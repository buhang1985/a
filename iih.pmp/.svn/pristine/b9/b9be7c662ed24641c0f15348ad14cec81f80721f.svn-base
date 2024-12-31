package iih.pmp.pay.bill.bp;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.wxvalidate.WXRefundValidateBP;

public class updateRefundStatus {
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	public void exec() throws BizException{
		
		TradeDO[] tras=pmputils.getTradeRService().find(" eu_direct=-1 and trade_status in("+TradeStatusEnum.REFUNDING+","+TradeStatusEnum.TRADE_UNKNOWN+")", "", FBoolean.FALSE);
		
		for (TradeDO tradeDO : tras) {
			OrdReqDTO dto=new OrdReqDTO();
			dto.setOrd_no(tradeDO.getOrd_no());
			dto.setId_user_req(tradeDO.getId_emp_op());
			dto.setRefund_req_no(tradeDO.getRefund_req_no());
			WXRefundValidateBP bp=new WXRefundValidateBP();
			bp.isTradecanReFund8trade(dto,tradeDO);
		}
	}

}
