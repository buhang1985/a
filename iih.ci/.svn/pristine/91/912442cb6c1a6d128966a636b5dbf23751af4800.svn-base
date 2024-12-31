package iih.ci.sdk.ems.rules;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mvel2.MVEL;
import org.mvel2.ParserContext;

import com.ymer.designer.scripteditor.MvelExtMethod;

import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 临床出院医嘱校验规则-注册函数
 * @author mkp
 *
 */
public class CiIpOutHospOrdRuleCheck implements MvelExtMethod{

	/**
	 * 类描述
	 */
	@Override
	public String getClazzDesc() {
		return "临床出院医嘱校验规则-注册函数定义";
	}

	/**
	 * 方法的参数明细
	 */
	@Override
	public Map<String, String> getMethodParamsDesc() {
		Map<String, String> desc = new HashMap<String, String>();
		desc.put("getCountBySql", String.class.getName());
		desc.put("getSqlStr", String.class.getName());
		return desc;
	}

	/**
	 * 方法的返回类型
	 */
	@Override
	public Map<String, String> getReturnTypes() {
		Map<String, String> returnTypes = new HashMap<String, String>();
		returnTypes.put("getCountBySql", Integer.class.getName());
		returnTypes.put("getSqlStr", String.class.getName());
		return returnTypes;
	}

	/**
	 * 导入方法
	 */
	@Override
	public void importMethod(ParserContext ctx) {
		ctx.addImport("getCountBySql", MVEL.getStaticMethod(CiIpOutHospOrdRuleCheck.class, "getCountBySql", new Class[] { String.class }));
		ctx.addImport("getSqlStr", MVEL.getStaticMethod(CiIpOutHospOrdRuleCheck.class, "getSqlStr", new Class[] { String.class }));
	}
	
	/**
	 * 组装sql中的字符串
	 * @param id_ent
	 * @return
	 */
	public static String getSqlStr(String id_ent) {
		return "'" + id_ent + "'";
	}
	
	/**
	 * 查询符合sql条件的行数
	 * @param sql
	 * @return
	 * @throws DAException 
	 */
	public static Integer getCountBySql(String sql) throws DAException {
		List<Integer> list = (List<Integer>) new DAFacade().execQuery(sql, new ColumnListHandler());
		if (list.size() == 0 || list == null) {
			return -1;
		} else {
			return list.get(0);
		}
	}
}
