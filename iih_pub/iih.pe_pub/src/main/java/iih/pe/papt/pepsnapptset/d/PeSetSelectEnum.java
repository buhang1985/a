package iih.pe.papt.pepsnapptset.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeSetSelectEnum {

    @DmEnumDesc(name="套餐",description="套餐")
	public static final Integer PESET=0; //套餐
    @DmEnumDesc(name="-",description="-")
	public static final Integer PEREMOVE=1; //-
    @DmEnumDesc(name="+",description="+")
	public static final Integer PEADD=2; //+
}	
