package iih.bd.fc.quesite.s.rule;

import java.util.ArrayList;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.que.i.IQuePharmacyService;
import iih.bd.fc.quesite.d.QueSiteDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.orgfw.dept.i.IDeptRService;

/**
 * 队列工作点保存更新前置规则
 * 
 * @author guoyang
 *
 */
public class QueSiteRule implements IRule<QueSiteDO> {

	@Override
	public void process(QueSiteDO... arg0) throws BizException {
		QueSiteDO[] sendMSiteArray = getSendMSiteArray(arg0);
		if (sendMSiteArray == null || sendMSiteArray.length <= 0) {
			return;
		}
		IQuePharmacyService quePharmacyService = ServiceFinder.find(IQuePharmacyService.class);
		IDeptRService deptRService = ServiceFinder.find(IDeptRService.class);
		QueDO queDO = quePharmacyService.getPharmacyQue(deptRService.findById(sendMSiteArray[0].getId_dep()));
		for (QueSiteDO queSiteDO : sendMSiteArray) {
			queSiteDO.setId_que(queDO.getId_que());
		}
	}
	/**
	 * 筛选出发药工作站类型的站点
	 * @param arg0
	 * @return
	 */
	private QueSiteDO[] getSendMSiteArray(QueSiteDO[] arg0) {
		if (arg0 == null || arg0.length <= 0) {
			return null;
		}
		ArrayList<QueSiteDO> queSiteList = new ArrayList<QueSiteDO>();

		for (QueSiteDO queSiteDO : arg0) {
			if (queSiteDO != null && queSiteDO.getSd_quesitetp() != null
					&& queSiteDO.getSd_quesitetp().equals(IBdFcDictCodeConst.SD_QUESITETP_SENDM)) {
				queSiteList.add(queSiteDO);
			}
		}
		return queSiteList.toArray(new QueSiteDO[0]);
	}
}
