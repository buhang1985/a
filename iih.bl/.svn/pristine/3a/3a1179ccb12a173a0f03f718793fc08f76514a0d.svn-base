package iih.bl.cg.bp.qry;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetPi4CmlInsDTOQry implements ITransQry {

	String codePat;

	/*
	 * 获取相关患者信息
	 */
	public GetPi4CmlInsDTOQry( String codePat) throws BizException {
		if (StringUtil.isEmpty(codePat))
			throw new BizException("请录入患者编码！");
		this.codePat = codePat;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(codePat);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ");
		sql.append(" PAT.CODE PID"); //患者ID
		sql.append(" ,PAT.name PATIENTNAME"); //患者姓名
		sql.append(" ,sexdoc.CODE_IE SEX"); //性别
		sql.append(" ,pat.dt_birth BIRTHDATE"); //出生日期
		sql.append(" ,nationdoc.name RACE"); //民族
		sql.append(" ,marrydoc.name MARITAL"); //婚姻
		sql.append(" ,COUNTRY.CODE NATIONALITY_CODE"); //国籍
//		sql.append(" --BIRTH_PLACE"); //出生地
		sql.append(" ,pat.sd_occu OCCUPATION_CODE"); //职业
		sql.append(" ,case when pat.sd_idtp = '01' then pat.id_code else null end SOCIAL_NO"); //身份证号
		sql.append(" ,idtpdoc.CODE_IE CREDENTIALTYPE"); //证件类型
		sql.append(" ,pat.id_code CREDENTIALNO"); //证件号码
//		sql.append(" --REGION_CODE"); //社保地区代码
//		sql.append(" --ORGANIZATION_ID"); //社保机构代码
		sql.append(" ,pathp.no_hp SSCARDNO"); //社保号
//		sql.append(" --HEALTHCARDNO"); //医保应用号
		sql.append(" ,pat.code_amr_ip IN_PATIENT_NO"); //住院号
		sql.append(" ,pat.code_amr_oep OUT_PATIENT_NO"); //门诊号
//		sql.append(" --HIC_NO"); //医疗证号
		sql.append(" ,nowaddr.sd_admdiv HOME_ADDR_CODE"); //现住址地区编码
		sql.append(" ,nowarea.fullname||nowaddr.street HOME_ADD"); //现住址
		sql.append(" ,nowaddr.zip HOME_PCODE"); //现住址邮编
		sql.append(" ,pat.workunit COMPANY"); //单位
		sql.append(" ,workarea.fullname||workaddr.street COMPANY_ADD"); //单位地址
		sql.append(" ,workarea.zipcode COMPANY_PCODE"); //单位住址邮编
		sql.append(" ,patcont.name LINKMAN_NM"); //联系人
		sql.append(" ,contdoc.name LINKMAN_REL"); //联系人关系
		sql.append(" ,patcont.contaddr LINKMAN_ADDR"); //联系人地址
		sql.append(" ,patcont.conttel LINKMAN_TEL"); //联系电话
		sql.append(" ,nativeaddr.sd_admdiv NATIVEPLACE_CODE"); //户籍地址
//		sql.append(" --GUARDIAN_NM"); //监护人姓名
//		sql.append(" --GUARDIAN_IDTYPE"); //监护人证件类型
//		sql.append(" --GUARDIAN_IDNO"); //监护人证件号码
		sql.append(" FROM PI_PAT PAT ");
		sql.append(" LEFT JOIN bd_udidoc sexdoc ON pat.id_sex = sexdoc.id_udidoc ");
		sql.append(" LEFT JOIN bd_udidoc nationdoc ON pat.id_nation = nationdoc.id_udidoc ");
		sql.append(" LEFT JOIN bd_udidoc marrydoc ON pat.id_marry = marrydoc.id_udidoc ");
		sql.append(" LEFT JOIN bd_udidoc idtpdoc ON pat.id_idtp = idtpdoc.id_udidoc ");
		sql.append(" LEFT JOIN pi_pat_hp pathp ON pat.id_pat = pathp.id_pat AND pathp.fg_deft = 'Y' ");
		sql.append(" LEFT JOIN pi_pat_addr nowaddr ON pat.id_pat = nowaddr.id_pat AND nowaddr.sd_addrtp = '9' ");
		sql.append(" LEFT JOIN bd_adminarea nowarea ON nowaddr.id_admdiv = nowarea.id_adminarea ");
		sql.append(" LEFT JOIN pi_pat_addr workaddr ON pat.id_pat = workaddr.id_pat AND workaddr.sd_addrtp = '2' ");
		sql.append(" LEFT JOIN bd_adminarea workarea ON workaddr.id_admdiv = workarea.id_adminarea ");
		sql.append(" LEFT JOIN pi_pat_addr nativeaddr ON pat.id_pat = nativeaddr.id_pat AND nativeaddr.sd_addrtp = '1' ");
		sql.append(" LEFT JOIN (SELECT MIN (pi_pat_cont.id_patcont) id_patcont, pi_pat_cont.id_pat FROM pi_pat_cont GROUP BY pi_pat_cont.id_pat ) patcontid ON pat.id_pat = patcontid.id_pat ");
		sql.append(" LEFT JOIN pi_pat_cont patcont ON patcontid.id_patcont = patcont.id_patcont ");
		sql.append(" LEFT JOIN bd_udidoc contdoc ON patcont.id_conttp = contdoc.id_udidoc ");
		sql.append(" LEFT JOIN BD_COUNTRY COUNTRY ON COUNTRY.ID_COUNTRYZONE=PAT.ID_COUNTRY ");
		sql.append(" WHERE PAT.code=? ");
		
		return sql.toString();
	}
}
