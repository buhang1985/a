package iih.en.pv.s.listener.bp;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.deptrans.d.EnDepTransDO;
import iih.en.pv.deptrans.d.EnEuTrans;
import iih.en.pv.deptrans.i.IEndeptransCudService;
import iih.en.pv.deptrans.i.IEndeptransRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 
 * @author renzhi
 * 根据医嘱删除指定的就诊转科记录
 *
 */
public class EnIpTransDeptOrCancelCheckListenerBP {

    public void exec(CiOrderDO[] ors) throws BizException {
       if (EnValidator.isEmpty(ors)) {
           return;
       }
       this.execDelete(ors);
    }
    
    /**
     *根据医嘱删除指定就诊转科的记录
     * @param ors
     * @throws BizException
     */
    private void execDelete(CiOrderDO[] ors) throws BizException {
        if(!EnValidator.isEmpty(ors)){
        	for(CiOrderDO or : ors){
        		EnDepTransDO[] deleteDos = this.getData(or);
                this.deleteData(deleteDos);
        	}
        }
    }
    
    /**
     * 获取要删除的就诊转科记录
     * @throws BizException 
     */
    private EnDepTransDO[] getData(CiOrderDO ciOrderDO) throws BizException {
        
        IEndeptransRService RService  = ServiceFinder.find(IEndeptransRService.class);
        String whereStr = "id_ent = '" +ciOrderDO.getId_en()+"' AND Eu_trans ='"+ EnEuTrans.APPLY +"'  AND Id_or = '" +ciOrderDO.getId_or()+"' ";
        EnDepTransDO[] querydatas = RService.find(whereStr, "SV", FBoolean.FALSE);
        if (EnValidator.isEmpty(querydatas)) {
            return null;            
        }
        return querydatas;
    }
    
    /**
     * 删除指定的转科就诊记录
     * @throws BizException 
     */
    private void deleteData(EnDepTransDO[] deleteDo) throws BizException {
        IEndeptransCudService  cudService = ServiceFinder.find(IEndeptransCudService.class); 
        if (deleteDo != null) {
            cudService.delete(deleteDo);
        }
    }
    
}
