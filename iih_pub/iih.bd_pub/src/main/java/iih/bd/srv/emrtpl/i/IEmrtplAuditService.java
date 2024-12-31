package iih.bd.srv.emrtpl.i;

import iih.bd.srv.emrtpl.d.EmrTplDO;
import xap.mw.core.data.BizException;

/**
 * 病历模板审核服务接口
 * 
 * @author hao_wu
 *
 */
public interface IEmrtplAuditService {

	/**
	 * 通过
	 * 
	 * @param emrTplArray
	 * @return
	 * @throws BizException
	 */
	public abstract EmrTplDO[] Approve(EmrTplDO[] emrTplArray) throws BizException;

	/**
	 * 驳回
	 * 
	 * @param emrTplArray
	 * @return
	 * @throws BizException
	 */
	public abstract EmrTplDO[] Reject(EmrTplDO[] emrTplArray) throws BizException;

	/**
	 * 提交
	 * 
	 * @param emrTplArray
	 * @return
	 * @throws BizException
	 */
	public abstract EmrTplDO[] Submit(EmrTplDO[] emrTplArray) throws BizException;
	
	/**
	 * 取消提交
	 * 
	 * @param emrTplArray
	 * @return
	 * @throws BizException
	 */
	public abstract EmrTplDO[] CancelSubmit(EmrTplDO[] emrTplArray) throws BizException;

}
