package iih.nm.nhr.wardprint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang3.StringUtils;

import iih.nm.nhr.dto.HrPsnDTO;
import iih.nm.nhr.dto.SchedDTO;
import iih.nm.nhr.dto.SiGrpPsnDTO;
import iih.nm.nhr.dto.SigrpDTO;
import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.handler.BeanListHandler;


/**
 * 功能描述：报表获取排班数据
 * @author guo.xiao
 *
 */
public class GetSchedDataBp {
	/**
	 * 排班打印标识
	 */
	public static final String NM = "nm";// 护理
	public static final String HR = "hr";// 人力
	
	private String idSiGrps; //排班分组主键
	
	private String dt_week; //当前排班分组下对应周一日期
	public List<SchedDTO> exec (String dt_monday,String id_dep_nur,String flag) throws Exception {
		//参数非空验证
		if (valida(dt_monday, id_dep_nur)) {
			return null;
		}
		//返回查询结果
		List<SchedDTO> schedList = null;
		if (NM.equals(flag)) {
			filterSiGrpByDtWeek(new FDate(dt_monday),getSiGrpMap(id_dep_nur));
			schedList = getResultByFill(getSchedRsBySql(getQrySQLStrNm(dt_week,dt_monday, id_dep_nur)),
					dt_monday,id_dep_nur, flag);
		} else if (HR.equals(flag)) {
			schedList = getResultByFill(getSchedRsBySql(getQrySQLStrHr(dt_monday, id_dep_nur)),
					dt_monday,id_dep_nur, flag);
		}
		return schedList;
	}
	
	/**
	 * 基础参数校验
	 * @param dt_monday
	 * @param id_dep_nur
	 * @return
	 */
    private boolean valida(String dt_monday,String id_dep_nur) {
    	return (StringUtils.isEmpty(dt_monday) || StringUtils.isEmpty(id_dep_nur));
    }
    
    /**
     * 报表后台排班数据填充返回
     * @param schedList
     * @param dt_mondy
     * @return
     * @throws Exception 
     */
    private List<SchedDTO> getResultByFill(List<SchedDTO> schedList,String dt_monday
    		,String id_dep_nur,String flag) throws Exception {
    	if (CollectionUtils.isNotEmpty(schedList)) {
    		//存放当前科室已存在的排班日期
			List<FDate> schedDate = new ArrayList<FDate>();
			//将list中的排班日期放入weekDate中(不重复)
			for (SchedDTO schedDTO : schedList) {
				if (!schedDate.contains(schedDTO.getDt_sched_date())) {
					schedDate.add(schedDTO.getDt_sched_date());
				}
			}
			//通过dt_monday(前台给定周一时间)获取该周日期
			List<FDate> weekDate = findDates(toDate(dt_monday),addDay(dt_monday, 6));
			//补充没有排班的日期 ,nm代表护理，hr代表人力
	        if (NM.equals(flag)) {
				return fillNmSchedData(schedList, weekDate, id_dep_nur, schedDate, dt_monday);
			} else if (HR.equals(flag)) {
			   return fillHrSchedData(schedList, weekDate, id_dep_nur, schedDate);
			}
		}
    	return null;
    }
    
    /**
     * 
     * 功能: 对指定日期增加指定的天数
     * 
     * @param str  日期[yyyy-mm-dd]
     * @param day  增加的天数
     * @return
     * @throws ParseException 
     *
     */
    public  Date addDay(String str, int day) throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        date = sdf.parse(str);
        date = DateUtils.addDays(date, day);
        return date;
    }
    
    /**
     * 字符串转Date
     * @param str
     * @return
     * @throws ParseException
     */
    public Date toDate(String str) throws ParseException {
    	Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        date = sdf.parse(str);
        return date;
    }
    
    /**
     * 根据当前周周一到周日 获取当前一周的时间
     * @param dBegin
     * @param dEnd
     * @return
     */
    public  List<FDate> findDates(Date dBegin, Date dEnd) {  
	     List<FDate> dataList = new ArrayList<FDate>();
	     dataList.add(new FDate(dBegin));
	     Calendar calBegin = Calendar.getInstance();  
	     // 使用给定的 Date 设置此 Calendar 的时间  
	     calBegin.setTime(dBegin);  
	     Calendar calEnd = Calendar.getInstance();  
	     // 使用给定的 Date 设置此 Calendar 的时间  
	     calEnd.setTime(dEnd);  
	     // 测试此日期是否在指定日期之后  
	     while (dEnd.after(calBegin.getTime()))  
	     {  
	      // 根据日历的规则，为给定的日历字段添加或减去指定的时间量  
	      calBegin.add(Calendar.DAY_OF_MONTH, 1);  
	      dataList.add(new FDate(calBegin.getTime()));
	     }  
	     return dataList;  
    }
    
    /**
     * 人力排班数据填充
     * @param schedList
     * @param weekDate
     * @param id_dep_nur
     * @param schedDate
     * @return
     * @throws Exception
     */
    private List<SchedDTO> fillHrSchedData(List<SchedDTO> schedList,List<FDate> weekDate,String id_dep_nur
    		,List<FDate> schedDate) throws Exception {
    	List<HrPsnDTO> hrPsnList = getHrPsnRsBySql(getHrPsnQeySql(id_dep_nur));
    	for (FDate fDate : weekDate) {
			if (!schedDate.contains(fDate)) {
				    for (HrPsnDTO hrPsnDTO : hrPsnList) {
				    	SchedDTO schedDTO = new SchedDTO();
				    	schedDTO.setDt_sched_date(fDate);
				    	schedDTO.setName(hrPsnDTO.getName());
				    	schedDTO.setName_hsc_si("/");
				    	schedList.add(schedDTO);
					}
			}
		}
    	return schedList;
    }
    
    /**
     * 护理排班数据填充
     * @param schedList
     * @param weekDate
     * @param id_dep_nur
     * @param schedDate
     * @param dt_monday
     * @return
     * @throws Exception
     */
    private List<SchedDTO> fillNmSchedData(List<SchedDTO> schedList,List<FDate> weekDate,String id_dep_nur
    		,List<FDate> schedDate,String dt_monday) throws Exception {
		//获取护理管理分组人员
//		List<SiGrpPsnDTO> siGrpPsnList = getSiGrpPsnRsBySql(
//				getSiGrpPsnQrySql(filterSiGrpByDtWeek(new FDate(dt_monday),
//						getSiGrpMap(id_dep_nur))));
		List<SiGrpPsnDTO> siGrpPsnList = getSiGrpPsnRsBySql(getSiGrpPsnQrySql(idSiGrps));
		for (FDate fDate : weekDate) {
			if (!schedDate.contains(fDate)) {
				    for (SiGrpPsnDTO siGrpPsnDTO : siGrpPsnList) {
				    	SchedDTO schedDTO = new SchedDTO();
				    	schedDTO.setDt_sched_date(fDate);
				    	schedDTO.setName(siGrpPsnDTO.getName());
				    	schedDTO.setName_nhr_si("/");
				    	schedDTO.setSortno(siGrpPsnDTO.getSortno());
				    	schedList.add(schedDTO);
					}
			}
		}
		return schedList;
    }
    
    /**
     * 获取排班数据 
     * @param strSql
     * @return
     * @throws Exception
     */
    @SuppressWarnings("deprecation")
	private List<SchedDTO> getSchedRsBySql(String strSql) throws Exception {		
    	SqlReader sql_rdr = new SqlReader(null, strSql);
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(SchedDTO.class);
		@SuppressWarnings("unchecked")
		List<SchedDTO> result = (List<SchedDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		if (result == null) {
			return null;
		}
		if (CollectionUtils.isNotEmpty(result)) {
			for (SchedDTO schedDTO : result) {
				if ("".equals(schedDTO.getName_nhr_si())) {
					schedDTO.setName_nhr_si("/");
				}
			}
		}
		return result;
	}
    
    /**
     * 获取排班分组数据
     * @param strSql
     * @return
     * @throws Exception
     */
    @SuppressWarnings("deprecation")
	private List<SigrpDTO> getSiGrpRsBySql(String strSql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, strSql);
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(SigrpDTO.class);
		@SuppressWarnings("unchecked")
		List<SigrpDTO> result = (List<SigrpDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		if (result == null || result.size() <= 0) {
			return null;
		}
		return result;
	}
    
    /**
     * 获取排班分组人员数据
     * @param strSql
     * @return
     * @throws Exception
     */
    @SuppressWarnings("deprecation")
	private List<SiGrpPsnDTO> getSiGrpPsnRsBySql(String strSql) throws Exception {		
    	SqlReader sql_rdr = new SqlReader(null, strSql);
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(SiGrpPsnDTO.class);
		@SuppressWarnings("unchecked")
		List<SiGrpPsnDTO> result = (List<SiGrpPsnDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		if (result == null || result.size() <= 0) {
			return null;
		}
		return result;
	}
    
    @SuppressWarnings("deprecation")
	private List<HrPsnDTO> getHrPsnRsBySql(String strSql) throws Exception {		
    	SqlReader sql_rdr = new SqlReader(null, strSql);
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(HrPsnDTO.class);
		@SuppressWarnings("unchecked")
		List<HrPsnDTO> result = (List<HrPsnDTO>) beanlist_handler.processRs(cached_rs);
		sql_rdr.destroy();
		if (result == null || result.size() <= 0) {
			return null;
		}
		return result;
	}



    /**
     * 人力排班查询sql拼接
     * @param dt_monday
     * @param id_dep_nur
     * @return
     */
    public String getQrySQLStrHr(String dt_monday,String id_dep_nur) {
		StringBuffer sb = new StringBuffer();
		sb.append("select sched.id_psndoc  id_psndoc,                    ");
		sb.append("psndoc.name  name,");
		sb.append("sched.dt_sched_date  dt_sched_date,                   ");
		sb.append("sched.name_hsc_si  name_hsc_si                 ");
		sb.append("from hr_hsc_sched sched                               ");
		sb.append("left join hr_hsc_sched_week week                      ");
		sb.append("on week.id_hsc_sched_week = sched.id_hsc_sched_week   ");
		sb.append("left join bd_psndoc psndoc                            ");
		sb.append("on psndoc.id_psndoc = sched.id_psndoc                 ");
		sb.append("where week.dt_monday= '");		
		sb.append(dt_monday);
		sb.append("' and week.id_dep= '");
		sb.append(id_dep_nur);
		sb.append("' ");
		sb.append("group by sched.dt_sched_date,sched.id_psndoc,         ");
		sb.append("psndoc.name,sched.name_hsc_si,psndoc.code             ");
		sb.append("order by psndoc.code                                  ");
		return sb.toString();
	}
    
    /**
     * 护理排班查询sql拼接
     * @param dt_monday
     * @param id_dep_nur
     * @return
     */
    public String getQrySQLStrNm(String dt_week,String dt_monday,String id_dep_nur) {
  		StringBuffer sb = new StringBuffer();
  		sb.append("select sched.id_nur,                                                                  ");
  		sb.append("nur.name,");
  		sb.append("sigrppsn.sortno,");
  		sb.append("sched.dt_sched_date,                   												  ");
  		sb.append("listagg(sched.name_nhr_si, '/') within group(order by sched.sortno_day) as name_nhr_si ");
  		sb.append("from nm_nhr_sched sched                               								  ");
  		sb.append("left join nm_nhr_sched_week week                      								  ");
  		sb.append("on week.id_nhr_sched_week = sched.id_nhr_sched_week   								  ");
  		sb.append("left join nm_nur nur                            										  ");
  		sb.append(" on nur.id_nur = sched.id_nur                 										  ");
  		sb.append(" inner join nm_nhr_sigrp_psn sigrppsn on nur.id_nur = sigrppsn.id_nur ");
  		sb.append(" left join nm_nhr_sigrp sigrp  on sigrp.id_nhr_sigrp = sigrppsn.id_nhr_sigrp ");
  		sb.append("where week.dt_monday= '");		
  		sb.append(dt_monday);
  		sb.append(" ' and sigrp.dt_week = '");		
  		sb.append(dt_week);
  		sb.append("' and week.id_dep_nur= '");
  		sb.append(id_dep_nur);
  		sb.append("' ");
  		sb.append("group by sched.dt_sched_date,sched.id_nur, nur.name,sigrppsn.sortno      							  ");
  		return sb.toString();
  	}

    
    /**
     * 获取当前科室分组信息
     * @param id_dep_nur
     * @return
     */
    public String getSiGrpQrySql(String id_dep_nur) {
    	StringBuffer sb = new StringBuffer();
  		sb.append("select id_nhr_sigrp,    ");
  		sb.append("id_dep_nur,             ");
  		sb.append("name,                   ");
  		sb.append("dt_week,                ");
  		sb.append("sortno                  ");
  		sb.append("from nm_nhr_sigrp sigrp ");
  		sb.append("where id_dep_nur= '");		
  		sb.append(id_dep_nur);
  		sb.append("' ");
  		sb.append("order by dt_week DESC ,Sortno asc");
  		return sb.toString();
    }
    
    /**
     * 获取当前科室分组下成员
     * @param idSiGrps
     * @return
     */
    public String getSiGrpPsnQrySql(String idSiGrps) {
    	StringBuffer sb = new StringBuffer();
  		sb.append("select sigrppsn.id_nhr_sigrp_psn,  ");
  		sb.append("sigrppsn.id_nhr_sigrp,             ");
  		sb.append("sigrppsn.sortno,                   ");
  		sb.append("nur.id_nur,                        ");
  		sb.append("psndoc.name ");
  		sb.append("from nm_nhr_sigrp_psn sigrppsn ");
  		sb.append("inner join nm_nur nur on sigrppsn.id_nur = nur.id_nur ");
  		sb.append("inner join bd_psndoc psndoc on psndoc.id_psndoc = nur.id_psndoc ");
  		sb.append("where sigrppsn.id_nhr_sigrp in ");		
  		sb.append(idSiGrps);
  		return sb.toString();
    }
    
    /**
     * 获取人力科室对应人员
     * @param id_dep_nur
     * @return
     */
    public String getHrPsnQeySql(String id_dep_nur) {
    	StringBuffer sb = new StringBuffer();
  		sb.append("select id_psndoc, ");
  		sb.append("name,             ");
  		sb.append("id_dep            ");
  		sb.append("from bd_psndoc    ");
  		sb.append("where id_dep = '");		
  		sb.append(id_dep_nur);
  		sb.append("'");
  		return sb.toString();
    }
    
    /**
     * 当前科室对应的集合
     * FDate 对应周一日期
     * List<SigrpDTO> 对应周一日期下的分组
     * @param id_dep_nur
     * @throws Exception
     */
    private Map<FDate,List<SigrpDTO>> getSiGrpMap(String id_dep_nur) throws Exception {
        //查询当前科室的排班分组
		List<SigrpDTO> siGrpList = getSiGrpRsBySql(getSiGrpQrySql(id_dep_nur));
    	Map<FDate,List<SigrpDTO>> siGrpMap = new HashMap<FDate,List<SigrpDTO>>();
    	for (SigrpDTO sigrpDTO : siGrpList) {
    		//当前集合已存在周一日期，将其对应的排班分组放入list中，不存在，新建list放入map中
			if (siGrpMap.keySet().contains(sigrpDTO.getDt_week())) {
				siGrpMap.get(sigrpDTO.getDt_week()).add(sigrpDTO);
			} else {
				List<SigrpDTO> list = new ArrayList<SigrpDTO>();
				list.add(sigrpDTO);
				siGrpMap.put(sigrpDTO.getDt_week(), list);
			}
		}
    	return siGrpMap;
    }
    
    /**
     * 根据给定日期过滤所需排班分组
     * 并返回排班分组主键s
     */
    private String filterSiGrpByDtWeek(FDate dt_monday,Map<FDate,List<SigrpDTO>> siGrpMap) {
    	if (siGrpMap == null ||siGrpMap.size() < 1 ||siGrpMap.values().size() < 1) {
			return null;
		}
    	List<FDate> dateList = new ArrayList<FDate>();
    	//将siGrpMap的周一日期放入dateList
    	for (FDate fDate : siGrpMap.keySet()) {
    		dateList.add(fDate);
		}
    	//对dateList排序
    	Collections.sort(dateList, new Comparator<FDate>() {
			@Override
			public int compare(FDate o1, FDate o2) {
				return o2.compareTo(o1);
			}
		});
    	//通过比较找到给定的dt_monday相等的或小于dt_monday的
    	for (FDate fDate : dateList) {
			if (dt_monday.compareTo(fDate) >= 0) {
				idSiGrps = getIdSiGrps(siGrpMap.get(fDate));
				dt_week = fDate.toString();
				return getIdSiGrps(siGrpMap.get(fDate));
			}
		}
    	return null;
    }
    
    /**
     * 排班分组主键拼接
     * @param siGrpList
     * @return
     */
    private String getIdSiGrps(List<SigrpDTO> siGrpList) {
		String idSiGrps = "(";
		for (SigrpDTO sgrpDTO : siGrpList) {
			idSiGrps += "'" + sgrpDTO.getId_nhr_sigrp() + "',";
		}
		idSiGrps = idSiGrps.substring(0, idSiGrps.length() - 1) + ")";
		return idSiGrps;
	}
}
