package iih.sc.apt.s.bp;

import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScValidator;
import xap.mw.core.data.BizException;

/**
 * 预约打印检查BP
 * 
 * @author zhengcm
 * @date 2017-10-09 16:10:58
 *
 */
public class CheckAptPrintBP {

	/**
	 * 预约打印检查
	 *
	 * @author zhengcm
	 * 
	 * @param id_apt
	 * @throws BizException
	 */
	public void exec(String id_apt) throws BizException {
		// 1、检查参数
		ScValidator.validateParam("id_apt", id_apt);
		// 检查预约状态
		ScAptDO aptDO = new AptEP().getById(id_apt);
		if (null != aptDO && aptDO.getFg_canc().booleanValue()) {
			throw new BizException(IScMsgConst.SC_APT_ORAL_CANCEL_OR＿BREAK);
		}
	}
}
