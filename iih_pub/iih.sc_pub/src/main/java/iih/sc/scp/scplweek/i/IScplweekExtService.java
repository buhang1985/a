package iih.sc.scp.scplweek.i;

import java.util.List;
import java.util.Map;

import iih.sc.scp.scplweek.d.ScPlanWeekChlDO;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import xap.mw.core.data.BizException;

public interface IScplweekExtService {
	/**
	 * 渠道控制 删除一条数据
	 * @param chls do数组
	 * @throws BizException
	 */
//	public void delScScPlanWeekChlDOs(ScPlanWeekChlDO[] chls) throws BizException;
	/**
	 * 渠道控制 保存数据
	 * @param chls
	 * @throws BizException
	 */
//	public void saveScScPlanWeekChlDOs(ScPlanWeekChlDO[] chls) throws BizException;
	
	/**
	 * 批量调整计划
	 * @param coverBool 是否覆盖
	 * @param list 勾选的位置集合 
	 * @param map 已存在的数据
	 * @param weekDO 要复制的源DO
	 * @param Sd_tickmd 票号模式编码
	 * @throws BizException
	 */
//	public void replaceScScPlanWeek(String coverBool,List list,Map map,ScPlanWeekDO weekDO,String Sd_tickmd) throws BizException;
}
