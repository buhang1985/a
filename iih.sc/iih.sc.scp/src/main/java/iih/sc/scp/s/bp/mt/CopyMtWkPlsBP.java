package iih.sc.scp.s.bp.mt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scp.dto.d.MtPLDaysDTO;
import iih.sc.scp.s.ep.ScplWeekEP;
import iih.sc.scp.s.ep.ScplWeekEnEP;
import iih.sc.scp.s.ep.ScplWeekTickEP;
import iih.sc.scp.s.ep.ScplWeekTicksEP;
import iih.sc.scp.scpltick.d.ScPlanWeekTickDO;
import iih.sc.scp.scplticks.d.ScPlanWeekTicksDO;
import iih.sc.scp.scplweek.d.ScPlanWeekChlDO;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.d.ScPlanWeekEnDO;
import iih.sc.scp.scplweek.d.ScplweekAggDO;
import iih.sc.scp.scplweek.d.desc.ScPlanWeekDODesc;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 复制周计划到指定周的指定天
 * 
 * @author liubin
 *
 */
public class CopyMtWkPlsBP {
	/**
	 * 复制周计划到指定周的指定天
	 * 
	 * @param id_scplWeek
	 * @param mtPlDaysDTOs
	 * @param isCover
	 *            是否覆盖复制
	 * @throws BizException
	 */
	public void exec(String id_scplWeek, String sd_tickmd, MtPLDaysDTO[] mtPlDaysDTOs, FBoolean isCover)
			throws BizException {
		// 1.数据校验
		this.volidate(id_scplWeek, sd_tickmd, mtPlDaysDTOs);

		// 2.查询复制源AggDO
		ScplweekAggDO weekAgg = this.getWeekAgg(id_scplWeek);

		// 3.查询号段或号位集合
		// Object[] ticks = this.getWeekTicks(id_scplWeek, sd_tickmd);
		ScPlanWeekTicksDO[] ticksDOs = getWeekTicksDos(id_scplWeek);// 号段
		ScPlanWeekTickDO[] tickDOs = getWeekTickDos(id_scplWeek);// 号位
		// 4.查询已经存在，需要覆盖的周计划
		ScPlanWeekDO[] weeks = this.getNeedCoverWeeks(id_scplWeek, mtPlDaysDTOs);

		// 5.覆盖复制时删除原有周计划
		this.delNeedCoverWeeks(weeks, sd_tickmd, isCover);

		// 6.复制数据
		this.copyWeek(weekAgg, ticksDOs, tickDOs, weeks, sd_tickmd, mtPlDaysDTOs, isCover);
	}

	/**
	 * 数据校验
	 * 
	 * @param id_scplWeek
	 * @param mtPlDaysDTOs
	 * @throws BizException
	 */
	private void volidate(String id_scplWeek, String sd_tickmd, MtPLDaysDTO[] mtPlDaysDTOs) throws BizException {
		if (ScValidator.isEmptyIgnoreBlank(id_scplWeek))
			throw new BizException("周计划ID不能为空！");
		if (ScValidator.isEmptyIgnoreBlank(sd_tickmd))
			throw new BizException("计划票号模式不能为空！");
		if (ScValidator.isNullOrEmpty(mtPlDaysDTOs))
			throw new BizException("周计划复制数据不能为空！");
	}

	/**
	 * 查询复制源AggDO
	 * 
	 * @param plWeekId
	 * @return
	 * @throws BizException
	 */
	private ScplweekAggDO getWeekAgg(String plWeekId) throws BizException {
		ScplWeekEP ep = new ScplWeekEP();
		ScplweekAggDO weekAgg = ep.getScplweekAggById(plWeekId);
		if (weekAgg == null)
			throw new BizException("未获取到周计划");
		return weekAgg;
	}

	/**
	 * 获取号段或号位数据
	 * 
	 * @param plWeekId
	 * @param sd_tickmd
	 * @return
	 * @throws BizException
	 */
	private Object[] getWeekTicks(String plWeekId, String sd_tickmd) throws BizException {
		if (IScDictCodeConst.SD_TICKMD_TICK.equals(sd_tickmd)) {
			ScplWeekTickEP tickEp = new ScplWeekTickEP();
			return tickEp.getTickByWeekIds(new String[] { plWeekId });
		} else if (IScDictCodeConst.SD_TICKMD_TICKS.equals(sd_tickmd)) {
			ScplWeekTicksEP ticksEp = new ScplWeekTicksEP();
			return ticksEp.getTicksByWeekIds(new String[] { plWeekId });
		}
		return null;
	}

	/**
	 * 获取号位
	 * 
	 * @param plWeekId
	 * @param sd_tickmd
	 * @return
	 * @throws BizException
	 */
	private ScPlanWeekTickDO[] getWeekTickDos(String plWeekId) throws BizException {
		ScplWeekTickEP tickEp = new ScplWeekTickEP();
		return tickEp.getTickByWeekIds(new String[] { plWeekId });
	}

	/**
	 * 获取号段
	 * 
	 * @param plWeekId
	 * @param sd_tickmd
	 * @return
	 * @throws BizException
	 */
	private ScPlanWeekTicksDO[] getWeekTicksDos(String plWeekId) throws BizException {
		ScplWeekTicksEP ticksEp = new ScplWeekTicksEP();
		return ticksEp.getTicksByWeekIds(new String[] { plWeekId });
	}

	/**
	 * 获取周计划
	 * 
	 * @param id_scplWeek
	 * @param mtPlDaysDTOs
	 * @return
	 * @throws BizException
	 */
	private ScPlanWeekDO[] getNeedCoverWeeks(String id_scplWeek, MtPLDaysDTO[] mtPlDaysDTOs) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%s.Id_scplweek <> '%s' ", ScPlanWeekDODesc.TABLE_ALIAS_NAME, id_scplWeek));
		StringBuilder sb_sub = new StringBuilder();
		boolean isSelected = false;
		for (MtPLDaysDTO day : mtPlDaysDTOs) {
			List<String> list = new ArrayList();
			if (FBoolean.TRUE.equals(day.getFg_mon()))
				list.add("1");
			if (FBoolean.TRUE.equals(day.getFg_tue()))
				list.add("2");
			if (FBoolean.TRUE.equals(day.getFg_wed()))
				list.add("3");
			if (FBoolean.TRUE.equals(day.getFg_thu()))
				list.add("4");
			if (FBoolean.TRUE.equals(day.getFg_fri()))
				list.add("5");
			if (FBoolean.TRUE.equals(day.getFg_sat()))
				list.add("6");
			if (FBoolean.TRUE.equals(day.getFg_sun()))
				list.add("7");
			if (list.isEmpty())
				continue;
			if (isSelected)
				sb_sub.append(" or ");
			if (!isSelected)
				isSelected = true;
			sb_sub.append(" ( ");
			sb_sub.append(String.format(" %s.Id_scpl = '%s' ", ScPlanWeekDODesc.TABLE_ALIAS_NAME, day.getId_scpl()));
			sb_sub.append(
					String.format(" and %s.Idx_week = '%s' ", ScPlanWeekDODesc.TABLE_ALIAS_NAME, day.getIdx_week()));
			sb_sub.append(String.format(" and %s.Id_dayslot = '%s' ", ScPlanWeekDODesc.TABLE_ALIAS_NAME,
					day.getId_dayslot()));
			sb_sub.append(" and "
					+ ScSqlUtils.getInSqlByIds(ScPlanWeekDODesc.TABLE_ALIAS_NAME + "." + ScPlanWeekDO.WEEKNO, list));
			sb_sub.append(" ) ");
		}
		if (isSelected)
			sb.append(" and ( " + sb_sub.toString() + " ) ");
		String whereStr = sb.toString();
		Logger.info(whereStr);
		ScplWeekEP ep = new ScplWeekEP();
		return ep.getPlWeeks(whereStr);
	}

	/**
	 * 覆盖复制时删除原有周计划
	 * 
	 * @param weeks
	 * @param sd_tickmd
	 * @param isCover
	 * @throws BizException
	 */
	private void delNeedCoverWeeks(ScPlanWeekDO[] weeks, String sd_tickmd, FBoolean isCover) throws BizException {
		// 判断是否是覆盖复制
		if (!(FBoolean.TRUE.equals(isCover)))
			return;
		if (ScValidator.isNullOrEmpty(weeks))
			return;
		Set<String> set = new HashSet<String>();
		for (ScPlanWeekDO week : weeks)
			set.add(week.getId_scplweek());
		ScplWeekEP ep = new ScplWeekEP();
		ep.deleteByParentDO(weeks);
		if (IScDictCodeConst.SD_TICKMD_TICK.equals(sd_tickmd)) {
			ScplWeekTickEP tickEp = new ScplWeekTickEP();
			tickEp.delete(set.toArray(new String[0]));
		} else if (IScDictCodeConst.SD_TICKMD_TICKS.equals(sd_tickmd)) {
			ScplWeekTicksEP ticksEp = new ScplWeekTicksEP();
			ticksEp.delete(set.toArray(new String[0]));
		}
		// 删除周计划就诊信息
		ScplWeekEnEP enEp = new ScplWeekEnEP();
		enEp.delete(set.toArray(new String[0]));
	}

	/**
	 * 复制周计划
	 * 
	 * @param weekAgg
	 * @param ticks
	 * @param weeks
	 * @param sd_tickmd
	 * @param mtPlDaysDTOs
	 * @param isCover
	 * @throws BizException
	 */
	private void copyWeek(ScplweekAggDO weekAgg, ScPlanWeekTicksDO[] ticksdos, ScPlanWeekTickDO[] tickdos,
			ScPlanWeekDO[] weeks, String sd_tickmd, MtPLDaysDTO[] mtPlDaysDTOs, FBoolean isCover) throws BizException {
		ScPlanWeekDO week = weekAgg.getParentDO();
		ScPlanWeekChlDO[] weekChls = weekAgg.getScPlanWeekChlDO();
		ScPlanWeekEnDO[] weekEns = weekAgg.getScPlanWeekEnDO();
		List<ScplweekAggDO> copyWeekAggList = new LinkedList<ScplweekAggDO>();
		List<ScPlanWeekTicksDO> copyTicksDosList = new LinkedList<ScPlanWeekTicksDO>();
		List<ScPlanWeekTickDO> copyTickDosList = new LinkedList<ScPlanWeekTickDO>();
		for (MtPLDaysDTO mtPlDays : mtPlDaysDTOs) {
			List<Integer> weekNos = this.getWeekNos(mtPlDays);
			if (weekNos.isEmpty())
				continue;
			for (Integer weekNo : weekNos) {
				// 如果选中了复制源周计划则跳过
				boolean isRepeat = this.isRepeatWeek(new ScPlanWeekDO[] { week }, mtPlDays.getId_scpl(),
						mtPlDays.getId_dayslot(), mtPlDays.getIdx_week(), weekNo);
				if (isRepeat)
					continue;
				// 非覆盖复制
				if (!(FBoolean.TRUE.equals(isCover))) {
					isRepeat = this.isRepeatWeek(weeks, mtPlDays.getId_scpl(), mtPlDays.getId_dayslot(),
							mtPlDays.getIdx_week(), weekNo);
					if (isRepeat)
						continue;
				}
				// 复制周计划
				ScPlanWeekDO copyWeek = (ScPlanWeekDO) week.clone();
				copyWeek.setStatus(DOStatus.NEW);
				copyWeek.setId_scplweek(this.getNewPlWeekId());
				copyWeek.setIdx_week(mtPlDays.getIdx_week());
				copyWeek.setWeekno(weekNo);
				ScplweekAggDO copyWeekAgg = new ScplweekAggDO();
				copyWeekAgg.setParentDO(copyWeek);
				//渠道
				if (!ScValidator.isNullOrEmpty(weekChls)) {
					List<ScPlanWeekChlDO> chlList = new LinkedList<>();
					for (ScPlanWeekChlDO weekChl : weekChls) {
						ScPlanWeekChlDO copyChl = (ScPlanWeekChlDO) weekChl.clone();
						copyChl.setStatus(DOStatus.NEW);
						copyChl.setId_scplweekchl(null);
						copyChl.setId_scplweek(copyWeek.getId_scplweek());
						chlList.add(copyChl);
					}
					copyWeekAgg.setScPlanWeekChlDO(chlList.toArray(new ScPlanWeekChlDO[0]));
				}
				//就诊
				if (!ScValidator.isNullOrEmpty(weekEns)) {
					List<ScPlanWeekEnDO> enList = new LinkedList<>();
					for (ScPlanWeekEnDO weekEn : weekEns) {
						ScPlanWeekEnDO copyEn = (ScPlanWeekEnDO) weekEn.clone();
						copyEn.setStatus(DOStatus.NEW);
						copyEn.setId_scplweeken(null);
						copyEn.setId_scplweek(copyWeek.getId_scplweek());
						enList.add(copyEn);
					}
					copyWeekAgg.setScPlanWeekEnDO(enList.toArray(new ScPlanWeekEnDO[0]));
				}
				copyWeekAggList.add(copyWeekAgg);
				
				// 复制号段或号位
				if (!ScValidator.isNullOrEmpty(tickdos)) {
					for (ScPlanWeekTickDO obj : tickdos) {
						ScPlanWeekTickDO copyTick = (ScPlanWeekTickDO) obj.clone();
						copyTick.setStatus(DOStatus.NEW);
						copyTick.setId_tick(null);
						copyTick.setId_scplweekticks(null);
						copyTick.setId_scplweek(copyWeek.getId_scplweek());
						copyTickDosList.add(copyTick);// 号位
					}
				}
				if (!ScValidator.isNullOrEmpty(ticksdos)) {
					for (ScPlanWeekTicksDO obj : ticksdos) {
						ScPlanWeekTicksDO copyTicks = (ScPlanWeekTicksDO) obj.clone();
						copyTicks.setStatus(DOStatus.NEW);
						copyTicks.setId_ticks(null);
						copyTicks.setId_scplweek(copyWeek.getId_scplweek());
						copyTicksDosList.add(copyTicks);// 号段
					}
				}
			}
		}
		ScplWeekEP weekEp = new ScplWeekEP();
		weekEp.savePlanWeekAgg(copyWeekAggList.toArray(new ScplweekAggDO[0]));
		if (IScDictCodeConst.SD_TICKMD_TICK.equals(sd_tickmd)) {
			ScplWeekTickEP tickEp = new ScplWeekTickEP();
			tickEp.save(copyTickDosList.toArray(new ScPlanWeekTickDO[0]));
		} else if (IScDictCodeConst.SD_TICKMD_TICKS.equals(sd_tickmd)) {
			ScplWeekTicksEP ticksEp = new ScplWeekTicksEP();
			ScPlanWeekTicksDO[] ticksDOs=ticksEp.save(copyTicksDosList.toArray(new ScPlanWeekTicksDO[0]));
			setTickDoTicksId(ticksDOs,copyTickDosList);
			if (CollectionUtils.isNotEmpty(copyTickDosList)) {
				ScplWeekTickEP tickEp = new ScplWeekTickEP();
				tickEp.save(copyTickDosList.toArray(new ScPlanWeekTickDO[0]));
			}
		}
	}

	/**
	 * 获取需要复制的星期
	 * 
	 * @param mtPLDays
	 * @return
	 */
	private List<Integer> getWeekNos(MtPLDaysDTO mtPLDays) {
		List<Integer> list = new LinkedList<Integer>();
		if (FBoolean.TRUE.equals(mtPLDays.getFg_mon()))
			list.add(1);
		if (FBoolean.TRUE.equals(mtPLDays.getFg_tue()))
			list.add(2);
		if (FBoolean.TRUE.equals(mtPLDays.getFg_wed()))
			list.add(3);
		if (FBoolean.TRUE.equals(mtPLDays.getFg_thu()))
			list.add(4);
		if (FBoolean.TRUE.equals(mtPLDays.getFg_fri()))
			list.add(5);
		if (FBoolean.TRUE.equals(mtPLDays.getFg_sat()))
			list.add(6);
		if (FBoolean.TRUE.equals(mtPLDays.getFg_sun()))
			list.add(7);
		return list;
	}

	/**
	 * 是否有重复的周计划
	 * 
	 * @param weeks
	 * @param scplId
	 * @param dayslotId
	 * @param idx_week
	 * @param weekNo
	 * @return
	 */
	private boolean isRepeatWeek(ScPlanWeekDO[] weeks, String scplId, String dayslotId, Integer idx_week,
			Integer weekNo) {
		boolean res = false;
		if (!ScValidator.isNullOrEmpty(weeks)) {
			for (ScPlanWeekDO week : weeks) {
				if (week.getId_scpl().equals(scplId) && week.getId_dayslot().equals(dayslotId)
						&& week.getIdx_week().equals(idx_week) && week.getWeekno().equals(weekNo)) {
					return true;
				}
			}
		}
		return res;
	}

	/**
	 * 获取新的主键
	 * 
	 * @return
	 */
	private String getNewPlWeekId() {
		DBUtil util = new DBUtil();
		return util.getOIDs(1)[0];
	}
	/**
	 * 根据号段指定号位中号段id
	 * 
	 * @param ticksDOs
	 * @param mtPlWk
	 */
	private void setTickDoTicksId(ScPlanWeekTicksDO[] ticksDOs, List<ScPlanWeekTickDO>tickDOsList ) {
		if (ArrayUtils.isEmpty(ticksDOs) || CollectionUtils.isEmpty(tickDOsList))
			return;
		Map<String, ScPlanWeekTickDO> tickMap = new HashMap<String, ScPlanWeekTickDO>();
		for (ScPlanWeekTickDO tickDO : tickDOsList) {
			String queno_plweekId= tickDO.getQueno()+"_"+tickDO.getId_scplweek();
			tickMap.put(queno_plweekId, tickDO);
		}
		for (ScPlanWeekTicksDO ticksDO : ticksDOs) {
			int queno_b = ticksDO.getQueno_b()==null?0:ticksDO.getQueno_b();
			int queno_e = ticksDO.getQueno_e()==null?0:ticksDO.getQueno_e();
			if(queno_b ==0)
				continue;
			for (int index = queno_b; index <= queno_e; index++) {
				String queno_plweekId= index+"_"+ticksDO.getId_scplweek();
				ScPlanWeekTickDO tickDO = tickMap.get(queno_plweekId);
				tickDO.setId_scplweekticks(ticksDO.getId_ticks());
			}
		}
	}
}
