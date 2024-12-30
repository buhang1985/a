package iih.sc.scbd.s.bp;

import iih.sc.scbd.log.d.ScLogRecDO;
import iih.sc.scbd.log.d.desc.ScLogRecDODesc;
import iih.sc.scbd.log.i.ISclogrecRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据记录id获取日志
 * @author caichenji
 *
 */
public class GetLogListBP {
	/**
	 * 根据记录id获取日志
	 * @param tableName 表名
	 * @param dataId 数据记录id
	 * @param beginDate 开始日期
	 * @param endDate 结束日期
	 * @return
	 * @throws BizException
	 */
	public ScLogRecDO[] exec(String tableName,String dataId,FDate beginDate,FDate endDate) throws BizException{
		ISclogrecRService sclogrecRService = ServiceFinder.find(ISclogrecRService.class);
		String tableAliasName = ScLogRecDODesc.TABLE_ALIAS_NAME;
		String whereStr = "";
		if(dataId == null){
			whereStr = tableAliasName+".name_table = '"+tableName+"' and SUBSTR("+tableAliasName+".dt_log,0,10) >= '"+beginDate+"' and SUBSTR("+tableAliasName+".dt_log,0,10) <= '"+endDate+"'";
		}else{
			whereStr = tableAliasName+".name_table = '"+tableName+"' and "+tableAliasName+".id_data = '"+dataId+"' and SUBSTR("+tableAliasName+".dt_log,0,10) >= '"+beginDate+"' and SUBSTR("+tableAliasName+".dt_log,0,10) <= '"+endDate+"'";
		}
		ScLogRecDO[] scLogRecDOs = sclogrecRService.find(whereStr, "dt_log desc", FBoolean.FALSE);
		return scLogRecDOs;
	}
}
