package iih.en.pv.s.bp.op.ws;

import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.sc.apt.dto.d.MakeAptDTO;
import iih.sc.apt.dto.d.RegResultDTO;
import iih.sc.apt.i.IScAptOutCmdService;

import org.springframework.transaction.TransactionStatus;

import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;

public class MakeAptNewBp {
	/**
	 * 预约
	 * 
	 * @param patCode 患者编码
	 * @param aptCode 预约号
	 * @param chlType 渠道类型,取值如：手机APP:15,微信:16,桌建APP:17,支付窗:18,官网:19
	 * @param agentCode 代办人编码
	 * @param schId 排班ID
	 * @return
	 * @throws BizException
	 */
	public RegResultDTO exec(final MakeAptDTO makeAptDTO)throws BizException {
		//记录输入参数日志，fanlq-add
		EnLogUtil.getInstance().logInfo("方法：MakeAptNewBp参数为:patCode:"+makeAptDTO.getPatCode()+";aptCode:"+makeAptDTO.getAptCode()
				+";chlType:"+makeAptDTO.getChlType()+";agentCode:"+makeAptDTO.getAgentCode()+";schId:"+makeAptDTO.getSchId());
		
		if(!EnValidator.isEmpty(makeAptDTO.getOprCode())){
		    	new SetPsnDocContextBP().exec(makeAptDTO.getOprCode());;
		 }
		RegResultDTO regRst = new RegResultDTO();
		// 1. 验证必输项
		String errorMsg = this.validParam(makeAptDTO.getPatCode(), makeAptDTO.getAptCode(), makeAptDTO.getChlType(), makeAptDTO.getAgentCode(),makeAptDTO.getSchId());
		if (!EnValidator.isEmpty(errorMsg)) {
			regRst.setRegMsg(errorMsg);
			return regRst;
		}
		try {
			
			regRst = TransactionExecutor.executeNewTransaction(new TransactionalOperation<RegResultDTO>() {
						@Override
						public RegResultDTO doInTransaction(TransactionStatus arg0) {
							try {
								IScAptOutCmdService serv = ServiceFinder.find(IScAptOutCmdService.class);
								return serv.aptForWechatNew( makeAptDTO);
							} catch (BizException e) {
								throw new BizRuntimeException(e.getMessage());
							}
						}
					});
		} catch (BizRuntimeException ex) {
			ex.printStackTrace();
			regRst.setRegMsg(ex.getMessage());
		}
		return regRst;
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
