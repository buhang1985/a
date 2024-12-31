package iih.sfda.aer.sfdaaerevdsq.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface FgMnurOnEnum {

    @DmEnumDesc(name="有",description="有")
	public static final Integer HAVE=1; //有
    @DmEnumDesc(name="无",description="无")
	public static final Integer NOT=2; //无
}	
