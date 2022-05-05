package com.vesoft.nebula.jdbc;

import java.sql.*;

/**
 * @author captain
 */

public interface BaseDatabaseMetaData extends DatabaseMetaData, BaseWrapper {

    @Override
    default boolean allProceduresAreCallable() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean allTablesAreSelectable() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean isReadOnly() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean nullsAreSortedHigh() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean nullsAreSortedLow() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean nullsAreSortedAtStart() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean nullsAreSortedAtEnd() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean usesLocalFiles() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean usesLocalFilePerTable() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsMixedCaseIdentifiers() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean storesUpperCaseIdentifiers() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean storesLowerCaseIdentifiers() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean storesMixedCaseIdentifiers() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsMixedCaseQuotedIdentifiers() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean storesUpperCaseQuotedIdentifiers() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean storesLowerCaseQuotedIdentifiers() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean storesMixedCaseQuotedIdentifiers() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default String getIdentifierQuoteString() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default String getNumericFunctions() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default String getStringFunctions() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default String getSystemFunctions() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default String getTimeDateFunctions() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default String getSearchStringEscape() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default String getExtraNameCharacters() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsAlterTableWithAddColumn() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsAlterTableWithDropColumn() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsColumnAliasing() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean nullPlusNonNullIsNull() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsConvert() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsConvert(int fromType, int toType) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsTableCorrelationNames() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsDifferentTableCorrelationNames() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsExpressionsInOrderBy() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsOrderByUnrelated() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsGroupBy() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsGroupByUnrelated() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsGroupByBeyondSelect() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsLikeEscapeClause() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsMultipleResultSets() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsMultipleTransactions() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsNonNullableColumns() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsMinimumSQLGrammar() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsCoreSQLGrammar() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsExtendedSQLGrammar() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsANSI92EntryLevelSQL() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsANSI92IntermediateSQL() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsANSI92FullSQL() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsIntegrityEnhancementFacility() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsOuterJoins() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsFullOuterJoins() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsLimitedOuterJoins() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default String getSchemaTerm() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default String getProcedureTerm() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default String getCatalogTerm() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean isCatalogAtStart() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default String getCatalogSeparator() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsSchemasInDataManipulation() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsSchemasInProcedureCalls() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsSchemasInTableDefinitions() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsSchemasInIndexDefinitions() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsSchemasInPrivilegeDefinitions() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsCatalogsInDataManipulation() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsCatalogsInProcedureCalls() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsCatalogsInTableDefinitions() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsCatalogsInIndexDefinitions() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsPositionedDelete() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsPositionedUpdate() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsSelectForUpdate() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsStoredProcedures() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsSubqueriesInComparisons() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsSubqueriesInExists() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsSubqueriesInIns() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsSubqueriesInQuantifieds() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsCorrelatedSubqueries() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsUnion() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsUnionAll() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsOpenCursorsAcrossCommit() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsOpenCursorsAcrossRollback() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsOpenStatementsAcrossCommit() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsOpenStatementsAcrossRollback() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getMaxBinaryLiteralLength() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getMaxCharLiteralLength() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getMaxColumnNameLength() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getMaxColumnsInGroupBy() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getMaxColumnsInIndex() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getMaxColumnsInOrderBy() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getMaxColumnsInSelect() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getMaxColumnsInTable() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getMaxConnections() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getMaxCursorNameLength() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getMaxIndexLength() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getMaxSchemaNameLength() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getMaxProcedureNameLength() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getMaxCatalogNameLength() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getMaxRowSize() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean doesMaxRowSizeIncludeBlobs() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getMaxStatementLength() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getMaxStatements() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getMaxTableNameLength() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getMaxTablesInSelect() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getMaxUserNameLength() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getDefaultTransactionIsolation() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsTransactions() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsTransactionIsolationLevel(int level) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsDataDefinitionAndDataManipulationTransactions() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsDataManipulationTransactionsOnly() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean dataDefinitionCausesTransactionCommit() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean dataDefinitionIgnoredInTransactions() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default ResultSet getProcedures(String catalog, String schemaPattern, String procedureNamePattern) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default ResultSet getProcedureColumns(String catalog, String schemaPattern, String procedureNamePattern, String columnNamePattern) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default ResultSet getColumnPrivileges(String catalog, String schema, String table, String columnNamePattern) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default ResultSet getTablePrivileges(String catalog, String schemaPattern, String tableNamePattern) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default ResultSet getBestRowIdentifier(String catalog, String schema, String table, int scope, boolean nullable) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default ResultSet getVersionColumns(String catalog, String schema, String table) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default ResultSet getPrimaryKeys(String catalog, String schema, String table) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default ResultSet getImportedKeys(String catalog, String schema, String table) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default ResultSet getExportedKeys(String catalog, String schema, String table) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default ResultSet getCrossReference(String parentCatalog, String parentSchema, String parentTable, String foreignCatalog, String foreignSchema, String foreignTable) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsResultSetType(int type) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsResultSetConcurrency(int type, int concurrency) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean ownUpdatesAreVisible(int type) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean ownDeletesAreVisible(int type) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean ownInsertsAreVisible(int type) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean othersUpdatesAreVisible(int type) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean othersDeletesAreVisible(int type) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean othersInsertsAreVisible(int type) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean updatesAreDetected(int type) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean deletesAreDetected(int type) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean insertsAreDetected(int type) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsBatchUpdates() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default ResultSet getUDTs(String catalog, String schemaPattern, String typeNamePattern, int[] types) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsSavepoints() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsNamedParameters() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsMultipleOpenResults() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsGetGeneratedKeys() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default ResultSet getSuperTypes(String catalog, String schemaPattern, String typeNamePattern) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default ResultSet getSuperTables(String catalog, String schemaPattern, String tableNamePattern) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default ResultSet getAttributes(String catalog, String schemaPattern, String typeNamePattern, String attributeNamePattern) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsResultSetHoldability(int holdability) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getResultSetHoldability() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getSQLStateType() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean locatorsUpdateCopy() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsStatementPooling() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default RowIdLifetime getRowIdLifetime() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean supportsStoredFunctionsUsingCallSyntax() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean autoCommitFailureClosesAllResultSets() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default ResultSet getFunctions(String catalog, String schemaPattern, String functionNamePattern) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default ResultSet getFunctionColumns(String catalog, String schemaPattern, String functionNamePattern, String columnNamePattern) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default ResultSet getPseudoColumns(String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default boolean generatedKeyAlwaysReturned() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default ResultSet getTypeInfo() throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default ResultSet getIndexInfo(String catalog, String schema, String table, boolean unique, boolean approximate) throws SQLException {
        throw ExceptionUtil.unsupportedFeatureException();
    }

    @Override
    default int getJDBCMajorVersion() throws SQLException {
        return 4;
    }

    @Override
    default int getJDBCMinorVersion() throws SQLException {
        return 0;
    }

}
