ALTER TABLE ACT_CMMN_CASEDEF ADD DGRM_RESOURCE_NAME_ varchar(4000);

ALTER TABLE ACT_CMMN_CASEDEF ADD HAS_START_FORM_KEY_ bit;

ALTER TABLE ACT_CMMN_DEPLOYMENT_RESOURCE ADD GENERATED_ bit;

ALTER TABLE ACT_CMMN_RU_CASE_INST ADD LOCK_TIME_ datetime;

ALTER TABLE ACT_CMMN_RU_PLAN_ITEM_INST ADD ITEM_DEFINITION_ID_ varchar(255);

ALTER TABLE ACT_CMMN_RU_PLAN_ITEM_INST ADD ITEM_DEFINITION_TYPE_ varchar(255);
