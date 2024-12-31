package iih.bl.cg.s.bp.qry;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 查询可补费的医嘱信息
 * @author f
 *
 */
public class GetBlIpFeeDTOINfoQry implements ITransQry {

	private String id_ent;
	private String whereStr;

	public GetBlIpFeeDTOINfoQry(String id_ent,String whereStr) {
		this.id_ent = id_ent;
		this.whereStr=whereStr;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(id_ent);
		return param;
	}

	@Override
	public String getQrySQLStr() {
 		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" X.ID_OR id_or,   ");
		sql.append(" Y.name_OR AS des_or, ");
		sql.append(" X.ID_SRV, ");
		sql.append(" X.NAME_SRV, ");
		sql.append(" X.SRVU id_srvu,  ");
		sql.append(" M.CODE AS srvu_code,   ");
		sql.append(" M.NAME AS srvu_name, ");
		sql.append(" X.PRICE,  ");
		sql.append(" X.PRICE_RATIO,  ");
		sql.append(" X.QUAN,   ");
		sql.append(" X.ONLYCODE, ");
		sql.append(" X.ID_DEP_MP,   ");
		sql.append(" P.NAME AS name_dep_mp,  ");
		sql.append(" X.Id_mm,  ");
		sql.append(" X.fg_mm, ");
		sql.append(" X.id_ent,   ");
		sql.append(" X.id_pat,   ");
		sql.append(" D.Fg_Charge,   ");
		sql.append(" x.id_dep_or, ");
		sql.append(" ordep.name Name_dep_or ");
		sql.append("FROM ");
		sql.append(" (  ");
		sql.append(" SELECT  ");
		sql.append(" cg.ID_OR,  ");
		sql.append(" cg.ID_SRV, ");
		sql.append(" cg.NAME_SRV, ");
		sql.append(" cg.ID_MM,  ");
		sql.append(" cg.PRICE,  ");
		sql.append(" cg.PRICE_RATIO,  ");
		sql.append(" cg.SRVU,   ");
		sql.append(" cg.id_ent,   ");
		sql.append(" cg.fg_mm,   ");
		sql.append(" cg.id_pat,   ");
		sql.append(" cg.id_dep_or, ");
		sql.append(" SUM (cg .QUAN * cg .EU_DIRECT) AS QUAN, ");
		sql.append(" cg .ONLYCODE, ");
		sql.append(" cg.ID_DEP_MP ");
		sql.append(" FROM  ");
		sql.append(" BL_CG_IP cg ");
		sql.append(" WHERE ");
		sql.append(" cg.fg_real = 'Y' and cg.fg_st = 'N' and cg.ID_ENT = ?  ");
		sql.append(" AND nvl(cg.fg_research,'N')='N' ");
		if(!StringUtil.isEmpty(this.whereStr)){
			sql.append(" and "+this.whereStr);
		}
//		sql.append(" having SUM (A .QUAN * A .EU_DIRECT)<>0 ");
		sql.append(" GROUP BY   ");
		sql.append(" cg.id_dep_or, ");
		sql.append(" cg.ID_OR,  ");
		sql.append(" cg.ID_SRV, ");
		sql.append(" cg.NAME_SRV, ");
		sql.append(" cg.ID_MM,  ");
		sql.append(" cg.PRICE,  ");
		sql.append(" cg.PRICE_RATIO,  ");
		sql.append(" cg.SRVU,   ");
		sql.append(" cg.ONLYCODE, ");
		sql.append(" cg.fg_mm, ");
		sql.append(" cg.id_ent,   ");
		sql.append(" cg.id_pat,   ");
		sql.append(" cg.ID_DEP_MP ");
		sql.append("	) X   ");
		sql.append("LEFT JOIN CI_ORDER Y ON X.ID_OR = Y.ID_OR  ");
		sql.append("LEFT OUTER JOIN Bd_Dep P ON X.ID_DEP_MP = P .ID_DEP ");
		sql.append("LEFT JOIN BD_MEASDOC M ON X.SRVU = M .ID_MEASDOC  ");
		sql.append("LEFT JOIN BD_MM D ON X.ID_MM = D .ID_MM  ");
		sql.append(" left join bd_dep ordep on ordep.id_dep=x.id_dep_or ");
		return sql.toString();
	}
}
