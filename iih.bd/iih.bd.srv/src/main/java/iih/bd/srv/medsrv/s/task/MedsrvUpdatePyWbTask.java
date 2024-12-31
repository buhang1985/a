package iih.bd.srv.medsrv.s.task;

import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ListUtil;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 更新拼音五笔码后台任务
 * @author ly
 *
 */
public class MedsrvUpdatePyWbTask implements IBackgroundWorkPlugin{

	@SuppressWarnings("unchecked")
	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0)
			throws BizException {
		
		String sql = "select * from bd_srv";
		
		DAFacade daf = new DAFacade();
		List<MedSrvDO> list = (List<MedSrvDO>)daf.execQuery(
				sql, new BeanListHandler(MedSrvDO.class));
		
		if(ListUtil.isEmpty(list))
			return null;
		
		for (MedSrvDO medSrvDO : list) {
			medSrvDO.setStatus(DOStatus.NEW);
			medSrvDO.setPycode(CnToPy.getPyFirstCode(medSrvDO.getName()));//拼音码
			medSrvDO.setWbcode(CnToWB.getWBCode(medSrvDO.getName()));//五笔码
		}
		
		daf.updateDOs(list.toArray(new MedSrvDO[list.size()]));
		
		return null;
	}
}
