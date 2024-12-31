package iih.en.pv.s.bp.ip.qry;

import iih.ci.ord.i.ICiOrdQryService;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.dto.d.PatientsDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 住院医生站查询会诊患者
 * 
 * @author liubin
 */
public class GetConsPatsBP {

	private static final String EXTRA_CONDITION = "EN.FG_IP = 'Y'";
	
	/**
	 * 查询会诊患者
	 * 
	 * @param deptId
	 * 		科室ID
	 * @param empId
	 * 		医生ID
	 * @return
	 * 		患者DTO集合
	 * @throws BizException 
	 */
	public PatientsDTO[] getConsPats(String depId, String empId) throws BizException{
		String[] entIds = getConsEntIds(depId, empId);
		if(!EnValidator.isEmpty(entIds)){
			return new GetIpDocStationPatsBP().exec(entIds, empId, EXTRA_CONDITION);
		}
		return null;
	}
	
	/**
	 * 查询待会诊应答患者
	 * 
	 * @param deptId
	 * 		科室ID
	 * @param empId
	 * 		医生ID
	 * @return
	 * 		患者DTO集合
	 * @throws BizException 
	 */
	public PatientsDTO[] getResponseConsPats(String depId, String empId) throws BizException{
		String[] entIds = getResponseConsEntIds(depId, empId);
		if(!EnValidator.isEmpty(entIds)){
			return new GetIpDocStationPatsBP().exec(entIds, empId, EXTRA_CONDITION);
		}
		return null;
	}
	
	/**
	 * 得到会诊患者就诊ID集合
	 * 
	 * @param depId
	 * @param empId
	 * @return
	 * @throws BizException
	 */
	private String[] getConsEntIds(String depId, String empId) throws BizException{
		ICiOrdQryService service = ServiceFinder.find(ICiOrdQryService.class);
		return service.getConsultationPatients(EnContextUtils.getOrgId(), depId, empId);
	}
	
	/**
	 * 得到待会诊应答患者就诊ID集合
	 * 
	 * @param depId
	 * @param empId
	 * @return
	 * @throws BizException
	 */
	private String[] getResponseConsEntIds(String depId, String empId) throws BizException{
		ICiOrdQryService service = ServiceFinder.find(ICiOrdQryService.class);
		return service.getToRespondConsultationPatients(EnContextUtils.getOrgId(), depId, empId);
	}
}
