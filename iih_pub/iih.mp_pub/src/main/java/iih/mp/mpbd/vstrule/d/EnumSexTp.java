package iih.mp.mpbd.vstrule.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumSexTp {

    @DmEnumDesc(name="通用",description="通用")
	public static final Integer GENERAL=0; //通用
    @DmEnumDesc(name="男",description="男")
	public static final Integer MALE=1; //男
    @DmEnumDesc(name="女",description="女")
	public static final Integer FEMALE=2; //女
}	
