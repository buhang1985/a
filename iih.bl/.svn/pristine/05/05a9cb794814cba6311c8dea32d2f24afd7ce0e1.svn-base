package iih.bl.cg.s.bp.qry;

import org.apache.commons.lang3.ArrayUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.dto.d.BlOrderValuationQueryParamDTO;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取就诊下的医嘱信息
 * 
 * @author xy.zhou
 * @date 2018年7月31日
 */
public class GetOrderDetailQry implements ITransQry {
	String id_ent;
	FDateTime dt_entry;
	FDateTime dt_end;
	String[] id_or;
	String fg_long;
	String[] id_srv;
	String id_srvtp;
	String fg_bb;
	String eu_orsrcfun;
	String id_emp_or;

	public GetOrderDetailQry(String id_ent, FDateTime dt_entry, FDateTime dt_end, String[] id_or, String fg_long,
			String id_srvtp, String[] id_srv, String fg_bb, String eu_orsrcfun, String id_emp_or) {
		this.id_ent = id_ent;
		if (dt_entry == null) {
			this.dt_entry = new FDateTime("1990-01-01 00:00:00");
		} else {
			this.dt_entry = dt_entry;
		}
		if (dt_end == null) {
			this.dt_end = new FDateTime();
		} else {
			this.dt_end = dt_end;
		}
		this.id_or = id_or;
		if (StringUtil.isEmpty(fg_long)) {
			this.fg_long = null;
		} else {
			this.fg_long = fg_long;
		}
		this.id_srvtp = id_srvtp;
		this.id_srv = id_srv;
		this.fg_bb = fg_bb;
		this.eu_orsrcfun = eu_orsrcfun;
		this.id_emp_or = id_emp_or;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		if (!StringUtil.isEmpty(this.id_ent)) {
			// if (StringUtil.isEmpty(this.fg_bb)) {
			// sqlParam.addParam(this.id_ent);
			// sqlParam.addParam(this.id_ent);
			// }else {
			sqlParam.addParam(this.id_ent);
			// }
		}
		if (!StringUtil.isEmpty(this.fg_long)) {
			sqlParam.addParam(this.fg_long);
		}
		if (!StringUtil.isEmpty(this.id_srvtp)) {
			sqlParam.addParam(this.id_srvtp);
		}

		if (!StringUtil.isEmpty(this.eu_orsrcfun)) {
			sqlParam.addParam(this.eu_orsrcfun);
		}

		if (this.dt_entry != null) {
			sqlParam.addParam(this.dt_entry);
		}
		if (this.dt_end != null) {
			sqlParam.addParam(this.dt_end);
		}
		if (!StringUtil.isEmpty(this.id_emp_or)) {
			sqlParam.addParam(this.id_emp_or);
		}
		// 优化sql修改 zx 2018年11月15日
		if (StringUtil.isEmpty(this.fg_bb) || this.fg_bb.equals("Y")) {
			if (!StringUtil.isEmpty(this.id_ent)) {
				// if (StringUtil.isEmpty(this.fg_bb)) {
				// sqlParam.addParam(this.id_ent);
				// sqlParam.addParam(this.id_ent);
				// }else {
				sqlParam.addParam(this.id_ent);
				// }
			}
			if (!StringUtil.isEmpty(this.fg_long)) {
				sqlParam.addParam(this.fg_long);
			}
			if (!StringUtil.isEmpty(this.id_srvtp)) {
				sqlParam.addParam(this.id_srvtp);
			}

			if (!StringUtil.isEmpty(this.eu_orsrcfun)) {
				sqlParam.addParam(this.eu_orsrcfun);
			}

			if (this.dt_entry != null) {
				sqlParam.addParam(this.dt_entry);
			}
			if (this.dt_end != null) {
				sqlParam.addParam(this.dt_end);
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
		sql.append("  select cio.id_en id_ent,cio.sd_su_or,cio.fg_stop,cio.sd_su_mp,cio.content_or,cio.name_or, ");
		sql.append("  cio.code_or,cio.fg_long,cio.dt_entry,cio.dt_effe dt_effc, cio.dt_end,cio.id_or,cio.fg_bb,  ");
		sql.append("  cio.fg_research,psn.name name_emp_or,dep.name name_dep_or,tp.name tp_name   ");
		sql.append("  from ci_order cio ");
		sql.append("  inner join bd_psndoc psn on cio.id_emp_or = psn.id_psndoc");
		sql.append("  inner join bd_dep dep on cio.id_dep_or = dep.id_dep");
		sql.append(" inner join bd_srvca tp on cio.id_srvca = tp.id_srvca ");
		// 优化sql修改 zx 2018年11月15日
		sql.append(" where cio.id_en=? ");

		if (!StringUtil.isEmpty(this.fg_long)) {
			sql.append(" and cio.fg_long=? ");
		}
		if (!ArrayUtil.isEmpty(id_or)) {
			sql.append(" and ").append(SqlUtils.getInSqlByIds("cio.id_or", this.id_or));
		}
		if (!ArrayUtil.isEmpty(this.id_srv)) {
			sql.append("  and exists(select 1 from bl_cg_ip cg where id_or = cio.id_or and ")
					.append(SqlUtils.getInSqlByIds("cg.id_srv", this.id_srv)).append(" )");
		} else if (!StringUtil.isEmpty(this.id_srvtp)) {
			sql.append("  and exists(select 1 from bl_cg_ip cg where id_or = cio.id_or and cg.id_srvtp=? )");
		} else if (!ArrayUtil.isEmpty(this.id_srv) && !StringUtil.isEmpty(this.id_srvtp)) {
			sql.append("  and exists(select 1 from bl_cg_ip cg where id_or = cio.id_or and ")
					.append(SqlUtils.getInSqlByIds("cg.id_srv", this.id_srv)).append("and cg.id_srvtp=? ")
					.append(" )");
		}
		if (!StringUtil.isEmpty(this.eu_orsrcfun)) {
			sql.append(" and cio.sd_orsrcfun=? ");
		}
		sql.append(" and cio.dt_entry between ? and ? ");
		if (!StringUtil.isEmpty(this.id_emp_or)) {
			sql.append(" and cio.id_emp_or=? ");
		}

		// sql.append(" order by dt_entry desc ");
		// 优化sql修改 zx 2018年11月15日
		if (StringUtil.isEmpty(this.fg_bb) || this.fg_bb.equals("Y")) {
			sql.append("  union all ");
			sql.append("  select cio.id_en id_ent,cio.sd_su_or,cio.fg_stop,cio.sd_su_mp,cio.content_or,cio.name_or, ");
			sql.append("  cio.code_or,cio.fg_long,cio.dt_entry,cio.dt_effe dt_effc, cio.dt_end,cio.id_or,cio.fg_bb,  ");
			sql.append("  cio.fg_research,psn.name name_emp_or,dep.name name_dep_or,tp.name tp_name   ");
			sql.append("  from ci_order cio ");
			sql.append("  inner join bd_psndoc psn on cio.id_emp_or = psn.id_psndoc");
			sql.append("  inner join bd_dep dep on cio.id_dep_or = dep.id_dep");
			sql.append("  inner join bd_srvca tp on cio.id_srvca = tp.id_srvca ");
			sql.append(" where   cio.id_en in(select id_ent_bb from en_ent_nb where id_ent_mom = ? ) ");
			if (!StringUtil.isEmpty(this.fg_long)) {
				sql.append(" and cio.fg_long=? ");
			}
			if (!ArrayUtil.isEmpty(id_or)) {
				sql.append(" and ").append(SqlUtils.getInSqlByIds("cio.id_or", this.id_or));
			}
			if (!ArrayUtil.isEmpty(this.id_srv)) {
				sql.append("  and exists(select 1 from bl_cg_ip cg where id_or = cio.id_or and ")
						.append(SqlUtils.getInSqlByIds("cg.id_srv", this.id_srv)).append(" )");
			} else if (!StringUtil.isEmpty(this.id_srvtp)) {
				sql.append("  and exists(select 1 from bl_cg_ip cg where id_or = cio.id_or and cg.id_srvtp=? )");
			} else if (!ArrayUtil.isEmpty(this.id_srv) && !StringUtil.isEmpty(this.id_srvtp)) {
				sql.append("  and exists(select 1 from bl_cg_ip cg where id_or = cio.id_or and ")
						.append(SqlUtils.getInSqlByIds("cg.id_srv", this.id_srv)).append("and cg.id_srvtp=? ")
						.append(" )");
			}
			if (!StringUtil.isEmpty(this.eu_orsrcfun)) {
				sql.append(" and cio.sd_orsrcfun=? ");
			}
			sql.append(" and cio.dt_entry between ? and ? ");
			if (!StringUtil.isEmpty(this.id_emp_or)) {
				sql.append(" and cio.id_emp_or=? ");
			}
		}
		sql.append(" order by dt_entry desc ");

		return sql.toString();
	}

}
