package iih.ci.mr.writer.s;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import iih.ci.mr.writer.i.IWriterUtil;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap2;
import xap.mw.core.service.constant.Binding;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.handler.MapListHandler;

@Service(serviceInterfaces={IWriterUtil.class}, binding=Binding.JSONRPC)
public class WriterUtilImpl implements IWriterUtil{
	
	@Override
	@SuppressWarnings("unchecked")
	public FArrayList2 findDataByPageIndex(String sqlStr, int pageSize, int pageIndex) throws BizException {
		ArrayList<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		
		boolean checkSqlValid = checkSqlValid(sqlStr,true);
		if(!checkSqlValid) return null; 
		
		int fromIndex = sqlStr.toUpperCase().indexOf("FROM");
		int whereIndex = sqlStr.toUpperCase().indexOf("WHERE");
		String strSplit = sqlStr;
		String strColumn = strSplit.substring(6, fromIndex);
		strSplit = sqlStr;
		String tableName = "";
		if(whereIndex == -1)
		{
			tableName = strSplit.substring(fromIndex+4);
		}
		else
		{
			tableName = strSplit.substring(fromIndex+4, whereIndex);
		}
		
		String[] str = strColumn.replace("，", ",").split(",");
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		String flag="";
		Map<String, Object> map = new HashMap<String,Object>();
		Map<String, String> map3 = new HashMap<String,String>();
		if(str!=null&&str.length>0)
		{
			if(str[0].contains("*"))
			{
				flag=str[0];
				sb.append(str[0]);
			}else
			{
				for(int i=0;i<str.length;i++){
					String[] columnNames = str[i].toUpperCase().split(" AS ");
					if(columnNames[columnNames.length-1].contains("."))
					{
						String[] columnNamePoints = columnNames[columnNames.length-1].split("\\.");
						sb.append(columnNamePoints[columnNamePoints.length-1]);
						map.put(columnNamePoints[columnNamePoints.length-1].trim().replace(" ", ""), columnNamePoints[columnNamePoints.length-1].trim().replace(" ", ""));
					}else
					{
						sb.append(columnNames[columnNames.length-1]);
						map.put(columnNames[columnNames.length-1].trim().replace(" ", ""), columnNames[columnNames.length-1].trim().replace(" ", ""));
					}
					if(i!=str.length-1)
					{
						sb.append(",");
					}
					
					if(columnNames.length>1)
					{
						map3.put(columnNames[0].trim().replace(" ", ""), columnNames[columnNames.length-1].trim().replace(" ", ""));
					}
				}
			}
		}
		sb.append(" FROM ( ");
		long end = pageIndex*pageSize;
		long start = (pageIndex-1)*pageSize;
		
		if(whereIndex > 0)
		{
			String selectSql = sqlStr.substring(0, whereIndex);
			String whereSql = sqlStr.substring(whereIndex);
			for (Map.Entry<String, String> entry : map3.entrySet()) { 
				if(whereSql.contains(entry.getValue()))
				{
					whereSql = whereSql.replace(" "+entry.getValue()+" ", " "+entry.getKey()+" ");
				}
			}
			sqlStr = selectSql + whereSql;
		}
		
		
		String endSql =  "select t.*,rownum row_ from (" +sqlStr + ") t"+ " where rownum <="+end+ ") where row_ >"+start;
		sb.append(endSql);
		
    	DAFacade daf = new DAFacade();  	
    	list= (ArrayList<Map<String, Object>>)daf.execQuery(sb.toString(), new MapListHandler());
    	if(list.size()==0){
    		if(flag.contains("*")){
	    		String str2="select column_name from user_tab_columns where table_name ='"+tableName.toUpperCase()+"'";
	    		ArrayList<Map<String, Object>> listColumn = (ArrayList<Map<String, Object>>)daf.execQuery(str2, new MapListHandler());
	    	    map.clear();
	    	    for(Map<String, Object> m:listColumn){
	    	    	for(Object o:m.values()){
	    	    		String value=(String)o;
	    	    		map.put(value, value);
	    	    	}
	    	    }    	   
    	    }
    		list.add(map);
    	}
    	FArrayList2 list2 =new FArrayList2();	
    	for(Map<String, Object> l:list){
    		FMap2 map2=new FMap2();
    		for(String key : map.keySet())
    		{
    		   Object o= l.get(key.toLowerCase().replace("\"", ""));
    		   if(o!=null){
    			   map2.put(key.replace("\"", ""), o);
    		   }else{
    			   map2.put(key.replace("\"", ""), key.replace("\"", ""));
    		   }
    			
    		}
    		list2.add(map2);
    	}   	
    	return list2;
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public FArrayList2 findDataAll(String sqlStr) throws BizException {
		ArrayList<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		boolean checkSqlValid = checkSqlValid(sqlStr,true);
		if(!checkSqlValid) return null; 

		int fromIndex = sqlStr.toUpperCase().indexOf("FROM");
		int whereIndex = sqlStr.toUpperCase().indexOf("WHERE");
		String strSplit = sqlStr;
		String strColumn = strSplit.substring(6, fromIndex);
		strSplit = sqlStr;
		String tableName = "";
		if(whereIndex == -1)
		{
			tableName = strSplit.substring(fromIndex+4);
		}
		else
		{
			tableName = strSplit.substring(fromIndex+4, whereIndex);
		}
		
		String[] str = strColumn.replace("，", ",").split(",");
		String flag="";
		Map<String, Object> map = new HashMap<String,Object>();
		Map<String, String> map3 = new HashMap<String,String>();
		if(str!=null&&str.length>0)
		{
			if(str[0].contains("*"))
			{
				flag=str[0];
			}else
			{
				for(int i=0;i<str.length;i++){
					String[] columnNames = str[i].toUpperCase().split(" AS ");
					if(columnNames[columnNames.length-1].contains("."))
					{
						String[] columnNamePoints = columnNames[columnNames.length-1].split(" AS ");
						map.put(columnNamePoints[columnNamePoints.length-1].trim().replace(" ", ""), columnNamePoints[columnNamePoints.length-1].trim().replace(" ", ""));
					}
					else
					{
						map.put(columnNames[columnNames.length-1].trim().replace(" ", ""), columnNames[columnNames.length-1].trim().replace(" ", ""));
					}
					if(columnNames.length>1)
					{
						map3.put(columnNames[0].trim().replace(" ", ""), columnNames[columnNames.length-1].trim().replace(" ", ""));
					}
				}
			}
		}
		
		
		if(whereIndex > 0)
		{
			String selectSql = sqlStr.substring(0, whereIndex);
			String whereSql = sqlStr.substring(whereIndex);
			for (Map.Entry<String, String> entry : map3.entrySet()) { 
				if(whereSql.contains(entry.getValue()))
				{
					whereSql = whereSql.replace(" "+entry.getValue()+" ", " "+entry.getKey()+" ");
				}
			}
			sqlStr = selectSql + whereSql;
		}
		
    	DAFacade daf = new DAFacade();  	
		list=(ArrayList<Map<String, Object>>) daf.execQuery(sqlStr, new MapListHandler());
		if(list.size()==0){
    		if("*".equals(flag)){
	    		String str2="select column_name from user_tab_columns where table_name ='"+tableName.toUpperCase()+"'";
	    		ArrayList<Map<String, Object>> listColumn = (ArrayList<Map<String, Object>>)daf.execQuery(str2, new MapListHandler());
	    	    map.clear();
	    	    for(Map<String, Object> m:listColumn){
	    	    	for(Object o:m.values()){
	    	    		String value=(String)o;
	    	    		map.put(value, value);
	    	    	}
	    	    }    	   
    	    }
    		list.add(map);
    	}
		FArrayList2 list2 =new FArrayList2();	
    	for(Map<String, Object> l:list){
    		FMap2 map2=new FMap2();
    		map2.putAll(l);
    		list2.add(map2);
    	}   	
		return list2;
	}

	@Override
	public String findDataScalar(String sqlStr) throws BizException {
		
		boolean checkSqlValid = checkSqlValid(sqlStr,true);
		
		if(!checkSqlValid) return null; 
		
    	DAFacade daf = new DAFacade();
		String result=(String) daf.execQuery(sqlStr, new ColumnHandler());
		
		  	
		return result;
	}
	@Override
	public Boolean checkSqlValid(String sqlStr, Boolean isOnlySel) throws BizException {
		
		if(sqlStr==null) return false;
		
		boolean flag = false;	
		try {			
			if(isOnlySel){
				//检验是否是查询；检验有效;目前要求必须有where方便校验，如果没有where 就执行原语句
				if(sqlStr.trim().toUpperCase().startsWith("SELECT")){
					sqlStr = sqlStr.toUpperCase();
					sqlStr = "select 1 from ("+sqlStr;
					/*if(sqlStr.contains("WHERE"))
					{*/
						//校验时，应该只获取一条数据，都获取数据量大时耗时长，暂时只考虑oracle
						//sqlStr = sqlStr.replace("WHERE", "WHERE rownum <= 1 and");
						sqlStr +=") WHERE rownum <= 1" ;
					/*}*/
					DAFacade daf = new DAFacade();  	
					daf.execQuery(sqlStr, new MapListHandler());
					flag=true;
			} else{
					flag = false;
				}
			}
		} catch (Exception e) {
			flag = false;
		}	
		return flag;
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public int resultCount(String sqlStr, int pageSize) throws BizException{
		
		int fromIndex = sqlStr.toUpperCase().indexOf("FROM");
		String strSplit = sqlStr;
		String strColumn = strSplit.substring(6, fromIndex);
		strSplit = sqlStr;
		String sb = strSplit.substring(fromIndex);
		String[] str = strColumn.replace("，", ",").split(",");
		Map<String, String> map = new HashMap<String,String>();
		if(str!=null&&str.length>0)
		{
			for(int i=0;i<str.length;i++){
				String[] columnNames = str[i].toUpperCase().split(" AS ");
				if(columnNames.length>1)
				{
					map.put(columnNames[0].trim().replace(" ", ""), columnNames[columnNames.length-1].trim().replace(" ", ""));
				}
			}
		}
		
		for (Map.Entry<String, String> entry : map.entrySet()) { 
				if(sb.contains(entry.getValue()))
				{
					sb = sb.replace(" "+entry.getValue()+" ", " "+entry.getKey()+" ");
				}
			}
		
		String endStr="select count(*) as "+ "\""+"size"+"\" "+sb.toString();
		DAFacade daf = new DAFacade();  	
		ArrayList<Map<String, Object>> count=(ArrayList<Map<String, Object>>)daf.execQuery(endStr, new MapListHandler());
		int size=(int) count.get(0).get("size");
		int y=(size%pageSize);
		int pageCount=(size/pageSize);
		if(y>0){
			return pageCount+1;
		}else{
			return pageCount;
		}	
	}
			
}

