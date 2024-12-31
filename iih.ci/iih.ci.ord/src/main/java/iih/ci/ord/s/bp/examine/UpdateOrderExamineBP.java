package iih.ci.ord.s.bp.examine;
/**
 * 药品的审核信息
 * @author li_zheng
 *
 */

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sie.common.utils.StringUtils;
import xap.sys.jdbc.facade.DAFacade;

public class UpdateOrderExamineBP {
  /**
     *  药品医嘱的审核信息
     * @param id_ors
     * @param id_emp_verify_pharm
     * @param eu_verify_pharm
     * @param des_verify_pharm
     * @throws BizException
     */
    public   void  updateOrderExamine(String[] id_ors,String id_emp_verify_pharm,
    		 Integer eu_verify_pharm,String des_verify_pharm) throws BizException{
		 if(id_ors== null || id_ors.length ==0 || StringUtils.isBlank(id_emp_verify_pharm)) return;
		 FDateTime dtNow = CiOrdAppUtils.getServerDateTime();
		 String[] arrayField = new String[] {CiOrderDO.ID_EMP_VERIFY_PHARM,CiOrderDO.EU_VERIFY_PHARM,CiOrderDO.DES_VERIFY_PHARM
				 ,CiOrderDO.DT_VERIFY_PHARM};
		 CiOrderDO[] ciorders =  CiOrdAppUtils.getOrQryService().findByBIds(id_ors, FBoolean.FALSE);
         for( CiOrderDO ord: ciorders) {
        	 ord.setId_emp_verify_pharm(id_emp_verify_pharm);
        	 ord.setEu_verify_pharm(eu_verify_pharm);
        	 ord.setDes_verify_pharm(des_verify_pharm);
        	 ord.setDt_verify_pharm(dtNow);
         }
         new DAFacade().updateDOArray(ciorders, arrayField);
    }


}
