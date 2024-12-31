package iih.ci.ord.s.bp.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.ci.ord.i.mqmsg.meta.IMQMsgTypeConst;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.message.message.i.IGenerateMessageExtdService;
/**
 * 
 * @author F
 *
 * @date 2020年2月13日下午5:23:17
 *
 * @classpath iih.ci.ord.s.bp.task.UnDiagSignTask
 */
public class UnDiagSignTask implements IBackgroundWorkPlugin{

	/**
	 * 0155529: 如果病人在入院三天后，没有医生签署的入院诊断，自动提示需要进行会诊流程。
	 */
	@Override
	public PreAlertObject executeTask(BgWorkingContext var1) throws BizException {
		Long startTime = System.currentTimeMillis();
		//查询满足条件的数据-住院的 三天没有诊断签署的
		List<Map<String, Object>> maps=selectData();
		//构建数据结构
		Map<String, List<String>> map=constructData(maps);
		//发送消息
		fireData(map);
		Long endTime = System.currentTimeMillis();
		System.out.println("时间:"+(endTime-startTime));
		return null;
	}
	private List<Map<String, Object>> selectData() throws BizException{
		//查询sql
		String sqlString=getSelectSql();
		//查询参数
		SqlParam sqlParam=getSelectParam();
		//查询结果
		List<Map<String, Object>> maps=getResultMapList(sqlString,sqlParam);
		return maps;
	}
	private String getSelectSql()throws BizException{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" select ");
		stringBuilder.append(" a.name_pat, ");//--患者姓名
		stringBuilder.append(" a.id_emp_phy, ");//--主治医师id
		stringBuilder.append(" c.name, ");//--主治医师姓名
		stringBuilder.append(" a.id_dep_phy, ");//--科室id
		stringBuilder.append(" d.name, ");//--科室姓名
		stringBuilder.append(" e.name_bed, ");//--床号
		stringBuilder.append(" f.code_amr_ip, ");//--住院号
		stringBuilder.append(" a.dt_acpt ");//--入科时间
		stringBuilder.append(" from en_ent a ");
		stringBuilder.append(" left join ci_di b on a.id_ent=b.id_en ");
		stringBuilder.append(" left join bd_psndoc c on c.id_psndoc=a.id_emp_phy ");
		stringBuilder.append(" left join bd_dep d on d.id_dep=a.id_dep_phy ");
		stringBuilder.append(" left join en_ent_ip e on e.id_ent=a.id_ent ");
		stringBuilder.append(" left join pi_pat f on f.id_pat=a.id_pat ");
		stringBuilder.append(" where  a.code_entp='10' and a.fg_ip='Y'and a.id_emp_phy is not null and a.id_emp_phy !='~' ");
		stringBuilder.append(" and (b.id_di is null or (b.fg_sign='N' and b.fg_cancel='N')) ");
		stringBuilder.append(" and sysdate>(to_date(a.dt_acpt,'yyyy-mm-dd hh24:mi:ss')+3) ");
		stringBuilder.append(" and a.id_pat not in( ");
		stringBuilder.append(" select ");
		stringBuilder.append(" a.id_pat ");
		stringBuilder.append(" from en_ent a ");
		stringBuilder.append(" left join ci_di b on a.id_ent=b.id_en ");
		stringBuilder.append(" where  a.code_entp='10' and a.fg_ip='Y'and a.id_emp_phy is not null and a.id_emp_phy !='~' ");
		stringBuilder.append(" and b.id_di is not null and b.fg_sign='Y' and b.fg_cancel='N' ");
		stringBuilder.append(" and sysdate>(to_date(a.dt_acpt,'yyyy-mm-dd hh24:mi:ss')+3) ");
		stringBuilder.append(" ) ");
		return stringBuilder.toString();
	}
	private SqlParam getSelectParam()throws BizException{
		return new SqlParam();
	}
	@SuppressWarnings("unchecked")
	private List<Map<String, Object>> getResultMapList(String sqlStr, SqlParam param) throws BizException {
		if(CiOrdUtils.isEmpty(sqlStr)|| param==null) {
			return null;
		}
		try {
			return (List<Map<String, Object>>) (new DAFacade().execQuery(sqlStr, param, new MapListHandler()));
		} catch (Exception e) {
			return null;
		}
	}
	private Map<String, List<String>> constructData(List<Map<String, Object>> maps)throws BizException{
		if(CiOrdUtils.isEmpty(maps)) {
			return null;
		}
		Map<String, List<String>> newMap=new HashMap<String, List<String>>();
		for(Map<String, Object> map:maps) {
			String id_dep_phy=nullHandle(map.get("id_dep_phy"));
			if(CiOrdUtils.isEmpty(id_dep_phy)) {
				continue;
			}
			if(newMap.containsKey(id_dep_phy)) {
				newMap.get(id_dep_phy)
				.add(("床号："+(nullHandle(map.get("name_bed")) == null?"/":nullHandle(map.get("name_bed"))+" "))
					+("患者："+(nullHandle(map.get("name_pat")) == null?"/":nullHandle(map.get("name_pat"))+" "))
					+("住院号："+(nullHandle(map.get("code_amr_ip")) == null?"/":nullHandle(map.get("code_amr_ip"))+" ")));
			}else {
				List<String> list=new ArrayList<String>();
				list.add(("床号："+(nullHandle(map.get("name_bed")) == null?"/":nullHandle(map.get("name_bed"))+" "))
					+("患者："+(nullHandle(map.get("name_pat")) == null?"/":nullHandle(map.get("name_pat"))+" "))
					+("住院号："+(nullHandle(map.get("code_amr_ip")) == null?"/":nullHandle(map.get("code_amr_ip"))+" ")));
				newMap.put(id_dep_phy, list);
			}
		}
		return newMap;
	}
	private void fireData(Map<String, List<String>> map)throws BizException{
		if(CiOrdUtils.isEmpty(map)) {
			return;
		}
		for(String m:map.keySet()) {
			Map<String, Object> msgMap = new HashMap<String, Object>();
			msgMap.put(IMQMsgTypeConst.CI_MSG_UN_DIAG_SIGN, map.get(m));
			msgMap.put("id_dep", m);
			IGenerateMessageExtdService msgService = ServiceFinder.find(IGenerateMessageExtdService.class);
			// 此处调用方法，为Map参数，因此在后台接收，也应该实现Map参数的接口方法
			msgService.GenerateMessageAndMap(IMQMsgTypeConst.CI_MSG_UN_DIAG_SIGN, msgMap, null);
		}
	}
	private static String nullHandle(Object input) {
		if (CiOrdUtils.isEmpty(input))
			return null;
		return input.toString();
	}
}
