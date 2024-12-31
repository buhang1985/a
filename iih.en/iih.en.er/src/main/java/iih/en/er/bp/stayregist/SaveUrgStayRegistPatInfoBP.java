package iih.en.er.bp.stayregist;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.fc.ipspectp.d.BdEnIpSpecDO;
import iih.bd.fc.ipspectp.i.IIpspectpRService;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.EnCodeAmrIpEP;
import iih.en.comm.ep.PiPatAmrCodeEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnCodeUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.UrgStayRegistryDTO;
import iih.pi.reg.i.IPiRegMaintainService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.i.IPatiRService;
import iih.pi.reg.patamrcode.d.PiPatAmrCodeDO;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存留观登记患者信息
 * 
 * @author liubin
 *
 */
public class SaveUrgStayRegistPatInfoBP {
	/**
	 * 保存留观登记患者信息
	 * 
	 * @param urgstayregistry
	 * @return 
	 * @throws BizException
	 */
	public PatiAggDO exec(UrgStayRegistryDTO urgStayRegistry) throws BizException {
		IPatiRService serv = ServiceFinder.find(IPatiRService.class);
		PatiAggDO agg = serv.findById(urgStayRegistry.getId_pat());
		if(EnValidator.isEmpty(agg))
			throw new BizException(IEnMsgConst.ERROR_PAT_NOT_EXIST);
		//1.保存PI_PAT
		updatePat(agg, urgStayRegistry);
		//2.保存PI_PAT_ADDR
		updatePatAddr(agg, urgStayRegistry);
		//3.保存PI_PAT_CONT
		updatePatCont(agg, urgStayRegistry);
		//4.保存PI_PAT_HP
		updatePatHp(agg, urgStayRegistry);
		
		IPiRegMaintainService patiService = ServiceFinder.find(IPiRegMaintainService.class);
		return patiService.savePatForHosReg(agg);
	}
	/**
	 * 保存患者信息PI_PAT
	 * 
	 * @param urgStayRegistry
	 * @throws BizException
	 */
	public void updatePat(PatiAggDO agg, UrgStayRegistryDTO urgStayRegistry) throws BizException {
		PatDO patdo = agg.getParentDO();
		patdo.setStatus(DOStatus.UPDATED);
		
		if (EnValidator.isEmpty(patdo.getId_pat())) {
			patdo.setCode(EnCodeUtils.createPatCode());
		}
		////判断是否生成住院号
		//根据参数查住院特定类型
		String sd_ip_spec = EnParamUtils.getErSdIptype();
		//根据住院特定类型，查找对应的患者病案类型
		IIpspectpRService iIpspectpRService = ServiceFinder.find(IIpspectpRService.class);
		BdEnIpSpecDO[] bdEnIpSpecDOs = iIpspectpRService.findByAttrValString(BdEnIpSpecDO.SD_IP_SPEC, sd_ip_spec);
		//如果住院特定类型表中无数据，默认走普通的住院号
		if (bdEnIpSpecDOs == null || bdEnIpSpecDOs.length <= 0 || IEnDictCodeConst.SD_IPTYPE_CUSTOM.equals(sd_ip_spec)){
			if (EnValidator.isEmpty(patdo.getCode_amr_ip()) || patdo.getCode_amr_ip().contains("B") 
					|| (EnValidator.isEmpty(urgStayRegistry.getId_ent())&&(EnParamUtils.getIsChangeIpCode()))) {
				patdo.setCode_amr_ip(new EnCodeAmrIpEP().createIpAmrCode());
				EnLogUtil.getInstance().logInfo("住院号生成：患者id"+patdo.getId_pat()+ " 住院号变成:"+patdo.getCode_amr_ip());
				urgStayRegistry.setCode_amr_ip(patdo.getCode_amr_ip());
			}else{
				urgStayRegistry.setCode_amr_ip(patdo.getCode_amr_ip());
			}
		}else{
			PiPatAmrCodeDO piPatAmrCodeDO = new PiPatAmrCodeEP().getpiPatAmrCodeByWherestr(patdo.getId_pat(), bdEnIpSpecDOs[0].getSd_patarmtp());
			if (piPatAmrCodeDO == null) {
				urgStayRegistry.setCode_amr_ip(new EnCodeAmrIpEP().createIpSpecTypeAmrCode(bdEnIpSpecDOs[0].getCode_codemaker()));
				EnLogUtil.getInstance().logInfo("特定类型住院号生成：患者id"+patdo.getId_pat()+ " 特定类型住院号为:"+urgStayRegistry.getCode_amr_ip());
			}else{
				urgStayRegistry.setCode_amr_ip(piPatAmrCodeDO.getCode());
			}
		}
		
		patdo.setFg_realname(FBoolean.TRUE);
		patdo.setName(urgStayRegistry.getName_pat());
		patdo.setId_sex(urgStayRegistry.getId_sex());// 性别
		patdo.setSd_sex(urgStayRegistry.getSd_sex());
		patdo.setId_idtp(urgStayRegistry.getId_idtp());// 证件类型
		patdo.setSd_idtp(urgStayRegistry.getSd_idtp());
		patdo.setId_code(urgStayRegistry.getId_code());
		patdo.setDt_birth(urgStayRegistry.getDt_birth());
		patdo.setId_marry(urgStayRegistry.getId_marry());
		patdo.setSd_marry(urgStayRegistry.getSd_marry());
		if(EnAppUtils.isMob(urgStayRegistry.getMob())){
			patdo.setMob(urgStayRegistry.getMob());
		}else
			patdo.setTel(urgStayRegistry.getMob());
		patdo.setId_nation(urgStayRegistry.getId_nation());// 民族
		patdo.setNation_name(urgStayRegistry.getName_nation());
		patdo.setSd_nation(urgStayRegistry.getSd_nation());
		patdo.setId_country(urgStayRegistry.getId_country()); // 国籍
		patdo.setCountry_name(urgStayRegistry.getName_country());
		patdo.setSd_country(urgStayRegistry.getSd_country());
		patdo.setWbcode(EnAppUtils.getWbCode(patdo.getName()));
		patdo.setPycode(EnAppUtils.getPyCode(patdo.getName()));
		patdo.setMnecode(patdo.getCode());
		patdo.setId_occu(urgStayRegistry.getId_occu());
		patdo.setSd_occu(urgStayRegistry.getSd_occu());
		patdo.setPhoto(urgStayRegistry.getPhoto());
		patdo.setWorkunit(urgStayRegistry.getWorkunit());
		patdo.setDomain(IPiDictCodeConst.DOMAIN_ID_ZY);
		patdo.setFg_sync_en(FBoolean.TRUE);
		agg.setParent(patdo);
	}
	/**
	 * 保存患者地址信息PI_PAT_ADDR
	 * 
	 * @param urgStayRegistry
	 * @throws BizException
	 */
	private void updatePatAddr(PatiAggDO agg, UrgStayRegistryDTO urgStayRegistry) throws BizException {
		PatiAddrDO[] addrDOs = agg.getPatiAddrDO();
		List<PatiAddrDO> patAddrList = new LinkedList<PatiAddrDO>();
		if(!EnValidator.isEmpty(addrDOs))
			Collections.addAll(patAddrList, addrDOs);
		if (!EnValidator.isEmpty(urgStayRegistry.getId_addr_now())) {// 现住址
			PatiAddrDO patAddrDO_Now = this.setAddrDOStatus(IPiDictCodeConst.SD_ADDR_TYPE_NOW, patAddrList,false);
			patAddrDO_Now.setId_pat(urgStayRegistry.getId_pat());
			patAddrDO_Now.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_NOW);
			patAddrDO_Now.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
			patAddrDO_Now.setId_admdiv(urgStayRegistry.getId_addr_now());
			patAddrDO_Now.setSd_admdiv(urgStayRegistry.getCode_addr_now());
			patAddrDO_Now.setStreet(urgStayRegistry.getStreet_addr_now());
			patAddrDO_Now.setZip(urgStayRegistry.getZip_addr_now());
			patAddrDO_Now.setTel(urgStayRegistry.getTel_addr_now());
		}else{
			this.setAddrDOStatus(IPiDictCodeConst.SD_ADDR_TYPE_NOW, patAddrList,true);
		}
		if (!EnValidator.isEmpty(urgStayRegistry.getId_addr_cencus())) {// 户籍地址
			PatiAddrDO patAddrDO_cencus = this.setAddrDOStatus(IPiDictCodeConst.SD_ADDR_TYPE_CENCUS, patAddrList,false);
			patAddrDO_cencus.setId_pat(urgStayRegistry.getId_pat());
			patAddrDO_cencus.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_CENCUS);
			patAddrDO_cencus.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_CENCUS);
			patAddrDO_cencus.setId_admdiv(urgStayRegistry.getId_addr_cencus());
			patAddrDO_cencus.setSd_admdiv(urgStayRegistry.getCode_addr_cencus());
			patAddrDO_cencus.setStreet(urgStayRegistry.getStreet_addr_cencus());
			patAddrDO_cencus.setZip(urgStayRegistry.getZip_addr_cencus());
		}else{
			this.setAddrDOStatus(IPiDictCodeConst.SD_ADDR_TYPE_CENCUS, patAddrList,true);
		}
		if (!EnValidator.isEmpty(urgStayRegistry.getId_addr_work())) {// 工作地址
			PatiAddrDO patAddrDO_work = this.setAddrDOStatus(IPiDictCodeConst.SD_ADDR_TYPE_WORK, patAddrList,false);
			patAddrDO_work.setId_pat(urgStayRegistry.getId_pat());
			patAddrDO_work.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_WORK);
			patAddrDO_work.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_WORK);
			patAddrDO_work.setId_admdiv(urgStayRegistry.getId_addr_work());
			patAddrDO_work.setSd_admdiv(urgStayRegistry.getCode_addr_work());
			patAddrDO_work.setStreet(urgStayRegistry.getStreet_addr_work());
			patAddrDO_work.setZip(urgStayRegistry.getZip_addr_work());
			patAddrDO_work.setTel(urgStayRegistry.getTel_addr_work());
		}else{
			this.setAddrDOStatus(IPiDictCodeConst.SD_ADDR_TYPE_WORK, patAddrList,true);
		}
		if (!EnValidator.isEmpty(urgStayRegistry.getId_addr_origin())) {// 籍贯
			PatiAddrDO patAddrDO_orgin = this.setAddrDOStatus(IPiDictCodeConst.SD_ADDR_TYPE_ORIGIN, patAddrList,false);
			patAddrDO_orgin.setId_pat(urgStayRegistry.getId_pat());
			patAddrDO_orgin.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_ORIGIN);
			patAddrDO_orgin.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_ORIGIN);
			patAddrDO_orgin.setId_admdiv(urgStayRegistry.getId_addr_origin());
			patAddrDO_orgin.setSd_admdiv(urgStayRegistry.getCode_addr_origin());
		}else{
			this.setAddrDOStatus(IPiDictCodeConst.SD_ADDR_TYPE_ORIGIN, patAddrList,true);
		}
		if (!EnValidator.isEmpty(urgStayRegistry.getId_addr_born())) {// 出生地
			PatiAddrDO patAddrDO_born = this.setAddrDOStatus(IPiDictCodeConst.SD_ADDR_TYPE_BORN, patAddrList,false);
			patAddrDO_born.setId_pat(urgStayRegistry.getId_pat());
			patAddrDO_born.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_BORN);
			patAddrDO_born.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_BORN);
			patAddrDO_born.setId_admdiv(urgStayRegistry.getId_addr_born());
			patAddrDO_born.setSd_admdiv(urgStayRegistry.getCode_addr_born());
		}else{
			this.setAddrDOStatus(IPiDictCodeConst.SD_ADDR_TYPE_BORN, patAddrList,true);
		}
		agg.setPatiAddrDO(patAddrList.toArray(new PatiAddrDO[]{}));
	}
	/**
	 * 保存患者联系人信息PI_PAT_CONT
	 * 
	 * @param urgStayRegistry
	 * @throws BizException
	 */
	private void updatePatCont(PatiAggDO agg, UrgStayRegistryDTO urgStayRegistry) throws BizException {
		if(EnValidator.isEmpty(urgStayRegistry.getName_patcont()) && EnValidator.isEmpty(urgStayRegistry.getId_conttp()) 
				&& EnValidator.isEmpty(urgStayRegistry.getConttel()) && EnValidator.isEmpty(urgStayRegistry.getContaddr()))
		return;
		
		PiPatContDO[] patContDOs = agg.getPiPatContDO();
		List<PiPatContDO> patContList = new LinkedList<PiPatContDO>();
		if(!EnValidator.isEmpty(patContDOs))
			Collections.addAll(patContList, patContDOs);
		PiPatContDO piContDO = null;
		int sortNo = 0;
		// 如果患者不为空，说明已经注册了
		if (!EnValidator.isEmpty(patContList)) {
			for (PiPatContDO contDO : patContList) {
				if (!EnValidator.isEmpty(urgStayRegistry.getId_patcont())) {
					if (contDO.getId_patcont().equals(urgStayRegistry.getId_patcont())) {
						piContDO = contDO;
						piContDO.setStatus(DOStatus.UPDATED);
					}
				}
				//取到最大的序号
				if (contDO.getSortno() != null && contDO.getSortno() > sortNo) {
					sortNo = contDO.getSortno();
				}
			}
		}

		if (piContDO == null) {
			piContDO = new PiPatContDO();
			piContDO.setStatus(DOStatus.NEW);
			piContDO.setSortno(++sortNo);
			patContList.add(piContDO);
		}
		piContDO.setId_pat(urgStayRegistry.getId_pat());
		piContDO.setId_conttp(urgStayRegistry.getId_conttp());
		piContDO.setSd_conttp(urgStayRegistry.getSd_conttp());
		piContDO.setConttp_name(urgStayRegistry.getName_conttp());
		piContDO.setName(urgStayRegistry.getName_patcont());
		piContDO.setConttel(urgStayRegistry.getConttel());
		piContDO.setContaddr(urgStayRegistry.getContaddr());
		piContDO.setFg_ieuse(FBoolean.TRUE);
		agg.setPiPatContDO(patContList.toArray(new PiPatContDO[]{}));
	}
	/**
	 * 保存患者医保信息PI_PAT_HP
	 * 
	 * @param urgStayRegistry
	 * @throws BizException
	 */
	private void updatePatHp(PatiAggDO agg, UrgStayRegistryDTO urgStayRegistry) throws BizException {
		// 如果主医保不存在，则不处理。
		if (EnValidator.isEmpty(urgStayRegistry.getId_hp())) {
			return;
		}
		PiPatHpDO[] piPatHpDOs = agg.getPiPatHpDO();
		List<PiPatHpDO> patHpList = new LinkedList<PiPatHpDO>();
		if(!EnValidator.isEmpty(piPatHpDOs))
			Collections.addAll(patHpList, piPatHpDOs);
		PiPatHpDO mainHpDO = null;
		int sortNo = -1;
		FBoolean hasMaj = FBoolean.FALSE;// 是否含有主医保
		FDateTime currentTime = EnAppUtils.getServerDateTime();
		if (!EnValidator.isEmpty(piPatHpDOs)) {
			for (PiPatHpDO piPatHpDO : patHpList) {
				if (piPatHpDO.getFg_deft() != null && piPatHpDO.getFg_deft().booleanValue()) {
					hasMaj = FBoolean.TRUE;
				}
				if (urgStayRegistry.getId_hp().equals(piPatHpDO.getId_hp())) {
					mainHpDO = piPatHpDO;
					mainHpDO.setNo_hp(urgStayRegistry.getNo_hp());
					mainHpDO.setStatus(DOStatus.UPDATED);
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
			mainHpDO.setId_pat(urgStayRegistry.getId_pat()); // 患者ID
			mainHpDO.setSortno(++sortNo); // 序号
			mainHpDO.setId_hp(urgStayRegistry.getId_hp()); // 医保计划
			mainHpDO.setNo_hp(urgStayRegistry.getNo_hp()); // 医保号
			mainHpDO.setMode_hp(IPiDictCodeConst.ID_HP_ENABLE);
			// 没有主医保，则此就是主医保
			if (hasMaj.booleanValue()) {
				mainHpDO.setFg_deft(FBoolean.FALSE); // 默认标志
			} else {
				mainHpDO.setFg_deft(FBoolean.TRUE);
			}
			mainHpDO.setDt_b(currentTime); // 有效日期开始
			mainHpDO.setFg_act(new FBoolean(true)); // 启用标志
			patHpList.add(mainHpDO);
		}
		agg.setPiPatHpDO(patHpList.toArray(new PiPatHpDO[0]));
	}
	/**
	 * 得到pataddrdo 地址do
	 * 
	 * @param addrTypeID
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private PatiAddrDO setAddrDOStatus(String addrType, List<PatiAddrDO> addrDOs, boolean isDel) throws BizException {
		PatiAddrDO patAddrDO = null;
		for (PatiAddrDO patiAddrDO : addrDOs) {
			if (addrType.equals(patiAddrDO.getSd_addrtp())) {
				patAddrDO = patiAddrDO;
				break;
			}
		}
		if (patAddrDO == null) {
			if(isDel) return null;
			patAddrDO = new PatiAddrDO();
			patAddrDO.setStatus(DOStatus.NEW);
			addrDOs.add(patAddrDO);
			return patAddrDO;
		}
		if(isDel){
			patAddrDO.setStatus(DOStatus.DELETED);
			return patAddrDO;
		}
		patAddrDO.setStatus(DOStatus.UPDATED);
		return patAddrDO;
	}
}
