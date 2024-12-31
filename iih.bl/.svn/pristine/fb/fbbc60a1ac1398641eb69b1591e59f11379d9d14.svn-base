package iih.bl.cg.bp.ip.qry;

import iih.bl.params.BlParams;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取住院结算信息
 * 
 * @author liwenqiang 2017年12月8日 17:14:42
 *
 */
public class GetIpStListQry implements ITransQry {

	String entId;
	private FBoolean fgMomBBMerge;

	public GetIpStListQry(String entId) {
		this.entId = entId;
		this.fgMomBBMerge = BlParams.BLSTIP0005();
	}

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam param = new SqlParam();
		param.addParam(entId);
		if (FBoolean.TRUE.equals(this.fgMomBBMerge)) {
			//如果母婴合并查询婴儿结算数据
			param.addParam(entId);
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ");
		sql.append("cgip.ID_STIP id_st, ");
		sql.append("cgip.FG_ST fg_st, ");
		sql.append("stip.DT_ST dt_st, ");
		sql.append("SUM(CGIP.AMT_RATIO * cgip.EU_DIRECT) amt_ratio,  ");
		sql.append("incip.incno incno, ");
		sql.append("STIP.CODE_ST code_st ");
		sql.append("FROM  ");
		sql.append("BL_CG_IP cgip ");
		sql.append("LEFT JOIN	BL_ST_IP stip ON stip.id_stip=cgip.id_stip ");
		sql.append("LEFT JOIN BL_INC_IP incip ON stip.id_stip=incip.id_stip ");
		sql.append("WHERE cgip.fg_real = 'Y' and (cgip.ID_ENT=? ");
		if (FBoolean.TRUE.equals(this.fgMomBBMerge)) {
			//如果母婴合并查询婴儿结算数据
			sql.append("or cgip.id_ent_mom=? ");
		}
		sql.append(" ) ");
		sql.append("AND NVL(stip.FG_CANC, 'N')='N' ");
		sql.append(" AND NVL(STIP.EU_DIRECT, '1')='1' ");
		sql.append("GROUP BY(   ");
		sql.append("cgip.ID_STIP, ");
		sql.append("cgip.FG_ST, ");
		sql.append("stip.DT_ST, ");
		sql.append("incip.incno,");
		sql.append("STIP.CODE_ST)  ");
		sql.append("ORDER BY STIP.DT_ST ");
		return sql.toString();
	}
}
