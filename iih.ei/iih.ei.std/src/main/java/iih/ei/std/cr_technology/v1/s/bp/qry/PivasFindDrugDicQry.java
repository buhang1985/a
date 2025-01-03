package iih.ei.std.cr_technology.v1.s.bp.qry;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询药品字典SQL
 * 
 * @author dj.zhang
 *
 */
public class PivasFindDrugDicQry implements ITransQry {
	
	public PivasFindDrugDicQry() throws BizException {
		
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT BDMM.ID_MM AS SPID, ");
		sql.append("BDMM.CODE AS SPBH, ");
		sql.append("BDMM.NAME AS SPMCH, ");
		sql.append("BDMM.NAME AS TONGYMCH, ");
		sql.append("BDMM.PRINTNAME AS PRINTNAME, ");
		sql.append("BDMM.SPEC AS SHPGG, ");
		sql.append("BDMM.NAME_UNIT_PKGBASE AS DW, ");
		sql.append("BDMM.FACTOR_MB AS USEJLGG, ");
		sql.append("BDMEASDOC.NAME AS USEDW, ");
		sql.append("BDUDIDOC.NAME AS JIXING, ");
		sql.append("BDMM.CODE AS SPBH_PASS, ");
		sql.append("BDMM.ENGNAME AS ENGLISH_NAME, ");
		sql.append("BDMM.PYCODE AS PYM, ");
		sql.append("BDMM.APPRNO AS PIZHWH, ");
		sql.append("BDSUP.NAME AS SHPCHD, ");
		sql.append("BDMM.MODIFIEDTIME AS XGDATETIME ");
		sql.append("FROM BD_MM BDMM ");
		sql.append("LEFT JOIN BD_SRV BDSRV ");
		sql.append("ON BDMM.ID_SRV = BDSRV.ID_SRV ");
		sql.append("LEFT JOIN BD_MEASDOC BDMEASDOC ");
		sql.append("ON BDMEASDOC.ID_MEASDOC = BDSRV.ID_UNIT_MED ");
		sql.append("LEFT JOIN BD_SRV_DRUG SRVDRUG ");
		sql.append("ON BDMM.ID_SRV = SRVDRUG.ID_SRV	");
		sql.append("LEFT JOIN BD_UDIDOC BDUDIDOC ");
		sql.append("ON BDUDIDOC.ID_UDIDOC = SRVDRUG.ID_DOSAGE ");
		sql.append("LEFT JOIN BD_SUP BDSUP ");
		sql.append("ON BDSUP.ID_SUP = BDMM.ID_SUP ");
		return sql.toString();
	}

}
