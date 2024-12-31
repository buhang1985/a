package iih.ci.ord.s.bp.orsrvsplit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.bd.base.utils.DateTimeUtils;
import iih.mp.nr.i.IMpNrLogService;
import iih.mp.nr.mporplan.d.MpOrPlanDO;
import iih.mp.nr.mporplan.i.IMporplanRService;
import iih.mp.nr.mpsrvplan.d.MpSrvPlanDO;
import iih.mp.nr.mpsrvplan.i.IMpsrvplanRService;
import iih.mp.nr.splitplan.splitresponse.d.FirstDaySplitDTO;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.i.IBaseDO;
import xap.mw.log.logging.Level;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 首日执行次数与实际拆分不相符的补齐计划逻辑
 * 
 * @Description:
 * @author: xu_xing@founder.com.cn
 * @version：2018年3月15日 下午6:01:41 创建
 * @version:2018年3月16日10:32:19首日拆分逻辑迭代
 */
public class OrSrvSplitFirdayMpValidBp {

	/**
	 * 主入口
	 * 
	 * @param params
	 * @param key
	 * @param last_split
	 * @return
	 * @throws BizException
	 */
	public List<BaseDTO> exec1(BaseDTO[] queryRes, BaseDTO[] splitRes, String key, String last_split) throws BizException {

		// 1、基础校验
		if (!validation(queryRes, key, last_split))
			return null;

		// 2、获取含首日拆分的计划
		List<String> listKey = new ArrayList<String>();
		BaseDTO[] firstDayPlans = getFirstSplitRes(queryRes, key, last_split, listKey);

		// 3、获取首日已拆分记录数
		FirstDaySplitDTO[] firstDaySplits = groupParams(splitRes, queryRes, key, last_split, listKey);

		// 4、获取本次拆分需要增补的计划
		List<BaseDTO> rtn = completePlanCount(key, firstDaySplits, listKey, firstDayPlans);

		return rtn;
	}

	/**
	 * 基础校验
	 * 
	 * @param params
	 * @return
	 */
	private boolean validation(BaseDTO[] params, String key, String last_split) throws BizException {
		if (params == null || params.length < 1)
			return false;
		if (StringUtil.isEmptyWithTrim(key))
			throw new BizException("首日拆分key属性为空异常！");
		if (StringUtil.isEmptyWithTrim(last_split))
			throw new BizException("首日拆分最后拆分时间属性为空异常！");
		return true;
	}

	/**
	 * 获取含首日拆分的计划
	 * 
	 * @param params
	 * @param key
	 * @param last_split
	 * @return
	 */
	private BaseDTO[] getFirstSplitRes(BaseDTO[] params, String key, String last_split, List<String> listKey) {
		List<BaseDTO> reList = new ArrayList<BaseDTO>();
		for (BaseDTO param : params) {
			if (FBoolean.FALSE.equals(param.getAttrVal("Fg_long")))
				continue;// 只针对长嘱
			FDateTime dt_effe = (FDateTime) param.getAttrVal("Dt_effe");
			FDateTime dt_last_bl = (FDateTime) param.getAttrVal(last_split);
			if (DateTimeUtils.isSameDay(dt_effe, dt_last_bl)) {// 本次拆分含有第一天的
				reList.add(param);
				listKey.add(param.getAttrVal(key).toString());// 记录需要首日拆分的数据
			}
		}
		return reList.toArray(new BaseDTO[reList.size()]);
	}

	/**
	 * 获取首日已拆分记录数
	 * 
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private FirstDaySplitDTO[] groupParams(BaseDTO[] splitRes, BaseDTO[] queryRes, String key, String last_split, List<String> listKey) throws BizException {
		HashMap<String, FirstDaySplitDTO> reMap = new HashMap<String, FirstDaySplitDTO>();
		HashMap<String, List<FDateTime>> mapSplited = getHasSplitPlan(key, listKey);
		for (BaseDTO baseDTO : queryRes) {
			Object objKey = baseDTO.getAttrVal(key);// 主键校验
			if (objKey == null)
				continue;
			Object quan_mp = baseDTO.getAttrVal("Quan_firday_mp");// 首日执行次数合法校验
			if (quan_mp == null || (Integer) quan_mp == 0)
				continue;
			String id_key = objKey.toString();
			if (!listKey.contains(id_key)) // 无需首日拆分的
				continue;
			FDateTime dt_effe = (FDateTime) baseDTO.getAttrVal("Dt_effe");// 生效时间
			// 已经拆分的次数，和本次拆分的次数
			int splitedCount = getSplitedCount(mapSplited, id_key, dt_effe, splitRes);
				FirstDaySplitDTO firstDayDTO = new FirstDaySplitDTO();
				firstDayDTO.setKey(id_key);// 主键,医嘱ID或者医嘱项目ID
				firstDayDTO.setQuan_first_mp((Integer) quan_mp);// 首日执行次数
			firstDayDTO.setQuan_split(splitedCount);// 首日拆解次数
				firstDayDTO.setDt_effe(dt_effe);// 生效时间
				firstDayDTO.setDt_last_bl((FDateTime) baseDTO.getAttrVal(last_split));// 最后拆解时间
				FArrayList array = new FArrayList();
				array.add(baseDTO);// 记录计划信息，用于首日次数不够时的复制
				firstDayDTO.setAddarray(array);
				reMap.put(id_key, firstDayDTO);
		}

		return reMap.values().toArray(new FirstDaySplitDTO[reMap.size()]);
	}

	/**
	 * 获取医嘱/医嘱项目对应已经拆分的明细
	 * 
	 * @param key
	 * @param listKey
	 * @param dt_data
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, List<FDateTime>> getHasSplitPlan(String key, List<String> listKey) throws BizException {
		HashMap<String, List<FDateTime>> mapSplitedPlan = new HashMap<String, List<FDateTime>>();
		if (!StringUtil.isEmptyWithTrim(key) && listKey != null && listKey.size() > 0) {
			if ("Id_or".equals(key)) {
				MpOrPlanDO[] plans = ServiceFinder.find(IMporplanRService.class).findByAttrValStrings(key, listKey.toArray(new String[0]));
				mapBasePlans(key, plans, mapSplitedPlan);
			} else {
				MpSrvPlanDO[] srvPlans = ServiceFinder.find(IMpsrvplanRService.class).findByAttrValStrings(key, listKey.toArray(new String[0]));
				mapBasePlans(key, srvPlans, mapSplitedPlan);
			}
		}
		return mapSplitedPlan;
	}

	/**
	 * 计划根据医嘱ID/项目ID分组
	 * 
	 * @param key
	 * @param plans
	 * @param mapSplitedPlan
	 */
	private void mapBasePlans(String key, BaseDO[] plans, HashMap<String, List<FDateTime>> mapSplitedPlan) {
		if (plans != null && plans.length > 0) {
			for (BaseDO plan : plans) {
				String keyVal = plan.getAttrVal(key).toString();
				FDateTime dt_mp_plan = (FDateTime) plan.getAttrVal("Dt_mp_plan");
				if (mapSplitedPlan.containsKey(keyVal))
					mapSplitedPlan.get(keyVal).add(dt_mp_plan);
				else {
					List<FDateTime> listData = new ArrayList<FDateTime>();
					listData.add(dt_mp_plan);
					mapSplitedPlan.put(keyVal, listData);
				}
			}
		}
	}

	/**
	 * 获取医嘱/医嘱项目首日已经拆分的计划数量
	 * 
	 * @param mapSplited
	 * @param keyVal
	 * @param dt_date
	 * @return
	 */
	private int getSplitedCount(HashMap<String, List<FDateTime>> mapSplited, String keyVal, FDateTime dt_date, BaseDTO[] splitRes) {
		int reInt = 0;
		if (mapSplited.containsKey(keyVal)) {
			List<FDateTime> listDate = mapSplited.get(keyVal);
			// 已经拆分完成的计划
			if (listDate != null && listDate.size() > 0) {
				for (FDateTime dt : listDate) {
					// 记录首日已经拆分的次数
					if (DateTimeUtils.isSameDay(dt, dt_date))
						reInt++;
				}
			}
		}
		// 本次拆分的计划
		if (splitRes != null && splitRes.length > 0) {
			for (BaseDTO baseDTO : splitRes) {
				if (isFirstPlan(baseDTO, dt_date))
					reInt++;
			}
		}
		return reInt;
	}

	/**
	 * 计划是否是首日的
	 * 
	 * @param baseDTO
	 * @param dt_effe
	 * @return
	 */
	private boolean isFirstPlan(BaseDTO baseDTO, FDateTime dt_effe) {
		FDateTime dt_mp_plan = (FDateTime) baseDTO.getAttrVal("Dt_mp_plan");
		if (dt_mp_plan != null)
			return DateTimeUtils.isSameDay(dt_mp_plan, dt_effe);
		return false;
	}

	/**
	 * 获取本次拆分需要增补的计划
	 * 
	 * @param firstSplits
	 * @return
	 */
	private List<BaseDTO> completePlanCount(String key, FirstDaySplitDTO[] firstSplits, List<String> listKey, BaseDTO[] firstDayPlans) {
		List<BaseDTO> reList = new ArrayList<BaseDTO>();
		HashMap<String, FirstDaySplitDTO> mapFirst = this.mapBaseDO(firstSplits, "Key");
		HashMap<String, BaseDTO> mapFirstQuery = this.mapBaseDO(firstDayPlans, key);
		for (String id_key : listKey) {
			if (mapFirst.containsKey(id_key)) {
				// 首日有计划
				FirstDaySplitDTO firstSplit = mapFirst.get(id_key);
				if (firstSplit.getQuan_first_mp() > firstSplit.getQuan_split()) {
					FArrayList array = firstSplit.getAddarray();
					Object obj = array.get(0);
					if (obj != null) {
						BaseDTO clonePlan = (BaseDTO) ((BaseDTO) obj).clone();
						clonePlan.setAttrVal("Dt_mp_plan", clonePlan.getAttrVal("Dt_effe"));
						reList.add(clonePlan);
					} else
						writeLog("首日执行，补齐执行计划时出现拆解的对象空异常！");
				}
				if (firstSplit.getQuan_first_mp() - firstSplit.getQuan_split() > 1)
					writeLog("首日执行，补齐执行计划时超过了一次！如果首日未拆分完，请忽略！");
			} else {
				// 首日无计划的（比如QD，首日无计划，强制执行一顿的）
				BaseDTO plan = mapFirstQuery.get(id_key);
				BaseDTO clonePlan = (BaseDTO) ((BaseDTO) plan).clone();
				clonePlan.setAttrVal("Dt_mp_plan", clonePlan.getAttrVal("Dt_effe"));
				reList.add(clonePlan);
			}
		}
		return reList;
	}

	/**
	 * BaseDO集合分组
	 * 
	 * @param params
	 * @param attrName
	 * @return
	 */
	public <T extends IBaseDO> HashMap<String, T> mapBaseDO(T[] params, String attrName) {
		HashMap<String, T> reMap = new HashMap<String, T>();
		if (params != null && params.length > 0) {
			for (T t : params) {
				Object key = t.getAttrVal(attrName);
				if (key == null)
					continue;
				reMap.put(key.toString(), t);
			}
		}
		return reMap;
	}

	/**
	 * 记录日志至MP域
	 * 
	 * @param msg
	 */
	private void writeLog(String msg) {
		ServiceFinder.find(IMpNrLogService.class).log(msg, Level.INFO);
	}
}
