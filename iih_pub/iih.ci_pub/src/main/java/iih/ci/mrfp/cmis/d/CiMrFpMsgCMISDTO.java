package iih.ci.mrfp.cmis.d;


import iih.en.pv.dto.d.OpTotalInfoDTO;
import iih.en.pv.inpatient.dto.d.IpTotalInfoDTO;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "CMIS")  
public class CiMrFpMsgCMISDTO {

	/**
	 * 患者信息
	 */
	public CiMrFpCMISDTO ciMrPat ;
	
	/**
	 * 手术信息
	 */
	public List<CiMrFpSugCMISDTO> sug;
	
	/**
	 * 西医诊断信息
	 */
	public List<CiMrFpXYDICMISDTO> di_xy;
	
	/**
	 * 中医诊断信息
	 */
	public List<CiMrFpZYDiCMISDTO> di_zy;
	
	/**
	 * 门诊工作量
	 */
	public List<OpTotalInfoDTO> jc_mz;
	
	/**
	 * 住院工作量
	 */
	public List<IpTotalInfoDTO> jc_zy;
	
}
