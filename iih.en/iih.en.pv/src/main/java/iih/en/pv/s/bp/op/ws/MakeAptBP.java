package iih.en.pv.s.bp.op.ws;

import iih.en.comm.validator.EnValidator;
import iih.pi.reg.i.IPiRegQryService;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.sc.apt.dto.d.RegResultDTO;
import iih.sc.apt.i.IScAptOutCmdService;

import org.springframework.transaction.TransactionStatus;

import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * APP预约BP
 * @author liubin
 *
 */
public class MakeAptBP {
	/**
	 * 预约
	 * @param patCode 患者编码
	 * @param deptCode 科室编码
	 * @param requestDate 预约日期
	 * @param dayslotType 午别类型（a或p）
	 * @param scsrvCode 服务编码
	 * @param doctorCode 医生编码
	 * @param seqNo 顺序号
	 * @param aptCode 预约号
	 * @param chlType 渠道类型
	 * @param agentCode 代办人编码
	 * @return
	 * @throws BizException 
	 */
	@SuppressWarnings("deprecation")
	public RegResultDTO exec(final String patCode,final String deptCode,final String requestDate,final String dayslotType,final String scsrvCode,final String doctorCode,final Integer seqNo,final String aptCode,final String chlType,final String agentCode) throws BizException{
		RegResultDTO regRst = new RegResultDTO();
		//1. 验证必输项
		String errorMsg = this.validParam(patCode, deptCode, requestDate, dayslotType, scsrvCode, doctorCode, seqNo, aptCode, chlType, agentCode);
		if(!EnValidator.isEmpty(errorMsg)){
			regRst.setRegMsg(errorMsg);
			return regRst;
		}
		try{
			regRst = TransactionExecutor.executeNewTransaction(new TransactionalOperation<RegResultDTO>(){
				@Override
				public RegResultDTO doInTransaction(TransactionStatus arg0) {
					try {
						return makeApt(patCode, deptCode, requestDate, dayslotType, scsrvCode, doctorCode, seqNo, aptCode, chlType, agentCode);
					} catch (BizException e) {
						throw new BizRuntimeException(e.getMessage());
					}
				}
			});
		}catch(BizRuntimeException ex){
			ex.printStackTrace();
			regRst.setRegMsg(ex.getMessage());
		}
		return regRst;
	}
	
	
	
	/**
	 * 预约
	 * @param patCode 患者编码
	 * @param deptCode 科室编码
	 * @param requestDate 预约日期
	 * @param dayslotType 午别类型（a或p）
	 * @param scsrvCode 服务编码
	 * @param doctorCode 医生编码
	 * @param seqNo 顺序号
	 * @param aptCode 预约号
	 * @param chlType 渠道类型
	 * @param agentCode 代办人编码
	 * @return
	 * @throws BizException 
	 */
	private RegResultDTO makeApt(String patCode,String deptCode,String requestDate,String dayslotType,String scsrvCode,String doctorCode,Integer seqNo,String aptCode,String chlType,String agentCode) throws BizException{
		//调用empi同步患者信息
//		IPiRegMaintainService piRegMainTainService = ServiceFinder.find(IPiRegMaintainService.class);
//		PatiAggDO patiAggDo = piRegMainTainService.getPatInfoByCodeFromEmpi(patCode);
		IPiRegQryService serv = ServiceFinder.find(IPiRegQryService.class);
		PatiAggDO patiAggDo = serv.getPatInfoForAp(patCode);
		if(null == patiAggDo)
			throw new BizException("未找到当前患者信息！");
		//3. 预约挂号
		IScAptOutCmdService scAptOutCmdService = ServiceFinder.find(IScAptOutCmdService.class);
		return scAptOutCmdService.aptForWechat(scsrvCode, doctorCode, requestDate, deptCode, dayslotType, chlType, seqNo, aptCode, patCode, agentCode);
	}
	
	/**
	 * 验证必输项参数
	 * @param patCode
	 * @param deptCode
	 * @param requestDate
	 * @param dayslotType
	 * @param scsrvCode
	 * @param doctorCode
	 * @param seqNo
	 * @param aptCode
	 * @param chlType
	 * @param agentCode
	 * @return
	 */
	private String validParam(String patCode,String deptCode,String requestDate,String dayslotType,String scsrvCode,String doctorCode,Integer seqNo,String aptCode,String chlType,String agentCode){
		String errorMsg = null;
		if(EnValidator.isEmpty(patCode)){
			errorMsg = "患者编码不能为空！";
//			Logger.error(errorMsg);
			return errorMsg;
		}
		if(EnValidator.isEmpty(deptCode)){
			errorMsg = "科室编码不能为空！";
//			Logger.error(errorMsg);
			return errorMsg;
		}
		if(EnValidator.isEmpty(requestDate)){
			errorMsg = "日期不能为空！";
//			Logger.error(errorMsg);
			return errorMsg;
		}
		if(EnValidator.isEmpty(dayslotType)){
			errorMsg = "午别类型不能为空！";
//			Logger.error(errorMsg);
			return errorMsg;
		}
		if(EnValidator.isEmpty(scsrvCode)){
			errorMsg = "服务编码编码不能为空！";
//			Logger.error(errorMsg);
			return errorMsg;
		}
		if(seqNo == null){
			errorMsg = "顺序号不能为空！";
//			Logger.error(errorMsg);
			return errorMsg;
		}
		if(EnValidator.isEmpty(aptCode)){
			errorMsg = "预约码不能为空！";
//			Logger.error(errorMsg);
			return errorMsg;
		}
		if(EnValidator.isEmpty(chlType)){
			errorMsg = "渠道编码不能为空！";
//			Logger.error(errorMsg);
			return errorMsg;
		}
//		if(EnValidator.isEmpty(agentCode)){
//			errorMsg = "渠道编码不能为空！";
//			Logger.error(errorMsg);
//			return errorMsg;
//		}
		return errorMsg;
	}

}
