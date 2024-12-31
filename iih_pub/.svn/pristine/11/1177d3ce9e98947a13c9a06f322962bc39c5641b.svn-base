package iih.bd.pp.anhuiinsur.i.refs;

import iih.bd.base.utils.SqlUtils;
import iih.bd.mhi.baserefs.MhiBaseRefGridModel;
import iih.bd.pp.anhuiinsur.d.BdHpFwssOrginalDO;
import iih.bd.pp.anhuiinsur.d.BdHpZlOrginalDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.coreitf.i.IBaseDO;
import xap.sys.appfw.refinfo.RefResultSet;

/**
 * 安徽医保诊疗和服务设施目录参照模型
 * 
 * @author hao_wu
 *
 */
public class TreatAndFwssOrginalRefModel extends MhiBaseRefGridModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5974205490982171276L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { BdHpZlOrginalDO.CODE, BdHpZlOrginalDO.NAME, BdHpZlOrginalDO.SD_HPSRVTP,
				BdHpZlOrginalDO.UNIT, BdHpZlOrginalDO.RATE_SELF_OEP, BdHpZlOrginalDO.PRI_MAX,
				BdHpZlOrginalDO.PRI_RETIRE, BdHpZlOrginalDO.PRI_EY, BdHpZlOrginalDO.RATE_RETIRE,
				BdHpZlOrginalDO.RATE_INJURY, BdHpZlOrginalDO.RATE_BIRTH, BdHpZlOrginalDO.RATE_EY,
				BdHpZlOrginalDO.RATE_RESI, BdHpZlOrginalDO.RATE_ARMY_OEP, BdHpZlOrginalDO.RATE_ARMY_IP,
				BdHpZlOrginalDO.NOTE };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { "EU_HPSRVTP", "ID_HP", "PK", };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "诊疗编码", "诊疗名称", "类别", "单位", "门诊自付比例", "最高限价", "离休价格", "二乙自付价格", "离休自付比例", "工伤自付比例",
				"生育自付比例", "二乙自付比例", "居民自付比例", "军休门诊自付比例", "军休住院自付比例", "备注" };
	}

	@Override
	public String getPkFieldCode() {
		return "PK";
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
	public String[] getBlurFields() {
		return new String[] { "Name", "Code", "Py_code", "Wb_code" };
	}

	@Override
	public String getTableName() {
		return "ZL_FWSS_ORGINAL";
	}

	/**
	 * 获取自定义参照SQL
	 * 
	 * @return
	 */
	@Override
	protected String getBaseRefSql() {
		StringBuilder baseSqlBuilder = new StringBuilder();

		baseSqlBuilder.append("SELECT * ");
		baseSqlBuilder.append("FROM ( ");
		baseSqlBuilder.append("(SELECT FWSS_ORGINAL.CODE,");
		baseSqlBuilder.append("FWSS_ORGINAL.NAME,");
		baseSqlBuilder.append("DECODE(FWSS_ORGINAL.SD_HPSRVTP,1,'甲类',2,'乙类',3,'自费') AS SD_HPSRVTP,");
		baseSqlBuilder.append("'' AS UNIT,");
		baseSqlBuilder.append("'' AS RATE_SELF_OEP,");
		baseSqlBuilder.append("FWSS_ORGINAL.PRI_MAX,");
		baseSqlBuilder.append("FWSS_ORGINAL.PRI_RETIRE,");
		baseSqlBuilder.append("FWSS_ORGINAL.PRI_EY,");
		baseSqlBuilder.append("'' AS RATE_RETIRE,");
		baseSqlBuilder.append("'' AS RATE_INJURY,");
		baseSqlBuilder.append("'' AS RATE_BIRTH,");
		baseSqlBuilder.append("'' AS RATE_EY,");
		baseSqlBuilder.append("'' AS RATE_RESI,");
		baseSqlBuilder.append("'' AS RATE_ARMY_OEP,");
		baseSqlBuilder.append("'' AS RATE_ARMY_IP,");
		baseSqlBuilder.append("'' AS NOTE,");
		baseSqlBuilder.append("'3' AS EU_HPSRVTP,");
		baseSqlBuilder.append("FWSS_ORGINAL.ID_HP,");
		baseSqlBuilder.append("FWSS_ORGINAL.ID_HP || '3' || FWSS_ORGINAL.CODE AS PK,");
		baseSqlBuilder.append("FWSS_ORGINAL.DS,");
		baseSqlBuilder.append("FWSS_ORGINAL.DT_E,");
		baseSqlBuilder.append("FWSS_ORGINAL.PY_CODE,");
		baseSqlBuilder.append("FWSS_ORGINAL.WB_CODE ");
		baseSqlBuilder.append("FROM BD_HP_FWSS_ORGINAL FWSS_ORGINAL ");

		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new BdHpFwssOrginalDO(), "FWSS_ORGINAL");
		baseSqlBuilder.append(String.format("WHERE %s ", BdModeWherePart));
		baseSqlBuilder.append(" and FWSS_ORGINAL."+this.getHpWherePart());

		baseSqlBuilder.append(") ");
		baseSqlBuilder.append("UNION ");
		baseSqlBuilder.append("(SELECT ZL_ORGINAL.CODE,");
		baseSqlBuilder.append("ZL_ORGINAL.NAME,");
		baseSqlBuilder.append("DECODE(ZL_ORGINAL.SD_HPSRVTP,1,'甲类',2,'乙类',3,'自费') AS SD_HPSRVTP,");
		baseSqlBuilder.append("ZL_ORGINAL.UNIT,");
		baseSqlBuilder.append("TO_CHAR(ZL_ORGINAL.RATE_SELF_OEP),");
		baseSqlBuilder.append("ZL_ORGINAL.PRI_MAX,");
		baseSqlBuilder.append("ZL_ORGINAL.PRI_RETIRE,");
		baseSqlBuilder.append("ZL_ORGINAL.PRI_EY,");
		baseSqlBuilder.append("TO_CHAR( ZL_ORGINAL.RATE_RETIRE),");
		baseSqlBuilder.append("TO_CHAR(ZL_ORGINAL.RATE_INJURY),");
		baseSqlBuilder.append("TO_CHAR(ZL_ORGINAL.RATE_BIRTH),");
		baseSqlBuilder.append("TO_CHAR(ZL_ORGINAL.RATE_EY),");
		baseSqlBuilder.append("TO_CHAR(ZL_ORGINAL.RATE_RESI),");
		baseSqlBuilder.append("TO_CHAR(ZL_ORGINAL.RATE_ARMY_OEP),");
		baseSqlBuilder.append("TO_CHAR(ZL_ORGINAL.RATE_ARMY_IP),");
		baseSqlBuilder.append("ZL_ORGINAL.NOTE,");
		baseSqlBuilder.append("'2' AS EU_HPSRVTP,");
		baseSqlBuilder.append("ZL_ORGINAL.ID_HP,");
		baseSqlBuilder.append("ZL_ORGINAL.ID_HP || '2' || ZL_ORGINAL.CODE AS PK, ");
		baseSqlBuilder.append("ZL_ORGINAL.DS,");
		baseSqlBuilder.append("ZL_ORGINAL.DT_E,");
		baseSqlBuilder.append("ZL_ORGINAL.PY_CODE,");
		baseSqlBuilder.append("ZL_ORGINAL.WB_CODE ");
		baseSqlBuilder.append("FROM BD_HP_ZL_ORGINAL ZL_ORGINAL ");

		BdModeWherePart = BdEnvContextUtil.processEnvContext(new BdHpZlOrginalDO(), "ZL_ORGINAL");
		baseSqlBuilder.append(String.format(" WHERE %s ", BdModeWherePart));
		baseSqlBuilder.append(" and ZL_ORGINAL."+this.getHpWherePart());
		baseSqlBuilder.append("   ) )	ZL_FWSS_ORGINAL								       ");

		return baseSqlBuilder.toString();
	}

	@Override
	public RefResultSet filterRefPks(String[] filterPks) {
		this._isByPks = true;
		RefResultSet resultSet = this.getRefResultByPks(filterPks);
		this._isByPks = false;
		return resultSet;
	}

	private RefResultSet getRefResultByPks(String[] filterPks) {
		String wherePart = SqlUtils.getInSqlByIds("PK", filterPks);

		try {
			this.addWherePart(wherePart);
			RefResultSet localRefResultSet = getRefData();
			return localRefResultSet;
		} finally {
			this.removeWherePart(wherePart);
		}
	}

	@Override
	protected String getBdModeWherePart() {
		return null;
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	@Override
	protected String buildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", BdHpZlOrginalDO.CODE));
		return stringBuilder.toString();
	}

	@Override
	protected IBaseDO getDo() {
		return new BdHpZlOrginalDO();
	}
}
