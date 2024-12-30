package iih.sc.sch.s.ep;

import iih.sc.sch.scsch.d.ScSchOptsrvDO;
import iih.sc.sch.scsch.i.IScSchOptsrvDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 备用服务EP
 * @author ltf
 *
 */
public class ScSchOptSrvEP {
	/**
	 * 保存
	 * 
	 * @param schChlDOs 排班人员集合
	 * @throws BizException
	 */
	public ScSchOptsrvDO[] save(ScSchOptsrvDO[] scSchOptsrvDOs) throws BizException {
		if (ArrayUtil.isEmpty(scSchOptsrvDOs)) {
			return null;
		}
		IScSchOptsrvDOCudService scSchOptsrvService= ServiceFinder.find(IScSchOptsrvDOCudService.class);
		return scSchOptsrvService.save(scSchOptsrvDOs);
	}
}
