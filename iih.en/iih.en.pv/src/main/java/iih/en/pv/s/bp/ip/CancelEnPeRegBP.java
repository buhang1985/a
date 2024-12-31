package iih.en.pv.s.bp.ip;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.enfee.d.EnPeCmpyACCDO;
import iih.en.pv.enfee.i.IEnpecmpyaccCudService;
import iih.en.pv.enfee.i.IEnpecmpyaccRService;
import iih.en.pv.inpatient.d.EnPeCmpyDO;
import iih.en.pv.inpatient.d.EnPeCmpyItmDO;
import iih.en.pv.inpatient.i.IEnPeCmpyItmDOCudService;
import iih.en.pv.inpatient.i.IEnPeCmpyItmDORService;
import iih.en.pv.inpatient.i.IEnpecmpyMDOCudService;
import iih.en.pv.inpatient.i.IEnpecmpyMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 取消团检入院
 * @author renying
 *
 */
public class CancelEnPeRegBP {
	 /**
     * 取消入院
     * @param pecmpyId
     * @return
     * @throws BizException
     */
    public void exec(String pecmpyId)throws BizException{
    	if(EnValidator.isEmpty(pecmpyId))
    		return;   	
        this.deleteEnPeCmpyItm(pecmpyId);
        this.deleteEnPeCmpy(pecmpyId);
        this.deletEmpeCmpyAcc(pecmpyId);
    	return ;
    } 
    
    /**
     * 删除团检详细
     * @param pecmpyId
     * @return
     */
    private void deleteEnPeCmpyItm(String pecmpyId) throws BizException{	
    	IEnPeCmpyItmDORService enpecmpyItmRService = ServiceFinder.find(IEnPeCmpyItmDORService.class);
    	IEnPeCmpyItmDOCudService enpecmpyItmCudService = ServiceFinder.find(IEnPeCmpyItmDOCudService.class);
    	EnPeCmpyItmDO[] enpecmpyItmDO = enpecmpyItmRService.findByAttrValString(EnPeCmpyItmDO.ID_PECMPY, pecmpyId);
    	if(EnValidator.isEmpty(enpecmpyItmDO))
    		return;
    	enpecmpyItmCudService.delete(enpecmpyItmDO);
    	
    }
    
    /**
     * 删除团检记录
     * @param pecmpyId
     * @return
     */
    private void deleteEnPeCmpy(String pecmpyId) throws BizException{
    	IEnpecmpyMDORService enpecmpyRService = ServiceFinder.find(IEnpecmpyMDORService.class);
    	IEnpecmpyMDOCudService enpecmpyCudService = ServiceFinder.find(IEnpecmpyMDOCudService.class);
    	EnPeCmpyDO enpecmpyDO = enpecmpyRService.findById(pecmpyId);
    	if(enpecmpyDO == null)
    		return;
    	enpecmpyDO.setStatus(DOStatus.DELETED);
    	enpecmpyCudService.save(new EnPeCmpyDO[] {enpecmpyDO});
    }
    
    /**
     * 删除团检账户
     * @param pecmpyId
     * @throws BizException
     */
    private void deletEmpeCmpyAcc(String pecmpyId) throws BizException{
    	IEnpecmpyaccRService pecmpyaccRservice = ServiceFinder.find(IEnpecmpyaccRService.class);
    	IEnpecmpyaccCudService pecmpyaccCudService = ServiceFinder.find(IEnpecmpyaccCudService.class);
    	EnPeCmpyACCDO[] enpecmpyACCDO = pecmpyaccRservice.findByAttrValString(EnPeCmpyACCDO.ID_PECMPY, pecmpyId);
    	if(EnValidator.isEmpty(enpecmpyACCDO))
    		return;
    	pecmpyaccCudService.delete(enpecmpyACCDO);
    }
}