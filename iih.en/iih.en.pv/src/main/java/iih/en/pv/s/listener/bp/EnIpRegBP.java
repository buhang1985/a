package iih.en.pv.s.listener.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import iih.en.comm.IEnConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.PatEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.dto.d.EnterDept4EsDTO;
import iih.en.pv.inpatient.dto.d.EnterDept4IpDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.d.desc.PatiAddrDODesc;
import iih.pi.reg.pat.i.IPatiAddrDORService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TimeZone;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;

public class EnIpRegBP {
	
	public void SetValue(EnterDept4EsDTO  esDTO,EnterDept4IpDTO enterDept4IpDTO) throws BizException, ParseException{		
		this.setValue(esDTO, enterDept4IpDTO);
		PatiVisitDO endo = this.setValueFromPativisitInfo(esDTO, enterDept4IpDTO);
		this.setValueFromEnHp(endo, enterDept4IpDTO);
		InpatientDO ipdo =this.setValueFromIpInfo(esDTO, enterDept4IpDTO);
		this.setValueFromPatAddr(esDTO, enterDept4IpDTO);
		this.setValueFromUdidoc(enterDept4IpDTO);
		this.setValueFromPatCate(esDTO, enterDept4IpDTO);//设置患者相关字段
		this.setValueFromDept(endo, enterDept4IpDTO);
		this.setGrpValue(enterDept4IpDTO);
		this.setEmergency(ipdo, enterDept4IpDTO);
		setPatCont(esDTO, enterDept4IpDTO);
	}
	
	private void setPatCont(EnterDept4EsDTO  esDTO,EnterDept4IpDTO enterDept4IpDTO) throws BizException {
		if (!EnValidator.isEmpty(esDTO.getId_pat())) {
			PatEP patep = new PatEP();
			PiPatContDO[] patConts = patep.getContDO(esDTO.getId_pat());
			if (!EnValidator.isEmpty(patConts)) {
				enterDept4IpDTO.setName_cont(patConts[0].getName());
				enterDept4IpDTO.setTel_cont_list(patConts[0].getConttel());
			}
		}
		
	}

	/**
	 * 设置值
	 * @param esDTO
	 * @param ipDTO
	 * @throws BizException 
	 * @throws ParseException 
	 */
	private void setValue(EnterDept4EsDTO  esDTO,EnterDept4IpDTO enterDept4IpDTO) throws BizException, ParseException
	{
		enterDept4IpDTO.setId_ent(esDTO.getId_ent());
		enterDept4IpDTO.setId_pat(esDTO.getId_pat());
		enterDept4IpDTO.setName_pat(esDTO.getName_pat());
		enterDept4IpDTO.setCode_ent(esDTO.getCode_ent());
		enterDept4IpDTO.setCode_entp(esDTO.getCode_enttp());
		enterDept4IpDTO.setName_entp(esDTO.getName_enttp());
		 if(esDTO.getDt_acpt() !=null){			    
			 enterDept4IpDTO.setDt_acpt(esDTO.getDt_acpt().toString(TimeZone.getDefault(),new SimpleDateFormat("yyyyMMddHHmm")));
	        }
        if(esDTO.getDt_birth_pat() !=null){
        	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        	enterDept4IpDTO.setDt_birth_pat(format.format((esDTO.getDt_birth_pat().toDate())));
        }
        enterDept4IpDTO.setName_bed(esDTO.getName_bed());	
        //enterDept4IpDTO.setAge(AgeCalcUtil.getAge(esDTO.getDt_birth_pat()));
        EnAgeCalcUtil.setDoAges(new EnterDept4IpDTO[]{enterDept4IpDTO}, "Id_ent", "Age");
        if(esDTO.getCode()!=null && esDTO.getCode().equals(IEnConst.UPDATE)){
        	enterDept4IpDTO.setCode(IEnConst.UPDATE);
        }else{
        	enterDept4IpDTO.setCode(IEnConst.NEW);
        }
        enterDept4IpDTO.setArea(IEnConst.HISAREA);
        enterDept4IpDTO.setSd_emp_zr(esDTO.getSd_emp_zr());//主任
        enterDept4IpDTO.setName_emp_zr(esDTO.getName_emp_zr());
        enterDept4IpDTO.setSd_emp_doc(esDTO.getSd_emp_doc());//住院医师
        enterDept4IpDTO.setPhy_name(esDTO.getPhy_name());
        enterDept4IpDTO.setSd_emp_zz(esDTO.getSd_emp_zz());//主治医师
        enterDept4IpDTO.setName_emp_zz(esDTO.getName_emp_zz());
        enterDept4IpDTO.setName_operator(EnContextUtils.getPsnDoc().getName());
        enterDept4IpDTO.setSd_operator(EnContextUtils.getPsnDoc().getCode());
//		if (EnValidator.isEmpty(esDTO.getSd_emp_ry()) || EnValidator.isEmpty(esDTO.getName_emp_ry())) {
//			enterDept4IpDTO.setSd_emp_doc(esDTO.getSd_emp_doc());
//			enterDept4IpDTO.setPhy_name(esDTO.getPhy_name());
//		}else {
//			enterDept4IpDTO.setSd_emp_doc(esDTO.getSd_emp_ry());
//			enterDept4IpDTO.setPhy_name(esDTO.getName_emp_ry());
//		}

	}
	
	/**
	 * 住院信息
	 * 
	 * @param esDTO
	 * @param ipDTO
	 * @throws BizException
	 */
	private InpatientDO setValueFromIpInfo(EnterDept4EsDTO esDTO, EnterDept4IpDTO enterDept4IpDTO) throws BizException {
		IpEP ipep = new IpEP();
		InpatientDO[] ipDOs = ipep.getIpDOByEntId(esDTO.getId_ent());

		if (EnValidator.isEmpty(ipDOs)) {
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_INPATIENTDO);
		}
		InpatientDO ipdo = ipDOs[0];
		enterDept4IpDTO.setTimes_ip(ipdo.getTimes_ip());
		enterDept4IpDTO.setSd_referalsrc(ipdo.getSd_referalsrc());
		enterDept4IpDTO.setReferalsrc_name(ipdo.getName_referalsrc());
		enterDept4IpDTO.setSd_level_diseadm(ipdo.getSd_level_diseadm());
		enterDept4IpDTO.setName_level_diseadm(ipdo.getName_level_diseadm());

		enterDept4IpDTO.setSd_diag(ipdo.getSd_diag_op());
		enterDept4IpDTO.setName_diag(ipdo.getName_diag_op());	
		enterDept4IpDTO.setCode_amr_ip(ipdo.getCode_amr_ip());//0164367 就诊类型为住院时，此节点值为住院号
		return ipdo;
	}

	/**
	 * 设置紧急程度，没有对应的编码，按照要求，写死了，集成平台有急，我们没有呀！！
	 * @param esDTO
	 * @param ipDTO
	 */
	private void setEmergency(InpatientDO ipdo,EnterDept4IpDTO enterDept4IpDTO){
		if(!EnValidator.isEmpty(ipdo.getSd_level_diseadm())){
			switch(ipdo.getSd_level_diseadm()){
			   case IBdFcDictCodeConst.CONDITION_GRADE_SEVERITY:
				   enterDept4IpDTO.setSd_level_diseadm("3");
				   enterDept4IpDTO.setName_level_diseadm(IEnConst.NAME_GRADE_SEVERITY);
				   break;
			   case IBdFcDictCodeConst.CONDITION_GRADE_DYING:
				   enterDept4IpDTO.setSd_level_diseadm("4");
				   enterDept4IpDTO.setName_level_diseadm(IEnConst.NAME_GRADE_DYING);
				   break;
			   case IBdFcDictCodeConst.CONDITION_GRADE_ORDINARY:
				   enterDept4IpDTO.setSd_level_diseadm("1");
				   enterDept4IpDTO.setName_level_diseadm(IEnConst.NAME_GRADE_ORDINARY);
				   break;				  
			}
		}
	}
	/**
	 * 就诊数据
	 * 
	 * @param esDTO
	 * @param ipDTO
	 * @throws BizException
	 */
	private PatiVisitDO setValueFromPativisitInfo(EnterDept4EsDTO esDTO, EnterDept4IpDTO enterDept4IpDTO) throws BizException {
		PvEP pvep = new PvEP();
		PatiVisitDO endo = pvep.getPvById(esDTO.getId_ent());
		enterDept4IpDTO.setId_ent(endo.getId_ent());
		enterDept4IpDTO.setSd_sex(endo.getSd_sex_pat());
		//enterDept4IpDTO.setAge(AgeCalcUtil.getAge(endo.getDt_birth_pat()));
		EnAgeCalcUtil.setDoAges(new EnterDept4IpDTO[]{enterDept4IpDTO}, "Id_ent", "Age");
		enterDept4IpDTO.setName_pat(endo.getName_pat());
		enterDept4IpDTO.setCode_ent(endo.getCode());
		if (IEnDictCodeConst.SD_ENTP_INPATIENT.equals(endo.getCode_entp())) {
			enterDept4IpDTO.setCode_entp("03");
			enterDept4IpDTO.setName_entp(endo.getName_entp());
		}
		return endo;

	}
	/**
	 * 住院费用即医保计划
	 * 
	 * @param esDTO
	 * @param ipDTO
	 * @throws BizException
	 */
	private void setValueFromEnHp(PatiVisitDO endo,EnterDept4IpDTO enterDept4IpDTO) throws BizException {
		if(EnValidator.isEmpty(endo.getId_hp())){
			return;
		}
		IHpMDORService rservice = ServiceFinder.find(IHpMDORService.class);
		HPDO hpDo = rservice.findById(endo.getId_hp());
		if (hpDo == null)
			return;
		enterDept4IpDTO.setSd_prim(hpDo.getCode());
		enterDept4IpDTO.setPrim_name(hpDo.getName());
		this.setValueFromDept(endo, enterDept4IpDTO);
	}

	/**
	 * 查找用户地址相关信息
	 * 
	 * @param patId
	 * @param enhosPatDTO
	 * @throws BizException
	 */
	private void setValueFromPatAddr(EnterDept4EsDTO esDTO,EnterDept4IpDTO enterDept4IpDTO) throws BizException {
		IPatiAddrDORService addRService = ServiceFinder.find(IPatiAddrDORService.class);
		PatiAddrDO[] patAddrDOArr = addRService.find(PatiAddrDODesc.TABLE_ALIAS_NAME + ".id_pat ='" + esDTO.getId_pat() + "' and Id_addrtp = '" + IPiDictCodeConst.ID_ADDR_TYPE_ORIGIN + "'", "",
				FBoolean.FALSE);
		if (EnValidator.isEmpty(patAddrDOArr)) {
			return;
		}
		PatiAddrDO addrdo = patAddrDOArr[0];
		enterDept4IpDTO.setSd_nativeaddr(addrdo.getSd_admdiv());
		if(!EnValidator.isEmpty(addrdo.getStreet()))
		{			
			enterDept4IpDTO.setName_nativeaddr(addrdo.getAdmdiv_name()+addrdo.getStreet());
		}else{
			enterDept4IpDTO.setName_nativeaddr(addrdo.getAdmdiv_name());
		}
	}
	
	/**
	 * 诊断类别
	 * @param ipDTO
	 */
	private void setValueFromUdidoc(EnterDept4IpDTO enterDept4IpDTO)
	{
		enterDept4IpDTO.setName_diag_category(IBdResDictCodeConst.NAME_DIAG_INHOS);
		enterDept4IpDTO.setSd_diag_category(IBdResDictCodeConst.SD_DIAG_INHOS);
	}
	
	/**
	 * 设置患者相关字段
	 * 
	 * @param enhosDTO
	 * @throws BizException
	 */
	private void setValueFromPatCate(EnterDept4EsDTO esDTO,EnterDept4IpDTO enterDept4IpDTO) throws BizException {
		PatEP patEP = new PatEP();
		PatDO patdo = patEP.getPatById(esDTO.getId_pat());
		if (patdo == null)
			throw new BizException(IEnMsgConst.ERROR_PAT_NOT_EXIST);
		enterDept4IpDTO.setSd_paticate(patdo.getPaticate_code());
		enterDept4IpDTO.setName_paticate(patdo.getPaticate_name());
		enterDept4IpDTO.setSd_sex(patdo.getSd_sex());
		enterDept4IpDTO.setCode_pat(patdo.getCode());
		//enterDept4IpDTO.setCode_amr_ip(patdo.getBarcode_chis());//集成平台需要的就诊号
		enterDept4IpDTO.setBarcode_chis(patdo.getBarcode_chis());//健康卡号
	}
	
	/**
	 * 查询科室信息
	 * @param lvHos4EsDTO
	 * @param ipDTO
	 * @throws BizException
	 */
	private void setValueFromDept(PatiVisitDO endo,EnterDept4IpDTO enterDept4IpDTO) throws BizException
	{
		HashSet<String> set = new HashSet<String>();
		set.add(endo.getId_dep_nur());
		set.add(endo.getId_dep_phy());
		DeptDO[] deptDO = this.getDeptInfo(set);
		if(EnValidator.isEmpty(deptDO))
			return;
		HashMap<String, DeptDO>  hashMap = this.getHashMap(deptDO);
	    this.setDeptName4DTO(hashMap, endo, enterDept4IpDTO);		
	}

	/**
	 * 查找所有的do
	 * 
	 * @param depSet
	 * @return
	 * @throws BizException
	 */
	private DeptDO[] getDeptInfo(HashSet<String> depSet) throws BizException {
		if(depSet.isEmpty())
			return null;
		IDeptRService rService = ServiceFinder.find(IDeptRService.class);
		DeptDO[] deptDOs = rService.findByIds(depSet.toArray(new String[] {}), FBoolean.FALSE);
		return deptDOs;
	}
	/**
	 * 将id和name 拼成hashMap
	 * 
	 * @param deptDOs
	 * @return
	 */
	private HashMap<String, DeptDO> getHashMap(DeptDO[] deptDOs) {
		HashMap<String, DeptDO> deptHashTable = new HashMap<String, DeptDO>();
		for (DeptDO deptdo : deptDOs) {
			deptHashTable.put(deptdo.getId_dep(), deptdo);
		}
		return deptHashTable;
	}

	/**
	 * 利用hashMap赋值name
	 * 
	 * @param deptHashTable
	 * @param transDepDTOs
	 */
	private void setDeptName4DTO(HashMap<String, DeptDO> deptHashTable,PatiVisitDO endo, EnterDept4IpDTO enterDept4IpDTO) {

		if (!EnValidator.isEmpty(endo.getId_dep_phy())) {
			if (deptHashTable.get(endo.getId_dep_phy()) != null) {
				enterDept4IpDTO.setName_dep_phy(deptHashTable.get(endo.getId_dep_phy()).getName());
				enterDept4IpDTO.setSd_dep_phy(deptHashTable.get(endo.getId_dep_phy()).getCode());
			}
		}
		if (!EnValidator.isEmpty(endo.getId_dep_nur())) {
			if (deptHashTable.get(endo.getId_dep_nur()) != null) {
				enterDept4IpDTO.setName_dep_nur(deptHashTable.get(endo.getId_dep_nur()).getName());
				enterDept4IpDTO.setSd_dep_nur(deptHashTable.get(endo.getId_dep_nur()).getCode());
			}
		}	
	}

	/**
	 * 设置机构
	 * @throws BizException
	 */
	private void setGrpValue(EnterDept4IpDTO enterDept4IpDTO) throws BizException
	{
		IOrgRService rService = ServiceFinder.find(IOrgRService.class);
		OrgDO orgDo = rService.findById(Context.get().getOrgId());
		enterDept4IpDTO.setSd_org(orgDo.getOrgcode());
		enterDept4IpDTO.setName_org(orgDo.getName());;	
	}
}
