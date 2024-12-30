package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.cior.d.desc.OrdApObsDODesc;
import iih.ci.ord.cior.i.ICiorapprisCudService;
import iih.ci.ord.cior.i.ICiorapprisRService;
import iih.sc.comm.IScMsgConst;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 预约成功后回写数据到申请表
 * 
 * @author ccj
 * @changed by zhengcm：修改医嘱申请单状态时，回写状态ID值
 *
 */
public class UpdateSdSuObsBp {
	/**
	 * 预约成功后回写数据到申请表
	 * 
	 * @param id_or 医嘱id
	 * @param isApt 是否预约 true 预约 false 取消预约
	 * @throws BizException
	 */
	public void exec(String id_or, FBoolean isApt) throws BizException {
		if (StringUtils.isEmpty(id_or))
			return;
		ICiorapprisRService obsDORService = ServiceFinder.find(ICiorapprisRService.class);
		ICiorapprisCudService cudService = ServiceFinder.find(ICiorapprisCudService.class);
		OrdApObsDO[] apObsDOs = null;
		if (isApt.booleanValue()) {
			// 预约
			apObsDOs = obsDORService.find(OrdApObsDODesc.TABLE_ALIAS_NAME + ".id_or ='" + id_or
					+ "' and " + OrdApObsDODesc.TABLE_ALIAS_NAME + ".sd_su_obs = '"
					+ ICiDictCodeConst.SD_CI_OBS_SQ + "'", null, FBoolean.TRUE);
			if (ArrayUtils.isEmpty(apObsDOs))
				throw new BizException(IScMsgConst.SC_APT_MT_WRITE_BACK_OBS);
			apObsDOs[0].setSd_su_obs(ICiDictCodeConst.SD_CI_OBS_YAP);
			apObsDOs[0].setId_su_obs(ICiDictCodeConst.ID_CI_OBS_YAP);
		} else {
			// 取消预约
			apObsDOs = obsDORService.find(OrdApObsDODesc.TABLE_ALIAS_NAME + ".id_or ='" + id_or
					+ "' and " + OrdApObsDODesc.TABLE_ALIAS_NAME + ".sd_su_obs = '"
					+ ICiDictCodeConst.SD_CI_OBS_YAP + "'", null, FBoolean.TRUE);
			if (ArrayUtils.isEmpty(apObsDOs))
				throw new BizException(IScMsgConst.SC_APT_MT_WRITE_BACK_OBS);
			apObsDOs[0].setSd_su_obs(ICiDictCodeConst.SD_CI_OBS_SQ);
			apObsDOs[0].setId_su_obs(ICiDictCodeConst.ID_CI_OBS_SQ);
		}
		apObsDOs[0].setStatus(DOStatus.UPDATED);
		cudService.save(apObsDOs);
	}
}
