package iih.ci.preop.order.bp;

import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.sdk.ems.meta.ErrorEmsList;
import iih.ci.tsip.d.CiTsOrDO;
import iih.ci.tsip.i.ICitsorderMDORService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class OrderDeleteValidateBP {
    
    /**
     * 检验是否导入
     * @param szCode_tsorder
     * @return
     * @throws BizException 
     */
    public ErrorEmsList validateImported(String[] szCode_tsorder) throws BizException {
        ErrorEmsList result = new ErrorEmsList();
        
        if (szCode_tsorder == null || szCode_tsorder.length == 0) {
            return null;
        }
        
        ICitsorderMDORService orderService = ServiceFinder.find(ICitsorderMDORService.class);
        CiTsOrDO[] ciTsOrs = orderService.findByAttrValStrings(CiTsOrDO.CODE_OR, szCode_tsorder);
        if (ciTsOrs == null || ciTsOrs.length == 0) {
            return null;
        }

        for (CiTsOrDO tsOrder : ciTsOrs) {
            if ("20".equals(tsOrder.getSd_su_ts_mp())) {
                ErrorEmsDTO errorEmsDTO = new ErrorEmsDTO();
                errorEmsDTO.setCode_or(tsOrder.getCode_or());
                errorEmsDTO.setName_or(tsOrder.getName_or());
                errorEmsDTO.setError_message("已导入的预住院申请不允许删除");
                result.add(errorEmsDTO);
            }
        }
        return result;
    }
}
