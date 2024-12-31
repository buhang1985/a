package iih.hp.cp.eletp.refs;

import java.util.List;

import iih.hp.cp.eletp.d.*;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefTreeModel;

public class HpCpEleTypeTreeModel extends RefTreeModel{

	@Override
	public String[] getShowFieldCode() {
		// TODO Auto-generated method stub
		return new String[]{HpCpElemTypeDO.CODE,HpCpElemTypeDO.NAME};
	}

	@Override
	public String[] getHiddenFieldCode() {
		// TODO Auto-generated method stub
		return new String[]{HpCpElemTypeDO.ID_ELETP,HpCpElemTypeDO.ID_PAR,HpCpElemTypeDO.FG_PKG,HpCpElemTypeDO.FG_NEEDMATCH};
	}

	@Override
	public String[] getShowFieldName() {
		// TODO Auto-generated method stub
		return new String[]{"编码","名称"};
	}

	@Override
	public String getPkFieldCode() {
		// TODO Auto-generated method stub
		return HpCpElemTypeDO.ID_ELETP;
	}

	@Override
	public String getRefCodeField() {
		// TODO Auto-generated method stub
		return HpCpElemTypeDO.CODE;
	}

	@Override
	public String getRefNameField() {
		// TODO Auto-generated method stub
		return HpCpElemTypeDO.NAME;
	}
	
	@Override
	public String getFatherField() {
		return HpCpElemTypeDO.ID_PAR;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return new HpCpElemTypeDO().getTableName();
	}
	
	@Override
	public String getRefSql()
	{
		String id_eletp_pa = (String)getExtendAttributeValue("id_eletp_pa");
		
		String sql = "select hp_cp_eletp.code, "
					+"hp_cp_eletp.name, "
					+"hp_cp_eletp.id_eletp, "
					+"hp_cp_eletp.id_par, "
					+"hp_cp_eletp.fg_pkg, "
					+"hp_cp_eletp.fg_needmatch "
       				+"from hp_cp_eletp "
					+"where hp_cp_eletp.ds = 0 ";
		
		StringBuilder sb;
		if(!StringUtil.isEmpty(id_eletp_pa))
		{
			 sql+= " and hp_cp_eletp.id_eletp in"
				+" (select hp_cp_eletpnestable.id_eletp_nestable"
				+" from hp_cp_eletpnestable"
				+" where hp_cp_eletpnestable.id_eletp = '"+id_eletp_pa+"'"
				+" and hp_cp_eletpnestable.ds = 0)";
			 
			 sb = new StringBuilder(sql);
			 List<String> whereParts = this.getWherePart();
			 if (whereParts.size() > 0) {
				 for (String where : whereParts) {
					 sb.append(" and (").append(where).append(") ");
				 }
			 }
		}
		else{
			sb = new StringBuilder(sql);
			List<String> whereParts = this.getWherePart();
			if (whereParts.size() > 0) {
				for (String where : whereParts) {
					sb.append(" and (").append(where).append(") ");
				}
			}
		}
		
		return sb.toString();
	}
}
