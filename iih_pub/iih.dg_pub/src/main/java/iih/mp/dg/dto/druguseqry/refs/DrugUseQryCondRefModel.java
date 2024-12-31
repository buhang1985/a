package iih.mp.dg.dto.druguseqry.refs;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class DrugUseQryCondRefModel extends RefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldName() {
		return new String[] { "住院号", "患者姓名", "就诊日期" };
	}

	@Override
	public String[] getShowFieldCode() {
		return new String[] { "Code_amr_ip", "Name_pat", "Dt_begin" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "Id_ent", "Pycode" };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { "Code_amr_ip", "Name_pat","Pycode" };
	}

	@Override
	public String getPkFieldCode() {
		return "Id_ent";
	}

	@Override
	public String getTableName() {
		return "a";
	}

	@Override
	public String getRefNameField() {
		return "Name_pat";
	}

	@Override
	public String getRefSql() {
		StringBuilder sql = new StringBuilder();
		
		String depid = (String) this.getExtendAttributeValue("depId");
		
		sql.append(" select a.code_amr_ip, a.name_pat, a.dt_begin, a.id_ent, a.pycode ");
		sql.append("from (select IP.Code_Amr_Ip, ENT.Name_Pat, ENT.Dt_Entry as dt_begin, ENT.Id_Ent, PAT.Pycode ");
		sql.append("from en_ent ENT ");
		sql.append("left join en_ent_ip IP ");
		sql.append("on ENT.Id_Ent = IP.Id_Ent ");
		sql.append("left join pi_pat PAT ");
		sql.append("on PAT.Id_Pat = ENT.Id_Pat ");
		sql.append("where ENT.Code_Entp = '10' ");
		
		if(!StringUtils.isNullOrEmpty(depid)) {
			sql.append(" and ENT.Id_Dep_Nur = '");
			sql.append(depid);
			sql.append("' ");
		}
		sql.append(") a ");
		
		List<String> wherePartList = this.getWherePart();
		if (wherePartList != null && wherePartList.size() > 0) {
			sql.append("where 1 = 1 ");
			for (String string : wherePartList) {
				sql.append(" and ");
				sql.append(string);
			}
		}
		
		List<String> orderPartList = this.getOrderPart();
		if (orderPartList != null && orderPartList.size() > 0) {
			sql.append(" ORDER BY ");
			for (int i = 0; i < orderPartList.size(); i++) {
				if (i != 0) {
					sql.append(" , ");
				}
				sql.append(orderPartList.get(i));
			}
		}

		return sql.toString();
	}

}
