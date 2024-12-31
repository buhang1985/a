package iih.ci.mrm.s.healthsystem;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.dbutils.handlers.MapListHandler;

import iih.ci.mrm.healthsystem.d.DocContrastDO;
import iih.ci.mrm.healthsystem.d.FieldContrastDO;
import iih.ci.mrm.healthsystem.d.ValueContrastDetailDO;
import iih.ci.mrm.healthsystem.i.IDocContrastDORService;
import iih.ci.mrm.healthsystem.i.IHealthsystemfieldMDORService;
import iih.ci.mrm.healthsystem.i.IValueContrastDetailDORService;
import iih.ci.mrm.i.healthsystem.IHealthSystemCrudService;
import iih.ci.mrm.s.healthsystem.bp.HealthSystemDataConvertDOBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FTime;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

@Service(serviceInterfaces={IHealthSystemCrudService.class}, binding=Binding.JSONRPC)
public class IHealthSystemCrudServiceImpl implements IHealthSystemCrudService {
	
	@Override
	public Map<String, List<Map<String, Object>>> getChangeDataWithMap(String id_doc_comparison, String[] id_ents, String idEntForm) throws BizException {
		// 根据表转换id查询任务信息
		IDocContrastDORService docRService = ServiceFinder.find(IDocContrastDORService.class);
		DocContrastDO docContrastDO = docRService.findById(id_doc_comparison);
		
		if (docContrastDO != null) {
			return dataChangeService(docContrastDO, id_ents, idEntForm);
		} else {
			return new HashMap<String, List<Map<String, Object>>>();
		}
	}

	@Override
	public List<Object> getChangeDataWithDO(String fullClassName, String id_doc_comparison, String[] id_ents, String idEntForm) throws BizException {
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
		queryMap = dataChangeService(docContrastDO, id_ents, idEntForm);
		
		try {
			doClass = Class.forName(fullClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if (doClass == null) {
			return resultList;
		}
		Method[] methods = doClass.getMethods();
		// 外层Map
		Set<Entry<String, List<Map<String, Object>>>> entrySet = queryMap.entrySet();
		
		for (Entry<String, List<Map<String, Object>>> entry : entrySet) {
			//String idEnt = entry.getKey();
			List<Map<String, Object>> dataList = entry.getValue();
			// 用于接收反射获取的类对象
			Object newInstance = new Object();
			
			for (Map<String, Object> dataMap : dataList) {
				try {
					newInstance = doClass.newInstance();
				} catch (Exception e) {
					e.printStackTrace();
				}
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
					
					for (Entry<String, Object> dataEntry : dataEntrySet) {
						// 获取字段名及对应值
						String key = dataEntry.getKey().toLowerCase();
						Object value = dataEntry.getValue();
						// 如果配置的源字段名使用了别名，则只取别名部分
						if (fieldname_source.contains(" as ")) {
							String[] fieldArr = fieldname_source.split(" as ");
							fieldname_source = fieldArr[fieldArr.length - 1];
						}
						// 匹配源_字段的名称
						if (fieldname_source.equals(key)) {
							// 根据字段类型信息判断是否需要转换字段类型
							if (value != null) {
								if ("30".equals(fieldtype_goal)) {// 字符
									value = value.toString();
								}
								if ("22".equals(fieldtype_goal)) {// 浮点
									if ("22".equals(fieldtype_source)) {
										value = new FDouble(value.toString());
									}
									if ("21".equals(fieldtype_source)) {
										value = new FDouble(value.toString());
									}
									if ("30".equals(fieldtype_source)) {
										value = new FDouble(value.toString());
									}
								}
								if ("21".equals(fieldtype_goal)) {// 整数
									if ("21".equals(fieldtype_source)) {
										value = Integer.valueOf(value.toString());
									}
									if ("30".equals(fieldtype_source)) {
										value = Integer.valueOf((String)value);
									}
								}
								if ("12".equals(fieldtype_goal)) {// 时间
									if ("12".equals(fieldtype_source)) {
										value = new FTime(value.toString());
									}
									if ("11".equals(fieldtype_source)) {
										long millis = ((FDate)value).getMillis();
										value = new FTime(millis);
									}
									if ("10".equals(fieldtype_source)) {
										long millis = ((FDateTime)value).getMillis();
										value = new FTime(millis);
									}
								}
								if ("11".equals(fieldtype_goal)) {// 日期
									if ("11".equals(fieldtype_source)) {
										value = new FDate(value.toString());
									}
									if ("12".equals(fieldtype_source)) {
										long millis = ((FTime)value).getMillis();
										value = new FTime(millis);
									}
									if ("10".equals(fieldtype_source)) {
										long millis = ((FDateTime)value).getMillis();
										value = new FTime(millis);
									}
								}
								if ("10".equals(fieldtype_goal)) {// 日期时间
									if ("10".equals(fieldtype_source)) {
										value = new FDateTime(value.toString());
									}
									if ("12".equals(fieldtype_source)) {
										long millis = ((FTime)value).getMillis();
										value = new FTime(millis);
									}
									if ("11".equals(fieldtype_source)) {
										long millis = ((FDate)value).getMillis();
										value = new FTime(millis);
									}
								}
							}
//							if (!fieldtype_source.equals(fieldtype_goal)) {
//								
//							}
							// 遍历反射获取的类的方法，与目标字段的名称进行匹配，目的是用维护的目标字段进行赋值
							for (Method method : methods) {
								String methodName = method.getName();
								// 将目标字段名与set方法进行匹配，并将value赋值给对应的字段
								try {
									if (fieldname_goal.equals(methodName)) {
										method.invoke(newInstance, value);
									}
								} catch (Exception e) {
									System.out.println(fieldname_goal);
									e.printStackTrace();
								}
							}
						}
					}
				}
				// 内层Map循环完成后，将封装好的DO/DTO数据add到result集合中
				resultList.add(newInstance);
			}
		}
		return resultList;
	}
	
	/**
	 * 
	 * @param paramDo
	 * @param idEnts
	 * @param idEntForm
	 * @return
	 * @throws BizException
	 */
	private Map<String, List<Map<String, Object>>> dataChangeService(DocContrastDO paramDo, String[] idEnts, String idEntForm) throws BizException {
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
		List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
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
			String transform_mode = fieldContrastDOs[j].getTransform_mode();// 转换方式
			String id_value_comparison = fieldContrastDOs[j].getId_value_comparison();// 对照参照id
			// 如果查询的字段为null，则跳过此次循环
			if (fieldname_source == null || "".equals(fieldname_source)) {
				// 如果最后一个字段为null，则需要完成SQL拼接
				if (j == fieldContrastDOs.length - 1) {
					String field = sbField.toString().substring(0, sbField.length() - 2);
					sb.append(field);
					sb.append(" from ");
					sb.append(tableName);
					// 如果维护的表信息中，没有设置where条件，则自动添加where语句
					if (!tableName.contains(" where ")) {
					sb.append(" where 1 = 1 ");
					}
					sqlList.add(sb.toString());
				}
				continue;
			}
			// 如果选择了值对照，查询值对照信息，用于匹配并转换数据
			if ("1".equals(transform_mode)) {
				// 查询使用的对照信息并封装
				ValueContrastDetailDO[] valueContrastDetailDOs = 
						valuedetailRService.find(" id_value_comparison = '" + id_value_comparison + "' ", "", FBoolean.FALSE);
				comparsionMap.put(fieldname_source, valueContrastDetailDOs);
			}
			
			if ("".equals(tableName)) {
				tableName = tablename_source;
				sbField.append(fieldname_source + ", ");
			} else {
				if (tableName.equals(tablename_source)) {
					sbField.append(fieldname_source + ", ");
				} else {
					// 拼接并储存查询SQL
					String field = sbField.toString().substring(0, sbField.length() - 2);
					sb.append(field);
					sb.append(" from ");
					sb.append(tableName);
					// 如果维护的表信息中，没有设置where条件，则自动添加where语句
					if (!tableName.contains(" where ")) {
					sb.append(" where 1 = 1 ");
					}
					sqlList.add(sb.toString());
					// 重新赋值表名，重新拼接查询字段
					tableName = tablename_source;
					sbField.delete(0, sbField.length());
					sbField.append(fieldname_source + ", ");
					sb.delete(0, sb.length());
					sb.append(" select ");
				}
			}
			// 如果最后一个字段为null，则需要完成SQL拼接
			if (j == fieldContrastDOs.length - 1) {
				String field = sbField.toString().substring(0, sbField.length() - 2);
				sb.append(field);
				sb.append(" from ");
				sb.append(tableName);
				// 如果维护的表信息中，没有设置where条件，则自动添加where语句
				if (!tableName.contains(" where ")) {
				sb.append(" where 1 = 1 ");
				}
				sqlList.add(sb.toString());
			}
		}
		
		Logger.error("********** SQL拼接并封装完成，开始循环执行查询 **********");
		
		if (idEnts == null || idEnts.length <= 0)
			return new HashMap<String, List<Map<String, Object>>>();
		// 执行查询和数据转换
		for (String idEnt : idEnts) {
			// 用于封装map数据
			Map<String, Object> lastMap = new HashMap<String, Object>();
			int listSize = 0;
			
			for (String sql : sqlList) {
				// 根据id_ent拼接查询调节
				String sqlWhere = sql + " and " + idEntForm + ".id_ent = '" + idEnt + "' ";
				
				Logger.error("**** 待执行SQL ****");
				Logger.error(sqlWhere);
				Logger.error(" ");
				
				List<Map<String, Object>> mapList = checkAndMergeData(sqlWhere, comparsionMap);
				listSize = mapList.size();
				
				for (Map<String, Object> map : mapList) {
					Set<Entry<String,Object>> entrySet = map.entrySet();

					for (Entry<String, Object> entry : entrySet) {
						String key = entry.getKey();
						Object value = entry.getValue();
						lastMap.put(key, value);
					}
					// 如果是多条数据暂定为手术或者诊断的数据
					if (listSize > 1) {
						dataList.add(lastMap);
						lastMap = new HashMap<String, Object>();
					}
				}
			}
			// 如果是单条数据暂定为基本信息的数据
			if (listSize <= 1) {
				dataList.add(lastMap);
			}
			resultMap.put(idEnt, dataList);
		}
		
		Logger.error("********** 循环查询执行结束 **********");
		
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
			Set<Entry<String, Object>> entrySet = map.entrySet();
			Set<Entry<String,ValueContrastDetailDO[]>> comparsionEntrySet = comparsionMap.entrySet();
			Map<String, Object> resultMap = new HashMap<String, Object>();
			
			for (Entry<String, Object> entry : entrySet) {
				String sourceKey = entry.getKey();
				Object sourceValue = entry.getValue();
				// 用于判断是否需要数据转换
				boolean isSameKey = false;
				
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
								resultMap.put(sourceKey, valueContrastDetailDO.getCode_goal());
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
					resultMap.put(sourceKey, sourceValue);
				}
			}
			resultList.add(resultMap);
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
	
	@Override
	public Map<String, List<Map<String, Object>>> getMapWithSigleForm(BaseDO obj,String id_doc_comparison, String[] id_ents,String idEntForm) throws BizException {
		HealthSystemDataConvertDOBp bp = new HealthSystemDataConvertDOBp();
		return bp.getMapDataWithDO(obj,id_doc_comparison, id_ents,idEntForm);
	}

	@Override
	public List<Object> getArrayListWithSigleForm(BaseDO obj,
			String id_doc_comparison, String[] id_ents,String idEntForm) throws BizException {
		HealthSystemDataConvertDOBp bp = new HealthSystemDataConvertDOBp();
		return bp.getArrayListDataWithDO( obj, id_doc_comparison, id_ents, idEntForm);
	}

	
}
