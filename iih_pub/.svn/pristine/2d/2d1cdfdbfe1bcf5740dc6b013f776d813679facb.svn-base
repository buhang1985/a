package iih.bd.fc.que.i;

import iih.bd.fc.que.d.QueDO;
import xap.mw.core.data.BizException;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 药房队列服务
 * 
 * @author hao_wu
 *
 */
public interface IQuePharmacyService {
	/**
	 * 查询药房科室下的队列，存在返回队列DO，不存在创建队列DO
	 */
	public abstract QueDO getPharmacyQue(DeptDO deptDO) throws BizException;

	/**
	 * 根据药房科室主键查询药房队列信息
	 * 
	 * @param depId 药房科室主键
	 * @return 药房队列信息
	 * @throws BizException
	 */
	public abstract QueDO findPharmacyQueByDepId(String depId) throws BizException;
}
