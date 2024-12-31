package iih.en.comm.validator;

import iih.en.comm.exception.NoUniqueException;

import java.util.Collection;
import java.util.Map;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.SqlBuildHelper;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 唯一性验证
 * @author yank
 *
 */
public final class UniqueValidator {	
	/**
	 * 验证
	 * @param clazz DO类型
	 * @param fieldName 字段名
	 * @param fieldValue 字段值
	 * @throws BizException 异常
	 */
	public static void validate(Class<? extends BaseDO> clazz,String fieldName,Integer fieldValue) throws BizException{
		if(isExist(clazz,fieldName,fieldValue)){
			clazz.getName();
			throw new NoUniqueException("");
		}
	}
	/**
	 * 验证
	 * @param clazz DO类型
	 * @param fieldName 字段名
	 * @param fieldValue 字段值
	 * @throws BizException 异常
	 */
	public static void validate(Class<? extends BaseDO> clazz,String fieldName,String fieldValue) throws BizException{
		if(isExist(clazz,fieldName,fieldValue)){
			clazz.getName();
			throw new NoUniqueException("");
		}
	}
	/**
	 * 是否已经存在
	 * @param clazz DO类型
	 * @param fieldName 字段名
	 * @param fieldValue 字段值
	 * @return boolean值
	 * @throws DAException
	 */
	public static boolean isExist(Class<? extends BaseDO> clazz,String fieldName,Integer fieldValue) throws DAException{
		String condition = String.format("%s=%s",fieldName,fieldValue);
		return isExist(clazz,condition);
	} 
	/**
	 * 是否已经存在
	 * @param clazz DO类型
	 * @param fieldName 字段名
	 * @param fieldValue 字段值
	 * @return boolean值
	 * @throws DAException
	 */
	public static boolean isExist(Class<? extends BaseDO> clazz,String fieldName,String fieldValue) throws DAException{
		String condition = String.format("%s='%s'",fieldName,fieldValue);
		return isExist(clazz,condition);
	} 
	/**
	 * 是否已经存在
	 * @param clazz DO类型
	 * @param fieldName 字段名
	 * @param fieldValue 字段值
	 * @return boolean值
	 * @throws DAException
	 */
	public static boolean isExist(Class<? extends BaseDO> clazz,Map<String,Object> fieldMap) throws DAException{
		if(fieldMap==null || fieldMap.size()==0){
			return true;
		}
		SqlBuildHelper conditionBuilder = new SqlBuildHelper();
		for(String field : fieldMap.keySet()){
			if(fieldMap.get(field) instanceof Integer){
				conditionBuilder.append(field,(Integer)fieldMap.get(field));
			}else{
				conditionBuilder.append(field,fieldMap.get(field).toString());
			}
		}
		return isExist(clazz,conditionBuilder.toString());
	} 
	/**
	 * 是否已经存在
	 * @param clazz DO类型
	 * @param condition 条件
	 * @return
	 * @throws DAException
	 */
	public static boolean isExist(Class<? extends BaseDO> clazz,String condition) throws DAException{
		Collection col = new DAFacade().findByCond(clazz.getClass(), condition);
		if(col!=null && col.size()>0){
			return true;
		}
		
		return false;
	}
}
