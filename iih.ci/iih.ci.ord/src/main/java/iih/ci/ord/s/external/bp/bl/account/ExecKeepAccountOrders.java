package iih.ci.ord.s.external.bp.bl.account;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.external.provide.meta.bl.OrderAccountDTO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 执行记账
 * 
 * @author HUMS
 *
 */
public class ExecKeepAccountOrders extends AbstractCiOrdBlAccount {

	@Override
	protected OrderAccountDTO isAllowedAccountOrders(CiEnContextDTO ctx, CiOrderDO order) {

		String msgInfo = order.getName_or() + "[" + order.getCode_or() + "]";
		OrderAccountDTO orderAccount = new OrderAccountDTO();
		orderAccount.setFg_allowed_account(FBoolean.FALSE);
		orderAccount.setId_or(order.getId_or());

		// 判断签署状态
		if (!FBoolean.TRUE.equals(order.getFg_sign())) {
			orderAccount.setMessageInfo(msgInfo + "未签署，不支持记账！");
			return orderAccount;
		}

		if (!ctx.getId_psndoc().equals(order.getId_emp_sign())) {
			orderAccount.setMessageInfo(msgInfo + "非本人签署，不支持记账！");
			return orderAccount;
		}

		// 判断药品类型，执行记账不支持药品记账
		if (order.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
			orderAccount.setMessageInfo(msgInfo + "是药品服务，不支持记账！");
			return orderAccount;
		}
		
		// 自定义医嘱类型，不支持记账
		if (order.getSd_srvtp() != null && order.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_ENTRUST)) {
			orderAccount.setMessageInfo(msgInfo + "是嘱托与宣教类服务，不支持记账！");
			return orderAccount;
		}

		// 执行科室非当前科室不支持记账
		if (!ctx.getId_dep_or().equals(order.getId_dep_mp())) {
			orderAccount.setMessageInfo(msgInfo + "执行科室非当前科室，不支持记账！");
			return orderAccount;
		}
		if (FBoolean.TRUE.equals(order.getFg_canc())) {
			orderAccount.setMessageInfo(msgInfo + "已经作废，不支持记账！");
			return orderAccount;
		}

		// 未记账才支持记账
		if (!ICiDictCodeConst.SD_SU_BL_NONE.equals(order.getSd_su_bl())) {
			orderAccount.setMessageInfo(msgInfo + "已经记账或退费，不支持记账！");
			return orderAccount;
		}

		orderAccount.setFg_allowed_account(FBoolean.TRUE);
		return orderAccount;
	}

	@Override
	protected OrderAccountDTO isAllowedRefoundOrders(CiEnContextDTO ctx, CiOrderDO order) {
		// TODO Auto-generated method stub
		return null;
	}
}