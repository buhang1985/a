package iih.bl.hp.s.bp;

import iih.bl.hp.i.IBlHpQryService;
import iih.bl.hp.rural.dto.d.RuralPersonInfoDTO;
import iih.ci.ord.i.external.provide.ICiOrdBlService;
import iih.ci.ord.i.external.provide.meta.bl.EnDiInfo4BlDTO;
import iih.mi.biz.dto.d.DiInfoRegInParamDTO;
import iih.mi.biz.dto.d.DiInfoRegSetsInParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 
* @author xy.zhou 
* @date 2018年4月10日
* @Description 拼装诊断入参
 */
public class GetUploadDiagnosisBp {
	/**
	 * 
	* @Description 拼装诊断信息
	* @param @param idEnt
	* @param @return
	* @param @throws BizException    
	* @return DiInfoRegSetsInParamDTO    
	* @throws
	 */
	public DiInfoRegSetsInParamDTO exec(String idEnt) throws BizException {
		DiInfoRegSetsInParamDTO diInfoRegSetsInParamDTO=new DiInfoRegSetsInParamDTO();
		//获取诊断信息
		EnDiInfo4BlDTO[] enDiInfo4BlDTOs = getEnDiInfo4BlDTO(idEnt);
		if (enDiInfo4BlDTOs==null) {
			throw new BizException("患者诊断信息不能为空");
		}
		//获取医保就诊信息
		RuralPersonInfoDTO ruralPersonDTO = getRuralPersonInfoDTO(idEnt);
		for (EnDiInfo4BlDTO enDiInfo4BlDTO : enDiInfo4BlDTOs) {
			DiInfoRegInParamDTO diInfoRegInParamDTO=new DiInfoRegInParamDTO();
			diInfoRegInParamDTO.setInpno(ruralPersonDTO.getHp_serialno());//住院号
			diInfoRegInParamDTO.setPatname(ruralPersonDTO.getPatname());//患者姓名
//			diInfoRegInParamDTO.setDi_no(enDiInfo4BlDTO.getSortno());//诊断序号
			diInfoRegInParamDTO.setDi_no(enDiInfo4BlDTO.getSortno()+1);//诊断序号
			diInfoRegInParamDTO.setDi_tp(enDiInfo4BlDTO.getSd_ditp());//诊断类型（编码）
			diInfoRegInParamDTO.setDi_mark(enDiInfo4BlDTO.getSd_disys());//中西医标志(编码)
			diInfoRegInParamDTO.setFg_major(enDiInfo4BlDTO.getFg_majdi());//诊断主次
			diInfoRegInParamDTO.setDi_code(enDiInfo4BlDTO.getId_didef_code());//诊断疾病编码
			diInfoRegInParamDTO.setDi_name(enDiInfo4BlDTO.getId_didef_name());//诊断疾病名称
			diInfoRegInParamDTO.setDt_di(enDiInfo4BlDTO.getDt_di());//诊断日期
			diInfoRegInParamDTO.setDidoctor_code(enDiInfo4BlDTO.getCode_emp_sign());//诊断医生编码
			diInfoRegInParamDTO.setDoctor_name(enDiInfo4BlDTO.getName_emp_sign());//诊断医生名称
			diInfoRegInParamDTO.setChiefdoctor_code(enDiInfo4BlDTO.getCode_emp_sign());//主治医生编码
			diInfoRegInParamDTO.setChiefdoctor_name(enDiInfo4BlDTO.getName_emp_sign());//主治医生名称
			FArrayList fList=new FArrayList();
			fList.add(diInfoRegInParamDTO);
			diInfoRegSetsInParamDTO.setDiagsets(fList);
		}
		return diInfoRegSetsInParamDTO;
	}
	/**
	* @Description:获取诊断信息
	* @param @param idEnt
	* @param @return    
	* @return EnDiInfo4BlDTO[]    
	* @throws BizException 
	 */
	private EnDiInfo4BlDTO[]  getEnDiInfo4BlDTO(String idEnt) throws BizException{
		ICiOrdBlService service = ServiceFinder.find(ICiOrdBlService.class);
		EnDiInfo4BlDTO[] dtOs = service.getEnDiInfo4BlDTOs(idEnt);
		return dtOs;
	}
	/**
	 * 
	* @Description:获取就诊信息
	* @param @param idEnt
	* @param @return
	* @param @throws BizException    
	* @return RuralPersonInfoDTO    
	* @throws
	 */
	private RuralPersonInfoDTO getRuralPersonInfoDTO(String idEnt)throws BizException{
		IBlHpQryService service = ServiceFinder.find(IBlHpQryService.class);
		RuralPersonInfoDTO dto = service.getRuralPersonInfo(idEnt);
		return dto;
	}
}
