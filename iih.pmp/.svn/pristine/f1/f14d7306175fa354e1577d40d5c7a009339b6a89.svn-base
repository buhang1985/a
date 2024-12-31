package iih.pmp.pay.s.bp;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.WXPayAppUtils;
import iih.pmp.pay.util.wxvalidate.WXPayValidateBP;

import java.util.HashMap;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public class WXJSAPIPayBP {
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	WXDataConvert convert=new WXDataConvert();
	/**
	 * 公众号支付 统一下单
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public OrdRstDTO doJSAPIPay(OrdReqDTO dto) throws BizException {
		if(dto==null||dto.getOrd_no()==null||dto.getTrade_no()==null)return null;
		WXPayBP paybp=new WXPayBP();
		WXPayValidateBP validatebp=new WXPayValidateBP();
		OrdRstDTO rnt = null;
		TradeDO[] ts=pmputils.getTradeRService().find(" trade_no='"+dto.getTrade_no()+"'", "", FBoolean.FALSE);
		if(ts==null||ts.length!=1)return null;
		TradeDO tra=ts[0];
		if(!pmputils.isDatetimeEqual(tra.getSv(), dto.getSv()))throw new BizException("交易数据已被他人修改");
		if(!pmputils.isFDoubleEq(dto.getAmount(), tra.getAmount()))throw new BizException("交易金额已被他人修改");
		OrdDO ord=pmputils.getOrdRService().findById(tra.getId_ord());
		if(ord==null)return null;
		HashMap<String, String> data=convert.getJSAPIData( tra, dto);
		rnt =paybp.UnifiedOrder(data, tra, ord, dto);
				
		
		return rnt;
	}

}
