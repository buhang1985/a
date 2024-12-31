package iih.ci.ord.s;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrderMainService;
import iih.ci.ord.i.ip.order.ICiIpOrderMainService;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.i.op.order.ICiOpOrderMainService;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 医嘱相关主服务
 * @author wangqingzhu
 *
 */
@Service(serviceInterfaces = { ICiOrderMainService.class }, binding = Binding.JSONRPC)
public class CiOrderMainServiceImpl implements ICiOrderMainService {

	@Override
	public OrderRstDTO load(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		return CiOrdUtils.isIpWf(ctx.getCode_entp())?ServiceFinder.find(ICiIpOrderMainService.class).load(ctx, arg):
			ServiceFinder.find(ICiOpOrderMainService.class).load(ctx,arg);
	}

	@Override
	public OrderRstDTO delete(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		
		return CiOrdUtils.isIpWf(ctx.getCode_entp())?ServiceFinder.find(ICiIpOrderMainService.class).delete(ctx, arg):
			ServiceFinder.find(ICiOpOrderMainService.class).delete(ctx,arg);
	}

	@Override
	public OrderRstDTO sign(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		return CiOrdUtils.isIpWf(ctx.getCode_entp())?ServiceFinder.find(ICiIpOrderMainService.class).sign(ctx, arg):
			ServiceFinder.find(ICiOpOrderMainService.class).sign(ctx,arg);
	}

	@Override
	public OrderRstDTO revert(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return CiOrdUtils.isIpWf(ctx.getCode_entp())?ServiceFinder.find(ICiIpOrderMainService.class).revert(ctx, arg):
			ServiceFinder.find(ICiOpOrderMainService.class).revert(ctx,arg);
	}

	@Override
	public OrderRstDTO cancel(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return CiOrdUtils.isIpWf(ctx.getCode_entp())?ServiceFinder.find(ICiIpOrderMainService.class).cancel(ctx, arg):
			ServiceFinder.find(ICiOpOrderMainService.class).cancel(ctx,arg);
	}

	@Override
	public OrderRstDTO copy(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		return CiOrdUtils.isIpWf(ctx.getCode_entp())?ServiceFinder.find(ICiIpOrderMainService.class).copy(ctx, arg):
			ServiceFinder.find(ICiOpOrderMainService.class).copy(ctx,arg);
	}

	@Override
	public OrderRstDTO saveAs(CiEnContextDTO ctx,OrderOperateDTO arg) throws BizException {
		return CiOrdUtils.isIpWf(arg.getEnContext().getCode_entp())?ServiceFinder.find(ICiIpOrderMainService.class).saveAs(ctx, arg):
			ServiceFinder.find(ICiOpOrderMainService.class).saveAs(ctx,arg);
	}

	@Override
	public OrderRstDTO revertcancel(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {

		return CiOrdUtils.isIpWf(ctx.getCode_entp())?ServiceFinder.find(ICiIpOrderMainService.class).revertcancel(ctx, arg):
			ServiceFinder.find(ICiOpOrderMainService.class).revertcancel(ctx,arg);
	}

	@Override
	public OrderRstDTO stop(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {

		return CiOrdUtils.isIpWf(ctx.getCode_entp())?ServiceFinder.find(ICiIpOrderMainService.class).stop(ctx, arg):
			ServiceFinder.find(ICiOpOrderMainService.class).stop(ctx,arg);
	}

	@Override
	public OrderRstDTO revertstop(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {

		return CiOrdUtils.isIpWf(ctx.getCode_entp())?ServiceFinder.find(ICiIpOrderMainService.class).revertstop(ctx, arg):
			ServiceFinder.find(ICiOpOrderMainService.class).revertstop(ctx,arg);
	}

	@Override
	public OrderRstDTO reserchconfirm(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		return CiOrdUtils.isIpWf(ctx.getCode_entp())?ServiceFinder.find(ICiIpOrderMainService.class).reserchconfirm(ctx, arg):
			ServiceFinder.find(ICiOpOrderMainService.class).reserchconfirm(ctx,arg);
	}

	@Override
	public OrderRstDTO addExtra(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {
		return CiOrdUtils.isIpWf(ctx.getCode_entp())?ServiceFinder.find(ICiIpOrderMainService.class).addExtra(ctx, arg):
			null;
	}
	
}
