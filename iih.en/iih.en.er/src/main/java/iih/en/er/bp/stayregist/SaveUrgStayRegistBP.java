package iih.en.er.bp.stayregist;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.EnAccEP;
import iih.en.comm.ep.EntContEP;
import iih.en.comm.ep.EntHpEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.ep.UdiDocEP;
import iih.en.comm.evt.EnEvtHandle;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnCodeUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnVisitTimesUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.UrgStayRegistryDTO;
import iih.en.er.ip.d.EnEntIpErDO;
import iih.en.er.ip.i.IEnentiperCudService;
import iih.en.er.pre.d.EnErPreDO;
import iih.en.er.pre.i.IEnerpreCudService;
import iih.en.pv.inpatient.d.EuInCp;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.s.bp.RegEventBP;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.aptip.i.IAptipMDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 保存急诊留观登记信息
 * 
 * @author liubin
 *
 */
public class SaveUrgStayRegistBP {
	/**
	 * 是否新登记
	 * 
	 */
	private boolean isNewRegist;
	/**
	 * 保存急诊留观登记信息
	 * 
	 * @param urgStayRegistry
	 * @return
	 * @throws BizException
	 */
	public UrgStayRegistryDTO exec(UrgStayRegistryDTO urgStayRegistry) throws BizException {
		//1.保存校验
		new ValidateSaveUrgStayRegistBP().exec(urgStayRegistry);
		
		isNewRegist = EnValidator.isEmpty(urgStayRegistry.getId_ent());
		//2.保存患者信息
		PatiAggDO agg = new SaveUrgStayRegistPatInfoBP().exec(urgStayRegistry);
		//3.保存就诊信息
		saveEntInfo(urgStayRegistry, agg);
		//4.保存急诊留观预检信息
		saveErInfo(urgStayRegistry);
		//5.修改留观许可状态
		updateScAptIp(urgStayRegistry);
		//6.记录入院事件
		new EnEvtHandle().insertIpRegistEvt(urgStayRegistry);
		//6.重新查询数据并返回
		urgStayRegistry = new GetUrgStayRegInfosBP().execByEntId(urgStayRegistry.getId_ent());
		//7.发送集成平台事件
		sendEvent(urgStayRegistry);
		
		return urgStayRegistry;
	}
	/**
	 * 保存就诊信息
	 * 
	 * @param urgStayRegistry
	 * @throws BizException
	 */
	private void saveEntInfo(UrgStayRegistryDTO urgStayRegistry, PatiAggDO agg) throws BizException{
		//1.保存EN_ENT
		saveEnt(urgStayRegistry);
		//2.保存EN_ENT_IP
		saveEnEntIp(urgStayRegistry);
		//3.保存en_ent_cont表
		saveEnEntCont(agg, urgStayRegistry);
		//4.保存EN_ENT_ACC
		saveEnAccount(urgStayRegistry);
		//5.保存en_ent_hp
		saveEnEntHp(urgStayRegistry);
	}
	/**
	 * 修改留观许可状态
	 * 
	 * @param urgStayRegistry
	 * @throws BizException
	 */
	private void saveErInfo(UrgStayRegistryDTO urgStayRegistry) throws BizException{
		if(!isNewRegist)
			return;
		//1.更新 en_erpre
		EnErPreDO erpre = updateEnErPre(urgStayRegistry);
		//2.新增en_ent_ip_er
		addIpEr(urgStayRegistry, erpre);
	}
	/**
	 * 修改留观许可状态
	 * 
	 * @param urgStayRegistry
	 * @throws BizException
	 */
	private void updateScAptIp(UrgStayRegistryDTO urgStayRegistry) throws BizException{
		if(!isNewRegist)
			return;
		AptIpDO aptdo = (AptIpDO)new DAFacade().findByPK(AptIpDO.class, urgStayRegistry.getId_aptip());
		if(aptdo == null )
			throw new BizException("未获取到该患者急诊留观申请单！");
		aptdo.setSd_status(IEnDictCodeConst.SD_STATUS_NOTICE_INHOS);
		aptdo.setId_entip(urgStayRegistry.getId_ent());
		aptdo.setStatus(DOStatus.UPDATED);
		IAptipMDOCudService serv=ServiceFinder.find(IAptipMDOCudService.class);
		serv.save(new AptIpDO[]{aptdo});
	}
	/**
	 * 3.保存en_ent表
	 * 
	 * @param urgStayRegistry
	 * @throws BizException 
	 */
	private PatiVisitDO saveEnt(UrgStayRegistryDTO urgStayRegistry) throws BizException {
		PvEP ep = new PvEP();
		PatiVisitDO patiVisitDO = null;
		if (isNewRegist) {
			patiVisitDO = new PatiVisitDO();
			patiVisitDO.setStatus(DOStatus.NEW);
			patiVisitDO.setId_org(EnContextUtils.getOrgId());
			patiVisitDO.setId_grp(EnContextUtils.getGrpId());
			patiVisitDO.setDt_insert(EnAppUtils.getServerDateTime());
			patiVisitDO.setFg_ip(FBoolean.FALSE); // 在院标志
			patiVisitDO.setFg_emgstay(FBoolean.TRUE);
			patiVisitDO.setFg_st(FBoolean.FALSE); // 结算标志
			patiVisitDO.setFg_flup(FBoolean.FALSE); // 随访标志
			patiVisitDO.setFg_canc(FBoolean.FALSE); // 退诊标志
			patiVisitDO.setFg_data_transf(FBoolean.FALSE);// 可转移标识
			patiVisitDO.setCode(EnCodeUtils.createEntCode());
			patiVisitDO.setId_entp(IBdFcDictCodeConst.ID_CODE_ENTP_ET_OBS); // 就诊类型ID
			patiVisitDO.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS); // 就诊类型
			patiVisitDO.setId_dep_phy(urgStayRegistry.getId_dep_phyadm()); // 当前就诊科室
			patiVisitDO.setId_dep_nur(urgStayRegistry.getId_dep_nuradm()); // 当前护理单位(病区)
			patiVisitDO.setFg_acptvalid(FBoolean.FALSE);
			patiVisitDO.setId_pat(urgStayRegistry.getId_pat());
			patiVisitDO.setId_emp_entry(EnContextUtils.getPsnId());
		} else {
			patiVisitDO = ep.getPvByPK(urgStayRegistry.getId_ent());
			patiVisitDO.setStatus(DOStatus.UPDATED);
			if(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN.equals(urgStayRegistry.getSd_status())){
				patiVisitDO.setId_dep_phy(urgStayRegistry.getId_dep_phyadm()); // 当前就诊科室
				patiVisitDO.setId_dep_nur(urgStayRegistry.getId_dep_nuradm()); // 当前护理单位(病区)
			}
		}
		patiVisitDO.setName_pat(urgStayRegistry.getName_pat());
		patiVisitDO.setTelno_pat(urgStayRegistry.getMob());
		patiVisitDO.setId_sex_pat(urgStayRegistry.getId_sex());
		patiVisitDO.setSd_sex_pat(urgStayRegistry.getSd_sex());
		patiVisitDO.setId_mari_pat(urgStayRegistry.getId_marry());
		patiVisitDO.setSd_mari_pat(urgStayRegistry.getSd_marry());
		patiVisitDO.setDt_birth_pat(urgStayRegistry.getDt_birth());
		patiVisitDO.setDt_entry(urgStayRegistry.getDt_entry()); // 就诊登记日期时间
		patiVisitDO.setId_hp(urgStayRegistry.getId_hp()); // 主医保计划
		patiVisitDO.setId_patca(urgStayRegistry.getId_patca()); // 患者分类
		patiVisitDO.setId_pripat(urgStayRegistry.getId_pripat()); // 价格分类
		patiVisitDO.setId_patcret(urgStayRegistry.getId_patcret()); // 信用分类
		patiVisitDO.setId_cust_cmpy(urgStayRegistry.getId_cust_cmpy());// 合同单位
		patiVisitDO.setCode_addr(urgStayRegistry.getCode_addr_now());
		patiVisitDO.setId_admdiv_addr(urgStayRegistry.getId_addr_now());
		patiVisitDO.setSd_admdiv_addr(urgStayRegistry.getCode_addr_now());
		patiVisitDO.setAddr_pat(urgStayRegistry.getStreet_addr_now());
		patiVisitDO.setCode_hpmedkind(urgStayRegistry.getCode_hpmedkind());
		patiVisitDO =  ep.savePv(patiVisitDO);
		urgStayRegistry.setId_ent(patiVisitDO.getId_ent());
		return patiVisitDO;
	}
	/**
	 * 保存EN_ENT_IP表(处理床位)
	 * 
	 * @param urgstayregistry
	 * @param id_ent 
	 * @throws BizException 
	 */
	private void saveEnEntIp(UrgStayRegistryDTO urgstayregistry) throws BizException {
		IpEP ep = new IpEP();
		InpatientDO inpatientDO = null;
		if(isNewRegist){
			inpatientDO = new InpatientDO();
			inpatientDO.setStatus(DOStatus.NEW);
			//住院号
			String sd_ip_spec = EnParamUtils.getErSdIptype();
			inpatientDO.setSd_ip_spec(sd_ip_spec);
			inpatientDO.setCode_amr_ip(urgstayregistry.getCode_amr_ip());
			inpatientDO.setTimes_ip(EnVisitTimesUtils.calcAdmObsTimes(urgstayregistry.getId_pat()));
			inpatientDO.setId_ent(urgstayregistry.getId_ent());
			inpatientDO.setSd_status(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN);//22-入院
			inpatientDO.setFg_newborn(FBoolean.FALSE); // 是否新生儿标志
			inpatientDO.setFg_blrecall(FBoolean.FALSE);
			inpatientDO.setFg_doc_commit(FBoolean.FALSE);
			inpatientDO.setFg_incp(FBoolean.FALSE);
			inpatientDO.setFg_mobapp(FBoolean.FALSE);
			inpatientDO.setFg_pe(FBoolean.FALSE);
			inpatientDO.setFg_surg(FBoolean.FALSE);
			inpatientDO.setNum_newborn(0);
			UdidocDO udidocDO = new UdiDocEP().getUdidocByCodeAndValue(IEnDictCodeTypeConst.SD_IP_TYPE, IEnDictCodeConst.SD_IPTYPE_CUSTOM);
			if (udidocDO != null) {
				inpatientDO.setId_ip_spec(udidocDO.getId_udidoc());
				inpatientDO.setSd_ip_spec(udidocDO.getCode());
			}
			inpatientDO.setId_referalsrc(IEnDictCodeConst.ID_REFERALSRC_EMERGENCY); // 来院方式ID
			inpatientDO.setSd_referalsrc(IEnDictCodeConst.SD_REFERALSRC_EMERGENCY); // 来院方式
		}else{
			inpatientDO = ep.getIpByEntId(urgstayregistry.getId_ent());
			inpatientDO.setStatus(DOStatus.UPDATED);
		}
		if(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN.equals(inpatientDO.getSd_status())){
			inpatientDO.setId_level_dise(urgstayregistry.getId_level_diseadm());
			inpatientDO.setSd_level_dise(urgstayregistry.getSd_level_diseadm());
			inpatientDO.setId_dep_phyadm(urgstayregistry.getId_dep_phyadm());
			inpatientDO.setId_dep_nuradm(urgstayregistry.getId_dep_nuradm());
			BedEP bedbp = new BedEP();
			if(isNewRegist){
				bedbp.occupyBed(urgstayregistry.getId_bed(), urgstayregistry.getId_aptip());
			}else{
				if(!inpatientDO.getId_bed().equals(urgstayregistry.getId_bed())){
					bedbp.releaseBedWithAppt(urgstayregistry.getId_ent(), inpatientDO.getId_bed());
					bedbp.occupyBed(urgstayregistry.getId_bed(), urgstayregistry.getId_aptip());
				}
			}
			inpatientDO.setId_bed(urgstayregistry.getId_bed()); // 选择的床位
			inpatientDO.setName_bed(urgstayregistry.getName_bed());
		}
		inpatientDO.setFg_surg(new FBoolean(false)); // 是否手术标志
		inpatientDO.setId_patcont(urgstayregistry.getId_patcont()); //联系人id
		inpatientDO.setCont_name(urgstayregistry.getName_patcont()); // 主要联系人姓名
		inpatientDO.setCont_tel(urgstayregistry.getConttel()); // 主要联系人电话 
		inpatientDO.setId_diag_op(urgstayregistry.getId_diag_op());
		inpatientDO.setDesc_diag_op(urgstayregistry.getDesc_diag_op());// 保存诊断
		inpatientDO.setId_level_diseadm(urgstayregistry.getId_level_diseadm());
		inpatientDO.setSd_level_diseadm(urgstayregistry.getSd_level_diseadm());
		inpatientDO.setId_emp_opapply(urgstayregistry.getId_emp_opapply());//入院医生
		inpatientDO.setEu_incp(EuInCp.NOCP);
		ep.save(inpatientDO);
	}
	/**
	 * 保存en_ent_cont表
	 * @param agg 
	 * 
	 * @param urgstayregistry
	 * @throws BizException 
	 */
	private void saveEnEntCont(PatiAggDO agg, UrgStayRegistryDTO urgStayRegistry) throws BizException {
		PiPatContDO[] conts = agg.getPiPatContDO();
		if(EnValidator.isEmpty(conts))
			return;
		PiPatContDO piPatCont = null;
		for(PiPatContDO cont : conts){
			if(FBoolean.TRUE.equals(cont.getFg_ieuse())){
				piPatCont = cont;
				break;
			}
		}
		if(piPatCont == null)
			return;
		EntContEP entContEP = new EntContEP();
		entContEP.SaveEntCont(piPatCont, urgStayRegistry.getId_ent());
	}
	/**
	 * 10.保存EN_ENT_ACC表
	 * 
	 * @param urgstayregistry
	 * @param id_ent 
	 * @throws BizException 
	 */
	private void saveEnAccount(UrgStayRegistryDTO urgStayRegistry) throws BizException {
		EnAccEP ep = new EnAccEP();
		ep.saveEnAccData(urgStayRegistry.getId_pat(), urgStayRegistry.getId_ent(), 
				urgStayRegistry.getDt_entry(), urgStayRegistry.getId_patcret());
	}
	/**
	 * 保存医保 en_ENT_HP表
	 * 
	 * @param urgstayregistry
	 * @throws BizException 
	 */
	private void saveEnEntHp(UrgStayRegistryDTO urgStayRegistry) throws BizException {
		// 删除已有
		EntHpEP entHpEP = new EntHpEP();
		entHpEP.deleteByEntId(urgStayRegistry.getId_ent());
		// 保存最新
		entHpEP.saveEntHp(urgStayRegistry);
	}
	/**
	 * 更新表 en_erpre
	 * 
	 * @param urgstayregistry
	 * @param id_ent 
	 * @throws BizException 
	 */
	private EnErPreDO updateEnErPre(UrgStayRegistryDTO urgStayRegistry) throws BizException {
		if(EnValidator.isEmpty(urgStayRegistry.getId_erpre())){
			return null;
		}
		EnErPreDO erpre = (EnErPreDO)new DAFacade().findByPK(EnErPreDO.class, urgStayRegistry.getId_erpre());
		if(erpre == null){
			throw new BizException("未获取到该患者急诊预检信息！");
		}
		erpre.setId_ent_ip(urgStayRegistry.getId_ent());
		erpre.setSd_status_ip(IEnDictCodeConst.SD_STATUS_ERPRE_VISIT);
		erpre.setStatus(DOStatus.UPDATED);
		IEnerpreCudService serv = ServiceFinder.find(IEnerpreCudService.class);
		serv.save(new EnErPreDO[]{erpre});
		return erpre;
	}
	/**
	 * 新增en_ent_ip_er
	 * 
	 * @param urgStayRegistry
	 * @param erpre
	 * @throws BizException
	 */
	private void addIpEr(UrgStayRegistryDTO urgStayRegistry, EnErPreDO erpre) throws BizException {
		EnEntIpErDO enEntIpErDO = new EnEntIpErDO();
		enEntIpErDO.setStatus(DOStatus.NEW);
		enEntIpErDO.setId_ent(urgStayRegistry.getId_ent());
		enEntIpErDO.setId_erpre(erpre.getId_erpre());
		enEntIpErDO.setId_ent_fst(erpre.getId_ent_fst());
		UdidocDO udidocDO = new UdiDocEP().getUdidocByCodeAndValue(IEnDictCodeTypeConst.SD_ERPRE_SCOLE, erpre.getSd_scale_hm());
		if(udidocDO != null){
			enEntIpErDO.setSd_scale_triage(udidocDO.getCode());
			enEntIpErDO.setId_scale_triage(udidocDO.getId_udidoc());
		}
		enEntIpErDO.setFg_nonperson(erpre.getFg_nonperson());
		IEnentiperCudService serv = ServiceFinder.find(IEnentiperCudService.class);
		serv.save(new EnEntIpErDO[]{enEntIpErDO});
	}
	/**
	 * 发送集成平台事件
	 * 
	 * @param urgstayregistry
	 */
	private void sendEvent(UrgStayRegistryDTO urgStayRegistry) {
		if (IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN.equals(urgStayRegistry.getSd_status())) {
			try {
				RegEventBP regBp = new RegEventBP();
				regBp.invokeStayRegEvent(urgStayRegistry, isNewRegist);
			} catch (Exception ex) {
				EnLogUtil.getInstance().logError("留观登记消息发送失败：", ex);
			}
			
		}
		
	}
}
