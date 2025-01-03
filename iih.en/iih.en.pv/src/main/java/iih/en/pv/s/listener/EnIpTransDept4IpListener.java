package iih.en.pv.s.listener;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.en.comm.IEnConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.PatEP;
import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.dto.d.TransDept4EsDTO;
import iih.en.pv.inpatient.dto.d.TransDept4IpDTO;
import iih.pi.reg.pat.d.PatDO;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import xap.ip.event.BusiType;
import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;

/**
 * 住院登记集成平台监听器
 * 
 * @author yank
 * @author renying
 *
 */
public class EnIpTransDept4IpListener implements IBusinessListener {
	/**
	 * 执行
	 */
	@Override
	public void doAction(IBusinessEvent event) throws BizException {
		// 1、验证事件，是否匹配
		this.validate(event);

		// 2、包装集成平台所需结构
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		TransDept4EsDTO eventSourceDTO = (TransDept4EsDTO) bizUserObj.getUserObj();
		TransDept4IpDTO transDept4IpDTO = wrapObj4Ip(eventSourceDTO);

		// 3、触发集成平台事件
		DomainBusinessUserObj buo = new DomainBusinessUserObj(transDept4IpDTO, BusiType.ZY,"0", "0");
		MsgObj msgObj = buo.getMsgObj();
		if(msgObj ==null){
			msgObj = new MsgObj();
		}
		msgObj.setApplyUnitId(transDept4IpDTO.getOld_sd_dep_phy());// 第四位申请科室遍码
		msgObj.setInteractionCode(IEnConst.NEW);
		buo.setMsgObj(msgObj);
		buo.setDeptId(transDept4IpDTO.getSd_dep_phy());// 第五位执行科室编码
		BusinessEvent bizEvent = new BusinessEvent(event.getSourceID(), "4411", buo);
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
		if (!IEnEventConst.EVENT_SOURCE_EN_IP_TRANS_DEPT.equalsIgnoreCase(event.getSourceID()) || !IEventType.TYPE_UPDATE_AFTER.equals(event.getEventType())) {
			throw new BizException(IEnMsgConst.ERROR_LISTENER_NOT_MATCH_EVENT);
		}
	}

	/**
	 * 包装集成平台事件源
	 * 
	 * @param ipReg4EsDTO
	 * @return
	 * @throws BizException
	 */
	private TransDept4IpDTO wrapObj4Ip(TransDept4EsDTO esDTO) throws BizException {

		TransDept4IpDTO ipDTO = new TransDept4IpDTO();

		ipDTO.setId_ent(esDTO.getId_ent());
		ipDTO.setCode_pat(esDTO.getCode_pat());
		ipDTO.setCode_ent(esDTO.getCode_ent());
		ipDTO.setCode_enttp(IEnConst.IPENTTP);
		ipDTO.setOrder_type_code(esDTO.getOrder_type_code());
		ipDTO.setName_enttp(esDTO.getName_enttp());
		ipDTO.setId_pat(esDTO.getId_pat());
		ipDTO.setCode_amr_ip(esDTO.getCode_amr_ip());
		ipDTO.setTransinto_time(esDTO.getTransinto_time().toString(TimeZone.getDefault(),new SimpleDateFormat("yyyyMMddHHmmss")));
		ipDTO.setName_pat(esDTO.getName_pat());

		ipDTO.setDt_birth(esDTO.getDt_birth());
		//ipDTO.setAge(AgeCalcUtil.getAge(esDTO.getDt_birth()));
		EnAgeCalcUtil.setDoAges(new TransDept4IpDTO[]{ipDTO}, "Id_ent", "Age");
		ipDTO.setOld_sd_dep_nur(esDTO.getOld_sd_dep_nur());
		ipDTO.setOld_dep_nur_name(esDTO.getOld_dep_nur_name());
		ipDTO.setOld_sd_dep_phy(esDTO.getOld_sd_dep_phy());
		ipDTO.setOld_dep_phy_name(esDTO.getOld_dep_phy_name());

		ipDTO.setName_dep_phy(esDTO.getName_dep_phy());
		ipDTO.setName_dep_nur(esDTO.getName_dep_nur());
		ipDTO.setSd_dep_nur(esDTO.getSd_dep_nur());
		ipDTO.setSd_dep_phy(esDTO.getSd_dep_phy());
		ipDTO.setSd_emp_nur(esDTO.getSd_emp_nur());
		ipDTO.setName_emp_nur(esDTO.getName_emp_nur());

		ipDTO.setOld_bedname(esDTO.getOld_bedname());
		ipDTO.setNew_bedname(esDTO.getNew_bedname());
		ipDTO.setCi_code(esDTO.getCi_code());
		ipDTO.setSd_sex_pat(esDTO.getSd_sex_pat());
		this.setValueFromIpInfo(ipDTO);
		this.setGrpValue(ipDTO);
		ipDTO.setArea(IEnConst.HISAREA);
		return ipDTO;
	}
	/**
	 * 获取患者分类
	 * 
	 * @param enhosDTO
	 * @throws BizException
	 */
	private void setValueFromPatCate(TransDept4EsDTO esDTO,TransDept4IpDTO ipDTO) throws BizException {
		PatEP patEP = new PatEP();
		PatDO patdo = patEP.getPatById(esDTO.getId_pat());
		if (patdo == null)
			throw new BizException(IEnMsgConst.ERROR_PAT_NOT_EXIST);

		ipDTO.setCode_pat(patdo.getCode());
		ipDTO.setCode_amr_ip(patdo.getCode_amr_ip());//集成平台需要的就诊号
	}
	
	/**
	 * 住院信息
	 * 
	 * @param esDTO
	 * @param ipDTO
	 * @throws BizException
	 */
	private void setValueFromIpInfo(TransDept4IpDTO ipDTO) throws BizException {
		IpEP ipep = new IpEP();
		InpatientDO[] ipDOs = ipep.getIpDOByEntId(ipDTO.getId_ent());

		if (EnValidator.isEmpty(ipDOs)) {
			throw new BizException(IEnMsgConst.ERROR_ENT_NOT_INPATIENTDO);
		}
		InpatientDO ipdo = ipDOs[0];
		ipDTO.setCode_amr_ip(ipdo.getCode_amr_ip());
		ipDTO.setIp_times(ipdo.getTimes_ip());
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
