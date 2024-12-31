package iih.bl.cg.bp.ip.qry;

import com.mysql.jdbc.StringUtils;

import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获取住院账单汇总信息
 * @author liwenqiang 2017年12月9日 11:28:02
 *
 */
public class GetIpInccaItmSumQry implements ITransQry {

	String entId;
	FBoolean fgSt;
	String stId;
	public GetIpInccaItmSumQry(String entId,FBoolean fgSt,String stId) {
		this.entId = entId;
		this.fgSt=fgSt;
		this.stId=stId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam param = new SqlParam();
		param.addParam(entId);
		param.addParam(fgSt);
		param.addParam(stId);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append(" '").append(this.stId).append("' as Id_st, ");
		sql.append("cgip.NAME_INCCAITM Name_inccaitm, ");
		sql.append("cgip.CODE_INCCAITM Code_inccaitm, ");
		sql.append("SUM(cgip.amt_ratio*cgip.eu_direct)  Amt_ratio ");
		sql.append("FROM  ");
		sql.append("BL_CG_IP cgip   ");
		sql.append("LEFT JOIN BD_DEP oepor ON oepor.id_dep=CGIP.id_dep_or ");
		sql.append("LEFT JOIN BD_DEP oepmp ON oepmp.id_dep=CGIP.id_dep_mp ");
		sql.append("WHERE ");
		sql.append("CGIP.ID_ENT=? ");
		sql.append(" and cgip.fg_real = 'Y' ");
		sql.append("AND	cgip.FG_ST = ? ");
		sql.append("AND cgip.ID_STIP=? ");
	
		sql.append("GROUP BY( ");
		sql.append("cgip.NAME_INCCAITM , ");
		sql.append("cgip.CODE_INCCAITM  ");
		sql.append(")  ");
		
		return sql.toString();
	}
}
