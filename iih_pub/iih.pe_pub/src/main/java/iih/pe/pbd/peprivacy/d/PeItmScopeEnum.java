package iih.pe.pbd.peprivacy.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeItmScopeEnum {

    @DmEnumDesc(name="不限",description="不限")
	public static final Integer PENOLIMIT=0; //不限
    @DmEnumDesc(name="个人",description="个人")
	public static final Integer PEPSNONLY=1; //个人
    @DmEnumDesc(name="团体",description="团体")
	public static final Integer PECORPONLY=2; //团体
}	
