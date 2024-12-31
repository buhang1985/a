package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.ep.EntContEP;
import iih.en.comm.ep.NbEP;
import iih.en.comm.util.FDoubleUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.IpInfoDTO;
import iih.en.pv.entagtp.d.EnTagTpDO;
import iih.en.pv.entagtp.i.IEntagtpRService;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpRService;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.EntContDO;
import iih.en.pv.pativisit.d.EuEntContTp;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.i.IPatiAddrDORService;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pat.i.IPiPatContDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取住院信息
 * 
 * @author renying
 *
 */
public class GetIpInfoBP {
	/**
	 * 获取住院信息
	 * 
	 * @param entId就诊id
	 * @return
	 * @throws BizException
	 */
	public IpInfoDTO exec(String entId) throws BizException {
		// 1.创建新的dto
		if(EnValidator.isEmpty(entId))
			return null;
		// 2.查找ent信息
		IpInfoDTO ipinfoDTO = this.getEntInfo(entId);
		if(ipinfoDTO == null)
			return null;
		// 3. 查找住院信息
		this.getInPatientDO(ipinfoDTO);
		// 4. 查找患者信息
		this.getPatDO(ipinfoDTO);
		// 5.查找医保信息
		this.getHPValue(ipinfoDTO);
		// 6.查找患者地址信息
		this.getPatAddrInfo4PatDTO(ipinfoDTO);
		// 7.查找患者联系人信息
		this.getPatContValue(ipinfoDTO);
		// 8.查找 就诊标签
		this.getEntTags(ipinfoDTO);
		//10.设置新生儿入院信息-体重、身高，fanlq-2018-10-31
		this.setNbIpInfo(ipinfoDTO);
		return ipinfoDTO;
	}


	/**
	 * 查找en_ent中的信息
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private IpInfoDTO getEntInfo(String entId) throws BizException {
		IPativisitRService patvisitService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO pativisitDO = patvisitService.findById(entId);
		if (pativisitDO == null) {
			return null;
		}
		
		IpInfoDTO ipinfoDTO = new IpInfoDTO();
		ipinfoDTO.setId_patca(pativisitDO.getId_patca());
		ipinfoDTO.setName_patca(pativisitDO.getName_patca());
		ipinfoDTO.setId_patcret(pativisitDO.getId_patcret());
		ipinfoDTO.setName_patcret(pativisitDO.getName_patcret());
		ipinfoDTO.setId_pripat(pativisitDO.getId_pripat());
		ipinfoDTO.setName_pripat(pativisitDO.getName_pripat());
		ipinfoDTO.setId_ent(entId);
		ipinfoDTO.setName_pat(pativisitDO.getName_pat());
		ipinfoDTO.setSex(pativisitDO.getName_sex());
		ipinfoDTO.setId_sex_pat(pativisitDO.getId_sex_pat());
		ipinfoDTO.setDt_birth_pat(pativisitDO.getDt_birth_pat());
		ipinfoDTO.setDt_acpt(pativisitDO.getDt_acpt());
		ipinfoDTO.setId_dep_phy(pativisitDO.getId_dep_phy());
		ipinfoDTO.setId_dep_nur(pativisitDO.getId_dep_nur());
		ipinfoDTO.setName_dep_phy(pativisitDO.getName_dep_phy());
		ipinfoDTO.setName_dep_nur(pativisitDO.getName_dep_nur());
		ipinfoDTO.setId_pat(pativisitDO.getId_pat());
		ipinfoDTO.setEnt_code(pativisitDO.getCode());
		return ipinfoDTO;
	}

	/**
	 * 查找住院信息
	 * 
	 * @param ipinfoDTO
	 * @throws BizException
	 */
	private void getInPatientDO(IpInfoDTO ipinfoDTO) throws BizException {
		IInpatientRService inpatientRService = ServiceFinder.find(IInpatientRService.class);
		InpatientDO[] inpatientDOs = inpatientRService.findByAttrValString(InpatientDO.ID_ENT, ipinfoDTO.getId_ent());
		InpatientDO inpatientDO = inpatientDOs[0];
		ipinfoDTO.setId_bed(inpatientDO.getId_bed());
		ipinfoDTO.setName_bed(inpatientDO.getName_bed());
		ipinfoDTO.setId_level_dise(inpatientDO.getId_level_dise());
		ipinfoDTO.setName_level_dise(inpatientDO.getName_level_dise());
		ipinfoDTO.setId_level_nur(inpatientDO.getId_level_nur());
		ipinfoDTO.setName_level_nur(inpatientDO.getName_level_nur());
		ipinfoDTO.setCode_amr_ip(inpatientDO.getCode_amr_ip());
		ipinfoDTO.setSd_status(inpatientDO.getSd_status());
		ipinfoDTO.setId_referalsrc(inpatientDO.getId_referalsrc());//来院方式id
		ipinfoDTO.setSd_referalsrc(inpatientDO.getSd_referalsrc());//来院方式编号
		ipinfoDTO.setName_referalsrc(inpatientDO.getName_referalsrc());//来院方式
	}

	/**
	 * 查找患者信息
	 * 
	 * @param ipinfoDTO
	 * @throws BizException
	 */
	private void getPatDO(IpInfoDTO ipinfoDTO) throws BizException {
		if (EnValidator.isEmpty(ipinfoDTO.getId_pat()))
			return;
		IPatiMDORService patiRService = ServiceFinder.find(IPatiMDORService.class);
		PatDO patDO = patiRService.findById(ipinfoDTO.getId_pat());
		ipinfoDTO.setId_idtp(patDO.getId_idtp());
		ipinfoDTO.setSd_idtp(patDO.getSd_idtp());
		ipinfoDTO.setName_idtp(patDO.getIdtp_name());
		ipinfoDTO.setCode_id(patDO.getId_code());
		ipinfoDTO.setMob(patDO.getMob());
		ipinfoDTO.setPat_code(patDO.getCode());
		ipinfoDTO.setPhoto(patDO.getPhoto());
		ipinfoDTO.setId_marry(patDO.getId_marry());
		ipinfoDTO.setName_marry(patDO.getMarry_name());
		ipinfoDTO.setSd_mari_pat(patDO.getSd_marry());
	}

	/**
	 * 设置医保的值
	 * 
	 * @param ipinfoDTO
	 * @throws BizException
	 */
	private void getHPValue(IpInfoDTO ipinfoDTO) throws BizException {
		String entID = ipinfoDTO.getId_ent();
		IEnthpRService rservice = ServiceFinder.find(IEnthpRService.class);
		EntHpDO[] entHpDOArr = rservice.findByAttrValString(EntHpDO.ID_ENT, entID);

		for (EntHpDO hpDO : entHpDOArr) {
			if (ipinfoDTO.getId_ent().equals(hpDO.getId_ent())) {
				if (hpDO.getFg_maj() == FBoolean.TRUE) {
					ipinfoDTO.setId_hp(hpDO.getId_hp());
					ipinfoDTO.setName_hp(hpDO.getName_hp());

				} else {
					ipinfoDTO.setId_hp_sec(hpDO.getId_hp());
					ipinfoDTO.setName_hp_sec(hpDO.getName_hp());
				}
			}
		}
	}

	/**
	 * 查找用户地址相关信息
	 * 
	 * @param patId
	 * @param enhosPatDTO
	 * @throws BizException
	 */
	private void getPatAddrInfo4PatDTO(IpInfoDTO ipinfoDTO) throws BizException {
		IPatiAddrDORService addRService = ServiceFinder.find(IPatiAddrDORService.class);
		PatiAddrDO[] patAddrDOArr = addRService.findByAttrValString(PatiAddrDO.ID_PAT, ipinfoDTO.getId_pat());
		if (EnValidator.isEmpty(patAddrDOArr)) {
			return;
		}
		for (PatiAddrDO addrPatDO : patAddrDOArr) {// 现住址
			if (!EnValidator.isEmpty(addrPatDO.getId_addrtp()) && addrPatDO.getId_addrtp().equals(IPiDictCodeConst.ID_ADDR_TYPE_NOW)) {
				ipinfoDTO.setName_admdiv(addrPatDO.getAdmdiv_fullname());
				ipinfoDTO.setId_admdiv(addrPatDO.getId_admdiv());
				ipinfoDTO.setSd_admdiv(addrPatDO.getSd_admdiv());
				ipinfoDTO.setAddr(addrPatDO.getStreet());
			}
		}
	}

	/**
	 * 获取患者联系人信息
	 * 
	 * @param patId
	 * @param enhosPatDTO
	 * @throws BizException
	 */
	private void getPatContValue(IpInfoDTO ipinfoDTO) throws BizException {

		
		NbEP nbep = new NbEP();
		NewbornDO nbChild = nbep.getNbDO(ipinfoDTO.getId_ent());
		EntContEP entContEP = new EntContEP();
		EntContDO[] entContDOs = null;
		if(nbChild == null){
		  entContDOs = entContEP.getEntConts(ipinfoDTO.getId_ent(), EuEntContTp.CONTACT.intValue(), null);	
		}else{
			  entContDOs = entContEP.getEntConts(ipinfoDTO.getId_ent(), EuEntContTp.MOTHER.intValue(), null);	
		}
		if (EnValidator.isEmpty(entContDOs)) {
			return;
		}
		
		EntContDO entCont = entContDOs[0];
		IPiPatContDORService pipatCountService = ServiceFinder.find(IPiPatContDORService.class);
		PiPatContDO[] patContDOs = pipatCountService.findByAttrValString(PiPatContDO.ID_PAT, ipinfoDTO.getId_pat());
		if (EnValidator.isEmpty(patContDOs)) {
			return;
		}
		PiPatContDO pipatCont = null;
		if (EnValidator.isEmpty(entCont.getId_patcontid())) {
			pipatCont = new PiPatContDO();
		} else {
			for (PiPatContDO cont : patContDOs) {
				if (!EnValidator.isEmpty(entCont.getId_patcontid()) && entCont.getId_patcontid().equals(cont.getId_patcont())) {
					pipatCont = cont;
				}
			}
		}
		if (pipatCont == null)
			return;
				
		ipinfoDTO.setId_patcont(pipatCont.getId_patcont());
		ipinfoDTO.setName_cont(pipatCont.getName());
		ipinfoDTO.setId_conttp(pipatCont.getId_conttp());
		ipinfoDTO.setName_conttp(pipatCont.getConttp_name());
		ipinfoDTO.setConttel(pipatCont.getConttel());
		ipinfoDTO.setContaddr(pipatCont.getContaddr());
	}
	
	/**
	 * 
	 * @Description: 获得就诊标签
	 * @param ipinfoDTO
	 * @throws BizException
	 * @author: lilei
	 * @date: 2018年9月14日 下午5:37:34
	 */
	private void getEntTags(IpInfoDTO ipinfoDTO) throws BizException {
		IEntagtpRService iEntagtpRService = ServiceFinder.find(IEntagtpRService.class);
		EnTagTpDO[] tagTpDos = iEntagtpRService.findByAttrValString(EnTagTpDO.ID_ENT, ipinfoDTO.getId_ent());
		if (tagTpDos != null && tagTpDos.length > 0){
			String ids = "",names = "";
			for(EnTagTpDO toDo : tagTpDos){
				ids += toDo.getId_tagtp() + ",";
				names += toDo.getName_tagtp() + ",";
			}
			ipinfoDTO.setId_tagtp(ids.substring(0, ids.length()-1));
			ipinfoDTO.setName_tagtp(names.substring(0, names.length()-1));
		}
	}
	/***
	 * 设置新生儿入院信息-体重、身高，fanlq-2018-10-31
	 * 
	 * @param ipinfoDTO
	 * @throws BizException 
	 */
	private void setNbIpInfo(IpInfoDTO ipinfoDTO) throws BizException{
		NbEP nbEP = new NbEP();
		NewbornDO newBornDO = nbEP.getNbChild(ipinfoDTO.getId_ent());
		if(newBornDO != null){
			ipinfoDTO.setWeight_reg(newBornDO.getWeight_reg());
			ipinfoDTO.setWeight_reg_g(FDoubleUtils.convertKgToG(newBornDO.getWeight_reg()));
			ipinfoDTO.setWeight(newBornDO.getWeight());
			ipinfoDTO.setWeight_g(FDoubleUtils.convertKgToG(newBornDO.getWeight()));//kg 转换为g
			ipinfoDTO.setHeight(newBornDO.getHeight());
		}
	}
}
