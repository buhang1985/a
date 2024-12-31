package iih.hp.cp.hpcpappexeinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.dp.report.data.reader.sql.SqlReader;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapListHandler;

public class HpcpAppExeService {
	
	// 诊疗活动包
	private static final String _DiagActPkg = "ZLHDB";
	// 医嘱包
	private static final String _OrderPkg = "YZB";
	// 重点医嘱
	private static final String _MasterOrder = "ZDYZ";
	// 医嘱
	private static final String _Order = "YZ";
	// 护理工作包
	private static final String _NurWorkPkg = "HLGZB";
	//成组医嘱包
	private static final String _GroupOrderPkg="CZYZB";
	// 责任护士签名
	private static final String _NursesSign = "责任护士签名";
	// 医师签名
	private static final String _PhysicianSign = "医师签名";
	
	/**
	 * 临床路径患者告知单和表单打印表单数据调取接口
	 * 
	 * @param id_cpapp		临床路径应用id
	 * @param fg_patNotice  是否是患者告知单		"Y":是	"N"：否
	 * @param fg_sign	            是否显示医生护士签名	"Y":是	"N"：否
	 * @return
	 * @throws Exception
	 */
	public List<Hpcpappexeinfo> fillBeanList(String id_cpapp, String fg_patNotice, String fg_sign,String execode) throws Exception {
		
		if(StringUtils.isBlank(id_cpapp) || StringUtils.isBlank(fg_patNotice)) {
			
			return null;
		}
		
		//计划阶段获取
		LinkedHashMap<String, Hpcpappexeinfo> stageInfo = this.getEleStage(id_cpapp,execode);
		
		//计划阶段下第一层元素获取(主要诊疗工作、重点医嘱、主要护理工作、)
		Map<String, LinkedHashMap<String, Hpcpappexeinfo>> topOneEleInfo = this.getTopOneInfo(id_cpapp, fg_patNotice, fg_sign, stageInfo);
		
		//所有元素获取(计划阶段组装)
		Map<String, List<Hpcpappexeinfo>> allEleInfo = this.getAllEleInfo(id_cpapp, fg_patNotice, topOneEleInfo);
		
		//结果返回
		return this.assembleResult(stageInfo, topOneEleInfo, allEleInfo,execode);
	}

	private LinkedHashMap<String, Hpcpappexeinfo> getEleStage(String id_cpapp,String execode) throws Exception {
		
		StringBuffer strSql = new StringBuffer(this.getBaseSql(id_cpapp));
		strSql.append(" and ele.id_ele = ele.id_ele_stage ");
//		if("1".equals(execode)) {
//			//已执行
//			strSql.append(" and appele.eu_exe_status=1 ");
//		}
		strSql.append(this.getBaseOrder());
		List<Hpcpappexeinfo> stageInfo = this.getResultBySql(strSql.toString());
		LinkedHashMap<String, Hpcpappexeinfo> result = new LinkedHashMap<String, Hpcpappexeinfo>();
		if(stageInfo == null || stageInfo.size() <= 0)
			return result;
		
		for(Hpcpappexeinfo stageEle : stageInfo) {
			result.put(stageEle.getId_ele(), stageEle);
		}
		
		return result;
	}
	
	private Map<String, LinkedHashMap<String, Hpcpappexeinfo>> getTopOneInfo(String id_cpapp, String fg_patNotice, String fg_sign, LinkedHashMap<String, Hpcpappexeinfo> stageInfo) throws Exception {
		
		StringBuffer strSql = new StringBuffer(this.getBaseSql(id_cpapp));
		String inSql = this.getInSql(stageInfo);
		strSql.append(" and ele.id_par in " + inSql);
		strSql.append(" and ele.eletp_code in ( ");
		strSql.append(" '" + _DiagActPkg + "',");
		strSql.append(" '" + _MasterOrder + "',");
		strSql.append(" '" + _NurWorkPkg + "')");
		strSql.append(this.getBaseOrder());
		List<Hpcpappexeinfo> topOneInfo = this.getResultBySql(strSql.toString());
		Map<String, LinkedHashMap<String, Hpcpappexeinfo>> result = new HashMap<String, LinkedHashMap<String, Hpcpappexeinfo>>();
		if(topOneInfo == null || topOneInfo.size() <= 0)
			return result;
		
		for(Hpcpappexeinfo topOneEle : topOneInfo) {
			topOneEle.setFg_top(FBoolean.TRUE);
			if(result.containsKey(topOneEle.getId_ele_stage())) {
				LinkedHashMap<String, Hpcpappexeinfo> topOneMap = result.get(topOneEle.getId_ele_stage());
				topOneMap.put(topOneEle.getId_ele(), topOneEle);
			} else {
				LinkedHashMap<String, Hpcpappexeinfo> topOneMap = new LinkedHashMap<String, Hpcpappexeinfo>();
				topOneMap.put(topOneEle.getId_ele(), topOneEle);
				result.put(topOneEle.getId_ele_stage(), topOneMap);
			}
		}
		
		if("Y".equals(fg_sign)) {
			for(Hpcpappexeinfo stageEle : stageInfo.values()) {
				LinkedHashMap<String, Hpcpappexeinfo> topOneMap = result.get(stageEle.getId_ele());
				Hpcpappexeinfo nureseSignEle = this.getSingEle(_NursesSign, stageEle);
				topOneMap.put(nureseSignEle.getId_ele(), nureseSignEle);
				Hpcpappexeinfo physicianSignEle = this.getSingEle(_PhysicianSign, stageEle);
				topOneMap.put(physicianSignEle.getId_ele(), physicianSignEle);
			}
		}
		
		return result;
	}

	private String getInSql(LinkedHashMap<String, Hpcpappexeinfo> stageInfo) {
		
		StringBuffer sql = new StringBuffer("(");
		for(String key : stageInfo.keySet()) {
			sql.append("'" + key + "',");
		}
		int index = sql.lastIndexOf(",");
		sql = sql.replace(index, index + 1, ")");
		return sql.toString();
	}
	
	private Hpcpappexeinfo getSingEle(String name, Hpcpappexeinfo stageEle) {
		
		Hpcpappexeinfo singEle = (Hpcpappexeinfo)stageEle.clone();
		singEle.setId_ele(name);
		singEle.setEle_name(name);
		
		return singEle;
	}
	
	private Map<String, List<Hpcpappexeinfo>> getAllEleInfo(String id_cpapp, String fg_patNotice,
			Map<String, LinkedHashMap<String, Hpcpappexeinfo>> topOneEleInfo) throws Exception {
		
		StringBuffer strSql = new StringBuffer(this.getBaseSql(id_cpapp));
		if("Y".equals(fg_patNotice)) {
			strSql.append(" and (ele.fg_pat_notice = 'Y' or ele.eletp_code = '" + _DiagActPkg + "') ");
		}
		strSql.append(this.getBaseOrder());
		List<Hpcpappexeinfo> allEleInfo = this.getResultBySql(strSql.toString());
		Map<String, List<Hpcpappexeinfo>> result = new HashMap<String, List<Hpcpappexeinfo>>();
		if(allEleInfo == null || allEleInfo.size() <= 0)
			return result;
		
		for(Hpcpappexeinfo ele : allEleInfo) {
			if(result.containsKey(ele.getId_ele_stage())) {
				List<Hpcpappexeinfo> elesOfStage = result.get(ele.getId_ele_stage());
				elesOfStage.add(ele);
			} else {
				List<Hpcpappexeinfo> elesOfStage = new ArrayList<Hpcpappexeinfo>();
				elesOfStage.add(ele);
				result.put(ele.getId_ele_stage(), elesOfStage);
			}
		}
		
		//如果是患者告知单，则需要对诊疗活动包进行处理，因为诊疗活动包元素没有“患者告知单”属性。
		if("Y".equals(fg_patNotice)) {
			//想要的结果：在患者告知单中，诊疗活动包下是患者告知单的元素会连同诊疗活动包一起展示出来，如果诊疗活动包下没有患者告知单，则诊疗活动包不会显示。
			//策略：1、不采用子找父的方式。原因：（1）需要多次查找数据库。（2）医嘱包等其它元素是有患者告知单属性的，目前需求下医嘱包不是患者告知单，则医嘱包及其所有子元素都不显示。如果通过子找父会破坏这个规则。
			//	  2、使用父找子，明确父元素，没有子的父元素移除。目前只针对诊疗活动包。
			
			//key：诊疗活动包元素id，value：诊疗活动包下的子元素。
			Map<String, List<Hpcpappexeinfo>> diagActPkgMap = new HashMap<>();
			for (Map.Entry<String, List<Hpcpappexeinfo>> entry : result.entrySet()) {
				for (Hpcpappexeinfo info : entry.getValue()) {
					if (_DiagActPkg.equals(info.getEletp_code())) {
						diagActPkgMap.put(info.getId_ele(), new ArrayList<Hpcpappexeinfo>());
					}
					if (diagActPkgMap.containsKey(info.getId_parent())) {
						diagActPkgMap.get(info.getId_parent()).add(info);
					}
				}
			}
			
			//去掉没有子元素的诊疗活动包
			for (Map.Entry<String, List<Hpcpappexeinfo>> entry : result.entrySet()) {
				Iterator<Hpcpappexeinfo> it = entry.getValue().iterator();
				while (it.hasNext()) {
					Hpcpappexeinfo hpcpappexeinfo = it.next();
					if (_DiagActPkg.equals(hpcpappexeinfo.getEletp_code())) {
						if (diagActPkgMap.get(hpcpappexeinfo.getId_ele()).size() == 0) {
							it.remove();
						} else if (diagActPkgMap.get(hpcpappexeinfo.getId_ele()).size() > 0) {
							boolean hasChild = hasChildDiagActPkg(diagActPkgMap.get(hpcpappexeinfo.getId_ele()), diagActPkgMap);
							if (!hasChild) {
								it.remove();
							}
						}
					}
				}
			}
		}
		
		return result;
	}

	//迭代判断诊疗活动包下是否有诊疗活动
	private boolean hasChildDiagActPkg(List<Hpcpappexeinfo> infoList, Map<String, List<Hpcpappexeinfo>> diagActPkgMap) {
		boolean hasChild = false;
		for (Hpcpappexeinfo info : infoList) {
			if (_DiagActPkg.equals(info.getEletp_code())) {
				if (diagActPkgMap.get(info.getId_ele()).size() == 0) {
					hasChild = false;
				} else if (diagActPkgMap.get(info.getId_ele()).size() > 0) {
					hasChild = hasChildDiagActPkg(diagActPkgMap.get(info.getId_ele()), diagActPkgMap);
					if (hasChild) {
						return true;
					}
				}
			} else {
				return true;
			}
		}
		return hasChild;
	}
	
	protected String getBaseSql(String id_cpapp) {
		
		StringBuffer strSql = new StringBuffer();
		strSql.append(" select ");
		strSql.append(" app.id_cpapp, ");
		strSql.append(" app.id_cp, ");
		strSql.append(" ele.id_ele, ");
		strSql.append(" ele.name ele_name, ");
		strSql.append(" ele.eletp_code, ");
		//strSql.append(" ele.id_par id_parent, ");
		strSql.append(" appele.id_par id_parent, ");
		strSql.append(" appele.id_ele_stage, ");
		strSql.append(" stage.name stage_name, ");
		strSql.append(" app_stage.dt_enter, ");
		strSql.append(" app_stage.dt_exit, ");
		strSql.append(" decode(appele.eu_exe_status, 1, 'Y', 2, 'N', '') fg_exe, ");
		strSql.append(" bd_udidoc.name exerole_name, ");
		strSql.append(" ele.serialno ");
		strSql.append(" from hp_Cp_app app ");
		strSql.append(" left join hp_cp_app_ele appele ");
		strSql.append(" on app.id_cpapp = appele.id_cpapp ");
		strSql.append(" left join hp_cp_ele ele ");
		strSql.append(" on appele.id_ele = ele.id_ele ");
		strSql.append(" left join hp_cp_ele stage  ");
		strSql.append(" on stage.id_ele = ele.id_ele_stage ");
		strSql.append(" left join hp_cp_app_ele_stage app_stage ");
		strSql.append(" on appele.id_appele = app_stage.id_appele and app_stage.id_ele = ele.id_ele ");
		strSql.append(" left join bd_udidoc ");
		strSql.append(" on ele.id_exe_role = bd_udidoc.id_udidoc ");
		strSql.append(" where app.id_cpapp = '" + id_cpapp + "' ");
		strSql.append(" and nvl(ele.id_ele_stage, '~') <> '~' ");
		
		return strSql.toString();
	}
	
	protected String getBaseOrder() {
		return " order by ele.id_par, ele.serialno ";
	}
	
	@SuppressWarnings("unchecked")
	private List<Hpcpappexeinfo> getResultBySql(String strSql) throws Exception {
		SqlReader sql_rdr = new SqlReader(null, strSql);
		sql_rdr.runSql(null, true);
		com.sun.rowset.CachedRowSetImpl cached_rs = sql_rdr.getCacheRowSet();
		
		// 转换成对应 DTO 对象
		BeanListHandler beanlist_handler = new BeanListHandler(Hpcpappexeinfo.class);
		List<Hpcpappexeinfo> result = (List<Hpcpappexeinfo>)beanlist_handler.processRs(cached_rs);

		sql_rdr.destroy(); // add by QYS at 2016.4.20
		
		if(result == null || result.size() <= 0) {
			return null;
		}
		
		return result;
	}
	
	private List<Hpcpappexeinfo> assembleResult(LinkedHashMap<String, Hpcpappexeinfo> stageInfo,
			Map<String, LinkedHashMap<String, Hpcpappexeinfo>> topOneEleInfo, Map<String, List<Hpcpappexeinfo>> allEleInfo,String execode) throws Exception {
		
		//组装返回值索引(计划阶段(主要诊疗工作、重点医嘱、主要护理工作))
		List<Hpcpappexeinfo> structresult = this.assembleStruct(stageInfo, topOneEleInfo);
		
		//组装每个索引下显示所需的json串
		this.assembleJson(structresult, allEleInfo,execode);
		
		//组装最终返回结果
		return this.assembleResult(stageInfo, topOneEleInfo, structresult);
	}

	private List<Hpcpappexeinfo> assembleStruct(LinkedHashMap<String, Hpcpappexeinfo> stageInfo,
			Map<String, LinkedHashMap<String, Hpcpappexeinfo>> topOneEleInfo) {
		
		List<Hpcpappexeinfo> result = new ArrayList<Hpcpappexeinfo>();
		for(String id_ele_stage : stageInfo.keySet()) {
			LinkedHashMap<String, Hpcpappexeinfo> topOneMap = topOneEleInfo.get(id_ele_stage);
			for(Hpcpappexeinfo topOneDO : topOneMap.values()) {
				result.add(topOneDO);
			}
		}		
		return result;
	}
	
	private void removeEmptyPkg(List<Hpcpappexeinfo> list,LinkedHashMap<String, List<Hpcpappexeinfo>> childeleList) {
		if(childeleList.size()==0)return;
//		LinkedHashMap<String, List<Hpcpappexeinfo>> childeleListnew=new LinkedHashMap<>();
		LinkedHashMap<String, Hpcpappexeinfo> parenteleList=new LinkedHashMap<>();
//		for (String key :childeleList.keySet()) {
//			List<Hpcpappexeinfo> childList = childeleList.get(key);
//			List<Hpcpappexeinfo> childListnew = new ArrayList<Hpcpappexeinfo>();
//			for (Hpcpappexeinfo hpcpappexeinfo : childList) {
//				childListnew.add(hpcpappexeinfo);
//			}
//			
//			childeleListnew.put(key, childListnew);
//		}
		for (Hpcpappexeinfo hpcpappexeinfo : list) {
			if(childeleList.containsKey(hpcpappexeinfo.getId_ele())) {
				parenteleList.put(hpcpappexeinfo.getId_ele(), hpcpappexeinfo);
			}
		}
			
		List<Hpcpappexeinfo> removelist=new ArrayList<>();
		for (Hpcpappexeinfo hpcpappexeinfo : list) {
			removePkg( hpcpappexeinfo,childeleList,removelist,parenteleList);
		}
		
//		list.removeAll(removelist);
	}
	/**
	 * 去除没有子项的医嘱包
	 * @param hpcpappexeinfo
	 * @param childeleList
	 * @param removelist
	 * @param parenteleList
	 */
	private void removePkg(Hpcpappexeinfo hpcpappexeinfo,LinkedHashMap<String, List<Hpcpappexeinfo>> childeleList,List<Hpcpappexeinfo> removelist,LinkedHashMap<String, Hpcpappexeinfo> parenteleList) {
		if(_OrderPkg.equals(hpcpappexeinfo.getEletp_code())||_GroupOrderPkg.equals(hpcpappexeinfo.getEletp_code())) {
			if(!removelist.contains(hpcpappexeinfo))
			{
			if(!childeleList.containsKey(hpcpappexeinfo.getId_ele())||childeleList.get(hpcpappexeinfo.getId_ele()).size()==0) {
				removelist.add(hpcpappexeinfo);
				String id_parent=hpcpappexeinfo.getId_parent();
				if(id_parent!=null&&id_parent.trim().length()>0) {
					List<Hpcpappexeinfo> childList = childeleList.get(id_parent);
					if(childList!=null&&childList.contains(hpcpappexeinfo)) {
					childList.remove(hpcpappexeinfo);
					if(parenteleList.containsKey(id_parent)) {
						Hpcpappexeinfo parent=parenteleList.get(id_parent);
						removePkg(parent, childeleList, removelist,parenteleList) ;
					}
					}
					
				}
				}
			}
		}
	}
	
	private void assembleJson(List<Hpcpappexeinfo> structresult, Map<String, List<Hpcpappexeinfo>> allEleInfo,String execode) {
		
		for(Hpcpappexeinfo structDO : structresult) {
			if(_NursesSign.equals(structDO.getId_ele()) || _PhysicianSign.equals(structDO.getId_ele()))
				continue;
			String jsonStr = this.assembleJsonStr(structDO, allEleInfo.get(structDO.getId_ele_stage()),execode);
			structDO.setJsonstr(jsonStr);
		}
	}

	private String assembleJsonStr(Hpcpappexeinfo structDO, List<Hpcpappexeinfo> list,String execode) {
		
		if(list == null || list.size() <= 0)
			return "";
		
		//获取当前索引下的所有子元素
		LinkedHashMap<String, List<Hpcpappexeinfo>> childeleList = new LinkedHashMap<String, List<Hpcpappexeinfo>>();
		this.getChildEle(childeleList, structDO, list,execode);
		removeEmptyPkg(list,childeleList);
		//已拼接元素记录
		Map<String, String> structedEle = new HashMap<String, String>();
		StringBuffer jsonStr = new StringBuffer();
		jsonStr.append("{text:'',children:[");
		for(List<Hpcpappexeinfo> childList : childeleList.values()) {
			this.getJsonStr(structedEle, jsonStr, childeleList, childList);
		}
		jsonStr.append("]}");
		
		return jsonStr.toString();
	}
	
	private void getChildEle(LinkedHashMap<String, List<Hpcpappexeinfo>> childeleList, Hpcpappexeinfo structDO, List<Hpcpappexeinfo> list,String execode) {
		
		for(Hpcpappexeinfo eleDO : list) {
			
			if(!eleDO.getId_parent().equals(structDO.getId_ele())) {
				continue;
			} else {
				if(structDO.getFg_top() != null && structDO.getFg_top().booleanValue() && 
						_OrderPkg.equals(structDO.getEletp_code())) {
					eleDO.setFg_nobox(FBoolean.TRUE);
				}
			}
			
			//医嘱包下只显示执行的医嘱
//			if(_OrderPkg.equals(structDO.getEletp_code()) && structDO.getFg_top() == null && 
//					_Order.equals(eleDO.getEletp_code()) && StringUtils.isBlank(eleDO.getFg_exe())) {
//				continue;
//			}
			
			if(_Order.equals(eleDO.getEletp_code())) {
				
				if("1".equals(execode)) {
					//已执行
					if(!"Y".equals(eleDO.getFg_exe()))
					{
						continue;
					}
						
				}else if("0".equals(execode)) {
					//未执行
					if("Y".equals(eleDO.getFg_exe())||"N".equals(eleDO.getFg_exe()))
					{
						continue;
					}
				}else if("2".equals(execode)) {
					//不执行
					if(!"N".equals(eleDO.getFg_exe()))
					{
						continue;
					}
				}
			}
			
			if(childeleList.containsKey(eleDO.getId_parent())) {
				List<Hpcpappexeinfo> childList = childeleList.get(eleDO.getId_parent());
				childList.add(eleDO);
			} else {
				List<Hpcpappexeinfo> childList = new ArrayList<Hpcpappexeinfo>();
				childList.add(eleDO);
				childeleList.put(eleDO.getId_parent(), childList);
			}
			this.getChildEle(childeleList, eleDO, list,execode);
		}
	}

	private void getJsonStr(Map<String, String> structedEle, StringBuffer jsonStr, LinkedHashMap<String, List<Hpcpappexeinfo>> childeleList, 
			List<Hpcpappexeinfo> childList) {
		
		for(Hpcpappexeinfo eleDO : childList) {
			if(structedEle.containsKey(eleDO.getId_ele()))
				continue;
			
			structedEle.put(eleDO.getId_ele(), eleDO.getId_ele());
			jsonStr.append("{text:'" + eleDO.getEle_name().replace("\n", "") + "'");
			if(eleDO.getFg_nobox() != null && eleDO.getFg_nobox().booleanValue()) {
				jsonStr.append(", nobox:''");
			}
			if(!StringUtils.isBlank(eleDO.getFg_exe()) && "Y".equals(eleDO.getFg_exe())) {
				jsonStr.append(", chk:'√'");
			} else if(!StringUtils.isBlank(eleDO.getFg_exe()) && "N".equals(eleDO.getFg_exe())) {
				jsonStr.append(", chk:'×'");
			}
			if(childeleList.containsKey(eleDO.getId_ele())) {
				jsonStr.append(",children:[");
				this.getJsonStr(structedEle, jsonStr, childeleList, childeleList.get(eleDO.getId_ele()));
				jsonStr.append("]},");
			} else {
				jsonStr.append("},");
			}
			
			if(childList.indexOf(eleDO) == childList.size() - 1) {
				int index = jsonStr.lastIndexOf(",");
				jsonStr.replace(index, index + 1, "");
			}
		}
	}
	
	private List<Hpcpappexeinfo> assembleResult(LinkedHashMap<String, Hpcpappexeinfo> stageInfo, Map<String, LinkedHashMap<String, Hpcpappexeinfo>> topOneEleInfo,
			List<Hpcpappexeinfo> structresult) {
		
		Hpcpappexeinfo[] stageList = stageInfo.values().toArray(new Hpcpappexeinfo[0]);
		List<Hpcpappexeinfo> result = new ArrayList<Hpcpappexeinfo>();
		for(int i = 0; i < stageInfo.values().size(); i++) {
			
			Hpcpappexeinfo eleinfo = stageList[i];
			eleinfo.setJsonstr("{text:'',children:[{text:'" + eleinfo.getEle_name().replace("\n", "") + "', nobox:''}]}");
			eleinfo.setEle_name("");
			result.add(eleinfo);
			
			Map<String, Hpcpappexeinfo> eleInfoMap = new HashMap<String, Hpcpappexeinfo>();
			
			LinkedHashMap<String, Hpcpappexeinfo> topOneInfo = topOneEleInfo.get(eleinfo.getId_ele_stage());
			for(Hpcpappexeinfo topOneDO : topOneInfo.values()) {
				result.add(topOneDO);
				eleInfoMap.put(topOneDO.getEle_name(), topOneDO);
			}
			
			if(i + 1 >= stageInfo.values().size())
				break;
			
			i = i + 1;
			Hpcpappexeinfo eleInfo2 = stageList[i];
			eleinfo.setJsonstr2("{text:'',children:[{text:'" + eleInfo2.getEle_name().replace("\n", "") + "', nobox:''}]}");
			
			LinkedHashMap<String, Hpcpappexeinfo> topOneInfo2 = topOneEleInfo.get(eleInfo2.getId_ele_stage());
			for(Hpcpappexeinfo topOneDO2 : topOneInfo2.values()) {
				Hpcpappexeinfo topOneDO = eleInfoMap.get(topOneDO2.getEle_name());
				topOneDO.setJsonstr2(topOneDO2.getJsonstr());
			}
		}
		
		return result;
	}
}
