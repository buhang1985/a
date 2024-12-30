package iih.sc.att.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取已有排班明细数量
 * 
 * @author yang.lu
 * 
 */
public class GetAttExecEmpCountQry implements ITransQry {
	String id_emp;
	String id_taskexec;

	public GetAttExecEmpCountQry(String id_emp, String id_taskexec) {
		this.id_emp = id_emp;
		this.id_taskexec = id_taskexec;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO 自动生成的方法存根
		SqlParam param = new SqlParam();
		param.addParam(this.id_emp);
		param.addParam(this.id_taskexec);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		// TODO 自动生成的方法存根
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM SC_TASK_EXEC_EMP WHERE ");
		sb.append("ID_EMP=? AND ID_TASKEXEC=? AND ROWNUM=1");
		return sb.toString();
	}

}
