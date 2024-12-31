package iih.en.comm.ep;

import iih.bd.fc.quesite.d.PauseEnum;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQuesiteCudService;
import iih.bd.fc.quesite.i.IQuesiteRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 站点EP
 * 
 * @author liubin
 *
 */
public class BdSiteEP {

	/**
	 * 获取站点
	 * 
	 * @param siteId 站点ID
	 * @return
	 * @throws BizException
	 */
	public QueSiteDO getSiteById(String siteId) throws BizException {
		return getSiteRServ().findById(siteId);
	}
	/**
	 * 获取站点
	 * 
	 * @param siteId 站点ID
	 * @return
	 * @throws BizException
	 */
	public QueSiteDO getSiteByPK(String siteId) throws BizException {
		return (QueSiteDO) new DAFacade().findByPK(QueSiteDO.class, siteId);
	}

	/**
	 * 获取站点查询服务
	 * 
	 * @return
	 */
	public IQuesiteRService getSiteRServ() {
		return ServiceFinder.find(IQuesiteRService.class);
	}

	/**
	 * 获取站点增加，删除，修改服务
	 * 
	 * @return
	 */
	public IQuesiteCudService getSiteCudServ() {
		return ServiceFinder.find(IQuesiteCudService.class);
	}
	/**
	 * 判断站点是否下线，下线后不能进行相关操作
	 * @param siteId
	 * @throws BizException
	 */
	public void siteError(String siteId) throws BizException{
		QueSiteDO queSiteDO = this.getSiteById(siteId);
		siteError(queSiteDO);
	}
	/**
	 * 判断站点是否下线，下线后不能进行相关操作
	 * @param siteId
	 * @throws BizException
	 */
	public void siteError(QueSiteDO queSiteDO) throws BizException{
		if(queSiteDO == null || !PauseEnum.ONLINE.toString().equals(queSiteDO.getEu_pause())){
			throw new BizException("站点已下线，不能进行该操作！");
		}
	}
}
