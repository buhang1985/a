package iih.bd.srv.diagdef.refs;

import java.util.Arrays;
import java.util.List;

import iih.bd.base.refs.BdRefGridModel;
import iih.bd.srv.diagdef.d.DiagDefDO;
import xap.mw.coreitf.i.IBaseDO;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.RefResultSet;
import xap.sys.permfw.role.d.RoleDO;

public class ChnMedDiagDefRefModel extends BdRefGridModel {

	private static final long serialVersionUID = 1L;

	/**
	 * 显示字段中文名
	 */
	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "标准", "体系" };
	}

	/**
	 * 显示字段名
	 */
	@Override
	public String[] getShowFieldCode() {
		return new String[] { DiagDefDO.CODE, RoleDO.NAME, "Cd_name", DiagDefDO.SYS_NAME };
	}

	/**
	 * 隐藏字段数组
	 */
	@Override
	public String[] getHiddenFieldCode() {

		return new String[] { DiagDefDO.ID_DIDEF, DiagDefDO.PYCODE, DiagDefDO.WBCODE, DiagDefDO.MNECODE,
				DiagDefDO.ID_CDSYS, DiagDefDO.ID_DISTDCA, DiagDefDO.ID_CDSYSTP, "standard_code", DiagDefDO.FG_UR,
				DiagDefDO.FG_CHRONIC, DiagDefDO.FG_SPECIAL, DiagDefDO.SYS_CODE, DiagDefDO.ID_INFECTIONTP,
				DiagDefDO.SD_INFECTIONTP };

	}

	@Override
	protected IBaseDO getDo() {
		return new DiagDefDO();
	}

	@Override
	protected String getBaseRefSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select bd_di_def.Code,");
		sqlBuilder.append("bd_di_def.Name,");
		sqlBuilder.append("bd_cdsys.name as Cd_name,");
		sqlBuilder.append("bd_udidoc.name as Sys_name, ");
		sqlBuilder.append("bd_di_def.Id_didef,");
		sqlBuilder.append("bd_di_def.Pycode,");
		sqlBuilder.append("bd_di_def.Wbcode,");
		sqlBuilder.append("bd_di_def.Mnecode,");
		sqlBuilder.append("bd_di_def.Id_cdsys,");
		sqlBuilder.append("bd_di_def.Id_distdca,");
		sqlBuilder.append("bd_di_def.Id_cdsystp,");
		sqlBuilder.append("bd_cdsys.code as standard_code,");
		sqlBuilder.append("bd_di_def.fg_ur as Fg_ur, ");
		sqlBuilder.append("bd_di_def.fg_chronic as fg_chronic, ");
		sqlBuilder.append("bd_di_def.fg_special as fg_special, ");
		sqlBuilder.append("bd_udidoc.code as Sys_code,");
		sqlBuilder.append("bd_di_def.Id_infectiontp, ");
		sqlBuilder.append("bd_di_def.Sd_infectiontp");
		sqlBuilder.append(" from bd_di_def bd_di_def ");
		sqlBuilder.append("left join bd_cdsys bd_cdsys ");
		sqlBuilder.append(" on bd_cdsys.id_cdsys = bd_di_def.id_cdsys ");
		sqlBuilder.append("left join bd_udidoc bd_udidoc ");
		sqlBuilder.append(" on bd_udidoc.id_udidoc = bd_di_def.id_cdsystp ");
		return sqlBuilder.toString();
	}

	@Override
	protected String buildWherePart() {

		StringBuilder wherePartBuilder = new StringBuilder();

		String wherePart = super.buildWherePart();
		wherePartBuilder.append(wherePart);

		wherePartBuilder.append(" and bd_di_def.fg_active ='Y' and bd_di_def.sd_cdsystp like '12%'");
		return wherePartBuilder.toString();
	}

	@Override
	public RefResultSet filterRefBlurValue(String blurValue, String[] outBlurFields, PaginationInfo pg) {

		String fields[] = getBlurFields();
		if (fields == null) {
			fields = getShowFieldCode();
		}
		List<String> old = Arrays.asList(fields);
		if (outBlurFields != null) {
			List<String> news = Arrays.asList(outBlurFields);
			for (int i = news.size(); i > 0; i--) {
				String one = (String) news.get(i);
				if (!old.contains(one))
					news.remove(one);
			}

			if (news != null)
				fields = (String[]) news.toArray(new String[0]);
		}

		StringBuilder wherePartBuilder = new StringBuilder();
		wherePartBuilder.append("(");
		for (int i = 0; i < fields.length; i++) {
			if (i != 0) {
				wherePartBuilder.append(" or ");
			}
			String field = cutOffAs(fields[i]);
			String wherePart = String.format("lower(%s.%s) like '%%%s%%'", getTableName(), field,
					blurValue.toLowerCase());
			wherePartBuilder.append(wherePart);
		}

		String wherePart = String.format(
				" or id_didef in (select distinct id_didef from bd_di_als where (lower(pycode) like '%s%%' or lower(wbcode) like '%s%%' or lower(mnecode) like '%%%s%%' or lower(alias) like '%%%s%%'))",
				blurValue, blurValue, blurValue, blurValue);
		wherePartBuilder.append(wherePart);

		wherePartBuilder.append(")");
		wherePart = wherePartBuilder.toString();

		try {
			addWherePart(wherePart);
			RefResultSet refresultset;
			if (pg != null) {
				refresultset = getRefData(pg);
				return refresultset;
			} else {
				refresultset = getRefData();
				return refresultset;
			}
		} finally {
			removeWherePart(wherePart);
		}
	}
}
