package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.PiPatEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.OpBasic4EditDTO;
import iih.en.pv.pativisit.d.EuEntContTp;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.s.out.bp.SaveIpntToChisBP;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.d.desc.PiPatHpDODesc;
import iih.pi.reg.pat.i.IPatiAddrDOCudService;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pat.i.IPiPatHpDORService;
import iih.sc.apt.aptip.d.AptIpAttrDO;
import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.aptip.i.IAptIpAttrDOCudService;
import iih.sc.apt.aptip.i.IAptipMDOCudService;
import iih.sc.apt.aptip.i.IAptipMDORService;
import iih.sc.apt.dto.d.AptIpDTO;

import java.sql.SQLException;
import java.util.ArrayList;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存入院通知单
 * 
 * @author renying
 */
public class SaveEntIpntBP {
	/**
	 * 保存入院通知单
	 * 
	 * @param aptIpDTO
	 *            住院通知单dto
	 * @param isDiagEnd
	 *            是否需要诊毕
	 * @author renying
	 * @throws SQLException 
	 */
	public void exec(AptIpDTO aptIpDTO, Boolean isDiagEnd) throws BizException {
		//1、查找就诊信息
		PatiVisitDO patiVisitDO = this.getPativisitDO( aptIpDTO.getId_ent());
		//2.保存患者联系人，fanlq-2018.02.09  modified renying
		this.savePatCont(aptIpDTO);
		//3、更新现住址,籍贯
		this.saveAddr(aptIpDTO);
		//4.更新en_ent地址
		this.saveEnAddr(aptIpDTO, patiVisitDO);
		//5.保存入院申请单
	    this.saveIpnt(aptIpDTO, patiVisitDO);
	    //6.保存床位状况
		this.saveAptiPattiDO(aptIpDTO);
	}

	/**
	 * 保存入院申请单
	 * @param aptIpDTO
	 * @param patiVisitDO
	 * @throws BizException
	 */
	private void saveIpnt(AptIpDTO aptIpDTO,PatiVisitDO patiVisitDO) throws BizException{
		//1、查找现有的入院通知单
		AptIpDO entIpntDOs = this.getAptIpDO(aptIpDTO.getId_scaptip());
		if (entIpntDOs == null) {
			// 没有入院通知单，就诊do
			entIpntDOs = this.saveNewAptIp(aptIpDTO,  EnAppUtils.getServerDateTime(), patiVisitDO);
			if(EnParamUtils.getIsSysChis()){
				new SaveIpntToChisBP().exec(aptIpDTO, false);
			}
		} else {
			 this.dataValidaor(entIpntDOs.getSd_status());
			 IpEP ipep = new IpEP();
			 ipep.validateInpatientDO(patiVisitDO.getId_pat());
			// 更新入院通知单
			entIpntDOs = this.updateAptIpDO(entIpntDOs, aptIpDTO,  EnAppUtils.getServerDateTime());
			
			if(EnParamUtils.getIsSysChis()){
				new SaveIpntToChisBP().exec(aptIpDTO, true);
			}
		}	
	}
	/**
	 * 获取就诊do
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO getPativisitDO(String entId) throws BizException {
		PvEP pvep = new PvEP();
		PatiVisitDO patiVisitDO = pvep.getPvById(entId);
		if (patiVisitDO == null) {
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_EXIST);
		}
		return patiVisitDO;
	}

	/**
	 * 获取当前的入院通知单
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private AptIpDO getAptIpDO(String aptIpId) throws BizException {
		if(EnValidator.isEmpty(aptIpId))
			return null;
		IAptipMDORService aptRService = ServiceFinder.find(IAptipMDORService.class);
		AptIpDO aptIpDO = aptRService.findById(aptIpId);
		return aptIpDO;

	}

	/**
	 * 更新住院通知单
	 * 
	 * @param aptipDO
	 * @param entipntDTO
	 * @param curTime
	 * @return
	 * @throws BizException
	 */
	private AptIpDO updateAptIpDO(AptIpDO aptipDO, AptIpDTO entipntDTO, FDateTime curTime) throws BizException {
		IAptipMDOCudService aptRService = ServiceFinder.find(IAptipMDOCudService.class);
		aptipDO.setSd_level_dise(entipntDTO.getSd_level_dise());
		aptipDO.setId_level_dise(entipntDTO.getId_level_dise());
		aptipDO.setId_dep_phy_ip(entipntDTO.getId_dep_phy_ip());
		aptipDO.setId_dep_nur_ip(entipntDTO.getId_dep_nur_ip());
		aptipDO.setId_didef_op(entipntDTO.getId_didef_op());
		aptipDO.setName_didef_op(entipntDTO.getName_didef_op());
		aptipDO.setSupplement_di(entipntDTO.getSupplement_di());
		if(entipntDTO.getDt_admit_plan() != null){
			aptipDO.setDt_admit_plan(new FDateTime(entipntDTO.getDt_admit_plan().toDate()));
		}
		aptipDO.setAmt_deposit(entipntDTO.getAmt_deposit());
		aptipDO.setDa_notice(curTime);
		aptipDO.setFg_plan(entipntDTO.getFg_plan());
		aptipDO.setSd_status(IEnDictCodeConst.SD_STATUS_NOTICE_CREATE);
		aptipDO.setNote(entipntDTO.getNote());
		//入院申请单增加字段，fanlq-add-2018.02.05
		aptipDO.setFg_vip(entipntDTO.getFg_vip());//vip标志
		aptipDO.setSd_referalsrc(entipntDTO.getSd_referalsrc());//来院方式
		aptipDO.setId_referalsrc(entipntDTO.getId_referalsrc());//来院方式
		aptipDO.setName_cont_phy(entipntDTO.getName_cont_phy());//医生姓名
		aptipDO.setTel_cont_phy(entipntDTO.getTel_cont_phy());//医生电话
		
		//入院申请单增加字段，fanlq-add-2018.05.31
		aptipDO.setId_walkwith(entipntDTO.getId_walkwith());//送入方式
		aptipDO.setSd_walkwith(entipntDTO.getSd_walkwith());//送入方式
		aptipDO.setId_introducer(entipntDTO.getId_introducer());
		aptipDO.setId_patcont(entipntDTO.getId_patcont());
		
		aptipDO.setId_patca(entipntDTO.getId_patca());
		// 设置有效期
		FDateTime nowData = EnAppUtils.getServerDateTime();
		Integer days = EnParamUtils.getIpntValidTime();
		if (days != null && nowData != null) {
			aptipDO.setDt_valid(nowData.getDateTimeAfter(days));
		}
		aptipDO.setStatus(DOStatus.UPDATED);
		AptIpDO aptipDOs[] = aptRService.update(new AptIpDO[] { aptipDO });// 更新
		entipntDTO.setId_scaptip(aptipDOs[0].getId_aptip());
		return aptipDOs[0];
	}

	/**
	 * 保存新的住院通知单
	 * 
	 * @param aptIpDTO
	 * @param curTime
	 * @param patiVisitDO
	 * @return
	 * @throws BizException
	 */
	private AptIpDO saveNewAptIp(AptIpDTO aptIpDTO, FDateTime curTime, PatiVisitDO patiVisitDO) throws BizException {
		IAptipMDOCudService aptRService = ServiceFinder.find(IAptipMDOCudService.class);
		AptIpDO aptIpDO = new AptIpDO();

		// 检索患者信息
		IPatiMDORService patiRService = ServiceFinder.find(IPatiMDORService.class);
		PatDO patiInfo = patiRService.findById(patiVisitDO.getId_pat());
		if (patiInfo == null) {
			throw new BizException(IEnMsgConst.ERROR_PAT_NOT_EXIST);
		}
		
		// 检索医保信息
		IPiPatHpDORService patHPRService = ServiceFinder.find(IPiPatHpDORService.class);
		if (!EnValidator.isEmpty(patiVisitDO.getId_hp())) {
			String whereStr = String.format(PiPatHpDODesc.TABLE_ALIAS_NAME + ".id_pat='%s' and " + PiPatHpDODesc.TABLE_ALIAS_NAME + ".id_hp ='%s'", patiVisitDO.getId_pat(), patiVisitDO.getId_hp());
			PiPatHpDO[] piPatHpDOs = patHPRService.find(whereStr, null, FBoolean.TRUE);
			PiPatHpDO pihpDO;
			if (!EnValidator.isEmpty(piPatHpDOs)) {
				pihpDO = piPatHpDOs[0];
				aptIpDO.setCode_hp(pihpDO.getHp_code());
			}
		}
		aptIpDO.setId_ent(aptIpDTO.getId_ent());
		aptIpDO.setId_pat(patiVisitDO.getId_pat());
		aptIpDO.setName_pat(patiVisitDO.getName_pat());
		aptIpDO.setSd_sex_pat(patiVisitDO.getSd_sex_pat());
		aptIpDO.setId_sex_pat(patiVisitDO.getId_sex_pat());
		aptIpDO.setDt_brith_pat(patiVisitDO.getDt_birth_pat());
		aptIpDO.setId_hp(patiVisitDO.getId_hp());
		aptIpDO.setDt_insert(curTime);
		aptIpDO.setId_dep_op(aptIpDTO.getId_dep_op());
		aptIpDO.setName_dep_op(aptIpDTO.getName_dep_op());
		aptIpDO.setFg_canc(FBoolean.FALSE);
		aptIpDO.setFg_plan(aptIpDTO.getFg_plan());
		aptIpDO.setId_emp_phy_op(aptIpDTO.getId_emp_phy_op());
		aptIpDO.setName_emp_phy_op(aptIpDTO.getName_emp_phy_op());
		aptIpDO.setId_dep_nur_ip(aptIpDTO.getId_dep_nur_ip());
		if(!EnValidator.isEmpty(aptIpDTO.getId_patca())){
			aptIpDO.setId_patca(aptIpDTO.getId_patca());
		}else{
			aptIpDO.setId_patca(patiVisitDO.getId_patca());
		}
		aptIpDO.setId_org(EnContextUtils.getOrgId());
		aptIpDO.setId_grp(EnContextUtils.getGrpId());
		// 检索诊断信息
		aptIpDO.setId_dep_phy_ip(aptIpDTO.getId_dep_phy_ip());
		if (aptIpDTO.getDt_admit_plan() != null) {
			aptIpDO.setDt_admit_plan(new FDateTime(aptIpDTO.getDt_admit_plan().toDate()));
		}
		aptIpDO.setAmt_deposit(aptIpDTO.getAmt_deposit());
		aptIpDO.setNote(aptIpDTO.getNote());
		aptIpDO.setId_level_dise(aptIpDTO.getId_level_dise());
		aptIpDO.setSd_level_dise(aptIpDTO.getSd_level_dise());
		aptIpDO.setDa_notice(curTime);
		aptIpDO.setSd_status(IEnDictCodeConst.SD_STATUS_NOTICE_CREATE);// 设置通知单状态为通知单开立
		aptIpDO.setId_didef_op(aptIpDTO.getId_didef_op());
		aptIpDO.setName_didef_op(aptIpDTO.getName_didef_op());
		aptIpDO.setSupplement_di(aptIpDTO.getSupplement_di());
		//入院申请单增加字段，fanlq-add-2018.02.05
		aptIpDO.setFg_vip(aptIpDTO.getFg_vip());//vip标志
		aptIpDO.setSd_referalsrc(aptIpDTO.getSd_referalsrc());//来院方式
		aptIpDO.setId_referalsrc(aptIpDTO.getId_referalsrc());//来院方式
		aptIpDO.setName_cont_phy(aptIpDTO.getName_cont_phy());//医生姓名
		aptIpDO.setTel_cont_phy(aptIpDTO.getTel_cont_phy());//医生电话
		//入院申请单增加字段，fanlq-add-2018.05.31
		aptIpDO.setId_walkwith(aptIpDTO.getId_walkwith());//送入方式
		aptIpDO.setSd_walkwith(aptIpDTO.getSd_walkwith());//送入方式
		aptIpDO.setId_introducer(aptIpDTO.getId_introducer());
		aptIpDO.setId_patcont(aptIpDTO.getId_patcont());
		Integer validDays = EnParamUtils.getIpntValidTime();
		FDateTime nowData = EnAppUtils.getServerDateTime();
		if (validDays != null && nowData != null) {
			aptIpDO.setDt_valid(nowData.getDateTimeAfter(validDays));
		}
		aptIpDO.setDt_insert(curTime);
		aptIpDO.setStatus(DOStatus.NEW);
		AptIpDO entIpntDOs[] = aptRService.save(new AptIpDO[] { aptIpDO });
		aptIpDTO.setId_scaptip(entIpntDOs[0].getId_aptip());
		return entIpntDOs[0];
	}

	/**
	 * 保存床位状况
	 * 
	 * @param aptidDTO
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void saveAptiPattiDO(AptIpDTO aptidDTO) throws BizException {
		FArrayList fArrayAttrDOs = aptidDTO.getBedattrs();
		if (EnValidator.isEmpty(fArrayAttrDOs)) {
			return;
		}
		AptIpAttrDO[] aptIpDOs = (AptIpAttrDO[]) fArrayAttrDOs.toArray(new AptIpAttrDO[] {});
		for (AptIpAttrDO aptIpAttrDO : aptIpDOs) {
			aptIpAttrDO.setId_aptip(aptidDTO.getId_scaptip());
			aptIpAttrDO.setId_grp(EnContextUtils.getGrpId());
			aptIpAttrDO.setId_org(EnContextUtils.getOrgId());
		}
		IAptIpAttrDOCudService aptIpService = ServiceFinder.find(IAptIpAttrDOCudService.class);
		aptIpService.save(aptIpDOs);
		return;
	}

	/**
	 * 保存地址
	 * 
	 * @param aptIpDTO  入院通知单DTO
	 * @throws BizException
	 */
	private void saveAddr(AptIpDTO aptIpDTO) throws BizException{
		ArrayList<PatiAddrDO> list = new ArrayList<>();
		//现住址
		if (!EnValidator.isEmpty(aptIpDTO.getId_admdiv())) {
			PatiAddrDO addrNow = new PiPatEP().getAndSetAddrDoStatus(IPiDictCodeConst.SD_ADDR_TYPE_NOW, aptIpDTO.getId_pat(), false);
			addrNow.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_NOW);
			addrNow.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
			addrNow.setId_admdiv(aptIpDTO.getId_admdiv());
			addrNow.setAdmdiv_fullname(aptIpDTO.getName_admdiv());
			addrNow.setSd_admdiv(aptIpDTO.getSd_admdiv());
			addrNow.setStreet(aptIpDTO.getAddr_pat());
			addrNow.setId_pat(aptIpDTO.getId_pat());
			list.add(addrNow);
		}
		//籍贯
		if (!EnValidator.isEmpty(aptIpDTO.getId_addr_origin())) {
			PatiAddrDO addrOrigin = new PiPatEP().getAndSetAddrDoStatus(IPiDictCodeConst.SD_ADDR_TYPE_ORIGIN, aptIpDTO.getId_pat(), false);
			addrOrigin.setId_pat(aptIpDTO.getId_pat());
			addrOrigin.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_ORIGIN);
			addrOrigin.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_ORIGIN);
			addrOrigin.setId_admdiv(aptIpDTO.getId_addr_origin());
			addrOrigin.setSd_admdiv(aptIpDTO.getSd_addr_origin());
			list.add(addrOrigin);
		}
		if (list.size() <= 0) {
			return;
		}
		//保存patiAggDo
		IPatiAddrDOCudService aptIpService = ServiceFinder.find(IPatiAddrDOCudService.class);
		aptIpService.save(list.toArray(new PatiAddrDO[0]));
	}
	
	/**
	 * 更新en_ent地址
	 * 
	 * @param apIpDTO
	 * @param patiVisitDO
	 * @throws BizException
	 */
	private void saveEnAddr(AptIpDTO apIpDTO, PatiVisitDO patiVisitDO) throws BizException {
		if (apIpDTO != null && patiVisitDO != null) {
			patiVisitDO.setAddr_pat(apIpDTO.getAddr_pat());
			patiVisitDO.setSd_admdiv_addr(apIpDTO.getSd_admdiv());
			patiVisitDO.setId_admdiv_addr(apIpDTO.getId_admdiv());
			patiVisitDO.setStatus(DOStatus.UPDATED);
			PvEP ep = new PvEP();
			ep.savePv(patiVisitDO);
		}
	}
	
	/**
	 * 如果单据不为申请状态，则抛出异常提示
	 * @throws BizException 
	 */
	private void dataValidaor(String status) throws BizException{
		if(!IEnDictCodeConst.SD_STATUS_NOTICE_CREATE.equals(status)){
			throw new BizException(IEnMsgConst.ERROR_SD_STATUS_STATUS);
		}		
	}
	/***
	 * 保存患者联系人
	 * 
	 * @author fanlq 
	 * @param aptIpDTO
	 * @throws BizException 
	 */
	private void savePatCont(AptIpDTO aptIpDTO) throws BizException{
		OpBasicInfoBP bp =new OpBasicInfoBP();
		OpBasic4EditDTO opBasicDTO = new OpBasic4EditDTO();
		opBasicDTO.setId_ent(aptIpDTO.getId_ent());
		opBasicDTO.setId_pat(aptIpDTO.getId_pat());
		opBasicDTO.setName_cont(aptIpDTO.getName_patcontref());
		opBasicDTO.setId_entcont(aptIpDTO.getId_entcont());
		opBasicDTO.setName_conttp(aptIpDTO.getName_conttp());
		opBasicDTO.setConttel(aptIpDTO.getConttel());
		opBasicDTO.setContaddr(aptIpDTO.getContaddr());
		opBasicDTO.setId_patcont(aptIpDTO.getId_patcont());
		opBasicDTO.setId_conttp(IPiDictCodeConst.ID_CONT_TYPE_OTHERS);
		opBasicDTO.setSd_conttp(IPiDictCodeConst.SD_CONT_TYPE_OTHERS);
		if(!EnValidator.isEmpty(aptIpDTO.getId_conttp())){
			opBasicDTO.setId_conttp(aptIpDTO.getId_conttp());
			opBasicDTO.setSd_conttp(aptIpDTO.getSd_conttp());			
		}
		// 保存就诊联系人
		opBasicDTO =bp.saveEntContInfo (opBasicDTO, EuEntContTp.CONTACT.intValue());
		if(!EnValidator.isEmpty(opBasicDTO.getId_patcont())){
			aptIpDTO.setId_patcont(opBasicDTO.getId_patcont());
		}
	}
}
