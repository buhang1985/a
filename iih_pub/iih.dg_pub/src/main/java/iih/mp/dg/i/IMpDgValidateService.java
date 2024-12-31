package iih.mp.dg.i;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 执行域药品模块校验服务
 * @author ly 2017/10/14
 *
 */
public interface IMpDgValidateService {

	/**
	 * 判断站点是否有没发药的处方
	 * 如果没有需要处理的发药处方则可以删除
	 * @param quesiteId
	 * @return 判断结果
	 * @throws BizException
	 */
	public abstract FBoolean ifSiteHasUnDispPres(String quesiteId) throws BizException;
	
	/**
	 * 判断医嘱是否进行过输液(门诊)
	 * 传入医嘱中，只要有一个医嘱已经输液执行过，则返回true
	 * @param idOrs 医嘱数组
	 * @return 判断结果
	 * @throws BizException
	 */
	public abstract FBoolean ifOpInfuHasExecuted(String[] idOrs) throws BizException;
	
}
