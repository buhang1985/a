package iih.ci.ord.s.ems.ip.ems.pathgy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.CiorapppathgyAggDO;
import iih.ci.ord.cior.d.OrdApPathgyDO;
import iih.ci.ord.cior.d.OrdApPathgySampDO;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.dws.ip.ems.d.EmsPathgyItemViewDTO;
import iih.ci.ord.dws.ip.ems.d.EmsPathgyViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderPrescribeModuleEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.defsave.DefaultPathgyCreateOrderInfo;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsSingleSaveBP;
import iih.ci.ord.s.ems.itf.IEmsValidate;
import iih.ci.ord.s.ems.meta.ObjectList;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.orcontent.CiOrContentUtils;
import iih.ci.ord.s.ems.orcontent.meta.PathyOrContentParam;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;

/**
 * 病理医疗单保存逻辑
 * 
 * @author Young
 *
 */
public class EmsPathgySaveBP extends BaseIpEmsSingleSaveBP {

	public EmsPathgySaveBP() {
		super();
		// 设置有效性检查
		setEmsValidate(new EmsPathgyValidate());
		// 设置医嘱默认生成逻辑
		setDefaultCreateOrderInfo(new DefaultPathgyCreateOrderInfo());
	}

	public EmsPathgySaveBP(IEmsValidate emsValidate) {
		super();
		// 设置有效性检查
		setEmsValidate(emsValidate);
		// 设置医嘱默认生成逻辑
		setDefaultCreateOrderInfo(new DefaultPathgyCreateOrderInfo());
	}

	@Override
	protected EmsSaveRstInfo handleSaveOrderPackageList(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPackageInfo)
			throws BizException {

		ObjectList appList = new ObjectList();
		EmsSaveRstInfo emsSaveInfo = super.handleSaveOrderPackageList(ctx, szOrderPackageInfo);
		for (OrderPackageInfo opInfo : szOrderPackageInfo) {
			if (!CiOrdUtils.isEmpty(opInfo.getOrderAppSheetList())) {
				Object objAppSheetInfo = opInfo.getOrderAppSheetList().get(0);
				if (objAppSheetInfo instanceof CiorapppathgyAggDO) {
					appList.add(CiOrdAppUtils.getOrapppathgyService()
							.save(opInfo.getOrderAppSheetList().toArray(new CiorapppathgyAggDO[] {}))[0]);
				}
			}
		}
		emsSaveInfo.szAppInfo = appList.toArray();
		return emsSaveInfo;
	}

	/**
	 * 合并申请单
	 */
	@Override
	protected void mergeOrderAppInfo(CiEnContextDTO ctx, Object[] appSheetList, Object[] extInfoList, Object uiModel)
			throws BizException {
		OrderListViewDTO srvdto = (OrderListViewDTO) uiModel;
		for (Object obj : appSheetList) {
			CiorapppathgyAggDO aggdo = (CiorapppathgyAggDO) obj;
			orderApplySheetFrom(aggdo, srvdto);
		}
	}

	/**
	 * 获取申清单信息
	 * 
	 * @param szId_or
	 *            医嘱ID集合
	 * @return
	 * @throws BizException
	 */
	protected Object[] qryOrderAppSheetList(String[] szId_or) throws BizException {
		CiorapppathgyAggDO[] szCiorapppathgyAggDO = CiOrdAppUtils.getOrapppathgyQryService()
				.findByAttrValStrings("Id_or", szId_or);
		if (!CiOrdUtils.isEmpty(szCiorapppathgyAggDO)) {
			return szCiorapppathgyAggDO;
		}
		return null;
	}

	/**
	 * 病理申请单内容映射
	 * 
	 * @param ordo
	 * @param srvInfo
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	private void orderApplySheetFrom(CiorapppathgyAggDO aggDO, OrderListViewDTO viewDTO) throws BizException {
		if (aggDO == null)
			return;
		OrdApPathgyDO pathgyDO = aggDO.getParentDO();
		// pathgyDO.setId_or(srvInfo.getId_or());
		pathgyDO.setNo_applyform(viewDTO.getNo_applyform());
		pathgyDO.setId_samptp(viewDTO.getId_extend());
		pathgyDO.setSd_samptp(viewDTO.getSd_extend());
		// pathgyDO.setQuan(srvInfo.getQuan_med());
		pathgyDO.setFg_urgent(viewDTO.getFg_urgent());
		pathgyDO.setId_dep(viewDTO.getId_dep_mp());
		pathgyDO.setName_dep(viewDTO.getName_dep_mp());
		pathgyDO.setId_su_pathgy(ICiDictCodeConst.ID_SU_PATHGY_YSQ);
		pathgyDO.setSd_su_pathgy(ICiDictCodeConst.SD_SU_PATHGY_YSQ);
		pathgyDO.setName_su("已申请");
		pathgyDO.setNo_pathgy(viewDTO.getNo_applyform());
		// pathgyDO.setDt_rptpathgy();
		pathgyDO.setStatus(viewDTO.getStatus());
		if (OrderPrescribeModuleEnum.ORDERAPPFORM.equals(viewDTO.getEu_orderPrescribeModule())) {
			EmsPathgyViewDTO pathyDto = (EmsPathgyViewDTO) viewDTO;
			pathgyDO.setId_samptp(pathyDto.getId_samptp());
			pathgyDO.setSd_samptp(pathyDto.getSd_samptp());
			pathgyDO.setName_samptp(pathyDto.getName_samptp());
			// pathgyDO.setId_colltp(pathyDto.getid);
			// pathgyDO.setSd_colltp(pathyDto.getSd_samptp());
			// pathgyDO.setName_cooltp(pathyDto.getName_samptp());
			// pathgyDO.setDes_labsamp(pathyDto.getName_samptp());
			pathgyDO.setId_di(pathyDto.getId_di());
			pathgyDO.setId_diitm(pathyDto.getId_diitm());
			pathgyDO.setName_diag(pathyDto.getName_diitm());
			// pathgyDO.setStr_code_di(srvInfo.getStr_code_di());
			// pathgyDO.setStr_name_di(srvInfo.getStr_name_di());
			// pathgyDO.setStr_id_diitm(srvInfo.getStr_id_diitm());
			pathgyDO.setAnnouncements(pathyDto.getAnnouncements());
			pathgyDO.setDes_sympsign(pathyDto.getDes_sympsign());
			pathgyDO.setFg_outer(pathyDto.getFg_outer());
			pathgyDO.setNo_pathgy_old(pathyDto.getNo_pathgy_old());
			pathgyDO.setDt_pathgy_old(pathyDto.getDt_pathgy_old());
			pathgyDO.setDi_pathgy_old(pathyDto.getDi_pathgy_old());
			pathgyDO.setOrg_pathgy_old(pathyDto.getOrg_pathgy_old());
			pathgyDO.setCollectdes(pathyDto.getCollectdes());
			pathgyDO.setId_emp(pathyDto.getId_emp());
			pathgyDO.setName_coll_emp(pathyDto.getName_emp());
			pathgyDO.setDt_coll(pathyDto.getDt_coll());
		}

		OrdApPathgySampDO[] sampDOs = aggDO.getOrdApPathgySampDO();
		Map<String, OrdApPathgySampDO> mapSampDOs = new HashMap<String, OrdApPathgySampDO>();
		if (sampDOs != null && sampDOs.length > 0) {
			for (OrdApPathgySampDO sampDO : sampDOs) {
				mapSampDOs.put(sampDO.getId_appathgysamp(), sampDO);
			}
		}

		FArrayList pathgySamList = viewDTO.getExtInfoList();
		if (pathgySamList != null) {
			List<OrdApPathgySampDO> lstSampDOs = new ArrayList<OrdApPathgySampDO>();
			for (int i = 0; i < pathgySamList.size(); i++) {
				EmsPathgyItemViewDTO emsItem = (EmsPathgyItemViewDTO) pathgySamList.get(i);
				OrdApPathgySampDO pathgySampDO = mapSampDOs.containsKey(emsItem.getId_appathgysamp())
						? mapSampDOs.get(emsItem.getId_appathgysamp()) : new OrdApPathgySampDO();
				if (pathgyDO.getId_appathgy() != null && pathgySampDO.getId_appathgy() == null) {
					pathgySampDO.setId_appathgy(pathgyDO.getId_appathgy());
				}
				pathgySampDO.setName_labsamp(emsItem.getName_labsamp());
				pathgySampDO.setId_body_coll(emsItem.getId_body_coll());
				pathgySampDO.setSd_body_coll(emsItem.getSd_body_coll());
				pathgySampDO.setBody_coll(emsItem.getName_body_coll());
				pathgySampDO.setQuan_coll(emsItem.getQuan_coll());
				pathgySampDO.setId_fixative(emsItem.getId_fixative());
				pathgySampDO.setSd_fixative(emsItem.getSd_fixative());
				pathgySampDO.setFixative(emsItem.getName_fixative());
				// pathgySampDO.setId_su_labsamp();
				// pathgySampDO.setSd_su_labsamp();
				// pathgySampDO.setId_dep_sign();
				// pathgySampDO.setId_emp_sign();
				// pathgySampDO.setDt_sign();
				pathgySampDO.setSortno(emsItem.getSortno());
				pathgySampDO.setStatus(pathgySampDO.getId_appathgysamp() == null ? DOStatus.NEW : emsItem.getStatus());
				lstSampDOs.add(pathgySampDO);
			}
			aggDO.setOrdApPathgySampDO(lstSampDOs.toArray(new OrdApPathgySampDO[lstSampDOs.size()]));
		}
	}

	@Override
	protected CiOrContentDO getOrderContent(CiEnContextDTO ctx, Object uiModel) {
		OrderListViewDTO uidto = (OrderListViewDTO) uiModel;
		PathyOrContentParam param = new PathyOrContentParam();
		param.setSd_srvtp(uidto.getSd_srvtp());
		param.setName_srv(uidto.getName_srv());
		param.setFg_urgent(uidto.getFg_urgent());
		param.setPri(uidto.getPri());
		param.setSd_nodispense(uidto.getSd_nodispense());
		return CiOrContentUtils.create(param);
	}
}
