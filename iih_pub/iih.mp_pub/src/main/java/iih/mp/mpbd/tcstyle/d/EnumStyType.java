package iih.mp.mpbd.tcstyle.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumStyType {

    @DmEnumDesc(name="体温单",description="体温单")
	public static final Integer TEMPERATURECHART=0; //体温单
    @DmEnumDesc(name="产程图",description="产程图")
	public static final Integer PRATOGRAM=1; //产程图
}	
