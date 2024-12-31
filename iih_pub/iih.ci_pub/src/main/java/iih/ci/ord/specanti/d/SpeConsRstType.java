package iih.ci.ord.specanti.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface SpeConsRstType {

    @DmEnumDesc(name="特殊级抗菌药会诊结果_同意",description="特殊级抗菌药会诊结果_同意")
    public static final String SPECONSD_AGREE="0"; //特殊级抗菌药会诊结果_同意
    @DmEnumDesc(name="特殊级抗菌药会诊结果_不同意",description="特殊级抗菌药会诊结果_不同意")
    public static final String SPECONS_REJECT="1"; //特殊级抗菌药会诊结果_不同意
}	
