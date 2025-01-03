package iih.ei.std.s.v1.bp.pe.lisdata.qry;

import iih.bd.bc.udi.pub.IBdSrvTpDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.utils.ContextUtils;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ei.std.d.v1.mp.lisdata.d.LabParamDTO;
import iih.pe.papt.pepsnappt.d.PePsnApptDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;
/**
 * 
* @ClassName: QueryOPLabApSql
* @Description: 查询门诊检验申请单信息
* @author zhy
* @date 2019年9月27日
*
 */
public class QueryPELabApSql implements ITransQry{
	
	private LabParamDTO paramDto;
    private String patID;
    private String barcodetp;
	private String cdPeDept;
	private String cdPeChief;
	private String code_dep_pe;
	private String name_dep_pe;
	public QueryPELabApSql(LabParamDTO paramDto, String patID, String barcodetp, String code_dep_pe, String name_dep_pe) throws BizException {
		super();
		this.paramDto = paramDto;
		this.patID = patID;
		this.barcodetp = barcodetp;
		this.code_dep_pe = code_dep_pe;
		this.name_dep_pe = name_dep_pe;
		String org = ContextUtils.getOrgId();
		this.cdPeChief = ParamsetQryUtil.getParaString(org, "PE000013");  //体检中心负责人编码或ID, 0001Z810000000005KOE
		this.cdPeDept = ParamsetQryUtil.getParaString(org, "PE000014");   //医院体检中心科室编码或ID, 0001Z8100000000007QB
	}
     
     
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(paramDto.getNo_applyform());
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
		//兰陵，调用LIS的exe打印条码: pe_apt_pebarcode
		if("1".equals(barcodetp)) {
			sql.append(" select  enent.ID_PEPSNAPPT as id_ent,      pipat.code as code_pat,      pepsn.name as name_pat,       ");
			sql.append(" sexudi.code as sd_sex,      sexudi.name as name_sex,      cardtpudi.name as name_idtp,       ");
			sql.append(" pipat.id_code,      pipat.mob as tel,      pipat.dt_birth,      address.street as address,       ");
			sql.append(" pipat.sd_country,      countryudi.name as name_country,      aboudi.name as name_abo,       ");
			sql.append(" rhudi.name as name_rh,      patca.name as name_patca,      '' as code_amr_oep,  pipat.code as code_amr_ip,  ");
			sql.append(" patcard.code as code_card,      '02' as code_entp,      enent.pe_code as code_ent,   ordep.code as code_ward, '体检' as name_ward,  enent.card_pe as no_bed,  ");
			sql.append(" '体检' as name_di,      enent.dt_pe as dt_acpt,      enent.pe_code || cat.code as no_applyform,     '体检' as note_app,  ");
			sql.append(" enent.pe_code as id_or,      enent.pe_code as code_or,      cat.name as name_applyform,       ");
			sql.append(" srvtpudi.code as sd_srvtp,    srvtpudi.name as name_srvtp,      bdsrv.code as total_code_srv,   bdsrv.name as name_srv, ");
			sql.append(" cat.price as pri, 1 as quan_medu,   samptpudi.name as name_samptp,       ");
			sql.append(" samptpudi.code as sd_samptp,      'N' as fg_urgent,      contpudi.code as sd_contp,      contpudi.name as name_contp, ");      
			sql.append(" colltpudi.code as sd_colltp,      colltpudi.name as name_colltp,      aplab.des_labsamp as des_labsamp,       ");
			sql.append(" patacc.prepay,      patacc.acc_lock,       ");
			sql.append(" ordep.code as code_dep_app,      ordep.name as name_dep_app,      psn.code as code_emp_app, ");      
			sql.append(" psn.name as name_emp_app,      enent.dt_reg as dt_app,      cat.name as des_or,      ");
			sql.append(" case when enent.fg_nopay = 'Y' then '后付费' else '先付费' end as name_su_bl,     '1' as sd_su_bl,     1 as num_bl ");      
			sql.append(" from pe_apt_pepsnapptcat cior        inner join pe_itm_pesrvbcatlog cat on cior.ID_PESRVCATLOG = cat.id_pesrvbcatlog    ");    
			sql.append(" inner join pe_itm_pesrvcastapp orcast on cior.ID_PESRVCATLOG = orcast.ID_PESRVBCATLOG      ");
			sql.append(" inner join pe_apt_pepsnappt enent on enent.ID_PEPSNAPPT=cior.ID_PEPSNAPPT       ");
			sql.append(" inner join pe_or_pepsnbinfo pepsn on enent.ID_PEPSNBINFO = pepsn.ID_PEPSNBINFO      "); 
			sql.append(" inner join pe_apt_pebarcode bar on enent.ID_PEPSNAPPT = bar.ID_PEPSNAPPT       ");
			sql.append(" left join bd_srv bdsrv on bdsrv.id_srv=orcast.ID_SRV       ");
			sql.append(" left join bd_srv_lab aplab on bdsrv.id_srv = aplab.id_srv  ");
			sql.append(" left join bd_dep ordep on ordep.id_dep = '" + this.cdPeDept + "'       ");
			sql.append(" left join pi_pat pipat on pipat.id_pat = pepsn.id_pat       ");
			sql.append(" left join pi_pat_acc patacc on patacc.id_pat = pipat.id_pat       ");
			sql.append(" left join bd_udidoc sexudi on sexudi.id_udidoc = pipat.id_sex       ");
			sql.append(" left join pi_pat_addr address on address.id_pat = pipat.id_pat and address.sd_addrtp='9'     ");  
			sql.append(" left join pi_pat_biol patbiol on patbiol.id_pat = pipat.id_pat       ");
			sql.append(" left join bd_udidoc aboudi on aboudi.id_udidoc = patbiol.id_blood_abo       ");
			sql.append(" left join bd_udidoc rhudi on rhudi.id_udidoc = patbiol.id_blood_rh       ");
			sql.append(" left join bd_udidoc countryudi on countryudi.id_udidoc = pipat.id_country       ");
			sql.append(" left join bd_udidoc cardtpudi on cardtpudi.id_udidoc = pipat.id_idtp    ");
			sql.append(" left join bd_udidoc samptpudi on samptpudi.id_udidoc = aplab.id_samptp ");
			sql.append(" left join bd_udidoc srvtpudi on srvtpudi.id_udidoc = bdsrv.id_srvtp ");
			sql.append(" left join bd_udidoc contpudi on contpudi.id_udidoc = aplab.id_contp ");
			sql.append(" left join bd_udidoc colltpudi on colltpudi.id_udidoc = aplab.id_colltp    ");
			sql.append(" left join pi_pat_ca patca on patca.id_patca = pipat.id_paticate       ");
			sql.append(" left join bd_psndoc psn on psn.id_psndoc = '" + this.cdPeChief + "'      ");
			sql.append(" left join pi_pat_hp pathp on pathp.id_pat = pipat.id_pat      ");
			sql.append(" left join pi_pat_card  patcard on patcard.id_pat = pipat.id_pat and patcard.fg_act = 'Y' ");
			sql.append(" where cat.catlog = 3 ");

			//if (null !=dt_bgin) { 
			//	sql.append(" and enent.dt_pe  >= ?");
			//}
			//if (null !=dt_end ) {
			//	sql.append(" and enent.dt_pe < ?");
			//}

			if(StringUtil.isEmptyWithTrim(patID)){
				sql.append(" and 1 = 2");
			}else {
				sql.append(" and pipat.id_pat='" + this.patID + "'");
			}
			if (!StringUtil.isEmptyWithTrim(paramDto.getCode_dep_mp())) {
				sql.append(" and ordepmp.code = '" + paramDto.getCode_dep_mp() + "'");
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
			sql.append(" and "+  EnvContextUtil.processEnvContext("", new PePsnApptDO(), "enent"));//增加管控
		}
		//南大高新，体检打印条码，与HIS住院打印条码方式一致：pe_apt_labsamp
		else if("2".equals(barcodetp)) {
			sql.append(" select  enent.ID_PEPSNAPPT as id_ent,      pipat.code as code_pat,   bar.no_bar,   pepsn.name as name_pat,       ");
			sql.append(" sexudi.code as sd_sex,      sexudi.name as name_sex,      cardtpudi.name as name_idtp,       ");
			sql.append(" pipat.id_code,      pipat.mob as tel,      pipat.dt_birth,      address.street as address,       ");
			sql.append(" pipat.sd_country,      countryudi.name as name_country,      aboudi.name as name_abo,       ");
			sql.append(" rhudi.name as name_rh,      patca.name as name_patca,      '' as code_amr_oep,  pipat.code as code_amr_ip,  ");
			sql.append(" patcard.code as code_card,      '02' as code_entp,      enent.pe_code as code_ent,   ordep.code as code_ward, '体检' as name_ward,  enent.card_pe as no_bed,  ");
			sql.append(" '体检' as name_di,      enent.dt_pe as dt_acpt,      enent.pe_code || cat.code as no_applyform,     '体检' as note_app,  ");
			sql.append(" enent.pe_code as id_or,      enent.pe_code as code_or,      cat.name as name_applyform,       ");
			sql.append(" srvtpudi.code as sd_srvtp,    srvtpudi.name as name_srvtp,      bdsrv.code as total_code_srv,   bdsrv.name as name_srv, ");
			sql.append(" cat.price as pri, 1 as quan_medu,   samptpudi.name as name_samptp,       ");
			sql.append(" samptpudi.code as sd_samptp,      'N' as fg_urgent,      contpudi.code as sd_contp,      contpudi.name as name_contp, ");      
			sql.append(" colltpudi.code as sd_colltp,      colltpudi.name as name_colltp,      aplab.des_labsamp as des_labsamp,       ");
			sql.append(" patacc.prepay,      patacc.acc_lock,       ");
			sql.append(" ordep.code as code_dep_app,      ordep.name as name_dep_app,      psn.code as code_emp_app, ");      
			sql.append(" psn.name as name_emp_app,      enent.dt_reg as dt_app,      cat.name as des_or,      ");
			sql.append(" case when enent.fg_nopay = 'Y' then '后付费' else '先付费' end as name_su_bl,     '1' as sd_su_bl,     1 as num_bl ");      
			sql.append(" from pe_apt_pepsnapptcat cior        inner join pe_itm_pesrvbcatlog cat on cior.ID_PESRVCATLOG = cat.id_pesrvbcatlog    ");    
			sql.append(" inner join pe_itm_pesrvcastapp orcast on cior.ID_PESRVCATLOG = orcast.ID_PESRVBCATLOG      ");
			sql.append(" inner join pe_apt_pepsnappt enent on enent.ID_PEPSNAPPT=cior.ID_PEPSNAPPT       ");
			sql.append(" inner join pe_or_pepsnbinfo pepsn on enent.ID_PEPSNBINFO = pepsn.ID_PEPSNBINFO      "); 
			sql.append(" inner join pe_apt_labsamp bar on enent.ID_PEPSNAPPT = bar.id_ent      and cior.no_barcode = bar.no_bar     ");
			sql.append(" inner join bd_dep ordepmp on orcast.exec_unit_app = ordepmp.id_dep       ");
			sql.append(" left join bd_srv bdsrv on bdsrv.id_srv=orcast.ID_SRV       ");
			sql.append(" left join bd_srv_lab aplab on bdsrv.id_srv = aplab.id_srv  ");
			sql.append(" left join bd_dep ordep on ordep.id_dep = '" + this.cdPeDept + "'       ");
			sql.append(" left join pi_pat pipat on pipat.id_pat = pepsn.id_pat       ");
			sql.append(" left join pi_pat_acc patacc on patacc.id_pat = pipat.id_pat       ");
			sql.append(" left join bd_udidoc sexudi on sexudi.id_udidoc = pipat.id_sex       ");
			sql.append(" left join pi_pat_addr address on address.id_pat = pipat.id_pat and address.sd_addrtp='9'     ");  
			sql.append(" left join pi_pat_biol patbiol on patbiol.id_pat = pipat.id_pat       ");
			sql.append(" left join bd_udidoc aboudi on aboudi.id_udidoc = patbiol.id_blood_abo       ");
			sql.append(" left join bd_udidoc rhudi on rhudi.id_udidoc = patbiol.id_blood_rh       ");
			sql.append(" left join bd_udidoc countryudi on countryudi.id_udidoc = pipat.id_country       ");
			sql.append(" left join bd_udidoc cardtpudi on cardtpudi.id_udidoc = pipat.id_idtp    ");
			sql.append(" left join bd_udidoc samptpudi on samptpudi.id_udidoc = aplab.id_samptp ");
			sql.append(" left join bd_udidoc srvtpudi on srvtpudi.id_udidoc = bdsrv.id_srvtp ");
			sql.append(" left join bd_udidoc contpudi on contpudi.id_udidoc = aplab.id_contp ");
			sql.append(" left join bd_udidoc colltpudi on colltpudi.id_udidoc = aplab.id_colltp    ");
			sql.append(" left join pi_pat_ca patca on patca.id_patca = pipat.id_paticate       ");
			sql.append(" left join bd_psndoc psn on psn.id_psndoc = '" + this.cdPeChief + "'      ");
			sql.append(" left join pi_pat_hp pathp on pathp.id_pat = pipat.id_pat      ");
			sql.append(" left join pi_pat_card  patcard on patcard.id_pat = pipat.id_pat and patcard.fg_act = 'Y' ");
			sql.append(" where cat.catlog = 3 ");

			//if (null !=dt_bgin) { 
			//	sql.append(" and enent.dt_pe  >= ?");
			//}
			//if (null !=dt_end ) {
			//	sql.append(" and enent.dt_pe < ?");
			//}

			if(StringUtil.isEmptyWithTrim(patID)){
				sql.append(" and 1 = 2");
			}else{
				sql.append(" and pipat.id_pat='" + this.patID + "'");
			}
			if (!StringUtil.isEmptyWithTrim(paramDto.getCode_dep_mp())) {
				sql.append(" and ordepmp.code = '" + paramDto.getCode_dep_mp() + "'");
			}
			if (!StringUtil.isEmptyWithTrim(paramDto.getNo_applyform())) {
				sql.append(" and bar.no_bar = ?");
			}
			if (null != paramDto.getDt_begin()) {
				sql.append(" and cior.dt_effe >= ?");
			}
			if (null != paramDto.getDt_end()) {
				sql.append(" and cior.dt_effe < ?");
			}
			sql.append(" and "+  EnvContextUtil.processEnvContext("", new PePsnApptDO(), "enent"));//增加管控
		}
		//门诊LIS条码打印程序打印条码，直接根据pe_code查询出结果，一次性打印完成
		else if("3".equals(barcodetp)) {
			sql.append(" select  enent.ID_PEPSNAPPT as id_ent,      pipat.code as code_pat,      pepsn.name as name_pat,       ");
			sql.append(" sexudi.code as sd_sex,      sexudi.name as name_sex,      cardtpudi.name as name_idtp,       ");
			sql.append(" pipat.id_code,      pipat.mob as tel,      pipat.dt_birth,      address.street as address,       ");
			sql.append(" pipat.sd_country,      countryudi.name as name_country,      aboudi.name as name_abo,       ");
			sql.append(" rhudi.name as name_rh,      patca.name as name_patca,      '' as code_amr_oep,  pipat.code as code_amr_ip,  ");
			sql.append(" patcard.code as code_card,      '02' as code_entp,      enent.pe_code as code_ent, ordep.code  as code_ward, '体检' as name_ward,  enent.card_pe as no_bed,  ");
			sql.append(" '体检' as name_di,      enent.dt_pe as dt_acpt,      enent.pe_code || cat.code as no_applyform,     '体检' as note_app,  ");
			sql.append(" enent.pe_code as id_or,      enent.pe_code as code_or,      cat.name as name_applyform,       ");
			sql.append(" srvtpudi.code as sd_srvtp,    srvtpudi.name as name_srvtp,      bdsrv.code as total_code_srv,   bdsrv.name as name_srv, ");
			sql.append(" cat.price as pri, 1 as quan_medu,   samptpudi.name as name_samptp,       ");
			sql.append(" samptpudi.code as sd_samptp,      'N' as fg_urgent,      contpudi.code as sd_contp,      contpudi.name as name_contp, ");      
			sql.append(" colltpudi.code as sd_colltp,      colltpudi.name as name_colltp,      aplab.des_labsamp as des_labsamp,       ");
			sql.append(" patacc.prepay,      patacc.acc_lock,       ");
			sql.append(" ordep.code as code_dep_app,      ordep.name as name_dep_app,      psn.code as code_emp_app, ");      
			sql.append(" psn.name as name_emp_app,      enent.dt_reg as dt_app,      cat.name as des_or,      ");
			sql.append(" case when enent.fg_nopay = 'Y' then '后付费' else '先付费' end as name_su_bl,     '1' as sd_su_bl,     1 as num_bl ");      
			sql.append(" from pe_apt_pepsnapptcat cior        inner join pe_itm_pesrvbcatlog cat on cior.ID_PESRVCATLOG = cat.id_pesrvbcatlog    ");    
			sql.append(" inner join pe_itm_pesrvcastapp orcast on cior.ID_PESRVCATLOG = orcast.ID_PESRVBCATLOG      ");
			sql.append(" inner join pe_apt_pepsnappt enent on enent.ID_PEPSNAPPT=cior.ID_PEPSNAPPT       ");
			sql.append(" inner join pe_or_pepsnbinfo pepsn on enent.ID_PEPSNBINFO = pepsn.ID_PEPSNBINFO      "); 
			sql.append(" left join bd_srv bdsrv on bdsrv.id_srv=orcast.ID_SRV       ");
			sql.append(" left join bd_srv_lab aplab on bdsrv.id_srv = aplab.id_srv  ");
			sql.append(" left join bd_dep ordep on ordep.id_dep = '" + this.cdPeDept + "'       ");
			sql.append(" left join pi_pat pipat on pipat.id_pat = pepsn.id_pat       ");
			sql.append(" left join pi_pat_acc patacc on patacc.id_pat = pipat.id_pat       ");
			sql.append(" left join bd_udidoc sexudi on sexudi.id_udidoc = pipat.id_sex       ");
			sql.append(" left join pi_pat_addr address on address.id_pat = pipat.id_pat and address.sd_addrtp='9'     ");  
			sql.append(" left join pi_pat_biol patbiol on patbiol.id_pat = pipat.id_pat       ");
			sql.append(" left join bd_udidoc aboudi on aboudi.id_udidoc = patbiol.id_blood_abo       ");
			sql.append(" left join bd_udidoc rhudi on rhudi.id_udidoc = patbiol.id_blood_rh       ");
			sql.append(" left join bd_udidoc countryudi on countryudi.id_udidoc = pipat.id_country       ");
			sql.append(" left join bd_udidoc cardtpudi on cardtpudi.id_udidoc = pipat.id_idtp    ");
			sql.append(" left join bd_udidoc samptpudi on samptpudi.id_udidoc = aplab.id_samptp ");
			sql.append(" left join bd_udidoc srvtpudi on srvtpudi.id_udidoc = bdsrv.id_srvtp ");
			sql.append(" left join bd_udidoc contpudi on contpudi.id_udidoc = aplab.id_contp ");
			sql.append(" left join bd_udidoc colltpudi on colltpudi.id_udidoc = aplab.id_colltp    ");
			sql.append(" left join pi_pat_ca patca on patca.id_patca = pipat.id_paticate       ");
			sql.append(" left join bd_psndoc psn on psn.id_psndoc = '" + this.cdPeChief + "'      ");
			sql.append(" left join pi_pat_hp pathp on pathp.id_pat = pipat.id_pat      ");
			sql.append(" left join pi_pat_card  patcard on patcard.id_pat = pipat.id_pat and patcard.fg_act = 'Y' ");
			sql.append(" where cat.catlog = 3 ");

			//if (null !=dt_bgin) { 
			//	sql.append(" and enent.dt_pe  >= ?");
			//}
			//if (null !=dt_end ) {
			//	sql.append(" and enent.dt_pe < ?");
			//}

			if(StringUtil.isEmptyWithTrim(patID)){
				sql.append(" and 1 = 2");
			}
			else{
				sql.append(" and pipat.id_pat='" + this.patID + "'");
			}
			if (!StringUtil.isEmptyWithTrim(paramDto.getCode_dep_mp())) {
				sql.append(" and ordepmp.code = '" + paramDto.getCode_dep_mp() + "'");
			}
			if (!StringUtil.isEmptyWithTrim(paramDto.getNo_applyform())) {
				sql.append(" and enent.pe_code = ?");
			}
			if (null != paramDto.getDt_begin()) {
				sql.append(" and cior.dt_effe >= ?");
			}
			if (null != paramDto.getDt_end()) {
				sql.append(" and cior.dt_effe < ?");
			}
			sql.append(" and "+  EnvContextUtil.processEnvContext("", new PePsnApptDO(), "enent"));//增加管控
		}	
		
		return sql.toString();
	}
     
}
