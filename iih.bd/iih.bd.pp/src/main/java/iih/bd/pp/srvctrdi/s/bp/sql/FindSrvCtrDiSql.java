package iih.bd.pp.srvctrdi.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.srvctrdi.d.BdHpSrvCtrDiDO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 查询医保诊断限制SQL
 * 
 * @author hao_wu
 *
 */
public class FindSrvCtrDiSql implements ITransQry {

	private String _wherePart;

	public FindSrvCtrDiSql(String wherePart) {
		this._wherePart = wherePart;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();
		String baseSql = GetBaseSql();
		sqlBuilder.append(baseSql);
		String wherePart = GetWherePart();
		if (!StringUtil.isEmpty(wherePart)) {
			sqlBuilder.append(" WHERE ");
			sqlBuilder.append(wherePart);
		}
		return sqlBuilder.toString();
	}

	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder(" 1 = 1 ");
		if (!StringUtil.isEmpty(this._wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}
		return wherePartBuilder.toString();
	}

	private String GetBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT * FROM ( ");
		sqlBuilder.append(" SELECT SRVCTR_DI.ID_SRVCTR_ID,		");// 主键
		sqlBuilder.append("   SRVCTR_DI.ID_GRP,			");// 所属集团
		sqlBuilder.append("   SRVCTR_DI.ID_ORG,			");// 所属组织
		sqlBuilder.append("   SRVCTR_DI.ID_HP,			");// 医保计划
		sqlBuilder.append("   SRVCTR_DI.ID_DI_DEF,			");// 医保诊断
		sqlBuilder.append("   SRVCTR_DI.ID_SRV,			");// 
		sqlBuilder.append("   SRVCTR_DI.ID_MM,			");// 
		
		sqlBuilder.append("   SRV.CODE Srv_code,			");// 
		sqlBuilder.append("   SRV.NAME Srv_name,			");// 
		sqlBuilder.append("   MM.CODE Mm_code,			");// 
		sqlBuilder.append("   MM.NAME Mm_name,			");// 
		
		sqlBuilder.append("   DI_DEF.NAME AS DI_DEF_NAME,		");// 医保诊断名称
		sqlBuilder.append("   DI_DEF.CODE AS DI_DEF_CODE,		");// 医保诊断编码
		sqlBuilder.append("   SRVCTR_DI.CODE_SRV_HP,			");// 医保项目编码
		sqlBuilder.append("   SRVORCA.NAME AS NAME_SRV_HP,		");// 医保项目名称
		sqlBuilder.append("   SRVCTR_DI.CREATEDBY,			");// 创建人
		sqlBuilder.append("   SRVCTR_DI.CREATEDTIME,			");// 创建时间
		sqlBuilder.append("   SRVCTR_DI.MODIFIEDBY,			");// 最后修改人
		sqlBuilder.append("   SRVCTR_DI.MODIFIEDTIME,			");// 最后修改时间
		sqlBuilder.append("   SRVCTR_DI.DS,			");
		sqlBuilder.append("   SRVCTR_DI.SV			");
		sqlBuilder.append(" FROM BD_HP_SRVCTR_DI SRVCTR_DI		");
		sqlBuilder.append(" JOIN BD_DI_DEF DI_DEF		");
		sqlBuilder.append(" ON SRVCTR_DI.ID_DI_DEF = DI_DEF.ID_DIDEF	");
		sqlBuilder.append(" LEFT JOIN BD_HP_SRVORCA SRVORCA	");
		sqlBuilder.append(" ON SRVCTR_DI.ID_SRV = SRVORCA.ID_SRV and SRVCTR_DI.ID_HP = SRVORCA.ID_HP	");
		sqlBuilder.append(" and nvl(SRVCTR_DI.ID_MM,'~') = nvl(SRVORCA.ID_MM,'~')	");
		
		sqlBuilder.append(" LEFT JOIN BD_SRV SRV ON SRV.ID_SRV = SRVCTR_DI.ID_SRV	");
		sqlBuilder.append(" LEFT JOIN BD_MM MM ON MM.ID_MM = SRVCTR_DI.ID_MM	");
		
		String org = EnvContextUtil.processEnvContext("", new BdHpSrvCtrDiDO(), "SRVCTR_DI");
		if(StringUtils.isNotBlank(org)){
			sqlBuilder.append(" Where ").append(org);
		}
		
		sqlBuilder.append(" ) A0 ");
		return sqlBuilder.toString();
	}

}
