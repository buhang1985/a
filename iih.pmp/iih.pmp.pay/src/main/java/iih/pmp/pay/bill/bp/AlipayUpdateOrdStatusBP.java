package iih.pmp.pay.bill.bp;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.d.OrdStatusEnum;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;

import java.text.SimpleDateFormat;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;


public class AlipayUpdateOrdStatusBP {
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	@SuppressWarnings("static-access")
	public void exec() throws BizException {
		
		FDateTime dt=pmputils.getServerDateTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String startTime = sdf.format(dt.getDate().toDate());
		TradeDO[] tras = pmputils.getTradeRService().find("sd_chl='" + PmpPayConst.ALIPAY_CHANNEL_CODE + "' and (trade_status=" + TradeStatusEnum.PAY_WAIT + " or trade_status=" + TradeStatusEnum.TRADE_UNKNOWN + ") and dt_req<'" + startTime + "'", "", FBoolean.FALSE);
		for (TradeDO tradeDO : tras) {			
			OrdDO ords = pmputils.getOrdRService().findById(tradeDO.getId_ord());
			if (ords != null && (ords.getOrd_status() == OrdStatusEnum.WAIT_TO_PAY || ords.getOrd_status() == OrdStatusEnum.UNKNOWN)) {
				//超过4小时，设置为支付失败
				if(tradeDO.getDt_req().getHoursBetween(tradeDO.getDt_req(), dt) > 4) {
					updateOrdStatus(ords, OrdStatusEnum.FAIL);
					updateTradeStatusnew(tradeDO, TradeStatusEnum.PAY_FAIL, dt);
				}
			}				
		}
	}
	
	private void updateOrdStatus(OrdDO o, int ordstatus) throws BizException {
		if (!o.getOrd_status().equals(ordstatus)) {
			o.setOrd_status(ordstatus);
			o.setStatus(DOStatus.UPDATED);
			pmputils.getOrdCudService().update(new OrdDO[] { o });
		}
	}

	private void updateTradeStatusnew(TradeDO t, int tradestatus, FDateTime dt) throws BizException {
		if (!t.getTrade_status().equals(tradestatus)) {
			t.setDt_finish(dt);
			t.setTrade_status(tradestatus);
			t.setStatus(DOStatus.UPDATED);
			pmputils.getTradeCUDService().update(new TradeDO[] { t });
		}
	}
}
