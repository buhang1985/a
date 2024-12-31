package iih.bl.cg.blcghist.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface BlCgIpEuAct {

    @DmEnumDesc(name="自费到医保(保外到保内)",description="")
	public static final Integer SELFTOHP=1; //自费到医保(保外到保内)
    @DmEnumDesc(name="医保到自费(保内到保外)",description="")
	public static final Integer HPTOSELF=2; //医保到自费(保内到保外)
}	
