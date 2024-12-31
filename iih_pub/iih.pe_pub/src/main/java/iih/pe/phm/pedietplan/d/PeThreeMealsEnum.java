package iih.pe.phm.pedietplan.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface PeThreeMealsEnum {

    @DmEnumDesc(name="早餐",description="早餐")
	public static final Integer PEBREAKFIRST=1; //早餐
    @DmEnumDesc(name="午餐",description="午餐")
	public static final Integer PELUNCH=2; //午餐
    @DmEnumDesc(name="晚餐",description="晚餐")
	public static final Integer PEDINNER=3; //晚餐
}	
