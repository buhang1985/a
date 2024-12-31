package iih.mp.mpbd.mpskd.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumEq {

    @DmEnumDesc(name="pc",description="")
	public static final Integer PC=0; //pc
    @DmEnumDesc(name="Android",description="")
	public static final Integer ANDROID=1; //Android
    @DmEnumDesc(name="IOS",description="")
	public static final Integer IOS=2; //IOS
}	
