package iih.pmp.pay.s;

import iih.pmp.pay.custom.bp.PmpReverseOrdBP;
import iih.pmp.pay.custom.bp.PmpReverseQueryBp;
import iih.pmp.pay.i.IPmpPayExternalService;
import iih.pmp.pay.i.IPmpPayOperatorService;
import iih.pmp.pay.i.IPmpPayService;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.utils.PmpPayLogUtils;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;

@Service(serviceInterfaces = { IPmpPayExternalService.class }, binding = Binding.JSONRPC)
public class PmpPayExternalServiceImpl implements IPmpPayExternalService {

	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();

	@Override
	public OrdRstDTO refund(OrdReqDTO dto) throws BizException {
		PmpPayLogUtils.info("[1]PMP退费方法,创建交易数据入参:"+(dto==null?"dto为null":dto.serializeJson()));
		// TODO Auto-generated method stub
		OrdRstDTO rnt1 = null;
		String errmsg="";
		try {
			rnt1 = ServiceFinder.find(IPmpPayOperatorService.class).refundtradeCreate(dto);
		}catch(Exception ex) {
			errmsg=ex.getMessage();
		}
		PmpPayLogUtils.info("[2]PMP退费方法,创建交易数据返回值:"+(rnt1==null?"rnt1为null":rnt1.serializeJson())+"   errmsg: "+errmsg);
		if (rnt1 == null || rnt1.getBiz_status() == null) {
			rnt1=new OrdRstDTO();
			rnt1.setBiz_status(BizStatusEnum.BIZ_FAIL);
			rnt1.setMsg(errmsg);
			rnt1.setTrade_status(TradeStatusEnum.REFUND_FAIL);
			return rnt1;
		}
		if (BizStatusEnum.BIZ_FAIL.equals(rnt1.getBiz_status())) {
			if(TradeStatusEnum.REFUND_SUCCESS.equals(rnt1.getTrade_status()))
				rnt1.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
			return rnt1;
		}
		
		dto.setTrade_no(rnt1.getTrade_no());
		dto.setTradetime(rnt1.getTradetime());
		dto.setSv(rnt1.getSv());
		OrdRstDTO rnt=null;
		try {
			PmpPayLogUtils.info("[3]PMP退费方法,退费方法入参:"+(dto==null?"dto为null":dto.serializeJson()));
			rnt = ServiceFinder.find(IPmpPayService.class).refund4task(dto);
		}catch(Exception ex) {
			errmsg=ex.getMessage();
		}
		PmpPayLogUtils.info("[4]PMP退费方法,退费返回值:"+(rnt==null?"rnt为null":rnt.serializeJson())+"   errmsg: "+errmsg);
		if (rnt == null) {
			rnt1.setBiz_status(BizStatusEnum.BIZ_FAIL);
			rnt1.setMsg(errmsg);
			rnt1.setTrade_status(TradeStatusEnum.TRADE_UNKNOWN);
			return rnt1;
		}

		rnt.setTrade_no(dto.getTrade_no());
		rnt.setTradetime(dto.getTradetime());
		PmpPayLogUtils.info("[5]PMP退费方法,最终返回值:"+(rnt==null?"rnt为null":rnt.serializeJson())+"   errmsg: "+errmsg);
		return rnt;
	}

	@Override
	public OrdRstDTO doBarcodePay(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		OrdRstDTO rnt1 = ServiceFinder.find(IPmpPayOperatorService.class).tradeCreate(dto);
		if (rnt1 == null || rnt1.getBiz_status() == null)
			return null;
		if (BizStatusEnum.BIZ_FAIL.equals(rnt1.getBiz_status())) {
			
			rnt1.setResult_code("FAIL");
			return rnt1;
		}

		dto.setTrade_no(rnt1.getTrade_no());
		dto.setTradetime(rnt1.getTradetime());
		dto.setSv(rnt1.getSv());
		OrdRstDTO rnt = null;
		try {
			rnt = ServiceFinder.find(IPmpPayOperatorService.class).barcodePay(dto);
		} catch (Exception ex) {
            rnt1.setMsg(ex.getMessage());
		}
		if (rnt == null) {
			rnt1.setResult_code("SUCCESS");
			rnt1.setBiz_status(BizStatusEnum.BIZ_FAIL);
			return rnt1;
		}
		rnt.setResult_code("SUCCESS");
		rnt.setTrade_no(rnt1.getTrade_no());
		rnt.setTradetime(rnt1.getTradetime());
		return rnt;
	}
/**
 * 正扫支付接口
 */
	@Override
	public OrdRstDTO doQrcodePay(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
	    OrdRstDTO rnt1 = ServiceFinder.find(IPmpPayOperatorService.class).tradeCreate(dto);
        if (rnt1 == null || rnt1.getBiz_status() == null) return null;
        if (BizStatusEnum.BIZ_FAIL.equals(rnt1.getBiz_status()))
        {
        	rnt1.setResult_code("FAIL");
            return rnt1;
        }

        dto.setTrade_no(rnt1.getTrade_no());
		dto.setTradetime(rnt1.getTradetime());
		dto.setSv(rnt1.getSv());
        OrdRstDTO rnt =  ServiceFinder.find(IPmpPayOperatorService.class).scanPayPrecreate(dto);
        if (rnt == null) {
			rnt1.setResult_code("SUCCESS");
			rnt1.setBiz_status(BizStatusEnum.BIZ_FAIL);
			return rnt1;
		}
		rnt.setResult_code("SUCCESS");
		rnt.setTrade_no(rnt1.getTrade_no());
		rnt.setTradetime(rnt1.getTradetime());
        return rnt;
	}
	
	@Override
	public OrdQryRstDTO ReverseOrd(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		return new PmpReverseOrdBP().ReverseOrd(dto);
	}

	@Override
	public OrdQryRstDTO ReverseQueryOrd(OrdReqDTO dto) throws BizException {
		// TODO Auto-generated method stub
		return new PmpReverseQueryBp().ReverseQueryOrd(dto);
	}

}
