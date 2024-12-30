package iih.sc.apt.s.bp.oral;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.IScMsgConst;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检查口腔预约渠道BP
 * 
 * @author zhengcm
 * @date 2017-11-07 08:55:00
 *
 */
public class CheckOralChlBP {

	/**
	 * 检查口腔预约渠道
	 *
	 * @author zhengcm
	 * 
	 * @param id_scchl 排班渠道ID
	 * @throws BizException
	 */
	public void check(String id_scchl) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_scchl)) {
			return;
		}
		// 检查渠道
		ISchedulechlMDORService chlService = ServiceFinder.find(ISchedulechlMDORService.class);
		SchedulechlDO chlDO = chlService.findById(id_scchl);
		if (null == chlDO || !chlDO.getCode().equals(IScDictCodeConst.SD_SCCHLTP_HOSPITAL_ROOM_DEPT)) {
			throw new BizException(IScMsgConst.SC_APT_ORAL_SCCHL_ERR);
		}
	}

}
