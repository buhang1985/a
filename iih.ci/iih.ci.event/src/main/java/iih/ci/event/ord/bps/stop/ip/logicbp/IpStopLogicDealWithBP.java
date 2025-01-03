package iih.ci.event.ord.bps.stop.ip.logicbp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.ci.event.ord.bps.stop.ip.query.IpStopInfoQuery;
import iih.ci.event.ord.bps.stop.ip.sql.IpStopSql;
import iih.ci.event.ord.bps.zcommon.parambp.CommonParamBP;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventLogger;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOrCancStpDTO;
import iih.ci.ord.iemsg.d.IEOrCancStpEnDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 住院停止处理逻辑BS005
 * @author F
 *
 * @date 2019年9月3日上午11:46:34
 *
 * @classpath iih.ci.event.ord.bps.stop.ip.logicbp.IpStopLogicDealWithBP
 */
public class IpStopLogicDealWithBP extends CommonParamBP{

//	1)	BS005消息
//	①　	BS005消息增加【医嘱组号】元素
//	②　	医嘱组号：传值为医嘱号，Ci_order.code_or。
//	③　	医嘱号：传值为医嘱号，Ci_order.code_or。
//	2)	BS311消息
//	①　	BS311消息西药类、草药类节点下分别增加【医嘱组号】元素
//	②　	西成药赋值
//	a)	医嘱号：传医嘱下服务号，赋值规则如下
//	非成组医嘱时为医嘱编码：ci_order.code_or
//	成组医嘱时为医嘱编码+服务序号：ci_order.code_or+sortno
//	b)	医嘱组号：传值为医嘱号，Ci_order.code_or。
//	③　	草药赋值
//	a)	医嘱号：传ci_order.code_or（现状保持不变）
//	b)	医嘱组号：赋空值（本不应该添加该字段）
//	④　	BS311消息西药类、草药类节点下分别增加【用药目的编码】【用药目的名称】元素，其中草药类下用药目的两个元素不需要赋值。
//	⑤　	用药目的编码：ci_or_srv. sd_antipurpose
//	⑥　	用药目的名称：ci_or_srv. sd_antipurpose对应档案名称
//	3)	BS307消息
//	①　	该消息门诊和住院都有，当前医嘱号取值规则，门诊同BS302消息，住院同BS311消息。
//	②　	本次BS311调整后，BS307住院西成药的医嘱号取值要做相同处理，传医嘱下服务号，赋值规则如下：
//	非成组医嘱时为医嘱编码：ci_order.code_or
//	成组医嘱时为医嘱编码+服务序号：ci_order.code_or+sortno

	/**
	 * 新的逻辑处理
	 * @param firedto
	 * @return
	 * @throws BizException
	 */
	public IEOrCancStpEnDTO[] execNew(OrdEventFireDTO firedto) throws BizException{
        String sql=getSQlStr(firedto.getIdors());
		
		//获得住院停止医嘱数据信息  含主子两部分部分
		List<Map<String, Object>> listmap=OrdEventUtil.getRsMapList(sql);
		return getIEOrCancStpEnDTOsNew(listmap);
	}
	private IEOrCancStpEnDTO[] getIEOrCancStpEnDTOsNew(List<Map<String, Object>> list){
		if(OrdEventUtil.isEmpty(list)) {
			return null;
		}
		//现在去重在sql去的重，发消息时 签署了几条医嘱 停止作废时就发几条消息 不管草药还是西药 其他医嘱也是如此
		IEOrCancStpEnDTO[] rtndtos=new IEOrCancStpEnDTO[list.size()];
		for(int i=0;i<list.size();i++){
			rtndtos[i]=getIEOrCancStpEnDTO(list.get(i));
		}
		//返回
		return rtndtos;
	}
	/**
	 * 生成集成平台住院停止医嘱服务数据信息
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOrCancStpEnDTO[] exec(OrdEventFireDTO firedto) throws BizException{
		//有效性校验
		if(OrdEventUtil.isEmpty(firedto.getIdors()))return null;
		
		//获得停止医嘱信息
		IpStopInfoQuery qry = new IpStopInfoQuery(firedto.getIdors());
		IEOrCancStpDTO[] ords = (IEOrCancStpDTO[]) AppFwUtil.getDORstWithDao(qry, IEOrCancStpDTO.class);
		if(OrdEventUtil.isEmpty(ords))return null;
		//sql串
		String sql=getSQlStr(firedto.getIdors());
		
		//获得住院停止医嘱数据信息  含主子两部分部分
		List<Map<String, Object>> listmap=OrdEventUtil.getRsMapList(sql);
		if(OrdEventUtil.isEmpty(listmap))return null;
		//医嘱类型为草药时
		if(OrdEventUtil.SD_SRVTP_CYL.equals(ords[0].getOrdertype())){
			return getIEOrCancStpEnDTOs(firedto.getIdors(), listmap);
		}
		//获得住院停止医嘱数据信息数组 并返回
		return getIEOrCancStpEnDTOs(listmap);
	}
	
	/**
	 * 获得获得住院停止医嘱数据信息数组
	 * @param listmap
	 * @return
	 * @throws BizException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private IEOrCancStpEnDTO[] getIEOrCancStpEnDTOs(List<Map<String, Object>> list){
		int iN=list.size();
		IEOrCancStpEnDTO[] rtndtos=new IEOrCancStpEnDTO[iN];
		
		List<Map<String, Object>> resultList = new ArrayList();
		for (Map<String, Object> m : list){
			if(resultList.contains(m)){
				continue;
			}
			resultList.add(m);
		}
		//遍历
		for(int i=0;i<iN;i++){
			rtndtos[i]=getIEOrCancStpEnDTO(list.get(i));
		}
		
		//返回
		return rtndtos;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private IEOrCancStpEnDTO[] getIEOrCancStpEnDTOs(String id_ors,List<Map<String, Object>> list) throws BizException {
		
		List<Map<String, Object>> resultList = new ArrayList();
		//去重
		for (Map<String, Object> m : list){
			if(resultList.contains(m)){
				continue;
			}
			resultList.add(m);
		}
		int iN=resultList.size();
		IEOrCancStpEnDTO[] rtndtos=new IEOrCancStpEnDTO[iN];
		//遍历
		for(int i=0;i<iN;i++){
			rtndtos[i]=getIEOrCancStpEnDTO(list.get(i));
		}
		
		//返回
		return rtndtos;
	}
	/**
	 * 获得获得住院停止医嘱数据信息数组
	 * @param listmap
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private IEOrCancStpEnDTO getIEOrCancStpEnDTO(Map<String, Object> map){
		//需要映射生成主子结构DTO数据
		IEOrCancStpEnDTO cancelendto=new IEOrCancStpEnDTO();
		FArrayList2 fa=new FArrayList2();
		IEOrCancStpDTO canceldto=getIEOrCancStpDTO(map);
		fa.add(canceldto);
		
		cancelendto.setId_ieorcancstps(fa);
		cancelendto.setId_ieorcancstpen(OrdEventUtil.nullHandle(map.get("id_ieorcancstpen")));
		cancelendto.setPatientid(OrdEventUtil.nullHandle(map.get("patientid")));
		cancelendto.setAdmiss_times(map.get("admiss_times")==null?"0":map.get("admiss_times").toString());
		cancelendto.setExec_dept_code(OrdEventUtil.nullHandle(map.get("exec_dept_code")));
		cancelendto.setExec_dept_name(OrdEventUtil.nullHandle(map.get("exec_dept_name")));
		cancelendto.setDomain_id(OrdEventUtil.nullHandle(map.get("domain_id")));
		//IE集成平台差异新增 begin 2017-05-18 19:38:49
		cancelendto.setOrg_code(OrdEventUtil.nullHandle(map.get("org_code")));
		cancelendto.setOrg_name(OrdEventUtil.nullHandle(map.get("org_name")));
		cancelendto.setDept_code(OrdEventUtil.nullHandle(map.get("dept_code")));
		cancelendto.setDept_name(OrdEventUtil.nullHandle(map.get("dept_name")));
		cancelendto.setVisit_sort_no(OrdEventUtil.nullHandle(map.get("visit_sort_no")));//就诊流水号
		cancelendto.setVisit_type_code(getParamCodeEntp(map.get("visit_type_code").toString()));//就诊类型编码
		cancelendto.setVisit_type_name(OrdEventUtil.nullHandle(map.get("visit_type_name")));//就诊类型名称
		cancelendto.setApply_code(OrdEventUtil.nullHandle(map.get("apply_code")));
		//end
		return cancelendto;
	}
	
	/**
	 * 获得获得住院停止医嘱数据信息数组
	 * @param listmap
	 * @return
	 */
	private IEOrCancStpDTO getIEOrCancStpDTO(Map<String, Object> map){
		//需要映射生成主子结构DTO数据
		IEOrCancStpDTO canceldto=new IEOrCancStpDTO();
		canceldto.setId_ieorcancstpen(OrdEventUtil.nullHandle(map.get("id_ieorcancstpen")));
		canceldto.setId_ieorcancstp(OrdEventUtil.nullHandle(map.get("id_ieorcancstp")));
		canceldto.setOrderno(OrdEventUtil.nullHandle(map.get("orderno")));
		canceldto.setOrdertype(OrdEventUtil.nullHandle(map.get("ordertype")));
		canceldto.setBbno(OrdEventUtil.nullHandle(map.get("bbno")));
		canceldto.setCanceltime(map.get("canceltime")==null?null:new FDateTime(map.get("canceltime").toString()));
		canceldto.setCancelpersoncode(OrdEventUtil.nullHandle(map.get("cancelpersoncode")));
		canceldto.setCancelpersonname(OrdEventUtil.nullHandle(map.get("cancelpersonname")));
		canceldto.setYz_cancel_yy(OrdEventUtil.nullHandle(map.get("yz_cancel_yy")));
		canceldto.setHc_order_no(OrdEventUtil.nullHandle(map.get("hc_order_no")));
		canceldto.setHc_order_type_no(OrdEventUtil.nullHandle(map.get("hc_order_type_no")));
		canceldto.setHc_order_type_name(OrdEventUtil.nullHandle(map.get("hc_order_type_name")));
		//IE集成平台差异新增 begin 2017-05-18 19:38:56
		canceldto.setSequence_number(OrdEventUtil.nullHandle(map.get("sequence_number")));
		canceldto.setExec_unit(OrdEventUtil.nullHandle(map.get("exec_unit")));//执行科室编码
		canceldto.setExec_unit_name(OrdEventUtil.nullHandle(map.get("exec_unit_name")));//执行科室名称
		canceldto.setOrdertypename(OrdEventUtil.nullHandle(map.get("ordertypename")));//医嘱的类型名称
		canceldto.setIemsgca_code(OrdEventUtil.nullHandle(map.get("iemsgca_code")));
		canceldto.setPayflag(OrdEventUtil.nullHandle(map.get("payflag")));
		canceldto.setOrdergroupid(OrdEventUtil.nullHandle(map.get("ordergroupid")));//医嘱组号
		//end 
		return canceldto;
	}
	
	/**
	 * 获得 SQL串 
	 * @param id_or
	 * @return
	 */
	private String getSQlStr(String id_ors){
		String id_or4sql=OrdEventUtil.getSqlInOrEqualStrs(id_ors);
		String formatsql=new IpStopSql().getIpStopSql(id_or4sql);
		OrdEventLogger.info(this.getClass().getSimpleName(), "BS005 住院 停止信息sql:"+formatsql);
		return formatsql;
	}
}
