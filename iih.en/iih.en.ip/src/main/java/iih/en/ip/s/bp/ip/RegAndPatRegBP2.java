package iih.en.ip.s.bp.ip;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.res.bed.d.Bdbed;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.EnCodeAmrIpEP;
import iih.en.comm.ep.EntContEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.PatEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnCodeUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.ip.dto.d.EnHosRegInfoDTO;
import iih.en.pv.dto.d.EnHosRegDTO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.dic.patientcategory.i.IPatientcategoryRService;
import iih.pi.reg.i.IPiRegMaintainService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.d.desc.PatiAddrDODesc;
import iih.pi.reg.pat.i.IPatiAddrDORService;
import iih.pi.reg.pat.i.IPatiMDOCudService;
import iih.pi.reg.pat.i.IPatiMDORService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class RegAndPatRegBP2 {
	
	/**
	 * 入院登记（含患者注册）
	 * 
	 * @param patDTO
	 *            患者信息
	 * @param enHosRegDTO
	 *            入院登记DTO
	 */
	public void exec(EnHosRegInfoDTO enHosRegInfoDTO, PatiAggDO patiAggDO) throws BizException {
		boolean hasBed = !EnValidator.isEmpty(enHosRegInfoDTO.getId_bed());
		// 1、校验数据
		ValidateIPDataBP2 vBP = new ValidateIPDataBP2();
		InpatientDO inpatientDO = vBP.exec(enHosRegInfoDTO,new FBoolean(true));
		// 3、就诊信息保存
		this.saveEntInfo(enHosRegInfoDTO, patiAggDO,inpatientDO, hasBed);
		// 5、回写患者医保登记信息
		//this.setHpEntCodeAh(enhosreginfodto);
		//return enHosRegDTO;
	}

	
	/**
	 * 保存患者信息
	 * 
	 * @param enhosPatDTO
	 * @param enHosRegDTO
	 * @return
	 * @throws BizException
	 */
	public PatiAggDO savePatInfo(EnHosRegInfoDTO enHosRegInfoDTO) throws BizException{
		PatEP ep = new PatEP();
		ep.updateSdCodeTp2Others(enHosRegInfoDTO.getId_pat(),enHosRegInfoDTO.getSd_idtp(),enHosRegInfoDTO.getId_code());
		//2.得到patdo，取出旧患者，新建新患者
		 PatDO patDO = this.setPatDOStatus(enHosRegInfoDTO); 
		//3.组装patdo
		 this.setPatDOContent(patDO,enHosRegInfoDTO);
		//4.得到pataddrdo 地址do//组装pataddrDO
		List<PatiAddrDO> addrlist = setPatAddrContent(enHosRegInfoDTO);
		//5.组装patcontDO 患者联系人
		List<PiPatContDO> patContDOList = null;
		patContDOList = this.setPatContContent(enHosRegInfoDTO);
		//6.组装aggdo
		PatiAggDO patiAggDO = new PatiAggDO();
		patiAggDO.setParent(patDO);
		patiAggDO.setPatiAddrDO(addrlist.toArray(new PatiAddrDO[]{}));
		if (!EnValidator.isEmpty(patContDOList)) {
			patiAggDO.setPiPatContDO(patContDOList.toArray(new PiPatContDO[]{}));
		}
		//保存aggdo
		IPiRegMaintainService patiService = ServiceFinder.find(IPiRegMaintainService.class);
		patiAggDO = patiService.savePatForHosReg(patiAggDO);
		return patiAggDO;
	}
	/**
	 * 得到patdo 旧患者取出 新患者新建
	 * 
	 * @param patDTO
	 * @return
	 * @throws BizException
	 */
	private PatDO setPatDOStatus(EnHosRegInfoDTO enHosRegInfoDTO) throws BizException {
		PatDO patdo;
		if (EnValidator.isEmpty(enHosRegInfoDTO.getId_pat())) {// 如果没有patid，新增患者
			patdo = new PatDO();
			patdo.setStatus(DOStatus.NEW);
		} else {
			patdo = this.getPatDO(enHosRegInfoDTO.getId_pat());
			patdo.setStatus(DOStatus.UPDATED);
		}
		return patdo;
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
	 * 组装patdo
	 * 
	 * @param patdo
	 * @param enHosRegInfoDTO
	 * @throws BizException
	 */
	private void setPatDOContent(PatDO patdo, EnHosRegInfoDTO enHosRegInfoDTO) throws BizException {
		if (patdo.getStatus() == DOStatus.NEW) {
			patdo.setCode(EnCodeUtils.createPatCode());
			if(this.IsChangePatCate(enHosRegInfoDTO.getId_patca())){
				patdo.setId_paticate(enHosRegInfoDTO.getId_patca());
	            patdo.setId_patpritp(enHosRegInfoDTO.getId_pripat());// 价格分类
	            patdo.setId_patcrettp(enHosRegInfoDTO.getId_patcret());//信用分类
			}else{
				PiPatCaDO patcaDo = this.GetDefaultPatCa();
				patdo.setId_paticate(patcaDo.getId_patca());
	            patdo.setId_patpritp(patcaDo.getId_patpritp());
	            patdo.setId_patcrettp(patcaDo.getId_patcrettp());
			}
		}
	
		if (EnValidator.isEmpty(patdo.getCode_amr_ip()) || (EnValidator.isEmpty(enHosRegInfoDTO.getId_ent())&&(EnParamUtils.getIsChangeIpCode()))) {
			patdo.setCode_amr_ip(new EnCodeAmrIpEP().createIpAmrCode());
			EnLogUtil.getInstance().logInfo("住院号生成：患者id"+patdo.getId_pat()+ " 住院号变成:"+patdo.getCode_amr_ip());
		}

		patdo.setFg_realname(FBoolean.TRUE);
		patdo.setName(enHosRegInfoDTO.getName_pat());

		patdo.setId_grp(EnContextUtils.getGrpId());
		patdo.setId_org(EnContextUtils.getOrgId());

		patdo.setId_sex(enHosRegInfoDTO.getId_sex());// 性别
		patdo.setSd_sex(enHosRegInfoDTO.getSd_sex());
		patdo.setName_sex(enHosRegInfoDTO.getName_sex());

		patdo.setId_idtp(enHosRegInfoDTO.getId_idtp());// 证件类型
		patdo.setSd_idtp(enHosRegInfoDTO.getSd_idtp());
		patdo.setIdtp_name(enHosRegInfoDTO.getName_idtp());// 证件号码
		patdo.setId_code(enHosRegInfoDTO.getId_code());

		patdo.setDt_birth(enHosRegInfoDTO.getDt_birth());
		patdo.setDt_birth_hms(enHosRegInfoDTO.getDt_birth_hms());//出生日期 时分秒 - zhangpp
		
		patdo.setId_marry(enHosRegInfoDTO.getId_marry());
		patdo.setSd_marry(enHosRegInfoDTO.getSd_marry());
		patdo.setMarry_name(enHosRegInfoDTO.getName_marry());

		patdo.setTel(enHosRegInfoDTO.getTel());// 电话
		patdo.setMob(enHosRegInfoDTO.getMob());// 移动电话

		if (EnValidator.isEmpty(enHosRegInfoDTO.getId_nation())) {
			patdo.setId_nation("@@@@AA1000000000MHM3");
			patdo.setNation_name("其他");
			patdo.setSd_nation("97");
		} else {
			patdo.setId_nation(enHosRegInfoDTO.getId_nation());// 民族
			patdo.setNation_name(enHosRegInfoDTO.getName_nation());
			patdo.setSd_nation(enHosRegInfoDTO.getSd_nation());
		}

		patdo.setId_country(enHosRegInfoDTO.getId_country()); // 国籍
		patdo.setCountry_name(enHosRegInfoDTO.getName_country());
		patdo.setSd_country(enHosRegInfoDTO.getSd_country());

		patdo.setWbcode(EnAppUtils.getWbCode(patdo.getName()));
		patdo.setPycode(EnAppUtils.getPyCode(patdo.getName()));
		patdo.setMnecode(patdo.getCode());
		patdo.setId_occu(enHosRegInfoDTO.getId_occu());
		patdo.setSd_occu(enHosRegInfoDTO.getSd_occu());
		patdo.setPhoto(enHosRegInfoDTO.getPhoto());
		patdo.setWorkunit(enHosRegInfoDTO.getWorkunit());
		patdo.setId_marry(enHosRegInfoDTO.getId_marry());//婚姻状况,fanlq-2018-05-26
		patdo.setSd_marry(enHosRegInfoDTO.getSd_marry());
		if(!EnValidator.isEmpty(enHosRegInfoDTO.getBarcode_chis())){
			patdo.setBarcode_chis(enHosRegInfoDTO.getBarcode_chis());
		}
		//2017/1/10 ly 设置域id
		patdo.setDomain(IPiDictCodeConst.DOMAIN_ID_ZY);
		
		patdo.setFg_sync_en(FBoolean.TRUE);
	}

	/**
	 * 新建患者是否修改患者分类
	 * @param patdo
	 * @throws BizException 
	 */
	private boolean  IsChangePatCate(String patCate) throws BizException{
		EnValidator.validateParam("IsChangePatCate","patCaId",patCate);
		IPatientcategoryRService rService = ServiceFinder.find(IPatientcategoryRService.class);
		PiPatCaDO cado = rService.findById(patCate);
		if(cado.getFg_op()!=null && cado.getFg_op().booleanValue()){
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @throws BizException
	 */
	private PiPatCaDO GetDefaultPatCa() throws BizException{
		PiPatCaDO cado =new PatEP().getPatDefaultCate();
		EnValidator.validateParam("GetDefaultPatCa","patCaId",cado);
		return cado;		
	}
	/**
	 * 组装地址do
	 * 
	 * @param enHosRegInfoDTO
	 * @throws BizException
	 */
	private List<PatiAddrDO> setPatAddrContent(EnHosRegInfoDTO enHosRegInfoDTO) throws BizException {
		List<PatiAddrDO> patAddrList = new ArrayList<PatiAddrDO>();
		if (!(EnValidator.isEmpty(enHosRegInfoDTO.getId_admdiv_now()) && EnValidator.isEmpty(enHosRegInfoDTO.getStreet_now()) 
				&& EnValidator.isEmpty(enHosRegInfoDTO.getZip_now())
				&& EnValidator.isEmpty(enHosRegInfoDTO.getTel_now()))) {
			// 现住址
			PatiAddrDO patAddrDO_Now = this.setAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_NOW, enHosRegInfoDTO.getId_pat(),
					false);
			patAddrDO_Now.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_NOW);
			patAddrDO_Now.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
			patAddrDO_Now.setId_admdiv(enHosRegInfoDTO.getId_admdiv_now());
			patAddrDO_Now.setAdmdiv_fullname(enHosRegInfoDTO.getName_admdiv_now());
			patAddrDO_Now.setSd_admdiv(enHosRegInfoDTO.getSd_admdiv_now());
			patAddrDO_Now.setStreet(enHosRegInfoDTO.getStreet_now());
			patAddrDO_Now.setZip(enHosRegInfoDTO.getZip_now());
			patAddrDO_Now.setId_pat(enHosRegInfoDTO.getId_pat());
			patAddrDO_Now.setTel(enHosRegInfoDTO.getTel_now());
			patAddrList.add(patAddrDO_Now);
		}else{
			PatiAddrDO patAddrDO_Now = this.setAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_NOW, enHosRegInfoDTO.getId_pat(),
					true);
			if(patAddrDO_Now!=null){
				patAddrList.add(patAddrDO_Now);
			}
		}
		if (!(EnValidator.isEmpty(enHosRegInfoDTO.getId_admdiv_resi())
				&& EnValidator.isEmpty(enHosRegInfoDTO.getStreet_resi())
				&& EnValidator.isEmpty(enHosRegInfoDTO.getZip_resi()))) {
			// 户籍地址
			PatiAddrDO patAddrDO_cencus = this.setAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_CENCUS,
					enHosRegInfoDTO.getId_pat(), false);
			patAddrDO_cencus.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_CENCUS);
			patAddrDO_cencus.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_CENCUS);
			patAddrDO_cencus.setId_admdiv(enHosRegInfoDTO.getId_admdiv_resi());
			patAddrDO_cencus.setAdmdiv_fullname(enHosRegInfoDTO.getName_admdiv_resi());
			patAddrDO_cencus.setSd_admdiv(enHosRegInfoDTO.getSd_admdiv_resi());
			patAddrDO_cencus.setStreet(enHosRegInfoDTO.getStreet_resi());
			patAddrDO_cencus.setZip(enHosRegInfoDTO.getZip_resi());
			patAddrDO_cencus.setId_pat(enHosRegInfoDTO.getId_pat());
			patAddrList.add(patAddrDO_cencus);
		}else{
			PatiAddrDO patAddrDO_cencus = this.setAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_CENCUS,
					enHosRegInfoDTO.getId_pat(), true);
			if(patAddrDO_cencus!=null)
			patAddrList.add(patAddrDO_cencus);
		}
		if (!(EnValidator.isEmpty(enHosRegInfoDTO.getId_admdiv_work())
				&& EnValidator.isEmpty(enHosRegInfoDTO.getStreet_work())
				&& EnValidator.isEmpty(enHosRegInfoDTO.getTel_work())
				&& EnValidator.isEmpty(enHosRegInfoDTO.getZip_work()))) {// 工作地址
			PatiAddrDO patAddrDO_work = this.setAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_WORK,
					enHosRegInfoDTO.getId_pat(), false);
			patAddrDO_work.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_WORK);
			patAddrDO_work.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_WORK);
			patAddrDO_work.setId_admdiv(enHosRegInfoDTO.getId_admdiv_work());
			patAddrDO_work.setAdmdiv_fullname(enHosRegInfoDTO.getName_admdiv_work());
			patAddrDO_work.setSd_admdiv(enHosRegInfoDTO.getSd_admdiv_work());
			patAddrDO_work.setStreet(enHosRegInfoDTO.getStreet_work());
			patAddrDO_work.setZip(enHosRegInfoDTO.getZip_work());
			patAddrDO_work.setId_pat(enHosRegInfoDTO.getId_pat());
			patAddrDO_work.setTel(enHosRegInfoDTO.getTel_work());
			patAddrList.add(patAddrDO_work);
		}else{
			PatiAddrDO patAddrDO_work = this.setAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_WORK,
					enHosRegInfoDTO.getId_pat(), true);
			if(patAddrDO_work !=null)
			patAddrList.add(patAddrDO_work);
		}
		if (!EnValidator.isEmpty(enHosRegInfoDTO.getId_nativeaddr())) {// 籍贯
			PatiAddrDO patAddrDO_orgin = this.setAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_ORIGIN,
					enHosRegInfoDTO.getId_pat(), false);
			patAddrDO_orgin.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_ORIGIN);
			patAddrDO_orgin.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_ORIGIN);
			patAddrDO_orgin.setId_admdiv(enHosRegInfoDTO.getId_nativeaddr());
			patAddrDO_orgin.setAdmdiv_fullname(enHosRegInfoDTO.getName_nativeaddr());
			patAddrDO_orgin.setSd_admdiv(enHosRegInfoDTO.getCode_nativeaddr());
			patAddrDO_orgin.setId_pat(enHosRegInfoDTO.getId_pat());
			patAddrList.add(patAddrDO_orgin);
		}else{
			PatiAddrDO patAddrDO_orgin = this.setAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_ORIGIN,
					enHosRegInfoDTO.getId_pat(), true);
			if(patAddrDO_orgin!=null)
			patAddrList.add(patAddrDO_orgin);
		}
		if (!EnValidator.isEmpty(enHosRegInfoDTO.getId_admdiv_birth())) {// 出生地
			PatiAddrDO patAddrDO = this.setAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_BORN, enHosRegInfoDTO.getId_pat(),
					false);
			patAddrDO.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_BORN);
			patAddrDO.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_BORN);
			patAddrDO.setId_admdiv(enHosRegInfoDTO.getId_admdiv_birth());
			patAddrDO.setAdmdiv_fullname(enHosRegInfoDTO.getName_admdiv_birth());
			patAddrDO.setSd_admdiv(enHosRegInfoDTO.getSd_admdiv_birth());
			patAddrDO.setId_pat(enHosRegInfoDTO.getId_pat());
			patAddrList.add(patAddrDO);
			
		}else{
			PatiAddrDO patAddrDO = this.setAddrDOStatus(IPiDictCodeConst.ID_ADDR_TYPE_BORN, enHosRegInfoDTO.getId_pat(),
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
	 * 设置患者联系人
	 * 
	 * @param enhosPatDTO
	 * @return
	 * @throws BizException
	 */
	private List<PiPatContDO> setPatContContent(EnHosRegInfoDTO enHosRegInfoDTO) throws BizException {

		if (EnValidator.isEmpty(enHosRegInfoDTO.getName_cont())
				&& EnValidator.isEmpty(enHosRegInfoDTO.getName_conttp()) && EnValidator.isEmpty(enHosRegInfoDTO.getConttel())
				&& EnValidator.isEmpty(enHosRegInfoDTO.getContaddr()))
			return null;// 如果患者姓名、类型、电话、地址都为空，就返回空
		PiPatContDO piContDO = null;
		int sortNo = 0;
		// 如果患者不为空，说明已经注册了
		if (!EnValidator.isEmpty(enHosRegInfoDTO.getId_pat())) {
			PatEP patep = new PatEP();
			PiPatContDO[] patConts = patep.getContDO(enHosRegInfoDTO.getId_pat());
			if (!EnValidator.isEmpty(patConts)) {
				for (PiPatContDO contDO : patConts) {
					if (!EnValidator.isEmpty(enHosRegInfoDTO.getId_patcont())) {
						if (contDO.getId_patcont().equals(enHosRegInfoDTO.getId_patcont())) {
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

		piContDO.setId_pat(enHosRegInfoDTO.getId_pat());
		piContDO.setId_conttp(enHosRegInfoDTO.getId_conttp());
		piContDO.setSd_conttp(enHosRegInfoDTO.getSd_conttp());
		piContDO.setName(enHosRegInfoDTO.getName_cont());
		piContDO.setConttel(enHosRegInfoDTO.getConttel());
		piContDO.setContaddr(enHosRegInfoDTO.getContaddr());
		List<PiPatContDO> list = new ArrayList<PiPatContDO>();
		list.add(piContDO);
		return list;
	}
	
	/**
	 * 保存就诊信息
	 * 
	 * @param enhosPatDTO
	 * @param enHosRegDTO
	 * @param pataggDO
	 * @throws BizException
	 */
	private void saveEntInfo(EnHosRegInfoDTO enHosRegInfoDTO, PatiAggDO pataggDO,
			InpatientDO inpatientDO, boolean hasBed) throws BizException {
		//0。判断是不是新患者
		FBoolean isNew = FBoolean.TRUE;
		if (enHosRegInfoDTO.getStatus() != DOStatus.NEW){
			isNew = FBoolean.FALSE;
		}
		// 1、取得保存后的patdo
		PatDO patdo = pataggDO.getParentDO();
		// 2、取得保存后的pat
		List<PiPatContDO> patContList = this.getPatCont(pataggDO);
		// 3、设置pat的值
		enHosRegInfoDTO.setId_pat(patdo.getId_pat());
		enHosRegInfoDTO.setId_pat(patdo.getId_pat());
		// 5、就诊数据保存
		PatiVisitDO patiVisitDO = this.SavePativisitData(enHosRegInfoDTO);
		// 6、住院数据保存
		inpatientDO=this.SaveInpatienttData(enHosRegInfoDTO, patiVisitDO.getId_ent(), patdo, hasBed);
		// 10、保存就诊联系人
		if (!EnValidator.isEmpty(patContList)) {
			this.SaveEntCont(patContList, patiVisitDO.getId_ent());
		}
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
	 * 登录患者就诊数据
	 */
	private PatiVisitDO SavePativisitData(EnHosRegInfoDTO enHosRegInfoDTO) throws BizException {
		PvEP pativisitCrudService = new PvEP();
		PatiVisitDO patiVisitDO = this.getPatVisitDO(enHosRegInfoDTO);
		if (enHosRegInfoDTO.getStatus() == DOStatus.NEW) {
			patiVisitDO.setId_grp(EnContextUtils.getGrpId());//集团
			patiVisitDO.setId_org(EnContextUtils.getOrgId());//组织	
		}

		// 检索患者信息
		PatDO patiInfo = this.getPatDO(enHosRegInfoDTO.getId_pat());	
		patiVisitDO.setCode(enHosRegInfoDTO.getCode_ent());
		patiVisitDO.setId_pat(patiInfo.getId_pat());
		patiVisitDO.setCode_entp(IBdFcDictCodeConst.ID_CODE_ENTP_IP); // 就诊类型ID
		patiVisitDO.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_IP); // 就诊类型
		// 更新患者信息
		patiVisitDO.setName_pat(patiInfo.getName());
		patiVisitDO.setId_sex_pat(patiInfo.getId_sex());
		patiVisitDO.setSd_sex_pat(patiInfo.getSd_sex());
		patiVisitDO.setSd_mari_pat(enHosRegInfoDTO.getSd_marry());
		patiVisitDO.setId_mari_pat(enHosRegInfoDTO.getId_marry());
		patiVisitDO.setDt_birth_pat(patiInfo.getDt_birth());
		patiVisitDO.setTelno_pat(enHosRegInfoDTO.getMob());
		patiVisitDO.setId_cust_cmpy(enHosRegInfoDTO.getId_cust_cmpy());
		// 更新就诊信息
		patiVisitDO.setDt_entry(enHosRegInfoDTO.getDt_entry()); // 就诊登记日期时间
		patiVisitDO.setId_dep_phy(enHosRegInfoDTO.getId_dep_phyadm()); // 当前就诊科室
		patiVisitDO.setId_dep_nur(enHosRegInfoDTO.getId_dep_nuradm()); // 当前护理单位(病区)
		patiVisitDO.setId_emp_entry(enHosRegInfoDTO.getId_emp()); // 登记人员
		patiVisitDO.setId_hp(enHosRegInfoDTO.getId_hp()); // 主医保计划
		patiVisitDO.setId_patca(enHosRegInfoDTO.getId_patca()); // 患者分类
		patiVisitDO.setId_pripat(enHosRegInfoDTO.getId_pripat()); // 价格分类
		patiVisitDO.setId_patcret(enHosRegInfoDTO.getId_patcret()); // 信用分类
		patiVisitDO.setFg_st(FBoolean.FALSE); // 结算标志
		patiVisitDO.setFg_flup(FBoolean.FALSE); // 随访标志
		patiVisitDO.setFg_canc(FBoolean.FALSE); // 退诊标志
		patiVisitDO.setFg_data_transf(FBoolean.FALSE);// 可转移标识
		patiVisitDO.setId_entp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);// 就诊类型
		patiVisitDO.setCode_hpmedkind(enHosRegInfoDTO.getCode_hpmedkind());//医疗类别

		// 地址信息
		patiVisitDO.setId_admdiv_addr(enHosRegInfoDTO.getId_admdiv_now());
		patiVisitDO.setAddr_pat(enHosRegInfoDTO.getName_admdiv_now());
		patiVisitDO.setSd_admdiv_addr(enHosRegInfoDTO.getSd_admdiv_now());
		if (enHosRegInfoDTO.getFg_ip() == null || !enHosRegInfoDTO.getFg_ip().booleanValue()) {
			FDateTime curTime = EnAppUtils.getServerDateTime();
			patiVisitDO.setDt_insert(curTime);
			patiVisitDO.setFg_ip(FBoolean.FALSE); // 在院标志
		}
		return pativisitCrudService.save(new PatiVisitDO[] { patiVisitDO })[0];
	}

	/**
	 * 登录住院数据
	 */
	private InpatientDO SaveInpatienttData(EnHosRegInfoDTO enHosRegInfoDTO,String entId, PatDO patdo, boolean hasBed) throws BizException {
		IpEP inpatientService =new IpEP();
		InpatientDO inpatientDO = new InpatientDO();
		inpatientDO.setStatus(DOStatus.NEW);
		String oldBedId = null;
        this.SetBedInfo(enHosRegInfoDTO, patdo.getSd_sex());
		if (enHosRegInfoDTO.getStatus() == DOStatus.UPDATED) {
			inpatientDO = this.getInPatientDO(entId);
			oldBedId = inpatientDO.getId_bed();
		} else if (enHosRegInfoDTO.getStatus() == DOStatus.NEW && !EnValidator.isEmpty(enHosRegInfoDTO.getId_bed_sc()) && !enHosRegInfoDTO.getId_bed_sc().equals(enHosRegInfoDTO.getId_bed())) {
			EnLogUtil.getInstance().logError("方法：SaveInpatienttData(enHosRegInfoDTO enHosRegInfoDTO, String entId, PatDO patdo, boolean hasBed, EnHosPatDTO enhosPatDTO)----患者未使用预约的床位，需释放预约的床位，预约床位id：" + enHosRegInfoDTO.getId_bed_sc());
			oldBedId = enHosRegInfoDTO.getId_bed_sc();
		}
		inpatientDO.setTimes_ip(enHosRegInfoDTO.getTimes_ip());
		if (enHosRegInfoDTO.getTimes_ip() == null || enHosRegInfoDTO.getTimes_ip() == 0) {
			inpatientDO.setTimes_ip(this.setIpTimes(enHosRegInfoDTO.getId_pat()));
		}
		inpatientDO.setCode_amr_ip(patdo.getCode_amr_ip());		
		inpatientDO.setId_ent(entId); // 就诊ID
		inpatientDO.setId_dep_phyadm(enHosRegInfoDTO.getId_dep_phyadm()); // 入院科室
		inpatientDO.setId_dep_nuradm(enHosRegInfoDTO.getId_dep_nuradm()); // 入院病区
		inpatientDO.setId_bed(enHosRegInfoDTO.getId_bed()); // 选择的床位
		inpatientDO.setName_bed(enHosRegInfoDTO.getName_bed());
		inpatientDO.setFg_surg(new FBoolean(false)); // 是否手术标志
		inpatientDO.setId_referalsrc(enHosRegInfoDTO.getId_referalsrc()); // 来院方式ID
		inpatientDO.setSd_referalsrc(enHosRegInfoDTO.getSd_referalsrc()); // 来院方式
		inpatientDO.setCont_name(enHosRegInfoDTO.getName_cont()); // 就诊联系人姓名
		inpatientDO.setCont_tel(enHosRegInfoDTO.getConttel()); // 就诊联系人电话
		inpatientDO.setId_diag_op(enHosRegInfoDTO.getId_diag_op());
		inpatientDO.setDesc_diag_op(enHosRegInfoDTO.getDesc_diag_op());// 保存诊断
		inpatientDO.setId_level_diseadm(enHosRegInfoDTO.getId_level_diseadm());
		inpatientDO.setSd_level_diseadm(enHosRegInfoDTO.getCode_level_diseadm());
		inpatientDO.setId_level_dise(enHosRegInfoDTO.getId_level_diseadm());
		inpatientDO.setSd_level_dise(enHosRegInfoDTO.getCode_level_diseadm());
		inpatientDO.setId_emp_opapply(enHosRegInfoDTO.getId_emp_opapply());//入院医生
		inpatientDO.setSd_pay_mothod(enHosRegInfoDTO.getSd_pay_mothod());//付款方式
		inpatientDO.setFg_vip(enHosRegInfoDTO.getFg_vip());
		inpatientDO.setFg_mobapp(enHosRegInfoDTO.getFg_mobapp());
		inpatientDO.setTelno_mobapp(enHosRegInfoDTO.getTelno_mobapp());
		inpatientDO.setFg_pe(enHosRegInfoDTO.getFg_pe());
		inpatientDO.setSd_pe_psntp(enHosRegInfoDTO.getSd_pe_psntp());
		inpatientDO.setName_pe_intr(enHosRegInfoDTO.getName_pe_intr());
		// 通过住院通知单入院的时候保存病情等级
		// this.SaveLevelDiseToIpnt(inpatientDO, enHosRegInfoDTO.getId_ent_ipnt());
		if (enHosRegInfoDTO.getFg_ip() == null || !enHosRegInfoDTO.getFg_ip().booleanValue()) {
			inpatientDO.setSd_status(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN); // 就诊状态为住院
			// 根据参数是否区分性别更新床位信息
			/*if (hasBed && IEnDictCodeConst.BED_HAS_SEX.equals(EnParamUtils.getBedSexParam(enHosRegInfoDTO.getId_ip_nuradm()))) {
				updateBedDataWithSex(enHosRegInfoDTO.getId_ent(), oldBedId, enHosRegInfoDTO.getId_bed(), enHosRegInfoDTO.getId_ent_ipnt(),
						patdo.getSd_sex());
			}else {
				updateBedData(enHosRegInfoDTO.getId_ent(), oldBedId, enHosRegInfoDTO.getId_bed(),enHosRegInfoDTO.getId_ent_ipnt());
			}*/
		}
		
		inpatientService.save(inpatientDO);
		enHosRegInfoDTO.setTimes_ip(inpatientDO.getTimes_ip());
		//住院数据保存后，同步患者表中的住院次数 - zhangpp
		this.SetPatDo(patdo);
		InpatientDO[] inpatients = inpatientService.getIpDOByEntId(entId);
		if(EnValidator.isEmpty(inpatients)){
			return null;
		}
		return inpatients[0];
	}
	/**
	 * 查找entdo
	 * 
	 * @param enHosRegDTO
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO getPatVisitDO(EnHosRegInfoDTO enHosRegInfoDTO) throws BizException {
		PvEP pvep = new PvEP();
		PatiVisitDO patiVisitDO = new PatiVisitDO();
		patiVisitDO.setStatus(DOStatus.NEW);
		if (enHosRegInfoDTO.getStatus() == DOStatus.UPDATED) {
			patiVisitDO = pvep.getPvById(enHosRegInfoDTO.getId_ent());
			patiVisitDO.setStatus(DOStatus.UPDATED);
		}
		return patiVisitDO;
	}
	/**
	 * 设置床位信息
	 * @param enHosRegDTO
	 * @throws BizException 
	 */
	private void SetBedInfo(EnHosRegInfoDTO enHosRegInfoDTO, String sdPatsex) throws BizException{
		if(!EnValidator.isEmpty(enHosRegInfoDTO.getId_bed())){
			return;
		}
		BedEP bedep = new BedEP();
		Bdbed bed = bedep.getBedbyDep(enHosRegInfoDTO.getId_dep_nuradm(), sdPatsex,true);
		enHosRegInfoDTO.setId_bed(bed.getId_bed());
		enHosRegInfoDTO.setName_bed(bed.getName());
	}
	
	/**
	 * 根据entid获取住院do
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private InpatientDO getInPatientDO(String entId) throws BizException {
		IpEP inpatientService = new IpEP();
		InpatientDO inpatientDO = inpatientService.getIpByEntId(entId);
		inpatientDO.setStatus(DOStatus.UPDATED);
		return inpatientDO;
	}
	
	/**
	 * 设置入院次数
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private int setIpTimes(String patId) throws BizException {
		IpEP ipEP = new IpEP();
		return ipEP.setIpTimes(patId);
		
	}
	/**
	 * 同步患者表中的住院次数
	 * @param times
	 * @throws BizException 
	 */
	@SuppressWarnings("unused")
	private void SetPatDo(PatDO patdo) throws BizException{
		patdo.setLast_times_ip(new IpEP().setPatTimes(patdo.getId_pat()));
		IPatiMDOCudService iPatiCudService = ServiceFinder.find(IPatiMDOCudService.class);
		iPatiCudService.update(new PatDO[]{patdo});
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
		Bdbed bed = bedep.getBedbyDep(enHosRegDTO.getId_dep_nuradm(), sdPatsex,true);
		enHosRegDTO.setId_bed(bed.getId_bed());
		enHosRegDTO.setBedname(bed.getName());
	}
	
	/**
	 * 保存entcont就诊联系人
	 * 
	 * @param picontDO
	 * @param entId
	 * @throws BizException
	 */
	private void SaveEntCont(List<PiPatContDO> patContList, String entId) throws BizException {
		if (EnValidator.isEmpty(patContList))
			return;
		EntContEP entContEP = new EntContEP();
			if (!EnValidator.isEmpty(patContList)) {
				entContEP.SaveEntCont(patContList.get(0), entId);
		}
	}
}
