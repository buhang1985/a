package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.ArrayList;

import iih.bd.pp.anhuisrvorca.s.bp.sql.RefreshTreatAndFwssCompSql;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
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

	public void exec(String hpCode) throws BizException {
		RefreshTreatAndFwssComp(hpCode);
	}

	/**
	 * 刷新诊疗对照
	 * 
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void RefreshTreatAndFwssComp(String hpCode) throws BizException {
		String hpId = GetHpId(hpCode);

		DAFacade daFacade = new DAFacade();
		RefreshTreatAndFwssCompSql sql = new RefreshTreatAndFwssCompSql(hpId);
		ArrayList<HPSrvorcaDO> hpSrvorcaDOList = (ArrayList<HPSrvorcaDO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(HPSrvorcaDO.class));
		daFacade.insertDOs(hpSrvorcaDOList.toArray(new HPSrvorcaDO[0]));
	}

	/**
	 * 获取医保计划主键
	 * 
	 * @param hpCode
	 * @return
	 * @throws BizException
	 */
	private String GetHpId(String hpCode) throws BizException {
		FindHpDoByCodeBp bp = new FindHpDoByCodeBp();
		HPDO hpdo = bp.exec(hpCode);
		return hpdo.getId_hp();
	}
}
