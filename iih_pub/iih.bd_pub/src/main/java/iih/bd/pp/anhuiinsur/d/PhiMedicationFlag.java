package iih.bd.pp.anhuiinsur.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PhiMedicationFlag {

    @DmEnumDesc(name="其它基层医疗机构用药",description="其它基层医疗机构用药")
    public static final String OTHERPHIMEDICATION="0"; //其它基层医疗机构用药
    @DmEnumDesc(name="基层医疗机构用药",description="基层医疗机构用药")
    public static final String PHIMEDICATION="1"; //基层医疗机构用药
}	
