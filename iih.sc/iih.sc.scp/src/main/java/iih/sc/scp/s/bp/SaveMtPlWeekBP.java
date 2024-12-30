package iih.sc.scp.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScValidator;
import iih.sc.scp.dto.d.MtPlWkDTO;
import iih.sc.scp.s.bp.mt.GetMtPlWeekBP;
import iih.sc.scp.s.ep.ScplEp;
import iih.sc.scp.s.ep.ScplWeekEP;
import iih.sc.scp.s.ep.ScplWeekTickEP;
import iih.sc.scp.s.ep.ScplWeekTicksEP;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scpltick.d.ScPlanWeekTickDO;
import iih.sc.scp.scplticks.d.ScPlanWeekTicksDO;
import iih.sc.scp.scplweek.d.ScPlanWeekChlDO;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.d.ScPlanWeekEnDO;
import iih.sc.scp.scplweek.d.ScplweekAggDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 保存周计划
 * 
 * @author liubin
 *
 */
public class SaveMtPlWeekBP {
	/**
	 * 保存周计划
	 * 
	 * @param 周计划
	 * @throws BizException
	 */
	public MtPlWkDTO exec(MtPlWkDTO mtPlWk) throws BizException {
		// 1.验证数据
		validater(mtPlWk);
		ScplWeekEP plWeekEp = new ScplWeekEP();
		ScplweekAggDO oldAgg = plWeekEp.getScplweekAggById(mtPlWk.getId_scplweek());
		// 2.删除号段/号位
		deleteTickAndTicks(mtPlWk);
		// 3.保存周计划AggDO
		String plWeekId = savePlWeek(mtPlWk, oldAgg);
		// 4.保存号段或号位
		this.saveWeekTickOrTicks(plWeekId, mtPlWk);
		// 5.查询周计划
		mtPlWk = this.getMtPlWk(plWeekId);

		return mtPlWk;
	}

	/**
	 * 验证数据
	 * 
	 * @param mtPlWk
	 * @throws BizException
	 */
	private void validater(MtPlWkDTO mtPlWk) throws BizException {
		if (ScValidator.isNullOrEmpty(mtPlWk) || ScValidator.isNullOrEmpty(mtPlWk.getWeek_list()))
			throw new BizException("保存数据为空!");
		if (!(IScDictCodeConst.SD_TICKMD_TICK.equals(mtPlWk.getSd_tickmd())
				|| IScDictCodeConst.SD_TICKMD_TICKS.equals(mtPlWk.getSd_tickmd())
				|| IScDictCodeConst.SD_TICKMD_TIME.equals(mtPlWk.getSd_tickmd())))
			throw new BizException("计划票号模式错误！");
	}

	/**
	 * 删除号段/号位
	 * 
	 * @param mtPlWk
	 * @throws BizException
	 */
	private void deleteTickAndTicks(MtPlWkDTO mtPlWk) throws BizException {
		String plWeekId = mtPlWk.getId_scplweek();
		if (ScValidator.isEmptyIgnoreBlank(plWeekId))
			return;
		// 1.号位模式删除号位
		if (IScDictCodeConst.SD_TICKMD_TICK.equals(mtPlWk.getSd_tickmd())) {
			ScplWeekTickEP tkEp = new ScplWeekTickEP();
			tkEp.delete(new String[] { plWeekId });
		}
		// 2.号段模式删除号位和号段
		else if (IScDictCodeConst.SD_TICKMD_TICKS.equals(mtPlWk.getSd_tickmd())) {
			ScplWeekTicksEP tksEp = new ScplWeekTicksEP();
			tksEp.delete(new String[] { plWeekId });
			// 号段模式删除号位指定渠道的列表
			ScplWeekTickEP tkEp = new ScplWeekTickEP();
			tkEp.delete(new String[] { plWeekId });
		}
	}

	/**
	 * 保存周计划AggDO
	 * 
	 * @param mtPlWk
	 * @return
	 * @throws BizException
	 */
	private String savePlWeek(MtPlWkDTO mtPlWk, ScplweekAggDO oldAgg) throws BizException {
		ScplweekAggDO weekAgg = (ScplweekAggDO) mtPlWk.getWeek_list().get(0);
		if (ScValidator.isNullOrEmpty(weekAgg))
			throw new BizException("保存数据为空!");
		String plWeekId = mtPlWk.getId_scplweek();
		ScPlanWeekDO week = weekAgg.getParentDO();
		if (ScValidator.isEmptyIgnoreBlank(plWeekId)) {
			// 新增
			DBUtil util = new DBUtil();
			week.setStatus(DOStatus.NEW);
			plWeekId = util.getOIDs(1)[0];
			week.setId_scplweek(plWeekId);
		} else {
			week.setStatus(DOStatus.UPDATED);
		}
		this.processWeekChls(plWeekId, weekAgg, oldAgg);
		ScplWeekEP weekEP = new ScplWeekEP();
		weekEP.savePlanWeekAgg(new ScplweekAggDO[] { weekAgg });
		return plWeekId;
	}

	/**
	 * 保存号段或号位
	 * 
	 * @param plWeekId
	 * @param mtPlWk
	 * @throws BizException
	 */
	private void saveWeekTickOrTicks(String plWeekId, MtPlWkDTO mtPlWk) throws BizException {
		// 1.号位模式保存号位
		if (IScDictCodeConst.SD_TICKMD_TICK.equals(mtPlWk.getSd_tickmd())) {
			this.saveTick(plWeekId, mtPlWk);
		}
		// 2.号段模式保存号位和号段
		else if (IScDictCodeConst.SD_TICKMD_TICKS.equals(mtPlWk.getSd_tickmd())) {
			ScPlanWeekTicksDO[] ticksDOs = this.saveTicks(plWeekId, mtPlWk);
			// 保存指定了渠道的号位
			FArrayList fTkList = mtPlWk.getWeek_tick_list();
			if (fTkList != null && !fTkList.isEmpty()) {
				this.setTickDoTicksId(ticksDOs, mtPlWk);// 设置号位的号段id
				this.saveTick(plWeekId, mtPlWk);
			}
		}
	}

	/**
	 * 查询周计划
	 * 
	 * @param plWeekId
	 * @return
	 * @throws BizException
	 */
	private MtPlWkDTO getMtPlWk(String plWeekId) throws BizException {
		GetMtPlWeekBP getMtPlWeekBP = new GetMtPlWeekBP();
		return getMtPlWeekBP.exec(plWeekId);
	}

	/**
	 * 处理周计划渠道
	 * 
	 * @param plWeekId
	 * @param weekAgg
	 * @throws BizException
	 */
	private void processWeekChls(String plWeekId, ScplweekAggDO weekAgg, ScplweekAggDO oldAgg) throws BizException {
		// 根据界面号源池渠道信息组装     渠道    DO集合
		List<ScPlanWeekChlDO> newChlsList = new LinkedList<>();
		
		// 根据界面号源池就诊信息组装     就诊    DO集合
		List<ScPlanWeekEnDO> newEnList = new LinkedList<>();
		
		this.assemlyNewWeekChls(weekAgg, newChlsList, newEnList);
		
		// 界面数据组装的    渠道      DO与原数据对比，分出新增，删除，修改的渠道DO
		List<ScPlanWeekChlDO> chlsList = new LinkedList<>();
		new ScplWeekEP().assemlyWeekChls(oldAgg, newChlsList, chlsList);
		
		// 界面数据组装的    就诊     DO与原数据对比，分出新增，删除，修改的渠道DO
		List<ScPlanWeekEnDO> ensList = new LinkedList<>();
		new ScplWeekEP().assemlyWeekEns(oldAgg, newEnList, ensList);
				
		// 给AggDO渠道数据赋值
		weekAgg.setScPlanWeekChlDO(chlsList.toArray(new ScPlanWeekChlDO[0]));
		
		// 给AggDO就诊数据赋值
		weekAgg.setScPlanWeekEnDO(ensList.toArray(new ScPlanWeekEnDO[0]));
	}

	/**
	 * 根据界面号源池渠道信息组装渠道DO集合
	 * 
	 * @param weekAgg
	 *            周计划编辑界面数据源
	 * @param newChlsList
	 *            渠道DO集合
	 * @throws BizException
	 */
	private void assemlyNewWeekChls(ScplweekAggDO weekAgg, List<ScPlanWeekChlDO> newChlsList, List<ScPlanWeekEnDO> newEnList) throws BizException {
		ScPlanWeekDO week = weekAgg.getParentDO();
		ScPlanWeekChlDO[] newChls = weekAgg.getScPlanWeekChlDO();
		Map<String,String> chlEnMap = new HashMap<String,String>();
		if (ScValidator.isNullOrEmpty(newChls))
			throw new BizException("号源池渠道列表不能为空！");
		for (ScPlanWeekChlDO chl : newChls) {
			if (chl.getStatus() == DOStatus.DELETED)
				continue;
			String chlId = chl.getId_scchl();
			String code_chl = chl.getCode_scchl();
			if (ScValidator.isEmptyIgnoreBlank(chlId) && chl.getScnum() > 0) {
				throw new BizException("号源池" + chl.getScpolcn() + "对应渠道不能为空！");
			} else if (!ScValidator.isEmptyIgnoreBlank(chlId)) {
				String[] chlIds = chlId.split(",");
				String[] codes_chl = code_chl.split(",");
				if (chlIds.length != codes_chl.length) {
					throw new BizException("号源池" + chl.getScpolcn() + "对应渠道，数据异常！");
				} else {
					for (int i = 0; i < chlIds.length; i++) {
						String id = chlIds[i];
						String code = codes_chl[i];
						/**
						 * 渠道DO集合
						 */
						ScPlanWeekChlDO planWeekChlDO = new ScPlanWeekChlDO();
						planWeekChlDO.setStatus(DOStatus.NEW);
						planWeekChlDO.setId_scplweek(week.getId_scplweek());
						planWeekChlDO.setId_scchl(id);
						planWeekChlDO.setScnum(chl.getScnum());
						planWeekChlDO.setScpolcn(chl.getScpolcn());
						if ("02".equals(code)) {// 判断为医院诊间渠道 才维护 授权科室，和授权医生
							planWeekChlDO.setIds_dep_spec(chl.getIds_dep_spec());
							planWeekChlDO.setIds_emp_spec(chl.getIds_emp_spec());
							planWeekChlDO.setNames_dep_spec(chl.getNames_dep_spec());
							planWeekChlDO.setNames_emp_spec(chl.getNames_emp_spec());
						}
						planWeekChlDO.setId_entp(chl.getId_entp());
						newChlsList.add(planWeekChlDO);
						
					}
					/**
					 * 就诊DO集合
					 */
					if (week.getFg_setentp() != null && week.getFg_setentp().booleanValue()) {
						String key = chl.getId_scplweek()+chl.getScpolcn();
						if(!chlEnMap.containsKey(key)){
						ScPlanWeekEnDO planWeekEnDO = new ScPlanWeekEnDO();
						planWeekEnDO.setStatus(DOStatus.NEW);
						planWeekEnDO.setId_scplweek(week.getId_scplweek());//计划周
						planWeekEnDO.setId_entp(chl.getId_entp());//就诊类型
						planWeekEnDO.setSd_entp(chl.getCode_entp());
						planWeekEnDO.setScpolcn(chl.getScpolcn());//对应号源池编号
						planWeekEnDO.setQuan(chl.getScnum());//数量
						newEnList.add(planWeekEnDO);
							chlEnMap.put(key, null);
					}
					}
				}
			}
			// 2.获取计划
			ScPlanDO pl = new ScplEp().getScPl(week.getId_scpl());
			if(pl.getSd_tickmd().equals(IScDictCodeConst.SD_TICKMD_TIME)){
				week.setAttrVal("Quan" + chl.getScpolcn() + "_appt", chl.getSctime().getHour()*60+chl.getSctime().getMinute());
			}else{
			week.setAttrVal("Quan" + chl.getScpolcn() + "_appt", chl.getScnum());
		}
	}
	}

	/**
	 * 号位模式保存
	 * 
	 * @param plWeekId
	 * @param mtPlWk
	 * @throws BizException
	 */
	private void saveTick(String plWeekId, MtPlWkDTO mtPlWk) throws BizException {
		FArrayList fTkList = mtPlWk.getWeek_tick_list();
		if (fTkList == null || fTkList.isEmpty())
			throw new BizException("周计划号位不能为空!");
		List<ScPlanWeekTickDO> tkList = new ArrayList<ScPlanWeekTickDO>();
		for (Object obj : fTkList) {
			if (!(obj instanceof ScPlanWeekTickDO))
				continue;
			ScPlanWeekTickDO tk = (ScPlanWeekTickDO) obj;
			tk.setStatus(DOStatus.NEW);
			tk.setId_tick(null);
			tk.setId_scplweek(plWeekId);
			tk.setId_grp(Context.get().getGroupId());
			tk.setId_org(Context.get().getOrgId());
			tkList.add(tk);
		}
		ScplWeekTickEP tkEp = new ScplWeekTickEP();
		tkEp.save(tkList.toArray(new ScPlanWeekTickDO[0]));
	}

	/**
	 * 号段模式保存
	 * 
	 * @param plWeekId
	 * @param mtPlWk
	 * @throws BizException
	 */
	private ScPlanWeekTicksDO[]  saveTicks(String plWeekId, MtPlWkDTO mtPlWk) throws BizException {
		FArrayList fTkList = mtPlWk.getWeek_ticks_list();
		if (fTkList == null || fTkList.isEmpty())
			throw new BizException("周计划号段不能为空!");
		List<ScPlanWeekTicksDO> tksList = new ArrayList<ScPlanWeekTicksDO>();
		for (Object obj : fTkList) {
			if (!(obj instanceof ScPlanWeekTicksDO))
				continue;
			ScPlanWeekTicksDO tk = (ScPlanWeekTicksDO) obj;
			if (tk.getStatus() == DOStatus.DELETED)
				continue;
			tk.setStatus(DOStatus.NEW);
			tk.setId_ticks(null);
			tk.setId_scplweek(plWeekId);
			tk.setId_grp(Context.get().getGroupId());
			tk.setId_org(Context.get().getOrgId());
			tksList.add(tk);
		}
		ScplWeekTicksEP tksEP = new ScplWeekTicksEP();
		ScPlanWeekTicksDO[] ticksDOs = tksEP.save(tksList.toArray(new ScPlanWeekTicksDO[0]));
		return ticksDOs;
	}

	/**
	 * 根据号段指定号位id
	 * 
	 * @param ticksDOs
	 * @param mtPlWk
	 */
	private void setTickDoTicksId(ScPlanWeekTicksDO[] ticksDOs, MtPlWkDTO mtPlWk) {
		FArrayList fTkList = mtPlWk.getWeek_tick_list();
		if (ticksDOs == null || ticksDOs.length <= 0 || fTkList == null || fTkList.isEmpty())
			return;
		Map<Integer, ScPlanWeekTickDO> tickMap = new HashMap<Integer, ScPlanWeekTickDO>();
		for (Object object : fTkList) {
			ScPlanWeekTickDO tickDO = (ScPlanWeekTickDO) object;
			tickMap.put(tickDO.getQueno(), tickDO);
		}
		for (ScPlanWeekTicksDO ticksDO : ticksDOs) {
			if (ticksDO.getQueno_b() == null || ticksDO.getQueno_e() == null)
				continue;
			int queno_b = ticksDO.getQueno_b();
			int queno_e = ticksDO.getQueno_e();
			if (queno_b == 0)
				continue;
			for (int index = queno_b; index <= queno_e; index++) {
				ScPlanWeekTickDO tickDO = tickMap.get(index);
				tickDO.setId_scplweekticks(ticksDO.getId_ticks());
				tickDO.setT_b(ticksDO.getT_b());
				tickDO.setT_e(ticksDO.getT_e());
			}
		}
	}

}
