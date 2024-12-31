package iih.pmp.pay.trade.d;

import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

public interface BillChekRst {

    @DmEnumDesc(name="未对账",description="未对账")
	public static final Integer UNCHECK=0; //未对账
    @DmEnumDesc(name="已对账",description="已对账")
	public static final Integer CHECKED=1; //已对账
    @DmEnumDesc(name="对账异常",description="对账失败")
	public static final Integer CHECKFAIL=2; //对账异常
    @DmEnumDesc(name="更新",description="更新数据")
	public static final Integer UPDATE=3; //更新
    @DmEnumDesc(name="渠道后台单边账",description="渠道后台单边账")
	public static final Integer CHL_ONESIDEBILL=4; //渠道后台单边账
    @DmEnumDesc(name="交易表单边账",description="交易表单边账")
	public static final Integer TRADE_ONESIDEBILL=5; //交易表单边账
}	
