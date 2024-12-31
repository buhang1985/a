package iih.mi.itf.facade;

import java.util.List;

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
import xap.lui.core.dataset.PaginationInfo;
import xap.mw.core.data.FArrayList;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保服务接口
 * 
 * @author hao_wu
 *
 */
public interface IInsureService {

	// 住院登记上传
	public ResultOutParamTransferDTO<InpRegisterRtnValDTO> uploadRegister(InsureContext insureContext,
			InputParamTransferDTO<InpRegisterParamDTO> inpRegister0);

	public ParamAttributeDTO getUploadRegisterInParam(InsureContext insureContext);

	// 转诊单下载
	public ResultOutParamTransferDTO<List<ReferralInfoRtnValDTO>> downLoadReferralInfo(InsureContext insureContext,
			InputParamTransferDTO<ReferralSearchInParamDTO> inputParamDTO);

	public ParamAttributeDTO getDownLoadReferralInfoInParam(InsureContext insureContext);

	// 住院登记撤销
	public ResultOutParamDTO<String> cancelRegister(InsureContext insureContext,
			InputParamTransferDTO<CancelInpRegisterParamDTO> cancelInpRegisterParamDto0);

	public ParamAttributeDTO getCancelRegisterInParamKeys(InsureContext insureContext);

	// 明细费用上传
	public ResultOutParamTransferDTO<List<InpDetailsRtnValDTO>> uploadInpDetails(InsureContext insureContext,
			InputParamTransferDTO<InpDetailUpLoadParamDTO> inpDetailUpLoadParam0);

	public ParamAttributeDTO getUploadInpDetailsInParam(InsureContext insureContext);

	// 住院结算发票登记
	public ResultOutParamDTO<String> uploadInpInvoice(InsureContext insureContext,
			InputParamTransferDTO<List<InpInvoiceInParamDTO>> inpInvoiceParamDTOs0);

	public ParamAttributeDTO getUploadInpInvoiceInParam(InsureContext insureContext);

	// 住院结算
	public ResultOutParamTransferDTO<InpPayRtnValDTO> inpPay(InsureContext insureContext,
			InputParamTransferDTO<InpPayInParamDTO> inpPayInParamDto0);

	public ParamAttributeDTO getInpPayInParam(InsureContext insureContext);

	// 出院登记
	public ResultOutParamDTO<String> OutHosReg(InsureContext insureContext,
			InputParamTransferDTO<OutHosRegInParamDTO> outHosRegInParam0);

	public ParamAttributeDTO getOutHosRegInParamKeys(InsureContext insureContext);

	/**
	 * 手术及操作信息上传接口
	 * 
	 * @param insureContext
	 * @param upLoadParamDto
	 * @return
	 * @Author gejie
	 */
	public ResultOutParamDTO<String> UploadOperation(InsureContext insureContext,
			InputParamTransferDTO<OperationRegSetsInParam> upLoadParamDTO);

	/**
	 * 获取手术操作上传入参的key值
	 * 
	 * @param insureContext
	 * @return
	 * @author gejie
	 */
	public ParamAttributeDTO getUploadOperationInParam(InsureContext insureContext);

	/**
	 * 取消手术及操作信息上传
	 * 
	 * @param insureContext
	 * @param upLoadParamDto
	 * @return
	 */
	public ResultOutParamDTO<String> CancelUploadOperation(InsureContext insureContext,
			InputParamTransferDTO<OperationRegSetsInParam> operationRegSetsInParam0);

	public ParamAttributeDTO getCancelUploadOperationInParam(InsureContext insureContext);

	// 住院疾病诊断登记
	public ResultOutParamDTO<String> UploadDiagnosis(InsureContext insureContext,
			InputParamTransferDTO<DiInfoRegSetsInParamDTO> diInfoRegSetsInParam0);

	public ParamAttributeDTO getUploadDiagnosisInParam(InsureContext insureContext);

	// 取消住院疾病诊断登记
	public ResultOutParamDTO<String> CancelUploadDiagnosis(InsureContext insureContext,
			InputParamTransferDTO<DiInfoRegSetsInParamDTO> diInfoRegSetsInParam0);

	public ParamAttributeDTO getCancelUploadDiagnosisInParam(InsureContext insureContext);

	/**
	 * 新益华农合西医病案上传
	 * 
	 * @param insureContext
	 * @param medicaluoloadDto
	 * @return
	 */
	public ResultOutParamDTO<String> uploadMedicalupload(InsureContext insureContext,
			InputParamTransferDTO<MedicaluploadDTO> medicaluoloadDto);

	/**
	 * 保存医保目录
	 * 
	 * @param insureContext
	 *            医保上下文
	 * @param miSrvTp
	 *            医保项目类型</br>
	 *            枚举：iih.mi.biz.dto.d.MiSrvTp
	 * @param fileKey
	 *            文件Key
	 * @return
	 */
	public ResultOutParamDTO<String> saveMedInsurDir(InsureContext insureContext, String miSrvTp, String fileKey);

	/**
	 * 刷新医保目录对照</br>
	 * 将不在对照表中的数据生成到对照表中
	 * 
	 * @param insureContext
	 *            医保上下文
	 * @param miSrvTp
	 *            医保项目类型</br>
	 *            枚举：iih.mi.biz.dto.d.MiSrvTp
	 * @return
	 */
	public ResultOutParamDTO<String> refreshMiDirComp(InsureContext insureContext, String miSrvTp);

	/**
	 * 医保目录自动对照
	 * 
	 * @param insureContext
	 *            医保上下文
	 * @param miSrvTp
	 *            医保项目类型</br>
	 *            枚举：iih.mi.biz.dto.d.MiSrvTp
	 * @return
	 */
	public ResultOutParamDTO<String> miDirAutoComp(InsureContext insureContext, String miSrvTp);

	/**
	 * 保存药品对照
	 * 
	 * @param insureContext
	 *            医保上下文
	 * @param drugCompDTOs
	 *            药品对照DTO集合
	 * @return
	 */
	public ResultOutParamTransferDTO<List<DrugCompDTO>> saveDrugComp(InsureContext insureContext,
			InputParamTransferDTO<List<DrugCompDTO>> drugCompDTOs);
	/**
	 * 保存药品诊疗对照
	 * 
	 * @param insureContext
	 *            医保上下文
	 * @param drugCompDTOs
	 *            药品对照DTO集合
	 * @return
	 */
	public ResultOutParamTransferDTO<List<DrugCompDTO>> saveDrugTreatComp(InsureContext insureContext,
			InputParamTransferDTO<List<DrugCompDTO>> drugCompDTOs);

	/**
	 * 保存诊疗对照
	 * 
	 * @param insureContext
	 *            医保上下文
	 * @param treatCompDTOs
	 *            诊疗对照DTO集合
	 * @return
	 */
	public ResultOutParamTransferDTO<List<TreatCompDTO>> saveTreatComp(InsureContext insureContext,
			InputParamTransferDTO<List<TreatCompDTO>> treatCompDTOs);

	/**
	 * 删除药品对照
	 * 
	 * @param insureContext
	 *            医保上下文
	 * @param drugCompDTOs
	 *            药品对照DTO集合
	 * @return
	 */
	public ResultOutParamTransferDTO<List<DrugCompDTO>> deleteDrugComp(InsureContext insureContext,
			InputParamTransferDTO<List<DrugCompDTO>> drugCompDTOs);

	/**
	 * 删除诊疗对照
	 * 
	 * @param insureContext
	 *            医保上下文
	 * @param treatCompDTOs
	 *            诊疗对照DTO集合
	 * @return
	 */
	public ResultOutParamTransferDTO<List<TreatCompDTO>> deleteTreatComp(InsureContext insureContext,
			InputParamTransferDTO<List<TreatCompDTO>> treatCompDTOs);
	// public void test() throws BizException;

	/**
	 * @param insureContext
	 *            医保上下文
	 * @param qryRootNodeDto
	 *            查询方案
	 * @param orderStr
	 *            排序字段
	 * @param pg
	 *            分页信息
	 * @return
	 */
	public ResultOutParamDTO<PagingRtnData<HPSrvorcaDO>> findByQCondAndPageInfo(InsureContext insureContext,
			QryRootNodeDTO qryRootNodeDto, String orderStr, PaginationInfo pg);

	/**
	 * @param insureContext
	 *            医保上下文
	 * @param qryRootNodeDto
	 *            查询方案
	 * @param orderStr
	 *            排序字段
	 * @param pg
	 *            分页信息
	 * @param miSrvTp
	 *            服务类型
	 * @return
	 */
	public ResultOutParamDTO<FArrayList> exportHpDirList(InsureContext insureContext, QryRootNodeDTO qryRootNodeDto,
			String orderStr, PaginationInfo pg, String miSrvTp);

	/**
	 * 保存未审批通过数据
	 * 
	 * @param _insureContext
	 *            医保上下文
	 * @param _fileKey
	 *            文件Key
	 */
	public void saveUnPassData(InsureContext _insureContext, String _fileKey);
}
