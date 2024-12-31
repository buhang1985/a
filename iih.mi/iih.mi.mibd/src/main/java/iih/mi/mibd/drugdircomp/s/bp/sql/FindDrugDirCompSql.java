package iih.mi.mibd.drugdircomp.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.mi.mibd.docenum.d.DirCompState;
import iih.mi.mibd.drug.d.DrugDO;
import iih.mi.mibd.drugdircomp.d.DrugdircompDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 查询药品对照SQL
 * 
 * @author hexx
 *
 */
public class FindDrugDirCompSql implements ITransQry {
	private String _wherePart;
	private String _misId;
	public FindDrugDirCompSql(String misId, String wherePart) {
		this._wherePart = wherePart;
		this._misId = misId;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(DirCompState.NOT_COMP);
		sqlParam.addParam(this._misId);
		sqlParam.addParam(this._misId);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String sql = GetBaseSql();
		String wherePart = GetWherePart();
		return String.format("%s WHERE %s", sql, wherePart);
	}

	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		if (this._wherePart != null) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}
		return wherePartBuilder.toString();
	}
	private String GetBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		  sqlBuilder.append(" SELECT MI_BD_COMP_DRUG.ID_COMP_DRUG as Id_drugcomp,		 ");
		  sqlBuilder.append(" MI_BD_COMP_DRUG.ID_GRP,						 ");
		  sqlBuilder.append(" MI_BD_COMP_DRUG.ID_ORG,						 ");
		  sqlBuilder.append(" MI_BD_COMP_DRUG.ID_MIS,						 ");
		  sqlBuilder.append(" MI_BD_COMP_DRUG.CODE,						 ");
		  sqlBuilder.append(" DECODE(MI_BD_COMP_DRUG.EU_STATUS,NULL,?,                         	 ");
		  sqlBuilder.append(" MI_BD_COMP_DRUG.EU_STATUS) AS EU_STATUS,                         	 ");
		  sqlBuilder.append(" MI_BD_COMP_DRUG.DT_APPROVED,					 ");
		  sqlBuilder.append(" MI_BD_COMP_DRUG.CREATEDBY,					 ");
		  sqlBuilder.append(" MI_BD_COMP_DRUG.CREATEDTIME,					 ");
		  sqlBuilder.append(" MI_BD_COMP_DRUG.MODIFIEDBY,					 ");
		  sqlBuilder.append(" MI_BD_COMP_DRUG.MODIFIEDTIME,					 ");
		  sqlBuilder.append(" MI_BD_COMP_DRUG.DS,						 ");
		  sqlBuilder.append(" MI_BD_COMP_DRUG.SV,						 ");

		  sqlBuilder.append(" MI_BD_DRUG.NAME AS NAME_GENERIC,                                   ");       
		  sqlBuilder.append(" MI_BD_DRUG.EU_FEELEVEL AS EU_FEELEVEL,                           	 ");
		  sqlBuilder.append(" MI_BD_DRUG.PRI_MAX AS PRI_MAX,                                   	 ");

		  sqlBuilder.append(" BD_MM.ID_MM AS ID_DRUG,						 ");
		  sqlBuilder.append(" BD_MM.NAME   AS DRUG_NAME,					 ");
		  sqlBuilder.append(" BD_MM.CODE   AS DRUG_CODE,					 ");
		  sqlBuilder.append(" MEASDOC.NAME  AS DRUG_UNIT,					 ");
		  sqlBuilder.append(" BD_MM.PRICE    AS DRUG_PRICE					 ");

		  sqlBuilder.append(" FROM BD_MM							 ");	
		  sqlBuilder.append(" LEFT JOIN MI_BD_COMP_DRUG						 ");
		  sqlBuilder.append(" ON BD_MM.ID_MM            = MI_BD_COMP_DRUG.ID_DRUG		 ");
		  sqlBuilder.append(" AND MI_BD_COMP_DRUG.ID_MIS = ?					 ");
		  
		   String wherePart = BdEnvContextUtil.processEnvContext(new DrugdircompDO(), "MI_BD_COMP_DRUG");
			if (StringUtils.isNotEmpty(wherePart)) {
					sqlBuilder.append(" AND ");
					sqlBuilder.append(wherePart);
			}

		  sqlBuilder.append(" LEFT JOIN MI_BD_DRUG						 ");
		  sqlBuilder.append(" ON MI_BD_COMP_DRUG.CODE = MI_BD_DRUG.CODE				 ");
		  sqlBuilder.append(" AND MI_BD_DRUG.ID_MIS   = ?					 ");

		   wherePart = BdEnvContextUtil.processEnvContext(new DrugDO(), "MI_BD_DRUG");
		   if (StringUtils.isNotEmpty(wherePart)) {
					sqlBuilder.append(" AND ");
					sqlBuilder.append(wherePart);
		    }

		  sqlBuilder.append(" LEFT JOIN BD_MEASDOC MEASDOC					 ");
		  sqlBuilder.append(" ON MEASDOC.ID_MEASDOC = BD_MM.ID_UNIT_PKGSP			 ");	

		  wherePart = BdEnvContextUtil.processEnvContext(new MeasDocDO(), "MEASDOC");
		  if (StringUtils.isNotEmpty(wherePart)) {
					sqlBuilder.append(" AND ");
					sqlBuilder.append(wherePart);
		  }	
		return sqlBuilder.toString();
	}
}
