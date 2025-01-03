package iih.pmp.pay.custom.bp;

import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.TransactionStatus;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayAppUtils;
import iih.pmp.pay.util.WXPayAppUtils;
import iih.pmp.pay.utils.PmpPayLogUtils;
import iih.pmp.pay.utils.PmpWxPayLogUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;

public class PmpPayUtils {

	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();
	WXPayAppUtils utils = new WXPayAppUtils();

	/**
	 * 民生银行生成交易数据
	 * 
	 * @param ord
	 * @param fg_precreated
	 * @return
	 * @throws BizException
	 */
	public TradeDO createPayTradeDo(OrdDO ord, OrdReqDTO dto) throws BizException {
		if (StringUtils.isBlank(dto.getId_user_req())) {
			throw new BizException("请求用户不允许为空");
		}

		TradeDO tra = new TradeDO();
		tra.setAmount(dto.getAmount());
		String code = PmpPayAppUtils.getTradeCode();
		if (code == null)
			return null;
		tra.setTrade_no(code);
		tra.setSd_ord(ord.getCode());
		tra.setId_emp_op(dto.getId_user_req());
//		tra.setId_emp_op(pmputils.getId_Stuff(null));// ????自助机或his是否也能获取
		tra.setId_org(pmputils.getEnvContext().getOrgId());// ????自助机或his是否也能获取
		tra.setId_grp(pmputils.getEnvContext().getGroupId());
		tra.setBody(dto.getBody());
		tra.setDt_req(pmputils.getServerDateTime());
		tra.setId_ord(ord.getId_ord());
		tra.setEu_direct(PmpPayConst.TRADE_DIRECT_PAY);
		tra.setSubject(dto.getSubject());
		tra.setTrade_status(TradeStatusEnum.TRADE_UNKNOWN);
		tra.setFg_precreate(dto.getFg_precreate());
		tra.setId_chl(PmpPayConst.getUdiID(dto.getSd_chl(), PmpPayConst.CHANNEL_DOCLIST_ID));
		tra.setSd_chl(dto.getSd_chl());
		tra.setOrd_no(dto.getOrd_no());
		tra.setSd_scene(dto.getSd_scene());
		tra.setId_scene(PmpPayConst.getUdiID(dto.getSd_scene(), PmpPayConst.SCENE_DOCLIST_ID));
		tra.setDeviceinfo(dto.getDeviceinfo());
		if (!pmputils.isStrEmpty(dto.getTradetype())) {
			tra.setTradetype(dto.getTradetype());
		} else {
			// 如果没传交易类型，通过条码判断是支付宝还是微信
			String tradetype = pmputils.getCmbcSence8Authorcode(dto.getAuth_code());
			tra.setTradetype(tradetype);
		}
		tra.setStatus(DOStatus.NEW);
//		TradeDO[] tras=pmputils.getTradeRService().find(" Trade_no='"+code+"'", "", FBoolean.FALSE);
//		if(tras!=null&&tras.length>0)return null;
		TradeDO[] trs = pmputils.getTradeCUDService().save(new TradeDO[] { tra });
		if (trs != null && trs.length > 0)
			return trs[0];
		return null;
	}

	/**
	 * 生成退款交易
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public TradeDO createReFundTradeDo(OrdReqDTO dto, OrdDO ord, TradeDO tras) throws BizException {
		return createReFundTradeDo(ord, dto, tras);
	}

	public TradeDO getPaidTrade(OrdReqDTO dto, OrdDO ord) throws BizException {
		TradeDO[] tras = pmputils.getTradeRService().find(TradeDO.ID_ORD + " ='" + ord.getId_ord() + "' and eu_direct="
				+ PmpPayConst.TRADE_DIRECT_PAY + " and trade_status= " + TradeStatusEnum.PAY_SUCCESS, null,
				FBoolean.FALSE);
		if (tras == null || tras.length == 0)
			return null;
		if (tras.length > 1)
			throw new BizException("该订单对应多笔已支付交易！");
		return tras[0];
	}

	public TradeDO createReFundTradeDo(OrdDO ord, OrdReqDTO dto, TradeDO reltrade) throws BizException {
		PmpPayLogUtils.info("[1]PMP_PmpPayUtils_createReFundTradeDo,创建交易信息,入参: 订单_"+(ord==null?"ord is null":ord.serializeJson())+" ,关联付款交易_"+(reltrade==null?"reltrade is null":reltrade.serializeJson())+" ,订单请求OrdReqDTO:"+dto.serializeJson());
		if (StringUtils.isBlank(dto.getId_user_req())) {
			throw new BizException("请求用户不允许为空");
		}

		TradeDO tra = new TradeDO();
		String code = PmpPayAppUtils.getTradeCode();
		if (code == null)
			return null;
		tra.setTrade_no(code);
		tra.setSd_ord(ord.getCode());
		tra.setAmount(dto.getAmount());
		tra.setRefund_req_no(dto.getRefund_req_no());
		tra.setId_emp_op(dto.getId_user_req());
		tra.setId_refund_user(dto.getId_user_req());
//		tra.setId_emp_op(pmputils.getId_Stuff(dto.getId_user_req()));
//		tra.setId_refund_user(pmputils.getId_Stuff(null));// ????自助机或his是否也能获取
		tra.setId_org(pmputils.getEnvContext().getOrgId());// ????自助机或his是否也能获取
		tra.setId_grp(pmputils.getEnvContext().getGroupId());
		tra.setDt_req(pmputils.getServerDateTime());
		tra.setId_ord(ord.getId_ord());
		tra.setEu_direct(PmpPayConst.TRADE_DIRECT_REFUND);
		tra.setTrade_status(TradeStatusEnum.TRADE_UNKNOWN);
		tra.setTrade_no_rel(reltrade.getTrade_no());
		tra.setId_chl(PmpPayConst.getUdiID(dto.getSd_chl(), PmpPayConst.CHANNEL_DOCLIST_ID));
		tra.setSd_chl(dto.getSd_chl());
		tra.setOrd_no(dto.getOrd_no());
		tra.setId_scene(PmpPayConst.getUdiID(reltrade.getSd_scene(), PmpPayConst.SCENE_DOCLIST_ID));
		tra.setSd_scene(reltrade.getSd_scene());
		tra.setBody(dto.getBody());
		tra.setSubject(dto.getSubject());
		tra.setDeviceinfo(dto.getDeviceinfo());
		tra.setTradetype(reltrade.getTradetype());
		tra.setPaymode(reltrade.getPaymode());
		tra.setStatus(DOStatus.NEW);
//		TradeDO[] tras=pmputils.getTradeRService().find(" Trade_no='"+code+"'", "", FBoolean.FALSE);
//		if(tras!=null&&tras.length>0)return null;
		TradeDO trs = SaveTrade(new TradeDO[] { tra });
		// TradeDO[] trs = pmputils.getTradeCUDService().save();
		/*
		 * if (trs != null && trs.length > 0) return trs[0];
		 */
		PmpPayLogUtils.info("[2]PMP_PmpPayUtils_createReFundTradeDo,创建交易信息,出参:"+tra.serializeJson()+ " ,订单_"+(ord==null?"ord is null":ord.serializeJson())+" ,关联付款交易_"+(reltrade==null?"reltrade is null":reltrade.serializeJson())+" ,订单请求OrdReqDTO:"+dto.serializeJson());
		return trs;
	}

	public TradeDO SaveTrade(final TradeDO[] tra) throws BizException {
		try {
			TradeDO tr = TransactionExecutor.executeNewTransaction(new TransactionalOperation<TradeDO>() {
				@Override
				public TradeDO doInTransaction(TransactionStatus arg0) {
					try {
						TradeDO[] trs = pmputils.getTradeCUDService().save(tra);
						if (trs != null && trs.length > 0)
							return trs[0];
						return null;
					} catch (Exception e) {
						throw new BizRuntimeException(e.getMessage(), e);
					}
				}
			});
			return tr;
		} catch (Exception e) {
			PmpWxPayLogUtils.logEx(e);
		}
		return null;
	}

}
