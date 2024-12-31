package iih.ci.mr.s.bp.task;

import java.util.Map;

import iih.ci.mr.s.bp.task.bp.MrCheckUnFilnishedTaskBP.ExecuteTaskbp;
import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

public class MrCheckUnFinishedTask extends PagingServiceImpl<CiMrmQryListDTO> implements IBackgroundWorkPlugin{

	@Override
	public PreAlertObject executeTask(BgWorkingContext paramBgWorkingContext) throws BizException {

		Map<String,Object> variableValueMap = paramBgWorkingContext.getKeyMap();
		ExecuteTaskbp taskbp = new ExecuteTaskbp();
		taskbp.executetaskBp(variableValueMap);
		return null;
	}

}
