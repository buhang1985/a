package iih.ei.std.s.v1.bp.pe.pathgydata.qry;

import iih.ei.std.d.v1.mp.pathgydata.d.PathgyApplyParamDTO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class QueryOPPathgySql implements ITransQry{
	
	private PathgyApplyParamDTO paramDTO;
	private String patId;
	public QueryOPPathgySql(PathgyApplyParamDTO paramDTO, String patId) {
		super();
		this.paramDTO = paramDTO;
		this.patId = patId;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
	    SqlParam param = new SqlParam();
	    param.addParam(paramDTO.getCode_entp());
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
		sqlStr.append(" pathgy.no_applyform as no_applyform,                                       ");//申请编号
		sqlStr.append(" pat.id_pat as id_pat,                                                      ");//患者ID
		sqlStr.append(" pat.name as name_pat,                                                      ");//患者姓名
		sqlStr.append(" sex.name as sex,                                                           ");//性别
		sqlStr.append(" nation.name as name_nation,                                                ");//民族
		sqlStr.append(" marry.name as name_marry,                                                  ");//婚姻状态
		sqlStr.append(" occu.name as name_occu,                                                    ");//职业
		sqlStr.append(" case when pat.id_idtp = '@@@@AA1000000000MNLZ' then pat.id_code  else '' end id_code,");//身份证号码
		sqlStr.append(" dept.name as name_dept,                                                    ");//科室名称
		sqlStr.append(" emp.name as name_emp,                                                      ");//执行人
		sqlStr.append(" pathgysamp.dt_sign as dt_sign,                                             ");//签收时间
		sqlStr.append(" samptp.name as name_samptp,                                                ");//标本类型名称
		sqlStr.append(" entip.code_amr_ip as code_amr_ip,                                          ");//住院号
		sqlStr.append(" dep_nur.name as name_dep_nur,                                              ");//病区
		sqlStr.append(" entip.name_bed as name_bed,                                                ");//床号
		sqlStr.append(" pathgy.str_name_di as str_name_di,                                         ");//诊断名称
		sqlStr.append(" pathgy.di_pathgy_old as di_pathgy_old,                                     ");//既往检查诊断
		sqlStr.append(" ord.sd_su_bl,                                                              ");//记账状态
		sqlStr.append(" (                                                                          ");
		sqlStr.append(" select sum(case fg_bl when 'Y' then 1 else 0 end)                          ");
		sqlStr.append(" from ci_or_srv orsrv where orsrv.id_or=ord.id_or                           ");
		sqlStr.append(" group by orsrv.id_or                                                       ");
		sqlStr.append(" ) as num_bl                                                                ");//医嘱需要计费的项目数
		sqlStr.append(" from ci_ap_pathgy pathgy                                                   ");
		sqlStr.append(" left join ci_order ord on ord.id_or = pathgy.id_or                         ");
		sqlStr.append(" left join pi_pat pat on pat.id_pat = ord.id_pat                            ");
		sqlStr.append(" left join ci_pathgy_samp pathgysamp on pathgysamp.id_appathgy = pathgy.id_appathgy");
		sqlStr.append(" left join bd_udidoc sex on sex.id_udidoc = pat.id_sex                      ");
		sqlStr.append(" left join bd_udidoc nation on nation.id_udidoc = pat.id_nation             ");
		sqlStr.append(" left join bd_udidoc marry on marry.id_udidoc = pat.id_marry                ");
		sqlStr.append(" left join bd_udidoc occu on occu.id_udidoc = pat.id_occu                   ");
		sqlStr.append(" left join bd_udidoc samptp on samptp.id_udidoc = pathgy.id_samptp and samptp.id_udidoclist = '@@@@ZZ20000000000026'");
		sqlStr.append(" left join en_ent_ip entip on entip.id_ent = ord.id_en                      ");
		sqlStr.append(" left join en_ent ent on ent.id_pat = pat.id_pat and ent.id_ent = ord.id_en ");
		sqlStr.append(" left join bd_dep dept on dept.id_dep = pathgy.id_dep                       ");
		sqlStr.append(" left join bd_dep dep_nur on dep_nur.id_dep = ent.id_dep_nur                ");
		sqlStr.append(" left join bd_psndoc emp on emp.id_psndoc = pathgy.id_emp                   ");
		sqlStr.append(" left join pi_pat_card patcard on patcard.id_pat = pat.id_pat               ");
		sqlStr.append(" where ent.code_entp = ?                                                    ");
		if (!StringUtil.isEmptyWithTrim(patId)) {
			sqlStr.append(" and pat.id_pat = ?                                                     ");
		}
		if (null != paramDTO.getNo_applyform()) {
			sqlStr.append(" and pathgy.no_applyform = ?                                            ");
		}
		return sqlStr.toString();
	}

}
