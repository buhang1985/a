package iih.en.pv.inpatient.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeStatusEnum {

    @DmEnumDesc(name="在院",description="在院")
    public static final String STATUS_PE_INHOS="01"; //在院
    @DmEnumDesc(name="出院",description="出院")
    public static final String STATUS_PE_OUTHOS="08"; //出院
}	
