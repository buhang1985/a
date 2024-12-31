package iih.bd.res.i.external.provide;

import iih.bd.res.bizgrp.d.BizgrpAggDO;
import xap.mw.core.data.BizException;

/**
 * 提供给病历域查询服务接口
 * 
 * @author hao_wu 2020-1-9
 *
 */
public interface IBdResMrQryService {

	/**
	 * 根据人员主键查询所属业务组信息
	 * 
	 * @param psnId 人员主键
	 * @return 询所属业务组信息
	 * @throws BizException
	 */
	public abstract BizgrpAggDO[] findBizGrpByPsnId(String psnId) throws BizException;
}
