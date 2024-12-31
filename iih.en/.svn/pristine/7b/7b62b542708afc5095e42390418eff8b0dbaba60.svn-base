package iih.en.comm.util;

import iih.en.comm.validator.EnValidator;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 就诊急诊帮助类
 * 
 * @author liubin
 *
 */
public class EnErUtils {
	
	/**
	 * 通过预检id获取所有就诊id
	 * 
	 * @param erPreId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static List<String> getEntIdsByPreId(String erPreId) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT EN.ID_ENT ");
		sqlBuilder.append(" FROM EN_ENT EN ");
		sqlBuilder.append(" INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		sqlBuilder.append(" INNER JOIN EN_ENT_OP_ER OPER ON EN.ID_ENT = OPER.ID_ENT ");
		sqlBuilder.append(" WHERE OPER.ID_ERPRE = ?  ");
		sqlBuilder.append(" AND EN.FG_CANC = 'N' ");
		sqlBuilder.append(" ORDER BY OP.DT_VALID_B, EN.DT_INSERT ");
		String sql = sqlBuilder.toString();
		SqlParam param = new SqlParam();
		param.addParam(erPreId); 
		return (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
	}
	/**
	 * 通过就诊id获取所有就诊id
	 * 
	 * @param erPreId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static List<String> getEntIdsByEntId(String entId) throws BizException{
		String erPreId = getPreIdByEntId(entId);
		if(EnValidator.isEmpty(erPreId))
			return null;
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT EN.ID_ENT ");
		sqlBuilder.append(" FROM EN_ENT EN ");
		sqlBuilder.append(" INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		sqlBuilder.append(" INNER JOIN EN_ENT_OP_ER OPER ON EN.ID_ENT = OPER.ID_ENT ");
		sqlBuilder.append(" WHERE OPER.ID_ERPRE = ?  ");
		sqlBuilder.append(" AND EN.FG_CANC = 'N' ");
		sqlBuilder.append(" ORDER BY OP.DT_VALID_B, EN.DT_INSERT ");
		String sql = sqlBuilder.toString();
		SqlParam param = new SqlParam();
		param.addParam(erPreId); 
		return (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
	}
	/**
	 * 根据就诊id获取预检id
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public static String getPreIdByEntId(String entId) throws BizException{
		String sql = "SELECT ER.ID_ERPRE FROM EN_ENT_OP_ER ER WHERE ER.ID_ENT = ? ";
		SqlParam param = new SqlParam();
		param.addParam(entId); 
		return (String) new DAFacade().execQuery(sql, param, new ColumnHandler());
	}
	/**
	 * 获取最后一次就诊记录 by id_erpre
	 * 
	 * @param erPreId
	 * @return
	 * @throws BizException
	 */
	public static String getLastEntByPreId(String erPreId) throws BizException{
		List<String> entIds = getEntIdsByPreId(erPreId);
		if(EnValidator.isEmpty(entIds))
			return null;
		return entIds.get(entIds.size() - 1);
	}
	/**
	 * 获取最后一次就诊记录 by id_ent
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public static String getLastEntByEntId(String entId) throws BizException{
		List<String> entIds = getEntIdsByEntId(entId);
		if(EnValidator.isEmpty(entIds))
			return null;
		return entIds.get(entIds.size() - 1);
	}
	/**
	 * 获取最后一次就诊记录 by id_erpre, 排除id_ent
	 * 
	 * @param erPreId
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public static String getLastEntByPreIdExcEntId(String erPreId, String entId) throws BizException{
		List<String> entIds = getEntIdsByPreId(erPreId);
		if(EnValidator.isEmpty(entIds))
			return null;
		int size = entIds.size();
		for(int i=size-1; i==0; i--){
			String lastId = entIds.get(i);
			if(lastId.equals(entId))
				continue;
			return lastId;
		}
		return null;
	}
	/**
	 * 获取最后一次就诊记录 by id_ent, 排除id_ent
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public static String getLastEntByExcEntId(String entId) throws BizException{
		List<String> entIds = getEntIdsByEntId(entId);
		if(EnValidator.isEmpty(entIds))
			return null;
		return entIds.get(entIds.size() - 1);
	}
	/**
	 * 获取该就诊的上一次就诊id
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public static String getPreEntId(String entId) throws BizException{
		List<String> entIds = getEntIdsByEntId(entId);
		if(EnValidator.isEmpty(entIds))
			return null;
		int size = entIds.size();
		String pre = null;
		for(int i=0; i<size; i++){
			String id = entIds.get(i);
			if(id.equals(entId))
				return pre;
			pre = id;
		}
		return null;
	}
}
