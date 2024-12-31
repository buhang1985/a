package iih.mp.nr.dto.wardprint.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumOrTp {

    @DmEnumDesc(name="检查",description="检查")
	public static final Integer OBS=2; //检查
    @DmEnumDesc(name="检验",description="检验")
	public static final Integer LIS=3; //检验
}	
