package iih.ci.rcm.s.bp.common;

import iih.ci.mr.pub.MrConst.IMrSysParamConst;
import iih.ci.mr.pub.MrConst.IMrSysParamDefaultConst;
import xap.mw.core.data.BizException;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class CiMrParamUtils {
	/**
	 * 传染病保存通知手机号集合，多个以逗号分隔
	 * 
	 * @param id_org
	 * @return
	 */
	public static String GetSysParamCardContagionSendMobile(String id_org) {
		try {
			return ParamsetQryUtil.getParaString(id_org,
					IMrSysParamConst.SYS_PARAM_CARD_CONTAGIONSENDMOBILE);
		} catch (BizException e) {
			return IMrSysParamDefaultConst.SYS_PARAM_CARD_CONTAGIONSENDMOBILE_DEFAULT;
		}
	}
}
