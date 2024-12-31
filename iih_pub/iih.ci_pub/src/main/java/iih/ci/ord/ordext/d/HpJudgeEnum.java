package iih.ci.ord.ordext.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface HpJudgeEnum {

    @DmEnumDesc(name="系统判定",description="系统判断，不允许医生干预")
    public static final String SYSTEM_JUDGE="0"; //系统判定
    @DmEnumDesc(name="待判断",description="需要进行医保适应症判断")
    public static final String WAITING_JUDGE="1"; //待判断
    @DmEnumDesc(name="医生判定",description="医生已对待判定适应症进行确认")
    public static final String DOCTOR_JUDGE="2"; //医生判定
    @DmEnumDesc(name="非医保就诊",description="系统判断：本次就诊为非医保就诊")
    public static final String NON_MEDICAL="3"; //非医保就诊
    @DmEnumDesc(name="非费用项目",description="非费用项目，不需要医保判断")
    public static final String NON_BLITEM="4"; //非费用项目
    @DmEnumDesc(name="不判断",description="不需要医保判断，比如科研、自备、嘱托类医嘱")
    public static final String NOT_JUDGE="5"; //不判断
    @DmEnumDesc(name="未启用医保判断",description="未启用医保判断")
    public static final String DISABLED="6"; //未启用医保判断
}	
