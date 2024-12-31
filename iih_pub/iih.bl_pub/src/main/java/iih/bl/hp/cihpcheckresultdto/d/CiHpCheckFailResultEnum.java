package iih.bl.hp.cihpcheckresultdto.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface CiHpCheckFailResultEnum {

    @DmEnumDesc(name="单方限制",description="未通过单方限制校验")
    public static final String SINGLEIDSRV="10"; //单方限制
    @DmEnumDesc(name="重复开药限制",description="重复开药")
    public static final String REPEAT_PRES_DRUG="20"; //重复开药限制
    @DmEnumDesc(name="超过单次执行医嘱领量限制",description="单次执行医嘱领量限制")
    public static final String GREATER_THAN_ONE_TIME="30"; //超过单次执行医嘱领量限制
    @DmEnumDesc(name="放射类医嘱限制",description="放射类医嘱限制")
    public static final String RADIATION_CLASS_ORDER="40"; //放射类医嘱限制
    @DmEnumDesc(name="超过门诊领量限制",description="超过门诊领量限制")
    public static final String GREATER_THAN_GET_OEP="50"; //超过门诊领量限制
    @DmEnumDesc(name="超过门诊持有量限制",description="超过门诊持有量限制")
    public static final String GREATER_THAN_OWN_OEP="60"; //超过门诊持有量限制
    @DmEnumDesc(name="超过急诊领量限制",description="超过急诊领量限制")
    public static final String GREATER_THAN_GET_ER="70"; //超过急诊领量限制
}	
