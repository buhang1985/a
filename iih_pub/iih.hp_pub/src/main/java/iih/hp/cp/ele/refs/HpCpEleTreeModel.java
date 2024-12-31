package iih.hp.cp.ele.refs;

import java.util.List;

import iih.hp.cp.ele.d.*;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefTreeModel;

public class HpCpEleTreeModel extends RefTreeModel{

	@Override
	public String[] getShowFieldCode() {
		// TODO Auto-generated method stub
		return new String[]{HpCpElemDO.CODE,HpCpElemDO.NAME};
	}

	@Override
	public String[] getHiddenFieldCode() {
		// TODO Auto-generated method stub
		return new String[]{HpCpElemDO.ID_ELE,HpCpElemDO.ID_PAR,HpCpElemDO.ID_ELETP};
	}

	@Override
	public String[] getShowFieldName() {
		// TODO Auto-generated method stub
		return new String[]{"编码","名称"};
	}

	@Override
	public String getPkFieldCode() {
		// TODO Auto-generated method stub
		return HpCpElemDO.ID_ELE;
	}

	@Override
	public String getRefCodeField() {
		// TODO Auto-generated method stub
		return HpCpElemDO.CODE;
	}

	@Override
	public String getRefNameField() {
		// TODO Auto-generated method stub
		return HpCpElemDO.NAME;
	}
	
	@Override
	public String getFatherField() {
		return HpCpElemDO.ID_PAR;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return new HpCpElemDO().getTableName();
	}
//	
//	@Override
//	public String getRefSql()
//	{
//		String a = (String)getExtendAttributeValue("id_eletp");
//
//		String sql = "select hp_cp_eletp.code, "
//					+"hp_cp_eletp.name, "
//					+"hp_cp_eletp.id_eletp, "
//					+"hp_cp_eletp.id_par "
//       				+"from hp_cp_eletp";
//		StringBuilder sb;
//		if(!StringUtil.isEmpty(a))
//		{
//			 sql+= " where hp_cp_eletp.id_eletp in"
//				+" (select hp_cp_eletpnestable.id_eletp_nestable"
//				+" from hp_cp_eletpnestable"
//				+" where hp_cp_eletpnestable.id_eletp = '"+a+"'"
//				+" and hp_cp_eletpnestable.ds = 0)";
//			 
//			 sb = new StringBuilder(sql);
//			 List<String> whereList = this.getWherePart();
//			 if (whereList.size() > 0) {
//				 for (String where : this.getWherePart()) {
//					 sb.append(" and (").append(where).append(") ");
//				 }
//			 }
//		}
//		else{
//			sb = new StringBuilder(sql);
//			List<String> whereList = this.getWherePart();
//			if (whereList.size() > 0) {
//				sb.append(" where 1 = 1 ");
//				for (String where : this.getWherePart()) {
//					sb.append(" and (").append(where).append(") ");
//				}
//			}
//		}
//		return sb.toString();
//	}
}
