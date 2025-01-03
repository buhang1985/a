package iih.bd.fc.s.bp.orwfcfg.qry;

import iih.bd.fc.s.bp.common.BdFcEnvContextUtil;
import iih.bd.fc.s.bp.common.WfUtils;
import iih.bd.fc.wf.d.WfDO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取医嘱2.0流向配置明细
 * 
 * @author xuxing_2019年4月27日18:34:53
 * @version xuxing_2019年7月30日14:13:30_修正流向2.0毒麻不生效
 * @version: xuxing_2019年8月12日10:01:05，增加多组织管控
 * @version：xuxing_修正对组织管控修改的bug，流向配置与属性只能左链接
 * @version：xuxing_修正星期查询枚举值错误的bug（11改为10）
 * @version：zhongcl 2020年6月22日13:31:24 添加录入科室，进行医技药品流向配置
 *
 */
public class GetWfDetailSql implements ITransQry {

	private String[] id_wfs;

	public GetWfDetailSql(String[] id_wfs) {
		this.id_wfs = id_wfs;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		WfUtils.setSqlParam(param, this.id_wfs);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                                                       ");
		sqlStr.append(" cfg.id_wf_cfg,                                                                               ");
		sqlStr.append(" cfg.sortno,                                                                                  ");
		sqlStr.append(" cfg.id_wf,                                                                                   ");
		sqlStr.append(" wf.eu_wftp,                                                                                  ");
		sqlStr.append(" cfg.fg_macro,                                                                                ");
		sqlStr.append(" cfg.eu_macro,                                                                                ");
		sqlStr.append(" cfg.id_dep_mp,                                                                               ");
		sqlStr.append(" cfg.eu_srvca,                                                                                ");
		sqlStr.append(" attr.id_srvca,                                                                               ");
		sqlStr.append(" srvca.innercode,                                                                             ");
		sqlStr.append(" cfg.eu_srv,                                                                                  ");
		sqlStr.append(" attr.id_srv,                                                                                 ");
		sqlStr.append(" cfg.eu_dosage,                                                                               ");
		sqlStr.append(" dosage.id_udidoc as id_dosage,                                                               ");// 历史原因，剂型使用的是ID，其余档案使用的编码
		sqlStr.append(" dosage.code as sd_dosage,                                                                    ");
		sqlStr.append(" cfg.eu_pois,                                                                                 ");
		sqlStr.append(" posi.code as sd_pois,                                                                        ");
		sqlStr.append(" cfg.eu_mm,                                                                                   ");
		sqlStr.append(" attr.id_mm,                                                                                  ");
		sqlStr.append(" cfg.eu_herbperp,                                                                             ");
		sqlStr.append(" herbperp.code as sd_herbperp,                                                                ");
		sqlStr.append(" cfg.eu_dep_or,                                                                               ");
		sqlStr.append(" attr.id_dep as id_dep_or,                                                                    ");
		sqlStr.append(" cfg.eu_dep_phy,                                                                              ");
		sqlStr.append(" attr.id_dep as id_dep_phy,                                                                   ");
		sqlStr.append(" cfg.eu_dep_nur,                                                                              ");
		sqlStr.append(" attr.id_dep as id_dep_nur,                                                                   ");
		sqlStr.append(" cfg.eu_route,                                                                                ");
		sqlStr.append(" attr.id_route,                                                                               ");
		sqlStr.append(" cfg.eu_week,                                                                                 ");
		sqlStr.append(" week.code as sd_week,                                                                        ");
		// 2019年12月26日14:51:49 增加年龄等级限制查询
		sqlStr.append(" cfg.eu_age,                                                                                  ");
		sqlStr.append(" attr.id_age_level,                                                                           ");
		sqlStr.append(" cfg.fg_mmwh,                                                                                 ");
		sqlStr.append(" cfg.fg_stock,                                                                                ");
		sqlStr.append(" cfg.eu_long,                                                                                 ");
		sqlStr.append(" cfg.eu_pres_out,                                                                             ");
		sqlStr.append(" cfg.time_begin,                                                                              ");
		sqlStr.append(" cfg.time_end,                                                                                ");
		// 2020年6月22日13:38:01 增加录入科室限制查询
		sqlStr.append(" cfg.eu_dep_record,                                                                           ");
		sqlStr.append(" attr.id_dep as id_dep_record                                                                  ");
		sqlStr.append(" from bd_wf_cfg cfg                                                                           ");
		sqlStr.append(" inner join bd_wf wf on wf.id_wf = cfg.id_wf                                                  ");
		sqlStr.append(" left join bd_wf_cfg_attr attr on attr.id_wf_cfg = cfg.id_wf_cfg                              ");
		sqlStr.append(" left join bd_srvca srvca on srvca.id_srvca = attr.id_srvca and attr.eu_attr = 1              ");
		sqlStr.append(" left join bd_udidoc dosage on dosage.id_udidoc = attr.id_dosage and attr.eu_attr = 4         ");
		sqlStr.append(" left join bd_udidoc posi on posi.id_udidoc = attr.id_pois and attr.eu_attr = 5               ");
		sqlStr.append(" left join bd_udidoc herbperp on herbperp.id_udidoc = attr.id_herbperp and attr.eu_attr = 12  ");
		sqlStr.append(" left join bd_udidoc week on week.id_udidoc = attr.id_week and attr.eu_attr = 10              ");
		sqlStr.append(" where " + new BdFcEnvContextUtil().getWherePart(new WfDO(), "wf	"));
		String whereIn = WfUtils.getSqlParamChars(this.id_wfs);
		if (!StringUtil.isEmptyWithTrim(whereIn))
			sqlStr.append(" and cfg.id_wf in ( " + whereIn + " )                                                     ");
		sqlStr.append(" order by cfg.id_wf asc,cfg.sortno asc                                                        ");
		return sqlStr.toString();
	}
}
