package iih.sfda.aer.sfdaaerevdsq.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface FgAtDsqEunm {

    @DmEnumDesc(name="是",description="是")
	public static final Integer YES=1; //是
    @DmEnumDesc(name="否",description="否")
	public static final Integer NOT=2; //否
}	