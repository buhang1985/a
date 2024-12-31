package iih.pmp.pay.s.bp;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.util.WXPayAppUtils;
import iih.pmp.pay.util.wxvalidate.WXPayValidateBP;
import iih.pmp.pay.util.wxvalidate.WXRePayValidateBP;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public class WXRePayTradeCreateBP {
	WXPayAppUtils utils=new WXPayAppUtils();
	public OrdRstDTO exec(OrdReqDTO dto) throws BizException{
		if(dto==null||dto.getOrd_no()==null)return null;
		WXRePayValidateBP validatebp=new WXRePayValidateBP();
		OrdRstDTO rnt = null;

		Map<String,Object> resultmap=validatebp.isOrdcanRePay(dto);
		boolean flag = (boolean) resultmap.get("flag");
		if (flag) {
			// todo
			// 如果订单不存在,则创建订单
			OrdDO ord = null;
			if(resultmap.containsKey("orddo")){
				ord = (OrdDO) resultmap.get("orddo");
			}else{
				ord = utils.createOrdDo(dto);
			}
			TradeDO tra = null;
			if (ord != null) {
				FBoolean fg = FBoolean.FALSE;
				tra = utils.createPayTradeDo(ord, fg,dto);
			}

			if (tra == null)
				return null;
			if(rnt==null)
				rnt=new OrdRstDTO();	
			rnt.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
			rnt.setTrade_no(tra.getTrade_no());
			rnt.setTradetime(tra.getDt_req());
			rnt.setSv(tra.getSv());
			}else{
			String err=(String) resultmap.get("errcode");
//			throw new BizException(err);
			if(rnt==null)
				rnt=new OrdRstDTO();
			rnt.setTrade_no(dto.getTrade_no());
			rnt.setTradetime(dto.getTradetime());
			rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
			rnt.setMsg(err);
		}
		return rnt;
	}
}
