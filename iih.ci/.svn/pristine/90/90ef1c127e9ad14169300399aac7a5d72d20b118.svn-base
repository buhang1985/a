package iih.ci.mr.s.bp.write;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import iih.ci.mr.pub.mrutil.stringoper.StringOperUtil;
import iih.ci.mrm.dto.cimrmmacrovaluedto.d.CiMrmMacroValueDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapListHandler;

public class MrWriteMacroBP {
	/**
	 * 宏元素自定义节点数据调用查询方法
	 * @param id_ent
	 * @param id_type
	 * @param arrMacroCodes
	 * @return
	 * @throws BizException
	 * @throws SQLException
	 */
	public FMap2 getMacroResultMap(String id_ent, String sd_type,String[] arrMacroCodes) throws BizException, SQLException {
		FMap2 MacroResultMap = new FMap2();
		// 拼接条件，查询宏元素自定义表
		StringBuilder sqlWhere1 = new StringBuilder();
		sqlWhere1.append(" where bd_marco_value.sd_type = '");
		sqlWhere1.append(sd_type);
		sqlWhere1.append("'  and bd_marco_value.fg_active = 'Y' and bd_mr_de.id_mr_de is not null");		
		// 调用sql方法
		StringBuilder sqlSB = getCiMrmMacroValueDTOSql(sqlWhere1.toString());
		String sqlMacroCodes =  StringOperUtil.arrayStringJoin(arrMacroCodes, ",","'","'");
		sqlSB.append(" and bd_de.code in ("+sqlMacroCodes+")");
		sqlSB.append(" order by name_table ");
		String sqlStr = sqlSB.toString();
		// 查询结果集，开始拼接sql
		DAFacade daf1 = new DAFacade();
		List<CiMrmMacroValueDTO> MacroValueDTOList = 
				(List<CiMrmMacroValueDTO>) daf1.execQuery(sqlStr, new BeanListHandler(CiMrmMacroValueDTO.class));
		
		if (MacroValueDTOList == null || MacroValueDTOList.size() <= 0) {
			return new FMap2();
		}
		// key：code_de/value：name_column
		Map<String, String> nameColumnMap = new HashMap<String, String>();
		
		int num = 0;
		for (int i = 0; i < MacroValueDTOList.size(); i++) {		
			CiMrmMacroValueDTO macroValueDo = MacroValueDTOList.get(i);
			// 如果此条数据未启用，跳过
			if (macroValueDo.getFg_active().equals("N")) {
				continue;
			}
			// 获取结果集中的第一个对象，开始拼接sql
			StringBuilder sqlWhere2 = new StringBuilder();
			sqlWhere2.append(" select ");
			sqlWhere2.append(macroValueDo.getName_column());
			nameColumnMap.put(macroValueDo.getCode_de(), macroValueDo.getName_column());
			
			for (int j = i+1; j < MacroValueDTOList.size(); j++) {
				// 如果此条数据未启用，跳过
				if (MacroValueDTOList.get(j).getFg_active().equals("N")) {
					continue;
				}
				// 前一个对象的Name_table与后一个对象的Name_table比较，来确定是否是用于同一组查询的数据
				if (!MacroValueDTOList.get(i).getName_table().equals(MacroValueDTOList.get(j).getName_table())) {
					num = i;
					i = j - 1;// 控制i的数值，让i从每一组的第一个开始循环
					break;
				}
				// 拼接同组sql的查询字段，直到出现新的一组数据停止当前这组的循环
				sqlWhere2.append(" , ");
				sqlWhere2.append(MacroValueDTOList.get(j).getName_column());
				nameColumnMap.put(MacroValueDTOList.get(j).getCode_de(), MacroValueDTOList.get(j).getName_column());
			}
			// 当前组的查询字段的拼接完成，将完整的sql先add到集合中
			sqlWhere2.append(" from ");
			sqlWhere2.append(MacroValueDTOList.get(num).getName_table());
			sqlWhere2.append(" '");
			sqlWhere2.append(id_ent);
			sqlWhere2.append("' ");
			String sql = sqlWhere2.toString();
			// 通过最终拼接的sql查询，将查询数据封装到Map中返回给前台
			DAFacade daf2 = new DAFacade();
			List<Map<String, Object>> resultList = (List<Map<String, Object>>) daf2.execQuery(sql, new MapListHandler());
			List<Map<String,Object>> newResultList = new ArrayList<Map<String,Object>>();
			for (Map<String, Object> map : resultList) {
				Map<String, Object> newMap = new HashMap<String, Object>();
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					newMap.put(entry.getKey().toLowerCase(), entry.getValue());
				}
				newResultList.add(newMap);
			}
			for (Map<String, Object> resultMap : newResultList) {
				Set<Entry<String,String>> entrySet = nameColumnMap.entrySet();
				
				for (Entry<String, String> entry : entrySet) {
					if(entry==null||entry.getValue()==null)
					{
						continue;						
					}
					String columnValue = entry.getValue().toLowerCase().replace(" ", "");	
					if(columnValue.contains("."))
					{
						columnValue = columnValue.substring(columnValue.indexOf(".")+1);
					}
					if(entry==null||entry.getKey()==null)
					{
						continue;
					}
					String key = entry.getKey();
					Object obj = resultMap.get(columnValue);
					String value = "";
					if(obj!=null)
					{
						value= obj.toString();
						MacroResultMap.put(key, value);			
					}
				}
			}
			num = i + 1;
			nameColumnMap.clear();// 重置sql的查询数据
		}
		return MacroResultMap;
	}
	/**
	 * getMacroResultMap方法查询sql
	 * @param 查询条件
	 * @return sql
	 */
	private StringBuilder getCiMrmMacroValueDTOSql(String sqlWhere1) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select bd_marco_value.id_marco_value as id_marco_value, ");// 宏元素主键
		sql.append(" bd_marco_value.id_grp as id_grp, ");// 所属集团
		sql.append(" bd_marco_value.id_org as id_org, ");// 所属组织
		sql.append(" bd_marco_value.id_type as id_type, ");// 宏元素自定义主键
		sql.append(" bd_marco_value.sd_type as sd_type, ");// 宏元素自定义编码
		sql.append(" bd_marco_value.name_type as name_type, ");// 宏元素自定义名称
		sql.append(" bd_marco_value.id_mr_de as id_mr_de, ");// 病历元素主键
		sql.append(" bd_marco_value.sd_mr_de as sd_mr_de, ");// 病历元素编码
		sql.append(" bd_marco_value.name_mr_de as name_mr_de, ");// 病历元素名称
		sql.append(" bd_marco_value.name_table as name_table, ");// 表名
		sql.append(" bd_marco_value.name_column as name_column, ");// 字段名
		sql.append(" bd_marco_value.fg_active as fg_active, ");// 是否启用
		sql.append(" bd_de.code as code_de ");// 公共数据元编码
		sql.append(" from bd_marco_value ");
		sql.append(" left join bd_mr_de bd_mr_de ");
		sql.append(" on bd_marco_value.id_mr_de = bd_mr_de.id_mr_de ");
		sql.append(" left join bd_de bd_de ");
		sql.append(" on bd_mr_de.id_de = bd_de.id_de ");
		sql.append(sqlWhere1);
		
		return sql;
	}
}
