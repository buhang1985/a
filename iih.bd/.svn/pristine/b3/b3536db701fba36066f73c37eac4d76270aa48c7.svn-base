package iih.bd.pp.hpsrvorca.bp;

import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.srvctrdi.d.BdHpSrvCtrDiDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAFacade;

public class HpSrvCtrDiDeleteBp {

	public void exec(HPSrvorcaDO[] hpSrvorcas) throws BizException{
		if (hpSrvorcas == null || hpSrvorcas.length <= 0) {
			return;
		}
		DeleteData(hpSrvorcas);
	}
	
	/**
	 * 删除医保计划_控制策略_诊断
	 * 
	 * @param hpSrvorcas
	 * @throws BizException
	 */
	private void DeleteData(HPSrvorcaDO[] hpSrvorcas) throws BizException {
		StringBuilder srvctrwherePart = new StringBuilder();
		srvctrwherePart.append("id_grp = '" + Context.get().getGroupId() + "' and id_org = '" + Context.get().getOrgId() + "' and (");
		for (int i = 0; i < hpSrvorcas.length; i++) {
			if(i == hpSrvorcas.length-1){
				srvctrwherePart.append(" (code_srv_hp = '" + hpSrvorcas[i].getCode() + "' and id_hp = '" + hpSrvorcas[i].getId_hp() + "' and eu_hpsrvtp = '" + hpSrvorcas[i].getEu_hpsrvtp() + "') ");
			}else{
				srvctrwherePart.append(" (code_srv_hp = '" + hpSrvorcas[i].getCode() + "' and id_hp = '" + hpSrvorcas[i].getId_hp() + "' and eu_hpsrvtp = '" + hpSrvorcas[i].getEu_hpsrvtp() + "') or ");
			}
		}
		srvctrwherePart.append(" ) ");
		DAFacade daFacade = new DAFacade();
		daFacade.deleteByWhere(BdHpSrvCtrDiDO.class, srvctrwherePart.toString());
		
	}
}
