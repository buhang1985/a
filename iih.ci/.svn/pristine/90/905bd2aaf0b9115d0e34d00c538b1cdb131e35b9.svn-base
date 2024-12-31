package iih.ci.ord.s.ems.ip.base;

import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.srvpri.CiOrBdSrvPricesCalByPriModeBP;
import iih.ci.ord.s.ems.defsave.DefaultSetCreateOrderInfo;
import iih.ci.ord.s.ems.defsave.DefaultSingleSrvCreateOrderInfo;
import iih.ci.ord.s.ems.meta.BdSrvMmInfo;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.meta.OrderPackageInfoList;
import iih.ci.ord.s.ems.meta.OrderSrvExtPackage;
import iih.ci.ord.s.ems.meta.OrderSrvMmInfo;
import iih.ci.ord.s.ems.meta.OrderSrvMmList;
import iih.ci.ord.s.ems.meta.SrvKey2UiModelMap;
import iih.ci.ord.s.ems.utils.BdSrvInfoUtils;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

public class BaseIpEmsSetSaveBP extends BaseIpEmsSingleSaveBP {

	/**
	 * 合并用户数据到默认医嘱中
	 * 
	 * @param ctx
	 *            就诊上下文
	 * @param szOrderPakageInfo
	 *            批量医嘱包信息
	 * @return 批量医嘱包信息（合并过信息）
	 * @throws BizException
	 *             业务异常
	 */
	protected OrderPackageInfo[] mergeOrderPakageInfo(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPakageInfo)
			throws BizException {
		for (OrderPackageInfo pInfo : szOrderPakageInfo) {
			// 合并医嘱UI模型数据
			mergeOrderInfo(ctx, pInfo);
			// 服务套内项目保存信息重新创建
			if (pInfo.isSet()) {
				if (pInfo.isNew()) {
					// 新建医嘱时候，删除服务信息
					if (!pInfo.isOrderSrvMmListEmpty())
						pInfo.getOrderSrvMmList().clear();
					if (!pInfo.isOrderSrvSetListEmpty())
						pInfo.getOrderSrvSetList().clear();
				} else {
					// 逻辑删除医嘱服务中的数据
					if (pInfo.getOrderSrvMmList() != null) {
						pInfo.getOrderSrvMmList().logicDelete();
					}
					if (pInfo.getOrderSrvSetList() != null) {
						pInfo.getOrderSrvSetList().logicDelete();
					}
				}
				// 重建套内临床项目
				OrderSrvExtPackage orderSrvExtPackage = null;
				SrvKey2UiModelMap setItemKey2UiModelMap = assembleSrvSetItemKey2UiModelMap(pInfo.getUiModel());
				if (setItemKey2UiModelMap != null && setItemKey2UiModelMap.size() > 0) {
					orderSrvExtPackage = ((DefaultSetCreateOrderInfo) getDefaultCreateOrderInfo())
							.CalcSrvFeesOrdSrvInfo(ctx, pInfo.getOrderInfo(),
									new BdSrvMmInfo(pInfo.getMainBdSrvInfo(), pInfo.getUiModel()),
									setItemKey2UiModelMap == null || setItemKey2UiModelMap.size() == 0 ? null
											: setItemKey2UiModelMap.asKeyArray());
					// 计算套内非临床
					MedSrvSetItemDO[] szMedSrvSetItemDO = BdSrvInfoUtils
							.QueryMedSrvSetItemBy(pInfo.getMainBdSrvInfo().getId_srv(), false);
					// 个数加收、个数定价套内非临床项目费用项计算错误--lxy
					OrderSrvExtPackage orderSrvExtPackage1 = ((DefaultSetCreateOrderInfo) this
							.getDefaultCreateOrderInfo()).CalcSrvFeesOrdSrvInfo(ctx, pInfo.getOrderInfo(),
									new BdSrvMmInfo(pInfo.getMainBdSrvInfo()), szMedSrvSetItemDO);
					if (!CiOrdUtils.isEmpty(orderSrvExtPackage1)) {
						for (OrdSrvDO srvDO : orderSrvExtPackage1.getOrderSrvMmList().asOrderSrvArray()) {
							srvDO.setFg_or(FBoolean.FALSE);// 套内非临床项目fg_or=N
						}
						if (!CiOrdUtils.isEmpty(orderSrvExtPackage)) {
							orderSrvExtPackage.merge(orderSrvExtPackage1);
						}
					}
					// 将新计算出来的服务套内项目附加到医嘱包中
					pInfo.append(orderSrvExtPackage.getOrdSrvSetInfoList());
				} else {
					orderSrvExtPackage = new OrderSrvExtPackage(pInfo.getOrderInfo().getId_srv(), new OrderSrvMmList());
				}
				// 套本身
				OrderSrvMmInfo mainSetSrv = ((DefaultSetCreateOrderInfo) getDefaultCreateOrderInfo()).getMainSetSrv(ctx,
						pInfo.getOrderInfo(), pInfo.getMainBdSrvInfo());
				mainSetSrv.getOrderSrvInfo()
						.setPri(this.getPrice4OrSrvSet(mainSetSrv.getOrderSrvInfo().getId_srv(),
								((OrderListViewDTO) pInfo.getUiModel()).getId_primd(),
								ctx.getId_pripat(), setItemKey2UiModelMap));
				orderSrvExtPackage.getOrderSrvMmList().add(mainSetSrv);

				// 将新计算出来的服务套内项目附加到医嘱包中
				pInfo.append(orderSrvExtPackage.getOrderSrvMmList());
				for (OrderSrvMmInfo srvMmInfo : pInfo.getOrderSrvMmList()) {
					// 处理其他信息
					afterMergeOrderSrvInfo(ctx, pInfo.getOrderInfo(), srvMmInfo.getOrderSrvInfo(), pInfo.getUiModel());
				}
			} else if (pInfo.getMainBdSrvInfo().getId_primd().equals(IBdPrimdCodeConst.ID_PRI_SRV_COMP)) {
				// 组合计价编辑时重新算项目
				if (!pInfo.isNew()) {
					for (OrderSrvMmInfo srvMmInfo : pInfo.getAllOrderSrvMmList()) {
						if (!CiOrdUtils.isTrue(srvMmInfo.getOrderSrvInfo().getFg_or())) {
							srvMmInfo.getOrderSrvInfo().setStatus(DOStatus.DELETED);
						}
					}
					OrderSrvMmList ordSrvMmList = ((DefaultSingleSrvCreateOrderInfo) getDefaultCreateOrderInfo())
							.CreateCompPrimdSrvInfo(ctx, pInfo,
									new BdSrvMmInfo(pInfo.getMainBdSrvInfo(), pInfo.getUiModel()));
					if (ordSrvMmList.size() > 0) {
						for (OrderSrvMmInfo srvMmInfo : ordSrvMmList) {
							srvMmInfo.getOrderSrvInfo().setStatus(DOStatus.NEW);
						}
						pInfo.getOrderSrvMmList().addAll(ordSrvMmList);
					}
				}
				// TODO:非套组合计价服务
				for (OrderSrvMmInfo srvMmInfo : pInfo.getOrderSrvMmList()) {
					mergeOrderSrvInfo(ctx, srvMmInfo.getOrderSrvInfo(), pInfo.getUiModel());
					// 处理其他信息
					afterMergeOrderSrvInfo(ctx, pInfo.getOrderInfo(), srvMmInfo.getOrderSrvInfo(), pInfo.getUiModel());

					if (CiOrdUtils.isTrue(srvMmInfo.getOrderSrvInfo().getFg_mm())) {
						mergeOrderMmInfo(ctx, srvMmInfo.getOrderSrvMmInfo(), pInfo.getUiModel());
					}
				}
			} else {

				for (OrderSrvMmInfo srvMmInfo : pInfo.getOrderSrvMmList()) {
					// 合并服务信息
					mergeOrderSrvInfo(ctx, srvMmInfo.getOrderSrvInfo(), pInfo.getUiModel());
					// 处理其他信息
					afterMergeOrderSrvInfo(ctx, pInfo.getOrderInfo(), srvMmInfo.getOrderSrvInfo(), pInfo.getUiModel());

					if (CiOrdUtils.isTrue(srvMmInfo.getOrderSrvInfo().getFg_mm())) {
						mergeOrderMmInfo(ctx, srvMmInfo.getOrderSrvMmInfo(), pInfo.getUiModel());
					}
				}
			}

			// 合并医嘱服务申请单
			if (!CiOrdUtils.isEmpty(pInfo.getOrderAppSheetList())) {
				mergeOrderAppInfo(ctx, pInfo.getOrderAppSheetList().asArray(), pInfo.getExtInfoList().asArray(),
						pInfo.getUiModel());
				// 合并申请单之后处理
				afterMergeOrderAppInfo(ctx, pInfo.getOrderInfo(), pInfo.getOrderAppSheetList().asArray(),
						pInfo.getExtInfoList().asArray(), pInfo.getUiModel());
			}
			// 处理服务套医嘱医保信息
			// handleOrderHpInfo(ctx, pInfo.getOrderInfo());
			// // 处理医嘱服务医保信息
			// OrderSrvMmList szOrdSrvMmInfo = pInfo.getOrderSrvMmList();
			// handleSrvHpInfo(ctx, szOrdSrvMmInfo);
			// // 处理其他的医保信息
			// OrdSrvDO[] szOrdSrvInfo = pInfo.getOrderSrvList();
			// afterHandleHpInfo(ctx, pInfo.getOrderInfo(), szOrdSrvInfo);
			afterMergeOrderPakageInfo(ctx, pInfo.getOrderInfo(), pInfo.getOrderSrvList(), pInfo.getUiModel());
		}
		return szOrderPakageInfo;
	}

	/**
	 * 将前端选择的临床套内项目转化为服务ID的映射表
	 * 
	 * @param objInfo
	 * @return
	 */
	protected SrvKey2UiModelMap assembleSrvSetItemKey2UiModelMap(Object objInfo) {
		assert false : "服务套项目必须实现该方法：将前台选择的套内项目集合转化为服务ID的映射关系";

		return null;
	}

	/**
	 * 合并套项目信息
	 * 
	 * @param ctx
	 * @param setSrvList
	 * @param uiModel
	 * @throws BizException
	 */
	protected void mergeOrderSetInfo(CiEnContextDTO ctx, OrdSrvSetDO[] setSrvList, Object uiModel) throws BizException {

	}

	@Override
	protected void afterMergeOrderPakageInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, OrdSrvDO[] srvInfos,
			Object uiModel) throws BizException {
		// TODO Auto-generated method stub
		super.afterMergeOrderPakageInfo(ctx, orderInfo, srvInfos, uiModel);
		if (null != uiModel) {
			OrderListViewDTO emsRisViewDTO = (OrderListViewDTO) uiModel;
			orderInfo.setDes_or(emsRisViewDTO.getDes_or());
		}

	}

	@Override
	protected EmsSaveRstInfo handleSaveOrderPackageList(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPackageInfo)
			throws BizException {
		// TODO Auto-generated method stub
		EmsSaveRstInfo emsSavedRstInfo = super.handleSaveOrderPackageList(ctx, szOrderPackageInfo);

		// 保存医嘱服务套内项目信息
		OrderPackageInfoList orderPackageInfoList = new OrderPackageInfoList(szOrderPackageInfo);
		OrdSrvSetDO[] szOrdSrvSetInfo = orderPackageInfoList.asOrderSrvSetArray();
		mergeOrderSetInfo(ctx, szOrdSrvSetInfo, szOrderPackageInfo[0].getUiModel());
		if (!CiOrdUtils.isEmpty(szOrdSrvSetInfo)) {
			emsSavedRstInfo.szOrderSrvSetInfo = CiOrdAppUtils.getOrsrvsetService().save(szOrdSrvSetInfo);
		}
		return emsSavedRstInfo;
	}

	@Override
	protected void afterMergeOrderSrvInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, OrdSrvDO srvInfo, Object uiModel)
			throws BizException {
		super.afterMergeOrderSrvInfo(ctx, orderInfo, srvInfo, uiModel);
		OrderListViewDTO orderlist = (OrderListViewDTO) uiModel;
		srvInfo.setId_dep_mp(orderlist.getId_dep_mp());
		srvInfo.setId_freq(orderlist.getId_freq());
		srvInfo.setFg_selfpay(orderlist.getFg_selfpay());
		srvInfo.setId_route(orderlist.getId_route());
		srvInfo.setId_routedes(orderlist.getId_routedes());
		srvInfo.setDt_last_bl(orderInfo.getDt_last_bl());
	}

	protected FDouble getPrice4OrSrvSet(String id_srv, String id_primd, String id_pripat,
			SrvKey2UiModelMap setItemKey2UiModelMap) throws BizException {
		CiOrBdSrvPricesCalByPriModeBP bp = new CiOrBdSrvPricesCalByPriModeBP();
		BdSrvPriCalParamDTO priParam = new BdSrvPriCalParamDTO();
		priParam.setId_srv(id_srv);
		priParam.setId_primd(id_primd);
		priParam.setNum(0);
		MedSrvPriceDO priceDo = bp.exec(priParam, id_pripat);
		return priceDo.getPrice_ratio();
	}
}
