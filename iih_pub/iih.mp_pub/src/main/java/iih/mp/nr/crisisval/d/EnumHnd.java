package iih.mp.nr.crisisval.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface EnumHnd {

    @DmEnumDesc(name="全部",description="全部")
	public static final Integer ALL=0; //全部
    @DmEnumDesc(name="未处理",description="未处理")
	public static final Integer UNHND=1; //未处理
    @DmEnumDesc(name="已处理",description="已处理")
	public static final Integer HNDED=2; //已处理
}	
