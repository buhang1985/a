package iih.pi.reg.pat.refs;

import java.util.List;

import xap.sys.appfw.refinfo.RefGridModel;
import iih.bd.utils.BdEnvContextUtil;
import iih.pi.reg.pat.d.PatDO;

public class PatiDetailRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { PatDO.CODE, PatDO.NAME, "Sex", PatDO.MOB, PatDO.DT_BIRTH};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PatDO.ID_PAT };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "编码", "名称", "性别", "移动电话", "出生年月" };
	}

	@Override
	public String getPkFieldCode() {
		return PatDO.ID_PAT;
	}

	@Override
	public String getTableName() {
		return new PatDO().getTableName();
	}

	@Override
	public String getRefCodeField() {
		return PatDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return PatDO.NAME;
	}

	@Override
	public String[] getBlurFields() {
		return new String[] { PatDO.CODE, PatDO.NAME, PatDO.PYCODE, PatDO.WBCODE };
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
			refSql = this.buildRefSql();

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
	private String buildRefSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT /*+ parallel(8) */ PI_PAT.CODE,");
		sqlBuilder.append("   PI_PAT.NAME,		             ");
		sqlBuilder.append("   SEX.NAME SEX,		             ");
		sqlBuilder.append("   PI_PAT.MOB,		             ");
		sqlBuilder.append("   PI_PAT.DT_BIRTH,		         ");
		sqlBuilder.append("   PI_PAT.ID_PAT		             ");
		sqlBuilder.append(" FROM PI_PAT PI_PAT		         ");
		sqlBuilder.append(" LEFT JOIN BD_UDIDOC SEX	         ");
		sqlBuilder.append(" ON PI_PAT.ID_SEX = SEX.ID_UDIDOC ");

		List<String> wherePartList = this.getWherePart();
		if (wherePartList != null && wherePartList.size() > 0) {
			sqlBuilder.append(" where ");
			for (int i = 0; i < wherePartList.size(); i++) {
				if (i != 0) {
					sqlBuilder.append(" and ");
				}
				sqlBuilder.append(wherePartList.get(i));
			}
		}

		List<String> orderPartList = this.getOrderPart();
		if (orderPartList != null && orderPartList.size() > 0) {
			sqlBuilder.append(" order by ");
			for (int i = 0; i < orderPartList.size(); i++) {
				if (i != 0) {
					sqlBuilder.append(" , ");
				}
				sqlBuilder.append(orderPartList.get(i));
			}
		}
		return sqlBuilder.toString();
	}

	/**
	 * 构建条件语句
	 * 
	 * @return
	 */
	private String BuildWherePart() {

		StringBuilder stringBuilder = new StringBuilder("1 = 1");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new PatDO(), false);
		stringBuilder.append(String.format(" and %s ", BdModeWherePart));
		return stringBuilder.toString();
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" PI_PAT.CODE ");
		return stringBuilder.toString();
	}
}
