package iih.sc.scbd.scprtcfg.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuNewborn {

    @DmEnumDesc(name="是",description="新生儿")
	public static final Integer NEW=1; //是
    @DmEnumDesc(name="否",description="不是新生儿")
	public static final Integer NONEW=2; //否
}	
