package iih.pmp.pay.cmbc.s.bp;

import java.util.HashMap;
import java.util.Map;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public class CmbcRefundBP {
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	/**
	 * 退款接口
	 * 
	 * @param dto
	 * @throws BizException 
	 */
	public OrdRstDTO doRefund(OrdReqDTO dto) throws BizException  {		
		
		if(dto==null||dto.getRefund_req_no()==null||dto.getOrd_no()==null||dto.getTrade_no()==null)return null;
		CmbcPayBP paybp=new CmbcPayBP();		
		OrdRstDTO rnt = null;
		TradeDO[] ts=pmputils.getTradeRService().find(" trade_no='"+dto.getTrade_no()+"'", "", FBoolean.FALSE);
		if(ts==null||ts.length!=1)return null;
		TradeDO tra=ts[0];
		if(!pmputils.isDatetimeEqual(tra.getSv(), dto.getSv()))throw new BizException("交易数据已被他人修改");
		if(!pmputils.isFDoubleEq(dto.getAmount(), tra.getAmount()))throw new BizException("交易金额已被他人修改");
		OrdDO ord=pmputils.getOrdRService().findById(tra.getId_ord());
		if(ord==null)return null;
			if (ord != null) {
				if (tra != null) {
					Map<String, Object> data=getReFundData(ord, tra, dto);
					rnt=paybp.refund(data, tra, ord);
				}
			}	
		

		return rnt;
		
	}
	
	public   Map<String, Object> getReFundData(OrdDO ord,TradeDO tra,OrdReqDTO dto) {
		Map<String, Object> data=new HashMap<String,Object>();
		data.put("merchantSeq", ord.getCode());
		data.put("mchSeqNo", tra.getTrade_no());
		String amount=pmputils.Yuan2Fen(dto.getAmount());
		data.put("orderAmount", amount);
		data.put("orderNote", dto.getSubject());
		data.put("reserve", dto.getBody());
		return data;
	}
	
}
