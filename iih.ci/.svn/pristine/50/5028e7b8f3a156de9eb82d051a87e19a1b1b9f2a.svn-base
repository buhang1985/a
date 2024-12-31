package iih.ci.sdk.cache;

import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.bd.fc.ormatchorpltp.d.OrpltpMatchParamDTO;
import iih.bd.fc.orpltp.d.OrpltpDO;
import iih.ci.sdk.utils.CiOrdAppUtils;
import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.data.BizException;

/**
 * 医嘱闭环缓存
 * @author wangqingzhu
 *
 */
public class BDOrpltpmtParamCache {
	public static String BDOrpltpmtParamCache_Key = "BDOrpltpmtParamCache_Key";
	public static String DefaultContext_ID = "@@@@";

	private BDOrpltpmtParamCache() {
	}
	
	public static OrpltpDO[] GetOrpltpInfo(OrpltpMatchParamDTO param) throws BizException {
		
		List<OrpltpDO> orpltpList = ContextCache.Get(BDOrpltpmtParamCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID, "", param.serializeJson());
		if(ObjectUtils.isEmpty(orpltpList)) {
			OrpltpDO[] szOrpltpInfo = CiOrdAppUtils.getIOrpltpmtParaService().GetOrpltp(param);
			if(!ObjectUtils.isEmpty(szOrpltpInfo)) {
				ContextCache.Put(BDOrpltpmtParamCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID, "", param.serializeJson(),ObjectUtils.asList(szOrpltpInfo));
				
				return szOrpltpInfo;
			}
		}
		return ObjectUtils.isEmpty(orpltpList)?null : orpltpList.toArray(new OrpltpDO[] {});
	}
	
	public static void Clear() {
		ContextCache.Clear(BDOrpltpmtParamCache.class.getSimpleName());
	}
}
