package iih.ei.std.s.v1.bp.pe.pathgydata.qry;

import iih.bd.utils.ContextUtils;
import iih.ei.std.d.v1.mp.pathgydata.d.PathgyApplyParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class QueryPePathgySql implements ITransQry{
	
	private PathgyApplyParamDTO paramDTO;
	private String patId;
	private String cdPeDept;
	private String cdPeChief;
	
	public QueryPePathgySql(PathgyApplyParamDTO paramDTO, String patId) throws BizException {
		super();
		this.paramDTO = paramDTO;
		this.patId = patId;
		String org = ContextUtils.getOrgId();
		this.cdPeChief = ParamsetQryUtil.getParaString(org, "PE000013");  //体检中心负责人编码或ID, 0001Z810000000005KOE
		this.cdPeDept = ParamsetQryUtil.getParaString(org, "PE000014");   //医院体检中心科室编码或ID, 0001Z8100000000007QB
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
	    SqlParam param = new SqlParam();
	    if (!StringUtil.isEmptyWithTrim(cdPeDept)) {
	    	param.addParam(cdPeDept);
	    }
	    if (!StringUtil.isEmptyWithTrim(cdPeChief)) {
			param.addParam(cdPeChief);
		}
	    if (!StringUtil.isEmptyWithTrim(patId)) {
	    	param.addParam(patId);
	    }
	    if (null != paramDTO.getNo_applyform()) {
			param.addParam(paramDTO.getNo_applyform());
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select distinct                                                            ");
		sqlStr.append(" ord.no_apply as no_applyform,                                       ");//申请编号
		sqlStr.append(" pat.id_pat as id_pat,                                                      ");//患者ID
		sqlStr.append(" pat.name as name_pat,                                                      ");//患者姓名
		sqlStr.append(" sex.name as sex,                                                           ");//性别
		sqlStr.append(" nation.name as name_nation,                                                ");//民族
		sqlStr.append(" marry.name as name_marry,                                                  ");//婚姻状态
		sqlStr.append(" occu.name as name_occu,                                                    ");//职业
		sqlStr.append(" case when pat.id_idtp = '@@@@AA1000000000MNLZ' then pat.id_code  else '' end id_code,");//身份证号码
		sqlStr.append(" dept.name as name_dept,                                                    ");//科室名称
		sqlStr.append(" emp.name as name_emp,                                                      ");//执行人
		sqlStr.append(" enent.dt_pe as dt_sign,                                             ");//签收时间
		sqlStr.append(" samptp.name as name_samptp,                                                ");//标本类型名称
		sqlStr.append(" entip.code_amr_ip as code_amr_ip,                                          ");//住院号
		sqlStr.append(" dep_nur.name as name_dep_nur,                                              ");//病区
		sqlStr.append(" enent.card_pe as name_bed,                                                ");//床号
		sqlStr.append(" pathgy.str_name_di as str_name_di,                                         ");//诊断名称
		sqlStr.append(" pathgy.di_pathgy_old as di_pathgy_old,                                     ");//既往检查诊断
		sqlStr.append(" ord.sd_su_bl,                                                              ");//记账状态
		sqlStr.append(" (                                                                          ");
		sqlStr.append(" select sum(case fg_bl when 'Y' then 1 else 0 end)                          ");
		sqlStr.append(" from ci_or_srv orsrv where orsrv.id_or=ord.id_or                           ");
		sqlStr.append(" group by orsrv.id_or                                                       ");
		sqlStr.append(" ) as num_bl                                                                ");//医嘱需要计费的项目数
		sqlStr.append(" from pe_apt_pepsnapptcat ord        inner join pe_itm_pesrvbcatlog cat on ord.ID_PESRVCATLOG = cat.id_pesrvbcatlog    ");    
		sqlStr.append(" inner join pe_itm_pesrvcastapp orcast on cior.ID_PESRVCATLOG = orcast.ID_PESRVBCATLOG      ");
		sqlStr.append(" inner join pe_apt_pepsnappt enent on enent.ID_PEPSNAPPT=cior.ID_PEPSNAPPT       ");
		sqlStr.append(" inner join pe_or_pepsnbinfo pepsn on enent.ID_PEPSNBINFO = pepsn.ID_PEPSNBINFO      "); 
		sqlStr.append(" inner join pe_apt_pebarcode bar on enent.ID_PEPSNAPPT = bar.ID_PEPSNAPPT       ");
		sqlStr.append(" left join bd_srv bdsrv on bdsrv.id_srv=orcast.ID_SRV       ");
		sqlStr.append(" left join bd_srv_lab aplab on bdsrv.id_srv = aplab.id_srv  ");
		
		/*sqlStr.append(" from ci_ap_pathgy pathgy                                                   ");
		sqlStr.append(" left join ci_order ord on ord.id_or = pathgy.id_or                         ");
		sqlStr.append(" left join pi_pat pat on pat.id_pat = ord.id_pat                            ");
		sqlStr.append(" left join ci_pathgy_samp pathgysamp on pathgysamp.id_appathgy = pathgy.id_appathgy");*/
		sqlStr.append(" left join pi_pat pat on pat.id_pat = pepsn.id_pat                            ");
		sqlStr.append(" left join bd_udidoc sex on sex.id_udidoc = pat.id_sex                      ");
		sqlStr.append(" left join bd_udidoc nation on nation.id_udidoc = pat.id_nation             ");
		sqlStr.append(" left join bd_udidoc marry on marry.id_udidoc = pat.id_marry                ");
		sqlStr.append(" left join bd_udidoc occu on occu.id_udidoc = pat.id_occu                   ");
		sqlStr.append(" left join bd_udidoc samptp on samptp.id_udidoc = aplab.id_samptp and samptp.id_udidoclist = '@@@@ZZ20000000000026'");
		sqlStr.append(" left join bd_dep dept on dept.id_dep = ?                      ");
		sqlStr.append(" left join bd_dep dep_nur on dep_nur.id_dep = ent.id_dep_nur                ");
		sqlStr.append(" left join bd_psndoc emp on emp.id_psndoc = ?                   ");
		sqlStr.append(" left join pi_pat_card patcard on patcard.id_pat = pat.id_pat               ");
		sqlStr.append(" where cat.catlog = 3 ");
		sqlStr.append(" order by enent.pe_code ");
		if (!StringUtil.isEmptyWithTrim(patId)) {
			sqlStr.append(" and pat.id_pat = ?                                                     ");
		}
		if (null != paramDTO.getNo_applyform()) {
			sqlStr.append(" and pathgy.no_applyform = ?                                            ");
		}
		return sqlStr.toString();
	}

}
