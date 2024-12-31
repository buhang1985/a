package iih.bd.pp.hpsrvorca.s.bp;

import iih.bd.pp.bdhpsrvctr.d.BdHpSrvctrDO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.srvctrdi.d.BdHpSrvCtrDiDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 删除所有对照信息业务逻辑
 * 
 * @author hao_wu
 *
 */
public class DeleteAllHpSrvorcaBp {

	public void exec() throws BizException {
		deleteBdHpSrvorca();
		// deleteBdHpSrvCtr();
		// deleteBdHpSrvCtrDi();
	}

	/**
	 * 删除bd_hp_srvorca
	 * 
	 * @throws DAException
	 */
	private void deleteBdHpSrvorca() throws DAException {
		String wherePart = String.format("id_grp = '%s' and id_org = '%s'", Context.get().getGroupId(),
				Context.get().getOrgId());
		DAFacade daFacade = new DAFacade();
		daFacade.deleteByWhere(HPSrvorcaDO.class, wherePart);
	}

	/**
	 * 删除bd_hp_srvctr
	 * 
	 * @throws DAException
	 */
	private void deleteBdHpSrvCtr() throws DAException {
		String wherePart = String.format("id_grp = '%s' and id_org = '%s'", Context.get().getGroupId(),
				Context.get().getOrgId());
		DAFacade daFacade = new DAFacade();
		daFacade.deleteByWhere(BdHpSrvctrDO.class, wherePart);
	}

	/**
	 * 删除bd_hp_srvctr_di
	 * 
	 * @throws DAException
	 */
	private void deleteBdHpSrvCtrDi() throws DAException {
		String wherePart = String.format("id_grp = '%s' and id_org = '%s'", Context.get().getGroupId(),
				Context.get().getOrgId());
		DAFacade daFacade = new DAFacade();
		daFacade.deleteByWhere(BdHpSrvCtrDiDO.class, wherePart);
	}
}
