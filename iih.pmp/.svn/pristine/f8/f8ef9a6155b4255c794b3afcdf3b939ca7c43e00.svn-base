package iih.pmp.pay.s.bp;

import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public class RefundTaskQueryBp {
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();
	
	public String exec(OrdReqDTO dto) throws BizException{
		TradeDO[] reqs = pmputils.getTradeRService().find(" refund_req_no = '"+dto.getRefund_req_no()+"'", "", FBoolean.FALSE);
		if(reqs.length>0){
			OrdQryRstDTO[] o = pmputils.getPmpPayService().pmprefundquery(dto);
		}
		
			TradeDO[] req = pmputils.getTradeRService().find(" refund_req_no = '"+dto.getRefund_req_no()+"'", "", FBoolean.FALSE);
			if(req!=null&&req.length<=1){
				if(req.length==1){
					if(req[0].getTrade_status().equals(TradeStatusEnum.REFUND_SUCCESS)){
						return TradeStatusEnum.REFUND_SUCCESS.toString();
					}else if(req[0].getTrade_status().equals(TradeStatusEnum.TRADE_UNKNOWN)){
						return TradeStatusEnum.TRADE_UNKNOWN.toString();
					}
				}
				return TradeStatusEnum.REFUND_FAIL.toString();
			}else{
				throw new BizException("订单号查询不到交易信息或查询到多条信息!");
			}
	}
}
