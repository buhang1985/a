package iih.mi.inst.bizgrp.tonglingcity.bp;

import iih.mi.biz.dto.d.MiSrvTp;
import iih.mi.inst.bizgrp.tonglingcity.bp.qry.SyncInsurDrugDataSql;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 同步医保药品信息
 * 
 * @author hao_wu
 *
 */
public class SyncInsurDrugDataBp {

	public void exec(String hpId, String[] pks) throws BizException {
		SyncInsurDrugData(hpId, pks);
		RefreshIdHpSrvTp(hpId, pks);
		CompletionDtbAndDte(hpId, pks);
	}

	/**
	 * 补全对照表中的dt_b,dt_e字段
	 * 
	 * @param hpId
	 * @param pks
	 * @throws DAException
	 */
	private void CompletionDtbAndDte(String hpId, String[] pks) throws DAException {
		CompletionDtbAndDteBp completionDtbAndDteBp = new CompletionDtbAndDteBp();
		completionDtbAndDteBp.exec(MiSrvTp.DRUG, hpId, pks);
	}

	/**
	 * 同步医保药品信息
	 * 
	 * @throws BizException
	 */
	private void SyncInsurDrugData(String hpId, String[] pks) throws BizException {
		SyncInsurDrugDataSql sql = new SyncInsurDrugDataSql(hpId, pks);
		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate(sql.getQrySQLStr(), sql.getQryParameter(null));
	}

	/**
	 * 刷新通用医保计划目录类型
	 * 
	 * @throws BizException
	 */
	private void RefreshIdHpSrvTp(String hpId, String[] pks) throws BizException {
		RefreshIdHpSrvTpBp bp = new RefreshIdHpSrvTpBp();
		bp.exec(MiSrvTp.DRUG, hpId, pks);
	}
}
