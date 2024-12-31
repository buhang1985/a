package iih.ci.ord.s.ems.itf.bp;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import xap.mw.core.data.BizException;

/**
 * 医疗单保存业务逻辑
 * 
 * @author wangqingzhu
 *
 */
public interface IEmsSaveBP {
	/**
	 * 保存医疗单
	 * 
	 * @param ems
	 * @return
	 */
	public abstract  EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] ems) throws BizException;
}
