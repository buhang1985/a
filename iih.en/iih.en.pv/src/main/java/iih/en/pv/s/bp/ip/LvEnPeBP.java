package iih.en.pv.s.bp.ip;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.d.EnPeCmpyDO;
import iih.en.pv.inpatient.d.PeStatusEnum;
import iih.en.pv.inpatient.i.IEnpecmpyMDOCudService;
import iih.en.pv.inpatient.i.IEnpecmpyMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 团检出院
 * @author renying
 *
 */
public class LvEnPeBP {
	 /**
     * 出院
     * @param pecmpyId
     * @return
     * @throws BizException
     */
    public void exec(String pecmpyId)throws BizException{
    	
    	if(EnValidator.isEmpty(pecmpyId)){
    		return;
    	}	 	
    	this.updateEnpeCmpy(pecmpyId);
    	return;
    }
   
    /**
     * 更新住院信息
     * @param pecmyId
     * @throws BizException
     */
    private void updateEnpeCmpy(String pecmyId) throws BizException{
    	
    	IEnpecmpyMDORService enpecmpyRservice = ServiceFinder.find(IEnpecmpyMDORService.class);
    	IEnpecmpyMDOCudService enpecmpyCudService = ServiceFinder.find(IEnpecmpyMDOCudService.class);
    	EnPeCmpyDO enpecmpyDO = enpecmpyRservice.findById(pecmyId);
    	FDateTime curDate = EnAppUtils.getServerDateTime();
    	enpecmpyDO.setDt_e(curDate);
    	enpecmpyDO.setEu_status(PeStatusEnum.STATUS_PE_OUTHOS);
    	enpecmpyDO.setStatus(DOStatus.UPDATED);
    	enpecmpyCudService.save(new EnPeCmpyDO[] {enpecmpyDO});   	
    }

    
}
