package iih.sc.apt.s.bp.opt;

import iih.ci.ord.i.external.provide.ICiOrdEnService;
import iih.sc.comm.ScContextUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 手术预约操作医嘱申请单BP
 * 
 * @author zhengcm
 * @date 2018-02-27 08:57:49
 *
 */
public class OptAptCiObsOperateBP {

	/**
	 * 预约成功回写
	 * 
	 * @author zhengcm
	 *
	 * @param id_or 医嘱ID
	 * @param dt_apt 预约时间
	 * @throws BizException
	 */
	public void rewriteAptSuccess(String id_or, FDateTime dt_apt) throws BizException {
		this.getCiService().updateAppSurgeryAppointmentStatus(id_or, dt_apt, ScContextUtils.getPsnId());
	}

	/**
	 * 取消预约回写
	 * 
	 * @author zhengcm
	 *
	 * @param id_or 医嘱ID
	 * @throws BizException
	 */
	public void rewriteCancApt(String id_or) throws BizException {
		this.getCiService().cancelAppSurgeryAppointmentStatus(id_or, ScContextUtils.getPsnId());
	}

	/**
	 * 获取医嘱申请处理服务
	 * 
	 * @author zhengcm
	 *
	 * @return
	 * @throws BizException
	 */
	private ICiOrdEnService getCiService() throws BizException {
		return ServiceFinder.find(ICiOrdEnService.class);
	}
}
