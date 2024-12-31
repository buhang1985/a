package iih.pmp.pay.cmbc.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ord.d.OrdStatusEnum;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.udi.PmpPayConst;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.PmpPayAppUtils;
import iih.pmp.pay.util.WXPayAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

public class CmbcPayUtils {
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
	public TradeDO createPayTradeDo(OrdDO ord, FBoolean fg_precreated, OrdReqDTO dto) throws BizException {
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
//		tra.setId_emp_op(pmputils.getId_Stuff(null));//????自助机或his是否也能获取
		tra.setId_org(pmputils.getEnvContext().getOrgId());// ????自助机或his是否也能获取
		tra.setId_grp(pmputils.getEnvContext().getGroupId());
		tra.setBody(dto.getBody());
		tra.setDt_req(pmputils.getServerDateTime());
		tra.setId_ord(ord.getId_ord());
		tra.setEu_direct(PmpPayConst.TRADE_DIRECT_PAY);
		tra.setSubject(dto.getSubject());
		tra.setTrade_status(TradeStatusEnum.TRADE_UNKNOWN);
		tra.setFg_precreate(fg_precreated);
		tra.setId_chl(PmpPayConst.getUdiID(dto.getSd_chl(), PmpPayConst.CHANNEL_DOCLIST_ID));
		tra.setSd_chl(dto.getSd_chl());
		tra.setOrd_no(dto.getOrd_no());
		tra.setSd_scene(dto.getSd_scene());
		tra.setId_scene(PmpPayConst.getUdiID(dto.getSd_scene(), PmpPayConst.SCENE_DOCLIST_ID));
		tra.setDeviceinfo(dto.getDeviceinfo());
		tra.setTradetype(dto.getTradetype());
		tra.setStatus(DOStatus.NEW);
//		TradeDO[] tras=pmputils.getTradeRService().find(" Trade_no='"+code+"'", "", FBoolean.FALSE);
//		if(tras!=null&&tras.length>0)return null;
		TradeDO[] trs = pmputils.getTradeCUDService().save(new TradeDO[] { tra });
		if (trs != null && trs.length > 0)
			return trs[0];
		return null;
	}

	public boolean validateOrd(OrdDO ordDO, OrdReqDTO dto, OrdQryRstDTO rst) throws BizException {
		boolean flag = false;
		if (ordDO.getOrd_status().equals(OrdStatusEnum.PAID)) {
			// 已支付，不可以再次支付
			// sb.append( pmputils.getOrdErrMsg(dto.getOrd_no(), "已支付"));
			TradeDO[] tras = pmputils.getTradeRService().find(
					" id_ord='" + ordDO.getId_ord() + "' and trade_status=" + TradeStatusEnum.PAY_SUCCESS, null,
					FBoolean.FALSE);
			if (tras == null || tras.length == 0) {
				utils.updateOrdStatus(ordDO, OrdStatusEnum.UNKNOWN);
				flag = true;
			} else {

			}

		} else if (OrdStatusEnum.FAIL.equals(ordDO.getOrd_status())
				|| OrdStatusEnum.UNKNOWN.equals(ordDO.getOrd_status())
				|| OrdStatusEnum.WAIT_TO_PAY.equals(ordDO.getOrd_status())) {
			// 支付失败，可以再次支付 失败原因有可能是系统超时，也属于状态未知，也需要重新校验
			flag = true;
		}
		return flag;
	}

	/**
	 * 生成退款交易
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public TradeDO createReFundTradeDo(OrdReqDTO dto, OrdDO ord) throws BizException {

		TradeDO[] tras = pmputils.getTradeRService().find(TradeDO.ID_ORD + " ='" + ord.getId_ord() + "' and eu_direct="
				+ PmpPayConst.TRADE_DIRECT_PAY + " and trade_status=1 ", null, FBoolean.FALSE);
		if (tras == null || tras.length == 0)
			return null;
		return createReFundTradeDo(ord, dto, tras[0]);
	}

	public TradeDO createReFundTradeDo(OrdDO ord, OrdReqDTO dto, TradeDO reltrade) throws BizException {
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
		tra.setId_chl(PmpPayConst.getUdiID(PmpPayConst.CMBC_CHANNEL_CODE, PmpPayConst.CHANNEL_DOCLIST_ID));
		tra.setSd_chl(PmpPayConst.CMBC_CHANNEL_CODE);
		tra.setOrd_no(dto.getOrd_no());
		tra.setId_scene(PmpPayConst.getUdiID(reltrade.getSd_scene(), PmpPayConst.SCENE_DOCLIST_ID));
		tra.setSd_scene(reltrade.getSd_scene());
		tra.setBody(reltrade.getBody());
		tra.setSubject(reltrade.getSubject());
		tra.setDeviceinfo(dto.getDeviceinfo());
		tra.setTradetype(dto.getTradetype());
		tra.setStatus(DOStatus.NEW);
//		TradeDO[] tras=pmputils.getTradeRService().find(" Trade_no='"+code+"'", "", FBoolean.FALSE);
//		if(tras!=null&&tras.length>0)return null;
		TradeDO[] trs = pmputils.getTradeCUDService().save(new TradeDO[] { tra });
		if (trs != null && trs.length > 0)
			return trs[0];
		return null;
	}

}
