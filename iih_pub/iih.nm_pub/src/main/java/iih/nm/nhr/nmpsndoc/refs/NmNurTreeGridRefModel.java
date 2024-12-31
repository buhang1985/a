package iih.nm.nhr.nmpsndoc.refs;

import iih.nm.Utils.NmEnvContextUtil;
import iih.nm.nhr.nmpsndoc.d.NmNurDO;

import java.util.List;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefTreeGridModel;
import xap.sys.orgfw.dept.d.DeptDO;

public class NmNurTreeGridRefModel extends RefTreeGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { NmNurDO.CODE, NmNurDO.NAME, NmNurDO.NAME_SEX, NmNurDO.NAME_NURTP, NmNurDO.NAME_NUR_LEVEL, NmNurDO.DEP_NAME, NmNurDO.NAME_DEP_ADMIN };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "工号", "姓名", "性别", "人员类型", "护士层级", "当前工作部门", "行政部门" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { NmNurDO.ID_PSNDOC, NmNurDO.ID_NUR, NmNurDO.SEX, NmNurDO.ID_NURTP, NmNurDO.ID_NUR_LEVEL, NmNurDO.ID_DEP, NmNurDO.ID_DEP_ADMIN };
	}

	@Override
	public String getPkFieldCode() {
		return NmNurDO.ID_NUR;
	}

	@Override
	public String getRefCodeField() {
		return NmNurDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return NmNurDO.NAME;
	}

	@Override
	public String getTableName() {
		return new NmNurDO().getTableName();
	}

	@Override
	public String getClassTableName() {
		return new DeptDO().getTableName();
	}

	@Override
	public String[] getClassFieldCode() {
		return new String[] { DeptDO.ID_DEP, DeptDO.CODE, DeptDO.NAME, DeptDO.ID_PARENT };
	}

	@Override
	public String getClassRefNameField() {
		return DeptDO.NAME;
	}

	@Override
	public String getClassRefCodeField() {
		return DeptDO.CODE;
	}

	@Override
	public String getClassPkFieldCode() {
		return DeptDO.ID_DEP;
	}

	/**
	 * 档案表中和分类连接的字段
	 */
	@Override
	public String getDocJoinField() {
		return NmNurDO.ID_DEP;
	}

	/**
	 * 分类表中和档案连接的字段---一般是分类主键
	 */
	@Override
	public String getClassJoinField() {
		return DeptDO.ID_DEP;
	}

	/**
	 * 父子键树结构：子字段。左树右表中，用于描述左分类的树结构。
	 */
	@Override
	public String getChildField() {
		return DeptDO.ID_DEP;
	}

	/**
	 * 父子键树结构：父字段。左树右表中，用于描述左分类的树结构。
	 */
	@Override
	public String getFatherField() {
		return DeptDO.ID_PARENT;
	}

	/**
	 * 返回分类数据查询过滤条件数组
	 */
	@Override
	public String[] getClassWherePart() {
		return new String[] { "bd_dep.ds = '0'  and bd_dep.code like '201%' or bd_dep.code like '101%'" };
	}

	/**
	 * 返回分类数据查询排序条件
	 */
	@Override
	public String[] getClassOrderPart() {
		return new String[] { DeptDO.CODE };
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { NmNurDO.PYCODE, NmNurDO.WBCODE, NmNurDO.MNECODE, NmNurDO.CODE, NmNurDO.NAME, NmNurDO.NAME_NUR_LEVEL, NmNurDO.NAME_NURTP };
	}

	@Override
	public String getRefSql() {

		StringBuffer sql = new StringBuffer();
		sql.append("	select nm_nur.code, 																	");
		sql.append("		nm_nur.name,                                                                        ");
		sql.append("		nm_nur.sex_name,                                                                    ");
		sql.append("		nm_nur.name_nurtp,                                                                  ");
		sql.append("		nm_nur.name_nur_level,                                                              ");
		sql.append("		nm_nur.name_dep,                                                                    ");
		sql.append("		nm_nur.name_dep_admin,                                                              ");
		sql.append("		nm_nur.id_psndoc,                                                                   ");
		sql.append("		nm_nur.id_nur,                                                                      ");
		sql.append("		nm_nur.sex,                                                                         ");
		sql.append("		nm_nur.id_nurtp,                                                                    ");
		sql.append("		nm_nur.id_nur_level,                                                                ");
		sql.append("		nm_nur.id_dep,                                                                      ");
		sql.append("		nm_nur.id_dep_admin,                                                                ");
		sql.append("	    nm_nur.ds,                                                                          ");
		sql.append("		nm_nur.id_org,                                                                      ");
		sql.append("		nm_nur.id_grp,                                                                      ");
		sql.append("		nm_nur.wbcode,                                                                      ");
		sql.append("		nm_nur.pycode,                                                                      ");
		sql.append("		nm_nur.mnecode                                                                      ");
		sql.append("	from                                                                                    ");
		sql.append("		(select                                                                             ");
		sql.append("			psndoc.code,                                                         			");
		sql.append("			psndoc.name,                                                            		");
		sql.append("			sextp.name sex_name,                                                    		");
		sql.append("			nurtp.name name_nurtp,                                               			");
		sql.append("			nurlvl.name name_nur_level,                                           			");
		sql.append("			wkdep.name name_dep,                                          					");
		sql.append("			admindep.name name_dep_admin,                                   				");
		sql.append("			nur.id_psndoc,	                                                                ");
		sql.append("			nur.id_nur,                                                                     ");
		sql.append("			psndoc.sex,                                                                     ");
		sql.append("			nur.id_nurtp,                                                                   ");
		sql.append("			nur.id_nur_level,                                                               ");
		sql.append("			psndoc.id_dep,                                                                  ");
		sql.append("			psndoc.id_dep_admin,                                                            ");
		sql.append("			nur.ds,                                                                         ");
		sql.append("			nur.id_org,                                                                     ");
		sql.append("			nur.id_grp,                                                                     ");
		sql.append("			psndoc.wbcode,                                                                  ");
		sql.append("			psndoc.pycode,                                                                  ");
		sql.append("			psndoc.mnecode                                                                  ");
		sql.append("		from nm_nur nur                                                                     ");
		sql.append("		inner join bd_psndoc psndoc on nur.id_psndoc=psndoc.id_psndoc                       ");
		sql.append("		left join bd_udidoc nurtp on nurtp.id_udidoc=nur.id_nurtp                           ");
		sql.append("		left join bd_udidoc sextp on sextp.id_udidoc=psndoc.sex                             ");
		sql.append("		left join bd_udidoc nurlvl on nurlvl.id_udidoc=nur.id_nur_level                     ");
		sql.append("		left join bd_dep wkdep on wkdep.id_dep=psndoc.id_dep                                ");
		sql.append("		left join bd_dep admindep on admindep.id_dep=psndoc.id_dep_admin) nm_nur            ");
		String joinPart = BuildJoinPart();
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		if (!StringUtil.isEmptyWithTrim(joinPart)) {
			sql.append(joinPart);
		} else {
			sql.append("where 1=2");
			return sql.toString();
		}
		if (!StringUtil.isEmptyWithTrim(wherePart)) {
			sql.append(wherePart);
		}
		if (!StringUtil.isEmptyWithTrim(orderPart)) {
			sql.append(orderPart);
		}

		return sql.toString();
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {
		StringBuilder stringBuilder = new StringBuilder(" where 1 = 1");
		stringBuilder.append(" and nm_nur.ds = 0 ");
		boolean fgHasValue = this.getClassJoinValue() != null;
		if (fgHasValue) {
			stringBuilder.append(" and nm_nur.id_dep=" + String.format("\'%s\'", new Object[] { this.getClassJoinValue() }));
		} else {
			stringBuilder.append("1=2");
			return stringBuilder.toString();
		}
		List<String> wherePart = this.getWherePart();
		if (wherePart != null && wherePart.size() > 0) {
			for (String partStr : wherePart) {
				stringBuilder.append(" and " + partStr);
			}
		}
		String NmModeWherePart = NmEnvContextUtil.processEnvContext(new NmNurDO(), false);
		stringBuilder.append(String.format(" and %s ", NmModeWherePart));
		return stringBuilder.toString();
	}

	/**
	 * 构建连接查询
	 * 
	 * @return
	 */
	private String BuildJoinPart() {

		StringBuffer joinPart = new StringBuffer();
		boolean fgHasValue = this.getClassJoinValue() != null;
		if (fgHasValue) {
			joinPart.append(" left join " + String.format("%s %s on %s.%s = %s.%s", new Object[] { this.getClassTableName(), this.getClassTableName(), this.getTableName(), this.getDocJoinField(), this.getClassTableName(), this.getClassJoinField() }));
		}
		return joinPart.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("order by nm_nur." + String.format("%s", NmNurDO.CODE));
		return stringBuilder.toString();
	}
}
