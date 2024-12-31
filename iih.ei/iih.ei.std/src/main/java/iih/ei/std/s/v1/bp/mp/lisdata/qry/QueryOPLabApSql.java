package iih.ei.std.s.v1.bp.mp.lisdata.qry;

import iih.bd.bc.udi.pub.IBdSrvTpDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ei.std.d.v1.mp.lisdata.d.LabParamDTO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;
/**
 * 
* @ClassName: QueryOPLabApSql
* @Description: 查询门诊检验申请单信息
* @author zhy
* @date 2019年9月27日
*
 */
public class QueryOPLabApSql implements ITransQry{
	
	private LabParamDTO paramDto;
    private String patID;
	public QueryOPLabApSql(LabParamDTO paramDto, String patID) {
		super();
		this.paramDto = paramDto;
		this.patID = patID;
	}
     
     
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(patID);// 患者编码
		param.addParam(IPiDictCodeConst.SD_ADDR_TYPE_NOW);//地址类型 现住址
		param.addParam(IBdSrvTpDictCodeConst.SD_SRVTP_LIS+"%");//服务类型为检查
		param.addParam(patID);
		param.addParam(paramDto.getCode_entp());//就诊类型
		if (!StringUtil.isEmptyWithTrim(paramDto.getCode_dep_mp())) {
			param.addParam(paramDto.getCode_dep_mp());
		}
		if (!StringUtil.isEmptyWithTrim(paramDto.getNo_applyform())) {
			param.addParam(paramDto.getNo_applyform());
		}
		if(null != paramDto.getDt_begin()){
			param.addParam(paramDto.getDt_begin());
		}
		if(null != paramDto.getDt_end()){
			param.addParam(paramDto.getDt_end());
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		
		return getWhereString();
	}

	public String getWhereString() {

		StringBuffer sql = new StringBuffer();

		sql.append("  select");
		sql.append("  enent.id_ent, ");
		sql.append("  pipat.code as code_pat,");
		sql.append("  pipat.name as name_pat, ");
		sql.append("  sexudi.code as sd_sex,");
		sql.append("  sexudi.name as name_sex,");
		sql.append("  cardtpudi.name as name_idtp,");
		sql.append("  pipat.id_code,");
		sql.append("  pipat.mob as tel,");
		sql.append("  pipat.dt_birth,");
		sql.append("  address.street as address,");
		sql.append("  pipat.sd_country,");
		sql.append("  countryudi.name as name_country,");
		sql.append("  aboudi.name as name_abo,");
		sql.append("  rhudi.name as name_rh,");
		sql.append("  patca.name as name_patca,");
		sql.append("  enentop.code_amr_oep,");
		//sql.append("  enent.code as code_card,");
		sql.append("  enent.code_entp,");
		sql.append("  enent.code as code_ent,");
		sql.append("  aplab.str_name_di as name_di,");//2017年12月13日10:40:56 xuxing 诊断取申请单诊断
		sql.append("  enent.dt_acpt,");
		sql.append("  aplab.no_applyform,");
		sql.append("  cior.id_or,");
		sql.append("  cior.code_or,");
		sql.append("  samp.no_bar,");
		sql.append("  cior.name_or as name_applyform,");
		sql.append("  cior.sd_srvtp,");
		sql.append("  srvtpudi.name as name_srvtp,");
		sql.append("  bdsrv.code as total_code_srv,");
		sql.append("  samptpudi.name  as name_samptp,");
		sql.append("  samptpudi.code as sd_samptp,");
		sql.append("  aplab.fg_urgent,");
		sql.append("  contpudi.code as sd_contp,");
		sql.append("  contpudi.name as name_contp,");
		sql.append("  colltpudi.code as sd_colltp,");
		sql.append("  colltpudi.name as name_colltp,");
		sql.append("  aplab.des_labsamp,");
		sql.append("  ordep.code as code_dep_app,");
		sql.append("  ordep.name as name_dep_app,");
		sql.append("  ordepmp.code as code_dep_mp,");
		sql.append("  ordepmp.name as name_dep_mp,");
		sql.append("  psn.code as code_emp_app,");
		sql.append("  psn.name as name_emp_app,");
		sql.append("  cior.dt_sign as dt_app,");
		sql.append("  cior.des_or,");
		sql.append(" cior.sd_su_bl,");// 2017-09-02增加记账状态
		sql.append(" ( ");
		sql.append("    select sum(case fg_bl when 'Y' then 1 else 0 end) ");
		sql.append("    from ci_or_srv orsrv where orsrv.id_or=cior.id_or");
		sql.append("    group by orsrv.id_or ");
		sql.append(" ) as num_bl");// 医嘱需要计费的项目数量
		
		sql.append(" from mp_or_pr orpr ");
		sql.append(" inner join ci_order cior on cior.id_or = orpr.id_or");
		sql.append(" left join bd_orpltpsta sta on sta.id_orpltpsta = orpr.id_orpltpsta");
		sql.append(" left join mp_ne_lab_samp_itm_ref ref on ref.id_or_pr = orpr.id_or_pr");
		sql.append(" left join mp_ne_lab_samp samp on samp.id_labsamp = ref.id_labsamp");
		sql.append("  inner join en_ent enent on enent.id_ent=cior.id_en");
		sql.append("  left join bd_srv bdsrv on bdsrv.id_srv=cior.id_srv");
		//sql.append("  left join en_ent_di entdi on entdi.id_ent = enent.id_ent and entdi.fg_maj='Y'");  //2017年12月13日10:40:56 xuxing 诊断取申请单诊断
		sql.append("  left join bd_dep ordep on ordep.id_dep=cior.id_dep_or ");
		sql.append("  left join bd_dep ordepmp on ordepmp.id_dep=cior.id_dep_mp ");
		sql.append("  inner join pi_pat pipat on pipat.id_pat = cior.id_pat and cior.id_pat= ?");
		sql.append("  left join bd_udidoc sexudi on sexudi.id_udidoc = pipat.id_sex");
		sql.append("  left join pi_pat_addr address on address.id_pat = pipat.id_pat and address.sd_addrtp=? ");
		sql.append("  left join pi_pat_biol patbiol on patbiol.id_pat = pipat.id_pat");
		sql.append("  left join bd_udidoc aboudi on aboudi.id_udidoc = patbiol.id_blood_abo");
		sql.append("  left join bd_udidoc rhudi on rhudi.id_udidoc = patbiol.id_blood_rh");
		sql.append("  left join bd_udidoc countryudi on countryudi.id_udidoc = pipat.id_country");
		sql.append("  left join bd_udidoc cardtpudi on cardtpudi.id_udidoc = pipat.id_idtp");
		sql.append("  left join pi_pat_ca patca on patca.id_patca = pipat.id_paticate ");
		sql.append("  inner join ci_ap_lab aplab on aplab.id_or= cior.id_or");
		sql.append("  left join bd_udidoc samptpudi on samptpudi.id_udidoc = aplab.id_samptp");
		sql.append("  left join bd_udidoc srvtpudi on srvtpudi.id_udidoc = cior.id_srvtp");
		sql.append("  left join bd_udidoc contpudi on contpudi.id_udidoc = aplab.id_contp");
		sql.append("  left join bd_udidoc colltpudi on colltpudi.id_udidoc = aplab.id_colltp");
		sql.append("  left join bd_psndoc psn on psn.id_psndoc = cior.id_emp_or");
		sql.append("  inner join en_ent_op enentop on enentop.id_ent = enent.id_ent ");
		sql.append(" left join pi_pat_hp pathp on pathp.id_pat = pipat.id_pat ");//关联医保卡
//		sql.append(" left join pi_pat_card  patcard on patcard.id_pat = pipat.id_pat ");//关联就诊卡
		sql.append(" where cior.sd_srvtp like ?  and orpr.eu_su=0 ");//过滤开立后的检验医嘱
		if(StringUtil.isEmptyWithTrim(patID)){
			sql.append(" and 1 = 2");
		}
		if(!StringUtil.isEmptyWithTrim(patID)){
			sql.append(" and pipat.id_pat=?");
		}
		sql.append(" and enent.code_entp = ?");
		if (!StringUtil.isEmptyWithTrim(paramDto.getCode_dep_mp())) {
			sql.append(" and ordepmp.code = ?");
		}
		if (!StringUtil.isEmptyWithTrim(paramDto.getNo_applyform())) {
			sql.append(" and cior.applyno = ?");
		}
		if (null != paramDto.getDt_begin()) {
			sql.append(" and cior.dt_effe >= ?");
		}
		if (null != paramDto.getDt_end()) {
			sql.append(" and cior.dt_effe < ?");
		}
		sql.append(" and "+  EnvContextUtil.processEnvContext("", new CiOrderDO(), "cior"));//增加管控

		return sql.toString();
	}
     
}
