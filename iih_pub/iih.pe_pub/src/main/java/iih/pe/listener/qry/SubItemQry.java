package iih.pe.listener.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class SubItemQry implements ITransQry {

	String id_pepsnappt;
	String item_code;
	
	public SubItemQry(String id_pepsnappt,String item_code){
		this.id_pepsnappt = id_pepsnappt;
		this.item_code = item_code;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(id_pepsnappt);
		param.addParam(item_code);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		
		//直接在rst中取值
		sb.append("select case when itm.sortno is null then 1 else itm.sortno end as display_order,");
		sb.append("       case when (itm.resulttp = 1 or itm.resulttp = 4) then rst.rst else '' end as lab_sub_text_value,");
		sb.append("       case when (itm.resulttp = 2 or itm.resulttp = 3) then rst.rst else '' end as lab_sub_value_pq,");
		sb.append("       case when (itm.resulttp = 2 or itm.resulttp = 3) then 'PQ' else 'ST' end as lab_sub_item_xsitype,");
		sb.append("       rst.unit       lab_sub_que_value_unit,");
		sb.append("       rst.ref        reference_range,");
		sb.append("       rst.mark_arrow unusual_desc,");
		sb.append("       rst.ref_min    as val_min,");
		sb.append("       rst.ref_min    as val_max,");
		sb.append("       itm.name      as lab_sub_item_name,");
		sb.append("       itm.code      as lab_sub_item_code");
		sb.append("  from pe_wf_perst rst");
		sb.append(" inner join pe_itm_pesrvbcatlog cat");
		sb.append("    on rst.id_pesrvbcatlog = cat.id_pesrvbcatlog");
		sb.append(" inner join pe_itm_pesrvitem itm");
		sb.append("    on itm.id_pesrvitem = rst.id_pesrvitem");
		sb.append(" where rst.id_pepsnappt = ? ");
		sb.append(" and cat.code = ? ");
		sb.append(" and rst.rst is not null");
		
		return sb.toString();
	}

}
