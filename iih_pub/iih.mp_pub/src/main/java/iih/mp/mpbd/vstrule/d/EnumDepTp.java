package iih.mp.mpbd.vstrule.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumDepTp {

    @DmEnumDesc(name="全院",description="全院")
	public static final Integer HOSPITAL=0; //全院
    @DmEnumDesc(name="科室",description="科室")
	public static final Integer DEPT=1; //科室
}	
