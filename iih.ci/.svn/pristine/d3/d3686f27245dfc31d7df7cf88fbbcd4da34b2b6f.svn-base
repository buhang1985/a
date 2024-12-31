package iih.ci.ord.s.external.bp.bl.account;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.external.provide.meta.bl.OrderAccountDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 诊间划价记账
 * 
 * @author ZHANGWQ
 *
 */
public class DiagTreatKeepAccountOrders extends AbstractCiOrdBlAccount {

	@Override
	protected OrderAccountDTO isAllowedAccountOrders(CiEnContextDTO ctx, CiOrderDO order) {
		return null;
	}

	@Override
	public OrderRstDTO keepAccountOrders(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		OrderRstDTO orderRst = new OrderRstDTO();
		orderRst.setIsSuccess(FBoolean.FALSE);
		orderRst.setMessageInfo("诊间记账模式下，不允许在医生站记账！");
		return orderRst;
	}

	@Override
	protected OrderAccountDTO isAllowedRefoundOrders(CiEnContextDTO ctx, CiOrderDO order) {
		// TODO Auto-generated method stub
		return null;
	}
}
