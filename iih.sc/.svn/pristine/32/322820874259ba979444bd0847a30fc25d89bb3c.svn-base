package iih.sc.apt.s.bp.mt;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.sc.comm.ScParamUtils;
import iih.sc.comm.ScValidator;
import xap.mw.core.data.BizException;

/**
 * 获取医技预约费用检查参数BP
 * 
 * @author zhengcm
 * @date 2017-04-12 19:09:35
 *
 */
public class GetMtAptCheckFeeParamBP {

	/**
	 * 获取医技预约费用检查参数对应的检查费用记账状态编码
	 *
	 * @param deptId
	 * @return
	 * @throws BizException
	 * @author zhengcm
	 */
	public String[] exec(String deptId) throws BizException {
		// 检查参数
		ScValidator.validateParam("deptId", deptId);
		// 获取医技预约费用检查参数
		boolean isCheckFee = ScParamUtils.getScAptMtChkFee(deptId);
		// 如果参数设置为True， 则只显示记账的，否则显示未记账和已记账
		if (isCheckFee) {
			return new String[] { ICiDictCodeConst.SD_SU_BL_ACCOUNT };
		} else {
			return new String[] { ICiDictCodeConst.SD_SU_BL_NONE, ICiDictCodeConst.SD_SU_BL_ACCOUNT };
		}
	}

}
