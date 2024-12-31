package iih.pmp.pay.util.wxvalidate;

import java.util.Map;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.s.bp.WXPayBP;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;

public class WXRePayValidateBP {
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	WXPayBP paybp=new WXPayBP();
	WXPayValidateBP bp =new WXPayValidateBP();
	public Map<String,Object> isOrdcanRePay(OrdReqDTO dto) throws BizException{
		
		OrdQryRstDTO qrst=new OrdQryRstDTO();
		qrst.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
		StringBuilder sb=new StringBuilder();
		FArrayList2 fa=bp.HandlerOrdValidate(dto,qrst);
		Map<String,Object>resultMap=(Map<String, Object>) fa.get(1);		
		boolean flag = (boolean) fa.get(0);
		OrdDO[] ords = null;
		if(flag){
			if(fa.size()<=2){
				return resultMap;
			}
		}
		if(flag){
		ords=(OrdDO[]) fa.get(2);
		flag=bp.validateOrd(ords[0], dto,qrst);
		}
		if(flag){
			flag=this.validateTrade(ords[0], dto, sb,qrst);
		}	
		//更新订单状态
		if(ords!=null&&ords.length==1)
		ords=pmputils.getOrdCudService().update(ords);
		if(flag){			
			resultMap.put("orddo", ords[0]);
		}else{
			resultMap.put("flag", flag);
		}
		return resultMap;
	}
	
	private boolean validateTrade(OrdDO ordDO,OrdReqDTO dto,StringBuilder sb,OrdQryRstDTO qrst) throws BizException{
		boolean flag=true;
		TradeDO[] tras = pmputils.getTradeDO8ord(ordDO);
		if (tras != null && tras.length > 0) {
			flag=false;
			// 查询交易表订单当前状态 todo
			for (TradeDO t : tras) {
				flag=bp.tradevalidate(t, ordDO, dto, qrst);

					if (!flag) {
						dto.setTrade_no(t.getTrade_no());
						dto.setTradetime(t.getDt_req());
						break;
					}
			}
			pmputils.getTradeCUDService().save(tras);
		}
		return flag;
	}

}
