/*
 * Copyright (c) 2016 LARUS Business Automation [http://www.larus-ba.it]
 * <p>
 * This file is part of the "LARUS Integration Framework for Neo4j".
 * <p>
 * The "LARUS Integration Framework for Neo4j" is licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p>
 * Created on 15/4/2016
 */
package com.vesoft.nebula.jdbc;

import java.sql.SQLFeatureNotSupportedException;

/**
 * @author captain
 */
public class ExceptionUtil {

    private static final int INDEX = 2;

    private ExceptionUtil() {
    }

    /**
     * build an {@code Exception} to mark a not yet implemented exception with method and class name.
     *
     * @return an UnsupportedOperationException
     */
    public static SQLFeatureNotSupportedException unsupportedFeatureException() {
        StackTraceElement[] stackTraceElements = new Exception().getStackTrace();
        if (stackTraceElements.length > INDEX) {
            StackTraceElement caller = stackTraceElements[INDEX];

            StringBuilder sb = new StringBuilder().append("Method ").append(caller.getMethodName()).append(" in class ").append(caller.getClassName())
                    .append(" is not yet implemented.");

            return new SQLFeatureNotSupportedException(sb.toString());
        } else {
            return new SQLFeatureNotSupportedException("Not yet implemented.");
        }
    }
}
