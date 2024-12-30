package iih.sc.sch.s.ep;

import iih.sc.sch.scsch.d.ScSchEmpDO;
import iih.sc.sch.scsch.d.ScSchEnDO;
import iih.sc.sch.scsch.i.IScSchEmpDOCudService;
import iih.sc.sch.scsch.i.IScSchEnDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 排班人员EP
 * 
 * @author yank
 *
 */
public class ScSchEmpEP {
	
	/**
	 * 保存
	 * 
	 * @param schChlDOs 排班人员集合
	 * @throws BizException
	 */
	public ScSchEmpDO[] save(ScSchEmpDO[] schEmpDOs) throws BizException {
		if (ArrayUtil.isEmpty(schEmpDOs)) {
			return null;
		}
		IScSchEmpDOCudService empCudService = ServiceFinder.find(IScSchEmpDOCudService.class);
		return empCudService.save(schEmpDOs);
	}
}
