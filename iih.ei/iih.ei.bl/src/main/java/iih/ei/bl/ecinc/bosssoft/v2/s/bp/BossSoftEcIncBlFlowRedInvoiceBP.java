package iih.ei.bl.ecinc.bosssoft.v2.s.bp;

import iih.bl.inc.blecinccomp.d.BlEcIncCompDO;
import iih.bl.inc.blincippaper.d.BlIncIpPaperDO;
import iih.bl.inc.blincoeppaper.d.BlIncOepPaperDO;
import iih.ei.bl.ecinc.bosssoft.constant.IEcIncBossSoftConst;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.ReturnParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.invoice.EcInvoiceRedOutParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.invoice.EcInvoiceRedParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.data.paper.EcPaperCancelParam;
import iih.ei.bl.ecinc.bosssoft.v2.s.http.BossSoftHttpClient;
import iih.ei.bl.ecinc.d.EcIncBlFlowRedInvoiceInDTO;
import iih.ei.bl.ecinc.d.EcIncBlFlowRedInvoiceOutDTO;
import iih.ei.bl.ecinc.d.EcIncResultDTO;
import iih.ei.bl.ecinc.d.EcIncTypeEnum;
import iih.ei.bl.ecinc.util.EcIncCompUtil;
import iih.ei.bl.ecinc.util.EcIncDataUtil;
import iih.ei.bl.ecinc.util.FlowContextUtil;
import iih.ei.bl.util.EIThirdLogger;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.jdbc.facade.DAFacade;

import com.alibaba.fastjson.JSON;

/**
 * 博思电子发票红冲
 * @author ly 2019/12/04
 * 
 */
public class BossSoftEcIncBlFlowRedInvoiceBP {
	
	/**
	 * 电子发票红冲
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO> exec(EcIncBlFlowRedInvoiceInDTO dto) throws BizException {
		
//		//判断是否有纸质票据
//		BlIncOepPaperDO paperDO = this.getOepPaperIncDO(dto.getId_inc_old());
//		
//		if(paperDO == null){
//			return this.redEcinc(dto);
//		}else{
//			return this.redPaper(paperDO, dto);
//		}
		
		if(EcIncTypeEnum.INCIP.equals(dto.getInctype())){
			//住院
			BlIncIpPaperDO paperDO = this.getIpPaperIncDO(dto.getId_inc_old());
			if(paperDO == null){
				return this.redEcinc(dto);
			}else{
				return this.redPaper(paperDO.getInc_code(),paperDO.getIncno(), dto);
			}
		}else{
			//门诊
			BlIncOepPaperDO paperDO = this.getOepPaperIncDO(dto.getId_inc_old());
			if(paperDO == null){
				return this.redEcinc(dto);
			}else{
				return this.redPaper(paperDO.getInc_code(),paperDO.getIncno(), dto);
			}
		}
	}
	
	/**
	 * 红冲电子票
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	private EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO> redEcinc(EcIncBlFlowRedInvoiceInDTO dto) throws BizException {
		
		EcInvoiceRedParam inParam = new EcInvoiceRedParam();
		
		inParam.setBillBatchCode(dto.getEcinc_code());
		inParam.setBillNo(dto.getEcincno());
		inParam.setReason(dto.getReason());
		
		//查询红冲结算数据
		//查询结算数据
//		BlStIpDO stDO = EcIncDataUtil.getIpStData(dto.getId_st_red());
		
		PsnDocDO psnDO = EcIncDataUtil.getPsnData(FlowContextUtil.getEmpId());
		inParam.setOperator(psnDO.getName());
		inParam.setBusDateTime(EcIncDataUtil.getBusiTime());
		
		Map<String, BlEcIncCompDO> psnCompMap = EcIncCompUtil.getCompData("07");
		BlEcIncCompDO psnCompDO = psnCompMap.get(psnDO.getCode());
		if(psnCompDO != null){
			inParam.setPlaceCode(psnCompDO.getEcinc_code());//开票点编码
		}else{
			inParam.setPlaceCode(psnDO.getCode());//开票点编码
		}
		
		ReturnParam rtnParam = null;
		try {
			BossSoftHttpClient httpClient = new BossSoftHttpClient(IEcIncBossSoftConst.METHOD_WRITEOFFEBILL,
					IEcIncBossSoftConst.METHOD_WRITEOFFEBILL_NAME);
			String data = JSON.toJSONString(inParam);
			rtnParam = httpClient.invoke(data);
		} catch (Exception e) {
			e.printStackTrace();
			EIThirdLogger.error(String.format("%s失败", IEcIncBossSoftConst.METHOD_WRITEOFFEBILL_NAME) + e.getMessage(), e);
			EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO> rlt = new EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO>();
			rlt.setFg_success(FBoolean.FALSE);
			rlt.setErrormsg(e.getMessage());
			rlt.setOutparam(e.getMessage());
			return rlt;
		}
		
		EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO> rlt = new EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO>();
		rlt.setFg_success(new FBoolean(rtnParam.getFgSuccess()));
		
		if(FBoolean.TRUE.equals(rlt.getFg_success())){
			EcInvoiceRedOutParam outData =  JSON.parseObject(rtnParam.getData(), EcInvoiceRedOutParam.class);;
			
			EcIncBlFlowRedInvoiceOutDTO outDto = new EcIncBlFlowRedInvoiceOutDTO();
			outDto.setEcinc_code(outData.geteScarletBillBatchCode());
			outDto.setEcincno(outData.geteScarletBillNo());
			outDto.setEcinc_checkno(outData.geteScarletRandom());
			outDto.setEcinc_url(outData.getPictureUrl());
			outDto.setEcinc_neturl(outData.getPictureNetUrl());
			try {
				outDto.setDt_inc(new FDateTime(outData.getCreateTime()));
			} catch (Exception e) {
			}
			try {
				if(!StringUtil.isEmpty(outData.getBillQRCode())){
					//outDto.setEc_qrcode_pic(Base64.decode(outData.getBillQRCode().getBytes("UTF-8")));
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
	
	/**
	 * 红冲纸质票
	 * @param paperDO
	 * @return
	 * @throws BizException
	 */
	private EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO> redPaper(String inc_code,String incNo, EcIncBlFlowRedInvoiceInDTO dto) throws BizException {
		
		EcPaperCancelParam inParam = new EcPaperCancelParam();
		inParam.setBillBatchCode(dto.getEcinc_code());
		inParam.setBillNo(dto.getEcincno());
		inParam.setpBillBatchCode(inc_code);
		inParam.setpBillNo(incNo);
		PsnDocDO psnDO = EcIncDataUtil.getPsnData(Context.get().getStuffId());
		inParam.setPlaceCode(psnDO.getCode());
		inParam.setAuthor(psnDO.getName());
		inParam.setReason(dto.getReason());
		inParam.setBusDateTime(EcIncDataUtil.getBusiTime());
		
		ReturnParam rtnParam = null;
		try {
			BossSoftHttpClient httpClient = new BossSoftHttpClient(IEcIncBossSoftConst.METHOD_INVALIDPAPER,
					IEcIncBossSoftConst.METHOD_INVALIDPAPER_NAME);
			String data = JSON.toJSONString(inParam);
			rtnParam = httpClient.invoke(data);
		} catch (Exception e) {
			e.printStackTrace();
			EIThirdLogger.error(String.format("%s失败", IEcIncBossSoftConst.METHOD_INVALIDPAPER_NAME) + e.getMessage(), e);
			EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO> rlt = new EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO>();
			rlt.setFg_success(FBoolean.FALSE);
			rlt.setErrormsg(e.getMessage());
			rlt.setOutparam(e.getMessage());
			return rlt;
		}
		
		EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO> rlt = new EcIncResultDTO<EcIncBlFlowRedInvoiceOutDTO>();
		rlt.setFg_success(new FBoolean(rtnParam.getFgSuccess()));
		
		if(FBoolean.TRUE.equals(rlt.getFg_success())){
			EcInvoiceRedOutParam outData =  JSON.parseObject(rtnParam.getData(), EcInvoiceRedOutParam.class);;
			
			EcIncBlFlowRedInvoiceOutDTO outDto = new EcIncBlFlowRedInvoiceOutDTO();
			outDto.setEcinc_code(outData.geteScarletBillBatchCode());
			outDto.setEcincno(outData.geteScarletBillNo());
			outDto.setEcinc_checkno(outData.geteScarletRandom());
			outDto.setEcinc_url(outData.getPictureUrl());
			outDto.setEcinc_neturl(outData.getPictureNetUrl());
			try {
				outDto.setDt_inc(new FDateTime(outData.getCreateTime()));
			} catch (Exception e) {
			}
			try {
				if(!StringUtil.isEmpty(outData.getBillQRCode())){
					//outDto.setEc_qrcode_pic(Base64.decode(outData.getBillQRCode().getBytes("UTF-8")));
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
	
	/**
	 * 获取门诊有效纸质票据
	 * @param incId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private BlIncOepPaperDO getOepPaperIncDO(String incId) throws BizException{
		
		DAFacade daf = new DAFacade();
		List<BlIncOepPaperDO> paperList = (List<BlIncOepPaperDO>)daf.findByAttrValString(BlIncOepPaperDO.class, BlIncOepPaperDO.ID_INCOEP, incId, null);

		if(ListUtil.isEmpty(paperList))
			return null;
		
		for (BlIncOepPaperDO blIncOepPaperDO : paperList) {
			if(FBoolean.FALSE.equals(blIncOepPaperDO.getFg_canc()))
				return blIncOepPaperDO;
		}
		
		return null;
	}
	
	/**
	 * 获取住院有效纸质票据
	 * @param incId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private BlIncIpPaperDO getIpPaperIncDO(String incId) throws BizException{
		
		DAFacade daf = new DAFacade();
		List<BlIncIpPaperDO> paperList = (List<BlIncIpPaperDO>)daf.findByAttrValString(BlIncIpPaperDO.class, BlIncIpPaperDO.ID_INCIP, incId, null);

		if(ListUtil.isEmpty(paperList))
			return null;
		
		for (BlIncIpPaperDO blIncIpPaperDO : paperList) {
			if(FBoolean.FALSE.equals(blIncIpPaperDO.getFg_canc()))
				return blIncIpPaperDO;
		}
		
		return null;
	}
}
