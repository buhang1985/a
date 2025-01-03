package iih.ci.ord.s;

import iih.bd.base.cache.ContextCache;
import iih.bd.srv.medsrv.refs.sql.hptype.HptypeDisplay;
import iih.bd.srv.medsrv.refs.sql.ip.DrugCheckDisplayMd4IP;
import iih.bd.srv.medsrv.refs.sql.op.DrugCheckDisplayMd4OP;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.cache.ICiSysCacheService;
import iih.ci.ord.s.ems.base.BaseSysCacheService;
import iih.ci.ord.s.ems.cache.BDTplInfoCache;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

@Service(serviceInterfaces = { ICiSysCacheService.class }, binding = Binding.JSONRPC)
public class CiSysCacheServiceImpl extends BaseSysCacheService implements ICiSysCacheService{
	
	
	/**
	 * 二级缓存
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean prepareL2Cache(CiEnContextDTO ctx) throws BizException {
		
		
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
		
		return FBoolean.TRUE;
	}

	@Override
	public FBoolean clearL1Cache(CiEnContextDTO ctx) throws BizException {
		ContextCache.ClearAll();
		DrugCheckDisplayMd4IP.clear();
		DrugCheckDisplayMd4OP.clear();
		HptypeDisplay.clear();
		return FBoolean.TRUE;
	}

	@Override
	public FBoolean clearL2Cache(CiEnContextDTO ctx) throws BizException {
		ContextCache.ClearAll();
		DrugCheckDisplayMd4IP.clear();
		DrugCheckDisplayMd4OP.clear();
		HptypeDisplay.clear();
		return FBoolean.TRUE;
	}

	@Override
	public FBoolean clearL3Cache(CiEnContextDTO ctx) throws BizException {
		ContextCache.ClearAll();
		DrugCheckDisplayMd4IP.clear();
		DrugCheckDisplayMd4OP.clear();
		HptypeDisplay.clear();
		BDTplInfoCache.Clear();
		return FBoolean.TRUE;
	}

	@Override
	public FBoolean clearCache(String cacheType, String keyword) throws BizException {
		ContextCache.ClearAll();
		return FBoolean.TRUE;
	}


}
