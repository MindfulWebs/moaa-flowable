CREATE TABLE ACT_DMN_HI_DECISION_EXECUTION (ID_ VARCHAR2(255) NOT NULL, DECISION_DEFINITION_ID_ VARCHAR2(255), DEPLOYMENT_ID_ VARCHAR2(255), START_TIME_ TIMESTAMP, END_TIME_ TIMESTAMP, INSTANCE_ID_ VARCHAR2(255), EXECUTION_ID_ VARCHAR2(255), ACTIVITY_ID_ VARCHAR2(255), FAILED_ NUMBER(1) DEFAULT 0, TENANT_ID_ VARCHAR2(255), EXECUTION_JSON_ CLOB, CONSTRAINT PK_ACT_DMN_HI_DECISION_EXECUTI PRIMARY KEY (ID_));
