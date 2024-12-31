package iih.en.pv.s.bp.op.ws;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.outpatient.dto.d.ResultBean;
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
 * 
 * @author 
 *
 */
public class Refund4AppBP {
	private static final String FLAG_SUCCESS = "0";
	private static final String FLAG_ERROR = "1";
	
	/**
	 * 退费
	 * @param refundType 退款类型
	 * @param domainId 域ID
	 * @param patCode 患者编码
	 * @param aptCode 预约号
	 * @param tickCode 票号
	 * @param money 金额
	 * @param opTimes 就诊次数
	 * @param settleTimes 结算次数
	 * @param flag 标志
	 * @param oprCode 操作员编码
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public ResultBean exec(String refundType,String domainId,String patCode,String aptCode,String tickCode,String money,Integer opTimes,Integer settleTimes,String flag,String oprCode) throws BizException{
		ResultBean result = this.volidate(patCode, aptCode);
		if(result != null)
			return result;
		final ScAptDO apt = this.getScApt(patCode, aptCode);
		result = this.volidate(apt);
		if(result != null)
			return result;
		result = new ResultBean();
		result.setFlag(FLAG_SUCCESS);
		
		try {
			TransactionExecutor.executeNewTransaction(new TransactionalOperation() {
				@Override
				public Object doInTransaction(TransactionStatus paramTransactionStatus) {
					try {
							OpAptDTO aptDTO = new OpAptDTO();
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
			result.setFlag(FLAG_ERROR);
			result.setMsg(ex.getMessage());
		}
		
		return result;
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
	 * @param aptCode 预约编码
	 * @return
	 * @throws BizException 
	 * @throws Exception 
	 */
	private ScAptDO getScApt(String patCode,String aptCode) throws BizException{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT SC_APT.* ");
		sb.append("FROM SC_APT_EXCHL SC_APT_EXCHL ");
		sb.append("INNER JOIN SC_APT SC_APT ON SC_APT_EXCHL.ID_APT = SC_APT.ID_APT ");
		sb.append("WHERE SC_APT_EXCHL.CODE_PAT = ? ");
		sb.append("AND SC_APT_EXCHL.CODE_APT = ? ");
		sb.append("AND SC_APT.FG_CANC = ? ");
		String sql = sb.toString();
		Logger.info(sql);
		SqlParam param = new SqlParam();
		param.addParam(patCode);
		param.addParam(aptCode);
		param.addParam(FBoolean.FALSE);
		@SuppressWarnings("unchecked")
		List<ScAptDO> list = (List<ScAptDO>) new DAFacade().execQuery(sql, param, new BeanListHandler(ScAptDO.class));
		if(!EnValidator.isEmpty(list)){
			//TODO：查到多个预约记录如何处理
			return list.get(0);
		}
		return null;
	}
	/**
	 * 数据验证
	 * 
	 * @param patCode
	 * @param aptCode
	 * @return
	 */
	private ResultBean volidate(String patCode, String aptCode){
		ResultBean result = new ResultBean();
		result.setFlag(FLAG_ERROR);
		if(EnValidator.isEmpty(patCode)) {
			result.setMsg("患者编码不能为空");
			return result;
		}
		if(EnValidator.isEmpty(aptCode)){
			result.setMsg("预约编码不能为空");
			return result;
		}
		return null;
	}
	/**
	 * 验证预约
	 * 
	 * @param apt
	 * @return
	 */
	private ResultBean volidate(ScAptDO apt){
		ResultBean result = new ResultBean();
		result.setFlag(FLAG_ERROR);
		if(apt == null) {
			result.setMsg(IEnMsgConst.ERROR_APT_NOT_EXIST);
			return result;
		}
		if(FBoolean.TRUE.equals(apt.getFg_canc())){
			result.setMsg(IEnMsgConst.ERROR_APT_NOT_CANC_CANCED);
			return result;
		}
		if(FBoolean.FALSE.equals(apt.getFg_payment())){
			result.setMsg("该预约未付费，不允许退费！");
			return result;
		}
		if(IScDictCodeConst.SD_APTSTATUS_FINISH.equals(apt.getSd_status())){
			result.setMsg(IEnMsgConst.ERROR_APT_NOT_CANC_FINISH);
			return result;
		}
		return null;
	}
}

