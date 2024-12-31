package iih.nm.nqm.qctplmaintenance.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface OwTpEnum {

    @DmEnumDesc(name="全院",description="全院")
	public static final Integer WHOLEHOSPITAL=0; //全院
    @DmEnumDesc(name="科室",description="科室")
	public static final Integer DEPARTMENT=1; //科室
    @DmEnumDesc(name="个人",description="个人")
	public static final Integer PERSONAGE=2; //个人
}	
