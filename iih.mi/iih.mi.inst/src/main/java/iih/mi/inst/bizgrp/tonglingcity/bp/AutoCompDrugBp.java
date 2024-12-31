package iih.mi.inst.bizgrp.tonglingcity.bp;

import java.util.ArrayList;

import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.mi.biz.dto.d.MiSrvTp;
import iih.mi.inst.bizbase.qry.AutoCompDrugSql;
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

	public void exec(String hpId) throws BizException {
		DeleteNoMatchedData(hpId);
		String[] pks = AutoCompDrug(hpId);
		SyncInsurDrugData(hpId, pks);
		AutoGenerateSrvctr(hpId);
	}

	/**
	 * 自动生成医保计划控制策略
	 * 
	 * @throws BizException
	 */
	private void AutoGenerateSrvctr(String hpId) throws BizException {
		AutoGenerateSrvctrBp bp = new AutoGenerateSrvctrBp();
		bp.exec(hpId, MiSrvTp.DRUG);
	}

	/**
	 * 删除未匹配数据
	 * 
	 * @throws BizException
	 */
	private void DeleteNoMatchedData(String hpId) throws BizException {
		DeleteNoMatchedDataBp bp = new DeleteNoMatchedDataBp();
		bp.exec(hpId, MiSrvTp.DRUG);
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
