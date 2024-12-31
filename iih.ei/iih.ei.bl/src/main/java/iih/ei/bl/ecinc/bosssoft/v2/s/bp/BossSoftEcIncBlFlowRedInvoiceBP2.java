package iih.ei.bl.ecinc.bosssoft.v2.s.bp;

import iih.bl.inc.dto.eincwriteoff.d.BlEIncWriteOffMsgResult;
import iih.bl.inc.dto.eincwriteoff.d.BlEIncWriteOffParam;
import iih.bl.inc.dto.eincwriteoff.d.BlEIncWriteOffResult;
import iih.ei.bl.ecinc.bosssoft.constant.IEcIncBossSoftConst;
import iih.ei.bl.ecinc.bosssoft.eincout.EIncWriteOffInvoke;
import iih.ei.bl.ecinc.d.EcIncBlFlowRedInvoiceInDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowRedInvoiceOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.util.EcIncDataUtil;
import iih.ei.bl.util.EIThirdLogger;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.bdfw.bbd.d.PsnDocDO;

/**
 * 博思电子发票红冲
 * @author ly 2019/12/04
 * 
 */
public class BossSoftEcIncBlFlowRedInvoiceBP2 {
	
	/**
	 * 电子发票红冲
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO> exec(EcIncBlFlowRedInvoiceInDTO dto) throws BizException {
		
		EIncWriteOffInvoke invoke = new EIncWriteOffInvoke();
		
		BlEIncWriteOffParam param = new BlEIncWriteOffParam();
		param.setBillBatchCode(dto.getEcinc_code());
		param.setBillNo(dto.getEcincno());
		param.setReason(dto.getReason());
		PsnDocDO psnDO = EcIncDataUtil.getPsnData(Context.get().getStuffId());
		param.setOperator(psnDO.getName());
		param.setBusDateTime(EcIncDataUtil.convertDateTime(new FDateTime()) + "000");
		param.setPlaceCode(psnDO.getCode());
		
		BlEIncWriteOffResult result = null;
		try {
			result = invoke.exec(param);
		} catch (Exception e) {
			e.printStackTrace();
			EIThirdLogger.error("电子票据红冲失败:" + e.getMessage(), e);
			EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO> rlt = new EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO>();
			rlt.setFg_success(FBoolean.FALSE);
			rlt.setErrormsg(e.getMessage());
			rlt.setOutparam(e.getMessage());
			return rlt;
		}
		
		EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO> rlt = new EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO>();
		rlt.setFg_success(new FBoolean(IEcIncBossSoftConst.SUCCESS_CODE.equals(result.getResult())));
		
		if(FBoolean.TRUE.equals(rlt.getFg_success())){
			BlEIncWriteOffMsgResult msgResult = result.getMessage();
			EcIncBlFlowRedInvoiceOutDTO outDto = new EcIncBlFlowRedInvoiceOutDTO();
			outDto.setEcinc_code(msgResult.geteScarletBillBatchCode());
			outDto.setEcincno(msgResult.geteScarletBillNo());
			outDto.setEcinc_checkno(msgResult.geteScarletRandom());
			outDto.setEcinc_url(msgResult.getPictureUrl());
			outDto.setEcinc_neturl(msgResult.getPictureNetUrl());
			try {
				outDto.setDt_inc(new FDateTime(msgResult.getCreateTime()));
			} catch (Exception e) {
			}
			rlt.setData(outDto);
		}else{
			rlt.setErrormsg(result.getErrorMsg());
		}
			
		rlt.setInparam(result.getInputStr());
		rlt.setOutparam(result.getOutputStr());
		return rlt;
	}
}
