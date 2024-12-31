package iih.pe.listener.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class ExamInfoQry implements ITransQry {

	String id_pepsnappt;
	
	public ExamInfoQry(String id_pepsnappt){
		this.id_pepsnappt = id_pepsnappt;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(id_pepsnappt);
		param.addParam(id_pepsnappt);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sql = new StringBuffer();
		sql.append("select depset.name as Dept_name,");
		sql.append("       depset.code as Dept_code,");
		//sql.append("       ---检查提示");
		sql.append("       doc.dt_check as Exam_date,");
		sql.append("       doc.id_doc   as Exam_doc_id,");
		sql.append("       doc.name_doc as Exam_doc_name,");
		//sql.append("       ---报告日期");
		//sql.append("       ---审核医生");
		sql.append("       itm.name as Exam_item_name,");
		sql.append("       itm.code as Exam_item_code,");
		sql.append("       rst.rst  as Exam_description");
		sql.append("  from pe_wf_perst rst");
		sql.append(" inner join pe_itm_pesrvitem itm");
		sql.append("    on rst.id_pesrvitem = itm.id_pesrvitem");
		sql.append(" inner join pe_bd_deptset depset");
		sql.append("    on itm.id_pedeptset = depset.id_pedeptset");
		sql.append("  inner join (select room.id_pepsnappt,");
		sql.append("                    room.id_pedeptset,");
		sql.append("                    u.code as id_doc,");
		sql.append("                    room.sv as dt_check,");
		sql.append("                    u.name as name_doc");
		sql.append("               from pe_wf_pewfroom room");
		sql.append("               left join sys_user u");
		sql.append("                 on room.id_doc = u.id_user");
		sql.append("              where room.id_pepsnappt = ? ) doc");
		sql.append("    on depset.id_pedeptset = doc.id_pedeptset");
		sql.append(" where rst.id_pepsnappt = ? ");
		sql.append("   and itm.sd_rptpart ='03'");
		sql.append(" order by depset.sortno");
		return sql.toString();
	}

}
