package iih.pi.dic.patcate.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.utils.BdEnvContextUtil;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @author dj.zhang
 *
 */
public class FindPatCateUIDTOsByWherePartSql implements ITransQry {

	private String _whereStr;
	private String _orderStr;

	public FindPatCateUIDTOsByWherePartSql(String whereStr, String orderStr) {
		this._orderStr = orderStr;
		this._whereStr = whereStr;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();

		String baseSql = getBaseSql();
		sqlBuilder.append(baseSql);

		String wherePart = getWherePart();
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" WHERE ");
			sqlBuilder.append(wherePart);
		}

		if (StringUtils.isNotEmpty(this._orderStr)) {
			sqlBuilder.append(" ORDER BY ");
			sqlBuilder.append(this._orderStr);
		}
		return sqlBuilder.toString();
	}

	/**
	 * 获取基础脚本
	 * 
	 * @return
	 */
	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT PATCA.ID_PATCA,PATCA.SORTNO, ");
		sqlBuilder.append(" PATCA.ID_ORG, ");
		sqlBuilder.append(" PATCA.ID_GRP, ");
		sqlBuilder.append(" PATCA.CODE, ");
		sqlBuilder.append(" PATCA.NAME, ");
		sqlBuilder.append(" PATCA.WBCODE, ");
		sqlBuilder.append(" PATCA.PYCODE, ");
		sqlBuilder.append(" PATCA.MNECODE, ");
		sqlBuilder.append(" PATCA.DES, ");
		sqlBuilder.append(" PATCA.ID_PATPRITP, ");
		sqlBuilder.append(" PATPRICA.NAME AS PATPRITP_NAME, ");
		sqlBuilder.append(" PATCA.ID_PATCRETTP, ");
		sqlBuilder.append(" PATCRET.NAME AS PATCRETTP_NAME, ");
		sqlBuilder.append(" PATCA.ID_PARENT, ");
		sqlBuilder.append(" PARENTCATE.NAME AS PARENT_NAME, ");
		sqlBuilder.append(" PATCA.INNERCODE, ");
		sqlBuilder.append(" PATCA.FG_DEF, ");
		sqlBuilder.append(" PATCA.CODE_CHIS, ");
		sqlBuilder.append(" PATCA.FG_OP, ");
		sqlBuilder.append(" PATCA.FG_ER, ");
		sqlBuilder.append(" PATCA.FG_IP, ");
		sqlBuilder.append(" PATCA.FG_PE, ");
		sqlBuilder.append(" PATCA.FG_FM, ");
		sqlBuilder.append(" PATCA.Fg_Use_Er1, ");
		sqlBuilder.append(" PATCA.Fg_Use_Er2, ");
		sqlBuilder.append(" PATCAHP.ID_PATCAHP, ");
		sqlBuilder.append(" PATCAHP.ID_HP, ");
		sqlBuilder.append(" HP.CODE AS HP_CODE, ");
		sqlBuilder.append(" HP.NAME AS HP_NAME, ");
		sqlBuilder.append(" PATCAHP.FG_FUNDPAY, ");
		sqlBuilder.append(" PATCAHP.FG_HP_CARD, ");
		sqlBuilder.append(" PATCAHP.ID_HPKIND, ");
		sqlBuilder.append(" HPKIND.CODE_HPKIND AS HPKIND_CODE, ");
		sqlBuilder.append(" HPKIND.NAME_HPKIND AS HPKIND_NAME, ");
		sqlBuilder.append(" PATCAHP.FG_HP_SPCL, ");
		sqlBuilder.append(" PATCAHP.ID_HPPATSOURCE, ");
		sqlBuilder.append(" PATCAHP.SD_HPPATSOURCE, ");
		sqlBuilder.append(" PATSOURCE.NAME AS HPPATSOURCE_NAME, ");
		sqlBuilder.append(" AH.id_hpmedkindah id_medkind_oepdft, ");
		sqlBuilder.append(" AH.code code_medkind_oepdft, ");
		sqlBuilder.append(" AH.NAME name_medkind_oepdft, ");
		sqlBuilder.append(" PATCAHP.eu_ident_read, ");
		sqlBuilder.append(" PATCAHP.fg_self_upload ");
		sqlBuilder.append(" FROM PI_PAT_CA PATCA ");
		sqlBuilder.append(" LEFT JOIN PI_PAT_CA_HP PATCAHP ");
		sqlBuilder.append(" ON PATCA.ID_PATCA = PATCAHP.ID_PATCA ");
		sqlBuilder.append(" LEFT JOIN bd_hp_med_kind_ah AH ");
		sqlBuilder.append(" ON AH.id_hpmedkindah=PATCAHP.id_medkind_oepdft ");
		sqlBuilder.append(" LEFT JOIN BD_HP HP ");
		sqlBuilder.append(" ON PATCAHP.ID_HP = HP.ID_HP ");
		sqlBuilder.append(" LEFT JOIN BD_HP_KIND HPKIND ");
		sqlBuilder.append(" ON PATCAHP.ID_HPKIND = HPKIND.ID_HPKIND ");
		sqlBuilder.append(" LEFT JOIN BD_PRI_PAT PATPRICA ");
		sqlBuilder.append(" ON PATPRICA.ID_PRIPAT = PATCA.ID_PATPRITP ");
		sqlBuilder.append(" LEFT JOIN PI_PAT_CRET PATCRET ");
		sqlBuilder.append(" ON PATCRET.ID_PATCRET = PATCA.ID_PATCRETTP ");
		sqlBuilder.append(" LEFT JOIN PI_PAT_CA PARENTCATE ");
		sqlBuilder.append(" ON PARENTCATE.ID_PATCA = PATCA.ID_PARENT ");
		sqlBuilder.append(" LEFT JOIN BD_UDIDOC PATSOURCE ");
		sqlBuilder.append(" ON PATSOURCE.ID_UDIDOC = PATCAHP.ID_HPPATSOURCE ");

		return sqlBuilder.toString();
	}

	/**
	 * 获取条件语句
	 * 
	 * @return
	 */
	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		if (this._whereStr != null) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._whereStr);
		}

		String wherePart = BdEnvContextUtil.processEnvContext(new PiPatCaDO(), "PATCA");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}
		return wherePartBuilder.toString();
	}

}
