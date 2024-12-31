package iih.sfda.aer.sfdaaerev.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EuDiagtsEnum {

    @DmEnumDesc(name="无",description="无")
	public static final Integer NO=1; //无
    @DmEnumDesc(name="有",description="有")
	public static final Integer HAVE=2; //有
    @DmEnumDesc(name="不需要",description="不需要")
	public static final Integer NONEED=3; //不需要
}	
