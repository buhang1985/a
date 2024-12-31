package iih.ci.ord.s.ems.op.pres;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.PresLoadDTO;
import iih.ci.ord.i.meta.PresRstDTO;
import iih.ci.ord.i.meta.PresSplDTO;
import iih.ci.ord.i.op.pres.ICiPresListMainService;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 处方相关操作主服务
 * 
 * @author wangqingzhu
 *
 */
@Service(serviceInterfaces = { ICiPresListMainService.class }, binding = Binding.JSONRPC)
public class CiPresListMainServiceImpl implements ICiPresListMainService {

	@Override
	public PresRstDTO load(CiEnContextDTO ctx, PresLoadDTO ld) throws BizException {
		// 是否为门急诊就诊
		if (CiOrdUtils.isOpUrgentWf(ctx.getCode_entp())) {
			return new PresListAction().load(ctx, ld);
		}
		// 是否为住院就诊
		else if (CiOrdUtils.isIpWf(ctx.getCode_entp())) {
			return null;
		}
		return null;
	}

	@Override
	public PresRstDTO reSeparate(CiEnContextDTO ctx, PresSplDTO ld) throws BizException {
		// 是否为门急诊就诊
		if (CiOrdUtils.isOpUrgentWf(ctx.getCode_entp())) {
			return new PresListAction().reSeparate(ctx, ld);
		}
		return null;
	}

}
