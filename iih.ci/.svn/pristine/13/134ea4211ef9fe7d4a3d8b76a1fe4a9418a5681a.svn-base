package iih.ci.mr.autocompletededit;

import xap.mw.core.data.BizException;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;

/**
 * 自动完成书写功能
 * @author yang
 * 流程：
 * 1 查询所有需要自动完成的就诊，且
 * 判断是否出院
 * 
 */
public final class AutoCompleteEdit implements IBackgroundWorkPlugin{

	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0)
			throws BizException {
		
		return null;
	}
	
	/**
	 * 根据就诊号完成本次就诊书写
	 * @param id_ent 就诊号
	 * @return
	 */
	private boolean completeEdit(String id_ent){
		
		return true;
	}
	/**
	 * 根据就诊号判断本次就诊是否可以完成书写
	 * 判断条件为：患者是否出院72小时
	 * @param id_ent 就诊号
	 * @return
	 */
	private boolean canCompleteEdit(String id_ent){
		
		return true;
	}



}
