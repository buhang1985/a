package iih.mi.itf.bizgrpitf;

import java.util.List;

import iih.mi.biz.dto.d.CancelInpRegisterParamDTO;
import iih.mi.biz.dto.d.InpRegisterParamDTO;
import iih.mi.biz.dto.d.InpRegisterRtnValDTO;
import iih.mi.biz.dto.d.OutHosRegInParamDTO;
import iih.mi.biz.dto.d.ParamAttributeDTO;
import iih.mi.biz.dto.d.ReferralInfoRtnValDTO;
import iih.mi.biz.dto.d.ReferralSearchInParamDTO;
import iih.mi.itf.bizgrpitf.param.ResultOutParamDTO;

public interface IpRegisterItf {
	
    // 转诊单下载
    public ResultOutParamDTO<List<ReferralInfoRtnValDTO>> DownLoadReferralInfo(ReferralSearchInParamDTO searchParam);
    public ParamAttributeDTO getDownLoadReferralInfoInParam();
	
    // 住院登记上传
    public ResultOutParamDTO<InpRegisterRtnValDTO> UploadRegister(InpRegisterParamDTO inpRegister);
    public ParamAttributeDTO getUploadRegisterInParam();
    
    // 住院登记撤销
    public ResultOutParamDTO<String> CancelRegister(CancelInpRegisterParamDTO cancelInpRegisterParamDto);
    public ParamAttributeDTO GetCancelRegisterInParamKeys();
    
    //出院登记
    public ResultOutParamDTO<String> OutHosReg(OutHosRegInParamDTO outHosRegDto);
    //获取出院登记参数
    public ParamAttributeDTO getOutHosRegInParamKeys();
}