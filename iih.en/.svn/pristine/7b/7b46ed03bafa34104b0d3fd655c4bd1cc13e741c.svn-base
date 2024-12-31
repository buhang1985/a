package iih.en.pv.s.bp.op.ws;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.i.IOutpatientRService;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.i.IScAptOutCmdService;
import iih.sc.apt.scapt.d.ScAptDO;

import java.util.List;

import org.springframework.transaction.TransactionStatus;

import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 取消预约BP
 * @author liubin
 *
 */
public class CancApt4AppBP {
	/**
	 * 取消预约
	 * @param patCode 患者编码
	 * @param deptCode 科室编码
	 * @param doctorCode 医生编码
	 * @param requestDate 预约日期
	 * @param dayslotType 午别类型
	 * @param seqNo 顺序号
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public String exec(String patCode,String deptCode,String doctorCode,String requestDate,String dayslotType,String seqNo) throws BizException{
		final ScAptDO apt = this.getScApt(patCode, deptCode, doctorCode, requestDate, dayslotType, seqNo);
		if(apt == null) {
			return IEnMsgConst.ERROR_APT_NOT_EXIST;
		}
		if(FBoolean.TRUE.equals(apt.getFg_canc())){
			return "取消预约成功";
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
		return "取消预约成功";
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
			IOutpatientRService opRService = ServiceFinder.find(IOutpatientRService.class);
			OutpatientDO[] ops = opRService.findByAttrValString(OutpatientDO.ID_SCHAPT, apt.getId_apt());
			if(!EnValidator.isEmpty(ops)){
				aptDTO.setId_ent(ops[0].getId_ent());
			}else{
				throw new BizException(IEnMsgConst.ERROR_ENT_NOT_EXIST);
			}
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
	private ScAptDO getScApt(String patCode,String deptCode,String doctorCode,String requestDate,String dayslotType,String seqNo) throws BizException{
		StringBuilder sb = new StringBuilder();
		SqlParam param = new SqlParam();
		sb.append("SELECT SC_APT.* ");
		sb.append("FROM SC_APT_EXCHL SC_APT_EXCHL ");
		sb.append("INNER JOIN SC_APT SC_APT ON SC_APT_EXCHL.ID_APT = SC_APT.ID_APT ");
		sb.append("WHERE SC_APT_EXCHL.CODE_PAT = ? ");
		param.addParam(patCode);
		sb.append("AND SC_APT_EXCHL.CODE_DEP = ? ");
		param.addParam(deptCode);
		sb.append("AND SC_APT_EXCHL.D_SC = ? ");
		param.addParam(requestDate);
		sb.append("AND SC_APT_EXCHL.AMPM = ? ");
		param.addParam(dayslotType);
		sb.append("AND SC_APT.QUENO = ? ");
		param.addParam(seqNo);
		if(!EnValidator.isEmpty(doctorCode)){
			sb.append("AND SC_APT_EXCHL.CODE_EMP_PHY = ? ");
			param.addParam(doctorCode);
		}
		String sql = sb.toString();
		Logger.info(sql);
		@SuppressWarnings("unchecked")
		List<ScAptDO> list = (List<ScAptDO>) new DAFacade().execQuery(sql, param, new BeanListHandler(ScAptDO.class));
		if(!EnValidator.isEmpty(list)){
			//TODO：查到多个预约记录如何处理
			return list.get(0);
		}
		return null;
	}
}
