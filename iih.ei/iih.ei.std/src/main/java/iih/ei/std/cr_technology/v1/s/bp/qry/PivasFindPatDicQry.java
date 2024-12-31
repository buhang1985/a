package iih.ei.std.cr_technology.v1.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @author dj.zhang
 *
 */
public class PivasFindPatDicQry implements ITransQry {

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT DISTINCT PIPAT.CODE_AMR_IP PATIENT_NO,");
		sql.append("PIPAT.code PATIENT_ID,");
		sql.append("1 VISIT_ID,");
		sql.append("PIPAT.NAME PATIENTNAME,");
		sql.append("BDUDISEX.NAME SEX,");
		sql.append("PIPAT.DT_BIRTH BIRTHDAY,");
		sql.append("BDUDINATION.NAME NATION,");
		sql.append("ENENT.DT_ENTRY LAST_VISIT_DATE,");
		sql.append("PIPAT.MNECODE PYM,");
		sql.append("PIPAT.ID_CODE IDENTITY,");
		sql.append("PIPATCA.NAME CHARGE_TYPE,");
		sql.append("BDPSNDOC.NAME ATTENDING_DOCTOR,");
		sql.append("BDDEP.CODE DEPT_CODE,");
		sql.append("TRUNC(MONTHS_BETWEEN(SYSDATE,TO_DATE(DT_BIRTH,'YYYY-MM-DD'))/12) NIANL,");
		sql.append("(CASE ENENT.FG_IP WHEN 'Y' THEN '是' WHEN 'N' THEN '否'	END) IS_CHUY,");
		sql.append("ENENTDI.NAME_DIDEF_DIS DIAGNOSIS,");
		sql.append("'住院' PATIENT_CLASS ");
		sql.append("FROM PI_PAT PIPAT ");
		sql.append("INNER JOIN EN_ENT ENENT ");
		sql.append("ON PIPAT.ID_PAT = ENENT.ID_PAT ");
		sql.append("INNER JOIN EN_ENT_IP ENENTIP ");
		sql.append("ON ENENTIP.ID_ENT = ENENT.ID_ENT ");
		sql.append("LEFT JOIN PI_PAT_CA PIPATCA ");
		sql.append("ON PIPATCA.ID_PATCA = ENENT.ID_PATCA ");
		sql.append("LEFT JOIN BD_UDIDOC BDUDISEX ");
		sql.append("ON PIPAT.ID_SEX = BDUDISEX.ID_UDIDOC ");
		sql.append("LEFT JOIN BD_UDIDOC BDUDINATION ");
		sql.append("ON PIPAT.ID_NATION = BDUDINATION.ID_UDIDOC ");
		sql.append("LEFT JOIN BD_PSNDOC BDPSNDOC ");
		sql.append("ON ENENT.ID_EMP_PHY = BDPSNDOC.ID_PSNDOC ");
		sql.append("LEFT JOIN BD_DEP BDDEP ");
		sql.append("ON ENENT.ID_DEP_NUR = BDDEP.ID_DEP ");
		sql.append("LEFT JOIN EN_ENT_DI ENENTDI ");
		sql.append("ON ENENTDI.ID_ENT = ENENT.ID_ENT ");
		sql.append("AND ENENTDI.FG_MAJ = 'Y' ");
		sql.append("WHERE ENENT.FG_IP = 'Y' AND PIPAT.FG_INVD = 'N'");
		return sql.toString();
	}

}
