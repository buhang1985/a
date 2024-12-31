package iih.pmp.pay.cmbc.bill.bp;

import java.util.ArrayList;
import java.util.List;

import iih.pmp.pay.bill.d.FailedTableEnum;
import iih.pmp.pay.billcheckexception.d.BillCheckExceptionDO;
import iih.pmp.pay.billcheckexception.d.CheckTradeStatus;
import iih.pmp.pay.billcheckexception.i.IBillcheckexceptionCudService;
import iih.pmp.pay.billcheckexception.i.IBillcheckexceptionRService;
import iih.pmp.pay.channelbill.d.ChannelBillDO;
import iih.pmp.pay.trade.d.BillChekRst;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 当天无对账单，统计异常数据
 * @author think
 *
 */
public class CmbcCheckWithoutBillBP {
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	 public void exec(BillCheckExceptionDO dto) throws BizException 
     {
		 IBillcheckexceptionRService _rservice = ServiceFinder
					.find(IBillcheckexceptionRService.class);
			IBillcheckexceptionCudService _cudservice = ServiceFinder
					.find(IBillcheckexceptionCudService.class);
		  String start=pmputils.getTransDate(dto.getDt_req().getDate(), "yyyy-MM-dd");
	      String end=pmputils.getTransDate(dto.getDt_req().getDate().getDateAfter(1), "yyyy-MM-dd");
	      String filter=" Bill_type='"+dto.getBill_type()+"' and tradetime>='"+start+"' and tradetime<'"+end+"' and sd_chl='"+PmpPayConst.CMBC_CHANNEL_CODE+"'";
			_cudservice.delete(_rservice.find(filter, "",
					FBoolean.FALSE));
	      TradeDO[] ts=pmputils.getTradeRService().find("dt_req>='"+start+"' and dt_req<'"+end+"'  and (trade_status=1 or trade_status=4)  and  Sd_chl='"+PmpPayConst.CMBC_CHANNEL_CODE+"'  and tradetype='"+pmputils.getCmbcSence(dto.getBill_type())+"'", "", FBoolean.FALSE);
	      List<BillCheckExceptionDO> exclist = new ArrayList<BillCheckExceptionDO>();
	      if(ts!=null) {
	    	  for (TradeDO t : ts) {
	    		 t.setCheck_rst(BillChekRst.TRADE_ONESIDEBILL);
	    		  if(TradeStatusEnum.PAY_SUCCESS.equals(t.getTrade_status())) {
	    			  BillCheckExceptionDO b1=this.createExceptionDO(t, CheckTradeStatus.PAYFAIL,dto);
	    			  exclist.add(b1);
	    		  }else if(TradeStatusEnum.REFUND_SUCCESS.equals(t.getTrade_status())) {
	    			  BillCheckExceptionDO b1=this.createExceptionDO(t, CheckTradeStatus.REFUNDFAIL,dto);
	    			  exclist.add(b1);
	    		  }
	    		  
			}
	    	  _cudservice.save(exclist.toArray(new BillCheckExceptionDO[0]));
	    	  
	      }
		 
     }
	 
		private BillCheckExceptionDO createExceptionDO(TradeDO dto,int chs,BillCheckExceptionDO chl) {
			BillCheckExceptionDO newdata = new BillCheckExceptionDO();
			newdata.setId_billitem(null);
			newdata.setId_trade(dto.getId_trade());
			newdata.setId_ord(dto.getId_ord());
			newdata.setTrade_no(chs==CheckTradeStatus.PAYFAIL?dto.getTrade_no():dto.getTrade_no_rel());
			newdata.setDt_req(dto.getDt_req());
			newdata.setOrd_no(dto.getOrd_no());
	        newdata.setId_chl(dto.getId_chl());
	        newdata.setSd_chl(dto.getSd_chl());
			newdata.setFailed_table(FailedTableEnum.TRADE);
			newdata.setIs_amaout_ckecked(FBoolean.FALSE);
			newdata.setIs_status_checked(FBoolean.FALSE);
			newdata.setCheckresult(dto.getCheck_rst());
			newdata.setTrade_type(CheckTradeStatus.PAYFAIL);
			newdata.setRefund_trade_no(chs==CheckTradeStatus.PAYFAIL?null:dto.getTrade_no());
			newdata.setTradetime(dto.getDt_req());
			newdata.setBill_type(chl.getBill_type());
			newdata.setStatus(DOStatus.NEW);
			return newdata;
		}

}
