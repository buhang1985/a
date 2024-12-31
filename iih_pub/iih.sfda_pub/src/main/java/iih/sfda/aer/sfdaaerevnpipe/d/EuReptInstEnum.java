package iih.sfda.aer.sfdaaerevnpipe.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuReptInstEnum {

    @DmEnumDesc(name="是",description="是")
	public static final Integer YES=1; //是
    @DmEnumDesc(name="否",description="否")
	public static final Integer NO=2; //否
    @DmEnumDesc(name="不需要",description="不需要")
	public static final Integer NONEED=3; //不需要
}	
