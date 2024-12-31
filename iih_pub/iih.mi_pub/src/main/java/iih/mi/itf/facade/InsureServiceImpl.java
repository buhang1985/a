package iih.mi.itf.facade;

import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import iih.bd.pp.anhuisrvorca.d.TreatCompDTO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.mi.biz.dto.d.CancelInpRegisterParamDTO;
import iih.mi.biz.dto.d.DiInfoRegSetsInParamDTO;
import iih.mi.biz.dto.d.InpDetailUpLoadParamDTO;
import iih.mi.biz.dto.d.InpDetailsRtnValDTO;
import iih.mi.biz.dto.d.InpInvoiceInParamDTO;
import iih.mi.biz.dto.d.InpPayInParamDTO;
import iih.mi.biz.dto.d.InpPayRtnValDTO;
import iih.mi.biz.dto.d.InpRegisterParamDTO;
import iih.mi.biz.dto.d.InpRegisterRtnValDTO;
import iih.mi.biz.dto.d.MedicaluploadDTO;
import iih.mi.biz.dto.d.OperationRegSetsInParam;
import iih.mi.biz.dto.d.OutHosRegInParamDTO;
import iih.mi.biz.dto.d.ParamAttributeDTO;
import iih.mi.biz.dto.d.ReferralInfoRtnValDTO;
import iih.mi.biz.dto.d.ReferralSearchInParamDTO;
import iih.mi.itf.bizgrpitf.param.ResultOutParamDTO;
import iih.mi.itf.bizgrpitf.param.transferitf.InputParamTransferDTO;
import iih.mi.itf.bizgrpitf.param.transferitf.ResultOutParamTransferDTO;
import iih.mi.itf.context.InsureContext;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import xap.lui.core.dataset.PaginationInfo;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保服务实现类
 * 
 * @author hao_wu
 *
 */
@Service(serviceInterfaces = { IInsureService.class }, binding = Binding.JSONRPC)
public class InsureServiceImpl implements IInsureService {

	// 住院登记上传
	public ResultOutParamTransferDTO<InpRegisterRtnValDTO> uploadRegister(InsureContext insureContext,InputParamTransferDTO<InpRegisterParamDTO> inpRegister0) {
		InpRegisterParamDTO inpRegister = unWrapInputParamDTO(inpRegister0);
		InsureFacade insureFacade = new InsureFacade(insureContext);
		return wrapOutputParamDTO(insureFacade.UploadRegister(inpRegister));
	}

	public ParamAttributeDTO getUploadRegisterInParam(InsureContext insureContext) {
		InsureFacade insureFacade = new InsureFacade(insureContext);
		return insureFacade.getUploadRegisterInParam();
	}

	// 转诊单下载
	public ResultOutParamTransferDTO<List<ReferralInfoRtnValDTO>> downLoadReferralInfo(InsureContext insureContext,
			InputParamTransferDTO<ReferralSearchInParamDTO> inputParamDTO) {
		InsureFacade insureFacade = new InsureFacade(insureContext);
		ReferralSearchInParamDTO referralSearchInParam = unWrapInputParamDTO(inputParamDTO);
		return wrapOutputParamDTOs(insureFacade.DownLoadReferralInfo(referralSearchInParam));
	}

	public ParamAttributeDTO getDownLoadReferralInfoInParam(InsureContext insureContext) {
		InsureFacade insureFacade = new InsureFacade(insureContext);
		return insureFacade.getDownLoadReferralInfoInParam();
	}

	// 住院登记撤销
	public ResultOutParamDTO<String> cancelRegister(InsureContext insureContext,
			InputParamTransferDTO<CancelInpRegisterParamDTO> cancelInpRegisterParamDto0) {
		InsureFacade insureFacade = new InsureFacade(insureContext);
		CancelInpRegisterParamDTO cancelInpRegisterParamDto = unWrapInputParamDTO(cancelInpRegisterParamDto0);
		return insureFacade.CancelRegister(cancelInpRegisterParamDto);
	}

	public ParamAttributeDTO getCancelRegisterInParamKeys(InsureContext insureContext) {
		InsureFacade insureFacade = new InsureFacade(insureContext);
		return insureFacade.GetCancelRegisterInParamKeys();
	}

	// 明细费用上传
	public ResultOutParamTransferDTO<List<InpDetailsRtnValDTO>> uploadInpDetails(InsureContext insureContext,
			InputParamTransferDTO<InpDetailUpLoadParamDTO> inpDetailUpLoadParam0) {
		InsureFacade insureFacade = new InsureFacade(insureContext);
		InpDetailUpLoadParamDTO inpDetailUpLoadParam = unWrapInputParamDTO(inpDetailUpLoadParam0);
		return wrapOutputParamDTOs(insureFacade.UploadInpDetails(inpDetailUpLoadParam));
	}

	public ParamAttributeDTO getUploadInpDetailsInParam(InsureContext insureContext) {
		InsureFacade insureFacade = new InsureFacade(insureContext);
		return insureFacade.getUploadInpDetailsInParam();
	}

	// 住院结算发票登记
	@Override
	public ResultOutParamDTO<String> uploadInpInvoice(InsureContext insureContext, InputParamTransferDTO<List<InpInvoiceInParamDTO>> inpInvoiceParamDTOs0) {
		InsureFacade insureFacade = new InsureFacade(insureContext);
		List<InpInvoiceInParamDTO> inpInvoiceParamDTOs = unWrapInputParamDTOs(inpInvoiceParamDTOs0);
		return insureFacade.UploadInpInvoice(inpInvoiceParamDTOs);
	}

	public ParamAttributeDTO getUploadInpInvoiceInParam(InsureContext insureContext) {
		InsureFacade insureFacade = new InsureFacade(insureContext);
		return insureFacade.getUploadInpInvoiceInParam();
	}

	// 住院结算
	public ResultOutParamTransferDTO<InpPayRtnValDTO> inpPay(InsureContext insureContext, InputParamTransferDTO<InpPayInParamDTO> inpPayInParamDto0) {
		InsureFacade insureFacade = new InsureFacade(insureContext);
		InpPayInParamDTO inpPayInParamDto = unWrapInputParamDTO(inpPayInParamDto0);
		return wrapOutputParamDTO(insureFacade.InpPay(inpPayInParamDto));
	}

	public ParamAttributeDTO getInpPayInParam(InsureContext insureContext) {
		InsureFacade insureFacade = new InsureFacade(insureContext);
		return insureFacade.getInpPayInParam();
	}

	// 出院登记
	public ResultOutParamDTO<String> OutHosReg(InsureContext insureContext, InputParamTransferDTO<OutHosRegInParamDTO> outHosRegInParam0) {
		InsureFacade insureFacade = new InsureFacade(insureContext);
		OutHosRegInParamDTO outHosRegInParam = unWrapInputParamDTO(outHosRegInParam0);
		return insureFacade.OutHosReg(outHosRegInParam);
	}

	public ParamAttributeDTO getOutHosRegInParamKeys(InsureContext insureContext) {
		InsureFacade insureFacade = new InsureFacade(insureContext);
		return insureFacade.getOutHosRegInParamKeys();
	}

	@Override
	public ResultOutParamDTO<String> saveMedInsurDir(InsureContext insureContext, String miSrvTp, String fileKey) {
		InsureServiceFacade insureServiceFacade = new InsureServiceFacade(insureContext);
		ResultOutParamDTO<String> result = insureServiceFacade.saveMedInsurDir(miSrvTp, fileKey);
		return result;
	}

	@Override
	public ResultOutParamDTO<String> refreshMiDirComp(InsureContext insureContext, String miSrvTp) {
		InsureServiceFacade insureServiceFacade = new InsureServiceFacade(insureContext);
		ResultOutParamDTO<String> result = insureServiceFacade.refreshMiDirComp(miSrvTp);
		return result;
	}

	@Override
	public ResultOutParamDTO<String> miDirAutoComp(InsureContext insureContext, String miSrvTp) {
		InsureServiceFacade insureServiceFacade = new InsureServiceFacade(insureContext);
		ResultOutParamDTO<String> result = insureServiceFacade.miDirAutoComp(miSrvTp);
		return result;
	}

	/**
	 * 手术及操作信息上传接口
	 * 
	 * @param insureContext
	 * @param upLoadParamDto
	 * @return
	 * @Author gejie
	 */
	@Override
	public ResultOutParamDTO<String> UploadOperation(InsureContext insureContext, InputParamTransferDTO<OperationRegSetsInParam> upLoadParamDTO){
		InsureFacade insureFacade = new InsureFacade(insureContext);
		OperationRegSetsInParam operationRegSetsInParam = unWrapInputParamDTO(upLoadParamDTO);
		return insureFacade.UploadOperation(operationRegSetsInParam);
	}

	@Override
	public ParamAttributeDTO getUploadOperationInParam(InsureContext insureContext) {
		InsureFacade insureFacade = new InsureFacade(insureContext);
		return insureFacade.getUploadOperationInParam();
	}

	@Override
	public ResultOutParamDTO<String> CancelUploadOperation(InsureContext insureContext,InputParamTransferDTO<OperationRegSetsInParam> operationRegSetsInParam0) {
		InsureFacade insureFacade = new InsureFacade(insureContext);
		OperationRegSetsInParam operationRegSetsInParam = unWrapInputParamDTO(operationRegSetsInParam0);
		return insureFacade.CancelUploadOperation(operationRegSetsInParam);
	}

	@Override
	public ParamAttributeDTO getCancelUploadOperationInParam(InsureContext insureContext) {
		InsureFacade insureFacade = new InsureFacade(insureContext);
		return insureFacade.getCancelUploadOperationInParam();
	}

	@Override
	public ResultOutParamDTO<String> UploadDiagnosis(InsureContext insureContext, InputParamTransferDTO<DiInfoRegSetsInParamDTO> diInfoRegSetsInParam0) {
		InsureFacade insureFacade = new InsureFacade(insureContext);
		DiInfoRegSetsInParamDTO diInfoRegSetsInParam = unWrapInputParamDTO(diInfoRegSetsInParam0);
		return insureFacade.UploadDiagnosis(diInfoRegSetsInParam);
	}

	@Override
	public ParamAttributeDTO getUploadDiagnosisInParam(InsureContext insureContext) {
		InsureFacade insureFacade = new InsureFacade(insureContext);
		return insureFacade.getUploadDiagnosisInParam();
	}

	@Override
	public ResultOutParamDTO<String> CancelUploadDiagnosis(InsureContext insureContext,
			InputParamTransferDTO<DiInfoRegSetsInParamDTO> diInfoRegSetsInParam0) {
		InsureFacade insureFacade = new InsureFacade(insureContext);
		DiInfoRegSetsInParamDTO diInfoRegSetsInParam = unWrapInputParamDTO(diInfoRegSetsInParam0);
		return insureFacade.UploadDiagnosis(diInfoRegSetsInParam);
	}

	@Override
	public ParamAttributeDTO getCancelUploadDiagnosisInParam(InsureContext insureContext) {
		InsureFacade insureFacade = new InsureFacade(insureContext);
		return insureFacade.getCancelUploadDiagnosisInParam();
	}

	/**
	 * 新益华农合西医病案上传
	 * @param insureContext
	 * @param medicaluoloadDto
	 * @return
	 */
	@Override
	public ResultOutParamDTO<String> uploadMedicalupload(InsureContext insureContext,
			InputParamTransferDTO<MedicaluploadDTO> medicaluoloadDto) {
		InsureFacade insureFacade = new InsureFacade(insureContext);
		MedicaluploadDTO medicalDto=unWrapInputParamDTO(medicaluoloadDto)
;		return insureFacade.uploadMedicalupload(medicalDto);
	}

	@Override
	public ResultOutParamTransferDTO<List<DrugCompDTO>> saveDrugComp(InsureContext insureContext, InputParamTransferDTO<List<DrugCompDTO>> drugCompDTOs0) {
		List<DrugCompDTO> drugCompDTOs = unWrapInputParamDTOs(drugCompDTOs0);
		InsureServiceFacade insureServiceFacade = new InsureServiceFacade(insureContext);
		return wrapOutputParamDTOs(insureServiceFacade.saveDrugComp(drugCompDTOs));
	}
	@Override
	public ResultOutParamTransferDTO<List<DrugCompDTO>> saveDrugTreatComp(InsureContext insureContext, InputParamTransferDTO<List<DrugCompDTO>> drugCompDTOs0) {
		List<DrugCompDTO> drugCompDTOs = unWrapInputParamDTOs(drugCompDTOs0);
		InsureServiceFacade insureServiceFacade = new InsureServiceFacade(insureContext);
		return wrapOutputParamDTOs(insureServiceFacade.saveDrugTreatComp(drugCompDTOs));
	}

	@Override
	public ResultOutParamTransferDTO<List<TreatCompDTO>> saveTreatComp(InsureContext insureContext, InputParamTransferDTO<List<TreatCompDTO>> treatCompDTOs0) {
		List<TreatCompDTO> treatCompDTOs = unWrapInputParamDTOs(treatCompDTOs0);
		InsureServiceFacade insureServiceFacade = new InsureServiceFacade(insureContext);
		return wrapOutputParamDTOs(insureServiceFacade.saveTreatComp(treatCompDTOs));
	}

	@Override
	public ResultOutParamTransferDTO<List<DrugCompDTO>> deleteDrugComp(InsureContext insureContext, InputParamTransferDTO<List<DrugCompDTO>> drugCompDTOs0) {
		List<DrugCompDTO> drugCompDTOs = unWrapInputParamDTOs(drugCompDTOs0);
		InsureServiceFacade insureServiceFacade = new InsureServiceFacade(insureContext);
		return wrapOutputParamDTOs(insureServiceFacade.deleteDrugComp(drugCompDTOs));
	}

	@Override
	public ResultOutParamTransferDTO<List<TreatCompDTO>> deleteTreatComp(InsureContext insureContext, InputParamTransferDTO<List<TreatCompDTO>> treatCompDTOs0) {
		List<TreatCompDTO> treatCompDTOs = unWrapInputParamDTOs(treatCompDTOs0);
		InsureServiceFacade insureServiceFacade = new InsureServiceFacade(insureContext);
		return wrapOutputParamDTOs(insureServiceFacade.deleteTreatComp(treatCompDTOs));
	}

	@Override
	public ResultOutParamDTO<PagingRtnData<HPSrvorcaDO>> findByQCondAndPageInfo(InsureContext insureContext,
			QryRootNodeDTO qryRootNodeDto, String orderStr, PaginationInfo pg) {
		InsureServiceFacade insureServiceFacade = new InsureServiceFacade(insureContext);
		ResultOutParamDTO<PagingRtnData<HPSrvorcaDO>> result = insureServiceFacade
				.findByQCondAndPageInfo(qryRootNodeDto, orderStr, pg);
		return result;
	}

	@Override
	public ResultOutParamDTO<FArrayList> exportHpDirList(InsureContext insureContext, QryRootNodeDTO qryRootNodeDto,
			String orderStr, PaginationInfo pg, String miSrvTp) {
		InsureServiceFacade insureServiceFacade = new InsureServiceFacade(insureContext);
		ResultOutParamDTO<FArrayList> result = insureServiceFacade.exportHpDirList(qryRootNodeDto, orderStr, pg,
				miSrvTp);
		return result;
	}
	
	private <E extends BaseDO> E unWrapInputParamDTO(InputParamTransferDTO<E> inputParamDTO) {
		FArrayList data = inputParamDTO.getData();
		if (CollectionUtils.isEmpty(data))
			return null;
		return (E)data.get(0);
	}
	
	private <E extends BaseDO> List<E> unWrapInputParamDTOs(InputParamTransferDTO<List<E>> inputParamDTO) {
		FArrayList data = inputParamDTO.getData();
		if (CollectionUtils.isEmpty(data))
			return null;
		List<E> al = new ArrayList<E>();
		al.addAll(data);
		return (List<E>)al;
	}
	
	private <E extends BaseDO> ResultOutParamTransferDTO<E> wrapOutputParamDTO(ResultOutParamDTO<E> originalOutParam){
		if (originalOutParam==null)
			return null;
		ResultOutParamTransferDTO<E> resultOutParamTransferDTO = new ResultOutParamTransferDTO<E>();
		resultOutParamTransferDTO.setFg_deal(originalOutParam.getFg_deal());
		resultOutParamTransferDTO.setFg_HpSuccess(originalOutParam.getFg_HpSuccess());
		resultOutParamTransferDTO.setFg_HisSuccess(originalOutParam.getFg_HisSuccess());
		resultOutParamTransferDTO.setCenterTradeNo(originalOutParam.getCenterTradeNo());
		resultOutParamTransferDTO.setErrorMsg(originalOutParam.getErrorMsg());
		resultOutParamTransferDTO.setOutParamAttributes(originalOutParam.getOutParamAttributes());
		E e = originalOutParam.getData();
		if (e == null)
			return resultOutParamTransferDTO;
        FArrayList data = new FArrayList();
        data.add(e);
        resultOutParamTransferDTO.setData(data);
        return resultOutParamTransferDTO;
    }
	
	private <E extends BaseDO> ResultOutParamTransferDTO<List<E>> wrapOutputParamDTOs(ResultOutParamDTO<List<E>> originalOutParam){
		if (originalOutParam==null)
			return null;
		ResultOutParamTransferDTO<List<E>> resultOutParamTransferDTO = new ResultOutParamTransferDTO<List<E>>();
		resultOutParamTransferDTO.setFg_deal(originalOutParam.getFg_deal());
		resultOutParamTransferDTO.setFg_HpSuccess(originalOutParam.getFg_HpSuccess());
		resultOutParamTransferDTO.setFg_HisSuccess(originalOutParam.getFg_HisSuccess());
		resultOutParamTransferDTO.setCenterTradeNo(originalOutParam.getCenterTradeNo());
		resultOutParamTransferDTO.setErrorMsg(originalOutParam.getErrorMsg());
		resultOutParamTransferDTO.setOutParamAttributes(originalOutParam.getOutParamAttributes());
		List<E> list = originalOutParam.getData();
		if (CollectionUtils.isEmpty(list))
			return resultOutParamTransferDTO;
        FArrayList data = new FArrayList();
    	data.addAll(list);
        resultOutParamTransferDTO.setData(data);
        return resultOutParamTransferDTO;
    }

	@Override
	public void saveUnPassData(InsureContext insureContext, String fileKey) {
		InsureServiceFacade insureServiceFacade = new InsureServiceFacade(insureContext);
		ResultOutParamDTO<String> result = insureServiceFacade.saveUnPassData(fileKey);
	}
}
