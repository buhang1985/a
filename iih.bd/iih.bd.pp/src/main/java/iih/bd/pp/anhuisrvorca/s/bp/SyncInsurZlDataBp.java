package iih.bd.pp.anhuisrvorca.s.bp;

import iih.bd.pp.anhuisrvorca.s.bp.sql.SyncInsurZlDataSql;
import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 同步医保诊疗信息
 * 
 * @author hao_wu
 *
 */
public class SyncInsurZlDataBp {
	public void exec(String hpId, String[] pks) throws BizException {
		SyncInsurZlData(hpId, pks);
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
		completionDtbAndDteBp.exec(HpSrvTpEnum.ZL, hpId, pks);
	}

	/**
	 * 同步医保诊疗数据
	 * 
	 * @throws BizException
	 */
	private void SyncInsurZlData(String hpId, String[] pks) throws BizException {
		SyncInsurZlDataSql sql = new SyncInsurZlDataSql(hpId, pks);
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
		bp.exec(HpSrvTpEnum.ZL, hpId, pks);
	}
}
