package iih.sfda.aer.sfdaaerevet.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface CommonEnum {

    @DmEnumDesc(name="是",description="是")
	public static final Integer YES=1; //是
    @DmEnumDesc(name="否",description="否")
	public static final Integer NO=2; //否
    @DmEnumDesc(name="不知道",description="不知道")
	public static final Integer UNKOWN=3; //不知道
}	
