package iih.mp.mb.mbbc.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EleTypeEnum {

    @DmEnumDesc(name="常量",description="")
	public static final Integer CONST=1; //常量
    @DmEnumDesc(name="业务值",description="")
	public static final Integer BIZVAL=2; //业务值
}	
