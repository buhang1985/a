package iih.bd.mhi.hpopepermapply.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface srvorgtype {

    @DmEnumDesc(name="医疗机构",description="医疗机构")
	public static final Integer SRVORG=1; //医疗机构
    @DmEnumDesc(name="药店",description="药店")
	public static final Integer PHARMACY=2; //药店
}	
