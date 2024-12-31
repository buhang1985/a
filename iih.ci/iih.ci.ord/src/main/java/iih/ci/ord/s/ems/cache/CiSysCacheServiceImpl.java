package iih.ci.ord.s.ems.cache;

import iih.bd.base.cache.ContextCache;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.cache.ICiSysCacheService;
import iih.ci.ord.s.ems.base.BaseSysCacheService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

@Service(serviceInterfaces = { ICiSysCacheService.class }, binding = Binding.JSONRPC)
public class CiSysCacheServiceImpl extends BaseSysCacheService implements ICiSysCacheService{
	
	private BaseCacheAction orderListCacheAction = new OrderListCacheAction();

	private BaseCacheAction emsListCacheAction = new EmsListCacheAction();
	
	private BaseCacheAction diagListCacheAction = new DiagListCacheAction(); 
	
	private BaseCacheAction orTmplListCacheAction = new OrTmplListCacheAction();
	/**
	 * 二级缓存
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean prepareL2Cache(CiEnContextDTO ctx) throws BizException {
		
		orderListCacheAction.prepareCacheL2( ctx);
		emsListCacheAction.prepareCacheL2(ctx);
		diagListCacheAction.prepareCacheL2(ctx);
		orTmplListCacheAction.prepareCacheL2(ctx);
		BDTplInfoCache.Clear();
		return FBoolean.TRUE;
	}

	/**
	 * 三级缓存
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean prepareL3Cache(CiEnContextDTO ctx) throws BizException {
		
		// 缓存该就诊下的所有医嘱
		orderListCacheAction.prepareCacheL3( ctx);
		emsListCacheAction.prepareCacheL3( ctx);
		diagListCacheAction.prepareCacheL3(ctx);
		orTmplListCacheAction.prepareCacheL3(ctx);
		return FBoolean.TRUE;
	}

	@Override
	public FBoolean clearL1Cache(CiEnContextDTO ctx) throws BizException {
		ContextCache.ClearAll();
		return FBoolean.TRUE;
	}

	@Override
	public FBoolean clearL2Cache(CiEnContextDTO ctx) throws BizException {
		ContextCache.ClearAll();
		return FBoolean.TRUE;
	}

	@Override
	public FBoolean clearL3Cache(CiEnContextDTO ctx) throws BizException {
		ContextCache.ClearAll();
		return FBoolean.TRUE;
	}

	@Override
	public FBoolean clearCache(String cacheType, String keyword) throws BizException {
		ContextCache.ClearAll();
		return FBoolean.TRUE;
	}


}
