package iih.en.pv.out.bp.qry;

import iih.en.comm.ep.EntDiEP;
import iih.en.comm.util.EnErUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.entdi.d.EntDiDO;
import xap.mw.core.data.BizException;

/**
 * 
 * 
 * @author liubin
 *
 */
public class GetErPreEntDisBP {
	/**
	 * 获取前一次就诊的诊断信息
	 * 1.本次就诊没有前一次就诊，返回null
	 * 2.前一次就诊没有诊断，返回null
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public EntDiDO[] exec(String entId) throws BizException {
		String preId = EnErUtils.getPreEntId(entId);
		if(EnValidator.isEmpty(preId))
			return null;
		EntDiEP ep = new EntDiEP();
		return ep.getEntDiByEntId(preId);
	}
}
