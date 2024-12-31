package iih.pe.listener.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class PhyExamInfoQry implements ITransQry {

	String id_pepsnappt;
	String item_code;

	public PhyExamInfoQry(String id_pepsnappt,String item_code){
		this.id_pepsnappt = id_pepsnappt;
		this.item_code = item_code;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam param = new SqlParam();
		param.addParam(id_pepsnappt);
		param.addParam(item_code);
		return param;
	}
	
	@Override
	public String getQrySQLStr() {
		StringBuffer sql = new StringBuffer();
		sql.append("select case when (itm.resulttp = 1 or itm.resulttp = 4) then rst.rst else '' end as phy_exam_text_value,");
		sql.append("       case when (itm.resulttp = 2 or itm.resulttp = 3) then rst.rst else '' end as phy_exam_value_pq,");
		sql.append("       case when (itm.resulttp = 2 or itm.resulttp = 3) then 'PQ' else 'ST' end as phy_exam_xsitype,");
		sql.append("    rst.unit as phy_exam_que_value_unit,");
		sql.append("    itm.name as phy_exam_name,");
		sql.append("	itm.code as phy_exam_code");
		sql.append("  from pe_wf_perst rst");
		sql.append(" inner join pe_itm_pesrvbcatlog cat");
		sql.append("    on rst.id_pesrvbcatlog = cat.id_pesrvbcatlog");
		sql.append(" inner join pe_itm_pesrvitem itm");
		sql.append("    on itm.id_pesrvitem = rst.id_pesrvitem");
		sql.append(" where rst.id_pepsnappt = ? ");
		sql.append(" and cat.code = ? ");
		sql.append(" and rst.rst is not null");

		return sql.toString();
	}

}
