package iih.en.que.s.bp.pharm;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.d.QueSiteStatus;
import iih.bd.fc.quesite.d.desc.QueSiteDODesc;
import iih.bd.fc.quesite.i.IQuesiteCudService;
import iih.bd.fc.quesite.i.IQuesiteRService;
import iih.en.que.s.event.DrugQueEvent;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 药房队列管理
 * 
 * @author yankan
 *
 */
public class SetSiteStatusBP {
	public SetSiteStatusBP() {

	}

	/**
	 * 设置队列状态
	 * 
	 * @param pcId
	 *            计算机id
	 * @param quesiteTp
	 *            工作站类型，01-门诊医生站 02-住院医生站 11-医技工作站 20 发药工作点 ，21 配药工作点
	 * @param newStatus
	 *            状态 0 离线，1 在线，2 暂停
	 * @param empId
	 *            操作员id
	 * @param dtOpr
	 *            操作时间
	 * @throws BizException
	 */
	public void exec(String pcId, String quesiteTp, Integer newStatus, String empId, FDateTime dtOpr)
			throws BizException {
		// 获取工作点
		IQuesiteRService quesiteRService = ServiceFinder.find(IQuesiteRService.class);
		String whereStr = String.format(QueSiteDODesc.TABLE_ALIAS_NAME + ".id_pc='%s' and "
				+ QueSiteDODesc.TABLE_ALIAS_NAME + ".sd_quesitetp='%s'", pcId, quesiteTp);
		QueSiteDO[] sites = quesiteRService.find(whereStr, null, FBoolean.FALSE);
		if (sites != null && sites.length > 0) {
			QueSiteDO siteDO = sites[0];
			if (FBoolean.FALSE.equals(siteDO.getFg_active())) {
				throw new BizException(String.format("本药房窗口【%s】未启用！", siteDO.getName()));
			}
			if (newStatus.equals(QueSiteStatus.ONLINE)) {
				siteDO.setEu_pause(PauseEnum.ONLINE);
				siteDO.setId_emp(empId);
				//触发上线事件
				this.invoke(siteDO.getId_quesite(),null, IEnEventConst.EVENT_DRUG_ONLIN);
			} else if (newStatus.equals(QueSiteStatus.PAUSE)) {
				siteDO.setEu_pause(PauseEnum.PAUSE);
				siteDO.setId_emp(empId);
				siteDO.setDate_b_pause(dtOpr);
				//触发暂停事件
				this.invoke(siteDO.getId_quesite(),null, IEnEventConst.EVENT_DRUG_OFFLIN);
			} else if (newStatus.equals(QueSiteStatus.OFFLINE)) {
				siteDO.setEu_pause(PauseEnum.OFFLINE);
				siteDO.setId_emp(null);
				siteDO.setDate_b_pause(dtOpr);
				//触发离线事件
				this.invoke(siteDO.getId_quesite(),null, IEnEventConst.EVENT_DRUG_OFFLIN);
			} 	
			// by hao_wu 用于记录变更信息
			// siteDO.setStatus(DOStatus.UPDATED);
			// new DAFacade().updateDO(siteDO);
			IQuesiteCudService quesiteCudService = ServiceFinder.find(IQuesiteCudService.class);
			quesiteCudService.update(new QueSiteDO[] { siteDO });
		}
	}
	
	/***
	 * 触发事件
	 * @param quesiteId
	 * @param event
	 * @throws BizException
	 */
	private void invoke(String quesiteId,String entqueId,String event) throws BizException{
		DrugQueEvent e = new DrugQueEvent();
		e.exec(quesiteId,entqueId,null, event);
	}
}
