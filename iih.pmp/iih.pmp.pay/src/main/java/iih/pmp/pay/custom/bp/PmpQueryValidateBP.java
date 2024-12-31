package iih.pmp.pay.custom.bp;

import iih.pmp.pay.custom.i.IPmpDataconvert;
import iih.pmp.pay.custom.i.IPmpSdk;
import iih.pmp.pay.ord.d.OrdDO;
import iih.pmp.pay.ordqryrstdto.d.OrdQryRstDTO;
import iih.pmp.pay.ordreqdto.d.OrdReqDTO;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.d.TradeStatusEnum;
import iih.pmp.pay.util.PmpPayAppBaseUtils;
import iih.pmp.pay.util.WXPayAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

public class PmpQueryValidateBP {

	PmpValidateBP bp;
	PmpPayAppBaseUtils pmputils = new PmpPayAppBaseUtils();
	WXPayAppUtils utils = new WXPayAppUtils();

	public PmpQueryValidateBP(IPmpSdk pay1, IPmpDataconvert dataconvert1) {
		bp = new PmpValidateBP(pay1, dataconvert1);
	}

	/**
	 * 查询订单状态，刷卡支付时，有轮询机制
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public OrdDO[] getOrdsInfo_new2(OrdReqDTO dto, OrdQryRstDTO rst) throws BizException {
		if ((dto.getOrd_no() == null && dto.getId_pat() == null))
			throw new BizException("外部订单号和患者id都为空！");
		boolean flag = false;
		OrdDO[] ords = pmputils.getOrdRService().find(this.getCondition(dto), "dt_ord desc", FBoolean.FALSE);

		if (ords == null || ords.length == 0)
			throw new BizException("当前账户没有此订单：" + dto.getOrd_no());
		if (ords.length > 1) {
			return ords;
		}
		flag = bp.validateOrd(ords[0], dto, rst);
		if (flag) {
			flag = this.queryTrade(dto, ords[0], rst);
		}

		// 更新订单状态
		OrdDO ords2 = utils.updateOrdStatus(ords[0]);

		return new OrdDO[] { ords2 };
	}

	/**
	 * 查询订单状态，刷卡支付时，有轮询机制
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public OrdDO[] getOrdsInfo_new(OrdReqDTO dto, OrdQryRstDTO rst) throws BizException {

		boolean flag = false;
//		OrdDO[] ords = pmputils.getOrdRService().find(
//				" ord_no='" + dto.getOrd_no() + "' and id_emp_op='" + pmputils.getId_Stuff(dto.getId_user_req()) + "' ",
//				null, FBoolean.FALSE);

		OrdDO[] ords = pmputils.getOrdRService().findByAttrValString(OrdDO.ORD_NO, dto.getOrd_no());

		if (ords == null || ords.length == 0 || ords.length > 1)
			throw new BizException("当前账户没有此订单或对应多个订单：" + dto.getOrd_no());
		if (!dto.getSd_chl().equals(ords[0].getSd_chl())) {
			throw new BizException("传入的渠道不正确！");
		}
		flag = bp.validateOrd(ords[0], dto, rst);
		if (flag) {
			flag = this.queryTrade(dto, ords[0], rst);
		}

		// 更新订单状态
		OrdDO ords2 = utils.updateOrdStatus(ords[0]);

		return new OrdDO[] { ords2 };
	}

	/**
	 * 查询订单状态，刷卡支付时，有轮询机制
	 * 
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public OrdDO[] getOrdsInfo_new3(OrdReqDTO dto, OrdQryRstDTO rst) throws BizException {

		boolean flag = false;
//		OrdDO[] ords = pmputils.getOrdRService().find(
//				" ord_no='" + dto.getOrd_no() + "' and id_emp_op='" + pmputils.getId_Stuff(dto.getId_user_req()) + "'",
//				null, FBoolean.FALSE);
		OrdDO[] ords = pmputils.getOrdRService().findByAttrValString(OrdDO.ORD_NO, dto.getOrd_no());

		if (ords == null || ords.length == 0 || ords.length > 1)
			return null;
		flag = bp.validateOrd(ords[0], dto, rst);
		if (flag) {
			flag = this.queryTrade(dto, ords[0], rst);
		}

		// 更新订单状态
		OrdDO ords2 = utils.updateOrdStatus(ords[0]);

		return new OrdDO[] { ords2 };
	}

	private boolean queryTrade(OrdReqDTO dto, OrdDO ordDO, OrdQryRstDTO rst) throws BizException {

		boolean flag = true;
		TradeDO[] tras = pmputils.getTradeDO8ord(ordDO);
		if (tras != null && tras.length > 0) {
			// 查询交易表订单当前状态 todo
			for (TradeDO t : tras) {
				flag = bp.tradevalidate(t, ordDO, dto, rst);

				if (!flag) {
					rst.setTrade_no(t.getTrade_no());
					rst.setTradetime(t.getDt_req());
					rst.setBankorderno(t.getBankorderno());
					rst.setTrade_no_chl(t.getTrade_no_chl());
					rst.setBanktradeno(t.getBanktradeno());
					rst.setMch_order_no(t.getSd_ord());
					rst.setTradetype(t.getTradetype());
					rst.setTrade_status(t.getTrade_status());
					break;
				}

			}

			if (flag) {
				rst.setTrade_status(TradeStatusEnum.PAY_FAIL);
			}

			pmputils.getTradeCUDService().save(tras);
		}
		return flag;

	}

	private String getCondition(OrdReqDTO dto) {
		StringBuilder sb = new StringBuilder();
		if (dto.getOrd_no() != null) {
			sb.append(" ord_no='" + dto.getOrd_no() + "'");
		}
		if (dto.getId_pat() != null) {
			if (sb.length() > 0)
				sb.append(" and ");
			sb.append(" id_pat='" + dto.getId_pat() + "'");
		}
//		if (dto.getFg_operator() != null && dto.getFg_operator().booleanValue()) {
//			if (sb.length() > 0)
//				sb.append(" and ");
//			sb.append(" id_emp_op='" + pmputils.getId_Stuff(dto.getId_user_req()) + "'");
//		}
		FDateTime dt = pmputils.getServerDateTime();
		String dtend = pmputils.getTransDate(dt.getDate().getDateBefore(2), "yyyy-MM-dd");
		if (sb.length() > 0)
			sb.append(" and ");
		sb.append(" dt_ord>='" + dtend + "'");
		return sb.toString();
	}

}
