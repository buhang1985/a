package iih.mp.ot.params;

import iih.bd.utils.ParamUtils;
import iih.mp.ot.params.constdef.MpOtParamCodeConst;
import xap.mw.core.data.BizException;

/**
 * MpOt参数工具类
 * @author guoyang
 *
 */
public class MpOtParamUtils {

	/**
	 * 获取门诊执行点记账是否可销账参数
	 * @return
	 * @throws BizException
	 */
	public static Integer getExecPointRefund() throws BizException {
		Integer execPointRefund = ParamUtils.GetOrgParamIntegerValue(MpOtParamCodeConst.MPOT0003);
		return execPointRefund;
	}
}
