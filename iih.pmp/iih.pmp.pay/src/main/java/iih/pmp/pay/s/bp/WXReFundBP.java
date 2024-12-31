package iih.pmp.pay.s.bp;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.WXPayAppUtils;
import iih.pmp.pay.util.wxvalidate.WXRefundValidateBP;

import java.util.HashMap;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public class WXReFundBP {
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	WXPayAppUtils utils=new WXPayAppUtils();
	WXDataConvert convert=new WXDataConvert();
	/**
	 * 退款接口
	 * 
	 * @param dto
	 * @throws BizException 
	 */
	public OrdRstDTO doRefund(OrdReqDTO dto) throws BizException  {		
		
		if(dto==null||dto.getRefund_req_no()==null||dto.getOrd_no()==null||dto.getTrade_no()==null)return null;
		WXPayBP paybp=new WXPayBP();		
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
					HashMap<String, String> data=convert.getReFundData(ord, tra, dto);
					rnt=paybp.refund(data, tra, ord);
				}
			}		
		return rnt;
		
	}
	
	public OrdRstDTO doRefund_old(OrdReqDTO dto) throws BizException  {
		if(dto==null||dto.getRefund_req_no()==null||dto.getOrd_no()==null)return null;
		WXPayBP paybp=new WXPayBP();
		WXRefundValidateBP validatebp=new WXRefundValidateBP();
		OrdRstDTO rnt = null;
		Map<String, Object> vrt = validatebp.isTradecanReFund(dto);
		boolean flag = (boolean) vrt.get("flag");		
		if (flag) {
			TradeDO tra = null;
			OrdDO ord = null;
			if (vrt.containsKey("tradedo")) {
				// 如果外部订单有对应的失败交易，则用原退款交易继续申请      
				tra = (TradeDO) vrt.get("tradedo");
				ord = pmputils.getOrdRService().findById(tra.getId_ord());
			} else {
				ord = utils.getPaidOrdDO(dto);
				if (ord != null) {
					tra = utils.createReFundTradeDo(dto, ord);
				}
			}

			if (ord != null) {
				if (tra != null) {
					HashMap<String, String> data=convert.getReFundData(ord, tra, dto);
					rnt=paybp.refund(data, tra, ord);
				}
			}
			if(ord==null||tra==null){
				flag=false;
				vrt.put("errcode", "未查找到可退款的订单或者交易！！！");
			}
		}
		if(!flag){
			
			String err=(String) vrt.get("errcode");
			if(rnt==null)
				rnt=new OrdRstDTO();	
			rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
			rnt.setMsg(err);
		}
		return rnt;
	}


}
