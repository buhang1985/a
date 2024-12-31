package iih.pmp.pay.s.bp;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.wxvalidate.WXPayValidateBP;
import iih.pmp.pay.util.wxvalidate.WXQueryValidateBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;

public class PmpQueryStatuseBP {
	
	/**
	 * 支付查询状态
	 * @param dto
	 * @throws BizException 
	 */
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	public String exec(OrdReqDTO dto) throws BizException{
		TradeDO[] req = pmputils.getTradeRService().find(" ord_no = '"+dto.getOrd_no()+"'", "", FBoolean.FALSE);
		if(req!=null&&req.length>0){
			for (TradeDO tradeDO : req) {
				if(tradeDO.getTrade_status().equals(TradeStatusEnum.REFUND_SUCCESS)){
					return TradeStatusEnum.REFUND_SUCCESS.toString();
				}
			}
			return TradeStatusEnum.REFUND_FAIL.toString();
		}else{
			throw new BizException("订单号查询不到交易信息!");
		}
	}
}
