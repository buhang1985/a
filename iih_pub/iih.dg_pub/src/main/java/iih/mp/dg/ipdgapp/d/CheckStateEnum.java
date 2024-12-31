package iih.mp.dg.ipdgapp.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface CheckStateEnum {

    @DmEnumDesc(name="未审核",description="")
	public static final Integer UNCHECKED=0; //未审核
    @DmEnumDesc(name="已审核",description="")
	public static final Integer CHECKED=1; //已审核
}	
