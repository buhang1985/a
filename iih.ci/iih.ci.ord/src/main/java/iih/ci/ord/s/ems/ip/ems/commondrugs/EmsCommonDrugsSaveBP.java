package iih.ci.ord.s.ems.ip.ems.commondrugs;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.d.PharmVerifyStatusEnum;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.IOrdSrvDOCudService;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.dws.ip.ems.d.EmsDrugsViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import iih.ci.ord.s.ems.defsave.DefaultDrugsCreateOrderInfo;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsMedicinesSaveBP;
import iih.ci.ord.s.ems.itf.IEmsValidate;
import iih.ci.ord.s.ems.meta.BdSrvMmInfo;
import iih.ci.ord.s.ems.meta.BdSrvMmInfoList;
import iih.ci.ord.s.ems.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.meta.DefaultCreateParamList;
import iih.ci.ord.s.ems.meta.OrderKey2UiModelMap;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.meta.OrderPackageInfoList;
import iih.ci.ord.s.ems.meta.OrderSrvMmInfo;
import iih.ci.ord.s.ems.meta.OrderSrvMmList;
import iih.ci.ord.s.ems.meta.SrvKey2UiModelMap;
import iih.ci.ord.s.ems.orcontent.CiOrContentUtils;
import iih.ci.ord.s.ems.orcontent.meta.CommonDrugItemOrContentParam;
import iih.ci.ord.s.ems.orcontent.meta.CommonDrugOrContentParam;
import iih.ci.ord.s.ems.utils.OrderEmsQuanUtil;
import iih.ci.ord.s.ems.utils.SysParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存
 * 
 * @author wangqingzhu
 *
 */
public class EmsCommonDrugsSaveBP extends BaseIpEmsMedicinesSaveBP {

	public EmsCommonDrugsSaveBP() {
		this.setEmsValidate(new EmsCommonDrugsValidate());
		this.setDefaultCreateOrderInfo(new DefaultDrugsCreateOrderInfo());
	}

	public EmsCommonDrugsSaveBP(IEmsValidate emsValidate) {
		this.setEmsValidate(emsValidate);
		this.setDefaultCreateOrderInfo(new DefaultDrugsCreateOrderInfo());
	}

	@Override
	protected DefaultCreateParam[] defaultCreateParamFrom(List<Object> listUiModel) throws BizException {
		DefaultCreateParamList listDefaultCreateParam = new DefaultCreateParamList();
		BdSrvMmInfoList bdSrvInfoList = new BdSrvMmInfoList();
		for (Object uiModel : listUiModel) {
			OrderListViewDTO drugInfo = (OrderListViewDTO) uiModel;
			// 基础服务和物品信息列表
			BdSrvMmInfo bsmi = new BdSrvMmInfo(drugInfo);
			if (bsmi.createSrvMmInfo(drugInfo.getId_srv(), drugInfo.getId_mm(), this.getEnContextInfo().getId_org(),
					this.getEnContextInfo().getId_dep_or())) {
				bdSrvInfoList.add(bsmi);
			}
		}
		listDefaultCreateParam.add(new DefaultCreateParam(bdSrvInfoList, listUiModel));
		return listDefaultCreateParam.asArray();
	}

	@Override
	protected OrderKey2UiModelMap assembleOrderKey2UiModelMap(List<Object> listUiModel) {
		if (listUiModel == null || listUiModel.size() == 0)
			return null;
		OrderKey2UiModelMap orderMap = new OrderKey2UiModelMap();
		if (listUiModel.get(0) instanceof OrderListViewDTO) {
			OrderListViewDTO itemDO = (OrderListViewDTO) listUiModel.get(0);
			orderMap.put(itemDO.getId_or(), listUiModel);
		}
		return orderMap;
	}

	@Override
	protected SrvKey2UiModelMap assembleSrvKey2UiModelMap(Object uiModel) {
		if (uiModel == null)
			return null;
		List<Object> uiList = (List<Object>) uiModel;

		SrvKey2UiModelMap srvMap = new SrvKey2UiModelMap();
		for (Object objInfo : uiList) {
			if (objInfo instanceof OrderListViewDTO) {
				OrderListViewDTO itemDO = (OrderListViewDTO) objInfo;
				srvMap.put(itemDO.getId_orsrv(), itemDO);
			}
		}

		return srvMap;
	}

	@Override
	protected OrderSrvMmList createOrderSrvMmList(CiOrderDO orderInfo, Object[] szSrvViewDTO) throws BizException {
		// 在合并过程中有可能存在新增加药品，因此，需要对新增加药品进行创建srvdo和mmdo对象
		OrderSrvMmList ls = new OrderSrvMmList();
		for (Object srvViewInfo : szSrvViewDTO) {
			OrderListViewDTO orderListViewInfo = (OrderListViewDTO) srvViewInfo;
			OrderSrvMmInfo info = getDefaultCreateOrderInfo().createOrderSrvMmInfo(getEnContextInfo(), orderInfo,
					orderListViewInfo.getId_srv(), orderListViewInfo.getId_mm(), (int) OrSrvSourceFromEnum.PHYSIAN);
			info.setUiModel(orderListViewInfo);
			ls.add(info);
		}

		return ls;
	}

	/**
	 * 处理医嘱包的保存
	 * 
	 * @param ctx
	 * @param szOrderPackageInfo
	 * @return
	 * @throws BizException
	 */
	protected EmsSaveRstInfo handleSaveOrderPackageList(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPackageInfo)
			throws BizException {

		EmsSaveRstInfo emsSaveRstInfo = new EmsSaveRstInfo();

		OrderPackageInfoList orderPackageInfoList = new OrderPackageInfoList(szOrderPackageInfo);

		// 保存医嘱服务物品信息
		OrdSrvMmDO[] szOrdSrvMmInfo = orderPackageInfoList.asOrderSrvMmArray();
		if (!CiOrdUtils.isEmpty(szOrdSrvMmInfo)) {
			emsSaveRstInfo.szOrderSrvMmInfo = CiOrdAppUtils.getOrsrvmmService().save(szOrdSrvMmInfo);
		}

		// 保存医嘱服务信息
		OrdSrvDO[] szOrdSrvInfo = orderPackageInfoList.asOrderSrvArray();
		if (!CiOrdUtils.isEmpty(szOrdSrvInfo)) {
			emsSaveRstInfo.szOrderSrvInfo = ServiceFinder.find(IOrdSrvDOCudService.class).save(szOrdSrvInfo);
		}

		// 保存医嘱信息
		CiOrderDO[] szOrderInfo = orderPackageInfoList.asOrderArray();
		this.setOrdSortno(szOrderInfo, ctx.getId_en());// 设置医嘱序号
		if (!CiOrdUtils.isEmpty(szOrderInfo)) {
			emsSaveRstInfo.szOrderInfo = ServiceFinder.find(ICiorderMDOCudService.class).save(szOrderInfo);
		}

		return emsSaveRstInfo;
	}

	@Override
	protected void mergeOrderInfo(CiEnContextDTO ctx, OrderPackageInfo pInfo) throws BizException {
		super.mergeOrderInfo(ctx, pInfo);
		OrderListViewDTO drug = super.getMainOrderListViewDTO8UI(pInfo);
		CiOrderDO orderInfo = pInfo.getOrderInfo();
		// 药品 医嘱列表中的嘱托，为用法要求的自由录入结果
		orderInfo.setDes_or(drug.getDes_or());

		// 长期医嘱不允许加急
		if (CiOrdUtils.isTrue(orderInfo.getFg_long())) {
			orderInfo.setFg_urgent(FBoolean.FALSE);
		}

		// 是否为药品医疗单
		if (drug instanceof EmsDrugsViewDTO) {
			EmsDrugsViewDTO drugItem = (EmsDrugsViewDTO) drug;
			orderInfo.setQuan_firday_mp(drugItem.getQuan_firday_mp());// 首日执行次数
			// orderInfo.setDes_or(drugItem.getDes_or());
			//orderInfo.setFg_deliveryroom_use(drugItem.getFg_deliveryroom_use());// 产房用药
		}
		// 出院带药医嘱
		if (CiOrdUtils.isTrue(drug.getFg_pres_outp()) && CiOrdUtils.isTrue(drug.getFg_long())) {
			if (CiOrdUtils.isTrue(drug.getFg_long())) {
				orderInfo.setDays_or(FDateTime.getDaysBetween(drug.getDt_effe().getDate(), drug.getDt_end().getDate())+1);
			} else {
				orderInfo.setDays_or(1);
			}
		}
		orderInfo.setEu_verify_pharm(PharmVerifyStatusEnum.UNAUDIT);// 药品审核标志
	}

	@Override
	protected boolean canMergeOrderSrvInfo(CiEnContextDTO ctx, OrdSrvDO srvInfo) {
		return OrSrvSourceFromEnum.PHYSIAN.equals(srvInfo.getEu_sourcemd())
				|| OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD.equals(srvInfo.getEu_sourcemd())
				|| OrSrvSourceFromEnum.AGENTFROMPRIMD.equals(srvInfo.getEu_sourcemd());
	}

	/*
	 * 合并医嘱服务项目信息，在此过程中，将非临床项目删除
	 * 
	 * @see
	 * iih.ci.ord.s.ems.ip.base.BaseIpEmsSaveBP#mergeOrderSrvInfo(iih.ci.ord
	 * .ems.d.CiEnContextDTO, iih.ci.ord.ciorder.d.OrdSrvDO, java.lang.Object)
	 */
	@Override
	protected void mergeOrderSrvInfo(CiEnContextDTO ctx, OrdSrvDO srvInfo, Object uiModel) throws BizException {
		OrderListViewDTO drug = (OrderListViewDTO) uiModel;
		boolean isClinicalItem = OrSrvSourceFromEnum.PHYSIAN.equals(srvInfo.getEu_sourcemd())
				|| OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD.equals(srvInfo.getEu_sourcemd())
				|| OrSrvSourceFromEnum.AGENTFROMPRIMD.equals(srvInfo.getEu_sourcemd());
		if (srvInfo.getStatus() != DOStatus.NEW && !isClinicalItem) {
			srvInfo.setStatus(DOStatus.DELETED);
		} else if (drug.getStatus() == DOStatus.DELETED) {
			srvInfo.setStatus(DOStatus.DELETED);
		} else {
			srvInfo.setDt_last_bl(CiOrdAppUtils.getServerDateTime());
			srvInfo.setId_wg_or(ctx.getId_grp());
			srvInfo.setId_pripat(ctx.getId_pripat());

			srvInfo.setId_srv(drug.getId_srv());
			srvInfo.setName_srv(drug.getName_srv());
			srvInfo.setName(drug.getName_srv());
			srvInfo.setId_mm(drug.getId_mm());
			srvInfo.setPri(drug.getPri());
			srvInfo.setPri_std(drug.getPri());
			srvInfo.setPri_ratio(FDouble.ONE_DBL);
			srvInfo.setId_medu(drug.getId_unit_med());
			srvInfo.setQuan_medu(drug.getQuan_med());
			srvInfo.setQuan_total_medu(drug.getQuan_cur());
			srvInfo.setId_route(drug.getId_route());
			srvInfo.setId_routedes(drug.getId_routedes());
			srvInfo.setId_freq(drug.getId_freq());
			srvInfo.setSd_frequnitct(drug.getSd_frequnitct());
			srvInfo.setFreqct(drug.getFreqct());
			srvInfo.setFreq_name(drug.getName_freq());

			srvInfo.setFg_selfpay(drug.getFg_selfpay());
			srvInfo.setFg_selfsrv(drug.getFg_selfsrv());
			srvInfo.setEu_sourcemd(drug.getEu_sourcemd());

			srvInfo.setId_dep_mp(drug.getId_dep_mp());
			srvInfo.setId_dep_wh(drug.getId_dep_wh());
			srvInfo.setFg_skintest(CiOrdUtils.nullHandle(drug.getFg_skintest()));
			// 不计费标志
			srvInfo.setId_nodispense(drug.getId_nodispense());
			srvInfo.setName_nodispense(drug.getName_nodispense());
			srvInfo.setSd_nodispense(drug.getSd_nodispense());
			// 如果不摆药类型为自备药，则设置自备药标志位True
			if ("0".equals(drug.getSd_nodispense())) {
				drug.setFg_self(FBoolean.TRUE);
			}
			// 映射自备药逻辑
			srvInfo.setFg_self(drug.getFg_self());

			// 后配液标志
//			srvInfo.setFg_secadmt(FBoolean.FALSE/* drug.getFg_secadmt() */);

			// 开立病区
			srvInfo.setId_dep_nur_srv(ctx.getId_dep_ns());

			// 服务关联的id_or
			srvInfo.setId_or_rel(drug.getId_or_rel());
			srvInfo.setSd_reltp(drug.getSd_reltp());
			// 支付方式
			srvInfo.setEu_blmd(drug.getEu_blmd());
			srvInfo.setSortno(drug.getSortno_srv());
			//出院带药
			srvInfo.setFg_pres_outp(drug.getFg_pres_outp());
			srvInfo.setStatus(drug.getStatus());

			if (drug instanceof EmsDrugsViewDTO) {
				EmsDrugsViewDTO drugItem = (EmsDrugsViewDTO) drug;
//				srvInfo.setId_antipurpose(drugItem.getId_antipurpose());// 用药目的ID
//				srvInfo.setSd_antipurpose(drugItem.getSd_antipurpose());// 用药目的编码
//				srvInfo.setName_antipurpose(drugItem.getName_antipurpose());// 用药目的
//				srvInfo.setId_prepurpose(drugItem.getId_prepurpose());// 预防用药目的ID
//				srvInfo.setSd_prepurpose(drugItem.getSd_prepurpose());// 预防用药目的编码
//				srvInfo.setName_prepurpose(drugItem.getName_prepurpose());// 预防用药目的
//				srvInfo.setId_preincitp(drugItem.getId_preincitp());// 手术预防用切口等级ID
//				srvInfo.setSd_preincitp(drugItem.getSd_preincitp());// 手术预防用切口等级编码
//				srvInfo.setName_preincitp(drugItem.getName_preincitp());// 手术预防用切口等级
//				srvInfo.setId_predrugreason(drugItem.getId_predrugreason());// 用药原因ID
//				srvInfo.setSd_predrugreason(drugItem.getSd_predrugreason());// 用药原因编码
//				srvInfo.setName_predrugreason(drugItem.getName_predrugreason());// 用药原因
			}
			// 物资流向科室处理：当该服务项目为 不摆药类型非空 时候，物资流向科室信息应该保存为空值。(PIVAS业务逻辑需求)
			if (drug.getSd_nodispense() != null) {
				srvInfo.setId_dep_wh(null);
				srvInfo.setName_dep_wh(null);
			}
		}
	}

	@Override
	protected void mergeOrderMmInfo(CiEnContextDTO ctx, OrdSrvMmDO srvMmInfo, Object uiModel) throws BizException {
		// ArrayList<Object> drugList = (ArrayList<Object>) uiModel;
		OrderListViewDTO drug = (OrderListViewDTO) uiModel;
		if (drug.getStatus() == DOStatus.DELETED) {
			srvMmInfo.setStatus(DOStatus.DELETED);
		} else {


			int[] numben = OrSrvSplitUtil.getNumDen(drug.getQuan_med(), drug.getFactor_mb());
			srvMmInfo.setQuan_num_base(numben[0]);
			srvMmInfo.setQuan_den_base(numben[1]);
			// 出院带药
			if (CiOrdUtils.isTrue(drug.getFg_pres_outp())) {
				int days = 0;
				if (CiOrdUtils.isTrue(drug.getFg_pres_outp())) {
					if (CiOrdUtils.isTrue(drug.getFg_long())) {
						days = FDateTime.getDaysBetween(drug.getDt_effe().getDate(), drug.getDt_end().getDate());
					} else {
						days = 1;
					}
				}
				srvMmInfo.setQuan_cur(OrderEmsQuanUtil.getMMQuan_cur(srvMmInfo.getSd_mupkgutp(), drug.getQuan_med(),
						drug.getFactor_mb(), drug.getFactor_cb(), days * drug.getFreqct()));
			} else {
				srvMmInfo.setQuan_cur(drug.getQuan_cur());// 总量
			}
			srvMmInfo.setId_pgku_cur(drug.getId_unit_cur());// 包装单位
			srvMmInfo.setPrice_pgku_cur(drug.getPri());// 参考价
			srvMmInfo.setFactor(drug.getFactor_cb());
			srvMmInfo.setFactor_mb(drug.getFactor_mb());
			if (drug instanceof EmsDrugsViewDTO) {
				StringBuffer name_mm = new StringBuffer();
				EmsDrugsViewDTO emsdrugsviewdto = (EmsDrugsViewDTO) drug;

				name_mm.append(emsdrugsviewdto.getSpec_mm()).append("【").append(emsdrugsviewdto.getName_srv())
				.append("】");
				srvMmInfo.setName_mm(name_mm.toString());
			}

			srvMmInfo.setQuan_bed_medu(FDouble.ZERO_DBL);
			srvMmInfo.setId_srv(drug.getId_srv());
			srvMmInfo.setStatus(drug.getStatus());
		}
	}

	@Override
	protected void afterMergeOrderPakageInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, OrdSrvDO[] srvInfos,
			Object uiModel) throws BizException {
		// TODO Auto-generated method stub
		super.afterMergeOrderPakageInfo(ctx, orderInfo, srvInfos, uiModel);

		List<OrderListViewDTO> uiList = (List<OrderListViewDTO>) uiModel;

		// CIOR0380 入壶类药品成组开单模式,参数值:0 用法开单,1用法要求开单
		String paramDosage = SysParamUtils.getSysParam().getSYS_PARAM_IntravenousDrugCreateMode().getOrgParam();
		if(ICiOrdNSysParamConst.SYS_PARAM_IntravenousDrugCreateMode_Route.equals(paramDosage) 
				&& !orderInfo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)){
			for (OrdSrvDO srvInfo : srvInfos) {
				if (srvInfo.getId_routedes() != null) {
					srvInfo.setId_routedes(null);
				}
				if (!srvInfo.getId_srv().equals(orderInfo.getId_srv()) &&
						!StringUtils.isEmpty(orderInfo.getId_route()) &&
						!orderInfo.getId_route().equals(srvInfo.getId_route())) {
					srvInfo.setId_routedes(srvInfo.getId_route());// 用法要求ID
					srvInfo.setId_route(orderInfo.getId_route());// 用法ID
					if (srvInfo.getStatus() == DOStatus.UNCHANGED) {
						srvInfo.setStatus(DOStatus.UPDATED);
					}
				}
			}
		}

		FArrayList items = new FArrayList();
		CommonDrugOrContentParam content = new CommonDrugOrContentParam();
		OrderListViewDTO drug = uiList.get(0);
		content.setDays_or(drug.getDays_or());
		// content.setFg_propc(drug.getfg);
		content.setFg_urgent(drug.getFg_urgent());
		content.setIsmuldose(drug.getIsmuldose());
		content.setIsmulexec(drug.getIsmulexec());
		content.setName_freq(drug.getName_freq());
		content.setName_route(drug.getName_route());
		content.setName_srv(drug.getName_srv());
		content.setName_unit_med(drug.getName_unit_med());
		content.setNote(drug.getNote());
		content.setPri(drug.getPri());
		// content.setQuan_med(drug.getQuan_med());
		content.setSd_srvtp(drug.getSd_srvtp());
		content.setTotal_pri(drug.getTotalprice());
		content.setFg_pres_outp(drug.getFg_pres_outp());
		content.setFg_wholepack(drug.getFg_wholepack());
		for (int i = 0; i < uiList.size(); i++) {
			EmsDrugsViewDTO ui = (EmsDrugsViewDTO) uiList.get(i);
			if (DOStatus.DELETED != ui.getStatus()) {
				CommonDrugItemOrContentParam item = new CommonDrugItemOrContentParam();
				item.setId_mm(ui.getId_mm());
				item.setName_mm(ui.getName_mm());
				item.setSpec_mm(ui.getSpec_mm());
				item.setName_srv(ui.getName_srv());
				item.setFg_self(ui.getFg_self());
				item.setFg_selfsrv(ui.getFg_selfsrv());
				item.setQuan_med(ui.getQuan_med());
				item.setName_unit_med(ui.getName_unit_med());
				item.setPri(ui.getPri());
				item.setFg_or(ui.getFg_or());
				item.setQuan_cur(ui.getQuan_cur());
				item.setSd_nodispense(ui.getSd_nodispense());
				// CIOR0380 入壶类药品成组开单模式,参数值:0 用法开单,1用法要求开单
				if (0 != i && ICiOrdNSysParamConst.SYS_PARAM_IntravenousDrugCreateMode_Route.equals(paramDosage)){
					item.setName_routedes(ui.getName_route());
				}
				item.setStatus(ui.getStatus());
				item.setFg_highrisk(ui.getFg_highrisk());
				item.setFg_extdispense(ui.getFg_extdispense());
				item.setId_dep_wh(ui.getId_dep_wh());
				items.add(item);
			}
		}
		content.setItems(items);
		CiOrContentDO ciOrContentDO = CiOrContentUtils.create(content);
		orderInfo.setContent_or(ciOrContentDO.toString());
	}

	@Override
	protected int GetSrvObjStatus(Object objDO) {
		OrderListViewDTO drugItem = (OrderListViewDTO) objDO;
		return drugItem.getStatus();
	}

	@Override
	protected CiOrContentDO getOrderContent(CiEnContextDTO ctx, Object uiModel) {
		return new CiOrContentDO();
	}

}
