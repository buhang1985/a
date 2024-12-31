package iih.ci.ord.s.external.bp.mr.tl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.dto.ordermr.d.OrderMrDto;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;
import iih.ci.ord.s.bp.qry.getOrderFlush2MrDtoListQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 病历读取医嘱的信息
 * @author li_zheng
 *
 */
public class getOrderFlush2MrDtoListBP {
	
	/**
	 * 医嘱信息 orderMrdto
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public OrderMrDto[] exec(String id_ent,String type)throws BizException{
		getOrderFlush2MrDtoListQry qry = new getOrderFlush2MrDtoListQry(id_ent,type);
		OrderMrDto[] rtn =(OrderMrDto[])AppFwUtil.getDORstWithDao(qry, OrderMrDto.class);
		return rtn;
		
	}
	/**
	 * 医嘱信息 orderMrdto
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public FMap2 exec1(String id_ent,String code_entp,CiOrderDO[] orders,String id_psndoc)throws BizException{
		//根据前台传入的医嘱id 设置医嘱同步到病历状态
		String whereStr = " ds = '0' and fg_sign = 'Y' and id_emp_sign='"+id_psndoc+"' and id_or in "; 
		//获取ci_agg的服务
		ICiorderRService iCiorderRService = ServiceFinder.find(ICiorderRService.class); 
		FMap2 xml_map = new FMap2();
		if(orders!=null && orders.length!=0){
			//获取id集合
			List<String> ordids=new ArrayList<String>();
			for(CiOrderDO orderdo: orders){
				ordids.add(orderdo.getId_or());
			}
			
			if(ordids.size()==0 || iCiorderRService==null) return null;
			//拼装where语句
			boolean isNullSql=true;
			String whereIdStr="(";
			for (int i = 0; i < ordids.size(); i++) {
				isNullSql = false;
				if (i==ordids.size()-1) {
					whereIdStr += "'"+ordids.get(i)+"')";
				}else{
					whereIdStr += "'"+ordids.get(i)+"',";
				}
			}
			if (isNullSql) {
				whereIdStr +="'')";
			}else{
				whereStr += whereIdStr;
			}
			//获取aggDO集合
			CiorderAggDO[] ci_or_aggs = iCiorderRService.find(whereStr, "", FBoolean.FALSE);
			
			if(ci_or_aggs==null ||ci_or_aggs.length==0 ) return null;
			List<CiOrderDO> signord = new ArrayList<CiOrderDO>();
			for (int i = 0; i < ci_or_aggs.length; i++) {
				//获取ci_order_DO
				CiOrderDO ci_or_do = ci_or_aggs[i].getParentDO();
				if (ci_or_do != null) {
					signord.add(ci_or_do);
				}
			}
			//获取处理ci_order表的服务
			ICiorderMDOCudService iCiemrCudService = ServiceFinder.find(ICiorderMDOCudService.class);
			
			if(signord==null ||signord.size()==0 ||iCiemrCudService==null) return null;
			//处理医嘱状态
			for(CiOrderDO orderdo: signord){
				//ordias在这步应该已经无用了??
				//ordids.add(orderdo.getId_or());
				//设置回刷病历标识为Y
				orderdo.setFg_flush2mr(FBoolean.TRUE);
				orderdo.setStatus(DOStatus.UPDATED);
				
			}
			//保存
			CiOrderDO[] signords = signord.toArray(new CiOrderDO[signord.size()]);
			iCiemrCudService.save(signords) ;
//			xml_map = DataHandle(ci_or_aggs);
		}
		xml_map = getOrderFlushList(id_ent, code_entp,id_psndoc,false);
		return xml_map;
		
	}
	
	/**
	 * 手动刷新处置到病历
	 * 医嘱信息 orderMrdto
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public FMap2 exec2(CiOrderDO[] orders)throws BizException{
		if (orders == null || orders.length <1) return DataHandleNull(null);
		//根据前台传入的医嘱id 设置医嘱同步到病历状态
		String whereStr = " ds = '0' and fg_sign = 'Y'  and id_or in "; 
		//获取ci_agg的服务
		ICiorderRService iCiorderRService = ServiceFinder.find(ICiorderRService.class);  
		FMap2 xml_map = new FMap2();
		if(orders!=null && orders.length!=0){
			//获取id集合
			List<String> ordids=new ArrayList<String>();
			for(CiOrderDO orderdo: orders){
				ordids.add(orderdo.getId_or());
			}
			
			if(ordids.size()==0 || iCiorderRService==null) return null;
			//拼装where语句
			boolean isNullSql=true;
			String whereIdStr="(";
			for (int i = 0; i < ordids.size(); i++) {
				isNullSql = false;
				if (i==ordids.size()-1) {
					whereIdStr += "'"+ordids.get(i)+"')";
				}else{
					whereIdStr += "'"+ordids.get(i)+"',";
				}
			}
			if (isNullSql) {
				whereIdStr +="'')";
			}else{
				whereStr += whereIdStr;
			}
			//获取aggDO集合
			CiorderAggDO[] ci_or_aggs = iCiorderRService.find(whereStr, "", FBoolean.FALSE);
			
			if(ci_or_aggs==null ||ci_or_aggs.length==0 ) return null;
			List<CiOrderDO> signord = new ArrayList<CiOrderDO>();
			for (int i = 0; i < ci_or_aggs.length; i++) {
				//获取ci_order_DO
				CiOrderDO ci_or_do = ci_or_aggs[i].getParentDO();
				if (ci_or_do != null) {
					signord.add(ci_or_do);
				}
			}
			//获取处理ci_order表的服务
			ICiorderMDOCudService iCiemrCudService = ServiceFinder.find(ICiorderMDOCudService.class);
			
			if(signord==null ||signord.size()==0 ||iCiemrCudService==null) return null;
			//处理医嘱状态
			for(CiOrderDO orderdo: signord){
				//ordias在这步应该已经无用了??
				//ordids.add(orderdo.getId_or());
				//设置回刷病历标识为Y
				orderdo.setFg_flush2mr(FBoolean.TRUE);
				orderdo.setStatus(DOStatus.UPDATED);
				
			}
			//保存
			CiOrderDO[] signords = signord.toArray(new CiOrderDO[signord.size()]);
			iCiemrCudService.save(signords) ;
			
			xml_map = DataHandle(ci_or_aggs);
		}
		return xml_map;
		
	}
	/**
	 * 返回所有已签署的需要刷入病历的医嘱集合
	 * @param id_ent
	 * @param code_entp
	 * @return
	 * @throws BizException
	 */
	 public FMap2 getOrderFlushList(String id_ent,String code_entp,String id_psndoc,boolean isAll)throws BizException{
		//获取ci_agg的服务
		ICiorderRService iCiorderRService = ServiceFinder.find(ICiorderRService.class);
		if(iCiorderRService==null) return null;
		//获取需要刷新到病历的处置
		String whereFlushStr= "";
		if (isAll) {
			whereFlushStr  = " ds = '0' and (eu_feereversetp != '1' or eu_feereversetp is null)and fg_sign = 'Y' and fg_flush2mr = 'Y' and id_en ='"+id_ent+"' and code_entp ='"+code_entp+"'";
		}else{
			whereFlushStr = " ds = '0' and (eu_feereversetp != '1' or eu_feereversetp is null)and fg_sign = 'Y' and fg_flush2mr = 'Y' and id_en ='"+id_ent+"' and code_entp ='"+code_entp+"' and id_emp_sign='"+id_psndoc+"'";
		}
		 
		//获取需要回写病历的aggDO集合
		CiorderAggDO[] ci_or_aggs_flush = iCiorderRService.find(whereFlushStr, "", FBoolean.FALSE);
		if (ci_or_aggs_flush == null || ci_or_aggs_flush.length <1) return DataHandleNull(null);
		//数据处理
		return DataHandle(ci_or_aggs_flush);
	 }
	/***
	 * //用以处理医嘱中的物品类医嘱
	 * @author yzh 
	 * @since 2017-05-08 20:23:41
	 * @param aggs
	 * @return
	 * @throws BizException
	 */
	private FMap2 DataHandle(CiorderAggDO[] aggs)throws BizException{
		FMap2 result = new FMap2();
		//西药
		List<List<HashMap<String,String>>> west_med = new ArrayList<List<HashMap<String,String>>>();
		//中成药
		List<List<HashMap<String,String>>> cn_med = new ArrayList<List<HashMap<String,String>>>();
		//草药
		List<List<HashMap<String,String>>> herbal = new ArrayList<List<HashMap<String,String>>>();
		//检查02
		List<HashMap<String,String>> inspect = new ArrayList<HashMap<String,String>>();
		//检验03
		List<HashMap<String,String>> test = new ArrayList<HashMap<String,String>>();
		//血液制品 14
		List<HashMap<String,String>> blood = new ArrayList<HashMap<String,String>>();
		//其他为治疗 
		List<HashMap<String,String>> treat = new ArrayList<HashMap<String,String>>();
		//获取医嘱服务项目物品表 的service ci_or_srv_mm
		IOrdsrvmmRService iOrdersrvmmRS = ServiceFinder.find(IOrdsrvmmRService.class);
		//物品属性表bd_mm
		IMeterialMDORService iMMRS = ServiceFinder.find(IMeterialMDORService.class);
		if (iOrdersrvmmRS == null || iMMRS == null) return null;
		boolean isNullSql = true;
		//拼装逻辑
		String whereIdStr = " Id_orsrv in (";
		for (int j = 0; j < aggs.length; j++) {
			CiorderAggDO agg = aggs[j];
			if (agg != null) {
				OrdSrvDO[] os_do = agg.getOrdSrvDO();
				if (os_do != null && os_do.length > 0) {
					isNullSql = false;
					for (int i = 0; i < os_do.length; i++) {
						if (j == 0 && aggs.length == 1) {
							if (i == os_do.length - 1) {
								whereIdStr += "'" + os_do[i].getId_orsrv() + "'";
							} else {
								whereIdStr += "'" + os_do[i].getId_orsrv() + "',";
							}
						}else if(j<aggs.length-1 && aggs.length>1){
							whereIdStr += "'" + os_do[i].getId_orsrv() + "',";
						}else if(j==aggs.length-1 && aggs.length>1){
							if (i == os_do.length - 1) {
								whereIdStr += "'" + os_do[i].getId_orsrv() + "'";
							} else {
								whereIdStr += "'" + os_do[i].getId_orsrv() + "',";
							}
						}
					}
				}
			}
		}
		if (!isNullSql) {
			whereIdStr += " )";
		}else{
			whereIdStr += " '' )";
		}
			// 获取所有医嘱项目物品信息
			OrdSrvMmDO[] osmmdos = iOrdersrvmmRS.find(whereIdStr, "", FBoolean.FALSE);
			
			for (CiorderAggDO aggDO : aggs) {
				//获取ci_order_do
				CiOrderDO ci_order = aggDO.getParentDO();
				if (ci_order == null) continue;
				//医嘱类型编码
				String sd_srvtp = ci_order.getSd_srvtp();
				
				if (sd_srvtp != null) {
					//如果是01开头为西药类 需要拆分看其中是否有中成药和草药
					if (sd_srvtp.startsWith("01")) {
						//创建用以保存西药草药和中成药数据的集合
						List<HashMap<String,String>> list_101 = new ArrayList<HashMap<String,String>>();
						List<HashMap<String,String>> list_102 = new ArrayList<HashMap<String,String>>();
						List<HashMap<String,String>> list_103 = new ArrayList<HashMap<String,String>>();
						//药品类进行拆分判断 获取医嘱服务
						OrdSrvDO[] os_do = aggDO.getOrdSrvDO();
						//拼装where条件
						if (os_do.length > 0) {
						
							
							for (int i = 0; i < os_do.length; i++) {
								OrdSrvDO osdo = os_do[i];
								if (osdo != null) {
									FBoolean fg_mm = osdo.getFg_mm();

									// 判断服务中是否是物品,非物品不做处理
									if (FBoolean.TRUE.equals(fg_mm)) {
										// 是物品 进行迭代
										for (int j = 0; j < osmmdos.length; j++) {

											OrdSrvMmDO osmdo = osmmdos[j];

											if (osmdo != null && osdo.getId_orsrv().equals(osmdo.getId_orsrv())) {
												// 获取物品类型编码
												String sdmmtp = osmdo.getSd_mmtp();
												if (sdmmtp != null) {
													String idmm = osmdo.getId_mm();
													// 获取bd_mm信息
													MeterialDO mdo = iMMRS.findById(idmm);
													// 拆分
													if (sdmmtp.equals("103")) {// 草药
														HashMap<String, String> h_map = ConvertObj2Map(ci_order, osdo,
																osmdo, mdo);
														list_103.add(h_map);
													}else{// 西药
														HashMap<String, String> wm_map = ConvertObj2Map(ci_order, osdo,
																osmdo, mdo);
														list_101.add(wm_map);
													} 
												}
											}
										}
									}
									// end fg_mm==FBoolean.TRUE
								}
							}
						}
					
						
						
						if (list_101 != null && list_101.size()>0) {
							west_med.add(list_101);
						}
						if (list_102 != null && list_102.size()>0) {
							cn_med.add(list_102);
						}
						if (list_103 != null && list_103.size()>0) {
							herbal.add(list_103);
						}
					}else if(sd_srvtp.startsWith("02")){//检查医嘱
						HashMap<String,String> inspect_map = ConvertObj2Map(ci_order,null, null, null);
						inspect.add(inspect_map);
					}else if(sd_srvtp.startsWith("03")){//检验医嘱
						HashMap<String,String> test_map = ConvertObj2Map(ci_order,null, null, null);
						test.add(test_map);
					}else if(sd_srvtp.startsWith("14")){//血液制品医嘱
						HashMap<String,String> blood_map = ConvertObj2Map(ci_order,null, null, null);
						blood.add(blood_map);
					}else{//其他均为治疗05
						HashMap<String,String> treat_map = ConvertObj2Map(ci_order,null, null, null);
						treat.add(treat_map);
					}
				}
			}
		
		
		
		
		String xml_101 = ConvertDO2Xml(west_med, true);
		String xml_102 = ConvertDO2Xml(cn_med, true);
		String xml_103 = ConvertDO2Xml(herbal, true);
		String xml_inspect = ConvertDO2Xml(inspect, false);
		String xml_test = ConvertDO2Xml(test, false);
		String xml_blood = ConvertDO2Xml(blood, false);
		String xml_treat = ConvertDO2Xml(treat, false);  
		result.put("0101", xml_101);
		result.put("010201", xml_102);
		result.put("0103", xml_103);
		result.put("02", xml_inspect);
		result.put("03", xml_test);
		result.put("14", xml_blood);
		result.put("05", xml_treat);
		return result;
	}
	
	/***
	 * //用以处理为空的情况
	 * @author yzh 
	 * @since 2017-05-26 17:01:15
	 * @param aggs
	 * @return
	 * @throws BizException
	 */
	private FMap2 DataHandleNull(CiorderAggDO[] aggs)throws BizException{
		FMap2 result = new FMap2();
		result.put("0101", "");
		result.put("010201", "");
		result.put("0103", "");
		result.put("02", "");
		result.put("03", "");
		result.put("14", "");
		result.put("05", "");
		return result;
	}
	
	/***
	 * @see 封装xml字符串
	 * @author yzh
	 * @param list
	 * @param fg_mm
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private String ConvertDO2Xml(List list,boolean fg_mm){
		if (list == null || list.size() <= 0) {
			return "";
		}else{
			//创建doc
			Document document = DocumentHelper.createDocument();
			//创建根节点
			Element rootElement = document.addElement("table");
			//创建col节点
			Element colElement = rootElement.addElement("column"); 
			
			//判断传入的是否是物品类型 以此来判断如何进行取值
			if (fg_mm) {
				for (int i = 0; i < list.size(); i++) {
					List<HashMap<String,String>> item_list = (List<HashMap<String, String>>) list.get(i);
					Element groupElement = rootElement.addElement("group");  
					for (int j = 0; j < item_list.size(); j++) {
						HashMap<String,String> map = item_list.get(j);
						
						Element rowElement = groupElement.addElement("row");
						Iterator<Entry<String, String>> iterator = map.entrySet().iterator();  
						if (i==0 && j==0) {
							while (iterator.hasNext()) {  
							    Map.Entry<String, String> entry = iterator.next(); 
							    Element colNode = colElement.addElement("node");
							    colNode.setText(entry.getKey());
							    Element rowNode = rowElement.addElement("node");
							    rowNode.setText(entry.getValue());
							}  
						}else{
							while (iterator.hasNext()) {  
							    Map.Entry<String, String> entry = iterator.next(); 
							    Element rowNode = rowElement.addElement("node");
							    rowNode.setText(entry.getValue());
							}
						}
					}
				}
			}else{
				for (int i = 0; i < list.size(); i++) {
					HashMap<String,String> map = (HashMap<String, String>) list.get(i);
					Element groupElement = rootElement.addElement("group");
					Element rowElement = groupElement.addElement("row");
					Iterator<Entry<String, String>> iterator = map.entrySet().iterator();  
					if (i==0) {
						while (iterator.hasNext()) {  
						    Map.Entry<String, String> entry = iterator.next(); 
						    Element colNode = colElement.addElement("node");
						    colNode.setText(entry.getKey());
						    Element rowNode = rowElement.addElement("node");
						    rowNode.setText(entry.getValue());
						} 
					}else{
						while (iterator.hasNext()) {  
						    Map.Entry<String, String> entry = iterator.next(); 
						    Element rowNode = rowElement.addElement("node");
						    rowNode.setText(entry.getValue());
						}
					}
					 
				}
			}
			return document.asXML();
		}
		
	}
	
	/***
	 * @see 封装空 xml字符串
	 * @author yzh
	 * @param list
	 * @param fg_mm
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private String ConvertNullXml(){
		HashMap<String,String> map = ConvertObj2Map(null, null, null, null);
		//创建doc
		Document document = DocumentHelper.createDocument();
		//创建根节点
		Element rootElement = document.addElement("table");
		//创建col节点
		Element colElement = rootElement.addElement("column"); 
		Iterator<Entry<String, String>> iterator = map.entrySet().iterator(); 
		Element groupElement = rootElement.addElement("group");
		Element rowElement = groupElement.addElement("row");
		while (iterator.hasNext()) {  
		    Map.Entry<String, String> entry = iterator.next(); 
		    Element colNode = colElement.addElement("node");
		    colNode.setText(entry.getKey());
		    Element rowNode = rowElement.addElement("node");
		    rowNode.setText(entry.getValue().toString());
		} 
		return document.asXML();
	}
	
	/***
	 * @see 用以将对象封装进入map
	 * @author yzh
	 * @param codo
	 * @param osdo
	 * @param osmmdo
	 * @param mdo
	 * @return
	 */
	@SuppressWarnings("unused")
	private HashMap<String, String> ConvertObj2Map(CiOrderDO codo, OrdSrvDO osdo, OrdSrvMmDO osmmdo, MeterialDO mdo) {
		HashMap<String, String> map = new HashMap<String, String>();
		String spec = "";
		String printname = "";
		boolean codo_flag = false;
		boolean osdo_flag = false;
		boolean osmmdo_flag = false;
		if (codo == null) {
			codo = new CiOrderDO();
			codo_flag = true;
		}
		if (osdo == null) {
			osdo = new OrdSrvDO();
			osdo_flag = true;
		}
		if (osmmdo == null) {
			osmmdo = new OrdSrvMmDO();
			osmmdo_flag = true;
		}
		//获取DO中的字段 和 val 循环放入map中
		String[] codo_names = codo.getAttrNames();
		if (codo_flag) {
			for (int i = 0; i < codo_names.length; i++) {
				map.put(codo_names[i], "");
			}
		}else{
			for (int i = 0; i < codo_names.length; i++) {
				Object val = codo.getAttrVal(codo_names[i]);
				if (val == null) {
					map.put(codo_names[i], "");
				}else{
					//判断是FBoolean类型 进行转换
					if(val instanceof FBoolean){
						if (FBoolean.TRUE.equals(val)) {
							map.put(codo_names[i], "true");
						}else{
							map.put(codo_names[i], "false");
						}
					}else{
						map.put(codo_names[i],val+"");
					}
				}
			}
		}
		
		String[] osdo_names = osdo.getAttrNames();
		if (osdo_flag) {
			for (int i = 0; i < osdo_names.length; i++) {
				map.put(osdo_names[i], "");
			}
		}else{
			for (int i = 0; i < osdo_names.length; i++) {
				Object val = osdo.getAttrVal(osdo_names[i]);
				if (val == null) {
					map.put(osdo_names[i], "");
				}else{
					if(val instanceof FBoolean){
						if (FBoolean.TRUE.equals(val)) {
							map.put(osdo_names[i], "true");
						}else{
							map.put(osdo_names[i], "false");
						}
					}else{
						map.put(osdo_names[i],val+"");
					}
				}
			}
		}
		
		String[] osmmdo_names = osmmdo.getAttrNames();
		if (osdo_flag) {
			for (int i = 0; i < osmmdo_names.length; i++) {
				map.put(osmmdo_names[i], "");
			}
		}else{
			for (int i = 0; i < osmmdo_names.length; i++) {
				Object val = osmmdo.getAttrVal(osmmdo_names[i]);
				if (val == null) {
					map.put(osmmdo_names[i], "");
				}else{
					if(val instanceof FBoolean){
						if (FBoolean.TRUE.equals(val)) {
							map.put(osmmdo_names[i], "true");
						}else{
							map.put(osmmdo_names[i], "false");
						}
					}else{
						map.put(osmmdo_names[i],val+"");
					}
				}
			}
		}
		
		if (mdo != null) {
			spec = mdo.getSpec();
			printname = mdo.getPrintname();
		}
		map.put("SPEC", spec);
		map.put("PRINTNAME", printname);
		return map;
	}
	
	

	
}
