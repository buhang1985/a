package iih.bd.fc.quesite.s.rule;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.fc.quesite.d.PauseEnum;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.sitechangerec.d.SiteChangeRecDO;
import iih.bd.fc.sitechangerec.d.SiteChangeTp;
import iih.bd.fc.sitechangerec.i.ISitechangerecCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.ICompareRule;

/**
 * 写站点状态变更记录规则
 * 
 * @author hao_wu
 *
 */
public class WriteSiteStateChangeRecordRule implements ICompareRule<QueSiteDO> {

	@Override
	public void process(QueSiteDO[] newSites, QueSiteDO[] oldSites) throws BizException {
		if (newSites == null || newSites.length <= 0) {
			return;
		}

		SiteChangeRecDO[] siteChangeRecs = getSiteChangeRecs(newSites, oldSites);
		saveSiteChangeRecs(siteChangeRecs);
	}

	/**
	 * 保存站点变更记录集合
	 * 
	 * @param siteChangeRecs
	 * @throws BizException
	 */
	private void saveSiteChangeRecs(SiteChangeRecDO[] siteChangeRecs) throws BizException {
		if (siteChangeRecs == null || siteChangeRecs.length <= 0) {
			return;
		}

		ISitechangerecCudService sitechangerecCudService = ServiceFinder.find(ISitechangerecCudService.class);
		sitechangerecCudService.insert(siteChangeRecs);
	}

	/**
	 * 获取站点变更记录集合
	 * 
	 * @param newSites
	 * @param oldSites
	 * @return
	 */
	private SiteChangeRecDO[] getSiteChangeRecs(QueSiteDO[] newSites, QueSiteDO[] oldSites) {
		ArrayList<SiteChangeRecDO> siteChangeRecList = new ArrayList<SiteChangeRecDO>();
		for (int i = 0; i < newSites.length; i++) {
			QueSiteDO newSite = newSites[i];
			QueSiteDO oldSite = oldSites[i];
			SiteChangeRecDO siteChangeRec = getSiteChangRec(newSite, oldSite);
			if (siteChangeRec != null) {
				siteChangeRecList.add(siteChangeRec);
			}
		}
		return siteChangeRecList.toArray(new SiteChangeRecDO[0]);
	}

	/**
	 * 获取站点变更记录
	 * 
	 * @param newSite
	 * @param oldSite
	 * @return
	 */
	private SiteChangeRecDO getSiteChangRec(QueSiteDO newSite, QueSiteDO oldSite) {
		String siteChangeTp = getChangeTp(newSite, oldSite);
		if (StringUtils.isEmpty(siteChangeTp)) {
			return null;
		}

		SiteChangeRecDO siteChangeRec = new SiteChangeRecDO();
		siteChangeRec.setId_grp(Context.get().getGroupId());
		siteChangeRec.setId_org(Context.get().getOrgId());
		siteChangeRec.setId_que_site(newSite.getId_quesite());
		siteChangeRec.setEu_changetp(siteChangeTp);
		siteChangeRec.setData_old(oldSite.toString());
		siteChangeRec.setData_new(newSite.toString());

		return siteChangeRec;
	}

	/**
	 * 获取站点变更类型
	 * 
	 * @param newSite
	 * @param oldSite
	 * @return
	 */
	private String getChangeTp(QueSiteDO newSite, QueSiteDO oldSite) {
		if (newSite == null || oldSite == null) {
			return null;
		}

		if (PauseEnum.ONLINE.equals(newSite.getEu_pause()) && !PauseEnum.ONLINE.equals(oldSite.getEu_pause())) {
			return SiteChangeTp.ONLINE;
		}

		if (PauseEnum.OFFLINE.equals(newSite.getEu_pause()) && !PauseEnum.OFFLINE.equals(oldSite.getEu_pause())) {
			return SiteChangeTp.OFFLINE;
		}

		if (PauseEnum.PAUSE.equals(newSite.getEu_pause()) && !PauseEnum.PAUSE.equals(oldSite.getEu_pause())) {
			return SiteChangeTp.SUSPEND;
		}

		return null;
	}

}
