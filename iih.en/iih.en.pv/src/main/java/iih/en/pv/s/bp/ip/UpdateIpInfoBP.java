package iih.en.pv.s.bp.ip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.bd.base.utils.DateTimeUtils;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.fc.tagtp.d.BdTagTpDO;
import iih.bd.fc.tagtp.i.ITagtpRService;
import iih.bd.utils.ContextUtils;
import iih.en.comm.ep.EntContEP;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.NbEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.util.FDoubleUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.IpInfoDTO;
import iih.en.pv.entagtp.d.EnTagTpDO;
import iih.en.pv.entagtp.i.IEntagtpCudService;
import iih.en.pv.entagtp.i.IEntagtpRService;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.inpatient.i.INewbornRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.d.desc.PatiAddrDODesc;
import iih.pi.reg.pat.d.desc.PiPatContDODesc;
import iih.pi.reg.pat.i.IPatiAddrDOCudService;
import iih.pi.reg.pat.i.IPatiAddrDORService;
import iih.pi.reg.pat.i.IPatiCudService;
import iih.pi.reg.pat.i.IPatiRService;
import iih.pi.reg.pat.i.IPiPatContDOCudService;
import iih.pi.reg.pat.i.IPiPatContDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 更新住院信息
 * 
 * @author renying
 *
 */
public class UpdateIpInfoBP {
	/**
	 * 更新住院信息
	 * 
	 * @param ipInfoDTO
	 * @throws BizException
	 */
	public void exec(IpInfoDTO ipInfoDTO) throws BizException {
		IpEP ipep = new IpEP();
		ipep.validateInpatientDOByEntId(ipInfoDTO.getId_ent());
		this.saveAddrInfo(ipInfoDTO);
		PiPatContDO patCont = this.saveContInfo(ipInfoDTO);
		EntContEP enContEP = new EntContEP();
		enContEP.SaveEntCont(patCont, ipInfoDTO.getId_ent());
		// this.SaveEntCont(patCont, ipInfoDTO.getId_ent());
		this.updatePatDO(ipInfoDTO);
		this.saveEntTags(ipInfoDTO);
		//保存新生儿入院信息-fanlq-2018-10-31
		this.saveNbIpInfo(ipInfoDTO);
		//更新就诊表里的生日信息
		this.updateEntDtBirth(ipInfoDTO);
	}
	
	/**
	 * 更新就诊表里的生日信息
	 * 
	 * @param ipinfoDTO
	 * @throws BizException
	 */
	private void updateEntDtBirth(IpInfoDTO ipinfoDTO) throws BizException {
		if (EnValidator.isEmpty(ipinfoDTO.getId_pat()))
			return;
		PvEP pvEP = new PvEP();
		PatiVisitDO patiVisitDO = pvEP.getPvById(ipinfoDTO.getId_ent());
		patiVisitDO.setStatus(DOStatus.UPDATED);
		patiVisitDO.setDt_birth_pat(ipinfoDTO.getDt_birth_pat());
		pvEP.savePv(patiVisitDO);
	}
	
	/**
	 * 更新患者信息
	 * 
	 * @param ipinfoDTO
	 * @throws BizException
	 */
	private void updatePatDO(IpInfoDTO ipinfoDTO) throws BizException {
		if (EnValidator.isEmpty(ipinfoDTO.getId_pat()))
			return;
		IPatiRService patiRService = ServiceFinder.find(IPatiRService.class);
		IPatiCudService patiCudService = ServiceFinder.find(IPatiCudService.class);
		PatiAggDO patiAggDO = patiRService.findById(ipinfoDTO.getId_pat());
		PatDO patDO = patiAggDO.getParentDO();
		patDO.setMob(ipinfoDTO.getMob());
		patDO.setDt_birth(ipinfoDTO.getDt_birth_pat());
		patDO.setId_idtp(ipinfoDTO.getId_idtp());
		patDO.setSd_idtp(ipinfoDTO.getSd_idtp());
		patDO.setId_code(ipinfoDTO.getCode_id());
		patDO.setId_marry(ipinfoDTO.getId_marry());
		patDO.setMarry_name(ipinfoDTO.getName_marry());
		patDO.setSd_marry(ipinfoDTO.getSd_mari_pat());
		patDO.setMarry_code(ipinfoDTO.getSd_mari_pat());
		patDO.setId_sex(ipinfoDTO.getId_sex_pat());
		if(!EnValidator.isEmpty(ipinfoDTO.getId_sex_pat())){
			if(IPiDictCodeConst.ID_SEX_MALE.equals(ipinfoDTO.getId_sex_pat())){
				patDO.setSd_sex(IPiDictCodeConst.SD_SEX_MALE);
			}else if(IPiDictCodeConst.ID_SEX_FEMALE.equals(ipinfoDTO.getId_sex_pat())){
				patDO.setSd_sex(IPiDictCodeConst.SD_SEX_FEMALE);
			}else if(IPiDictCodeConst.ID_SEX_UNEXPLAIN.equals(ipinfoDTO.getId_sex_pat())){
				patDO.setSd_sex(IPiDictCodeConst.SD_SEX_UNEXPLAIN);
			}else if(IPiDictCodeConst.ID_SEX_UNKNOW.equals(ipinfoDTO.getId_sex_pat())){
				patDO.setSd_sex(IPiDictCodeConst.SD_SEX_UNKNOW);
			}
		}
		patDO.setStatus(DOStatus.UPDATED);
		patiCudService.save(new PatiAggDO[] { patiAggDO });
	}

	/**
	 * 保存地址信息
	 * 
	 * @param ipinfoDTO
	 * @throws BizException
	 */
	private void saveAddrInfo(IpInfoDTO ipinfoDTO) throws BizException {
		if (!EnValidator.isEmpty(ipinfoDTO.getId_admdiv())) {// 现住址
			PatiAddrDO patAddrDO = this.setAddrDOStatus(ipinfoDTO.getId_pat());
			patAddrDO.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_NOW);
			patAddrDO.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
			patAddrDO.setId_admdiv(ipinfoDTO.getId_admdiv());
			patAddrDO.setAdmdiv_name(ipinfoDTO.getName_admdiv());
			patAddrDO.setSd_admdiv(ipinfoDTO.getSd_admdiv());
			patAddrDO.setStreet(ipinfoDTO.getAddr());
			patAddrDO.setId_pat(ipinfoDTO.getId_pat());
			IPatiAddrDOCudService addRService = ServiceFinder.find(IPatiAddrDOCudService.class);
			addRService.save(new PatiAddrDO[] { patAddrDO });
		}
	}

	/**
	 * 得到pataddrdo 地址do
	 * 
	 * @param addrTypeID
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private PatiAddrDO setAddrDOStatus(String patId) throws BizException {
		PatiAddrDO patAddrDO = null;
		IPatiAddrDORService addRService = ServiceFinder.find(IPatiAddrDORService.class);
		PatiAddrDO[] patAddrDOArr = addRService.find(PatiAddrDODesc.TABLE_ALIAS_NAME + ".id_pat ='" + patId + "' and " + PatiAddrDODesc.TABLE_ALIAS_NAME + ".id_addrtp = '" + IPiDictCodeConst.ID_ADDR_TYPE_NOW + "'", "", FBoolean.FALSE);
		if (EnValidator.isEmpty(patAddrDOArr)) {
			patAddrDO = new PatiAddrDO();
			patAddrDO.setStatus(DOStatus.NEW);
			return patAddrDO;
		}
		patAddrDO = patAddrDOArr[0];
		patAddrDO.setStatus(DOStatus.UPDATED);
		return patAddrDO;
	}

	/**
	 * 保存联系人
	 * 
	 * @param ipinfoDTO
	 * @throws BizException
	 */
	private PiPatContDO saveContInfo(IpInfoDTO ipinfoDTO) throws BizException {
		if (EnValidator.isEmpty(ipinfoDTO.getId_conttp())
				&& EnValidator.isEmpty(ipinfoDTO.getName_cont())
				&& EnValidator.isEmpty(ipinfoDTO.getConttel())) {
			//删除就诊联系人
			EntContEP ep = new EntContEP();
			ep.deleteEntCont(ipinfoDTO.getId_ent());
			return null;
		}

		PiPatContDO patContDO = this.setPatContStatus(ipinfoDTO);
		patContDO.setId_pat(ipinfoDTO.getId_pat());
		patContDO.setName(ipinfoDTO.getName_cont());
		patContDO.setId_conttp(ipinfoDTO.getId_conttp());
		patContDO.setConttp_name(ipinfoDTO.getName_conttp());
		patContDO.setConttel(ipinfoDTO.getConttel());
		patContDO.setContaddr(ipinfoDTO.getContaddr());
		IPiPatContDOCudService pipatCudService = ServiceFinder.find(IPiPatContDOCudService.class);
		return pipatCudService.save(new PiPatContDO[] { patContDO })[0];
	}

	/**
	 * 保存患者联系人信息
	 * 
	 * @param enhosPatDTO
	 * @return
	 * @throws BizException
	 */
	private PiPatContDO setPatContStatus(IpInfoDTO ipinfoDTO) throws BizException {

		if (EnValidator.isEmpty(ipinfoDTO.getName_cont()) && EnValidator.isEmpty(ipinfoDTO.getName_conttp()) && EnValidator.isEmpty(ipinfoDTO.getConttel()) && EnValidator.isEmpty(ipinfoDTO.getContaddr()))
			return null;// 如果患者姓名、类型、电话、地址都为空，就返回空
		PiPatContDO piContDO = null;
		int sortNo = 0;
		// 如果患者不为空，说明已经注册了
		if (!EnValidator.isEmpty(ipinfoDTO.getId_pat())) {
			IPiPatContDORService rservice = ServiceFinder.find(IPiPatContDORService.class);
			PiPatContDO[] patConts = rservice.find(PiPatContDODesc.TABLE_ALIAS_NAME + ".id_pat = '" + ipinfoDTO.getId_pat() + "'", "", FBoolean.FALSE);

			if (!EnValidator.isEmpty(patConts)) {
				for (PiPatContDO contDO : patConts) {
					if (!EnValidator.isEmpty(ipinfoDTO.getId_patcont())) {
						if (contDO.getId_patcont().equals(ipinfoDTO.getId_patcont())) {
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

		piContDO.setId_pat(ipinfoDTO.getId_pat());
		piContDO.setId_conttp(ipinfoDTO.getId_conttp());
		piContDO.setSd_conttp(ipinfoDTO.getSd_conttp());
		// piContDO.setName(enhosreg.getCont_name());
		piContDO.setName(ipinfoDTO.getName_cont());
		piContDO.setConttel(ipinfoDTO.getConttel());
		piContDO.setContaddr(ipinfoDTO.getContaddr());

		// if (piContDO.getStatus() == DOStatus.NEW) {
		// patiAggdo.setPiPatContDO(new PiPatContDO[] { piContDO });
		// }
		return piContDO;
	}
	
	/**
	 * 
	 * @Description: 保存 就诊标签
	 * @param ipinfoDTO
	 * @throws BizException
	 * @author: lilei
	 * @date: 2018年9月14日 下午5:22:27
	 */
	private void saveEntTags(IpInfoDTO ipinfoDTO)  throws BizException {
		IEntagtpRService iEntagtpRService = ServiceFinder.find(IEntagtpRService.class);
		IEntagtpCudService iEntagtpCudService = ServiceFinder.find(IEntagtpCudService.class);
		ITagtpRService iTagtpRService = ServiceFinder.find(ITagtpRService.class);
		//1.获取患者原来的标签
		EnTagTpDO[] tagTpDos = iEntagtpRService.findByAttrValString(EnTagTpDO.ID_ENT, ipinfoDTO.getId_ent());
		// 获取现在的标签
		String tagtpStr = ipinfoDTO.getId_tagtp();
		//2.通过 id_tagtp 和现在的获得的标签对比，
		//如果没有选
		if (EnValidator.isEmpty(tagtpStr)){
			if(tagTpDos.length > 0 ){
				//全部删除
				iEntagtpCudService.delete(tagTpDos);
				return;
			}
		}
		if(EnValidator.isEmpty(tagTpDos) && EnValidator.isEmpty(tagtpStr)){
			return ;
		}
		//对比是不是一样
		List<String> newIds = Arrays.asList(tagtpStr.split(","));
		List<String> oldIds = new ArrayList<String>();
		for (EnTagTpDO tpDo : tagTpDos){
			oldIds.add(tpDo.getId_tagtp());
		}
		if(newIds.containsAll(oldIds) && newIds.size() == oldIds.size()){
			return;
		}
		//清空原来的
		iEntagtpCudService.delete(tagTpDos);

		//新增
		List<EnTagTpDO> newTags = new ArrayList<EnTagTpDO>();
		//fanlq-2018-09-15-循环里外调用服务
		String whereStr = EnSqlUtils.getInSqlByIds("Id_tagtp", newIds);
		BdTagTpDO[] bdTagTpDOs = iTagtpRService.find(whereStr, null, FBoolean.FALSE);
		if(bdTagTpDOs != null && bdTagTpDOs.length >0){
			for(BdTagTpDO bdTagTpDO : bdTagTpDOs){
				EnTagTpDO enTagTpDO = new EnTagTpDO();
				enTagTpDO.setId_ent(ipinfoDTO.getId_ent());
				enTagTpDO.setId_tagtp(bdTagTpDO.getId_tagtp());
				enTagTpDO.setCode_tagtp(bdTagTpDO.getCode());
				enTagTpDO.setName_tagtp(bdTagTpDO.getName());
				enTagTpDO.setDt_tag(new FDateTime());
				enTagTpDO.setId_emp_tag(ContextUtils.getPsnId());
				newTags.add(enTagTpDO);	
			}
			iEntagtpCudService.insert(newTags.toArray(new EnTagTpDO[]{}));
		}
//		for (String id : newIds){
//			BdTagTpDO bdTagTpDO= iTagtpRService.findById(id);
//			EnTagTpDO enTagTpDO = new EnTagTpDO();
//			enTagTpDO.setId_ent(ipinfoDTO.getId_ent());
//			enTagTpDO.setId_tagtp(id);
//			enTagTpDO.setCode_tagtp(bdTagTpDO.getCode());
//			enTagTpDO.setName_tagtp(bdTagTpDO.getName());
//			enTagTpDO.setDt_tag(new FDateTime());
//			enTagTpDO.setId_emp_tag(ContextUtils.getDeptId());
//			newTags.add(enTagTpDO);	
//		}
//		iEntagtpCudService.insert(newTags.toArray(new EnTagTpDO[]{}));
	}
	
	/***
	 * 保存新生儿入院信息-fanlq-2018-10-31
	 * 
	 * @param ipinfoDTO
	 * @throws BizException 
	 */
	private void saveNbIpInfo(IpInfoDTO ipinfoDTO) throws BizException{
		int days = EnParamUtils.getMaxNewbbDays();
		FDate date = EnAppUtils.getServerDate();
		int inteday = 0;
		if(ipinfoDTO.getDt_birth_pat() != null && date != null){
			inteday = DateTimeUtils.getNatDaysBetween(ipinfoDTO.getDt_birth_pat(), date);
		}
		INewbornRService rservice = ServiceFinder.find(INewbornRService.class);
		NewbornDO[] newBornDOs = rservice.find("Id_ent_bb = '"+ipinfoDTO.getId_ent()+"'", null, FBoolean.FALSE);
		if(FDoubleUtils.isNullOrZero(ipinfoDTO.getWeight()) && FDoubleUtils.isNullOrZero(ipinfoDTO.getWeight_reg()) && FDoubleUtils.isNullOrZero(ipinfoDTO.getHeight()) && inteday > days){
			return;
		}else if(newBornDOs != null && newBornDOs.length > 0 && (EnValidator.isEmpty(newBornDOs[0].getId_pat_mom()) || "~".equals(newBornDOs[0].getId_pat_mom()))){
			if((FDoubleUtils.isMoreThanZero(ipinfoDTO.getWeight()) || FDoubleUtils.isMoreThanZero(ipinfoDTO.getWeight_reg()) || FDoubleUtils.isMoreThanZero(ipinfoDTO.getHeight())) && inteday > days){
			throw new BizException("出生【"+days+"】天以上患者不能填写新生儿入院信息，请删除重新保存！");
		}
		}
		NbEP nbEP = new NbEP();
		NewbornDO newBornDO = nbEP.getNbChild(ipinfoDTO.getId_ent());
		if(newBornDO != null){
			newBornDO.setWeight(ipinfoDTO.getWeight());
			newBornDO.setWeight_reg(ipinfoDTO.getWeight_reg());
			newBornDO.setHeight(ipinfoDTO.getHeight());
			newBornDO.setStatus(DOStatus.UPDATED);
			nbEP.updateNbDOs(new NewbornDO[]{newBornDO});
		}else{
			newBornDO = new NewbornDO();
			newBornDO.setId_ent_bb(ipinfoDTO.getId_ent());
			newBornDO.setId_pat_bb(ipinfoDTO.getId_pat());
			newBornDO.setId_org(EnContextUtils.getOrgId());
			newBornDO.setId_grp(EnContextUtils.getGrpId());
			newBornDO.setNo_bb(0);
			newBornDO.setName_bb(ipinfoDTO.getName_pat());
			newBornDO.setId_sex(ipinfoDTO.getId_sex_pat());
			newBornDO.setName_sex(ipinfoDTO.getSex());
			newBornDO.setDt_birth(new FDateTime(ipinfoDTO.getDt_birth_pat().getMillis()));
			newBornDO.setId_emp_reg(EnContextUtils.getPsnId());
			newBornDO.setDt_reg(EnAppUtils.getServerDateTime());
			newBornDO.setWeight(ipinfoDTO.getWeight());
			newBornDO.setWeight_reg(ipinfoDTO.getWeight_reg());
			newBornDO.setHeight(ipinfoDTO.getHeight());
			newBornDO.setStatus(DOStatus.NEW);
			nbEP.insertNbDOs(new NewbornDO[]{newBornDO});
		}
	}
}
