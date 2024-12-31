package iih.mi.bd.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.fc.entp.d.EnTypeDO;
import iih.bd.mhi.hpentpcomp.d.HpEntpCompDO;
import iih.bd.utils.BdEnvContextUtil;
import iih.mi.mibd.entp.d.EnTpDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据医保产品主键和HIS就诊类型主键集合查询就诊类型基础数据
 * 
 * @author hao_wu
 *
 */
public class FindEnTpBaseInfoByHisEnTpIdsQry implements ITransQry {

	/**
	 * 医保产品主键
	 */
	private String _hpId;
	/**
	 * HIS就诊类型主键集合
	 */
	private String[] _hisEnTpIds;

	public FindEnTpBaseInfoByHisEnTpIdsQry(String hpId, String[] hisEnTpIds) {
		this._hpId = hpId;
		this._hisEnTpIds = hisEnTpIds;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer wherePartBuffer) {
		SqlParam sqlParam = new SqlParam();

		if (StringUtils.isNotEmpty(this._hpId)) {
			sqlParam.addParam(this._hpId);
		}

		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();

		String baseSql = getBaseSql();
		sqlBuilder.append(baseSql);

		String wherePart = getWherePart();
		sqlBuilder.append(" WHERE ");
		sqlBuilder.append(wherePart);

		return sqlBuilder.toString();
	}

	/**
	 * 获取基础SQL
	 * 
	 * @return
	 */
	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();

		sqlBuilder.append(" SELECT ENTPCOMP.ID_GRP,				");
		sqlBuilder.append("   ENTPCOMP.ID_ORG,					");
		sqlBuilder.append("   ENTPCOMP.ID_HP,					");
		sqlBuilder.append("   ENTPCOMP.ID_ENTP,					");
		sqlBuilder.append("   BDENTP.CODE ENTP_CODE,					");
		sqlBuilder.append("   BDENTP.NAME ENTP_NAME,					");
		sqlBuilder.append("   HPENTP.CODE AS CODE_HPENTP,		");
		sqlBuilder.append("   HPENTP.NAME AS NAME_HPENTP			");
		sqlBuilder.append(" FROM BD_MHI_COMP_ENTP ENTPCOMP			");
		sqlBuilder.append(" LEFT JOIN BD_MHI_ENTP HPENTP			");
		sqlBuilder.append(" ON ENTPCOMP.ID_HPENTP = HPENTP.ID_HPENTP			");
		sqlBuilder.append(" LEFT JOIN BD_ENTP BDENTP				");
		sqlBuilder.append(" ON ENTPCOMP.ID_ENTP = BDENTP.ID_ENTP		");

		return sqlBuilder.toString();
	}

	/**
	 * 获取条件语句
	 * 
	 * @return
	 */
	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String wherePart = BdEnvContextUtil.processEnvContext(new EnTpDO(), "HPENTP");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		wherePart = BdEnvContextUtil.processEnvContext(new HpEntpCompDO(), "ENTPCOMP");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		wherePart = BdEnvContextUtil.processEnvContext(new EnTypeDO(), "BDENTP");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		if (this._hisEnTpIds != null && this._hisEnTpIds.length > 0) {
			wherePart = SqlUtils.getInSqlByIds("ENTPCOMP.ID_ENTP", this._hisEnTpIds);
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}

		if (StringUtils.isNotEmpty(this._hpId)) {
			wherePartBuilder.append(" AND ENTPCOMP.ID_HP = ?");
		}

		return wherePartBuilder.toString();
	}

}
