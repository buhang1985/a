package iih.ci.ord.i.op.ems;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import xap.mw.core.data.BizException;

/**
 * 医疗单主服务接口
 * 
 * @author wangqingzhu
 *
 */

public interface ICiOpEmsMainService {

	/**
	 * 创建医疗单UI对象
	 * 
	 * @param ems
	 * @return
	 */
	public abstract EmsRstDTO[] create(CiEnContextDTO ctx, EmsCrtDTO[] emsarray) throws BizException;

	/**
	 * 加载医疗单
	 * 
	 * @param ems
	 * @return
	 */
	public abstract EmsRstDTO[] load(CiEnContextDTO ctx, EmsLoadDTO[] emsarray) throws BizException;

	/**
	 * 保存医疗单
	 * 
	 * @param ems
	 * @return
	 */
	public abstract EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] ems) throws BizException;
}
