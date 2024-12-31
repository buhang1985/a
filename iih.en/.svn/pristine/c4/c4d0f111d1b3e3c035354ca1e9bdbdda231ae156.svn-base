package iih.en.ip.s.qry;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.ep.EntContEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.PatEP;
import iih.en.comm.validator.EnValidator;
import iih.en.ip.dto.d.EnHosRegInfoDTO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpRService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.desc.InpatientDODesc;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.EntContDO;
import iih.en.pv.pativisit.d.EuEntContTp;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.d.desc.PatiAddrDODesc;
import iih.pi.reg.pat.i.IPatiAddrDORService;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pat.i.IPatiRService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.d.desc.UdidocDODesc;
import xap.sys.xbd.udi.i.IUdidocRService;

public class GetEnHosRegInfoBP2 {

	/**
	 * 获取入院登记信息(2.0）
	 * 
	 * @author tang.ht
	 *
	 */
		public EnHosRegInfoDTO exec(String patId) throws BizException {
			return getEnHosInfo(patId);	

		}
		
		private EnHosRegInfoDTO getEnHosInfo(String patId) throws BizException{
			if (EnValidator.isEmpty(patId)) {
				throw new BizException("患者信息id为空");
			}
			//0.获取患者就诊信息
			EnHosRegInfoDTO[] results = this.getInpatientData(patId);
			IPatiMDORService patRService = ServiceFinder.find(IPatiMDORService.class);
			PatiVisitDO entInfo = this.getEntInfo(patId);
			PatDO patDO = patRService.findById(patId);		
			EnHosRegInfoDTO enHos = results[0];
			// 1.根据就诊信息设置婚姻状况
			this.getMarryInfo4PatDTO(entInfo,enHos);
			// 2.根据就诊信息设置行政区划
			//this.getAddrInfo4PatDTO(entInfo, enHos);
			// 3.根据患者信息设置婚姻状况
			this.getPatMarryInfo4PatDTO(patDO, enHos);
			// 4.根据患者信息设置用户地址
			this.getPatAddrInfo4PatDTO(patId, enHos);
			// 5.设置患者基本信息
			this.getPatBasicInfo(patDO, enHos);
			if(entInfo !=null&&entInfo.getId_ent()!=null){
			// 6.设置患者的住院信息
			String entId = entInfo.getId_ent();
			this.getInpatientInfo(entId, enHos);
			}
			return enHos;
		}
		/**
		 * 查找en_ent中是否有保存的地址
		 * 
		 * @param patId
		 * @return
		 * @throws DAException
		 */
		private PatiVisitDO getEntInfo(String patId) throws DAException {
			PatiVisitDO entDO = null;
			StringBuilder sqlSb = new StringBuilder();
			sqlSb.append(" select ent.id_ent,");
			sqlSb.append(" ent.id_admdiv_addr,");
			sqlSb.append(" ent.sd_admdiv_addr,");
			sqlSb.append(" ent.addr_pat,");
			sqlSb.append(" ent.id_mari_pat");
			sqlSb.append(" from en_ent ent");
			sqlSb.append(" inner join en_ent_ip ip");
			sqlSb.append("  on ent.id_ent = ip.id_ent");
			sqlSb.append(" where ent.id_pat = ?");
			sqlSb.append("  and ip.sd_status in ('" + IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN + "','" 
																								
					+ IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN + "')");
			SqlParam param = new SqlParam();
			param.addParam(patId);
			@SuppressWarnings("unchecked")
			List<PatiVisitDO> list = (List<PatiVisitDO>) new DAFacade().execQuery(sqlSb.toString(), param, new BeanListHandler(PatiVisitDO.class));

			if (!EnValidator.isEmpty(list)) {
				entDO = list.get(0);
			}
			return entDO;
		}
		/**
		 * 将婚姻信息设置到enHosRegInfoDTO
		 * 
		 * @param entDO
		 * @param enHosRegInfoDTO
		 * @throws BizException
		 * 
		 */
		private void getMarryInfo4PatDTO(PatiVisitDO entDO, EnHosRegInfoDTO enHosRegInfoDTO) throws BizException {
			if (entDO == null) {
				return;
			}
			// 如果婚姻id都是空就不查了
			if (EnValidator.isEmpty(entDO.getId_mari_pat())) {
				return;
			}
			enHosRegInfoDTO.setName_marry(entDO.getId_mari_pat());
			enHosRegInfoDTO.setId_marry(entDO.getName_mari());
		}
		
		/**
		 * 根据就诊信息设置行政区划
		 * 
		 * @param entDO
		 * @param enhosPatDTO
		 * @throws BizException
		 * 
		 */
		private void getAddrInfo4PatDTO(PatiVisitDO entDO, EnHosRegInfoDTO enHosRegInfoDTO) throws BizException {
			if (entDO == null) {
				return;
			}
			if (EnValidator.isEmpty(entDO.getId_admdiv_addr())) {
				return;
			}
			// 如果行政区划的id不为空
			enHosRegInfoDTO.setName_admdiv_now(entDO.getAddr_pat());
			enHosRegInfoDTO.setId_admdiv_now(entDO.getId_admdiv_addr());
			enHosRegInfoDTO.setSd_admdiv_now(entDO.getSd_admdiv_addr());
			enHosRegInfoDTO.setStreet_now(entDO.getAddr_pat());
		}
		
		/**
		 * 根据患者信息设置婚姻状况
		 * 
		 * @param patdo
		 * @param enHosRegInfoDTO
		 * @throws BizException
		 */
		private void getPatMarryInfo4PatDTO(PatDO patdo, EnHosRegInfoDTO enHosRegInfoDTO) throws BizException {
			if (!EnValidator.isEmpty(enHosRegInfoDTO.getName_marry())) {
				return;
			}
			if (EnValidator.isEmpty(patdo.getId_marry())) {
				return;
			}
			enHosRegInfoDTO.setName_marry(patdo.getMarry_name());
			enHosRegInfoDTO.setId_marry(patdo.getId_marry());
		}
		
		/**
		 * 查找用户地址相关信息
		 * 
		 * @param patId
		 * @param enHosRegInfoDTO
		 * @throws BizException
		 */
		private void getPatAddrInfo4PatDTO(String patId, EnHosRegInfoDTO enHosRegInfoDTO) throws BizException {
			IPatiAddrDORService addRService = ServiceFinder.find(IPatiAddrDORService.class);
			PatiAddrDO[] patAddrDOArr = addRService.find(PatiAddrDODesc.TABLE_ALIAS_NAME + ".id_pat ='" + patId + "'", "", FBoolean.FALSE);
			if (EnValidator.isEmpty(patAddrDOArr)) {
				return;
			}
			for (PatiAddrDO addrPatDO : patAddrDOArr) {
				// 现住址
				if (!EnValidator.isEmpty(addrPatDO.getId_addrtp()) && addrPatDO.getId_addrtp().equals(IPiDictCodeConst.ID_ADDR_TYPE_NOW) && EnValidator.isEmpty(enHosRegInfoDTO.getName_admdiv_now())) {
					enHosRegInfoDTO.setName_admdiv_now(addrPatDO.getAdmdiv_name());
					enHosRegInfoDTO.setId_admdiv_now(addrPatDO.getId_admdiv());
					enHosRegInfoDTO.setSd_admdiv_now(addrPatDO.getSd_admdiv());
					enHosRegInfoDTO.setStreet_now(addrPatDO.getStreet());
					enHosRegInfoDTO.setTel_now(addrPatDO.getTel());
					enHosRegInfoDTO.setZip_now(addrPatDO.getZip());
				}
				// 户籍地址
				if (!EnValidator.isEmpty(addrPatDO.getId_addrtp()) && addrPatDO.getId_addrtp().equals(IPiDictCodeConst.ID_ADDR_TYPE_CENCUS)) {
					enHosRegInfoDTO.setId_admdiv_resi(addrPatDO.getId_admdiv());
					enHosRegInfoDTO.setSd_admdiv_resi(addrPatDO.getSd_admdiv());
					enHosRegInfoDTO.setName_admdiv_resi(addrPatDO.getAdmdiv_name());
					enHosRegInfoDTO.setStreet_resi(addrPatDO.getStreet());
					enHosRegInfoDTO.setZip_resi(addrPatDO.getZip());
				}
				// 工作地址
				if (!EnValidator.isEmpty(addrPatDO.getId_addrtp()) && addrPatDO.getId_addrtp().equals(IPiDictCodeConst.ID_ADDR_TYPE_WORK)) {
					enHosRegInfoDTO.setId_admdiv_work(addrPatDO.getId_admdiv());
					enHosRegInfoDTO.setSd_admdiv_work(addrPatDO.getSd_admdiv());
					enHosRegInfoDTO.setName_admdiv_work(addrPatDO.getAdmdiv_name());
					enHosRegInfoDTO.setStreet_work(addrPatDO.getStreet());
					enHosRegInfoDTO.setZip_work(addrPatDO.getZip());
					enHosRegInfoDTO.setTel_work(addrPatDO.getTel());
				}
				// 籍贯地址
				if (!EnValidator.isEmpty(addrPatDO.getId_addrtp()) && addrPatDO.getId_addrtp().equals(IPiDictCodeConst.ID_ADDR_TYPE_ORIGIN)) {
					enHosRegInfoDTO.setId_nativeaddr(addrPatDO.getId_admdiv());
					enHosRegInfoDTO.setName_nativeaddr(addrPatDO.getAdmdiv_name());
					enHosRegInfoDTO.setCode_nativeaddr(addrPatDO.getSd_admdiv());
				}
				//出生地
	            if (!EnValidator.isEmpty(addrPatDO.getId_addrtp()) && addrPatDO.getId_addrtp().equals(IPiDictCodeConst.ID_ADDR_TYPE_BORN))
	            {
	            	enHosRegInfoDTO.setId_admdiv_birth(addrPatDO.getId_admdiv());
	            	enHosRegInfoDTO.setName_admdiv_birth(addrPatDO.getAdmdiv_fullname());
	            	enHosRegInfoDTO.setSd_admdiv_birth(addrPatDO.getSd_admdiv());
	            }
			}
		}
		
		/**
		 * 设置患者的基本信息值
		 * 
		 * @param patdo
		 * @param enHosRegInfoDTO
		 * @throws BizException
		 */
		private void getPatBasicInfo(PatDO patdo, EnHosRegInfoDTO enHosRegInfoDTO) throws BizException {
			enHosRegInfoDTO.setId_pat(patdo.getId_pat());
			enHosRegInfoDTO.setCode_pat(patdo.getCode());
			enHosRegInfoDTO.setName_pat(patdo.getName());
			enHosRegInfoDTO.setCode_amr_ip(patdo.getCode_amr_ip());

			enHosRegInfoDTO.setId_sex(patdo.getId_sex());// 性别
			enHosRegInfoDTO.setSd_sex(patdo.getSd_sex());
			enHosRegInfoDTO.setName_sex(patdo.getName_sex());

			enHosRegInfoDTO.setId_idtp(patdo.getId_idtp());// 证件类型
			enHosRegInfoDTO.setSd_idtp(patdo.getSd_idtp());
			enHosRegInfoDTO.setName_idtp(patdo.getIdtp_name());
			enHosRegInfoDTO.setId_code(patdo.getId_code());// 证件号码

			enHosRegInfoDTO.setDt_birth(patdo.getDt_birth());
			enHosRegInfoDTO.setId_marry(patdo.getId_marry());
			enHosRegInfoDTO.setSd_marry(patdo.getSd_marry());
			enHosRegInfoDTO.setName_marry(patdo.getMarry_name());
			enHosRegInfoDTO.setDt_birth_hms(patdo.getDt_birth_hms());
			enHosRegInfoDTO.setTel(patdo.getTel());// 电话
			enHosRegInfoDTO.setMob(patdo.getMob());// 移动电话

			enHosRegInfoDTO.setId_nation(patdo.getId_nation()); // 民族
			enHosRegInfoDTO.setName_nation(patdo.getNation_name());

			enHosRegInfoDTO.setId_country(patdo.getId_country());// 国籍
			enHosRegInfoDTO.setName_country(patdo.getCountry_name());

			
			enHosRegInfoDTO.setId_occu(patdo.getId_occu());
			enHosRegInfoDTO.setSd_occu(patdo.getSd_occu());
			enHosRegInfoDTO.setName_occu(patdo.getOccu_name());
			enHosRegInfoDTO.setWorkunit(patdo.getWorkunit());
			enHosRegInfoDTO.setAge(AgeCalcUtil.getAge(patdo.getDt_birth()));
		}
		
		/**
		 * 住院信息
		 * 
		 * @param enHosRegInfoDTO
		 * @param entId
		 * @throws BizException
		 */
		private void getInpatientInfo(String entId, EnHosRegInfoDTO enHosRegInfoDTO) throws BizException {
			IInpatientRService rService = ServiceFinder.find(IInpatientRService.class);
			InpatientDO[] inpatientDOs = rService.find(String.format(InpatientDODesc.TABLE_ALIAS_NAME + ".id_ent='%s'",entId), null, FBoolean.FALSE);
			if (EnValidator.isEmpty(inpatientDOs)) {
				return;
			}
			enHosRegInfoDTO.setSd_pay_mothod(inpatientDOs[0].getSd_pay_mothod());
			enHosRegInfoDTO.setFg_vip(inpatientDOs[0].getFg_vip());
			enHosRegInfoDTO.setFg_mobapp(inpatientDOs[0].getFg_mobapp());
			enHosRegInfoDTO.setTelno_mobapp(inpatientDOs[0].getTelno_mobapp());//手机app
			enHosRegInfoDTO.setFg_pe(inpatientDOs[0].getFg_pe());
			enHosRegInfoDTO.setSd_pe_psntp(inpatientDOs[0].getSd_pe_psntp());
			enHosRegInfoDTO.setName_pe_intr(inpatientDOs[0].getName_pe_intr());
			IUdidocRService uService = ServiceFinder.find(IUdidocRService.class);
			//付款方式
			UdidocDO[] payMethods = uService.find(String.format(UdidocDODesc.TABLE_ALIAS_NAME + ".id_udidoclist='%s' and " + UdidocDODesc.TABLE_ALIAS_NAME
					+ ".code='%s'", "@@@@TL400000000000QF", inpatientDOs[0].getSd_pay_mothod()), null, FBoolean.FALSE);
			//体检身份类型
			UdidocDO[] pePsnTps = uService.find(String.format(UdidocDODesc.TABLE_ALIAS_NAME + ".id_udidoclist='%s' and " + UdidocDODesc.TABLE_ALIAS_NAME
					+ ".code='%s'", "@@@@ZZ2000000000005L", inpatientDOs[0].getSd_pe_psntp()), null, FBoolean.FALSE);
			if (!EnValidator.isEmpty(payMethods) && payMethods.length > 0) {
				enHosRegInfoDTO.setName_pay_mothod(payMethods[0].getName());
				enHosRegInfoDTO.setId_pay_mothod(payMethods[0].getId_udidoc());
			}
			if (!EnValidator.isEmpty(pePsnTps) && pePsnTps.length > 0) {
				enHosRegInfoDTO.setName_pe_psntp(pePsnTps[0].getName());
				enHosRegInfoDTO.setId_pe_psntp(pePsnTps[0].getId_udidoc());
			}
		}

		
		/**
		 * 查询sql
		 * 
		 * @param idPat
		 * @return
		 * @throws BizException
		 */
		private EnHosRegInfoDTO[] getInpatientData(String idPat) throws BizException {
			StringBuffer sqlSb = new StringBuffer();

			sqlSb.append(" Select ent.id_ent,ent.fg_ip,");
			sqlSb.append(" ent.code_entp,");
			sqlSb.append(" ent.id_entp,");
			sqlSb.append(" ent.dt_entry, ");//入院时间
			sqlSb.append(" ent.id_patca,");//患者分类
			sqlSb.append(" patca.code as code_patca,");
			sqlSb.append(" patca.name as name_patca,");
			sqlSb.append(" ent.id_pripat,");//价格分类
			sqlSb.append(" pripat.name as name_pripat, ");
			sqlSb.append(" ent.id_patcret ,");//信用分类
			sqlSb.append(" patcret.name as name_patcret, ");
			sqlSb.append(" ent.id_pat,");
			sqlSb.append(" ent.code code_ent,");
			sqlSb.append(" ip.id_level_diseadm,");//病情等级
			sqlSb.append(" ip.sd_level_diseadm as code_level_diseadm,");
			sqlSb.append(" ip.id_referalsrc,");//入院方式
			sqlSb.append(" ip.Sd_referalsrc as Code_referalsrc,");
			sqlSb.append(" ent.id_dep_phy as id_dep_phyadm,");
			sqlSb.append(" ip.times_ip ,");
			sqlSb.append(" ent.id_dep_nur as id_dep_nuradm,");
			sqlSb.append(" ip.id_bed,");
			sqlSb.append(" bed.code as code_bed, ");
			sqlSb.append(" ip.name_bed,");
			sqlSb.append(" ip.Id_diag_op,");
			sqlSb.append(" ip.Desc_diag_op,");
			sqlSb.append(" ip.fg_vip,");
			sqlSb.append(" def.name as name_diag,");
			sqlSb.append(" def.code as code_diag,");
			sqlSb.append(" udidoc.name as Name_referalsrc,");
			sqlSb.append(" udidoc2.name as name_level_diseadm,");
			sqlSb.append(" case ip.sd_status");
			sqlSb.append("  when '25' then '在院'");
			sqlSb.append("  when '22' then '登记'");
			sqlSb.append("  end as code_status,");
			sqlSb.append(" bed.sd_bedsexlimit   code_bedsex,");
			sqlSb.append(" opemp.name name_emp_opapply,");
			sqlSb.append(" opemp.code code_emp_opapply,");
			sqlSb.append(" ip.id_emp_opapply ,");
			sqlSb.append(" ent.id_cust_cmpy,");
			sqlSb.append(" cust.name name_cust_cmpy,");
			sqlSb.append(" apt.amt_deposit,");
			sqlSb.append(" apt.id_bed id_bed_sc ");
			sqlSb.append(" from en_ent ent");
			sqlSb.append(" inner join en_ent_ip ip on ent.id_ent = ip.id_ent ");
			sqlSb.append(" left join pi_pat pat on ent.id_pat = pat.id_pat ");
			sqlSb.append(" left join bd_bed bed on ip.id_bed = bed.id_bed ");
			sqlSb.append(" left join bd_psndoc emp on ent.id_emp_phy = emp.id_psndoc ");
			sqlSb.append(" left outer join pi_pat_ca patca on ent.id_patca = patca.id_patca ");
			sqlSb.append(" left outer join bd_pri_pat pripat on ent.id_pripat = pripat.Id_pripat ");
			sqlSb.append(" left outer join pi_pat_cret patcret on ent.id_patcret = patcret.Id_patcret ");
			sqlSb.append(" left join bd_udidoc udidoc on ip.id_referalsrc = udidoc.id_udidoc ");
			sqlSb.append(" left join bd_udidoc udidoc2 on ip.id_level_diseadm = udidoc2.id_udidoc ");
			sqlSb.append(" left join bd_di_def def on def.id_didef = ip.Id_diag_op ");
			sqlSb.append(" left join bd_hp_med_kind_ah hmk on ent.code_hpmedkind = hmk.code and ent.id_hp = hmk.id_hp ");
			sqlSb.append(" left join bd_bed bed");
			sqlSb.append(" 	 on bed.id_bed = ip.id_bed");
			sqlSb.append(" left join bd_psndoc opemp on ip.id_emp_opapply = opemp.id_psndoc");
			sqlSb.append(" left join bd_cust cust on ent.id_cust_cmpy = cust.id_cust");
			sqlSb.append(" left join sc_apt_ip apt on apt.id_entip = ent.id_ent");
			sqlSb.append("  where ent.id_pat = ?");
			sqlSb.append("  and ip.sd_status in ('" + IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN + "','" // del																									
					+ IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN + "')");
			SqlParam param = new SqlParam();
			param.addParam(idPat);
			@SuppressWarnings("unchecked")
			List<EnHosRegInfoDTO> list = (List<EnHosRegInfoDTO>) new DAFacade().execQuery(sqlSb.toString(), param, new BeanListHandler(EnHosRegInfoDTO.class));
			PatiAggDO patAgg = this.getPatAggDO(idPat);
			if (EnValidator.isEmpty(list)) {
				EnHosRegInfoDTO enHosRegInfoDTO = new EnHosRegInfoDTO();
				enHosRegInfoDTO.setId_pat(idPat);
				this.setPatCate(enHosRegInfoDTO);
				this.getIpTimes(enHosRegInfoDTO.getId_pat());
				enHosRegInfoDTO.setStatus(DOStatus.NEW);
				//设置患者就诊标签
				//QryPatHpTagtpBP tagtp = new QryPatHpTagtpBP();
				//tagtp.exec(enhosDTO);
				//return new EnHosRegDTO[]{enhosDTO};
				return new EnHosRegInfoDTO[]{enHosRegInfoDTO};
			}
			for(EnHosRegInfoDTO enHosRegInfoDTO: list){
				this.getHPValue(enHosRegInfoDTO, patAgg);
				this.getDepName(enHosRegInfoDTO);
				this.getPatContInfo(patAgg, enHosRegInfoDTO);
				//		this.getPatCate(enhosDTO, patAgg);		
				//if(this.IsHasIpnt(enhosDTO.getId_ent())){
				//	enhosDTO.setFg_aptip(FBoolean.TRUE);
				//}
				//设置患者就诊标签
				//QryPatHpTagtpBP tagtp = new QryPatHpTagtpBP();
				//tagtp.exec(enhosDTO);
			}
			return list.toArray(new EnHosRegInfoDTO[0]);
		}
		
		/**
		 * 设置患者分类，价格分类，信用分类
		 * 
		 * @param enhosDTO
		 * @throws BizException
		 */
		private void setPatCate(EnHosRegInfoDTO enHosRegInfoDTO) throws BizException {
			PiPatCaDO patca = new PatEP().getPatDefaultCate();
			if(patca != null){
				enHosRegInfoDTO.setId_patca(patca.getId_patca());
				enHosRegInfoDTO.setName_patca(patca.getName());
				enHosRegInfoDTO.setId_pripat(patca.getId_patpritp());
				enHosRegInfoDTO.setName_pripat(patca.getPatpritp_name());
				enHosRegInfoDTO.setId_patcret(patca.getId_patcrettp());
				enHosRegInfoDTO.setName_patcret(patca.getPatcrettp_name());
			}
		}
		
		/**
		 * 设置入院次数
		 * 
		 * @param patId
		 * @return
		 * @throws BizException
		 */
		private void getIpTimes(String patId) throws BizException {
			IpEP ipEP = new IpEP();
			 ipEP.setIpTimes(patId);
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
		 * 查询患者医保数据
		 * 
		 * @param enhosDTO
		 * @return
		 * @throws BizException
		 */
		private EnHosRegInfoDTO getHPValue(EnHosRegInfoDTO enHosRegInfoDTO, PatiAggDO patAgg) throws BizException {
			this.setHpValue(enHosRegInfoDTO);
			if (enHosRegInfoDTO.getId_pat() != null) {// 查询患者医保号
				PiPatHpDO[] pipatHpDOs = GetHpCode(patAgg);
				if (!EnValidator.isEmpty(pipatHpDOs)) {
					for (PiPatHpDO pipatHpDo : pipatHpDOs) {
						if (!EnValidator.isEmpty(pipatHpDo.getId_hp()) && pipatHpDo.getId_hp().equals(enHosRegInfoDTO.getId_hp_auxi())) {
							enHosRegInfoDTO.setNo_hp(pipatHpDo.getNo_hp());
						}
						if (!EnValidator.isEmpty(pipatHpDo.getId_hp()) && pipatHpDo.getId_hp().equals(enHosRegInfoDTO.getNo_hp_auxi())) {
							enHosRegInfoDTO.setNo_hp_auxi(pipatHpDo.getNo_hp());
						}
					}
				}
			}
			return enHosRegInfoDTO;
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
		 * 查询部门的名称
		 * 
		 * @param enhosDTO
		 * @return
		 * @throws BizException
		 */
		private EnHosRegInfoDTO getDepName(EnHosRegInfoDTO enHosRegInfoDTO) throws BizException {
			String depId = enHosRegInfoDTO.getId_dep_phyadm();
			String nurId = enHosRegInfoDTO.getId_dep_nuradm();
			IDeptRService service = ServiceFinder.find(IDeptRService.class);
			if (EnValidator.isEmpty(depId) && EnValidator.isEmpty(nurId)) {// 如果两个参数都是空，就返回
				return enHosRegInfoDTO;
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
						enHosRegInfoDTO.setName_dep_phyadm(deptdo.getName());
						enHosRegInfoDTO.setCode_dep_phyadm(deptdo.getCode());
					}
					if (deptdo.getId_dep().equals(nurId)) {
						enHosRegInfoDTO.setName_dep_nuradm(deptdo.getName());
						enHosRegInfoDTO.setCode_dep_nuradm(deptdo.getCode());
					}
				}
			}
			return enHosRegInfoDTO;
		}
		
		/**
		 * 查找联系人信息
		 * 
		 * @param patiAgg
		 * @param enHosRegInfoDTO
		 * @throws BizException
		 */
		private void getPatContInfo(PatiAggDO patiAgg, EnHosRegInfoDTO enHosRegInfoDTO) throws BizException {
			EntContDO[] entConts =null;
			EntContEP entContEP = new EntContEP();
			entConts = entContEP.getEntConts(enHosRegInfoDTO.getId_ent(), EuEntContTp.CONTACT.intValue(), null);
			if (EnValidator.isEmpty(entConts)) {
				return;
			}
			EntContDO entCont = entConts[0];
			
			enHosRegInfoDTO.setId_patcont(entCont.getId_entcont());
			enHosRegInfoDTO.setId_conttp(entCont.getId_conttp());
			enHosRegInfoDTO.setSd_conttp(entCont.getSd_conttp());
			enHosRegInfoDTO.setName_conttp(entCont.getName_conttp());
			enHosRegInfoDTO.setConttel(entCont.getConttel());
			enHosRegInfoDTO.setContaddr(entCont.getContaddr());
			enHosRegInfoDTO.setName_cont(entCont.getName());
		}
		
		
		
		
		private void setHpValue(EnHosRegInfoDTO enHosRegInfoDTO) throws BizException {
			String entID = enHosRegInfoDTO.getId_ent();
			IEnthpRService rservice = ServiceFinder.find(IEnthpRService.class);
			EntHpDO[] entHpDOArr = rservice.findByAttrValString(EntHpDO.ID_ENT, entID);
			if(EnValidator.isEmpty(entHpDOArr))
				return;
			for (EntHpDO hpDO : entHpDOArr) { // 查询就诊医保
				if (hpDO.getFg_maj().booleanValue()) {
					if (FBoolean.TRUE.equals(hpDO.getFg_maj())) {
						enHosRegInfoDTO.setId_hp(hpDO.getId_hp());
						enHosRegInfoDTO.setName_hp(hpDO.getName_hp());
						enHosRegInfoDTO.setId_hp(hpDO.getId_enthp());
						enHosRegInfoDTO.setNo_hp(hpDO.getNo_hp());
						enHosRegInfoDTO.setCode_hpkind(hpDO.getCode_hpkind());
						enHosRegInfoDTO.setCode_hppatca(hpDO.getCode_hppatca());
						enHosRegInfoDTO.setCode_hparea(hpDO.getCode_hparea());
					} else {
						enHosRegInfoDTO.setId_hp_auxi(hpDO.getId_hp());
						enHosRegInfoDTO.setName_hp_auxi(hpDO.getName_hp());
						enHosRegInfoDTO.setId_hp_auxi(hpDO.getId_enthp());
					}
				}
			}
		}
}
