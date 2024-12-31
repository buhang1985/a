package iih.ei.bl.ecinc.bosssoft.v2.s.bp;

import com.alibaba.fastjson.JSON;

import iih.bl.st.blstoep.d.BlStOepDO;
import iih.ei.bl.ecinc.bosssoft.constant.IEcIncBossSoftConst;
import iih.ei.bl.ecinc.bosssoft.v2.s.bp.help.IpEcIncDataBP;
import iih.ei.bl.ecinc.bosssoft.v2.s.bp.help.OpEcIncDataBP;
import iih.ei.bl.ecinc.bosssoft.v2.s.bp.help.PeEcIncDataBP;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.ReturnParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.invoice.EcInvoiceIpParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.invoice.EcInvoiceOpParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.invoice.EcInvoiceOutParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.invoice.EcInvoicePeParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.http.BossSoftHttpClient;
import iih.ei.bl.ecinc.d.EcIncBlFlowInvoiceInDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowInvoiceOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.d.EcIncTypeEnum;
import iih.ei.bl.util.EIThirdLogger;
import xap.mw.core.base64.Base64;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 博思电子票据开具
 * @author ly 2019/12/04
 *
 */
public class BossSoftEcIncBlFlowInvoiceBP {

	/**
	 * 电子票据开具
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public EcIncResultDTO<EcIncBlFlowInvoiceOutDTO> exec(EcIncBlFlowInvoiceInDTO dto) throws BizException {
		
		String data = null;
		String method = null;
		String methodName = null;
		
		if(EcIncTypeEnum.INCIP.equals(dto.getInctype())){
			EcInvoiceIpParam ipParam = new IpEcIncDataBP().exec(dto);
			data = JSON.toJSONString(ipParam);
			method = IEcIncBossSoftConst.METHOD_INVEBILLHOSPITALIZED;
			methodName = IEcIncBossSoftConst.METHOD_INVEBILLHOSPITALIZED_NAME;
		}else{
			
			OpEcIncDataBP bp = new OpEcIncDataBP();
			EcInvoiceOpParam opParam  = bp.exec(dto);
			BlStOepDO stDO = bp.getStDO();
			if(stDO != null && !StringUtil.isEmpty(stDO.getPecode())){
				EcInvoicePeParam peParam = new PeEcIncDataBP().exec2(opParam, stDO);
				data = JSON.toJSONString(peParam);
				method = IEcIncBossSoftConst.METHOD_INVEBILLCHECKUP;
				methodName = IEcIncBossSoftConst.METHOD_INVEBILLCHECKUP_NAME;
			}else{
				data = JSON.toJSONString(opParam);
				method = IEcIncBossSoftConst.METHOD_INVOICEEBILLOUTPATIENT;
				methodName = IEcIncBossSoftConst.METHOD_INVOICEEBILLOUTPATIENT_NAME;
			}
		}
		
		ReturnParam rtnParam = null;
		try {
			
			BossSoftHttpClient httpClient = new BossSoftHttpClient(method,methodName);
			rtnParam = httpClient.invoke(data);
		} catch (Exception e) {
			e.printStackTrace();
			EIThirdLogger.error(String.format("%s失败:", methodName) + e.getMessage(), e);
			EcIncResultDTO<EcIncBlFlowInvoiceOutDTO> rlt = new EcIncResultDTO<EcIncBlFlowInvoiceOutDTO>();
			rlt.setFg_success(FBoolean.FALSE);
			rlt.setErrormsg(e.getMessage());
			rlt.setOutparam(e.getMessage());
			return rlt;
		}
		
		EcIncResultDTO<EcIncBlFlowInvoiceOutDTO> rlt = new EcIncResultDTO<EcIncBlFlowInvoiceOutDTO>();
		rlt.setFg_success(new FBoolean(rtnParam.getFgSuccess()));
		
		if(FBoolean.TRUE.equals(rlt.getFg_success())){
			EcInvoiceOutParam outData =  JSON.parseObject(rtnParam.getData(), EcInvoiceOutParam.class);;
			EcIncBlFlowInvoiceOutDTO outDto = new EcIncBlFlowInvoiceOutDTO();
			outDto.setEcinc_code(outData.getBillBatchCode());
			outDto.setEcincno(outData.getBillNo());
			outDto.setEcinc_checkno(outData.getRandom());
			outDto.setEcinc_url(outData.getPictureUrl());
			outDto.setEcinc_neturl(outData.getPictureNetUrl());
			try {
				outDto.setDt_inc(new FDateTime(outData.getCreateTime()));
			} catch (Exception e) {
			}
			try {
				if(!StringUtil.isEmpty(outData.getBillQRCode())){
					outDto.setEc_qrcode_pic(Base64.decode(outData.getBillQRCode().getBytes("UTF-8")));
				}
			} catch (Exception e) {
			}
			rlt.setData(outDto);
		}else{
			rlt.setErrormsg(rtnParam.getErrorMsg());
		}
		rlt.setInparam(rtnParam.getInputStr());
		rlt.setOutparam(rtnParam.getOutputStr());
		return rlt;
	}
}
