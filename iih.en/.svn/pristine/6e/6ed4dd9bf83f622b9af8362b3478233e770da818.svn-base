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
import iih.en.pv.inpatient.dto.d.LvDep4EsDTO;
import iih.en.pv.inpatient.dto.d.LvDep4IpDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;

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
 * 出科--集成平台监听器
 * 
 *
 */
public class EnIpLvDep4IpListener implements IBusinessListener {
	/**
	 * 执行
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 1、验证事件，是否匹配
		this.validate(event);

		// 2、包装集成平台所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		LvDep4EsDTO eventSourceDTO = (LvDep4EsDTO) bizUserObj.getUserObj();
		LvDep4IpDTO lvDep4IpDTO;

		lvDep4IpDTO = wrapObj4Ip(eventSourceDTO);
		// 3、触发集成平台事件
		DomainBusinessUserObj buo = new DomainBusinessUserObj(lvDep4IpDTO, BusiType.ZY,"0", "0");
		buo.setDeptId(lvDep4IpDTO.getSd_dep_nur());// 第五位 执行科室编码
		MsgObj msgObj = new MsgObj();
		msgObj.setApplyUnitId(lvDep4IpDTO.getSd_dep_phy());// 第四位 申请科室编码
		buo.setMsgObj(msgObj);
		
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
		if (!IEnEventConst.EVENT_SOURCE_EN_IP_LEAVE_DEP.equalsIgnoreCase(event.getSourceID()) || !IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType())) {
			throw new BizException(IEnMsgConst.ERROR_LISTENER_NOT_MATCH_EVENT);
		}
	}

	/**
	 * 包装集成平台事件源
	 * 
	 * @param lvHos4EsDTO
	 * @return
	 * @throws BizException
	 * @throws ParseException
	 */
	private LvDep4IpDTO wrapObj4Ip(LvDep4EsDTO lvDep4EsDTO) throws BizException {
		LvDep4IpDTO ipDTO = new LvDep4IpDTO();
		ipDTO.setId_ent(lvDep4EsDTO.getId_ent());
		ipDTO.setCode_ent(lvDep4EsDTO.getCode_ent());
		ipDTO.setCode_enttp(IEnConst.IPENTTP);
		ipDTO.setName_enttp(lvDep4EsDTO.getName_enttp());
		ipDTO.setId_pat(lvDep4EsDTO.getId_pat());
		ipDTO.setName_pat(lvDep4EsDTO.getName_pat());
		ipDTO.setSd_sex(lvDep4EsDTO.getSd_sex());

		ipDTO.setDt_birth(lvDep4EsDTO.getDt_birth()==null ? "":new SimpleDateFormat("yyyyMMdd").format(lvDep4EsDTO.getDt_birth().toDate()));
		ipDTO.setAge(lvDep4EsDTO.getAge());
		ipDTO.setBed_code(lvDep4EsDTO.getBed_code());
		ipDTO.setDt_lv(lvDep4EsDTO.getDt_lv() == null ? "":new SimpleDateFormat("yyyyMMddHHmm").format(lvDep4EsDTO.getDt_lv().getMillis()));
		ipDTO.setCi_code(lvDep4EsDTO.getCi_code());
		ipDTO.setName_ci(lvDep4EsDTO.getName_ci());

		ipDTO.setSd_outtp(lvDep4EsDTO.getSd_outtp());
		ipDTO.setName_outtp(lvDep4EsDTO.getName_outtp());
		ipDTO.setDt_ci_lv(lvDep4EsDTO.getDt_ci_lv()==null ?"":new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(lvDep4EsDTO.getDt_ci_lv().getMillis())) );
		ipDTO.setBed_code(lvDep4EsDTO.getBed_code());
		ipDTO.setSd_operator(EnContextUtils.getPsnDoc().getCode());
		ipDTO.setName_operator(EnContextUtils.getPsnDoc().getName());
		this.setValueFromIpInfo(lvDep4EsDTO, ipDTO);
		this.setValueFromPativisitInfo(lvDep4EsDTO, ipDTO);
		this.setDeptValue(lvDep4EsDTO, ipDTO);
		this.setPatValue4DTO(lvDep4EsDTO, ipDTO);
		this.setGrpValue(ipDTO);
		ipDTO.setCode(IEnConst.SD_CDR_NEW);
		ipDTO.setCode_tp(IEnConst.HISAREA);
		ipDTO.setCreate_time(new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date()));
		
		return ipDTO;
	}

	/**
	 * 住院信息
	 * 
	 * @param esDTO
	 * @param ipDTO
	 * @throws BizException
	 */
	private void setValueFromIpInfo(LvDep4EsDTO lvHos4EsDTO, LvDep4IpDTO ipDTO) throws BizException {
		IpEP ipep = new IpEP();
		InpatientDO[] ipDOs = ipep.getIpDOByEntId(ipDTO.getId_ent());

		if (EnValidator.isEmpty(ipDOs)) {
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_INPATIENTDO);
		}
		InpatientDO ipdo = ipDOs[0];
		ipDTO.setCode_amr_ip(ipdo.getCode_amr_ip());
		ipDTO.setTimes_ip(ipdo.getTimes_ip());
	}

	/**
	 * 就诊数据
	 * 
	 * @param esDTO
	 * @param ipDTO
	 * @throws BizException
	 * @throws ParseException
	 */
	private void setValueFromPativisitInfo(LvDep4EsDTO lvHos4EsDTO, LvDep4IpDTO ipDTO) throws BizException {
		PvEP pvep = new PvEP();
		PatiVisitDO endo = pvep.getPvById(lvHos4EsDTO.getId_ent());
		ipDTO.setSd_sex(endo.getSd_sex_pat());
		//ipDTO.setAge(AgeCalcUtil.getAge(endo.getDt_birth_pat()));
		EnAgeCalcUtil.setDoAges(new LvDep4IpDTO[]{ipDTO}, "Id_ent", "Age");
		Integer days = (int) ((EnAppUtils.getServerDateTime().getDate().toDate().getTime() - endo.getDt_acpt().getDate().toDate().getTime()) / 86400000) + 1;
		ipDTO.setTime_inhos(days.toString());
		ipDTO.setUnit("天");
	}

	/**
	 * 查询科室信息
	 * 
	 * @param lvHos4EsDTO
	 * @param ipDTO
	 * @throws BizException
	 */
	private void setDeptValue(LvDep4EsDTO lvHos4EsDTO, LvDep4IpDTO ipDTO) throws BizException {
		HashSet<String> set = new HashSet<String>();
		set.add(lvHos4EsDTO.getId_dep_nur());
		set.add(lvHos4EsDTO.getId_dep_phy());

		DeptDO[] deptDO = this.getDeptInfo(set);
		if (EnValidator.isEmpty(deptDO))
			return;
		HashMap<String, DeptDO> hashMap = this.getHashMap(deptDO);
		this.setDeptName4DTO(hashMap, lvHos4EsDTO, ipDTO);

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
	private void setDeptName4DTO(HashMap<String, DeptDO> deptHashTable, LvDep4EsDTO lvHos4EsDTO, LvDep4IpDTO ipDTO) {

		if (!EnValidator.isEmpty(lvHos4EsDTO.getId_dep_nur())) {
			if (deptHashTable.get(lvHos4EsDTO.getId_dep_phy()) != null) {
				ipDTO.setName_dep_phy(deptHashTable.get(lvHos4EsDTO.getId_dep_phy()).getName());
				ipDTO.setSd_dep_phy(deptHashTable.get(lvHos4EsDTO.getId_dep_phy()).getCode());
//
//				ipDTO.setSd_grp(deptHashTable.get(lvHos4EsDTO.getId_dep_phy()).getCode());
//				ipDTO.setName_grp(deptHashTable.get(lvHos4EsDTO.getId_dep_phy()).getName());
			}
		}
		if (!EnValidator.isEmpty(lvHos4EsDTO.getId_dep_phy())) {
			if (deptHashTable.get(lvHos4EsDTO.getId_dep_nur()) != null) {
				ipDTO.setName_dep_nur(deptHashTable.get(lvHos4EsDTO.getId_dep_nur()).getName());
				ipDTO.setSd_dep_nur(deptHashTable.get(lvHos4EsDTO.getId_dep_nur()).getCode());
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
	private void setPatValue4DTO(LvDep4EsDTO esDTO, LvDep4IpDTO ipDTO) throws BizException {
		IPatiMDORService patRService = ServiceFinder.find(IPatiMDORService.class);
		PatDO patdo = patRService.findById(ipDTO.getId_pat());
		if (patdo == null) {
			throw new BizException(IEnMsgConst.ERROR_PAT_NOT_EXIST);
		}
		ipDTO.setPat_code(patdo.getCode());		
	}
	
	/**
	 * 设置机构
	 * @throws BizException
	 */
	private void setGrpValue( LvDep4IpDTO ipDTO) throws BizException
	{
		IOrgRService rService = ServiceFinder.find(IOrgRService.class);
		OrgDO orgDo = rService.findById(Context.get().getOrgId());
		ipDTO.setSd_grp(orgDo.getOrgcode());
		ipDTO.setName_grp(orgDo.getName());
	}
}
