package iih.pmp.pay.bill.bp;

import iih.pmp.pay.channelbill.d.ChannelBillDO;
import iih.pmp.pay.channelbill.i.IChannelbillRService;
import iih.pmp.pay.channelbillitem.d.ChlBillItemDO;
import iih.pmp.pay.channelbillitem.i.IChannelbillitemCudService;
import iih.pmp.pay.channelbillitem.i.IChannelbillitemRService;
import iih.pmp.pay.trade.d.BillChekRst;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.trade.i.ITradeCudService;
import iih.pmp.pay.trade.i.ITradeRService;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.BillCheckAppUtils;
import iih.pmp.pay.util.PmpPayAppBaseUtils;

import java.util.HashMap;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

public class CheckRefundBillBP {
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	public void exec() throws BizException{

		IChannelbillRService _rservice=ServiceFinder.find(IChannelbillRService.class);
		ChannelBillDO[] chls=_rservice.find(" sd_chl='"+PmpPayConst.WXPAY_CHANNEL_CODE+"' and bill_type='ALL'", "", FBoolean.FALSE);
		this.checkRefundTrade(chls);
	}
	
	public void exec(FDate begin,FDate end) throws BizException{

		IChannelbillRService _rservice=ServiceFinder.find(IChannelbillRService.class);
		ChannelBillDO[] chls=_rservice.find(" sd_chl='"+PmpPayConst.WXPAY_CHANNEL_CODE+"' and bill_type='ALL'"+" and "+BillCheckAppUtils.getTimeSpanSql(begin, end, ChannelBillDO.DT_BILL), "", FBoolean.FALSE);
		this.checkRefundTrade(chls);
	}
	
	
	private void checkRefundTrade(ChannelBillDO[] chls) throws BizException{
		for(int i=0;i<chls.length;i++){
			ChannelBillDO bill=chls[i];
			StringBuilder sb=new StringBuilder();
			StringBuilder sb2=new StringBuilder();
			StringBuilder sb3=new StringBuilder();
			StringBuilder sb4=new StringBuilder();
			StringBuilder sb5=new StringBuilder();
			String sql=" select a.Id_channel_bill_item,b.id_trade, a.mch_trade_no,a.refund_fee,b.amount,b.trade_status,a.check_rst,b.check_rst as tcheck_rst from pmp_chlbillitem a left join pmp_trade b on a.mch_refund_no=b.trade_no where "+"   a.trade_status='REFUND' and "+ChlBillItemDO.ID_CHANNEL_BILL+"='"+bill.getId_channel_bill()+"'";
			DAFacade da=new DAFacade();
			Object result=da.execQuery(sql,  new MapListHandler());
			if(result!=null){
			List<HashMap<String, Object>> b=(List<HashMap<String, Object>>)result;
			for(int j=0;j<b.size();j++){
				HashMap<String,Object>o=b.get(j);
				double total_fee=this.getdouble(o.get("refund_fee"));
				if(o.get("amount")==null){
//					sb.put(getString(o.get("Id_channel_bill_item")), BillChekRst.CHL_ONESIDEBILL);
					if(sb.length()==0){
						sb.append("'"+getString(o.get("id_channel_bill_item"))+"'");
					}else{
						sb.append(",'"+getString(o.get("id_channel_bill_item"))+"'");
					}
				}else{
					double amount=this.getdouble(o.get("amount"));
					boolean isequal=pmputils.isDoubleEq(total_fee, amount);
					if(!isequal){
//						sb2.put(getString(o.get("id_trade")), BillChekRst.CHECKFAIL);
						if(sb2.length()==0){
							sb2.append("'"+getString(o.get("id_trade"))+"'");
						}else{
							sb2.append(",'"+getString(o.get("id_trade"))+"'");
						}
					}else{
						
						if(o.get("id_channel_bill_item")==null){
							int k=1;
						}
						int ts=Integer.parseInt(o.get("trade_status").toString());
						if(ts==TradeStatusEnum.REFUND_SUCCESS){
						if(sb3.length()==0){
							sb3.append("'"+getString(o.get("id_trade"))+"'");
						}else{
							sb3.append(",'"+getString(o.get("id_trade"))+"'");
						}
						
                         if(sb4.length()==0){
                        	
                        	 sb4.append("'"+getString(o.get("id_channel_bill_item"))+"'");
						}else{
							sb4.append(",'"+getString(o.get("id_channel_bill_item"))+"'");
						}
						}else{
							
							if(sb5.length()==0){
								sb5.append("'"+getString(o.get("id_trade"))+"'");
							}else{
								sb5.append(",'"+getString(o.get("id_trade"))+"'");
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
	
	private void Setbillstatus(StringBuilder sb,int status) throws BizException{
		if(sb.length()>0){
		IChannelbillitemCudService _itemservice=ServiceFinder.find(IChannelbillitemCudService.class);
		 IChannelbillitemRService _itemrservice=ServiceFinder.find(IChannelbillitemRService.class);
		 ChlBillItemDO[] items=_itemrservice.find(ChlBillItemDO.ID_CHANNEL_BILL_ITEM+" in ("+sb.toString()+")", "", FBoolean.FALSE);
		 for (ChlBillItemDO chlBillItemDO : items) {
			 chlBillItemDO.setCheck_rst(status);
			 chlBillItemDO.setStatus(DOStatus.UPDATED);
		}
		 new DAFacade().updateDOArray(items, new String[]{ChlBillItemDO.CHECK_RST});
//		 _itemservice.save(items);
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
	
	private double getdouble(Object o){
		return Double.parseDouble(o.toString());
	}
	private String getString(Object o){
		String val=null;
		try{
		val=o.toString();
		}catch(Exception e){
			int i=1;
		}
		return val;
		
	}
}
