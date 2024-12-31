package iih.bl.cg.bp.ip.qry;

import iih.bl.params.BlParams;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取住院账单项集合
 * 
 * @param entId
 *            就诊id
 * @param inccaItmCode
 *            账单项编码
 * @return 账单项集合
 * @throws BizException
 * @author liwenqiang
 */
public class GetIpInccaItmListQry implements ITransQry {

	String entId;
	String inccaItmCode;
	private FBoolean fgMomBBMerge;

	public GetIpInccaItmListQry(String entId, String inccaItmCode) {
		this.entId = entId;
		this.inccaItmCode = inccaItmCode;
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
		param.addParam(inccaItmCode);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT  ");
		sql.append("cgip.NAME_INCCAITM Name_inccaitm, ");
		sql.append("cgip.CODE_INCCAITM Code_inccaitm, ");
		sql.append("SUM (cgip.amt_ratio * cgip.EU_DIRECT) Amt_ratio, ");
		//sql.append(" dep1.name Name_dep_or,dep2.name Name_dep_mp,cgip.id_dep_or, id_dep_or,cgip.id_dep_mp, ");
		sql.append("SUBSTR(CGIP.dt_cg, 1, 10) Dt_cg  ");
		sql.append("FROM ");
		sql.append("BL_CG_IP cgip ");
		sql.append("LEFT JOIN bl_st_ip stip ON CGIP.id_stip = STIP.id_stip ");
		sql.append("left join bd_dep dep1  on dep1.id_dep=cgip.id_dep_or ");
		sql.append(" left join bd_dep dep2 on dep2.id_dep=cgip.id_dep_mp ");
		sql.append("WHERE ");
		sql.append(" ( cgip.ID_ENT = ? ");
		if (FBoolean.TRUE.equals(this.fgMomBBMerge)) {
			//如果母婴合并查询婴儿结算数据
			sql.append("or cgip.id_ent_mom=? ");
		}
		sql.append(" ) ");
		sql.append(" and cgip.fg_real = 'Y' ");
		sql.append("AND CODE_INCCAITM = ? ");
		sql.append("AND NVL(stip.FG_CANC, 'N')='N' ");
		sql.append(" AND NVL(STIP.EU_DIRECT, '1')='1' ");
		sql.append(" AND nvl(cgip.fg_research,'N')='N' ");
		sql.append("GROUP BY ( ");
		sql.append("cgip.NAME_INCCAITM, ");
		sql.append("cgip.CODE_INCCAITM, ");
		sql.append("SUBSTR(CGIP.dt_cg, 1, 10)) ");
		//sql.append("SUBSTR(CGIP.dt_cg, 1, 10),dep1.name,dep2.name,cgip.id_dep_or,cgip.id_dep_mp) ");
		sql.append("ORDER BY ");
		sql.append("SUBSTR(CGIP.dt_cg, 1, 10) ");

		return sql.toString();
	}
}
