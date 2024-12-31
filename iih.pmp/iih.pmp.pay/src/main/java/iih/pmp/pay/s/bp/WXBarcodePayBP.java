package iih.pmp.pay.s.bp;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.d.OrdStatusEnum;
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

public class WXBarcodePayBP {
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	WXPayAppUtils utils=new WXPayAppUtils();
	WXDataConvert convert=new WXDataConvert();
	/**
	 * 刷卡支付 内置重试机制，最多30s
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public OrdRstDTO domicroPayWithPos(OrdReqDTO dto) throws BizException {
		if(dto==null||dto.getOrd_no()==null||dto.getTrade_no()==null)return null;
		WXPayBP paybp=new WXPayBP();		
		OrdRstDTO rnt = null;
		TradeDO[] ts=pmputils.getTradeRService().find(" trade_no='"+dto.getTrade_no()+"'", "", FBoolean.FALSE);
		if(ts==null||ts.length!=1){rnt=this.getFailRst(dto);rnt.setMsg("没有对应的交易或对应多条交易");return rnt;}
		TradeDO tra=ts[0];
		if(!pmputils.isDatetimeEqual(tra.getSv(), dto.getSv())){rnt=this.getFailRst(dto);rnt.setMsg("交易数据已被他人修改");return rnt;}
		if(!pmputils.isFDoubleEq(dto.getAmount(), tra.getAmount())){rnt=this.getFailRst(dto);rnt.setMsg("交易金额已被他人修改");return rnt;}
		OrdDO ord=pmputils.getOrdRService().findById(tra.getId_ord());
		if(ord==null){rnt=this.getFailRst(dto);rnt.setMsg("没有对应的订单");return rnt;}
		if(ord.getOrd_status()==OrdStatusEnum.PAID||ord.getOrd_status()==OrdStatusEnum.WAIT_TO_PAY){rnt=this.getFailRst(dto);rnt.setMsg("订单已支付或者正在支付中，请重新查询订单");return rnt;}
		if(!pmputils.isFDoubleEq(dto.getAmount(), ord.getAmount())){rnt=this.getFailRst(dto);rnt.setMsg("订单金额与请求交易金额不一致");return rnt;}
		HashMap<String, String> data=convert.getMicroPayData( tra, dto);
		rnt =paybp.microPayWithPos(data, tra, ord, dto);					
		return rnt;
	}
	
	private OrdRstDTO getFailRst(OrdReqDTO dto){
		
		OrdRstDTO rnt=new OrdRstDTO();
		rnt.setTrade_no(dto.getTrade_no());
		rnt.setTradetime(dto.getTradetime());
		rnt.setSv(dto.getSv());
		rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
		return rnt;
	}
	
	/**
	 * 刷卡支付 内置重试机制，最多30s
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public OrdRstDTO domicroPayWithPos_old(OrdReqDTO dto) throws BizException {
		if(dto==null||dto.getOrd_no()==null)return null;
		WXPayBP paybp=new WXPayBP();
		WXPayValidateBP validatebp=new WXPayValidateBP();
		OrdRstDTO rnt = null;

			Map<String,Object> resultmap=validatebp.isOrdcanPay_new(dto,null);
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
				HashMap<String, String> data=convert.getMicroPayData( tra, dto);
				rnt =paybp.microPayWithPos(data, tra, ord, dto);
				}else{
				String err=(String) resultmap.get("errcode");
//				throw new BizException(err);
				if(rnt==null)
					rnt=new OrdRstDTO();	
				rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
				rnt.setMsg(err);
			}
		
		return rnt;
	}

}
