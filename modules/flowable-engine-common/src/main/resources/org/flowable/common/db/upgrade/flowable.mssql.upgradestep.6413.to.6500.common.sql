update ACT_GE_PROPERTY set VALUE_ = '6.5.0.0' where NAME_ = 'common.schema.version';


alter table ACT_RU_EVENT_SUBSCR add SUB_SCOPE_ID_ nvarchar(64);
alter table ACT_RU_EVENT_SUBSCR add SCOPE_ID_ nvarchar(64);
alter table ACT_RU_EVENT_SUBSCR add SCOPE_DEFINITION_ID_ nvarchar(64);
alter table ACT_RU_EVENT_SUBSCR add SCOPE_TYPE_ nvarchar(64);

