package iih.en.pv.outpatient.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuRegTp {

    @DmEnumDesc(name="普通挂号",description="普通挂号")
    public static final String COMMON="0"; //普通挂号
    @DmEnumDesc(name="分诊台挂号",description="分诊台挂号")
    public static final String TRIAGE="1"; //分诊台挂号
    @DmEnumDesc(name="先诊疗后付费方式挂号",description="先诊疗后付费方式挂号")
    public static final String PAYAFTERDI="2"; //先诊疗后付费方式挂号
    @DmEnumDesc(name="医生诊间挂号",description="医生诊间挂号")
    public static final String CONSULTINGROOM="3"; //医生诊间挂号
    @DmEnumDesc(name="免挂号费非排班挂号",description="免挂号费非排班挂号")
    public static final String FREENOSCH="4"; //免挂号费非排班挂号
    @DmEnumDesc(name="未挂号分诊",description="未挂号分诊")
    public static final String NOREGTRIAGE="5"; //未挂号分诊
    @DmEnumDesc(name="应急系统",description="应急系统")
    public static final String EMGSYSTEM="8"; //应急系统
    @DmEnumDesc(name="预约",description="预约")
    public static final String APT="9"; //预约
}	
