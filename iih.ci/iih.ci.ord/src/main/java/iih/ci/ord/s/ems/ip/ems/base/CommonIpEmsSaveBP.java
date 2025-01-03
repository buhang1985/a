package iih.ci.ord.s.ems.ip.ems.base;

import java.util.List;

import iih.bd.base.define.StringObjectMap;
import iih.bd.bc.udi.pub.IBdSrvTpDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvBlModeEnum;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderPrescribeModuleEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.i.meta.MiVerifyParamDTO;
import iih.ci.ord.i.meta.MiVerifyRstDTO;
import iih.ci.ord.i.mi.ICiMiMainService;
import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.ordsrvdose.i.IOrdsrvdoseRService;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.ordsrvset.i.IOrdsrvsetRService;
import iih.ci.ord.params.CiParams;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.bp.quantum.times.QuanFirstDayMpBP;
import iih.ci.ord.s.ems.define.ICiDoctorStationTypeConst;
import iih.ci.ord.s.ems.ip.base.BaseIpEmsSaveBP;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.ems.meta.BdSrvMmInfo;
import iih.ci.ord.s.ems.meta.BdSrvMmInfoList;
import iih.ci.ord.s.ems.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.meta.DefaultCreateParamList;
import iih.ci.ord.s.ems.meta.ErrorEmsList;
import iih.ci.ord.s.ems.meta.ObjectList;
import iih.ci.ord.s.ems.meta.OrderKey2UiModelMap;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.meta.OrderPackageInfoList;
import iih.ci.ord.s.ems.meta.OrderSrvDoseList;
import iih.ci.ord.s.ems.meta.OrderSrvSetList;
import iih.ci.ord.s.ems.meta.SrvKey2UiModelMap;
import iih.ci.ord.s.ems.stackpoint.IStackPointAction;
import iih.ci.ord.s.ems.stackpoint.StackPointOfHpIndicAction;
import iih.ci.ord.s.ems.stackpoint.StackPointOfHpVerifyAction;
import iih.ci.ord.s.ems.utils.OrderUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 通用模式医疗单保存基类
 * 
 * @author wangqingzhu
 *
 */
public class CommonIpEmsSaveBP extends BaseIpEmsSaveBP {

	@Override
	public EmsRstDTO[] save(CiEnContextDTO ctx, EmsSaveDTO[] szEms) throws BizException {

		EmsRstDTO rst = new EmsRstDTO();
		// 1. 获取就诊上下文
		EmsSaveDTO ems = szEms[0];
		this.setEnContextInfo(ctx);

		// 将FArrayList 对象转化为标准Jave类对象
		ObjectList emsList = new ObjectList();
		emsList.addAll(ems.getDocument());

		// TODO:先判断医嘱版本信息（时间戳sv)
		ErrorEmsList errorList = orSvValidate(ctx, ems);
		if (!CiOrdUtils.isEmpty(errorList)) {
			rst.setErrorEmsList(errorList.asFArrayList());
			return new EmsRstDTO[] { rst };
		}

		// 需要保存的医嘱包对象数组
		OrderPackageInfo[] szOrderPakageInfo = null;

		// 2. 获取医疗单文档信息
		if (hasStackPoint(emsList)) {
			EmsRstDTO rstInfo = new EmsRstDTO();
			szOrderPakageInfo = toStackPointSave(ctx, emsList, rstInfo);
			if (null == szOrderPakageInfo) {
				return new EmsRstDTO[] { rstInfo };
			}
		} else {
			EmsRstDTO rstInfo = new EmsRstDTO();
			FMap2 extension = ems.getExtension();
			szOrderPakageInfo = toNormalSave(ctx, emsList, extension, rstInfo);
			if (null == szOrderPakageInfo) {
				return new EmsRstDTO[] { rstInfo };
			}
		}
		// 7.临床路径医生审核标志判断并赋值
		handleHpAppOrDoctorCheckInfo(ctx, szOrderPakageInfo);
		// 8. 医保默认值
		szOrderPakageInfo = handleOrdDefaultHpInfo(ctx, szOrderPakageInfo);
		// 9. 批量执行
		EmsSaveRstInfo emsSaveRstInfo = handleSaveOrderPackageList(ctx, szOrderPakageInfo);
		OrdBizLogger.info(ctx, "[SaveBP]保存数据库通过");
        
		// 10. 返回值处理
		return handleEmsRstInfos(ctx, emsSaveRstInfo, rst);
	}

	/**
	 * 执行断点保存逻辑
	 * 
	 * @param ctx
	 * @param emsList
	 * @param rstInfo
	 * @return
	 */
	protected OrderPackageInfo[] toStackPointSave(CiEnContextDTO ctx, ObjectList emsList, EmsRstDTO rstInfo)
			throws BizException {
		OrderPackageInfoList orderPackageInfoList = new OrderPackageInfoList();

		IStackPointAction iAction = (IStackPointAction) emsList.get(0);

		// i.断点上下文出栈
		OrderPackageInfo pInfo = popStack(ctx, iAction.getCacheKey());
		if (iAction instanceof StackPointOfHpIndicAction && iAction.OnCallBackAction(ctx, pInfo)) {
			// 5.2医保细则校验
			ICiMiMainService hpMainService = ServiceFinder.find(ICiMiMainService.class);
			if (null != hpMainService) {
				MiVerifyParamDTO param = new MiVerifyParamDTO();
				MiVerifyRstDTO verifyRstInfo = hpMainService.verifyMiRule(ctx, param);
				if (null != verifyRstInfo && FBoolean.FALSE.equals(verifyRstInfo.getSuccess())) {
					// 医保细则校验失败
					pushStack(ctx, pInfo.getOrderKey(), pInfo);
					StackPointOfHpVerifyAction nextAction = new StackPointOfHpVerifyAction();
					nextAction.setCacheKey(pInfo.getOrderKey());
					// TODO: 设置细则校验结果数据
					nextAction.setDocument(new FArrayList());

					rstInfo.setErrorEmsList(new FArrayList());
					rstInfo.getErrorEmsList().add(new ErrorEmsDTO(nextAction));
					return null;
				}
			}

		} else if (iAction instanceof StackPointOfHpVerifyAction && iAction.OnCallBackAction(ctx, pInfo)) {
			// 医保细则校验前端处理完毕后，此处是否有处理
		}

		// 将处理完毕的医嘱包对象，添加到医嘱包列表中
		orderPackageInfoList.add(pInfo);

		// 数据库保存
		return orderPackageInfoList.asArray();
	}

	/**
	 * 正常保存逻辑
	 * 
	 * @param ctx
	 * @param emsList
	 * @param extension
	 * @param rstInfo
	 * @return
	 * @throws BizException
	 */
	protected OrderPackageInfo[] toNormalSave(CiEnContextDTO ctx, ObjectList emsList, FMap2 extension,
			EmsRstDTO rstInfo) throws BizException {

		boolean isAssiDataSaving = !OrderPrescribeModuleEnum.ORDERLIST
				.equals(((OrderListViewDTO) emsList.get(0)).getEu_orderPrescribeModule())
				&& !OrderPrescribeModuleEnum.ORDERAPPFORM
				.equals(((OrderListViewDTO) emsList.get(0)).getEu_orderPrescribeModule());
		ErrorEmsDTO[] errorDTOs = null;
		if (extension == null || !extension.containsKey("ErrorChecked")) {
			// 3. 有效性批量验证
			if (!verifyEmsInfo(ctx, emsList.toArray(), rstInfo)) {
				return null;
//				if (!isAssiDataSaving) {
//					// 设置错误信息数据
//					// rstInfo.setErrorEmsList(errorEmsList.asFArrayList());
//					return null;
//				}else{
//					if(rstInfo.getErrorEmsList()!=null && rstInfo.getErrorEmsList().size()>0)
//						errorDTOs=(ErrorEmsDTO[])rstInfo.getErrorEmsList().toArray(new ErrorEmsDTO[]{});
//
//				}

			}

		}

		// 4. 默认值批量处理
		handleOrderPackageInfoDefaultValue(ctx, emsList);

		// 5. 批量构建
		OrderPackageInfo[] szOrderPakageInfo = handleOrderAggInfoList(ctx, emsList);

		// 6. 完整性批量验证
		// ErrorEmsList errorList =
		// getEmsValidate().beforeSaveValidate(szOrderPakageInfo);
		// if (!CiOrdUtils.isEmpty(errorList)) {
		// errorEmsList.addAll(errorList);
		// if (!isAssiDataSaving) {
		// // 设置错误信息数据
		// rstInfo.setErrorEmsList(errorEmsList.asFArrayList());
		// return null;
		// }
		// }

		// 如果存在错误，将错误信息记录到医嘱对象中
		if (errorDTOs!=null && isAssiDataSaving) {
			handleOrderErrorInfo(szOrderPakageInfo[0], errorDTOs);
		} else {
			handleOrderErrorInfo(szOrderPakageInfo[0], null);
		}

		return szOrderPakageInfo;
	}

	/**
	 * 处理医嘱中的错误信息
	 * 
	 * @param pkgInfo
	 * @param errorEmsList
	 */
	protected void handleOrderErrorInfo(OrderPackageInfo pkgInfo, ErrorEmsDTO[] errorDTOs) {
		if (null != errorDTOs) {
			String error_des = "";
			for (ErrorEmsDTO errorDTO : errorDTOs) {
				error_des += errorDTO.getError_message();
			}
			pkgInfo.getOrderInfo().setError_level(errorDTOs[0].getError_level());
			pkgInfo.getOrderInfo().setError_des(error_des);
		} else {
			pkgInfo.getOrderInfo().setError_level(null);
			pkgInfo.getOrderInfo().setError_des(null);
		}
	}

	/**
	 * 处理医嘱更新逻辑
	 * 
	 * @param ctx
	 *            就诊上下文
	 * @param listUiModel
	 *            医疗单模型列表
	 * @return
	 * @throws BizException
	 */
	@Override
	protected OrderPackageInfo[] handleUpdateOrderInfo(CiEnContextDTO ctx, List<Object> listUiModel)
			throws BizException {
		// 有效性检查
		if (listUiModel == null || listUiModel.size() <= 0)
			return null;

		// 获取Id_or 与 ViewDTO对象的映射关系表
		OrderKey2UiModelMap orderKey2UiModelMap = assembleOrderKey2UiModelMap(listUiModel);

		// 更具Id_or与ViewDTO对象的映射关系表，创建OrderPackageInfo医嘱包数组（单医嘱保存只有一个医嘱包）
		OrderPackageInfo[] szOrderPackageInfo = orderPakageInfoArrayFrom(orderKey2UiModelMap);

		// 根据上下文对象合并医嘱包信息
		return mergeOrderPakageInfo(ctx, szOrderPackageInfo);
	}

	/**
	 * 获取服务对象的状态
	 * 
	 * @param objDO
	 * @return
	 */
	@Override
	protected int GetSrvObjStatus(Object objDO) {
		return ((OrderListViewDTO) objDO).getStatus();
	}

	/**
	 * 将医疗单UI模型列表转化为默认创建医疗单参数数组
	 * 
	 * @param listUiModel
	 * @return
	 */
	@Override
	protected DefaultCreateParam[] defaultCreateParamFrom(List<Object> listUiModel) throws BizException {
		DefaultCreateParamList listDefaultCreateParam = new DefaultCreateParamList();
		StringObjectMap som = new StringObjectMap();
		for (Object uiModel : listUiModel) {
			OrderListViewDTO doInfo = (OrderListViewDTO) uiModel;
			som.put(doInfo.getId_srv(), uiModel);
		}
		MedSrvDO[] szMedSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findByIds(som.asKeyArray(),
				FBoolean.FALSE);
		assert !CiOrdUtils.isEmpty(szMedSrvInfo) : "获取医疗单基础服务数据失败";
		for (MedSrvDO srvInfo : szMedSrvInfo) {
			BdSrvMmInfoList bdSrvMmInfoList = new BdSrvMmInfoList();
			bdSrvMmInfoList.add(new BdSrvMmInfo(srvInfo, som.get(srvInfo.getId_srv())));
			listDefaultCreateParam.add(new DefaultCreateParam(bdSrvMmInfoList, som.get(srvInfo.getId_srv())));
		}
		return listDefaultCreateParam.asArray();
	}

	/**
	 * 批量解析医嘱ID
	 * 
	 * @param listUiModel
	 * @return
	 */

	protected OrderKey2UiModelMap assembleOrderKey2UiModelMap(List<Object> listUiModel) {
		OrderKey2UiModelMap oiumm = new OrderKey2UiModelMap();
		for (int index = 0; index < listUiModel.size(); ++index) {
			OrderListViewDTO itemDO = (OrderListViewDTO) listUiModel.get(index);
			oiumm.put(itemDO.getId_or(), itemDO);
		}
		return oiumm;
	}

	/**
	 * 解析服务的UI模型对象，生成Id_srv->ViewDTO的映射表
	 * 
	 * @param uiModel
	 * @return
	 */

	protected SrvKey2UiModelMap assembleSrvKey2UiModelMap(Object uiModel) {
		SrvKey2UiModelMap o = new SrvKey2UiModelMap();
		OrderListViewDTO doInfo = (OrderListViewDTO) uiModel;
		o.put(doInfo.getId_orsrv(), doInfo);
		return o;
	}

	/**
	 * 根据医嘱和UI模型的映射关系表(id_or->viewdto)，获取医嘱包信息数组
	 * 
	 * @param szId_or
	 *            医嘱ID数组
	 * @return 医嘱包信息数组
	 * @throws BizException
	 */
	protected OrderPackageInfo[] orderPakageInfoArrayFrom(OrderKey2UiModelMap oium) throws BizException {
		OrderPackageInfoList orderPakageInfoList = new OrderPackageInfoList();
		// 获取医嘱服务聚集信息
		CiorderAggDO[] szCiorderAggInfo = CiOrdAppUtils.getOrAggQryService().findByBIds(oium.asKeyArray(),
				FBoolean.FALSE);

		// 查询套内项目信息
		for (CiorderAggDO orderAggInfo : szCiorderAggInfo) {
			// 获取医嘱信息
			CiOrderDO orderInfo = orderAggInfo.getParentDO();

			// 获取服务项目数组
			OrdSrvDO[] szOrdSrvDO = orderAggInfo.getOrdSrvDO();

			// 查询套内项目数组
			OrdSrvSetDO[] szOrdSrvSetDO = ServiceFinder.find(IOrdsrvsetRService.class)
					.findByAttrValStrings(OrdSrvSetDO.ID_OR, new String[] { orderInfo.getId_or() });

			// 查询物品项目数组
			OrdSrvMmDO[] szOrdSrvMmDO = ServiceFinder.find(IOrdsrvmmRService.class).findByAttrValStrings(
					OrdSrvMmDO.ID_ORSRV, OrderUtils.ModelAttrValues(szOrdSrvDO, OrdSrvMmDO.ID_ORSRV));

			// 查询变动用药信息数组
			OrdSrvDoseDO[] szOrdSrvDoseDO = ServiceFinder.find(IOrdsrvdoseRService.class).findByAttrValStrings(
					OrdSrvMmDO.ID_ORSRV, OrderUtils.ModelAttrValues(szOrdSrvDO, OrdSrvMmDO.ID_ORSRV));

			// 查询申请单信息
			Object[] szOrderAppSheetList = qryOrderAppSheetList(new String[] { orderInfo.getId_or() });

			// 获取服务项目的主键和UI模型的映射(Id_srv->ViewDTO)对象映射集合
			SrvKey2UiModelMap srvKeyUiModelCache = assembleSrvKey2UiModelMap(oium.get(orderInfo.getId_or()));

			// ## 组装医嘱服务包
			// ---------------------------------------------------------------------
			// 创建医嘱包对象
			OrderPackageInfo opi = new OrderPackageInfo();

			// 设置医嘱包对象状态：更新
			opi.setStatus(DOStatus.UPDATED);

			// 填充医嘱OrderDO对象
			opi.setOrderInfo(orderAggInfo.getParentDO());

			// 医嘱中，服务物品信息聚合结构
			orderSrvMmListFrom(opi, srvKeyUiModelCache, orderAggInfo.getParentDO(), szOrdSrvDO, szOrdSrvMmDO);

			// --------------------------------------------------------------------------

			// 设置基础服务信息
			opi.setBdSrvList(bdSrvInfoListFrom(orderInfo, opi.getOrderSrvMmList()));

			// 填充套内项目信息集合
			if (!CiOrdUtils.isEmpty(szOrdSrvSetDO)) {
				opi.setOrderSrvSetList(new OrderSrvSetList(szOrdSrvSetDO));
			}
			// 填充变动用药信息集合
			if (!CiOrdUtils.isEmpty(szOrdSrvDoseDO)) {
				opi.setOrderSrvDoseList(new OrderSrvDoseList(szOrdSrvDoseDO));
			}

			// 填充申请单信息集合
			if (!CiOrdUtils.isEmpty(szOrderAppSheetList)) {
				opi.setOrderAppSheetList(new ObjectList(szOrderAppSheetList));
			}

			// 将医疗单的Ui对象存放到医嘱包对象中
			opi.setUiModel(oium.get(orderInfo.getId_or()));

			// 将新生成的医嘱包对象，追加到医嘱包列表对象中
			orderPakageInfoList.add(opi);
		}

		return orderPakageInfoList.asArray();
	}

	/**
	 * 将UI模型数据合并到医嘱信息中
	 * 
	 * @param ctx
	 * @param orderInfo
	 * @param uiModel
	 * @throws BizException
	 */
	protected void mergeOrderInfo(CiEnContextDTO ctx, OrderPackageInfo pInfo) throws BizException {
		OrderListViewDTO orderlist = this.getMainOrderListViewDTO8UI(pInfo);
		CiOrderDO orderInfo = pInfo.getOrderInfo();
		orderInfo.setDt_effe(orderlist.getDt_effe());
		// orderInfo.setId_or(orderlist.getId_or());//医嘱ID
		orderInfo.setCode_or(orderlist.getCode_or());// 医嘱编码
		//在国际医院版本中，会诊医嘱内容拼接，只拼接医嘱名称。
		if (IBdSrvTpDictCodeConst.SD_SRVTP_DIAGTREAT_CONSULT_ID.equals(orderlist.getId_srvtp())){
			orderInfo.setContent_or(orderlist.getName_srv());
		} else {
			orderInfo.setContent_or(this.getOrderContent(ctx, orderlist).toString());
		}
		// orderInfo.setId_orsrv("");//医嘱服务ID，创建不赋值
		// orderInfo.setId_srvtp(medSrv.getId_srvtp());//服务类型ID
		// orderInfo.setSd_srvtp(medSrv.getSd_srvtp());//服务类型编码
		// orderInfo.setName_srvtp(medSrv.getSrvtp_name());//服务类型
		// orderInfo.setId_srv(medSrv.getId_srv());//服务ID
		orderInfo.setId_srv(orderlist.getId_srv());
		if (CiOrdUtils.isTrue(orderlist.getFg_selfsrv())) {
			orderInfo.setName_or(orderlist.getName_srv());// 服务编码
		}

		// orderInfo.setExtend(Extend);//辅助说明，医疗单赋值
		orderInfo.setQuan_medu(orderlist.getQuan_med());// 剂量
		orderInfo.setId_unit_med(orderlist.getId_unit_med());// 剂量单位ID
		// orderInfo.setName_unit_med(orderlist.getMed_name());//剂量单位
		orderInfo.setId_freq(orderlist.getId_freq());// 频次ID
		orderInfo.setFreq_name(orderlist.getName_freq());
		orderInfo.setFreqct(orderlist.getFreqct());// 频次数量
		orderInfo.setSd_frequnitct(orderlist.getSd_frequnitct());// 频次周期类型编码
		orderInfo.setId_route(orderlist.getId_route());// 用法ID
		orderInfo.setRoute_name(orderlist.getName_route());// 用法
		// orderInfo.setFilter_route(Filter_route);//用法过滤条件，关联剂型，药品
		orderInfo.setId_routedes(orderlist.getId_routedes());// 用法要求ID
		// orderInfo.setName_routedes(orderlist.getRoutedes_name());//用法要求
		orderInfo.setDt_entry(CiOrdAppUtils.getServerDateTime());// 开立时间
		orderInfo.setDt_invalid(OrderUtils.getDtInvalid(ctx, orderInfo.getDt_entry()));
		orderInfo.setId_emp_or(ctx.getId_emp_or());// 开立医生ID
		// orderInfo.setName_emp_or(ctx.getName_emp_or());//开立医生
		if (!CiOrdUtils.isTrue(orderlist.getFg_long())) {
			orderInfo.setDt_end(orderlist.getDt_effe());// 停止时间
		} else {
			// 新增时，dt_end为空，DO会默认赋值3000-01-01 00:00:00；编辑时，不会赋默认值。所以统一赋值。
			orderInfo.setDt_end(
					orderlist.getDt_end() == null ? new FDateTime("2099-01-01 00:00:00") : orderlist.getDt_end());// 停止时间
		}
		if (FBoolean.TRUE.equals(orderlist.getFg_long()) && orderlist.getDt_end() != null
				&& CiOrdUtils.MAX_SYS_DATETIME.after(orderInfo.getDt_end())) {
			orderInfo.setFg_stop(FBoolean.TRUE);
			orderInfo.setId_emp_stop(ctx.getId_emp_or());
			orderInfo.setId_dep_stop(ctx.getId_dep_or());
			orderInfo.setDt_stop(orderInfo.getDt_entry());
			orderInfo.setDt_invalid(orderInfo.getDt_end());
		}		
		// orderInfo.setName_emp_stop(Name_emp_stop);//停止医生
		orderInfo.setDays_or(orderlist.getDays_or());// 医嘱天数，医疗单实际赋值
		orderInfo.setTimes_cur(orderlist.getTimes_cur());// 次数，医疗单实际赋值
		orderInfo.setFg_research(orderlist.getFg_research());// 科研标识
		// orderInfo.setResult(Result);//结果
		orderInfo.setFg_long(orderlist.getFg_long());// 长临标识
		orderInfo.setId_su_or(orderlist.getId_su_or());// 医嘱状态：开立
		orderInfo.setSd_su_or(orderlist.getSd_su_or());// 医嘱状态：开立
		orderInfo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);// 执行状态：未执行
		orderInfo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);// 执行状态：未执行
		orderInfo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);// 计费：未计费
		orderInfo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);// 计费：未计费
		// orderInfo.setFg_skintest(Fg_skintest);//皮试标识
		orderInfo.setFg_urgent(orderlist.getFg_urgent());// 加急标识
		// orderInfo.setpr(orderlist.getPri());//单价
		// orderInfo.setFg_self(Fg_self);//自备药标识，药品
		// orderInfo.setFg_selfpay(orderlist.getFg_selfpay());//自费标识
		// orderInfo.setQuan_cur(Quan_cur);//总量当前
		// orderInfo.setId_unit_cur(Id_unit_cur);//总量单位ID
		orderInfo.setFg_set(orderlist.getFg_set());
		// orderInfo.setSd_su_bl(orderlist.getSd_su_bl());
		orderInfo.setId_srvof(orderlist.getDriverInfo().getId_ems());

		orderInfo.setEu_orsrcmdtp(ctx.getEu_orsrcmdtp());// 医嘱来源方式：医生开立
		orderInfo.setIsmuldose(orderlist.getIsmuldose());// 多剂量标识
		orderInfo.setIsmulexec(orderlist.getIsmulexec());// 多次执行标识
		orderInfo.setSd_totalopenmode(orderlist.getSd_totalopenmode());// 总量开单模式
		// orderInfo.setFg_mm(orderlist.getFg_mm());//物品标识
		orderInfo.setId_or_rel(orderlist.getId_or_rel());// 关联医嘱ID，创建不赋值
		// orderInfo.setEu_blmd(orderlist.getEu_blmd());//划价方式
		// orderInfo.setFg_selfsrv(orderlist.getFg_ctm());//自定义服务标识
		// orderInfo.setFg_use(orderlist.getFg_use_ip());//可使用标识-当前就诊类型
		// orderInfo.setSingleMedUnitList(SingleMedUnitList);//计量单位集合
		// orderInfo.setSv(dt);//时间戳
		orderInfo.setId_dep_mp(orderlist.getId_dep_mp());
		orderInfo.setName_dep_mp(orderlist.getName_dep_mp());
		// 日期相关
		FDateTime[] dtSE = OrderUtils.getDtBeginEnd(ctx.getCode_entp(), orderlist.getDt_effe(), null,
				orderlist.getDays_or());
		orderInfo.setDt_effe(dtSE[0]);
		orderInfo.setFg_sign(FBoolean.FALSE);
		orderInfo.setDt_invalid(OrderUtils.getDtInvalid(ctx, dtSE[0]));
		orderInfo.setDt_last_bl(orderInfo.getDt_effe());
		if (FBoolean.FALSE.equals(orderlist.getFg_long())) {
			orderInfo.setDt_end(orderInfo.getDt_effe());
		}
		orderInfo.setFg_mp_in(FBoolean.TRUE);
		// 计算总次数
		GetTotalTimesBP totalTimesBP = new GetTotalTimesBP();
		Integer totalTimes = totalTimesBP.getTotalTimes(orderInfo.getDt_effe(),orderInfo.getId_freq(), orderlist.getDays_or());
		orderInfo.setTimes_cur(totalTimes);
		// 执行闭环
		orderInfo.setId_orpltp(OrderUtils.getOrCLoopTpId(orderInfo));

		// 开单病区
		orderInfo.setId_dep_nur_or(ctx.getId_dep_ns());

		// orderInfo.setDes_or(orderlist.getd);
		orderInfo.setTimes_mp_in(orderlist.getTimes_cur());
		orderInfo.setFuncclassstr(orderlist.getDriverInfo().getJsonDriver());
		orderInfo.setApplyno(orderlist.getNo_applyform());
		orderInfo.setFg_pres_outp(orderlist.getFg_pres_outp());
		// 医嘱列表中的嘱托，为用法要求的自由录入结果
		orderInfo.setDes_or(orderlist.getDes_or());
		if (OrderPrescribeModuleEnum.ORDERTEMP.equals(orderlist.getEu_orderPrescribeModule())) {
			orderInfo.setError_level(orderlist.getError_level());
			orderInfo.setError_des(orderlist.getError_des());
		} else {
			orderInfo.setError_level("A");
			orderInfo.setError_des(null);
		}
		// 医嘱来源功能
		orderInfo.setId_orsrcfun(ctx.getId_orsrcfun());
		orderInfo.setSd_orsrcfun(ctx.getSd_orsrcfun());
		if(orderlist.getEu_orsrcmdtp()!=null)
		orderInfo.setEu_orsrcmdtp(orderlist.getEu_orsrcmdtp());
		orderInfo.setStatus(pInfo.getStatus());
		//护嘱的首日次数判断是否跟随医嘱，跟随取医嘱，不跟随重新计算		 0179065 liyue 2019-12-04 
		if("2".equals(orderInfo.getSd_orsrcfun()) && CiParams.YX_CIOR0009().booleanValue()) {
			orderInfo.setQuan_firday_mp(orderlist.getQuan_firday_mp());
		}else {
			//首日执行次数
			if(orderInfo.getQuan_firday_mp()==null&&FBoolean.TRUE.equals(orderInfo.getFg_long())){
				orderInfo.setQuan_firday_mp(QuanFirstDayMpBP.CalFirstDayMp(orderInfo.getId_freq(), orderInfo.getDt_effe(),null, orderInfo.getSd_srvtp(), orderInfo.getCode_entp(), null, null));
			}
		}
	}

	/**
	 * 将UI信息合并到服务中
	 * 
	 * @param ctx
	 * @param srvInfo
	 * @param uiModel
	 * @throws BizException
	 */
	protected void mergeOrderSrvInfo(CiEnContextDTO ctx, OrdSrvDO srvInfo, Object uiModel) throws BizException {
		OrderListViewDTO orderlist = (OrderListViewDTO) uiModel;
		if (orderlist.getStatus() == DOStatus.DELETED || srvInfo.getStatus() == DOStatus.DELETED)
			return;
		// 自定义服务
		if (CiOrdUtils.isTrue(orderlist.getFg_selfsrv())) {
			srvInfo.setName(orderlist.getName_srv());
		}
		srvInfo.setStatus(orderlist.getStatus());
		// 合并执行科室
		srvInfo.setId_dep_mp(orderlist.getId_dep_mp());
		if (CiOrdUtils.isTrue(srvInfo.getFg_or())) {
			srvInfo.setQuan_medu(orderlist.getQuan_med());
		}
		// 合并用法
		srvInfo.setId_route(orderlist.getId_route());
		// 合并用法要求
		srvInfo.setId_routedes(orderlist.getId_routedes());
		// 合并频次
		srvInfo.setId_freq(orderlist.getId_freq());
		srvInfo.setDt_create(orderlist.getDt_effe());
		// 重新计算价格
		srvInfo.setPri(this.getPrice4OrSrv(srvInfo.getId_srv(), orderlist.getId_primd(),
				ctx.getId_pripat()));
		// 合并自费标志
		srvInfo.setFg_selfpay(orderlist.getFg_selfpay());

		// 不计费标志
		srvInfo.setId_nodispense(orderlist.getId_nodispense());
		srvInfo.setName_nodispense(orderlist.getName_nodispense());
		srvInfo.setSd_nodispense(orderlist.getSd_nodispense());

		// 计算默认计费时间
		srvInfo.setDt_last_bl(orderlist.getDt_effe());

		// 服务开立病区
		srvInfo.setId_dep_nur_srv(ctx.getId_dep_ns());
		srvInfo.setSortno(orderlist.getSortno_srv());
		//手动划价，价格取前台传回的值
		if(MedSrvBlModeEnum.MANUALBL==orderlist.getEu_blmd()){
			srvInfo.setPri(orderlist.getPri());
		}
	}

	protected OrderListViewDTO getMainOrderListViewDTO8UI(OrderPackageInfo pInfo) {
		for (int i = 0; i < pInfo.getOrderSrvMmList().size(); i++) {
			OrderListViewDTO viewDTO = (OrderListViewDTO) pInfo.getOrderSrvMmList().get(i).getUiModel();
			if (viewDTO.getStatus() == DOStatus.DELETED) {
				continue;
			}
			return viewDTO;
		}
		return null;
	}
	@Override
	protected void afterMergeOrderPakageInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, OrdSrvDO[] srvInfos,
			Object uiModel) throws BizException {
		super.afterMergeOrderPakageInfo(ctx, orderInfo, srvInfos, uiModel);
		//设置医嘱开立的医生站类型
		if(ICiDoctorStationTypeConst.Type_Ip_MtDoctor_Station.equals(ctx.getStationType())){//医技医生站
			orderInfo.setId_orsrcfun(ICiDictCodeConst.ID_ORDSRCFUN_MT);
			orderInfo.setSd_orsrcfun(ICiDictCodeConst.SD_ORDSRCFUN_MT);
		}else if(ICiDoctorStationTypeConst.Type_Ip_NurDoctor_Station.equals(ctx.getStationType())){//护嘱医生站
			orderInfo.setId_orsrcfun(ICiDictCodeConst.ID_ORDSRCFUN_NUR);
			orderInfo.setSd_orsrcfun(ICiDictCodeConst.SD_ORDSRCFUN_NUR);
		}else{
			orderInfo.setId_orsrcfun(ICiDictCodeConst.ID_ORDSRCFUN_DOC);
			orderInfo.setSd_orsrcfun(ICiDictCodeConst.SD_ORDSRCFUN_DOC);
		}

	}

}
