package iih.mi.mc.mimcspec.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface MiMcDrugControlEnum {

    @DmEnumDesc(name="按开单天数控制",description="按开单天数控制")
	public static final Integer CONTROLDAYS=0; //按开单天数控制
    @DmEnumDesc(name="按月进行药品总量控制",description="按月进行药品总量控制")
	public static final Integer CONTROLMONTH=1; //按月进行药品总量控制
}	
