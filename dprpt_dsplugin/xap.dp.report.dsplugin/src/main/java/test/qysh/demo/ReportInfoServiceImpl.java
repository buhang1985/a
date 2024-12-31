package test.qysh.demo;

import java.sql.ResultSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xap.dp.report.data.reader.sql.RptRsHanlderUtils;
import xap.dp.report.data.reader.sql.SqlExecutor;
import xap.dp.report.util.StringUtil;

import com.software.vtreport.data.reader.sql.RptSqlParam;

/**
 * JavaBean查询服务，用于生成数据列表
 * 
 * @author qi_yongsheng
 */
public class ReportInfoServiceImpl {
	private static Logger logger = LoggerFactory.getLogger(ReportInfoServiceImpl.class);
	
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
		
		// 构造带变参的sql语句
		String str_sql = "select name, reportPath, sv from sys_reportfree_hospital where reportPath like ?";
		
		// 创建sql执行器 (SqlExecutor可以支持变参)
		SqlExecutor sql_exec = new SqlExecutor();
		// 设置sql语句
		sql_exec.setSql(str_sql);
		
		// 添加sql参数方法1 (使用addParamSorted方法需要按变参出现的顺序添加)
		RptSqlParam param = new RptSqlParam(rptPathPrefix+'%', String.class);
		sql_exec.addParamSorted(param);
		
		// 添加sql参数方法2 (使用addParam方法需要构造参数对象时指定变参序号，起始值为1)
//		RptSqlParam param = new RptSqlParam(1, rptPathPrefix+'%', String.class);
//		sql_exec.addParam(param);
		
		ResultSet rset = null;
		List<ReportInfoDTO> beanlist = null;
		try {
			// 执行sql查询
			rset = sql_exec.exeQuery();
			
			// 将查询结果集转换成JavaBean对象列表
			beanlist = (List<ReportInfoDTO>)RptRsHanlderUtils.toBeanList(rset, ReportInfoDTO.class);
		}
		catch(Exception ex) {
			logger.error("", ex);
		}
		finally {
			sql_exec.destroy();
			SqlExecutor.closeResultSet(rset);
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
