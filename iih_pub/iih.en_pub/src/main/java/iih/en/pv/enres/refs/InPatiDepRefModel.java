package iih.en.pv.enres.refs;

import java.util.List;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.d.desc.DeptDODesc;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 患者就诊科室参照
 * 
 * @author houll 2018/03/20
 */
public class InPatiDepRefModel extends RefGridModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { DeptDO.CODE, DeptDO.NAME };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { DeptDO.ID_DEP };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "部门编码", "部门名称" };
	}

	@Override
	public String getPkFieldCode() {
		return DeptDO.ID_DEP;
	}

	@Override
	public String getRefCodeField() {
		return DeptDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return DeptDO.NAME;
	}

	@Override
	public String getTableName() {
		return DeptDODesc.TABLE_NAME;
	}

	@Override
	public String getRefSql() {
		String entId = (String) this.getExtendAttributeValue("id_ent");// 就诊id
		String sql = "select bd_dep.code,bd_dep.name,bd_dep.id_dep "
				+ "from bd_dep "
				+ "where 1=1 ";
		
		String sqlContext = " and " + EnvContextUtil.processEnvContext("", new DeptDO(), "bd_dep");//增加组织隔离
		sql+=sqlContext;
		
		if (!StringUtil.isEmpty(entId)) {
			sql += "and bd_dep.id_dep in "
					+ "(select distinct id_dep from en_ent_dep where id_ent = '"
					+ entId + "' and sd_entdeprole in ('1','3')) ";
		}

		StringBuilder sb = new StringBuilder(sql);
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sb.append(" And (").append(where).append(") ");
			}
		}
		return sb.toString();

	}

	@Override
	public String[] getBlurFields() {
		return new String[] { DeptDO.CODE, DeptDO.NAME };
	}
}
