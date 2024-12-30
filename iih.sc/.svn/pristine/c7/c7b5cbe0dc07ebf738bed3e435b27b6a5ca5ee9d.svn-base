package iih.sc.scbd.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.sc.scbd.log.d.ScLogRecDO;
import iih.sc.scbd.log.d.desc.ScLogRecDODesc;
import iih.sc.scbd.log.i.ISclogrecRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据父记录id获取日志
 * @author ccj
 *
 */
public class GetLogListByParentIdBP {
	/**
	 * 根据父记录id获取日志
	 * @param tableName 表名
	 * @param parentId 父记录id
	 * @param beginDate 开始日期
	 * @param endDate 结束日期
	 * @return
	 * @throws BizException
	 */
	public ScLogRecDO[] exec(String tableName,String parentId,FDate beginDate,FDate endDate) throws BizException{
		if(StringUtils.isBlank(tableName) || StringUtils.isBlank(parentId) || beginDate == null || endDate ==null) return null;
		ISclogrecRService sclogrecRService = ServiceFinder.find(ISclogrecRService.class);
		String tableAliasName = ScLogRecDODesc.TABLE_ALIAS_NAME;
		StringBuilder sb = new StringBuilder();
		sb.append(tableAliasName);
		sb.append(".name_table = '");
		sb.append(tableName);
		sb.append("' and ");
		sb.append(tableAliasName);
		sb.append(".id_parent_data = '");
		sb.append(parentId);
		sb.append("' and SUBSTR(");
		sb.append(tableAliasName);
		sb.append(".dt_log,0,10) >= '");
		sb.append(beginDate);
		sb.append("' and SUBSTR(");
		sb.append(tableAliasName);
		sb.append(".dt_log,0,10) <= '");
		sb.append(endDate);
		sb.append("'");
		ScLogRecDO[] scLogRecDOs = sclogrecRService.find(sb.toString(), "dt_log desc", FBoolean.TRUE);
		return scLogRecDOs;
	}
}
