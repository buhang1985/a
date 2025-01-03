package iih.ci.ord.s.utils;

import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.util.biz.CiEnContextUtil;
import iih.ci.ord.s.ems.op.order.OrderSignBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 门诊简化版签署逻辑
 * @author zhangwq
 *
 */
public class OpSimpleOrderSignBP extends OrderSignBP {
	public OrderRstDTO sign(CiEnContextDTO ctx, String[] idors) throws BizException {
		ICiorderMDORService orderService = ServiceFinder.find(ICiorderMDORService.class);
		CiOrderDO[] ciors = orderService.findByBIds(idors, FBoolean.FALSE);
		return sign(ctx,ciors);
	}

	public OrderRstDTO sign(CiEnContextDTO ctx, CiOrderDO[] ciors) throws BizException {
		Context.get().setAttribute("CiEnContextDTO",ctx);
		FDateTime dt_cur = CiOrdAppUtils.getServerDateTime();
		return saveSignData(ciors, dt_cur, null);
	}
	public OrderRstDTO sign(CiEnContextDTO ctx, List<CiOrderDO> ciors) throws BizException {
		return sign(ctx, ciors.toArray(new CiOrderDO[0]));
	}
	public OrderRstDTO sign(String[] idors) throws BizException{
		ICiorderMDORService orderService = ServiceFinder.find(ICiorderMDORService.class);
		CiOrderDO[] ciors = orderService.findByBIds(idors, FBoolean.FALSE);
		if(ciors==null || ciors.length == 0){
			return null;
		}
		return sign(ciors);
	}
	public OrderRstDTO sign(CiOrderDO[] ciors) throws BizException {
		CiEnContextDTO ctx = CiEnContextUtil.getCiEnContext(ciors[0].getId_en());
		Context.get().setAttribute("CiEnContextDTO",ctx);
		FDateTime dt_cur = CiOrdAppUtils.getServerDateTime();
		return saveSignData(ciors, dt_cur, null);
	}
	public OrderRstDTO sign(List<CiOrderDO> ciors) throws BizException {
		return sign(ciors.toArray(new CiOrderDO[0]));
	}
}
