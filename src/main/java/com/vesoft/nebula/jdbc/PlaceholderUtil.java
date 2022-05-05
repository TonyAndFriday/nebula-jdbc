package com.vesoft.nebula.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;

/**
 * sql 参数替换
 *
 * @author captain
 */
public class PlaceholderUtil {

    private static final Logger LOG = LoggerFactory.getLogger(PlaceholderUtil.class);

    private static final String WARNING_VALUE = "null";

    private PlaceholderUtil() {
    }

    /**
     * 替换参数
     *
     * @param raw
     * @param parameters
     * @return
     * @throws SQLException
     */
    public static String replacePlaceholders(String raw, Map<Integer, Object> parameters) throws SQLException {
        StringBuilder digested = new StringBuilder();
        char mark = 0;
        boolean isStr = false;
        int paramIndex = 1;
        for (int i = 0; i < raw.length(); i++) {
            char c = raw.charAt(i);
            // 忽略引号内的内容(这里需要判断单引号和双引号)
            if (isStr && c == mark) {
                isStr = false;
                digested.append(c);
                continue;
            }
            if (c == '"' || c == '\'') {
                isStr = true;
                mark = c;
                digested.append(c);
                continue;
            }
            if (isStr) {
                digested.append(c);
                continue;
            }
            // 使用参数替换?
            if (c == '?') {
                // HashMap 在key不存在时，会直接返回null， 所以这里应该判断key是否存在，避免不必要的错误
                if (!parameters.containsKey(paramIndex)) {
                    throw new SQLException("参数索引不存在：" + paramIndex);
                }
                //convert to "null" if the value if null, otherwise invoke x.toString()
                digested.append(parameters.get(paramIndex++));
                continue;
            }
            digested.append(c);
        }
        // 参数数量与？数量不一致报错， 必须相等
        if (parameters.size() != (paramIndex - 1)) {
            throw new SQLException("nGql 参数数量异常，nGql : [ " + digested + " ], params: [ " + Arrays.toString(parameters.values().toArray()) + " ]");
        }
        return digested.toString();
    }

    /**
     * 语法校验，是否存在 == null 的语法
     *
     * @param nql
     * @throws SQLException
     * @deprecated 1.2版本适配nebula 3.0，官方已在2.5版本修复此bug
     */
    @Deprecated
    public static void grammarCheck(String nql) throws SQLException {
        boolean start = false;
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < nql.length(); i++) {
            if (nql.charAt(i) == '=') {
                if (nql.charAt(i + 1) == '=') {
                    start = true;
                    i++;
                    continue;
                }
            }
            if (start) {
                word.append(nql.charAt(i));
            }
            if (start && nql.charAt(i) == ' ') {
                if (word.toString().trim().length() <= 0) {
                    continue;
                }
                start = false;
                if (word.toString().trim().equalsIgnoreCase(WARNING_VALUE)) {
                    LOG.error("错误的sql语句：{}", nql);
                    throw new SQLException("sql 错误，不允许使用 == null 形式");
                } else {
                    word = new StringBuilder();
                }
            }
        }
    }

}
