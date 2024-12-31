package iih.mp.dg.opdginfu.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface InfuTypes {

    @DmEnumDesc(name="输液",description="输液")
	public static final Integer TYPE_DRUG=0; //输液
    @DmEnumDesc(name="输血",description="输血")
	public static final Integer TYPE_BLOOD=1; //输血
}	
