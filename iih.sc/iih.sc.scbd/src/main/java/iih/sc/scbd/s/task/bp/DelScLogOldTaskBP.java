package iih.sc.scbd.s.task.bp;

import iih.sc.comm.ScAppUtils;
import java.util.Map;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 定时删除EN-SC日志记录
 * 
 * @author liubin
 *
 */
public class DelScLogOldTaskBP {
	
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
		sqlBuilder.append(" DELETE FROM SC_LOG_REC REC ");
		sqlBuilder.append(" WHERE EXISTS (SELECT SETTING.ID_LOGSETTING ");
		sqlBuilder.append(" FROM SC_LOG_SETTING SETTING ");
		sqlBuilder.append(" WHERE REC.ID_ORG = SETTING.ID_ORG ");
		sqlBuilder.append(" AND REC.ID_ORG = ? ");
		sqlBuilder.append(" AND REC.NAME_TABLE = SETTING.NAME_TABLE ");
		sqlBuilder.append(" AND NVL(SETTING.NUM_DAYS_RESV,'0') > 0 ");
		sqlBuilder.append(" AND REC.DT_LOG < TO_CHAR(TO_DATE(?, 'yyyy-mm-dd hh24:mi:ss')-SETTING.NUM_DAYS_RESV,'yyyy-mm-dd hh24:mi:ss')) ");
		String sql = sqlBuilder.toString();
		SqlParam param = new SqlParam();
		param.addParam(orgId);
		param.addParam(ScAppUtils.getServerDateTime()); 
		new DAFacade().execUpdate(sql, param);                        
	}
}
