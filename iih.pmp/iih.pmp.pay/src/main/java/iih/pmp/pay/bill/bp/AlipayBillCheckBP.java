package iih.pmp.pay.bill.bp;

import java.util.HashMap;
import java.util.List;

import iih.pmp.pay.channelbill.d.ChannelBillDO;
import iih.pmp.pay.channelbill.i.IChannelbillRService;
import iih.pmp.pay.channelbillitem.d.ChlBillItemDO;
import iih.pmp.pay.channelbillitem.i.IChannelbillitemRService;
import iih.pmp.pay.trade.d.BillChekRst;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.trade.i.ITradeRService;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

public class AlipayBillCheckBP {
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	public void exec() throws BizException {
		IChannelbillRService _rservice = ServiceFinder.find(IChannelbillRService.class);
		ChannelBillDO[] chls = _rservice.find(" id_chl='" + PmpPayConst.getUdiID(PmpPayConst.ALIPAY_CHANNEL_CODE, PmpPayConst.CHANNEL_DOCLIST_ID) + "'", "", FBoolean.FALSE);
		checkTrade(chls);
	}
	
	@SuppressWarnings("unchecked")
	private void checkTrade(ChannelBillDO[] chls) throws BizException {		
		DAFacade da = new DAFacade();		
		for (int i = 0; i < chls.length; i++) {		
			ChannelBillDO bill = chls[i];
			StringBuilder sb = new StringBuilder();
			StringBuilder sb2 = new StringBuilder();
			StringBuilder sb3 = new StringBuilder();
			StringBuilder sb4 = new StringBuilder();
			StringBuilder sb5 = new StringBuilder();
			String sql = "select a.Id_channel_bill_item,a.mch_trade_no,a.total_fee,b.id_trade,b.amount,b.trade_status from pmp_chlbillitem a left join pmp_trade b on a.mch_trade_no=b.trade_no where " + ChlBillItemDO.ID_CHANNEL_BILL + "='" + bill.getId_channel_bill() + "'";
			Object result = da.execQuery(sql, new MapListHandler());
			if (result != null) {
				List<HashMap<String, Object>> b = (List<HashMap<String, Object>>) result;
				for (int j = 0; j < b.size(); j++) {
					HashMap<String, Object> o = b.get(j);
					double total_fee = getdouble(o.get("total_fee"));
					if (o.get("amount") == null) {
						if (sb.length() == 0) {
							sb.append("'" + getString(o.get("id_channel_bill_item")) + "'");
						}
						else {
							sb.append(",'" + getString(o.get("id_channel_bill_item")) + "'");
						}
					}
					else {
						double amount = getdouble(o.get("amount"));
						boolean isequal = pmputils.isDoubleEq(total_fee, amount);
						if (!isequal) {
							if (sb2.length() == 0) {
								sb2.append("'" + getString(o.get("id_trade")) + "'");
							}
							else {
								sb2.append(",'" + getString(o.get("id_trade")) + "'");
							}
						}
						else {							
							int ts = Integer.parseInt(o.get("trade_status").toString());
							if(ts == TradeStatusEnum.PAY_SUCCESS || ts == TradeStatusEnum.REFUND_SUCCESS) {
								if (sb3.length() == 0) {
									sb3.append("'" + getString(o.get("id_trade")) + "'");
								}
								else {
									sb3.append(",'" + getString(o.get("id_trade")) + "'");
								}							
		                        if (sb4.length() == 0) {	                        	
		                        	 sb4.append("'" + getString(o.get("id_channel_bill_item")) + "'");
								}
		                        else {
									sb4.append(",'" + getString(o.get("id_channel_bill_item")) + "'");
								}
							}
							else {								
								if(sb5.length() == 0) {
									sb5.append("'" + getString(o.get("id_trade")) + "'");
								}
								else {
									sb5.append(",'" + getString(o.get("id_trade")) + "'");
								}
							}							
						}					
					}
				
				}
				this.Setbillstatus(sb, BillChekRst.CHL_ONESIDEBILL);
				this.Settradestatus(sb2, BillChekRst.CHECKFAIL);
				this.Settradestatus(sb3, BillChekRst.CHECKED);
				this.Setbillstatus(sb4, BillChekRst.CHECKED);
				this.Settradestatus(sb5, BillChekRst.UPDATE);		 
			}			
		}
	}
	
	private void Setbillstatus(StringBuilder sb,int status) throws BizException {
		if (sb.length() > 0) {
			IChannelbillitemRService _itemrservice = ServiceFinder.find(IChannelbillitemRService.class);
			ChlBillItemDO[] items = _itemrservice.find(ChlBillItemDO.ID_CHANNEL_BILL_ITEM + " in (" + sb.toString() + ")", "", FBoolean.FALSE);
			for (ChlBillItemDO chlBillItemDO : items) {
				chlBillItemDO.setCheck_rst(status);
				chlBillItemDO.setStatus(DOStatus.UPDATED);
			}
			new DAFacade().updateDOArray(items, new String[]{ChlBillItemDO.CHECK_RST});
		}
	}
	
	private void Settradestatus(StringBuilder sb,int status) throws BizException {
		if (sb.length() > 0) {
			ITradeRService _traderservice = ServiceFinder.find(ITradeRService.class);
			TradeDO[] items = _traderservice.find(TradeDO.ID_TRADE + " in (" + sb.toString() + ")", "", FBoolean.FALSE);
			for (TradeDO chlBillItemDO : items) {
				chlBillItemDO.setCheck_rst(status);
				chlBillItemDO.setStatus(DOStatus.UPDATED);
			}
			new DAFacade().updateDOArray(items, new String[]{TradeDO.CHECK_RST});
		}
	}
	
	private double getdouble(Object o) {
		return Double.parseDouble(o.toString());
	}
	
	private String getString(Object o) {
		String val = null;
		try {
			val = o.toString();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return val;		
	}

}
