package ruralcooperinsure.s;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.DocumentException;

import iih.mi.device.convert.ruralcooperinsure.RuralCooperDataConverter;
import iih.mi.device.data.ResultInfo;
import iih.mi.device.insurances.ruralcooperinsure.InsureServiceHandler;
import iih.mi.device.serializedata.ruralcooperinsure.BackPayProc;
import iih.mi.device.serializedata.ruralcooperinsure.CancelInpRegisterProc;
import iih.mi.device.serializedata.ruralcooperinsure.ClearInpDetailProc;
import iih.mi.device.serializedata.ruralcooperinsure.InpPayProc;
import iih.mi.device.serializedata.ruralcooperinsure.InpRegisterSeekProc;
import iih.mi.device.serializedata.ruralcooperinsure.PreInpPayProc;
import iih.mi.device.serializedata.ruralcooperinsure.ReferralDownLoadProc;
import iih.mi.device.serializedata.ruralcooperinsure.UpLoadInpDetailProc;
import iih.mi.device.serializedata.ruralcooperinsure.UploadInpRegisterProc;
import iih.valueobject.country.ruralcooperinsure.dto.d.InpDetailUpLoadDTO;
import iih.valueobject.country.ruralcooperinsure.dto.d.InpPayInpDataParamDTO;
import iih.valueobject.country.ruralcooperinsure.dto.d.InpPayReqParamDTO;
import iih.valueobject.country.ruralcooperinsure.dto.d.InpPayResultDTO;
import iih.valueobject.country.ruralcooperinsure.dto.d.InpRegisterInfoDTO;
import iih.valueobject.country.ruralcooperinsure.dto.d.InpRegisterResultDTO;
import iih.valueobject.country.ruralcooperinsure.dto.d.InpRegisterSeekReqDTO;
import iih.valueobject.country.ruralcooperinsure.dto.d.InpUnRegisterRequestDTO;
import iih.valueobject.country.ruralcooperinsure.dto.d.ReferralInformationDTO;
import iih.valueobject.country.ruralcooperinsure.dto.d.ReferralSearchInfoDTO;
import ruralcooperinsure.i.IruralCooperInsureService;
import xap.mw.core.data.BizException;
/**
 * 新农合接口实现
 * @author LIM
 *
 */
public class RuralCooperInsureServiceImpl implements IruralCooperInsureService {
    /**
     * 下载患者转诊单
     * @throws BizException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws DocumentException 
     * @throws UnsupportedEncodingException 
     */
	public ResultInfo<List<ReferralInformationDTO>> DownLoadReferralInfo(ReferralSearchInfoDTO serInfoDto) throws BizException, InstantiationException, IllegalAccessException, UnsupportedEncodingException, DocumentException{
        InsureServiceHandler facade = new InsureServiceHandler();
        ReferralDownLoadProc proc = new ReferralDownLoadProc(serInfoDto);
        facade.businessHandle(proc);      
        ResultInfo<List<ReferralInformationDTO>> resultInfo =RuralCooperDataConverter.mapperResultInfo(proc);
        return resultInfo;
    }
	/**
	 * 住院登记信息上传
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws BizException 
	 * @throws DocumentException 
	 * @throws UnsupportedEncodingException 
	 */
	public ResultInfo<InpRegisterResultDTO> UploadInpRegister(InpRegisterInfoDTO registerInfoDto) throws BizException, InstantiationException, IllegalAccessException, UnsupportedEncodingException, DocumentException {
        InsureServiceHandler facade = new InsureServiceHandler();
        UploadInpRegisterProc proc = new UploadInpRegisterProc(registerInfoDto);
        facade.businessHandle(proc);
        ResultInfo<InpRegisterResultDTO> resultInfo = RuralCooperDataConverter.mapperResultInfo(proc);
        return resultInfo;
	}
	/**
	 * 取消住院登记
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws BizException 
	 * @throws DocumentException 
	 * @throws UnsupportedEncodingException 
	 */
	public ResultInfo<Boolean> CancelInpRegister(InpUnRegisterRequestDTO unRegisterRequestDto) throws BizException, InstantiationException, IllegalAccessException, UnsupportedEncodingException, DocumentException {
		// TODO Auto-generated method stub
        InsureServiceHandler facade = new InsureServiceHandler();
        CancelInpRegisterProc proc = new CancelInpRegisterProc(unRegisterRequestDto);
        facade.businessHandle(proc);
        ResultInfo<Boolean> resultInfo = RuralCooperDataConverter.mapperResultInfo(proc);
        return resultInfo;		
	}
	/**
	 * 住院登记信息查询
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws BizException 
	 * @throws DocumentException 
	 * @throws UnsupportedEncodingException 
	 */
	@Override
	public ResultInfo<InpRegisterInfoDTO> InpRegisterinfoSeek(InpRegisterSeekReqDTO inpRegisterSeekReqDto) throws BizException, InstantiationException, IllegalAccessException, UnsupportedEncodingException, DocumentException {
        InsureServiceHandler facade = new InsureServiceHandler();
        InpRegisterSeekProc proc = new InpRegisterSeekProc(inpRegisterSeekReqDto);
        facade.businessHandle(proc);
        ResultInfo<InpRegisterInfoDTO> resultInfo = RuralCooperDataConverter.mapperResultInfo(proc);
        return resultInfo;		
	}
	/**
	 * 住院处方明细上传
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws BizException 
	 * @throws DocumentException 
	 * @throws UnsupportedEncodingException 
	 * @areaCode 参合地地区编码
	 * @inpDetails住院处方明细
	 */
	@Override
	public ResultInfo<String> UpLoadInpDetails(String areaCode,List<InpDetailUpLoadDTO> inpDetails) throws BizException, InstantiationException, IllegalAccessException, UnsupportedEncodingException, DocumentException {
        InsureServiceHandler facade = new InsureServiceHandler();
        UpLoadInpDetailProc proc = new UpLoadInpDetailProc(areaCode, inpDetails);
        facade.businessHandle(proc);
        ResultInfo<String> resultInfo = RuralCooperDataConverter.mapperResultInfo(proc);
        return resultInfo;		
	}
	/**
	 * 处方明细撤销
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws BizException 
	 * @throws DocumentException 
	 * @throws UnsupportedEncodingException 
	 */
	@Override
	public ResultInfo<String> ClearInpDetails(String areaCode,String strInpRegisterNo, String[] itemCodes) throws BizException, InstantiationException, IllegalAccessException, UnsupportedEncodingException, DocumentException {
        InsureServiceHandler facade = new InsureServiceHandler();
        ClearInpDetailProc proc = new ClearInpDetailProc(areaCode,strInpRegisterNo,itemCodes);
        facade.businessHandle(proc);
        ResultInfo<String> resultInfo = RuralCooperDataConverter.mapperResultInfo(proc);
        return resultInfo;		
	}
	/**
	 * 费用预结算
	 * @param reqParamDto 预结算入参集合
	 * @param inpDataDto 预结算信息
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws BizException 
	 * @throws DocumentException 
	 * @throws UnsupportedEncodingException 
	 */
	@Override
	public ResultInfo<InpPayResultDTO> PreInpPay(InpPayReqParamDTO reqParamDto,InpPayInpDataParamDTO inpDataDto) throws BizException, InstantiationException, IllegalAccessException, UnsupportedEncodingException, DocumentException {
        InsureServiceHandler facade = new InsureServiceHandler();
        PreInpPayProc proc = new PreInpPayProc(reqParamDto,inpDataDto);
        facade.businessHandle(proc);
        ResultInfo<InpPayResultDTO> resultInfo = RuralCooperDataConverter.mapperResultInfo(proc);
        return resultInfo;		
	}
	/**
	 * 住院结算确认
	 * @param reqParamDto 请求信息
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws BizException 
	 * @throws DocumentException 
	 * @throws UnsupportedEncodingException 
	 */
	@Override
	public ResultInfo<InpPayResultDTO> InpPay(InpPayReqParamDTO reqParamDto) throws BizException, InstantiationException, IllegalAccessException, UnsupportedEncodingException, DocumentException {
        InsureServiceHandler facade = new InsureServiceHandler();
        InpPayProc proc=new InpPayProc(reqParamDto);
        facade.businessHandle(proc);
        ResultInfo<InpPayResultDTO> resultinfo = RuralCooperDataConverter.mapperResultInfo(proc);
        return resultinfo;		
	}

	/**
	 * 住院退结算
	 * @param areacode 参合地区编码
	 * @param inpNo 住院结算流水号
	 * @param operatorName 操作人员信息
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws BizException 
	 * @throws DocumentException 
	 * @throws UnsupportedEncodingException 
	 */
	public ResultInfo<String> BackPay(String areacode, String inpNo,String operatorName) throws BizException, InstantiationException, IllegalAccessException, UnsupportedEncodingException, DocumentException {
	    InsureServiceHandler facade = new InsureServiceHandler();
	    BackPayProc proc=new BackPayProc(areacode,inpNo,operatorName);
	    facade.businessHandle(proc);
	    ResultInfo<String> resultInfo = RuralCooperDataConverter.mapperResultInfo(proc);
	    return resultInfo;		
	}

}
