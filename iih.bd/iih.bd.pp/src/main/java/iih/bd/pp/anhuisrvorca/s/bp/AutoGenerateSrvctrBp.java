package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.ArrayList;

import iih.bd.pp.anhuisrvorca.s.bp.sql.AutoGenerateSrvctrSql;
import iih.bd.pp.bdhpsrvctr.d.BdHpSrvctrDO;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
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

	public void exec(String hpId, Integer euHpSrvTp) throws BizException {
		DeleteUnUsedData(hpId, euHpSrvTp);
		AutoGenerateSrvctr(hpId, euHpSrvTp);
	}

	/**
	 * 自动生成医保计划控制策略
	 * 
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void AutoGenerateSrvctr(String hpId, Integer euHpSrvTp) throws BizException {
		AutoGenerateSrvctrSql sql = new AutoGenerateSrvctrSql(hpId, euHpSrvTp);

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
	private void DeleteUnUsedData(String hpId, Integer euHpSrvTp) throws BizException {
		String sql = "DELETE FROM BD_HP_SRVCTR WHERE ID_GRP = ? AND ID_ORG = ? AND ID_HP = ? AND EU_HPSRVTP = ? AND CODE NOT IN (SELECT CODE FROM BD_HP_SRVORCA WHERE ID_GRP = ? AND ID_ORG = ? AND ID_HP = ? AND EU_HPSRVTP = ? AND EU_STATUS NOT IN (?,?))";
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		sqlParam.addParam(hpId);
		sqlParam.addParam(euHpSrvTp);
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		sqlParam.addParam(hpId);
		sqlParam.addParam(euHpSrvTp);
		sqlParam.addParam(HpStatusEnum.NOT_MATCHED);
		sqlParam.addParam(HpStatusEnum.MATCHED);

		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate(sql, sqlParam);
	}
}
