package test.qysh.demo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.rowset.CachedRowSetImpl;

import xap.dp.report.data.reader.sql.RptRsHanlderUtils;
import xap.dp.report.data.reader.sql.SqlReader;
import xap.dp.report.util.StringUtil;

/**
 * JavaBean查询服务，用于生成数据列表 (使用SqlReader执行sql语句)
 * 
 * @author qi_yongsheng
 */
public class ReportInfoServiceImpl2 {
	private static Logger logger = LoggerFactory.getLogger(ReportInfoServiceImpl2.class);
	
	/**
	 * 使用指定的报表路径前缀，查询报表信息列表
	 * @param rptPathPrefix
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public ReportInfoDTO[] exec(String rptPathPrefix) {
		if(StringUtil.isNullOrEmpty(rptPathPrefix)) {
			rptPathPrefix = "[]";
		}
		
		// 构造直接拼接的sql语句 (不带变参)
		StringBuilder str_buf = new StringBuilder(128);
		str_buf.append("select name, reportPath, sv from sys_reportfree_hospital");
		str_buf.append(" where reportPath like '").append(rptPathPrefix).append('%').append("'");
		String str_sql = str_buf.toString();
		str_buf.setLength(0); str_buf.trimToSize();
		
		// 创建sql执行器 (SqlReader不支持变参)
		SqlReader sql_rdr = new SqlReader(null, str_sql);
		
		CachedRowSetImpl rs_cache = null;
		List<ReportInfoDTO> beanlist = null;
		try {
			// 执行sql查询
			sql_rdr.exeQuery(null, true);
			rs_cache = sql_rdr.getCacheRowSet();
			
			// 将查询结果集转换成JavaBean对象列表
			beanlist = (List<ReportInfoDTO>)RptRsHanlderUtils.toBeanList(rs_cache, ReportInfoDTO.class);
		}
		catch(Exception ex) {
			logger.error("", ex);
		}
		finally {
			sql_rdr.destroy();
			SqlReader.closeResultSet(rs_cache);
		}
		
		// 将JavaBean列表转换成数组
		ReportInfoDTO[] res_arr_dto = null;
		if(null == beanlist || beanlist.isEmpty()) {
			res_arr_dto = new ReportInfoDTO[0];
		}
		else {
			res_arr_dto = beanlist.toArray(new ReportInfoDTO[0]);
			beanlist.clear();
		}
		
		return res_arr_dto;
	}
}
