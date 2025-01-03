package iih.en.pv.s.bp.op.ws;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bl.itf.dto.regincinfo.d.RegIncDTO;
import iih.bl.itf.std.inner.en.IBlOpChargeForEnInnerService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.ei.std.d.v1.utils.EiValidator;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.appoint.s.bp.GetStOepInfoBP;
import iih.en.pv.outpatient.dto.d.ResultBean;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.i.IScAptOutCmdService;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.i.IScaptMDORService;

import java.util.List;

import org.springframework.transaction.TransactionStatus;

import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class Refund4AppNewBP {
	private static final String FLAG_SUCCESS = "0";
	private static final String FLAG_ERROR = "1";
	/**
	 * 取消预约并退费
	 * 
	 * @param aptId 预约编码
	 * @param money 金额
	 * @param opTimes 就诊次数
	 * @param settleTimes 结算次数
	 * @param flag 标志
	 * @param oprCode 操作员编码
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public ResultBean exec(String aptId, String money, Integer opTimes, Integer settleTimes, String flag, String oprCode) 
			throws BizException{
		//记录输入参数日志，fanlq-add
		EnLogUtil.getInstance().logInfo("方法：Refund4AppNewBP参数为:aptId:"+aptId+";money:"+money
				+";opTimes:"+opTimes+";settleTimes:"+settleTimes+";flag:"+flag+";oprCode:"+oprCode);
		new SetPsnDocContextBP().exec(oprCode);;
		final ScAptDO apt = this.getScApt(aptId);
		ResultBean result = this.volidate(apt);
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
							//校验是否可以退费-已发发票不允许退费
							isCancEntRefund(aptDTO);
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
		//设置结算信息
		this.setStInfo(result, aptId);
		return result;
	}
	/**
	 * 设置结算信息
	 * 
	 * @param resultDto
	 * @param aptId
	 * @throws BizException
	 */
	private void setStInfo(ResultBean result, String aptId) throws BizException{
		GetStOepInfoBP bp = new GetStOepInfoBP();
		BlStOepDO st = bp.queryCancStByAptId(aptId);
		if(st == null)
			return;
		result.setId_stoep(st.getId_stoep());
		result.setCode_st(st.getCode_st());
		result.setDt_st(st.getDt_st()==null? null : st.getDt_st().toString());
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
			String entId = this.getEntId(apt.getId_apt());
			aptDTO.setId_ent(entId);
		}
	}
	/**
	 * 获取预约记录
	 * 
	 * @param aptId 预约id
	 * @return
	 * @throws BizException 
	 * @throws Exception 
	 */
	private ScAptDO getScApt(String aptId) throws BizException{
		IScaptMDORService serv = ServiceFinder.find(IScaptMDORService.class);
		return serv.findById(aptId);
	}
	/**
	 * 获取就诊Id
	 * 
	 * @param aptId
	 * @return
	 * @throws DAException 
	 */
	@SuppressWarnings("unchecked")
	private String getEntId(String aptId) throws DAException{
		String sql = "select op.id_ent from en_ent_op op where op.id_schapt = ? ";
		SqlParam param  = new SqlParam();
		param.addParam(aptId);
		List<String> list = (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
		if(!EnValidator.isEmpty(list))
			return list.get(0);
		return null;
	}
	/**
	 * 验证预约
	 * 
	 * @param apt
	 * @return
	 * @throws DAException 
	 */
	private ResultBean volidate(ScAptDO apt) throws BizException{
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
		if(isHpPay(apt.getId_apt())){
			result.setMsg("该预约是医保支付，请到窗口退号！");
			return result;
		}
		if(IScDictCodeConst.SD_APTSTATUS_FINISH.equals(apt.getSd_status())){
			result.setMsg(IEnMsgConst.ERROR_APT_NOT_CANC_FINISH);
			return result;
		}
		return null;
	}
	/**
	 * 是否是医保支付
	 * 
	 * @param id_apt
	 * @return
	 * @throws DAException
	 */
	private boolean isHpPay(String id_apt) throws BizException {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT COUNT(1) ");
		sqlBuilder.append(" FROM EN_ENT EN ");
		sqlBuilder.append(" INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		sqlBuilder.append(" INNER JOIN EN_ENT_HP HP ON EN.ID_ENT = HP.ID_ENT ");
		sqlBuilder.append(" WHERE OP.ID_SCHAPT = ? ");
		SqlParam param = new SqlParam();
		param.addParam(id_apt);
		Integer count = (Integer) new DAFacade().execQuery(sqlBuilder.toString(), param, new ColumnHandler());
		return count != null && count > 0;
	}
	/***
	 * @Description:校验是否可以退费
	 * @param aptDTO
	 * @return
	 * @throws BizException 
	 */
	private void isCancEntRefund(OpAptDTO aptDTO) throws BizException{
		if(!EiValidator.isEmpty(aptDTO.getId_ent())){
			IBlOpChargeForEnInnerService service = ServiceFinder.find(IBlOpChargeForEnInnerService.class);
			RegIncDTO incDTO = service.getRegIncInfo(aptDTO.getId_ent());
			if(!EiValidator.isEmpty(incDTO) && !EiValidator.isEmpty(incDTO.getIncno_paper())){
				throw new BizException("此号已经打印纸质发票，请到窗口退号！");
			}
		}
	}
}
