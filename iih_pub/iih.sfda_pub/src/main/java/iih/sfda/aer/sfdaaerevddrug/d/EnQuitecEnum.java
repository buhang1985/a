package iih.sfda.aer.sfdaaerevddrug.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnQuitecEnum {

    @DmEnumDesc(name="有",description="有")
	public static final Integer HAVE=1; //有
    @DmEnumDesc(name="无",description="无")
	public static final Integer NOTHAVE=2; //无
    @DmEnumDesc(name="不详",description="不详")
	public static final Integer NOTQUITECLEAR=3; //不详
}	
