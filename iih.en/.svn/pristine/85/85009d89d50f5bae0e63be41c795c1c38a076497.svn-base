package iih.en.pv.s.listener;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.comm.IEnConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.IpEP;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.dto.d.ChgBed4EsDTO;
import iih.en.pv.inpatient.dto.d.TransDept4IpDTO;

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
 * 换床--集成平台监听器
 * 
 * @author yank
 * @author renying
 *
 */
public class EnIpChgBed4IpListener implements IBusinessListener {
	/**
	 * 执行
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 1、验证事件，是否匹配
		this.validate(event);

		// 2、包装集成平台所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		ChgBed4EsDTO eventSourceDTO = (ChgBed4EsDTO) bizUserObj.getUserObj();
		TransDept4IpDTO chgBed4IpDTO = wrapObj4Ip(eventSourceDTO);

		// 3、触发集成平台事件
		DomainBusinessUserObj buo = new DomainBusinessUserObj(chgBed4IpDTO, BusiType.ZY,"0", "0");
		MsgObj msgObj = buo.getMsgObj();
		if(msgObj ==null){
			msgObj = new MsgObj();
		}
		msgObj.setApplyUnitId(chgBed4IpDTO.getOld_sd_dep_phy());// 第四位申请科室遍码
		msgObj.setInteractionCode(IEnConst.NEW);
		buo.setMsgObj(msgObj);
		buo.setDeptId(chgBed4IpDTO.getSd_dep_phy());// 第五位执行科室编码
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
		if (!IEnEventConst.EVENT_SOURCE_EN_IP_CHANGE_BED.equalsIgnoreCase(event.getSourceID()) || !IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType())) {
			throw new BizException(IEnMsgConst.ERROR_LISTENER_NOT_MATCH_EVENT);
		}
	}

	/**
	 * 包装集成平台事件源
	 * 
	 * @param chgBed4EsDTO
	 * @return
	 * @throws BizException
	 */
	private TransDept4IpDTO wrapObj4Ip(ChgBed4EsDTO esDTO) throws BizException {
		TransDept4IpDTO ipDTO = new TransDept4IpDTO();
		ipDTO.setId_ent(esDTO.getId_ent());
		ipDTO.setCode_ent(esDTO.getCode_ent());
		ipDTO.setCode_enttp(IEnConst.IPENTTP);
		ipDTO.setName_enttp("住院");
		ipDTO.setId_pat(esDTO.getId_pat());
		ipDTO.setSd_sex_pat(esDTO.getSd_sex_pat());
		ipDTO.setName_pat(esDTO.getName_pat());
		ipDTO.setDt_birth(esDTO.getDt_birth());
		ipDTO.setOld_bedname(esDTO.getOld_bedname());
		ipDTO.setNew_bedname(esDTO.getNew_bedname());
	//	ipDTO.setTransinto_time(EnAppUtils.getServerDateTime());
		ipDTO.setSd_emp_nur(EnContextUtils.getPsnDoc().getCode());
		ipDTO.setName_emp_nur(EnContextUtils.getPsnDoc().getName());
		ipDTO.setCode_pat(esDTO.getCode_pat());
		ipDTO.setIp_times(esDTO.getTimes_ip());
		ipDTO.setArea(IEnConst.HISAREA);
		ipDTO.setOrder_type_code(IEnConst.CHGBED);
		ipDTO.setTransinto_time(esDTO.getDt_opr().toString(TimeZone.getDefault(),new SimpleDateFormat("yyyyMMddHHmmss")));
		this.setValueFromIpInfo(esDTO, ipDTO);
		this.setDeptValue(esDTO, ipDTO);
		this.setGrpValue(ipDTO);
		return ipDTO;
	}

	/**
	 * 住院信息
	 * 
	 * @param esDTO
	 * @param ipDTO
	 * @throws BizException
	 */
	private void setValueFromIpInfo(ChgBed4EsDTO esDTO, TransDept4IpDTO ipDTO) throws BizException {
		IpEP ipep = new IpEP();
		InpatientDO[] ipDOs = ipep.getIpDOByEntId(esDTO.getId_ent());

		if (EnValidator.isEmpty(ipDOs)) {
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_INPATIENTDO);
		}
		InpatientDO ipdo = ipDOs[0];
		ipDTO.setIp_times(ipdo.getTimes_ip());
		ipDTO.setCode_amr_ip(ipdo.getCode_amr_ip());
	}

	/**
	 * 查询科室信息
	 * 
	 * @param lvHos4EsDTO
	 * @param ipDTO
	 * @throws BizException
	 */
	private void setDeptValue(ChgBed4EsDTO esDTO, TransDept4IpDTO ipDTO) throws BizException {
		HashSet<String> set = new HashSet<String>();
		set.add(esDTO.getId_dep_nur());
		set.add(esDTO.getId_dep_phy());
		set.add(esDTO.getOld_id_dep_nur());
		set.add(esDTO.getOld_id_dep_phy());

		DeptDO[] deptDO = this.getDeptInfo(set);
		if (EnValidator.isEmpty(deptDO))
			return;
		HashMap<String, DeptDO> hashMap = this.getHashMap(deptDO);
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
		if (depSet.isEmpty())
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
	private void setDeptName4DTO(HashMap<String, DeptDO> deptHashTable, ChgBed4EsDTO esDTO, TransDept4IpDTO ipDTO) {

		if (!EnValidator.isEmpty(esDTO.getId_dep_phy())) {
			if (deptHashTable.get(esDTO.getId_dep_phy()) != null) {
				ipDTO.setName_dep_phy(deptHashTable.get(esDTO.getId_dep_phy()).getName());
				ipDTO.setSd_dep_phy(deptHashTable.get(esDTO.getId_dep_phy()).getCode());
			}
		}
		if (!EnValidator.isEmpty(esDTO.getId_dep_nur())) {
			if (deptHashTable.get(esDTO.getId_dep_nur()) != null) {
				ipDTO.setName_dep_nur(deptHashTable.get(esDTO.getId_dep_nur()).getName());
				ipDTO.setSd_dep_nur(deptHashTable.get(esDTO.getId_dep_nur()).getCode());
			}
		}

		if (!EnValidator.isEmpty(esDTO.getOld_id_dep_nur())) {
			if (deptHashTable.get(esDTO.getOld_id_dep_nur()) != null) {
				ipDTO.setOld_dep_nur_name(deptHashTable.get(esDTO.getOld_id_dep_nur()).getName());
				ipDTO.setOld_sd_dep_nur(deptHashTable.get(esDTO.getOld_id_dep_nur()).getCode());
			}
		}
		if (!EnValidator.isEmpty(esDTO.getOld_id_dep_phy())) {
			if (deptHashTable.get(esDTO.getOld_id_dep_phy()) != null) {
				ipDTO.setOld_dep_phy_name(deptHashTable.get(esDTO.getOld_id_dep_phy()).getName());
				ipDTO.setOld_sd_dep_phy(deptHashTable.get(esDTO.getOld_id_dep_phy()).getCode());
			}
		}

	}

	/**
	 * 设置机构
	 * @throws BizException
	 */
	private void setGrpValue( TransDept4IpDTO ipDTO) throws BizException
	{
		IOrgRService rService = ServiceFinder.find(IOrgRService.class);
		OrgDO orgDo = rService.findById(Context.get().getOrgId());
		ipDTO.setCode_org(orgDo.getOrgcode());
		ipDTO.setName_org(orgDo.getName());;
	}

}
