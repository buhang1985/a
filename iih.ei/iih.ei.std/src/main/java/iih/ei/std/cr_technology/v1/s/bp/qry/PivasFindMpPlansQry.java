package iih.ei.std.cr_technology.v1.s.bp.qry;

import org.apache.commons.lang.StringUtils;

import iih.ei.std.cr_technology.v1.d.PivasFindMpPlansParamBean;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * Pivas查询药品执行计划Qry
 * 
 * @author hao_wu 2018-6-26
 *
 */
public class PivasFindMpPlansQry implements ITransQry {

	private PivasFindMpPlansParamBean _paramBean;

	public PivasFindMpPlansQry(PivasFindMpPlansParamBean paramBean) {
		this._paramBean = paramBean;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(Context.get().getOrgId());
		sqlParam.addParam(Context.get().getDeptId());
		sqlParam.addParam(this._paramBean.getsDate() + " 00:00:00");
		sqlParam.addParam(this._paramBean.geteDate() + " 23:59:59");
		if(!StringUtils.isBlank(this._paramBean.getSendDate())) {
			sqlParam.addParam(this._paramBean.getSendDate());
		}
		if(!StringUtils.isBlank(this._paramBean.getDt_b_search()) && 
				!StringUtils.isBlank(this._paramBean.getDt_e_search())) {
			sqlParam.addParam(this._paramBean.getDt_b_search());
			sqlParam.addParam(this._paramBean.getDt_e_search());
			sqlParam.addParam(this._paramBean.getDt_b_search());
			sqlParam.addParam(this._paramBean.getDt_e_search());
			sqlParam.addParam(this._paramBean.getDt_b_search());
			sqlParam.addParam(this._paramBean.getDt_e_search());
			sqlParam.addParam(this._paramBean.getDt_b_search());
			sqlParam.addParam(this._paramBean.getDt_e_search());
			sqlParam.addParam(this._paramBean.getDt_b_search());
			sqlParam.addParam(this._paramBean.getDt_e_search());
			sqlParam.addParam(this._paramBean.getDt_b_search());
			sqlParam.addParam(this._paramBean.getDt_e_search());
		}
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String baseSql = getBaseSql();
		String wherePart = getWherePart();
		String orderPart = getOrderPart();

		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(baseSql);
		sqlBuilder.append(" WHERE ");
		sqlBuilder.append(wherePart);

		if (StringUtils.isNotEmpty(orderPart)) {
			sqlBuilder.append(" ORDER BY ");
			sqlBuilder.append(orderPart);
		}
		return sqlBuilder.toString();
	}

	/**
	 * 获取排序语句
	 * 
	 * @return
	 */
	private String getOrderPart() {
		return "ORD.CODE_OR,ORSRV.SORTNO";
	}

	/**
	 * 获取基础SQL
	 * 
	 * @return
	 */
	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT PAT.CODE AS PATCODE,");//患者编码
		sqlBuilder.append("PAT.CODE_AMR_IP AS CODEAMRIP,");//住院病案编号
		sqlBuilder.append("ENTIP.TIMES_IP AS TIMESIP,");//住院次数		
		sqlBuilder.append("ORPRSRV.ID_OR_PR_SRV AS ORDERPRSRVID,");//医嘱执行记录号
		sqlBuilder.append("ORD.CODE_OR AS ORDERNO,");//医嘱号
		sqlBuilder.append("ORD.CODE_OR || ORSRV.SORTNO AS ORDERSRVNO,");//医嘱下服务号
		sqlBuilder.append("ORPRSRV.DT_MP_PLAN AS ORDERSRVPLANTIME,");//药品执行时间
		//医嘱停止、作废会更改计划执行状态为已取消
		sqlBuilder.append("CASE WHEN ORPRSRV.EU_SU = '2' OR ORPRSRV.EU_SU = '3' THEN 'Y' ");
		sqlBuilder.append("WHEN dt.en_opap = '2' or dt.en_opde = '2' THEN 'Y' ");
		sqlBuilder.append("ELSE 'N' END AS DELETEFLAG, ");//药品执行计划删除标记
		sqlBuilder.append("dt.en_send as dgapCode, ");//药品执行计划发送状态  1已发送 2取消发送
		sqlBuilder.append("DECODE(dt.en_send, 1, ap.disp_time, ' ') as disptime, ");
		sqlBuilder.append("or_dep.code ordepcode, ");
		sqlBuilder.append("mp_dep.code mpdepcode ");
		sqlBuilder.append("FROM mp_dg_ip_apde_dt dt ");
		sqlBuilder.append("INNER JOIN MP_OR_PR_SRV ORPRSRV ");
		sqlBuilder.append("ON dt.id_or_pr_srv = ORPRSRV.id_or_pr_srv ");
		sqlBuilder.append("INNER JOIN CI_ORDER ORD ");
		sqlBuilder.append("ON ORD.ID_OR = ORPRSRV.ID_OR ");
		sqlBuilder.append("INNER JOIN CI_OR_SRV ORSRV ");
		sqlBuilder.append("ON ORSRV.ID_ORSRV = ORPRSRV.ID_ORSRV ");
		sqlBuilder.append("LEFT JOIN EN_ENT ENT ");
		sqlBuilder.append("ON ORD.ID_EN = ENT.ID_ENT ");
		sqlBuilder.append("LEFT JOIN PI_PAT PAT ");
		sqlBuilder.append("ON ORD.ID_PAT = PAT.ID_PAT ");
		sqlBuilder.append("LEFT JOIN EN_ENT_IP ENTIP ");
		sqlBuilder.append("ON ENTIP.ID_ENT = ORD.ID_EN ");
		sqlBuilder.append("left join mp_dg_ip_ap ap ");
		sqlBuilder.append("on ap.id_dgipap = dt.id_dgipap ");
		sqlBuilder.append("left join bd_dep or_dep ");
		sqlBuilder.append("on ORD.id_dep_or = or_dep.id_dep ");
		sqlBuilder.append("left join bd_dep mp_dep ");
		sqlBuilder.append("on ORD.id_dep_mp = mp_dep.id_dep ");
		return sqlBuilder.toString();
	}

	/**
	 * 获取条件语句
	 * 
	 * @return
	 */
	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder(" 1 = 1 AND ORPRSRV.ID_ORG = ?");		
		wherePartBuilder.append(" AND ORSRV.id_dep_wh = ? ");
		wherePartBuilder.append(" AND nvl(ORSRV.fg_self, 'N') <> 'Y' ");
		wherePartBuilder.append(" AND ORPRSRV.DT_MP_PLAN >= ? ");
		wherePartBuilder.append(" AND ORPRSRV.DT_MP_PLAN <= ? ");
		//只查询在院患者信息
		wherePartBuilder.append(" AND (case ent.fg_ip when 'Y' then 'Y' end)='Y' ");
		//只获取护士已经发送和取消发送的
		wherePartBuilder.append(" AND dt.en_send in (1, 2) ");
		//药房未确认的
		wherePartBuilder.append(" AND nvl(dt.id_dgipde, '~') = '~' ");
		//首日不摆的
		wherePartBuilder.append(" AND (nvl(dt.sd_fddgipap, '~') = '~' or dt.sd_fddgipap <> '01')");
		//提交时间
		if(!StringUtils.isBlank(this._paramBean.getSendDate())) {
			wherePartBuilder.append(" AND (nvl(ap.disp_time, '~') = '~' or ap.disp_time >= ? or dt.en_send = 2) ");
		}
		if(!StringUtils.isBlank(this._paramBean.getDt_b_search()) && 
				!StringUtils.isBlank(this._paramBean.getDt_e_search())) {
			wherePartBuilder.append(" AND ( ");
			wherePartBuilder.append("(nvl(ap.disp_time, '~') = '~' or (ap.disp_time >= ? and ap.disp_time <= ?) or dt.en_send = 2)");
			wherePartBuilder.append(" or (dt.sv >= ? and dt.sv <= ?)");
			wherePartBuilder.append(" or (ap.sv >= ? and ap.sv <= ?) ");
			wherePartBuilder.append(" or (ORD.dt_chk >= ? and ORD.dt_chk <= ?) ");
			wherePartBuilder.append(" or (ORD.dt_chk_canc >= ? and ORD.dt_chk_canc <= ?) ");
			wherePartBuilder.append(" or (ORD.dt_chk_stop >= ? and ORD.dt_chk_stop <= ?) ");
			wherePartBuilder.append(" or ORPRSRV.EU_SU in ('2', '3')");
			wherePartBuilder.append(" or dt.en_opap = '2' ");
			wherePartBuilder.append(" or dt.en_opde = '2' ");
			wherePartBuilder.append(" )");
		}
		return wherePartBuilder.toString();
	}
}
