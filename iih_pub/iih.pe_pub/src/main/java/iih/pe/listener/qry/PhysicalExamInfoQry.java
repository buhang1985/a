package iih.pe.listener.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class PhysicalExamInfoQry implements ITransQry {

	String id_pepsnappt;
	public PhysicalExamInfoQry(String id_pepsnappt){
		this.id_pepsnappt = id_pepsnappt;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam param = new SqlParam();
		param.addParam(id_pepsnappt);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		sb.append("select log.name   as Item_name, ");
		sb.append("		  log.code   as Item_code, ");
		sb.append("		  oval.dt_oval as Exam_date, ");
		sb.append("	      s.code   as Exam_doc_id,");
		sb.append("       s.name as Exam_doc_name");
		sb.append("  from pe_apt_pepsnapptcat rst");
		sb.append(" inner join pe_itm_pesrvbcatlog log");
		sb.append("    on rst.id_pesrvcatlog = log.id_pesrvbcatlog");
		sb.append(" inner join pe_bd_deptset depset");
		sb.append("    on rst.id_pedeptset = depset.id_pedeptset");
		sb.append(" inner join pe_wf_pewfoval oval");
		sb.append("	on oval.id_pepsnappt = rst.id_pepsnappt");
		sb.append("	 inner join pe_wf_pewfroom rm ");
		sb.append("	  on rst.id_pepsnappt = rm.id_pepsnappt and depset.id_pedeptset = rm.id_pedeptset");
		sb.append("  inner join sys_user s");
		sb.append(" on s.id_user = rm.id_nur");
		sb.append(" where log.catlog = 1");//体格检查
		sb.append("   and rst.id_pepsnappt = ? ");
		sb.append(" order by depset.sortno");
		return sb.toString();
	}

}
