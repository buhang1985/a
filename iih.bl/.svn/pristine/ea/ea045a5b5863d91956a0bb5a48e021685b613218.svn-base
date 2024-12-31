package iih.bl.hp.s.bp.qry;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetDetailsUploadDTOsToOepQry implements ITransQry {

	String patid;
	String entid;

	public GetDetailsUploadDTOsToOepQry(String patid, String entid) {

		this.patid = patid;
		this.entid = entid;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();

		if (!StringUtil.isEmptyWithTrim(this.patid)) {
			sqlParam.addParam(this.patid);
		}
		if (!StringUtil.isEmptyWithTrim(this.entid)) {
			sqlParam.addParam(this.entid);
		}
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlb = new StringBuilder();
		sqlb.append(" SELECT  ");
		sqlb.append(" ENT.CODE serialno, ");
		sqlb.append(" ITMOEP.SD_SRVTP srvca, ");
		sqlb.append(" SRVORCA.CODE_CA incca, ");
		sqlb.append(" PRES.CODE presno, ");
		sqlb.append(" PRES.DT_ENTRY presdate, ");
		sqlb.append(" SRV.CODE srvcode, ");
		sqlb.append(" SRVORCA.CODE centercode, ");
		sqlb.append(" SRV.NAME srvname, ");
		sqlb.append(" ITMOEP.PRICE, ");
		sqlb.append(" ITMOEP.QUAN, ");
		sqlb.append(" UDIDOC.NAME dosageform, ");
		sqlb.append(" ITMOEP.SPEC, ");
		sqlb.append(" SRVDRUG.usage everydosage, ");
		sqlb.append(" FREQ.NAME freq, ");
		sqlb.append(" PSNDOC.NAME doctorname, ");
		sqlb.append(" PSNDOC.CODE presdoctor, ");
		sqlb.append(" UDIDOCROUTE.NAME USAGE, ");
		sqlb.append(" MEASDOC.NAME UNIT, ");
		sqlb.append(" DEP.NAME, ");
		sqlb.append(" 1 DAYS, ");
		sqlb.append(" DECODE(ITMOEP.SD_SRVTP, '0103','Y', 'N') singleflag, ");
		sqlb.append(" PSNDOC.NAME  operaname, ");
		sqlb.append(" null nullfiled, ");
		sqlb.append(" 0 debitamt, ");
		sqlb.append(" ITMOEP.amt_ratio amt, ");
		sqlb.append(" ITMOEP.ratio_hp selfratio, ");
		sqlb.append(" '' billcate, ");
		sqlb.append(" NVL(UDIDOCHPTP.NAME,'丙类') srvgrade ");
		sqlb.append(" FROM BL_CG_ITM_OEP ITMOEP ");
		sqlb.append(" INNER JOIN EN_ENT ENT ON ENT.ID_ENT=ITMOEP.ID_ENT ");
		sqlb.append(" INNER JOIN BD_HP_SRVORCA SRVORCA ON SRVORCA.ID_SRV = ITMOEP.ID_SRV AND ENT.ID_HP=SRVORCA.ID_HP ");
		sqlb.append(" LEFT JOIN CI_PRES PRES ON PRES.ID_PRES=ITMOEP.ID_PRES ");
		sqlb.append(" LEFT JOIN BD_SRV SRV ON SRV.ID_SRV=ITMOEP.ID_SRV ");
		sqlb.append(" LEFT JOIN BD_SRV_DRUG SRVDRUG ON SRVDRUG.ID_SRV=SRV.ID_SRV ");
		sqlb.append(" LEFT JOIN BD_UDIDOC UDIDOC ON UDIDOC.ID_udidoc=SRVDRUG.ID_dosage  ");
		sqlb.append(" LEFT JOIN BD_FREQ FREQ ON FREQ.ID_FREQ=SRV.ID_FREQ ");
		sqlb.append(" LEFT JOIN BD_PSNDOC PSNDOC ON PSNDOC.ID_PSNDOC=ITMOEP.ID_EMP_OR ");
		sqlb.append(" LEFT JOIN BD_UDIDOC UDIDOCROUTE ON UDIDOCROUTE.ID_udidoc=SRV.id_route  ");
		sqlb.append(" LEFT JOIN BD_MEASDOC MEASDOC ON MEASDOC.id_measdoc=ITMOEP.SRVU ");
		sqlb.append(" LEFT JOIN BD_DEP DEP ON DEP.ID_DEP=ITMOEP.id_dep_mp ");
		sqlb.append(" LEFT JOIN BD_UDIDOC UDIDOCHPTP ON UDIDOCHPTP.ID_udidoc=ITMOEP.id_hpsrvtp  ");
		sqlb.append(" WHERE 1=1 ");
		if (!StringUtil.isEmptyWithTrim(this.patid)) {
			sqlb.append(" AND ITMOEP.ID_PAT=? ");
		}

		if (!StringUtil.isEmptyWithTrim(this.entid)) {
			sqlb.append(" AND ITMOEP.ID_ENT=? ");
		}
		sqlb.append(" ORDER BY ITMOEP.sv DESC ");

		return sqlb.toString();
	}

}