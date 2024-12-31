package iih.bd.fc.s.bp.wfexdept;

import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

public class GetOrExDepValidationBp {

	/**
	 * 取医嘱执行科室列表校验
	 * 
	 * @param param
	 * @return
	 */
	public boolean exec(OrWfExDeptParamDTO[] params) throws BizException {
		if (params != null && params.length > 0) {
			for (OrWfExDeptParamDTO param : params) {
				if (param == null)
					return false;
				// 就诊类型
				if (StringUtil.isEmpty(param.getCode_entp()))
					throw new BizException("医嘱流向匹配：就诊类型空异常！");
				// 服务类型
				if (StringUtil.isEmpty(param.getSd_srvtp()))
					throw new BizException("医嘱流向匹配：服务类型空异常！");
				// 服务类型
				if (param.getEu_wftp() == null)
					throw new BizException("医嘱流向匹配：流向类型空异常！");
			}
			return true;
		}
		return false;
	}
}
