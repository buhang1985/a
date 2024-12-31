package iih.pmp.pay.s.bp;

import java.util.Map;

import iih.pmp.pay.custom.bp.PmpPayBP;
import iih.pmp.pay.custom.bp.PmpPayUtils;
import iih.pmp.pay.custom.i.IPmpDataconvert;
import iih.pmp.pay.custom.i.IPmpSdk;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayAppUtils;
import iih.pmp.pay.util.PmpPayBaseCost;
import iih.pmp.pay.utils.PmpPayLogUtils;
import iih.pmp.yxpaySDK.bp.YxPayUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public class PmpRefund4TaskBP {
	

	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();
	PmpPayUtils utils = new PmpPayUtils();

	/**
	 * 退款接口
	 * 
	 * @param dto
	 * @throws BizException
	 */
	public OrdRstDTO doRefund(OrdReqDTO dto) throws BizException {
		PmpPayLogUtils.info("[1]PMP_PmpRefund4TaskBP,退款接口,入参: "+(dto==null?"dto为null":dto.serializeJson()));
		if (dto == null || pmputils.isStrEmpty(dto.getRefund_req_no()) || pmputils.isStrEmpty(dto.getOrd_no()) || pmputils.isStrEmpty(dto.getTrade_no()))
			return null;
		
		OrdRstDTO rnt = null;
		TradeDO[] ts = pmputils.getTradeRService().find(" trade_no='" + dto.getTrade_no() + "'", "", FBoolean.FALSE);
		if (ts == null || ts.length != 1)
			return null;
		TradeDO tra = ts[0];
		PmpPayLogUtils.info("[2]PMP_PmpRefund4TaskBP,交易信息: "+(tra==null?"tra为null":tra.serializeJson())+" ,入参信息: "+(dto==null?"dto为null":dto.serializeJson()));
		if (!pmputils.isDatetimeEqual(tra.getSv(), dto.getSv()))
			throw new BizException("交易数据已被他人修改");
		if (!pmputils.isFDoubleEq(dto.getAmount(), tra.getAmount()))
			throw new BizException("交易金额已被他人修改");		
		OrdDO ord = pmputils.getOrdRService().findById(tra.getId_ord());	
		PmpPayLogUtils.info("[3]PMP_PmpRefund4TaskBP,订单信息: "+(ord==null?"ord为null":ord.serializeJson())+" ,入参信息: "+(dto==null?"dto为null":dto.serializeJson()));
		if (ord == null)
			return null;
		if(!dto.getSd_chl().equals(tra.getSd_chl())){
			throw new BizException("传入的渠道号与交易表不一致！");
		}
		if(!dto.getSd_chl().equals(ord.getSd_chl())){
			throw new BizException("传入的渠道号与订单表不一致！");
		}
		TradeDO paidtra=utils.getPaidTrade(dto,ord);
		PmpPayLogUtils.info("[4]PMP_PmpRefund4TaskBP,支付交易信息: "+(paidtra==null?"paidtra为null":paidtra.serializeJson())+" ,入参信息: "+(dto==null?"dto为null":dto.serializeJson()));
		if (ord != null) {
			if (tra != null&&paidtra!=null&&paidtra.getTrade_no().equals(tra.getTrade_no_rel())) {
				if(pmputils.isStrEmpty(tra.getId_refund_user())) {
					if(dto.getId_refund_user()==null)
						throw new BizException("当前退款操作人员为空");
					tra.setId_refund_user(dto.getId_refund_user());
				}
				
				IPmpDataconvert dataconvert = PmpPayAppUtils.getDataconvert(dto.getSd_chl());
				IPmpSdk pay=PmpPayAppUtils.getPmpSdk(dto.getSd_chl());
				PmpPayBP paybp = new PmpPayBP(pay,dataconvert);
				Map<String, Object> data = dataconvert.getReFundParam(ord, tra, dto,paidtra);
				PmpPayLogUtils.info("[5]PMP_PmpRefund4TaskBP,退款参数组装: "+(data==null?"data为null":YxPayUtils.m2json(data))+" ,入参信息: "+(dto==null?"dto为null":dto.serializeJson()));
				rnt = paybp.refund(data, tra, ord, dto,paidtra);
			}
		}
		PmpPayLogUtils.info("[6]PMP_PmpRefund4TaskBP,最终返回结果: "+(rnt==null?"rnt为null":rnt.serializeJson())+" ,入参信息: "+(dto==null?"dto为null":dto.serializeJson()));
		return rnt;

	}


}
