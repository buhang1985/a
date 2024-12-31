package iih.bd.srv.diagdef.refs;

import java.util.Arrays;
import java.util.List;

import iih.bd.pp.hpdiexpenseself.d.BdHpDiExpenseSelfDO;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.d.desc.DiagDefDODesc;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.RefGridModel;
import xap.sys.appfw.refinfo.RefResultSet;
import xap.sys.permfw.role.d.RoleDO;

/**
 * 保内诊断参照模型
 * 
 * @author hao_wu
 *
 */
public class MedicareInnerDiagRefModel extends RefGridModel {
	/**
	 * 版本唯一码
	 */
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

	/**
	 * 查询字段名数组
	 */
	@Override
	public String[] getBlurFields() {
		return new String[] { DiagDefDO.CODE, DiagDefDO.NAME, DiagDefDO.PYCODE, DiagDefDO.WBCODE, DiagDefDO.MNECODE };
	}

	/**
	 * 参照主表名
	 */
	@Override
	public String getTableName() {
		return DiagDefDODesc.TABLE_NAME;
	}

	/**
	 * 主键字段
	 */
	@Override
	public String getPkFieldCode() {
		return DiagDefDO.ID_DIDEF;
	}

	/**
	 * 编码字段
	 */
	@Override
	public String getRefCodeField() {
		return DiagDefDO.CODE;
	}

	/**
	 * 显示名称字段
	 */
	@Override
	public String getRefNameField() {
		return DiagDefDO.NAME;
	}

	@Override
	public String getRefSql() {
		String wherePart = BuildWherePart();
		String orderPart = BuildOrderPart();
		String refSql;
		try {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().add(wherePart);
			}
			if (orderPart != null && !"".equals(orderPart)) {
				this.getOrderPart().add(orderPart);
			}
			refSql = this.BuildRefSql();

		} finally {
			if (wherePart != null && !"".equals(wherePart)) {
				this.getWherePart().remove(wherePart);
			}
			if (orderPart != null && !"".equals(orderPart)) {
				this.getOrderPart().remove(orderPart);
			}
		}

		return refSql;
	}

	/**
	 * 构建参照SQL
	 * 
	 * @return
	 */
	private String BuildRefSql() {
		StringBuilder refSqlBuilder = new StringBuilder();

		String baseSql = GetBaseSql();
		refSqlBuilder.append(baseSql);

		List<String> wherePartList = this.getWherePart();
		if (wherePartList != null && wherePartList.size() > 0) {
			for (String wherePart : wherePartList) {
				refSqlBuilder.append(String.format(" AND (%s)", wherePart));
			}
		}

		List<String> orderByList = this.getOrderPart();
		if (orderByList != null && orderByList.size() > 0) {
			refSqlBuilder.append(" ORDER BY ");
			for (int i = 0; i < orderByList.size(); i++) {
				if (i != 0) {
					refSqlBuilder.append(", ");
				}
				refSqlBuilder.append(orderByList.get(i));
			}
		}

		return refSqlBuilder.toString();
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

	private String cutOffAs(String oriField) {
		int index = oriField.indexOf(" as ");
		if (index != -1)
			oriField = oriField.substring(0, index);
		return oriField;
	}

	/**
	 * 获取基础SQL
	 * 
	 * @return
	 */
	private String GetBaseSql() {
		StringBuilder baseSqlBuilder = new StringBuilder();
		baseSqlBuilder.append("SELECT BD_DI_DEF.CODE,");
		baseSqlBuilder.append("BD_DI_DEF.NAME,");
		baseSqlBuilder.append("BD_CDSYS.NAME AS CD_NAME,");
		baseSqlBuilder.append("BD_UDIDOC.NAME AS SYS_NAME,");
		baseSqlBuilder.append("BD_DI_DEF.ID_DIDEF,");
		baseSqlBuilder.append("BD_DI_DEF.PYCODE,");
		baseSqlBuilder.append("BD_DI_DEF.WBCODE,");
		baseSqlBuilder.append("BD_DI_DEF.MNECODE,");
		baseSqlBuilder.append("BD_DI_DEF.ID_CDSYS,");
		baseSqlBuilder.append("BD_DI_DEF.ID_DISTDCA,");
		baseSqlBuilder.append("BD_DI_DEF.ID_CDSYSTP,");
		baseSqlBuilder.append("BD_CDSYS.CODE AS STANDARD_CODE,");
		baseSqlBuilder.append("BD_DI_DEF.FG_UR AS FG_UR,");
		baseSqlBuilder.append("BD_DI_DEF.FG_CHRONIC AS FG_CHRONIC,");
		baseSqlBuilder.append("BD_DI_DEF.FG_SPECIAL AS FG_SPECIAL,");
		baseSqlBuilder.append("BD_UDIDOC.CODE AS SYS_CODE,");
		baseSqlBuilder.append("BD_DI_DEF.ID_INFECTIONTP,");
		baseSqlBuilder.append("BD_DI_DEF.SD_INFECTIONTP ");
		baseSqlBuilder.append("FROM BD_DI_DEF BD_DI_DEF ");
		baseSqlBuilder.append("LEFT JOIN BD_CDSYS BD_CDSYS ");
		baseSqlBuilder.append("ON BD_CDSYS.ID_CDSYS = BD_DI_DEF.ID_CDSYS ");
		baseSqlBuilder.append("LEFT JOIN BD_UDIDOC BD_UDIDOC ");
		baseSqlBuilder.append("ON BD_UDIDOC.ID_UDIDOC = BD_DI_DEF.ID_CDSYSTP ");
		baseSqlBuilder.append("WHERE BD_DI_DEF.ID_DIDEF ");
		baseSqlBuilder.append("NOT IN (SELECT ID_DIDEF FROM BD_HP_DI_EXPENSE_SELF WHERE ");

		String bdModeWherePart = BdEnvContextUtil.processEnvContext(new BdHpDiExpenseSelfDO(), false);
		baseSqlBuilder.append(bdModeWherePart);

		baseSqlBuilder.append(") ");
		return baseSqlBuilder.toString();
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {

		StringBuilder stringBuilder = new StringBuilder("1 = 1");
		stringBuilder.append(" AND BD_DI_DEF.DS = 0 AND BD_DI_DEF.FG_ACTIVE ='Y'");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new DiagDefDO(), false);
		stringBuilder.append(String.format(" AND %s ", BdModeWherePart));

		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", DiagDefDO.CODE));
		return stringBuilder.toString();
	}
}
