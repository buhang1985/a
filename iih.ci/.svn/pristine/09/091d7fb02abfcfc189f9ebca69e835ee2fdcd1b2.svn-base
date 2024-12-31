package iih.ci.ord.s.ems;

import iih.bd.base.cache.ContextCache;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ems.ICiCacheClearMainService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

@Service(serviceInterfaces = { ICiCacheClearMainService.class }, binding = Binding.JSONRPC)
public class CiCacheClearMainServiceImpl implements ICiCacheClearMainService {

	@Override
	public FBoolean ClearWithCtx(CiEnContextDTO ctx) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FBoolean ClearWithEntp(String entp) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FBoolean ClearWithType(String ct) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FBoolean ClearAll() throws BizException {
		// TODO Auto-generated method stub
		ContextCache.ClearAll();
		return FBoolean.TRUE;
	}

}
