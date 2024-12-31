package iih.ci.ord.cfg.cirulecfg.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface RuleType {

    @DmEnumDesc(name="检验合单规则",description="检验合单规则（业务规则）")
    public static final String MERGE_LIS="A1"; //检验合单规则
    @DmEnumDesc(name="药品分方规则",description="分方规则（业务规则）")
    public static final String MERGE_PRES="A2"; //药品分方规则
    @DmEnumDesc(name="草药分方规则",description="草药分方规则（业务规则）")
    public static final String MERGE_HERBS_PRES="A21"; //草药分方规则
    @DmEnumDesc(name="检查合单规则",description="检查合单规则（业务规则）")
    public static final String MERGE_RIS="A3"; //检查合单规则
    @DmEnumDesc(name="超天数开单校验",description="超天数开单校验（校验规则）")
    public static final String VALIDATOR_EXCESSIVE="A6"; //超天数开单校验
}	
