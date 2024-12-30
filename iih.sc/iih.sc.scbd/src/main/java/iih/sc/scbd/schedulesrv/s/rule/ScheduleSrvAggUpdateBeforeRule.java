package iih.sc.scbd.schedulesrv.s.rule;

import java.util.LinkedList;
import java.util.List;

import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvRelDO;
import iih.sc.scbd.schedulesrv.d.SchedulesrvAggDO;
import iih.sc.scbd.schedulesrv.s.bp.ScheduleSrvAggUpdateBeforeBp;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.sys.appfw.bizrule.IRule;

/**
 * ScheduleSrvAgg更新后规则
 * @author guoyang
 *
 */
public class ScheduleSrvAggUpdateBeforeRule implements IRule<SchedulesrvAggDO> {
	
	@Override
	public void process(SchedulesrvAggDO... paramArrayOfT) throws BizException {
		ScheduleSrvDO scheduleSrvDO = getScheduleSrvDO(paramArrayOfT);
		List<String> IdMdSrvList = getDeleteScheduleSrvRelDO(paramArrayOfT);
		
		ScheduleSrvAggUpdateBeforeBp bp = new ScheduleSrvAggUpdateBeforeBp();
		bp.exe(scheduleSrvDO, IdMdSrvList);
	}

	/**
	 * 获取当前agg数据的主DO
	 * @param paramArrayOfT1
	 */
	private ScheduleSrvDO getScheduleSrvDO(SchedulesrvAggDO[] paramArrayOfT) {
		if(paramArrayOfT != null && paramArrayOfT.length > 0){
			ScheduleSrvDO scheduleSrvDO = paramArrayOfT[0].getParentDO();
			return scheduleSrvDO;
		}
		return null;
		
	}

	/**
	 * 获取排班服务子DO中删除的医疗服务项目的id
	 * @param paramArrayOfT1
	 * @return
	 */
	private List<String> getDeleteScheduleSrvRelDO(SchedulesrvAggDO[] paramArrayOfT) {
		if(paramArrayOfT != null && paramArrayOfT.length > 0){
			List<String> IdMdSrvList = new LinkedList<String>();
			ScheduleSrvRelDO[] scheduleSrvRelDOs = paramArrayOfT[0].getScheduleSrvRelDO();
			if(scheduleSrvRelDOs != null && scheduleSrvRelDOs.length > 0){
				for (ScheduleSrvRelDO scheduleSrvRelDO : scheduleSrvRelDOs) {
					if(scheduleSrvRelDO.getStatus() == DOStatus.DELETED){
						IdMdSrvList.add(scheduleSrvRelDO.getId_mdsrv());
					}
				}
			}
			return IdMdSrvList;
		}
		return null;
	}
}
