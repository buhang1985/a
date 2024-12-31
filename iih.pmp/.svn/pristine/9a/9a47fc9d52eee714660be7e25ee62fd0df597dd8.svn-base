package iih.pmp.pay.cmbc.s.bp;

import java.util.HashMap;
import java.util.Map;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.d.OrdStatusEnum;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

public class CmbcBarcodePayBP {
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	 public OrdRstDTO doBarcodePay(OrdReqDTO dto) throws BizException {
		 if(dto==null||dto.getOrd_no()==null||dto.getTrade_no()==null)return null;
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
			 Map<String, Object> data=convertData( dto, ord, tra);	 			 
			 rnt =new CmbcPayBP().dobarcodepay(data, tra, ord, dto);
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
	 
	 
	 private Map<String, Object> convertData(OrdReqDTO dto,OrdDO ord,TradeDO tra){
		 Map<String,Object>data=new HashMap<String,Object>();
		 data.put("deviceInfo", dto.getDeviceinfo());
		 String remark=pmputils.getBase64Str(dto.getAuth_code());
		 data.put("remark", remark);
		 String amount=pmputils.Yuan2Fen(dto.getAmount());
		 data.put("amount", amount);
		 data.put("orderInfo", dto.getSubject());
		 data.put("merchantSeq", ord.getCode());
		 data.put("mchSeqNo", tra.getTrade_no());
		 FDateTime dt=pmputils.getServerDateTime();		 
		 String transdate=pmputils.getTransDate(dt, "yyyyMMdd");	 
		 String transtime=pmputils.getTransDate(dt, "yyyyMMddHHmmssSSS");	 
		 data.put("transDate", transdate);
		 data.put("transTime", transtime);
		 data.put("inExtData", dto.getBody());
		 data.put("selectTradeType", dto.getTradetype());
		 return data;
	 }
}
