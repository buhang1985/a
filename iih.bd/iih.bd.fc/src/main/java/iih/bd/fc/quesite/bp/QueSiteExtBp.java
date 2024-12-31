package iih.bd.fc.quesite.bp;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.fc.pub.BdFcAppUtils;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQuesiteCudService;
import iih.bd.fc.quesite.i.IQuesiteRService;
import iih.en.que.i.IEnQueOutCmdService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 就诊队列工作点扩展服务——具体实现
 * @author 刘 斌
 *2015年9月14日 下午5:25:37
 */
public class QueSiteExtBp {

	/**
	 * 暂停工作站点
	 * @param queSite
	 * @throws BizException
	 */
	public void stopQueSite(QueSiteDO queSite) throws BizException {
		this.verifyQueSite(queSite);
		IQuesiteRService siteRService = ServiceFinder.find(IQuesiteRService.class);
		QueSiteDO queSiteDO = siteRService.findById(queSite.getId_quesite());
		if (queSiteDO != null) {
			// 设置暂停状态为true
			queSiteDO.setEu_pause(PauseEnum.PAUSE);
			// 设置暂停开始时间为当前时间
			FDateTime curTime = BdFcAppUtils.getServerDateTime();
			queSiteDO.setDate_b_pause(curTime);
			queSiteDO.setStatus(DOStatus.UPDATED);
			IQuesiteCudService siteCudService = ServiceFinder.find(IQuesiteCudService.class);
			siteCudService.update(new QueSiteDO[] { queSiteDO });
			this.invoke(queSite.getId_quesite(), null,queSiteDO.getId_queben(), IEnEventConst.EVENT_EN_ALL_DOC_PAUSE);//发送事件，fanlq-2018-07-10
		}
	}

	/**
	 * 启动工作站点
	 * @param queSite
	 * @throws BizException
	 */
	public void startQueSite(QueSiteDO queSite) throws BizException {
		this.verifyQueSite(queSite);
		IQuesiteRService siteRService = ServiceFinder.find(IQuesiteRService.class);
		QueSiteDO queSiteDO = siteRService.findById(queSite.getId_quesite());
		if (queSiteDO != null) {
			// 设置暂停状态为false
			queSiteDO.setEu_pause(PauseEnum.ONLINE);
			// 设置暂停结束时间为当前时间
			queSiteDO.setStatus(DOStatus.UPDATED);
			IQuesiteCudService siteCudService = ServiceFinder.find(IQuesiteCudService.class);
			siteCudService.update(new QueSiteDO[] { queSiteDO });
			this.invoke(queSite.getId_quesite(), null,queSiteDO.getId_queben(), IEnEventConst.EVENT_EN_ALL_DOC_CONTINUE);//发送事件，fanlq-2018-07-10
		}
	}
	/**
	 * 登陆工作站点
	 * @param quesiteId 工作站点id
	 * @param empId 人员id
	 * @throws BizException
	 */
	public void login(String quesiteId,String empId) throws BizException{
		if(StringUtil.isEmptyWithTrim(quesiteId)){
			throw new BizException("登陆工作站点 logout方法中quesiteId不能为空！");
		}
		if(StringUtil.isEmptyWithTrim(empId)){
			throw new BizException("登陆工作站点 logout方法中empId不能为空！");
		}
		IQuesiteRService siteRService = ServiceFinder.find(IQuesiteRService.class);
		QueSiteDO queSiteDO = siteRService.findById(quesiteId);
		if(queSiteDO!=null){
			queSiteDO.setId_emp(empId);
			queSiteDO.setEu_pause(PauseEnum.ONLINE);
			queSiteDO.setStatus(DOStatus.UPDATED);
			IQuesiteCudService siteCudService = ServiceFinder.find(IQuesiteCudService.class);
			siteCudService.update(new QueSiteDO[] { queSiteDO });
			this.invoke(quesiteId, null,queSiteDO.getId_queben(), IEnEventConst.EVENT_EN_ALL_DOC_ONLINE);//发送事件，fanlq-2018-07-10
		}
	}
	/**
	 * 退出工作点
	 * @param quesiteId 工作点
	 * @throws BizException
	 */
	public void logout(String quesiteId) throws BizException{
		if(StringUtil.isEmptyWithTrim(quesiteId)){
			throw new BizException("退出工作点时logout方法中quesiteId不能为空！");
		}
		IQuesiteRService siteRService = ServiceFinder.find(IQuesiteRService.class);
		QueSiteDO queSiteDO = siteRService.findById(quesiteId);
		if(queSiteDO!=null){
			queSiteDO.setId_emp(null);
			queSiteDO.setEu_pause(PauseEnum.OFFLINE);
			FDateTime curTime = BdFcAppUtils.getServerDateTime();
			queSiteDO.setDate_b_pause(curTime);
			queSiteDO.setStatus(DOStatus.UPDATED);
			IQuesiteCudService siteCudService = ServiceFinder.find(IQuesiteCudService.class);
			siteCudService.update(new QueSiteDO[] { queSiteDO });
			this.invoke(quesiteId, null, queSiteDO.getId_queben(),IEnEventConst.EVENT_EN_ALL_DOC_OFFLINE);//发送事件，fanlq-2018-07-10
		}
	}
	/**
	 * 验证QueSiteDO
	 * 
	 * @param queSiteDO
	 * @throws BizException
	 */
	private void verifyQueSite(QueSiteDO queSiteDO) throws BizException{
		if(queSiteDO==null){
			throw new BizException("QueSiteDO不能为空！");
		}
		if(StringUtil.isEmptyWithTrim(queSiteDO.getId_quesite())){
			throw new BizException("QueSiteDO中Id_quesite不能为空！");
		}
	}
	
	/***
	 * 发送事件
	 * @param quesiteId
	 * @param queId
	 * @param event
	 * @throws BizException
	 */
	private void invoke(String quesiteId,String queId,String id_queben,String event) throws BizException{
		IEnQueOutCmdService service = ServiceFinder.find(IEnQueOutCmdService.class);
		service.invoke(quesiteId, queId, id_queben, event);
	}
}
