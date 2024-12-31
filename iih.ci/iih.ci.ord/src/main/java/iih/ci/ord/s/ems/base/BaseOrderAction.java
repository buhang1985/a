package iih.ci.ord.s.ems.base;

import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.itf.IOrderAction;
import iih.ci.ord.s.ems.itf.bp.IOrderCopyBP;
import iih.ci.ord.s.ems.itf.bp.IOrderDeleteBP;
import iih.ci.ord.s.ems.itf.bp.IOrderLoadBP;
import iih.ci.ord.s.ems.itf.bp.IOrderRevertBP;
import iih.ci.ord.s.ems.itf.bp.IOrderSaveAsBP;
import iih.ci.ord.s.ems.itf.bp.IOrderSaveFeeBP;
import iih.ci.ord.s.ems.itf.bp.IOrderSignBP;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 
 * @author wangqingzhu
 *
 */
public class BaseOrderAction implements IOrderAction {
	private IOrderLoadBP orderLoadBP;
	private IOrderSignBP orderSignBP;
	private IOrderDeleteBP orderDeleteBP;
	private IOrderRevertBP orderRevertBP;
	private IOrderSaveAsBP orderSaveAsBP;
	private IOrderCopyBP orderCopyBP;
	private IOrderSaveFeeBP orderSaveFeeBP;

	public IOrderLoadBP getOrderLoadBP() {
		return orderLoadBP;
	}

	public void setOrderLoadBP(IOrderLoadBP orderLoadBP) {
		this.orderLoadBP = orderLoadBP;
	}

	public IOrderSignBP getOrderSignBP() {
		return orderSignBP;
	}

	public void setOrderSignBP(IOrderSignBP orderSignBP) {
		this.orderSignBP = orderSignBP;
	}

	public IOrderDeleteBP getOrderDeleteBP() {
		return orderDeleteBP;
	}

	public void setOrderDeleteBP(IOrderDeleteBP orderDeleteBP) {
		this.orderDeleteBP = orderDeleteBP;
	}

	public IOrderRevertBP getOrderRevertBP() {
		return orderRevertBP;
	}

	public void setOrderRevertBP(IOrderRevertBP orderRevertBP) {
		this.orderRevertBP = orderRevertBP;
	}

	public IOrderSaveAsBP getOrderSaveAsBP() {
		return orderSaveAsBP;
	}

	public void setOrderSaveAsBP(IOrderSaveAsBP orderSaveAsBP) {
		this.orderSaveAsBP = orderSaveAsBP;
	}

	public IOrderCopyBP getOrderCopyBP() {
		return orderCopyBP;
	}

	public void setOrderCopyBP(IOrderCopyBP orderCopyBP) {
		this.orderCopyBP = orderCopyBP;
	}

	public IOrderSaveFeeBP getOrderSaveFeeBP() {
		return orderSaveFeeBP;
	}

	public void setOrderSaveFeeBP(IOrderSaveFeeBP orderSaveFeeBP) {
		this.orderSaveFeeBP = orderSaveFeeBP;
	}

	@Override
	public OrderRstDTO load(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderLoadBP.load(ctx, arg);
	}

	/**
	 * 查询 MedSrvAggDO对象结构
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	protected MedsrvAggDO queryMedSrvAggInfo(String id_srv) throws BizException {
		return ServiceFinder.find(IMedsrvRService.class).findById(id_srv);
	}

	@Override
	public OrderRstDTO delete(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderDeleteBP.delete(ctx, arg);
	}

	@Override
	public OrderRstDTO sign(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderSignBP.sign(ctx, arg);
	}

	@Override
	public OrderRstDTO revert(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderRevertBP.revert(ctx, arg);
	}

	@Override
	public OrderRstDTO copy(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderCopyBP.copy(ctx, arg);
	}

	@Override
	public OrderRstDTO saveAs(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderSaveAsBP.saveAs(ctx, arg);
	}

	@Override
	public OrderRstDTO cancel(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderRstDTO stop(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderRstDTO addExtra(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderCopyBP.addExtra(ctx, arg);
	}

}
