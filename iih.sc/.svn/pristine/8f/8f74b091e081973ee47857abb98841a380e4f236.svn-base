package iih.sc.apt.s.listener.bp;

import iih.sc.apt.dto.d.OpApt4EsDTO;
import iih.sc.apt.s.ep.AptEP;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.comm.ScValidator;
import xap.mw.core.data.BizException;

/**
 * 获取OpApt4EsDTO
 * 
 * @author liubin
 *
 */
public class GetOpApt4EsDTOBP {
	/**
	 * 获取OpApt4EsDTO
	 * 
	 * @param aptId 预约ID
	 * @return
	 * @throws BizException
	 */
	public OpApt4EsDTO getApt4EsByAptId(String aptId) throws BizException{
		if(ScValidator.isEmptyIgnoreBlank(aptId))
			return null;
		AptEP ep = new AptEP();
		ScAptDO apt = ep.getById(aptId);
		if(apt == null)
			return null;
		OpApt4EsDTO es = new OpApt4EsDTO();
		es.setId_apt(aptId);
		es.setId_pat(apt.getId_pat());
		es.setId_sch(apt.getId_sch());
		return es;
	}
	/**
	 * 获取OpApt4EsDTO
	 * 
	 * @param aptId 预约ID
	 * @param patId 患者ID
	 * @param schId 排班ID
	 * @return
	 * @throws BizException
	 */
	public OpApt4EsDTO getApt4Es(String aptId, String patId, String schId) throws BizException{
		OpApt4EsDTO es = new OpApt4EsDTO();
		es.setId_apt(aptId);
		es.setId_pat(patId);
		es.setId_sch(schId);
		return es;
	}
}
