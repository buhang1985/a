package iih.mi.inst.bizgrp.tonglingcity.bp;

import java.util.ArrayList;

import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.mi.biz.dto.d.MiSrvTp;
import iih.mi.inst.bizbase.qry.AutoCompSrvfacSql;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 自动对照服务设施目录业务逻辑
 * 
 * @author hao_wu
 *
 */
public class AutoCompSrvfacBp {
	public void exec(String hpId) throws BizException {
		DeleteNoMatchedData(hpId);
		String[] pks = AutoCompFwss(hpId);
		SyncInsurFwssData(hpId, pks);
		AutoGenerateSrvctr(hpId);
	}

	/**
	 * 自动生成医保计划控制策略
	 * 
	 * @throws BizException
	 */
	private void AutoGenerateSrvctr(String hpId) throws BizException {
		AutoGenerateSrvctrBp bp = new AutoGenerateSrvctrBp();
		bp.exec(hpId, MiSrvTp.SRVFAC);
	}

	/**
	 * 删除未匹配数据
	 * 
	 * @throws BizException
	 */
	private void DeleteNoMatchedData(String hpId) throws BizException {
		DeleteNoMatchedDataBp bp = new DeleteNoMatchedDataBp();
		bp.exec(hpId, MiSrvTp.SRVFAC);
	}

	/**
	 * 同步医保服务设施数据
	 * 
	 * @throws BizException
	 */
	private void SyncInsurFwssData(String hpId, String[] pks) throws BizException {
		SyncInsurFwssDataBp bp = new SyncInsurFwssDataBp();
		bp.exec(hpId, pks);
	}

	@SuppressWarnings("unchecked")
	private String[] AutoCompFwss(String hpId) throws BizException {
		DAFacade daFacade = new DAFacade();
		AutoCompSrvfacSql sql = new AutoCompSrvfacSql(hpId);
		ArrayList<HPSrvorcaDO> hpSrvorcaDOList = (ArrayList<HPSrvorcaDO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(HPSrvorcaDO.class));
		String[] pks = daFacade.insertDOs(hpSrvorcaDOList.toArray(new HPSrvorcaDO[0]));
		return pks;
	}
}
