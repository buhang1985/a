package iih.bl.hp.i;

import iih.bl.hp.dto.miipcharge.d.DetailUpLoadSearchDTO;
import iih.mi.biz.dto.d.DiInfoRegSetsInParamDTO;
import iih.mi.biz.dto.d.InpDetailUpLoadParamDTO;
import iih.mi.biz.dto.d.InpInvoiceInParamDTO;
import iih.mi.biz.dto.d.InpPayInParamDTO;
import iih.mi.biz.dto.d.OutHosRegInParamDTO;
import iih.mi.biz.dto.d.ParamAttributeDTO;
import xap.mw.core.data.BizException;
import xap.sys.securityfw.switchdept.d.PsnInfo;

/**
 * 费用域医保平台调用参数组装service
 * @author ly 2018/03/09
 *
 */
public interface IBlMiParamPackagingService {

	/************************门诊结算业务********************************/
	
	/************************住院结算业务********************************/
	
	/**
	 * 构建明细费用上传参数值
	 * @param searchDto 查询条件
	 * @param attrDto 需要设置的参数
	 * @return
	 * @throws BizException
	 */
	public abstract InpDetailUpLoadParamDTO getUploadInpDetailsParam(DetailUpLoadSearchDTO searchDto,ParamAttributeDTO attrDto) throws BizException;
	
	/**
	 * 构建住院预结算参数值
	 * @param searchDto
	 * @param attrDto
	 * @return InpPayInParamDTO,InpPayDataDTO
	 * @throws BizException
	 */
	public abstract InpPayInParamDTO getInpPrePayParam(String entId,PsnInfo psnInfo,ParamAttributeDTO attrDto) throws BizException;
	/**
	 * 
	* @Description:构建新益华诊断上传入参
	* @param @param entId
	* @param @return    
	* @return DiInfoRegSetsInParamDTO    
	* @throws BizException
	 */
	public abstract DiInfoRegSetsInParamDTO getUploadDiagnosis(String  entId) throws BizException;
	/**
	 * 
	* @Description:构建新益华出院登记入参
	* @param @param entId
	* @param @return
	* @param @throws BizException    
	* @return OutHosRegInParamDTO    
	* @throws
	 */
	public abstract OutHosRegInParamDTO getOutHosReg(String  entId) throws BizException;
	/**
	 * 
	* @Description:构建新益华发票登记入参
	* @param @param strIdEmpIss 收款员id
	* @param @param entId
	* @param @return
	* @param @throws BizException    
	* @return InpInvoiceInParamDTO    
	* @throws
	 */
	public abstract InpInvoiceInParamDTO[] getUploadInpInvoice(String strIdEmpIss, String entId)throws BizException;
	/********************************************************/
}
