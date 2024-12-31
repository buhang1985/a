package iih.bl.hp.rule;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.res.deptb.d.DeptBDO;
import iih.bd.res.deptb.i.IDeptbRService;
import iih.bl.comm.util.BlMsgUtils;
import iih.bl.hp.ep.FreqEP;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.hp.d.HpQryCiorderDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.TreeMap;

import org.omg.CORBA.PRIVATE_MEMBER;

import xap.lui.core.format.DateFormat;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.portal.pin.msg.Msg;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.d.PsndocAggDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.bdfw.bbd.i.IPsndocRService;

public class GetOldMmDaysMapBP {

	/**
	 * 获取已开单的服务物品的持有量天数与服务数据
	 * 
	 * @param historycidtoLst
	 *            原始服务
	 * @param srvAndSrvorDays
	 *            获取使用天数
	 * @param ordsrvMap
	 *            获取对应服务DO
	 * @param 药品开立历史消息
	 * @throws BizException
	 */
	public void exec(FArrayList2 historycidtoLst, HashMap<String, Integer> srvAndSrvorDays, HashMap<String, OrdSrvDO> ordsrvMap, HashMap<String, String> mmHisMsg) throws BizException {
		String msg = "";
		// 1.准备基础数据
		// 当前日期
		FDate currentDate = AppUtils.getServerDate();
		// 药品最早执行日期集合
		HashMap<String, HashMap<FDateTime, Integer>> maxDtEffeMap = new HashMap<String, HashMap<FDateTime, Integer>>();
		// 医嘱开立科室 开立医生
		HashMap<String, String> ciorDepDoctMap = new HashMap<String, String>();
		// 2.设置药品总持有量，设置药品最早执行日期，设置对应的服务DO
		setMaxDay(historycidtoLst, srvAndSrvorDays, ordsrvMap, maxDtEffeMap, currentDate, ciorDepDoctMap);
		// 3.计算剩余持有量天数
		setDtEffeDays(srvAndSrvorDays, maxDtEffeMap, currentDate, mmHisMsg, ciorDepDoctMap);
	}

	/**
	 * 设置药品总持有量，设置药品最早执行日期，设置对应的服务DO
	 * 
	 * @param historycidtoLst
	 *            原始服务
	 * @param srvAndSrvorDays
	 *            持有量天数集合
	 * @param ordsrvMap
	 *            服务集合
	 * @param maxDtEffeMap
	 *            最早开单天数
	 * @param currentDate
	 *            当前日期
	 * @param ciorDepDoctMap
	 *            医嘱对应开立医生和开立科室集合
	 * @throws BizException
	 */
	private void setMaxDay(FArrayList2 historycidtoLst, HashMap<String, Integer> srvAndSrvorDays, HashMap<String, OrdSrvDO> ordsrvMap, HashMap<String, HashMap<FDateTime, Integer>> maxDtEffeMap, FDate currentDate, HashMap<String, String> ciorDepDoctMap) throws BizException {

		if (historycidtoLst != null) {

			for (Object object : historycidtoLst) {
				// 医嘱查询实体 DTO数据
				HpQryCiorderDTO commCiOrder = (HpQryCiorderDTO) object;
				// 医嘱信息
				CiOrderDO oldOr = commCiOrder.getCiorderdo();
				// 判断是否是西药、中成药医嘱
				if (!oldOr.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG))
					continue;
				// xap.mw.log.logging.Logger.warn(oldOr.getName_or()+"下------------------------");

				// 医嘱中包含的服务
				FArrayList2 orSrvs = commCiOrder.getOrdsrvs();

				// 服务下物品
				FArrayList2 orMms = commCiOrder.getOrdsrvmms();
				// 获取单次频次
				FreqEP freqEP = new FreqEP();
				HashMap<String, String> freqOnceMap = freqEP.getOnceFreqMap();
				// 获取出持有量天数的总天数
				for (Object srvObj : orSrvs) {
					OrdSrvDO ordSrvDO = (OrdSrvDO) srvObj;
					if (freqOnceMap.containsKey(ordSrvDO.getId_freq())||(FBoolean.TRUE).equals(ordSrvDO.getFg_self())) {
						continue;// 单次则过滤不校验  自备药不参与持有量校验
					}

					int i=0;
					if (orMms != null)
						for (Object mmObj : orMms) {
							OrdSrvMmDO srvMmDO = (OrdSrvMmDO) mmObj;
							if (ordSrvDO.getId_srv().equals(srvMmDO.getId_srv())) {
								// 持有量键
								String strKey = ordSrvDO.getId_srv() + srvMmDO.getId_mm();
								// 计算当前物品持有量天数
								Integer days = srvMmDO.getDays_available();								
								// log 显示当前获取数据名称 天数 执行日期
								// xap.mw.log.logging.Logger.warn(strKey+srvMmDO.getName_mm()+"   "+days+"   "
								// + oldOr.getDt_effe());
								// xap.mw.log.logging.Logger.debug(strKey+srvMmDO.getName_mm()+"   "+days+"   "
								// + oldOr.getDt_effe());
								// xap.mw.log.logging.Logger.info(strKey+srvMmDO.getName_mm()+"   "+days+"   "
								// + oldOr.getDt_effe());
								// 获取当前开药执行日期
								FDateTime dtEffe = oldOr.getDt_effe();

								ordSrvDO.setId_mm(srvMmDO.getId_mm());
								// 判断是否有此项目
								if (srvAndSrvorDays.containsKey(strKey)) {
									i++;
									// 添加对应日期的持有量天数
									maxDtEffeMap.get(strKey).put(dtEffe.addSeconds(i), days);
									// 赋值当前天数（累加）
									days = days + srvAndSrvorDays.get(strKey);
									// 删除已有数据
									srvAndSrvorDays.remove(strKey);
									ordsrvMap.remove(strKey);
									
								} else {
									HashMap<FDateTime, Integer> dtmap = new HashMap<FDateTime, Integer>();
									dtmap.put(dtEffe, days);
									maxDtEffeMap.put(strKey, dtmap);
								}
								// 组织开立科室和开立医生map
								if (!ciorDepDoctMap.containsKey(strKey + dtEffe.addSeconds(i).toStdString())) {
									String depDoct = "";
									depDoct = getDepAndDoct(oldOr.getId_emp_or(), oldOr.getId_dep_or());
									if (!StringUtil.isEmpty(depDoct)) {
										ciorDepDoctMap.put(strKey + dtEffe.addSeconds(i).toStdString(), depDoct);
									}
								}
								srvAndSrvorDays.put(strKey, days);
								ordsrvMap.put(strKey, ordSrvDO);
							}
						}
				}
			}
		}
	}

	/**
	 * 计算剩余持有量天数
	 * 
	 * @param srvAndSrvorDays
	 *            持有量天数集合
	 * @param maxDtEffeMap
	 *            最早开单天数
	 * @param currentDate
	 * @param mmHisMsg
	 *            开立医嘱的开立天数消息集合
	 * @param ciorDepDoctMap
	 *            开立医生和科室集合 当前日期
	 */
	private void setDtEffeDays(HashMap<String, Integer> srvAndSrvorDays, HashMap<String, HashMap<FDateTime, Integer>> maxDtEffeMap, FDate currentDate, HashMap<String, String> mmHisMsg, HashMap<String, String> ciorDepDoctMap) {
		String msg = "";
		// 循环最早日期
		for (String strKey : maxDtEffeMap.keySet()) {
			// 创建排序集合
			TreeMap<FDateTime, Integer> map = new TreeMap<FDateTime, Integer>(new Comparator<FDateTime>() {
				public int compare(FDateTime obj1, FDateTime obj2) {
					return obj1.compareTo(obj2);// 升序排序
				}
			});
			// 将持有量天数添加到 集合中
			for (FDateTime dtKey : maxDtEffeMap.get(strKey).keySet()) {
				int days = maxDtEffeMap.get(strKey).get(dtKey);
				if (map.containsKey(dtKey))
					days = days + map.get(dtKey);
				map.put(dtKey, days);
			}
			// 上一次区间日期
			FDateTime lastDateTime = null;
			// 区间次有量天数
			Integer s_e_days = 0;

			// xap.mw.log.logging.Logger.warn("+++++ : "+strKey);
			msg = "";
			// 循环排序后持有量数据
			for (FDateTime dtKey : map.keySet()) {
				// 如果上一次区间不为空时 区间持有量=持有量+(上一次区间日期-本次区间日期)如果小于0 为0 ，并加上本次持有量天数

				if (lastDateTime != null) {
					s_e_days = s_e_days + lastDateTime.getDate().asLocalBegin().getDaysAfter(dtKey.getDate().asLocalBegin());
					if (s_e_days < 0)
						s_e_days = 0;
					s_e_days = s_e_days + map.get(dtKey);
					// xap.mw.log.logging.Logger.warn("+++++ : "+dtKey+"   "+s_e_days+"   "
					// +map.get(dtKey));
				} else {
					// 如果是第一次 持有量天数位本次持有量天数
					s_e_days = map.get(dtKey);
				}
				// 将本次区间日期设置为 上次区间日期
				lastDateTime = dtKey;
				msg += BlMsgUtils.GetCheckOpHoldDetailsMsg(lastDateTime.getDate().toString(), ciorDepDoctMap.get(strKey + dtKey.toStdString()), "", map.get(dtKey));
			}

			// 获取当前物品所有持有量 总持有量=区间持有量+(上一次区间日期-当前日期)
			Integer avadays = s_e_days + lastDateTime.getDate().asLocalBegin().getDaysAfter(currentDate.asLocalBegin());

			// 小于0 默认为0
			if (avadays < 0)
				avadays = 0;
			// log 显示当前获取数据Kye 与 天数
			// xap.mw.log.logging.Logger.warn(strKey+"："+avadays+"--------------"
			// );
			// 删除已有的
			srvAndSrvorDays.remove(strKey);

			// 添加计算后持有量值
			srvAndSrvorDays.put(strKey, avadays);
			mmHisMsg.put(strKey, msg);
		}

	}

	/**
	 * 
	 * @param id_emp_or
	 *            开立医生id
	 * @param id_dep_or
	 *            开立科室id
	 * @param DepDoctMap
	 *            返回的医生和科室的map
	 * @throws BizException
	 */
	private String getDepAndDoct(String id_emp_or, String id_dep_or) throws BizException {
		String uName = "", dName = "";
		// 医生信息
		IPsndocMDORService psndocRService = ServiceFinder.find(IPsndocMDORService.class);

		PsnDocDO[] psnDo = psndocRService.find(PsnDocDO.ID_PSNDOC + "='" + id_emp_or + "' or " + PsnDocDO.CODE + "='" + id_emp_or + "'", "", FBoolean.FALSE);
		if (psnDo != null && psnDo.length > 0) {
			uName = psnDo[0].getName();
		}

		// 科室信息
		IDeptbRService depdocRService = ServiceFinder.find(IDeptbRService.class);

		DeptBDO[] deptDO = depdocRService.find(DeptBDO.ID_DEP + "='" + id_dep_or + "' or " + DeptBDO.CODE + "='" + id_dep_or + "'", "", FBoolean.FALSE);
		if (deptDO != null && deptDO.length > 0) {
			dName = deptDO[0].getName();
		}

		return dName + uName;
	}
}
