package iih.ci.mrm.s.healthsystem.bp;

import iih.ci.mrm.healthsystem.d.DocContrastDO;
import iih.ci.mrm.healthsystem.d.FieldContrastDO;
import iih.ci.mrm.healthsystem.d.ValueContrastDetailDO;
import iih.ci.mrm.healthsystem.i.IDocContrastDORService;
import iih.ci.mrm.healthsystem.i.IHealthsystemfieldMDORService;
import iih.ci.mrm.healthsystem.i.IValueContrastDetailDORService;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.dbutils.handlers.MapListHandler;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.i.IBaseDO;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

public class HealthSystemDataConvertDOBp {
	public List<Object> getArrayListDataWithDO(BaseDO obj, String id_doc_comparison, String[] id_ents,String identform) throws BizException {
		// 根据表转换id查询任务信息
		IDocContrastDORService docRService = ServiceFinder.find(IDocContrastDORService.class);
		IHealthsystemfieldMDORService fieldRService = ServiceFinder.find(IHealthsystemfieldMDORService.class);
		
		DocContrastDO docContrastDO = docRService.findById(id_doc_comparison);
		FieldContrastDO[] fieldContrastDOs = fieldRService.find(" id_doc_comparison = '" + id_doc_comparison + "' ", " tablename_source ", FBoolean.FALSE);
		// 用于封装返回的DO/DTO类型的数据
		List<Object> resultList = new ArrayList<Object>();
		// 用于存储查询的KV数据集
		Map<String, List<Map<String, Object>>> queryMap = new HashMap<String, List<Map<String, Object>>>();
		// 用于接收反射获取的Class对象
		Class<?> doClass = null;
		
		if (docContrastDO == null) {
			return new ArrayList<Object>();
		}
		queryMap = dataChangeService(docContrastDO, id_ents,identform);
		
		Method[] methods = doClass.getMethods();
		// 外层Map
		Set<Entry<String,List<Map<String, Object>>>> entrySet = queryMap.entrySet();
		
		for (Entry<String, List<Map<String, Object>>> entry : entrySet) {
			String idEnt = entry.getKey();
			for(Map<String, Object> dataMap :entry.getValue())
			{
				//Map<String, Object> dataMap = entry.getValue();
				// 用于接收反射获取的类对象
				
				// 			
				for (FieldContrastDO fieldContrastDO : fieldContrastDOs) {
					String fieldname_source = fieldContrastDO.getFieldname_source();// 源字段名称
					String str1 = fieldContrastDO.getFieldname_goal().toLowerCase();// 目标字段名称
					// 如果源字段或者目标字段为null，则跳过此字段的匹配
					if (fieldname_source == null || str1 == null) {
						continue;
					}
					
					String str2 = str1.substring(0, 1).toUpperCase();
					String str3 = str1.substring(1, str1.length());
					String fieldname_goal = "set" + str2 + str3;
					String fieldtype_source = fieldContrastDO.getFieldtype_source();// 源字段类型
					String fieldtype_goal = fieldContrastDO.getFieldtype_goal();// 目标字段类型
					
					// 内层Map
					Set<Entry<String,Object>> dataEntrySet = dataMap.entrySet();
					BaseDO newInstance = (BaseDO)obj.clone();
					for (Entry<String, Object> dataEntry : dataEntrySet) {
						
						// 获取字段名及对应值
						String key = dataEntry.getKey().toLowerCase();
						Object value = dataEntry.getValue();
						
						
						newInstance.setAttrVal(key, value);
						
							
						
					}
					// 内层Map循环完成后，将封装好的DO/DTO数据add到result集合中
					resultList.add(newInstance);
				}
				
			}
			
		}
		return resultList;
	}
	
	public Map<String, List<Map<String, Object>>> getMapDataWithDO(BaseDO obj, String id_doc_comparison, String[] id_ents,String identform) throws BizException{
		// 根据表转换id查询任务信息
				IDocContrastDORService docRService = ServiceFinder.find(IDocContrastDORService.class);
				IHealthsystemfieldMDORService fieldRService = ServiceFinder.find(IHealthsystemfieldMDORService.class);
				
				DocContrastDO docContrastDO = docRService.findById(id_doc_comparison);
				FieldContrastDO[] fieldContrastDOs = fieldRService.find(" id_doc_comparison = '" + id_doc_comparison + "' ", " tablename_source ", FBoolean.FALSE);
				// 用于存储查询的KV数据集
				Map<String, List<Map<String, Object>>> queryMap = new HashMap<String, List<Map<String, Object>>>();

				queryMap = dataChangeService(docContrastDO, id_ents,identform);
				return queryMap;
	}
	private Map<String, List<Map<String, Object>>> dataChangeService(DocContrastDO paramDo, String[] idEnts,String identform) throws BizException {
		// 服务定义
		IHealthsystemfieldMDORService fieldRService = ServiceFinder.find(IHealthsystemfieldMDORService.class);
		IValueContrastDetailDORService valuedetailRService = ServiceFinder.find(IValueContrastDetailDORService.class);
		// 用于封装返回的结果集
		Map<String, List<Map<String, Object>>> resultMap = new HashMap<String, List<Map<String, Object>>>();
		// 用于存储拼接好的SQL
		List<String> sqlList = new ArrayList<String>();
		// 用于存储每个字段对应的对照信息
		Map<String, ValueContrastDetailDO[]> comparsionMap = new HashMap<String, ValueContrastDetailDO[]>();
		// 用于封装抽取数据
		List<Map<String, Object>> dataMap = new ArrayList<Map<String, Object>>();
		// 用于拼接查询SQL
		StringBuilder sb = new StringBuilder();
		sb.append(" select ");

		String id_doc_comparison = paramDo.getId_doc_comparison();// 表转换id
		// 根据表转换主键查询字段转换数据
		FieldContrastDO[] fieldContrastDOs = 
				fieldRService.find(" id_doc_comparison = '" + id_doc_comparison + "' ", " tablename_source ", FBoolean.FALSE);
		
		if (fieldContrastDOs == null || fieldContrastDOs.length <= 0)
			return new HashMap<String, List<Map<String, Object>>>();
		
		// 用于记录表名
		String tableName = "";
		// 用于拼接查询字段
		StringBuilder sbField = new StringBuilder();
		// 循环拼接查询SQL，并封装
		for (int j = 0; j < fieldContrastDOs.length; j++) {
			String tablename_source = fieldContrastDOs[j].getTablename_source();// 表
			String fieldname_source = fieldContrastDOs[j].getFieldname_source();// 源字段
			String fieldname_target = fieldContrastDOs[j].getFieldname_goal();// 目标字段
			String transform_mode = fieldContrastDOs[j].getTransform_mode();// 转换方式
			String id_value_comparison = fieldContrastDOs[j].getId_value_comparison();// 对照参照id
			// 如果查询的字段为null，则跳过此次循环
			if (fieldname_target == null || "".equals(fieldname_target)) {
				// 如果最后一个字段为null，则需要完成SQL拼接
				if (j == fieldContrastDOs.length - 1) {
					String field = sbField.toString().substring(0, sbField.length() - 2);
					sb.append(field);
					sb.append(" from ");
					sb.append(tableName);
					sb.append(" where 1 = 1 ");
					
					sqlList.add(sb.toString());
				}
				continue;
			}
			
			if ("1".equals(transform_mode)) {
				// 查询使用的对照信息并封装
				ValueContrastDetailDO[] valueContrastDetailDOs = 
						valuedetailRService.find(" id_value_comparison = '" + id_value_comparison + "' ", "", FBoolean.FALSE);
				comparsionMap.put(fieldname_target, valueContrastDetailDOs);
			}
			
			if ("".equals(tableName)) {
				tableName = tablename_source;
				sbField.append(fieldname_source+" as "+fieldname_target + ", ");
			} else {
				if (tableName.equals(tablename_source)) {
					sbField.append(fieldname_source+" as "+fieldname_target + ", ");
					
					if (j == fieldContrastDOs.length - 1) {
						// 拼接并储存查询SQL
						String field = sbField.toString().substring(0, sbField.length() - 2);
						sb.append(field);
						sb.append(" from ");
						sb.append(tableName);
						sb.append(" where 1 = 1 ");
						
						sqlList.add(sb.toString());
					}
				} else {
					// 拼接并储存查询SQL
					String field = sbField.toString().substring(0, sbField.length() - 2);
					sb.append(field);
					sb.append(" from ");
					sb.append(tableName);
					sb.append(" where 1 = 1 ");
					
					sqlList.add(sb.toString());
					// 重新赋值表名，重新拼接查询字段
					tableName = tablename_source;
					sbField.delete(0, sbField.length());
					sbField.append(fieldname_target + ", ");
					sb.delete(0, sb.length());
					sb.append(" select ");
				}
			}
		}
		
		if (idEnts == null || idEnts.length <= 0)
			return new HashMap<String, List<Map<String, Object>>>();
		
		if(sqlList.size() == 1)
		{
			// 执行查询和数据转换
			for (String idEnt : idEnts) {
				for (String sql : sqlList) {
					// 根据id_ent拼接查询调节
					String sqlWhere = sql + " and "+identform+".id_ent = '" + idEnt + "' ";
					List<Map<String, Object>> map = checkAndMergeData(sqlWhere, comparsionMap);		
					resultMap.put(idEnt, map);
				}
				
			}
		}
		
		
		return resultMap;
	}

	/**
	 * 查询并根据对照信息转换数据
	 * @param sqlStr：查询SQL
	 * @param comparsionMap：对照信息map集合
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<Map<String, Object>> checkAndMergeData(String sqlStr, Map<String, ValueContrastDetailDO[]> comparsionMap) throws BizException {
		DAFacade daf = new DAFacade();
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		// 查询
		List<Map<String, Object>> sourceList = (List<Map<String, Object>>) daf.execQuery(sqlStr, new MapListHandler());
		
		for (Map<String, Object> map : sourceList) {
			Map<String, Object> resmap = new HashMap<String, Object>();
			Set<Entry<String, Object>> entrySet = map.entrySet();
			Set<Entry<String,ValueContrastDetailDO[]>> comparsionEntrySet = comparsionMap.entrySet();
			
			for (Entry<String, Object> entry : entrySet) {
				String sourceKey = entry.getKey();
				Object sourceValue = entry.getValue();
				// 用于判断是否需要数据转换
				boolean isSameKey = true;
				
				for (Entry<String, ValueContrastDetailDO[]> comparsionEntry : comparsionEntrySet) {
					String comparsionKey = comparsionEntry.getKey();
					// 字段转换方式匹配
					if (sourceKey.equalsIgnoreCase(comparsionKey)) {
						ValueContrastDetailDO[] comparsionValue = comparsionEntry.getValue();
						// 用于判断是否转换了数据
						boolean isHasValue = true;
						
						for (ValueContrastDetailDO valueContrastDetailDO : comparsionValue) {
							String code_source = valueContrastDetailDO.getCode_source();
							// 匹配对照编码
							if (sourceValue != null && code_source != null && sourceValue.equals(code_source)) {
								resmap.put(sourceKey, valueContrastDetailDO.getCode_goal());
								isHasValue = true;
								break;
							}else {
								isHasValue = false;
							}
						}
						
						if (isHasValue) {
							isSameKey = true;
							break;
						} else {
							isSameKey = false;
						}
					} else {
						isSameKey = false;
					}
				}
				// 如果未进行转换，则直接赋值原来的数据
				if (!isSameKey) {
					resmap.put(sourceKey, sourceValue);
				}
			}
			resultList.add(resmap);
		}
		return resultList;
	}

	/**
	 * 根据查询字段和查询条件拼接条件SQL
	 * @param field 查询条件字段
	 * @param fieldArray 查询条件数组
	 * @return and field in (...)
	 */
	private String changeArrToSqlWhereStr(String field, String[] fieldArray) {
		// 用于封装查询条件
		StringBuilder sb = new StringBuilder();
		sb.append(" and ");
		sb.append(field);
		sb.append(" in (");
		// 用于封装条件字段
		StringBuilder fieldSb = new StringBuilder();
		
		for (int i = 0; i < fieldArray.length; i++) {
			fieldSb.append(" '");
			fieldSb.append(fieldArray[i]);
			fieldSb.append("', ");
		}
		String fieldStr = fieldSb.toString().substring(0, fieldSb.toString().length() - 2);
		sb.append(fieldStr);
		sb.append(") ");
		
		return sb.toString();
	}
}
