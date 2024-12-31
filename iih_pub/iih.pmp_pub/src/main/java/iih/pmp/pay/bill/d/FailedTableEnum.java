package iih.pmp.pay.bill.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface FailedTableEnum {

    @DmEnumDesc(name="订单表",description="")
    public static final String ORDER="pmp_ord"; //订单表
    @DmEnumDesc(name="交易表",description="")
    public static final String TRADE="pmp_trade"; //交易表
    @DmEnumDesc(name="渠道表",description="")
    public static final String CHLBILLITEM="pmp_chlbillitem"; //渠道表
}	
