package iih.en.pv.s.listener;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.comm.IEnConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.IpEP;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.dto.d.Recall4EsDTO;
import iih.en.pv.inpatient.dto.d.Recall4IpDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;

import java.sql.Date;
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
 * 出院召回--集成平台监听器
 * 
 * @author yank
 * @author renying
 *
 */
public class EnIpRecall4IpListener implements IBusinessListener {
	/**
	 * 执行
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 1、验证事件，是否匹配
		this.validate(event);

		// 2、包装集成平台所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		Recall4EsDTO eventSourceDTO = (Recall4EsDTO) bizUserObj.getUserObj();
		Recall4IpDTO recall4IpDTO = wrapObj4Ip(eventSourceDTO);

		// 3、触发集成平台事件
		DomainBusinessUserObj buo = new DomainBusinessUserObj(recall4IpDTO, BusiType.ZY,"0", "0");
		MsgObj msgObj = buo.getMsgObj();
		if(msgObj ==null){
			msgObj = new MsgObj();
		}
		msgObj.setInteractionCode(IEnConst.NEW);
		buo.setMsgObj(msgObj);
		buo.setDeptId(recall4IpDTO.getSd_dep_phy());// 第五位执行科室编码
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
		if (!IEnEventConst.EVENT_SOURCE_EN_IP_RECALL.equalsIgnoreCase(event.getSourceID()) || !IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType())) {
			throw new BizException(IEnMsgConst.ERROR_LISTENER_NOT_MATCH_EVENT);
		}
	}

	/**
	 * 包装集成平台事件源
	 * 
	 * @param recall4EsDTO
	 * @return
	 * @throws BizException
	 */
	private Recall4IpDTO wrapObj4Ip(Recall4EsDTO esDTO) throws BizException {
		Recall4IpDTO ipDTO = new Recall4IpDTO();
		ipDTO.setId_ent(esDTO.getId_ent());
		ipDTO.setCode_ent(esDTO.getCode_ent());
		ipDTO.setCode_enttp(IEnConst.IPENTTP);
		ipDTO.setName_enttp(esDTO.getName_enttp());
		ipDTO.setId_pat(esDTO.getId_pat());
		ipDTO.setDt_recall(esDTO.getDt_recall()==null ?"":new SimpleDateFormat("yyyyMMddHHmm").format(new Date(esDTO.getDt_recall().getMillis())));
		ipDTO.setName_pat(esDTO.getName_pat());
		ipDTO.setSd_sex(esDTO.getSd_sex());

		ipDTO.setDt_birth(esDTO.getDt_birth()==null ?"":new SimpleDateFormat("yyyyMMdd").format(new Date(esDTO.getDt_birth().getMillis())));
		ipDTO.setAge(esDTO.getAge());
		ipDTO.setSd_operator(EnContextUtils.getPsnDoc().getCode());
		ipDTO.setName_operator(EnContextUtils.getPsnDoc().getName());
		ipDTO.setName_bed(esDTO.getName_bed());
		ipDTO.setCode_tp(IEnConst.HISAREA);
		this.setDeptValue(esDTO, ipDTO);
		this.setValueFromIpInfo(esDTO, ipDTO);
		//ipDTO.setCode(IEnDictCodeConst.SD_CDR_NEW);
		//ipDTO.setCode_tp(IEnDictCodeConst.SD_ENTP_IP);
		this.setPatValue4DTO(esDTO, ipDTO);
		this.setGrpValue(ipDTO);
		return ipDTO;
	}

	/**
	 * 查询科室信息
	 * 
	 * @param lvHos4EsDTO
	 * @param ipDTO
	 * @throws BizException
	 */
	private void setDeptValue(Recall4EsDTO esDTO, Recall4IpDTO ipDTO) throws BizException {
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
		if (depSet == null || depSet.isEmpty()) {
			return null;
		}
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
	private void setDeptName4DTO(HashMap<String, DeptDO> deptHashTable, Recall4EsDTO esDTO, Recall4IpDTO ipDTO) {

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
	 * 住院信息
	 * 
	 * @param esDTO
	 * @param ipDTO
	 * @throws BizException
	 */
	private void setValueFromIpInfo(Recall4EsDTO esDTO, Recall4IpDTO ipDTO) throws BizException {
		IpEP ipep = new IpEP();
		InpatientDO[] ipDOs = ipep.getIpDOByEntId(esDTO.getId_ent());

		if (EnValidator.isEmpty(ipDOs)) {
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_INPATIENTDO);
		}
		InpatientDO ipdo = ipDOs[0];
		ipDTO.setTimes_ip(ipdo.getTimes_ip());
		ipDTO.setCode_amr_ip(ipdo.getCode_amr_ip());
	
	}
	
	/**
	 * 获取患者do
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private void setPatValue4DTO(Recall4EsDTO esDTO, Recall4IpDTO ipDTO) throws BizException {
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
	private void setGrpValue( Recall4IpDTO ipDTO) throws BizException
	{
		IOrgRService rService = ServiceFinder.find(IOrgRService.class);
		OrgDO orgDo = rService.findById(Context.get().getOrgId());
		ipDTO.setCode_org(orgDo.getOrgcode());
		ipDTO.setName_org(orgDo.getName());;
	}
}
