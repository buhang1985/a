package test.qysh.demo;

import java.sql.ResultSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xap.dp.report.data.reader.sql.RptRsHanlderUtils;
import xap.dp.report.data.reader.sql.SqlExecutor;

/**
 * JavaBean查询服务，用于生成带图片字段的数据集
 * 
 * @author qi_yongsheng
 */
public class ImgSignatureServiceImpl {
	private static Logger logger = LoggerFactory.getLogger(ImgSignatureServiceImpl.class);
	
	@SuppressWarnings("unchecked")
	public ImgSignatureDTO[] exec() {
		// 构造带变参的sql语句
		String str_sql = "select ID_MYSCVI, PIC from sys_myscvi where rownum<=5";
		
		// 创建sql执行器 (SqlExecutor可以支持变参)
		SqlExecutor sql_exec = new SqlExecutor();
		// 设置sql语句
		sql_exec.setSql(str_sql);
		
		ResultSet rset = null;
		List<ImgSignatureDTO> beanlist = null;
		try {
			// 执行sql查询
			rset = sql_exec.exeQuery();
			
			// 将查询结果集转换成JavaBean对象列表
			beanlist = (List<ImgSignatureDTO>) RptRsHanlderUtils.toBeanList(rset, ImgSignatureDTO.class);
		}
		catch(Exception ex) {
			logger.error("", ex);
		}
		finally {
			sql_exec.destroy();
			SqlExecutor.closeResultSet(rset);
		}
		
		// 将JavaBean列表转换成数组
		ImgSignatureDTO[] res_arr_dto = null;
		if(null == beanlist || beanlist.isEmpty()) {
			res_arr_dto = new ImgSignatureDTO[0];
		}
		else {
			res_arr_dto = beanlist.toArray(new ImgSignatureDTO[0]);
			beanlist.clear();
		}
		
		return res_arr_dto;
	}
}
