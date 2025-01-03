package iih.bl.cg.s.bp.qry;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.dto.d.BlOrderValuationQueryParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询非医嘱明细
 * 
 * @author xy.zhou
 * @date 2018年7月31日
 */
public class GetNotOrderDetailedQry implements ITransQry {

	private String id_ent;
	private String[] id_srv;
	private String id_srvtp;
	private String fg_bb;
	private String id_ent_mom;
	private String id_emp_or;

	public GetNotOrderDetailedQry(String id_ent, String[] id_srv, String id_srvtp, String fg_bb, String id_emp_or)
			throws BizException {
		this.id_ent = id_ent;
		this.id_srv = id_srv;
		this.id_srvtp = id_srvtp;
		this.id_ent_mom = id_ent;
		this.fg_bb = fg_bb;

		this.id_emp_or = id_emp_or;
	}	
	
	public GetNotOrderDetailedQry(BlOrderValuationQueryParamDTO tempDTO)
	{
		this.id_ent = tempDTO.getId_ent();
		this.id_srv = (tempDTO.getId_srv() == null ? null : tempDTO.getId_srv().split(","));
		this.id_srvtp = tempDTO.getId_srvtp();
		this.id_ent_mom = tempDTO.getId_ent();
		this.fg_bb = tempDTO.getFg_bb();
//		this.Srcfunc_des = "";
//		this.fg_pay = "";
//		this.Id_ordsrvtp = (tempDTO.getId_ordsrvtp() == null ? null : tempDTO.getId_ordsrvtp().split(","));
	} 

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();

		if (!StringUtil.isEmpty(this.id_ent)) {
			if (StringUtil.isEmpty(this.fg_bb)) {
				sqlParam.addParam(this.id_ent);
			} else {
				sqlParam.addParam(this.id_ent);
			}
		}

		if (!StringUtil.isEmpty(this.id_srvtp)) {
			sqlParam.addParam(this.id_srvtp);
		}

		if (!StringUtil.isEmpty(this.id_emp_or)) {
			sqlParam.addParam(this.id_emp_or);
		}
		// 优化sql 去掉 or 添加参数
		if (StringUtil.isEmpty(this.fg_bb)) {
			if (!StringUtil.isEmpty(this.id_ent)) {
				sqlParam.addParam(this.id_ent);
			}
			if (!StringUtil.isEmpty(this.id_srvtp)) {
				sqlParam.addParam(this.id_srvtp);
			}
			if (!StringUtil.isEmpty(this.id_emp_or)) {
				sqlParam.addParam(this.id_emp_or);
			}
		}

		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append(
				" select cg.id_ent,cg.dt_cg,cg.id_srv,cg.name_srv,doc.name as srvu,cg.fg_mm,cg.spec,cg.price_ratio,cg.price price_std, ");
		sql.append(
				" (cg.quan*cg.eu_direct) quan_mend,(cg.amt_ratio*cg.eu_direct) amt_ratio,cg.amt amt_std,cg.id_dep_or,cg.name_mm,cg.id_mm, ");
		sql.append(
				" dep1.name name_dep_or,cg.id_dep_mp,dep2.name name_dep_mp,cg.eu_direct,cg.fg_bb,cg.fg_research,cg.fg_selfpay, ");
		sql.append(" cg.id_emp_cg,psn.name name_emp_cg,nvl(cg.srcfunc_des,1) srcfunc_des,cg.code_apply,ent.id_hp ");
		sql.append(" from bl_cg_ip cg ");
		sql.append(" left join bd_psndoc psn on psn.id_psndoc=cg.id_emp_cg ");
		sql.append(" left join bd_measdoc doc on doc.id_measdoc=cg.srvu ");
		sql.append(" left join bd_dep dep1 on dep1.id_dep=cg.id_dep_or ");
		sql.append(" left join bd_dep dep2 on dep2.id_dep=cg.id_dep_mp ");
		sql.append(" left join en_ent ent on ent.id_ent=cg.id_ent ");
		sql.append(" where 1=1 ");
		sql.append(" and cg.fg_real = 'Y' ");
		sql.append(" and cg.id_or='~'  ");

		if (!StringUtil.isEmpty(this.id_ent)) {
			if (StringUtil.isEmpty(this.fg_bb)) {
				sql.append(" and (cg.id_ent=? )");
				// 优化sql 去掉 or
				// sql.append(" and (cg.id_ent=? or cg.id_ent_mom=?)");
			} else if (this.fg_bb.equals("Y")) {
				sql.append(" and cg.id_ent_mom=? and cg.fg_bb='Y'");
			} else {
				sql.append(" and cg.id_ent=?  and cg.fg_bb='N'");
			}
		}

		if (!StringUtil.isEmpty(this.id_srvtp)) {
			sql.append(" and cg.id_srvtp=?");
		}

		if (!StringUtil.isEmpty(this.id_emp_or)) {
			sql.append(" and cg.id_emp_or=? ");
		}

		if (!ArrayUtil.isEmpty(this.id_srv)) {
			sql.append(" and ").append(SqlUtils.getInSqlByIds("cg.id_srv", this.id_srv));
		}
		// 优化sql 去掉 or
		if (StringUtil.isEmpty(this.fg_bb)) {
			sql.append(" union all");
			sql.append(
					" select cg.id_ent,cg.dt_cg,cg.id_srv,cg.name_srv,doc.name as srvu ,cg.fg_mm,cg.spec,cg.price_ratio,cg.price price_std, ");
			sql.append(
					" (cg.quan*cg.eu_direct) quan_mend,(cg.amt_ratio*cg.eu_direct) amt_ratio,cg.amt amt_std,cg.id_dep_or,cg.name_mm,cg.id_mm, ");
			sql.append(
					" dep1.name name_dep_or,cg.id_dep_mp,dep2.name name_dep_mp,cg.eu_direct,cg.fg_bb,cg.fg_research,cg.fg_selfpay, ");
			sql.append(" cg.id_emp_cg,psn.name name_emp_cg,nvl(cg.srcfunc_des,1) srcfunc_des,cg.code_apply,ent.id_hp ");
			sql.append(" from bl_cg_ip cg ");
			sql.append(" left join bd_psndoc psn on psn.id_psndoc=cg.id_emp_cg ");
			sql.append(" left join bd_dep dep1 on dep1.id_dep=cg.id_dep_or ");
			sql.append(" left join bd_measdoc doc on doc.id_measdoc=cg.srvu ");
			sql.append(" left join bd_dep dep2 on dep2.id_dep=cg.id_dep_mp ");
			sql.append(" left join en_ent ent on ent.id_ent=cg.id_ent ");
			sql.append(" where 1=1 ");
			sql.append(" and cg.fg_real = 'Y' ");
			sql.append(" and cg.id_or='~'  ");

			if (!StringUtil.isEmpty(this.id_ent)) {
				sql.append(" and (cg.id_ent_mom =? )");

			}

			if (!StringUtil.isEmpty(this.id_srvtp)) {
				sql.append(" and cg.id_srvtp=?");
			}

			if (!StringUtil.isEmpty(this.id_emp_or)) {
				sql.append(" and cg.id_emp_or=? ");
			}

			if (!ArrayUtil.isEmpty(this.id_srv)) {
				sql.append(" and ").append(SqlUtils.getInSqlByIds("cg.id_srv", this.id_srv));
			}

		}
		sql.append(" order by dt_cg ");
		return sql.toString();
	}

}
