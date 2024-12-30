package iih.sc.apt.s.task;

import iih.sc.apt.s.task.bp.CancelReservationBP;
import xap.mw.core.data.BizException;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

public class CancelReservationTask implements IBackgroundWorkPlugin {

    @Override
    public PreAlertObject executeTask(BgWorkingContext arg0) throws BizException {
        CancelReservationBP bp = new CancelReservationBP();
        bp.exec();
        PreAlertObject obj = new PreAlertObject();
        
        return obj;
    }

}
