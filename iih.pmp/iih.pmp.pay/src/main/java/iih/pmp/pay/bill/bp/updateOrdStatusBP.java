package iih.pmp.pay.bill.bp;

import java.text.SimpleDateFormat;
import java.util.List;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.d.OrdStatusEnum;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.wxvalidate.WXQueryValidateBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class updateOrdStatusBP {
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	public void exec() throws BizException{
		
		FDateTime dt=pmputils.getServerDateTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String startTime = sdf.format(dt.getDate().toDate());
		String sql="select a.* from pmp_trade a left join pmp_ord b on a.id_ord=b.id_ord where "+" a.sd_chl='"+PmpPayConst.WXPAY_CHANNEL_CODE+"' and( a.trade_status="+TradeStatusEnum.NOTPAY+" ) and a.dt_req<'"+startTime+"'  and b.ord_status="+OrdStatusEnum.WAIT_TO_PAY;
		TradeDO[] tras=pmputils.getTradeRService().find("sd_chl='"+PmpPayConst.WXPAY_CHANNEL_CODE+"' and( trade_status="+TradeStatusEnum.PAY_WAIT+" or trade_status="+TradeStatusEnum.TRADE_UNKNOWN+" ) and dt_req<'"+startTime+"'", "", FBoolean.FALSE);
		this.queryTrades(tras);
		this.updateNotPay(sql);
	}
	
	private void updateNotPay(String sql) throws BizException{
		
     DAFacade da = new DAFacade();		
     List<TradeDO>rst=(List<TradeDO>) da.execQuery(sql, new BeanListHandler(TradeDO.class));
     if(rst!=null&&rst.size()>0){
    	 
    	 this.queryTrades(rst.toArray(new TradeDO[0]));
     }
	}
	
	private void queryTrades(TradeDO[]tras) throws BizException{
		FDateTime dt=pmputils.getServerDateTime();
		
		for (TradeDO tradeDO : tras) {

			OrdReqDTO dto=new OrdReqDTO();
			dto.setOrd_no(tradeDO.getOrd_no());
			dto.setId_user_req(tradeDO.getId_emp_op());
			WXQueryValidateBP bp=new WXQueryValidateBP();
			OrdDO ords=bp.getOrdsInfo8Trade(dto, tradeDO);

				if(ords!=null&&ords.getOrd_status()==OrdStatusEnum.WAIT_TO_PAY){
					//超过4小时，设置为支付失败
					if(tradeDO.getDt_req().getHoursBetween(tradeDO.getDt_req(), dt)>4){
						updateOrdStatus(ords, OrdStatusEnum.FAIL);
//						TradeDO t=pmputils.getTradeRService().findById(tradeDO.getId_trade());
					//	updateTradeStatusnew(t, TradeStatusEnum.PAY_FAIL);
					}
				}				
		}
	}
	
	private void updateOrdStatus(OrdDO o, int ordstatus) throws BizException {
		if (!o.getOrd_status().equals(ordstatus)  ) {
			o.setOrd_status(ordstatus);
			o.setStatus(DOStatus.UPDATED);
			pmputils.getOrdCudService().update(new OrdDO[] { o });
		}
	}

	private void updateTradeStatusnew(TradeDO t, int tradestatus)
			throws BizException {
		if (!t.getTrade_status().equals(tradestatus)) {
			t.setTrade_status(tradestatus);
			t.setStatus(DOStatus.UPDATED);
			pmputils.getTradeCUDService().update(new TradeDO[] { t });
		}
	}

}
