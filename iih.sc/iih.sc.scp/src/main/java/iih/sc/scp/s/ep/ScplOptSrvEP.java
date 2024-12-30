package iih.sc.scp.s.ep;

import iih.sc.comm.ScValidator;
import iih.sc.scp.scploptsrv.d.ScPlOptSrvDO;
import iih.sc.scp.scploptsrv.i.IScploptsrvCudService;
import iih.sc.scp.scploptsrv.i.IScploptsrvRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class ScplOptSrvEP {
	
	/**
	 * 根据计划ID删除备选服务
	 * 
	 * @param scplId
	 * @throws BizException
	 */
	public void deleteScplOptSrvByplId(String scplId) throws BizException{
		if(ScValidator.isEmptyIgnoreBlank(scplId))
			return;
		ScPlOptSrvDO[] scPlOptSrvs = getRServ().findByAttrValString(ScPlOptSrvDO.ID_SCPL, scplId);
		if(ScValidator.isNullOrEmpty(scPlOptSrvs))
			return;
		getCudServ().delete(scPlOptSrvs);
	}
	
	/**
	 * 保存
	 * 
	 * @param scPlOptSrvs
	 * @return
	 * @throws BizException
	 */
	public ScPlOptSrvDO[] save(ScPlOptSrvDO[] scPlOptSrvs) throws BizException{
		if(ScValidator.isNullOrEmpty(scPlOptSrvs))
			return null;
		return getCudServ().save(scPlOptSrvs);
	}
	
	/**
	 * 获取查询服务
	 * 
	 * @return
	 */
	public IScploptsrvRService getRServ(){
		return ServiceFinder.find(IScploptsrvRService.class);
	}
	/**
	 * 获取操作服务
	 * @return
	 */
	public IScploptsrvCudService getCudServ(){
		return ServiceFinder.find(IScploptsrvCudService.class);
	}
}
