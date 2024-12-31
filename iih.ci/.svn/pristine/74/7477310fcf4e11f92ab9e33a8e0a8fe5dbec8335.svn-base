package iih.ci.ord.s.bp.orsrvsplit.firstmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import iih.bd.base.utils.DateTimeUtils;
import iih.ci.ord.dto.blexorder.d.OrSplitOrderDTO;
import iih.ci.ord.dto.blexorder.d.OrSrvSplitParamDTO;
import iih.mp.nr.i.IMpNrLogService;
import iih.mp.nr.mporplan.d.MpOrPlanDO;
import iih.mp.nr.mporplan.i.IMporplanRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @Description:补齐医嘱拆分首日不够的逻辑
 * @author: xu_xing@founder.com.cn
 * @version：2018年9月28日 下午7:44:10 创建
 * @version: xuxing_2019年5月29日13:00:58，修复首日补齐逻辑没有查询现有数据，导致首日多补的bug
 */
public class OrSplitFixBp {

	/**
	 * 主入口
	 * 
	 * @param queryRes
	 *            ，查询的结果
	 * @param orSplitRes
	 *            ，拆分后的结果（可能有查询有数据，拆分后没数据）
	 * @return
	 * @throws BizException
	 */
	public List<OrSplitOrderDTO> exec(OrSplitOrderDTO[] queryRes, OrSplitOrderDTO[] orSplitRes, OrSrvSplitParamDTO param) throws BizException {

		// 1、基础校验
		if (!validation(queryRes))
			return null;

		// 2、获取含首日拆分的医嘱ID
		String[] id_ors = getFirstSplitOrs(queryRes, param);
		if (id_ors == null || id_ors.length < 1)
			return null;

		// 3、获取已经拆分的计划信息
		List<String> listFirstOr = Arrays.asList(id_ors);
		MpOrPlanDO[] plans = getPlans(id_ors,param);

		// 4、获取本次实际拆分的首日记录
		HashMap<String, List<FDateTime>> mapSpliting = getActurlSplit(listFirstOr, orSplitRes);

		// 5、合并已经拆分的结果
		megerSplited(mapSpliting, plans);

		// 6、补齐首日不够的情况
		List<OrSplitOrderDTO> rtn = figerOutAddPlan(listFirstOr, queryRes, mapSpliting);

		return rtn;
	}

	/**
	 * 基础校验
	 * 
	 * @param queryRes
	 * @return
	 */
	private boolean validation(OrSplitOrderDTO[] queryRes) {
		if (queryRes == null || queryRes.length < 1)
			return false;
		return true;
	}

	/**
	 * 获取含首日拆分的医嘱ID
	 * 
	 * @param queryRes
	 * @return
	 */
	private String[] getFirstSplitOrs(OrSplitOrderDTO[] queryRes, OrSrvSplitParamDTO param) {
		List<String> reList = new ArrayList<String>();
		for (OrSplitOrderDTO qry : queryRes) {
			if (FBoolean.FALSE.equals(qry.getFg_long()))
				continue;
			if (FBoolean.TRUE.equals(qry.getFg_pres_outp())) {// 过滤掉出院带药
				continue;
			}
//			// 本次含首日拆分
//			if (DateTimeUtils.isSameDay(qry.getDt_effe(), qry.getDt_last_bl_or())) {
//				reList.add(qry.getId_or());
//			}

			if (FBoolean.TRUE.equals(param.getFg_presplit())) {
				if (qry.getDt_effe().compareTo(param.getDt_split_start()) >= 0 && param.getDt_split_end().compareTo(qry.getDt_effe()) >= 0)
					reList.add(qry.getId_or());
			} else {
				// 本次含首日拆分
				if (DateTimeUtils.isSameDay(qry.getDt_effe(), qry.getDt_last_bl_or()))
					reList.add(qry.getId_or());
			}
		}
		return reList.toArray(new String[0]);
	}

	/**
	 * 获取已经拆分的计划信息
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private MpOrPlanDO[] getPlans(String[] id_ors,OrSrvSplitParamDTO param) throws BizException {
		if (FBoolean.TRUE.equals(param.getFg_presplit())) 
			return null;
		return ServiceFinder.find(IMporplanRService.class).findByAttrValStrings(MpOrPlanDO.ID_OR, id_ors);
	}

	/**
	 * 获取本次实际拆分的首日记录
	 * 
	 * @return
	 */
	private HashMap<String, List<FDateTime>> getActurlSplit(List<String> listFirstOr, OrSplitOrderDTO[] orSplitRes) {
		HashMap<String, List<FDateTime>> reMap = new HashMap<String, List<FDateTime>>();
		if (orSplitRes == null || orSplitRes.length < 1)
			return reMap;
		for (OrSplitOrderDTO splitRes : orSplitRes) {
			if (!listFirstOr.contains(splitRes.getId_or()))
				continue;
			List<FDateTime> listSplited = new ArrayList<FDateTime>();
			if (reMap.containsKey(splitRes.getId_or()))
				listSplited = reMap.get(splitRes.getId_or());
			listSplited.add(splitRes.getDt_mp_plan());
			reMap.put(splitRes.getId_or(), listSplited);
		}
		return reMap;
	}

	/**
	 * 合并已经拆分的结果 包含已经拆分完成的计划和本次即将拆分的
	 * 
	 * @param mapSplit
	 * @param plans
	 */
	private void megerSplited(HashMap<String, List<FDateTime>> mapSplit, MpOrPlanDO[] plans) {
		if (plans == null || plans.length < 1)
			return;
		for (MpOrPlanDO plan : plans) {
			List<FDateTime> listSplited = null;
			if (mapSplit.containsKey(plan.getId_or())) {
				listSplited = mapSplit.get(plan.getId_or());
			} else {
				listSplited = new ArrayList<FDateTime>();
				mapSplit.put(plan.getId_or(), listSplited);
			}
			if (!listSplited.contains(plan.getDt_mp_plan()))
				listSplited.add(plan.getDt_mp_plan());
		}
	}

	/**
	 * 补齐首日不够的情况
	 * 
	 * @param queryRes
	 * @param mapSpliting
	 * @return
	 */
	private List<OrSplitOrderDTO> figerOutAddPlan(List<String> listFirstOr, OrSplitOrderDTO[] queryRes, HashMap<String, List<FDateTime>> mapSpliting) {

		IMpNrLogService logService = ServiceFinder.find(IMpNrLogService.class);
		List<OrSplitOrderDTO> reList = new ArrayList<OrSplitOrderDTO>();
		String log = "\n首日拆分日志：\n";
		for (OrSplitOrderDTO qry : queryRes) {
			if (qry.getQuan_firday_mp() == null)
				continue;
			if (!listFirstOr.contains(qry.getId_or()))
				continue;

			// 需求首日执行次数
			int quan_first_mp = qry.getQuan_firday_mp();
			if (quan_first_mp < 1)
				continue;

			List<FDateTime> listSplit = mapSpliting.get(qry.getId_or());
			// 已经拆分的首日次数
			int quan_splited = 0;
			if (listSplit != null && listSplit.size() > 0) {
				for (FDateTime fDt : listSplit) {
					if (DateTimeUtils.isSameDay(qry.getDt_effe(), fDt)) {
						quan_splited++;
					}
				}
			}

			if (quan_first_mp > quan_splited) {
				if (quan_first_mp - quan_splited == 1) {
					// 只能补齐首日一次
					// 补齐的点与生效时间重合时，不补齐
					FDateTime dt_mp_plan = qry.getDt_effe();
					if (listSplit != null && listSplit.size() > 0 && listSplit.contains(dt_mp_plan))
						continue;
					OrSplitOrderDTO add = (OrSplitOrderDTO) qry.clone();
					add.setDt_mp_plan(dt_mp_plan);
					reList.add(add);
				} else {
					log += "医嘱ID：" + qry.getId_or() + "需求首日执行次数:" + quan_first_mp + "已经首日拆分的次数" + quan_splited + "无法计算补齐\n";
				}
			}
			String msg = "医嘱ID：" + qry.getId_or() + "需求首日执行次数:" + quan_first_mp + "已经首日拆分的次数" + quan_splited + "补齐次数" + reList.size() + "\n";
			log += msg;
		}
		logService.log(log, Level.INFO);
		return reList;
	}
}
