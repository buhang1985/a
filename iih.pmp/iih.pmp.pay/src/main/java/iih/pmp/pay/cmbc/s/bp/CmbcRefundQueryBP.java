package iih.pmp.pay.cmbc.s.bp;

import java.util.Map;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.WXPayAppUtils;
import xap.mw.core.data.BizException;

public class CmbcRefundQueryBP {
	PmpPayAppBaseUtils pmputils=new PmpPayAppBaseUtils();
	WXPayAppUtils utils=new WXPayAppUtils();
	public OrdQryRstDTO[] queryrefund(OrdReqDTO dto) throws BizException{
		if(dto==null||dto.getRefund_req_no()==null||dto.getOrd_no()==null)return null;
		OrdDO ord = null;
		ord = utils.getPaidOrdDO(dto);
		if(ord==null)return null;
		CmbcRufundValidateBP validatebp=new CmbcRufundValidateBP();
		OrdRstDTO rnt = null;
		Map<String, Object> vrt = validatebp.isTradecanReFund(dto,ord);
		OrdQryRstDTO rst=null;
		boolean flag = (boolean) vrt.get("flag");	
		if(flag) {
			rst=createRstDTO(ord,null);
		}else {
			TradeDO[] tras = pmputils.getRefundTradeDO(ord,dto);
			for (TradeDO t : tras) {
				if(t.getTrade_status().equals(TradeStatusEnum.REFUND_SUCCESS)) {
					rst=createRstDTO(ord,t);
					break;
				}
			}
		}
		return new OrdQryRstDTO[] {rst};
	}
	
	private OrdQryRstDTO createRstDTO(OrdDO ord,TradeDO tra) {
		OrdQryRstDTO qrst=new OrdQryRstDTO();
		qrst.setOrd_no(ord.getOrd_no());
		qrst.setDt_ord(ord.getDt_ord());
		qrst.setOrd_status(ord.getOrd_status());
		qrst.setAmount(ord.getAmount());
		qrst.setAmount_bk(ord.getAmount_bk());
		if(tra==null) {
			qrst.setTrade_status(TradeStatusEnum.REFUND_FAIL);
		}else {
			qrst.setTrade_no(tra.getTrade_no());
			qrst.setRefund_fee(tra.getAmount());
			qrst.setTrade_status(tra.getTrade_status());
			qrst.setRefund_no(tra.getRefund_req_no());
			qrst.setBankorderno(tra.getBankorderno());
			qrst.setTrade_no_chl(tra.getTrade_no_chl());
		}
		return qrst;
	}
}
