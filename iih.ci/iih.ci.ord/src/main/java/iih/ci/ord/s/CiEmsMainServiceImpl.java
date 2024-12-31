package iih.ci.ord.s;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiEmsMainService;
import iih.ci.ord.i.ip.ems.ICiIpEmsMainService;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.i.op.ems.ICiOpEmsMainService;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 
 * @author wangqingzhu
 *
 */
@Service(serviceInterfaces = { ICiEmsMainService.class }, binding = Binding.JSONRPC)
public class CiEmsMainServiceImpl implements ICiEmsMainService {

	@Override
	public EmsRstDTO[] create(CiEnContextDTO ctx, EmsCrtDTO[] szEms) throws BizException {
		
		return CiOrdUtils.isIpWf(ctx.getCode_entp())?ServiceFinder.find(ICiIpEmsMainService.class).create(ctx, szEms):
			ServiceFinder.find(ICiOpEmsMainService.class).create(ctx, szEms);
	}

	@Override
	public EmsRstDTO[] load(CiEnContextDTO ctx, EmsLoadDTO[] szEms) throws BizException {
		return CiOrdUtils.isIpWf(ctx.getCode_entp())?ServiceFinder.find(ICiIpEmsMainService.class).load(ctx, szEms):
			ServiceFinder.find(ICiOpEmsMainService.class).load(ctx, szEms);
	}

	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] szEms) throws BizException {
		return CiOrdUtils.isIpWf(ctx.getCode_entp())?ServiceFinder.find(ICiIpEmsMainService.class).save(ctx, szEms):
			ServiceFinder.find(ICiOpEmsMainService.class).save(ctx, szEms);
	}

	
}
