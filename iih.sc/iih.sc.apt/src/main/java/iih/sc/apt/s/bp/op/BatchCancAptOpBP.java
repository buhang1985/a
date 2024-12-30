package iih.sc.apt.s.bp.op;

import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.s.bp.CancelAptTimeCheckBP;
import iih.sc.apt.s.bp.oral.BreakOralAptBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;

/**
 * 批量取消门诊预约BP
 * 
 * @author zhengcm
 * @date 2017-11-13 19:55:10
 *
 */
public class BatchCancAptOpBP {

	/**
	 * 批量取消门诊预约
	 *
	 * @author zhengcm
	 * 
	 * @param aptDTOs
	 * @throws BizException
	 */
	public void exec(OpAptDTO[] aptDTOs) throws BizException {
		if (ArrayUtil.isEmpty(aptDTOs)) {
			return;
		}
		for (OpAptDTO aptDTO : aptDTOs) {
			// 预约取消预约时间校验（过时爽约）
			FBoolean isCanCancel = new CancelAptTimeCheckBP().check(aptDTO.getId_apt());
			if (isCanCancel.booleanValue()) {
				new CancAptOpBP().exec(aptDTO);
			} else {
				new BreakOralAptBP().exec(aptDTO.getId_apt(), FBoolean.FALSE);
			}
		}
	}

}
