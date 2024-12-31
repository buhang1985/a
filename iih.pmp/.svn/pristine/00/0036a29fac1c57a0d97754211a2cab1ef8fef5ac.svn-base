package iih.pmp.pay.custom.bp;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.pmp.pay.custom.i.IPmpDataconvert;
import iih.pmp.pay.custom.i.IPmpSdk;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public class PmpRefundBP {
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();
	PmpPayUtils utils = new PmpPayUtils();

	/**
	 * 退款接口
	 * 
	 * @param dto
	 * @throws BizException
	 */
	public OrdRstDTO doRefund(OrdReqDTO dto) throws BizException {

		if (dto == null || pmputils.isStrEmpty(dto.getRefund_req_no()) || pmputils.isStrEmpty(dto.getOrd_no()) || pmputils.isStrEmpty(dto.getTrade_no()))
			return null;
		
		OrdRstDTO rnt = null;
		TradeDO[] ts = pmputils.getTradeRService().find(" trade_no='" + dto.getTrade_no() + "'", "", FBoolean.FALSE);
		if (ts == null || ts.length != 1)
			return null;
		TradeDO tra = ts[0];
		if (!pmputils.isDatetimeEqual(tra.getSv(), dto.getSv()))
			throw new BizException("交易数据已被他人修改");
		if (!pmputils.isFDoubleEq(dto.getAmount(), tra.getAmount()))
			throw new BizException("交易金额已被他人修改");
		if(StringUtils.isBlank(tra.getId_refund_user())) {
			throw new BizException("当前人员不允许为空！");
		}
		
		OrdDO ord = pmputils.getOrdRService().findById(tra.getId_ord());		
		if (ord == null)
			return null;
		if(!dto.getSd_chl().equals(tra.getSd_chl())){
			throw new BizException("传入的渠道号与交易表不一致！");
		}
		if(!dto.getSd_chl().equals(ord.getSd_chl())){
			throw new BizException("传入的渠道号与订单表不一致！");
		}
		TradeDO paidtra=utils.getPaidTrade(dto,ord);
		if (ord != null) {
			if (tra != null&&paidtra!=null&&paidtra.getTrade_no().equals(tra.getTrade_no_rel())) {
				IPmpDataconvert dataconvert = PmpPayAppUtils.getDataconvert(dto.getSd_chl());
				IPmpSdk pay=PmpPayAppUtils.getPmpSdk(dto.getSd_chl());
				PmpPayBP paybp = new PmpPayBP(pay,dataconvert);
				Map<String, Object> data = dataconvert.getReFundParam(ord, tra, dto,paidtra);
				rnt = paybp.refund(data, tra, ord, dto,paidtra);
			}
		}
		return rnt;

	}

}
