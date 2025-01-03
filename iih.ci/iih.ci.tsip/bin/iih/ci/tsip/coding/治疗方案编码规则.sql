--治疗方案编码规则
insert into SYS_BCR_ENT (ID_BCRENT, METAID, CODE, NAME, CODELENTH, CODESCOPE, CODESTYLE, ORGTYPE, DS, SV)
values ('0001Z8100000003L7GRT', 'C8CB9D00-B580-0001-B66B-23F0A1B041D0', 'code_citsor', '治疗方案编码', null, 'global', 'both', 'GLOBLE00000000000000', 0, '2020-03-12 08:50:24');

insert into sys_bcr_base (ID_BCRBASE, CODEMODE, CODESCOPE, FORMAT, ISAUTOFILL, ISDEFAULT, ISEDITABLE, CODE, ID_GROUP, RULECODE, RULENAME, ISFIXED, ISGETRANDOM, DS, SV, ID_BCRENT, ISSERIALCOVER, ISRANDOM)
values ('0001Z8100000003L7GRU', 'pre', 'a', 'yyyyMMdd', 'Y', 'N', 'N', 'code_citsor', 'GLOBLE00000000000000', 'citsor', '治疗方案', 'Y', 'N', 0, '2020-03-12 08:58:34', '0001Z8100000003L7GRT', null, null);

insert into sys_bcr_elem (ID_BCRELEM, ID_BCRBASE, ID_BCRENT, SEQNO, ELEMTYPE, ELEMLEN, ELEMVALUE, FLOWNOBYTYPE, DS, SV, ID_BCRMAP)
values ('0001Z8100000003L7GRV', '0001Z8100000003L7GRU', '0001Z8100000003L7GRT', 2, '3', 6, null, '0', 0, '2020-03-12 08:58:34', '~');

insert into sys_bcr_elem (ID_BCRELEM, ID_BCRBASE, ID_BCRENT, SEQNO, ELEMTYPE, ELEMLEN, ELEMVALUE, FLOWNOBYTYPE, DS, SV, ID_BCRMAP)
values ('0001Z8100000003L7GRW', '0001Z8100000003L7GRU', '0001Z8100000003L7GRT', 0, '0', 3, 'IIH', '0', 0, '2020-03-12 08:58:34', '~');

insert into sys_bcr_elem (ID_BCRELEM, ID_BCRBASE, ID_BCRENT, SEQNO, ELEMTYPE, ELEMLEN, ELEMVALUE, FLOWNOBYTYPE, DS, SV, ID_BCRMAP)
values ('0001Z8100000003L7GRX', '0001Z8100000003L7GRU', '0001Z8100000003L7GRT', 1, '2', 8, '2020-03-12 08:57:44', '3', 0, '2020-03-12 08:58:34', '~');


