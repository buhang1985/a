package iih.ci.ord.s.bp.iemsg;

import java.util.List;
import java.util.Map;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.iemsg.d.IEOpOrCancStpDTO;
import iih.ci.ord.iemsg.d.IEOpOrCancStpEnDTO;
import iih.ci.ord.iemsg.d.IEOrCancStpDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FDateTime;

/**
 * 门诊集成平台撤回医嘱服务数据信息操作BP
 * @author yangz
 */
public class GetIEMsgOpInfo4CancStpBP {
	/**
	 * 生成集成平台门诊撤回医嘱服务数据信息
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpOrCancStpEnDTO[] exec(String id_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		//sql串
		String sql=getSQlStr(id_ors);
		
		//获得门诊撤回医嘱数据信息  含主子两部分部分
		List<Map<String, Object>> listmap=CiOrdUtils.getRsMapList(sql);
		if(CiOrdUtils.isEmpty(listmap))return null;
		
		//获得门诊撤回医嘱数据信息数组 并返回
		return getIEOrCancStpEnDTOs(listmap);
	}
	
	/**
	 * 获得获得门诊撤回医嘱数据信息数组
	 * @param listmap
	 * @return
	 */
	private IEOpOrCancStpEnDTO[] getIEOrCancStpEnDTOs(List<Map<String, Object>> listmap){
		int iN=listmap.size();
		IEOpOrCancStpEnDTO[] rtndtos=new IEOpOrCancStpEnDTO[iN];
		
		//遍历
		for(int i=0;i<iN;i++){
			rtndtos[i]=getIEOrCancStpEnDTO(listmap.get(i));
		}
		
		//返回
		return rtndtos;
	}
	
	/**
	 * 获得获得门诊撤回医嘱数据信息数组
	 * @param listmap
	 * @return
	 */
	private IEOpOrCancStpEnDTO getIEOrCancStpEnDTO(Map<String, Object> map){
		//需要映射生成主子结构DTO数据
		IEOpOrCancStpEnDTO cancelendto=new IEOpOrCancStpEnDTO();
		FArrayList2 fa=new FArrayList2();
		IEOpOrCancStpDTO canceldto=getIEOrCancStpDTO(map);
		fa.add(canceldto);
		
		cancelendto.setId_ieorcancstps(fa);
		cancelendto.setId_ieorcancstpen(CiOrdUtils.nullHandle(map.get("id_ieorcancstpen")));
		cancelendto.setPatient_id(CiOrdUtils.nullHandle(map.get("patient_id")));
		cancelendto.setTimes(CiOrdUtils.nullHandle(map.get("times")));
		cancelendto.setExec_unit(CiOrdUtils.nullHandle(map.get("exec_unit")));
		cancelendto.setExec_unit_name(CiOrdUtils.nullHandle(map.get("exec_unit_name")));
		cancelendto.setDomain_id(CiOrdUtils.nullHandle(map.get("domain_id")));
		//IE集成平台差异新增 begin 2017-05-18 19:38:49
		cancelendto.setOrg_code(CiOrdUtils.nullHandle(map.get("org_code")));
		cancelendto.setOrg_name(CiOrdUtils.nullHandle(map.get("org_name")));
		cancelendto.setDept_code(CiOrdUtils.nullHandle(map.get("dept_code")));
		cancelendto.setDept_name(CiOrdUtils.nullHandle(map.get("dept_name")));
		cancelendto.setIemsgca_code(CiOrdUtils.nullHandle(map.get("iemsgca_code")));
		//end
		cancelendto.setVisitordno(CiOrdUtils.nullHandle(map.get("visitordno")));
		cancelendto.setVisittype(CiOrdUtils.nullHandle(map.get("visittype")));
		cancelendto.setVisittypename(CiOrdUtils.nullHandle(map.get("visittypename")));
		return cancelendto;
	}
	
	/**
	 * 获得获得门诊撤回医嘱数据信息数组
	 * @param listmap
	 * @return
	 */
	private IEOpOrCancStpDTO getIEOrCancStpDTO(Map<String, Object> map){
		//需要映射生成主子结构DTO数据
		
		 
		IEOpOrCancStpDTO canceldto=new IEOpOrCancStpDTO();
		canceldto.setId_ieorcancstpen(CiOrdUtils.nullHandle(map.get("id_ieorcancstpen")));
		canceldto.setId_ieorcancstp(CiOrdUtils.nullHandle(map.get("id_ieorcancstp")));
		canceldto.setOrder_id(CiOrdUtils.nullHandle(map.get("order_id")));
		canceldto.setOrder_type(CiOrdUtils.nullHandle(map.get("order_type")));//医嘱类别编码
		canceldto.setOrder_type_name(CiOrdUtils.nullHandle(map.get("order_type_name")));//医嘱类别名称
		canceldto.setSample_no(CiOrdUtils.nullHandle(map.get("sample_no")));
		canceldto.setCancel_date(map.get("cancel_date")==null?null:new FDateTime(map.get("cancel_date").toString()));
		canceldto.setCancel_opera(CiOrdUtils.nullHandle(map.get("cancel_opera")));
		canceldto.setCancel_opera_name(CiOrdUtils.nullHandle(map.get("cancel_opera_name")));
		canceldto.setCancel_reason(CiOrdUtils.nullHandle(map.get("cancel_reason")));
		canceldto.setMutex_order_no(CiOrdUtils.nullHandle(map.get("mutex_order_no")));
		canceldto.setMutex_order_type(CiOrdUtils.nullHandle(map.get("mutex_order_type")));
		canceldto.setMutex_order_name(CiOrdUtils.nullHandle(map.get("mutex_order_name")));
		//IE集成平台差异新增 begin 2017-05-18 19:38:56
		canceldto.setSequence_number(CiOrdUtils.nullHandle(map.get("sequence_number")));
		canceldto.setExec_unit(CiOrdUtils.nullHandle(map.get("exec_unit")));
		canceldto.setExec_unit_name(CiOrdUtils.nullHandle(map.get("exec_unit_name")));
		canceldto.setApply_code(CiOrdUtils.nullHandle(map.get("apply_code")));
		//end 
		return canceldto;
	}
	
	/**
	 * 获得 SQL串 
	 * @param id_or
	 * @return
	 */
	private String getSQlStr(String id_ors){
		String formatsql=new CiIEMsgRelSqlConst().CI_IE_ORCANCEL_OP_SQL();
		String id_or4sql=CiOrdUtils.getSqlInOrEqualStrs(id_ors);
		CiEnContextDTO ctx = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		 OrdBizLogger.info(ctx, "BS007 手术 门诊撤回 IEOpOpOrEnDTO sql:"+String.format(formatsql, "A.id_or"+id_or4sql));
		return String.format(formatsql, "A.id_or"+id_or4sql);
	}
}
