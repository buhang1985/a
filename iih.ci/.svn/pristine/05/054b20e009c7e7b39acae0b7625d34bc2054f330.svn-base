package iih.ci.ord.s.ems.base;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrderMainService;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.ems.itf.bp.IOrderCancelBP;
import iih.ci.ord.s.ems.itf.bp.IOrderCopyBP;
import iih.ci.ord.s.ems.itf.bp.IOrderDeleteBP;
import iih.ci.ord.s.ems.itf.bp.IOrderLoadBP;
import iih.ci.ord.s.ems.itf.bp.IOrderRevertBP;
import iih.ci.ord.s.ems.itf.bp.IOrderSaveAsBP;
import iih.ci.ord.s.ems.itf.bp.IOrderSignBP;
import xap.mw.core.data.BizException;

public class BaseOrderMainService  {
	private IOrderLoadBP orderLoadAction ;
	private IOrderSignBP orderSignAction ;
	private IOrderDeleteBP orderDeleteAction ;
	private IOrderRevertBP orderRevertAction ;
	private IOrderCancelBP orderCancelAction ;
	private IOrderCopyBP orderCopyAction ;
	private IOrderSaveAsBP orderSaveAsAction ;

	
	public IOrderLoadBP getOrderLoadAction() {
		return orderLoadAction;
	}

	public void setOrderLoadAction(IOrderLoadBP orderLoadAction) {
		this.orderLoadAction = orderLoadAction;
	}

	public IOrderSignBP getOrderSignAction() {
		return orderSignAction;
	}

	public void setOrderSignAction(IOrderSignBP orderSignAction) {
		this.orderSignAction = orderSignAction;
	}

	public IOrderDeleteBP getOrderDeleteAction() {
		return orderDeleteAction;
	}

	public void setOrderDeleteAction(IOrderDeleteBP orderDeleteAction) {
		this.orderDeleteAction = orderDeleteAction;
	}

	public IOrderRevertBP getOrderRevertAction() {
		return orderRevertAction;
	}

	public void setOrderRevertAction(IOrderRevertBP orderRevertAction) {
		this.orderRevertAction = orderRevertAction;
	}

	public IOrderCancelBP getOrderCancelAction() {
		return orderCancelAction;
	}

	public void setOrderCancelAction(IOrderCancelBP orderCancelAction) {
		this.orderCancelAction = orderCancelAction;
	}

	public IOrderCopyBP getOrderCopyAction() {
		return orderCopyAction;
	}

	public void setOrderCopyAction(IOrderCopyBP orderCopyAction) {
		this.orderCopyAction = orderCopyAction;
	}

	public IOrderSaveAsBP getOrderSaveAsAction() {
		return orderSaveAsAction;
	}

	public void setOrderSaveAsAction(IOrderSaveAsBP orderSaveAsAction) {
		this.orderSaveAsAction = orderSaveAsAction;
	}

	
	public OrderRstDTO delete(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderDeleteAction.delete(ctx,arg);
	}

	
	public OrderRstDTO sign(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderSignAction.sign(ctx,arg);
	}

	
	public OrderRstDTO revert(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderRevertAction.revert(ctx,arg);
	}

	
	public OrderRstDTO cancel(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderCancelAction.cancel(ctx,arg);
	}

	
	public OrderRstDTO copy(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderCopyAction.copy(ctx,arg);
	}

	
	public OrderRstDTO saveAs(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderSaveAsAction.saveAs(ctx,arg);
	}

	
	public OrderRstDTO load(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderLoadAction.load(ctx,arg);
	}

	
	public OrderRstDTO revertcancel(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public OrderRstDTO stop(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public OrderRstDTO revertstop(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public OrderRstDTO reserchconfirm(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderRstDTO addExtra(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		return this.orderCopyAction.addExtra(ctx, arg);
	}
}
