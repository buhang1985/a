package iih.sc.scp.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.IScMsgConst;
import iih.sc.scp.scpltick.d.ScPlanWeekTickDO;
import iih.sc.scp.scpltick.d.desc.ScPlanWeekTickDODesc;
import iih.sc.scp.scpltick.i.IScpltickCudService;
import iih.sc.scp.scpltick.i.IScpltickRService;
import iih.sc.scp.scplticks.d.ScPlanWeekTicksDO;
import iih.sc.scp.scplticks.d.desc.ScPlanWeekTicksDODesc;
import iih.sc.scp.scplticks.i.IScplticksCudService;
import iih.sc.scp.scplticks.i.IScplticksRService;
import iih.sc.scp.scplweek.d.ScplweekAggDO;
import iih.sc.scp.scplweek.i.IScplweekCudService;
import iih.sc.scp.scplweek.i.IScplweekRService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 复制一条周计划
 * 
 * @author zhouliming
 */
public class CopyPlanWeekBP {
	/**
	 * 复制一条周计划
	 * 
	 * @param id_scplweek
	 *            被复制的周计划id
	 * @param weekNum
	 *            星期数
	 * @param Sd_tickmd
	 *            票号模式
	 * @throws BizException
	 */
	public void exec(String id_scplweek, String weekNum, String Sd_tickmd) throws BizException {
		if (StringUtils.isBlank(id_scplweek) || StringUtils.isBlank(Sd_tickmd) || StringUtils.isBlank(weekNum))
			return;
		IScplweekCudService weekService = ServiceFinder.find(IScplweekCudService.class);
		IScplweekRService service = ServiceFinder.find(IScplweekRService.class);
		ScplweekAggDO weekAggDO = service.findById(id_scplweek);// 被复制的周计划aggDO
		if (weekAggDO == null) {
			throw new RuntimeException(IScMsgConst.SC_SCP_SCPLAN_SCPLWEEKNULL);// 未获取到所选周计划数据，请重新操作！
		}
		ScplweekAggDO copyAggDO = (ScplweekAggDO) weekAggDO.clone();//克隆aggDO数据

		copyAggDO.getParent().setStatus(DOStatus.NEW);
		copyAggDO.getParent().setPkVal(null);//主键清空
		copyAggDO.getParentDO().setWeekno(new Integer(weekNum));//星期数
		if (copyAggDO.getAllChildrenDO() != null && copyAggDO.getAllChildrenDO().length > 0) {

			for (BaseDO baseDO : copyAggDO.getAllChildrenDO()) {
				baseDO.setStatus(DOStatus.NEW);
				baseDO.setPkVal(null);//主键清空
			}
		}

		ScplweekAggDO[] copyWeekAggDOs = weekService.save(new ScplweekAggDO[] { copyAggDO });// 保存周计划aggDO
		if (copyWeekAggDOs == null || copyWeekAggDOs.length == 0)
			return;
		String id_copyWeek = copyWeekAggDOs[0].getParentDO().getId_scplweek();// 生成的新的周计划id
		copyTickOrTicks(id_scplweek, id_copyWeek, Sd_tickmd);// 复制号位或号段
	}

	/**
	 * 保存号位/号段
	 * 
	 * @param id_scplweek
	 *            被复制的周计划id
	 * @param id_copyWeek
	 *            新生成的周计划id
	 * @param Sd_tickmd
	 *            票号模式
	 * @throws BizException
	 */
	private void copyTickOrTicks(String id_scplweek, String id_copyWeek, String Sd_tickmd) throws BizException {
		if (StringUtils.isBlank(id_scplweek) || StringUtils.isBlank(id_copyWeek) || StringUtils.isBlank(Sd_tickmd))
			return;

		if (Sd_tickmd.equals(IScDictCodeConst.SD_TICKMD_TICK)) {
			IScpltickRService service = ServiceFinder.find(IScpltickRService.class);
			IScpltickCudService tickCudService = ServiceFinder.find(IScpltickCudService.class);
			String tableDesc = ScPlanWeekTickDODesc.TABLE_ALIAS_NAME;

			ScPlanWeekTickDO[] tickDOs = service.find(tableDesc + ".id_scplweek = '" + id_scplweek + "'", "", FBoolean.FALSE);
			// 给每个号位DO的周计划id赋值
			for (ScPlanWeekTickDO tickDO : tickDOs) {
				tickDO.setId_scplweek(id_copyWeek);
				tickDO.setId_tick(null);
				tickDO.setStatus(DOStatus.NEW);
			}
			tickCudService.save(tickDOs);// 保存号位
		} else if (Sd_tickmd.equals(IScDictCodeConst.SD_TICKMD_TICKS)) {
			IScplticksRService service = ServiceFinder.find(IScplticksRService.class);
			IScplticksCudService ticksCudService = ServiceFinder.find(IScplticksCudService.class);
			String tableDesc = ScPlanWeekTicksDODesc.TABLE_ALIAS_NAME;

			ScPlanWeekTicksDO[] ticksDOs = service.find(tableDesc + ".id_scplweek = '" + id_scplweek + "'", "", FBoolean.FALSE);
			// 给每个号段DO的周计划id赋值
			for (ScPlanWeekTicksDO ticksDO : ticksDOs) {
				ticksDO.setId_scplweek(id_copyWeek);
				ticksDO.setId_ticks(null);
				ticksDO.setStatus(DOStatus.NEW);
			}
			ticksCudService.save(ticksDOs);// 保存号段
		}
	}
}
