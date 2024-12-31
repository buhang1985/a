package iih.mp.dg.ipdgapp.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface ChargeStatusEnum {

    @DmEnumDesc(name="未记账",description="未记账")
	public static final Integer UNCHARGE=0; //未记账
    @DmEnumDesc(name="已记帐",description="已记帐")
	public static final Integer CHARGED=1; //已记帐
    @DmEnumDesc(name="已结算",description="已结算")
	public static final Integer SETTLEMENT=2; //已结算
    @DmEnumDesc(name="已付款",description="已付款")
	public static final Integer PAYED=3; //已付款
}	
