package iih.ci.ord.s.ems.ip.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderPrescribeModuleEnum;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.i.common.EmsDriverInfo;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.ordsrvdose.i.IOrdsrvdoseRService;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.ordsrvset.i.IOrdsrvsetRService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.base.BaseEmsLoadBP;
import iih.ci.ord.s.ems.cache.BDFreqInfoCache;
import iih.ci.ord.s.ems.cache.BDMeasInfoCache;
import iih.ci.ord.s.ems.cache.BDUdidocInfoCache;
import iih.ci.ord.s.ems.meta.BdSrvInfoList;
import iih.ci.ord.s.ems.meta.ObjectList;
import iih.ci.ord.s.ems.meta.OrderKey2UiModelMap;
import iih.ci.ord.s.ems.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.meta.OrderPackageInfoList;
import iih.ci.ord.s.ems.meta.OrderSrvDoseList;
import iih.ci.ord.s.ems.meta.OrderSrvMmInfo;
import iih.ci.ord.s.ems.meta.OrderSrvMmList;
import iih.ci.ord.s.ems.meta.OrderSrvSetList;
import iih.ci.ord.s.ems.meta.SrvKey2UiModelMap;
import iih.ci.ord.s.ems.utils.BdSrvInfoUtils;
import iih.ci.ord.s.ems.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.utils.OrderUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * @author wangqingzhu
 *
 */
public class BaseIpEmsLoadBP extends BaseEmsLoadBP {

	@Override
	public EmsRstDTO[] load(CiEnContextDTO ctx, EmsLoadDTO[] args) throws BizException {
		// TODO Auto-generated method stub
		return new EmsRstDTO[] { new EmsRstDTO() };
	}

	protected FArrayList handleReturnDocument(Object objInfo) throws BizException {
		FArrayList objList = new FArrayList();
		objList.add(objInfo);

		return objList;
	}

	/**
	 * 获取医疗单对象
	 * 
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	protected CiEmsDTO ciEmsInfoFrom(String id_or) throws BizException {
		FMap fmap = ServiceFinder.find(ICiOrdQryService.class).getCiEmsDTO(new String[] { id_or });
		CiEmsDTO ems = (CiEmsDTO) fmap.get(id_or);
		ems.setStatus(DOStatus.UPDATED);
		return ems;
	}

	protected OrdSrvDO mainSrvInfoFrom(OrderPackageInfo opInfo) {
		OrdSrvDO orSrvDo = null;
		for (OrdSrvDO srvdo : opInfo.getOrderSrvList()) {
			if (srvdo.getId_srv().equals(opInfo.getOrderInfo().getId_srv())) {
				orSrvDo = srvdo;
				break;
			}
		}
		return orSrvDo;
	}

	/**
	 * 医嘱主键与医嘱UI模型的映射表代理
	 * 
	 * @author wangqingzhu
	 *
	 */
	public static interface IOrderKey2UiModelMapFrom {
		public OrderKey2UiModelMap getOrderKey2UiModelMap(Object objInfo);
	}

	/**
	 * 
	 * @param objInfo
	 * @param itf
	 * @return
	 * @throws BizException
	 */
	protected OrderPackageInfo[] orderPakageInfoArrayFrom(Object objInfo, IOrderKey2UiModelMapFrom orderDelegate,
			ISrvKey2UiModelMapFrom srvDelegate) throws BizException {
		return orderPakageInfoArrayFrom(orderDelegate.getOrderKey2UiModelMap(objInfo), srvDelegate);
	}

	/**
	 * 医嘱服务主键与UI模型的映射表代理
	 * 
	 * @author wangqingzhu
	 *
	 */
	public static interface ISrvKey2UiModelMapFrom {
		public SrvKey2UiModelMap getSrvKey2UiModelMap(Object objInfo);
	}

	/**
	 * 根据用户医疗单UI模型信息，获取医嘱包信息数组
	 * 
	 * @param szId_or
	 *            医嘱ID数组
	 * @return 医嘱包信息数组
	 * @throws BizException
	 */
	protected OrderPackageInfo[] orderPakageInfoArrayFrom(OrderKey2UiModelMap oium, ISrvKey2UiModelMapFrom srvDelegate)
			throws BizException {
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
			OrdSrvSetDO[] szOrdSrvSetDO = ServiceFinder.find(IOrdsrvsetRService.class).findByAttrValStrings("Id_or",
					new String[] { orderInfo.getId_or() });
			// 查询物品项目数组
			OrdSrvMmDO[] szOrdSrvMmDO = ServiceFinder.find(IOrdsrvmmRService.class).findByAttrValStrings("Id_orsrv",
					OrderUtils.ModelAttrValues(szOrdSrvDO, "Id_orsrv"));
			// 查询变动用药信息数组
			OrdSrvDoseDO[] szOrdSrvDoseDO = ServiceFinder.find(IOrdsrvdoseRService.class)
					.findByAttrValStrings("Id_orsrv", OrderUtils.ModelAttrValues(szOrdSrvDO, "Id_orsrv"));
			// 查询申请单信息
			Object[] szOrderAppSheetList = OrderUtils.QryOrderAppSheetList(new String[] { orderInfo.getId_or() });

			// 获取服务项目的主键和UI模型的映射
			SrvKey2UiModelMap srvKeyUiModelCache = srvDelegate.getSrvKey2UiModelMap(oium.get(orderInfo.getId_or()));

			// 组装医嘱服务包
			OrderPackageInfo opi = new OrderPackageInfo();

			opi.setOrderInfo(orderAggInfo.getParentDO());
			Map<String, OrdSrvMmDO> tmpSrvKeyOrdSrvMmCache = new HashMap<String, OrdSrvMmDO>();

			if (!CiOrdUtils.isEmpty(szOrdSrvMmDO)) {
				for (OrdSrvMmDO mmInfo : szOrdSrvMmDO) {
					tmpSrvKeyOrdSrvMmCache.put(mmInfo.getId_orsrv(), mmInfo);
				}
			}

			OrderSrvMmList ordSrvMmInfoList = new OrderSrvMmList();
			for (OrdSrvDO srvInfo : orderAggInfo.getOrdSrvDO()) {
				Object uiModel = srvKeyUiModelCache.containsKey(srvInfo.getId_orsrv())
						? srvKeyUiModelCache.get(srvInfo.getId_orsrv()) : null;
						OrderSrvMmInfo orderSrvMmInfo = new OrderSrvMmInfo(srvInfo, uiModel);
						if (tmpSrvKeyOrdSrvMmCache.containsKey(srvInfo.getId_orsrv())) {
							orderSrvMmInfo.setOrderSrvMmInfo(tmpSrvKeyOrdSrvMmCache.get(srvInfo.getId_orsrv()));
						}
						ordSrvMmInfoList.add(orderSrvMmInfo);
			}
			opi.setOrderSrvMmList(ordSrvMmInfoList);
			// 基础服务信息
			if (CiOrdUtils.isTrue(orderInfo.getFg_set())) {
				MedSrvDO[] szMedSrvInfo = BdSrvInfoUtils.QueryBdSrvInfo(new String[] { orderInfo.getId_srv() });
				opi.setBdSrvList(new BdSrvInfoList(szMedSrvInfo));
			} else {
				MedSrvDO[] szMedSrvInfo = BdSrvInfoUtils.QueryBdSrvInfo(ordSrvMmInfoList.asSrvKeyArray());
				opi.setBdSrvList(new BdSrvInfoList(szMedSrvInfo));
			}

			if (!CiOrdUtils.isEmpty(szOrdSrvSetDO)) {
				opi.setOrderSrvSetList(new OrderSrvSetList(szOrdSrvSetDO));
			}
			if (!CiOrdUtils.isEmpty(szOrdSrvDoseDO)) {
				opi.setOrderSrvDoseList(new OrderSrvDoseList(szOrdSrvDoseDO));
			}
			if (!CiOrdUtils.isEmpty(szOrderAppSheetList)) {
				opi.setOrderAppSheetList(new ObjectList(szOrderAppSheetList));
			}
			opi.setUiModel(oium.get(orderInfo.getId_or()));
			orderPakageInfoList.add(opi);
		}

		return orderPakageInfoList.asArray();
	}

	/**
	 * 根据用户医疗单UI模型信息，获取医嘱包信息数组
	 * 
	 * @param szId_or
	 *            医嘱ID数组
	 * @return 医嘱包信息数组
	 * @throws BizException
	 */
	protected OrderPackageInfo[] orderPakageInfoArrayFrom(String[] szId_or) throws BizException {
		OrderPackageInfoList orderPakageInfoList = new OrderPackageInfoList();
		// 获取医嘱服务聚集信息
		CiorderAggDO[] szCiorderAggInfo = CiOrdAppUtils.getOrAggQryService().findByBIds(szId_or, FBoolean.FALSE);
		// 查询套内项目信息
		for (CiorderAggDO orderAggInfo : szCiorderAggInfo) {
			// 获取医嘱信息
			CiOrderDO orderInfo = orderAggInfo.getParentDO();
			// 获取服务项目数组
			OrdSrvDO[] szOrdSrvDO = orderAggInfo.getOrdSrvDO();
			// 查询套内项目数组
			OrdSrvSetDO[] szOrdSrvSetDO = ServiceFinder.find(IOrdsrvsetRService.class).findByAttrValStrings("Id_or",
					new String[] { orderInfo.getId_or() });
			// 查询物品项目数组
			OrdSrvMmDO[] szOrdSrvMmDO = ServiceFinder.find(IOrdsrvmmRService.class).findByAttrValStrings("Id_orsrv",
					OrderUtils.ModelAttrValues(szOrdSrvDO, "Id_orsrv"));
//			// 查询变动用药信息数组
//			OrdSrvDoseDO[] szOrdSrvDoseDO = ServiceFinder.find(IOrdsrvdoseRService.class)
//					.findByAttrValStrings("Id_orsrv", OrderUtils.ModelAttrValues(szOrdSrvDO, "Id_orsrv"));
			// 查询申请单信息
			Object[] szOrderAppSheetList = OrderUtils.QryOrderAppSheetList(new String[] { orderInfo.getId_or() });

			// 组装医嘱服务包
			orderPakageInfoList.add(orderPakageInfoFrom(orderAggInfo,szOrdSrvMmDO,szOrdSrvSetDO,
					null != szOrderAppSheetList && szOrderAppSheetList.length > 0?szOrderAppSheetList[0]:null));
		}

		return orderPakageInfoList.asArray();
	}
	
	/**
	 * 根据数据库表对象，组装医嘱包信息对象
	 * @param orderAggInfo
	 * @param szOrdSrvMmDO
	 * @param szOrdSrvSetDO
	 * @param orderAppSheetInfo
	 * @return
	 * @throws BizException
	 */
	protected OrderPackageInfo orderPakageInfoFrom(CiorderAggDO orderAggInfo,OrdSrvMmDO[] szOrdSrvMmDO,OrdSrvSetDO[] szOrdSrvSetDO,Object orderAppSheetInfo) throws BizException {
		// 组装医嘱服务包
		OrderPackageInfo opi = new OrderPackageInfo();
		
		opi.setOrderInfo(orderAggInfo.getParentDO());
		Map<String, OrdSrvMmDO> tmpSrvKeyOrdSrvMmCache = new HashMap<String, OrdSrvMmDO>();

		if (!CiOrdUtils.isEmpty(szOrdSrvMmDO)) {
			for (OrdSrvMmDO mmInfo : szOrdSrvMmDO) {
				tmpSrvKeyOrdSrvMmCache.put(mmInfo.getId_orsrv(), mmInfo);
			}
		}

		OrderSrvMmList ordSrvMmInfoList = new OrderSrvMmList();
		for (OrdSrvDO srvInfo : orderAggInfo.getOrdSrvDO()) {

			OrderSrvMmInfo orderSrvMmInfo = new OrderSrvMmInfo(srvInfo, null);
			if (tmpSrvKeyOrdSrvMmCache.containsKey(srvInfo.getId_orsrv())) {
				orderSrvMmInfo.setOrderSrvMmInfo(tmpSrvKeyOrdSrvMmCache.get(srvInfo.getId_orsrv()));
			}
			ordSrvMmInfoList.add(orderSrvMmInfo);
		}
		opi.setOrderSrvMmList(ordSrvMmInfoList);
		// 基础服务信息
		if (CiOrdUtils.isTrue(orderAggInfo.getParentDO().getFg_set())) {
			MedSrvDO[] szMedSrvInfo = BdSrvInfoUtils.QueryBdSrvInfo(new String[] { orderAggInfo.getParentDO().getId_srv() });
			opi.setBdSrvList(new BdSrvInfoList(szMedSrvInfo));
		} else {
			MedSrvDO[] szMedSrvInfo = BdSrvInfoUtils.QueryBdSrvInfo(ordSrvMmInfoList.asSrvKeyArray());
			opi.setBdSrvList(new BdSrvInfoList(szMedSrvInfo));
		}

		if (!CiOrdUtils.isEmpty(szOrdSrvSetDO)) {
			opi.setOrderSrvSetList(new OrderSrvSetList(szOrdSrvSetDO));
		}
//		if (!CiOrdUtils.isEmpty(szOrdSrvDoseDO)) {
//			opi.setOrderSrvDoseList(new OrderSrvDoseList(szOrdSrvDoseDO));
//		}
		if (!CiOrdUtils.isEmpty(orderAppSheetInfo)) {
			opi.setOrderAppSheetList(new ObjectList());
			
			opi.getOrderAppSheetList().add(orderAppSheetInfo);
		}
		opi.setUiModel(null);
		
		return opi;
	}

	/**
	 * 组装模型信息 （暂时不启用）
	 * @param ctx
	 * @param opInfo
	 * @param cls
	 * @return
	 * @throws BizException
	 */
	public <T extends OrderListViewDTO> List<OrderListViewDTO> emsViewModelFrom(CiEnContextDTO ctx, OrderPackageInfo opInfo, Class<T> cls) throws BizException{
		
		List<OrderListViewDTO> orderListViewInfoList = new ArrayList<OrderListViewDTO>();
		for (OrderSrvMmInfo ordSrvMmInfo : opInfo.getOrderSrvMmList()) {
			
			OrdSrvDO ordSrvDO=ordSrvMmInfo.getOrderSrvInfo();
			// 临床项目
			if (CiOrdUtils.isTrue(ordSrvDO.getFg_or()) && OrSrvSourceFromEnum.PHYSIAN.equals(ordSrvDO.getEu_sourcemd())) {
				
				T orderListInfo = null;
				try{
					orderListInfo = cls.newInstance();
				}
				catch(Exception e){
					throw new BizException(e.getMessage());
				}
				this.orderListViewInfoFrom(ctx, opInfo.getMainBdSrvInfo(), opInfo.getOrderInfo(), ordSrvDO, orderListInfo);
				orderListViewInfoList.add(orderListInfo);
			}
		}
		return orderListViewInfoList;
	}
	

	/**
	 * 医嘱列表信息赋值
	 * 
	 * @param ctx
	 * @param medSrv
	 * @param emsViewInfo
	 * @throws BizException
	 */
	protected void orderListViewInfoFrom(CiEnContextDTO ctx, MedSrvDO medSrv, CiOrderDO orderInfo, OrdSrvDO srvDo, OrderListViewDTO emsViewInfo) 
			throws BizException {
		if (emsViewInfo == null)
			return;
		emsViewInfo.setIdsrvIdmm(srvDo.getId_srv());
		emsViewInfo.setId_or(orderInfo.getId_or());// 医嘱ID
		emsViewInfo.setCode_or(orderInfo.getCode_or());// 医嘱编码
		emsViewInfo.setId_orsrv(srvDo.getId_orsrv());// 医嘱服务ID
		emsViewInfo.setId_srvtp(srvDo.getId_srvtp());// 服务类型ID
		emsViewInfo.setSd_srvtp(srvDo.getSd_srvtp());// 服务类型编码
		emsViewInfo.setCode_entp(orderInfo.getCode_entp());// 就诊类型
		emsViewInfo.setId_srv(srvDo.getId_srv());// 服务ID
		emsViewInfo.setCode_srv(srvDo.getCode_srv());// 服务编码
		emsViewInfo.setName_srv(srvDo.getName_srv());
		emsViewInfo.setSortno_srv(srvDo.getSortno());
		// orderListViewDTO.setExtend(Extend);//辅助说明，医疗单赋值
		emsViewInfo.setQuan_med(srvDo.getQuan_medu());// 剂量
		emsViewInfo.setId_unit_med(srvDo.getId_medu());// 剂量单位ID
		emsViewInfo.setName_unit_med(BDMeasInfoCache.GetNameOfBdMeasInfo(srvDo.getId_medu()));// 剂量单位
		// 当前剂量单位和剂量赋值
		emsViewInfo.setId_medu_cur(emsViewInfo.getId_unit_med());
		emsViewInfo.setName_medu_cur(emsViewInfo.getName_unit_med());
		emsViewInfo.setQuan_medu_cur(emsViewInfo.getQuan_med());
		//频次
		FreqDefDO freqDefDO = BDFreqInfoCache.GetFreqInfo(srvDo.getId_freq());
		emsViewInfo.setId_freq(srvDo.getId_freq());// 频次ID
		emsViewInfo.setName_freq(freqDefDO.getCode());// 频次
		emsViewInfo.setFreqct(srvDo.getFreqct());// 频次数量
		emsViewInfo.setSd_frequnitct(srvDo.getSd_frequnitct());// 频次周期类型编码
		emsViewInfo.setCode_disp_freq(freqDefDO.getCode_disp());
		emsViewInfo.setId_route(srvDo.getId_route());// 用法ID
		emsViewInfo.setName_route(srvDo.getRoute_name());// 用法
		// orderListViewDTO.setFilter_route(Filter_route);//用法过滤条件，关联剂型，药品
		emsViewInfo.setId_routedes(orderInfo.getId_routedes());// 用法要求ID
		emsViewInfo.setName_routedes(orderInfo.getRoutedes_name());// 用法要求
		emsViewInfo.setDt_effe(orderInfo.getDt_effe());// 开立时间
		emsViewInfo.setId_emp_or(ctx.getId_emp_or());// 开立医生ID
		emsViewInfo.setName_emp_or(ctx.getName_emp_or());// 开立医生
		
		emsViewInfo.setId_emp_stop(orderInfo.getId_emp_stop());// 停止医生ID
		emsViewInfo.setName_emp_stop(orderInfo.getEmp_stop_name());// 停止医生
		emsViewInfo.setDays_or(orderInfo.getDays_or());// 医嘱天数
		emsViewInfo.setTimes_cur(orderInfo.getTimes_cur());// 次数
		emsViewInfo.setFg_research(orderInfo.getFg_research());// 科研标识
		emsViewInfo.setId_researchproject(orderInfo.getId_researchproject());// 科研项目ID
		emsViewInfo.setName_researchproject(orderInfo.getName_researchproject()); // 科研项目名称
		emsViewInfo.setCode_researchproject(orderInfo.getCode_researchproject());// 科研项目Code
		emsViewInfo.setPassword(orderInfo.getPassword()); // 科研项目密码
		emsViewInfo.setFg_long(orderInfo.getFg_long());// 长临标识
		emsViewInfo.setFg_long_edit(BDFreqInfoCache.GetFgLongEditOfFreqInfo(emsViewInfo.getId_freq()));
		if(!CiOrdUtils.isTrue(orderInfo.getFg_long())){
			emsViewInfo.setDt_end(null);
		}
		else{
			emsViewInfo.setDt_end(null == orderInfo.getDt_end()?null:orderInfo.getDt_end().after(new FDateTime("2098-01-01 00:00:00"))?null:orderInfo.getDt_end());// 停止时间
		}
		
		emsViewInfo.setId_su_or(orderInfo.getId_su_or());// 医嘱状态：开立
		emsViewInfo.setSd_su_or(orderInfo.getSd_su_or());// 医嘱状态：开立
		emsViewInfo.setFg_skintest(srvDo.getFg_skintest());//皮试标识
		emsViewInfo.setFg_urgent(orderInfo.getFg_urgent());// 加急标识
		emsViewInfo.setPri(srvDo.getPri());// 单价
		emsViewInfo.setFg_self(srvDo.getFg_self());//自备药标识，药品
		emsViewInfo.setFg_selfpay(srvDo.getFg_selfpay());// 自费标识
		emsViewInfo.setQuan_cur(srvDo.getQuan_total_medu());// 总量当前
		emsViewInfo.setId_unit_cur(srvDo.getId_medu());// 总量单位ID
		emsViewInfo.setSd_orrsttp(orderInfo.getSd_orrsttp());// ？？？
		emsViewInfo.setEu_uncporjudge(orderInfo.getEu_uncporjudge());// ？？？
		emsViewInfo.setEu_hpindicjudge(orderInfo.getEu_hpindicjudge());// ？？？
		emsViewInfo.setEu_hpindicjudge(orderInfo.getEu_hpindicjudge());// ？？？
		emsViewInfo.setEu_verify_pharm(orderInfo.getEu_verify_pharm());// ？？？
		emsViewInfo.setIsmuldose(orderInfo.getIsmuldose());// 多剂量标识
		emsViewInfo.setIsmulexec(orderInfo.getIsmulexec());// 多次执行标识
		emsViewInfo.setSd_totalopenmode(orderInfo.getSd_totalopenmode());// 总量开单模式
		emsViewInfo.setId_or_rel(orderInfo.getId_or_rel());// 关联医嘱ID
		emsViewInfo.setEu_blmd(srvDo.getEu_blmd());// 划价方式
		emsViewInfo.setFg_selfsrv(srvDo.getFg_selfsrv());// 自定义服务标识
		emsViewInfo.setFg_use(medSrv.getFg_use_ip());// 可使用标识-当前就诊类型	
		emsViewInfo.setId_ems(orderInfo.getId_srvof()); // 医疗单Id_ems
		emsViewInfo.setJsonDriver(orderInfo.getFuncclassstr());// 驱动信息
		emsViewInfo.setFg_quickwflow(orderInfo.getFg_quickwflow());// 短流程标志
		emsViewInfo.setEu_orsrcmdtp(orderInfo.getEu_orsrcmdtp());//医嘱来源方式：医生开立
		emsViewInfo.setQuan_firday_mp(orderInfo.getQuan_firday_mp());	
		emsViewInfo.setEu_sourcemd(srvDo.getEu_sourcemd());// 服务来源
		emsViewInfo.setFg_mm(srvDo.getFg_mm());//物品标识
		
		emsViewInfo.setFg_secadmt(srvDo.getFg_secadmt());// 后配液标志
		emsViewInfo.setId_nodispense(srvDo.getId_nodispense());// 不摆药类型	
		emsViewInfo.setSd_nodispense(srvDo.getSd_nodispense());// 不摆药类型
		emsViewInfo.setName_nodispense(BDUdidocInfoCache.GetNameOfBDUdidocInfo(srvDo.getId_nodispense()));// 不摆药类型
		emsViewInfo.setFg_set(orderInfo.getFg_set());
		emsViewInfo.setId_primd(medSrv.getId_primd());
		emsViewInfo.setFg_or(srvDo.getFg_or());
		emsViewInfo.setSv(orderInfo.getSv());
		emsViewInfo.setEu_OrderPrescribeModule(OrderPrescribeModuleEnum.ORDERAPPFORM);//医嘱开立方式-医疗单开立
		emsViewInfo.setId_dep_mp(srvDo.getId_dep_mp());
		emsViewInfo.setName_dep_mp(srvDo.getDep_mp_name());
		emsViewInfo.setId_dep_wh(srvDo.getId_dep_wh());
		emsViewInfo.setName_dep_wh(srvDo.getName_dep_wh());
		emsViewInfo.setFg_urgent_edit(medSrv.getFg_urgent_ip());// 加急可使用标识
		emsViewInfo.setFg_pres_outp(orderInfo.getFg_pres_outp());
		emsViewInfo.setId_orsrcfun(orderInfo.getId_orsrcfun());
		emsViewInfo.setSd_orsrcfun(orderInfo.getSd_orsrcfun());
		this.setOrWfDeptInfo(ctx, medSrv, emsViewInfo);
	}

	/**
	 * 设置执行科室信息
	 * 
	 * @param ctx
	 * @param medSrv
	 * @param orderViewDTO
	 * @throws BizException
	 */
	protected void setOrWfDeptInfo(CiEnContextDTO ctx, MedSrvDO medSrv, OrderListViewDTO orderViewDTO)
			throws BizException {
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ctx, medSrv.getId_srv(), orderViewDTO.getId_mm(), orderViewDTO.getId_route(),null,
				orderViewDTO.getFg_long(),ctx.getFg_pres_outp(),orderViewDTO.getDt_effe());
		if (!CiOrdUtils.isEmpty(wf)) {
			if (!StringUtils.isEmpty(orderViewDTO.getId_mm())) {
//				orderViewDTO.setId_dep_wh(wf.getId_dept_wh());// 物资仓库ID
//				orderViewDTO.setName_dep_wh(wf.getName_dept_wh());// 物资仓库
				orderViewDTO.setFilter_dep_wh(wf.getId_dept_whs());// 物资仓库过滤条件
			}
//			orderViewDTO.setId_dep_mp(wf.getFirstid_mp_dept());// 执行科室ID
//			orderViewDTO.setName_dep_mp(wf.getFirstname_mp_dept());// 执行科室
			orderViewDTO.setFilter_dep_mp("1".equals(wf.getMp_source()) ? null : wf.getId_mp_depts());// 执行科室过滤条件
		}
	}

	/**
	 * 医疗单UI与列表合并
	 * 
	 * @param srcDto
	 *            列表数据
	 * @param uiModel
	 *            医疗单UI
	 */
	protected void mergeModelInfo(OrderListViewDTO srcDto, OrderListViewDTO uiModel) {
		srcDto.deSerializeJson(uiModel.serializeJson());
	}

	protected void setEmsDriverInfo(EmsDriverInfo driverInfo, OrderListViewDTO emsViewDTO) {
		if (emsViewDTO.getDriverInfo() == null) {
			emsViewDTO.setDriverInfo(driverInfo);
		}
		if (StringUtils.isEmpty(emsViewDTO.getId_ems())) {
			emsViewDTO.setId_ems(driverInfo.getId_ems());
		}
		if (StringUtils.isEmpty(emsViewDTO.getJsonDriver())) {
			emsViewDTO.setJsonDriver(driverInfo.getJsonDriver());
		}
		if (null == emsViewDTO.getFg_quickwflow()) {
			emsViewDTO.setFg_quickwflow(driverInfo.getFg_quickwflow());
		}

	}
	/**
	 * 获取医嘱列表上显示的服务类型名称 bd_udidoc.ctrl2
	 * @param id_srvtp
	 * @return
	 * @throws DAException
	 */
	protected String getOrListNameSrvtp(String id_srvtp) throws DAException {
		StringBuffer sqlQry = new StringBuffer();
		SqlParam param = new SqlParam();
		param.addParam(IBdSrvDictCodeTypeConst.ID_SRVTP);
		param.addParam(id_srvtp);
		sqlQry.append(" select ctrl2 from bd_udidoc where id_udidoclist = ? and id_udidoc = ?");
		List<String> list = (List<String>) new DAFacade().execQuery(sqlQry.toString(),param, new ColumnListHandler());
		if(!CiOrdUtils.isEmpty(list)) return list.get(0);
		return null;
	}
}
