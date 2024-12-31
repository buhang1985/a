package iih.pi.reg.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.utils.BdEnvContextUtil;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.patbbr.d.PiPatBbrDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 检查患者不良记录业务逻辑
 * 
 * @author hao_wu
 *
 */
public class CheckPatBadRecBp {

	public FBoolean exec(String patCode, String badRecTpCode) throws BizException {
		if (StringUtils.isEmpty(patCode)) {
			throw new BizException("患者编码不允许为空。");
		}
		if (StringUtils.isEmpty(badRecTpCode)) {
			throw new BizException("不良记录类型编码不允许为空。");
		}

		FBoolean result = checkPatBadRec(patCode, badRecTpCode);
		return result;
	}

	/**
	 * 检查患者不良记录
	 * 
	 * @author hao_wu
	 * @param patCode
	 * @param badRecTpCode
	 * @return
	 * @throws BizException
	 */
	private FBoolean checkPatBadRec(String patCode, String badRecTpCode) throws BizException {
		Integer patBadRecCount = findPatBadRecCount(patCode, badRecTpCode);
		if (patBadRecCount != null && patBadRecCount > 0) {
			return FBoolean.TRUE;
		}
		return FBoolean.FALSE;
	}

	/**
	 * 查询患者不良记录条数
	 * 
	 * @author hao_wu
	 * @param patCode
	 * @param badRecTpCode
	 * @return
	 * @throws BizException
	 */
	private Integer findPatBadRecCount(String patCode, String badRecTpCode) throws BizException {
		String sql = getFindPatBadRecCounSql();

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(patCode);
		sqlParam.addParam(badRecTpCode);

		DAFacade daFacade = new DAFacade();
		Integer badRecCount = (Integer) daFacade.execQuery(sql, sqlParam, new ColumnHandler("count"));
		return badRecCount;
	}

	/**
	 * 获取查询患者不良记录条数SQL
	 * 
	 * @author hao_wu
	 * @return
	 */
	private String getFindPatBadRecCounSql() {
		StringBuilder sqlBuilder = new StringBuilder();

		sqlBuilder.append(" SELECT COUNT(*) AS COUNT ");
		sqlBuilder.append(" FROM PI_PAT_BBR BBR ");
		sqlBuilder.append(" JOIN PI_PAT PI ");
		sqlBuilder.append(" ON BBR.ID_PAT = PI.ID_PAT ");
		sqlBuilder.append(" WHERE PI.CODE = ? ");
		sqlBuilder.append(" AND BBR.SD_BBRTP = ? ");
		sqlBuilder.append(" AND BBR.FG_ACTIVE = 'Y' ");

		String wherePart = BdEnvContextUtil.processEnvContext(new PatDO(), "PI");
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}

		wherePart = BdEnvContextUtil.processEnvContext(new PiPatBbrDO(), "BBR");
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}

		return sqlBuilder.toString();
	}

}
