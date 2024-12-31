package iih.ci.ord.s.ems.itf.bp;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import xap.mw.core.data.BizException;

/**
 * 医疗单加载业务逻辑
 * 
 * @author wangqingzhu
 *
 */
public interface IEmsLoadBP {

	/**
	 * 从医嘱加载医疗单
	 * 
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract EmsRstDTO[] load(CiEnContextDTO ctx, EmsLoadDTO[] args) throws BizException;
}
