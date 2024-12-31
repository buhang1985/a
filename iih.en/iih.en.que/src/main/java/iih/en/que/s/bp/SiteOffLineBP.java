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
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 把在线的医生站点设置为离线
 * 
 * @author liubin
 *
 */
public class SiteOffLineBP {
	/**
	 * 把在线的医生站点设置为离线
	 * 
	 * @param queSiteId
	 * @return
	 * @throws BizException
	 */
	public QueSiteDO exec(String queSiteId, String codeEnTp) throws BizException {
		EnValidator.validateParam("queSiteId", queSiteId);
		IQuesiteRService queSiteRServ = ServiceFinder.find(IQuesiteRService.class);
		QueSiteDO queSite = queSiteRServ.findById(queSiteId);
		if(queSite!=null){
			queSite.setStatus(DOStatus.UPDATED);
			queSite.setEu_pause(PauseEnum.OFFLINE);
			queSite.setDate_b_pause(EnAppUtils.getServerDateTime());
			IQuesiteCudService queSiteCudServ = ServiceFinder.find(IQuesiteCudService.class);
			QueSiteDO[] queSites = queSiteCudServ.save(new QueSiteDO[] { queSite } );
			if(!EnValidator.isEmpty(queSites)) {
				//触发下线事件
				this.invoke(queSites[0].getId_que(), queSites[0].getId_quesite(), codeEnTp, null);
				return queSites[0];
			}
		}
		return null;
	}
	/**
	 * 触发下线事件
	 * 
	 * @param queId
	 * @param siteId
	 * @param entId
	 * @throws BizException 
	 */
	private void invoke(String queId, String siteId, String codeEnTp, String entId) throws BizException{
		EnOpQueEventBP event = new EnOpQueEventBP();
		event.invokeEnOpQueEvent(queId, siteId, codeEnTp, entId, IEnEventConst.EVENT_EN_OP_DOC_OFFLINE);
	}
}
