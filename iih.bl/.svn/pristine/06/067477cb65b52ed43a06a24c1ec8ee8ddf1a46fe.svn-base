package iih.bl.hp.s;

import iih.bl.hp.dto.miipcharge.d.DetailUpLoadSearchDTO;
import iih.bl.hp.i.IBlMiParamPackagingService;
import iih.bl.hp.s.bp.GetOutHosRegBp;
import iih.bl.hp.s.bp.GetUploadDiagnosisBp;
import iih.bl.hp.s.bp.GetUploadInpInvoiceBp;
import iih.bl.hp.s.miparampack.GetInpPrePayParamBp;
import iih.bl.hp.s.miparampack.GetUploadInpDetailsParamBP;
import iih.mi.biz.dto.d.DiInfoRegSetsInParamDTO;
import iih.mi.biz.dto.d.InpDetailUpLoadParamDTO;
import iih.mi.biz.dto.d.InpInvoiceInParamDTO;
import iih.mi.biz.dto.d.InpPayInParamDTO;
import iih.mi.biz.dto.d.OutHosRegInParamDTO;
import iih.mi.biz.dto.d.ParamAttributeDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.securityfw.switchdept.d.PsnInfo;

/**
 * 费用域医保平台调用参数组装service
 * @author ly 2018/03/09
 *
 */
@Service(serviceInterfaces={IBlMiParamPackagingService.class}, binding=Binding.JSONRPC)
public class BlMiParamPackagingServiceImpl implements IBlMiParamPackagingService {

	/**
	 * 构建明细费用上传参数值
	 * @param searchDto 查询条件
	 * @param attrDto 需要设置的参数
	 * @return
	 * @throws BizException
	 */
	@Override
	public InpDetailUpLoadParamDTO getUploadInpDetailsParam(
			DetailUpLoadSearchDTO searchDto, ParamAttributeDTO attrDto)throws BizException {
		GetUploadInpDetailsParamBP bp = new GetUploadInpDetailsParamBP();
		return bp.exec(searchDto, attrDto);
	}
	/**
	 * 构建预结算上传参数值
	 * @param searchDto 查询条件
	 * @param attrDto 需要设置的参数
	 * @return
	 * @throws BizException
	 */
	@Override
	public InpPayInParamDTO getInpPrePayParam(String entId,PsnInfo psnInfo,
			ParamAttributeDTO attrDto) throws BizException {
		GetInpPrePayParamBp bp=new GetInpPrePayParamBp();
		return bp.exec(entId,psnInfo,attrDto);
	}
	/**
	 * 
	* @Description:构建新益华诊断上传入参
	* @param @param entId
	* @param @return    
	* @return DiInfoRegSetsInParamDTO    
	* @throws BizException
	 */
	@Override
	public DiInfoRegSetsInParamDTO getUploadDiagnosis(String entId) throws BizException{
		GetUploadDiagnosisBp bp=new GetUploadDiagnosisBp();
		return bp.exec(entId);
	}
	/**
	 * 
	* @Description:构建新益华出院登记入参
	* @param @param entId
	* @param @return    
	* @return DiInfoRegSetsInParamDTO    
	* @throws BizException
	 */
	@Override
	public OutHosRegInParamDTO getOutHosReg(String entId) throws BizException {
		GetOutHosRegBp bp=new GetOutHosRegBp();
		return bp.exec(entId);
	}
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
	@Override
	public InpInvoiceInParamDTO[] getUploadInpInvoice(String strIdEmpIss, String entId) throws BizException {
		GetUploadInpInvoiceBp bp=new GetUploadInpInvoiceBp();
		return bp.exec(strIdEmpIss,entId);
	}
	
	 
}
