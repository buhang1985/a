package iih.ci.sdk.cache;

import java.util.List;

import iih.bd.base.cache.ContextCache;
import iih.bd.srv.freqdef.d.FreqTimeDO;
import iih.bd.srv.freqdef.i.IFreqTimeDORService;
import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 频次执行时刻缓存
 * @author wangqingzhu
 *
 */
public class BDFreqTimeInfoCache {
	public static String BDFreqTimeInfoCache_Key = "BDFreqTimeInfoCache_Key";
	public static String DefaultContext_ID = "@@@@";
	
	private BDFreqTimeInfoCache() {

	}
	
	public static FreqTimeDO[] GetFreqTimeInfos(String id_freq) throws BizException {
		List<FreqTimeDO> freqTimeList = ContextCache.Get(BDFreqTimeInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID, BDFreqTimeInfoCache_Key, id_freq);
		if(ObjectUtils.isEmpty(freqTimeList)) {
			FreqTimeDO[] szFreqTimeInfo = ServiceFinder.find(IFreqTimeDORService.class).find(String.format("%s='%s'", FreqTimeDO.ID_FREQ,id_freq), FreqTimeDO.SORTNO, FBoolean.FALSE);//.findByAttrValString(FreqTimeDO.ID_FREQ,id_freq);
			if(!ObjectUtils.isEmpty(szFreqTimeInfo)) {
				freqTimeList = ObjectUtils.asList(szFreqTimeInfo);
				ContextCache.Put(BDFreqTimeInfoCache.class.getSimpleName(), DefaultContext_ID, DefaultContext_ID, BDFreqTimeInfoCache_Key, id_freq,freqTimeList);
			}
		}
		
		return ObjectUtils.isEmpty(freqTimeList)?null: freqTimeList.toArray(new FreqTimeDO[] {} );
	}
	
	/**
	 * 清空频次缓存
	 */
	public static void Clear() {
		ContextCache.Clear(BDFreqTimeInfoCache.class.getSimpleName());
	}
}
