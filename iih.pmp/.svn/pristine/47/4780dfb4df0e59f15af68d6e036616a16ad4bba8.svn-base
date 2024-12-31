package iih.pmp.pay.custom.bp;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.pmp.pay.custom.i.IPmpDataconvert;
import iih.pmp.pay.custom.i.IPmpSdk;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.d.OrdStatusEnum;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 预下单支付
 * @author licheng
 *
 */
public class PmpPreQrCodePayBP {
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();
	
	public OrdRstDTO doPrePay(OrdReqDTO dto) throws BizException {
		if (dto == null || pmputils.isStrEmpty(dto.getOrd_no()) || pmputils.isStrEmpty(dto.getTrade_no()))
			return null;
		if(pmputils.isStrEmpty(dto.getTradetype()))
        	dto.setTradetype(null);
		OrdRstDTO rnt = null;
		TradeDO[] ts = pmputils.getTradeRService().find(" trade_no='" + dto.getTrade_no() + "'", "", FBoolean.FALSE);
		if (ts == null || ts.length != 1) {
			rnt = this.getFailRst(dto);
			rnt.setMsg("没有对应的交易或对应多条交易！");
			return rnt;
		}

		TradeDO tra = ts[0];
		if (!pmputils.isDatetimeEqual(tra.getSv(), dto.getSv())) {
			rnt = this.getFailRst(dto);
			rnt.setMsg("交易数据已被他人修改！");
			return rnt;
		}
		if (!pmputils.isFDoubleEq(dto.getAmount(), tra.getAmount())) {
			rnt = this.getFailRst(dto);
			rnt.setMsg("交易金额已被他人修改！");
			return rnt;
		}

		OrdDO ord = pmputils.getOrdRService().findById(tra.getId_ord());
		if (ord == null) {
			rnt = this.getFailRst(dto);
			rnt.setMsg("没有对应的订单！");
			return rnt;
		}

		if (ord.getOrd_status() == OrdStatusEnum.PAID || ord.getOrd_status() == OrdStatusEnum.WAIT_TO_PAY) {
			rnt = this.getFailRst(dto);
			rnt.setMsg("订单已支付或者正在支付中，请重新查询订单！");
			return rnt;
		}

		if (!pmputils.isFDoubleEq(dto.getAmount(), ord.getAmount())) {
			rnt = this.getFailRst(dto);
			rnt.setMsg("订单金额与请求交易金额不一致！");
			return rnt;
		}
		if(!dto.getOrd_no().equals(ord.getOrd_no())) {
			rnt = this.getFailRst(dto);
			rnt.setMsg("订单外部订单号与请求dto外部订单号不一致！");
			return rnt;
		}
		if(StringUtils.isBlank(tra.getId_emp_op())) {
			rnt = this.getFailRst(dto);
			rnt.setMsg("当前人员不允许为空！");
			return rnt;
		}
		if(!dto.getSd_chl().equals(tra.getSd_chl())){
			rnt = this.getFailRst(dto);
			rnt.setMsg("传入的渠道号与交易表不一致！");
			return rnt;
		}
		if(!dto.getSd_chl().equals(ord.getSd_chl())){
			rnt = this.getFailRst(dto);
			rnt.setMsg("传入的渠道号与订单表不一致！");
			return rnt;
		}
		IPmpDataconvert dataconvert = PmpPayAppUtils.getDataconvert(dto.getSd_chl());
		IPmpSdk pay=PmpPayAppUtils.getPmpSdk(dto.getSd_chl());
		Map<String, Object> data = dataconvert.getQRCODEParam(dto, ord, tra);
		rnt = new PmpPayBP(pay,dataconvert).doqrcodepay(data, tra, ord, dto);
		return rnt;
	}
	
	private OrdRstDTO getFailRst(OrdReqDTO dto) {

		OrdRstDTO rnt = new OrdRstDTO();
		rnt.setTrade_no(dto.getTrade_no());
		rnt.setTradetime(dto.getTradetime());
		rnt.setSv(dto.getSv());
		rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
		return rnt;
	}

}
