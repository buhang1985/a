package iih.sc.scbd.s.task.bp;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.springframework.transaction.TransactionStatus;

import iih.sc.comm.ScAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 定时删除EN-SC日志记录
 * 
 * @author liubin
 *
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class DelScLogTaskBP {
	
	private static final String key_org_id = "OrgId";

	/**
	 * 定时删除EN-SC日志记录
	 * 
	 * @throws BizException
	 */
	
	public void exec(Map<String, Object> keyMap) throws BizException{
		if(keyMap == null || !keyMap.containsKey(key_org_id) || keyMap.get(key_org_id) == null)
			throw new BizException("定时任务参数OrgId未配置！");
		String orgId = (String)keyMap.get(key_org_id);
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT COUNT(*) FROM SC_LOG_REC REC ");
		sqlBuilder.append(" WHERE EXISTS (SELECT SETTING.ID_LOGSETTING "); 
		sqlBuilder.append(" FROM SC_LOG_SETTING SETTING ");
		sqlBuilder.append(" WHERE REC.ID_ORG = SETTING.ID_ORG ");
		sqlBuilder.append(" AND REC.ID_ORG = ? ");
		sqlBuilder.append(" AND REC.NAME_TABLE = SETTING.NAME_TABLE ");
		sqlBuilder.append(" AND NVL(SETTING.NUM_DAYS_RESV,'0') > 0 ");
		sqlBuilder.append(" AND REC.DT_LOG < TO_CHAR(TO_DATE(?, 'yyyy-mm-dd hh24:mi:ss')-SETTING.NUM_DAYS_RESV,'yyyy-mm-dd hh24:mi:ss')) ");
		String sql_qry = sqlBuilder.toString();
		
		final SqlParam param = new SqlParam();
		param.addParam(orgId);
		param.addParam(ScAppUtils.getServerDateTime()); 
		Integer count = 0;
		
		count = (Integer) new DAFacade().execQuery(sql_qry, param,
				new ScalarHandler<Integer>());
		
		
		count = count % 200 > 0 ? count / 200 + 1 : count / 200;
			
		sqlBuilder.replace(0, 16, "DELETE");
		sqlBuilder.append(" AND ROWNUM < 201 ");
		final String sql_del = sqlBuilder.toString();

		
		while (count > 0) {
			try {
				TransactionExecutor.executeNewTransaction(new TransactionalOperation() {
					
					@Override
					public Object doInTransaction(TransactionStatus paramTransactionStatus)
							throws InvocationTargetException {
						try {
							new DAFacade().execUpdate(sql_del, param);
							Thread.sleep(5000);
						} catch (Exception e) {
							e.printStackTrace();
						} 
						return null;
						
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
				throw new BizException(e.getMessage());
			}
			
			count --;
			
		}
	}
}
