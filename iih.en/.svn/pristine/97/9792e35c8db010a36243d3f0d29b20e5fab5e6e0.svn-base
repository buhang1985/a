package iih.en.que.s.bp;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQuesiteCudService;
import iih.bd.fc.quesite.i.IQuesiteRService;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.s.event.bp.EnOpQueEventBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医生退出工作站时，修改工作点信息
 * 
 * @author liubin
 * 
 */
public class LogoutOpSiteBP {
	/**
	 * 医生退出工作站时，修改工作点信息
	 * 
	 * @param queSiteId
	 *            医生工作站ID
	 * @throws BizException
	 */
	public QueSiteDO exec(String queSiteId, String codeEnTp) throws BizException {
		QueSiteDO queSite = ServiceFinder.find(IQuesiteRService.class).findById(queSiteId);
		if (queSite != null) {
			String queId = queSite.getId_que();
			String empId = queSite.getId_emp();
			queSite.setId_emp(null);
			queSite.setId_dep(null);
			queSite.setId_que(null);
			queSite.setEu_pause(PauseEnum.OFFLINE);
			FDateTime curTime = EnAppUtils.getServerDateTime();
			queSite.setDate_b_pause(curTime);
			queSite.setStatus(DOStatus.UPDATED);
			// by hao_wu 用于记录变更信息
			// new DAFacade().updateDO(queSite);
			QueSiteDO[] sites = ServiceFinder.find(IQuesiteCudService.class).save(new QueSiteDO[] { queSite });
			// 触发下线事件
			this.invoke(queId, queSiteId, codeEnTp, null, empId);
			
			return EnValidator.isEmpty(sites) ? null : sites[0];
		}
		return null;
	}

	/**
	 * 触发下线事件
	 * 
	 * @param queId
	 * @param siteId
	 * @param entId
	 * @param empId
	 * @throws BizException
	 */
	private void invoke(String queId, String siteId, String codeEnTp, String entId, String empId) throws BizException {
		EnOpQueEventBP event = new EnOpQueEventBP();
		event.invokeEnOpQueOutEvent(queId, siteId, codeEnTp, entId, IEnEventConst.EVENT_EN_OP_DOC_OFFLINE, empId);
	}
}
