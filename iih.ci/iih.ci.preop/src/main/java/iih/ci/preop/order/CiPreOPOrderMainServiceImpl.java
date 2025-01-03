package iih.ci.preop.order;

import java.util.List;

import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.ci.core.utils.ObjectUtils;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.preop.order.bp.OrderCancelBP;
import iih.ci.preop.order.bp.OrderDeleteBP;
import iih.ci.preop.order.bp.OrderLoadBP;
import iih.ci.preop.order.bp.OrderSignBP;
import iih.ci.preop.order.bp.assi.OrderSaveByAssiBP;
import iih.ci.preop.order.bp.assi.OrderSaveByOrtmplBP;
import iih.ci.preop.order.copy.OrderCopyAction;
import iih.ci.preop.order.d.OrderListViewDTO;
import iih.ci.type.StringList;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
 * 门诊预住院申请单逻辑服务实现
 * @author wangqingzhu
 *
 */
@Service(serviceInterfaces = { ICiPreOPOrderMainService.class }, binding = Binding.JSONRPC)
public class CiPreOPOrderMainServiceImpl implements ICiPreOPOrderMainService {

	@Override
	public OrderRstDTO load(CiEnContextDTO ctx, OrderOperateDTO param) throws BizException {
		// TODO 可能这个地方需要一些有效性验证处理
		
		return new OrderRstDTO(FBoolean.TRUE,new OrderLoadBP().exec(ctx.getId_en(), ctx.getCode_entp()));
	}

	@Override
	public OrderRstDTO sign(CiEnContextDTO ctx, OrderOperateDTO param) throws BizException {
		// TODO 入参有效性校验逻辑
		if(ObjectUtils.isEmpty(param) || ObjectUtils.isEmpty(param.getDocument())) {
			return new OrderRstDTO(FBoolean.FALSE,"没有给定所要签署的预住院申请遗嘱信息！");
		}
		
		// 解析参数中传递的预住院申请医嘱信息
		StringList tsOrderList = new StringList();
		for(Object objID : param.getDocument()) {
			tsOrderList.add(objID.toString());
		}
		return new OrderRstDTO(FBoolean.TRUE,new OrderSignBP().exec(ctx.getId_en(), ctx.getCode_entp(),tsOrderList.asArray()));
	}

	@Override
	public OrderRstDTO cancel(CiEnContextDTO ctx, OrderOperateDTO param) throws BizException {
		OrderCancelBP cancel = new OrderCancelBP();
		return cancel.exec(ctx.getId_en(), ctx.getCode_entp(), (String[])param.getDocument().toArray(new String[0]));
	}

	@Override
	public OrderRstDTO delete(CiEnContextDTO ctx, OrderOperateDTO param) throws BizException {
		OrderDeleteBP delete = new OrderDeleteBP();
		return delete.exec(ctx.getId_en(), ctx.getCode_entp(), (String[])param.getDocument().toArray(new String[0]));
	}

	@Override
	public OrderRstDTO copy(CiEnContextDTO ctx, OrderOperateDTO param) throws BizException {
		OrderCopyAction copy = new OrderCopyAction();
		return copy.copy(ctx, param);
	}

	@Override
	public OrderRstDTO saveMedSrv(CiEnContextDTO ctx, OrTplNItmDO[] ortplItemDO) throws BizException {
		OrderSaveByAssiBP save = new OrderSaveByAssiBP();
		return save.exec(ctx, ortplItemDO);
	}
	
	@Override
	public OrderRstDTO saveOrtmpl(CiEnContextDTO ctx, OrTplNItmDO[] ortplItemDO) throws BizException {
		OrderSaveByOrtmplBP save = new OrderSaveByOrtmplBP();
		return save.exec(ctx, ortplItemDO);
	}

}
