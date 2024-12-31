package iih.mp.dg.i.external.provide;

import iih.mp.dg.dto.dgunchargedto.d.DgUnChargeDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

/**
 * 药品执行域提供给费用域服务接口
 * 
 * @author hao_wu 2018-8-1
 *
 */
public interface IMpDgBlService {

	/**
	 * 查询未记账费用列表
	 * 
	 * @param orIds
	 *            医嘱主键
	 * @param beginTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return
	 * @throws BizException
	 */
	public abstract DgUnChargeDTO[] findUnChargeList(String[] orIds, FDateTime beginTime, FDateTime endTime)
			throws BizException;
	
	/**
	 * 查询急诊留观未记账费用列表
	 * 
	 * @param orIds
	 *            医嘱主键
	 * @param beginTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return
	 * @throws BizException
	 */
	public abstract DgUnChargeDTO[] findEtUnChargeList(String[] orIds, FDateTime beginTime, FDateTime endTime)
			throws BizException;
}
