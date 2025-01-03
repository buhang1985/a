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
import iih.en.pv.inpatient.dto.d.LvHos4EsDTO;
import iih.en.pv.inpatient.dto.d.LvHos4IpDTO;
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
 * 出院--集成平台监听器
 * 
 * @author yank
 * @author renying
 *
 */
public class EnIpLvHos4IpListener implements IBusinessListener {
	/**
	 * 执行
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 1、验证事件，是否匹配
		this.validate(event);

		// 2、包装集成平台所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		LvHos4EsDTO eventSourceDTO = (LvHos4EsDTO) bizUserObj.getUserObj();
		LvHos4IpDTO lvHos4IpDTO;

		lvHos4IpDTO = wrapObj4Ip(eventSourceDTO);
		// 3、触发集成平台事件
		DomainBusinessUserObj buo = new DomainBusinessUserObj(lvHos4IpDTO, BusiType.ZY,"0", "0");
		MsgObj msgObj = buo.getMsgObj();
		if(msgObj ==null){
			msgObj = new MsgObj();
		}
		msgObj.setInteractionCode(IEnConst.NEW);
		buo.setMsgObj(msgObj);
		buo.setDeptId(lvHos4IpDTO.getSd_dep_phy());// 第五位执行科室编码
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
		if (!IEnEventConst.EVENT_SOURCE_EN_IP_LEAVE.equalsIgnoreCase(event.getSourceID()) || !IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType())) {
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
	private LvHos4IpDTO wrapObj4Ip(LvHos4EsDTO lvHos4EsDTO) throws BizException {
		LvHos4IpDTO ipDTO = new LvHos4IpDTO();
		ipDTO.setId_ent(lvHos4EsDTO.getId_ent());
		ipDTO.setCode_ent(lvHos4EsDTO.getCode_ent());
		ipDTO.setCode_enttp(IEnConst.IPENTTP);
		ipDTO.setName_enttp(lvHos4EsDTO.getName_enttp());
		ipDTO.setId_pat(lvHos4EsDTO.getId_pat());
		ipDTO.setName_pat(lvHos4EsDTO.getName_pat());
		ipDTO.setSd_sex(lvHos4EsDTO.getSd_sex());

		ipDTO.setDt_birth(lvHos4EsDTO.getDt_birth()==null ? "":new SimpleDateFormat("yyyyMMdd").format(lvHos4EsDTO.getDt_birth().toDate()));
		ipDTO.setAge(lvHos4EsDTO.getAge());
		ipDTO.setBed_code(lvHos4EsDTO.getBed_code());
		ipDTO.setDt_lv(lvHos4EsDTO.getDt_lv() == null ? "":new SimpleDateFormat("yyyyMMddHHmm").format(lvHos4EsDTO.getDt_lv().getMillis()));
		ipDTO.setCi_code(lvHos4EsDTO.getCi_code());
		ipDTO.setName_ci(lvHos4EsDTO.getName_ci());

		ipDTO.setSd_outtp(lvHos4EsDTO.getSd_outtp());
		ipDTO.setName_outtp(lvHos4EsDTO.getName_outtp());
		ipDTO.setDt_ci_lv(lvHos4EsDTO.getDt_ci_lv()==null ?"":new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(lvHos4EsDTO.getDt_ci_lv().getMillis())) );
		ipDTO.setBed_code(lvHos4EsDTO.getBed_code());
		ipDTO.setSd_operator(EnContextUtils.getPsnDoc().getCode());
		ipDTO.setName_operator(EnContextUtils.getPsnDoc().getName());
		this.setValueFromIpInfo(lvHos4EsDTO, ipDTO);
		this.setValueFromPativisitInfo(lvHos4EsDTO, ipDTO);
		this.setDeptValue(lvHos4EsDTO, ipDTO);
		this.setPatValue4DTO(lvHos4EsDTO, ipDTO);
		this.setGrpValue(ipDTO);
		ipDTO.setCode(IEnConst.SD_CDR_NEW);
		ipDTO.setCode_tp(IEnConst.HISAREA);
		
		return ipDTO;
	}

	/**
	 * 住院信息
	 * 
	 * @param esDTO
	 * @param ipDTO
	 * @throws BizException
	 */
	private void setValueFromIpInfo(LvHos4EsDTO lvHos4EsDTO, LvHos4IpDTO ipDTO) throws BizException {
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
	private void setValueFromPativisitInfo(LvHos4EsDTO lvHos4EsDTO, LvHos4IpDTO ipDTO) throws BizException {
		PvEP pvep = new PvEP();
		PatiVisitDO endo = pvep.getPvById(lvHos4EsDTO.getId_ent());
		ipDTO.setSd_sex(endo.getSd_sex_pat());
		//ipDTO.setAge(AgeCalcUtil.getAge(endo.getDt_birth_pat()));
		EnAgeCalcUtil.setDoAges(new LvHos4IpDTO[]{ipDTO}, "Id_ent", "Age");
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
	private void setDeptValue(LvHos4EsDTO lvHos4EsDTO, LvHos4IpDTO ipDTO) throws BizException {
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
	private void setDeptName4DTO(HashMap<String, DeptDO> deptHashTable, LvHos4EsDTO lvHos4EsDTO, LvHos4IpDTO ipDTO) {

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
	private void setPatValue4DTO(LvHos4EsDTO esDTO, LvHos4IpDTO ipDTO) throws BizException {
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
	private void setGrpValue( LvHos4IpDTO ipDTO) throws BizException
	{
		IOrgRService rService = ServiceFinder.find(IOrgRService.class);
		OrgDO orgDo = rService.findById(Context.get().getOrgId());
		ipDTO.setSd_grp(orgDo.getOrgcode());
		ipDTO.setName_grp(orgDo.getName());
	}
}
