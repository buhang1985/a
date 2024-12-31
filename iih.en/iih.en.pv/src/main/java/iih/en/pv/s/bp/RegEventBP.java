package iih.en.pv.s.bp;

import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.er.dto.d.UrgStayRegistryDTO;
import iih.en.pv.dto.d.EnHosRegDTO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.dto.d.IpReg4EsDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.s.event.IpRegEvent;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.businessevent.IEventType;

public class RegEventBP {

	
	/**
	 * 触发住院登记事件
	 * 
	 * @throws BizException
	 */
	public void invokeIpRegEvent(EnHosRegDTO enHosRegDTO, PatiVisitDO patiVisitDO, InpatientDO inpatientDO,FBoolean isNew) throws BizException {
		// 1、构造事件源
		IpReg4EsDTO reg4EsDTO = new IpReg4EsDTO();
		this.invokeRegInfo(reg4EsDTO, enHosRegDTO, patiVisitDO, inpatientDO,isNew);
		// 2、触发事件
		IpRegEvent ipRegEvent = new IpRegEvent();
		ipRegEvent.invoke(reg4EsDTO);
	}
	
	/**
	 * 触发留观登记事件
	 * 
	 * @throws BizException
	 */
	public void invokeStayRegEvent(UrgStayRegistryDTO stayRegDTO, boolean isNew) throws BizException {
		// 1、构造事件源
		IpReg4EsDTO reg4EsDTO = new IpReg4EsDTO();
		this.invokeStayRegInfo(reg4EsDTO,stayRegDTO, isNew);
		// 2、触发事件
		IpRegEvent ipRegEvent = new IpRegEvent();
		ipRegEvent.invoke(reg4EsDTO);
	}

	/**
	 * 发送入院登记事件
	 * 
	 * @param esDTO
	 * @param regDTO
	 * @param patiVisitDO
	 * @param inpatientDO
	 * @throws BizException
	 */
	private void invokeRegInfo(IpReg4EsDTO esDTO, EnHosRegDTO regDTO, PatiVisitDO patiVisitDO, InpatientDO inpatientDO,FBoolean isNew) throws BizException {
		esDTO.setIsnew(isNew);	
		esDTO.setId_ent(patiVisitDO.getId_ent());
		esDTO.setCode_ent(patiVisitDO.getCode());// 就诊编码：xuxing_2018年1月9日15:34:42
		esDTO.setCode_pat(patiVisitDO.getCode_pat());//患者编码：xuxing_2018年1月9日15:34:42
		esDTO.setId_pat(patiVisitDO.getId_pat());// 患者ID，传patient_id
		esDTO.setName_pat(patiVisitDO.getName_pat());// 患者姓名
		esDTO.setDt_birth_pat(patiVisitDO.getDt_birth_pat());// 出生日期
		esDTO.setId_dep_phy(patiVisitDO.getId_dep_phy());
		esDTO.setId_dep_nur(patiVisitDO.getId_dep_nur());

		esDTO.setName_bed(regDTO.getBedname());

		esDTO.setSd_referalsrc(regDTO.getSd_referalsrc());
		esDTO.setReferalsrc_name(regDTO.getReferalsrc_name());
		esDTO.setSd_level_diseadm(regDTO.getSd_level_diseadm());
		esDTO.setName_level_diseadm(regDTO.getName_level_diseadm());
		esDTO.setId_prim(regDTO.getPrim_cplan());
		esDTO.setPrim_name(regDTO.getPrim_name());
		esDTO.setSd_sex(patiVisitDO.getSd_sex_pat());
		esDTO.setName_paticate(patiVisitDO.getName_patca());
		esDTO.setSd_paticate(patiVisitDO.getSd_patca());
		esDTO.setSd_diag(regDTO.getSd_diag());
		esDTO.setName_diag(regDTO.getDia_name());
	
		esDTO.setEvent_source(IEventType.TYPE_INSERT_AFTER);
		esDTO.setId_dep_opr(EnContextUtils.getDeptId());  //操作科室
		esDTO.setId_emp_opr(EnContextUtils.getPsnId());//操作员
		esDTO.setDt_opr(EnAppUtils.getServerDateTime());
		esDTO.setDt_acpt(patiVisitDO.getDt_entry());
		esDTO.setSd_emp_ry(inpatientDO.getCode_emp_phy_op());//门诊医生sd
		esDTO.setName_emp_ry(inpatientDO.getName_emp_phy_op());//门诊医生
		esDTO.setCode_enttp(patiVisitDO.getCode_entp());//就诊类型编码
		esDTO.setName_enttp(patiVisitDO.getName_entp());//就诊类型名称
		esDTO.setFg_newborn(FBoolean.FALSE);
		if(inpatientDO!=null){
			esDTO.setCode_amr_ip(inpatientDO.getCode_amr_ip()); // 就诊号，传inpatient_no
			esDTO.setTimes_ip(inpatientDO.getTimes_ip());
		}
		
	}
	
	/**
	 * 发送留观登记事件
	 * 
	 * @param reg4EsDTO
	 * @param stayRegDTO
	 * @param isNew
	 */
	private void invokeStayRegInfo(IpReg4EsDTO esDTO, UrgStayRegistryDTO stayRegDTO, boolean isNew) {
		esDTO.setIsnew(FBoolean.valueOf(isNew));	
		esDTO.setId_ent(stayRegDTO.getId_ent());
		esDTO.setId_pat(stayRegDTO.getId_pat());// 患者ID，传patient_id
		esDTO.setName_pat(stayRegDTO.getName_pat());// 患者姓名
		esDTO.setDt_birth_pat(stayRegDTO.getDt_birth());// 出生日期
		esDTO.setId_dep_phy(stayRegDTO.getId_dep_phyadm());
		esDTO.setId_dep_nur(stayRegDTO.getId_dep_nuradm());
		esDTO.setName_bed(stayRegDTO.getName_bed());
		esDTO.setSd_level_diseadm(stayRegDTO.getSd_level_diseadm());
		esDTO.setName_level_diseadm(stayRegDTO.getName_level_diseadm());
		esDTO.setId_prim(stayRegDTO.getId_hp());
		esDTO.setPrim_name(stayRegDTO.getName_hp());
		esDTO.setSd_sex(stayRegDTO.getSd_sex());
		esDTO.setName_paticate(stayRegDTO.getName_patca());
		esDTO.setSd_diag(stayRegDTO.getCode_diag_op());//?
		esDTO.setName_diag(stayRegDTO.getName_diag_op());
	
		esDTO.setEvent_source(IEventType.TYPE_INSERT_AFTER);
		esDTO.setId_dep_opr(EnContextUtils.getDeptId());  //操作科室
		esDTO.setId_emp_opr(EnContextUtils.getPsnId());//操作员
		esDTO.setDt_opr(EnAppUtils.getServerDateTime());
		esDTO.setDt_acpt(stayRegDTO.getDt_entry());
		esDTO.setCode_amr_ip(stayRegDTO.getCode_amr_ip()); 
		esDTO.setTimes_ip(stayRegDTO.getTimes_ip());
	}
}
