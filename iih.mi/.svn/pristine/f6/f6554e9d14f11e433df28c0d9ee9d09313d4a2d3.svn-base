package iih.mi.inst.bizgrp.tonglingcity.bp;

import java.util.ArrayList;

import iih.bd.pp.bdhpsrvctr.d.BdHpSrvctrDO;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import iih.mi.inst.bizgrp.tonglingcity.bp.qry.AutoGenerateSrvctrSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 自动生成医保计划控制策略业务逻辑
 * 
 * @author hao_wu
 *
 */
public class AutoGenerateSrvctrBp {

	public void exec(String hpId, String miSrvTp) throws BizException {
		DeleteUnUsedData(hpId, miSrvTp);
		AutoGenerateSrvctr(hpId, miSrvTp);
	}

	/**
	 * 自动生成医保计划控制策略
	 * 
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void AutoGenerateSrvctr(String hpId, String miSrvTp) throws BizException {
		AutoGenerateSrvctrSql sql = new AutoGenerateSrvctrSql(hpId, miSrvTp);

		DAFacade daFacade = new DAFacade();
		BdHpSrvctrDO[] result = ((ArrayList<BdHpSrvctrDO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(BdHpSrvctrDO.class))).toArray(new BdHpSrvctrDO[0]);
		daFacade.insertDOs(result);
	}

	/**
	 * 删除不使用的医保计划控制策略
	 * 
	 * @throws BizException
	 */
	private void DeleteUnUsedData(String hpId, String miSrvTp) throws BizException {
		String sql = "DELETE FROM BD_HP_SRVCTR WHERE ID_GRP = ? AND ID_ORG = ? AND ID_HP = ? AND EU_HPSRVTP = ? AND CODE NOT IN (SELECT CODE FROM BD_HP_SRVORCA WHERE ID_GRP = ? AND ID_ORG = ? AND ID_HP = ? AND EU_HPSRVTP = ? AND EU_STATUS NOT IN (?,?))";
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		sqlParam.addParam(hpId);
		sqlParam.addParam(miSrvTp);
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		sqlParam.addParam(hpId);
		sqlParam.addParam(miSrvTp);
		sqlParam.addParam(HpStatusEnum.NOT_MATCHED);
		sqlParam.addParam(HpStatusEnum.MATCHED);

		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate(sql, sqlParam);
	}
}
