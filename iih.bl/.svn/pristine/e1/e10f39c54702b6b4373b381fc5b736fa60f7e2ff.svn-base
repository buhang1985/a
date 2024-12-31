package iih.bl.inc.s.bp.qry;

import iih.bl.params.BlParams;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetIncIssRecordQry implements ITransQry {
	private String empId;
	private String pcId;

	public GetIncIssRecordQry(String empId, String pcId) {
		this.empId = empId;
		this.pcId = pcId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam param = new SqlParam();
		if ("01".equals(BlParams.BLINC0012())) {
			param.addParam(this.empId);
		} else if ("02".equals(BlParams.BLINC0012())) {
			param.addParam(this.pcId);
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append(" select iss.id_inciss,incca.name name_innca,iss.id_inciss ,iss.id_incca,incca.name,iss.Code_incpkg,iss.dt_iss,iss.num_b,iss.num_e,incno_cur,fg_curuse ");
		sqlSb.append(" from bl_inc_iss iss ");
        sqlSb.append("  left join bd_incca incca on incca.id_incca=iss.id_incca ");
        
		if ("01".equals(BlParams.BLINC0012())) {
			sqlSb.append(" where iss.id_emp_iss=? ");
		} else if ("02".equals(BlParams.BLINC0012())) {
			sqlSb.append(" where iss.id_pc=? ");
		}

		return sqlSb.toString();

	}
}
