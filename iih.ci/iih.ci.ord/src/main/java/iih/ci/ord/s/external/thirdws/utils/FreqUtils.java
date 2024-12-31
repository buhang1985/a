package iih.ci.ord.s.external.thirdws.utils;

import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.i.IFreqdefMDORService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class FreqUtils {
	/**
	 * 查询频次
	 * @param freqcode
	 * @return
	 * @throws BizException
	 */
	public static FreqDefDO getFreqDOByCode(String freqcode) throws BizException{
		IFreqdefMDORService service = ServiceFinder.find(IFreqdefMDORService.class);
		FreqDefDO[] freqs = service.findByAttrValString(FreqDefDO.CODE, freqcode);
		if(freqs!=null && freqs.length > 0){
			return freqs[0];
		}
		return null;
	}
}
