package iih.mi.inst.bizbase;

import java.util.List;

import iih.mi.bd.d.HpDTO;
import iih.mi.biz.dto.d.CancelInpRegisterParamDTO;
import iih.mi.biz.dto.d.InpRegisterParamDTO;
import iih.mi.biz.dto.d.InpRegisterRtnValDTO;
import iih.mi.biz.dto.d.OutHosRegInParamDTO;
import iih.mi.biz.dto.d.ParamAttributeDTO;
import iih.mi.biz.dto.d.ReferralInfoRtnValDTO;
import iih.mi.biz.dto.d.ReferralSearchInParamDTO;
import iih.mi.itf.bizgrpitf.param.ResultOutParamDTO;
import xap.mw.core.data.BizRuntimeException;

public class IpRegisterBaseImpl extends InsureBaseImpl{
	
	public ResultOutParamDTO<InpRegisterRtnValDTO> UploadRegister(InpRegisterParamDTO inpRegister){
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品不支持[住院登记上传]接口方法!");
	}
	public ParamAttributeDTO getUploadRegisterInParam(){
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品不支持[住院登记上传]接口方法!");
	}
	
	public ResultOutParamDTO<List<ReferralInfoRtnValDTO>> DownLoadReferralInfo(ReferralSearchInParamDTO searchParam) {
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品不支持[转诊单下载]接口方法!");
	}
	public ParamAttributeDTO getDownLoadReferralInfoInParam(){
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品不支持[转诊单下载]接口方法!");
	}
	
	public ResultOutParamDTO<String> CancelRegister(CancelInpRegisterParamDTO cancelInpRegisterParamDto) {
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品不支持[住院登记撤销]接口方法!");
	}
	public ParamAttributeDTO GetCancelRegisterInParamKeys(){
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品不支持[住院登记撤销]接口方法!");
	}
	
	//出院登记
	public ResultOutParamDTO<String> OutHosReg(OutHosRegInParamDTO outHosRegDto){
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品不支持[出院登记]接口方法!");
	}
	public ParamAttributeDTO getOutHosRegInParamKeys(){
		HpDTO hpDTO= getHpDTO();
		throw new BizRuntimeException("["+hpDTO.getCode()+"]医保产品不支持[出院登记]接口方法!");
	}
}
