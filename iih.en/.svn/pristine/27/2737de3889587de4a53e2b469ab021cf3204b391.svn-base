package iih.en.pv.s.listener;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import iih.en.comm.IEnConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.PatEP;
import iih.en.comm.ep.UdiDocEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.dto.d.IpReg4EsDTO;
import iih.en.pv.inpatient.dto.d.IpReg4IpDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.desc.PatiAddrDODesc;
import iih.pi.reg.pat.i.IPatiAddrDORService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TimeZone;

import xap.ip.event.BusiType;
import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 住院登记集成平台监听器
 * @author yank
 * @author renying
 *
 */
public class EnIpReg4IpListener  implements IBusinessListener {
	/**
	 * 执行
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		//1、验证事件，是否匹配
		this.validate(event);
		
		//2、包装集成平台所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj)event.getUserObject();
		IpReg4EsDTO eventSourceDTO = (IpReg4EsDTO)bizUserObj.getUserObj();
		IpReg4IpDTO reg4IpDTO = null;
		try {
			reg4IpDTO = wrapObj4Ip(eventSourceDTO);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3、触发集成平台事件
		DomainBusinessUserObj buo = new DomainBusinessUserObj(reg4IpDTO, BusiType.ZY,"0", "0");
		MsgObj msgObj = buo.getMsgObj();
		if(msgObj ==null){
			msgObj = new MsgObj();
		}
		msgObj.setApplyUnitId(reg4IpDTO.getSd_dep_phy());// 第四位申请科室遍码
		buo.setMsgObj(msgObj);
		buo.setDeptId(reg4IpDTO.getSd_dep_nur());// 第五位执行科室编码
		BusinessEvent bizEvent = new BusinessEvent(event.getSourceID(),event.getEventType(),buo);
		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
		ipEventListener.doAction(bizEvent);
	}
	/**
	 * 验证事件
	 * @param event 事件
	 * @throws BizException
	 */
	private void validate(IBusinessEvent event) throws BizException{
		if(!IEnEventConst.EVENT_SOURCE_EN_IP_REG.equalsIgnoreCase(event.getSourceID())
			|| !IEventType.TYPE_INSERT_AFTER.equals(event.getEventType())){
			throw new BizException(IEnMsgConst.ERROR_LISTENER_NOT_MATCH_EVENT);
		}		
	}
	/**
	 * 包装集成平台事件源
	 * @param ipReg4EsDTO
	 * @return
	 * @throws BizException
	 * @throws ParseException 
	 */
	private IpReg4IpDTO wrapObj4Ip(IpReg4EsDTO esDTO) throws BizException, ParseException{
		IpReg4IpDTO ipDTO = new IpReg4IpDTO();
		this.setValue(esDTO, ipDTO);
		this.setValueFromEnHp(esDTO, ipDTO);
		this.setValueFromPatAddr(esDTO, ipDTO);
		this.setValueFromUdidoc(ipDTO);
		this.setValueFromPatCate(esDTO, ipDTO);
		this.setValueFromDept(esDTO, ipDTO);
		this.setGrpValue(ipDTO);
		this.setSexValue(esDTO, ipDTO);
		this.setEmergency(esDTO, ipDTO);
		return ipDTO;
	}
	/**
	 * 设置值
	 * @param esDTO
	 * @param ipDTO
	 * @throws BizException 
	 * @throws ParseException 
	 */
	private void setValue(IpReg4EsDTO esDTO,IpReg4IpDTO ipDTO) throws BizException, ParseException
	{
		ipDTO.setId_ent(esDTO.getId_ent());
		ipDTO.setId_pat(esDTO.getId_pat());
		ipDTO.setName_pat(esDTO.getName_pat());
        if(esDTO.getDt_birth_pat() !=null){
        	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        	ipDTO.setDt_birth_pat(format.format((esDTO.getDt_birth_pat().toDate())));
        	//ipDTO.setDt_birth_pat(esDTO.getDt_birth_pat().);
        }
		ipDTO.setName_bed(esDTO.getName_bed());
		ipDTO.setTimes_ip(esDTO.getTimes_ip());
		ipDTO.setSd_referalsrc(esDTO.getSd_referalsrc());
		ipDTO.setReferalsrc_name(esDTO.getReferalsrc_name());
		ipDTO.setSd_level_diseadm(esDTO.getSd_level_diseadm());
		ipDTO.setName_level_diseadm(esDTO.getName_level_diseadm());
		ipDTO.setPrim_name(esDTO.getPrim_name());
		ipDTO.setSd_sex(esDTO.getSd_sex());
		ipDTO.setSd_diag(esDTO.getSd_diag());
		ipDTO.setName_diag(esDTO.getName_diag());		
		ipDTO.setAge(AgeCalcUtil.getAge(esDTO.getDt_birth_pat()));
		ipDTO.setSd_paticate(esDTO.getSd_paticate());
		ipDTO.setName_paticate(esDTO.getName_paticate());
		ipDTO.setCode_ent(esDTO.getCode_ent());//就诊流水号
		ipDTO.setCode_enttp(IEnConst.IPENTTP);//就诊类型编码
		ipDTO.setName_enttp("住院");//就诊类型名称
		if (!EnValidator.isEmpty(esDTO.getSd_emp_ry()) && !EnValidator.isEmpty(esDTO.getName_emp_ry())) {
			ipDTO.setSd_emp_ry(esDTO.getSd_emp_ry());
			ipDTO.setName_emp_ry(esDTO.getName_emp_ry());
		}
		 if(esDTO.getDt_acpt() !=null){			    
	        	ipDTO.setDt_acpt(esDTO.getDt_acpt().toString(TimeZone.getDefault(),new SimpleDateFormat("yyyyMMddHHmmss")));
	        }
		if(esDTO.getIsnew()!=null && esDTO.getIsnew().booleanValue()){
			ipDTO.setCode(IEnConst.NEW);
		}else{
			ipDTO.setCode(IEnConst.UPDATE);
		}
		ipDTO.setArea(IEnConst.HISAREA);

	}
	/**
	 * 设置紧急状态
	 * @throws BizException 
	 */
	private void setSexValue(IpReg4EsDTO esDTO,IpReg4IpDTO ipDTO) throws BizException{
		if(!EnValidator.isEmpty(esDTO.getSd_sex())){
			UdiDocEP ep = new UdiDocEP();
			UdidocDO udidoc = ep.getUdidocByCodeAndValue(IPiDictCodeTypeConst.SD_SEX_CODE, ipDTO.getSd_sex());
			if(udidoc !=null){
				ipDTO.setSd_sex(udidoc.getCode_ie());
			}
		}
	}
	/**
	 * 设置紧急程度，没有对应的编码，按照要求，写死了，集成平台有急，我们没有呀！！
	 * @param esDTO
	 * @param ipDTO
	 */
	private void setEmergency(IpReg4EsDTO esDTO,IpReg4IpDTO ipDTO){
		if(!EnValidator.isEmpty(esDTO.getSd_level_diseadm())){
			switch(esDTO.getSd_level_diseadm()){
			   case IBdFcDictCodeConst.CONDITION_GRADE_SEVERITY:
				   ipDTO.setSd_level_diseadm("3");
				   ipDTO.setName_level_diseadm(IEnConst.NAME_GRADE_SEVERITY);
				   break;
			   case IBdFcDictCodeConst.CONDITION_GRADE_DYING:
				   ipDTO.setSd_level_diseadm("4");
				   ipDTO.setName_level_diseadm(IEnConst.NAME_GRADE_DYING);
				   break;
			   case IBdFcDictCodeConst.CONDITION_GRADE_ORDINARY:
				   ipDTO.setSd_level_diseadm("1");
				   ipDTO.setName_level_diseadm(IEnConst.NAME_GRADE_ORDINARY);
				   break;				  
			}
		}
	}

	/**
	 * 住院费用即医保计划
	 * 
	 * @param esDTO
	 * @param ipDTO
	 * @throws BizException
	 */
	private void setValueFromEnHp(IpReg4EsDTO esDTO,IpReg4IpDTO ipDTO) throws BizException {
		if(EnValidator.isEmpty(esDTO.getId_prim())){
			return;
		}
		IHpMDORService rservice = ServiceFinder.find(IHpMDORService.class);
		HPDO hpDo = rservice.findById(esDTO.getId_prim());
		if (hpDo == null)
			return;
		ipDTO.setSd_prim(hpDo.getCode());
		ipDTO.setPrim_name(hpDo.getName());
	}

	/**
	 * 查找用户地址相关信息
	 * 
	 * @param patId
	 * @param enhosPatDTO
	 * @throws BizException
	 */
	private void setValueFromPatAddr(IpReg4EsDTO esDTO,IpReg4IpDTO ipDTO) throws BizException {
		IPatiAddrDORService addRService = ServiceFinder.find(IPatiAddrDORService.class);
		PatiAddrDO[] patAddrDOArr = addRService.find(PatiAddrDODesc.TABLE_ALIAS_NAME + ".id_pat ='" + esDTO.getId_pat() + "' and Id_addrtp = '" + IPiDictCodeConst.ID_ADDR_TYPE_ORIGIN + "'", "",
				FBoolean.FALSE);
		if (EnValidator.isEmpty(patAddrDOArr)) {
			return;
		}
		PatiAddrDO addrdo = patAddrDOArr[0];
		ipDTO.setSd_nativeaddr(addrdo.getSd_admdiv());
		if(!EnValidator.isEmpty(addrdo.getStreet()))
		{			
			ipDTO.setName_nativeaddr(addrdo.getAdmdiv_name()+addrdo.getStreet());
		}else{
			ipDTO.setName_nativeaddr(addrdo.getAdmdiv_name());
		}
	}
	
	/**
	 * 诊断类别
	 * @param ipDTO
	 */
	private void setValueFromUdidoc(IpReg4IpDTO ipDTO)
	{
		ipDTO.setName_diag_category(IBdResDictCodeConst.NAME_DIAG_INHOS);
		ipDTO.setSd_diag_category(IBdResDictCodeConst.SD_DIAG_INHOS);
	}
	
	/**
	 * 获取患者分类
	 * 
	 * @param enhosDTO
	 * @throws BizException
	 */
	private void setValueFromPatCate(IpReg4EsDTO esDTO,IpReg4IpDTO ipDTO) throws BizException {
		PatEP patEP = new PatEP();
		PatDO patdo = patEP.getPatById(esDTO.getId_pat());
		if (patdo == null)
			throw new BizException(IEnMsgConst.ERROR_PAT_NOT_EXIST);
		ipDTO.setSd_paticate(patdo.getPaticate_code());
		ipDTO.setName_paticate(patdo.getPaticate_name());
		ipDTO.setCode_pat(patdo.getCode());
		ipDTO.setCode_amr_ip(patdo.getCode_amr_ip());//集成平台需要的就诊号
	}
	
	/**
	 * 查询科室信息
	 * @param lvHos4EsDTO
	 * @param ipDTO
	 * @throws BizException
	 */
	private void setValueFromDept(IpReg4EsDTO esDTO,IpReg4IpDTO ipDTO) throws BizException
	{
		HashSet<String> set = new HashSet<String>();
		set.add(esDTO.getId_dep_nur());
		set.add(esDTO.getId_dep_phy());
		DeptDO[] deptDO = this.getDeptInfo(set);
		if(EnValidator.isEmpty(deptDO))
			return;
		HashMap<String, DeptDO>  hashMap = this.getHashMap(deptDO);
	    this.setDeptName4DTO(hashMap, esDTO, ipDTO);
		
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
	private void setDeptName4DTO(HashMap<String, DeptDO> deptHashTable,IpReg4EsDTO esDTO,IpReg4IpDTO ipDTO) {

		if (!EnValidator.isEmpty(esDTO.getId_dep_nur())) {
			if (deptHashTable.get(esDTO.getId_dep_phy()) != null) {
				ipDTO.setName_dep_phy(deptHashTable.get(esDTO.getId_dep_phy()).getName());
				ipDTO.setSd_dep_phy(deptHashTable.get(esDTO.getId_dep_phy()).getCode());
			}
		}
		if (!EnValidator.isEmpty(esDTO.getId_dep_phy())) {
			if (deptHashTable.get(esDTO.getId_dep_nur()) != null) {
				ipDTO.setName_dep_nur(deptHashTable.get(esDTO.getId_dep_nur()).getName());
				ipDTO.setSd_dep_nur(deptHashTable.get(esDTO.getId_dep_nur()).getCode());
			}
		}

	}
	
	/**
	 * 设置机构
	 * @throws BizException
	 */
	private void setGrpValue( IpReg4IpDTO ipDTO) throws BizException
	{
		IOrgRService rService = ServiceFinder.find(IOrgRService.class);
		OrgDO orgDo = rService.findById(Context.get().getOrgId());
		ipDTO.setSd_org(orgDo.getOrgcode());
		ipDTO.setName_org(orgDo.getName());;
	
	}
}
