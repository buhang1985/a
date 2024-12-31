package iih.ci.sdk.utils;

import org.apache.commons.lang3.StringUtils;

import iih.bd.srv.freqdef.d.FreqTimeDO;
import iih.ci.sdk.cache.BDFreqTimeInfoCache;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
/**
 * 医疗单工具类
 * @author Liuxiaoying
 *
 */
public class CiBizEmsUtils {


	/**
	 * 获取首日执行次数
	 * 
	 * @param id_freq
	 * @param dt_entry
	 * @return
	 * @throws BizException
	 */
	public static Integer getQuan_firday_mp(String id_freq, FDateTime dt_entry) throws BizException {
		if (StringUtils.isEmpty(id_freq) || dt_entry == null) {
			return 0;
		}
		FreqTimeDO[] freqTimeDOs = BDFreqTimeInfoCache.GetFreqTimeInfos(id_freq);
		if (ObjectUtils.isEmpty(freqTimeDOs )) {
			return 0;
		}
		Integer quan = 0;
		for(FreqTimeDO freqTime:freqTimeDOs){
			if (freqTime.getTime_mp().after(new FTime(dt_entry.getTime()))) {
				quan++;
			}
		}			
		return quan;
	}
}
