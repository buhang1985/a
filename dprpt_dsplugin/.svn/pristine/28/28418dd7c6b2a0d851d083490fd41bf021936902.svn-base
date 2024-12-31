package iih.mp.nr.common;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.software.vtreport.data.reader.sql.RptSqlParam;

import iih.mp.nr.common.dto.UdidocDTO;
import iih.mp.nr.common.qry.GetUdidocsQry;
import iih.nm.nom.dto.NomQualityMonthDTO;
import xap.dp.report.data.reader.sql.RptRsHanlderUtils;
import xap.dp.report.data.reader.sql.SqlExecutor;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @Description:获取档案信息工具类
 * @author:zhongcl@founder.com.cn
 * @version:2019年1月9日 下午2:03:32 创建
 */
public class UdidocSearchUtils {
	
	/**
	 * 根据档案模板code获取档案设置
	 * @param code
	 * @return
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	public static List<UdidocDTO> findByUdidoclistCode(String code) throws BizException{
		
		GetUdidocsQry qry=new GetUdidocsQry(code);
		SqlExecutor sql_exe=new SqlExecutor();
		sql_exe.setSql(qry.getQrySQLStr());
		RptSqlParam param1 = new RptSqlParam(code, String.class);
		sql_exe.addParamSorted(param1);
		List<UdidocDTO> beanlist = null;
		try {
			// 执行sql查询
			ResultSet rset = sql_exe.exeQuery();
			// 将查询结果集转换成JavaBean对象列表
			beanlist = (List<UdidocDTO>)RptRsHanlderUtils.toBeanList(rset, UdidocDTO.class);
			// 关闭结果集
			SqlExecutor.closeResultSet(rset);
		}
		catch(Exception ex) {
			throw new BizException(ex);
		}
		finally {
			sql_exe.destroy();
		}
		return beanlist;
	}
	
	/**
	 * 根据档案模板code以及档案code获取特定档案
	 * @param udidoclistCode
	 * @param udidocCode
	 * @return
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	public static UdidocDTO findByCode(String udidoclistCode, String udidocCode) throws BizException{
		
		GetUdidocsQry qry=new GetUdidocsQry(udidoclistCode,udidocCode);
		SqlExecutor sql_exe=new SqlExecutor();
		sql_exe.setSql(qry.getQrySQLStr());
		RptSqlParam param1 = new RptSqlParam(udidoclistCode, String.class);
		sql_exe.addParamSorted(param1);
		RptSqlParam param2 = new RptSqlParam(udidocCode, String.class);
		sql_exe.addParamSorted(param2);
		List<UdidocDTO> beanlist = null;
		try {
			// 执行sql查询
			ResultSet rset = sql_exe.exeQuery();
			// 将查询结果集转换成JavaBean对象列表
			beanlist = (List<UdidocDTO>)RptRsHanlderUtils.toBeanList(rset, UdidocDTO.class);
			// 关闭结果集
			SqlExecutor.closeResultSet(rset);
		}
		catch(Exception ex) {
			throw new BizException(ex);
		}
		finally {
			sql_exe.destroy();
		}
		if(CollectionUtils.isNotEmpty(beanlist)){
			return beanlist.get(0);
		}
		return null;
	}
	
	/**
	 * 根据档案表字段以及属性值获取特定档案
	 * @param fieldValue
	 * @return
	 * @throws DAException 
	 */
	public static List<UdidocDTO> findByAttrs(Map<String,Object> fieldValue) throws DAException{
		GetUdidocsQry qry=new GetUdidocsQry(fieldValue);
		@SuppressWarnings("unchecked")
		List<UdidocDTO> udidocDTOs = (List<UdidocDTO>) new DAFacade().execQuery(qry.getQrySQLStr(), qry.getQryParameter(null), new BeanListHandler(UdidocDTO.class));
	     return udidocDTOs;
	}
}
