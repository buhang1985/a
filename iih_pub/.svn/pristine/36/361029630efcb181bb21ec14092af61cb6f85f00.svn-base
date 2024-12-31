package iih.nmr.pkuf.refer;

import iih.bd.utils.BdEnvContextUtil;

import java.util.List;

import xap.dp.dmengine.d.ComponentDO;
import xap.dp.dmengine.d.desc.ComponentDODesc;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class ComponentRefModel extends RefGridModel {
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { ComponentDO.NAME, ComponentDO.DISPLAYNAME, ComponentDO.MODULEID, ComponentDO.NAMESPACE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { ComponentDO.ID };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "名称", "显示名称", "所属模块", "命名空间" };
	}

	@Override
	public String getPkFieldCode() {
		return ComponentDO.ID;
	}

	@Override
	public String getRefCodeField() {
		return ComponentDO.NAME;
	}

	@Override
	public String getRefNameField() {
		return ComponentDO.DISPLAYNAME;
	}

	@Override
	public String getTableName() {
		return ComponentDODesc.TABLE_NAME;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { ComponentDO.NAME, ComponentDO.DISPLAYNAME, ComponentDO.MODULEID, ComponentDO.NAMESPACE, ComponentDO.ID };
	}

	@Override
	public String getRefSql() {

		String sql = "select name,displayname,moduleid,namespace,id from dm_component where 1 = 1 ";

		String orgSql = BdEnvContextUtil.processEnvContext(new ComponentDO(), false);
		if (!StringUtil.isEmpty(orgSql)) {
			sql += " and " + orgSql + " ";
		}

		StringBuilder sb = new StringBuilder(sql);
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sb.append(" And (").append(where).append(") ");
			}
		}

		sb.append(" order by createdtime,id ");

		return sb.toString();
	}

}
