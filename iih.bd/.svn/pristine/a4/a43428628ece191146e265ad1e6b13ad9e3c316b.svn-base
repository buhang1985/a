package iih.bd.pp.hpsrvorca.bp;

import iih.bd.pp.bdhpsrvctr.d.BdHpSrvctrDO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAFacade;

public class HpSrvorcaDeleteBp {
	
	public void exec(HPSrvorcaDO[] hpSrvorcas) throws BizException{
		if (hpSrvorcas == null || hpSrvorcas.length <= 0) {
			return;
		}
		DeleteOldData(hpSrvorcas);
	}
	
	/**
	 * 删除旧的医保计划_控制策略数据
	 * 
	 * @param hpSrvorcas
	 * @throws BizException
	 */
	private void DeleteOldData(HPSrvorcaDO[] hpSrvorcas) throws BizException {
		StringBuilder srvctrwherePart = new StringBuilder();
		srvctrwherePart.append("id_grp = '" + Context.get().getGroupId() + "' and id_org = '" + Context.get().getOrgId() + "' and (");
		for (int i = 0; i < hpSrvorcas.length; i++) {
			if(i == hpSrvorcas.length-1){
				srvctrwherePart.append(" (id_srv = '" + hpSrvorcas[i].getId_srv() + "' and id_hp = '" + hpSrvorcas[i].getId_hp() + "' and eu_hpsrvtp = '" + hpSrvorcas[i].getEu_hpsrvtp() + "') ");
			}else{
				srvctrwherePart.append(" (id_srv = '" + hpSrvorcas[i].getId_srv() + "' and id_hp = '" + hpSrvorcas[i].getId_hp() + "' and eu_hpsrvtp = '" + hpSrvorcas[i].getEu_hpsrvtp() + "') or ");
			}
		}
		srvctrwherePart.append(" ) ");
		DAFacade daFacade = new DAFacade();
		daFacade.deleteByWhere(BdHpSrvctrDO.class, srvctrwherePart.toString());
	}
}
