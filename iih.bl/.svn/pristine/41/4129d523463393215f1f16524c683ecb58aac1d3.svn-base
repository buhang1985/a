package iih.bl.cg.s.bp.ip.qry;

import iih.bl.cg.dto.d.BlFeeSrvConQryDTO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查詢住院费用项目明細
 * 
 * @author zhangxin 2018年10月22日
 * 
 *
 */
public class GetIpCgSrvTotalQry implements ITransQry {
	private BlFeeSrvConQryDTO conqry;

	public GetIpCgSrvTotalQry(BlFeeSrvConQryDTO conqry) {
		this.conqry = conqry;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer sql) {
		SqlParam sp = new SqlParam();
		if (!StringUtil.isEmptyWithTrim((this.conqry.getFg_ip()))) {

			sp.addParam(this.conqry.getFg_ip());
		}
		if (this.conqry.getDt_begin() != null && this.conqry.getDt_end() != null) {

			sp.addParam(this.conqry.getDt_begin());
			sp.addParam(this.conqry.getDt_end());
		}

		if (!StringUtil.isEmpty(this.conqry.getId_dep())) {

			sp.addParam(this.conqry.getId_dep());
		}
		if (!StringUtil.isEmpty(this.conqry.getId_pat_in())) {

			sp.addParam(this.conqry.getId_pat_in());
		} else if (!StringUtil.isEmpty(this.conqry.getId_pat_out())) {

			sp.addParam(this.conqry.getId_pat_out());

		}
		if (!StringUtil.isEmpty(this.conqry.getSrv_name())) {
			sp.addParam("%" + this.conqry.getSrv_name() + "%");

		}

		return sp;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"  select distinct cg.id_srv,cg.name_srv,sum(cg.quan-cg.quan_ret) as quan, mea.name as srvu,cg.price_ratio as price ,sum(cg.price_ratio*(cg.quan-cg.quan_ret)) as amt_ratio from bl_cg_ip cg  ");
		sql.append(" inner join bd_measdoc mea on  mea.id_measdoc = cg.srvu ");
		sql.append(" inner join en_ent ent on cg.id_ent = ent.id_ent ");
		sql.append(" where cg.fg_real = 'Y' and cg.fg_mm ='N' and   cg.fg_refund ='N' and cg.eu_direct =1  ");
		if (!StringUtil.isEmptyWithTrim((this.conqry.getFg_ip()))) {
			sql.append(" and   ent.fg_ip= ? ");
		}
		if (this.conqry.getDt_begin() != null && this.conqry.getDt_end() != null) {
			sql.append(" and   cg.dt_cg between ? and ? ");
		}
		if (!StringUtil.isEmpty(this.conqry.getId_dep())) {
			sql.append(" and   cg.id_dep_mp = ?  ");
		}
		if (!StringUtil.isEmpty(this.conqry.getId_pat_in()) || !StringUtil.isEmpty(this.conqry.getId_pat_out())) {
			sql.append(" and   cg.id_pat = ? ");
		}
		if (!StringUtil.isEmpty(this.conqry.getSrv_name())) {
			sql.append(" and   cg.name_srv  like ? ");
		}
		sql.append(" group by cg.id_srv,cg.name_srv,mea.name,cg.price_ratio ");
		sql.append(" order by cg.name_srv ");
		return sql.toString();
	}

}
