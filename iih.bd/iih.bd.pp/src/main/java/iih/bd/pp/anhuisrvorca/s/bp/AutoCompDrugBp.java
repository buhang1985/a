package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.ArrayList;

import iih.bd.pp.anhuisrvorca.s.bp.sql.AutoCompDrugSql;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 自动对照药品目录业务逻辑
 * 
 * @author hao_wu
 *
 */
public class AutoCompDrugBp {

	public void exec(String hpCode) throws BizException {
		String hpId = GetHpId(hpCode);
		DeleteNoMatchedData(hpId);
		String[] pks = AutoCompDrug(hpId);
		SyncInsurDrugData(hpId, pks);
		AutoGenerateSrvctr(hpId);
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

	/**
	 * 自动生成医保计划控制策略
	 * 
	 * @throws BizException
	 */
	private void AutoGenerateSrvctr(String hpId) throws BizException {
		AutoGenerateSrvctrBp bp = new AutoGenerateSrvctrBp();
		bp.exec(hpId, HpSrvTpEnum.DRUG);
	}

	/**
	 * 删除未匹配数据
	 * 
	 * @throws BizException
	 */
	private void DeleteNoMatchedData(String hpId) throws BizException {
		DeleteNoMatchedDataBp bp = new DeleteNoMatchedDataBp();
		bp.exec(hpId, HpSrvTpEnum.DRUG);
	}

	/**
	 * 同步医保药品数据
	 * 
	 * @throws BizException
	 */
	private void SyncInsurDrugData(String hpId, String[] pks) throws BizException {
		SyncInsurDrugDataBp bp = new SyncInsurDrugDataBp();
		bp.exec(hpId, pks);
	}

	@SuppressWarnings("unchecked")
	private String[] AutoCompDrug(String hpId) throws BizException {
		DAFacade daFacade = new DAFacade();
		AutoCompDrugSql sql = new AutoCompDrugSql(hpId);
		ArrayList<HPSrvorcaDO> hpSrvorcaDOList = (ArrayList<HPSrvorcaDO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(HPSrvorcaDO.class));
		String[] pks = daFacade.insertDOs(hpSrvorcaDOList.toArray(new HPSrvorcaDO[0]));
		return pks;
	}
}
