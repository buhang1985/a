package iih.bl.cg.s.bp.ip.qry;

import iih.bl.cg.dto.d.BlFeeSrvConQryDTO;
import iih.bl.cg.dto.d.BlFeeSrvTotalQryDTO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取患者记账明细数据
 * 
 * @author zhangxin 2018年10月22日
 *
 */
public class GetIpCgPatDetailsQry implements ITransQry {
	private BlFeeSrvTotalQryDTO cond;
	private BlFeeSrvConQryDTO conqry;

	public GetIpCgPatDetailsQry(BlFeeSrvTotalQryDTO cond, BlFeeSrvConQryDTO conqry) {
		this.cond = cond;
		this.conqry = conqry;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer sql) {
		SqlParam sp = new SqlParam();
		if (!StringUtil.isEmptyWithTrim(this.conqry.getFg_ip())) {
			sp.addParam(this.conqry.getFg_ip());
		}
		if (this.conqry.getDt_begin() != null && this.conqry.getDt_end() != null) {
			sp.addParam(this.conqry.getDt_begin());
			sp.addParam(this.conqry.getDt_end());
		}
		if (!StringUtil.isEmpty(this.conqry.getId_dep())) {
			sp.addParam(this.conqry.getId_dep());
		}
		if (!StringUtil.isEmpty(this.cond.getId_srv())) {
			sp.addParam(this.cond.getId_srv());
		}
		if (!StringUtil.isEmpty(this.conqry.getId_pat_in())) {
			sp.addParam(this.conqry.getId_pat_in());
		} else if (!StringUtil.isEmpty(this.conqry.getId_pat_out())) {
			sp.addParam(this.conqry.getId_pat_out());
		}
		if (this.cond.getPrice() != null && !this.cond.getPrice().equals("")) {
			sp.addParam(this.cond.getPrice());
		}
		return sp;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sql = new StringBuffer();
		sql.append(
				" select entip.name_bed as bed_num,  pat.name as name_pat, cg.name_srv, mea.name as srvu,  (cg.quan-cg.quan_ret) as quan , ");
		sql.append(" cg.dt_or as or_time, empor.name as name_or, ");
		sql.append(" cg.dt_cg as cg_time, empcg.name as name_cg, ");
		sql.append(" mpdep.name as mp_depname,ordep.name as or_depname ");
		sql.append(" from bl_cg_ip cg  ");
		sql.append(" left join pi_pat pat  on cg.id_pat = pat.id_pat ");
		sql.append(" left join en_ent ent on cg.id_ent = ent.id_ent ");
		sql.append(" left join en_ent_ip entip  on ent.id_ent = entip.id_ent ");
		sql.append(" left join bd_psndoc empor  on empor.id_psndoc = cg.id_emp_or ");
		sql.append(" left join bd_psndoc empcg  on empcg.id_psndoc = cg.id_emp_cg ");
		sql.append(" left join bd_measdoc mea on  mea.id_measdoc = cg.srvu ");
		sql.append(" left join bd_dep mpdep on  mpdep.id_dep = cg.id_dep_mp ");
		sql.append(" left join bd_dep ordep on  ordep.id_dep = cg.id_dep_or ");
		sql.append(" where cg.fg_real = 'Y' and cg.fg_mm ='N' and   cg.fg_refund ='N'  and  cg.eu_direct = 1 ");
		if (!StringUtil.isEmptyWithTrim((this.conqry.getFg_ip()))) {
			sql.append(" and ent.fg_ip= ? ");
		}
		if (this.conqry.getDt_begin() != null && this.conqry.getDt_end() != null) {
			sql.append(" and cg.dt_cg between ? and ? ");
		}
		if (!StringUtil.isEmpty(this.conqry.getId_dep())) {
			sql.append(" and cg.id_dep_mp = ?  ");
		}
		if (!StringUtil.isEmpty(this.cond.getId_srv())) {
			sql.append(" and cg.id_srv = ?  ");
		}
		if (!StringUtil.isEmpty(this.conqry.getId_pat_in()) || !StringUtil.isEmpty(this.conqry.getId_pat_out())) {
			sql.append(" and cg.id_pat = ? ");
		}
		if (this.cond.getPrice() != null && !this.cond.getPrice().equals("")) {
			sql.append(" and cg.price_ratio = ? ");
		}
		sql.append(" order by ordep.id_dep,entip.name_bed   ");
		return sql.toString();
	}

}
