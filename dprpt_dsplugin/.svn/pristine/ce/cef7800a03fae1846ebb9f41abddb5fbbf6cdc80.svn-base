package iih.nmr.aggsource.bp;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import iih.nmr.aggsource.dto.ChildinoutDTO;
import iih.nmr.aggsource.dto.ChildnurDTO;
import xap.dp.report.data.reader.sql.RptRsHanlderUtils;
import xap.dp.report.data.reader.sql.SqlExecutor;
import xap.mw.core.utils.StringUtil;

public class ChildInoutBp {
	public List<ChildnurDTO> exec(String id_ent, String dt_start, String dt_end) throws Exception {

		// 1、基础数据校验
		if (StringUtil.isEmptyWithTrim(id_ent))
			return null;

		// 2、查询出入液量信息
		List<ChildnurDTO> incomeList = getIncomes(id_ent, dt_start, dt_end);

		// 3、查询统计信息
		List<ChildinoutDTO> totalList = getTotals(id_ent);

		// 4、数据整合
		incomeList = dealData(incomeList, totalList);
		return incomeList;
	}

	/**
	 * 数据整合
	 * 
	 * @param incomeList
	 * @param totalList
	 */
	private List<ChildnurDTO> dealData(List<ChildnurDTO> incomeList, List<ChildinoutDTO> totalList) {
		if (incomeList == null || incomeList.size() == 0 || totalList == null || totalList.size() == 0)
			return incomeList;
		// 如果都不为空
		int i = 0;
		for (int local = 0; local < incomeList.size() - 1 && totalList.size() > 0; local++) {
			if (incomeList.get(local + 1).getDt_datetime().compareTo(totalList.get(0).getDt_end()) > 0
					&& totalList.size() > 0) {
				List<ChildinoutDTO> arry = getAttrs(incomeList.get(local + 1).getDt_datetime(), totalList);
				incomeList.get(local).setListTotal(arry);
				for (int n = 0; n < arry.size(); n++) {
					totalList.remove(0);
				}
			}
			i++;
		}
		// 判断达到最后一条记录信息时是否存在未添加集合的统计信息
		if (i == incomeList.size() - 1 && totalList.size() != 0) {
			for (int m = 0; m < totalList.size(); m++) {
				incomeList.get(i).setListTotal(totalList);
			}
		}
		return incomeList;
	}

	/**
	 * 获取部分统计集合
	 * 
	 * @param dt_datetime
	 * @param totalList
	 * @return
	 */
	private List<ChildinoutDTO> getAttrs(String dt_datetime, List<ChildinoutDTO> totalList) {

		List<ChildinoutDTO> arry = new ArrayList<ChildinoutDTO>();
		for (ChildinoutDTO ChildinoutDTO : totalList) {
			if (ChildinoutDTO.getDt_end().compareTo(dt_datetime) < 0)
				arry.add(ChildinoutDTO);
			else
				break;
		}
		return arry;
	}

	/**
	 * 查询统计信息
	 * 
	 * @param id_ent
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private List<ChildinoutDTO> getTotals(String id_ent) throws Exception {
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("SELECT udi1.name as name_iotype, dt_begin, dt_end, num_in, num_out, note, dt_create,id_nur,sc.pic,"
						+ "PSN.NAME AS NAME_NUR"// SC.PIC,
						+ "  FROM nmr_pkuf_childinout t" + "  LEFT JOIN SYS_MYSCVI SC ON T.ID_NUR=SC.ID_USER"
						+ "  LEFT JOIN BD_PSNDOC PSN ON T.ID_NUR = PSN.ID_PSNDOC"
						+ "  left join bd_udidoc udi1 on t.id_iotype=udi1.id_udidoc" + " where id_ent  = '" + id_ent
						+ "' order by dt_end asc");
		//GetResultbysql sqlutil = new GetResultbysql();
		//@SuppressWarnings("unchecked")
		// List<ChildinoutDTO> incomeList = (List<ChildinoutDTO>)
		// sqlutil.getResultListBySql(strBuffer.toString(),
		// ChildinoutDTO.class);
		List<ChildinoutDTO> incomeList = null;
		// 构造带变参的sql语句
		String str_sql = strBuffer.toString();
		// 创建sql执行器 (SqlExecutor可以支持变参)
		SqlExecutor sql_exec = new SqlExecutor();
		// 设置sql语句
		sql_exec.setSql(str_sql);
		// 执行sql查询
		ResultSet rset = sql_exec.exeQuery();
		// 将查询结果集转换成JavaBean对象列表
		incomeList = (List<ChildinoutDTO>) RptRsHanlderUtils.toBeanList(rset, ChildinoutDTO.class);
		return incomeList;
	}

	/**
	 * 查询出入液量记录信息
	 * 
	 * @param id_ent
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private List<ChildnurDTO> getIncomes(String id_ent, String dt_start, String dt_end) throws Exception {

		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("SELECT t.id_nur,sc.pic,DT_DATETIME, "
				+ "UDI0.NAME AS NAME_NUR_LEVEL, "
				+ "UDI1.NAME AS NAME_CONSCIONS, "
				+ "NV_T, INT_PULSE, INT_BREATHING, INT_SBP, "
				+ "INT_DBP, CONSCIOUS, OXYGEN, UDI2.NAME AS NAME_SKIN_SITUA, "
				+ "INFU_AMOUNT, DIET, DRINK, STOOL, PEE, OTHERS_AMOUNT, "
				+ "NURSING, PSN.NAME AS NAME_PSNDOC,NURS_SIGN "
				+ "FROM NMR_PKUF_CHILDNURSE T "
				+ "LEFT JOIN BD_PSNDOC PSN ON ID_NUR = PSN.ID_PSNDOC "
				+ " LEFT JOIN BD_UDIDOC UDI0 ON T.ID_NUR_LEVEL=UDI0.ID_UDIDOC "
				+ " LEFT JOIN BD_UDIDOC UDI1 ON T.ID_CONSCIOUS=UDI1.ID_UDIDOC "
				+ " LEFT JOIN BD_UDIDOC UDI2 ON T.ID_SKIN_SITUA=UDI2.ID_UDIDOC "
				+ " LEFT join sys_myscvi sc on t.id_nur=sc.id_user "
			    + " where  id_ent  = '" + id_ent + "' ");
		if (dt_start != null && dt_start != "" && dt_start != " ") {
			strBuffer.append(" and DT_DATETIME>='" + dt_start + "'");
		}
		if (dt_end != null && dt_start != "" && dt_start != " ") {
			strBuffer.append(" and DT_DATETIME<='" + dt_end + "'");
		}
		strBuffer.append("order by DT_DATETIME");
		// GetResultbysql sqlutil = new GetResultbysql();
		// @SuppressWarnings("unchecked")
		// List<ChildnurDTO> incomeList =(List<ChildnurDTO>)new
		// DAFacade().execQuery(strBuffer.toString(), new
		// BeanListHandler(ChildnurDTO.class));
		// List<ChildnurDTO> incomeList = (List<ChildnurDTO>)
		// sqlutil.getResultListBySql(strBuffer.toString(),
		// ChildnurDTO.class);
		List<ChildnurDTO> incomeList = null;
		// 构造带变参的sql语句
		String str_sql = strBuffer.toString();
		// 创建sql执行器 (SqlExecutor可以支持变参)
		SqlExecutor sql_exec = new SqlExecutor();
		// 设置sql语句
		sql_exec.setSql(str_sql);
		// 执行sql查询
		ResultSet rset = sql_exec.exeQuery();
		// 将查询结果集转换成JavaBean对象列表
		incomeList = (List<ChildnurDTO>) RptRsHanlderUtils.toBeanList(rset, ChildnurDTO.class);
		/*if (incomeList != null && incomeList.size() > 0) {
			String d_time = "";
			for (int i = 1; i < incomeList.size() && incomeList.size() > 0; i++) {
				if (incomeList.get(i).getDt_datetime() == incomeList.get(i - 1).dt_datetime
						|| incomeList.get(i).dt_datetime == d_time)
					incomeList.get(i).setDt_datetime("");
				if (incomeList.get(i - 1).getDt_datetime() != "")
					d_time = incomeList.get(i - 1).getDt_datetime();
			}
		}*/

		return incomeList;
	}

}
