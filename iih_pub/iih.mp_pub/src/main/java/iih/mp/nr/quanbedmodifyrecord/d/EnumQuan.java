package iih.mp.nr.quanbedmodifyrecord.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumQuan {

    @DmEnumDesc(name="手动修改",description="")
	public static final Integer MANUAL_OPR=1; //手动修改
    @DmEnumDesc(name="自动扣除",description="")
	public static final Integer AUTO=2; //自动扣除
}	
