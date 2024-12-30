package iih.sc.apt.s.bp.oral;

import iih.sc.apt.s.ep.OralAptEP;
import iih.sc.comm.IScMsgConst;
import iih.sc.sch.scsch.d.ScSchDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 校验口腔预约排班BP
 * 
 * @author zhengcm
 * @date 2017-10-12 08:24:07
 *
 */
public class CheckOralAptSchBP {

	/**
	 * 校验口腔预约排班
	 *
	 * @author zhengcm
	 * 
	 * @param id_sch
	 * @throws BizException
	 */
	public void check(String id_sch) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_sch)) {
			return;
		}
		ScSchDO schDO = new OralAptEP().getSch(id_sch);
		if (null != schDO && !schDO.getFg_active().booleanValue()) {
			throw new BizException(IScMsgConst.SC_APT_ORAL_SCH_UNACTIVE);
		}
	}

}
