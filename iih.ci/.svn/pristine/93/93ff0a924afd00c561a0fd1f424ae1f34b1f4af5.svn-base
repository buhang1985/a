package iih.ci.preip.imp.listen;

import iih.ci.preip.imp.bp.ImportPreIPOrdersBP;
import iih.en.pv.out.d.EnEvtDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;

/**
 * 监听就诊域预住院转住院事件
 * 
 * 接收到事件后，执行转正式医嘱更新逻辑
 * 
 * @author mkp
 *
 */
public class CiPreIPImportOrderEnEvtListener implements IBusinessListener {
    public static final String PRE_EN_EVENT_CODE = "042";

    @Override
    public void doAction(IBusinessEvent event) throws BizException {
        BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
        EnEvtDTO enEvtDTO = (EnEvtDTO) bizUserObj.getUserObj();
        
        // 校验事件
        if (!checkEvent(enEvtDTO)) {
            return;
        }
        
        // 导入
        ImportPreIPOrdersBP importBP = new ImportPreIPOrdersBP();
        importBP.exec(enEvtDTO.getId_ent(), enEvtDTO.getDt_evt(), enEvtDTO.getDt_insert(), enEvtDTO.getId_dep_oper(), enEvtDTO.getId_emp_rec());
    }

    /**
     * 校验事件有效性
     * @param enEvtDTO
     * @return
     */
    private boolean checkEvent(EnEvtDTO enEvtDTO) {
        if (enEvtDTO == null) {
            return false;
        }
        
        if (!PRE_EN_EVENT_CODE.equals(enEvtDTO.getSd_entevt())) {
            return false;
        }
        return true;
    }

}
