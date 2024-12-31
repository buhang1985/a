package iih.bl.cg.bp.oep.qry;

import xap.mw.core.utils.ArrayUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取上传医保处方 中需要的基础数据
 * @author yang.lu
 *
 */
public class GetRecipeDTOQry implements ITransQry {
	String[] enIds;

	/*
	 * 获取处方基础数据
	 */
	public GetRecipeDTOQry(String[] enIds) {
		this.enIds = enIds;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if (!ArrayUtil.isEmpty(enIds)) {
			for (String enId : enIds) {
				param.addParam(enId);
			}
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT DISTINCT EN_ENT.ID_ENT AS ID_EN ,");
		sql.append(" EN_ENT.id_dep_phy as ID_DEP_OR,");
		sql.append(" BD_DEP.CODE AS CODE_DEP,");
		sql.append(" BD_DEP.NAME AS ID_DEP_NAME,");
		sql.append(" BD_HP_DEP.CODE_HP AS DEPCODE_HP,");
		sql.append(" BD_HP_DEP.NAME_HP AS DEPNAME_HP,");
		sql.append(" BD_EMP_PHY.DRID AS ID_EMP_OR,");
		sql.append(" BD_PSNDOC.NAME AS ID_EMP_NAME,");
		sql.append(" BL_PROP_AR_OEP.CODE_HP Registertradeno");
		sql.append(" FROM EN_ENT EN_ENT");
		sql.append(" LEFT JOIN BD_DEP BD_DEP on BD_DEP.ID_DEP=EN_ENT.id_dep_phy");
		sql.append(" LEFT JOIN EN_ENT_HP EN_ENT_HP on EN_ENT_HP.id_ent=EN_ENT.id_ent AND EN_ENT_HP.fg_maj='Y'");
		sql.append(" LEFT JOIN BD_HP_DEP BD_HP_DEP ON BD_HP_DEP.ID_HP=EN_ENT_HP.ID_HP AND EN_ENT.id_dep_phy=BD_HP_DEP.ID_DEP");
		sql.append(" LEFT JOIN BD_EMP_PHY BD_EMP_PHY ON BD_EMP_PHY.ID_PSNDOC=EN_ENT.ID_EMP_PHY");
		sql.append(" LEFT JOIN BD_PSNDOC BD_PSNDOC ON BD_PSNDOC.ID_PSNDOC=EN_ENT.ID_EMP_PHY");
		sql.append(" LEFT JOIN BL_ST_OEP ON BL_ST_OEP.ID_ENT = EN_ENT.ID_ENT AND BL_ST_OEP.EU_DIRECT='1' AND BL_ST_OEP.EU_STTP='31'");
		sql.append(" LEFT JOIN BL_PROP_OEP ON BL_PROP_OEP.ID_STOEP=BL_ST_OEP.ID_STOEP");
		sql.append(" LEFT JOIN BL_PROP_AR_OEP ON BL_PROP_AR_OEP.ID_PROPOEP=BL_PROP_OEP.ID_PROPOEP");
		sql.append(" WHERE EN_ENT.ID_ENT IN (");
		if (!ArrayUtil.isEmpty(enIds)) {
			for (int i = 0; i < enIds.length; i++) {
				sql.append((i != 0 ? "," : "") + "?");
			}
		}
		sql.append(")");
		return sql.toString();

	}

}
