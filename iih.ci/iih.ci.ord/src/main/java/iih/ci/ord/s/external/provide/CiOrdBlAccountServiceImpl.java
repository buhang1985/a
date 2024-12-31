package iih.ci.ord.s.external.provide;

import java.util.Map;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.external.provide.ICiOrdBlAccountService;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.external.bp.bl.account.AbstractCiOrdBlAccount;
import iih.ci.ord.s.external.bp.bl.account.ExecKeepAccountOrders;
import iih.ci.ord.s.external.bp.bl.account.KeepAccountOrdersFacotory;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;

public class CiOrdBlAccountServiceImpl implements ICiOrdBlAccountService {

	@Override
	public FMap isAllowedUseAccout(CiEnContextDTO ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public OrderRstDTO keepAccountOrders(CiEnContextDTO ctx, String[] id_ors) throws BizException {

		return this.getAccountService().keepAccountOrders(ctx, id_ors);
	}*/

	@Override
	public OrderRstDTO keepAccountOrders(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		KeepAccountOrdersFacotory factory = new KeepAccountOrdersFacotory();
		AbstractCiOrdBlAccount ciOrdBlAccount = factory.createExecInstance();
		return ciOrdBlAccount.keepAccountOrders(ctx, arg);
	}

	@Override
	public OrderRstDTO cancelAccoutOrders(CiEnContextDTO ctx, String[] id_ors) throws BizException {
		KeepAccountOrdersFacotory factory = new KeepAccountOrdersFacotory();
		AbstractCiOrdBlAccount ciOrdBlAccount = factory.createRefundInstance();
		return ciOrdBlAccount.cancelAccoutOrders(ctx, id_ors);
	}

	@Override
	public OrderRstDTO updateOrdersAccountSdSuBl(String id_en, Map<String, String> sdSuBlMap) {
		// TODO Auto-generated method stub
		return null;
	}

	private ICiOrdBlAccountService getAccountService() {
		
		return new ExecKeepAccountOrders();
	}

}
