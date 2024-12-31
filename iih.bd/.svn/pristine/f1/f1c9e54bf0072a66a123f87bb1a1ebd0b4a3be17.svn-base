package iih.bd.fc.s.bp.deptflow.qry;

import iih.bd.fc.s.bp.common.BdFcEnvContextUtil;
import iih.bd.fc.s.bp.common.WfUtils;
import iih.bd.fc.wf.d.WfDO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @Description:获取医嘱流向部门信息
 * @author: xu_xing@founder.com.cn
 * @version：2019年1月10日 下午12:37:43 创建
 * @version: xuxing_2019年8月12日10:01:05，增加多组织管控
 */
public class GetWfDeptSql implements ITransQry {

	private String[] id_wfs;

	public GetWfDeptSql(String[] id_wfs) {
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
		sqlStr.append(" select                                        ");
		sqlStr.append(" wfdep.id_wfdep,                               ");
		sqlStr.append(" wf.id_wf,                                     ");
		sqlStr.append(" org.code as code_org,                         ");
		sqlStr.append(" org.name as name_org,                         ");
		sqlStr.append(" wf.eu_wftp,                                   ");
		sqlStr.append(" wf.code,                                      ");
		sqlStr.append(" wf.name,                                      ");
		sqlStr.append(" wf.code_entp,                                 ");
		sqlStr.append(" eu_wftp,                                      ");
		sqlStr.append(" id_wfdep,                                     ");
		sqlStr.append(" wfdep.sortno,                                 ");
		sqlStr.append(" wfdep.fg_macro,                               ");
		sqlStr.append(" wfdep.eu_macrodepmp,                          ");
		sqlStr.append(" wfdep.id_dep_mp,                              ");
		sqlStr.append(" wfdep.id_org_mp,                              ");
		sqlStr.append(" wfdep.id_srvcas,                              ");
		sqlStr.append(" wfdep.sd_srvcas,                              ");
		sqlStr.append(" wfdep.id_srvs,                                ");
		sqlStr.append(" wfdep.sd_srvs,                                ");
		sqlStr.append(" wfdep.id_usgs,                                ");
		sqlStr.append(" wfdep.sd_usgs,                                ");
		sqlStr.append(" wfdep.id_dosages,                             ");
		sqlStr.append(" wfdep.id_mms,                                 ");
		sqlStr.append(" wfdep.fg_mmwh,                                ");
		sqlStr.append(" wfdep.eu_presoutpctr,                         ");
		sqlStr.append(" wfdep.id_pois,                                ");
		sqlStr.append(" wfdep.sd_pois,                                ");
		sqlStr.append(" wfdep.ordrecurtp,                             ");
		sqlStr.append(" wfdep.time_b,                                 ");
		sqlStr.append(" wfdep.time_e,                                 ");
		sqlStr.append(" wfdep.id_weeks,                               ");
		sqlStr.append(" wfdep.sd_weeks,                               ");
		sqlStr.append(" wfdep.id_dep_ors,                             ");
		sqlStr.append(" wfdep.id_dep_clinics,                         ");
		sqlStr.append(" wfdep.id_dep_nurs,                            ");
		sqlStr.append(" wfdep.sd_herbpreparationtp                    ");//草药剂型
		sqlStr.append(" from bd_wf_dep wfdep                          ");
		sqlStr.append(" inner join bd_wf wf on wf.id_wf = wfdep.id_wf  ");
		sqlStr.append(" left join bd_org org on wfdep.id_org_mp = org.id_org ");
		sqlStr.append(" where wfdep.ds = 0                            ");
		sqlStr.append(" and " + new BdFcEnvContextUtil().getWherePart(new WfDO(), "wf"));
		sqlStr.append(" and wf.ds = 0                                 ");
		String whereInStr = WfUtils.getSqlParamChars(this.id_wfs);
		if (!StringUtil.isEmptyWithTrim(whereInStr)) {
			sqlStr.append(" and wf.id_wf in ( " + whereInStr + " )    ");
		} else {
			sqlStr.append(" and 1 = 2                                 ");
		}
		return sqlStr.toString();
	}
}
