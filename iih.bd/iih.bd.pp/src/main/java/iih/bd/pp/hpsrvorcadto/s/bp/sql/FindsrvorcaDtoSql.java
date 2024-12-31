package iih.bd.pp.hpsrvorcadto.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

public class FindsrvorcaDtoSql implements ITransQry {

	private String _hpId;
	private String _idRef;
	private String _wherePart;

	public FindsrvorcaDtoSql(String wherePart) {
		this._wherePart = wherePart;
	}
	
	public FindsrvorcaDtoSql(String wherePart, String hpId, String idRef) {
		this._hpId = hpId;
		this._idRef = idRef;
		this._wherePart = wherePart;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		if(this._idRef == null) {
			sqlParam.addParam(this._hpId);
		}else {
			sqlParam.addParam(this._idRef);
		}
		sqlParam.addParam(HpStatusEnum.CONTRAST);
		sqlParam.addParam(HpStatusEnum.UPLOAD);
		sqlParam.addParam(HpStatusEnum.REVIEW);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String sql = GetBaseSql();
		String wherePart = GetWherePart();
		return String.format("%s WHERE %s", sql, wherePart);
	}

	private String GetBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT * FROM (	");
		sqlBuilder.append("SELECT DECODE(BD_HP_SRVORCA.ID_MM,'~',SRV.CODE,MM.CODE) AS HIS_CODE,	");// HIS编码
		sqlBuilder.append("  DECODE(BD_HP_SRVORCA.ID_MM,'~',SRV.NAME,MM.NAME)      AS HIS_NAME,	");// HIS名称
		sqlBuilder.append("  DECODE(BD_HP_SRVORCA.ID_MM,'~',SRV.PYCODE,MM.PYCODE)      AS PYCODE,	");// HIS拼音码
		sqlBuilder.append("  DECODE(BD_HP_SRVORCA.ID_MM,'~',SRV.WBCODE,MM.WBCODE)      AS WBCODE,	");// HIS五笔码
		sqlBuilder.append("  BD_HP_SRVORCA.CODE                                     AS INSUR_CODE,	");// 医保编码
		sqlBuilder.append("  BD_HP_SRVORCA.NAME                                     AS INSUR_NAME,	");// 医保名称
		sqlBuilder.append("  BD_HP_SRVORCA.EU_STATUS,							");// 所属状态
		sqlBuilder.append("  BD_HP_SRVORCA.EU_HPSRVTP,							");// 医保服务类型
		sqlBuilder.append("  BD_HP_SRVORCA.ID_MM							");
		sqlBuilder.append("FROM BD_HP_SRVORCA BD_HP_SRVORCA						");
		sqlBuilder.append("LEFT JOIN BD_SRV SRV							");
		sqlBuilder.append("ON SRV.ID_SRV = BD_HP_SRVORCA.ID_SRV					");
		
		sqlBuilder.append("LEFT JOIN BD_MM MM							");
		sqlBuilder.append("ON MM.ID_MM              = BD_HP_SRVORCA.ID_MM				");
		sqlBuilder.append("WHERE 	BD_HP_SRVORCA.ID_HP = ?			");
		String org = EnvContextUtil.processEnvContext("",new HPSrvorcaDO(),"BD_HP_SRVORCA");
		if(StringUtils.isNotBlank(org)){
			sqlBuilder.append("AND 	").append(org);
		}
		sqlBuilder.append(" ) SRVORCA");
		return sqlBuilder.toString();
	}

	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		wherePartBuilder.append(" AND ");
		wherePartBuilder.append(" SRVORCA.EU_STATUS IN (?,?,?) ");
		if (this._wherePart != null) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}
		return wherePartBuilder.toString();
	}

}
