package iih.pmp.pay.s.bp;

import iih.pmp.pay.channelbillitem.d.ChlBillItemDO;
import iih.pmp.pay.channelbillitem.i.IChannelbillitemCudService;
import iih.pmp.pay.channelbillitem.i.IChannelbillitemRService;
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
import xap.mw.sf.core.util.ServiceFinder;

public class PmpBillCheckBP {
	
	/**
	 * 对账
	 * @param dto
	 * @throws BizException 
	 */
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	public String exec(OrdReqDTO dto) throws BizException{
		TradeDO[] req = pmputils.getTradeRService().find(" ord_no = '"+dto.getOrd_no()+"'", "", FBoolean.FALSE);
		IChannelbillitemCudService _itemservice = ServiceFinder.find(IChannelbillitemCudService.class);
		IChannelbillitemRService _itemrrservice = ServiceFinder.find(IChannelbillitemRService.class);
		//所有对账的账单
		
		ChlBillItemDO[] chlBillItem = _itemrrservice.find("", "", FBoolean.FALSE);
		String ord_no = "";
		if(req.length>0){
			for (ChlBillItemDO tradeDO : chlBillItem) {
			}
			ord_no = ord_no.substring(ord_no.length()-1);
		}
	
		return null;
	}
}
