package iih.en.que.s.bp;

import iih.bd.base.utils.MapUtils;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.ep.BdQueEP;
import iih.en.comm.ep.BdSiteEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 批量上线
 * 
 * @author Anninglbj
 *
 */
public class BatchLoginOpSiteBP {
	/**
	 * 批量上线
	 * 
	 * @param sites
	 * @param queId
	 * @return
	 * @throws BizException
	 */
	public QueSiteDO[] exec(QueSiteDO[] sites, String queId) throws BizException {
		if(EnValidator.isEmpty(sites) || EnValidator.isEmpty(queId))
			return sites;
		Map<String, QueSiteDO> map = (Map<String, QueSiteDO>) MapUtils.convertArrayToMap(sites, QueSiteDO.ID_QUESITE);
		BdSiteEP ep = new BdSiteEP();
		sites = ep.getSiteRServ().findByBIds(map.keySet().toArray(new String[0]), FBoolean.FALSE);
		if(EnValidator.isEmpty(sites))
			return null;
		QueDO que = getQueDo(queId);
		String empId = getEmpId(que.getId_scres());
		LoginOpSiteBP bp = new LoginOpSiteBP();
		for(QueSiteDO site : sites){
			//已经上线的不再上线
			if(PauseEnum.ONLINE.equals(site.getEu_pause()))
				continue;
			//可使用科室不包含此队列科室
			if(!EnValidator.isEmpty(site.getIds_dep_enable())
					&& !site.getIds_dep_enable().contains(que.getId_dep()))
				continue;
			//上线
			EnTrDocSiteInfoDTO siteInfo = new EnTrDocSiteInfoDTO();
			siteInfo.setId_quesite(site.getId_quesite());
			siteInfo.setId_ques(EnAppUtils.objArray2List(que.getId_que()));
			siteInfo.setId_emp(empId);
			siteInfo.setId_dep(que.getId_dep());
			bp.exec(siteInfo);
		}
		return ep.getSiteRServ().findByBIds(map.keySet().toArray(new String[0]), FBoolean.FALSE);
	}
	/**
	 * 获取队列信息
	 * 
	 * @param queId
	 * @return
	 * @throws BizException
	 */
	private QueDO getQueDo(String queId) throws BizException{
		return new BdQueEP().getQueById(queId);
	}
	/**
	 * 获取资源人员信息
	 * 
	 * @param scresId
	 * @return
	 * @throws BizException
	 */
	private String getEmpId(String scresId) throws BizException{
		String sql = " select id_emp from sc_res where id_scres = ? ";
		SqlParam param = new SqlParam();
		param.addParam(scresId);
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		return EnValidator.isEmpty(list) ? null : list.get(0);
	}
}
