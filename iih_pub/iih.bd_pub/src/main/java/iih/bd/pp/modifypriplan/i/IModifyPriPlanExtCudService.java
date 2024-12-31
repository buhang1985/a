package iih.bd.pp.modifypriplan.i;

import iih.bd.pp.modifypriplan.d.ModifyPriPlanDO;
import xap.mw.core.data.BizException;

/**
 * 调价计划扩展服务
 * 
 * @author hao_wu 2019-3-26
 *
 */
public interface IModifyPriPlanExtCudService {

	/**
	 * 根据计划主键集合进行调价</br>
	 * 
	 * @param planIds
	 * @throws BizException
	 */
	public abstract void modifyPriceByIds(String[] planIds) throws BizException;

	/**
	 * 启用调价计划
	 * 
	 * @param modifyPriPlanDos
	 * @return
	 * @throws BizException
	 */
	public abstract ModifyPriPlanDO[] enable(ModifyPriPlanDO[] modifyPriPlanDos) throws BizException;

	/**
	 * 停用调价计划
	 * 
	 * @param modifyPriPlanDos
	 * @return
	 * @throws BizException
	 */
	public abstract ModifyPriPlanDO[] disable(ModifyPriPlanDO[] modifyPriPlanDos) throws BizException;
}
