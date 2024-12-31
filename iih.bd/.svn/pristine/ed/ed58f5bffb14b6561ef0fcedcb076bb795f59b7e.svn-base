package iih.bd.srv.medsrv.s.rule;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.pp.prisrv.d.PriSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 删除定价模式为本服务定价的医疗服务前删除对应的价表数据
 * 
 * @author hao_wu
 *
 */
@SuppressWarnings("rawtypes")
public class DelPriSrvBeforeDelMedSrvRule implements IRule {

	/**
	 * 真删除标识
	 */
	private FBoolean _realDel;

	public DelPriSrvBeforeDelMedSrvRule(FBoolean realDel) {
		this._realDel = realDel;
	}

	@Override
	public void process(Object... arg0) throws BizException {
		if (arg0 == null || arg0.length <= 0) {
			return;
		}
		Object object = arg0[0];
		if (object instanceof MedsrvAggDO) {
			DelPriSrv((MedsrvAggDO[]) arg0);
		} else if (object instanceof MedSrvDO) {
			DelPriSrv((MedSrvDO[]) arg0);
		}
	}

	/**
	 * 删除价表数据
	 * 
	 * @param medSrvDOs
	 * @throws BizException
	 */
	private void DelPriSrv(MedSrvDO[] medSrvDOs) throws BizException {
		String[] srvIds = GetSrvIds(medSrvDOs);
		DelPriSrvBySrvIds(srvIds);
	}

	/**
	 * 删除价表数据
	 * 
	 * @param medsrvAggDOs
	 * @throws BizException
	 */
	private void DelPriSrv(MedsrvAggDO[] medsrvAggDOs) throws BizException {
		String[] srvIds = GetSrvIds(medsrvAggDOs);
		DelPriSrvBySrvIds(srvIds);
	}

	/**
	 * 获取服务主键组
	 * 
	 * @param medSrvDOs
	 * @return
	 */
	private String[] GetSrvIds(MedSrvDO[] medSrvDOs) {
		ArrayList<String> srvIds = new ArrayList<String>();
		for (MedSrvDO medSrvDO : medSrvDOs) {
			String srvId = GetSrvId(medSrvDO);
			if (!StringUtils.isEmpty(srvId)) {
				srvIds.add(srvId);
			}
		}
		return srvIds.toArray(new String[0]);
	}

	/**
	 * 获取服务主键组
	 * 
	 * @param medsrvAggDOs
	 * @return
	 */
	private String[] GetSrvIds(MedsrvAggDO[] medsrvAggDOs) {
		ArrayList<String> srvIds = new ArrayList<String>();
		for (MedsrvAggDO medsrvAggDO : medsrvAggDOs) {
			String srvId = GetSrvId(medsrvAggDO.getParentDO());
			if (!StringUtils.isEmpty(srvId)) {
				srvIds.add(srvId);
			}
		}
		return srvIds.toArray(new String[0]);
	}

	/**
	 * 获取服务主键
	 * 
	 * @param medSrvDO
	 * @return
	 */
	private String GetSrvId(MedSrvDO medSrvDO) {
		if (IBdPrimdCodeConst.CODE_PRI_SRV.equals(medSrvDO.getSd_primd())) {
			return medSrvDO.getId_srv();
		}
		return null;
	}

	/**
	 * 根据服务主键组删除价表数据
	 * 
	 * @param srvIds
	 * @throws BizException
	 */
	private void DelPriSrvBySrvIds(String[] srvIds) throws BizException {
		if (srvIds == null || srvIds.length <= 0) {
			return;
		}

		if (this._realDel.equals(FBoolean.TRUE)) {
			RealDelPriSrvBySrvIds(srvIds);
		} else {
			LogicDeletePriSrvBySrvIds(srvIds);
		}
	}

	/**
	 * 根据服务主键组逻辑删除价表数据
	 * 
	 * @param srvIds
	 * @throws BizException
	 */
	private void LogicDeletePriSrvBySrvIds(String[] srvIds) throws BizException {
		String logicDeleteSql = GetLogicDeleteSql(srvIds);

		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate(logicDeleteSql);
	}

	/**
	 * 获取逻辑删除脚本
	 * 
	 * @param srvIds
	 * @return
	 */
	private String GetLogicDeleteSql(String[] srvIds) {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("update BD_PRI_SRV set ds = 1");

		String wherePart = BuildWherePart(srvIds);
		sqlBuilder.append(" where ");
		sqlBuilder.append(wherePart);

		return sqlBuilder.toString();
	}

	/**
	 * 根据服务主键组物理删除价表数据
	 * 
	 * @param srvIds
	 * @throws BizException
	 */
	private void RealDelPriSrvBySrvIds(String[] srvIds) throws BizException {
		String wherePart = BuildWherePart(srvIds);
		DAFacade daFacade = new DAFacade();
		daFacade.deleteByWhere(PriSrvDO.class, wherePart);
	}

	/**
	 * 使用服务主键组构建条件语句
	 * 
	 * @param srvIds
	 * @return
	 */
	private String BuildWherePart(String[] srvIds) {
		StringBuilder wherePartBuilder = new StringBuilder(" 1 = 1 ");

		// 管控条件
		String wherePart = BdEnvContextUtil.processEnvContext(new PriSrvDO(), false);
		if (!StringUtils.isEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		// 服务主键过滤条件
		wherePart = SqlUtils.getInSqlByBigIds(PriSrvDO.ID_SRV, srvIds);
		if (!StringUtils.isEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		return wherePartBuilder.toString();
	}
}
