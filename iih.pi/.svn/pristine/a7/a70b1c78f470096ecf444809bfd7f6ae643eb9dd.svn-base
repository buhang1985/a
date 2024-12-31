package iih.pi.reg.s.bp.qry;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.utils.BdEnvContextUtil;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.desc.PatDODesc;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 通过患者主键查询患者基本信息
 * 
 * @author hao_wu
 *
 */
public class FindPiPatBasicInfoByPatIdsQry implements ITransQry {

	/**
	 * 患者主键集合
	 */
	private String[] _patIds;

	public FindPiPatBasicInfoByPatIdsQry(String[] patIds) {
		this._patIds = patIds;
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
		sqlBuilder.append(" WHERE ");
		sqlBuilder.append(wherePart);

		return sqlBuilder.toString();
	}

	/**
	 * 获取基础Sql
	 * 
	 * @return
	 */
	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT a0.ID_PAT,			       ");
		sqlBuilder.append("   a0.ID_ORG,			       ");
		sqlBuilder.append("   a0.ID_GRP,			       ");
		sqlBuilder.append("   a0.CODE,				       ");
		sqlBuilder.append("   a0.NAME,				       ");
		sqlBuilder.append("   a0.WBCODE,			       ");
		sqlBuilder.append("   a0.PYCODE,			       ");
		sqlBuilder.append("   a0.MNECODE,			       ");
		sqlBuilder.append("   a0.ID_IDTP,			       ");
		sqlBuilder.append("   a0b4.NAME AS IDTP_NAME,		       ");
		sqlBuilder.append("   a0.SD_IDTP,			       ");
		sqlBuilder.append("   a0.ID_CODE,			       ");
		sqlBuilder.append("   a0.ID_PATICATE,			       ");
		sqlBuilder.append("   a0b5.NAME AS PATICATE_NAME,	       ");
		sqlBuilder.append("   a0.ID_PATPRITP,			       ");
		sqlBuilder.append("   a0b6.NAME AS PATPRITP_NAME,	       ");
		sqlBuilder.append("   a0.ID_PATCRETTP,			       ");
		sqlBuilder.append("   a0b7.NAME AS PATCRETTP_NAME,	       ");
		sqlBuilder.append("   a0.ID_SEX,			       ");
		sqlBuilder.append("   a0b14.NAME AS SEX_NAME,		       ");
		sqlBuilder.append("   a0.SD_SEX,			       ");
		sqlBuilder.append("   a0.DT_BIRTH,			       ");
		sqlBuilder.append("   a0.TEL,				       ");
		sqlBuilder.append("   a0.MOB,				       ");
		sqlBuilder.append("   a0.ID_NATION,			       ");
		sqlBuilder.append("   a0b8.NAME AS NATION_NAME,		       ");
		sqlBuilder.append("   a0.SD_NATION,			       ");
		sqlBuilder.append("   a0.ID_COUNTRY,			       ");
		sqlBuilder.append("   a0b9.NAME AS COUNTRY_NAME,	       ");
		sqlBuilder.append("   a0.SD_COUNTRY,			       ");
		sqlBuilder.append("   a0.ID_SRCREGIONTP,		       ");
		sqlBuilder.append("   a0b17.NAME AS SRCREGIONTP_NAME,	       ");
		sqlBuilder.append("   a0.SD_SRCREGIONTP,		       ");
		sqlBuilder.append("   a0.ID_MARRY,			       ");
		sqlBuilder.append("   a0b10.NAME AS MARRY_NAME,		       ");
		sqlBuilder.append("   a0.SD_MARRY,			       ");
		sqlBuilder.append("   a0.ID_OCCU,			       ");
		sqlBuilder.append("   a0b11.NAME AS OCCU_NAME,		       ");
		sqlBuilder.append("   a0.SD_OCCU,			       ");
		sqlBuilder.append("   a0.WORKUNIT,			       ");
		sqlBuilder.append("   a0.CODE_AMR_OEP,			       ");
		sqlBuilder.append("   a0.CODE_AMR_IP,			       ");
		sqlBuilder.append("   a0.PHOTO,				       ");
		sqlBuilder.append("   a0.ID_LOG,			       ");
		sqlBuilder.append("   a0.ID_PIINVDMD,			       ");
		sqlBuilder.append("   a0.SD_PIINVDMD,			       ");
		sqlBuilder.append("   a0.PRIINVDDES,			       ");
		sqlBuilder.append("   a0.FG_INVD,			       ");
		sqlBuilder.append("   a0.FG_REALNAME,			       ");
		sqlBuilder.append("   a0.ID_EDUC,			       ");
		sqlBuilder.append("   a0b15.NAME AS EDUC_NAME,		       ");
		sqlBuilder.append("   a0.SD_EDUC,			       ");
		sqlBuilder.append("   a0.ID_PATSRCTP,			       ");
		sqlBuilder.append("   a0b18.NAME AS PATSRCTP_NAME,	       ");
		sqlBuilder.append("   a0.SD_PATSRCTP,			       ");
		sqlBuilder.append("   a0.BARCODE_CHIS			       ");
		sqlBuilder.append(" FROM pi_pat a0			       ");
		sqlBuilder.append(" LEFT JOIN bd_udidoc a0b4		       ");
		sqlBuilder.append(" ON a0.ID_IDTP = a0b4.ID_UDIDOC	       ");
		sqlBuilder.append(" LEFT JOIN pi_pat_ca a0b5		       ");
		sqlBuilder.append(" ON a0.ID_PATICATE = a0b5.ID_PATCA	       ");
		sqlBuilder.append(" LEFT JOIN bd_pri_pat a0b6		       ");
		sqlBuilder.append(" ON a0.ID_PATPRITP = a0b6.ID_PRIPAT	       ");
		sqlBuilder.append(" LEFT JOIN pi_pat_cret a0b7		       ");
		sqlBuilder.append(" ON a0.ID_PATCRETTP = a0b7.ID_PATCRET       ");
		sqlBuilder.append(" LEFT JOIN bd_udidoc a0b14		       ");
		sqlBuilder.append(" ON a0.ID_SEX = a0b14.ID_UDIDOC	       ");
		sqlBuilder.append(" LEFT JOIN bd_udidoc a0b8		       ");
		sqlBuilder.append(" ON a0.ID_NATION = a0b8.ID_UDIDOC	       ");
		sqlBuilder.append(" LEFT JOIN bd_country a0b9		       ");
		sqlBuilder.append(" ON a0.ID_COUNTRY = a0b9.ID_COUNTRYZONE     ");
		sqlBuilder.append(" LEFT JOIN bd_udidoc a0b17		       ");
		sqlBuilder.append(" ON a0.ID_SRCREGIONTP = a0b17.ID_UDIDOC     ");
		sqlBuilder.append(" LEFT JOIN bd_udidoc a0b10		       ");
		sqlBuilder.append(" ON a0.ID_MARRY = a0b10.ID_UDIDOC	       ");
		sqlBuilder.append(" LEFT JOIN bd_udidoc a0b11		       ");
		sqlBuilder.append(" ON a0.ID_OCCU = a0b11.ID_UDIDOC	       ");
		sqlBuilder.append(" LEFT JOIN bd_udidoc a0b15		       ");
		sqlBuilder.append(" ON a0.ID_EDUC = a0b15.ID_UDIDOC	       ");
		sqlBuilder.append(" LEFT JOIN bd_udidoc a0b18		       ");
		sqlBuilder.append(" ON a0.ID_PATSRCTP = a0b18.ID_UDIDOC	       ");

		return sqlBuilder.toString();
	}

	/**
	 * 获取条件语句
	 * 
	 * @return
	 */
	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String wherePart = BdEnvContextUtil.processEnvContext(new PatDO(), true);
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		if (this._patIds != null && this._patIds.length > 0) {
			wherePart = SqlUtils.getInSqlByIds(PatDO.ID_PAT, this._patIds);
			if (StringUtils.isNotEmpty(wherePart)) {
				wherePartBuilder.append(" AND ");
				wherePartBuilder.append(wherePart);
			}
		}

		return wherePartBuilder.toString();
	}
}
