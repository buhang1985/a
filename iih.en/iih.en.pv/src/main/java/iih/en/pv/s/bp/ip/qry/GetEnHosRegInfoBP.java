package iih.en.pv.s.bp.ip.qry;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.res.bed.d.Bdbed;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.EntContEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.PatEP;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnHosRegDTO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpRService;
import iih.en.pv.pativisit.d.EntContDO;
import iih.en.pv.pativisit.d.EuEntContTp;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pat.i.IPatiRService;
import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.aptip.d.desc.AptIpDODesc;
import iih.sc.apt.aptip.i.IAptipMDORService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;

/**
 * 住院登记查询
 * 
 * @author renying
 *
 */
public class GetEnHosRegInfoBP {
	
	/**
	 * 住院登记查询
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public EnHosRegDTO[] exec(String patId) throws BizException {
		if (EnValidator.isEmpty(patId)) {
			return null;
		}
		// 取得住院数据
		EnHosRegDTO[] results = getInpatientData(patId);
		for(EnHosRegDTO result : results){
			if (EnValidator.isEmpty(result.getId_ent())) {
				//查询入院通知单
				List<EnHosRegDTO> result2 = getNoticeData(patId);
				// PatiAggDO patAgg = this.getPatAggDO(patId);
				if (EnValidator.isEmpty(result2)) {
					return results;
				}
				result2.add(results[0]);

				return result2.toArray(new EnHosRegDTO[]{});
			}
		}
		// 取得住院通知单数据
		return results;
	}
	/**
	 * 通过就诊id获取住院就诊数据
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public EnHosRegDTO getEnHosRegByEntId(String entId, FBoolean fg_st) throws BizException {
		if(EnValidator.isEmpty(entId))
			return null;
		StringBuffer sqlSb = new StringBuffer();
		sqlSb.append(" Select ent.id_ent,ent.fg_ip,");
		sqlSb.append(" ent.dt_entry, ");
		sqlSb.append(" ent.id_pripat,");
		sqlSb.append(" pripat.name as pri_name, ");
		sqlSb.append(" ent.id_patcret,");
		sqlSb.append(" patcret.name as pat_name, ");
		sqlSb.append(" ent.id_pat,");
		sqlSb.append(" ent.code code_ent,");
		sqlSb.append(" ent.code_hpmedkind,");//诊疗类别
		sqlSb.append(" hmk.id_hpmedkindah id_hpmedkind,");
		sqlSb.append(" hmk.name name_hpmedkind,");
		sqlSb.append(" ip.id_level_diseadm,");
		sqlSb.append(" ip.id_patcont,");
		sqlSb.append(" ip.sd_level_diseadm,");
		sqlSb.append(" ip.sd_status,");
		sqlSb.append(" ip.id_referalsrc,");
		sqlSb.append(" ip.sd_referalsrc,");
		sqlSb.append(" ip.id_dep_phyadm,");
		sqlSb.append(" ip.times_ip times ,");
		sqlSb.append(" ip.id_dep_nuradm,");
		sqlSb.append(" ip.id_bed,");
		sqlSb.append(" ip.name_bed      bedname,");
		sqlSb.append(" ip.Id_diag_op    Id_diag,");
		sqlSb.append(" ip.Desc_diag_op   Desc_diag,");
		sqlSb.append(" ent.id_patca as id_paticate,");
		sqlSb.append(" patca.name as name_paticate,");
		sqlSb.append(" ent.note,");//备注
		sqlSb.append(" def.name as Dia_name,");
		sqlSb.append(" def.code as sd_diag,");
		sqlSb.append(" udidoc.name     referalsrc_name,");
		sqlSb.append(" udidoc2.name   name_level_diseadm,");
		sqlSb.append(" case ip.sd_status");
		sqlSb.append("  when '25' then '在院'");
		sqlSb.append("  when '22' then '登记'");
		sqlSb.append("  when '28' then '出院'");
		sqlSb.append("  end as show_ipstatus,");
		sqlSb.append(" bed.sd_bedsexlimit   sd_bedsex,");
		sqlSb.append(" opemp.name name_emp_phy_op,");
		sqlSb.append(" ip.id_emp_opapply id_emp_phy_op ");
		sqlSb.append(" (CASE WHEN EXISTS (SELECT TAGTP.ID_ENTTAGTP FROM EN_ENT_TAGTP TAGTP WHERE TAGTP.ID_ENT = ent.ID_ENT AND TAGTP.CODE_TAGTP = '003') THEN 'Y' ELSE 'N' END) AS FG_POOR ");//贫困患者
		sqlSb.append(" from en_ent ent");
		sqlSb.append(" inner join en_ent_ip ip");
		sqlSb.append("   on ent.id_ent = ip.id_ent");
		sqlSb.append(" left join pi_pat pat on ent.id_pat = pat.id_pat ");
		sqlSb.append(" left outer join pi_pat_ca patca ");
		sqlSb.append("   on ent.id_patca = patca.id_patca ");
		sqlSb.append(" left outer join bd_pri_pat pripat ");
		sqlSb.append("   on ent.id_pripat = pripat.Id_pripat ");
		sqlSb.append(" left outer join pi_pat_cret patcret ");
		sqlSb.append("   on ent.id_patcret = patcret.Id_patcret ");
		sqlSb.append(" left outer join bd_udidoc udidoc");
		sqlSb.append("   on ip.id_referalsrc = udidoc.id_udidoc");
		sqlSb.append(" left outer join bd_udidoc udidoc2");
		sqlSb.append("   on ip.id_level_diseadm = udidoc2.id_udidoc");
		sqlSb.append(" left join bd_di_def def");
		sqlSb.append("   on def.id_didef = ip.Id_diag_op ");
		sqlSb.append(" left join bd_hp_med_kind_ah hmk");
		sqlSb.append("   on ent.code_hpmedkind = hmk.code ");
		sqlSb.append(" left join bd_bed bed");
		sqlSb.append(" 	 on bed.id_bed = ip.id_bed");
		sqlSb.append(" left join bd_psndoc opemp on ip.id_emp_opapply = opemp.id_psndoc");
		sqlSb.append("  where ent.id_ent = ?");
		sqlSb.append(" and ent.fg_canc = ? ");
		SqlParam param = new SqlParam();
		param.addParam(entId);
		param.addParam(FBoolean.FALSE);
		@SuppressWarnings("unchecked")
		List<EnHosRegDTO> list = (List<EnHosRegDTO>) new DAFacade().execQuery(sqlSb.toString(), param, new BeanListHandler(EnHosRegDTO.class));
		if(!EnValidator.isEmpty(list)){
			EnHosRegDTO enHostReg = list.get(0);
			this.setHpValue(enHostReg);
			return enHostReg;
		}
		return null;
	}
	/**
	 * 查询sql
	 * 
	 * @param idPat
	 * @return
	 * @throws BizException
	 */
	private EnHosRegDTO[] getInpatientData(String idPat) throws BizException {
		StringBuffer sqlSb = new StringBuffer();

		sqlSb.append(" Select ent.id_ent,");
		sqlSb.append(" ent.fg_ip, ");
		sqlSb.append(" ent.code_entp,");
		sqlSb.append(" ent.id_entp,");
		sqlSb.append(" ent.dt_entry, ");
		sqlSb.append(" ent.id_patca as id_paticate,");
		sqlSb.append(" patca.name as name_paticate,");
		sqlSb.append(" ent.id_pripat,");
		sqlSb.append(" pripat.name as pri_name, ");
		sqlSb.append(" ent.id_patcret,");
		sqlSb.append(" patcret.name as pat_name, ");
		sqlSb.append(" ent.id_pat,");
		sqlSb.append(" ent.code code_ent,");
		sqlSb.append(" ent.code_hpmedkind,");//诊疗类别
		sqlSb.append(" hmk.id_hpmedkindah id_hpmedkind,");
		sqlSb.append(" hmk.name name_hpmedkind,");
		sqlSb.append(" ent.id_emp_phy,");
		sqlSb.append(" emp.code as code_emp_phy,");
		sqlSb.append(" emp.name as name_emp_phy,");
		sqlSb.append(" ent.note,");//备注
		sqlSb.append(" ip.id_level_diseadm,");
		sqlSb.append(" ip.id_patcont,");
		sqlSb.append(" ip.fg_newborn  Fg_bb,");
		sqlSb.append(" ip.sd_level_diseadm,");
		sqlSb.append(" ip.sd_status,");
		sqlSb.append(" ip.id_referalsrc,");
		sqlSb.append(" ip.sd_referalsrc,");
		sqlSb.append(" ip.id_ip_spec, ");
		sqlSb.append(" ip.sd_ip_spec, ");
		sqlSb.append(" udidoc3.name as name_ip_spec, ");
		sqlSb.append(" ip.id_dep_phyadm as id_dep_phyadm,");
		sqlSb.append(" ip.times_ip times ,");
		sqlSb.append(" ip.id_dep_nuradm as id_dep_nuradm,");
		sqlSb.append(" ip.id_bed,");
		sqlSb.append(" bed.code as code_bed, ");
		sqlSb.append(" ip.name_bed      bedname,");
		sqlSb.append(" ip.Id_diag_op    Id_diag,");
		sqlSb.append(" ip.Desc_diag_op   Desc_diag,");
		sqlSb.append(" ip.fg_vip,");
		sqlSb.append(" def.name as Dia_name,");
		sqlSb.append(" def.code as sd_diag,");
		sqlSb.append(" udidoc.name     referalsrc_name,");
		sqlSb.append(" udidoc2.name   name_level_diseadm,");
		sqlSb.append(" case ip.sd_status when '25' then '在院' when '22' then '登记' end as show_ipstatus,");
		sqlSb.append(" bed.sd_bedsexlimit   sd_bedsex,");
		sqlSb.append(" opemp.name name_emp_phy_op,");
		sqlSb.append(" opemp.code code_emp_phy_op,");
		sqlSb.append(" ip.id_emp_opapply id_emp_phy_op,");
		sqlSb.append(" ent.id_cust_cmpy,");
		sqlSb.append(" cust.name name_cust_cmpy,");
		sqlSb.append(" apt.amt_deposit,");
		sqlSb.append(" apt.id_bed id_bed_sc ,");
		sqlSb.append(" ip.fg_ippre,");
		sqlSb.append(" dep2.name name_dep_phy_target, ");//目标科室
		sqlSb.append(" dep3.name name_dep_nur_target ");//目标病区
		sqlSb.append(" from en_ent ent");
		sqlSb.append(" inner join en_ent_ip ip on ent.id_ent = ip.id_ent ");
		sqlSb.append(" left join pi_pat pat on ent.id_pat = pat.id_pat ");
		sqlSb.append(" left join bd_bed bed on ip.id_bed = bed.id_bed ");
		sqlSb.append(" left join bd_psndoc emp on ent.id_emp_phy = emp.id_psndoc ");
		sqlSb.append(" left outer join pi_pat_ca patca on ent.id_patca = patca.id_patca ");
		sqlSb.append(" left outer join bd_pri_pat pripat on ent.id_pripat = pripat.Id_pripat ");
		sqlSb.append(" left outer join pi_pat_cret patcret on ent.id_patcret = patcret.Id_patcret ");
		sqlSb.append(" left outer join bd_udidoc udidoc on ip.id_referalsrc = udidoc.id_udidoc ");
		sqlSb.append(" left outer join bd_udidoc udidoc2 on ip.id_level_diseadm = udidoc2.id_udidoc ");
		sqlSb.append(" left join bd_udidoc udidoc3 on ip.id_ip_spec = udidoc3.id_udidoc ");
		sqlSb.append(" left join bd_di_def def on def.id_didef = ip.Id_diag_op ");
		sqlSb.append(" left join bd_hp_med_kind_ah hmk on ent.code_hpmedkind = hmk.code and ent.id_hp = hmk.id_hp ");
		sqlSb.append(" left join bd_bed bed on bed.id_bed = ip.id_bed");
		sqlSb.append(" left join bd_psndoc opemp on ip.id_emp_opapply = opemp.id_psndoc");
		sqlSb.append(" left join bd_cust cust on ent.id_cust_cmpy = cust.id_cust");
		sqlSb.append(" left join sc_apt_ip apt on apt.id_entip = ent.id_ent");
		sqlSb.append(" left join en_ippre ippre on ippre.id_ent = ent.id_ent");
		//查询已经入院的患者的入院登记信息,如果是预住院,就取预住院表的数据
		sqlSb.append(" left join bd_dep dep2 on (case when ippre.id_preip is null then ip.id_dep_phyadm else ippre.id_dep_phy end)= dep2.id_dep ");
		sqlSb.append(" left join bd_dep dep3 on (case when ippre.id_preip is null then ip.id_dep_nuradm else ippre.id_dep_ward end) = dep3.id_dep ");
		sqlSb.append(" where ent.id_pat = ?");
		sqlSb.append(" and ip.sd_status in ('" + IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN + "','" // del																									
				+ IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN + "')");
		sqlSb.append(" and ent.code_entp in (?,?) ");
		SqlParam param = new SqlParam();
		param.addParam(idPat);
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE);
		@SuppressWarnings("unchecked")
		List<EnHosRegDTO> list = (List<EnHosRegDTO>) new DAFacade().execQuery(sqlSb.toString(), param, new BeanListHandler(EnHosRegDTO.class));
		PatiAggDO patAgg = this.getPatAggDO(idPat);
		if (EnValidator.isEmpty(list)) {
			EnHosRegDTO enhosDTO = new EnHosRegDTO();
			enhosDTO.setId_pat(idPat);
			this.setPatCate(enhosDTO);
			this.getIpTimes(enhosDTO);
			enhosDTO.setStatus(DOStatus.NEW);
			//设置患者就诊标签
			QryPatHpTagtpBP tagtp = new QryPatHpTagtpBP();
			tagtp.exec(enhosDTO);
			return new EnHosRegDTO[]{enhosDTO};
		}
		for(EnHosRegDTO enhosDTO: list){
			this.getHPValue(enhosDTO, patAgg);
			this.getDepName(enhosDTO);
			this.getPatContInfo(patAgg, enhosDTO);
			//		this.getPatCate(enhosDTO, patAgg);		
			if(this.IsHasIpnt(enhosDTO.getId_ent())){
				enhosDTO.setFg_aptip(FBoolean.TRUE);
			}
			//设置患者就诊标签
			QryPatHpTagtpBP tagtp = new QryPatHpTagtpBP();
			tagtp.exec(enhosDTO);
		}
		return list.toArray(new EnHosRegDTO[0]);
	}

	/**
	 * 设置入院次数
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void getIpTimes(EnHosRegDTO enhosDTO) throws BizException {
		enhosDTO.setTimes(new IpEP().setIpTimes(enhosDTO.getId_pat()));
	}

	/**
	 * 查询入院通知单sql
	 * 
	 * @param idPat
	 * @return
	 * @throws BizException
	 */
	private List<EnHosRegDTO> getNoticeData(String idPat) throws BizException {

		StringBuffer sqlSb = new StringBuffer();
		sqlSb.append(" select ip.id_aptip Id_ent_ipnt, ");
		sqlSb.append(" ip.fg_ippre, ");
		//如果是预住院患者,前端的"入院科室"就取申请单的预住院科室,如果不是预住院患者,就取申请单的入院科室   病区同理.
		sqlSb.append(" case when ip.fg_ippre = 'Y'  then  ip.id_dep_phy_ippre else ip.id_dep_phy_ip end id_dep_phyadm,");
		sqlSb.append(" case when bed.id_bed is null then (case when ip.fg_ippre = 'Y'  then  ip.id_dep_nur_ippre else ip.id_dep_nur_ip end) else dep3.id_dep end  id_dep_nuradm,");
		sqlSb.append(" ip.id_dep_phy_ip    id_dep_phy_target,");//目标科室
		sqlSb.append(" case when bed.id_bed is null then ip.id_dep_nur_ip else dep3.id_dep end  id_dep_nur_target,");//目标病区
		sqlSb.append(" ip.id_didef_op   id_diag,");
	    sqlSb.append(" ip.amt_deposit,");
		sqlSb.append(" ip.supplement_di desc_diag,");
		sqlSb.append(" ip.sd_level_dise    sd_level_diseadm,");
		sqlSb.append(" ip.id_level_dise    id_level_diseadm,");
		sqlSb.append(" ip.sd_status  apt_status,");
		sqlSb.append(" ip.id_bed,");
		sqlSb.append(" ip.id_emp_phy_op,");
		sqlSb.append(" ip.name_emp_phy_op,");
		sqlSb.append(" ip.fg_vip,");
		sqlSb.append(" ip.dt_insert dt_insert_sc,");
		sqlSb.append(" ip.id_referalsrc,");
		sqlSb.append(" ip.sd_referalsrc,");
		sqlSb.append(" ip.id_bed id_bed_sc,");
		sqlSb.append(" udidoc2.name     referalsrc_name,");
		sqlSb.append(" intrpsn.name as name_pe_intr, ");
		//sqlSb.append(" ent.id_ent,");
		sqlSb.append(" udidoc.name         name_level_diseadm,");
		sqlSb.append(" dep.name            phy_name,");//入院科室名称
		sqlSb.append(" dep.code            code_dep_phyadm,");
		sqlSb.append(" case when bed.id_bed is null then dep2.name else dep3.name end   nur_name,");
		sqlSb.append(" case when bed.id_bed is null then dep2.code else dep3.code end   code_dep_nuradm,");
		sqlSb.append(" dep4.name  name_dep_phy_target,");//目标科室
		sqlSb.append(" case when bed.id_bed is null then dep5.name else dep3.name end   name_dep_nur_target,");//目标病区
		sqlSb.append(" bed.name  bedname,");
		sqlSb.append(" bed.id_dep_belong   id_nur_bed,");
		sqlSb.append(" def.name            dia_name,");
		sqlSb.append(" def.code as sd_diag,");
		sqlSb.append(" bed.sd_bedsexlimit   sd_bedsex,");
		sqlSb.append(" ent.id_cust_cmpy,");
		sqlSb.append(" opemp.code code_emp_phy_op,");
		sqlSb.append(" cust.name name_cust_cmpy ");
		sqlSb.append(" from sc_apt_ip ip");
		sqlSb.append(" left join en_ent ent on ent.id_ent = ip.id_ent");
		sqlSb.append(" left outer join bd_dep dep on (case when ip.fg_ippre = 'Y' then ip.id_dep_phy_ippre else ip.id_dep_phy_ip end) = dep.id_dep");
		sqlSb.append(" left outer join bd_dep dep2 on (case when ip.fg_ippre = 'Y' then ip.id_dep_nur_ippre else ip.id_dep_nur_ip end) = dep2.id_dep");
		sqlSb.append(" left outer join bd_di_def def on ip.id_didef_op = def.id_didef");
		sqlSb.append(" left outer join bd_udidoc udidoc on udidoc.id_udidoc = ip.id_level_dise");
		sqlSb.append(" left join bd_bed bed on ip.id_bed = bed.id_bed ");
		sqlSb.append(" left outer join bd_dep dep3 on bed.id_dep_belong = dep3.id_dep");
		sqlSb.append(" left outer join bd_dep dep4 on ip.id_dep_phy_ip = dep4.id_dep ");
		sqlSb.append(" left outer join bd_dep dep5 on ip.id_dep_nur_ip = dep5.id_dep");
		sqlSb.append(" left join bd_cust cust on ent.id_cust_cmpy = cust.id_cust");
		sqlSb.append(" left join bd_psndoc opemp on ip.id_emp_phy_op = opemp.id_psndoc");
		sqlSb.append(" left outer join bd_udidoc udidoc2 on ip.id_referalsrc = udidoc2.id_udidoc ");
		sqlSb.append(" left join bd_psndoc intrpsn on ip.id_introducer = intrpsn.id_psndoc ");
		sqlSb.append(" where ");
		sqlSb.append(" ip.sd_status in ('" + IEnDictCodeConst.SD_STATUS_NOTICE_CREATE + "','" + IEnDictCodeConst.SD_STATUS_NOTICE_NOTIFY + "','"

		+ IEnDictCodeConst.SD_STATUS_NOTICE_ACC + "','" + IEnDictCodeConst.SD_STATUS_NOTICE_REFUSE + "')");
		sqlSb.append(" and ip.fg_emgstay = 'N'  and ip.Fg_canc ='N'");// 急诊留观标识
		
		SqlParam param = new SqlParam();
		//判断是否为合并患者，如果是获取所有的申请单
		IPatiMDORService iService = ServiceFinder.find(IPatiMDORService.class);
		PatDO patDo = iService.findById(idPat);
		PatDO[] patDOs = iService.findByAttrValString("Id_person", patDo.getCode());
		if (patDOs == null || patDOs.length <= 0) {
			sqlSb.append(" and ip.id_pat = ? ");
			param.addParam(idPat);
		}else{
			List<String> list = new ArrayList<String>();
			for (PatDO patDO : patDOs) {
				if (list.contains(patDO.getId_pat())) {
					continue;
				}
				list.add(patDO.getId_pat());
			}
			String strParam = EnSqlUtils.getInSqlByIds("ip.id_pat", list);
			if (strParam != null) {
				sqlSb.append(" and " + strParam + " ");
			}
		}
		
		@SuppressWarnings("unchecked")
		List<EnHosRegDTO> list = (List<EnHosRegDTO>) new DAFacade().execQuery(sqlSb.toString(), param, new BeanListHandler(EnHosRegDTO.class));
		if (EnValidator.isEmpty(list)) {
			return null;
		}
		for (EnHosRegDTO enhosDTO : list) {
			enhosDTO.setId_pat(idPat);
			enhosDTO.setFg_aptip(FBoolean.TRUE);
			this.setPatCate(enhosDTO);
			if(EnValidator.isEmpty(enhosDTO.getId_dep_nuradm()) &&!EnValidator.isEmpty(enhosDTO.getId_bed())){
				this.getBedNur(enhosDTO);
			}	
			if (enhosDTO.getTimes() == null) {
				this.getIpTimes(enhosDTO);
			}
		}
		return list;
	}
	
	/**
	 * 设置床位所属的病区
	 * @param enhosDTO
	 * @throws BizException
	 */
	private void getBedNur(EnHosRegDTO enhosDTO) throws BizException
	{
//		IAptipMDORService aptRService = ServiceFinder.find(IAptipMDORService.class);
//		AptIpDO aptIpDO = aptRService.findById(enhosDTO.getId_ent_ipnt());
		BedEP bedEp = new BedEP();
		Bdbed bedDO = bedEp.getBed(enhosDTO.getId_bed());
		enhosDTO.setId_dep_nuradm(bedDO.getId_dep_belong());
		enhosDTO.setNur_name(bedDO.getDept_name());
	}
	
	/**
	 * 查找pataggdo
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private PatiAggDO getPatAggDO(String patId) throws BizException {
		IPatiRService rservice = ServiceFinder.find(IPatiRService.class);
		PatiAggDO patAgg = rservice.findById(patId);
		EnValidator.isEmpty(patAgg);
		return patAgg;
	}
	/**
	 * 设置医保计划
	 * 
	 * @param enhosDTO
	 * @return
	 * @throws BizException
	 */
	private void setHpValue(EnHosRegDTO enhosDTO) throws BizException {
		String entID = enhosDTO.getId_ent();
		IEnthpRService rservice = ServiceFinder.find(IEnthpRService.class);
		EntHpDO[] entHpDOArr = rservice.findByAttrValString(EntHpDO.ID_ENT, entID);
		if(EnValidator.isEmpty(entHpDOArr))
			return;
		for (EntHpDO hpDO : entHpDOArr) { // 查询就诊医保
			if (enhosDTO.getId_ent().equals(hpDO.getId_ent())) {
				if (hpDO.getFg_maj() == FBoolean.TRUE) {
					enhosDTO.setPrim_cplan(hpDO.getId_hp());
					enhosDTO.setPrim_name(hpDO.getName_hp());
					enhosDTO.setId_enthp_prim(hpDO.getId_enthp());
					enhosDTO.setCode_hp(hpDO.getNo_hp());
					enhosDTO.setCode_hpkind(hpDO.getCode_hpkind());
					enhosDTO.setCode_hppatca(hpDO.getCode_hppatca());
					enhosDTO.setCode_hparea(hpDO.getCode_hparea());
					enhosDTO.setHpcode(hpDO.getCode_hp());
					enhosDTO.setFg_fundpay(hpDO.getFg_fundpay());
					enhosDTO.setFg_hpspcl(hpDO.getFg_hpspcl());
					enhosDTO.setFg_hp_card(hpDO.getFg_hp_card());
				} else {
					enhosDTO.setAuxi_cplan(hpDO.getId_hp());
					enhosDTO.setAuxi_name(hpDO.getName_hp());
					enhosDTO.setId_enthp_auxi(hpDO.getId_enthp());
				}
			}
		}
	}
	/**
	 * 查询患者医保数据
	 * 
	 * @param enhosDTO
	 * @return
	 * @throws BizException
	 */
	private EnHosRegDTO getHPValue(EnHosRegDTO enhosDTO, PatiAggDO patAgg) throws BizException {
		this.setHpValue(enhosDTO);
		if (enhosDTO.getId_pat() != null) {// 查询患者医保号
			PiPatHpDO[] pipatHpDOs = GetHpCode(patAgg);
			if (!EnValidator.isEmpty(pipatHpDOs)) {
				for (PiPatHpDO pipatHpDo : pipatHpDOs) {
					if (!EnValidator.isEmpty(pipatHpDo.getId_hp()) && pipatHpDo.getId_hp().equals(enhosDTO.getPrim_cplan())) {
						enhosDTO.setCode_hp(pipatHpDo.getNo_hp());
					}
					if (!EnValidator.isEmpty(pipatHpDo.getId_hp()) && pipatHpDo.getId_hp().equals(enhosDTO.getAuxi_cplan())) {
						enhosDTO.setCode_hp2(pipatHpDo.getNo_hp());
					}
				}
			}
		}
		return enhosDTO;
	}

	/**
	 * 查询部门的名称
	 * 
	 * @param enhosDTO
	 * @return
	 * @throws BizException
	 */
	private EnHosRegDTO getDepName(EnHosRegDTO enhosDTO) throws BizException {
		String depId = enhosDTO.getId_dep_phyadm();
		String nurId = enhosDTO.getId_dep_nuradm();
		IDeptRService service = ServiceFinder.find(IDeptRService.class);
		if (EnValidator.isEmpty(depId) && EnValidator.isEmpty(nurId)) {// 如果两个参数都是空，就返回
			return enhosDTO;
		}
		List<String> list = new ArrayList<String>();
		if (!EnValidator.isEmpty(depId)) {
			list.add(depId);
		}
		if (!EnValidator.isEmpty(nurId)) {
			list.add(nurId);
		}

		DeptDO[] depts = service.findByIds(list.toArray(new String[] {}), FBoolean.FALSE);
		if (!EnValidator.isEmpty(depts)) {
			for (DeptDO deptdo : depts) {
				if (deptdo.getId_dep().equals(depId)) {
					enhosDTO.setPhy_name(deptdo.getName());
					enhosDTO.setCode_dep_phyadm(deptdo.getCode());
				}
				if (deptdo.getId_dep().equals(nurId)) {
					enhosDTO.setNur_name(deptdo.getName());
					enhosDTO.setCode_dep_nuradm(deptdo.getCode());
				}
			}
		}
		return enhosDTO;
	}

	/**
	 * 设置患者分类，价格分类，信用分类
	 * 
	 * @param enhosDTO
	 * @throws BizException
	 */
	private void setPatCate(EnHosRegDTO enhosDTO) throws BizException {
		PiPatCaDO patca = new PatEP().getPatDefaultCate();
		if(patca != null){
			enhosDTO.setId_paticate(patca.getId_patca());
			enhosDTO.setName_paticate(patca.getName());
			enhosDTO.setId_pripat(patca.getId_patpritp());
			enhosDTO.setPri_name(patca.getPatpritp_name());
			enhosDTO.setId_patcret(patca.getId_patcrettp());
			enhosDTO.setPat_name(patca.getPatcrettp_name());
		}
	}

	/**
	 * 查询患者医保号
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private PiPatHpDO[] GetHpCode(PatiAggDO patAgg) throws BizException {
		PiPatHpDO[] piPatHpDOs = patAgg.getPiPatHpDO();
		return piPatHpDOs;
	}

	/**
	 * 查找联系人信息
	 * 
	 * @param patiAgg
	 * @param enhosregDTO
	 * @throws BizException
	 */
	private void getPatContInfo(PatiAggDO patiAgg, EnHosRegDTO enhosregDTO) throws BizException {
		EntContDO[] entConts =null;
		EntContEP entContEP = new EntContEP();
		if(enhosregDTO.getFg_bb() !=null && enhosregDTO.getFg_bb().booleanValue()){
			entConts = entContEP.getEntConts(enhosregDTO.getId_ent(), EuEntContTp.MOTHER.intValue(), null);		
		}else{
			entConts = entContEP.getEntConts(enhosregDTO.getId_ent(), EuEntContTp.CONTACT.intValue(), null);		
		}
		if (EnValidator.isEmpty(entConts)) {
			return;
		}

		EntContDO entCont = entConts[0];
		PiPatContDO[] patConts = patiAgg.getPiPatContDO();
		if (patConts == null || patConts.length == 0) {
			return;
		}
		PiPatContDO pipatCont = null;
		if (EnValidator.isEmpty(entCont.getId_patcontid())) {
			pipatCont = new PiPatContDO();
		} else {
			for (PiPatContDO cont : patConts) {
				if (!EnValidator.isEmpty(entCont.getId_patcontid()) && entCont.getId_patcontid().equals(cont.getId_patcont())) {
					pipatCont = cont;
				}
			}
		}
		if (pipatCont == null)
			return;
		this.setContValue(pipatCont, enhosregDTO);
	}

	/**
	 * 设置联系人信息
	 * 
	 * @param patContDO
	 * @param enhosRegDTO
	 */
	private void setContValue(PiPatContDO patContDO, EnHosRegDTO enhosRegDTO) {
		enhosRegDTO.setId_patcont(patContDO.getId_patcont());
		enhosRegDTO.setId_conttp(patContDO.getId_conttp());
		enhosRegDTO.setSd_conttp(patContDO.getSd_conttp());
		enhosRegDTO.setName_conttp(patContDO.getConttp_name());
		enhosRegDTO.setCont_name(patContDO.getName());
		enhosRegDTO.setConttel(patContDO.getConttel());
		enhosRegDTO.setContaddr(patContDO.getContaddr());
		enhosRegDTO.setName_patcontref(patContDO.getName());
	}
	
	/**
	 * 判定是否有通知单
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private Boolean IsHasIpnt(String entId) throws BizException{
		IAptipMDORService IaptIpRService = ServiceFinder.find(IAptipMDORService.class);
		AptIpDO[] aptIpDOs = IaptIpRService.find(AptIpDODesc.TABLE_ALIAS_NAME +".id_entIp ='"+entId +"' and fg_canc = 'N' ", "", FBoolean.FALSE);
		if(EnValidator.isEmpty(aptIpDOs))
			return false;
		return true;
	   	
	}
	
	
}
