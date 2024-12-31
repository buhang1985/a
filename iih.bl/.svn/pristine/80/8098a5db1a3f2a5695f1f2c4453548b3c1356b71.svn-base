package iih.bl.hp.hpque.bp;

import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bl.cg.d.SpecillDTO;
import iih.bl.hp.rule.qry.GetFgSpecillByRuleQry;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 检查医嘱是否为特殊病
 * @author LIM
 *
 */
public class CheckSpecillBP {
	/**
	 * 判断当前物品 是否是特殊病药品
	 * @param mmId
	 * @param entId
	 * @param dilist
	 * @return
	 * @throws BizException 
	 */
	public FBoolean exec(String mmId,String entId,FArrayList2 dilist) throws BizException{
		SpecillDTO[] spmmcidDtos = (SpecillDTO[]) AppFwUtil.getDORstWithDao(new GetFgSpecillByRuleQry(mmId, entId), SpecillDTO.class);
		if(!ArrayUtil.isEmpty(spmmcidDtos)&&dilist!=null&&dilist.size()!=0){
			for (Object diItmObj : dilist.toArray()) {
				if (diItmObj == null)
					continue;
				String codeDi="";
				//开单校验和诊断依赖校验所传入对象区分diItmObj
				if(diItmObj.getClass().equals(DiagDefDO.class)){
					DiagDefDO diItm= (DiagDefDO)diItmObj;
					codeDi=diItm.getCode();
				}
				else if(diItmObj.getClass().equals(CiDiagItemDO.class)){
					CiDiagItemDO diItm= (CiDiagItemDO)diItmObj;
					codeDi=diItm.getDidef_code();
				}else {
					continue;
				}
				if(codeDi.equals(spmmcidDtos[0].getCode_di()))
					return FBoolean.TRUE;
				
				
			}
		}
		
		return FBoolean.FALSE;
	}
}
