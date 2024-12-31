package iih.mi.inst.bizbase;

import java.util.List;

import iih.mi.bd.d.HpDTO;
import iih.mi.biz.common.d.MiPropInfoInDTO;
import iih.mi.biz.common.d.MiPropInfoOutDTO;
import iih.mi.biz.dto.d.DiInfoRegSetsInParamDTO;
import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.biz.dto.d.InpDetailUpLoadParamDTO;
import iih.mi.biz.dto.d.InpDetailsRtnValDTO;
import iih.mi.biz.dto.d.InpInvoiceInParamDTO;
import iih.mi.biz.dto.d.InpPayInParamDTO;
import iih.mi.biz.dto.d.InpPayRtnValDTO;
import iih.mi.biz.dto.d.MedicaluploadDTO;
import iih.mi.biz.dto.d.MedicaluploadTcmDTO;
import iih.mi.biz.dto.d.OperationRegSetsInParam;
import iih.mi.biz.dto.d.ParamAttributeDTO;
import iih.mi.itf.bizgrpitf.param.ResultOutParamDTO;
import iih.mi.itf.dto.proxyhp.d.StProxyhpDTO;
import iih.mi.miinsurebiz.etsettleparam.d.EtSettleRtnValDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.FArrayList;

public class IpChargeBaseImpl extends InsureBaseImpl{
	
	public ResultOutParamDTO<List<InpDetailsRtnValDTO>> UploadInpDetails(InpDetailUpLoadParamDTO upLoadParamDto) {
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品不支持[住院费用明细录入]接口方法!");
	}
	public ParamAttributeDTO getUploadInpDetailsInParam(){
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品不支持[住院费用明细录入]接口方法!");
	}
	
	public ResultOutParamDTO<String> UploadInpInvoice(List<InpInvoiceInParamDTO> inpInvoiceParamDTO) {
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品不支持[住院结算发票登记]接口方法!");
	}
	public ParamAttributeDTO getUploadInpInvoiceInParam() {
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品不支持[住院结算发票登记]接口方法!");
	}

	public ResultOutParamDTO<InpPayRtnValDTO> InpPay(InpPayInParamDTO inpPayInParamDto) {
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品不支持[住院结算记]接口方法!");
	}

	public ParamAttributeDTO getInpPayInParam() {
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品不支持[住院结算记]接口方法!");
	}
	
    //手术及操作信息上传
	public ResultOutParamDTO<String> UploadOperation(OperationRegSetsInParam upLoadParamDto){
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品不支持[手术及操作信息上传]接口方法!");
	}
	public ParamAttributeDTO getUploadOperationInParam(){
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品不支持[手术及操作信息上传]接口方法!");
	}
	
	//取消手术及操作信息上传
	public ResultOutParamDTO<String> CancelUploadOperation(OperationRegSetsInParam upLoadParamDto){
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品不支持[取消手术及操作信息上传]接口方法!");
	}
	public ParamAttributeDTO getCancelUploadOperationInParam(){
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品不支持[取消手术及操作信息上传]接口方法!");
	}
	
	
	//住院疾病诊断登记
	public ResultOutParamDTO<String> UploadDiagnosis(DiInfoRegSetsInParamDTO upLoadParamDto){
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品不支持[住院疾病诊断登记]接口方法!");
	}
	public ParamAttributeDTO getUploadDiagnosisInParam(){
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品不支持[住院疾病诊断登记]接口方法!");
	}
	
	
	//取消住院疾病诊断登记
	public ResultOutParamDTO CancelUploadDiagnosis(DiInfoRegSetsInParamDTO upLoadParamDto){
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品不支持[取消住院疾病诊断登记]接口方法!");
	}
	public ParamAttributeDTO getCancelUploadDiagnosisInParam(){
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品不支持[取消住院疾病诊断登记]接口方法!");
	}
	
	//病案上传 2018-05-22
	public ResultOutParamDTO MedicalUpload(MedicaluploadDTO upLoadParamDto){
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品不支持[住院病案上传]接口方法!");
	};
	public ParamAttributeDTO getUploadMedicalInParam(){
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品不支持[住院病案上传]接口方法!");
	};
	
	//病案上传 2018-05-22
	public ResultOutParamDTO MedicalUploadTcm(MedicaluploadTcmDTO upLoadParamDto){
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品不支持[住院病案（中医）上传]接口方法!");
	};
	public ParamAttributeDTO getUploadMedicalTcmInParam(){
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品不支持[住院病案（中医）上传]接口方法!");
	};
	
	/**保存各医保分摊信息
	 * @param hpPayRtnValDto
	 * @return
	 * @throws BizException
	 */
	public FArrayList saveHpPropTmpData(InpPayRtnValDTO hpPayRtnValDto,HisPropertyRefHpDTO hisPropertyDto) throws BizException{
		HpDTO hpDTO= getHpDTO();
		throw new BizException("["+hpDTO.getCode()+"]医保产品必须实现自己的医保分摊数据保存逻辑!");
	}
	/**保存医保分摊的红冲数据
	 * @return
	 * @throws BizException
	 */
	public FArrayList saveBackHpPropTmpData(HisPropertyRefHpDTO hisPropertyDTO) throws BizException{
		HpDTO hpDTO= getHpDTO();
		throw new BizException("["+hpDTO.getCode()+"]医保产品必须实现自己的医保分摊数据保存逻辑!");
	}
	
	/** 获取具体医保分摊数据
	 * @return
	 * @throws BizException
	 */
	public FArrayList getHpPropDataTmp(HisPropertyRefHpDTO hisPropertyDTO) throws BizException{
		HpDTO hpDTO= getHpDTO();
		throw new BizException("["+hpDTO.getCode()+"]医保产品必须实现自己的医保分摊数据查询逻辑!");
	}
	
	/** 保存收付款分摊信息（常规流程）
	 * @return 保存得分摊结果
	 * @throws BizException
	 * @date 2018-04-26
	 */
	public FArrayList savePayPropData(InpPayRtnValDTO hpPayRtnValDto,HisPropertyRefHpDTO hisPropertyDTO) throws BizException{
		HpDTO hpDTO= getHpDTO();
		throw new BizException("["+hpDTO.getCode()+"]医保产品必须实现自己的医保分摊数据保存逻辑!");
	}
	
	public FArrayList saveBackPayPropData(InpPayRtnValDTO hpPayRtnValDto,HisPropertyRefHpDTO hisPropertyDTO) throws BizException{
		HpDTO hpDTO= getHpDTO();
		throw new BizException("["+hpDTO.getCode()+"]医保产品必须实现自己的医保分摊红冲数据保存逻辑!");
	}
	/**
	 * 更新医保前置流程分摊his关联主键
	 * @Title: updataTmpPropDataOep   
	 * @Description: TODO  
	 * @param: @param hisPropertyDTO
	 * @param: @return
	 * @param: @throws BizException      
	 * @return: FArrayList      
	 * @throws
	 */
	public FArrayList updateTmpPropDataOep(HisPropertyRefHpDTO hisPropertyDTO) throws BizException{
		HpDTO hpDTO= getHpDTO();
		throw new BizException("["+hpDTO.getCode()+"]医保产品必须实现自己的医保分摊数据查询逻辑!");
	}
	
	/**
	 * 更新急诊转住院分摊
	 * @param hpPayRtnValDto
	 * @param stProxyHpDo
	 */
	public void updateEtToIpPropData(EtSettleRtnValDTO hpPayRtnValDto,StProxyhpDTO stProxyHpDto)throws BizException
	{
		throw new BizException("医保产品必须实现自己的更新急诊转住院分摊逻辑!");

	}

	/**
	 * 红冲急诊转住院分摊
	 * @param stProxyHpDto
	 */
	public void saveBackEtToIpPropData(StProxyhpDTO stProxyHpDto)throws BizException
	{
		throw new BizException("医保产品必须实现自己的红冲急诊转住院分摊逻辑!");

	}
	
	/**
	 * 获取住院医保分摊结果
	 * @param dto
	 * @return
	 * @throws BizException
	 * @author ly 2019/12/31
	 */
	public MiPropInfoOutDTO getIpPropData(MiPropInfoInDTO dto) throws BizException{
		return new MiPropInfoOutDTO();
	}

}
