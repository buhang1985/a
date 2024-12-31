package iih.bl.cg.bp.ip.qry;

import iih.bl.cg.dto.d.BlInccaItmDTO;
import iih.bl.params.BlParams;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取账单项的记账信息
 * 
 * @param entId
 *            就诊id
 * @param inccaItmCode
 *            账单项编码
 * @param cgDate
 *            记账日期
 * @return
 * @throws BizException
 * @author liwenqiang
 */
public class GetIpCgListByInccaItmQry implements ITransQry {

	String entId;
	String inccaItmCode;
	FDate cgDate;
	String id_dep_or;
	String id_dep_mp;
	private FBoolean fgMomBBMerge;

	public GetIpCgListByInccaItmQry(String entId, BlInccaItmDTO inccaItmDto) {
		this.entId = entId;
		this.inccaItmCode = inccaItmDto.getCode_inccaitm();
		this.cgDate = inccaItmDto.getDt_cg();
		if (inccaItmDto.getId_dep_or() != null) {
			this.id_dep_or = inccaItmDto.getId_dep_or();
		}
		if (inccaItmDto.getId_dep_mp() != null) {
			this.id_dep_mp = inccaItmDto.getId_dep_mp();
		}
		
		this.fgMomBBMerge = BlParams.BLSTIP0005();
	}

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam param = new SqlParam();
		param.addParam(entId);
		if (FBoolean.TRUE.equals(this.fgMomBBMerge)) {
			// 如果母婴合并查询婴儿结算数据
			param.addParam(entId);
		}
		if (!StringUtil.isEmpty(inccaItmCode)) {
			param.addParam(inccaItmCode);
		}
		if (cgDate != null) {
			param.addParam(new FDateTime(cgDate.toLocalString() + " 00:00:00"));
			param.addParam(new FDateTime(cgDate.toLocalString() + " 23:59:59"));
		}
		if (!StringUtil.isEmpty(this.id_dep_or)) {
			param.addParam(this.id_dep_or);
		}
		if (!StringUtil.isEmpty(this.id_dep_mp)) {
			param.addParam(this.id_dep_mp);
		}

		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT  ");
		sql.append("CGIP.DT_CG dt_cg, ");
		sql.append("cgip.name_srv name_srv, ");
		sql.append("cgip.id_srv id_srv, ");
		sql.append("cgip.id_mm id_mm, ");
		sql.append("cgip.name_mm name_mm, ");
		sql.append("nvl(CGIP.spec,'/') spec, ");
		sql.append("CGIP.price_ratio price_ratio, ");
		sql.append("CGIP.QUAN*cgip.EU_DIRECT quan_mend, ");
		sql.append("CGIP.AMT_RATIO*cgip.EU_DIRECT AMT_RATIO, "); // 金额应加上方向，否则会导致汇总金额不一致
																	// by liwq
																	// 2018年1月4日0:42:17
		sql.append("doc_or.NAME name_emp_or, ");
		sql.append("doc_cg.NAME name_emp_cg, ");
		sql.append("oepor.name name_dep_or, ");
		sql.append("oepmp.NAME name_dep_mp, ");
		//sql.append("decode(hpsrv.sd_hpsrvtp,'1','甲类','2','乙类','丙类') sd_hpsrvtp, ");
		sql.append(" cior.name_or name_or, ");
		sql.append(" cgip.fg_bb fg_bb, ");
		sql.append(" cgip.id_ent_mom id_ent_mom ");
		sql.append("FROM ");
		sql.append("BL_CG_IP cgip ");
		sql.append("LEFT JOIN bl_st_ip stip ON CGIP.id_stip = STIP.id_stip ");
		sql.append("LEFT JOIN BD_DEP oepor ON oepor.id_dep = CGIP.id_dep_or ");
		sql.append("LEFT JOIN BD_DEP oepmp ON oepmp.id_dep = CGIP.id_dep_mp ");
		sql.append("LEFT JOIN BD_PSNDOC doc_or ON doc_or.id_PSNDOC = cgIp.id_emp_or ");
		sql.append("LEFT JOIN BD_PSNDOC doc_cg ON doc_cg.id_psndoc = cgip.id_emp_cg ");
		sql.append("LEFT JOIN CI_ORDER cior ON cior.id_or = cgip.id_or ");
//		sql.append(
//				"join bd_hp_srvorca  hpsrv on  (cgip.id_srv = hpsrv.id_srv and cgip.fg_mm='N') or (cgip.id_mm = hpsrv.id_mm and cgip.fg_mm = 'Y') ");
		sql.append("WHERE ");
		sql.append(" ( CGIP.ID_ENT = ? ");
		if (FBoolean.TRUE.equals(this.fgMomBBMerge)) {
			// 如果母婴合并查询婴儿结算数据
			sql.append("or cgip.id_ent_mom=? ");
		}
		sql.append(" ) ");
		sql.append(" and cgip.fg_real = 'Y' ");
		sql.append(" AND nvl(cgip.fg_research,'N')='N' ");
		if (!StringUtil.isEmpty(inccaItmCode)) {

			sql.append("AND CGIP.CODE_INCCAITM = ? ");
		}
		if (cgDate != null) {
			sql.append("AND CGIP.DT_CG >= ? ");
			sql.append("AND CGIP.DT_CG <= ? ");
		}
		if (!StringUtil.isEmpty(this.id_dep_or)) {
			sql.append("and cgip.id_dep_or=? ");
		}
		if (!StringUtil.isEmpty(this.id_dep_mp)) {
			sql.append("and cgip.id_dep_mp=? ");
		}
		sql.append("AND NVL(stip.FG_CANC, 'N')='N' ");
		sql.append(" AND NVL(STIP.EU_DIRECT, '1')='1' ");
		sql.append(" order by cgip.dt_cg desc ");
		return sql.toString();
	}
}
