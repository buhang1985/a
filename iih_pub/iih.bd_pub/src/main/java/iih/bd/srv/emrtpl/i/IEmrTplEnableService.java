package iih.bd.srv.emrtpl.i;

import iih.bd.srv.emrtpl.d.EmrTplDO;
import xap.mw.core.data.BizException;

/**
 * 医疗记录模板启用服务
 * 
 * @author hao_wu
 *
 */
public interface IEmrTplEnableService {
	/**
	 * 启用医疗记录模板
	 * 
	 * @param emrTplDOs
	 *            医疗记录模板列表
	 * @return
	 * @throws BizException
	 */
	public abstract EmrTplDO[] Enable(EmrTplDO[] emrTplDOs) throws BizException;

	/**
	 * 停用医疗记录模板
	 * 
	 * @param EmrTplDOs
	 *            医疗记录模板列表
	 * @return
	 * @throws BizException
	 */
	public abstract EmrTplDO[] Disable(EmrTplDO[] emrTplDOs) throws BizException;
}
