package iih.sc.sch.s.ep;

import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchEnDO;
import iih.sc.sch.scsch.i.IScSchChlDOCudService;
import iih.sc.sch.scsch.i.IScSchEnDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 排班就诊EP
 * 
 * @author yank
 *
 */
public class SchEnEP {
	
	/**
	 * 保存
	 * 
	 * @param schChlDOs 排班就诊集合
	 * @throws BizException
	 */
	public ScSchEnDO[] save(ScSchEnDO[] schEnDOs) throws BizException {
		if (ArrayUtil.isEmpty(schEnDOs)) {
			return null;
		}
		IScSchEnDOCudService enCudService = ServiceFinder.find(IScSchEnDOCudService.class);
		return enCudService.save(schEnDOs);
	}

}
