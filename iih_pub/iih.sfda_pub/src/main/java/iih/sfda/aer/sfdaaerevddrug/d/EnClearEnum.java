package iih.sfda.aer.sfdaaerevddrug.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnClearEnum {

    @DmEnumDesc(name="是",description="是")
	public static final Integer YES=1; //是
    @DmEnumDesc(name="否",description="否")
	public static final Integer NOT=2; //否
    @DmEnumDesc(name="不明",description="不明")
	public static final Integer NOTCLEAR=3; //不明
}	
