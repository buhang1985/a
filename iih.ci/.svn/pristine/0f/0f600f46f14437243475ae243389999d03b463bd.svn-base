package iih.ci.ord.s.ems.base;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.i.op.order.ICiOrderMainService;
import iih.ci.ord.s.ems.op.order.OrderCancelService;
import iih.ci.ord.s.ems.op.order.OrderCopyService;
import iih.ci.ord.s.ems.op.order.OrderDeleteService;
import iih.ci.ord.s.ems.op.order.OrderLoadService;
import iih.ci.ord.s.ems.op.order.OrderRevertService;
import iih.ci.ord.s.ems.op.order.OrderSaveAsService;
import iih.ci.ord.s.ems.op.order.OrderSignService;
import xap.mw.core.data.BizException;

public class BaseCiOrderMainService implements ICiOrderMainService {
	private OrderLoadService orderLoadService = new OrderLoadService();
	private OrderSignService orderSignService =  new OrderSignService();
	private OrderDeleteService orderDeleteService = new OrderDeleteService();
	private OrderRevertService orderRevertService = new OrderRevertService();
	private OrderCancelService orderCancelService = new OrderCancelService();
	private OrderCopyService orderCopyService = new OrderCopyService();
	private OrderSaveAsService orderSaveAsService = new OrderSaveAsService();

	@Override
	public OrderRstDTO delete(CiEnContextDTO ctx ,OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderDeleteService.delete(ctx,arg);
	}

	@Override
	public OrderRstDTO sign(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderSignService.sign(ctx, arg);
	}

	@Override
	public OrderRstDTO revert(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderRevertService.revert(ctx, arg);
	}

	@Override
	public OrderRstDTO cancel(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderCancelService.cancel(ctx, arg);
	}

	@Override
	public OrderRstDTO copy(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderCopyService.copy(ctx, arg);
	}

	@Override
	public OrderRstDTO saveAs(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderSaveAsService.saveAs(ctx, arg);
	}

	@Override
	public OrderRstDTO load(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return orderLoadService.load(ctx, arg);
	}	

	@Override
	public OrderRstDTO recoverPres(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}
	
  @Override
  public OrderRstDTO addExtra(CiEnContextDTO ctx, OrderOperateDTO arg)throws BizException{
		
	  return orderCopyService.addExtra(ctx, arg);

	}

@Override
public OrderRstDTO deleteCancel(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public OrderRstDTO deleteRevert(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public OrderRstDTO deleteHBI(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
	// TODO Auto-generated method stub
	return null;
}

@Override
public OrderRstDTO cancelCopy(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
	// TODO Auto-generated method stub
	return null;
}
}
