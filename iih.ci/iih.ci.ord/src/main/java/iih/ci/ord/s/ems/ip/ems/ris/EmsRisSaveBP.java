package iih.ci.ord.s.ems.ip.ems.ris;

import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.dws.ip.ems.d.EmsRisViewDTO;
import iih.ci.ord.dws.ip.ems.d.EmsRisViewItemDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderPrescribeModuleEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.srvpri.CiOrBdSrvPricesCalByPriModeBP;
import iih.ci.ord.s.ems.defsave.DefaultRisCreateOrderInfo;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsSetSaveBP;
import iih.ci.ord.s.ems.itf.IEmsValidate;
import iih.ci.ord.s.ems.meta.ObjectList;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.meta.SrvKey2UiModelMap;
import iih.ci.ord.s.ems.orcontent.CiOrContentUtils;
import iih.ci.ord.s.ems.orcontent.meta.RisOrContentParam;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDouble;

/**
 * 检查医疗单保存逻辑
 * 
 * @author Young
 *
 */
public class EmsRisSaveBP extends BaseIpEmsSetSaveBP {

	public EmsRisSaveBP() {
		super();
		// 设置有效性检查
		setEmsValidate(new EmsRisValidate());
		// 设置医嘱默认生成逻辑
		setDefaultCreateOrderInfo(new DefaultRisCreateOrderInfo());
	}

	public EmsRisSaveBP(IEmsValidate emsValidate) {
		super();
		// 设置有效性检查
		setEmsValidate(emsValidate);
		// 设置医嘱默认生成逻辑
		setDefaultCreateOrderInfo(new DefaultRisCreateOrderInfo());
	}

	@Override
	protected EmsSaveRstInfo handleSaveOrderPackageList(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPackageInfo)
			throws BizException {
		ObjectList appList = new ObjectList();
		EmsSaveRstInfo emsSaveInfo = super.handleSaveOrderPackageList(ctx, szOrderPackageInfo);
		for (OrderPackageInfo opInfo : szOrderPackageInfo) {
			if (!CiOrdUtils.isEmpty(opInfo.getOrderAppSheetList())) {
				Object objAppSheetInfo = opInfo.getOrderAppSheetList().get(0);
				// 检查申请单保存
				if (objAppSheetInfo instanceof OrdApObsDO) {
					appList.add(CiOrdAppUtils.getOrapprisService()
							.save(opInfo.getOrderAppSheetList().toArray(new OrdApObsDO[] {}))[0]);
				}
			}
		}
		emsSaveInfo.szAppInfo = appList.asArray();
		return emsSaveInfo;
	}

	@Override
	protected void mergeOrderAppInfo(CiEnContextDTO ctx, Object[] appSheetList, Object[] extInfoList, Object uiModel)
			throws BizException {
		// TODO 合并申请单信息
		OrderListViewDTO viewDTO = (OrderListViewDTO) uiModel;
		for (Object obj : appSheetList) {
			OrdApObsDO ordris = (OrdApObsDO) obj;
			// ordris.setId_or(srvdto.getId_or());// 医嘱id不需要合并
			ordris.setNo_applyform(viewDTO.getNo_applyform());// 申请单号
			ordris.setDt_plan(viewDTO.getDt_effe());// 计划检查日期
			ordris.setFg_urgent(viewDTO.getFg_urgent());// 加急标识
			ordris.setStatus(viewDTO.getStatus());
			ordris.setClinicalzztz(((EmsRisViewDTO) uiModel).getClinicalzztz());// 临床症状及体征
			if (OrderPrescribeModuleEnum.ORDERAPPFORM.equals(viewDTO.getEu_orderPrescribeModule())) {
				EmsRisViewDTO risViewDto = (EmsRisViewDTO) uiModel;
				// ordris.setAnnouncements();//注意事项
				ordris.setId_pps(risViewDto.getId_pps());// 检查目的
				ordris.setSd_pps(risViewDto.getSd_pps());// 检查目的编码
				ordris.setDes_pps(risViewDto.getName_pps());// 检查目的描述
				ordris.setId_di(risViewDto.getId_di());// 临床诊断
				ordris.setId_diitm(risViewDto.getId_diitm());// 临床诊断子项
				ordris.setName_diag(risViewDto.getName_diitm());// 诊断名称
				// ordris.setStr_id_diitm(srvdto.getStr_id_diitm());//临床诊断明细
				// ordris.setStr_code_di(srvdto.getStr_code_di());//诊断编码拼接
				// ordris.setStr_name_di(srvdto.getStr_name_di());//诊断名称拼接
				// ordris.setDes_sympsign(srvdto.getDes_sympsign());//病情描述

				ordris.setDef1(risViewDto.getDef1());
				ordris.setDef2(risViewDto.getDef2());
				ordris.setDef3(risViewDto.getDef3());
				ordris.setDef4(risViewDto.getDef4());
				ordris.setDef5(risViewDto.getDef5());
				ordris.setDef6(risViewDto.getDef6());
				ordris.setDef7(risViewDto.getDef7());
				ordris.setDef8(risViewDto.getDef8());
				ordris.setDef9(risViewDto.getDef9());
				ordris.setDef10(risViewDto.getDef10());
				ordris.setDef11(risViewDto.getDef11());
				ordris.setDef12(risViewDto.getDef12());
				ordris.setDef13(risViewDto.getDef13());
				ordris.setDef14(risViewDto.getDef14());
				ordris.setDef15(risViewDto.getDef15());
				ordris.setDef16(risViewDto.getDef16());
				ordris.setDef17(risViewDto.getDef17());
				ordris.setDef18(risViewDto.getDef18());
				ordris.setDef19(risViewDto.getDef19());
				ordris.setDef20(risViewDto.getDef20());
				ordris.setDef21(risViewDto.getDef21());
				ordris.setDef22(risViewDto.getDef22());
				ordris.setDef23(risViewDto.getDef23());
				ordris.setDef24(risViewDto.getDef24());
				ordris.setDef25(risViewDto.getDef25());
				ordris.setDef26(risViewDto.getDef26());
				ordris.setDef27(risViewDto.getDef27());
				ordris.setDef28(risViewDto.getDef28());
				ordris.setDef29(risViewDto.getDef29());
				ordris.setDef30(risViewDto.getDef30());
				ordris.setDef31(risViewDto.getDef31());
				ordris.setDef32(risViewDto.getDef32());
				ordris.setDef33(risViewDto.getDef33());
				ordris.setDef34(risViewDto.getDef34());
				ordris.setDef35(risViewDto.getDef35());
				ordris.setDef36(risViewDto.getDef36());
				ordris.setDef37(risViewDto.getDef37());
				ordris.setDef38(risViewDto.getDef38());
				ordris.setDef39(risViewDto.getDef39());
				ordris.setDef40(risViewDto.getDef40());
				ordris.setDef41(risViewDto.getDef41());
				ordris.setDef42(risViewDto.getDef42());
				ordris.setDef43(risViewDto.getDef43());
				ordris.setDef44(risViewDto.getDef44());
				ordris.setDef45(risViewDto.getDef45());
				ordris.setDef46(risViewDto.getDef46());
				ordris.setDef47(risViewDto.getDef47());
				ordris.setDef48(risViewDto.getDef48());
				ordris.setDef49(risViewDto.getDef49());
				ordris.setDef50(risViewDto.getDef50());
			}
		}
	}

	@Override
	protected void mergeOrderSetInfo(CiEnContextDTO ctx, OrdSrvSetDO[] setSrvList, Object uiModel) throws BizException {
		// TODO 合并套内项目信息
		if (!CiOrdUtils.isEmpty(setSrvList)) {
			OrderListViewDTO emsRisViewDTO = (OrderListViewDTO) uiModel;
			FArrayList opList = emsRisViewDTO.getExtInfoList();
			for (OrdSrvSetDO setSrvDo : setSrvList) {
				for (Object object : opList) {
					EmsRisViewItemDTO emsRisViewItemDTO = (EmsRisViewItemDTO) object;
					if (emsRisViewItemDTO.getId_srv().equals(setSrvDo.getId_srvset())) {
						setSrvDo.setId_body(emsRisViewItemDTO.getId_body());
						setSrvDo.setSd_body(emsRisViewItemDTO.getSd_body());
						setSrvDo.setBody_name(emsRisViewItemDTO.getName_body());
					}
				}
			}
		}
	}

	/**
	 * 将前端选择的临床套内项目转化为服务ID的映射表
	 * 
	 * @param objInfo
	 * @return
	 */
	@Override
	protected SrvKey2UiModelMap assembleSrvSetItemKey2UiModelMap(Object objInfo) {
		SrvKey2UiModelMap o = new SrvKey2UiModelMap();
		OrderListViewDTO ems = (OrderListViewDTO) objInfo;
		for (Object obsLapInfo : ems.getExtInfoList()) {
			EmsRisViewItemDTO itemdo = (EmsRisViewItemDTO) obsLapInfo;
			if (itemdo.getStatus() != DOStatus.DELETED && CiOrdUtils.isTrue(itemdo.getFg_check())) {
				o.put(itemdo.getId_srv(), obsLapInfo);
			}
		}
		return o;
	}

	/**
	 * 获取申请 单信息
	 * 
	 * @param szId_or
	 *            医嘱ID集合
	 * @return
	 * @throws BizException
	 */
	protected Object[] qryOrderAppSheetList(String[] szId_or) throws BizException {
		// 检查申请单保存
		OrdApObsDO[] szOrdApObsDO = CiOrdAppUtils.getOrapprisQryService().findByAttrValStrings(CiOrderDO.ID_OR,
				szId_or);
		if (!CiOrdUtils.isEmpty(szOrdApObsDO)) {
			return szOrdApObsDO;
		}
		return null;
	}

	/**
	 * 医嘱内容拼接
	 * 
	 * @param ctx
	 * @param uiModel
	 * @return
	 */
	@Override
	protected CiOrContentDO getOrderContent(CiEnContextDTO ctx, Object uiModel) {
		OrderListViewDTO uiDto = (OrderListViewDTO) uiModel;
		RisOrContentParam param = new RisOrContentParam();
		param.setName_srv(uiDto.getName_srv());
		param.setPri(uiDto.getPri());
		param.setIsmuldose(uiDto.getIsmuldose());
		param.setIsmulexec(uiDto.getIsmulexec());
		param.setSd_srvtp(uiDto.getSd_srvtp());
		param.setQuan_med(uiDto.getQuan_med());
		param.setName_unit_med(uiDto.getName_unit_med());
		param.setName_freq(uiDto.getName_freq());
		param.setDays_or(uiDto.getDays_or());
		param.setFg_urgent(uiDto.getFg_urgent());
		param.setSd_nodispense(uiDto.getSd_nodispense());
		if (!CiOrdUtils.isEmpty(uiDto.getExtInfoList())) {
			StringBuilder bodyname = new StringBuilder();
			for (Object obj : uiDto.getExtInfoList()) {
				EmsRisViewItemDTO itemDto = (EmsRisViewItemDTO) obj;
				if (CiOrdUtils.isTrue(itemDto.getFg_check())) {
					bodyname.append("、" + itemDto.getName_body());
				}
			}
			if (bodyname.length() > 0) {
				param.setStr_body(bodyname.substring(1));
			}
		}
		return CiOrContentUtils.create(param);
	}

	@Override
	protected void afterMergeOrderSrvInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, OrdSrvDO srvInfo,
			Object uiModel) throws BizException {
		OrderListViewDTO uiDto = (OrderListViewDTO) uiModel;
		// 设置不计费类型
		srvInfo.setId_nodispense(uiDto.getId_nodispense());
		srvInfo.setSd_nodispense(uiDto.getSd_nodispense());
		srvInfo.setName_nodispense(uiDto.getName_nodispense());
		
		srvInfo.setId_freq(uiDto.getId_freq());
		srvInfo.setSd_frequnitct(uiDto.getSd_frequnitct());
		srvInfo.setId_route(uiDto.getId_route());
		srvInfo.setDt_create(uiDto.getDt_effe());
		srvInfo.setId_routedes(uiDto.getId_routedes());
		srvInfo.setId_dep_mp(orderInfo.getId_dep_mp());
		srvInfo.setDt_last_bl(orderInfo.getDt_last_bl());
		srvInfo.setQuan_total_medu(null);
	}

	@Override
	protected FDouble getPrice4OrSrvSet(String id_srv, String id_primd, String id_pripat,
			SrvKey2UiModelMap setItemKey2UiModelMap) throws BizException {
		CiOrBdSrvPricesCalByPriModeBP bp = new CiOrBdSrvPricesCalByPriModeBP();
		BdSrvPriCalParamDTO priParam = new BdSrvPriCalParamDTO();
		priParam.setId_srv(id_srv);
		priParam.setId_primd(id_primd);
		priParam.setNum(0);

		if (setItemKey2UiModelMap.size() > 0) {
			priParam.setNum(setItemKey2UiModelMap.size());
			FArrayList itemParams = new FArrayList();
			for (String key : setItemKey2UiModelMap.asKeyArray()) {
				EmsRisViewItemDTO itemdo = (EmsRisViewItemDTO) setItemKey2UiModelMap.get(key);
				BdSrvPriCalParamDTO param = new BdSrvPriCalParamDTO();
				param.setId_srv(itemdo.getId_srv());
				param.setId_primd(itemdo.getId_primd());
				param.setNum(1);
				itemParams.append(param);
			}
			priParam.setSrvsetitms(itemParams);
		}

		MedSrvPriceDO priceDo = bp.exec(priParam, id_pripat);
		return priceDo.getPrice_ratio();
	}
}
