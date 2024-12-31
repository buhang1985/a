package iih.bd.mhi.hpopepermapply.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface chargelv {

    @DmEnumDesc(name="县级以下",description="县级以下")
	public static final Integer BLCOUNTY=0; //县级以下
    @DmEnumDesc(name="县级",description="县级")
	public static final Integer COUNTY=1; //县级
    @DmEnumDesc(name="市级",description="市级")
	public static final Integer CITY=2; //市级
    @DmEnumDesc(name="省级",description="省级")
	public static final Integer PROVINCIAL=3; //省级
}	
