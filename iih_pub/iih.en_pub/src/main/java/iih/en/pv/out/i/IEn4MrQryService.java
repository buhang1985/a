package iih.en.pv.out.i;

import iih.en.pv.out.mr.d.EnTransDeptFlowDTO;
import xap.mw.core.data.BizException;

/**
 * 就诊对MR提供查询接口
 * 
 * @author liubin
 *
 */
public interface IEn4MrQryService extends IEn4CommQryService {
	/**
	 * 获取住院就诊转科流程记录
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public EnTransDeptFlowDTO[] getTransDeptFlows(String entId) throws BizException;
}
