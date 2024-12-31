package iih.en.pv.s.bp.op.ws;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.util.EnLogUtil;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.i.IScAptOutCmdService;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.i.IScaptMDORService;

import org.springframework.transaction.TransactionStatus;

import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 取消预约BP
 * @author liubin
 *
 */
public class CancApt4AppNewBP {
	/**
	 * 取消预约
	 * 
	 * @param aptId 预约ID
	 * @param oprCode 操作员编码
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public String exec(String aptId, String oprCode) throws BizException{
		//记录输入参数日志，fanlq-add
		EnLogUtil.getInstance().logInfo("方法：CancApt4AppNewBP参数为:aptId:"+aptId+";oprCode:"+oprCode);
		new SetPsnDocContextBP().exec(oprCode);	
		final ScAptDO apt = this.getScApt(aptId);
		if(apt == null) {
			return IEnMsgConst.ERROR_APT_NOT_EXIST;
		}
		if(FBoolean.TRUE.equals(apt.getFg_canc())){
			return null;
		}
		if(IScDictCodeConst.SD_APTSTATUS_PAY.equals(apt.getSd_status())){
			return IEnMsgConst.ERROR_APT_NOT_CANC_PAY;
		}
		if(IScDictCodeConst.SD_APTSTATUS_FINISH.equals(apt.getSd_status())){
			return IEnMsgConst.ERROR_APT_NOT_CANC_FINISH;
		}
		
		try {
			TransactionExecutor.executeNewTransaction(new TransactionalOperation() {
				@Override
				public Object doInTransaction(TransactionStatus paramTransactionStatus) {
					try {
							final OpAptDTO aptDTO = new OpAptDTO();
							wrapOpApt(aptDTO, apt);
							IScAptOutCmdService serv = ServiceFinder.find(IScAptOutCmdService.class);
							serv.cancOpApt(aptDTO);
						} catch (BizException e) {
							throw new BizRuntimeException(e.getMessage(), e);
						}
						return null;
					}
				});
		} catch (BizRuntimeException ex) {
			ex.printStackTrace();
			return ex.getMessage();
		}
		return null;
	}
	/**
	 * 组装OpAptDTO
	 * 
	 * @param aptDTO
	 * @param apt
	 * @throws BizException 
	 */
	private void wrapOpApt(OpAptDTO aptDTO, ScAptDO apt) throws BizException{
		aptDTO.setId_apt(apt.getId_apt());
		if(FBoolean.TRUE.equals(apt.getFg_payment())){
			throw new BizException(IEnMsgConst.ERROR_APT_NOT_CANC_PAY);
		}
	}
	/**
	 * 获取预约记录
	 * 
	 * @param patCode 患者编码
	 * @param deptCode 科室编码
	 * @param doctorCode 医生编码
	 * @param requestDate 预约日期
	 * @param dayslotType 午别类型
	 * @param scsrvCode 服务编码
	 * @param seqNo 顺序号
	 * @return
	 * @throws BizException 
	 * @throws Exception 
	 */
	private ScAptDO getScApt(String aptId) throws BizException{
		IScaptMDORService serv = ServiceFinder.find(IScaptMDORService.class);
		return serv.findById(aptId);
	}
}
