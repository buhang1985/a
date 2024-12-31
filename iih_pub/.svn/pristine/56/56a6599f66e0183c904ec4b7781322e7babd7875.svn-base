package iih.nm.nhr.nmpsndoc.refs;

import iih.nm.Utils.NmEnvContextUtil;
import iih.nm.nhr.nmpsndoc.d.NmNurDO;

import java.util.List;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefGridModel;

public class NmNurRefModel extends RefGridModel {

	@Override
	public String[] getShowFieldCode() {
		return new String[] { NmNurDO.CODE, NmNurDO.NAME, NmNurDO.NAME_SEX, NmNurDO.NAME_NURTP, NmNurDO.NAME_NUR_LEVEL, NmNurDO.DEP_NAME, NmNurDO.NAME_DEP_ADMIN, NmNurDO.NAME_EMPDUTY, NmNurDO.EMPTITLENAME, NmNurDO.BIRTHDAY };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "人员编码", "人员名称", "性别", "人员类型", "护士层级", "当前工作部门", "行政部门", "职务", "职称", "出生日期" };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { NmNurDO.ID_PSNDOC, NmNurDO.ID_NUR, NmNurDO.SEX, NmNurDO.ID_NURTP, NmNurDO.ID_NUR_LEVEL, NmNurDO.ID_DEP, NmNurDO.ID_DEP_ADMIN, NmNurDO.ID_EMPDUTY, NmNurDO.ID_EMPTITLE };
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
		sql.append("		nm_nur.name_empduty,                                                                ");
		sql.append("		nm_nur.emptitlename,                                                                ");
		sql.append("		nm_nur.birthday,                                                                    ");
		sql.append("		nm_nur.id_psndoc,                                                                   ");
		sql.append("		nm_nur.id_nur,                                                                      ");
		sql.append("		nm_nur.sex,                                                                         ");
		sql.append("		nm_nur.id_nurtp,                                                                    ");
		sql.append("		nm_nur.id_nur_level,                                                                ");
		sql.append("		nm_nur.id_dep,                                                                      ");
		sql.append("		nm_nur.id_dep_admin,                                                                ");
		sql.append("		nm_nur.id_empduty,                                                                  ");
		sql.append("		nm_nur.id_emptitle,                                                                 ");
		sql.append("	    nm_nur.ds,                                                                          ");
		sql.append("	    nm_nur.sd_nurtp,                                                                    ");
		sql.append("		nm_nur.id_org,                                                                      ");
		sql.append("		nm_nur.id_grp,                                                                      ");
		sql.append("		nm_nur.wbcode,                                                                      ");
		sql.append("		nm_nur.pycode,                                                                      ");
		sql.append("		nm_nur.mnecode                                                                      ");
		sql.append("	from                                                                                    ");
		sql.append("		(select                                                                             ");
		sql.append("			psndoc.code,                                                            		");
		sql.append("			psndoc.name,                                                            		");
		sql.append("			sextp.name sex_name,                                                    		");
		sql.append("			nurtp.name name_nurtp,                                               			");
		sql.append("			nurlvl.name name_nur_level,                                           			");
		sql.append("			wkdep.name name_dep,                                          					");
		sql.append("			admindep.name name_dep_admin,                                   				");
		sql.append("			bdjob.name name_empduty,                                   				        ");
		sql.append("			emptitle.name emptitlename,                                   		   	    	");
		sql.append("			psndoc.birthday,                                                                ");
		sql.append("			nur.id_psndoc,	                                                                ");
		sql.append("			nur.id_nur,                                                                     ");
		sql.append("			psndoc.sex,                                                                     ");
		sql.append("			nur.id_nurtp,                                                                   ");
		sql.append("			nur.id_nur_level,                                                               ");
		sql.append("			psndoc.id_dep,                                                                  ");
		sql.append("			psndoc.id_dep_admin,                                                            ");
		sql.append("			psndoc.id_empduty,                                                              ");
		sql.append("			psndoc.id_emptitle,                                                             ");
		sql.append("			nur.ds,                                                                         ");
		sql.append("			nur.sd_nurtp,                                                                   ");
		sql.append("			nur.id_org,                                                                     ");
		sql.append("			nur.id_grp,                                                                     ");
		sql.append("			psndoc.wbcode,                                                                  ");
		sql.append("			psndoc.pycode,                                                                  ");
		sql.append("			psndoc.mnecode                                                                  ");
		sql.append("		from nm_nur nur                                                                     ");
		sql.append("		inner join bd_psndoc psndoc on nur.id_psndoc=psndoc.id_psndoc                       ");
		sql.append("		left join bd_job bdjob on bdjob.id_job=psndoc.id_empduty                            ");
		sql.append("		left join bd_udidoc emptitle on emptitle.id_udidoc=psndoc.id_emptitle               ");
		sql.append("		left join bd_udidoc nurtp on nurtp.id_udidoc=nur.id_nurtp                           ");
		sql.append("		left join bd_udidoc sextp on sextp.id_udidoc=psndoc.sex                             ");
		sql.append("		left join bd_udidoc nurlvl on nurlvl.id_udidoc=nur.id_nur_level                     ");
		sql.append("		left join bd_dep wkdep on wkdep.id_dep=psndoc.id_dep                                ");
		sql.append("		left join bd_dep admindep on admindep.id_dep=psndoc.id_dep_admin) nm_nur            ");

		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
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
		stringBuilder.append(" and ds = 0 ");
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
