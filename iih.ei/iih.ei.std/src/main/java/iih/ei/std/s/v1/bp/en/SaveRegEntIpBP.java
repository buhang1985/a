package iih.ei.std.s.v1.bp.en;

import java.util.ArrayList;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.bd.fc.ipspectp.d.BdEnIpSpecDO;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.i.IDiagdefMDORService;
import iih.ei.std.d.v1.en.entipreginfo.d.EntIpRegInfoParamDTO;
import iih.ei.std.d.v1.en.entipreginfo.d.EntIpRegInfoResultDTO;
import iih.ei.std.d.v1.utils.EiValidator;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.common.DeptEP;
import iih.ei.std.s.v1.bp.common.EiAdminAreaEP;
import iih.ei.std.s.v1.bp.common.EiCodeUtils;
import iih.ei.std.s.v1.bp.common.EiUdidocEP;
import iih.ei.std.s.v1.bp.common.PatEP;
import iih.ei.std.s.v1.bp.common.PsnDocEP;
import iih.en.pv.dto.d.EnHosRegDTO;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.entdi.i.IEntdiRService;
import iih.en.pv.i.IEnIpCmdService;
import iih.en.pv.i.IEnIpQryService;
import iih.en.pv.inpatient.dto.d.EnHosPatDTO;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.aptip.i.IAptipMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.bdfw.bbd.d.AdminAreaDO;
import xap.sys.bdfw.bbd.d.CountryZoneDO;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.ICountryzoneRService;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.xbd.udi.d.UdidocDO;
/***
 * 保存住院登记
 * @author li.wm
 * @date: 2019年11月28日 
 */
public class SaveRegEntIpBP extends IIHServiceBaseBP<EntIpRegInfoParamDTO, EntIpRegInfoResultDTO> {
	/**
	 * 操作类型-修改
	 */
	private static final String OPERTP_UPDATE = "1";
	/**
	 * 操作类型-增加
	 */
	private static final String OPERTP_NEW = "0";
	/***
	 * 参数校验
	 * @param param
	 */
	@Override
	protected void checkParam(EntIpRegInfoParamDTO param) throws BizException {
		if(StringUtils.isNullOrEmpty(param.getOpertp())){
			throw new BizException("参数操作类型不能为空！");
		}
		
		if(StringUtils.isNullOrEmpty(param.getCode_pat())){
			throw new BizException("患者编码不能为空！");
		}
		
		if(StringUtils.isNullOrEmpty(param.getName())){
			throw new BizException("患者姓名不能为空！");
		}
		
		if (OPERTP_UPDATE.equals(param.getOpertp())){
			if (StringUtils.isNullOrEmpty(param.getCode_amr_ip())){
				throw new BizException("保存住院时，住院档案号不能为空！");
			}
			if (StringUtils.isNullOrEmpty(param.getTimes_ip())){
				throw new BizException("保存住院时，住院次数不能为空！");
			}
		}
		if (OPERTP_NEW.equals(param.getOpertp())){
			if (StringUtils.isNullOrEmpty(param.getId_scaptip())){
				throw new BizException("新增住院时，入院许可证不能空！");
			}
		}
		
			
	}
	/***
	 * 过程
	 * @param param
	 */
	@Override
	protected EntIpRegInfoResultDTO process(EntIpRegInfoParamDTO param) throws BizException {
		//获取出参
		EntIpRegInfoResultDTO result= new EntIpRegInfoResultDTO();
		
		IEnIpCmdService iService = ServiceFinder.find(IEnIpCmdService.class);
		//获取自定义档案Map
		Map<String, Map<String, UdidocDO>> udilistMap = this.getUdidocListMap();
		//设置患者DTO数据
		EnHosPatDTO enHosPat = this.getEnHosPatInfo(param, udilistMap);
		//设置就诊DTO数据
		EnHosRegDTO enHosReg = this.getEnHosRegInfo(param, enHosPat, udilistMap);
		//数据校验
		iService.validateIPData(enHosPat, enHosReg, FBoolean.TRUE);
		//保存患者信息
		enHosPat = iService.savePatInfo(enHosPat, enHosReg);
		//保存就诊信息
		iService.regAndPatReg(enHosPat, enHosReg);
		//设置返回结果
		this.getResultInfo(result, enHosPat, enHosReg);
		return result;
	}
	
	/**
	 * 批量获取自定义档案
	 * @return
	 * @throws BizException
	 */
	private Map<String, Map<String, UdidocDO>> getUdidocListMap() throws BizException{
		ArrayList<String> udiCodeList = new ArrayList<String>();
		udiCodeList.add(IPiDictCodeTypeConst.SD_SEX_CODE);
		udiCodeList.add(IPiDictCodeTypeConst.SD_IDTP);
		udiCodeList.add(IPiDictCodeTypeConst.SD_MARRY);
		udiCodeList.add(IPiDictCodeTypeConst.SD_NATION);
		udiCodeList.add(IPiDictCodeTypeConst.SD_OCCU);
		udiCodeList.add(IPiDictCodeTypeConst.SD_CONTTP);
		udiCodeList.add(IEnDictCodeTypeConst.CODE_UDIDOCLIST_IP);
		udiCodeList.add(IEnDictCodeTypeConst.SD_STATUS_DISE);
		Map<String, Map<String, UdidocDO>> udiListMap = 
				new EiUdidocEP().getUdiDocsMapByCodes(udiCodeList.toArray(new String[0]));
		return udiListMap;
	}
	
	/**
	 * 批量获取行政区划
	 * @param params
	 * @return
	 * @throws BizException
	 */
	private Map<String, AdminAreaDO> getAdminAreaMap(EntIpRegInfoParamDTO params) throws BizException{
		ArrayList<String> list = new ArrayList<String>();
		if (!StringUtil.isEmpty(params.getSd_admdiv_nati())) {//籍贯
			list.add(params.getSd_admdiv_nati());
		}
		if (!StringUtil.isEmpty(params.getBirth_sd_admdiv())) {//出生地
			list.add(params.getBirth_sd_admdiv());
		}
		if (!StringUtil.isEmpty(params.getCuraddr_sd_admdiv())) {//现住址
			list.add(params.getCuraddr_sd_admdiv());
		}
		if (!StringUtil.isEmpty(params.getWorkunit_sd_admdiv())) {//单位地址
			list.add(params.getWorkunit_sd_admdiv());
		}
		if (!StringUtil.isEmpty(params.getIdent_sd_admdiv())) {//户口地址
			list.add(params.getIdent_sd_admdiv());
		}
		if (list.isEmpty()) {
			return null;
		}
		Map<String, AdminAreaDO> adminAreaMap = 
				new EiAdminAreaEP().getAdminAreasByCodeList(list.toArray(new String[0]));
		return adminAreaMap;
	}
	
	/**
	 * 设置患者DTO数据
	 * @param params
	 * @param enHosPat
	 * @param enHosReg
	 * @throws BizException 
	 */
	private EnHosPatDTO getEnHosPatInfo(EntIpRegInfoParamDTO params, Map<String, Map<String, UdidocDO>> udilistMap) throws BizException{
		EnHosPatDTO enHosPat = new EnHosPatDTO();
		ICountryzoneRService iCountryzoneRService = ServiceFinder.find(ICountryzoneRService.class);
		Map<String, AdminAreaDO> adminAreaMap = this.getAdminAreaMap(params);
		PatDO[] patis = new PatEP().getMRServ().findByAttrValString("Code", params.getCode_pat());
		if (EiValidator.isEmpty(patis)) {
			throw new BizException("没有获取到患者信息！");
		}
		enHosPat.setId_pat(patis[0].getId_pat());
		enHosPat.setCode_amr_ip(params.getCode_amr_ip());
		enHosPat.setName_pat(params.getName());
		enHosPat.setCode_pat(params.getCode_pat());
		//性别
		if (!StringUtil.isEmpty(params.getSd_sex())) {
			if (udilistMap != null && udilistMap.containsKey(IPiDictCodeTypeConst.SD_SEX_CODE)
					&& udilistMap.get(IPiDictCodeTypeConst.SD_SEX_CODE).containsKey(params.getSd_sex())) {
				UdidocDO sex = udilistMap.get(IPiDictCodeTypeConst.SD_SEX_CODE).get(params.getSd_sex());
				enHosPat.setId_sex(sex.getId_udidoc());
				enHosPat.setSd_sex(sex.getCode());
				enHosPat.setName_sex(sex.getName());
			}else{
				throw new BizException("未获取到患者性别");
			}
		}else{
			throw new BizException("未获取到患者性别");
		}
		//出生日期
		if(!StringUtil.isEmpty(params.getDt_birth())){
			enHosPat.setDt_birth(new FDate(params.getDt_birth()));
			try {
				enHosPat.setDt_birth_hms(new FDateTime(params.getDt_birth()));
			} catch (Exception e) {
				enHosPat.setDt_birth_hms(new FDateTime(params.getDt_birth()+" 00:00:00"));
			}
			
			enHosPat.setAge(AgeCalcUtil.getAge(enHosPat.getDt_birth()));
		}else{
			throw new BizException("未获取到患者出生日期");
		}
		//移动电话
		if (!StringUtil.isEmpty(params.getTelno())) {
			enHosPat.setMob(params.getTelno());
		}else{
			throw new BizException("未获取到患者的移动电话");
		}
		//证件类型
		if (!StringUtil.isEmpty(params.getSd_idtp())) {
			if (udilistMap != null && udilistMap.containsKey(IPiDictCodeTypeConst.SD_IDTP)
					&& udilistMap.get(IPiDictCodeTypeConst.SD_IDTP).containsKey(params.getSd_idtp())) {
				UdidocDO idTp = udilistMap.get(IPiDictCodeTypeConst.SD_IDTP).get(params.getSd_idtp());
				enHosPat.setId_idtp(idTp.getId_udidoc());
				enHosPat.setSd_idtp(idTp.getCode());
				enHosPat.setName_idtp(idTp.getName());
			}else{
				throw new BizException("未获取到患者的证件类型");
			}
		}else{
			throw new BizException("未获取到患者的证件类型");
		}
		//证件号码
		if (!StringUtil.isEmpty(params.getId_code())) {
			enHosPat.setId(params.getId_code());
		}else{
			throw new BizException("未获取到患者的证件号码");
		}
		//婚否
		if (!StringUtil.isEmpty(params.getSd_marry())) {
			if (udilistMap != null && udilistMap.containsKey(IPiDictCodeTypeConst.SD_MARRY)
					&& udilistMap.get(IPiDictCodeTypeConst.SD_MARRY).containsKey(params.getSd_marry())) {
				UdidocDO marry = udilistMap.get(IPiDictCodeTypeConst.SD_MARRY).get(params.getSd_marry());
				enHosPat.setId_marry(marry.getId_udidoc());
				enHosPat.setSd_marry(marry.getCode());
				enHosPat.setName_marry(marry.getName());
			}
		}
		//国家地区
		if (!StringUtil.isEmpty(params.getSd_country())) {
			CountryZoneDO[] countrys = iCountryzoneRService.findByAttrValString("Code", params.getSd_country());
			if(countrys != null){
				enHosPat.setId_country(countrys[0].getId_countryzone());
				enHosPat.setSd_country(countrys[0].getCode());
				enHosPat.setName_country(countrys[0].getName());
			}
		}
		//籍贯-行政区划
		if (!StringUtil.isEmpty(params.getSd_admdiv_nati())) {
			if (adminAreaMap != null && adminAreaMap.containsKey(params.getSd_admdiv_nati())) {
				AdminAreaDO nativeaddr = adminAreaMap.get(params.getSd_admdiv_nati());
				enHosPat.setId_nativeaddr(nativeaddr.getId_adminarea());
				enHosPat.setSd_nativeaddr(nativeaddr.getCode());
				enHosPat.setName_nativeaddr(nativeaddr.getName());
			}
		}
		//民族
		if (!StringUtil.isEmpty(params.getSd_nation())) {
			if (udilistMap != null && udilistMap.containsKey(IPiDictCodeTypeConst.SD_NATION)
					&& udilistMap.get(IPiDictCodeTypeConst.SD_NATION).containsKey(params.getSd_nation())) {
				UdidocDO nation = udilistMap.get(IPiDictCodeTypeConst.SD_NATION).get(params.getSd_nation());
				enHosPat.setId_nation(nation.getId_udidoc());
				enHosPat.setSd_nation(nation.getCode());
				enHosPat.setName_nation(nation.getName());
			}
		}
		//现住址-行政区划
		if (!StringUtil.isEmpty(params.getCuraddr_sd_admdiv())) {
			if (adminAreaMap != null && adminAreaMap.containsKey(params.getCuraddr_sd_admdiv())) {
				AdminAreaDO admdiv = adminAreaMap.get(params.getCuraddr_sd_admdiv());
				enHosPat.setId_admdiv(admdiv.getId_adminarea());
				enHosPat.setSd_admdiv(admdiv.getCode());
				enHosPat.setName_admdiv(admdiv.getName());
			}
		}
		enHosPat.setAddr_pat(params.getCuraddr_dtl());
		enHosPat.setPostcode_addr(params.getCurzipcode());
		enHosPat.setWorkplace(params.getWorkunit());
		//单位地址-行政区划
		if (!StringUtil.isEmpty(params.getWorkunit_sd_admdiv())) {
			if (adminAreaMap != null && adminAreaMap.containsKey(params.getWorkunit_sd_admdiv())) {
				AdminAreaDO admdivWork = adminAreaMap.get(params.getWorkunit_sd_admdiv());
				enHosPat.setId_admdiv_work(admdivWork.getId_adminarea());
				enHosPat.setSd_admdiv_work(admdivWork.getCode());
				enHosPat.setName_admdiv_work(admdivWork.getName());
			}
		}
		enHosPat.setDetail_addr_work(params.getWorkunit_addrstr());
		enHosPat.setPostcode_work(params.getWorkunit_zipcode());
		enHosPat.setTel_work(params.getWorkunit_tel());
		//户口地址-行政区划
		if (!StringUtil.isEmpty(params.getIdent_sd_admdiv())) {
			if (adminAreaMap != null && adminAreaMap.containsKey(params.getIdent_sd_admdiv())) {
				AdminAreaDO admdivResi = adminAreaMap.get(params.getIdent_sd_admdiv());
				enHosPat.setId_admdiv_resi(admdivResi.getId_adminarea());
				enHosPat.setSd_admdiv_resi(admdivResi.getCode());
				enHosPat.setName_admdiv_resi(admdivResi.getName());
			}
		}
		enHosPat.setDetail_addr_resi(params.getIdent_addrstr());
		enHosPat.setPostcode_resi(params.getIdent_zip());
		//出生地-行政区划
		if (!StringUtil.isEmpty(params.getBirth_sd_admdiv())) {
			if (adminAreaMap != null && adminAreaMap.containsKey(params.getBirth_sd_admdiv())) {
				AdminAreaDO birthAddr = adminAreaMap.get(params.getBirth_sd_admdiv());
				enHosPat.setId_birth_addr(birthAddr.getId_adminarea());
				enHosPat.setSd_birth_addr(birthAddr.getCode());
				enHosPat.setName_birth_addr(birthAddr.getName());
			}
		}
		//职业
		if (!StringUtil.isEmpty(params.getSd_occu())) {
			if (udilistMap != null && udilistMap.containsKey(IPiDictCodeTypeConst.SD_OCCU)
					&& udilistMap.get(IPiDictCodeTypeConst.SD_OCCU).containsKey(params.getSd_occu())) {
				UdidocDO occu = udilistMap.get(IPiDictCodeTypeConst.SD_OCCU).get(params.getSd_occu());
				enHosPat.setId_job(occu.getId_udidoc());
				enHosPat.setSd_job(occu.getCode());
				enHosPat.setName_job(occu.getName());
			}
		}
		//联系人类型
		if (!StringUtil.isEmpty(params.getCont_sd_conttp())) {
			if (udilistMap != null && udilistMap.containsKey(IPiDictCodeTypeConst.SD_CONTTP)
					&& udilistMap.get(IPiDictCodeTypeConst.SD_CONTTP).containsKey(params.getCont_sd_conttp())) {
				UdidocDO cont = udilistMap.get(IPiDictCodeTypeConst.SD_CONTTP).get(params.getCont_sd_conttp());
				enHosPat.setId_conttp(cont.getId_udidoc());
				enHosPat.setSd_conttp(cont.getCode());
				enHosPat.setName_conttp(cont.getName());
			}
		}
		enHosPat.setName_patcontref(params.getCont_name());
		enHosPat.setConttel(params.getCont_tel());
		enHosPat.setContaddr(params.getCont_addrstr());
		
		return enHosPat;
	}
		
	/**
	 * 设置就诊DTO数据
	 * @param params
	 * @param enHosPat
	 * @return
	 * @throws BizException
	 */
	private EnHosRegDTO getEnHosRegInfo(EntIpRegInfoParamDTO params, EnHosPatDTO enHosPat, Map<String, Map<String, UdidocDO>> udilistMap) throws BizException {
		EnHosRegDTO enHosReg = new EnHosRegDTO();
		if(OPERTP_UPDATE.equals(params.getOpertp())) {
			IEnIpQryService iQryService = ServiceFinder.find(IEnIpQryService.class);
			EnHosRegDTO[] enHosRegs = iQryService.getHosRegInfo(enHosPat.getId_pat());
			for (EnHosRegDTO enHosRegDTO : enHosRegs) {
				if (params.getTimes_ip().equals(enHosRegDTO.getTimes().toString())) {
					enHosReg = enHosRegDTO;
					enHosReg.setStatus(DOStatus.UPDATED);
					break;
				}
			}
		}
		if (OPERTP_NEW.equals(params.getOpertp())) {
			enHosReg.setStatus(DOStatus.NEW);
			enHosReg.setId_pat(enHosPat.getId_pat());
			//就诊类型
			enHosReg.setId_entp("@@@@AA10000000004O83");
			enHosReg.setCode_entp("10");
			enHosReg.setName_entp("住院");
			//生成就诊编码
			enHosReg.setCode_ent(EiCodeUtils.createEntCode());
			//患者分类、价格分类、信用分类
			PiPatCaDO piPatCa = new PatEP().getPatDefaultCate();
			enHosReg.setId_paticate(piPatCa.getId_patca());
			enHosReg.setId_pripat(piPatCa.getId_patpritp());
			enHosReg.setId_patcret(piPatCa.getId_patcrettp());
		}
		//入院时间
		if (!StringUtil.isEmpty(params.getDt_entry())) {			
			try {
				enHosReg.setDt_entry(new FDateTime(params.getDt_entry()));
			} catch (Exception e) {
				enHosReg.setDt_entry(new FDateTime(params.getDt_entry()+" 00:00:00"));
			}
			
		}else{
			throw new BizException("未获取到患者的入院时间");
		}
		//入院方式
		if (!StringUtil.isEmpty(params.getSd_referalsrc())) {
			if (udilistMap != null && udilistMap.containsKey(IEnDictCodeTypeConst.CODE_UDIDOCLIST_IP)
					&& udilistMap.get(IEnDictCodeTypeConst.CODE_UDIDOCLIST_IP).containsKey(params.getSd_referalsrc())) {
				UdidocDO referalsrc = udilistMap.get(IEnDictCodeTypeConst.CODE_UDIDOCLIST_IP).get(params.getSd_referalsrc());
				enHosReg.setId_referalsrc(referalsrc.getId_udidoc());
				enHosReg.setSd_referalsrc(referalsrc.getCode());
				enHosReg.setReferalsrc_name(referalsrc.getName());
			}
		}else{
			enHosReg.setId_referalsrc(IEnDictCodeConst.ID_REFERALSRC_OUTPATIENT);
			enHosReg.setSd_referalsrc(IEnDictCodeConst.SD_REFERALSRC_OUTPATIENT);
			enHosReg.setReferalsrc_name("门诊");
		}
		if (!StringUtil.isEmpty(params.getId_scaptip())) {
			enHosReg.setId_ent_ipnt(params.getId_scaptip());
			IAptipMDORService iAptipRService = ServiceFinder.find(IAptipMDORService.class);
			AptIpDO aptIp = iAptipRService.findById(params.getId_scaptip());
			if (aptIp == null) {
				throw new BizException("未获取到入院许可证！");
			}
			//入院申请单状态
			enHosReg.setApt_status(aptIp.getSd_status());
			//入院医生
			if(!StringUtil.isEmpty(aptIp.getId_emp_phy_op())){
				PsnDocDO psnDoc = new PsnDocEP().getPsnById(aptIp.getId_emp_phy_op());
				if (psnDoc != null) {
					enHosReg.setId_emp_phy_op(psnDoc.getId_psndoc());
					enHosReg.setCode_emp_phy_op(psnDoc.getCode());
					enHosReg.setName_emp_phy_op(psnDoc.getName());
				}else{
					throw new BizException("未获取到患者的入院医生");
				}
			}else{
				throw new BizException("未获取到患者的入院医生");
			}
			//入院科室
			if (!StringUtil.isEmpty(aptIp.getId_dep_phy_ip())) {
				DeptDO phyadm = new DeptEP().getDeptById(aptIp.getId_dep_phy_ip());
				if(phyadm != null){
					enHosReg.setId_dep_phyadm(phyadm.getId_dep());
					enHosReg.setCode_dep_phyadm(phyadm.getCode());
					enHosReg.setPhy_name(phyadm.getName());
				}else{
					throw new BizException("未获取到患者的入院科室");
				}
			}else{
				throw new BizException("未获取到患者的入院科室");
			}
			//入院病区
			if (!StringUtil.isEmpty(aptIp.getId_dep_nur_ip())) {
				DeptDO nuradm = new DeptEP().getDeptById(aptIp.getId_dep_nur_ip());
				if(nuradm != null){
					enHosReg.setId_dep_nuradm(nuradm.getId_dep());
					enHosReg.setCode_dep_nuradm(nuradm.getCode());
					enHosReg.setNur_name(nuradm.getName());
				}else{
					throw new BizException("未获取到患者的入院病区");
				}
			}else{
				throw new BizException("未获取到患者的入院病区");
			}
			//入院病情
			if (!StringUtil.isEmpty(aptIp.getSd_level_dise())) {
				if (udilistMap != null && udilistMap.containsKey(IEnDictCodeTypeConst.SD_STATUS_DISE)
						&& udilistMap.get(IEnDictCodeTypeConst.SD_STATUS_DISE).containsKey(aptIp.getSd_level_dise())) {
					UdidocDO diseadm = udilistMap.get(IEnDictCodeTypeConst.SD_STATUS_DISE).get(aptIp.getSd_level_dise());
					enHosReg.setId_level_diseadm(diseadm.getId_udidoc());
					enHosReg.setSd_level_diseadm(diseadm.getCode());
					enHosReg.setName_level_diseadm(diseadm.getName());
				}else{
					throw new BizException("未获取到患者的入院病情");
				}
			}else{
				throw new BizException("未获取到患者的入院病情");
			}
			//门诊主要诊断
			//优先取预诊，没有取门诊主诊断
			if (!StringUtil.isEmpty(aptIp.getId_didef_op())) {
				IDiagdefMDORService iDiagdefRService = ServiceFinder.find(IDiagdefMDORService.class);
				DiagDefDO diagDef = iDiagdefRService.findById(aptIp.getId_didef_op());
				if(diagDef != null){
					enHosReg.setId_diag(diagDef.getId_didef());
					enHosReg.setSd_diag(diagDef.getCode());
					enHosReg.setDia_name(diagDef.getName());
				}
			}else {
				IEntdiRService iEntdiRService = ServiceFinder.find(IEntdiRService.class);
				String whereStr = " id_ent = '"+ aptIp.getId_ent() +"' and fg_maj = 'Y' ";
				EntDiDO[] entDis = iEntdiRService.find(whereStr, "", FBoolean.FALSE);
				if (entDis != null && entDis.length >= 1) {
					enHosReg.setId_diag(entDis[0].getId_didef_dis());
					enHosReg.setSd_diag(entDis[0].getCode_didef_dis());
					enHosReg.setDia_name(entDis[0].getName_didef_dis());
				}
			}
			enHosReg.setDesc_diag(aptIp.getSupplement_di());
		}
		//设置 入院特定类型
		if(StringUtils.isEmptyOrWhitespaceOnly(params.getSd_ip_spec())){
			enHosReg.setSd_ip_spec(BdEnIpSpecDO.SD_IP_SPEC);
		}else{
			enHosReg.setSd_ip_spec(params.getSd_ip_spec());
		}
		return enHosReg;
	}
	
	/**
	 * 设置返回结果
	 * @param resultBean
	 * @param enHosPat
	 * @param enHosReg
	 */
	private void getResultInfo(EntIpRegInfoResultDTO result, EnHosPatDTO enHosPat, EnHosRegDTO enHosReg){

		result.setCode_pat(enHosPat.getCode_pat());
		result.setCode_amr_ip(enHosPat.getCode_amr_ip());
		result.setTimes_ip(Integer.toString(enHosReg.getTimes()));
	}
}
