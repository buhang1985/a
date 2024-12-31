package iih.mkr.ms.mscacust.ref;

import java.util.ArrayList;
import java.util.List;

import iih.mkr.ms.mscacust.d.MkrMscaCtmDO;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefTreeModel;

@SuppressWarnings("serial")
public class MkrMscaCustRefModel extends RefTreeModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { MkrMscaCtmDO.CODE, MkrMscaCtmDO.NAME };
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { MkrMscaCtmDO.ID_CACTM, MkrMscaCtmDO.ID_PAR, MkrMscaCtmDO.WBCODE, 
				MkrMscaCtmDO.PYCODE, MkrMscaCtmDO.INSTR, MkrMscaCtmDO.INNERCODE};
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称" };
	}

	@Override
	public String getPkFieldCode() {
		return MkrMscaCtmDO.ID_CACTM;
	}

	@Override
	public String getRefCodeField() {
		return MkrMscaCtmDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return MkrMscaCtmDO.NAME;
	}

	@Override
	public String getTableName() {
		return new MkrMscaCtmDO().getTableName();
	}
	
	@Override
	public String getFatherField() {
		return MkrMscaCtmDO.ID_PAR;
	}
	
	@Override
	public String getChildField() {
		return MkrMscaCtmDO.ID_CACTM;
	}
	
	@Override
	public List<String> getOrderPart() {
		List<String> orderPart = new ArrayList<String>();
		orderPart.add(MkrMscaCtmDO.CODE);
		return orderPart;
	}
	
	@Override
	public String getRefSql() {
		String cactmID = (String) this.getExtendAttributeValue("Id_cactm");
		String euOwtp = (String) this.getExtendAttributeValue("Eu_owtp");
		String ownDept = (String) this.getExtendAttributeValue("Id_ow_dept");
		String owEmp = (String) this.getExtendAttributeValue("Id_ow_emp");
		StringBuffer wherePartBuffer = new StringBuffer();
		wherePartBuffer.append(" ds=0 ");
		
		String orgId = Context.get().getOrgId();
		if (!StringUtil.isEmpty(orgId)){
			wherePartBuffer.append(" and id_org='" + orgId + "' ");
		}
	
		if (!StringUtil.isEmpty(euOwtp)){
			wherePartBuffer.append(" and Eu_owtp = '" + euOwtp + "' ");
		}
		
		if (!StringUtil.isEmpty(ownDept)){
			wherePartBuffer.append(" and id_ow_dept='" + ownDept + "' ");
		}
		
		if (!StringUtil.isEmpty(cactmID)){
			wherePartBuffer.append(" and id_cactm not in (" + cactmID + ")");
		}
		
		if (!StringUtil.isEmpty(owEmp)){
			wherePartBuffer.append(" and Id_ow_emp = '" + owEmp + "' ");
		}
		
		
		String wherePart = wherePartBuffer.toString();
		this.addWherePart(wherePart);
		String sql = null;
		try {
			sql = super.getRefSql();
		} finally {
			this.removeWherePart(wherePart);
		}

		return sql;
	}
	
	@Override
	public String afterBuilderSql(String sql) {
		return super.afterBuilderSql(sql);
	}
	 
	@Override
	public String[] getBlurFields() {
		return new String[]{"name","code","wbcode", "pycode"};
	}
}
