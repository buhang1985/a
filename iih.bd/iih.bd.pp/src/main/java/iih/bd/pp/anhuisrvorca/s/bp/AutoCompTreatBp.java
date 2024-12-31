package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.ArrayList;

import iih.bd.pp.anhuisrvorca.s.bp.sql.AutoCompTreatByCodeSql;
import iih.bd.pp.anhuisrvorca.s.bp.sql.AutoCompTreatByNameSql;
import iih.bd.pp.anhuisrvorca.s.bp.sql.AutoCompTreatSql;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 自动对照诊疗目录业务逻辑
 * 
 * @author hao_wu
 *
 */
public class AutoCompTreatBp {
	public void exec(String hpCode) throws BizException {
		String hpId = GetHpId(hpCode);
		AutoCompTreatByDef8(hpId);
		AutoCompTreatByCode(hpId);
		AutoCompTreatByName(hpId);
	}

	/**
	 * 使用def8字段进行对照
	 * @param hpId
	 * @throws BizException 
	 */
	private void AutoCompTreatByDef8(String hpId) throws BizException {
		DeleteNoMatchedData(hpId);
		String[] pks = AutoCompTreat(hpId);
		SyncInsurTreatData(hpId, pks);
		AutoGenerateSrvctr(hpId);
	}
	

	/**
	 * 使用code字段进行对照
	 * @param hpId
	 * @param pks 
	 * @throws DAException 
	 */
	private void AutoCompTreatByCode(String hpId) throws BizException {
		DeleteNoMatchedData(hpId);
		String[] pks = AutoCompTreatCode(hpId);
		SyncInsurTreatData(hpId, pks);
		AutoGenerateSrvctr(hpId);
	}
	
	/**
	 * 使用name字段进行对照
	 * @param hpId
	 * @param pks 
	 * @throws DAException 
	 */
	private void AutoCompTreatByName(String hpId) throws BizException {
		DeleteNoMatchedData(hpId);
		String[] pks = AutoCompTreatName(hpId);
		SyncInsurTreatData(hpId, pks);
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
		bp.exec(hpId, HpSrvTpEnum.ZL);
	}

	/**
	 * 删除未匹配数据
	 * 
	 * @throws BizException
	 */
	private void DeleteNoMatchedData(String hpId) throws BizException {
		DeleteNoMatchedDataBp bp = new DeleteNoMatchedDataBp();
		bp.exec(hpId, HpSrvTpEnum.ZL);
	}

	/**
	 * 同步医保诊疗数据
	 * 
	 * @throws BizException
	 */
	private void SyncInsurTreatData(String hpId, String[] pks) throws BizException {
		SyncInsurZlDataBp bp = new SyncInsurZlDataBp();
		bp.exec(hpId, pks);
	}

	@SuppressWarnings("unchecked")
	private String[] AutoCompTreat(String hpId) throws BizException {
		DAFacade daFacade = new DAFacade();
		AutoCompTreatSql sql = new AutoCompTreatSql(hpId);
		ArrayList<HPSrvorcaDO> hpSrvorcaDOList = (ArrayList<HPSrvorcaDO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(HPSrvorcaDO.class));
		String[] pks = daFacade.insertDOs(hpSrvorcaDOList.toArray(new HPSrvorcaDO[0]));
		return pks;
	}
	
	@SuppressWarnings("unchecked")
	private String[] AutoCompTreatCode(String hpId) throws BizException {
		DAFacade daFacade = new DAFacade();
		AutoCompTreatByCodeSql sql = new AutoCompTreatByCodeSql(hpId);
		ArrayList<HPSrvorcaDO> hpSrvorcaDOList = (ArrayList<HPSrvorcaDO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(HPSrvorcaDO.class));
		String[] pks = daFacade.insertDOs(hpSrvorcaDOList.toArray(new HPSrvorcaDO[0]));
		return pks;
	}
	
	@SuppressWarnings("unchecked")
	private String[] AutoCompTreatName(String hpId) throws BizException {
		DAFacade daFacade = new DAFacade();
		AutoCompTreatByNameSql sql = new AutoCompTreatByNameSql(hpId);
		ArrayList<HPSrvorcaDO> hpSrvorcaDOList = (ArrayList<HPSrvorcaDO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(HPSrvorcaDO.class));
		String[] pks = daFacade.insertDOs(hpSrvorcaDOList.toArray(new HPSrvorcaDO[0]));
		return pks;
	}
}