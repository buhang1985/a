/**
 * 
 */
package iih.bd.fc.orwf.ref;

import java.util.List;

import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * @ClassName: RefOrWfExDeptDTO
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年4月8日 下午4:52:51
 * @Package iih.bd.fc.orwf.ref Copyright: Copyright (c) 2011 Company:
 *          北大医疗信息技术有限责任公司
 */
public class RefOrWfExDeptDTO extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { "Code", "Name" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "Id_dep", "Id_parent", "Innercode" };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "部门编码", "部门名称" };
	}

	@Override
	public String getPkFieldCode() {
		return "Id_dep";
	}

	@Override
	public String getRefCodeField() {
		return "Code";
	}

	@Override
	public String getRefNameField() {
		return "Name";
	}

	@Override
	public String getRefSql() {
		String refSql = "select code,name,id_dep,id_parent,innercode from BD_DEP";

		StringBuilder sb = new StringBuilder(refSql);
		sb.append(" where 1=1 ");

		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new DeptDO(), false);
		sb.append(String.format(" and %s ", BdModeWherePart));

		String sddepttpStr = (String) getExtendAttributeValue("sddepttp");
		if (!StringUtil.isEmpty(sddepttpStr)) {
			sb.append(new StringBuilder().append(" and sd_depttp = '").append(sddepttpStr).append("'").toString());
		}

		List<String> whereList = getWherePart();
		if (whereList.size() > 0) {
			for (String where : getWherePart()) {
				sb.append(" And (").append(where).append(") ");
			}
		}

		return sb.toString();
	}

	@Override
	public String getTableName() {
		return new DeptDO().getTableName();
	}
}
