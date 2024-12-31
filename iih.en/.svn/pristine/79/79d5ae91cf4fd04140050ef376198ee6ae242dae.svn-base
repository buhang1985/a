package iih.en.pv.s.bp.ip;

import iih.en.pv.enfee.d.EnPeCmpyACCDO;
import iih.en.pv.enfee.i.IEnpecmpyaccCudService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 
 * @author renzhi
 * 新增团检账号
 *
 */
public class SaveEnPeCmpyACCDOBP {

    /**
     * 根据服务新增团检账户记录
     * @param enPeCmpyDO
     * @throws BizException 
     */
    public void serviceExec(EnPeCmpyACCDO saveDo) throws BizException {
        //获取团检账户服务
        IEnpecmpyaccCudService enpeService = ServiceFinder.find(IEnpecmpyaccCudService.class);
        enpeService.insert( new EnPeCmpyACCDO[] {saveDo});
    }

}
