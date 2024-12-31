package iih.mi.itf.facade;

import java.util.List;
import java.util.Map;

import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import iih.mi.bd.d.HpDTO;
import iih.mi.biz.common.d.MiPropInfoInDTO;
import iih.mi.biz.common.d.MiPropInfoOutDTO;
import iih.mi.biz.dto.d.CancelInpRegisterParamDTO;
import iih.mi.biz.dto.d.CommonPropDataDTO;
import iih.mi.biz.dto.d.DiInfoRegSetsInParamDTO;
import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.biz.dto.d.InpDetailUpLoadParamDTO;
import iih.mi.biz.dto.d.InpDetailsRtnValDTO;
import iih.mi.biz.dto.d.InpInvoiceInParamDTO;
import iih.mi.biz.dto.d.InpPayInParamDTO;
import iih.mi.biz.dto.d.InpPayRtnValDTO;
import iih.mi.biz.dto.d.InpRegisterParamDTO;
import iih.mi.biz.dto.d.InpRegisterRtnValDTO;
import iih.mi.biz.dto.d.MedicaluploadDTO;
import iih.mi.biz.dto.d.MedicaluploadTcmDTO;
import iih.mi.biz.dto.d.OepSettleRtnValDTO;
import iih.mi.biz.dto.d.OperationRegSetsInParam;
import iih.mi.biz.dto.d.OutHosRegInParamDTO;
import iih.mi.biz.dto.d.ParamAttributeDTO;
import iih.mi.biz.dto.d.ReferralInfoRtnValDTO;
import iih.mi.biz.dto.d.ReferralSearchInParamDTO;
import iih.mi.itf.bizgrpitf.HpInnerService;
import iih.mi.biz.flow.oepchargeflow.d.MiOepChargePaySelfInParamDTO;
import iih.mi.biz.flow.oepchargeflow.d.MiOepChargePaySelfOutParamDTO;
import iih.mi.biz.flow.oepchargeflow.d.MiOepChargePricingSelfInParamDTO;
import iih.mi.biz.flow.oepchargeflow.d.MiOepChargePricingSelfOutParamDTO;
import iih.mi.itf.bizgrpitf.HpSettingItf;
import iih.mi.itf.bizgrpitf.IpChargeItf;
import iih.mi.itf.bizgrpitf.IpRegisterItf;
import iih.mi.itf.bizgrpitf.OepChargeItf;
import iih.mi.itf.bizgrpitf.param.ResultOutParamDTO;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.dto.proxyhp.d.StProxyhpDTO;
import iih.mi.itf.factory.InsureInstanceFactory;
import iih.mi.miinsurebiz.etsettleparam.d.EtSettleRtnValDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.utils.ObjectCreator;

public class InsureFacade {
	
	// 医保产品
	private HpDTO hpDTO = null; 

	// 医保产品编码
	private String id_hp = null;
	// 医保险种编码
	// private String hpKindCode = null;

	// 医保系统工厂实例类
	protected InsureInstanceFactory insureInstanceFactory = null;
	
	// 医保第三方数据源
	private String dataSourceName = null;
	
	// 医保后台开发模块
	public static final String MI_DEV_MODULE = "iih.mi";
	
	
	public HpDTO geHpDTO() {
		return hpDTO;
	}
	
	public String getId_hp() {
		return id_hp;
	}

	public String getDataSourceName() {
		return dataSourceName;
	}

	public InsureFacade(InsureContext insureContext) {
		super();
		init(insureContext);
	}

	/**
	 * 初始化
	 * 
	 * @param insureContext
	 */
	private void init(InsureContext insureContext) {
		if (StringUtil.isEmptyWithTrim(insureContext.getIdHp())) {
			throw new BizRuntimeException("医保系统编码为空!");
		}
		HpDTO hpDTO = null;
		try {
			hpDTO = HpCacheProxy.getHpDTOById(insureContext.getIdHp());
		} catch (BizException e) {
			throw new BizRuntimeException(e.getMessage(), e);
		}
		if (hpDTO == null)
			throw new BizRuntimeException("根据医保系统编码查询不到医保系统!");
		if (hpDTO.getFactoryinst() == null)
			throw new BizRuntimeException("请先设置医保系统的工厂实例参数!");
		
		this.hpDTO = hpDTO;
		this.id_hp = insureContext.getIdHp();
		// this.hpKindCode = insureContext.getHpKindCode();
		
		//2018/07/20修改 工厂配置：类名,dll名,模块名
		String[] classModules = hpDTO.getFactoryinst().split(",");
		String module = "";
		String className = classModules[0];
		if (classModules.length == 3) {
			module = classModules[2];
		} else {
			module = MI_DEV_MODULE;
		}
		
		this.insureInstanceFactory = (InsureInstanceFactory) ObjectCreator.newInstance(module,className);
		this.dataSourceName = hpDTO.getDatasourcename();
		Context.get().setAttribute(InsureFacade.class.getName(), InsureFacade.this);
	}
	
	// 住院登记上传
	public ResultOutParamDTO<InpRegisterRtnValDTO> UploadRegister(InpRegisterParamDTO inpRegister){
		IpRegisterItf registerItf = this.insureInstanceFactory.createIpRegisterInstance();
		return registerItf.UploadRegister(inpRegister);
	}
	public ParamAttributeDTO getUploadRegisterInParam(){
		IpRegisterItf registerItf = this.insureInstanceFactory.createIpRegisterInstance();
		return registerItf.getUploadRegisterInParam();
	}
	// 转诊单下载
	public ResultOutParamDTO<List<ReferralInfoRtnValDTO>> DownLoadReferralInfo(ReferralSearchInParamDTO searchParam){
		IpRegisterItf registerItf = this.insureInstanceFactory.createIpRegisterInstance();
		return registerItf.DownLoadReferralInfo(searchParam);
	}
	public ParamAttributeDTO getDownLoadReferralInfoInParam(){
		IpRegisterItf registerItf = this.insureInstanceFactory.createIpRegisterInstance();
		return registerItf.getDownLoadReferralInfoInParam();
	}
    // 住院登记撤销
    public ResultOutParamDTO<String> CancelRegister(CancelInpRegisterParamDTO cancelInpRegisterParamDto){
		IpRegisterItf registerItf = this.insureInstanceFactory.createIpRegisterInstance();
		return registerItf.CancelRegister(cancelInpRegisterParamDto);
    }
    public ParamAttributeDTO GetCancelRegisterInParamKeys(){
		IpRegisterItf registerItf = this.insureInstanceFactory.createIpRegisterInstance();
		return registerItf.GetCancelRegisterInParamKeys();
    }
    //明细费用上传
	public ResultOutParamDTO<List<InpDetailsRtnValDTO>> UploadInpDetails(InpDetailUpLoadParamDTO upLoadParamDto) {
		IpChargeItf ipChargeItf = this.insureInstanceFactory.createIpChargeInstance();
		return ipChargeItf.UploadInpDetails(upLoadParamDto);
	}
    public ParamAttributeDTO getUploadInpDetailsInParam(){
		IpChargeItf ipChargeItf = this.insureInstanceFactory.createIpChargeInstance();
		return ipChargeItf.getUploadInpDetailsInParam();
    }
    //住院结算发票登记
	public ResultOutParamDTO<String> UploadInpInvoice(List<InpInvoiceInParamDTO> inpInvoiceParamDTO){
		IpChargeItf ipChargeItf = this.insureInstanceFactory.createIpChargeInstance();
		return ipChargeItf.UploadInpInvoice(inpInvoiceParamDTO);
	}
    public ParamAttributeDTO getUploadInpInvoiceInParam(){
		IpChargeItf ipChargeItf = this.insureInstanceFactory.createIpChargeInstance();
		return ipChargeItf.getUploadInpInvoiceInParam();
    }
    //住院结算
  	public ResultOutParamDTO<InpPayRtnValDTO> InpPay(InpPayInParamDTO inpPayInParamDto) {
  		IpChargeItf ipChargeItf = this.insureInstanceFactory.createIpChargeInstance();
  		return ipChargeItf.InpPay(inpPayInParamDto);
  	}
    public ParamAttributeDTO getInpPayInParam(){
    	IpChargeItf ipChargeItf = this.insureInstanceFactory.createIpChargeInstance();
    	return ipChargeItf.getInpPayInParam();
    }
    
    //出院登记
    public ResultOutParamDTO<String> OutHosReg(OutHosRegInParamDTO outHosRegDto){
		IpRegisterItf registerItf = this.insureInstanceFactory.createIpRegisterInstance();
		return registerItf.OutHosReg(outHosRegDto);
    }
    public ParamAttributeDTO getOutHosRegInParamKeys(){
		IpRegisterItf registerItf = this.insureInstanceFactory.createIpRegisterInstance();
		return registerItf.getOutHosRegInParamKeys();
    }
    

    //手术及操作信息上传
	public ResultOutParamDTO<String> UploadOperation(OperationRegSetsInParam upLoadParamDto){
		IpChargeItf ipChargeItf = this.insureInstanceFactory.createIpChargeInstance();
		return ipChargeItf.UploadOperation(upLoadParamDto);
    }
	public ParamAttributeDTO getUploadOperationInParam(){
		IpChargeItf ipChargeItf = this.insureInstanceFactory.createIpChargeInstance();
		return ipChargeItf.getUploadOperationInParam();
	}

	/**取消手术及操作信息上传
	 * @param upLoadParamDto
	 * @return
	 */
	public ResultOutParamDTO<String> CancelUploadOperation(OperationRegSetsInParam upLoadParamDto){
		IpChargeItf ipChargeItf = this.insureInstanceFactory.createIpChargeInstance();
		return ipChargeItf.CancelUploadOperation(upLoadParamDto);
	}
	public ParamAttributeDTO getCancelUploadOperationInParam(){
		IpChargeItf ipChargeItf = this.insureInstanceFactory.createIpChargeInstance();
		return ipChargeItf.getCancelUploadOperationInParam();
	}
	
	//住院疾病诊断登记
	public ResultOutParamDTO<String> UploadDiagnosis(DiInfoRegSetsInParamDTO upLoadParamDto){
		IpChargeItf ipChargeItf = this.insureInstanceFactory.createIpChargeInstance();
		return ipChargeItf.UploadDiagnosis(upLoadParamDto);
	}
	public ParamAttributeDTO getUploadDiagnosisInParam(){
		IpChargeItf ipChargeItf = this.insureInstanceFactory.createIpChargeInstance();
		return ipChargeItf.getUploadDiagnosisInParam();
	}
	
	//取消住院疾病诊断登记
	public ResultOutParamDTO<String> CancelUploadDiagnosis(DiInfoRegSetsInParamDTO upLoadParamDto){
		IpChargeItf ipChargeItf = this.insureInstanceFactory.createIpChargeInstance();
		return ipChargeItf.CancelUploadDiagnosis(upLoadParamDto);
	}
	public ParamAttributeDTO getCancelUploadDiagnosisInParam(){
		IpChargeItf ipChargeItf = this.insureInstanceFactory.createIpChargeInstance();
		return ipChargeItf.getCancelUploadDiagnosisInParam();
	}
	
	
	/**保存住院前置医保分摊数据
	 * @param hpPayRtnValDto 医保结算信息
	 * @return
	 * @author yangyang
	 */
	public FArrayList saveHpPropData(InpPayRtnValDTO hpPayRtnValDto,HisPropertyRefHpDTO hisPropertyDto) throws BizException{
		IpChargeItf ipChargeItf = this.insureInstanceFactory.createIpChargeInstance();
		return ipChargeItf.saveHpPropTmpData(hpPayRtnValDto,hisPropertyDto);
	}
	/**保存住院前置医保分摊的红冲数据
	 * @return
	 * @throws BizException
	 * @author yangyang
	 */
	public FArrayList savePreFlowBackPropData(HisPropertyRefHpDTO hisPropertyDto) throws BizException{
		IpChargeItf ipChargeItf = this.insureInstanceFactory.createIpChargeInstance();
		return ipChargeItf.saveBackHpPropTmpData(hisPropertyDto);
	}
	/** 获取住院前置医保分摊数据
	 * @param hisPropertyDTO
	 * @return
	 * @throws BizException
	 */
	public FArrayList getHpPropDataIp(HisPropertyRefHpDTO hisPropertyDTO) throws BizException
	{
		IpChargeItf ipChargeItf = this.insureInstanceFactory.createIpChargeInstance();
		return ipChargeItf.getHpPropDataTmp(hisPropertyDTO);
	}
	
	/** 获取门诊医保分摊数据
	 * @param hisPropertyDTO
	 * @return
	 * @throws BizException
	 */
	public FArrayList getHpPropDataOep(HisPropertyRefHpDTO hisPropertyDTO) throws BizException
	{
		OepChargeItf oepChargeItf=this.insureInstanceFactory.createOepChargeInstance();
		return oepChargeItf.getHpPropDataOep(hisPropertyDTO);
	}
	/** 住院保存收付款最终分摊信息
	 * @return 保存得分摊结果
	 * @throws BizException
	 * @date 2018-04-26
	 */
	public FArrayList savePayPropDataIp(InpPayRtnValDTO hpPayRtnValDto,HisPropertyRefHpDTO hisPropertyDTO) throws BizException
	{
		IpChargeItf ipChargeItf = this.insureInstanceFactory.createIpChargeInstance();
		return ipChargeItf.savePayPropData(hpPayRtnValDto, hisPropertyDTO);
	}
	
	/** 住院退费保存医保分摊数据原记录
	 * @param hpPayRtnValDto
	 * @param hisPropertyDTO
	 * @return
	 * @throws BizException
	 */
	public FArrayList saveBackPayPropData(InpPayRtnValDTO hpPayRtnValDto,HisPropertyRefHpDTO hisPropertyDTO) throws BizException
	{
		IpChargeItf ipChargeItf = this.insureInstanceFactory.createIpChargeInstance();
		return ipChargeItf.saveBackPayPropData(hpPayRtnValDto, hisPropertyDTO);
	}
	/** 门诊保存收付款分摊信息
	 * @return 保存得分摊结果 
	 * @throws BizException
	 * @date 2018-04-26
	 */
	public FArrayList savePayPropDataOep(OepSettleRtnValDTO hpPayRtnValDto, HisPropertyRefHpDTO hisPropertyDTO)
			throws BizException {
		OepChargeItf oepChargeItf=this.insureInstanceFactory.createOepChargeInstance();
		return oepChargeItf.savePayPropDataOep(hpPayRtnValDto, hisPropertyDTO);
	}
	
	/** 
	 * 存储医保分摊红冲数据门诊
	 * @param hisPropertyDTO
	 * @return
	 * @throws BizException
	 */
	public FArrayList saveBackPropDataOep(HisPropertyRefHpDTO hisPropertyDTO) throws BizException
	{
		OepChargeItf oepChargeItf=this.insureInstanceFactory.createOepChargeInstance();
		return oepChargeItf.saveBackPropDataOep(hisPropertyDTO);
	}
	
	/** 
	 * 获取医保流程类型，是前置流程还是常规流程
	 * @return
	 */
	public String GetHpFlowType() {
		HpSettingItf hpSettingItf=this.insureInstanceFactory.createHpSettingServiceInstance();
		return hpSettingItf.GetHpFlowType();
	}
	
	/**
	 * 获取住院医保明细上传模式
	 * @return 模式
	 * @author ly 2019/01/17
	 */
	public String GetIpDetailUploadMode() throws BizException{
		HpSettingItf hpSettingItf=this.insureInstanceFactory.createHpSettingServiceInstance();
		return hpSettingItf.GetIpDetailUploadMode();
	} 
	
	/**
	 * @throws BizException 
	 * 更新前置流程分摊关联主键
	 * @Title: updataTmpPropDataOep   
	 * @Description: TODO  
	 * @param: @param hisPropertyDTO
	 * @param: @return      
	 * @return: FArrayList      
	 * @throws
	 */
	public FArrayList updateTmpPropDataOep(HisPropertyRefHpDTO hisPropertyDTO) throws BizException{
		IpChargeItf ipChargeItf = this.insureInstanceFactory.createIpChargeInstance();
		return ipChargeItf.updateTmpPropDataOep(hisPropertyDTO);
	}
	
	/*
	 * 病案首页（西医）上传
	 * 2018-05-23, nielisheng
	 */
	public ResultOutParamDTO<String> uploadMedicalupload(MedicaluploadDTO medicaluoloadDto){
		IpChargeItf ipChargeItf = this.insureInstanceFactory.createIpChargeInstance();
		return ipChargeItf.MedicalUpload(medicaluoloadDto);
	}
	
	/*
	 * 病案首页（中医）上传
	 * 2018-05-23, nielisheng
	 */
	public ResultOutParamDTO<String> uploadMedicaluploadTcm(MedicaluploadTcmDTO medicaluoloadTcmDto){
		IpChargeItf ipChargeItf = this.insureInstanceFactory.createIpChargeInstance();
		return ipChargeItf.MedicalUploadTcm(medicaluoloadTcmDto);
	}
	
	/**
	 * 更新急诊转住院分摊
	 * @param hpPayRtnValDto
	 * @param stProxyHpDo
	 */
	public void updateEtToIpPropData(EtSettleRtnValDTO hpPayRtnValDto,StProxyhpDTO stProxyHpDto)throws BizException{
		IpChargeItf ipChargeItf = this.insureInstanceFactory.createIpChargeInstance();
		ipChargeItf.updateEtToIpPropData(hpPayRtnValDto,stProxyHpDto);
	}

	/**
	 * 红冲急诊转住院分摊
	 * @param stProxyHpDto
	 */
	public void saveBackEtToIpPropData(StProxyhpDTO stProxyHpDto)throws BizException{
		IpChargeItf ipChargeItf = this.insureInstanceFactory.createIpChargeInstance();
		ipChargeItf.saveBackEtToIpPropData(stProxyHpDto);
	}

	/**
	 * 自助机医保后台划价流程
	 * (本流程适用于给自助机提供交易入参模式)
	 * @param inParam 入参
	 * @return 结果
	 * @throws BizException
	 * @author ly 2019/07/02
	 */
	public ResultOutParamDTO<MiOepChargePricingSelfOutParamDTO> oepPricingSelf(MiOepChargePricingSelfInParamDTO inParam) throws BizException{
		OepChargeItf oepChargeItf = this.insureInstanceFactory.createOepChargeInstance();
		return oepChargeItf.oepPricingSelf(inParam);
	}
	
	/**
	 * 自助机医保后台收付款流程
	 * (本流程适用于给自助机提供交易入参模式)
	 * @param inParam 入参
	 * @return 结果
	 * @throws BizException
	 * @author ly 2019/07/02
	 */
	public ResultOutParamDTO<MiOepChargePaySelfOutParamDTO> oepPaySelf(MiOepChargePaySelfInParamDTO inParam) throws BizException{
		OepChargeItf oepChargeItf = this.insureInstanceFactory.createOepChargeInstance();
		return oepChargeItf.oepPaySelf(inParam);
	}
	
	/**
	 * 门诊医保公式计算
	 * @param oepSettleRtnValDto 门诊结算信息
	 * @return 结果
	 * @throws BizException
	 * @author ly 2019/07/10
	 */
	public CommonPropDataDTO hpFormulaCalculateOep(OepSettleRtnValDTO oepSettleRtnValDto) throws BizException{
		OepChargeItf oepChargeItf = this.insureInstanceFactory.createOepChargeInstance();
		return oepChargeItf.hpFormulaCalculateOep(oepSettleRtnValDto);
	}
	
	/**
	 * 获取门诊医保分摊结果
	 * @param dto
	 * @return
	 * @throws BizException
	 * @author ly 2019/12/29
	 */
	public MiPropInfoOutDTO getOepPropData(MiPropInfoInDTO dto) throws BizException{
		OepChargeItf oepChargeItf = this.insureInstanceFactory.createOepChargeInstance();
		return oepChargeItf.getOepPropData(dto);
	}
	
	/**
	 * 获取住院医保分摊结果
	 * @param dto
	 * @return
	 * @throws BizException
	 * @author ly 2019/12/31
	 */
	public MiPropInfoOutDTO getIpPropData(MiPropInfoInDTO dto) throws BizException{
		IpChargeItf ipChargeItf = this.insureInstanceFactory.createIpChargeInstance();
		return ipChargeItf.getIpPropData(dto);
	}
}
