package iih.sc.sch.s.bp.mt.apt.filter;

import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.scbd.dto.d.ScBdSrvDTO;
import iih.sc.scbd.schedulesrv.d.ScSrvKindItm;
import iih.sc.scbd.schedulesrv.i.IScSrvKindItmRService;
import iih.sc.sch.s.bp.mt.apt.bp.GetSchproptpKinditmBP;
import iih.sc.sch.s.bp.mt.apt.ep.ScSrvKindEP;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class ScAptKinditmFilter {
	/**
	 * 根据排班类别明细过滤号段
	 * 
	 * @author yzh
	 * @param ticks
	 * @param idSrv
	 * @param idSch
	 * @return
	 * @throws BizException
	 */
	public ScSchTicksDO filterTicksByScSrvKinditm4Manual(ScSchTicksDO tick, String idSrv, String idSch, MtResDTO resDTO)
			throws BizException {
		ScBdSrvDTO[] scbdsrvs = new ScSrvKindEP().getScBdSrv8IdSrv(idSch, idSrv);
		String ids_kinditm = tick.getIds_kinditm();
		Map<String, List<String>> tickReleseKind = null;
		if (StringUtil.isEmpty(ids_kinditm)) {
			return tick;
		}
		String schKindItms = "";
		// 排斥禁止和次数限制为空,且强制并行或提示并行不为空时释放类别明细
		if (ArrayUtil.isEmpty(resDTO.getDays_excl_must().toArray())
				&& ArrayUtil.isEmpty(resDTO.getDays_excl_times().toArray())
				&& ((!ArrayUtil.isEmpty(resDTO.getDays_together_must().toArray()))
						|| (!ArrayUtil.isEmpty(resDTO.getDays_together_hint().toArray())))) {
			schKindItms = new GetSchproptpKinditmBP().exec(idSch);
			if (!StringUtil.isEmpty(schKindItms)) {
				// 获取号源释放的类别
				tickReleseKind = this.getSrvKindByitms(schKindItms.split(","));
			}
		} else if (ArrayUtil.isEmpty(resDTO.getDays_excl_must().toArray())
				&& ArrayUtil.isEmpty(resDTO.getDays_excl_times().toArray()) && (resDTO.getFg_release() != null && resDTO.getFg_release().booleanValue())) {
			schKindItms = new GetSchproptpKinditmBP().exec(idSch);
			if (!StringUtil.isEmpty(schKindItms)) {
				// 获取号源释放的类别
				tickReleseKind = this.getSrvKindByitms(schKindItms.split(","));
			}
		}
		String cond = ScSqlUtils.getInSqlByIds(ScSrvKindItm.ID_SCSRVKINDITM, ids_kinditm.split(","));
		IScSrvKindItmRService iscsrvkinditmrservice = ServiceFinder.find(IScSrvKindItmRService.class);
		ScSrvKindItm[] scSrvKindItms = iscsrvkinditmrservice.find(cond, null, FBoolean.FALSE);
		// 根据服务上的类别明细查询出DO DO上的服务类别需要参与到下面的类别明细的校验
		Map<String, String> scSrvKindItmMap = ScAppUtils.extractStrMapFromObjs(ScSrvKindItm.ID_SCSRVKIND,
				"Id_scsrvkinditem", scbdsrvs, schKindItms);

		// 根据号位号段上的类别明细查询出DO DO上的服务类别需要参与到下面的类别明细的校验
		Map<String, List<String>> scTickKindItmMap = ScAppUtils.extractStrMapFromObjs(ScSrvKindItm.ID_SCSRVKIND,
				ScSrvKindItm.ID_SCSRVKINDITM, scSrvKindItms);

		for (Map.Entry<String, List<String>> entry : scTickKindItmMap.entrySet()) {
			String id_scsrvkind = entry.getKey();
			// 释放类别明细校验
			if (tickReleseKind != null) {
				List<String> ids_kinditm_list_tick = scTickKindItmMap.get(id_scsrvkind);
				List<String> ids_kinditm_list_rele = tickReleseKind.get(id_scsrvkind);
				// 如果释放的类别存在排班的类别 且 服务类别中不存在
				if (scTickKindItmMap.containsKey(id_scsrvkind) && !scSrvKindItmMap.containsKey(id_scsrvkind)) {
					// 如果释放的明细全包含号位的明细,校验通过,否则失败
					if (!ListUtil.isEmpty(ids_kinditm_list_rele)
							&& ids_kinditm_list_rele.containsAll(ids_kinditm_list_tick)) {
						continue;
					} else {
						return null;
					}
				}
				// 如果释放的类别存在排班的类别 且 服务类别中存在
				else if (tickReleseKind.containsKey(id_scsrvkind) && scSrvKindItmMap.containsKey(id_scsrvkind)) {
					// 在号位中添加所有释放的类别明细
					ids_kinditm_list_tick.addAll(ids_kinditm_list_rele);
				}
			}
			// 判断服务是否包含号位号段上的类别
			if (scSrvKindItmMap.containsKey(id_scsrvkind)) {
				// 取出号位号段上的类别对应的明细集合list
				List<String> id_kinditm_list = scTickKindItmMap.get(id_scsrvkind);
				// 判断号位号段上的类别对应明细是否包含服务上该类别下的明细
				if (!id_kinditm_list.contains(scSrvKindItmMap.get(id_scsrvkind))
						&& !StringUtil.isEmpty(scSrvKindItmMap.get(id_scsrvkind))) {
					return null;
				}
			} else {
				return null;
			}
		}
		return tick;
	}

	/**
	 * 根据排班类别明细过滤号位
	 * 
	 * @author yzh
	 * @param ticks
	 * @param idSrv
	 * @param idSch
	 * @return
	 * @throws BizException
	 */
	public ScSchTickDO filterTickByScSrvKinditm4Manual(ScSchTickDO tick, String idSrv, String idSch, MtResDTO resDTO)
			throws BizException {
		ScBdSrvDTO[] scbdsrvs = new ScSrvKindEP().getScBdSrv8IdSrv(idSch, idSrv);
		String ids_kinditm = tick.getIds_kinditm();
		if (StringUtil.isEmpty(ids_kinditm)) {
			return tick;
		}

		String schKindItms = "";
		Map<String, List<String>> tickReleseKind = null;
		// 排斥禁止和次数限制为空,且强制并行或提示并行不为空时释放类别明细
		if (ArrayUtil.isEmpty(resDTO.getDays_excl_must().toArray())
				&& ArrayUtil.isEmpty(resDTO.getDays_excl_times().toArray())
				&& ((!ArrayUtil.isEmpty(resDTO.getDays_together_must().toArray()))
						|| (!ArrayUtil.isEmpty(resDTO.getDays_together_hint().toArray())))) {
			schKindItms = new GetSchproptpKinditmBP().exec(idSch);
			if (!StringUtil.isEmpty(schKindItms)) {
				// 获取号源释放的类别
				tickReleseKind = this.getSrvKindByitms(schKindItms.split(","));
			}
		} else if (ArrayUtil.isEmpty(resDTO.getDays_excl_must().toArray())
				&& ArrayUtil.isEmpty(resDTO.getDays_excl_times().toArray()) && (resDTO.getFg_release() != null && resDTO.getFg_release().booleanValue())) {
			schKindItms = new GetSchproptpKinditmBP().exec(idSch);
			if (!StringUtil.isEmpty(schKindItms)) {
				// 获取号源释放的类别
				tickReleseKind = this.getSrvKindByitms(schKindItms.split(","));
			}
		}
		String cond = ScSqlUtils.getInSqlByIds(ScSrvKindItm.ID_SCSRVKINDITM, ids_kinditm.split(","));
		IScSrvKindItmRService iscsrvkinditmrservice = ServiceFinder.find(IScSrvKindItmRService.class);
		ScSrvKindItm[] scSrvKindItms = iscsrvkinditmrservice.find(cond, null, FBoolean.FALSE);
		// 根据服务上的类别明细查询出DO DO上的服务类别需要参与到下面的类别明细的校验
		Map<String, String> scSrvKindItmMap = ScAppUtils.extractStrMapFromObjs(ScSrvKindItm.ID_SCSRVKIND,
				"Id_scsrvkinditem", scbdsrvs, schKindItms);

		// 根据号位号段上的类别明细查询出DO DO上的服务类别需要参与到下面的类别明细的校验
		Map<String, List<String>> scTickKindItmMap = ScAppUtils.extractStrMapFromObjs(ScSrvKindItm.ID_SCSRVKIND,
				ScSrvKindItm.ID_SCSRVKINDITM, scSrvKindItms);

		for (Map.Entry<String, List<String>> entry : scTickKindItmMap.entrySet()) {
			String id_scsrvkind = entry.getKey();
			// 释放类别明细校验
			if (tickReleseKind != null) {
				List<String> ids_kinditm_list_tick = scTickKindItmMap.get(id_scsrvkind);
				List<String> ids_kinditm_list_rele = tickReleseKind.get(id_scsrvkind);
				// 如果释放的类别存在排班的类别 且 服务类别中不存在
				if (scTickKindItmMap.containsKey(id_scsrvkind) && !scSrvKindItmMap.containsKey(id_scsrvkind)) {
					// 如果释放的明细全包含号位的明细,校验通过,否则失败
					if (!ListUtil.isEmpty(ids_kinditm_list_rele)
							&& ids_kinditm_list_rele.containsAll(ids_kinditm_list_tick)) {
						continue;
					} else {
						return null;
					}
				}
				// 如果释放的类别存在排班的类别 且 服务类别中存在
				else if (tickReleseKind.containsKey(id_scsrvkind) && scSrvKindItmMap.containsKey(id_scsrvkind)) {
					// 在号位中添加所有释放的类别明细
					ids_kinditm_list_tick.addAll(ids_kinditm_list_rele);
				}
			}
			// 判断服务是否包含号位号段上的类别
			if (scSrvKindItmMap.containsKey(id_scsrvkind)) {
				// 取出号位号段上的类别对应的明细集合list
				List<String> id_kinditm_list = scTickKindItmMap.get(id_scsrvkind);
				// 判断号位号段上的类别对应明细是否包含服务上该类别下的明细 释放掉的类别,类别明细是空
				if (!id_kinditm_list.contains(scSrvKindItmMap.get(id_scsrvkind))
						&& !StringUtil.isEmpty(scSrvKindItmMap.get(id_scsrvkind))) {
					return null;
				}
			} else {
				return null;
			}
		}
		return tick;
	}

	/**
	 * 根据排班类别明细过滤号位
	 * 
	 * @author yzh
	 * @param ticks
	 * @param idSrv
	 * @param idSch
	 * @return
	 * @throws BizException
	 */
	public ScSchTickDO[] filterTickByScSrvKinditm4Manual(ScSchTickDO[] ticks, String idSrv, String idSch,
			MtResDTO resDTO) throws BizException {
		String schKindItms = "";
		Map<String, List<String>> tickReleseKind = null;
		// 排斥禁止和次数限制为空,且强制并行或提示并行不为空时释放类别明细
		if (ArrayUtil.isEmpty(resDTO.getDays_excl_must().toArray())
				&& ArrayUtil.isEmpty(resDTO.getDays_excl_times().toArray())
				&& ((!ArrayUtil.isEmpty(resDTO.getDays_together_must().toArray()))
						|| (!ArrayUtil.isEmpty(resDTO.getDays_together_hint().toArray())))) {
			schKindItms = new GetSchproptpKinditmBP().exec(idSch);
			if (!StringUtil.isEmpty(schKindItms)) {
				// 获取号源释放的类别
				tickReleseKind = this.getSrvKindByitms(schKindItms.split(","));
			}
		} else if (ArrayUtil.isEmpty(resDTO.getDays_excl_must().toArray())
				&& ArrayUtil.isEmpty(resDTO.getDays_excl_times().toArray()) && (resDTO.getFg_release() != null && resDTO.getFg_release().booleanValue())) {
			schKindItms = new GetSchproptpKinditmBP().exec(idSch);
			if (!StringUtil.isEmpty(schKindItms)) {
				// 获取号源释放的类别
				tickReleseKind = this.getSrvKindByitms(schKindItms.split(","));
			}
		}
		//根据排班id和服务id查询服务的排班类别细目
		ScBdSrvDTO[] scbdsrvs = new ScSrvKindEP().getScBdSrv8IdSrv(idSch, idSrv);
		List<ScSchTickDO> canUseKinditmresult = new ArrayList<ScSchTickDO>();
		IScSrvKindItmRService iscsrvkinditmrservice = ServiceFinder.find(IScSrvKindItmRService.class);
		for (ScSchTickDO tick : ticks) {
			String ids_kinditm = tick.getIds_kinditm();
			if (StringUtil.isEmpty(ids_kinditm)) {
				canUseKinditmresult.add(tick);
				continue;
			}

			String cond = ScSqlUtils.getInSqlByIds(ScSrvKindItm.ID_SCSRVKINDITM, ids_kinditm.split(","));
			ScSrvKindItm[] scSrvKindItms = iscsrvkinditmrservice.find(cond, null, FBoolean.FALSE);

			// 根据服务上的类别明细查询出DO DO上的服务类别需要参与到下面的类别明细的校验
			Map<String, String> scSrvKindItmMap = ScAppUtils.extractStrMapFromObjs(ScSrvKindItm.ID_SCSRVKIND,
					"Id_scsrvkinditem", scbdsrvs, schKindItms);

			// 根据号位号段上的类别明细查询出DO DO上的服务类别需要参与到下面的类别明细的校验
			Map<String, List<String>> scTickKindItmMap = ScAppUtils.extractStrMapFromObjs(ScSrvKindItm.ID_SCSRVKIND,
					ScSrvKindItm.ID_SCSRVKINDITM, scSrvKindItms);
			boolean isCheckKinditm = true;
			if (!StringUtil.isEmpty(ids_kinditm)) {
				for (Map.Entry<String, List<String>> entry : scTickKindItmMap.entrySet()) {
					String id_scsrvkind = entry.getKey();
					// 释放类别明细校验
					if (tickReleseKind != null) {
						List<String> ids_kinditm_list_tick = scTickKindItmMap.get(id_scsrvkind);
						List<String> ids_kinditm_list_rele = tickReleseKind.get(id_scsrvkind);
						// 如果释放的类别存在排班的类别 且 服务类别中不存在
						if (scTickKindItmMap.containsKey(id_scsrvkind) && !scSrvKindItmMap.containsKey(id_scsrvkind)) {
							// 如果释放的明细全包含号位的明细,校验通过,否则失败
							if (!ListUtil.isEmpty(ids_kinditm_list_rele)
									&& ids_kinditm_list_rele.containsAll(ids_kinditm_list_tick)) {
								continue;
							} else {
								return null;
							}
						}
						// 如果释放的类别存在排班的类别 且 服务类别中存在
						else if (tickReleseKind.containsKey(id_scsrvkind)
								&& scSrvKindItmMap.containsKey(id_scsrvkind)) {
							// 在号位中添加所有释放的类别明细
							ids_kinditm_list_tick.addAll(ids_kinditm_list_rele);
						}
					}

					// 判断服务是否包含号位号段上的类别
					if (scSrvKindItmMap.containsKey(id_scsrvkind)) {
						// 取出号位号段上的类别对应的明细集合list
						List<String> id_kinditm_list = scTickKindItmMap.get(id_scsrvkind);
						// 判断号位号段上的类别对应明细是否包含服务上该类别下的明细 释放掉的类别,类别明细是空
						if (!id_kinditm_list.contains(scSrvKindItmMap.get(id_scsrvkind))
								&& !StringUtil.isEmpty(scSrvKindItmMap.get(id_scsrvkind))) {
							isCheckKinditm = false;
						}
					} else {
						isCheckKinditm = false;
					}
				}
			}
			if (isCheckKinditm) {
				canUseKinditmresult.add(tick);
			}
		}
		if (ListUtil.isEmpty(canUseKinditmresult)) {
			return null;
		}
		return canUseKinditmresult.toArray(new ScSchTickDO[canUseKinditmresult.size()]);
	}

	/**
	 * 根据排班类别明细过滤号位
	 * 
	 * @author yzh
	 * @param ticks
	 * @param idSrv
	 * @param idSch
	 * @return
	 * @throws BizException
	 */
	public ScSchTickDO[] filterTickByScSrvKinditm4Auto(ScSchTickDO[] ticks, String idSrv, String idSch,
			FBoolean fg_release) throws BizException {
		String schKindItms = "";
		Map<String, List<String>> tickReleseKind = null;
		if (FBoolean.TRUE.equals(fg_release)) {
			schKindItms = new GetSchproptpKinditmBP().exec(idSch);
			if (!StringUtil.isEmpty(schKindItms)) {
				// 获取号源释放的类别
				tickReleseKind = this.getSrvKindByitms(schKindItms.split(","));
			}
		}
		ScBdSrvDTO[] scbdsrvs = new ScSrvKindEP().getScBdSrv8IdSrv(idSch, idSrv);
		List<ScSchTickDO> canUseKinditmresult = new ArrayList<ScSchTickDO>();
		IScSrvKindItmRService iscsrvkinditmrservice = ServiceFinder.find(IScSrvKindItmRService.class);
		for (ScSchTickDO tick : ticks) {
			String ids_kinditm = tick.getIds_kinditm();
			if (StringUtil.isEmpty(ids_kinditm)) {
				canUseKinditmresult.add(tick);
				continue;
			}

			String cond = ScSqlUtils.getInSqlByIds(ScSrvKindItm.ID_SCSRVKINDITM, ids_kinditm.split(","));
			ScSrvKindItm[] scSrvKindItms = iscsrvkinditmrservice.find(cond, null, FBoolean.FALSE);
			// 根据服务上的类别明细查询出DO DO上的服务类别需要参与到下面的类别明细的校验
			Map<String, String> scSrvKindItmMap = ScAppUtils.extractStrMapFromObjs(ScSrvKindItm.ID_SCSRVKIND,
					"Id_scsrvkinditem", scbdsrvs, schKindItms);
			// 根据号位号段上的类别明细查询出DO DO上的服务类别需要参与到下面的类别明细的校验
			Map<String, List<String>> scTickKindItmMap = ScAppUtils.extractStrMapFromObjs(ScSrvKindItm.ID_SCSRVKIND,
					ScSrvKindItm.ID_SCSRVKINDITM, scSrvKindItms);
			boolean isCheckKinditm = true;
			if (!StringUtil.isEmpty(ids_kinditm)) {
				for (Map.Entry<String, List<String>> entry : scTickKindItmMap.entrySet()) {
					String id_scsrvkind = entry.getKey();
					// 释放类别明细校验
					if (tickReleseKind != null) {
						List<String> ids_kinditm_list_tick = scTickKindItmMap.get(id_scsrvkind);
						List<String> ids_kinditm_list_rele = tickReleseKind.get(id_scsrvkind);
						// 如果释放的类别存在排班的类别 且 服务类别中不存在
						if (scTickKindItmMap.containsKey(id_scsrvkind) && !scSrvKindItmMap.containsKey(id_scsrvkind)) {
							// 如果释放的明细全包含号位的明细,校验通过,否则失败
							if (!ListUtil.isEmpty(ids_kinditm_list_rele)
									&& ids_kinditm_list_rele.containsAll(ids_kinditm_list_tick)) {
								canUseKinditmresult.add(tick);
								continue;
							} else {
								isCheckKinditm = false;
							}
						}
						// 如果释放的类别存在排班的类别 且 服务类别中存在
						else if (tickReleseKind.containsKey(id_scsrvkind)
								&& scSrvKindItmMap.containsKey(id_scsrvkind)) {
							// 在号位中添加所有释放的类别明细
							ids_kinditm_list_tick.addAll(ids_kinditm_list_rele);
						}
					}
					// 判断服务是否包含号位号段上的类别
					if (scSrvKindItmMap.containsKey(id_scsrvkind)) {
						// 取出号位号段上的类别对应的明细集合list
						List<String> id_kinditm_list = scTickKindItmMap.get(id_scsrvkind);
						// 判断号位号段上的类别对应明细是否包含服务上该类别下的明细 释放掉的类别,类别明细是空
						if (!id_kinditm_list.contains(scSrvKindItmMap.get(id_scsrvkind))
								&& !StringUtil.isEmpty(scSrvKindItmMap.get(id_scsrvkind))) {
							isCheckKinditm = false;
						}
					} else {
						isCheckKinditm = false;
					}
				}
			}
			if (isCheckKinditm) {
				canUseKinditmresult.add(tick);
			}
		}
		if (ListUtil.isEmpty(canUseKinditmresult)) {
			return null;
		}
		return canUseKinditmresult.toArray(new ScSchTickDO[canUseKinditmresult.size()]);
	}

	/**
	 * 排班类别明细过滤 号段模式下过滤号段的排班服务类别明细
	 * 
	 * @author yzh
	 * @param filterDOs
	 * @param idSrv
	 * @param idSch
	 * @return
	 * @throws BizException
	 */
	public ScSchTicksDO[] filterTicksByScSrvKinditm4Auto(ScSchTicksDO[] filterDOs, String idSrv, String idSch,
			FBoolean fg_release) throws BizException {
		String schKindItms = "";
		Map<String, List<String>> tickReleseKind = null;
		// 排斥禁止和次数限制为空,且强制并行或提示并行不为空时释放类别明细
		if (FBoolean.TRUE.equals(fg_release)) {
			schKindItms = new GetSchproptpKinditmBP().exec(idSch);
			if (!StringUtil.isEmpty(schKindItms)) {
				// 获取号源释放的类别
				tickReleseKind = this.getSrvKindByitms(schKindItms.split(","));
			}
		}
		ScBdSrvDTO[] scbdsrvs = new ScSrvKindEP().getScBdSrv8IdSrv(idSch, idSrv);
		IScSrvKindItmRService iscsrvkinditmrservice = ServiceFinder.find(IScSrvKindItmRService.class);
		List<ScSchTicksDO> canUseKinditmresult = new ArrayList<ScSchTicksDO>();
		for (ScSchTicksDO ticks : filterDOs) {
			String ids_kinditm = ticks.getIds_kinditm();
			if (StringUtil.isEmpty(ids_kinditm)) {
				canUseKinditmresult.add(ticks);
				continue;
			}

			String cond = ScSqlUtils.getInSqlByIds(ScSrvKindItm.ID_SCSRVKINDITM, ids_kinditm.split(","));
			ScSrvKindItm[] scSrvKindItms = iscsrvkinditmrservice.find(cond, null, FBoolean.FALSE);
			// 根据服务上的类别明细查询出DO DO上的服务类别需要参与到下面的类别明细的校验
			Map<String, String> scSrvKindItmMap = ScAppUtils.extractStrMapFromObjs(ScSrvKindItm.ID_SCSRVKIND,
					"Id_scsrvkinditem", scbdsrvs, schKindItms);
			// 根据号位号段上的类别明细查询出DO DO上的服务类别需要参与到下面的类别明细的校验
			Map<String, List<String>> scTickKindItmMap = ScAppUtils.extractStrMapFromObjs(ScSrvKindItm.ID_SCSRVKIND,
					ScSrvKindItm.ID_SCSRVKINDITM, scSrvKindItms);
			boolean isCheckKinditm = true;
			if (!StringUtil.isEmpty(ids_kinditm)) {
				for (Map.Entry<String, List<String>> entry : scTickKindItmMap.entrySet()) {
					String id_scsrvkind = entry.getKey();

					// 释放类别明细校验
					if (tickReleseKind != null) {
						List<String> ids_kinditm_list_tick = scTickKindItmMap.get(id_scsrvkind);
						List<String> ids_kinditm_list_rele = tickReleseKind.get(id_scsrvkind);
						// 如果释放的类别存在排班的类别 且 服务类别中不存在
						if (scTickKindItmMap.containsKey(id_scsrvkind) && !scSrvKindItmMap.containsKey(id_scsrvkind)) {
							// 如果释放的明细全包含号位的明细,校验通过,否则失败
							if (!ListUtil.isEmpty(ids_kinditm_list_rele)
									&& ids_kinditm_list_rele.containsAll(ids_kinditm_list_tick)) {
								canUseKinditmresult.add(ticks);
								continue;
							} else {
								isCheckKinditm = false;
							}
						}
						// 如果释放的类别存在排班的类别 且 服务类别中存在
						else if (tickReleseKind.containsKey(id_scsrvkind)
								&& scSrvKindItmMap.containsKey(id_scsrvkind)) {
							// 在号位中添加所有释放的类别明细
							ids_kinditm_list_tick.addAll(ids_kinditm_list_rele);
						}
					}

					// 判断服务是否包含号位号段上的类别
					if (scSrvKindItmMap.containsKey(id_scsrvkind)) {
						// 取出号位号段上的类别对应的明细集合list
						List<String> id_kinditm_list = scTickKindItmMap.get(id_scsrvkind);
						// 判断号位号段上的类别对应明细是否包含服务上该类别下的明细 释放掉的类别,类别明细是空
						if (!id_kinditm_list.contains(scSrvKindItmMap.get(id_scsrvkind))
								&& !StringUtil.isEmpty(scSrvKindItmMap.get(id_scsrvkind))) {
							isCheckKinditm = false;
						}
					} else {
						isCheckKinditm = false;
					}
				}
			}
			if (isCheckKinditm) {
				canUseKinditmresult.add(ticks);
			}
		}
		if (ListUtil.isEmpty(canUseKinditmresult)) {
			return null;
		}
		return canUseKinditmresult.toArray(new ScSchTicksDO[canUseKinditmresult.size()]);
	}

	/**
	 * 排班类别明细过滤 号段模式下过滤号段的排班服务类别明细
	 * 
	 * @author yzh
	 * @param filterDOs
	 * @param idSrv
	 * @param idSch
	 * @return
	 * @throws BizException
	 */
	public List<String> filterTicksByScSrvKinditm4Manuals(ScSchTicksDO[] filterDOs, String idSrv, String idSch,
			MtResDTO resDTO) throws BizException {
		String schKindItms = "";
		Map<String, List<String>> tickReleseKind = null;
		// 排斥禁止和次数限制为空,且强制并行或提示并行不为空时释放类别明细
		if (ArrayUtil.isEmpty(resDTO.getDays_excl_must().toArray())
				&& ArrayUtil.isEmpty(resDTO.getDays_excl_times().toArray())
				&& ((!ArrayUtil.isEmpty(resDTO.getDays_together_must().toArray()))
						|| (!ArrayUtil.isEmpty(resDTO.getDays_together_hint().toArray())))) {
			schKindItms = new GetSchproptpKinditmBP().exec(idSch);
			if (!StringUtil.isEmpty(schKindItms)) {
				// 获取号源释放的类别
				tickReleseKind = this.getSrvKindByitms(schKindItms.split(","));
			}
		} else if (ArrayUtil.isEmpty(resDTO.getDays_excl_must().toArray())
				&& ArrayUtil.isEmpty(resDTO.getDays_excl_times().toArray()) && (resDTO.getFg_release() != null && resDTO.getFg_release().booleanValue())) {
			schKindItms = new GetSchproptpKinditmBP().exec(idSch);
			if (!StringUtil.isEmpty(schKindItms)) {
				// 获取号源释放的类别
				tickReleseKind = this.getSrvKindByitms(schKindItms.split(","));
			}
		}
		ScBdSrvDTO[] scbdsrvs = new ScSrvKindEP().getScBdSrv8IdSrv(idSch, idSrv);
		IScSrvKindItmRService iscsrvkinditmrservice = ServiceFinder.find(IScSrvKindItmRService.class);
		List<String> canUseKinditmresult = new ArrayList<String>();
		for (ScSchTicksDO ticks : filterDOs) {
			String ids_kinditm = ticks.getIds_kinditm();
			if (StringUtil.isEmpty(ids_kinditm)) {
				canUseKinditmresult.add(ticks.getId_ticks());
				continue;
			}

			String cond = ScSqlUtils.getInSqlByIds(ScSrvKindItm.ID_SCSRVKINDITM, ids_kinditm.split(","));
			ScSrvKindItm[] scSrvKindItms = iscsrvkinditmrservice.find(cond, null, FBoolean.FALSE);
			// 根据服务上的类别明细查询出DO DO上的服务类别需要参与到下面的类别明细的校验
			Map<String, String> scSrvKindItmMap = ScAppUtils.extractStrMapFromObjs(ScSrvKindItm.ID_SCSRVKIND,
					"Id_scsrvkinditem", scbdsrvs, schKindItms);
			// 根据号位号段上的类别明细查询出DO DO上的服务类别需要参与到下面的类别明细的校验
			Map<String, List<String>> scTickKindItmMap = ScAppUtils.extractStrMapFromObjs(ScSrvKindItm.ID_SCSRVKIND,
					ScSrvKindItm.ID_SCSRVKINDITM, scSrvKindItms);
			boolean isCheckKinditm = true;
			if (!StringUtil.isEmpty(ids_kinditm)) {
				for (Map.Entry<String, List<String>> entry : scTickKindItmMap.entrySet()) {
					String id_scsrvkind = entry.getKey();

					// 释放类别明细校验
					if (tickReleseKind != null) {
						List<String> ids_kinditm_list_tick = scTickKindItmMap.get(id_scsrvkind);
						List<String> ids_kinditm_list_rele = tickReleseKind.get(id_scsrvkind);
						// 如果释放的类别存在排班的类别 且 服务类别中不存在
						if (scTickKindItmMap.containsKey(id_scsrvkind) && !scSrvKindItmMap.containsKey(id_scsrvkind)) {
							// 如果释放的明细全包含号位的明细,校验通过,否则失败
							if (!ListUtil.isEmpty(ids_kinditm_list_rele)
									&& ids_kinditm_list_rele.containsAll(ids_kinditm_list_tick)) {
								canUseKinditmresult.add(ticks.getId_ticks());
								continue;
							} else {
								isCheckKinditm = false;
							}
						}
						// 如果释放的类别存在排班的类别 且 服务类别中存在
						else if (tickReleseKind.containsKey(id_scsrvkind)
								&& scSrvKindItmMap.containsKey(id_scsrvkind)) {
							// 在号位中添加所有释放的类别明细
							ids_kinditm_list_tick.addAll(ids_kinditm_list_rele);
						}
					}

					// 判断服务是否包含号位号段上的类别
					if (scSrvKindItmMap.containsKey(id_scsrvkind)) {
						// 取出号位号段上的类别对应的明细集合list
						List<String> id_kinditm_list = scTickKindItmMap.get(id_scsrvkind);
						// 判断号位号段上的类别对应明细是否包含服务上该类别下的明细 释放掉的类别,类别明细是空
						if (!id_kinditm_list.contains(scSrvKindItmMap.get(id_scsrvkind))
								&& !StringUtil.isEmpty(scSrvKindItmMap.get(id_scsrvkind))) {
							isCheckKinditm = false;
						}
					} else {
						isCheckKinditm = false;
					}
				}
			}
			if (isCheckKinditm) {
				canUseKinditmresult.add(ticks.getId_ticks());
			}
		}
		if (ListUtil.isEmpty(canUseKinditmresult)) {
			return null;
		}
		return canUseKinditmresult;
	}

	/**
	 * 根据排班类别明细过滤号段
	 * 
	 * @author yzh
	 * @param ticks
	 * @param idSrv
	 * @param idSch
	 * @param schKindItm
	 *            需要释放的类别明细
	 * @return
	 * @throws BizException
	 */
	public ScSchTicksDO filterTicksByScSrvKinditm(ScSchTicksDO tick, String idSrv, String idSch, FBoolean fg_release)
			throws BizException {
		String schKindItms = "";
		Map<String, List<String>> tickReleseKind = null;
		if (FBoolean.TRUE.equals(fg_release)) {
			schKindItms = new GetSchproptpKinditmBP().exec(idSch);
			if (!StringUtil.isEmpty(schKindItms)) {
				// 获取号源释放的类别
				tickReleseKind = this.getSrvKindByitms(schKindItms.split(","));
			}
		}

		ScBdSrvDTO[] scbdsrvs = new ScSrvKindEP().getScBdSrv8IdSrv(idSch, idSrv);
		String ids_kinditm = tick.getIds_kinditm();
		if (StringUtil.isEmpty(ids_kinditm)) {
			return tick;
		}
		String cond = ScSqlUtils.getInSqlByIds(ScSrvKindItm.ID_SCSRVKINDITM, ids_kinditm.split(","));

		IScSrvKindItmRService iscsrvkinditmrservice = ServiceFinder.find(IScSrvKindItmRService.class);
		ScSrvKindItm[] scSrvKindItms = iscsrvkinditmrservice.find(cond, null, FBoolean.FALSE);
		// 根据服务上的类别明细查询出DO DO上的服务类别需要参与到下面的类别明细的校验
		Map<String, String> scSrvKindItmMap = ScAppUtils.extractStrMapFromObjs(ScSrvKindItm.ID_SCSRVKIND,
				"Id_scsrvkinditem", scbdsrvs, schKindItms);
		// 根据号位号段上的类别明细查询出DO DO上的服务类别需要参与到下面的类别明细的校验
		Map<String, List<String>> scTickKindItmMap = ScAppUtils.extractStrMapFromObjs(ScSrvKindItm.ID_SCSRVKIND,
				ScSrvKindItm.ID_SCSRVKINDITM, scSrvKindItms);

		for (Map.Entry<String, List<String>> entry : scTickKindItmMap.entrySet()) {
			String id_scsrvkind = entry.getKey();
			// 释放类别明细校验
			if (tickReleseKind != null) {
				List<String> ids_kinditm_list_tick = scTickKindItmMap.get(id_scsrvkind);
				List<String> ids_kinditm_list_rele = tickReleseKind.get(id_scsrvkind);
				// 如果释放的类别存在排班的类别 且 服务类别中不存在
				if (scTickKindItmMap.containsKey(id_scsrvkind) && !scSrvKindItmMap.containsKey(id_scsrvkind)) {
					// 如果释放的明细全包含号位的明细,校验通过,否则失败
					if (!ListUtil.isEmpty(ids_kinditm_list_rele)
							&& ids_kinditm_list_rele.containsAll(ids_kinditm_list_tick)) {
						continue;
					} else {
						return null;
					}
				}
				// 如果释放的类别存在排班的类别 且 服务类别中存在
				else if (tickReleseKind.containsKey(id_scsrvkind) && scSrvKindItmMap.containsKey(id_scsrvkind)) {
					// 在号位中添加所有释放的类别明细
					ids_kinditm_list_tick.addAll(ids_kinditm_list_rele);
				}
			}

			// 判断服务是否包含号位号段上的类别
			if (scSrvKindItmMap.containsKey(id_scsrvkind)) {
				// 取出号位号段上的类别对应的明细集合list
				List<String> id_kinditm_list = scTickKindItmMap.get(id_scsrvkind);
				// 判断号位号段上的类别对应明细是否包含服务上该类别下的明细 释放掉的类别,类别明细是空
				if (!id_kinditm_list.contains(scSrvKindItmMap.get(id_scsrvkind))
						&& !StringUtil.isEmpty(scSrvKindItmMap.get(id_scsrvkind))) {
					return null;
				}
			} else {
				return null;
			}
		}
		return tick;
	}

	/**
	 * 根据类别明细获取对应类别
	 * 
	 * @param kinditms
	 * @return
	 * @throws DAException
	 */
	private Map<String, List<String>> getSrvKindByitms(String[] kinditms) throws DAException {
		StringBuilder sql = new StringBuilder();
		sql.append("select itm.Id_scsrvkinditm,itm.id_scsrvkind from sc_srv_kind_itm itm where ");
		sql.append(ScSqlUtils.getInSqlByIds("itm.id_scsrvkinditm", kinditms));
		List<ScSrvKindItm> resList = (List<ScSrvKindItm>) new DAFacade().execQuery(sql.toString(),
				new BeanListHandler(ScSrvKindItm.class));
		if (resList == null || resList.size() == 0) {
			return null;
		}
		Map<String, List<String>> result = ScAppUtils.extractStrMapFromObjs(ScSrvKindItm.ID_SCSRVKIND,
				ScSrvKindItm.ID_SCSRVKINDITM, resList.toArray(new ScSrvKindItm[0]));
		return result;

	}
}
