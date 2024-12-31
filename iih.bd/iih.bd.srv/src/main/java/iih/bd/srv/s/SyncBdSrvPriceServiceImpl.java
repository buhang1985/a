package iih.bd.srv.s;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.pp.listener.d.MedSrvEventDTO;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.srv.d.MmPriceDTO;
import iih.bd.srv.i.ISyncBdSrvPriceService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.d.desc.MedSrvDODesc;
import iih.bd.srv.medsrv.s.MedsrvCrudServiceImpl;
import iih.bd.srv.s.bp.BdSelfSrvPricesCalBP;
import iih.bd.srv.s.bp.GetOutlineSrvRefMmBP;
import iih.bd.utils.log.BdSrvLogUtils;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.devcfg.alert.taskcenter.itf.ISchedulerServiceAPI;

@Service(serviceInterfaces = { ISyncBdSrvPriceService.class }, binding = Binding.JSONRPC)
public class SyncBdSrvPriceServiceImpl implements ISyncBdSrvPriceService {

	@Override
	public boolean SyncBdSrvPrice() {
		// ParamsetQryUtil.getParaString(IOrgConst.GLOBEORG, paramCode);

		try {
			MedsrvCrudServiceImpl medsrvCrudServiceImpl = new MedsrvCrudServiceImpl();
			// 查询条件: 非药品 && 启用 && 医嘱 && 费用
			String whereCondition = String.format(" %s not like '01%%' and %s = 'Y' and %s = 'Y' and %s = 'Y'",
					MedSrvDO.SD_SRVTP, MedSrvDO.FG_ACTIVE, MedSrvDO.FG_OR, MedSrvDO.FG_BL);

			MedsrvAggDO[] szMedsrvAggDO = medsrvCrudServiceImpl.find(whereCondition, MedSrvDO.SD_SRVTP, FBoolean.FALSE);

			SyncBdSrvPrice(szMedsrvAggDO);

			// 同步物品
			SyncBdMmPrice(null);

		} catch (BizException e) {
			BdSrvLogUtils.logEx(e);
			return false;
		} catch (Exception e) {
			BdSrvLogUtils.logEx(e);
			return false;
		}

		return true;
	}

	@Override
	public boolean SyncBdSrvPrice(String id_srv) {
		// ParamsetQryUtil.getParaString(IOrgConst.GLOBEORG, paramCode);

		try {
			MedsrvCrudServiceImpl medsrvCrudServiceImpl = new MedsrvCrudServiceImpl();
			// 查询条件: 非药品 && 启用 && 医嘱 && 费用
			String whereCondition = String.format(" %s = %s and %s = 'Y' and %s = 'Y' and %s = 'Y'", MedSrvDO.ID_SRV,
					id_srv, MedSrvDO.FG_ACTIVE, MedSrvDO.FG_OR, MedSrvDO.FG_BL);

			MedsrvAggDO[] szMedsrvAggDO = medsrvCrudServiceImpl.find(whereCondition, MedSrvDO.SD_SRVTP, FBoolean.FALSE);

			if (szMedsrvAggDO != null && szMedsrvAggDO.length == 1) {

				// 同步服务价格
				SyncBdSrvPrice(szMedsrvAggDO);

				FBoolean fg_mm = szMedsrvAggDO[0].getParentDO().getFg_mm();
				if (fg_mm != null && fg_mm.booleanValue()) {
					// 同步物品
					SyncBdMmPrice(szMedsrvAggDO);
				}

			}
		} catch (BizException e) {
			BdSrvLogUtils.logEx(e);
			return false;
		} catch (Exception e) {
			BdSrvLogUtils.logEx(e);
			return false;
		}

		return true;
	}

	private boolean SyncBdSrvPrice(MedsrvAggDO[] szMedsrvAggDO) {

		try {
			MedsrvCrudServiceImpl medsrvCrudServiceImpl = new MedsrvCrudServiceImpl();

			MedsrvAggDO[] szRetMedsrvAggDO = syncSrvOrSetPrice(medsrvCrudServiceImpl, szMedsrvAggDO);

			// 发送事件
			if (szRetMedsrvAggDO != null && szRetMedsrvAggDO.length > 0) {
				List<MedsrvAggDO> sentMedsrvAggDOList = new ArrayList<MedsrvAggDO>();
				for (MedsrvAggDO item : szRetMedsrvAggDO) {
					if (item.getParentDO().getSd_primd().equals(IBdPrimdCodeConst.CODE_PRI_SRV)) {
						sentMedsrvAggDOList.add(item);
					}
				}

				sentUpdateSrvEvent(sentMedsrvAggDOList.toArray(new MedsrvAggDO[sentMedsrvAggDOList.size()]));
			}

		} catch (BizException e) {
			BdSrvLogUtils.logEx(e);
		}

		return true;
	}

	private boolean SyncBdMmPrice(MedsrvAggDO[] szMedsrvAggDO) {
		try {
			MedsrvCrudServiceImpl medsrvCrudServiceImpl = new MedsrvCrudServiceImpl();

			// 同步物品
			if (szMedsrvAggDO == null) {
				String whereCondition = String.format(" %s = 'Y' and %s = 'Y' and %s = 'Y' and %s = 'Y'",
						MedSrvDO.FG_MM, MedSrvDO.FG_ACTIVE, MedSrvDO.FG_OR, MedSrvDO.FG_BL);
				szMedsrvAggDO = medsrvCrudServiceImpl.find(whereCondition, MedSrvDO.ID_SRV, FBoolean.FALSE);
			}
			syncSrvOrMmPrice(medsrvCrudServiceImpl, szMedsrvAggDO);

		} catch (BizException e) {
			BdSrvLogUtils.logEx(e);
		}

		return true;
	}

	/**
	 * 从费用接口获取数据同步 srv 的参考价格
	 * 
	 * @param medsrvCrudServiceImpl
	 * @param szMedsrvAggDO
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private MedsrvAggDO[] syncSrvOrSetPrice(MedsrvCrudServiceImpl medsrvCrudServiceImpl, MedsrvAggDO[] szMedsrvAggDO)
			throws BizException {
		MedsrvAggDO[] szRetMedsrvAggDO = null;
		Map<String, MedsrvAggDO> tmpCache = new HashMap<String, MedsrvAggDO>();

		if (szMedsrvAggDO != null) {
			List<BdSrvPriCalParamDTO> tmpBdSrvPriCalParamDTOList = new ArrayList<BdSrvPriCalParamDTO>();
			for (int index = 0; index < szMedsrvAggDO.length; ++index) {

				MedSrvDO medSrvDO = szMedsrvAggDO[index].getParentDO();

				BdSrvPriCalParamDTO dto = new BdSrvPriCalParamDTO();
				dto.setId_srv(medSrvDO.getId_srv());
				dto.setName_srv(medSrvDO.getName());
				dto.setId_primd(medSrvDO.getId_primd());
				tmpCache.put(medSrvDO.getId_srv(), szMedsrvAggDO[index]);

				if (medSrvDO.getFg_set() != null && medSrvDO.getFg_set().booleanValue()) {
					MedSrvSetItemDO[] szSetItem = szMedsrvAggDO[index].getMedSrvSetItemDO();
					if (null != szSetItem) {
						FArrayList items = new FArrayList();
						dto.setNum(szSetItem.length);
						for (MedSrvSetItemDO item : szSetItem) {
							if (item.getFg_clinical() != null && item.getFg_clinical().booleanValue()) {
								BdSrvPriCalParamDTO bdSrvPriCalParamDTO = new BdSrvPriCalParamDTO();
								bdSrvPriCalParamDTO.setId_srv(item.getId_srv_itm());
								bdSrvPriCalParamDTO.setName_srv(item.getSet_name());

								items.add(bdSrvPriCalParamDTO);
							}
						}
						dto.setSrvsetitms(items);
					}
				}
				tmpBdSrvPriCalParamDTOList.add(dto);
			}

			// 费用接口访问
			PriStdSrvDTO[] results = new BdSelfSrvPricesCalBP().exec((BdSrvPriCalParamDTO[]) tmpBdSrvPriCalParamDTOList
					.toArray(new BdSrvPriCalParamDTO[tmpBdSrvPriCalParamDTOList.size()]));

			if (results != null) {
				List<MedsrvAggDO> updateMedsrvAggDOList = new ArrayList<MedsrvAggDO>();

				for (PriStdSrvDTO item : results) {
					if (tmpCache.containsKey(item.getId_srv())) {
						MedsrvAggDO medsrvAggDO = tmpCache.get(item.getId_srv());
						if (medsrvAggDO.getParentDO() != null
								&& medsrvAggDO.getParentDO().getPri() != item.getPrice()) {
							// idSrvList.add(medsrvAggDO.getParentDO().getId_srv());
							BdSrvLogUtils.info("服务ID:%s,服务名称:%s, 价格:%.2f, 最新价格: %.2f",
									medsrvAggDO.getParentDO().getId_srv(), medsrvAggDO.getParentDO().getName(),
									medsrvAggDO.getParentDO().getPri() == null ? 0
											: medsrvAggDO.getParentDO().getPri().doubleValue(),
									item.getPrice().doubleValue());
							medsrvAggDO.getParentDO().setPri(item.getPrice());
							medsrvAggDO.getParentDO().setStatus(DOStatus.UPDATED);
							updateMedsrvAggDOList.add(medsrvAggDO);
						}

					}

				}
				if (updateMedsrvAggDOList.size() > 0) {
					szRetMedsrvAggDO = medsrvCrudServiceImpl
							.save(updateMedsrvAggDOList.toArray(new MedsrvAggDO[updateMedsrvAggDOList.size()]));
				}

			}

		}

		return szRetMedsrvAggDO;
	}

	/**
	 * 将物品价格同步到srv的参考价格
	 * 
	 * @param medsrvCrudServiceImpl
	 * @param szMedsrvAggDO
	 * @return
	 * @throws BizException
	 */
	private String[] syncSrvOrMmPrice(MedsrvCrudServiceImpl medsrvCrudServiceImpl, MedsrvAggDO[] szMedsrvAggDO)
			throws BizException {
		List<String> idSrvList = new ArrayList<String>();
		if (szMedsrvAggDO != null) {

			GetOutlineSrvRefMmBP bp = new GetOutlineSrvRefMmBP();

			for (int index = 0; index < szMedsrvAggDO.length; ++index) {
				MedSrvDO medSrvDO = szMedsrvAggDO[index].getParentDO();
				// 获取关联物品信息
				MmPriceDTO[] szRefMm = bp.exec(medSrvDO.getId_srv());
				if (null != szRefMm) {
					if (szRefMm.length == 1) {
						medSrvDO.setPri(szRefMm[0].getPrice());
						medSrvDO.setStatus(1);
					} else if (szRefMm.length > 1) {
						medSrvDO.setPri(FDouble.ZERO_DBL);
						medSrvDO.setStatus(1);
					}
					idSrvList.add(medSrvDO.getId_srv());
				}
			}

			medsrvCrudServiceImpl.save(szMedsrvAggDO);
		}

		return idSrvList.toArray(new String[idSrvList.size()]);
	}

	/**
	 * 修改服务时候，将修改后的数据发送给集成平台
	 * 
	 * @param szMedSrvAggDO
	 * @throws BizException
	 */
	private void sentUpdateSrvEvent(MedsrvAggDO[] szMedSrvAggDO) throws BizException {
		// 定义 srv 列表对象
		List<MedSrvEventDTO> medSrvDOList = new ArrayList<MedSrvEventDTO>();
		// 组织 srv 的数据结构
		for (MedsrvAggDO aggDO : szMedSrvAggDO) {
			medSrvDOList.add(getMedSrvDTO(aggDO.getParentDO()));
		}
		// 判空，有效后发送事件
		if (medSrvDOList.size() > 0) {
			BusinessEvent enterDeptEvent = new BusinessEvent(MedSrvDODesc.CLASS_FULLNAME, IEventType.TYPE_UPDATE_AFTER,
					medSrvDOList.toArray(new MedSrvEventDTO[medSrvDOList.size()]));
			EventDispatcher.fireEvent(enterDeptEvent);
		}

	}

	/**
	 * 将医疗服务DO转换为DTO
	 */
	private MedSrvEventDTO getMedSrvDTO(MedSrvDO medSrvDO) {

		MedSrvEventDTO medSrvEventDTO = new MedSrvEventDTO();
		medSrvEventDTO.setId_srv(medSrvDO.getId_srv());
		medSrvEventDTO.setId_grp(medSrvDO.getId_grp());
		medSrvEventDTO.setId_org(medSrvDO.getId_org());
		medSrvEventDTO.setName(medSrvDO.getName());
		medSrvEventDTO.setCode(medSrvDO.getCode());
		medSrvEventDTO.setId_srvtp(medSrvDO.getId_srvtp());
		medSrvEventDTO.setSd_srvtp(medSrvDO.getSd_srvtp());
		medSrvEventDTO.setId_srvca(medSrvDO.getId_srvca());
		medSrvEventDTO.setPycode(medSrvDO.getPycode());
		medSrvEventDTO.setId_unit_med(medSrvDO.getId_unit_med());
		medSrvEventDTO.setQuan_med(medSrvDO.getQuan_med());
		medSrvEventDTO.setId_primd(medSrvDO.getId_primd());
		medSrvEventDTO.setSd_primd(medSrvDO.getSd_primd());
		medSrvEventDTO.setIncca_ip(medSrvDO.getIncca_ip());
		medSrvEventDTO.setIncca_op(medSrvDO.getIncca_op());
		medSrvEventDTO.setPri(medSrvDO.getPri());
		medSrvEventDTO.setFg_active(medSrvDO.getFg_active());
		medSrvEventDTO.setFg_or(medSrvDO.getFg_or());
		medSrvEventDTO.setFg_mm(medSrvDO.getFg_mm());
		medSrvEventDTO.setFg_bl(medSrvDO.getFg_bl());

		return medSrvEventDTO;
	}

	/**
	 * 2017-07-26 09:23:37 by yzh 患者价格维护模块——>手工价格同步按钮——>调用后台价格任务SyncBdSrvPriceTask
	 * 
	 * @param map key:operate 操作来源 01 患者价格分类 02价表维护
	 * @return
	 */
	@Override
	public boolean SyncBdSrvPriceEx(Map<String, Object> map) {
		// FIXME 目前重新处理所有患者价格分类,未传参,以后需要根据不同条件处理时需要传参
		FMap2 variableValueMap = new FMap2();
		// 操作来源 01 为患者价格分类 02为价表维护
		String operate = (String) map.get("operate");
		String id_org = xap.mw.core.data.Context.get().getOrgId();
		String id_grp = xap.mw.core.data.Context.get().getGroupId();
		variableValueMap.put("id_org", id_org);
		variableValueMap.put("id_grp", id_grp);
		// 由哪里调用的任务 pripat 为 从前台患者价格分类 手动价格同步调用
		variableValueMap.put("operate", operate);
		ISchedulerServiceAPI api = ServiceFinder.find(ISchedulerServiceAPI.class);
		api.submitTask0("SyncBdSrvPriceExTask", new FDateTime(new Date(new Date().getTime() + 2000)), variableValueMap);
		return true;
	}

}
