package iih.en.pv.s.bp.ip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.fc.ipspectp.d.BdEnIpSpecDO;
import iih.bd.fc.ipspectp.i.IIpspectpRService;
import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bizgrp.d.BizGroupDO;
import iih.bl.hp.hpentcode.d.HpEntCodeDO;
import iih.bl.hp.hpentcode.i.IHpentcodeCudService;
import iih.bl.hp.hpentcode.i.IHpentcodeRService;
import iih.bl.hp.hptransactahip.d.HpTransActAhIpDO;
import iih.bl.hp.hptransactahip.d.HptransactahipAggDO;
import iih.bl.hp.hptransactahip.i.IHptransactahipCudService;
import iih.bl.hp.hptransactahip.i.IHptransactahipRService;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.EnAccEP;
import iih.en.comm.ep.EnCodeAmrIpEP;
import iih.en.comm.ep.EnEvtEP;
import iih.en.comm.ep.EnPatTpEP;
import iih.en.comm.ep.EntContEP;
import iih.en.comm.ep.EntHpEP;
import iih.en.comm.ep.PatEP;
import iih.en.comm.ep.PiPatAmrCodeEP;
import iih.en.comm.ep.PiPatEP;
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
import iih.en.pv.dto.d.EnHosRegDTO;
import iih.en.pv.enhpreferral.d.EnHpReferralDO;
import iih.en.pv.enhpreferral.i.IEnhpreferralCudService;
import iih.en.pv.inpatient.d.EnIppreDO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.dto.d.EnHosPatDTO;
import iih.en.pv.inpatient.i.IEnippreCudService;
import iih.en.pv.inpatient.i.IEnippreRService;
import iih.en.pv.inpatient.s.InpatientCrudServiceImpl;
import iih.en.pv.out.d.EnEvtDTO;
import iih.en.pv.outpatient.dto.d.RegRuleDTO;
import iih.en.pv.pativisit.d.EntContDO;
import iih.en.pv.pativisit.d.EuEntContTp;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.en.pv.s.bp.RegEventBP;
import iih.en.pv.s.rule.CheckIpRegitsRuleBP;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.reg.i.IPiRegMaintainService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.d.desc.PatiAddrDODesc;
import iih.pi.reg.pat.i.IPatiAddrDORService;
import iih.pi.reg.pat.i.IPatiMDOCudService;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pat.i.IPiPatContDOCudService;
import iih.pi.reg.pat.i.IPiPatHpDOCudService;
import iih.pi.reg.pat.i.IPiPatHpDORService;
import iih.pi.reg.patamrcode.d.PiPatAmrCodeDO;
import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.aptip.i.IAptipMDOCudService;
import iih.sc.apt.aptip.i.IAptipMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 入院登记（含患者注册）
 * 
 * @author Sarah
 *
 */
public class RegAndPatRegBP {
	
	/**
	 * 入院登记（含患者注册）
	 * 
	 * @param patDTO
	 *            患者信息
	 * @param enHosRegDTO
	 *            入院登记DTO
	 */
	public EnHosRegDTO exec(EnHosPatDTO patDTO, EnHosRegDTO enHosRegDTO, String id_transactneusoftahip)
			throws BizException {
		// 1、校验数据
		ValidateIPDataBP vBP = new ValidateIPDataBP();
		InpatientDO inpatientDO = vBP.exec(patDTO, enHosRegDTO,new FBoolean(true));
		// 2、患者信息保存
		this.savePatInfo(patDTO, enHosRegDTO);
		PatiAggDO pataggDO = new PiPatEP().getPatAggRServ().findById(patDTO.getId_pat());
		// 3、就诊信息保存
		this.saveEntInfo(patDTO, enHosRegDTO, pataggDO,inpatientDO);
		// 4、回写医保交易记录
		//this.setTransactneusoftahip(id_transactneusoftahip, enHosRegDTO);
		// 5、回写患者医保登记信息
		this.setHpEntCodeAh(enHosRegDTO);
		//记录入院事件
		new EnEvtHandle().insertIpRegistEvt(enHosRegDTO);
		
		return enHosRegDTO;
	}

	/**
	 * 入院登记（含患者注册）
	 * 
	 * @param patDTO
	 *            患者信息
	 * @param enHosRegDTO
	 *            入院登记DTO
	 */
	public EnHosRegDTO exec(EnHosPatDTO patDTO, EnHosRegDTO enHosRegDTO) throws BizException {
		//获取保存的患者信息
		if (EnValidator.isEmpty(patDTO.getId_pat())) {
			throw new BizException("患者ID值为空！");
		}
		PatiAggDO patiAggDO = new PiPatEP().getPatAggRServ().findById(patDTO.getId_pat());
		boolean hasBed = !EnValidator.isEmpty(enHosRegDTO.getId_bed());
		// 1、校验数据
		ValidateIPDataBP vBP = new ValidateIPDataBP();
		InpatientDO inpatientDO = vBP.exec(patDTO, enHosRegDTO,new FBoolean(true));
		// 2、患者信息保存
		//PatiAggDO pataggDO = this.savePatInfo(patDTO, enHosRegDTO);
		// 3、就诊信息保存
		this.saveEntInfo(patDTO, enHosRegDTO, patiAggDO,inpatientDO, hasBed);
		// 4、回写医保交易记录
		//this.setTransactneusoftahip(enHosRegDTO);
		// 5、回写患者医保登记信息
		this.setHpEntCodeAh(enHosRegDTO);
		//记录入院事件
		new EnEvtHandle().insertIpRegistEvt(enHosRegDTO);
		return enHosRegDTO;
	}
	
	/**
	 * 保存失败，住院号回滚
	 * @param patDTO
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	public void rollBackCodeAmrIp(EnHosPatDTO patDTO, EnHosRegDTO enHosRegDTO) throws BizException{
		//如果就诊信息保存失败，回滚生成的住院号
		if (FBoolean.TRUE.equals(patDTO.getFg_codeamr())) {
			new EnCodeAmrIpEP().rollBackAndDelPatDOCodeAmrIp(patDTO.getCode_amr_ip(), patDTO.getId_pat());
		}
		if (FBoolean.TRUE.equals(patDTO.getFg_sptycodeamr())) {
			IIpspectpRService iIpspectpRService = ServiceFinder.find(IIpspectpRService.class);
			BdEnIpSpecDO[] bdEnIpSpecDOs = iIpspectpRService.findByAttrValString(BdEnIpSpecDO.SD_IP_SPEC, enHosRegDTO.getSd_ip_spec());
			new EnCodeAmrIpEP().rollBackAndDelPatAmrCodeDOCodeAmrIp(bdEnIpSpecDOs[0].getCode_codemaker(), 
					patDTO.getCode_amr_ip(), patDTO.getId_pat(), bdEnIpSpecDOs[0].getSd_patarmtp());
		}
	}
	
	/**
	 * 回写患者医保登记信息
	 * 
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	private void setHpEntCodeAh(EnHosRegDTO enHosRegDTO) throws BizException{
		//医保就诊才能解锁
		if(EnValidator.isEmpty(enHosRegDTO.getPrim_cplan()))
			return;
		IHpentcodeRService rServ = ServiceFinder.find(IHpentcodeRService.class);
		String whereStr = String.format("code_ent = '%s' and fg_active = '%s'", enHosRegDTO.getCode_ent(),
				FBoolean.TRUE);
		HpEntCodeDO[] entCodeAhs = rServ.find(whereStr, null, FBoolean.FALSE);
		if(EnValidator.isEmpty(entCodeAhs))
			return;
		for(HpEntCodeDO entCodeAh : entCodeAhs){
			entCodeAh.setId_ent(enHosRegDTO.getId_ent());
			entCodeAh.setId_pat(enHosRegDTO.getId_pat());
			entCodeAh.setFg_lock(FBoolean.FALSE);
			entCodeAh.setStatus(DOStatus.UPDATED);
		}
		ServiceFinder.find(IHpentcodeCudService.class).update(entCodeAhs);
	}

	/**
	 * 回写医保交易记录
	 * 
	 * @param id_transactneusoftahip
	 * @param enHosRegDTO
	 * @throws BizException 
	 */
	@SuppressWarnings("unused")
	private void setTransactneusoftahip(String id_transactneusoftahip, EnHosRegDTO enHosRegDTO) throws BizException{
		if(EnValidator.isEmpty(id_transactneusoftahip))
			return;
		IHptransactahipRService rServ = ServiceFinder.find(IHptransactahipRService.class);
		HptransactahipAggDO agg = rServ.findById(id_transactneusoftahip);
		HpTransActAhIpDO actAhIpDO = agg.getParentDO();
		actAhIpDO.setStatus(DOStatus.UPDATED);
		actAhIpDO.setId_pat(enHosRegDTO.getId_pat());
		actAhIpDO.setId_ent(enHosRegDTO.getId_ent());
		IHptransactahipCudService cudServ = ServiceFinder.find(IHptransactahipCudService.class);
		cudServ.update(new HptransactahipAggDO[]{agg});
	}
	
	/**
	 * 保存患者信息
	 * 
	 * @param enhosPatDTO
	 * @param enHosRegDTO
	 * @return
	 * @throws BizException
	 */
	public EnHosPatDTO savePatInfo(EnHosPatDTO enhosPatDTO, EnHosRegDTO enHosRegDTO) throws BizException {	
		PatEP ep = new PatEP();
		ep.updateSdCodeTp2Others(enhosPatDTO.getId_pat(), enhosPatDTO.getSd_idtp(), enhosPatDTO.getId());
		// 2.得到patdo 旧患者取出 新患者新建
		PatDO patdo = this.setPatDOStatus(enhosPatDTO);
		// 3.组装patdo
		this.setPatDOContent(patdo, enhosPatDTO, enHosRegDTO);
		// 4.得到pataddrdo 地址do//组装pataddrDO
		List<PatiAddrDO> addrlist = setPatAddrContent(enhosPatDTO);
		// 5.组装patcontDO 患者联系人
		List<PiPatContDO> patContDOList = null;
		if (enhosPatDTO.getIschild() != null && enhosPatDTO.getIschild().booleanValue()) {
			patContDOList = this.setPatContWithParent(enhosPatDTO);
		} else {
			patContDOList = this.setPatContContent(enhosPatDTO);
		}
		// 6.组装aggdo
		PatiAggDO patiaggdo = new PatiAggDO();
		patiaggdo.setParentDO(patdo);
		patiaggdo.setPatiAddrDO(addrlist.toArray(new PatiAddrDO[] {}));
		if (!EnValidator.isEmpty(patContDOList)) {
			patiaggdo.setPiPatContDO(patContDOList.toArray(new PiPatContDO[] {}));
		}
		// 保存aggdo
		IPiRegMaintainService patiService = ServiceFinder.find(IPiRegMaintainService.class);
		PatiAggDO pAggDO = patiService.savePatForHosReg( patiaggdo);
		//给EnHosPatDTO设置id_pat的值
		enhosPatDTO.setId_pat(pAggDO.getParentDO().getId_pat());
		return enhosPatDTO;
	}

	/**
	 * 保存就诊信息
	 * 
	 * @param enhosPatDTO
	 * @param enHosRegDTO
	 * @param pataggDO
	 * @throws BizException
	 */
	private void saveEntInfo(EnHosPatDTO enhosPatDTO, EnHosRegDTO enHosRegDTO, PatiAggDO pataggDO,
			InpatientDO inpatientDO, boolean hasBed) throws BizException {
		//0。判断是不是新患者
		FBoolean isNew = FBoolean.TRUE;
		if (enHosRegDTO.getStatus() != DOStatus.NEW){
			isNew = FBoolean.FALSE;
		}
		// 1、取得保存后的patdo
		PatDO patdo = pataggDO.getParentDO();
		// 2、取得保存后的pat联系人
		List<PiPatContDO> patContList = this.getPatCont(pataggDO);

		// 3、设置pat的值
		enhosPatDTO.setId_pat(patdo.getId_pat());
		enHosRegDTO.setId_pat(patdo.getId_pat());
		//2、再次校验规则疫情
		this.checkIpRegRule(enhosPatDTO, enHosRegDTO);
		//如果是非普通住院患者，保存患者病案编码表 zhangpp 2019.10.15
		if(EnValidator.isEmpty(enHosRegDTO.getSd_ip_spec())){
			enHosRegDTO.setSd_ip_spec(IEnDictCodeConst.SD_IPTYPE_CUSTOM);
		}
		new PiPatAmrCodeEP().registSavePatAmrCodeDO(enhosPatDTO.getId_pat(), enhosPatDTO.getCode_amr_ip(), 
				enHosRegDTO.getSd_ip_spec(), enHosRegDTO.getSd_status());
		
		// 5、就诊数据保存
		PatiVisitDO patiVisitDO = this.SavePativisitData(enhosPatDTO, enHosRegDTO);
		//判断是不是转诊患者，如果是，保存转诊信息-zhangpp
		this.SaveBiTransInfo(enHosRegDTO);
		// 6、住院数据保存
		inpatientDO=this.SaveInpatienttData(enHosRegDTO, patiVisitDO.getId_ent(), patdo, hasBed, enhosPatDTO);
		//7.预住院数据保存
		this.saveEnIppreDO(enHosRegDTO, enhosPatDTO, inpatientDO);
		// 7、就诊医保数据保存
		this.SaveHealthInsuranceData(enHosRegDTO, patiVisitDO.getId_ent());
		// 8、患者医保数据保存
		this.savePiHp(enHosRegDTO);
		// 9.保存就诊贫困标签
		enHosRegDTO.setId_ent(patiVisitDO.getId_ent());//fanlq-2018-09-25-add-就诊标签就诊id没保存上
		this.setPoorTag(enHosRegDTO);
		//10.保存就诊低保标签，fanlq-2018-09-25-add
		this.setMinlivingTag(enHosRegDTO);
		//11.保存就诊五保标签，fanlq-2018-09-25-add
		this.setFiveguarTag(enHosRegDTO);
		//保存担保人信息，在就诊联系人表中 zhangpp 2019.10.28
		this.setEntContSurety(enhosPatDTO, patiVisitDO.getId_ent());
		// 10、保存就诊联系人
		if (!EnValidator.isEmpty(patContList)) {
			this.SaveEntCont(patContList, patiVisitDO.getId_ent(), enhosPatDTO);
		}
		if (enHosRegDTO.getFg_ip() == null || !enHosRegDTO.getFg_ip().booleanValue()) {
			// 9、创建就诊账户
			this.SaveEnAccData(enHosRegDTO, patiVisitDO.getId_ent(), patiVisitDO.getId_pat());
			// 10、修改入院通知单信息
			this.updateIpntInfo(enHosRegDTO, patiVisitDO.getId_ent());
			enHosRegDTO.setSd_status(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN);
		}
		//enHosRegDTO.setId_ent(patiVisitDO.getId_ent());//重复设值，注释掉
		//11、记录就诊变更事件 患者分类事件变更
		this.saveEntChageEvt(isNew,enhosPatDTO,enHosRegDTO);
		//12.发送集成平台事件
		this.invoke(enHosRegDTO,patiVisitDO,inpatientDO,isNew);
	}

	/**
	 * 保存患者担保人信息
	 * @param enHosPatDTO
	 * @throws BizException 
	 */
	private void setEntContSurety(EnHosPatDTO enHosPatDTO, String entId) throws BizException{
		if (EnValidator.isEmpty(enHosPatDTO.getSurety_name_emp()) || EnValidator.isEmpty(enHosPatDTO.getSurety_idtp_emp())
				|| EnValidator.isEmpty(enHosPatDTO.getSurety_idcard_emp())){
			return;
		}
		EntContEP entContEP = new EntContEP();
		EntContDO[] entContDOs = entContEP.getEntConts(entId, EuEntContTp.SURETY, "");
		EntContDO entContDO = null;
		if (EnValidator.isEmpty(entContDOs)) {
			entContDO = new EntContDO();
			entContDO.setStatus(DOStatus.NEW);
		}else {
			entContDO = entContDOs[0];
			entContDO.setStatus(DOStatus.UPDATED);
		}
		entContDO.setId_ent(entId);
		entContDO.setEu_entconttp(EuEntContTp.SURETY);
		entContDO.setId_conttp(enHosPatDTO.getSurety_idconttp_emp());
		entContDO.setSd_conttp(enHosPatDTO.getSurety_sdconttp_emp());
		entContDO.setName(enHosPatDTO.getSurety_name_emp());
		entContDO.setConttel(enHosPatDTO.getSurety_tel_emp());
		entContDO.setIdcode(enHosPatDTO.getSurety_idcard_emp());
		entContDO.setId_idtp(enHosPatDTO.getSurety_idtp_emp());
		entContDO.setSd_idtp(enHosPatDTO.getSurety_sdtp_emp());
		entContDO.setId_guarantp(enHosPatDTO.getSurety_idtype());
		entContDO.setSd_guarantp(enHosPatDTO.getSurety_sdtype());
		entContEP.saveEntContByStatus(Arrays.asList(entContDO));
	}
	
	/**
	 * 保存entcont
	 * 
	 * @param picontDO
	 * @param entId
	 * @throws BizException
	 */
	private void SaveEntCont(List<PiPatContDO> patContList, String entId, EnHosPatDTO enhosPatDTO) throws BizException {
		if (EnValidator.isEmpty(patContList))
			return;
		EntContEP entContEP = new EntContEP();
		if (enhosPatDTO.getIschild() != null && enhosPatDTO.getIschild().booleanValue()
				&& !EnValidator.isEmpty(patContList)) {
			entContEP.SaveParentCont(patContList.toArray(new PiPatContDO[] {}), entId);
		} else {
			if (!EnValidator.isEmpty(patContList)) {
				PiPatContDO piContDO = patContList.get(0);
				for (PiPatContDO contDO : patContList) {
					if (!EnValidator.isEmpty(enhosPatDTO.getId_patcont())) {
						if (contDO.getId_patcont().equals(enhosPatDTO.getId_patcont())) {
							piContDO = contDO;
							break;
						}
					}else if (!EnValidator.isEmpty(enhosPatDTO.getName_patcontref())){
						if (enhosPatDTO.getName_patcontref().equals(contDO.getName())) {
							piContDO = contDO;
							break;
						}
					}
				}
				entContEP.SaveEntCont(piContDO, entId);
			}
		}
	}

	/**
	 * 登录患者就诊数据
	 */
	private PatiVisitDO SavePativisitData(EnHosPatDTO patDTO, EnHosRegDTO enHosRegDTO) throws BizException {
		IPativisitCudService pativisitCrudService = ServiceFinder.find(IPativisitCudService.class);
		PatiVisitDO patiVisitDO = this.getPatVisitDO(enHosRegDTO);
		if (enHosRegDTO.getStatus() == DOStatus.NEW) {
			patiVisitDO.setId_grp(EnContextUtils.getGrpId());//集团
			patiVisitDO.setId_org(EnContextUtils.getOrgId());//组织	
		}

		// 检索患者信息
		PatDO patiInfo = this.getPatDO(patDTO.getId_pat());	
		patiVisitDO.setCode(enHosRegDTO.getCode_ent());
		patiVisitDO.setId_pat(patiInfo.getId_pat());
		if(enHosRegDTO.getFg_ippre() != null && enHosRegDTO.getFg_ippre().booleanValue()){
			patiVisitDO.setId_entp(IBdFcDictCodeConst.ID_CODE_ENTP_IP_PRE); // 就诊类型ID预住院
			patiVisitDO.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE); // 就诊类型预住院
		}else{
			patiVisitDO.setId_entp(IBdFcDictCodeConst.ID_CODE_ENTP_IP); // 就诊类型ID
			patiVisitDO.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_IP); // 就诊类型
		}
		// 更新患者信息
		patiVisitDO.setName_pat(patiInfo.getName());
		patiVisitDO.setId_sex_pat(patiInfo.getId_sex());
		patiVisitDO.setSd_sex_pat(patiInfo.getSd_sex());
		patiVisitDO.setSd_mari_pat(patDTO.getSd_marry());
		patiVisitDO.setId_mari_pat(patDTO.getId_marry());
		patiVisitDO.setDt_birth_pat(patiInfo.getDt_birth());
		patiVisitDO.setTelno_pat(patDTO.getMob());
		patiVisitDO.setId_cust_cmpy(enHosRegDTO.getId_cust_cmpy());
		// 更新就诊信息
		patiVisitDO.setDt_entry(enHosRegDTO.getDt_entry()); // 就诊登记日期时间
		if(patiVisitDO.getFg_acptvalid()==null){
			patiVisitDO.setFg_acptvalid(new FBoolean(false)); // 接诊有效,只有空的时候才赋值，否则会导致，有权限修改在院信息时把标识置为无效
		}	
		//入科后不更新科室和病区
		if(!IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN.equals(enHosRegDTO.getSd_status())){
			patiVisitDO.setId_dep_phy(enHosRegDTO.getId_dep_phyadm()); // 当前就诊科室
			patiVisitDO.setId_dep_nur(enHosRegDTO.getId_dep_nuradm()); // 当前护理单位(病区)
		}
		patiVisitDO.setId_hp(enHosRegDTO.getPrim_cplan()); // 主医保计划
		patiVisitDO.setId_patca(enHosRegDTO.getId_paticate()); // 患者分类
		patiVisitDO.setId_pripat(enHosRegDTO.getId_pripat()); // 价格分类
		patiVisitDO.setId_patcret(enHosRegDTO.getId_patcret()); // 信用分类
		patiVisitDO.setFg_st(FBoolean.FALSE); // 结算标志
		patiVisitDO.setFg_flup(FBoolean.FALSE); // 随访标志
		patiVisitDO.setFg_canc(FBoolean.FALSE); // 退诊标志
		patiVisitDO.setFg_data_transf(FBoolean.FALSE);// 可转移标识
		patiVisitDO.setCode_hpmedkind(enHosRegDTO.getCode_hpmedkind());//医疗类别
		patiVisitDO.setNote(enHosRegDTO.getNote());//备注
		 // 登记人员
		if(EnValidator.isEmpty(patiVisitDO.getId_emp_entry())){
			patiVisitDO.setId_emp_entry(enHosRegDTO.getId_emp());
		}

		// 地址信息
		patiVisitDO.setId_admdiv_addr(patDTO.getId_admdiv());
		patiVisitDO.setSd_admdiv_addr(patDTO.getSd_admdiv());
		patiVisitDO.setAddr_pat(patDTO.getAddr_pat());
		if (enHosRegDTO.getFg_ip() == null || !enHosRegDTO.getFg_ip().booleanValue()) {
			FDateTime curTime = EnAppUtils.getServerDateTime();
			patiVisitDO.setDt_insert(curTime);
			patiVisitDO.setFg_ip(FBoolean.FALSE); // 在院标志
		}
		return pativisitCrudService.save(new PatiVisitDO[] { patiVisitDO })[0];
	}

	/**
	 * 登录住院数据
	 */
	private InpatientDO SaveInpatienttData(EnHosRegDTO enHosRegDTO, String entId, PatDO patdo, boolean hasBed,
			EnHosPatDTO enhosPatDTO) throws BizException {
		InpatientCrudServiceImpl inpatientService = new InpatientCrudServiceImpl();
		InpatientDO inpatientDO = new InpatientDO();
		inpatientDO.setStatus(DOStatus.NEW);
		if(enHosRegDTO.getFg_ippre() != null && enHosRegDTO.getFg_ippre().booleanValue()){
			inpatientDO.setFg_ippre(FBoolean.TRUE);
		}
		String oldBedId = null;
        this.SetBedInfo(enHosRegDTO, patdo.getSd_sex());
		if (enHosRegDTO.getStatus() == DOStatus.UPDATED) {
			inpatientDO = this.getInPatientDO(entId);
			oldBedId = inpatientDO.getId_bed();
		} else if (enHosRegDTO.getStatus() == DOStatus.NEW && !EnValidator.isEmpty(enHosRegDTO.getId_bed_sc()) && !enHosRegDTO.getId_bed_sc().equals(enHosRegDTO.getId_bed())) {
			EnLogUtil.getInstance().logError("方法：SaveInpatienttData(EnHosRegDTO enHosRegDTO, String entId, PatDO patdo, boolean hasBed, EnHosPatDTO enhosPatDTO)----患者未使用预约的床位，需释放预约的床位，预约床位id：" + enHosRegDTO.getId_bed_sc());
			oldBedId = enHosRegDTO.getId_bed_sc();
		}
		if(inpatientDO.getTimes_ip() == null || inpatientDO.getTimes_ip() <= 0){
			inpatientDO.setTimes_ip(enHosRegDTO.getTimes());
			if(inpatientDO.getTimes_ip() == null || inpatientDO.getTimes_ip() <= 0){
				inpatientDO.setTimes_ip(EnVisitTimesUtils.calcAdmIpTimes(patdo.getId_pat()));
			}
			patdo.setLast_times_ip(inpatientDO.getTimes_ip());
			//住院数据保存后，同步患者表中的住院次数 - zhangpp
			this.SetPatDo(patdo);
		}
		inpatientDO.setCode_amr_ip(enhosPatDTO.getCode_amr_ip());		
		inpatientDO.setId_ent(entId); // 就诊ID
		//入科后不更新科室和病区
		if (!IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN.equals(enHosRegDTO.getSd_status())) {
			inpatientDO.setId_dep_phyadm(enHosRegDTO.getId_dep_phyadm()); // 入院科室
			inpatientDO.setId_dep_nuradm(enHosRegDTO.getId_dep_nuradm()); // 入院病区	
		}
		inpatientDO.setId_bed(enHosRegDTO.getId_bed()); // 选择的床位
		inpatientDO.setName_bed(enHosRegDTO.getBedname());
		inpatientDO.setFg_surg(new FBoolean(false)); // 是否手术标志
		inpatientDO.setFg_newborn(new FBoolean(false)); // 是否新生儿标志
		inpatientDO.setId_referalsrc(enHosRegDTO.getId_referalsrc()); // 来院方式ID
		inpatientDO.setSd_referalsrc(enHosRegDTO.getSd_referalsrc()); // 来院方式
		inpatientDO.setCont_name(enHosRegDTO.getCont_name()); // 主要联系人姓名
		inpatientDO.setCont_tel(enHosRegDTO.getConttel()); // 主要联系人电话
		inpatientDO.setId_diag_op(enHosRegDTO.getId_diag());
		inpatientDO.setDesc_diag_op(enHosRegDTO.getDesc_diag());// 保存诊断
		inpatientDO.setId_level_diseadm(enHosRegDTO.getId_level_diseadm());
		inpatientDO.setSd_level_diseadm(enHosRegDTO.getSd_level_diseadm());
		inpatientDO.setId_level_dise(enHosRegDTO.getId_level_diseadm());
		inpatientDO.setSd_level_dise(enHosRegDTO.getSd_level_diseadm());
		inpatientDO.setId_emp_opapply(enHosRegDTO.getId_emp_phy_op());//入院医生
		inpatientDO.setSd_pay_mothod(enhosPatDTO.getSd_pay_mothod());//付款方式
		inpatientDO.setFg_vip(enhosPatDTO.getFg_vip());
		inpatientDO.setFg_mobapp(enhosPatDTO.getFg_mobapp());
		inpatientDO.setTelno_mobapp(enhosPatDTO.getTelno_mobapp());
		inpatientDO.setFg_pe(enhosPatDTO.getFg_pe());
		inpatientDO.setSd_pe_psntp(enhosPatDTO.getSd_pe_psntp());
		inpatientDO.setName_pe_intr(enhosPatDTO.getName_pe_intr());
		//住院特定类型
		if (!EnValidator.isEmpty(enHosRegDTO.getId_ip_spec()) && !EnValidator.isEmpty(enHosRegDTO.getSd_ip_spec())) {
			inpatientDO.setId_ip_spec(enHosRegDTO.getId_ip_spec());
			inpatientDO.setSd_ip_spec(enHosRegDTO.getSd_ip_spec());
		}else{
			UdidocDO udidocDO = new UdiDocEP().getUdidocByCodeAndValue(IEnDictCodeTypeConst.SD_IP_TYPE, IEnDictCodeConst.SD_IPTYPE_CUSTOM);
			if (udidocDO != null) {
				inpatientDO.setId_ip_spec(udidocDO.getId_udidoc());
				inpatientDO.setSd_ip_spec(udidocDO.getCode());
			}
		}
		// 通过住院通知单入院的时候保存病情等级
		// this.SaveLevelDiseToIpnt(inpatientDO, enHosRegDTO.getId_ent_ipnt());
		if (enHosRegDTO.getFg_ip() == null || !enHosRegDTO.getFg_ip().booleanValue()) {
			inpatientDO.setSd_status(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN); // 就诊状态为住院
			// 根据参数是否区分性别更新床位信息
			if (hasBed && IEnDictCodeConst.BED_HAS_SEX.equals(EnParamUtils.getBedSexParam(enHosRegDTO.getId_dep_nuradm()))) {
				updateBedDataWithSex(enHosRegDTO.getId_ent(), oldBedId, enHosRegDTO.getId_bed(), enHosRegDTO.getId_ent_ipnt(),
						patdo.getSd_sex());
			}else {
				updateBedData(enHosRegDTO.getId_ent(), oldBedId, enHosRegDTO.getId_bed(),enHosRegDTO.getId_ent_ipnt());
			}
		}
		InpatientDO[] inpatients = inpatientService.save(new InpatientDO[] { inpatientDO });
		enHosRegDTO.setTimes(inpatientDO.getTimes_ip());
		if(EnValidator.isEmpty(inpatients)){
			return null;
		}
		return inpatients[0];
	}
	
	/**
	 * 同步患者表中的住院次数
	 * @param times
	 * @throws BizException 
	 */
	private void SetPatDo(PatDO patdo) throws BizException{
		IPatiMDOCudService iPatiCudService = ServiceFinder.find(IPatiMDOCudService.class);
		iPatiCudService.update(new PatDO[]{patdo});
	}

	/**
	 * 登录患者就诊账户数据
	 * 
	 * @param enHosRegDTO
	 * @param entid
	 * @param patId
	 * @throws BizException
	 */
	private void SaveEnAccData(EnHosRegDTO enHosRegDTO, String entid, String patId) throws BizException {
		EnAccEP enaccBp = new EnAccEP();
		enaccBp.saveEnAccData(patId, entid, enHosRegDTO.getDt_entry(), enHosRegDTO.getId_patcret());
	}

	/**
	 * 登录就诊医保数据
	 * 
	 */
	private void SaveHealthInsuranceData(EnHosRegDTO enHosRegDTO, String entId) throws BizException {
		// 删除已有
		EntHpEP entHpEP = new EntHpEP();
		entHpEP.deleteByEntId(entId);
		// 保存最新
		entHpEP.saveEntHp(entId, enHosRegDTO);
	}

	/**
	 * 登录患者医保数据 如果主医保不存在，则不处理。 没有主医保，也肯定没有辅医保，辅医保依附主医保存在
	 * 
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	private void savePiHp(EnHosRegDTO enHosRegDTO) throws BizException {
		
		// 如果主医保不存在，则不处理。
		// 没有主医保，也肯定没有辅医保，辅医保依附主医保存在
		if (EnValidator.isEmpty(enHosRegDTO.getPrim_cplan())) {
			return;
		}

		IPiPatHpDORService patHPRService = ServiceFinder.find(IPiPatHpDORService.class);
		String whereStr = String.format("id_pat='%s'", enHosRegDTO.getId_pat());
		PiPatHpDO[] piPatHpDOs = patHPRService.find(whereStr, null, FBoolean.TRUE);

		PiPatHpDO mainHpDO = null;
		PiPatHpDO extraHpDO = null;
		int sortNo = -1;
		FBoolean hasMaj = FBoolean.FALSE;// 是否含有主医保
		FDateTime currentTime = EnAppUtils.getServerDateTime();
		ArrayList<PiPatHpDO> saveList = new ArrayList<PiPatHpDO>();
		if (!EnValidator.isEmpty(piPatHpDOs)) {
			for (PiPatHpDO piPatHpDO : piPatHpDOs) {
				if (piPatHpDO.getFg_deft() != null && piPatHpDO.getFg_deft().booleanValue()) {
					hasMaj = FBoolean.TRUE;
				}
				if (enHosRegDTO.getPrim_cplan().equals(piPatHpDO.getId_hp())) {
					mainHpDO = piPatHpDO;
					mainHpDO.setNo_hp(enHosRegDTO.getCode_hp());
					mainHpDO.setStatus(DOStatus.UPDATED);
					saveList.add(mainHpDO);
				} else if (!EnValidator.isEmpty(enHosRegDTO.getAuxi_cplan())
						&& enHosRegDTO.getAuxi_cplan().equals(piPatHpDO.getId_hp())) {
					extraHpDO = piPatHpDO;
					extraHpDO.setNo_hp(enHosRegDTO.getCode_hp2());
					extraHpDO.setStatus(DOStatus.UPDATED);
					saveList.add(extraHpDO);
				}
				if (piPatHpDO.getSortno() == null) {
					sortNo = 0;
				} else if (sortNo < piPatHpDO.getSortno()) {
					sortNo = piPatHpDO.getSortno();
				}
			}
		}

		// 没有找到，则新建主医保
		if (mainHpDO == null) {
			mainHpDO = new PiPatHpDO();
			mainHpDO.setStatus(DOStatus.NEW);
			mainHpDO.setId_pat(enHosRegDTO.getId_pat()); // 患者ID
			mainHpDO.setSortno(++sortNo); // 序号
			mainHpDO.setId_hp(enHosRegDTO.getPrim_cplan()); // 医保计划
			mainHpDO.setNo_hp(enHosRegDTO.getCode_hp()); // 医保号
			mainHpDO.setMode_hp(IPiDictCodeConst.ID_HP_ENABLE);
			// 没有主医保，则此就是主医保
			if (hasMaj.booleanValue()) {
				mainHpDO.setFg_deft(FBoolean.FALSE); // 默认标志
			} else {
				mainHpDO.setFg_deft(FBoolean.TRUE);
			}
			mainHpDO.setDt_b(currentTime); // 有效日期开始
			mainHpDO.setFg_act(new FBoolean(true)); // 启用标志
			saveList.add(mainHpDO);
		}

		// 新建辅助医保
		if (!EnValidator.isEmpty(enHosRegDTO.getAuxi_cplan()) && extraHpDO == null) {
			extraHpDO = new PiPatHpDO();
			extraHpDO.setStatus(DOStatus.NEW);
			extraHpDO.setId_pat(enHosRegDTO.getId_pat()); // 患者ID
			extraHpDO.setSortno(++sortNo); // 序号
			extraHpDO.setId_hp(enHosRegDTO.getAuxi_cplan()); // 医保计划
			extraHpDO.setNo_hp(enHosRegDTO.getCode_hp2()); // 医保号
			extraHpDO.setFg_deft(FBoolean.FALSE); // 默认标志
			extraHpDO.setDt_b(currentTime); // 有效日期开始
			extraHpDO.setFg_act(FBoolean.TRUE); // 启用标志
			extraHpDO.setMode_hp(IPiDictCodeConst.ID_HP_ENABLE);
			saveList.add(extraHpDO);
		}

		if (saveList.size() > 0) {
			IPiPatHpDOCudService patHPCrudService = ServiceFinder.find(IPiPatHpDOCudService.class);
			patHPCrudService.save(saveList.toArray(new PiPatHpDO[0]));
		}
	}
	/**
	 * 设置患者贫困标签
	 * 
	 * @param enhosPatDTO
	 * @throws BizException
	 */
	private void setPoorTag(EnHosRegDTO enHosRegDTO) throws BizException{
		new EnPatTpEP().setEntPoorTag(enHosRegDTO.getId_ent(), enHosRegDTO.getFg_poor());
	}
	/**
	 * 设置患者低保标签
	 * 
	 * @param enhosPatDTO
	 * @throws BizException
	 */
	private void setMinlivingTag(EnHosRegDTO enHosRegDTO) throws BizException{
		new EnPatTpEP().setMinlivingTag(enHosRegDTO.getId_ent(), enHosRegDTO.getFg_minliving());
	}
	/**
	 * 设置患者五保标签
	 * 
	 * @param enhosPatDTO
	 * @throws BizException
	 */
	private void setFiveguarTag(EnHosRegDTO enHosRegDTO) throws BizException{
		new EnPatTpEP().setFiveguarTag(enHosRegDTO.getId_ent(), enHosRegDTO.getFg_fiveguar());
	}
	/**
	 * 更新住院通知单
	 * 
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	private void updateIpntInfo(EnHosRegDTO enHosRegDTO, String entId) throws BizException {
		// 由入院通知单转入的时候
		if (EnValidator.isEmpty(enHosRegDTO.getId_ent_ipnt())) {
			return;
		}
		IAptipMDORService aptRService = ServiceFinder.find(IAptipMDORService.class);
		IAptipMDOCudService aptCudService = ServiceFinder.find(IAptipMDOCudService.class);
		AptIpDO entIpntDO = aptRService.findById(enHosRegDTO.getId_ent_ipnt());
		entIpntDO.setStatus(DOStatus.UPDATED);
		entIpntDO.setSd_status(IEnDictCodeConst.SD_STATUS_NOTICE_INHOS);
		entIpntDO.setFg_emgstay(FBoolean.FALSE);// 急诊留观标识为false
		entIpntDO.setId_entip(entId);
		aptCudService.update(new AptIpDO[] { entIpntDO });
	}

	/**
	 * 更新床位信息
	 * 
	 * @param bedId
	 * @param ifOccupy
	 * @throws BizException
	 */
	private void updateBedData(String idEnt, String oldBedID, String newBedID,String ipntId) throws BizException {
		BedEP bedbp = new BedEP();
		if (!EnValidator.isEmpty(oldBedID)) {
			bedbp.releaseBedWithAppt(idEnt, oldBedID);
		}

		if (!EnValidator.isEmpty(newBedID)) {
			bedbp.occupyBed(newBedID,ipntId);
		}
	}
	
	/**
	 * 区分床位性别时更新床位信息
	 * 
	 * @param oldBedID
	 * @param newBedID
	 * @param ipntId
	 * @throws BizException
	 * 
	 * @author jizb
	 */
	private void updateBedDataWithSex(String idEnt, String oldBedID, String newBedID, String ipntId, String sdSexOfPat)
			throws BizException {
		BedEP bedbp = new BedEP();
		if (!EnValidator.isEmpty(oldBedID)) {
			bedbp.releaseBedWithSex(idEnt, oldBedID, FBoolean.TRUE);
		}

		if (!EnValidator.isEmpty(newBedID)) {
			bedbp.occupyBedWithSex(newBedID, ipntId, sdSexOfPat, FBoolean.TRUE, IBdResDictCodeConst.SD_BEDSU_OCCUPYBYIN,
					IBdResDictCodeConst.ID_BEDSU_OCCUPYBYIN);
		}
	}

	/**
	 * 查找entdo
	 * 
	 * @param enHosRegDTO
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO getPatVisitDO(EnHosRegDTO enHosRegDTO) throws BizException {
		PvEP pvep = new PvEP();
		PatiVisitDO patiVisitDO = new PatiVisitDO();
		patiVisitDO.setStatus(DOStatus.NEW);
		if (enHosRegDTO.getStatus() == DOStatus.UPDATED) {
			patiVisitDO = pvep.getPvById(enHosRegDTO.getId_ent());
			patiVisitDO.setStatus(DOStatus.UPDATED);
		}
		return patiVisitDO;
	}

	/**
	 * 获取patcontdo
	 * 
	 * @param pataggDO
	 * @return
	 */
	private List<PiPatContDO> getPatCont(PatiAggDO pataggDO) {
		List<PiPatContDO> patContList = null;
		if (pataggDO.getPiPatContDO() != null) {
			PiPatContDO[] patConts = pataggDO.getPiPatContDO();
			if (!EnValidator.isEmpty(patConts)) {
				patContList = Arrays.asList(patConts);
			}
		}
		return patContList;
	}

	/**
	 * 根据entid获取住院do
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private InpatientDO getInPatientDO(String entId) throws BizException {
		InpatientCrudServiceImpl inpatientService = new InpatientCrudServiceImpl();
		InpatientDO inpatientDO = inpatientService.find("id_ent = '" + entId + "'", "", new FBoolean(false))[0];
		inpatientDO.setStatus(DOStatus.UPDATED);
		return inpatientDO;
	}

	/**
	 * 获取患者do
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private PatDO getPatDO(String patId) throws BizException {
		IPatiMDORService patRService = ServiceFinder.find(IPatiMDORService.class);
		PatDO patdo = patRService.findById(patId);
		if (patdo == null) {
			throw new BizException(IEnMsgConst.ERROR_PAT_NOT_EXIST);
		}
		return patdo;
	}

	/**
	 * 得到patdo 旧患者取出 新患者新建
	 * 
	 * @param patDTO
	 * @return
	 * @throws BizException
	 */
	private PatDO setPatDOStatus(EnHosPatDTO patDTO) throws BizException {
		PatDO patdo;
		if (EnValidator.isEmpty(patDTO.getId_pat())) {// 如果没有patid，新增患者
			patdo = new PatDO();
			patdo.setStatus(DOStatus.NEW);
		} else {
			patdo = this.getPatDO(patDTO.getId_pat());
			patdo.setStatus(DOStatus.UPDATED);
		}
		return patdo;
	}

	/**
	 * 组装patdo
	 * 
	 * @param patdo
	 * @param enhosPatDTO
	 * @throws BizException
	 */
	private void setPatDOContent(PatDO patdo, EnHosPatDTO enhosPatDTO, EnHosRegDTO enHosRegDTO) throws BizException {
		if (EnValidator.isEmpty(patdo.getId_pat())) {
			patdo.setCode(EnCodeUtils.createPatCode());
		}
		////判断是否生成住院号
		//根据住院特定类型，查找对应的患者病案类型
		if(EnValidator.isEmpty(enHosRegDTO.getSd_ip_spec())){
			enHosRegDTO.setSd_ip_spec(IEnDictCodeConst.SD_IPTYPE_CUSTOM);
		}
		IIpspectpRService iIpspectpRService = ServiceFinder.find(IIpspectpRService.class);
		BdEnIpSpecDO[] bdEnIpSpecDOs = iIpspectpRService.findByAttrValString(BdEnIpSpecDO.SD_IP_SPEC, enHosRegDTO.getSd_ip_spec());
		//如果住院特定类型表中无数据，默认走普通的住院号
		if (bdEnIpSpecDOs == null || bdEnIpSpecDOs.length <= 0 || IEnDictCodeConst.SD_IPTYPE_CUSTOM.equals(enHosRegDTO.getSd_ip_spec())){
			if (EnValidator.isEmpty(patdo.getCode_amr_ip()) || patdo.getCode_amr_ip().contains("B") 
					|| (EnValidator.isEmpty(enHosRegDTO.getId_ent())&&(EnParamUtils.getIsChangeIpCode()))) {
				patdo.setCode_amr_ip(new EnCodeAmrIpEP().createIpAmrCode());
				EnLogUtil.getInstance().logInfo("住院号生成：患者id"+patdo.getId_pat()+ " 住院号变成:"+patdo.getCode_amr_ip());
				enhosPatDTO.setCode_amr_ip(patdo.getCode_amr_ip());
				enhosPatDTO.setFg_codeamr(FBoolean.TRUE);
			}else{
				enhosPatDTO.setCode_amr_ip(patdo.getCode_amr_ip());
				enhosPatDTO.setFg_codeamr(FBoolean.FALSE);
			}
		}else{
			PiPatAmrCodeDO piPatAmrCodeDO = new PiPatAmrCodeEP().getpiPatAmrCodeByWherestr(patdo.getId_pat(), bdEnIpSpecDOs[0].getSd_patarmtp());
			if (piPatAmrCodeDO == null) {
				enhosPatDTO.setCode_amr_ip(new EnCodeAmrIpEP().createIpSpecTypeAmrCode(bdEnIpSpecDOs[0].getCode_codemaker()));
				EnLogUtil.getInstance().logInfo("特定类型住院号生成：患者id"+patdo.getId_pat()+ " 特定类型住院号为:"+enhosPatDTO.getCode_amr_ip());
				enhosPatDTO.setFg_sptycodeamr(FBoolean.TRUE);
			}else{
				enhosPatDTO.setCode_amr_ip(piPatAmrCodeDO.getCode());
				enhosPatDTO.setFg_sptycodeamr(FBoolean.FALSE);
			}
		}
		
		//设置患者分类
		this.setPatPatCa(patdo, enHosRegDTO);
		patdo.setFg_realname(FBoolean.TRUE);
		patdo.setName(enhosPatDTO.getName_pat());

		patdo.setId_grp(EnContextUtils.getGrpId());
		patdo.setId_org(EnContextUtils.getOrgId());

		patdo.setId_sex(enhosPatDTO.getId_sex());// 性别
		patdo.setSd_sex(enhosPatDTO.getSd_sex());
		patdo.setName_sex(enhosPatDTO.getName_sex());

		patdo.setId_idtp(enhosPatDTO.getId_idtp());// 证件类型
		patdo.setSd_idtp(enhosPatDTO.getSd_idtp());
		patdo.setIdtp_name(enhosPatDTO.getName_idtp());// 证件号码
		patdo.setId_code(enhosPatDTO.getId());

		patdo.setDt_birth(enhosPatDTO.getDt_birth());
		patdo.setDt_birth_hms(enhosPatDTO.getDt_birth_hms());//出生日期 时分秒 - zhangpp
		
		patdo.setId_marry(enhosPatDTO.getId_marry());
		patdo.setSd_marry(enhosPatDTO.getSd_marry());
		patdo.setMarry_name(enhosPatDTO.getName_marry());

		patdo.setTel(enhosPatDTO.getTel());// 电话
		patdo.setMob(enhosPatDTO.getMob());// 移动电话

		if (EnValidator.isEmpty(enhosPatDTO.getId_nation())) {
			patdo.setId_nation("@@@@AA1000000000MHM3");
			patdo.setNation_name("其他");
			patdo.setSd_nation("97");
		} else {
			patdo.setId_nation(enhosPatDTO.getId_nation());// 民族
			patdo.setNation_name(enhosPatDTO.getName_nation());
			patdo.setSd_nation(enhosPatDTO.getSd_nation());
		}

		patdo.setId_country(enhosPatDTO.getId_country()); // 国籍
		patdo.setCountry_name(enhosPatDTO.getName_country());
		patdo.setSd_country(enhosPatDTO.getSd_country());

		patdo.setWbcode(EnAppUtils.getWbCode(patdo.getName()));
		patdo.setPycode(EnAppUtils.getPyCode(patdo.getName()));
		patdo.setMnecode(patdo.getCode());
		patdo.setId_occu(enhosPatDTO.getId_job());
		patdo.setSd_occu(enhosPatDTO.getSd_job());
		patdo.setPhoto(enhosPatDTO.getPhoto());
		patdo.setWorkunit(enhosPatDTO.getWorkplace());
		patdo.setId_marry(enhosPatDTO.getId_marry());//婚姻状况,fanlq-2018-05-26
		patdo.setSd_marry(enhosPatDTO.getSd_marry());
		if(!EnValidator.isEmpty(enhosPatDTO.getBarcode_chis())){
			patdo.setBarcode_chis(enhosPatDTO.getBarcode_chis());
		}
		//2017/1/10 ly 设置域id
		patdo.setDomain(IPiDictCodeConst.DOMAIN_ID_ZY);
		
		patdo.setFg_sync_en(FBoolean.TRUE);
	}

	/**
	 * 设置患者联系人
	 * 
	 * @param enhosPatDTO
	 * @return
	 * @throws BizException
	 */
	private List<PiPatContDO> setPatContContent(EnHosPatDTO enhosPatDTO) throws BizException {

		if (EnValidator.isEmpty(enhosPatDTO.getName_patcontref())
				&& EnValidator.isEmpty(enhosPatDTO.getName_conttp()) && EnValidator.isEmpty(enhosPatDTO.getConttel())
				&& EnValidator.isEmpty(enhosPatDTO.getContaddr()))
			return null;// 如果患者姓名、类型、电话、地址都为空，就返回空
		PiPatContDO piContDO = null;
		int sortNo = 0;
		// 如果患者不为空，说明已经注册了
		if (!EnValidator.isEmpty(enhosPatDTO.getId_pat())) {
			PatEP patep = new PatEP();
			PiPatContDO[] patConts = patep.getContDO(enhosPatDTO.getId_pat());
			if (!EnValidator.isEmpty(patConts)) {
				for (PiPatContDO contDO : patConts) {
					if (!EnValidator.isEmpty(enhosPatDTO.getId_patcont())) {
						if (contDO.getId_patcont().equals(enhosPatDTO.getId_patcont())) {
							piContDO = contDO;
							piContDO.setStatus(DOStatus.UPDATED);
						}
					}
					if (contDO.getSortno() != null && contDO.getSortno() > sortNo) {
						sortNo = contDO.getSortno();
					}
				}
			}
		}

		if (piContDO == null) {
			piContDO = new PiPatContDO();
			piContDO.setStatus(DOStatus.NEW);
			piContDO.setSortno(sortNo + 1);
		}

		piContDO.setId_pat(enhosPatDTO.getId_pat());
		piContDO.setId_conttp(enhosPatDTO.getId_conttp());
		piContDO.setSd_conttp(enhosPatDTO.getSd_conttp());
		piContDO.setName(enhosPatDTO.getName_patcontref());
		piContDO.setConttel(enhosPatDTO.getConttel());
		piContDO.setContaddr(enhosPatDTO.getContaddr());
		List<PiPatContDO> list = new ArrayList<PiPatContDO>();
		list.add(piContDO);
		return list;
	}

	/**
	 * 创建患者父母联系人
	 * 
	 * @param enhosPatDTO
	 * @return
	 * @throws BizException
	 */
	private List<PiPatContDO> setPatContWithParent(EnHosPatDTO enhosPatDTO) throws BizException {
		int sortNo = 0;
		if (!EnValidator.isEmpty(enhosPatDTO.getId_pat())) {
			PatEP patep = new PatEP();
			// 查到父母联系人并删除
			PiPatContDO[] patConts = patep.getParentContDO(enhosPatDTO.getId_pat());
			if (!EnValidator.isEmpty(patConts)) {
				IPiPatContDOCudService cmdService = ServiceFinder.find(IPiPatContDOCudService.class);
				cmdService.delete(patConts);
			}
			// 查找最大的排序号
			PiPatContDO[] patConts1 = patep.getContDO(enhosPatDTO.getId_pat());
			if (!EnValidator.isEmpty(patConts1)) {
				for (PiPatContDO contDO : patConts1) {
					if (contDO.getSortno() != null && contDO.getSortno() > sortNo) {
						sortNo = contDO.getSortno();
					}
				}
			}
		}
		// 创建母亲联系人
		List<PiPatContDO> ParContList = new ArrayList<PiPatContDO>();
		if (!(EnValidator.isEmpty(enhosPatDTO.getName_patcontref())
				&& EnValidator.isEmpty(enhosPatDTO.getConttel())
				&& EnValidator.isEmpty(enhosPatDTO.getContaddr())
				&& EnValidator.isEmpty(enhosPatDTO.getZip_cont()))) {
			PiPatContDO piContDO = new PiPatContDO();
			piContDO.setStatus(DOStatus.NEW);
			piContDO.setSortno(++sortNo);
			piContDO.setId_pat(enhosPatDTO.getId_pat());
			piContDO.setId_conttp(IPiDictCodeConst.ID_CONT_TYPE_PARENT);
			piContDO.setSd_conttp(IPiDictCodeConst.SD_CONT_TYPE_PARENT);
			piContDO.setName(enhosPatDTO.getName_patcontref());
			piContDO.setConttel(enhosPatDTO.getConttel());
			piContDO.setContaddr(enhosPatDTO.getContaddr());
			piContDO.setSd_fmrole(IPiDictCodeConst.SD_PARENT_MOTHER);
			piContDO.setId_fmrole(IPiDictCodeConst.ID_PARENT_MOTHER);
			piContDO.setZip(enhosPatDTO.getZip_cont());
			piContDO.setContid(enhosPatDTO.getId_cont());
			ParContList.add(piContDO);
		}
		// 创建父亲联系人
		if (!(EnValidator.isEmpty(enhosPatDTO.getName_patcontref2())
				&& EnValidator.isEmpty(enhosPatDTO.getConttel2())
				&& EnValidator.isEmpty(enhosPatDTO.getContaddr2())
				&& EnValidator.isEmpty(enhosPatDTO.getZip_cont2()))) {
			PiPatContDO piContDO2 = new PiPatContDO();
			piContDO2.setStatus(DOStatus.NEW);
			piContDO2.setSortno(++sortNo);
			piContDO2.setId_pat(enhosPatDTO.getId_pat());
			piContDO2.setId_conttp(IPiDictCodeConst.ID_CONT_TYPE_PARENT);
			piContDO2.setSd_conttp(IPiDictCodeConst.SD_CONT_TYPE_PARENT);
			piContDO2.setName(enhosPatDTO.getName_patcontref2());
			piContDO2.setConttel(enhosPatDTO.getConttel2());
			piContDO2.setContaddr(enhosPatDTO.getContaddr2());
			piContDO2.setSd_fmrole(IPiDictCodeConst.SD_PARENT_FATHER);
			piContDO2.setId_fmrole(IPiDictCodeConst.ID_PARENT_FATHER);
			piContDO2.setZip(enhosPatDTO.getZip_cont2());
			piContDO2.setContid(enhosPatDTO.getId_cont2());
			ParContList.add(piContDO2);
		}
		return ParContList;
	}

	/**
	 * 组装地址do
	 * 
	 * @param enhosPatDTO
	 * @throws BizException
	 */
	private List<PatiAddrDO> setPatAddrContent(EnHosPatDTO enhosPatDTO) throws BizException {
		List<PatiAddrDO> patAddrList = new ArrayList<PatiAddrDO>();
		if (!(EnValidator.isEmpty(enhosPatDTO.getId_admdiv()) && EnValidator.isEmpty(enhosPatDTO.getAddr_pat()) 
				&& EnValidator.isEmpty(enhosPatDTO.getPostcode_addr())
				&& EnValidator.isEmpty(enhosPatDTO.getTel_admdiv()))) {// 现住址
			PatiAddrDO patAddrDO_Now = this.setAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_NOW, enhosPatDTO.getId_pat(),
					false);
			patAddrDO_Now.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_NOW);
			patAddrDO_Now.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
			patAddrDO_Now.setId_admdiv(enhosPatDTO.getId_admdiv());
			patAddrDO_Now.setAdmdiv_fullname(enhosPatDTO.getName_admdiv());
			patAddrDO_Now.setSd_admdiv(enhosPatDTO.getSd_admdiv());
			patAddrDO_Now.setStreet(enhosPatDTO.getAddr_pat());
			patAddrDO_Now.setZip(enhosPatDTO.getPostcode_addr());
			patAddrDO_Now.setId_pat(enhosPatDTO.getId_pat());
			patAddrDO_Now.setTel(enhosPatDTO.getTel_admdiv());
			patAddrList.add(patAddrDO_Now);
		}else{
			PatiAddrDO patAddrDO_Now = this.setAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_NOW, enhosPatDTO.getId_pat(),
					true);
			if(patAddrDO_Now!=null){
				patAddrList.add(patAddrDO_Now);
			}
		}
		if (!(EnValidator.isEmpty(enhosPatDTO.getId_admdiv_resi())
				&& EnValidator.isEmpty(enhosPatDTO.getDetail_addr_resi())
				&& EnValidator.isEmpty(enhosPatDTO.getPostcode_resi()))) {// 户籍地址
			PatiAddrDO patAddrDO_cencus = this.setAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_CENCUS,
					enhosPatDTO.getId_pat(), false);
			patAddrDO_cencus.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_CENCUS);
			patAddrDO_cencus.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_CENCUS);
			patAddrDO_cencus.setId_admdiv(enhosPatDTO.getId_admdiv_resi());
			patAddrDO_cencus.setAdmdiv_fullname(enhosPatDTO.getName_admdiv_resi());
			patAddrDO_cencus.setSd_admdiv(enhosPatDTO.getSd_admdiv_resi());
			patAddrDO_cencus.setStreet(enhosPatDTO.getDetail_addr_resi());
			patAddrDO_cencus.setZip(enhosPatDTO.getPostcode_resi());
			patAddrDO_cencus.setId_pat(enhosPatDTO.getId_pat());
			patAddrList.add(patAddrDO_cencus);
		}else{
			PatiAddrDO patAddrDO_cencus = this.setAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_CENCUS,
					enhosPatDTO.getId_pat(), true);
			if(patAddrDO_cencus!=null)
			patAddrList.add(patAddrDO_cencus);
		}
		if (!(EnValidator.isEmpty(enhosPatDTO.getId_admdiv_work())
				&& EnValidator.isEmpty(enhosPatDTO.getDetail_addr_work())
				&& EnValidator.isEmpty(enhosPatDTO.getTel_work())
				&& EnValidator.isEmpty(enhosPatDTO.getPostcode_work()))) {// 工作地址
			PatiAddrDO patAddrDO_work = this.setAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_WORK,
					enhosPatDTO.getId_pat(), false);
			patAddrDO_work.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_WORK);
			patAddrDO_work.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_WORK);
			patAddrDO_work.setId_admdiv(enhosPatDTO.getId_admdiv_work());
			patAddrDO_work.setAdmdiv_fullname(enhosPatDTO.getName_admdiv_work());
			patAddrDO_work.setSd_admdiv(enhosPatDTO.getSd_admdiv_work());
			patAddrDO_work.setStreet(enhosPatDTO.getDetail_addr_work());
			patAddrDO_work.setZip(enhosPatDTO.getPostcode_work());
			patAddrDO_work.setId_pat(enhosPatDTO.getId_pat());
			patAddrDO_work.setTel(enhosPatDTO.getTel_work());
			patAddrList.add(patAddrDO_work);
		}else{
			PatiAddrDO patAddrDO_work = this.setAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_WORK,
					enhosPatDTO.getId_pat(), true);
			if(patAddrDO_work !=null)
			patAddrList.add(patAddrDO_work);
		}
		if (!EnValidator.isEmpty(enhosPatDTO.getId_nativeaddr())) {// 籍贯
			PatiAddrDO patAddrDO_orgin = this.setAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_ORIGIN,
					enhosPatDTO.getId_pat(), false);
			patAddrDO_orgin.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_ORIGIN);
			patAddrDO_orgin.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_ORIGIN);
			patAddrDO_orgin.setId_admdiv(enhosPatDTO.getId_nativeaddr());
			patAddrDO_orgin.setAdmdiv_fullname(enhosPatDTO.getName_nativeaddr());
			patAddrDO_orgin.setSd_admdiv(enhosPatDTO.getSd_nativeaddr());
			patAddrDO_orgin.setId_pat(enhosPatDTO.getId_pat());
			patAddrList.add(patAddrDO_orgin);
		}else{
			PatiAddrDO patAddrDO_orgin = this.setAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_ORIGIN,
					enhosPatDTO.getId_pat(), true);
			if(patAddrDO_orgin!=null)
			patAddrList.add(patAddrDO_orgin);
		}
		if (!EnValidator.isEmpty(enhosPatDTO.getId_birth_addr())) {// 出生地
			PatiAddrDO patAddrDO = this.setAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_BORN, enhosPatDTO.getId_pat(),
					false);
			patAddrDO.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_BORN);
			patAddrDO.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_BORN);
			patAddrDO.setId_admdiv(enhosPatDTO.getId_birth_addr());
			patAddrDO.setAdmdiv_fullname(enhosPatDTO.getName_birth_addr());
			patAddrDO.setSd_admdiv(enhosPatDTO.getSd_birth_addr());
			patAddrDO.setId_pat(enhosPatDTO.getId_pat());
			patAddrList.add(patAddrDO);
			
		}else{
			PatiAddrDO patAddrDO = this.setAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_BORN, enhosPatDTO.getId_pat(),
					true);
			if(patAddrDO!=null){
				patAddrList.add(patAddrDO);
			}
		}
		return patAddrList;
	}

	/**
	 * 得到pataddrdo 地址do
	 * 
	 * @param addrTypeID
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private PatiAddrDO setAddrDOStatus(String addrTypeID, String patId , boolean isDel) throws BizException {
		PatiAddrDO patAddrDO = null;
		IPatiAddrDORService addRService = ServiceFinder.find(IPatiAddrDORService.class);
		PatiAddrDO[] patAddrDOArr = addRService.find(PatiAddrDODesc.TABLE_ALIAS_NAME + ".id_pat ='" + patId + "' and "
				+ PatiAddrDODesc.TABLE_ALIAS_NAME + ".id_addrtp = '" + addrTypeID + "'", "", FBoolean.FALSE);
		if (EnValidator.isEmpty(patAddrDOArr)  ) {
			if (isDel)
				return null;
			patAddrDO = new PatiAddrDO();
			patAddrDO.setStatus(DOStatus.NEW);
			return patAddrDO;
		}

		patAddrDO = patAddrDOArr[0];
		if(isDel){
			patAddrDO.setStatus(DOStatus.DELETED);
			return patAddrDO;
		}
		patAddrDO.setStatus(DOStatus.UPDATED);
		return patAddrDO;
	}

	/**
	 * 
	 * @param enHosRegDTO
	 * @throws BizException 
	 */
	private void SetBedInfo(EnHosRegDTO enHosRegDTO, String sdPatsex) throws BizException{
		if(!EnValidator.isEmpty(enHosRegDTO.getId_bed())){
			return;
		}
		BedEP bedep = new BedEP();
		Bdbed bed = bedep.getRegistBedbyDep(enHosRegDTO.getId_dep_nuradm(), sdPatsex);
		enHosRegDTO.setId_bed(bed.getId_bed());
		enHosRegDTO.setBedname(bed.getName());
	}
	
	/**
	 * 保存就诊信息
	 * 
	 * @param enhosPatDTO
	 * @param enHosRegDTO
	 * @param pataggDO
	 * @throws BizException
	 */
	private void saveEntInfo(EnHosPatDTO enhosPatDTO, EnHosRegDTO enHosRegDTO, PatiAggDO pataggDO,
			InpatientDO inpatientDO) throws BizException {
		//0。判断是不是新患者
		FBoolean isNew = FBoolean.TRUE;
		if (enHosRegDTO.getStatus() != DOStatus.NEW){
			isNew = FBoolean.FALSE;
		}
		// 1、取得保存后的patdo
		PatDO patdo = pataggDO.getParentDO();
		// 2、取得保存后的pat
		List<PiPatContDO> patContList = this.getPatCont(pataggDO);

		// 3、设置pat的值
		enhosPatDTO.setId_pat(patdo.getId_pat());
		enHosRegDTO.setId_pat(patdo.getId_pat());
		//2、再次校验规则疫情
		this.checkIpRegRule(enhosPatDTO, enHosRegDTO);
		// 5、就诊数据保存
		PatiVisitDO patiVisitDO = this.SavePativisitData(enhosPatDTO, enHosRegDTO);
		// 6、住院数据保存
		inpatientDO=this.SaveInpatienttData(enHosRegDTO, patiVisitDO.getId_ent(), patdo, enhosPatDTO);
		// 7. 预住院
		this.saveEnIppreDO(enHosRegDTO, enhosPatDTO,inpatientDO);
		// 8、就诊医保数据保存
		this.SaveHealthInsuranceData(enHosRegDTO, patiVisitDO.getId_ent());
		// 9、患者医保数据保存
		this.savePiHp(enHosRegDTO);
		// 10、保存就诊联系人
		if (!EnValidator.isEmpty(patContList)) {
			this.SaveEntCont(patContList, patiVisitDO.getId_ent(), enhosPatDTO);
		}
		if (enHosRegDTO.getFg_ip() == null || !enHosRegDTO.getFg_ip().booleanValue()) {
			// 9、创建就诊账户
			this.SaveEnAccData(enHosRegDTO, patiVisitDO.getId_ent(), patiVisitDO.getId_pat());

			// 10、修改入院通知单信息
			this.updateIpntInfo(enHosRegDTO, patiVisitDO.getId_ent());
			enHosRegDTO.setSd_status(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN);
		}
		enHosRegDTO.setId_ent(patiVisitDO.getId_ent());
		//11.发送集成平台事件
		if (enHosRegDTO.getFg_ip() == null || !enHosRegDTO.getFg_ip().booleanValue()) {
			this.invoke(enHosRegDTO, patiVisitDO, inpatientDO, isNew);
		}
	}

	/**
	 * 登录住院数据
	 */
	private InpatientDO SaveInpatienttData(EnHosRegDTO enHosRegDTO, String entId, PatDO patdo, EnHosPatDTO enhosPatDTO) throws BizException {
		InpatientCrudServiceImpl inpatientService = new InpatientCrudServiceImpl();
		InpatientDO inpatientDO = new InpatientDO();
		inpatientDO.setStatus(DOStatus.NEW);
		String oldBedId = null;
		this.SetBedInfo(enHosRegDTO, patdo.getSd_sex());
		if (enHosRegDTO.getStatus() == DOStatus.UPDATED) {
			inpatientDO = this.getInPatientDO(entId);
			oldBedId = inpatientDO.getId_bed();
		}
		if(inpatientDO.getTimes_ip() == null || inpatientDO.getTimes_ip() == 0){
			inpatientDO.setTimes_ip(EnVisitTimesUtils.calcAdmIpTimes(patdo.getId_pat()));
		}
		inpatientDO.setCode_amr_ip(patdo.getCode_amr_ip());		
		inpatientDO.setId_ent(entId); // 就诊ID
		if (enHosRegDTO.getFg_ip() == null || !enHosRegDTO.getFg_ip().equals(FBoolean.TRUE)) {
			inpatientDO.setId_dep_phyadm(enHosRegDTO.getId_dep_phyadm()); // 入院科室
			inpatientDO.setId_dep_nuradm(enHosRegDTO.getId_dep_nuradm()); // 入院病区
		}
		//预住院
		if(enHosRegDTO.getFg_ippre() != null && enHosRegDTO.getFg_ippre().booleanValue()){
			inpatientDO.setFg_ippre(FBoolean.TRUE);
		}
		inpatientDO.setId_bed(enHosRegDTO.getId_bed()); // 选择的床位
		inpatientDO.setName_bed(enHosRegDTO.getBedname());
		inpatientDO.setFg_surg(new FBoolean(false)); // 是否手术标志
		inpatientDO.setFg_newborn(new FBoolean(false)); // 是否新生儿标志
		inpatientDO.setId_referalsrc(enHosRegDTO.getId_referalsrc()); // 来院方式ID
		inpatientDO.setSd_referalsrc(enHosRegDTO.getSd_referalsrc()); // 来院方式
		inpatientDO.setCont_name(enHosRegDTO.getCont_name()); // 主要联系人姓名
		inpatientDO.setCont_tel(enHosRegDTO.getConttel()); // 主要联系人电话
		inpatientDO.setId_diag_op(enHosRegDTO.getId_diag());
		inpatientDO.setDesc_diag_op(enHosRegDTO.getDesc_diag());// 保存诊断
		inpatientDO.setId_level_diseadm(enHosRegDTO.getId_level_diseadm());
		inpatientDO.setSd_level_diseadm(enHosRegDTO.getSd_level_diseadm());
		inpatientDO.setId_level_dise(enHosRegDTO.getId_level_diseadm());
		inpatientDO.setSd_level_dise(enHosRegDTO.getSd_level_diseadm());
		inpatientDO.setSd_pay_mothod(enhosPatDTO.getSd_pay_mothod());//付款方式
		inpatientDO.setSd_pe_psntp(enhosPatDTO.getSd_pe_psntp());//体检身份
		inpatientDO.setName_pe_intr(enhosPatDTO.getName_pe_intr());//介绍人
		inpatientDO.setTelno_mobapp(enhosPatDTO.getTelno_mobapp());//开通手机app
		inpatientDO.setFg_pe(enhosPatDTO.getFg_pe());//体检
		inpatientDO.setFg_mobapp(enhosPatDTO.getFg_mobapp());//开通手机app
		// 通过住院通知单入院的时候保存病情等级
		// this.SaveLevelDiseToIpnt(inpatientDO, enHosRegDTO.getId_ent_ipnt());
		if (enHosRegDTO.getFg_ip() == null || !enHosRegDTO.getFg_ip().booleanValue()) {
			inpatientDO.setSd_status(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN); // 就诊状态为住院
			// 更新床位信息
			updateBedData(enHosRegDTO.getId_ent(), oldBedId, enHosRegDTO.getId_bed(),enHosRegDTO.getId_ent_ipnt());
		}
		InpatientDO[] inpatients = inpatientService.save(new InpatientDO[] { inpatientDO });
		enHosRegDTO.setTimes(inpatientDO.getTimes_ip());
		if(EnValidator.isEmpty(inpatients)){
			return null;
		}
		return inpatients[0];
	}
	/**
	 * 调用规则引擎校验
	 * 
	 * @author liubin
	 * 
	 * @param enhosPatDTO
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	private void checkIpRegRule(EnHosPatDTO enhosPatDTO, EnHosRegDTO enHosRegDTO)throws BizException{
		RegRuleDTO regRule= new RegRuleDTO();
		regRule.setId_pat(enhosPatDTO.getId_pat());
		regRule.setId_dept(enHosRegDTO.getId_dep_phyadm());
		CheckIpRegitsRuleBP checkBp = new CheckIpRegitsRuleBP();
		checkBp.check(regRule, enHosRegDTO);
	}
	/**
	 * 保存转诊患者信息en_ent_hp_referal-zhangpp
	 * @param enHosRegDTO
	 * @throws BizException 
	 */
	private void SaveBiTransInfo(EnHosRegDTO enHosRegDTO) throws BizException{
		
		FArrayList list = enHosRegDTO.getOthers();	
		if (list == null || list.isEmpty() || list.size() == 0) {
			return;
		}
		EnHpReferralDO[] enHpDto = (EnHpReferralDO[])list.toArray();
		IEnhpreferralCudService iService = ServiceFinder.find(IEnhpreferralCudService.class);
		iService.save(enHpDto);
		
	}
	/**
	 * 设置患者分类
	 * 
	 * @param patdo
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	private void setPatPatCa(PatDO patdo, EnHosRegDTO enHosRegDTO) throws BizException {
		PiPatEP ep = new PiPatEP();
		if (EnValidator.isEmpty(patdo.getId_pat()) || EnParamUtils.isSyncPatCa()) {
			//患者分类可用于门诊
			if(FBoolean.TRUE.equals(ep.isMatchPatca(enHosRegDTO.getId_paticate(), IBdFcDictCodeConst.SD_CODE_ENTP_OP))){
				patdo.setId_paticate(enHosRegDTO.getId_paticate());
				patdo.setId_patpritp(enHosRegDTO.getId_pripat());// 价格分类
				patdo.setId_patcrettp(enHosRegDTO.getId_patcret());
			}
		}
		//患者中患者分类信息为空时取默认患者分类
		if(EnValidator.isEmpty(patdo.getId_paticate())){
			PiPatCaDO patcaDo = ep.getPatDefaultCate();
			patdo.setId_paticate(patcaDo.getId_patca());
            patdo.setId_patpritp(patcaDo.getId_patpritp());
            patdo.setId_patcrettp(patcaDo.getId_patcrettp());
		}
	}
	
	/**
	 * 保存预住院信息
	 * @param dto
	 * @param inpatientDO
	 * @return
	 * @throws BizException
	 */
	private void saveEnIppreDO(EnHosRegDTO dto,EnHosPatDTO patdto,InpatientDO inpatientDO) throws BizException{
		if(dto.getFg_ippre() == null || !dto.getFg_ippre().booleanValue()){
			return;
		}
		EnIppreDO enIppreDO = getEnIppreDOByIdEnt(inpatientDO.getId_ent());
		if(enIppreDO == null){
			enIppreDO = new EnIppreDO();
			enIppreDO.setStatus(DOStatus.NEW);
			enIppreDO.setSd_status(IEnDictCodeConst.SD_STATUS_IPPRE_HOS_ENTER);
			enIppreDO.setFg_valid(FBoolean.TRUE);
			enIppreDO.setFg_done_mt(FBoolean.FALSE);
			enIppreDO.setFg_done_anest(FBoolean.FALSE);
			enIppreDO.setFg_done_bed(FBoolean.FALSE);
			enIppreDO.setFg_done_dep(FBoolean.FALSE);
			enIppreDO.setFg_fp(FBoolean.FALSE);
		}else{
			enIppreDO.setStatus(DOStatus.UPDATED);
		}
		enIppreDO.setCode_pat(patdto.getCode_pat());
		enIppreDO.setId_ent(inpatientDO.getId_ent());
		enIppreDO.setId_ent_ip(inpatientDO.getId_inpatient());
		//IAptipMDORService aptRService = ServiceFinder.find(IAptipMDORService.class);
		//AptIpDO entIpntDO = aptRService.findById(dto.getId_ent_ipnt());
		enIppreDO.setId_dep_ward(dto.getId_dep_nur_target());//即预住院的目标科室,也就是申请单的入院科室
		enIppreDO.setId_dep_phy(dto.getId_dep_phy_target());
			
		//江苏需要填,标版暂时不知道从哪取
		/*enIppreDO.setCode_wg(dto.getCode_wg());
		BizGroupDO bizGroupDO = this.getBizGroupDOBycode(dto.getCode_wg());
		if(bizGroupDO !=null){
			enIppreDO.setId_wg(bizGroupDO.getId_wg());
		}*/
		IEnippreCudService cudService = ServiceFinder.find(IEnippreCudService.class);
		cudService.save(new EnIppreDO[]{enIppreDO});
	}
	
	private EnIppreDO getEnIppreDOByIdEnt(String id_ent) throws BizException{
		if(StringUtil.isEmpty(id_ent)){
			return null;
		}
		IEnippreRService enippreRService = ServiceFinder.find(IEnippreRService.class);
		EnIppreDO[] ippreDOs = enippreRService.find("id_ent='" +id_ent + "'","id_ent", FBoolean.FALSE);
		if (ArrayUtil.isEmpty(ippreDOs)) {
			EnLogUtil.getInstance().logError("未找到id_ent为："+id_ent+"的预住院信息");
			return null;
		}
		return ippreDOs[0];
	}
	
	/***
	 * @Description:记录就诊变更事件 患者分类事件变更
	 * @param isNew
	 * @param enhosPatDTO
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	private void saveEntChageEvt(FBoolean isNew,EnHosPatDTO enhosPatDTO,EnHosRegDTO enHosRegDTO) throws BizException{
		// 11、记录就诊变更事件 患者分类事件变更
		if(!isNew.booleanValue()&&  !enhosPatDTO.getId_patca().equals(enHosRegDTO.getId_paticate())){
			FDateTime curTime = EnAppUtils.getServerDateTime();
			EnEvtEP evtEP = new EnEvtEP();
			EnEvtDTO enEvtDO = new EnEvtDTO();
			enEvtDO.setStatus(DOStatus.NEW);
			enEvtDO.setId_ent(enHosRegDTO.getId_ent());
			enEvtDO.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_PATCACHG);
			enEvtDO.setShort_des("修改患者分类");
			enEvtDO.setDes("患者编码："+enhosPatDTO.getCode_pat()+" 患者分类修改前："+enhosPatDTO.getId_patca()+" 患者分类修改后："+enHosRegDTO.getId_paticate()+"");
			enEvtDO.setDt_evt(curTime);
			enEvtDO.setDt_insert(curTime);
			enEvtDO.setId_emp_rec(EnContextUtils.getPsnId());		
			enEvtDO.setVal_old(enhosPatDTO.getId_patca());
			enEvtDO.setVal_new(enHosRegDTO.getId_paticate());
			evtEP.insertEvt(new  EnEvtDTO[]{enEvtDO});
		}
	}
	
	/***
	 * @Description:发送集成平台事件
	 * @param enHosRegDTO
	 * @param patiVisitDO
	 * @param inpatientDO
	 * @param isNew
	 */
	private void invoke(EnHosRegDTO enHosRegDTO,PatiVisitDO patiVisitDO,InpatientDO inpatientDO,FBoolean isNew){
		try {
			RegEventBP regBp = new RegEventBP();
			regBp.invokeIpRegEvent(enHosRegDTO, patiVisitDO, inpatientDO,isNew);
		} catch (Exception ex) {
			Logger.error("入院登记消息发送失败：", ex);
		}
	}
}
