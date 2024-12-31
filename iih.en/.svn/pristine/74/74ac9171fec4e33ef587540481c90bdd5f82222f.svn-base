package iih.en.pv.s.mvelextmethod;

import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.LvCheckOtherResultDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mvel2.MVEL;
import org.mvel2.ParserContext;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

import com.ymer.designer.scripteditor.MvelExtMethod;

/**
 * 就诊住院出院转科检查扩展规则
 * 
 * @author liubin
 *
 */
public class EnIpLvTransCheckMvelExtMethod implements MvelExtMethod {

	@Override
	public String getClazzDesc() {
		return "就诊住院出院转科检查扩展规则";
	}

	@Override
	public Map<String, String> getMethodParamsDesc() {
		Map<String, String> descs = new HashMap<String, String>();
		descs.put("assemlyResults", "组装出院转科检查扩展规则返回结果，param1[1-禁止  2-提示]，param2[问题描述]，param3[需要提示的就诊Id集合]");
		descs.put("getInSqlByIds", "根据ids和查询字段生成in条件语句，param1[查询字段名]，param2[字符串集合]");
		descs.put("getEntIdsBySql", "获取就诊id集合，param1[sql语句]");
//		descs.put("getNoTransDepSummary", "获取就诊id集合，param1[转科患者dto集合]");
		return descs;
	}

	@Override
	public Map<String, String> getReturnTypes() {
		Map<String, String> returnTypes = new HashMap<String, String>();
		returnTypes.put("assemlyResults", LvCheckOtherResultDTO[].class.getName());
		returnTypes.put("getInSqlByIds", String.class.getName());
		returnTypes.put("getEntIdsBySql", String.class.getName());
//		returnTypes.put("getNoTransDepSummary", String.class.getName());
		return returnTypes;
	}

	@Override
	public void importMethod(ParserContext ctx) {
		ctx.addImport("assemlyResults", MVEL.getStaticMethod(
				EnIpLvTransCheckMvelExtMethod.class, "assemlyResults",
				new Class[] { String.class, String.class, String[].class }));
		ctx.addImport("getInSqlByIds", MVEL.getStaticMethod(
				EnIpLvTransCheckMvelExtMethod.class, "getInSqlByIds",
				new Class[] { String.class, String[].class }));
		ctx.addImport("getEntIdsBySql", MVEL.getStaticMethod(
				EnIpLvTransCheckMvelExtMethod.class, "getEntIdsBySql",
				new Class[] { String.class}));
//		ctx.addImport("getNoTransDepSummary", MVEL.getStaticMethod(
//				EnIpLvTransCheckMvelExtMethod.class, "getNoTransDepSummary",
//				new Class[] { TransDepPatDTO[].class}));
	}
	/**
	 * 组装规则返回结果
	 * 
	 * @param problem_type 问题类型  1-禁止  2-提示
	 * @param msg 问题描述
	 * @param idEnts 需要提示的就诊Id集合
	 * @return
	 */
	public static LvCheckOtherResultDTO[] assemlyResults(String problem_type, String msg, String[] idEnts){
		if(EnValidator.isEmpty(idEnts))
			return null;
		List<LvCheckOtherResultDTO> lvCheckOtherResults = new ArrayList<>(idEnts.length);
		for(String idEnt : idEnts){
			LvCheckOtherResultDTO lvCheckOtherResult = new LvCheckOtherResultDTO();
			lvCheckOtherResult.setId_ent(idEnt);
			lvCheckOtherResult.setProblem_type(problem_type);
			lvCheckOtherResult.setDesc(msg);
			lvCheckOtherResults.add(lvCheckOtherResult);
		}
		return lvCheckOtherResults.toArray(new LvCheckOtherResultDTO[lvCheckOtherResults.size()]);
	}
	/**
	 * 获取就诊id集合
	 * 
	 * @param sql
	 * @return
	 * @throws BizException
	 */
	public static String[] getEntIdsBySql(String sql) throws BizException{
		if(EnValidator.isEmpty(sql))
			return null;
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) new DAFacade().execQuery(sql, new ColumnListHandler());
		return EnValidator.isEmpty(list) ? null : list.toArray(new String[list.size()]);
	}
	
	/**
	 * 根据ids和查询字段生成in条件语句
	 * @param fieldName 查询字段名
	 * @param ids id字符串集合
	 * @return in查询语句
	 */
	public static String getInSqlByIds(String fieldName, String[] ids) {
		return EnSqlUtils.getInSqlByIds(fieldName, ids);
	}
	/**
	 * 调用病历接口查转科时是否有出院小结
	 * @param dtos
	 * @return
	 * @throws BizException 
	 */
//	public static String[] getNoTransDepSummary(TransDepPatDTO[] dtos) throws BizException{
//		ICiMrOutQryServices mrServices = ServiceFinder.find(ICiMrOutQryServices.class);
//		//return mrServices.getPatDeathByIdPat(idPat)
//	}
}
