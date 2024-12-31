package iih.en.que.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.d.desc.QueSiteDODesc;
import iih.bd.fc.quesite.i.IQuesiteCudService;
import iih.bd.fc.quesite.i.IQuesiteRService;
import iih.bd.res.workstation.d.WorkStationPcDO;
import iih.bd.res.workstation.i.IWorkstationRService;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 工作站BP 工作点初始化、更新
 * 
 * @author yankan
 * @since 2015-10-10
 *
 */
public class QueSiteBP {

	/**
	 * 构造函数
	 */
	public QueSiteBP() {

	}

	/**
	 * 登陆工作站
	 * 
	 * @param ip PC的IP地址
	 * @param empId 工作人员id
	 * @param quesiteType 站点类型
	 * @throws BizException
	 */
	public QueSiteDO login() throws BizException {
		// 1、找工作站
		String pcId = EnContextUtils.getPcId();
		if (EnValidator.isEmpty(pcId)) {
			throw new BizException("站点未注册！");
		}
		QueSiteDO queSiteDO = this.getQueSite(pcId);
		// 2、更新工作站为在线
		queSiteDO = this.changeSiteStatus(queSiteDO, 1);
		return queSiteDO;
	}

	/**
	 * 更新站点状态
	 * 
	 * @param queSiteId
	 * @param status 状态，0 离线，1 在线，2 暂停
	 * @return
	 * @throws BizException
	 */
	public QueSiteDO changeSiteStatus(String queSiteId, Integer status) throws BizException {
		if (status == null) {
			throw new BizException("参数status值为null");
		}
		IQuesiteRService queSiteRService = ServiceFinder.find(IQuesiteRService.class);
		QueSiteDO queSiteDO = queSiteRService.findById(queSiteId);
		queSiteDO = this.changeSiteStatus(queSiteDO, status);

		return queSiteDO;
	}

	/**
	 * 更新站点状态
	 * 
	 * @param queSiteDO 站点
	 * @param status 状态，0 离线，1 在线，2 暂停
	 * @return
	 * @throws BizException
	 */
	public QueSiteDO changeSiteStatus(QueSiteDO queSiteDO, Integer status) throws BizException {
		if (queSiteDO == null) {
			throw new BizException("参数queSiteDO值为null");
		}
		if (status == null) {
			throw new BizException("参数status值为null");
		}
		if (queSiteDO != null) {
			FDateTime curTime = EnAppUtils.getServerDateTime();
			if (status.equals(0)) {
				// 离线
				// queSiteDO.setFg_pause(FBoolean.TRUE);
				queSiteDO.setEu_pause(PauseEnum.OFFLINE);
				queSiteDO.setDate_b_pause(curTime);// 设置暂停开始时间为当前时间
				queSiteDO.setId_emp(null);// 清空人员
			} else if (status.equals(1)) {
				// 在线
				// queSiteDO.setFg_pause(FBoolean.FALSE);
				queSiteDO.setEu_pause(PauseEnum.ONLINE);
				queSiteDO.setDate_e_pause(curTime);// 设置暂停结束时间为当前时间
				queSiteDO.setId_emp(EnContextUtils.getPsnId());
			} else if (status.equals(2)) {
				// 暂停
				// queSiteDO.setFg_pause(FBoolean.TRUE);
				queSiteDO.setEu_pause(PauseEnum.PAUSE);
				queSiteDO.setDate_b_pause(curTime);// 设置暂停开始时间为当前时间
			}
			queSiteDO.setStatus(DOStatus.UPDATED);
			IQuesiteCudService service = ServiceFinder.find(IQuesiteCudService.class);
			QueSiteDO[] sites = service.save(new QueSiteDO[] { queSiteDO });
			queSiteDO = sites[0];
		}

		return queSiteDO;
	}

	/**
	 * 获取站点
	 * 
	 * @param pcId 计算机注册，分配的PCID
	 * @return
	 * @throws BizException
	 */
	private QueSiteDO getQueSite(String pcId) throws BizException {
		IQuesiteRService quesiteRService = ServiceFinder.find(IQuesiteRService.class);
		IWorkstationRService wkService = ServiceFinder.find(IWorkstationRService.class);
		WorkStationPcDO[] wkDOs = wkService.findByAttrValString(WorkStationPcDO.PCID, pcId);
		if (EnValidator.isEmpty(wkDOs)) {
			throw new BizException("未找到该计算的的PCID");
		}
		WorkStationPcDO wkDO = wkDOs[0];
		QueSiteDO[] queSiteDOs = quesiteRService.find(QueSiteDODesc.TABLE_ALIAS_NAME + ".ID_PC='"
				+ wkDO.getId_pc() + "' AND " + QueSiteDODesc.TABLE_ALIAS_NAME + ".sd_quesitetp='"
				+ IBdFcDictCodeConst.SD_QUESITETP_MT + "'", null, FBoolean.FALSE);
		if (queSiteDOs != null && queSiteDOs.length > 0) {
			return queSiteDOs[0];
		} else {
			throw new BizException("你的计算机未注册医技工作站，请到（基础数据——>流程配置——>医技队列维护）重新维护！");
		}
	}
}
