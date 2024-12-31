package iih.en.pv.s.listener;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.comm.IEnConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.dto.d.DisHos4EsDTO;
import iih.en.pv.inpatient.dto.d.LvHos4IpDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TimeZone;

import xap.ip.event.BusiType;
import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.mw.core.data.BizException;
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
 * 退院--集成平台监听器
 * 
 * @author yank
 * @author renying
 *
 */
public class EnIpDisHos4IpListener implements IBusinessListener {
	/**
	 * 执行
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 1、验证事件，是否匹配
		this.validate(event);

		// 2、包装集成平台所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		DisHos4EsDTO eventSourceDTO = (DisHos4EsDTO) bizUserObj.getUserObj();
		LvHos4IpDTO reg4IpDTO = wrapObj4Ip(eventSourceDTO);

		// 3、触发集成平台事件
		DomainBusinessUserObj buo = new DomainBusinessUserObj(reg4IpDTO, BusiType.ZY,"0", "0");
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
		if (!IEnEventConst.EVENT_SOURCE_EN_IP_DISCHARGE.equalsIgnoreCase(event.getSourceID()) || !IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType())) {
			throw new BizException(IEnMsgConst.ERROR_LISTENER_NOT_MATCH_EVENT);
		}
	}

	/**
	 * 包装集成平台事件源
	 * 
	 * @param disHos4EsDTO
	 * @return
	 * @throws BizException
	 */
	private LvHos4IpDTO wrapObj4Ip(DisHos4EsDTO esDTO) throws BizException {
		LvHos4IpDTO ipDTO = new LvHos4IpDTO();	
		ipDTO.setDt_lv(esDTO.getDt_lv().toString(TimeZone.getDefault(),new SimpleDateFormat("yyyyMMddHHmm")));
		ipDTO.setId_ent(esDTO.getId_ent());
		ipDTO.setId_pat(esDTO.getId_pat());
		ipDTO.setBed_code(esDTO.getBed_code());
		ipDTO.setSd_operator(EnContextUtils.getPsnDoc().getCode());
		ipDTO.setName_operator(EnContextUtils.getPsnDoc().getName());
		ipDTO.setCode(IEnConst.SD_LV_DISCHARGE);
		ipDTO.setCode_tp(IEnConst.HISAREA);
		ipDTO.setCode_enttp(IEnConst.IPENTTP);//就诊类型编码
		ipDTO.setName_enttp("住院");//就诊类型名称
		ipDTO.setPat_code(esDTO.getCode_pat());
		
		// 1、设置部门
		this.setDeptValue(esDTO, ipDTO);
//		this.setValueFromIpInfo(esDTO, ipDTO);
		ipDTO.setTimes_ip(esDTO.getTimes_ip());
		this.setValueFromPativisitInfo(esDTO, ipDTO);
		this.setPatValue4DTO(esDTO, ipDTO);
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
	private void setValueFromIpInfo(DisHos4EsDTO esDTO, LvHos4IpDTO ipDTO) throws BizException {
		IpEP ipep = new IpEP();
		InpatientDO[] ipDOs = ipep.getIpDOByEntId(esDTO.getId_ent());

		if (EnValidator.isEmpty(ipDOs)) {
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_INPATIENTDO);
		}
		InpatientDO ipdo = ipDOs[0];
		//ipDTO.setCode_amr_ip(ipdo.getCode_amr_ip());
		ipDTO.setTimes_ip(esDTO.getTimes_ip());

	}

	/**
	 * 就诊数据
	 * 
	 * @param esDTO
	 * @param ipDTO
	 * @throws BizException
	 */
	private void setValueFromPativisitInfo(DisHos4EsDTO esDTO, LvHos4IpDTO ipDTO) throws BizException {
		PvEP pvep = new PvEP();
		PatiVisitDO endo = pvep.getPvById(esDTO.getId_ent());
		ipDTO.setCode_ent(endo.getCode());
		ipDTO.setSd_sex(endo.getSd_sex_pat());
		//ipDTO.setAge(AgeCalcUtil.getAge(endo.getDt_birth_pat()));
		EnAgeCalcUtil.setDoAges(new LvHos4IpDTO[]{ipDTO}, "Id_ent", "Age");
		ipDTO.setDt_birth(endo.getDt_birth_pat()==null ? "":new SimpleDateFormat("yyyyMMdd").format(endo.getDt_birth_pat().toDate()));
		Integer days = 0;
		if (endo.getDt_acpt() != null)
			days = (int) ((EnAppUtils.getServerDateTime().getDate().toDate().getTime() - endo.getDt_acpt().getDate().toDate().getTime()) / 86400000) + 1;
		ipDTO.setTime_inhos(days.toString());
		ipDTO.setName_pat(endo.getName_pat());
		ipDTO.setUnit("天");
	}

	/**
	 * 查询科室信息
	 * 
	 * @param lvHos4EsDTO
	 * @param ipDTO
	 * @throws BizException
	 */
	private void setDeptValue(DisHos4EsDTO esDTO, LvHos4IpDTO ipDTO) throws BizException {
		HashSet<String> set = new HashSet<String>();
		set.add(esDTO.getId_dep_nur());
		set.add(esDTO.getId_dep_phy());
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
	private void setDeptName4DTO(HashMap<String, DeptDO> deptHashTable, DisHos4EsDTO esDTO, LvHos4IpDTO ipDTO) {
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
	}
	/**
	 * 获取患者do
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private void setPatValue4DTO(DisHos4EsDTO esDTO, LvHos4IpDTO ipDTO) throws BizException {
		IPatiMDORService patRService = ServiceFinder.find(IPatiMDORService.class);
		PatDO patdo = patRService.findById(ipDTO.getId_pat());
		if (patdo == null) {
			throw new BizException(IEnMsgConst.ERROR_PAT_NOT_EXIST);
		}
		ipDTO.setPat_code(patdo.getCode());		
		ipDTO.setCode_amr_ip(patdo.getCode_amr_ip());
	}
	
	/**
	 * 设置机构
	 * @throws BizException
	 */
	private void setGrpValue( LvHos4IpDTO ipDTO) throws BizException
	{
		IOrgRService qryService = ServiceFinder.find(IOrgRService.class);
		OrgDO groupDo = qryService.findById(EnContextUtils.getOrgId());
		ipDTO.setSd_grp(groupDo.getOrgcode());
		ipDTO.setName_grp(groupDo.getName());
	}
}
