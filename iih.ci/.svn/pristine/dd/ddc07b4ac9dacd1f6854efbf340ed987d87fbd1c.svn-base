package iih.ci.ord.s.ems.ip.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.fc.i.IBdFcQryService;
//import iih.bd.fc.orwfovalchk.d.OrWfOvalChkOrDTO;
//import iih.bd.fc.orwfovalchk.d.OrWfOvalChkRltDTO;
//import iih.bd.fc.orwfovalchk.d.OrWfOvalChkRltItmDTO;
//import iih.bd.fc.orwfovalchk.d.OrWfOvalChkSrvDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.i.error.YesNoErrorEmsDTO;
import iih.ci.ord.i.external.obtain.ICiOrdBdRService;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import iih.ci.ord.s.ems.meta.StringList;
import iih.ci.ord.s.ems.utils.SysParamUtils;
import iih.mm.itf.material.d.GetStockReqDTO;
import iih.mm.itf.material.d.MaterialStatus;
import iih.mm.itf.material.d.MaterialStockDTO;
import iih.mm.itf.material.i.IMaterialStockService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

public class BaseIpDrugsEmsValidate extends BaseIpEmsValidate {
	
	@Override
	public ErrorEmsList viewModelValidate(Object[] objEms, CiEnContextDTO ctx) throws BizException {
		// 定义医疗单错误信息集合
		ErrorEmsList eeList = super.viewModelValidate(objEms, ctx);

		// 分析药品服务基本信息错误
		ErrorEmsDTO errorInfo = analysisErrorOfSrvInfo(objEms);
		if (null != errorInfo) {
			eeList.add(errorInfo);
		}

		// 分析物品库存信息
		errorInfo = analysisErrorOfMmInfo(objEms);
		if (null != errorInfo) {
			eeList.add(errorInfo);
		}

		// 分析用法错误信息
		errorInfo = analysisErrorOfRouteInfo(objEms);
		if (null != errorInfo) {
			eeList.add(errorInfo);
		}

		// 分析执行流向错误信息
		errorInfo = analysisErrorOfWfDeptInfo(objEms);
		if (null != errorInfo) {
			eeList.add(errorInfo);
		}
		
		return eeList;
	}
	
	protected ErrorEmsDTO analysisErrorOfSrvInfo(Object[] objEms){
		return null;
	}

	/**
	 * 校验物品信息
	 * 
	 * @param objInfos
	 * @return
	 * @throws BizException
	 */
	protected ErrorEmsDTO analysisErrorOfMmInfo(Object[] objInfos) throws BizException {

		IMaterialStockService service = ServiceFinder.find(IMaterialStockService.class);
		Map<String, OrderListViewDTO> drugMap = new HashMap<String, OrderListViewDTO>();

		List<GetStockReqDTO> params = new ArrayList<GetStockReqDTO>();
		for (Object objInfo : objInfos) {
			OrderListViewDTO drug = (OrderListViewDTO) objInfo;
			if(drug.getStatus()==DOStatus.DELETED)
				continue;
			if (null == drug.getSd_nodispense()) {
				GetStockReqDTO param = new GetStockReqDTO();
				param.setId_dep(drug.getId_dep_wh());
				param.setId_mm(drug.getId_mm());
				param.setReq_unit_id(drug.getId_unit_base());
				params.add(param);
				drugMap.put(drug.getId_mm(), drug);
			}
		}
		// 是否校验物品信息
		if (params.size() > 0) {

			MaterialStockDTO[] szRstInfo = service.getMaterialStocks(params.toArray(new GetStockReqDTO[params.size()]));
			if (szRstInfo != null && szRstInfo.length > 0) {
				StringList errorList = new StringList();
				for (MaterialStockDTO mmdto : szRstInfo) {
					if (drugMap.containsKey(mmdto.getId_mm())) {

						if (mmdto.getMmstatus().equals((int) MaterialStatus.NORELATION) && !errorList.contains(drugMap.get(mmdto.getId_mm()).getName_srv())) {
							errorList.add(String.format("【%s】药房无此药！", drugMap.get(mmdto.getId_mm()).getName_srv()));
						} else if (mmdto.getMmstatus().equals((int) MaterialStatus.STOP) && !errorList.contains( drugMap.get(mmdto.getId_mm()).getName_srv())) {
							errorList.add(
									String.format("【%s】已停开！请联系药剂科确认！", drugMap.get(mmdto.getId_mm()).getName_srv()));
						} else if (mmdto.getQuan_stock().compareTo(new FDouble(0)) <= 0  && !errorList.contains( drugMap.get(mmdto.getId_mm()).getName_srv())) {
							errorList.add(String.format("【%s】库存不足！", drugMap.get(mmdto.getId_mm()).getName_srv()));
						}
					}
				}
				if (errorList.size() > 0) {
					OrderListViewDTO srvInfo = (OrderListViewDTO) objInfos[0];
					return new ErrorEmsDTO(srvInfo.getCode_or(), srvInfo.getName_mm(), errorList.toStringWithNO(1));
				}
			}
		}
		return null;
	}

	/**
	 * 医嘱流向校验
	 * 
	 * @param objEms
	 * @param code_entp
	 * @return
	 * @throws BizException
	 */
	protected ErrorEmsDTO analysisErrorOfWfDeptInfo(Object[] objEms) throws BizException {
		
//		if (CiOrdUtils.isEmpty(objEms))
//			return null;
//
//		IBdFcQryService qryService = ServiceFinder.find(IBdFcQryService.class);
//		if (qryService != null) {
//			OrWfOvalChkRltDTO[] szRstInfo = qryService.getOrWfOvalChkRlt(createParam(objEms));
//			if (!CiOrdUtils.isEmpty(szRstInfo)) {
//				StringBuilder sbError = toErrorMessage(szRstInfo, objEms);
//				
//				if (null != sbError && sbError.length() > 0 && null != objEms && objEms.length > 0) {
//					OrderListViewDTO srvInfo = (OrderListViewDTO) objEms[0];
//					return new ErrorEmsDTO(srvInfo.getCode_or(),
//							StringUtils.isEmpty(srvInfo.getName_mm()) ? srvInfo.getName_srv() : srvInfo.getName_mm(),
//							sbError.toString());
//				}
//			}
//
//		}

		
		return null;
	}

//	private OrWfOvalChkOrDTO[] createParam(Object[] objEms) {
//		List<OrWfOvalChkOrDTO> paramList = new ArrayList<OrWfOvalChkOrDTO>();
//
//		OrWfOvalChkOrDTO paramDTO = new OrWfOvalChkOrDTO();
//		FArrayList itemsList = new FArrayList();
//		// 构建医嘱信息结构
//		{
//			OrderListViewDTO ordlistDTO = (OrderListViewDTO) objEms[0];
//			paramDTO.setId_or(ordlistDTO.getCode_or());// 医嘱ID
//			paramDTO.setCode_entp(this.ciEnContextInfo.getCode_entp());// 就诊类型
//			paramDTO.setFg_pres_outp(ordlistDTO.getFg_pres_outp());// 出院带药标识
//			paramDTO.setFg_urgent(ordlistDTO.getFg_urgent());// 加急标识
//		}
//		for (Object obj : objEms) {
//			OrderListViewDTO infoItem = (OrderListViewDTO) obj;
//			if(infoItem.getStatus()==DOStatus.DELETED)
//				continue;
//			OrWfOvalChkSrvDTO itemParam = new OrWfOvalChkSrvDTO();
//			itemParam.setId_or(infoItem.getCode_or());// 医嘱ID
//			itemParam.setFg_or(infoItem.getFg_or());// 临床标识
//			itemParam.setId_dep_mp(infoItem.getId_dep_mp());// 执行科室
//			itemParam.setId_dep_wh(infoItem.getId_dep_wh());// 物资科室
//			itemParam.setId_orsrv(
//					infoItem.getId_srv() + (StringUtils.isEmpty(infoItem.getId_mm()) ? "" : infoItem.getId_mm()));// 医嘱项目ID
//			itemParam.setSd_srvtp(infoItem.getSd_srvtp());// 医嘱项目类型
//			itemParam.setFg_mm(infoItem.getFg_mm());// 物品标志
//			itemParam.setFg_outdeptadmt(new FBoolean("1".equals(infoItem.getSd_nodispense())));// 自备
//			itemsList.add(itemParam);
//
//		}
//		paramDTO.setArraysrv(itemsList);
//		paramList.add(paramDTO);
//		return paramList.toArray(new OrWfOvalChkOrDTO[paramList.size() - 1]);
//	}

//	private StringBuilder toErrorMessage(OrWfOvalChkRltDTO[] rstInfo, Object[] szUiModel) {
//		StringBuilder sbErrorInfo = new StringBuilder();
//		for (OrWfOvalChkRltDTO rtnDTO : rstInfo) {
//			if (!CiOrdUtils.isTrue(rtnDTO.getFg_success())) {
//				for (Object obj : rtnDTO.getArraymsg()) {
//					OrWfOvalChkRltItmDTO itemInfo = (OrWfOvalChkRltItmDTO) obj;
//					OrderListViewDTO srvInfo = findModelByCode(szUiModel, itemInfo.getId_orsrv());
//					if (null != srvInfo) {
//						sbErrorInfo.append(String.format("【%s】%s", srvInfo.getName_srv(), itemInfo.getDes_msg()));
//					}
//				}
//
//			}
//		}
//		return sbErrorInfo;
//	}

	/**
	 * 查找服务UI模型
	 * 
	 * @param szUiModel
	 * @param code
	 * @return
	 */
	private OrderListViewDTO findModelByCode(Object[] szUiModel, String code) {
		for (Object objItem : szUiModel) {
			OrderListViewDTO srvInfo = (OrderListViewDTO) objItem;
			if (code.equals(srvInfo.getId_srv()+(StringUtils.isEmpty(srvInfo.getId_mm())?"":srvInfo.getId_mm()))) {
				return srvInfo;
			}
		}
		return null;
	}

	/**
	 * 用法校验
	 * 
	 * @param objEms
	 * @return
	 * @throws BizException
	 */
	protected ErrorEmsDTO analysisErrorOfRouteInfo(Object[] objEms) throws BizException {

		if (!CiOrdUtils.isEmpty(objEms)) {
			// 将剂型关联用法使用模式分为3种，1控制模式，2提醒模式，3不管理
			// 【住院剂型关联用法管理模式】参数，参数到机构级别，默认值为1控制模式
			String paramDosage = SysParamUtils.getSysParam().getSYS_PARAM_DosageFormAssociationUsageIP().getOrgParam();
			if ("2".equals(paramDosage)) {
				StringList errorList = new StringList();
				for (Object objInfo : objEms) {
					OrderListViewDTO drug = (OrderListViewDTO) objInfo;
					if(drug.getStatus()==DOStatus.DELETED)
						continue;
					String filter_route = ServiceFinder.find(ICiOrdBdRService.class)
							.getIdroutes8Dosage(drug.getSd_srvtp(), new String[] { drug.getId_srv() }, FBoolean.TRUE);
					if (drug.getStatus() != DOStatus.DELETED && (filter_route == null
							|| (drug.getId_route() != null && !filter_route.contains(drug.getId_route())))) {
						errorList.add(String.format("【%s】不能使用【%s】用法;", drug.getName_srv(), drug.getName_route()));
					}
				}
				// 定义医疗单错误信息对象
				if (errorList.size() > 0) {
					OrderListViewDTO srvInfo = (OrderListViewDTO) objEms[0];
					return new YesNoErrorEmsDTO(srvInfo.getCode_or(), srvInfo.getName_mm(),
							errorList.toStringWithNO(1));

				}
			}
		}

		return null;
	}
}
