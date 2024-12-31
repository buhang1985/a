package ruralcooperinsure.i;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.DocumentException;

import xap.mw.core.data.BizException;
import iih.mi.device.data.ResultInfo;
import iih.valueobject.country.ruralcooperinsure.dto.d.*;

/**
 * 新农合国家平台接口集合
 * 
 * @author LIM
 *
 */
public interface IruralCooperInsureService {
	/**
	 * 下载患者转诊单
	 * 
	 * @param serInfoDto
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws DocumentException 
	 * @throws UnsupportedEncodingException 
	 */
	public ResultInfo<List<ReferralInformationDTO>> DownLoadReferralInfo(ReferralSearchInfoDTO serInfoDto) throws BizException, InstantiationException, IllegalAccessException, UnsupportedEncodingException, DocumentException;

	/**
	 * 住院登记信息上传
	 * 
	 * @param registerInfoDto
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws BizException 
	 * @throws DocumentException 
	 * @throws UnsupportedEncodingException 
	 */
	public ResultInfo<InpRegisterResultDTO> UploadInpRegister(InpRegisterInfoDTO registerInfoDto) throws BizException, InstantiationException, IllegalAccessException, UnsupportedEncodingException, DocumentException;

	/**
	 * 取消住院登记
	 * 
	 * @param unRegisterRequestDto
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws BizException 
	 * @throws DocumentException 
	 * @throws UnsupportedEncodingException 
	 */
	public ResultInfo<Boolean> CancelInpRegister(InpUnRegisterRequestDTO unRegisterRequestDto) throws BizException, InstantiationException, IllegalAccessException, UnsupportedEncodingException, DocumentException;

	/**
	 * 住院登记信息查询
	 * 
	 * @param inpRegisterSeekReqDto
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws BizException 
	 * @throws DocumentException 
	 * @throws UnsupportedEncodingException 
	 */
	public ResultInfo<InpRegisterInfoDTO> InpRegisterinfoSeek(InpRegisterSeekReqDTO inpRegisterSeekReqDto) throws BizException, InstantiationException, IllegalAccessException, UnsupportedEncodingException, DocumentException;

	/**
	 * 处方明细上传
	 * 
	 * @param inpRegisterSeekReqDto
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws BizException 
	 * @throws DocumentException 
	 * @throws UnsupportedEncodingException 
	 */
	public ResultInfo<String> UpLoadInpDetails(String areaCode,List<InpDetailUpLoadDTO> inpDetails) throws BizException, InstantiationException, IllegalAccessException, UnsupportedEncodingException, DocumentException;

	/**
	 * 处方明细撤销
	 * 
	 * @param areaCode
	 * @param strInpRegisterNo
	 * @param itemCodes
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws BizException 
	 * @throws DocumentException 
	 * @throws UnsupportedEncodingException 
	 */
	public ResultInfo<String> ClearInpDetails(String areaCode,String strInpRegisterNo, String[] itemCodes) throws BizException, InstantiationException, IllegalAccessException, UnsupportedEncodingException, DocumentException;

	/**
	 * 住院预结算
	 * 
	 * @param reqParamDto
	 * @param inpDataDto
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws BizException 
	 * @throws DocumentException 
	 * @throws UnsupportedEncodingException 
	 */
	public ResultInfo<InpPayResultDTO> PreInpPay(InpPayReqParamDTO reqParamDto,InpPayInpDataParamDTO inpDataDto) throws BizException, InstantiationException, IllegalAccessException, UnsupportedEncodingException, DocumentException;

	/**
	 * 住院结算确认
	 * 
	 * @param reqParamDto
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws BizException 
	 * @throws DocumentException 
	 * @throws UnsupportedEncodingException 
	 */
	public ResultInfo<InpPayResultDTO> InpPay(InpPayReqParamDTO reqParamDto) throws BizException, InstantiationException, IllegalAccessException, UnsupportedEncodingException, DocumentException;

	/**
	 * 退结算
	 * 
	 * @param areacode
	 *            区域编码
	 * @param inpNo
	 *            住院结算流水号
	 * @param operatorName
	 *            操作人员信息
	 * @return
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws BizException 
	 * @throws DocumentException 
	 * @throws UnsupportedEncodingException 
	 */
	public ResultInfo<String> BackPay(String areacode, String inpNo,String operatorName) throws BizException, InstantiationException, IllegalAccessException, UnsupportedEncodingException, DocumentException;
}
