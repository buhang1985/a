package iih.en.que.s.bp;

import iih.bd.base.utils.MapUtils;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.ep.BdSiteEP;
import iih.en.comm.validator.EnValidator;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 门诊工作站批量下线
 * 
 * @author Anninglbj
 *
 */
public class BatchLogoutOpSiteBP {
	/**
	 * 批量下线
	 * 
	 * @param sites
	 * @return
	 * @throws BizException
	 */
	public QueSiteDO[] exec(QueSiteDO[] sites) throws BizException {
		if(EnValidator.isEmpty(sites))
			return null;
		Map<String, QueSiteDO> map = (Map<String, QueSiteDO>) MapUtils.convertArrayToMap(sites, QueSiteDO.ID_QUESITE);
		BdSiteEP ep = new BdSiteEP();
		sites = ep.getSiteRServ().findByBIds(map.keySet().toArray(new String[0]), FBoolean.FALSE);
		if(EnValidator.isEmpty(sites))
			return null;
		LogoutOpSiteBP bp = new LogoutOpSiteBP();
		for(QueSiteDO site : sites){
			if(PauseEnum.OFFLINE.equals(site.getEu_pause()))
				continue;
			bp.exec(site.getId_quesite(), null);
		}
		return ep.getSiteRServ().findByBIds(map.keySet().toArray(new String[0]), FBoolean.FALSE);
	}
	
}
