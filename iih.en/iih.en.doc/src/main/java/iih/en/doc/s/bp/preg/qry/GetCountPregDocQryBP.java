package iih.en.doc.s.bp.preg.qry;
import iih.en.comm.IEnConst;
import iih.en.comm.validator.EnValidator;

import java.util.ArrayList;
import java.util.Map;

import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据指定 月份 或者 指定 某天查询 建档记录数 time 时间 monthorday 查询的是某个月还是某天
 * 
 * @author renzhi
 *
 */
public class GetCountPregDocQryBP {

    public int exec(String[] time, String monthorday) throws DAException {
        // 1. 验证参数是否为空
        if (EnValidator.isEmpty(monthorday) && EnValidator.isEmpty(time)) {
            return 0;
        }
        if (time.length == 1 && "day".equals(monthorday)) {
            return this.getCountDay(time);
        }
        if (time.length == 2 && "month".equals(monthorday)) {
            return this.getCountMonth(time);
        }
        return 0;
    }

    /**
     * 获取月份 Count
     * 
     * @param time
     * @return
     * @throws DAException
     */
    @SuppressWarnings("unchecked")
    private int getCountMonth(String[] time) throws DAException {
        //拼接sql
        StringBuilder sqlSb = this.getSql();
        //sql赋值
        SqlParam param = new SqlParam();
        
        sqlSb.append(" AND PREG.D_EXPECT>=?");
        param.addParam(time[0]);
        sqlSb.append(" AND PREG.D_EXPECT<=?");
        param.addParam(time[1]);
        
        return this.getcount(sqlSb, param);
    }

    /**
     * 获取*年*月*日 建档记录数Count
     * 
     * @param time
     * @return
     * @throws DAException
     */
    private int getCountDay(String[] time) throws DAException {
        //拼接sql
        StringBuilder sqlSb = this.getSql();
        SqlParam param = new SqlParam();
        
        //拼接sql
        sqlSb.append(" AND PREG.DT_APPT = ?");
        param.addParam(time[0]);
        
        return this.getcount(sqlSb, param);
    }

    /**
     * 执行sql 获取建档记录数 并 返回
     * 
     * @param sqlSb
     * @param param
     * @return
     * @throws DAException 
     */
    @SuppressWarnings("unchecked")
    private int getcount(StringBuilder sqlSb, SqlParam param) throws DAException {
        //建档记录数  默认为0
        int count = 0;
        //执行sql 
        Map<String, Object> map = (Map<String, Object>) new DAFacade().execQuery(sqlSb.toString(), param, new MapHandler());
        //根据key 获取建档记录数
        Object object = map.get("T");
        //判断是否为 int 类型 
        if (object instanceof Integer) {
            //强转 并赋值
            count = (int) object;
        }
        //返回建档记录数
        return count;
    }

    /**
     * 封装sql
     * 
     * @return
     */
    private StringBuilder getSql() {
        StringBuilder sqlSb = new StringBuilder();
        sqlSb.append(" SELECT");
        sqlSb.append(" COUNT(*) as T ");
        sqlSb.append(" FROM EN_DOC DOC");
        sqlSb.append(" INNER JOIN EN_DOC_PREG PREG ON PREG.ID_ENTDOC = DOC.ID_ENTDOC");
        sqlSb.append(" WHERE PREG.EU_STATUS IN ('1','2')");
        return sqlSb;
    }

    
    /**
     * 封装sql
     * 
     * @return
     */
    private StringBuilder getMonthSql() {
        StringBuilder sqlSb = new StringBuilder();
        sqlSb.append(" SELECT");
        sqlSb.append(" SUBSTR(PREG.DT_APPT,0,7) time,");
        sqlSb.append(" COUNT(*) as T ");
        sqlSb.append(" FROM EN_DOC DOC");
        sqlSb.append(" INNER JOIN EN_DOC_PREG PREG ON PREG.ID_ENTDOC = DOC.ID_ENTDOC");
        return sqlSb;
    }
    
    /**
     * 查询建档预约数
     * @param times
     * @return
     * @throws DAException
     */
    private int[] getMonthCount(String[] times) throws DAException {
        //拼接sql
        StringBuilder sqlSb = this.getMonthSql();
        SqlParam param = new SqlParam();
        sqlSb.append(" WHERE PREG.EU_STATUS IN (?,?)");
        param.addParam("1");
        param.addParam("2");
        sqlSb.append(" GROUP BY SUBSTR(PREG.DT_APPT,0,7)");
        sqlSb.append(" HAVING ?");
        if (times[0] != null ) {
            param.addParam(times[0]);
            sqlSb.append(" < SUBSTR(PREG.DT_APPT,0,7)");
        }
        if(times[times.length-1]!= null) {
            sqlSb.append(" OR SUBSTR(PREG.DT_APPT,0,7) <?");
            param.addParam(times[times.length-1]);
            sqlSb.append(" ORDER BY SUBSTR(PREG.DT_APPT,0,7) ASC");
        }
        ArrayList map =   (ArrayList) new DAFacade().execQuery(sqlSb.toString(), param, new MapListHandler());
        return this.getArray(times, map);
        
    }
    
    /**
     * 根据日期封装数据
     * @param times
     * @param list
     * @return
     */
    @SuppressWarnings("unchecked")
    private int[] getArray(String[] times,ArrayList list) {
        int[] arr = new int[times.length];
        for (int i = 0; i < times.length; i++) {
            String time = times[i];
            for (int j = 0; j < list.size(); j++) {
                Map<String, String> map = (Map<String, String>) list.get(j);
                if (time.equals(map.get("TIME"))) {
                    Object obj = map.get("T");
                    String string = obj.toString();
                    if (string != null) {
                        arr[i]= new Integer(string);
                    }
                }
            }
        }
        return arr;
    }
    
    /**
     * 根据指定日期天数获取建档预约数
     * @param times
     * @return
     * @throws DAException 
     */
    public int[] findCount(String[] times,String monthorday) throws DAException {
        int[] count = new int[times.length];
        if (times == null || times.length == 0) {
            return count;
        }
        if (EnValidator.isEmpty(monthorday)) {
            return count;
        }
        if ("day".equals(monthorday)) {
            count = this.getDayCount(times);
        }
        if ("month".equals(monthorday)) {
            count = this.getMonthCount(times);
        }
        return count;
    }
    
    /**
     * 获取每天的预约数sql
     * 封装SQL
     * @return
     */
    private StringBuilder getDaySql() {
        StringBuilder sqlSb = new StringBuilder();
        sqlSb.append(" SELECT");
        sqlSb.append(" SUBSTR(PREG.DT_APPT,0,10) time,");
        sqlSb.append(" COUNT(*) as T ");
        sqlSb.append(" FROM EN_DOC DOC");
        sqlSb.append(" INNER JOIN EN_DOC_PREG PREG ON PREG.ID_ENTDOC = DOC.ID_ENTDOC");
        return sqlSb;
    }
    
    /**
     * 查询建档预约数
     * @param times
     * @return
     * @throws DAException
     */
    @SuppressWarnings("unused")
    private int[] getDayCount(String[] times) throws DAException {
        //拼接sql
        StringBuilder sqlSb = this.getDaySql();
        //封装参数对象
        SqlParam param = new SqlParam();
        sqlSb.append(" WHERE PREG.EU_STATUS IN (?,?)");
        param.addParam(IEnConst.STATE_RESERVE);
        param.addParam(IEnConst.STATE_DOC);
        sqlSb.append(" GROUP BY SUBSTR(PREG.DT_APPT,0,10)");
        sqlSb.append(" HAVING ?");
        if (times[0] != null ) {
            param.addParam(times[0]);
            sqlSb.append(" < SUBSTR(PREG.DT_APPT,0,10)");
        }
        if(times[times.length-1]!= null) {
            sqlSb.append(" OR SUBSTR(PREG.DT_APPT,0,10) <?");
            param.addParam(times[times.length-1]);
            sqlSb.append(" ORDER BY SUBSTR(PREG.DT_APPT,0,10) ASC");
        }
        ArrayList map =   (ArrayList) new DAFacade().execQuery(sqlSb.toString(), param, new MapListHandler());
        return this.getArray(times, map);
    }
}
