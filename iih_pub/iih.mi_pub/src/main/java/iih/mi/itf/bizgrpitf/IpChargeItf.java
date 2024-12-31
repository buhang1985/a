package iih.mi.itf.bizgrpitf;

import java.util.List;

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
import xap.mw.core.data.FArrayList;

public interface IpChargeItf {
	
    //明细费用上传
	public ResultOutParamDTO<List<InpDetailsRtnValDTO>> UploadInpDetails(InpDetailUpLoadParamDTO upLoadParamDto);
    public ParamAttributeDTO getUploadInpDetailsInParam();
    
    //住院结算发票登记
	public ResultOutParamDTO<String> UploadInpInvoice(List<InpInvoiceInParamDTO> inpInvoiceParamDTO);
    public ParamAttributeDTO getUploadInpInvoiceInParam();
    
    //住院结算
    public ResultOutParamDTO<InpPayRtnValDTO> InpPay(InpPayInParamDTO inpPayInParamDto);
    public ParamAttributeDTO getInpPayInParam();
    
    //手术及操作信息上传
	public ResultOutParamDTO<String> UploadOperation(OperationRegSetsInParam upLoadParamDto);
	public ParamAttributeDTO getUploadOperationInParam();
	
	//取消手术及操作信息上传
	public ResultOutParamDTO<String> CancelUploadOperation(OperationRegSetsInParam upLoadParamDto);
	public ParamAttributeDTO getCancelUploadOperationInParam();
	
	//住院疾病诊断登记
	public ResultOutParamDTO<String> UploadDiagnosis(DiInfoRegSetsInParamDTO upLoadParamDto);
	public ParamAttributeDTO getUploadDiagnosisInParam();
	
	//取消住院疾病诊断登记
	public ResultOutParamDTO<String> CancelUploadDiagnosis(DiInfoRegSetsInParamDTO upLoadParamDto);
	public ParamAttributeDTO getCancelUploadDiagnosisInParam();
	
	//病案上传 2018-05-22
	public ResultOutParamDTO<String> MedicalUpload(MedicaluploadDTO upLoadParamDto);
	public ParamAttributeDTO getUploadMedicalInParam();
	
	//病案上传-中医 2018-05-22
	public ResultOutParamDTO<String> MedicalUploadTcm(MedicaluploadTcmDTO upLoadParamDto);
	public ParamAttributeDTO getUploadMedicalTcmInParam();
	//public 
	/**保存前置医保的分摊数据
	 * @return
	 * @throws BizException
	 */
	public abstract FArrayList saveHpPropTmpData(InpPayRtnValDTO hpPayRtnValDto,HisPropertyRefHpDTO hisPrpertyDto) throws BizException;
	
	/**保存医保分摊的红冲数据
	 * @return
	 * @throws BizException
	 */
	public abstract FArrayList saveBackHpPropTmpData(HisPropertyRefHpDTO hisPropertyDTO) throws BizException;

	/** 获取医保分摊数据
	 * @param hisPropertyDTO
	 * @return
	 * @throws BizException
	 */
	public abstract FArrayList getHpPropDataTmp(HisPropertyRefHpDTO hisPropertyDTO) throws BizException;

	/** 保存收付款分摊信息（常规流程）
	 * @return 保存得分摊结果
	 * @throws BizException
	 * @date 2018-04-26
	 */
	public abstract FArrayList savePayPropData(InpPayRtnValDTO hpPayRtnValDto,HisPropertyRefHpDTO hisPropertyDTO) throws BizException;
	
	/** 保存医保分摊红冲数据
	 * @param hpPayRtnValDto
	 * @param hisPropertyDTO
	 * @return
	 * @throws BizException
	 * @author yangyang
	 */
	public abstract FArrayList saveBackPayPropData(InpPayRtnValDTO hpPayRtnValDto,HisPropertyRefHpDTO hisPropertyDTO) throws BizException;
	/**
	 * 更新前置流程分摊关联主键
	 * @Title: updataTmpPropDataOep   
	 * @Description: TODO  
	 * @param: @param hisPropertyDTO
	 * @param: @return
	 * @param: @throws BizException      
	 * @return: FArrayList      
	 * @throws
	 */
	public abstract FArrayList updateTmpPropDataOep(HisPropertyRefHpDTO hisPropertyDTO) throws BizException;

	/**
	 * 更新急诊转住院分摊
	 * @param hpPayRtnValDto
	 * @param stProxyHpDo
	 */
	public abstract void updateEtToIpPropData(EtSettleRtnValDTO hpPayRtnValDto,StProxyhpDTO stProxyHpDto)throws BizException;

	/**
	 * 红冲急诊转住院分摊
	 * @param stProxyHpDto
	 */
	public abstract void saveBackEtToIpPropData(StProxyhpDTO stProxyHpDto)throws BizException;

	/**
	 * 获取住院医保分摊结果
	 * @param dto
	 * @return
	 * @throws BizException
	 * @author ly 2019/12/31
	 */
	public abstract MiPropInfoOutDTO getIpPropData(MiPropInfoInDTO dto) throws BizException;
}