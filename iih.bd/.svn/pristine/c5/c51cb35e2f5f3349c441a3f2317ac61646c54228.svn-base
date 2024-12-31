package iih.bd.srv.pub;


import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapHandler;
import xap.sys.jdbc.handler.MapListHandler;

public class BdAppUtil {
	
	/**
	 * 获得sql串对应的Map
	 * @param sqlStr
	 * @return
	 * @throws BizException
	 */
	public static Map<String,Object> getRsMap(String sqlStr) throws BizException{
		try{
			return (Map<String,Object>)(new DAFacade().execQuery(sqlStr, new MapHandler()));
		}catch(Exception e){
			throw new BizException(e.getMessage());
		}
	}
	
	/**
	 * 获得sql串对应的MapList
	 * @param sqlStr
	 * @return
	 * @throws BizException
	 */
	public static List<Map<String, Object>> getRsMapList(String sqlStr) throws BizException{
		try{
			return (List<Map<String, Object>>)(new DAFacade().execQuery(sqlStr, new MapListHandler()));
		}catch(Exception e){
			throw new BizException(e.getMessage());
		}
	}
}
