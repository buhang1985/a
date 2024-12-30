package iih.sc.att.s.bp.qry;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

//TODO 增加备注
public class GetScTaskPlDOListQry implements ITransQry {

	String id_dept = null;

	public GetScTaskPlDOListQry(String id_dept) {
		this.id_dept = id_dept;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if (!StringUtil.isEmptyWithTrim(id_dept))
			param.addParam(this.id_dept);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT SC_TASK_PL.*,BD_DEP.code \"Code_dep\",BD_DEP.\"NAME\" \"Name_dep\" FROM SC_TASK_PL");
		sb.append(" LEFT JOIN BD_DEP ON SC_TASK_PL.ID_DEP=BD_DEP.ID_DEP");
		sb.append(" WHERE SC_TASK_PL.fg_active=2");
		if (!StringUtil.isEmptyWithTrim(id_dept))
			sb.append(" and SC_TASK_PL.id_dep=?");
		return sb.toString();
	}

}
