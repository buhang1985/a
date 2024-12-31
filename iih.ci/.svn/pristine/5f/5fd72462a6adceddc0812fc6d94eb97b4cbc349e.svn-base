package iih.ci.mr.cimrpatsigns.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CimrpatSignsSql implements ITransQry {
	private String Code_entp;
	private String Sd_status;
	private String Id_dep_nur;
	private String WhereStr;

	public CimrpatSignsSql(String code_entp, String sd_status,
			String id_dep_nur, String whereStr) {
		Code_entp = code_entp;
		Sd_status = sd_status;
		Id_dep_nur = id_dep_nur;
		WhereStr = whereStr;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam sql = new SqlParam();
		sql.addParam(Code_entp);
		sql.addParam(Sd_status);
		sql.addParam(Id_dep_nur);
		return sql;
	}

	@Override
	public String getQrySQLStr() {
		return getSql();
	}

	private String getSql() {
		return "select "
				+ " enent.id_ent,"
				+ " enent.code,"
				+ " enentip.bebcode,"
				+ " enent.name,"
				+ " (case when id_sex_pat='0' then '未知' when id_sex_pat='1' then '男' when id_sex_pat='2' then '女' when id_sex_pat='9' then '未说明' else null end)sex,/*性别*/"
				+ " TRUNC(months_between(sysdate, to_date(substr(dt_birth_pat,1,10),'yyyy-mm-dd'))/12) as age/*年龄*/"
				+ " from en_ent enent"
				+ " left join EN_ENT_IP enentip on enentip.id_ent=enent.id_ent"
				+ " where enent.code_entp=? and enent.sd_status=? and enent.id_dep_nur=? "
				+ WhereStr;

	}

}
