package iih.ci.ord.s.bp.orsrvsplit.firstmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import iih.bd.base.utils.DateTimeUtils;
import iih.ci.ord.dto.blexorder.d.OrSrvSplitParamDTO;
import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;
import iih.mp.nr.mpsrvplan.d.MpSrvPlanDO;
import iih.mp.nr.mpsrvplan.i.IMpsrvplanRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 
 * @Description:补齐医嘱项目拆分首日不够的逻辑
 * @author: xu_xing@founder.com.cn
 * @version：2018年9月28日 下午8:26:56 创建
 * @version: xuxing_2019年5月29日13:00:58，修复首日补齐逻辑没有查询现有数据，导致首日多补的bug
 */
public class OrSrvSplitFixBp {

	/**
	 * 主入口
	 * 
	 * @param queryRes，查询的结果
	 * @param orSplitRes，拆分后的结果（可能有查询有数据，拆分后没数据）
	 * @return
	 * @throws BizException
	 */
	public List<SrvSplitOrderDTO> exec(SrvSplitOrderDTO[] queryRes, SrvSplitOrderDTO[] orSplitRes, OrSrvSplitParamDTO param) throws BizException {

		// 1、基础校验
		if (!validation(queryRes))
			return null;

		// 2、获取含首日拆分的医嘱ID
		String[] id_orsrvs = getFirstSplitOrs(queryRes, param);
		if (id_orsrvs == null || id_orsrvs.length < 1)
			return null;

		// 3、获取已经拆分的计划信息
		List<String> listFirstOrSrv = Arrays.asList(id_orsrvs);
		MpSrvPlanDO[] srvPlans = getSrvPlans(id_orsrvs, param);

		// 4、获取本次实际拆分的首日记录
		HashMap<String, List<FDateTime>> mapSpliting = getActurlSplit(listFirstOrSrv, orSplitRes);

		// 5、合并已经拆分的结果
		megerSplited(mapSpliting, srvPlans);

		// 6、补齐首日不够的情况
		List<SrvSplitOrderDTO> rtn = figerOutAddPlan(listFirstOrSrv, queryRes, mapSpliting);

		return rtn;
	}

	/**
	 * 基础校验
	 * 
	 * @param queryRes
	 * @return
	 */
	private boolean validation(SrvSplitOrderDTO[] queryRes) {
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
	private String[] getFirstSplitOrs(SrvSplitOrderDTO[] queryRes, OrSrvSplitParamDTO param) {
		List<String> reList = new ArrayList<String>();
		for (SrvSplitOrderDTO qry : queryRes) {
			if (FBoolean.FALSE.equals(qry.getFg_long()))
				continue;
			//			// 本次含首日拆分
			//			if (DateTimeUtils.isSameDay(qry.getDt_effe(), qry.getDt_last_bl())) {
			//				reList.add(qry.getId_orsrv());
			//			}
			if (FBoolean.TRUE.equals(param.getFg_presplit())) {
				if (qry.getDt_effe().compareTo(param.getDt_split_start()) >= 0 && param.getDt_split_end().compareTo(qry.getDt_effe()) >= 0)
					reList.add(qry.getId_orsrv());
			} else {
				// 本次含首日拆分
				if (DateTimeUtils.isSameDay(qry.getDt_effe(), qry.getDt_last_bl()))
					reList.add(qry.getId_orsrv());
			}
		}
		return reList.toArray(new String[0]);
	}

	/**
	 * 获取已经拆分的计划项目信息
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private MpSrvPlanDO[] getSrvPlans(String[] id_orsrvs, OrSrvSplitParamDTO param) throws BizException {
		if (FBoolean.TRUE.equals(param.getFg_presplit()))
			return null;
		return ServiceFinder.find(IMpsrvplanRService.class).findByAttrValStrings(MpSrvPlanDO.ID_ORSRV, id_orsrvs);
	}

	/**
	 * 获取本次实际拆分的首日记录
	 * 
	 * @return
	 */
	private HashMap<String, List<FDateTime>> getActurlSplit(List<String> listFirstOrSrv, SrvSplitOrderDTO[] orSplitRes) {
		HashMap<String, List<FDateTime>> reMap = new HashMap<String, List<FDateTime>>();
		if (orSplitRes == null || orSplitRes.length < 1)
			return reMap;
		for (SrvSplitOrderDTO splitRes : orSplitRes) {
			if (!listFirstOrSrv.contains(splitRes.getId_orsrv()))
				continue;
			List<FDateTime> listSplited = new ArrayList<FDateTime>();
			if (reMap.containsKey(splitRes.getId_orsrv()))
				listSplited = reMap.get(splitRes.getId_orsrv());
			listSplited.add(splitRes.getDt_mp_plan());
			reMap.put(splitRes.getId_orsrv(), listSplited);
		}
		return reMap;
	}

	/**
	 * 合并已经拆分的结果 包含已经拆分完成的计划和本次即将拆分的
	 * 
	 * @param mapSplit
	 * @param plans
	 */
	private void megerSplited(HashMap<String, List<FDateTime>> mapSplit, MpSrvPlanDO[] srvPlans) {
		if (srvPlans == null || srvPlans.length < 1)
			return;
		for (MpSrvPlanDO plan : srvPlans) {
			List<FDateTime> listSplited = null;
			if (mapSplit.containsKey(plan.getId_orsrv())) {
				listSplited = mapSplit.get(plan.getId_orsrv());
			} else {
				listSplited = new ArrayList<FDateTime>();
				mapSplit.put(plan.getId_orsrv(), listSplited);
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
	private List<SrvSplitOrderDTO> figerOutAddPlan(List<String> listFirstOrSrv, SrvSplitOrderDTO[] queryRes, HashMap<String, List<FDateTime>> mapSpliting) {
		List<SrvSplitOrderDTO> reList = new ArrayList<SrvSplitOrderDTO>();
		for (SrvSplitOrderDTO qry : queryRes) {
			if (qry.getQuan_firday_mp() == null)
				continue;
			if (!listFirstOrSrv.contains(qry.getId_orsrv()))
				continue;

			// 需求首日执行次数
			int quan_first_mp = qry.getQuan_firday_mp();
			if (quan_first_mp < 1)
				continue;

			List<FDateTime> listSplit = mapSpliting.get(qry.getId_orsrv());
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
					SrvSplitOrderDTO add = (SrvSplitOrderDTO) qry.clone();
					add.setDt_mp_plan(dt_mp_plan);
					reList.add(add);
				}
			}
		}
		return reList;
	}
}
