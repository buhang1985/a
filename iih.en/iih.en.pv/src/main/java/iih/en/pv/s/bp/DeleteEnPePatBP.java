package iih.en.pv.s.bp;

import iih.en.pv.inpatient.d.EnPeCmpyDO;
import iih.en.pv.inpatient.dto.d.EnPeCmpyDTO;
import iih.en.pv.inpatient.i.IEnpecmpyMDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 
 * @author renzhi
 *
 */
public class DeleteEnPePatBP {

    /**
     * 删除团检明细记录
     * @param qryDTO
     * @throws BizException 
     */
    public void exec(EnPeCmpyDTO qryDTO) throws BizException {
        if (qryDTO == null || qryDTO.getId_pecmpy() == null) {
            return;
        }
        this.deleteDo(qryDTO);
        
    }
    
    /**
     * 根据团检id删除
     * @param qryDTO
     * @throws BizException 
     */
    private void deleteDo(EnPeCmpyDTO qryDTO) throws BizException {
        IEnpecmpyMDOCudService doService = ServiceFinder.find(IEnpecmpyMDOCudService.class);
        EnPeCmpyDO[] dos  = new EnPeCmpyDO[1];
        dos[1]= this.getEnPeCmpyDo(qryDTO);
        doService.delete(dos);
    }

    private EnPeCmpyDO getEnPeCmpyDo(EnPeCmpyDTO qryDTO) {
        EnPeCmpyDO delDo = new EnPeCmpyDO();
        delDo.setId_pecmpy(qryDTO.getId_pecmpy());
        delDo.setId_cust_cmpy(qryDTO.getId_cust_cmpy());
        return delDo;
    }
    
}
