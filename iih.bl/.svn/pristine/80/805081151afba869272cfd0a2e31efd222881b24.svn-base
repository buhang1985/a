package iih.bl.st.opfeeout.bp.qry;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetBlopfeeoutfiledtoQry implements ITransQry {

	List<String> id_stoeps; 
	/**
	 * 获取患者收费信息
	 * @param ID_STOEPs
	 * @throws BizException
	 * @author liwenqiang 2017.11.27
	 */
	public GetBlopfeeoutfiledtoQry(List<String> ID_STOEPs) throws BizException {
		this.id_stoeps = ID_STOEPs;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		for (String id_stoep : id_stoeps) {
			param.addParam(id_stoep);
		}
		return param;
	}
	
	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT");
		sql.append(" ST.id_stoep id_stoep,");
		sql.append(" ST.code_st code_st,");
		sql.append(" '' code_org,");
		sql.append(" enhp.no_hp code_manual, ");
		sql.append(" pat.id_code id_card,");
		sql.append(" pat.name name_pat,");
		sql.append(" pat.sd_sex sd_sex,");
		sql.append(" NVL(enhp.CODE_HPKIND, '3') type_insur,");
		sql.append(" (CASE st.code_enttp WHEN '00' THEN ");
		sql.append(" (CASE WHEN st.eu_sttp='30' THEN '11' WHEN st.eu_sttp='31' THEN '17' END ) ");
		sql.append(" WHEN '01' THEN ");
		sql.append(" (CASE WHEN st.eu_sttp='30' THEN '19' WHEN st.eu_sttp='31' THEN '18' END )");
		sql.append(" END)");
		sql.append(" type_med, ");
		sql.append(" inc.incno incno, ");
		sql.append(" st.dt_st dt_pay, ");
		//sql.append(" '0' number,");
		sql.append(" st.amt amt ");
		sql.append(" FROM BL_ST_OEP st ");
		sql.append(" INNER JOIN EN_ENT ent ON ENT.ID_ENT=ST.ID_ENT");
		sql.append(" INNER JOIN PI_PAT pat ON ent.id_pat=pat.id_pat ");
		sql.append(" INNER JOIN en_ent_hp enhp ON enhp.id_ent=ent.id_ent AND enhp.FG_MAj='Y' ");
		sql.append(" INNER JOIN BL_INC_OEP INC ON INC.id_stoep=st.id_stoep");
		sql.append(" WHERE ST.eu_direct = '1'");
		sql.append(" AND ST.ID_STOEP IN(");
		for (String id_stoep : this.id_stoeps) {
			sql.append( "?,");
		}
		sql.append("'0') ");
		return sql.toString();
	}
	
}
