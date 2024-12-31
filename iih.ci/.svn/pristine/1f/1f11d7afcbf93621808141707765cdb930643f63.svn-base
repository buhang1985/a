package iih.ci.ord.s.ems.op.order;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.i.op.order.ICiOpOrderMainService;
import iih.ci.ord.s.ems.base.BaseOrderMainService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 医嘱相关主服务
 * 
 * @author wangqingzhu
 *
 */
@Service(serviceInterfaces = { ICiOpOrderMainService.class }, binding = Binding.JSONRPC)
public class CiOpOrderMainServiceImpl extends BaseOrderMainService implements ICiOpOrderMainService {
	public CiOpOrderMainServiceImpl() {

		setOrderLoadAction(new OrderLoadAction());
		setOrderSignAction(new OrderSignAction());
		setOrderDeleteAction(new OrderDeleteAction());
		setOrderRevertAction(new OrderRevertAction());
		setOrderCancelAction(new OrderCancelAction());
		setOrderCopyAction(new OrderCopyAction());
		setOrderSaveAsAction(new OrderSaveAsAction());

	}
	
	

	@Override
	public OrderRstDTO load(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return super.load(ctx, arg);
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



	@Override
	public OrderRstDTO recoverPres(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
