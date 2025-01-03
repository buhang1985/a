package iih.bd.pp.anhuiinsur.i.refs;

import iih.bd.mhi.baserefs.MhiBaseRefGridModel;
import iih.bd.pp.anhuiinsur.d.BdHpDrugOrginalDO;
import xap.mw.coreitf.i.IBaseDO;

/**
 * 安徽医保药品目录参照模型
 * 
 * @author hao_wu
 *
 */
public class DrugOrginalRefModel extends MhiBaseRefGridModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[] { BdHpDrugOrginalDO.CODE, BdHpDrugOrginalDO.NAME, BdHpDrugOrginalDO.SPEC,
				BdHpDrugOrginalDO.DOSAGE,BdHpDrugOrginalDO.PRC_DRUG_CERTI, BdHpDrugOrginalDO.UNIT, BdHpDrugOrginalDO.DRUG_NAME_PRICE,
				BdHpDrugOrginalDO.DRUG_GRADE, BdHpDrugOrginalDO.RATE_SELF_OEP, BdHpDrugOrginalDO.RATE_RESI,
				BdHpDrugOrginalDO.RATE_RETIRE, BdHpDrugOrginalDO.RATE_INJURY, BdHpDrugOrginalDO.RATE_BIRTH,
				BdHpDrugOrginalDO.RATE_EY, BdHpDrugOrginalDO.RATE_ARMY_OEP, BdHpDrugOrginalDO.RATE_ARMY_IP };
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { BdHpDrugOrginalDO.ID_HPDRUGORGINAL, "ID_HP" };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "药品编码", "药品名称", "规格", " 剂型","医保批准文号", "单位", "单价", "类型", "门诊自付比例", "居民自付比例", "离休自付比例", "工伤自付比例",
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
	public String[] getBlurFields() {
		return new String[] { BdHpDrugOrginalDO.NAME, BdHpDrugOrginalDO.CODE, BdHpDrugOrginalDO.PY_CODE,
				BdHpDrugOrginalDO.PRC_DRUG_CERTI,BdHpDrugOrginalDO.WB_CODE, BdHpDrugOrginalDO.ZDY_CODE,  };
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
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT *						    ");
		sqlBuilder.append("FROM							    ");
		sqlBuilder.append("  (SELECT DRUG_ORGINAL.CODE,				    ");
		sqlBuilder.append("    DRUG_ORGINAL.NAME,				    ");
		sqlBuilder.append("    DRUG_ORGINAL.SPEC,				    ");
		sqlBuilder.append("    DECODE(DOSAGE.ID_HP,NULL,DRUG_ORGINAL.DOSAGE,DOSAGE.NAME) AS DOSAGE, ");
		sqlBuilder.append("    DRUG_ORGINAL.PRC_DRUG_CERTI,					    ");

		sqlBuilder.append("    DRUG_ORGINAL.UNIT,				    ");
		sqlBuilder.append("    DRUG_ORGINAL.DRUG_NAME_PRICE,				    ");
		sqlBuilder.append("    DECODE(DRUG_ORGINAL.DRUG_GRADE,1,'甲类',2,'乙类',3,'自费') AS DRUG_GRADE, ");
		sqlBuilder.append("    DRUG_ORGINAL.RATE_SELF_OEP,				    ");
		sqlBuilder.append("    DRUG_ORGINAL.RATE_RESI,				    ");
		sqlBuilder.append("    DRUG_ORGINAL.RATE_RETIRE,				    ");
		sqlBuilder.append("    DRUG_ORGINAL.RATE_INJURY,				    ");
		sqlBuilder.append("    DRUG_ORGINAL.RATE_BIRTH,				    ");
		sqlBuilder.append("    DRUG_ORGINAL.RATE_EY,				    ");
		sqlBuilder.append("    DRUG_ORGINAL.RATE_ARMY_OEP,				    ");
		sqlBuilder.append("    DRUG_ORGINAL.RATE_ARMY_IP,				    ");

		sqlBuilder.append("    DRUG_ORGINAL.ID_HPDRUGORGINAL, ");
		sqlBuilder.append(" DRUG_ORGINAL.ID_HP||'_'||DRUG_ORGINAL.CODE AS PK, ");
		sqlBuilder.append("    DRUG_ORGINAL.ID_HP,				    ");
		sqlBuilder.append("    DRUG_ORGINAL.ID_GRP,				    ");
		sqlBuilder.append("    DRUG_ORGINAL.ID_ORG,				    ");
		sqlBuilder.append("    DRUG_ORGINAL.DS,					    ");
		sqlBuilder.append("    DRUG_ORGINAL.PY_CODE,				    ");
		sqlBuilder.append("    DRUG_ORGINAL.WB_CODE,				    ");
		sqlBuilder.append("    DRUG_ORGINAL.ZDY_CODE				    ");

		sqlBuilder.append("  FROM BD_HP_DRUG_ORGINAL DRUG_ORGINAL		    ");
		sqlBuilder.append("LEFT JOIN BD_MHI_DOSAGE DOSAGE						 ");
		sqlBuilder.append("ON DOSAGE.CODE = DRUG_ORGINAL.DOSAGE				 ");
		sqlBuilder.append("AND DOSAGE.ID_HP = DRUG_ORGINAL.ID_HP				 ");
		sqlBuilder.append(" and DRUG_ORGINAL."+this.getHpWherePart());
		sqlBuilder.append("  ) BD_HP_DRUG_ORGINAL				    ");
		
		return sqlBuilder.toString();
	}

	@Override
	protected IBaseDO getDo() {
		return new BdHpDrugOrginalDO();
	}
}
