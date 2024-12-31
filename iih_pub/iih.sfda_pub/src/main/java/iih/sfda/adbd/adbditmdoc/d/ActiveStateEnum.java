package iih.sfda.adbd.adbditmdoc.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface ActiveStateEnum {

    @DmEnumDesc(name="新建",description="")
	public static final Integer CREATE=1; //新建
    @DmEnumDesc(name="启用",description="")
	public static final Integer ENABLE=2; //启用
    @DmEnumDesc(name="停用",description="")
	public static final Integer DISABLE=3; //停用
}	
