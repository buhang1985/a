package iih.pmp.pay.s.bp;

import java.util.Map;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.WXPayAppUtils;
import iih.pmp.pay.util.wxvalidate.WXRefundValidateBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

public class WXRefundTradeCreateBP {
	WXPayAppUtils utils=new WXPayAppUtils();
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	public OrdRstDTO exec(OrdReqDTO dto) throws BizException{
		if(dto==null||dto.getRefund_req_no()==null||dto.getOrd_no()==null)return null;
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
				//如果金额不对则更新交易金额
				if(!pmputils.isFDoubleEq(dto.getAmount(), tra.getAmount())){
					tra.setAmount(dto.getAmount());
					tra.setStatus(DOStatus.UPDATED);
					pmputils.getTradeCUDService().update(new TradeDO[]{tra});
					tra=pmputils.getTradeRService().findById(tra.getId_trade());
				}
				ord = pmputils.getOrdRService().findById(tra.getId_ord());
				
			} else {
				ord = utils.getPaidOrdDO(dto);
				if (ord != null) {
					tra = utils.createReFundTradeDo(dto, ord);
				}
			}

			if (ord != null) {
				if (tra != null) {
					if(rnt==null)
						rnt=new OrdRstDTO();	
					rnt.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
					rnt.setTrade_no(tra.getTrade_no());
					rnt.setTradetime(tra.getDt_req());
					rnt.setSv(tra.getSv());
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
