package iih.pe.pwf.pewfoval.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeNeedStEnum {

    @DmEnumDesc(name="-",description="-")
	public static final Integer PENONE=1; //-
    @DmEnumDesc(name="√",description="√")
	public static final Integer PEOK=2; //√
    @DmEnumDesc(name="x",description="x")
	public static final Integer PENO=3; //x
}	
