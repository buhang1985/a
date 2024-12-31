package iih.en.pv.s.listener;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.comm.IEnConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.PatEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.dto.d.EnterDept4EsDTO;
import iih.en.pv.inpatient.dto.d.EnterDept4IpDTO;
import iih.en.pv.inpatient.dto.d.IpReg4IpDTO;
import iih.en.pv.s.listener.bp.EnIpRegBP;
import iih.pi.reg.pat.d.PatDO;

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
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;

/**
 * 住院登记集成平台监听器
 * 
 * @author yank
 * @author renying
 *
 */
public class EnIpEnterDept4IpListener implements IBusinessListener {
	/**
	 * 执行
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 1、验证事件，是否匹配
		this.validate(event);

		// 2、包装集成平台所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		EnterDept4EsDTO eventSourceDTO = (EnterDept4EsDTO) bizUserObj.getUserObj();
		EnterDept4IpDTO enterDept4IpDTO = null;
		try {
			enterDept4IpDTO = wrapObj4Ip(eventSourceDTO);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DomainBusinessUserObj buo = new DomainBusinessUserObj(enterDept4IpDTO, BusiType.ZY,"0", "0");
		buo.setDeptId(enterDept4IpDTO.getSd_dep_nur());// 第五位 执行科室编码
		MsgObj msgObj = new MsgObj();
		msgObj.setApplyUnitId(enterDept4IpDTO.getSd_dep_phy());// 第四位 申请科室编码
		buo.setMsgObj(msgObj);
		// 3、触发集成平台事件
		BusinessEvent bizEvent = new BusinessEvent(event.getSourceID(), event.getEventType(), buo);
		BusinessEventListener ipEventListener = ServiceFinder.find(BusinessEventListener.class);
		ipEventListener.doAction(bizEvent);
	}

	/**
	 * 验证事件
	 * 
	 * @param event
	 *            事件
	 * @throws BizException
	 */
	private void validate(IBusinessEvent event) throws BizException {
		if (!IEnEventConst.EVENT_SOURCE_EN_IP_IN_DEPT.equalsIgnoreCase(event.getSourceID()) || !IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType())) {
			throw new BizException(IEnMsgConst.ERROR_LISTENER_NOT_MATCH_EVENT);
		}
	}

	/**
	 * 包装集成平台事件源
	 * 
	 * @param enterDept4EsDTO
	 * @return
	 * @throws BizException
	 * @throws ParseException 
	 */
	private EnterDept4IpDTO wrapObj4Ip(EnterDept4EsDTO esDTO) throws BizException, ParseException {
		EnterDept4IpDTO enterDept4IpDTO = new EnterDept4IpDTO();
		EnIpRegBP bp =new EnIpRegBP();
		bp.SetValue(esDTO, enterDept4IpDTO);
//		IpReg4IpDTO ipDTO = new IpReg4IpDTO();
//		// 1、把已有数据赋值
//		this.setValueFromEndep(enterDept4EsDTO, ipDTO);
//		// 2、住院获取表数据
//		this.setValueFromIpInfo(enterDept4EsDTO, ipDTO);
//		// 3、获取患者表数据
//	    this.setValueFromPat(enterDept4EsDTO, ipDTO);
//	    // 4、获取住院表数据
//	    this.setValueFromIpInfo(enterDept4EsDTO, ipDTO);
//	    // 5、设置机构的值
//	    this.setGrpValue(ipDTO);
		return enterDept4IpDTO;
	}

	/**
	 * 把已有数据赋值
	 * 
	 * @param EsDTO
	 * @param ipDTO
	 */
	private void setValueFromEndep(EnterDept4EsDTO esDTO, IpReg4IpDTO ipDTO) {
		ipDTO.setId_ent(esDTO.getId_ent());
		ipDTO.setId_pat(esDTO.getId_pat());
		ipDTO.setCode(IEnConst.UPDATE);
		ipDTO.setArea(IEnConst.HISAREA);
		ipDTO.setName_bed(esDTO.getName_bed());
		 if(esDTO.getDt_acpt() !=null){			    
	        	ipDTO.setDt_acpt(esDTO.getDt_acpt().toString(TimeZone.getDefault(),new SimpleDateFormat("yyyyMMddHHmm")));
	        }
		ipDTO.setName_pat(esDTO.getName_pat());
		 if(esDTO.getDt_birth_pat() !=null){
	        	ipDTO.setDt_birth_pat(new SimpleDateFormat("yyyyMMdd").format(esDTO.getDt_birth_pat().toDate()));
	        }
		 ipDTO.setSd_emp_zr(esDTO.getSd_emp_zr());
		 ipDTO.setName_emp_zr(esDTO.getName_emp_zr());
		 ipDTO.setSd_emp_doc(esDTO.getSd_emp_doc());
		 ipDTO.setPhy_name(esDTO.getPhy_name());
	}

	/**
	 * 住院信息
	 * 
	 * @param esDTO
	 * @param ipDTO
	 * @throws BizException
	 */
	private void setValueFromIpInfo(EnterDept4EsDTO esDTO, IpReg4IpDTO ipDTO) throws BizException {
		IpEP ipep = new IpEP();
		InpatientDO[] ipDOs = ipep.getIpDOByEntId(esDTO.getId_ent());

		if (EnValidator.isEmpty(ipDOs)) {
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_INPATIENTDO);
		}
		InpatientDO ipdo = ipDOs[0];
		ipDTO.setTimes_ip(ipdo.getTimes_ip());
		this.setValueFromDept(ipdo, ipDTO);
	}
	
	/**
	 * 获取患者数据
	 * 
	 * @param enhosDTO
	 * @throws BizException
	 */
	private void setValueFromPat(EnterDept4EsDTO esDTO,IpReg4IpDTO ipDTO) throws BizException {
		PatEP patEP = new PatEP();
		PatDO patdo = patEP.getPatById(esDTO.getId_pat());
		if (patdo == null)
			throw new BizException(IEnMsgConst.ERROR_PAT_NOT_EXIST);
		ipDTO.setCode_pat(patdo.getCode());
		ipDTO.setCode_amr_ip(patdo.getCode_amr_ip());//集成平台需要的就诊号
	
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
	
	

	/**
	 * 查询科室信息
	 * @param lvHos4EsDTO
	 * @param ipDTO
	 * @throws BizException
	 */
	private void setValueFromDept(InpatientDO ipdo,IpReg4IpDTO ipDTO) throws BizException
	{
		HashSet<String> set = new HashSet<String>();
		set.add(ipdo.getId_dep_nuradm());
		set.add(ipdo.getId_dep_phyadm());
		DeptDO[] deptDO = this.getDeptInfo(set);
		if(EnValidator.isEmpty(deptDO))
			return;
		HashMap<String, DeptDO>  hashMap = this.getHashMap(deptDO);
	    this.setDeptName4DTO(hashMap, ipdo, ipDTO);
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
	public HashMap<String, DeptDO> getHashMap(DeptDO[] deptDOs) {
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
	public void setDeptName4DTO(HashMap<String, DeptDO> deptHashTable,InpatientDO ipdo ,IpReg4IpDTO ipDTO) {

		if (!EnValidator.isEmpty(ipdo.getId_dep_nuradm())) {
			if (deptHashTable.get(ipdo.getId_dep_phyadm()) != null) {
				ipDTO.setName_dep_phy(deptHashTable.get(ipdo.getId_dep_phyadm()).getName());
				ipDTO.setSd_dep_phy(deptHashTable.get(ipdo.getId_dep_phyadm()).getCode());
			}
		}
		if (!EnValidator.isEmpty(ipdo.getId_dep_phyadm())) {
			if (deptHashTable.get(ipdo.getId_dep_nuradm()) != null) {
				ipDTO.setName_dep_nur(deptHashTable.get(ipdo.getId_dep_nuradm()).getName());
				ipDTO.setSd_dep_nur(deptHashTable.get(ipdo.getId_dep_nuradm()).getCode());
			}
		}

	
	}
}
