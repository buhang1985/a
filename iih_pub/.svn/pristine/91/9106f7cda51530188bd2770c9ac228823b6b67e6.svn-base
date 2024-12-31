package iih.en.pv.inpatient.refs;

import java.util.List;

import xap.sys.appfw.refinfo.RefGridModel;
import iih.bd.utils.BdEnvContextUtil;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatDO;

/**
 * 就诊患者详细信息
 * @author lilei
 * @date 2020年3月31日 
 */
public class PatiEntDetailRefModel extends RefGridModel {
	@Override
	public String[] getShowFieldCode() {
		return new String[] { PatDO.CODE, PatDO.NAME, PatDO.ID_CODE, PatDO.MOB, "Sex", PatiVisitDO.DT_ENTRY, "Name_entp", PatDO.DT_BIRTH,  
				 "Name_dep_phy", "Name_dep_nur", "Code_amr_ip"};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[] { PatiVisitDO.ID_ORG, PatiVisitDO.ID_ENT, PatDO.ID_PAT, PatiVisitDO.ID_ENTP, PatiVisitDO.ID_DEP_PHY, PatiVisitDO.ID_DEP_NUR };
	}

	@Override
	public String[] getShowFieldName() {
		return new String[] { "患者编码", "姓名", "证件号", "移动电话", "性别", "就诊日期", "就诊类型", "出生年月", "就诊科室", 
				"就诊病区", "住院号"};
	}

	@Override
	public String getPkFieldCode() {
		return PatiVisitDO.ID_ENT;
	}

	@Override
	public String getTableName() {
		return "patent";
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
		return new String[] { PatDO.CODE, PatDO.NAME, PatDO.PYCODE, PatDO.WBCODE, PatDO.MOB, PatDO.ID_CODE, PatDO.CODE_AMR_IP };
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
		sqlBuilder.append(" SELECT PI_PAT.CODE,		         ");
		sqlBuilder.append("   PI_PAT.NAME,		             ");
		sqlBuilder.append("   PI_PAT.ID_CODE,		         ");
		sqlBuilder.append("   PI_PAT.MOB,		             ");
		sqlBuilder.append("   SEX.NAME SEX,		             ");
		sqlBuilder.append(" EN_ENT.DT_ENTRY, ");
		sqlBuilder.append("   ENTP.NAME AS NAME_ENTP,		 ");
		sqlBuilder.append("   PI_PAT.DT_BIRTH,		         ");
		sqlBuilder.append(" PHY.NAME AS NAME_DEP_PHY, ");
		sqlBuilder.append(" NUR.NAME AS NAME_DEP_NUR, ");
		sqlBuilder.append(" IP.CODE_AMR_IP, ");
		
		sqlBuilder.append("   EN_ENT.ID_ORG,	             ");
		sqlBuilder.append("   EN_ENT.ID_ENT,	             ");
		sqlBuilder.append("   PI_PAT.ID_PAT,	             ");
		sqlBuilder.append("   EN_ENT.ID_ENTP,		             ");
		sqlBuilder.append(" EN_ENT.ID_DEP_PHY, ");
		sqlBuilder.append(" EN_ENT.ID_DEP_NUR, ");
		sqlBuilder.append("   PI_PAT.PYCODE,		         ");
		sqlBuilder.append("   PI_PAT.WBCODE		         ");
		
		sqlBuilder.append(" FROM EN_ENT EN_ENT ");
		sqlBuilder.append(" INNER JOIN PI_PAT PI_PAT ON EN_ENT.ID_PAT = PI_PAT.ID_PAT ");
		sqlBuilder.append(" LEFT JOIN BD_ENTP ENTP ON ENTP.ID_ENTP = EN_ENT.ID_ENTP ");
		sqlBuilder.append(" LEFT JOIN EN_ENT_IP IP ON IP.ID_ENT = EN_ENT.ID_ENT ");
		sqlBuilder.append(" LEFT JOIN BD_UDIDOC SEX	         ");
		sqlBuilder.append(" ON PI_PAT.ID_SEX = SEX.ID_UDIDOC ");
		sqlBuilder.append(" LEFT JOIN BD_DEP PHY ON PHY.ID_DEP = EN_ENT.ID_DEP_PHY	 ");
		sqlBuilder.append(" LEFT JOIN BD_DEP NUR ON NUR.ID_DEP = EN_ENT.ID_DEP_NUR	 ");
		String BdModeWherePart = BdEnvContextUtil.processEnvContext(new PatiVisitDO(), false);
		sqlBuilder.append(String.format(" where %s ", BdModeWherePart));
		sqlBuilder.append(" and en_ent.fg_canc = 'N' and pi_pat.fg_invd = 'N' ");
		String sql = "select * from (" + sqlBuilder.toString() + ") patent";
		sqlBuilder = new StringBuilder(sql);
		
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

		//StringBuilder stringBuilder = new StringBuilder("1 = 1");
		return "";
	}

	/**
	 * 构建排序语句
	 * 
	 * @return
	 */
	private String BuildOrderPart() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" CODE ASC, DT_ENTRY DESC ");
		return stringBuilder.toString();
	}
}
