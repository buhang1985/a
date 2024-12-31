package iih.ei.std.s.v1.bp.pe.pacsdata.qry;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pe.papt.pepsnappt.d.PePsnApptDO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

public class GetPeObsApInfoSql implements ITransQry{

	private String patID;// 患者id
	private String apply_no; //申请单号
	private String code;// 体检唯一码
	private String code_dep_mp;// 执行科室
	private String code_dep_pe;
	private String name_dep_pe;
	private String code_psn_pe;
	private String name_psn_pe;

	public GetPeObsApInfoSql(String patID, String apply_no, String code, String code_dep_mp, String code_dep_pe, String name_dep_pe, String code_psn_pe, String name_psn_pe) {
		super();
		this.patID = patID;
		this.apply_no = apply_no;
		this.code = code;
		this.code_dep_mp = code_dep_mp;
		this.code_dep_pe = code_dep_pe;
		this.name_dep_pe = name_dep_pe;
		this.code_psn_pe = code_psn_pe;
		this.name_psn_pe = name_psn_pe;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		
		// 体检
		param.addParam(IPiDictCodeConst.SD_ADDR_TYPE_ORIGIN);// 地址类型 籍贯
		param.addParam(IPiDictCodeConst.SD_ADDR_TYPE_COMMUNICATE);// 地址类型 通讯地址
		if (!StringUtil.isEmptyWithTrim(patID)) {
			param.addParam(patID);
		}
		if (!StringUtil.isEmptyWithTrim(apply_no)) {
			param.addParam(apply_no);
		}
		if (!StringUtil.isEmptyWithTrim(code)) {
			param.addParam(code);
		}
		if (!StringUtil.isEmptyWithTrim(code_dep_mp)) {
			param.addParam(code_dep_mp);// 执行科室
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {

		StringBuffer sql = new StringBuffer();
		//sql.append(" select enent.pe_code as Code_or,    ");// 医嘱编码
		sql.append(" select substr(cior.id_pepsnapptcat, 5, 16) as Code_or,    ");// 医嘱编码
		sql.append(" pipat.code as Code_pat,             ");// 患者编码
		sql.append(" pipat.name as Name_pat,             ");// 患者姓名
		sql.append(" pipat.pycode as Pycode_pat,         ");// 患者姓名拼音码
		sql.append(" sexudi.code as Sd_sex,              ");// 患者性别档案编码
		sql.append(" sexudi.name name_sex,               ");// 患者性别
		sql.append(" pipat.dt_birth as Dt_birth,         ");// 出生日期
		sql.append(" marryudi.code as Sd_marry,          ");// 婚姻档案编码
		sql.append(" birthaddr.street as birth_place,    ");// 出生地
		sql.append(" address.street as address,          ");// 现住址
		sql.append(" pipat.mob as relation_tel,          ");// 联系电话
		sql.append(" pipat.tel as patient_home_tel,      ");// 患者家庭电话
		sql.append(" pipat.id_code as id_card_no,        ");// 证件号码
		sql.append(" cior.ID_PEPSNAPPTCAT as id_or,        ");// 医嘱ID
		sql.append(" 'N' as fg_set,                      ");// 服务套标识
		sql.append(" enent.pe_code as code_amr_ip,       ");// 住院号
		sql.append(" '" + this.name_dep_pe + "' as Name_dep_nur,          ");// 病房（文字） 对应iih的护理单元
		sql.append(" '"+IBdFcDictCodeConst.SD_CODE_ENTP_PE+"' as code_entp ,                 ");// 患者就诊类型
		sql.append(" '体检中心'  name_entp,           ");// 患者就诊类型
		sql.append(" '" + this.name_dep_pe + "' as Name_dep_or,      ");// 开立科室
		sql.append(" '" + this.code_dep_pe + "' Code_dep_or,      ");// 开立科室编码
		sql.append(" '" + this.name_psn_pe + "' Name_emp_or,         ");// 开立医生
		sql.append(" '" + this.code_psn_pe + "' Code_emp_or,         ");// 开立医生编码
		sql.append(" execdep.name Name_dep_mp,       ");// 执行科室
		sql.append(" execdep.Code Code_dep_mp,       ");// 执行科室
		sql.append(" '体检' as des_sympsign,        "); // 症状
		sql.append(" '体检' as str_name_di,         "); // 诊断
		sql.append(" bdsrv.sd_srvtp as sd_srvtp,");// 检查类型编码 对应iih医疗服务类型02是检查
		sql.append(" bdsrv.code as Code_srv_exam, cat.price as Total_price,");// 服务类型编码
		sql.append(" enent.pe_code code_ent,           ");// 就诊流水
		//sql.append(" enent.pe_code as  no_applyform ,");// 申请单号
		sql.append(" substr(cior.id_pepsnapptcat, 5, 16) as  no_applyform ,");// 申请单号
		sql.append(" bdsrv.NAME as Name_srv_exam,");// 检查项目名称
		sql.append(" enent.dt_appt as dt_effe, ");// 申请时间
		sql.append(" case when cior.fg_paid = 'Y' then 1 else 0 end as sd_su_bl ");// 2019-08-13增加体检记账状态
		sql.append(" from pe_apt_pepsnapptcat cior");
		sql.append("  inner join pe_itm_pesrvbcatlog cat on cior.ID_PESRVCATLOG = cat.id_pesrvbcatlog");
		sql.append(" inner join pe_itm_pesrvcastapp orcast on cior.ID_PESRVCATLOG = orcast.ID_PESRVBCATLOG");
		sql.append("  inner join pe_apt_pepsnappt enent on enent.ID_PEPSNAPPT=cior.ID_PEPSNAPPT");
		sql.append("  inner join pe_or_pepsnbinfo pepsn on enent.ID_PEPSNBINFO = pepsn.ID_PEPSNBINFO");
		sql.append("  inner join bd_dep execdep on orcast.exec_unit_app = execdep.id_dep ");
		sql.append(" left join pi_pat pipat on pipat.id_pat = pepsn.id_pat");
		sql.append(" left join bd_udidoc sexudi on sexudi.id_udidoc = pipat.id_sex");
		sql.append(" left join bd_udidoc marryudi on marryudi.id_udidoc = pipat.id_marry");
		sql.append(" left join pi_pat_addr birthaddr on birthaddr.id_pat = pipat.id_pat and birthaddr.sd_addrtp= ?");
		sql.append(" left join pi_pat_addr address on address.id_pat = pipat.id_pat and address.sd_addrtp= ?");
		sql.append(" left join bd_srv bdsrv on bdsrv.id_srv = orcast.id_srv");
		sql.append(" left join bd_psndoc psn on psn.id_psndoc = '~'");
		sql.append(" left join pi_pat_hp pathp on pathp.id_pat = pipat.id_pat");
		sql.append(" left join pi_pat_card  patcard on patcard.id_pat = pipat.id_pat");
		sql.append(" where cat.CATLOG = 2");
		if(!StringUtil.isEmptyWithTrim(patID)){
			sql.append(" and pipat.id_pat=?");
		}
		if(!StringUtil.isEmptyWithTrim(apply_no)){
			sql.append(" and enent.pe_code=?");
		}
		if(!StringUtil.isEmptyWithTrim(code)){
			sql.append(" and enent.pe_code=?");
		}
		if(!StringUtil.isEmptyWithTrim(code_dep_mp)){
			sql.append(" and execdep.code=?");
		}
		sql.append(" and " + EnvContextUtil.processEnvContext("", new PePsnApptDO(), "enent")); // 管控

		return sql.toString();
	}

}