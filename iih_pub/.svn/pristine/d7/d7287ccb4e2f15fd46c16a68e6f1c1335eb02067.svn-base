package iih.bd.srv.maintenance.refs;

import java.util.List;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefTreeGridModel;

public class MainTenanceGridModel extends RefGridModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { "code", "name" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "id_bd_mti" };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "工具编码", "工具名称", };
	}

	@Override
	public String getPkFieldCode() {
		return "id_bd_mti";
	}

	@Override
	public String getTableName() {
		return "BdMti";
	}

	@Override
	public String getRefCodeField() {
		return "code";

	}

	@Override
	public String getRefNameField() {
		return "name";
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { "code", "name" };
	}

	
	@Override
	public String getRefSql(){
		String Id_Bd_Mti = (String) this.getExtendAttributeValue("id_bd_mti");
		StringBuilder SQL = new StringBuilder();
		SQL.append(" select * from (" );
		SQL.append(" select bd_mti.code,bd_mti.name,bd_mti.id_bd_mti ");
		SQL.append(" from bd_mti bd_mti ");
		if(!StringUtil.isEmpty(Id_Bd_Mti)){
			SQL.append(" where bd_mti.id_bd_mti like '%"+Id_Bd_Mti+"%' ");
		}
		SQL.append(") BdMti ");
		SQL.append(" where 1=1 ");
		List<String>whereList = this.getWherePart();
		if(whereList.size()>0){
			for(String wherepart:this.getWherePart()){
				SQL.append(" And(").append(wherepart).append(")");
			}
		}
		return SQL.toString();
	}
	
}
