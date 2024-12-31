package iih.mi.inst.bizgrp.tonglingcity.bp;

import java.util.ArrayList;

import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.mi.bd.d.HpDTO;
import iih.mi.inst.bizgrp.tonglingcity.bp.qry.RefreshTreatAndFwssCompSql;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 刷新诊疗和服务设施对照
 * 
 * @author hao_wu
 *
 */
public class RefreshTreatAndFwssCompBp {

	public void exec(HpDTO hpDTO) throws BizException {
		RefreshTreatAndFwssComp(hpDTO);
	}

	/**
	 * 刷新诊疗对照
	 * 
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void RefreshTreatAndFwssComp(HpDTO hpDTO) throws BizException {
		DAFacade daFacade = new DAFacade();
		RefreshTreatAndFwssCompSql sql = new RefreshTreatAndFwssCompSql(hpDTO.getId_hp());
		ArrayList<HPSrvorcaDO> hpSrvorcaDOList = (ArrayList<HPSrvorcaDO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(HPSrvorcaDO.class));
		daFacade.insertDOs(hpSrvorcaDOList.toArray(new HPSrvorcaDO[0]));
	}
}
