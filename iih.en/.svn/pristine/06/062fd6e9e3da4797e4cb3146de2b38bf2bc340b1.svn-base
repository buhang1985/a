package iih.en.pv.s.task.bp;

import iih.en.comm.IEnConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enmsg.d.EnMsgDO;
import iih.en.pv.enmsg.i.IEnmsgCudService;

import org.springframework.transaction.TransactionStatus;

import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/***
 * 检查定时发送短信任务是否已发送过短信
 * @author fanlq
 *
 */
public class CheckIsSendedMsgBP {

	/***
	 * 查询患者此次就诊是否已发短信
	 * @author fanlq 
	 * @param entId
	 * @param msgCode
	 * @throws BizException 
	 */
	public FBoolean getSendMsgData(String entId,String msgCode) throws BizException{
		if(EnValidator.isEmpty(entId) || EnValidator.isEmpty(msgCode)){
			return FBoolean.FALSE;
		}
		StringBuilder sqlBuilder = new StringBuilder();
		SqlParam param = new SqlParam();
		sqlBuilder.append("select fg_suc from en_msg where Mainid = ? and code = ? ");
		param.addParam(entId);
		param.addParam(msgCode);
		String fg_suc_str = (String)new DAFacade().execQuery(sqlBuilder.toString(), param, new ColumnHandler());
		if(EnValidator.isEmpty(fg_suc_str)){
			return FBoolean.FALSE;
		}else
			return new FBoolean(fg_suc_str);
	}
		
	/***
	 * 保存已发送短信的数据到数据库中
	 * @author fanlq
	 * @throws BizException 
	 */
	public void saveSendedMsgData(final String id_ent,final String msgCode,final String result) throws BizException{
		if(EnValidator.isEmpty(id_ent) || EnValidator.isEmpty(result)){
			return;
		}
		// 单独事务
		TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
			@Override
			public String doInTransaction(TransactionStatus status) {
				try {
					EnMsgDO msgDO = new EnMsgDO();
					msgDO.setMainid(id_ent);
					msgDO.setCode(msgCode);
					if(IEnConst.SENDEDMSG_SUC_CONST.equals(result))
						msgDO.setFg_suc(FBoolean.TRUE);
					else msgDO.setFg_suc(FBoolean.FALSE);
					msgDO.setStatus(DOStatus.NEW);
					IEnmsgCudService service = ServiceFinder.find(IEnmsgCudService.class);
					service.save(new EnMsgDO[]{msgDO});
				} catch (Exception e) {
					throw new BizRuntimeException(e.getMessage());
				}
				return null;
			}
		});		
	}
}
