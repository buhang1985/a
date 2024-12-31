package iih.pmp.pay.bill.bp;

import java.util.HashMap;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import iih.pmp.pay.bill.d.CheckBillParamDTO;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.d.OrdStatusEnum;
import iih.pmp.pay.ord.i.IOrdRService;
import iih.pmp.pay.trade.d.BillChekRst;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.trade.i.ITradeCudService;
import iih.pmp.pay.trade.i.ITradeRService;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.BillCheckAppUtils;
import iih.pmp.pay.util.PmpPayAppBaseUtils;


public class OrderCheckBP {
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	private final String _basesql="select a.id_ord,a.ord_status,a.check_rst,a.amount,b.id_trade,b.amount tamount,b.check_rst tcheck_rst,b.dt_req from pmp_trade b  left join pmp_ord a on a.id_ord=b.id_ord where b.sd_chl='"
			+ PmpPayConst.WXPAY_CHANNEL_CODE
			+ "' ";


	public void exec() throws BizException {
		String sql = _basesql+ " and b.trade_status in("
				+ TradeStatusEnum.PAY_SUCCESS;
		this.CheckOrder(sql,null,null);
	}

	public void exec_old(FDate begin, FDate end) throws BizException {

		String sql = _basesql+ " and b.trade_status="
				+ TradeStatusEnum.PAY_SUCCESS
				+ " and "
				+ BillCheckAppUtils.getTimeSpanSql(begin, end, TradeDO.DT_REQ);
		this.CheckOrder(sql,begin,end);

	}
	public void exec(FDate begin, FDate end) throws BizException {

		List<CheckBillParamDTO> rst=new GenerateCheckExceptionBP().getpaiddata(begin, end);
		this.CheckOrder3(begin,end,rst);

	}

	private void CheckOrder(String sql,FDate begin, FDate end) throws BizException {
		DAFacade da = new DAFacade();
		Object result = da.execQuery(sql, new MapListHandler());
		if (result != null) {
			List<HashMap<String, Object>> b = (List<HashMap<String, Object>>) result;
			//已核对
			StringBuilder sb = new StringBuilder();
			//核对失败
			StringBuilder sb2 = new StringBuilder();
			//需要更新
			StringBuilder sb3 = new StringBuilder();
			//单边账
			StringBuilder sb4 = new StringBuilder();
			for (int j = 0; j < b.size(); j++) {
				HashMap<String, Object> o = b.get(j);
				String id_trade=o.get("id_trade").toString(); 
					if (this.getstatusEnum(o.get("tcheck_rst")) == BillChekRst.CHECKED||this.getstatusEnum(o.get("tcheck_rst")) == BillChekRst.TRADE_ONESIDEBILL) {
						Double a1 = pmputils.getdouble(o.get("amount"));
						Double a2 = pmputils.getdouble(o.get("tamount"));
						if (a1 != null && a2 != null
								&& pmputils.isDoubleEq(a1, a2)) {
							String id_ord = o.get("id_ord").toString();
							int status=this.getstatusEnum(o.get("ord_status"));
							if(status==OrdStatusEnum.PAID){
							
							BillCheckAppUtils.AppendBuilder(sb, id_ord);
							}else{
								BillCheckAppUtils.AppendBuilder(sb3, id_ord);
							}
						}else{ 
							if(o.get("id_ord")!=null){
							String id_ord = o.get("id_ord").toString();
							BillCheckAppUtils.AppendBuilder(sb2, id_ord);
						}else{
							BillCheckAppUtils.AppendBuilder(sb4, id_trade);
						}
						}
					} else {
						//如果交易表与第三方后台对账未通过，则订单表的对账状态为失败
						if(o.get("id_ord")!=null){
							String id_ord = o.get("id_ord").toString();

							BillCheckAppUtils.AppendBuilder(sb2, id_ord);
						}

					}				
			}
			this.updateUncheck(begin,end);
			this.Setorderstatus(sb, BillChekRst.CHECKED);
			this.Setorderstatus(sb2, BillChekRst.CHECKFAIL);
			this.Setorderstatus(sb3, BillChekRst.UPDATE);
			this.Settradestatus(sb4, BillChekRst.TRADE_ONESIDEBILL);
		}

	}
	
	private void CheckOrder3(FDate begin, FDate end,List<CheckBillParamDTO> rst) throws BizException {

			//已核对
			StringBuilder sb = new StringBuilder();
			//核对失败
			StringBuilder sb2 = new StringBuilder();
			//需要更新
			StringBuilder sb3 = new StringBuilder();
			//单边账
			StringBuilder sb4 = new StringBuilder();
			for (int j = 0; j < rst.size(); j++) {
				CheckBillParamDTO p = rst.get(j);
				if(p.getId_trade()!=null){
					boolean istaequal = pmputils.isDoubleEq(p.getTotal_fee().toDouble(),
							p.getAmount().toDouble());

					if(p.getTcheck_rst()==BillChekRst.CHECKED){
					if (p.getId_ord() != null) {
						boolean isordequal = pmputils.isDoubleEq(
								p.getTotal_fee().toDouble(), p.getCamount().toDouble());
						if (!isordequal) {
							// 生成异常数据
							BillCheckAppUtils.AppendBuilder(sb2, p.getId_ord());
						} else if (p.getOrd_status() != OrdStatusEnum.PAID&&p.getTrade_status()!=TradeStatusEnum.TURN_REFUND) {
							// 生成异常数据
							BillCheckAppUtils.AppendBuilder(sb3, p.getId_ord());
						}else{
							BillCheckAppUtils.AppendBuilder(sb, p.getId_ord());
						}
					}
					}else{
						BillCheckAppUtils.AppendBuilder(sb2, p.getId_ord());
					}
				} 
			}

					

				
//			}
			this.updateUncheck(begin,end);
			this.Setorderstatus(sb, BillChekRst.CHECKED);
			this.Setorderstatus(sb2, BillChekRst.CHECKFAIL);
			this.Setorderstatus(sb3, BillChekRst.UPDATE);
			this.Settradestatus(sb4, BillChekRst.TRADE_ONESIDEBILL);
		

	}

	private int getstatusEnum(Object o) {
		if (o == null)
			return 0;
		return Integer.parseInt(o.toString());
	}

	private void Setorderstatus(StringBuilder sb, int status)
			throws BizException {
		if (sb.length() > 0) {
			IOrdRService _orderservice = ServiceFinder.find(IOrdRService.class);
			OrdDO[] items = _orderservice.find(
					OrdDO.ID_ORD + " in (" + sb.toString() + ")", "",
					FBoolean.FALSE);
			for (OrdDO ord : items) {
				ord.setCheck_rst(status);
				ord.setStatus(DOStatus.UPDATED);
			}
			new DAFacade().updateDOArray(items,
					new String[] { OrdDO.CHECK_RST });
			// _tradeservice.save(items);
		}
	}
	
	private void Settradestatus(StringBuilder sb,int status) throws BizException{
		if(sb.length()>0){
		ITradeCudService _tradeservice=ServiceFinder.find(ITradeCudService.class);
		 ITradeRService _traderservice=ServiceFinder.find(ITradeRService.class);
		 TradeDO[] items=_traderservice.find(TradeDO.ID_TRADE+" in ("+sb.toString()+")", "", FBoolean.FALSE);
		 for (TradeDO chlBillItemDO : items) {
			 chlBillItemDO.setCheck_rst(status);
			 chlBillItemDO.setStatus(DOStatus.UPDATED);
		}
		 new DAFacade().updateDOArray(items, new String[]{TradeDO.CHECK_RST});
//		 _tradeservice.save(items);
		}
	}
	/**
	 * 将订单的状态都置未核对
	 * @param begin
	 * @param end
	 * @throws BizException
	 */
	private void updateUncheck(FDate begin, FDate end) throws BizException{
		if(begin!=null&&end!=null){
		IOrdRService _orderservice = ServiceFinder.find(IOrdRService.class);
		OrdDO[] items = _orderservice.find(BillCheckAppUtils.getTimeSpanSql(begin, end, OrdDO.DT_ORD), "",
				FBoolean.FALSE);
		

			 for (OrdDO chlBillItemDO : items) {
				 chlBillItemDO.setCheck_rst(BillChekRst.UNCHECK);
				 chlBillItemDO.setStatus(DOStatus.UPDATED);
			}
			 new DAFacade().updateDOArray(items, new String[]{OrdDO.CHECK_RST});
		
	}
	}

}
