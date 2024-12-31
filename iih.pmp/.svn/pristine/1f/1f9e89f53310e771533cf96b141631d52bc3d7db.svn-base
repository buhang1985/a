package iih.pmp.pay.s.bp;

import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.wxvalidate.WXRefundValidateBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.coreitf.d.FBoolean;

public class WXRefundQueryBP {

	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();

	public TradeDO queryrefund(OrdReqDTO dto) throws BizException {
		if (dto == null || dto.getRefund_req_no() == null || dto.getOrd_no() == null)
			return null;
		WXRefundValidateBP validatebp = new WXRefundValidateBP();
		validatebp.isTradecanReFund(dto);
//		OrdRstDTO rnt = null;
//		Map<String, Object> vrt = validatebp.isTradecanReFund(dto);

		String wherePart = String.format("%s = ? and %s = ? and %s = %s", TradeDO.REFUND_REQ_NO, TradeDO.ORD_NO,
				TradeDO.EU_DIRECT, PmpPayConst.TRADE_DIRECT_REFUND);
		SqlParamDTO sqlParamDTO = new SqlParamDTO();
		sqlParamDTO.addParam(dto.getRefund_req_no());
		sqlParamDTO.addParam(dto.getOrd_no());
		TradeDO[] tras = pmputils.getTradeRService().find2(wherePart, sqlParamDTO, null, FBoolean.FALSE);

//		TradeDO[] tras = pmputils.getTradeRService().find(
//				TradeDO.REFUND_REQ_NO + " ='" + dto.getRefund_req_no()
//						+ "' and "+TradeDO.ORD_NO+"='"+dto.getOrd_no()+"' and eu_direct=" + PmpPayConst.TRADE_DIRECT_REFUND
//						+ " and " + TradeDO.ID_EMP_OP + "='"
//						+ pmputils.getId_Stuff(dto.getId_user_req()) + "'",
//				null, FBoolean.FALSE);
		if (tras != null && tras.length > 0)
			return tras[0];
		return null;
	}

}
