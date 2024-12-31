package iih.bd.mhi.hpdrugdircomp.s.bp.sql;

import org.apache.commons.lang3.StringUtils;

import iih.bd.mhi.hpdrug.d.HpDrugDO;
import iih.bd.mhi.hpdrugdircomp.d.HpDrugDirCompDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @author hexx
 * 
 * 通过名称查找sql
 */
public class AutoCompHpDrugByNameSql implements ITransQry {

	private String _hpId;

	public AutoCompHpDrugByNameSql(String hpId) {
		this._hpId = hpId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(this._hpId);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder baseSQL = new StringBuilder();
		baseSQL.append(" SELECT BDMM.ID_MM AS ID_DRUG ,                                 ");
		baseSQL.append("   HPDRUG.CODE			  				");
		baseSQL.append(" FROM				  				");
		baseSQL.append("   (SELECT ID_MM,		  				");
		baseSQL.append("     CODE,			  				");
		baseSQL.append("     NAME			  				");
		baseSQL.append("   FROM BD_MM			  				");
		baseSQL.append("   WHERE   1 = 1				");

		String wherePart = BdEnvContextUtil.processEnvContext(new MeterialDO(), "BD_MM");
		if (StringUtils.isNotEmpty(wherePart)) {
			baseSQL.append(" AND ");
			baseSQL.append(wherePart);
		}

		baseSQL.append("   AND ID_MM NOT IN		       				");
		baseSQL.append("     (SELECT ID_DRUG FROM BD_HP_COMP_DRUG WHERE ID_HP = ?   	");

		wherePart = BdEnvContextUtil.processEnvContext(new HpDrugDirCompDO(), "BD_HP_COMP_DRUG");
		if (StringUtils.isNotEmpty(wherePart)) {
			baseSQL.append(" AND ");
			baseSQL.append(wherePart);
		}

		baseSQL.append("     )				       				");
		baseSQL.append("   ) BDMM			       				");
		baseSQL.append(" INNER JOIN			       				");
		baseSQL.append("   (SELECT MIN(BD_HP_DRUG.CODE) AS CODE,	       		");
		baseSQL.append("     BD_HP_DRUG.NAME		       				");
		baseSQL.append("   FROM BD_HP_DRUG WHERE ID_HP = ?		       		");

		wherePart = BdEnvContextUtil.processEnvContext(new HpDrugDO(), "BD_HP_DRUG");
		if (StringUtils.isNotEmpty(wherePart)) {
			baseSQL.append(" AND ");
			baseSQL.append(wherePart);
		}

		baseSQL.append("   GROUP BY BD_HP_DRUG.NAME	       				");
		baseSQL.append("   ) HPDRUG			       				");
		baseSQL.append(" ON HPDRUG.NAME = BDMM.NAME 	       				");

		return baseSQL.toString();
	}
}
