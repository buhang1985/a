package iih.mp.dg.ipshetp.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface DrugCycleEnum {

    @DmEnumDesc(name="当天",description="")
	public static final Integer TODAY=0; //当天
    @DmEnumDesc(name="明天",description="")
	public static final Integer TOMORROW=1; //明天
}	
