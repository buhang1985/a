package iih.hp.cp.sdele.refs;

import iih.hp.cp.sdele.d.HpCpSdElemDO;

import java.util.ArrayList;
import java.util.List;

import xap.sys.appfw.refinfo.RefTreeModel;

public class HpCpSdEleTreeModel extends RefTreeModel{
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getPkFieldCode() {
		return HpCpSdElemDO.ID_SD_ELE;
	}
	
	@Override
	public String[] getShowFieldCode() {
		return new String[]{HpCpSdElemDO.NAME, HpCpSdElemDO.CODE};
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[]{"名称", "编码"};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{HpCpSdElemDO.ID_SD_ELE, HpCpSdElemDO.ID_ELETP, HpCpSdElemDO.ID_PAR};
	}

	@Override
	public String getRefCodeField() {
		return HpCpSdElemDO.CODE;
	}
	
	@Override
	public String getRefNameField() {
		return HpCpSdElemDO.NAME;
	}
	
	@Override
	public String getFatherField() {
		return HpCpSdElemDO.ID_PAR;
	}

	@Override
	public String getTableName() {
		return new HpCpSdElemDO().getTableName();
	}
	
	@Override
	public List<String> getOrderPart() {
		List<String> orderPart = new ArrayList<String>();
		orderPart.add(HpCpSdElemDO.CODE);
		return orderPart;
	}
	
	@Override
	public String getRefSql()
	{
		String notlock_child = (String)getExtendAttributeValue("notlock_child");
		String id_sd_ele = (String)getExtendAttributeValue("id_sd_ele");
		String id_sd = (String)getExtendAttributeValue("id_sd");
		String id_eletp_nestable = (String)getExtendAttributeValue("id_eletp_nestable");
		
		StringBuilder str_buf = new StringBuilder(80);
		boolean is_first_valid = true;
		
		// 用于排除锁定子元素的情况(有缺陷，客户端修改数据尚未保存时这个逻辑无法工作)
		if(notlock_child!=null && !notlock_child.isEmpty()) {
			if(!is_first_valid) str_buf.append(" and");
			str_buf.append(" fg_lock_child<>'Y'");
			is_first_valid = false;
		}
		// 用于排除自身
		if(id_sd_ele!=null && !id_sd_ele.isEmpty()) {
			if(!is_first_valid) str_buf.append(" and");
			str_buf.append(" id_sd_ele<>'").append(id_sd_ele).append("'");
			is_first_valid = false;
		}
		// 用于限制在当前模板中
		if (id_sd!=null && !id_sd.isEmpty()) {
			if(!is_first_valid) str_buf.append(" and");
			str_buf.append(" id_sd='").append(id_sd).append("'");
			is_first_valid = false;
		}
		
		if (id_eletp_nestable!=null && !id_eletp_nestable.isEmpty()) {
			if(!is_first_valid) str_buf.append(" and");
			
			// 可嵌入的父元素类型
			str_buf.append(" id_eletp in (");
			str_buf.append("select id_eletp from hp_cp_eletpnestable");
			str_buf.append(" where id_eletp_nestable='").append(id_eletp_nestable).append("'");
			str_buf.append(")");
			
			is_first_valid = false;
		}
		
		String wherePart = str_buf.toString();
		str_buf.setLength(0); str_buf.trimToSize();
		
		this.addWherePart(wherePart);
		String str_sql = null;
		try {
			str_sql = super.getRefSql();
		} finally {
			this.removeWherePart(wherePart);
		}
		
		return str_sql;
	}
}
