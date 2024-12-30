package iih.sc.apt.s.bp.oral;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.comm.IScMsgConst;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 校验口腔预约状态BP
 * 
 * @author zhengcm
 * @date 2017-09-12 16:26:10
 *
 */
public class CheckOralAptStatusBP {

	/**
	 * 校验口腔预约状态
	 *
	 * @author zhengcm
	 * 
	 * @param id_apt 预约ID
	 * @throws BizException
	 */
	public void check(String id_apt) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_apt)) {
			return;
		}
		ScAptDO aptDO = new AptEP().getById(id_apt);
		if (aptDO.getFg_canc().booleanValue()) {
			throw new BizException(IScMsgConst.SC_APT_ORAL_CANCEL_OR＿BREAK);
		}
		if (aptDO.getSd_status().equals(IScDictCodeConst.SD_APTSTATUS_FINISH)) {
			throw new BizException(IScMsgConst.SC_APT_HAVA_TAKE_TICKET);
		}
	}

}
