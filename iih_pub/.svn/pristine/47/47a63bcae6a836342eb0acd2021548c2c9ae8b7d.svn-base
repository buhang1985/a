package iih.bd.pp.anhuiinsur.i.refs;

import iih.bd.mhi.baserefs.MhiBaseRefGridModel;
import iih.bd.pp.anhuiinsur.d.BdHpDrugOrginalDO;
import iih.bd.pp.anhuiinsur.d.BdHpFwssOrginalDO;
import iih.bd.pp.anhuiinsur.d.BdHpZlOrginalDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.coreitf.i.IBaseDO;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.refinfo.RefResultSet;

public class DrugAndTreatOrginalRefModel extends MhiBaseRefGridModel{

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { BdHpDrugOrginalDO.ID_HPDRUGORGINAL, "ID_HP" };
	}

	@Override
	public String[] getShowFieldCode() {
		return new String[] { BdHpDrugOrginalDO.CODE, BdHpDrugOrginalDO.NAME, BdHpDrugOrginalDO.SPEC,
				BdHpDrugOrginalDO.DOSAGE, BdHpDrugOrginalDO.UNIT, BdHpDrugOrginalDO.DRUG_NAME_PRICE,
				BdHpDrugOrginalDO.DRUG_GRADE, BdHpDrugOrginalDO.RATE_SELF_OEP, BdHpDrugOrginalDO.RATE_RESI,
				BdHpDrugOrginalDO.RATE_RETIRE, BdHpDrugOrginalDO.RATE_INJURY, BdHpDrugOrginalDO.RATE_BIRTH,
				BdHpDrugOrginalDO.RATE_EY, BdHpDrugOrginalDO.RATE_ARMY_OEP, BdHpDrugOrginalDO.RATE_ARMY_IP };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "药品编码", "药品名称", "规格", " 剂型", "单位", "单价", "类型", "门诊自付比例", "居民自付比例", "离休自付比例", "工伤自付比例",
				"生育自付比例", "二乙自付比例", "军休门诊自付比例", "军休住院自付比例" };
	}

	@Override
	public String getPkFieldCode() {
		return "ID_HP";
	}

	@Override
	public String getRefCodeField() {
		return BdHpDrugOrginalDO.CODE;
	}

	@Override
	public String getRefNameField() {
		return BdHpDrugOrginalDO.NAME;
	}
	
	@Override
	public String getTableName() {
		return new BdHpDrugOrginalDO().getTableName();
	}

	@Override
	protected IBaseDO getDo() {
		return new BdHpDrugOrginalDO();
	}
	
	@Override
	public String[] getBlurFields() {
		return new String[] { BdHpDrugOrginalDO.NAME, BdHpDrugOrginalDO.CODE, BdHpDrugOrginalDO.PY_CODE,
				BdHpDrugOrginalDO.WB_CODE };
	}
	
	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	@Override
	protected String buildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(String.format("%s", BdHpDrugOrginalDO.CODE));
		return stringBuilder.toString();
	}

	@Override
	protected String getBaseRefSql() {
		StringBuilder baseSqlBuilder = new StringBuilder();

		baseSqlBuilder.append("SELECT *						    ");
		baseSqlBuilder.append("FROM							    ");
		baseSqlBuilder.append("  (SELECT DRUG_ORGINAL.CODE,				    ");
		baseSqlBuilder.append("    DRUG_ORGINAL.NAME,				    ");
		baseSqlBuilder.append("    DRUG_ORGINAL.SPEC,				    ");
		baseSqlBuilder.append("    DECODE(DOSAGE.ID_HP,NULL,DRUG_ORGINAL.DOSAGE,DOSAGE.NAME) AS DOSAGE, ");
		
		baseSqlBuilder.append("    DRUG_ORGINAL.UNIT,				    ");
		baseSqlBuilder.append("    TO_CHAR(DRUG_ORGINAL.DRUG_NAME_PRICE),				    ");
		baseSqlBuilder.append("    DECODE(DRUG_ORGINAL.DRUG_GRADE,1,'甲类',2,'乙类',3,'自费',4,'定额') AS DRUG_GRADE, ");
		baseSqlBuilder.append("    DRUG_ORGINAL.RATE_SELF_OEP,				    ");
		baseSqlBuilder.append("    TO_CHAR(DRUG_ORGINAL.RATE_RESI),				    ");
		baseSqlBuilder.append("    DRUG_ORGINAL.RATE_RETIRE,				    ");
		baseSqlBuilder.append("    DRUG_ORGINAL.RATE_INJURY,				    ");
		baseSqlBuilder.append("    DRUG_ORGINAL.RATE_BIRTH,				    ");
		baseSqlBuilder.append("    DRUG_ORGINAL.RATE_EY,				    ");
		baseSqlBuilder.append("    DRUG_ORGINAL.RATE_ARMY_OEP,				    ");
		baseSqlBuilder.append("    DRUG_ORGINAL.RATE_ARMY_IP,				    ");

//		baseSqlBuilder.append("    DRUG_ORGINAL.ID_HPDRUGORGINAL, ");
		baseSqlBuilder.append(" DRUG_ORGINAL.ID_HP||'_'||DRUG_ORGINAL.CODE AS PK, ");
		baseSqlBuilder.append("    DRUG_ORGINAL.ID_HP,				    ");
		baseSqlBuilder.append("    DRUG_ORGINAL.ID_GRP,				    ");
		baseSqlBuilder.append("    DRUG_ORGINAL.ID_ORG,				    ");
		baseSqlBuilder.append("    DRUG_ORGINAL.DS,					    ");
//		baseSqlBuilder.append("    DRUG_ORGINAL.PRC_DRUG_CERTI,					    ");
		baseSqlBuilder.append("    DRUG_ORGINAL.PY_CODE,				    ");
		baseSqlBuilder.append("    DRUG_ORGINAL.WB_CODE				    ");
//		baseSqlBuilder.append("    DRUG_ORGINAL.ZDY_CODE				    ");

		baseSqlBuilder.append("  FROM BD_HP_DRUG_ORGINAL DRUG_ORGINAL		    ");
		baseSqlBuilder.append("LEFT JOIN BD_MHI_DOSAGE DOSAGE						 ");
		baseSqlBuilder.append("ON DOSAGE.CODE = DRUG_ORGINAL.DOSAGE				 ");
		baseSqlBuilder.append("AND DOSAGE.ID_HP = DRUG_ORGINAL.ID_HP				 ");
//		baseSqlBuilder.append("  ) BD_HP_DRUG_ORGINAL				    ");

		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new BdHpDrugOrginalDO(), "DRUG_ORGINAL");
		baseSqlBuilder.append(String.format("WHERE %s ", BdModeWherePart));

//		baseSqlBuilder.append(") ");
		baseSqlBuilder.append(" UNION ");
		baseSqlBuilder.append("(SELECT ZL_ORGINAL.CODE,");
		baseSqlBuilder.append("ZL_ORGINAL.NAME,");
		baseSqlBuilder.append("'' AS SPEC,");
		baseSqlBuilder.append("'' AS DOSAGE,");
		baseSqlBuilder.append("ZL_ORGINAL.UNIT,");
		baseSqlBuilder.append("'' AS DRUG_NAME_PRICE,");
		baseSqlBuilder.append("DECODE(ZL_ORGINAL.SD_HPSRVTP,1,'甲类',2,'乙类',3,'自费',4,'定额') AS DRUG_GRADE,");
		baseSqlBuilder.append("ZL_ORGINAL.RATE_SELF_OEP,");
		baseSqlBuilder.append("'' AS RATE_RESI,");
		baseSqlBuilder.append("ZL_ORGINAL.RATE_RETIRE,");
		baseSqlBuilder.append("ZL_ORGINAL.RATE_INJURY,");
		baseSqlBuilder.append("ZL_ORGINAL.RATE_BIRTH,");
		baseSqlBuilder.append("ZL_ORGINAL.RATE_EY,");
//		baseSqlBuilder.append("TO_CHAR(ZL_ORGINAL.RATE_RESI),");
		baseSqlBuilder.append("ZL_ORGINAL.RATE_ARMY_OEP,");
		baseSqlBuilder.append("ZL_ORGINAL.RATE_ARMY_IP,");

		baseSqlBuilder.append("ZL_ORGINAL.ID_HP || '2' || ZL_ORGINAL.CODE AS PK, ");
		baseSqlBuilder.append("ZL_ORGINAL.ID_HP,");
		baseSqlBuilder.append("ZL_ORGINAL.ID_GRP,");
		baseSqlBuilder.append("ZL_ORGINAL.ID_ORG,");
		baseSqlBuilder.append("ZL_ORGINAL.DS,");
		baseSqlBuilder.append("ZL_ORGINAL.PY_CODE,");
		baseSqlBuilder.append("ZL_ORGINAL.WB_CODE ");
		baseSqlBuilder.append("FROM BD_HP_ZL_ORGINAL ZL_ORGINAL ");

		BdModeWherePart = BdEnvContextUtil.processEnvContext(new BdHpZlOrginalDO(), "ZL_ORGINAL");
		baseSqlBuilder.append(String.format(" WHERE %s ", BdModeWherePart));

		baseSqlBuilder.append("   ) )       ");

		return baseSqlBuilder.toString();
	}
	
	@Override
	protected String buildWherePart() {
		String wherePart = super.buildWherePart();
		if (this._isByPks) {
			return wherePart;
		}
		String hpWherePart = getHpWherePart();
		return hpWherePart;
//		return String.format("%s AND %s", wherePart, hpWherePart);
	}
	@Override
	public RefResultSet filterRefBlurValue(String blurValue, PaginationInfo pg) {
		// 重写该方法，该方法是模糊字段检索的处理
		String[] fields = this.getBlurFields();
		if (fields == null)
			fields = this.getShowFieldCode();

		StringBuilder buf = new StringBuilder();
		buf.append("(");
		for (int i = 0; i < fields.length; i++) {
			String field = fields[i];
			buf.append("lower(");
			buf.append(field);
			buf.append(")");
			buf.append(" like '%");
			buf.append(blurValue.toLowerCase());
			buf.append("%'");
			if (i != fields.length - 1)
				buf.append(" or ");
		}
		buf.append(")");
		String str = buf.toString();
		this.addWherePart(str);
		try {
			if (pg == null)
				return this.getRefData();
			else
				return this.getRefData(pg);
		} finally {
			this.removeWherePart(str);
		}
	}
}
