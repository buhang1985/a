package iih.ci.sdk.ems.itf;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import xap.mw.core.data.BizException;

/**
 * 医疗单新建业务逻辑
 * @author wangqingzhu
 *
 */
public interface IEmsCreateBP extends IEmsBP {
	/**
	 * 创建医疗单UI对象
	 * @param ems
	 * @return
	 */
	public abstract EmsRstDTO[] create(CiEnContextDTO ctx, EmsCrtDTO[] szEms) throws BizException;
	
	/**
	 * 单体创建逻辑
	 * @param ctx
	 * @param arg
	 * @return
	 * @throws BizException
	 */
	public abstract EmsRstDTO create(CiEnContextDTO ctx, EmsCrtDTO arg) throws BizException;
	
}
