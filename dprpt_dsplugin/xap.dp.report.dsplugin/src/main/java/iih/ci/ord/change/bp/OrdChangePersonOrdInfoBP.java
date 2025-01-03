package iih.ci.ord.change.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.ci.ord.change.OrdChangeOrderInfoDTO;
import iih.ci.ord.change.OrdChangePersonDTO;
import iih.ci.ord.printmanage.srv.CiorderPrintUtils;
import xap.mw.coreitf.d.FDateTime;
/**
 * 医嘱变更单，病区信息
 * 
 * @author zhangwq
 *
 */
public class OrdChangePersonOrdInfoBP {
	/**
	 * 当前时间
	 */
	FDateTime dtNow = new FDateTime();

	public List<OrdChangePersonDTO> exec(String model, String id_en,String changeDate,String ordstatus,String print,String end,String sign,String fg_long,String name_freq ,String name_route,String YHZ,String sd_srvtp) {
		try {
			List<Map<String,Object>> rstMapList = CiorderPrintUtils.GetQryRstMapList(getQrySql(model,id_en,changeDate, print,end, sign, fg_long, name_freq , name_route, YHZ,sd_srvtp));
			return transChangePerson(rstMapList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	/**
	 * 组装成前台报告的数据源
	 * @param rstMapList
	 * @return
	 */
	private List<OrdChangePersonDTO> transChangePerson(List<Map<String,Object>> rstMapList){
		List<OrdChangePersonDTO> personList = new ArrayList<OrdChangePersonDTO>();
		Map<String,OrdChangePersonDTO> tempMapPerson = new HashMap<String,OrdChangePersonDTO>();
		//草药医嘱的id集合
		List<String> herbOrdIdList = new ArrayList<String>();
		for(Map<String,Object> map : rstMapList){
			String id_pat = map.get("id_en").toString();
			String sd_srvtp = map.get("sd_srvtp").toString();
			String id_or = map.get("id_or").toString();
			if(tempMapPerson.containsKey(id_pat)){
				OrdChangePersonDTO person = tempMapPerson.get(id_pat);
				this.setPersonProperty(person, map);
				List<OrdChangeOrderInfoDTO> OrderInfoList = person.getChangeOrderInfoList();
				//草药需要特殊处理
				if(sd_srvtp.startsWith("0103")){
					if(!herbOrdIdList.contains(id_or)){
						OrdChangeOrderInfoDTO ordInfo = new OrdChangeOrderInfoDTO();
						this.setHerbOrdInfoProperty(ordInfo, map);
						herbOrdIdList.add(id_or);
						OrderInfoList.add(ordInfo);
					}
				}else{
					OrdChangeOrderInfoDTO ordInfo = new OrdChangeOrderInfoDTO();
					this.setOrdInfoProperty(ordInfo, map);
					OrderInfoList.add(ordInfo);
				}
				person.setChangeOrderInfoList(OrderInfoList);
			}else{
				OrdChangePersonDTO person = new OrdChangePersonDTO();
				this.setPersonProperty(person, map);
				List<OrdChangeOrderInfoDTO> OrderInfoList = new ArrayList<OrdChangeOrderInfoDTO>();
				OrdChangeOrderInfoDTO ordInfo = new OrdChangeOrderInfoDTO();
				//草药需要特殊处理
				if(sd_srvtp.startsWith("0103")){
					this.setHerbOrdInfoProperty(ordInfo, map);
					herbOrdIdList.add(id_or);
				}else{
					this.setOrdInfoProperty(ordInfo, map);
				}
				OrderInfoList.add(ordInfo);
				person.setChangeOrderInfoList(OrderInfoList);
				tempMapPerson.put(id_pat, person);
				personList.add(person);
			}
		}
		return personList;
	}
	/**
	 * 获得不同模式下的查询sql
	 * @param model
	 * @param id_en
	 * @return
	 */
	private String getQrySql(String model, String id_en,String changeDate,String print,String end,String sign,String fg_long,String name_freq ,String name_route,String YHZ,String sd_srvtp) {
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append(" select * from (select");
		sqlSb.append(" CASE ci.fg_canc WHEN  'Y' THEN '【作废】'||srv.name ELSE srv.name END as name_srv,drug.fg_highrisk,ci.fg_pres_outp,ci.Fg_wholepack,ci.fg_canc,srv.quan_medu,measdoc.name name_unit_medu"
				+ ",freq.name name_freq,route.name name_route,pat.name as pat_name"
				+ ",ip.name_bed as name_bed,bd.name as name_sex,ci.id_en,srv.sd_srvtp,ci.id_or,ci.orders,ci.Des_or,ci.dt_effe,ci.dt_stop,fg_stop "
				+ ",(case ci.fg_long when 'N' then '' else ci.dt_end end) dt_end,(case ci.fg_long when 'Y' then '长期' else '临时' end) fg_long ");
		sqlSb.append(" from ci_order ci left join ci_or_srv srv");
		sqlSb.append(" on ci.id_or=srv.id_or");
		sqlSb.append(" left join bd_measdoc measdoc");
		sqlSb.append(" on srv.id_medu = measdoc.id_measdoc");
		sqlSb.append(" left join bd_route route");
		sqlSb.append(" on srv.id_route = route.id_route");
		sqlSb.append(" left join pi_pat pat");
		sqlSb.append(" on ci.id_pat = pat.id_pat");
		sqlSb.append(" left join en_ent_ip ip");
		sqlSb.append(" on ci.id_en = ip.id_ent");
		sqlSb.append(" left join bd_freq freq");
		sqlSb.append(" on ci.id_freq = freq.id_freq");
		sqlSb.append(" left join bd_udidoc bd");
		sqlSb.append(" on pat.id_sex = bd.id_udidoc");
		sqlSb.append(" left join bd_srv_drug drug");
		sqlSb.append(" on ci.id_srv = drug.id_srv");
		sqlSb.append(" where ci.id_en in("+id_en+") and srv.sd_srvtp like '01%' ");

		sqlSb.append(" and "+this.getStrTime( sign, changeDate, end));
		sqlSb.append("  "+this.getStrYHZ(YHZ));
		sqlSb.append("  "+this.getStrLong(fg_long));
		if(!StringUtils.isBlank(name_freq)&&!"all".equals(name_freq)) {
			sqlSb.append(" and ci.id_freq = '"+name_freq+ "' ");
		}
//		if(!StringUtils.isBlank(name_route)&&!"all".equals(name_route)) {
//			sqlSb.append(" and srv.id_route = '"+name_route+ "' ");
//		}
		
		if(!StringUtils.isBlank(name_route)&&!"all".equals(name_route)) {
			String ss=this.formatStr(name_route);
			if(ss!=null) {
				sqlSb.append(" and srv.id_route in ("+ss+ ") ");
			}								
		}


		if(!StringUtils.isBlank(sd_srvtp)) {
			String[] srvtps=sd_srvtp.split(",");    
			StringBuilder sb=new StringBuilder();
			for (String s : srvtps) {
                sb.append(" srv.sd_srvtp like '"+s+"%' or ");
			}           
			String ss=sb.toString();
			if(!StringUtils.isBlank(ss)) {
				int i=ss.lastIndexOf("or");
				sqlSb.append(" and ( "+ss.substring(0,i)+")");
			}
		}
		//打印过滤
		sqlSb.append("  "+this.getIsPrint(print));
		
		sqlSb.append("  union all");
		sqlSb.append(" select CASE ci.fg_canc  WHEN 'Y' THEN '【作废】'||ci.name_or ELSE ci.name_or END as name_srv,drug.fg_highrisk,ci.fg_pres_outp,ci.fg_wholepack,ci.fg_canc,ci.quan_medu,measdoc.name name_unit_medu"
				+ ",freq.name name_freq,route.name name_route,pat.name as pat_name"
				+ ",ip.name_bed as name_bed,bd.name as name_sex,ci.id_en,ci.sd_srvtp,ci.id_or,ci.orders,ci.Des_or,ci.dt_effe,ci.dt_stop,fg_stop "
				+ ",(case ci.fg_long when 'N' then '' else ci.dt_end end) dt_end,(case ci.fg_long when 'Y' then '长期' else '临时' end) fg_long ");
		sqlSb.append(" from ci_order ci");
		sqlSb.append(" left join bd_measdoc measdoc");
		sqlSb.append(" on ci.id_unit_med = measdoc.id_measdoc");
		sqlSb.append(" left join bd_route route");
		sqlSb.append(" on ci.id_route = route.id_route");
		sqlSb.append(" left join pi_pat pat");
		sqlSb.append(" on ci.id_pat = pat.id_pat");
		sqlSb.append(" left join en_ent_ip ip");
		sqlSb.append(" on ci.id_en = ip.id_ent");
		sqlSb.append(" left join bd_freq freq");
		sqlSb.append(" on ci.id_freq = freq.id_freq");
		sqlSb.append(" left join bd_udidoc bd");
		sqlSb.append(" on pat.id_sex = bd.id_udidoc");
		sqlSb.append(" left join bd_srv_drug drug");
		sqlSb.append(" on ci.id_srv = drug.id_srv");
		sqlSb.append(" where ci.id_en in ("+id_en+") and ci.sd_srvtp not like '01%' ");
	    //时间过滤
		sqlSb.append(" and "+this.getStrTime( sign, changeDate, end));
		//医护嘱过滤
		sqlSb.append("  "+this.getStrYHZ(YHZ));
		//长临过滤
		sqlSb.append("  "+this.getStrLong(fg_long));
		//频次
		if(!StringUtils.isBlank(name_freq)&&!"all".equals(name_freq)) {
			sqlSb.append(" and ci.id_freq = '"+name_freq+ "' ");
		}
		//用法
//		if(!StringUtils.isBlank(name_route)&&!"all".equals(name_route)) {
//			sqlSb.append(" and ci.id_route = '"+name_route+ "' ");
//		}
		if(!StringUtils.isBlank(name_route)&&!"all".equals(name_route)) {
			String ss=this.formatStr(name_route);
			if(ss!=null) {
				sqlSb.append(" and ci.id_route in ("+ss+ ") ");
			}								
		}
		//服务类型
		if(!StringUtils.isBlank(sd_srvtp)) {
			String[] srvtps=sd_srvtp.split(",");    
			StringBuilder sb=new StringBuilder();
			for (String s : srvtps) {
                sb.append(" ci.sd_srvtp like '"+s+"%' or ");
			}           
			String ss=sb.toString();
			if(!StringUtils.isBlank(sd_srvtp)) {
				int i=ss.lastIndexOf("or");
				sqlSb.append(" and ( "+ss.substring(0,i)+")");
			}
		}
		//打印过滤
		sqlSb.append("  "+this.getIsPrint(print));
		sqlSb.append(this.getOrderByPart());
		return sqlSb.toString();
	}
	/**
	 * 是否打印过滤
	 * @param print
	 * @return
	 */
	private String getIsPrint(String print) {
		if(!StringUtils.isBlank(print)) {
			switch (print) {
			case "1"://已打印
				return" and ci.id_or in (select id_or from ci_or_change_prn) ";
			case "2"://未打印
				return" and ci.id_or not in (select id_or from ci_or_change_prn) ";
			default://全部
				return" ";
			}
		}
		return " ";
	}
	/**
 	 * 长期临时过滤
	 * @param fg_long
	 * @return
	 */
	private String getStrLong(String fg_long) {
		if(!StringUtils.isBlank(fg_long)) {
			switch (fg_long) {
			case "1"://长期
				return" and ci.fg_long = 'Y' ";
			case "2"://临时
				return" and ci.fg_long = 'N' ";
			default://全部
				return" ";
			}
		}
		return " ";
	}
	/**
	 * 医护嘱过滤
	 * @param YHZ
	 * @return
	 */
	private String getStrYHZ(String YHZ) {
		if(!StringUtils.isBlank(YHZ)) {
			switch (YHZ) {
			case "1"://医嘱
				return" and ci.sd_orsrcfun = '1' ";
			case "2"://护嘱
				return" and ci.sd_orsrcfun = '2' ";
			default://全部
				return" ";
			}
		}
		return " ";
	}
	/**
	 * 时间段过滤
	 * @param sign       全部0/签署医嘱1/停止医嘱2
	 * @param changeDate 开始时间
	 * @param end        截止时间
	 * @return
	 */
	private String  getStrTime(String sign,String changeDate,String end) {
		String begindate = (changeDate==""?this.dtNow.getBeginDate().toString()+" 00:00:00":changeDate);
		String endindate = (end==""?this.dtNow.getBeginDate().toString()+" 23:59:59":end);
		
		switch (sign) {
		case "1":
			return " ci.fg_sign='Y' and '"+begindate+"' <= ci.dt_sign and ci.dt_sign < ='"+endindate+"' ";
		case "2":
			return " ci.fg_stop='Y' and '"+begindate+"' <= ci.dt_end and ci.dt_end < ='"+endindate+"' ";
		default:
			return " ((ci.fg_sign='Y'and '"+begindate+"' <= ci.dt_sign and ci.dt_sign < ='"+endindate+"' ) or (ci.fg_stop='Y'  and '"+begindate+"' <= ci.dt_end and ci.dt_end < ='"+endindate+"' )) ";
		}
	}
	/**
	 * 变更打印表添加数据
	 * @return
	 */
	private String DoAddPrn() {
//		if(!StringUtils.isBlank(ordstatus)&&"Y".equals(ordstatus)) {
			
//		}
		return null;
		
	}
    /**
     * 排序规则
     * @return
     */
	private String getOrderByPart(){
		return " ) order by name_bed asc,dt_effe,id_or";
	}
	/**
	 * 设置患者的字段信息
	 * @param person
	 * @param map
	 */
	private void setPersonProperty(OrdChangePersonDTO person,Map<String,Object> map){
		person.setName(map.get("pat_name")==null?"":map.get("pat_name").toString());
		person.setName_sex(map.get("name_sex")==null?"":map.get("name_sex").toString());
		person.setName_bed(map.get("name_bed")==null?"":map.get("name_bed").toString());
	}
	/**
	 * 设置医嘱的字段信息
	 */
	private void setOrdInfoProperty(OrdChangeOrderInfoDTO ordInfo,Map<String,Object> map){
//		ordInfo.setName_srv(map.get("name_srv")==null?"":map.get("name_srv").toString());
		//获取高危标识
		String highName;
		if(map.get("fg_highrisk")==null){
		highName = "";
		}else{
		highName = map.get("fg_highrisk").equals("Y")?"【高危】":"";
		}
		//获取医嘱内容
		String NameSrv = (String) (map.get("name_srv")==null?"":map.get("name_srv"));
		//判断是否出院带药医嘱
		String PresOutp =map.get("fg_pres_outp").equals("N")?"":"(出院带药)";
		//判断是否在院整领
		String WholePack = map.get("fg_wholepack").equals("N")?"":"[在院整领]";
		//拼接医嘱内容	
		ordInfo.setName_srv((highName+NameSrv+PresOutp+WholePack).toString());
		ordInfo.setQuan_med(map.get("quan_medu")==null?null:new Double(map.get("quan_medu").toString()));
		ordInfo.setName_unit_med(map.get("name_unit_medu")==null?null:map.get("name_unit_medu").toString());
		ordInfo.setName_freq(map.get("name_freq")==null?"":map.get("name_freq").toString());
		ordInfo.setName_route(map.get("name_route")==null?"":map.get("name_route").toString());
		ordInfo.setDes_or(map.get("des_or")==null?"":map.get("des_or").toString());
		ordInfo.setFg_long(map.get("fg_long")==null?"":map.get("fg_long").toString());

			if(!StringUtils.isBlank((String) map.get("dt_stop"))) {
				ordInfo.setDt_stop(new FDateTime(map.get("dt_stop").toString()));
				}
			if(map.get("fg_stop").equals("Y")){
			 if(!StringUtils.isBlank((String) map.get("dt_end"))) {
				ordInfo.setDt_end(new FDateTime(map.get("dt_end").toString()));
				}
			}
		
		ordInfo.setDt_effe(new FDateTime(map.get("dt_effe").toString()));
	}
	/**
	 * 设置草药医嘱的字段信息
	 * @param ordInfo
	 * @param map
	 */
	private void setHerbOrdInfoProperty(OrdChangeOrderInfoDTO ordInfo,Map<String,Object> map){
		if("Y".equals( map.get("fg_canc") )) {
			ordInfo.setName_srv("【作废】草药" + map.get("orders") + "付：" + (map.get("des_or")==null?"":map.get("des_or").toString()));

		}else {
			ordInfo.setName_srv("草药" + map.get("orders") + "付：" + (map.get("des_or")==null?"":map.get("des_or").toString()));
		}
		ordInfo.setName_route(map.get("name_route")==null?"":map.get("name_route").toString());
		ordInfo.setDt_effe(new FDateTime(map.get("dt_effe").toString()));
		ordInfo.setDes_or(map.get("des_or")==null?"":map.get("des_or").toString());
		ordInfo.setFg_long(map.get("fg_long")==null?"":map.get("fg_long").toString());
	}
	
	private String formatStr(String vals) {
		if(StringUtils.isBlank(vals))
		   return null;
		String[] ss=vals.split(",");
		StringBuilder sb=new StringBuilder();
		for (String s : ss) {
			sb.append("'"+s+"',");
		}
		String str=sb.toString();
		if(!StringUtils.isBlank(str)) {
			int i=str.lastIndexOf(",");
			return str.substring(0,i);
		}
		return null;
	}
}
