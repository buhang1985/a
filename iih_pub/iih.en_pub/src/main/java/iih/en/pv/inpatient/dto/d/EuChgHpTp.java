package iih.en.pv.inpatient.dto.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuChgHpTp {

    @DmEnumDesc(name="自费转医保",description="自费转医保")
    public static final String SELFTOHPPAY="01"; //自费转医保
    @DmEnumDesc(name="医保转自费",description="医保转自费")
    public static final String HPTOSELFPAY="02"; //医保转自费
    @DmEnumDesc(name="医保转其他医保",description="医保转其他医保")
    public static final String HPTOOTHERHPPAY="03"; //医保转其他医保
}	
