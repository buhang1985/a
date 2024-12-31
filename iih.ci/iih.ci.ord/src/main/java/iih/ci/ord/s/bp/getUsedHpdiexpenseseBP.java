package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.i.external.obtain.ICiOrdBlRService;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 删除自费诊断的提示
 * @author li_zheng
 *
 */
public class getUsedHpdiexpenseseBP {
	
	private ICiOrdBlRService ciOrdBlRService;
	
	public getUsedHpdiexpenseseBP(){
		ciOrdBlRService = (ICiOrdBlRService)ServiceFinder.find(ICiOrdBlRService.class.getName());
	}
	
	/**
	 * 通过费用接口判断保外诊断下是否有未结算的医嘱
	 * @author yzh
	 * @param id_en
	 * @param Id_didef
	 * @return
	 * @throws BizException
	 */
	public String JudgeOwnExpenseDiag(String id_en, String Id_didef)throws BizException{
		
		String[] idOrSrvs= getEffectiveCiorderAggDO(id_en);
		if(idOrSrvs== null || idOrSrvs.length==0) return null;
		
		// 刪除自费诊断时 需要校验是否存在未结算的服务项目，如果存在未结算项目，并且不存在其他自费诊断时，不允许删除当前的自费诊断
		Map<String, FBoolean> map = ciOrdBlRService.getOrSrvBlStatus(idOrSrvs);
		
		for(FBoolean value : map.values()){
			if(FBoolean.FALSE.equals(value)){
				return "有自费诊断不能删除"; 
			}
		}
		
		return null;
		
	/*	String key =  MapToString(map);
		if(key  != null){
			 String sql = " Id_didef ='"+ Id_didef +"' and Fg_entp_op ='Y' ";
			 BdHpDiExpenseSelfDO[] hpDiag= CiOrdAppUtils.getIHpdiexpenseself().find(sql, "", FBoolean.FALSE);
			 if(hpDiag != null && hpDiag.length >0){
				 return "有自费诊断不能删除"; 
			  } 
	  	 } */
       
	}
	
	private  Map<String,String> getHpdiexpensese(FArrayList2 list2){
		Map map = new HashMap();
		if(list2 != null && list2.size() >0){
			for(int i =0;i<list2.size();i++){
				CiDiagItemDO itemDO =(CiDiagItemDO)list2.get(i);
				if(itemDO != null && "1".equals(itemDO.getEu_hpbeyond())){
					map.put(itemDO.getId_didef(), itemDO.getId_didef_code());
				}
			}
		}
		return map;
	}
	/**
	 * 有效医嘱的项目
	 * @param id_ent
	 * @return
	 */
	private String[] getEffectiveCiorderAggDO(String id_ent)throws BizException{
		 List list = new ArrayList();
		 String  ci_ordersql = " id_en ='"+id_ent+"' and fg_canc='N' and sd_su_bl != '2' ";
		 CiorderAggDO[] aggs = CiOrdAppUtils.getOrAggQryService().find(ci_ordersql, "", FBoolean.FALSE);
		 if(aggs != null && aggs.length >0)	{
			 if(aggs != null && aggs.length >0){
				 for(CiorderAggDO aggdo: aggs){
					for(OrdSrvDO ordsrvdo :aggdo.getOrdSrvDO()){
						list.add(ordsrvdo.getId_orsrv());
					}  
				  }
	           }
          }
		 if(list != null && list.size() >0){
			 return (String[])list.toArray(new String[list.size()]); 
		 }
		return null;
   }
	/**
	 * 
	 * @param map
	 * @return
	 */
    private String MapToString(FMap map){
		if(map ==null || map.size()==0)return null;
		StringBuffer sb = new StringBuffer();
		for(String key : map.keySet()){ 
			   FBoolean  value = (FBoolean)map.get(key);
			   if(FBoolean.FALSE.equals(value)){
				 return key;
			   }
		} 
		return null;
	}		
}
