package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.bp.PatQryBP;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.EnAccEP;
import iih.en.comm.ep.EnCodeAmrIpEP;
import iih.en.comm.ep.EntContEP;
import iih.en.comm.ep.EntHpEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnHosRegDTO;
import iih.en.pv.inpatient.d.EntIpntDO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.dto.d.EnHosPatDTO;
import iih.en.pv.inpatient.i.IEnipntMDORService;
import iih.en.pv.inpatient.i.IInpatientCudService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.d.desc.PatiVisitDODesc;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.en.pv.s.bp.RegEventBP;
import iih.en.pv.s.out.bp.SaveCodeAmrIpToChisBp;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.i.IPatiCudService;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pat.i.IPatiRService;
import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.aptip.i.IAptipMDOCudService;
import iih.sc.apt.aptip.i.IAptipMDORService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;

/**
 * 入院登记
 * 
 * @author renying
 */
public class IPRegisterBP {

	/**
	 * 入院登记
	 * 
	 * @param patDTO
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	public EnHosRegDTO exec(EnHosPatDTO patDTO, EnHosRegDTO enHosRegDTO) throws BizException {
		
		//0、判断是不是新患者
		FBoolean isNew = FBoolean.TRUE;
		if (enHosRegDTO.getStatus() != DOStatus.NEW){
			isNew = FBoolean.FALSE;
		}
		// 1、校验数据
		ValidateIPDataBP vBP = new ValidateIPDataBP();
		InpatientDO inpatientDO = vBP.exec(patDTO, enHosRegDTO,new FBoolean(false));
		// 2、获取对应的pat信息
		PatiAggDO patAgg = this.getPatAggDO(patDTO.getId_pat());
		PatDO patdo = (PatDO) patAgg.getParentDO();
		// 3、就诊数据保存
		PatiVisitDO patiVisitDO = this.SavePativisitData(patDTO, enHosRegDTO);

		// 4、住院数据保存
		inpatientDO = this.SaveInpatienttData(enHosRegDTO, patiVisitDO.getId_ent(), patdo);
		// 5、就诊医保数据保存
		this.SaveHPData(enHosRegDTO, patiVisitDO.getId_ent());
		// 6、患者医保数据保存
		this.setPiHp(enHosRegDTO, patAgg);
		if (enHosRegDTO.getFg_ip() == null || !enHosRegDTO.getFg_ip().booleanValue()) {
			// 7、创建就诊账户
			this.SaveEnAccData(enHosRegDTO, patiVisitDO.getId_ent(), patiVisitDO.getId_pat());
		}
		// 8、患者信息婚姻状况、和住院号、和实名标志 修改
		this.setPiMarryInfo(patDTO, patdo, inpatientDO);
		// 9、 联系地址保存
		this.setAddrInfo(patDTO, patAgg);
		if (enHosRegDTO.getFg_ip() == null || !enHosRegDTO.getFg_ip().booleanValue()) {
			// 10、修改入院通知单信息
			this.updateIpntInfo(enHosRegDTO.getId_ent_ipnt(), patiVisitDO.getId_ent());
		}
		// 11、修改患者价格分类信用分类信息
		this.setPipritp(patdo, enHosRegDTO);
		// 12.更新患者联系人
		PiPatContDO pcont = this.setPatCont(patAgg, enHosRegDTO);
		// 13.保存吧患者agg
		patAgg = this.updatePatAgg(patAgg);
		this.getPatCont(patAgg, pcont);
		// 14.更新就诊信息中患者联系人信息
		this.SaveEntCont(pcont, patiVisitDO.getId_ent());
		// 15.触发住院登记事件
		try {
			RegEventBP regBp = new RegEventBP();
			regBp.invokeIpRegEvent(enHosRegDTO, patiVisitDO, inpatientDO, isNew);
		} catch (Exception ex) {

		}
		enHosRegDTO.setId_ent(patiVisitDO.getId_ent());
		return enHosRegDTO;
	}

	/**
	 * 获取patcontdo
	 * 
	 * @param pataggDO
	 * @return
	 */
	private PiPatContDO getPatCont(PatiAggDO pataggDO, PiPatContDO pcont) {
		if (pcont == null)
			return null;
		if (pataggDO.getPiPatContDO() != null) {
			PiPatContDO[] pipatConts = pataggDO.getPiPatContDO();
			for (PiPatContDO picontDO : pipatConts) {
				if (picontDO == pcont) {
					pcont = picontDO;
					break;
				}
			}
		}
		return pcont;
	}



	/**
	 * 查找患者agg
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private PatiAggDO getPatAggDO(String patId) throws BizException {
		IPatiRService rservice = ServiceFinder.find(IPatiRService.class);
		PatiAggDO patAgg = rservice.findById(patId);
		if (EnValidator.isEmpty(patAgg)) {
			throw new BizException(IEnMsgConst.ERROR_PAT_NOT_EXIST);
		}
		return patAgg;
	}

	/**
	 * 查找entdo
	 * 
	 * @param enHosRegDTO
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO getPatVisitDO(EnHosRegDTO enHosRegDTO) throws BizException {
		PatiVisitDO patiVisitDO = new PatiVisitDO();
		patiVisitDO.setStatus(DOStatus.NEW);
		if (EnValidator.isEmpty(enHosRegDTO.getId_ent())) {
			return patiVisitDO;
		}
		PvEP pvep = new PvEP();
		patiVisitDO = pvep.getPvById(enHosRegDTO.getId_ent());
		if (patiVisitDO == null) {
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_EXIST);
		}
		patiVisitDO.setStatus(DOStatus.UPDATED);
		return patiVisitDO;
	}

	/**
	 * 根据entid获取住院do
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private InpatientDO getInPatientDO(String entId) throws BizException {
		IpEP ipep = new IpEP();
		InpatientDO[] ipDOs = ipep.getIpDOByEntId(entId);
		InpatientDO inpatientDO = ipDOs[0];
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
	 * 更新住院通知单
	 * 
	 * @param ipntId
	 *            入院通知单ID
	 * @param entIpId
	 *            住院就诊ID，PV的id_ent
	 * @throws BizException
	 */
	private void updateIpntInfo(String ipntId, String entIpId) throws BizException {
		// 由入院通知单转入的时候
		if (EnValidator.isEmpty(ipntId)) {
			return;
		}
		IAptipMDOCudService aptcudService = ServiceFinder.find(IAptipMDOCudService.class);
		IAptipMDORService aptRService = ServiceFinder.find(IAptipMDORService.class);
		AptIpDO entIpntDO = aptRService.findById(ipntId);
		entIpntDO.setStatus(DOStatus.UPDATED);
		entIpntDO.setSd_status(IEnDictCodeConst.SD_STATUS_NOTICE_INHOS);
		entIpntDO.setFg_emgstay(FBoolean.FALSE);// 急诊留观标识为false
		entIpntDO.setId_entip(entIpId);// 住院就诊ID
		aptcudService.update(new AptIpDO[] { entIpntDO });

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
	 * 更新患者agg
	 * 
	 * @param patiAggdo
	 * @throws BizException
	 */
	private PatiAggDO updatePatAgg(PatiAggDO patiAggdo) throws BizException {
		IPatiCudService cudService = ServiceFinder.find(IPatiCudService.class);
		PatiAggDO[] patAggs = cudService.save(new PatiAggDO[] { patiAggdo });
		return patAggs[0];
	}

	

	/**
	 * 设置患者联系人信息
	 * 
	 * @param patiAggdo
	 * @param enhosreg
	 * @return
	 */
	private PiPatContDO setPatCont(PatiAggDO patiAggdo, EnHosRegDTO enhosreg) {

		if (EnValidator.isEmpty(enhosreg.getCont_name()) && EnValidator.isEmpty(enhosreg.getName_conttp()) && EnValidator.isEmpty(enhosreg.getConttel()) && EnValidator.isEmpty(enhosreg.getContaddr()))
			return null;// 如果患者姓名、类型、电话、地址都为空，就返回空
		PiPatContDO piContDO = null;
		int sortNo = 0;
		PiPatContDO[] patConts = patiAggdo.getPiPatContDO();
		if (!EnValidator.isEmpty(patConts)) {
			for (PiPatContDO contDO : patConts) {
				if (!EnValidator.isEmpty(enhosreg.getId_patcont())) {
					if (contDO.getId_patcont().equals(enhosreg.getId_patcont())) {
						piContDO = contDO;
						piContDO.setStatus(DOStatus.UPDATED);
					}
				}
				if (contDO.getSortno() != null && contDO.getSortno() > sortNo) {
					sortNo = contDO.getSortno();
				}
			}
		}
		if (piContDO == null) {
			piContDO = new PiPatContDO();
			piContDO.setStatus(DOStatus.NEW);
			piContDO.setSortno(sortNo + 1);
		}

		piContDO.setId_pat(enhosreg.getId_pat());
		piContDO.setId_conttp(enhosreg.getId_conttp());
		piContDO.setSd_conttp(enhosreg.getSd_conttp());
		// piContDO.setName(enhosreg.getCont_name());
		piContDO.setName(enhosreg.getName_patcontref());
		piContDO.setConttel(enhosreg.getConttel());
		piContDO.setContaddr(enhosreg.getContaddr());

		if (piContDO.getStatus() == DOStatus.NEW) {
			patiAggdo.setPiPatContDO(new PiPatContDO[] { piContDO });
		}
		return piContDO;
	}

	/**
	 * 保存患者的婚姻状况 和住院号 和实名标志
	 * 
	 * @param enhosPatDTO
	 * @throws BizException
	 */
	private void setPiMarryInfo(EnHosPatDTO enhosPatDTO, PatDO patdo, InpatientDO inpateintDO) throws BizException {
		patdo.setId_marry(enhosPatDTO.getId_marry());
		patdo.setSd_marry(enhosPatDTO.getSd_marry());
		patdo.setMarry_name(enhosPatDTO.getName_marry());
		patdo.setFg_realname(FBoolean.TRUE);
		if (EnValidator.isEmpty(patdo.getCode_amr_ip())) {
			patdo.setCode_amr_ip(inpateintDO.getCode_amr_ip());
		}
		patdo.setStatus(DOStatus.UPDATED);
	}

	/**
	 * 更新患者的价格分类和信用分类
	 * 
	 * @param patdo
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	private void setPipritp(PatDO patdo, EnHosRegDTO enHosRegDTO) throws BizException {
		patdo.setId_patpritp(enHosRegDTO.getId_pripat());// 价格分类
		patdo.setId_patcrettp(enHosRegDTO.getId_patcret());// 信用分类
		patdo.setStatus(DOStatus.UPDATED);
	}

	/**
	 * 登录患者医保数据 如果主医保不存在，则不处理。 没有主医保，也肯定没有辅医保，辅医保依附主医保存在
	 * 
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	private void setPiHp(EnHosRegDTO enHosRegDTO, PatiAggDO patAgg) throws BizException {
		// 如果主医保不存在，则不处理。
		// 没有主医保，也肯定没有辅医保，辅医保依附主医保存在
		if (EnValidator.isEmpty(enHosRegDTO.getPrim_cplan())) {
			return;
		}
		PiPatHpDO[] piPatHpDOs = patAgg.getPiPatHpDO();

		PiPatHpDO mainHpDO = null;
		PiPatHpDO extraHpDO = null;
		int sortNo = -1;
		FBoolean hasMaj = FBoolean.FALSE;// 是否含有主医保
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
				} else if (!EnValidator.isEmpty(enHosRegDTO.getAuxi_cplan()) && enHosRegDTO.getAuxi_cplan().equals(piPatHpDO.getId_hp())) {
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
		FDateTime currentTime = EnAppUtils.getServerDateTime();
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
		List<PiPatHpDO> list = new ArrayList<PiPatHpDO>();
		if (mainHpDO != null && mainHpDO.getStatus() == DOStatus.NEW) {
			list.add(mainHpDO);
		}
		if (extraHpDO != null && extraHpDO.getStatus() == DOStatus.NEW) {
			list.add(extraHpDO);
		}
		if (!EnValidator.isEmpty(list)) {
			patAgg.setPiPatHpDO(list.toArray(new PiPatHpDO[] {}));
		}
	}

	/**
	 * 保存地址信息
	 * 
	 * @param enhosPatDTO
	 * @throws BizException
	 */
	private void setAddrInfo(EnHosPatDTO enhosPatDTO, PatiAggDO patAgg) throws BizException {
		PatiAddrDO[] patAddrDOArr = patAgg.getPatiAddrDO();
		
		PatiAddrDO patiAddr = new PatiAddrDO();
		patiAddr.setStatus(DOStatus.NEW);
		patiAddr.setId_pat(enhosPatDTO.getId_pat());	
		if (!EnValidator.isEmpty(patAddrDOArr)) {
			for (PatiAddrDO addrDo : patAddrDOArr) {
				if (addrDo.getId_addrtp() != null && addrDo.getId_addrtp().equals((IPiDictCodeConst.ID_ADDR_TYPE_NOW))) {
					patiAddr = addrDo;
					patiAddr.setStatus(DOStatus.UPDATED);
				}
			}
		} 		
		patiAddr.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_NOW);
		patiAddr.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
		patiAddr.setAdmdiv_code(enhosPatDTO.getSd_admdiv());
		patiAddr.setAdmdiv_fullname(enhosPatDTO.getName_admdiv());
		patiAddr.setId_admdiv(enhosPatDTO.getId_admdiv());
		patiAddr.setStreet(enhosPatDTO.getAddr_pat());
		if (patiAddr.getStatus() == DOStatus.NEW) {
			patAgg.setPatiAddrDO(new PatiAddrDO[] { patiAddr });
		}
	}

	/**
	 * 登录患者就诊数据
	 * 
	 * @param patDTO
	 * @param enHosRegDTO
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO SavePativisitData(EnHosPatDTO patDTO, EnHosRegDTO enHosRegDTO) throws BizException {

		IPativisitCudService pativisitCrudService = ServiceFinder.find(IPativisitCudService.class);
		PatiVisitDO patiVisitDO = this.getPatVisitDO(enHosRegDTO);
		if (patiVisitDO.getStatus() == DOStatus.NEW) {
			IBillcodeManage codeS1 = ServiceFinder.find(IBillcodeManage.class);
			String code_cg = codeS1.getPreBillCode_RequiresNew(PatiVisitDODesc.CLASS_FULLNAME);
			patiVisitDO.setCode(code_cg);
		}

		// 检索患者信息
		PatDO patiInfo = this.getPatDO(patDTO.getId_pat());

		patiVisitDO.setId_pat(patiInfo.getId_pat());
		patiVisitDO.setCode_entp(IBdFcDictCodeConst.ID_CODE_ENTP_IP); // 就诊类型ID
		patiVisitDO.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_IP); // 就诊类型
		// 更新患者信息
		patiVisitDO.setName_pat(patiInfo.getName());
		patiVisitDO.setId_sex_pat(patiInfo.getId_sex());
		patiVisitDO.setSd_sex_pat(patiInfo.getSd_sex());

		patiVisitDO.setId_patca(patDTO.getId_patca());

		patiVisitDO.setSd_mari_pat(patDTO.getSd_marry());
		patiVisitDO.setId_mari_pat(patDTO.getId_marry());

		patiVisitDO.setDt_birth_pat(patiInfo.getDt_birth());
		patiVisitDO.setTelno_pat(patiInfo.getTel());

		PatQryBP patqryBp = new PatQryBP();
		patiVisitDO.setAddr_pat(patqryBp.getPresentAddress(patiInfo.getId_pat())); // 地址

		// 更新就诊信息
		patiVisitDO.setDt_entry(enHosRegDTO.getDt_entry()); // 就诊登记日期时间
		if(patiVisitDO.getFg_acptvalid()==null){
			patiVisitDO.setFg_acptvalid(new FBoolean(false)); // 接诊有效,只有空的时候才赋值，否则会导致，有权限修改在院信息时把标识置为无效
		}	
		patiVisitDO.setId_dep_phy(enHosRegDTO.getId_dep_phyadm()); // 当前就诊科室
		patiVisitDO.setId_dep_nur(enHosRegDTO.getId_dep_nuradm()); // 当前护理单位(病区)
		patiVisitDO.setId_emp_entry(enHosRegDTO.getId_emp()); // 登记人员
		patiVisitDO.setId_hp(enHosRegDTO.getPrim_cplan()); // 主医保计划
		patiVisitDO.setId_patca(patiInfo.getId_paticate()); // 患者分类
		patiVisitDO.setId_pripat(enHosRegDTO.getId_pripat()); // 价格分类
		patiVisitDO.setId_patcret(enHosRegDTO.getId_patcret()); // 信用分类
		patiVisitDO.setFg_st(FBoolean.FALSE); // 结算标志

		patiVisitDO.setFg_flup(FBoolean.FALSE); // 随访标志
		patiVisitDO.setFg_canc(FBoolean.FALSE); // 退诊标志
		patiVisitDO.setFg_data_transf(FBoolean.FALSE);// 可转移标识
		patiVisitDO.setId_entp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);// 就诊类型

		// 地址信息
		patiVisitDO.setCode_addr(patDTO.getSd_admdiv());
		patiVisitDO.setName_addr(patDTO.getName_admdiv());
		patiVisitDO.setId_admdiv_addr(patDTO.getId_admdiv());
		patiVisitDO.setAddr_pat(patDTO.getAddr_pat());
		patiVisitDO.setSd_admdiv_addr(patDTO.getSd_admdiv());

		// 其它信息
		patiVisitDO.setId_org(EnContextUtils.getOrgId());
		patiVisitDO.setId_grp(EnContextUtils.getGrpId());
		if (enHosRegDTO.getFg_ip() == null || !enHosRegDTO.getFg_ip().booleanValue()) {
			FDateTime curTime = EnAppUtils.getServerDateTime();
			patiVisitDO.setDt_insert(curTime);
			patiVisitDO.setFg_ip(FBoolean.FALSE); // 在院标志
		}
		return pativisitCrudService.save(new PatiVisitDO[] { patiVisitDO })[0];
	}

	/**
	 * 登录住院数据
	 * 
	 * @param enHosRegDTO
	 * @param entId
	 * @throws BizException
	 */
	private InpatientDO SaveInpatienttData(EnHosRegDTO enHosRegDTO, String entId, PatDO patdo) throws BizException {

		IInpatientCudService inpatientService = ServiceFinder.find(IInpatientCudService.class);
		InpatientDO inpatientDO = new InpatientDO();
		inpatientDO.setStatus(DOStatus.NEW);
		String oldBedId = null;

		if (!EnValidator.isEmpty(enHosRegDTO.getId_ent())) {
			inpatientDO = this.getInPatientDO(entId);
			oldBedId = inpatientDO.getId_bed();
			inpatientDO.setStatus(DOStatus.UPDATED);
		}
		if (!EnValidator.isEmpty(patdo.getCode_amr_ip())) {
			inpatientDO.setCode_amr_ip(patdo.getCode_amr_ip());
			if (EnParamUtils.getIsSysChis()) {
				SaveCodeAmrIpToChisBp bp = new SaveCodeAmrIpToChisBp();
				bp.exec(patdo, FBoolean.TRUE.booleanValue());
			}
		} else {
			inpatientDO.setCode_amr_ip(new EnCodeAmrIpEP().createIpAmrCode());
			if (EnParamUtils.getIsSysChis()) {
				SaveCodeAmrIpToChisBp bp = new SaveCodeAmrIpToChisBp();
				bp.exec(patdo, FBoolean.TRUE.booleanValue());
			}
		}

		inpatientDO.setTimes_ip(enHosRegDTO.getTimes());
		inpatientDO.setId_ent(entId); // 就诊ID
		inpatientDO.setId_dep_phyadm(enHosRegDTO.getId_dep_phyadm()); // 入院科室
		inpatientDO.setId_dep_nuradm(enHosRegDTO.getId_dep_nuradm()); // 入院病区
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

		// 通过住院通知单入院的时候保存病情等级
		// this.SaveLevelDiseToIpnt(inpatientDO, enHosRegDTO.getId_ent_ipnt());

		if (!EnValidator.isEmpty(enHosRegDTO.getId_ent_ipnt())) {
			IEnipntMDORService ipntMDOService = ServiceFinder.find(IEnipntMDORService.class);
			EntIpntDO entIpntDO = ipntMDOService.findById(enHosRegDTO.getId_ent_ipnt());
			if (entIpntDO != null) {
				inpatientDO.setSd_level_dise(entIpntDO.getSd_status_pat()); // 住院通知单中的病情状况
				inpatientDO.setId_level_dise(entIpntDO.getId_status_pat());
				inpatientDO.setId_level_diseadm(entIpntDO.getSd_status_pat());
				inpatientDO.setSd_level_diseadm(entIpntDO.getId_status_pat());
			}

		}
		if (enHosRegDTO.getFg_ip() == null || !enHosRegDTO.getFg_ip().booleanValue()) {
			inpatientDO.setSd_status(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN); // 就诊状态为住院
			updateBedData(enHosRegDTO.getId_ent(), oldBedId, enHosRegDTO.getId_bed(),enHosRegDTO.getId_ent_ipnt());
		}

		// 更新床位信息
		InpatientDO[] inpatients = inpatientService.save(new InpatientDO[] { inpatientDO });
		return inpatients[0];
	}

	/**
	 * 保存entcont
	 * 
	 * @param picontDO
	 * @param entId
	 * @throws BizException
	 */
	private void SaveEntCont(PiPatContDO picontDO, String entId) throws BizException {
		EntContEP entContEP = new EntContEP();
		entContEP.SaveEntCont(picontDO, entId);
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
	 * @param enHosRegDTO
	 * @param entId
	 * @throws BizException
	 */
	private void SaveHPData(EnHosRegDTO enHosRegDTO, String entId) throws BizException {
		EntHpEP entHpEp = new EntHpEP();
		entHpEp.deleteByEntId(entId);
		entHpEp.saveEntHp(entId, enHosRegDTO.getPrim_cplan(), enHosRegDTO.getCode_hp(), enHosRegDTO.getAuxi_cplan(), enHosRegDTO.getCode_hp2());
	}

	

	
}
