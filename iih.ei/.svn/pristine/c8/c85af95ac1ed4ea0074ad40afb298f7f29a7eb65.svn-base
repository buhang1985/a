package iih.ei.bl.ecinc.util;

import iih.bl.comm.IBlFlowKeyConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;

/**
 * 流程上下文
 * @author ly 2020/01/17
 *
 */
public class FlowContextUtil {

	/**
	 * 获取操作人员
	 * @return
	 * @throws BizException
	 * @author ly 2020/01/17
	 */
	public static String getEmpId() throws BizException{
		String empId = Context.get().getStuffId();
		String flowEmpId = Context.get().getAttribute(IBlFlowKeyConst.BL_FLOW_KEY_ID_EMP, String.class);
		if(!StringUtil.isEmpty(flowEmpId)){
			empId = flowEmpId;
		}
		return empId;
	}
}
