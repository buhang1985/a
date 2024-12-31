package iih.nm.nhr.nmnurlabor.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface LaborAdjEnum {

    @DmEnumDesc(name="请假",description="请假")
	public static final Integer VACATE=0; //请假
    @DmEnumDesc(name="替班",description="替班")
	public static final Integer RELAY=1; //替班
}	
