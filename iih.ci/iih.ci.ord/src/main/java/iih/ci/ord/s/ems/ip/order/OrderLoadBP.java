package iih.ci.ord.s.ems.ip.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;

import iih.bd.base.database.DatabaseUtils;
import iih.bd.base.database.SqlConditionsParameter;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.ems.d.EmsAppModeEnum;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.d.RefuseCheckTp;
import iih.ci.ord.dws.ip.ems.d.EmsRisViewItemDTO;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderPrescribeModuleEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.i.common.EmsDriverInfo;
import iih.ci.ord.i.external.obtain.ICiOrdBdRService;
import iih.ci.ord.i.meta.OrderOperateDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.base.BaseEmsDriverDecode;
import iih.ci.ord.s.ems.cache.BDMeasInfoCache;
import iih.ci.ord.s.ems.cache.BDSrvInfoCache;
import iih.ci.ord.s.ems.cache.BDUdidocInfoCache;
import iih.ci.ord.s.ems.itf.bp.IOrderLoadBP;
import iih.ci.ord.s.ems.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.utils.SysParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 住院医嘱内容加载逻辑
 * 
 * @author wangqingzhu
 *
 */
public class OrderLoadBP extends BaseEmsDriverDecode implements IOrderLoadBP {

	@Override
	public OrderRstDTO load(CiEnContextDTO ctx, OrderOperateDTO arg) throws BizException {

		OrderRstDTO rst = new OrderRstDTO( );
		// 入参需要区别住院医嘱列表还是出院带药医嘱列表
		// 获取医嘱排序模式
		List<OrderListViewDTO> orderList = DatabaseUtils.Q(new SqlConditionsParameter(this.getMainSql(ctx).toString())
				.addParam(ctx.getId_en()).addParam(ctx.getCode_entp())
				// .addParam(FBoolean.TRUE)//// 是否出院带药
				.addParam(OrSourceFromEnum.IIHMEDTECHORDERS).addSql(this.getOrderBy().toString()),
				OrderListViewDTO.class);
		rst.setDocument(new FArrayList());
		rst.getDocument().addAll(nursHadnleOrderListComplexInfo(ctx, orderList));
		return rst;
	}

	public List<OrderListViewDTO> load(CiEnContextDTO ctx, String[] szId_or) throws BizException {
		List<OrderListViewDTO> orderList = DatabaseUtils.Q(new SqlConditionsParameter(this.getMainSql(ctx).toString())
				.addParam(ctx.getId_en()).addParam(ctx.getCode_entp())
				// .addParam(FBoolean.TRUE)//// 是否出院带药
				.addParam(OrSourceFromEnum.IIHMEDTECHORDERS).andSqlInParam("A.id_or", szId_or)
				.addSql(this.getOrderBy().toString()), OrderListViewDTO.class);
		return nursHadnleOrderListComplexInfo(ctx, orderList);

	}

	/**
	 * 医嘱列表数据处理
	 * 
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	private List<OrderListViewDTO> nursHadnleOrderListComplexInfo(CiEnContextDTO ctx, List<OrderListViewDTO> orderList)
			throws BizException {
		this.setOrderStatus(orderList);
		for (OrderListViewDTO orderListViewDTO : orderList) {
			// 组织物品医嘱服务剂量
			// if (!StringUtils.isEmpty(orderListViewDTO.getId_unit_base())) {
			// orderListViewDTO.setName_unit_base(BDMeasInfoCache.GetNameOfBdMeasInfo(orderListViewDTO.getId_unit_base()));
			// }
			// 当前默认单位，为剂量单位
			orderListViewDTO.setId_medu_cur(orderListViewDTO.getId_unit_med());
			orderListViewDTO.setName_medu_cur(orderListViewDTO.getName_unit_med());
			orderListViewDTO.setQuan_medu_cur(orderListViewDTO.getQuan_med());
			orderListViewDTO.setFactor_cur(orderListViewDTO.getFactor_mb());
			if (orderListViewDTO.getDt_end() != null
					&& (orderListViewDTO.getDt_end().after(new FDateTime("2098-01-01 00:00:00"))
							|| orderListViewDTO.getDt_end().compareTo(orderListViewDTO.getDt_effe()) == 0))
				orderListViewDTO.setDt_end(null);
			// 参照主键必须赋值
			orderListViewDTO.setIdsrvIdmm(orderListViewDTO.getId_srv() + (StringUtils.isEmpty(orderListViewDTO.getId_mm()) ? "" : orderListViewDTO.getId_mm())+ (StringUtils.isEmpty(orderListViewDTO.getId_unit_cur()) ? "": orderListViewDTO.getId_unit_cur()));
			//药品的剂量单位转为基本包装单位
			if(!StringUtils.isEmpty(orderListViewDTO.getSd_srvtp()) && orderListViewDTO.getSd_srvtp().startsWith("01"))
			{
				getBaseQuanMedu(orderListViewDTO);
			}
		}
		return orderList;
	}

	/**
	 * 医嘱列表数据处理
	 * 
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	private List<OrderListViewDTO> hadnleOrderList(CiEnContextDTO ctx, List<OrderListViewDTO> orderList)
			throws BizException {

		List<OrderListViewDTO> rstOrderList = new ArrayList<OrderListViewDTO>();
		if (CiOrdUtils.isEmpty(orderList))
			return rstOrderList;

		// 设置医嘱显示状态
		this.setOrderStatus(orderList);

		// 医嘱费用总金额map
		Map<String, OrderListViewDTO> orderFeeMaps = new HashMap<String, OrderListViewDTO>();
		// 存放医嘱服务套ci_or_srv 中fg_set=Y fg_or=Y的数据
		Map<String, OrderListViewDTO> orderSetMaps = new HashMap<String, OrderListViewDTO>();
		// 草药根据id_or合并存放
		Map<String, OrderListViewDTO> herbMaps = new HashMap<String, OrderListViewDTO>();

		// 服务ID
		List<String> idsrvlst = new ArrayList<String>();
		// 定义物品ID集合
		// StringList mmIDList = new StringList();

		this.setSrvRoutedesInfo(orderList);
		for (OrderListViewDTO orderListViewDTO : orderList) {
			// TODO 判断出院带药列表需要计算总金额
			if (ctx.getEmsappmode() == EmsAppModeEnum.OUTHEMSAPPMODE) {
				if (orderFeeMaps.containsKey(orderListViewDTO.getId_or())) {
					// 所有费用项金额合计
					if (CiOrdUtils.isTrue(orderListViewDTO.getFg_bl())) {
						OrderListViewDTO dto = orderFeeMaps.get(orderListViewDTO.getId_or());
						FDouble or_total_pri = dto.getTotalprice();
						or_total_pri = or_total_pri
								.add(orderListViewDTO.getQuan_cur().multiply(orderListViewDTO.getPri()));
						dto.setTotalprice(or_total_pri);
					}
				} else {
					if (orderListViewDTO.getFg_bl().booleanValue())
						orderFeeMaps.put(orderListViewDTO.getId_or(), orderListViewDTO);
				}
			}
			// 如果是服务套 把fg_set=Y 并且 fg_or=Y的orsrv 取出
			if (CiOrdUtils.isTrue(orderListViewDTO.getFg_set()) && CiOrdUtils.isTrue(orderListViewDTO.getFg_or())) {
				orderSetMaps.put(orderListViewDTO.getId_or(), orderListViewDTO);
			}
			// 如果是草药则按照id_or进行过滤支取一条显示在医嘱列表上
			if (orderListViewDTO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
				if (!herbMaps.containsKey(orderListViewDTO.getId_or())) {
					herbMaps.put(orderListViewDTO.getId_or(), orderListViewDTO);
				}
			}

			// 参照主键必须赋值
			orderListViewDTO.setIdsrvIdmm(orderListViewDTO.getId_srv()
					+ (StringUtils.isEmpty(orderListViewDTO.getId_mm()) ? "" : orderListViewDTO.getId_mm())
					+ (StringUtils.isEmpty(orderListViewDTO.getId_unit_cur()) ? ""
							: orderListViewDTO.getId_unit_cur()));

			// 解析驱动
			if (!StringUtils.isEmpty(orderListViewDTO.getJsonDriver())) {
				EmsDriverInfo dvi = this.parseJsonDriver(orderListViewDTO.getJsonDriver());
				dvi.setId_ems(orderListViewDTO.getId_ems());
				orderListViewDTO.setDriverInfo(dvi);
			}

			// 记录非签署状态医嘱的id_srv
			if (!StringUtils.isEmpty(orderListViewDTO.getId_srv()) && !idsrvlst.contains(orderListViewDTO.getId_srv())
					&& !CiOrdUtils.isTrue(orderListViewDTO.getFg_sign())) {
				idsrvlst.add(orderListViewDTO.getId_srv());
			}
			// 医嘱开立方式：默认医嘱列表开立
			orderListViewDTO.setEu_OrderPrescribeModule(OrderPrescribeModuleEnum.ORDERLIST);

			// 组织物品医嘱服务剂量
			if (!StringUtils.isEmpty(orderListViewDTO.getId_unit_base())) {
				orderListViewDTO
						.setName_unit_base(BDMeasInfoCache.GetNameOfBdMeasInfo(orderListViewDTO.getId_unit_base()));
			}
			// 当前默认单位，为剂量单位
			orderListViewDTO.setId_medu_cur(orderListViewDTO.getId_unit_med());
			orderListViewDTO.setName_medu_cur(orderListViewDTO.getName_unit_med());
			orderListViewDTO.setQuan_medu_cur(orderListViewDTO.getQuan_med());
			orderListViewDTO.setFactor_cur(orderListViewDTO.getFactor_mb());
			// 用法过滤条件，关联剂型，药品
			if (!CiOrdUtils.isTrue(orderListViewDTO.getFg_sign())) {
				orderListViewDTO.setFilter_route(ServiceFinder.find(ICiOrdBdRService.class).getIdroutes8Dosage(
						orderListViewDTO.getSd_srvtp(), new String[] { orderListViewDTO.getId_srv() }, FBoolean.FALSE));
			}
			if (orderListViewDTO.getDt_end() != null
					&& (orderListViewDTO.getDt_end().after(new FDateTime("2098-01-01 00:00:00"))
							|| orderListViewDTO.getDt_end().compareTo(orderListViewDTO.getDt_effe()) == 0))
				orderListViewDTO.setDt_end(null);

		}

		// 查询 Bd_srv 基础数据集合
		Map<String, MedSrvDO> mapMedSrvs = new HashMap<String, MedSrvDO>();
		if (idsrvlst.size() > 0) {
			MedSrvDO[] srvs = BDSrvInfoCache.GetBdSrvInfos(ctx, idsrvlst.toArray(new String[] {}));
			if (srvs != null && srvs.length > 0) {
				for (MedSrvDO srv : srvs) {
					mapMedSrvs.put(srv.getId_srv(), srv);
				}
			}
		}

		// 非服务套的服务 将fg_or=Y的取出
		for (OrderListViewDTO orderListViewDTO : orderList) {
			if (CiOrdUtils.isTrue(orderListViewDTO.getFg_or())) {
				if (!orderSetMaps.containsKey(orderListViewDTO.getId_or())
						&& !herbMaps.containsKey(orderListViewDTO.getId_or())) {
					if (orderFeeMaps.containsKey(orderListViewDTO.getId_or())) {
						orderListViewDTO.setTotalprice(orderFeeMaps.get(orderListViewDTO.getId_or()).getTotalprice());
					}

					rstOrderList.add(orderListViewDTO);
				}
			}
			// 计算执行科室信息
			if (!CiOrdUtils.isTrue(orderListViewDTO.getFg_sign())) {
				this.setOrWfDeptInfo(ctx, mapMedSrvs.get(orderListViewDTO.getId_srv()), orderListViewDTO);
			}
			// 不计费标志名称
			if (!StringUtils.isEmpty(orderListViewDTO.getId_nodispense())) {
				orderListViewDTO.setName_nodispense(
						BDUdidocInfoCache.GetNameOfBDUdidocInfo(orderListViewDTO.getId_nodispense()));
			}
		}

		String orSetQrySql = this.getOrSetSql();
		String setSrvQrySql = this.getSetSrvSql();

		// 服务套的数据取出放入返回结果集
		Iterator<Entry<String, OrderListViewDTO>> entryKeyIterator = orderSetMaps.entrySet().iterator();
		while (entryKeyIterator.hasNext()) {
			Entry<String, OrderListViewDTO> dto = entryKeyIterator.next();
			OrderListViewDTO orderListViewDTO = dto.getValue();
			if (orderFeeMaps.containsKey(orderListViewDTO.getId_or())) {
				orderListViewDTO.setTotalprice(orderFeeMaps.get(orderListViewDTO.getId_or()).getTotalprice());
			}

			FArrayList emsextinfolist = new FArrayList();
			SqlParam param = new SqlParam();
			param.addParam(orderListViewDTO.getId_or());
			@SuppressWarnings("unchecked")
			List<EmsRisViewItemDTO> checksetitem = (List<EmsRisViewItemDTO>) new DAFacade().execQuery(orSetQrySql,
					param, new BeanListHandler(EmsRisViewItemDTO.class));
			param.clearParams();
			param.addParam(orderListViewDTO.getId_srv());
			// 查询出服务套关联的套内项目
			@SuppressWarnings("unchecked")
			List<EmsRisViewItemDTO> allsetitem = (List<EmsRisViewItemDTO>) new DAFacade().execQuery(setSrvQrySql, param,
					new BeanListHandler(EmsRisViewItemDTO.class));
			for (EmsRisViewItemDTO item : allsetitem) {
				for (EmsRisViewItemDTO checkItem : checksetitem) {
					if (checkItem.getId_srv().equals(item.getId_srv())) {
						item.setId_body(checkItem.getId_body());
						item.setSd_body(checkItem.getSd_body());
						item.setName_body(checkItem.getName_body());
						item.setFg_check(FBoolean.TRUE);
					}
				}
				emsextinfolist.append(item);
			}
			orderListViewDTO.setExtInfoList(emsextinfolist);

			// 处理检查套内项目的拼接
			if (orderListViewDTO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)
					&& !orderListViewDTO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI)) {
				StringBuilder strIdSb = new StringBuilder();
				StringBuilder strCodeSb = new StringBuilder();
				StringBuilder strNameSb = new StringBuilder();
				for (Object objItem : orderListViewDTO.getExtInfoList()) {
					EmsRisViewItemDTO itemDTO = (EmsRisViewItemDTO) objItem;
					if (FBoolean.TRUE.equals(itemDTO.getFg_check())) {
						if (!StringUtils.isEmpty(itemDTO.getName_body())) {
							strIdSb.append(",").append(itemDTO.getId_body());
							strCodeSb.append(",").append(itemDTO.getSd_body());
							strNameSb.append(",").append(itemDTO.getName_body());
						}
					}
				}

				orderListViewDTO.setId_extend(strIdSb.length() > 0 ? strIdSb.substring(1) : strIdSb.toString());
				orderListViewDTO.setSd_extend(strCodeSb.length() > 0 ? strCodeSb.substring(1) : strCodeSb.toString());
				orderListViewDTO.setExtend(strNameSb.length() > 0 ? strNameSb.substring(1) : strNameSb.toString());
			}
			rstOrderList.add(orderListViewDTO);
		}
		// 取出草药的医嘱信息添加到返回的集合中
		Iterator<Entry<String, OrderListViewDTO>> herbKeyIterator = herbMaps.entrySet().iterator();
		while (herbKeyIterator.hasNext()) {
			Entry<String, OrderListViewDTO> dto = herbKeyIterator.next();
			OrderListViewDTO orderListViewDTO = dto.getValue();
			if (orderFeeMaps.containsKey(orderListViewDTO.getId_or())) {
				orderListViewDTO.setTotalprice(orderFeeMaps.get(orderListViewDTO.getId_or()).getTotalprice());
			}
			orderListViewDTO.setName_srv(orderListViewDTO.getNote());
			rstOrderList.add(orderListViewDTO);
		}
		return rstOrderList;
		// */
	}

	private List<OrderListViewDTO> hadnleOrderListComplexInfo(CiEnContextDTO ctx, List<OrderListViewDTO> orderList)
			throws BizException {

		List<OrderListViewDTO> rstOrderList = new ArrayList<OrderListViewDTO>();
		if (CiOrdUtils.isEmpty(orderList))
			return rstOrderList;

		// 设置医嘱显示状态
		this.setOrderStatus(orderList);

		// 医嘱费用总金额map
		Map<String, OrderListViewDTO> orderFeeMaps = new HashMap<String, OrderListViewDTO>();
		// 存放医嘱服务套ci_or_srv 中fg_set=Y fg_or=Y的数据
		Map<String, OrderListViewDTO> orderSetMaps = new HashMap<String, OrderListViewDTO>();
		// 草药根据id_or合并存放
		Map<String, OrderListViewDTO> herbMaps = new HashMap<String, OrderListViewDTO>();

		// 服务ID
		List<String> idsrvlst = new ArrayList<String>();
		// 定义物品ID集合
		// StringList mmIDList = new StringList();

		this.setSrvRoutedesInfo(orderList);
		for (OrderListViewDTO orderListViewDTO : orderList) {
			// TODO 判断出院带药列表需要计算总金额
			if (ctx.getEmsappmode() == EmsAppModeEnum.OUTHEMSAPPMODE) {
				if (orderFeeMaps.containsKey(orderListViewDTO.getId_or())) {
					// 所有费用项金额合计
					if (CiOrdUtils.isTrue(orderListViewDTO.getFg_bl())) {
						OrderListViewDTO dto = orderFeeMaps.get(orderListViewDTO.getId_or());
						FDouble or_total_pri = dto.getTotalprice();
						or_total_pri = or_total_pri
								.add(orderListViewDTO.getQuan_cur().multiply(orderListViewDTO.getPri()));
						dto.setTotalprice(or_total_pri);
					}
				} else {
					if (orderListViewDTO.getFg_bl().booleanValue())
						orderFeeMaps.put(orderListViewDTO.getId_or(), orderListViewDTO);
				}
			}
			// 如果是服务套 把fg_set=Y 并且 fg_or=Y的orsrv 取出
			if (CiOrdUtils.isTrue(orderListViewDTO.getFg_set()) && CiOrdUtils.isTrue(orderListViewDTO.getFg_or())) {
				orderSetMaps.put(orderListViewDTO.getId_or(), orderListViewDTO);
			}
			// 如果是草药则按照id_or进行过滤支取一条显示在医嘱列表上
			if (orderListViewDTO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
				if (!herbMaps.containsKey(orderListViewDTO.getId_or())) {
					herbMaps.put(orderListViewDTO.getId_or(), orderListViewDTO);
				}
			}

			orderListViewDTO.setCode_entp(ctx.getCode_entp());
			// 参照主键必须赋值
			orderListViewDTO.setIdsrvIdmm(orderListViewDTO.getId_srv()
					+ (StringUtils.isEmpty(orderListViewDTO.getId_mm()) ? "" : orderListViewDTO.getId_mm()));

			// 解析驱动
			if (!StringUtils.isEmpty(orderListViewDTO.getJsonDriver())) {
				EmsDriverInfo dvi = this.parseJsonDriver(orderListViewDTO.getJsonDriver());
				dvi.setId_ems(orderListViewDTO.getId_ems());
				orderListViewDTO.setDriverInfo(dvi);
			}

			// 记录非签署状态医嘱的id_srv
			if (!StringUtils.isEmpty(orderListViewDTO.getId_srv()) && !idsrvlst.contains(orderListViewDTO.getId_srv())
					&& !CiOrdUtils.isTrue(orderListViewDTO.getFg_sign())) {
				idsrvlst.add(orderListViewDTO.getId_srv());
			}
			// 医嘱开立方式：默认医嘱列表开立
			orderListViewDTO.setEu_OrderPrescribeModule(OrderPrescribeModuleEnum.ORDERLIST);

			// 组织物品医嘱服务剂量
			if (!StringUtils.isEmpty(orderListViewDTO.getId_unit_base())) {
				orderListViewDTO
						.setName_unit_base(BDMeasInfoCache.GetNameOfBdMeasInfo(orderListViewDTO.getId_unit_base()));
			}
			// 当前默认单位，为剂量单位
			orderListViewDTO.setId_medu_cur(orderListViewDTO.getId_unit_med());
			orderListViewDTO.setName_medu_cur(orderListViewDTO.getName_unit_med());
			orderListViewDTO.setQuan_medu_cur(orderListViewDTO.getQuan_med());
			orderListViewDTO.setFactor_cur(orderListViewDTO.getFactor_mb());
			// 用法过滤条件，关联剂型，药品
			if (!CiOrdUtils.isTrue(orderListViewDTO.getFg_sign())) {
				orderListViewDTO.setFilter_route(ServiceFinder.find(ICiOrdBdRService.class).getIdroutes8Dosage(
						orderListViewDTO.getSd_srvtp(), new String[] { orderListViewDTO.getId_srv() }, FBoolean.FALSE));
			}
			if (orderListViewDTO.getDt_end() != null
					&& (orderListViewDTO.getDt_end().after(new FDateTime("2098-01-01 00:00:00"))
							|| orderListViewDTO.getDt_end().compareTo(orderListViewDTO.getDt_effe()) == 0))
				orderListViewDTO.setDt_end(null);

		}

		// 查询 Bd_srv 基础数据集合
		Map<String, MedSrvDO> mapMedSrvs = new HashMap<String, MedSrvDO>();
		if (idsrvlst.size() > 0) {
			MedSrvDO[] srvs = BDSrvInfoCache.GetBdSrvInfos(ctx, idsrvlst.toArray(new String[] {}));
			if (srvs != null && srvs.length > 0) {
				for (MedSrvDO srv : srvs) {
					mapMedSrvs.put(srv.getId_srv(), srv);
				}
			}
		}

		// 非服务套的服务 将fg_or=Y的取出
		for (OrderListViewDTO orderListViewDTO : orderList) {
			if (CiOrdUtils.isTrue(orderListViewDTO.getFg_or())) {
				if (!orderSetMaps.containsKey(orderListViewDTO.getId_or())
						&& !herbMaps.containsKey(orderListViewDTO.getId_or())) {
					if (orderFeeMaps.containsKey(orderListViewDTO.getId_or())) {
						orderListViewDTO.setTotalprice(orderFeeMaps.get(orderListViewDTO.getId_or()).getTotalprice());
					}

					rstOrderList.add(orderListViewDTO);
				}
			}
			// 计算执行科室信息
			if (!CiOrdUtils.isTrue(orderListViewDTO.getFg_sign())) {
				this.setOrWfDeptInfo(ctx, mapMedSrvs.get(orderListViewDTO.getId_srv()), orderListViewDTO);
			}
			// 不计费标志名称
			if (!StringUtils.isEmpty(orderListViewDTO.getId_nodispense())) {
				orderListViewDTO.setName_nodispense(
						BDUdidocInfoCache.GetNameOfBDUdidocInfo(orderListViewDTO.getId_nodispense()));
			}
		}

		String orSetQrySql = this.getOrSetSql();
		String setSrvQrySql = this.getSetSrvSql();

		// 服务套的数据取出放入返回结果集
		Iterator<Entry<String, OrderListViewDTO>> entryKeyIterator = orderSetMaps.entrySet().iterator();
		while (entryKeyIterator.hasNext()) {
			Entry<String, OrderListViewDTO> dto = entryKeyIterator.next();
			OrderListViewDTO orderListViewDTO = dto.getValue();
			if (orderFeeMaps.containsKey(orderListViewDTO.getId_or())) {
				orderListViewDTO.setTotalprice(orderFeeMaps.get(orderListViewDTO.getId_or()).getTotalprice());
			}

			FArrayList emsextinfolist = new FArrayList();
			SqlParam param = new SqlParam();
			param.addParam(orderListViewDTO.getId_or());
			@SuppressWarnings("unchecked")
			List<EmsRisViewItemDTO> checksetitem = (List<EmsRisViewItemDTO>) new DAFacade().execQuery(orSetQrySql,
					param, new BeanListHandler(EmsRisViewItemDTO.class));
			param.clearParams();
			param.addParam(orderListViewDTO.getId_srv());
			// 查询出服务套关联的套内项目
			@SuppressWarnings("unchecked")
			List<EmsRisViewItemDTO> allsetitem = (List<EmsRisViewItemDTO>) new DAFacade().execQuery(setSrvQrySql, param,
					new BeanListHandler(EmsRisViewItemDTO.class));
			for (EmsRisViewItemDTO item : allsetitem) {
				for (EmsRisViewItemDTO checkItem : checksetitem) {
					if (checkItem.getId_srv().equals(item.getId_srv())) {
						item.setId_body(checkItem.getId_body());
						item.setSd_body(checkItem.getSd_body());
						item.setName_body(checkItem.getName_body());
						item.setFg_check(FBoolean.TRUE);
					}
				}
				emsextinfolist.append(item);
			}
			orderListViewDTO.setExtInfoList(emsextinfolist);

			// 处理检查套内项目的拼接
			if (orderListViewDTO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)
					&& !orderListViewDTO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI)) {
				StringBuilder strIdSb = new StringBuilder();
				StringBuilder strCodeSb = new StringBuilder();
				StringBuilder strNameSb = new StringBuilder();
				for (Object objItem : orderListViewDTO.getExtInfoList()) {
					EmsRisViewItemDTO itemDTO = (EmsRisViewItemDTO) objItem;
					if (FBoolean.TRUE.equals(itemDTO.getFg_check())) {
						if (!StringUtils.isEmpty(itemDTO.getName_body())) {
							strIdSb.append(",").append(itemDTO.getId_body());
							strCodeSb.append(",").append(itemDTO.getSd_body());
							strNameSb.append(",").append(itemDTO.getName_body());
						}
					}
				}

				orderListViewDTO.setId_extend(strIdSb.length() > 0 ? strIdSb.substring(1) : strIdSb.toString());
				orderListViewDTO.setSd_extend(strCodeSb.length() > 0 ? strCodeSb.substring(1) : strCodeSb.toString());
				orderListViewDTO.setExtend(strNameSb.length() > 0 ? strNameSb.substring(1) : strNameSb.toString());
			}
			rstOrderList.add(orderListViewDTO);
		}
		// 取出草药的医嘱信息添加到返回的集合中
		Iterator<Entry<String, OrderListViewDTO>> herbKeyIterator = herbMaps.entrySet().iterator();
		while (herbKeyIterator.hasNext()) {
			Entry<String, OrderListViewDTO> dto = herbKeyIterator.next();
			OrderListViewDTO orderListViewDTO = dto.getValue();
			if (orderFeeMaps.containsKey(orderListViewDTO.getId_or())) {
				orderListViewDTO.setTotalprice(orderFeeMaps.get(orderListViewDTO.getId_or()).getTotalprice());
			}
			orderListViewDTO.setName_srv(orderListViewDTO.getNote());
			rstOrderList.add(orderListViewDTO);
		}
		return rstOrderList;
		// */
	}

	private StringBuffer getMainSql(CiEnContextDTO ctx) throws BizException {

		StringBuffer sql = new StringBuffer()
				.append("select A.id_or,")
				.append(" A.quan_firday_mp,")
				.append(" A.code_or,")
				.append(" A.code_entp,")
				.append(" D.id_orsrv,")
				// .append(" A.id_srvtp,")
				.append(" A.sd_srvtp,")
				.append(" D.id_srv,")
				.append(" A.id_srvof as id_ems,")
				// .append(" A.fg_quickwflow,")
				.append(" D.name name_srv,")
				.append(" E.id_mm,")
				.append(" E.name_mm,")
				.append(" A.sortno,")
				.append(" D.sortno sortno_srv,")
				// .append(" J.sd_datelimittype,")
				.append(" D.id_primd,")
				.append(" A.id_or_rel,")
				.append(" A.fg_pres_outp,")
				// .append(" A.id_orsrcfun,")
				.append(" A.sd_orsrcfun,")
				.append(" A.Dt_Chk,")//增加医嘱确认时间
				.append("(select ctrl2 from bd_udidoc where Id_udidoclist = '" + IBdSrvDictCodeTypeConst.ID_SRVTP
						+ "' and code=decode(substr(A.sd_srvtp, 1, 2),'01',substr(A.sd_srvtp, 1, 4),'14',substr(A.sd_srvtp, 1, 4),substr(A.sd_srvtp, 1, 2))) name_srvtp,")
				.append(" D.quan_medu quan_med,")
				.append(" D.quan_total_medu,")
				.append(" D.id_medu id_unit_med,")
				.append(" med.name name_unit_med,")
				.append(" E.id_pgku_base Id_unit_base,")
				.append(" basemed.name name_unit_base,")
				// .append(" A.applyno as no_applyform,")
				.append(" (case when substr(A.sd_srvtp,0,2)='01' then E.price_pgku_cur else D.pri end) pri,")
				.append(" (case when substr(A.sd_srvtp,0,2)='01' then E.quan_cur else D.quan_total_medu end) quan_cur,")
				// .append(" DRUG.sd_anti,A.Fg_spec_anti_approve,")
				.append(" C.sd_totalopenmode,")
				.append(" D.id_freq,")
				.append(" P.code name_freq,")
				.append(" P.fg_long_edit,")
				.append(" P.Freqct,")
				.append(" A.times_cur,")
				 .append(" D.id_route,")
				.append(" Q.name name_route,")
				// .append(" A.id_routedes,")
				.append(" A.des_or ,")
				// .append(" D.id_routedes id_routedes_srv,")
				// .append(" Q1.name name_routedes_srv,")
				// .append(" A.id_su_or,")
				.append(" to_char((select listagg(b.name,',') within group (order by b.code) from bd_route_des b where D.id_routedes like '%'||b.id_routedes||'%')) as name_routedes,")
				.append(" A.sd_su_or,")
				.append(" A.sd_su_mp,")
				.append(" A.sd_su_bl,")
				// .append(" A.fg_orhp,")
				// .append(" A.eu_uncporjudge,")
				// .append(" A.eu_verify_pharm,")
				// .append(" A.sd_orrsttp,")
				// .append(" case when D.sd_srvtp like '0101%' then
				// D.eu_hpindicjudge else A.eu_hpindicjudge end as
				// eu_hpindicjudge,")
				 .append(" A.id_emp_stop,")
				 .append(" A.id_emp_chk,")
				 .append(" A.id_emp_chk_stop,")
				 .append(" S.name name_emp_stop,")
				 .append(" S1.name name_nur_check,")
				 .append(" S2.name name_nur_stop,")
				// .append(" D.id_dep_wh,")
				.append(" T.name name_dep_wh,")
				.append(" D.id_dep_mp,")
				.append(" U.name name_dep_mp,")
				.append(" A.dt_effe,")
				.append(" A.dt_end,")
			    .append(" E.Factor_mb,")
				// .append(" E.Factor as factor_cb ,")
				// .append(" K.ctrl1 as eu_anseca,")
				// .append(" D.fg_or,")
				.append(" D.fg_bl,")
				.append(" A.fg_long,")
				.append(" D.fg_mm,")
				// .append(" D.fg_set,")
				// .append(" C.fg_setradio,")
				// .append(" A.fg_research,")
				// .append(" D.fg_propc,")
				.append(" A.ismuldose,")
				.append(" A.ismulexec,")
				// .append(" D.Fg_Selfsrv,")
			    .append(" A.fg_urgent,")//0179177: 医生开的加急的项目在护嘱界面不会显示出来，护嘱界面的加急没有勾选上。【南大项目】//修改：liyuelong 2019/12/5 注释放开
				// .append(" case when A.sd_srvtp like '0101%' then D.fg_selfpay
				// else case when A.fg_orhp='Y' then 'N' else 'Y' end end as
				// fg_selfpay,")
			    .append(" A.fg_skintest,")//0179177: 医生开的加急的项目在护嘱界面不会显示出来，护嘱界面的加急没有勾选上。【南大项目】//修改：liyuelong 2019/12/5 注释放开
				.append(" D.Id_dep_srv id_dep_or,")
				 .append(" D.fg_self,")
				.append(" A.fg_stop,")
				.append(" A.fg_pres_outp,")
				// .append(" C.fg_urgent_ip as Fg_urgent_edit,")
				// .append(" D.Eu_sourcemd,")
				.append(" A.Fg_sign,")
				.append(" A.Fg_chk,")
				// .append(" A.Fg_refusecheck,")
				.append(" A.Fg_canc,")
				.append(" A.Fg_uncancelable,")
				.append(" A.Fg_chk_canc,")
				.append(" A.Fg_chk_stop,")
				.append(" (case when A.fg_pres_outp='Y' then  '出院带药'")
				.append(" else KKKK.name  end")
				.append(" ) as Name_drugdeliverymethod, ")
				.append(" basemed.name Name_unit_cur,")
				// .append(" A.Eu_refusechecktp,")
				.append(" A.des_or note,")
				// .append(" A.error_level,")
				// .append(" A.error_des,")
				.append(" A.funcclassstr JsonDriver,")
				// .append(" A.Sv,")
				.append(" E.id_pgku_base id_unit_base,")
				.append(" E.id_pgku_cur id_unit_cur,")
				// .append(" D.sd_nodispense,")
				// .append(" D.id_nodispense,")
				.append(" (case")
				// .append(" when substr(A.sd_srvtp,0,4)='0101' then F.name
				// ||'('||F.spec||')'")
				.append(" when substr(A.sd_srvtp,0,4)='0101' then  F.spec")
				.append(" when substr(A.sd_srvtp,0,4)='0207' then  W.name")
				.append(" when substr(A.sd_srvtp,0,2)='04'   then  K.name")
				.append(" when substr(A.sd_srvtp,0,2)='03'   then  Z.name")
				// .append(" when substr(A.sd_srvtp,0,2)='02' then G.body_name")
				.append(" when substr(A.sd_srvtp,0,4)='1201' then  O.name")
				.append(" when substr(A.sd_srvtp,0,4)='1202' then  M.name")
				.append(" else '' end")
				.append(" ) as extend,")
				// .append(" (case")
				// .append(" when substr(A.sd_srvtp,0,4)='0101' then ''")
				// .append(" when substr(A.sd_srvtp,0,4)='0207' then
				// W.id_udidoc")
				// .append(" when substr(A.sd_srvtp,0,2)='04' then K.id_udidoc")
				// .append(" when substr(A.sd_srvtp,0,2)='03' then Z.id_udidoc")
				// // .append(" when substr(A.sd_srvtp,0,2)='02' then
				// G.id_body")
				// .append(" when substr(A.sd_srvtp,0,4)='1201' then O.id_dep")
				// .append(" when substr(A.sd_srvtp,0,4)='1202' then
				// M.id_udidoc")
				// .append(" else '' end")
				// .append(" ) as id_extend,")
				// .append(" (case")
				// .append(" when substr(A.sd_srvtp,0,4)='0101' then ''")
				// .append(" when substr(A.sd_srvtp,0,4)='0207' then W.code")
				// .append(" when substr(A.sd_srvtp,0,2)='04' then K.code")
				// .append(" when substr(A.sd_srvtp,0,2)='03' then Z.code")
				// // .append(" when substr(A.sd_srvtp,0,2)='02' then
				// G.sd_body")
				// .append(" when substr(A.sd_srvtp,0,4)='1201' then O.code")
				// .append(" when substr(A.sd_srvtp,0,4)='1202' then M.code")
				// .append(" else '' end) as sd_extend, ")
				// .append(" (case when A.sd_su_or='0' then A.id_emp_or")
				// .append(" else A.id_emp_sign end")
				// .append(" ) as id_emp_or ,")// id_emp_or
				.append(" (case when A.sd_su_or='0' then  R.name")
				.append(" else signpsn.name end")
				.append(" ) as name_emp_or, ")
				.append("D.eu_blmd, ")
				.append(" case when substr(C.sd_srvtp,0,2)='01' then ("+this.getOrdContentField() +") else '' end as ordcontent ")
				.append(" from ci_order A")
				.append(" left outer join ci_or_srv D on A.id_or = D.id_or")
				.append(" left outer join bd_srv C on D.id_srv = C.id_srv")
				.append(" left outer join bd_srv_drug DRUG on DRUG.id_srv = C.id_srv")
				.append(" left outer join ci_or_srv_mm E on D.id_orsrv = E.id_orsrv")
				.append(" left outer join bd_mm F on E.id_mm = F.id_mm")

				.append(" left outer join ci_ap_sug J on A.id_or = J.id_or")
				.append(" left outer join bd_udidoc K on J.id_anestp = K.id_udidoc")
				.append(" left outer join bd_udidoc KKKK on A.id_drugdeliverymethod = KKKK.id_udidoc")
				.append(" left outer join ci_ap_out L on A.id_or = L.id_or")
				.append(" left outer join bd_udidoc M on L.id_outtp = M.id_udidoc")
				.append(" left outer join ci_ap_trans N on A.id_or = N.id_or")
				.append(" left outer join bd_dep O on N.id_dep_to = O.id_dep")
				.append(" left outer join bd_freq P on D.id_freq = P.id_freq")
				.append(" left outer join bd_route Q on D.id_route = Q.id_route").append(this.getStrSql4Routedes())
				.append(" left outer join bd_psndoc R on A.id_emp_or = R.id_psndoc")
				.append(" left outer join bd_psndoc S on A.id_emp_stop = S.id_psndoc")
				.append(" left outer join bd_psndoc S1 on A.id_emp_chk = S1.id_psndoc")
				.append(" left outer join bd_psndoc S2 on A.id_emp_chk_stop = S2.id_psndoc")
				.append(" left outer join bd_dep T on D.id_dep_wh = T.id_dep")
				.append(" left outer join bd_dep U on D.id_dep_mp = U.id_dep")
				.append(" left outer join ci_ap_pathgy V on A.id_or = V.id_or")
				.append(" left outer join bd_udidoc W on V.id_samptp = W.id_udidoc")
				.append(" left outer join ci_ap_lab Y on A.id_or = Y.id_or")
				.append(" left outer join bd_udidoc Z on Y.id_samptp = Z.id_udidoc")
				.append(" left outer join bd_measdoc med on D.id_medu = med.id_measdoc")
				.append(" left outer join bd_psndoc signpsn on A.id_emp_sign = signpsn.id_psndoc")
				.append(" left outer join bd_measdoc basemed on basemed.id_measdoc = E.id_pgku_cur")
				.append(" where A.id_en =? and A.code_entp = ?  and A.eu_orsrcmdtp != ? ")
				.append(" and (A.eu_feereversetp is null or A.eu_feereversetp<>1) and D.Fg_or='Y'")
				.append(ICiDictCodeConst.SD_ORDSRCFUN_NUR.equals(ctx.getSd_orsrcfun())
						? " and ((A.fg_sign = 'Y' and (A.Sd_orsrcfun != '2' or A.Sd_orsrcfun is null or A.Sd_orsrcfun='')) or (A.Sd_orsrcfun = '2'))" : "");
		return sql;
	}
	private String getOrdContentField() throws BizException {
		
		String config=ParamsetQryUtil.getParaString(Context.get().getOrgId(),"CIOR0542");
		StringBuilder sb=new StringBuilder();
		String con="||";
		if(config!=null&&config.trim().length()>0) {
			String[] ss=config.split(",");
			int i=0;
			for (String s : ss) {
				if(s.equals(spec)) {
					sb.append("'['"+con+"F.spec"+con+"']'"+con);
				}
				if(s.equals(highrisk)) {
					String t=" (case when D.fg_highrisk='Y' then '高危 ' else '' end ) ";
					sb.append(t+con);
				}
				if(s.equals(srvname)) {
					sb.append(" C.name "+con);
				}
				if (s.equals(mmname)) {
					sb.append(" F.name "+con);
				}
			}
		}
		if(sb.length()==0) {
			sb.append(" F.spec ");
		}
		String tmp=sb.toString();
		int index=tmp.lastIndexOf(con);
		if(index>0)
		return sb.substring(0, index);
		return sb.toString();
	}
	//规格
	private static final String spec="0001";
	//高危
	private static final String highrisk="0002";
	//药品通用名
	private static final String srvname="0003";
	//药品商品名
	private static final String mmname="0004";
	/**
	 * 获取查询医嘱列表数据sql
	 * 
	 * @return
	 */
	private StringBuffer getOrderBy() throws BizException {
		String orderbyMode = ServiceFinder.find(ICiOrdQryService.class).getOrderSequenceMode();
		return new StringBuffer().append(" order by A.dt_effe asc").append(",nvl(A.sortno,0) asc")
				.append(",D.sortno asc");
	}

	/**
	 * 查询套内项目
	 * 
	 * @param condition
	 * @return
	 */
	private String getOrSetSql() {
		StringBuffer qry = new StringBuffer();
		qry.append(
				" select id_or,id_body,sd_body,body_name as name_body,id_srvset as id_srv from ci_or_srv_set where id_or = ? ");
		return qry.toString();
	}

	/**
	 * 查询套内项目基础数据
	 * 
	 * @return
	 */
	private String getSetSrvSql() {
		StringBuffer qry = new StringBuffer();
		qry.append(
				" select d.id_srv,d.name as name_srv,a.fg_edit,b.id_body,b.sd_body,c.name as name_body,b.id_pos,b.sd_pos,e.name as name_pos")
				.append(" from bd_srvset_def a left outer join bd_srv_obs b on a.id_srv_itm = b.id_srv ")
				.append(" left outer join bd_udidoc c on b.id_body = c.id_udidoc ")
				.append(" left outer join bd_srv d on a.id_srv_itm = d.id_srv")
				.append(" left outer join bd_udidoc e on b.id_pos = e.id_udidoc")
				.append(" where a.id_srv = ? and a.fg_clinical = 'Y' and a.ds = 0");
		return qry.toString();
	}

	/**
	 * 设置执行科室信息
	 * 
	 * @param ctx
	 * @param medSrv
	 * @param orderListViewDTO
	 * @throws BizException
	 */
	private void setOrWfDeptInfo(CiEnContextDTO ctx, MedSrvDO medSrv, OrderListViewDTO orderListViewDTO)
			throws BizException {
		// 基础数据服务对象为空时候不做任务处理
		if (null == medSrv) {
			orderListViewDTO.setError_level("E");
			orderListViewDTO
					.setError_des(String.format("计算执行科室过滤条件时候，查询服务（%s）定义在数据库中不存在", orderListViewDTO.getId_srv()));
			return;
		}
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ctx, medSrv.getId_srv(), orderListViewDTO.getId_mm(),orderListViewDTO.getId_route(),null,
				orderListViewDTO.getFg_long(), ctx.getFg_pres_outp(),orderListViewDTO.getDt_effe());
		if (!CiOrdUtils.isEmpty(wf)) {
			// 非物品没有物质科室
			if (FBoolean.TRUE.equals(medSrv.getFg_mm())) {
				orderListViewDTO.setFilter_dep_wh(wf.getId_dept_whs());// 物资仓库过滤条件
			}

			orderListViewDTO.setFilter_dep_mp("1".equals(wf.getMp_source()) ? null : wf.getId_mp_depts());// 执行科室过滤条件
		}
	}

	/**
	 * 获取用法要求SQL
	 * 
	 * @return
	 */
	private String getStrSql4Routedes() {
		String paramDosage = SysParamUtils.getSysParam().getSYS_PARAM_IntravenousDrugCreateMode().getOrgParam();
		if (ICiOrdNSysParamConst.SYS_PARAM_IntravenousDrugCreateMode_Route.equals(paramDosage)) {
			return " left outer join bd_route Q1 on D.id_routedes = Q1.id_route";
		} else {
			return " left outer join bd_route_des Q1 on D.id_routedes = Q1.id_routedes";
		}
	}

	/**
	 * 设置用法
	 * 
	 * @param orderListViewDTOs
	 */
	private void setSrvRoutedesInfo(List<OrderListViewDTO> orderListViewDTOs) {
		// CIOR0380 入壶类药品成组开单模式,参数值:0 用法开单,1用法要求开单
		String paramDosage = SysParamUtils.getSysParam().getSYS_PARAM_IntravenousDrugCreateMode().getOrgParam();
		if (ICiOrdNSysParamConst.SYS_PARAM_IntravenousDrugCreateMode_Route.equals(paramDosage)) {
			for (OrderListViewDTO orderListViewDTO : orderListViewDTOs) {
				// 成组药，非第一味药，用法要求不为空，则将用法ID赋回
				if (orderListViewDTO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG)
						&& StringUtils.isNotEmpty(orderListViewDTO.getId_routedes_srv())) {
					orderListViewDTO.setId_route(orderListViewDTO.getId_routedes_srv());// 用法ID
					orderListViewDTO.setName_route(orderListViewDTO.getName_routedes_srv());// 用法
				}
			}
		}
	}

	/**
	 * 设置医嘱显示状态
	 * 
	 * @param orderList
	 */
	private void setOrderStatus(List<OrderListViewDTO> orderList) {
		for (OrderListViewDTO order : orderList) {
			if (ICiDictCodeConst.SD_SU_OPEN.equals(order.getSd_su_or())) {
				order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_OPEN);// 开立
			} else if (ICiDictCodeConst.SD_SU_SIGN.equals(order.getSd_su_or())) {
				order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_SIGN);// 签署
				if (CiOrdUtils.isTrue(order.getFg_refusecheck())
						&& RefuseCheckTp.REFUSE_SIGN_CHECK.equals(order.getEu_refusechecktp())) {
					// 设置拒绝确认医嘱状态
					order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_SIGN + RefuseCheckTp.REFUSE_SIGN_CHECK);// 签署
				}
			} else if (ICiDictCodeConst.SD_SU_CHECKTHROUGH.equals(order.getSd_su_or())) {
				if (ICiDictCodeConst.SD_SU_MP_NONE.equals(order.getSd_su_mp())) {
					if (FBoolean.FALSE.equals(order.getFg_stop()) || FBoolean.TRUE.equals(order.getFg_pres_outp())) {
						// 出院带药不需要预停操作
						order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_CHECKTHROUGH);// 确认

					} else if (FBoolean.TRUE.equals(order.getFg_stop())) {
						order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_22);// 确认预停
						if (CiOrdUtils.isTrue(order.getFg_refusecheck())
								&& RefuseCheckTp.REFUSE_STOP_CHECK.equals(order.getEu_refusechecktp())) {
							// 设置拒绝确认医嘱状态 201
							order.setSd_su_or_ext(
									ICiDictCodeConst.SD_SU_CHECKTHROUGH + RefuseCheckTp.REFUSE_STOP_CHECK);// 签署
						}
					} else {
						order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_11);// 未知
					}
				} else if (ICiDictCodeConst.SD_SU_MP_PERFORMED.equals(order.getSd_su_mp())) {
					if (FBoolean.FALSE.equals(order.getFg_stop())) {
						order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_21);// 执行中

					} else if (FBoolean.TRUE.equals(order.getFg_stop())) {
						order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_23);// 预停
						// 是否 护士拒绝停止确认
						if (CiOrdUtils.isTrue(order.getFg_refusecheck())
								&& RefuseCheckTp.REFUSE_STOP_CHECK.equals(order.getEu_refusechecktp())) {
							// 设置拒绝确认医嘱状态 231
							order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_23 + RefuseCheckTp.REFUSE_STOP_CHECK);// 签署
						}
					} else {
						order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_11);// 未知
					}
				} else {
					order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_11);// 未知
				}
			} else if (ICiDictCodeConst.SD_SU_CHECKSTOP.equals(order.getSd_su_or())) {
				if (FBoolean.TRUE.equals(order.getFg_stop())) {
					if (ICiDictCodeConst.SD_SU_MP_NONE.equals(order.getSd_su_mp())) {
						order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_CHECKSTOP);

					} else if (ICiDictCodeConst.SD_SU_MP_PERFORMED.equals(order.getSd_su_mp())) {
						order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_51);
					} else {
						order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_11);// 未知
					}
				} else {
					order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_11);// 未知
				}
			} else if (ICiDictCodeConst.SD_SU_FINISH.equals(order.getSd_su_or())) {
				if (ICiDictCodeConst.SD_SU_MP_EXEOK.equals(order.getSd_su_mp())) {
					order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_FINISH);// 完成
				} else if (ICiDictCodeConst.SD_SU_MP_EXECANC.equals(order.getSd_su_mp())) {
					order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_61);// 取消
				} else if (ICiDictCodeConst.SD_SU_MP_CANCEL.equals(order.getSd_su_mp())) {
					order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_62);// 不执行
				} else {
					order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_11);// 未知
				}
			} else if (ICiDictCodeConst.SD_SU_CANCEL.equals(order.getSd_su_or())) {
				order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_CANCEL);// 作废
				// 是否 护士拒绝停止确认
				if (CiOrdUtils.isTrue(order.getFg_refusecheck())
						&& RefuseCheckTp.REFUSE_CANC_CHECK.equals(order.getEu_refusechecktp())) {
					// 设置拒绝确认医嘱状态 702
					order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_CANCEL + RefuseCheckTp.REFUSE_CANC_CHECK);// 签署
				}
			} else if (ICiDictCodeConst.SD_SU_CHECKCANCEL.equals(order.getSd_su_or())) {
				order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_CHECKCANCEL);// 作废确认
			} else {
				order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_11);// 未知
			}
		}
	}
	/**
	 * 医学单位的剂量，转换为基本包装单位的剂量,换算系数为1或者换算后为整数时换算
	 * @param quan_med
	 * @param factor_mb
	 * @return
	 */
	private void getBaseQuanMedu(OrderListViewDTO orderListViewDTO){
//		if(new FDouble(1).compareTo(orderListViewDTO.getFactor_mb())==0){
//			//只需要把单位修改一下
//			orderListViewDTO.setId_medu_cur(orderListViewDTO.getId_unit_base());
//			orderListViewDTO.setName_medu_cur(orderListViewDTO.getName_unit_base());
//		}else{
//			int[] numben=OrSrvSplitUtil.getNumDen(orderListViewDTO.getQuan_med(), orderListViewDTO.getFactor_mb());
//			if(numben[0]%numben[1]==0){
//				orderListViewDTO.setQuan_medu_cur(new FDouble(numben[0]).div(new FDouble(numben[1])));
//				orderListViewDTO.setId_medu_cur(orderListViewDTO.getId_unit_base());
//				orderListViewDTO.setName_medu_cur(orderListViewDTO.getName_unit_base());
//			}
//		}
	}
}
