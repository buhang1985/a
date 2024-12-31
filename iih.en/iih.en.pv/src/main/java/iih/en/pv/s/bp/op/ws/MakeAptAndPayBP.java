package iih.en.pv.s.bp.op.ws;

import iih.bl.st.blstoep.d.BlStOepDO;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.appoint.bean.MakeAptAndPayParam;
import iih.en.pv.appoint.result.AppointResultManage;
import iih.en.pv.appoint.result.InvoiceBean;
import iih.en.pv.appoint.s.bp.GetStOepInfoBP;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.dto.d.PayForAptDTO;
import iih.en.pv.s.bp.ip.ws.GetInvoiceInfoBP;
import iih.sc.apt.dto.d.MakeAptDTO;
import iih.sc.apt.dto.d.RegResultDTO;
import iih.sc.apt.i.IScAptOutCmdService;

import java.util.List;

import org.springframework.transaction.TransactionStatus;

import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
/***
 * 预约且付费
 * @author fanlq
 *
 */
public class MakeAptAndPayBP {

	public RegResultDTO exec(final MakeAptAndPayParam bean) throws BizException{
		RegResultDTO regRst = new RegResultDTO();
		regRst = TransactionExecutor.executeNewTransaction(new TransactionalOperation<RegResultDTO>() {
			@Override
			public RegResultDTO doInTransaction(TransactionStatus arg0) {
				try {
					return process(bean);
				} catch (BizException e) {
					throw new BizRuntimeException(e.getMessage());
				}
			}
		});
		return regRst;
	}
	
	public RegResultDTO process(MakeAptAndPayParam bean) throws BizException{
		RegResultDTO regResultDTO = new RegResultDTO();
		//1.预约
		MakeAptDTO makeAptDTO =AppointResultManage.getMakeAptAndPay(bean);
		if(!EnValidator.isEmpty(makeAptDTO.getOprCode())){
	    	new SetPsnDocContextBP().exec(makeAptDTO.getOprCode());;
		}
		// 1. 验证必输项
		String errorMsg = this.validParam(makeAptDTO.getPatCode(), makeAptDTO.getAptCode(), makeAptDTO.getChlType(), makeAptDTO.getAgentCode(),makeAptDTO.getSchId());
		if (!EnValidator.isEmpty(errorMsg)) {
			regResultDTO.setRegMsg(errorMsg);
			return regResultDTO;
		}
		IScAptOutCmdService serv = ServiceFinder.find(IScAptOutCmdService.class);
		regResultDTO = serv.aptForWechatNew( makeAptDTO);;
		if(regResultDTO == null || EnValidator.isEmpty(regResultDTO.getId_apt())){
			regResultDTO.setRegMsg("未找到预约id，请重新操作！");
			return regResultDTO;
		}
		//2.付费
		PayForAptDTO payForAptDTO =AppointResultManage.getMakeAptPayDTO(bean);
		payForAptDTO.setAptId(regResultDTO.getId_apt());
		IScAptOutCmdService service = ServiceFinder.find(IScAptOutCmdService.class);
		String msg = service.payForAptNew2( payForAptDTO.getAptId(),payForAptDTO.getPatCode(), payForAptDTO.getChlType(),payForAptDTO.getOrderNo(), payForAptDTO.getPayType(), payForAptDTO.getAccNo(), payForAptDTO.getPatCardNo(),
				payForAptDTO.getParCardPwd(), payForAptDTO.getMoney(), payForAptDTO.getOprCode(),
				payForAptDTO.getPatHpTp(),payForAptDTO.getHpPriceData(), payForAptDTO.getPatHpNO(),payForAptDTO.getHpPatInfXml(),payForAptDTO.getInsurPriceDivideXml(),payForAptDTO.getDt_st(),payForAptDTO.getBusiness_code(),payForAptDTO.getFg_printInvoice());
		if(!EnValidator.isEmpty(msg)){
			regResultDTO.setRegMsg(msg);
		}
		//设置发票信息
		if(FBoolean.TRUE.equals(FBoolean.valueOf(payForAptDTO.getFg_printInvoice()))){
			InvoiceBean invoice = new GetInvoiceInfoBP().exec(payForAptDTO.getAptId());
			FArrayList incoicList = new FArrayList();
			incoicList.add(invoice);
			regResultDTO.setIncoicList(incoicList);
		}
		//设置结算信息
		this.setStInfo(regResultDTO, payForAptDTO.getAptId());
		//设置就诊次数
		this.setTimesOp(regResultDTO, payForAptDTO.getAptId());
		return regResultDTO;
	}
	/**
	 * 设置结算信息
	 * 
	 * @param resultDto
	 * @param aptId
	 * @throws BizException
	 */
	private void setStInfo(RegResultDTO resultDto, String aptId) throws BizException{
		GetStOepInfoBP bp = new GetStOepInfoBP();
		BlStOepDO st = bp.queryByAptId(aptId);
		if(st == null)
			return;
		resultDto.setId_stoep(st.getId_stoep());
		resultDto.setCode_st(st.getCode_st());
		resultDto.setDt_st(st.getDt_st()==null? null : st.getDt_st().toString());
	}

	/**
	 * 设置结算信息
	 * 
	 * @param resultDto
	 * @param aptId
	 * @throws BizException
	 */
	private void setTimesOp(RegResultDTO resultDto, String aptId)
			throws BizException {
		@SuppressWarnings("unchecked")
		List<OutpatientDO> list = (List<OutpatientDO>) new DAFacade()
				.findByAttrValString(OutpatientDO.class,
						OutpatientDO.ID_SCHAPT, aptId, new String[] {
								OutpatientDO.ID_ENT, OutpatientDO.ID_SCHAPT,
								OutpatientDO.TIMES_OP });
		if (EnValidator.isEmpty(list))
			return;
		resultDto.setTimes(String.valueOf(list.get(0).getTimes_op()));
	}
	/**
	 * 验证数据
	 * 
	 * @param patCode 患者编码
	 * @param aptCode 预约号
	 * @param chlType 渠道类型,取值如：手机APP:15,微信:16,桌建APP:17,支付窗:18,官网:19
	 * @param agentCode 代办人编码
	 * @param schId 排班ID
	 * @return
	 */
	private String validParam(String patCode, String aptCode, String chlType, String agentCode, String schId){
		String errorMsg = null;
		if(EnValidator.isEmpty(patCode)){
			errorMsg = "患者编码不能为空！";
			return errorMsg;
		}
		if(EnValidator.isEmpty(aptCode)){
			errorMsg = "预约码不能为空！";
			return errorMsg;
		}
		if(EnValidator.isEmpty(chlType)){
			errorMsg = "渠道编码不能为空！";
			return errorMsg;
		}
		if(EnValidator.isEmpty(schId)){
			errorMsg = "预约排班不能为空！";
			return errorMsg;
		}
		return errorMsg;
	}
}
