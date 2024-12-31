package iih.mp.mpbd.patvstagt.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumTagt {

    @DmEnumDesc(name="体征类",description="体征类")
	public static final Integer VS=0; //体征类
    @DmEnumDesc(name="患者状态类",description="患者状态类")
	public static final Integer ENSTATE=1; //患者状态类
    @DmEnumDesc(name="医嘱类",description="医嘱类")
	public static final Integer ORDER=2; //医嘱类
}	
