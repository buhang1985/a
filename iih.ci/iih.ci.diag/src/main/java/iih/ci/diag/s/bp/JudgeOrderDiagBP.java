/**
 * 
 */
package iih.ci.diag.s.bp;

import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.pub.CiDiAppUtils;
import iih.ci.diag.s.CiDiUtils;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.HpBeyondEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;

/**
 * @ClassName: JudgeOrderDiagBP
 * @Description: 判断诊断和医保的关系
 * @author Comsys-li_zheng
 * @date 2016年12月26日 下午3:19:40
 * @Package iih.ci.diag.s.bp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class JudgeOrderDiagBP {

	//医嘱的信息
	/**
	 * 判断诊断和医嘱的关系
	 * @param aggDO
	 * @param cienContextDTO
	 */
	public void JudgeOrderDiag(CidiagAggDO aggDO,CiEnContextDTO cienContextDTO)throws BizException{
		if(cienContextDTO != null && cienContextDTO.getId_hp() != null){
			updateCiOrderBhpjudgerst(cienContextDTO);
		}
	}
	/**
	 * 医保外的诊断
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	private String getHpDaig(String id_en)throws BizException{
		CidiagAggDO[] aggDO = CiDiAppUtils.getICidiagQryService().getLastCiDiags(id_en);
	     String id_didef =   null;//bd 诊断的 id
		 if(aggDO != null && aggDO.length >0){
	    	for(CidiagAggDO aggdo:aggDO){
	    		if(aggdo != null && aggdo.getCiDiagItemDO().length >0){
	    			for(CiDiagItemDO item:aggdo.getCiDiagItemDO()){
	    				if(HpBeyondEnum.HPEXTERNALDIAG.equals(item.getEu_hpbeyond())){
	    					id_didef += ","+item.getId_didef();
	    				}
	    			}
	    		}
	    	}
			 
	     }
		 
		 if(id_didef != null){
			 return id_didef.substring(1);
		 }
	     return  id_didef;
	}
	
	/**
	 * 更新医嘱的保外诊断信息
	 * @param cienContextDTO
	 * @throws BizException
	 */
	private void updateCiOrderBhpjudgerst(CiEnContextDTO cienContextDTO)throws BizException{
		if(cienContextDTO != null && cienContextDTO.getDes_bhpjudgerst() != null){
			CiDiAppUtils.getICiOrdMaintainService().updateCiOrderBhpjudgerst(cienContextDTO);
		}
		
	}
	
	
	/**
	 * 判断医嘱有
	 * @param id_ent
	 * @param id_didef
	 * @return
	 * @throws BizException
	 */
	private boolean getOrders(String id_ent,String id_didef)throws BizException{
		boolean IsOrder = false;
		CiOrderDO[] orders = CiDiAppUtils.getICiOrdQryService().getCiOrdersUsedHpCiDi(id_ent,id_didef);
		if(orders == null || orders.length ==0){
			IsOrder = false;
		}else{
			IsOrder = true;
		}
		return IsOrder;
	}
}
