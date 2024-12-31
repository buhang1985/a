package iih.en.pv.s.task.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.enstate.d.EuPeriodTp;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 定时处理就诊状况
 * @author ren_ying
 */
public class DelExpiredStatus {
	/**
	 * 就诊状况参数
	 */
	private static final String  Key_IgnoreStateTpIds = "IgnoreStateTpIds";
	
	/**
	 * 定时处理就诊状况
	 * @author ren_ying
	 * 
	 * 2018-12-07 liubin 迭代整体逻辑，变为sql删除
	 * 
	 * @param keyMap
	 * @throws BizException
	 */
	public void exec(Map<String, Object> keyMap) throws BizException{
		//1.获取不需要处理的就诊状况类型
		String[] ignoreStateTpIds = getIgnoreStateTpIds(keyMap);
		//2.删除过期定时任务
		delExpireStates(ignoreStateTpIds);
	}
	/**
	 * 删除过期定时任务
	 * 
	 * @param ignoreStateTpIds
	 * @throws BizException
	 */
	private void delExpireStates(String[] ignoreStateTpIds) throws BizException{
		
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" DELETE FROM EN_ENT_STATE ENSTATE ");
		sqlBuilder.append(" WHERE ENSTATE.SD_ENSTATETP NOT IN (?,?,?) ");
		if(!EnValidator.isEmpty(ignoreStateTpIds)){
			sqlBuilder.append(" AND " ).append(EnSqlUtils.getNotInSqlByIds("ENSTATE.ID_ENSTATETP", ignoreStateTpIds));
		}
		sqlBuilder.append(" AND EXISTS ");
		sqlBuilder.append(" ( ");
		sqlBuilder.append(" SELECT BDSTATE.ID_ENSTATE FROM BD_EN_STATE BDSTATE ");
		sqlBuilder.append(" INNER JOIN BD_MEASDOC MEASDOC ON BDSTATE.ID_MEASDOC_PERIOD = MEASDOC.ID_MEASDOC ");
		sqlBuilder.append(" WHERE ENSTATE.ID_ENSTATETP = BDSTATE.ID_ENSTATETP ");
		sqlBuilder.append(" AND ENSTATE.VAL = BDSTATE.VAL ");
		sqlBuilder.append(" AND MEASDOC.CODE IN (?,?,?,?) ");
		sqlBuilder.append(" AND NVL(BDSTATE.PERIOD,'0') > 0 ");
		sqlBuilder.append(" AND ((BDSTATE.EU_PERIODTP = ? AND ENSTATE.DT_INVALID <= ?) ");
		sqlBuilder.append(" OR (BDSTATE.EU_PERIODTP = ? AND ENSTATE.DT_OCC <= TO_CHAR(TO_DATE(?, 'yyyy-mm-dd hh24:mi:ss')-BDSTATE.PERIOD * (DECODE(MEASDOC.CODE,?,1,?,1/24,?,1/24/60,?,1/24/60/60)),'yyyy-mm-dd hh24:mi:ss'))) ");
		sqlBuilder.append(" )");
		String sql = sqlBuilder.toString();
		SqlParam param = new SqlParam();
		param.addParam(IBdFcDictCodeConst.SD_ENSTSTATETP_FOOD);
		param.addParam(IBdFcDictCodeConst.SD_ENSTSTATETP_DISE);
		param.addParam(IBdFcDictCodeConst.SD_ENSTSTATETP_NUR);
		param.addParam(IBdFcDictCodeConst.CODE_TIME_DAY);
		param.addParam(IBdFcDictCodeConst.CODE_TIME_HOUR);
		param.addParam(IBdFcDictCodeConst.CODE_TIME_MIN);
		param.addParam(IBdFcDictCodeConst.CODE_TIME_SEC);
		param.addParam(EuPeriodTp.USEINVALIDTIME);
		param.addParam(EnAppUtils.getServerDateTime());
		param.addParam(EuPeriodTp.USEBEGINTIME);
		param.addParam(EnAppUtils.getServerDateTime());
		param.addParam(IBdFcDictCodeConst.CODE_TIME_DAY);
		param.addParam(IBdFcDictCodeConst.CODE_TIME_HOUR);
		param.addParam(IBdFcDictCodeConst.CODE_TIME_MIN);
		param.addParam(IBdFcDictCodeConst.CODE_TIME_SEC);
		new DAFacade().execUpdate(sql, param);
	}
	
	/**
	 * 获取不需要处理的就诊状况类型
	 * 
	 * @param keyMap
	 * @return
	 */
	private String[] getIgnoreStateTpIds(Map<String, Object> keyMap){
		if(keyMap == null || !keyMap.containsKey(Key_IgnoreStateTpIds))
			return null;
		String ignoreStateTpIds = (String) keyMap.get(Key_IgnoreStateTpIds);
		if(EnValidator.isEmpty(ignoreStateTpIds))
			return null;
		return ignoreStateTpIds.split(",");
	}
}
