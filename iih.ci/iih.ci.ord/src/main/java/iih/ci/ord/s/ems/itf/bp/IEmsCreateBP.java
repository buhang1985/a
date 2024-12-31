package iih.ci.ord.s.ems.itf.bp;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import xap.mw.core.data.BizException;

/**
 * 医疗单新建业务逻辑
 * 
 * @author wangqingzhu
 *
 */
public interface IEmsCreateBP {
	/**
	 * 创建医疗单UI对象
	 * 
	 * @param ems
	 * @return
	 */
	public abstract EmsRstDTO[] create(CiEnContextDTO ctx, EmsCrtDTO[] ems) throws BizException;

}
