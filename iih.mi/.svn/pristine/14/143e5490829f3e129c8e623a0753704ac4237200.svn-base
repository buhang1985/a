package iih.mi.inst.bizgrp.tonglingcity.bp;

import java.util.ArrayList;

import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.mi.bd.d.HpDTO;
import iih.mi.inst.bizgrp.tonglingcity.bp.qry.RefreshDrugCompSql;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 刷新药品对照业务逻辑
 * 
 * @author hao_wu
 *
 */
public class RefreshDrugCompBp {
	public void exec(HpDTO hpDTO) throws BizException {
		RefreshDrugComp(hpDTO);
	}

	@SuppressWarnings("unchecked")
	private void RefreshDrugComp(HpDTO hpDTO) throws BizException {
		DAFacade daFacade = new DAFacade();
		RefreshDrugCompSql sql = new RefreshDrugCompSql(hpDTO.getId_hp());
		ArrayList<HPSrvorcaDO> hpSrvorcaDOList = (ArrayList<HPSrvorcaDO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(HPSrvorcaDO.class));
		daFacade.insertDOs(hpSrvorcaDOList.toArray(new HPSrvorcaDO[0]));
	}
}
