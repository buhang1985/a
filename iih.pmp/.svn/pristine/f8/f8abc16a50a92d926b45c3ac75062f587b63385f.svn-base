package iih.pmp.pay.custom.bp;

import java.util.Map;

import iih.pmp.pay.custom.i.IPmpDataconvert;
import iih.pmp.pay.custom.i.IPmpSdk;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.ordrstdto.d.BizStatusEnum;
import iih.pmp.pay.ordrstdto.d.OrdRstDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayAppUtils;
import iih.pmp.pay.util.PmpPayBaseCost;
import iih.pmp.pay.util.WXPayAppUtils;
import iih.pmp.pay.utils.PmpPayLogUtils;
import xap.mw.core.data.BizException;

public class PmpRefundTradeCreateBP {

	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();
	WXPayAppUtils utils = new WXPayAppUtils();
	PmpPayUtils utilspmp = new PmpPayUtils();

	public OrdRstDTO exec(OrdReqDTO dto) throws BizException {
		PmpPayLogUtils.info("[1]PMP_PmpRefundTradeCreateBP,创建交易数据入参:"+(dto==null?"dto为null":dto.serializeJson()));
		if (dto == null || pmputils.isStrEmpty(dto.getRefund_req_no()) || pmputils.isStrEmpty(dto.getOrd_no()))
			throw new BizException("退款单号或外部订单号为空");
		if(dto.getAmount()==null||dto.getAmount().getDouble()<=0)
			throw new BizException("退款申请金额为空，或金额小于等于0");
		OrdDO ord = null;
		ord = utils.getPaidOrdDO(dto);
		PmpPayLogUtils.info("[2]PMP_PmpRefundTradeCreateBP,获取支付订单信息:"+(ord==null?"ord为null":ord.serializeJson()));

		if (ord == null)
			return null;
		if(!dto.getSd_chl().equals(ord.getSd_chl())) {
			throw new BizException("传入的渠道不正确，请重新选择渠道！");
		}
		if(dto.getAmount().getDouble()>ord.getAmount_bk().getDouble())
			throw new BizException("退款申请金额大于可退款金额！");
		TradeDO paidtra=utilspmp.getPaidTrade(dto,ord);
		PmpPayLogUtils.info("[3]PMP_PmpRefundTradeCreateBP,获取支付交易信息:"+(paidtra==null?"paidtra为null":paidtra.serializeJson()));
		if(paidtra==null)throw new BizException("未查询到已支付交易");
		IPmpDataconvert dataconvert = PmpPayAppUtils.getDataconvert(dto.getSd_chl());
		IPmpSdk pay=PmpPayAppUtils.getPmpSdk(dto.getSd_chl());
		PmpRefundValidateBP validatebp = new PmpRefundValidateBP(pay,dataconvert);
		OrdRstDTO rnt = new OrdRstDTO();
		Map<String, Object> vrt = validatebp.isTradecanReFund(dto, ord,rnt,paidtra);
		boolean flag = (boolean) vrt.get(PmpPayBaseCost.PMP_FLAG);
		PmpPayLogUtils.info("[4]PMP_PmpRefundTradeCreateBP,获取交易能否退款结果:"+(vrt==null?"vrt为null":vrt.get(PmpPayBaseCost.PMP_FLAG)));
		if (flag) {
			TradeDO tra = null;
			// 如果退款失败,需要再生成流水号,继续退,不能使用之前的流水号
			PmpPayLogUtils.info("[5]PMP_PmpRefundTradeCreateBP: "+(vrt==null?"vrt为null":vrt.get(PmpPayBaseCost.PMP_FLAG))+" ,ord "+(ord==null?"ord is null":ord.serializeJson())+" ,tra "+(tra==null?"tra is null":tra.serializeJson()));
			if (ord != null) {
				tra = new PmpPayUtils().createReFundTradeDo(dto, ord,paidtra);
			}
			PmpPayLogUtils.info("[6]PMP_PmpRefundTradeCreateBP: "+(vrt==null?"vrt为null":vrt.get(PmpPayBaseCost.PMP_FLAG))+" ,ord "+(ord==null?"ord is null":ord.serializeJson())+" ,tra "+(tra==null?"tra is null":tra.serializeJson()));
			if (ord != null) {
				if (tra != null) {
					rnt.setBiz_status(BizStatusEnum.BIZ_SUCCESS);
					rnt.setTrade_no(tra.getTrade_no());
					rnt.setTradetime(tra.getDt_req());
					rnt.setSv(tra.getSv());
				}
			}
			if (ord == null || tra == null) {
				flag = false;
				vrt.put(PmpPayBaseCost.ERR_MSG, "未查找到可退款的订单或者交易！！！");
			}
			PmpPayLogUtils.info("[7]PMP_PmpRefundTradeCreateBP: "+(vrt==null?"vrt为null":vrt.get(PmpPayBaseCost.PMP_FLAG))+" ,ord "+(ord==null?"ord is null":ord.serializeJson())+" ,tra "+(tra==null?"tra is null":tra.serializeJson()));
		}
		PmpPayLogUtils.info("[8]PMP_PmpRefundTradeCreateBP,flag: "+flag+" ,ord "+(ord==null?"ord is null":ord.serializeJson()));
		if (!flag) {
			String err = (String) vrt.get(PmpPayBaseCost.ERR_MSG);
			rnt.setBiz_status(BizStatusEnum.BIZ_FAIL);
			rnt.setMsg(err);
		}
		PmpPayLogUtils.info("[9]PMP_PmpRefundTradeCreateBP,最终返回结果: "+(rnt==null?"rnt is null":rnt.serializeJson())+" ,ord "+(ord==null?"ord is null":ord.serializeJson()));
		return rnt;
	}

}
