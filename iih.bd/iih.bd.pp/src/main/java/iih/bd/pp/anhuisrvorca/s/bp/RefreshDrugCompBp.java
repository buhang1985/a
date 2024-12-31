package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.ArrayList;

import iih.bd.pp.anhuisrvorca.s.bp.sql.RefreshDrugCompSql;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
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
	public void exec(String hpCode) throws BizException {
		RefreshDrugComp(hpCode);
	}

	@SuppressWarnings("unchecked")
	private void RefreshDrugComp(String hpCode) throws BizException {
		String hpId = GetHpId(hpCode);
		DAFacade daFacade = new DAFacade();
		RefreshDrugCompSql sql = new RefreshDrugCompSql(hpId);
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
