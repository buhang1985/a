package iih.sc.apt.s.bp;

import org.apache.commons.lang.ArrayUtils;

import iih.sc.scbd.i.IScBdQryService;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取渠道
 * @author yank
 *
 */
public class GetChannelByTpBP {
	/**
	 * 获取诊间渠道
	 * @param chlTp 渠道类型编码
	 * @return
	 * @throws BizException
	 */
	public SchedulechlDO exec(String chlTp) throws BizException{	
		IScBdQryService chlService = ServiceFinder.find(IScBdQryService.class);
		SchedulechlDO[] chlDOs = chlService.getChlByTp(chlTp);
		if(ArrayUtils.isNotEmpty(chlDOs)){
			return chlDOs[0];
		}
		return null;
	} 
}
