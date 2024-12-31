package iih.ci.event.ord.bps.revert.op.logicbp;

import java.util.List;
import java.util.Map;

import iih.ci.event.ord.bps.revert.op.query.OpOpRevertAllInfoQuery;
import iih.ci.event.ord.bps.zcommon.parambp.CommonParamBP;
import iih.ci.event.ord.utils.OrdEventFireDTO;
import iih.ci.event.ord.utils.OrdEventUtil;
import iih.ci.ord.iemsg.d.IEOpOrCancStpDTO;
import iih.ci.ord.iemsg.d.IEOpOrCancStpEnDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FDateTime;
/**
 * 门诊 手术撤回逻辑处理BS005
 * @author F
 *
 * @date 2019年9月11日下午1:12:35
 *
 * @classpath iih.ci.event.ord.bps.revert.op.logicbp.OpOpRevertLogicDealWithBP
 */
public class OpOpRevertLogicDealWithBP extends CommonParamBP{

	/**
	 * 生成集成平台门诊撤回医嘱服务数据信息
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpOrCancStpEnDTO[] exec(OrdEventFireDTO firedto) throws BizException{
		//有效性校验
		if(OrdEventUtil.isEmpty(firedto.getIdors()))return null;
		OpOpRevertAllInfoQuery query=new OpOpRevertAllInfoQuery(firedto.getIdors());
		//sql串
		String sql=query.getQrySQLStr();
		
		//获得门诊撤回医嘱数据信息  含主子两部分部分
		List<Map<String, Object>> listmap=OrdEventUtil.getRsMapList(sql);
		if(OrdEventUtil.isEmpty(listmap))return null;
		
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
	@SuppressWarnings("unchecked")
	private IEOpOrCancStpEnDTO getIEOrCancStpEnDTO(Map<String, Object> map){
		//需要映射生成主子结构DTO数据
		IEOpOrCancStpEnDTO cancelendto=new IEOpOrCancStpEnDTO();
		FArrayList2 fa=new FArrayList2();
		IEOpOrCancStpDTO canceldto=getIEOrCancStpDTO(map);
		fa.add(canceldto);
		
		cancelendto.setId_ieorcancstps(fa);
		cancelendto.setId_ieorcancstpen(OrdEventUtil.nullHandle(map.get("id_ieorcancstpen")));
		cancelendto.setPatient_id(OrdEventUtil.nullHandle(map.get("patient_id")));
		cancelendto.setTimes(map.get("times")==null?"0":map.get("times").toString());
		cancelendto.setExec_unit(OrdEventUtil.nullHandle(map.get("exec_unit")));
		cancelendto.setExec_unit_name(OrdEventUtil.nullHandle(map.get("exec_unit_name")));
		cancelendto.setDomain_id(OrdEventUtil.nullHandle(map.get("domain_id")));
		//IE集成平台差异新增 begin 2017-05-18 19:38:49
		cancelendto.setOrg_code(OrdEventUtil.nullHandle(map.get("org_code")));
		cancelendto.setOrg_name(OrdEventUtil.nullHandle(map.get("org_name")));
		cancelendto.setDept_code(OrdEventUtil.nullHandle(map.get("dept_code")));
		cancelendto.setDept_name(OrdEventUtil.nullHandle(map.get("dept_name")));
		cancelendto.setIemsgca_code(OrdEventUtil.nullHandle(map.get("iemsgca_code")));
		//end
		cancelendto.setVisitordno(OrdEventUtil.nullHandle(map.get("visitordno")));
		cancelendto.setVisittype(getParamCodeEntp(OrdEventUtil.nullHandle(map.get("visittype"))));
		cancelendto.setVisittypename(OrdEventUtil.nullHandle(map.get("visittypename")));
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
		canceldto.setId_ieorcancstpen(OrdEventUtil.nullHandle(map.get("id_ieorcancstpen")));
		canceldto.setId_ieorcancstp(OrdEventUtil.nullHandle(map.get("id_ieorcancstp")));
		canceldto.setOrder_id(OrdEventUtil.nullHandle(map.get("order_id")));
		canceldto.setOrder_type(OrdEventUtil.nullHandle(map.get("order_type")));//医嘱类别编码
		canceldto.setOrder_type_name(OrdEventUtil.nullHandle(map.get("order_type_name")));//医嘱类别名称
		canceldto.setSample_no(OrdEventUtil.nullHandle(map.get("sample_no")));
		canceldto.setCancel_date(map.get("cancel_date")==null?null:new FDateTime(map.get("cancel_date").toString()));
		canceldto.setCancel_opera(OrdEventUtil.nullHandle(map.get("cancel_opera")));
		canceldto.setCancel_opera_name(OrdEventUtil.nullHandle(map.get("cancel_opera_name")));
		canceldto.setCancel_reason(OrdEventUtil.nullHandle(map.get("cancel_reason")));
		canceldto.setMutex_order_no(OrdEventUtil.nullHandle(map.get("mutex_order_no")));
		canceldto.setMutex_order_type(OrdEventUtil.nullHandle(map.get("mutex_order_type")));
		canceldto.setMutex_order_name(OrdEventUtil.nullHandle(map.get("mutex_order_name")));
		//IE集成平台差异新增 begin 2017-05-18 19:38:56
		canceldto.setSequence_number(OrdEventUtil.nullHandle(map.get("sequence_number")));
		canceldto.setExec_unit(OrdEventUtil.nullHandle(map.get("exec_unit")));
		canceldto.setExec_unit_name(OrdEventUtil.nullHandle(map.get("exec_unit_name")));
		canceldto.setApply_code(OrdEventUtil.nullHandle(map.get("apply_code")));
		//end 
		canceldto.setPayflag(OrdEventUtil.nullHandle(map.get("payflag")));
		return canceldto;
	}
	
}
