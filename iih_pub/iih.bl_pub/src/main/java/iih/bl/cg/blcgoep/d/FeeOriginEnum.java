package iih.bl.cg.blcgoep.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface FeeOriginEnum {

    @DmEnumDesc(name="医嘱产生",description="orders_fee")
	public static final Integer ORDERS_FEE=0; //医嘱产生
    @DmEnumDesc(name="就诊产生",description="encounter_fee")
	public static final Integer ENCOUNTER_FEE=1; //就诊产生
    @DmEnumDesc(name="建档费",description="patregister_fee")
	public static final Integer PATREGISTER_FEE=2; //建档费
    @DmEnumDesc(name="第三方体检费",description="thirdpe_fee")
	public static final Integer THIRDPE_FEE=3; //第三方体检费
    @DmEnumDesc(name="费用产生",description="bl_fee")
	public static final Integer BL_FEE=4; //费用产生
}	
