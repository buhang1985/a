package iih.ci.ord.s.bp.iemsg;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.bd.bc.event.pub.IBdSrvIEEventConst;
import iih.ci.ord.iemsg.d.IEOrCancStpDTO;
import iih.ci.ord.iemsg.d.IEOrCancStpEnDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiCanclStpOrQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 生成集成平台住院作废核对或停核医嘱服务数据信息操作BP
 */
public class GetIEMsgInfo4CancStpBP {
	/**
	 * 生成集成平台住院作废核对或停核医嘱服务数据信息
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOrCancStpEnDTO[] exec(String id_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		//获得作废医嘱信息
		CiCanclStpOrQry qry = new CiCanclStpOrQry(id_ors);
		IEOrCancStpDTO[] ords = (IEOrCancStpDTO[]) AppFwUtil.getDORstWithDao(qry, IEOrCancStpDTO.class);
		if(CiOrdUtils.isEmpty(ords))return null;
		//sql串
		String sql=getSQlStr(id_ors);
		
		//获得住院作废核对或停核医嘱数据信息  含主子两部分部分
		List<Map<String, Object>> listmap=CiOrdUtils.getRsMapList(sql);
		if(CiOrdUtils.isEmpty(listmap))return null;
		//医嘱类型为草药时
		if(IBdSrvIEEventConst.SD_SRVTP_CYL.equals(ords[0].getOrdertype())){
			return getIEOrCancStpEnDTOs(id_ors, listmap);
		}
		//获得住院作废核对或停核医嘱数据信息数组 并返回
		return getIEOrCancStpEnDTOs(listmap);
	}
	
	/**
	 * 获得获得住院作废核对或停核医嘱数据信息数组
	 * @param listmap
	 * @return
	 * @throws BizException 
	 */
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
	 * 获得获得住院作废核对或停核医嘱数据信息数组
	 * @param listmap
	 * @return
	 */
	private IEOrCancStpEnDTO getIEOrCancStpEnDTO(Map<String, Object> map){
		//需要映射生成主子结构DTO数据
		IEOrCancStpEnDTO cancelendto=new IEOrCancStpEnDTO();
		FArrayList2 fa=new FArrayList2();
		IEOrCancStpDTO canceldto=getIEOrCancStpDTO(map);
		fa.add(canceldto);
		
		cancelendto.setId_ieorcancstps(fa);
		cancelendto.setId_ieorcancstpen(CiOrdUtils.nullHandle(map.get("id_ieorcancstpen")));
		cancelendto.setPatientid(CiOrdUtils.nullHandle(map.get("patientid")));
		cancelendto.setAdmiss_times(CiOrdUtils.nullHandle(map.get("admiss_times")));
		cancelendto.setExec_dept_code(CiOrdUtils.nullHandle(map.get("exec_dept_code")));
		cancelendto.setExec_dept_name(CiOrdUtils.nullHandle(map.get("exec_dept_name")));
		cancelendto.setDomain_id(CiOrdUtils.nullHandle(map.get("domain_id")));
		//IE集成平台差异新增 begin 2017-05-18 19:38:49
		cancelendto.setOrg_code(CiOrdUtils.nullHandle(map.get("org_code")));
		cancelendto.setOrg_name(CiOrdUtils.nullHandle(map.get("org_name")));
		cancelendto.setDept_code(CiOrdUtils.nullHandle(map.get("dept_code")));
		cancelendto.setDept_name(CiOrdUtils.nullHandle(map.get("dept_name")));
		cancelendto.setVisit_sort_no(CiOrdUtils.nullHandle(map.get("visit_sort_no")));//就诊流水号
		cancelendto.setVisit_type_code(CiOrdUtils.nullHandle(map.get("visit_type_code")));//就诊类型编码
		cancelendto.setVisit_type_name(CiOrdUtils.nullHandle(map.get("visit_type_name")));//就诊类型名称
		cancelendto.setApply_code(CiOrdUtils.nullHandle(map.get("apply_code")));
		//end
		return cancelendto;
	}
	
	/**
	 * 获得获得住院作废核对或停核医嘱数据信息数组
	 * @param listmap
	 * @return
	 */
	private IEOrCancStpDTO getIEOrCancStpDTO(Map<String, Object> map){
		//需要映射生成主子结构DTO数据
		
		 
		IEOrCancStpDTO canceldto=new IEOrCancStpDTO();
		canceldto.setId_ieorcancstpen(CiOrdUtils.nullHandle(map.get("id_ieorcancstpen")));
		canceldto.setId_ieorcancstp(CiOrdUtils.nullHandle(map.get("id_ieorcancstp")));
		canceldto.setOrderno(CiOrdUtils.nullHandle(map.get("orderno")));
		canceldto.setOrdertype(CiOrdUtils.nullHandle(map.get("ordertype")));
		canceldto.setBbno(CiOrdUtils.nullHandle(map.get("bbno")));
		canceldto.setCanceltime(map.get("canceltime")==null?null:new FDateTime(map.get("canceltime").toString()));
		canceldto.setCancelpersoncode(CiOrdUtils.nullHandle(map.get("cancelpersoncode")));
		canceldto.setCancelpersonname(CiOrdUtils.nullHandle(map.get("cancelpersonname")));
		canceldto.setYz_cancel_yy(CiOrdUtils.nullHandle(map.get("yz_cancel_yy")));
		canceldto.setHc_order_no(CiOrdUtils.nullHandle(map.get("hc_order_no")));
		canceldto.setHc_order_type_no(CiOrdUtils.nullHandle(map.get("hc_order_type_no")));
		canceldto.setHc_order_type_name(CiOrdUtils.nullHandle(map.get("hc_order_type_name")));
		//IE集成平台差异新增 begin 2017-05-18 19:38:56
		canceldto.setSequence_number(CiOrdUtils.nullHandle(map.get("sequence_number")));
		canceldto.setExec_unit(CiOrdUtils.nullHandle(map.get("exec_unit")));//执行科室编码
		canceldto.setExec_unit_name(CiOrdUtils.nullHandle(map.get("exec_unit_name")));//执行科室名称
		canceldto.setOrdertypename(CiOrdUtils.nullHandle(map.get("ordertypename")));//医嘱的类型名称
		canceldto.setIemsgca_code(CiOrdUtils.nullHandle(map.get("iemsgca_code")));
		//end 
		return canceldto;
	}
	
	/**
	 * 获得 SQL串 
	 * @param id_or
	 * @return
	 */
	private String getSQlStr(String id_ors){
		String id_or4sql=CiOrdUtils.getSqlInOrEqualStrs(id_ors);
		String formatsql=new CiIEMsgRelSqlConst().CI_IE_ORCANCEL_SQL(id_or4sql);
		return formatsql;
	}
	
}
