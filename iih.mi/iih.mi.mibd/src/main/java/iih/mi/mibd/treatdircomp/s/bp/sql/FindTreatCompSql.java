package iih.mi.mibd.treatdircomp.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.mi.mibd.docenum.d.DirCompState;
import iih.mi.mibd.treat.d.TreatDO;
import iih.mi.mibd.treatdircomp.d.TreatdircompDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 查询诊疗服务对照SQL
 * 
 * @author dj.zhang
 *
 */
public class FindTreatCompSql implements ITransQry {

	private String _wherePart;
	private String _misId;

	public FindTreatCompSql(String misId, String wherePart) {
		this._wherePart = wherePart;
		this._misId = misId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
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

	/**
	 * @Title: GetWherePart
	 * @Description: 生成查询条件
	 * @return
	 */
	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String wherePart = String.format(" AND BD_SRV.SD_SRVTP NOT LIKE '%s%%'", IBdSrvDictCodeConst.SD_SRVTP_DRUG);
		wherePartBuilder.append(wherePart);

		wherePart = BdEnvContextUtil.processEnvContext(new MedSrvDO(), "BD_SRV");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		if (this._wherePart != null) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}
		return wherePartBuilder.toString();
	}

	/**
	 * @Title: GetBaseSql
	 * @Description: 生成SQL
	 * @return
	 */
	private String GetBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT MI_BD_COMP_TREAT.ID_COMP_TREAT AS ID_TREATCOMP,						      ");
		sqlBuilder.append("   MI_BD_COMP_TREAT.ID_GRP,								      ");
		sqlBuilder.append("   MI_BD_COMP_TREAT.ID_ORG,								      ");
		sqlBuilder.append("   MI_BD_COMP_TREAT.ID_MIS,								      ");
		sqlBuilder.append("   MI_BD_COMP_TREAT.CODE,								      ");
		sqlBuilder.append("   DECODE(MI_BD_COMP_TREAT.EU_STATUS,NULL,?, ");
		sqlBuilder.append("   MI_BD_COMP_TREAT.EU_STATUS) AS EU_STATUS,    ");
		sqlBuilder.append("   MI_BD_COMP_TREAT.DT_APPROVED,							      ");
		sqlBuilder.append("   MI_BD_COMP_TREAT.CREATEDBY,							      ");
		sqlBuilder.append("   MI_BD_COMP_TREAT.CREATEDTIME,							      ");
		sqlBuilder.append("   MI_BD_COMP_TREAT.MODIFIEDBY,							      ");
		sqlBuilder.append("   MI_BD_COMP_TREAT.MODIFIEDTIME,							      ");
		sqlBuilder.append("   MI_BD_COMP_TREAT.DS,								      ");
		sqlBuilder.append("   MI_BD_COMP_TREAT.SV,								      ");

		sqlBuilder.append("   MI_BD_TREAT.NAME AS NAME, ");
		sqlBuilder.append("   MI_BD_TREAT.EU_FEELEVEL AS EU_FEELEVEL,  ");
		sqlBuilder.append("   MI_BD_TREAT.PRI_MAX AS PRI_MAX,      ");

		sqlBuilder.append("   BD_SRV.ID_SRV AS ID_TREAT,							      ");
		sqlBuilder.append("   BD_SRV.NAME   AS TREAT_NAME,							      ");
		sqlBuilder.append("   BD_SRV.CODE   AS TREAT_CODE,							      ");
		sqlBuilder.append("   MEASDOC.NAME  AS TREAT_UNIT,							      ");
		sqlBuilder.append("   BD_SRV.PRI    AS TREAT_PRICE						      ");

		sqlBuilder.append(" FROM BD_SRV										      ");
		sqlBuilder.append(" LEFT JOIN MI_BD_COMP_TREAT								      ");
		sqlBuilder.append(" ON BD_SRV.ID_SRV = MI_BD_COMP_TREAT.ID_TREAT				      ");
		sqlBuilder.append(" AND MI_BD_COMP_TREAT.ID_MIS = ?							      ");

		String wherePart = BdEnvContextUtil.processEnvContext(new TreatdircompDO(), "MI_BD_COMP_TREAT");
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}

		sqlBuilder.append(" LEFT JOIN MI_BD_TREAT								      ");
		sqlBuilder.append(" ON MI_BD_COMP_TREAT.CODE = MI_BD_TREAT.CODE						      ");
		sqlBuilder.append(" AND MI_BD_TREAT.ID_MIS   = ?							      ");

		wherePart = BdEnvContextUtil.processEnvContext(new TreatDO(), "MI_BD_TREAT");
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}

		sqlBuilder.append(" LEFT JOIN BD_MEASDOC MEASDOC							      ");
		sqlBuilder.append(" ON MEASDOC.ID_MEASDOC = BD_SRV.ID_UNIT_MED					 ");

		wherePart = BdEnvContextUtil.processEnvContext(new MeasDocDO(), "MEASDOC");
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}

		return sqlBuilder.toString();
	}
}
