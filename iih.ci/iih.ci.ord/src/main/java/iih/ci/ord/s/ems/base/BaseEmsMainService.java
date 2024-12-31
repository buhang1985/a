package iih.ci.ord.s.ems.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.srv.ems.d.SrvMatchEmsParamDTO;
import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.bd.srv.ems.i.IEmsManagementService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.common.EmsDriverInfo;
import iih.ci.ord.i.error.StackPointDTO;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.i.meta.EmsSaveDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.meta.EmsRstInfoList;
import iih.ci.ord.s.ems.utils.ReflClassUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 医疗单后台服务业务逻辑处理基类，主要完成医疗单匹配业务逻辑
 * 
 * @author wangqingzhu
 *
 */
public class BaseEmsMainService extends BaseEmsDriverDecode {

	/**
	 * 匹配医疗单并创建相关医疗单数据
	 * 
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	protected EmsRstDTO[] matchLoadEmsDriver(CiEnContextDTO ctx, EmsLoadDTO[] emsarray) throws BizException {

		// 有效性判断
		if (CiOrdUtils.isEmpty(ctx) || CiOrdUtils.isEmpty(emsarray)) {
			return null;
		}

		// 定义返回值集合对象
		EmsRstInfoList rstInfoList = new EmsRstInfoList();

		// 定义缺失驱动信息医嘱结合
		List<EmsLoadDTO> containDriverInfoList = new ArrayList<EmsLoadDTO>();
		List<EmsLoadDTO> unContainDriverInfoList = new ArrayList<EmsLoadDTO>();

		// 对批量打开医疗单的请求参数进行分拣，根据包含驱动信息和不包含驱动信息为依据进行分堆处理
		for (EmsLoadDTO loadInfo : emsarray) {
			// 如果没有给定驱动信息的时候，将加载医疗单参数对象放到后续处理集合中
			if (CiOrdUtils.isEmpty(loadInfo.getDriverInfo()) || CiOrdUtils.isEmpty(loadInfo.getDriverInfo().getDll())
					|| CiOrdUtils.isEmpty(loadInfo.getDriverInfo().getEmsFrontDriver())
					|| CiOrdUtils.isEmpty(loadInfo.getDriverInfo().getJar())
					|| CiOrdUtils.isEmpty(loadInfo.getDriverInfo().getEmsBackendDriver())) {
				unContainDriverInfoList.add(loadInfo);
			} else {
				containDriverInfoList.add(loadInfo);
			}

		}

		// 处理医嘱包含驱动信息的业务逻辑
		rstInfoList.addAll(loadContainsEmsDriverInfo(ctx, containDriverInfoList));

		// 处理医嘱不包含驱动的业务逻辑
		rstInfoList.addAll(loadUnContainsEmsDriverInfo(ctx, unContainDriverInfoList));

		return rstInfoList.size() == 0 ? null : rstInfoList.asArray();
	}

	/**
	 * 处理请求信息中包含了医疗单驱动信息的业务逻辑
	 * 
	 * @param ctx
	 * @param lst
	 * @return
	 * @throws BizException
	 */
	private EmsRstInfoList loadContainsEmsDriverInfo(CiEnContextDTO ctx, List<EmsLoadDTO> lst) throws BizException {

		// 定义返回值集合对象
		EmsRstInfoList rstInfoList = new EmsRstInfoList();
		if (CiOrdUtils.isEmpty(lst)) {
			return rstInfoList;
		}
		for (EmsLoadDTO loadInfo : lst) {
			EmsRstDTO rstInfo = emsLoadFromDriver(ctx, loadInfo);
			rstInfo.getDriverInfo().setId_ems(loadInfo.getDriverInfo().getId_ems());
			rstInfo.getDriverInfo().setFg_quickwflow(loadInfo.getDriverInfo().getFg_quickwflow());
			rstInfoList.add(rstInfo);
		}
		return rstInfoList;
	}

	/**
	 * 处理请求信息中不包含医疗单驱动信息的业务逻辑
	 * 
	 * @param ctx
	 * @param lst
	 * @return
	 * @throws BizException
	 */
	private EmsRstInfoList loadUnContainsEmsDriverInfo(CiEnContextDTO ctx, List<EmsLoadDTO> lst) throws BizException {
		// 定义返回值集合对象
		EmsRstInfoList rstInfoList = new EmsRstInfoList();
		if (CiOrdUtils.isEmpty(lst)) {
			return rstInfoList;
		}

		Map<String, EmsLoadDTO> tmpIdOrderLoadInfoCache = new HashMap<String, EmsLoadDTO>();

		// 获取当前给定医嘱的基本服务信息
		StringBuilder sb = new StringBuilder();
		for (EmsLoadDTO loadInfo : lst) {
			sb.append(",'").append(loadInfo.getId_or()).append("'");
			tmpIdOrderLoadInfoCache.put(loadInfo.getId_or(), loadInfo);
		}

		// 查询医嘱关键信息
		List<CiOrderDO> orderInfoList = (List<CiOrderDO>) new DAFacade().execQuery(String.format(
				"select id_or, id_srv, sd_srvtp, Id_srvof, Funcclassstr from ci_order where id_or in (%s)",
				sb.substring(1)), new BeanListHandler(CiOrderDO.class));

		// 先根据存储的驱动尝试反射调用（Funcclassstr）
		// 其次，根据Id_srvof 医疗单id去直接查询出医疗单驱动
		// 最后才会根据医疗单匹配接口获取医疗单驱动
		// 组织医疗单驱动匹配入参对象
		IEmsManagementService emsManagementService = ServiceFinder.find(IEmsManagementService.class);

		for (CiOrderDO orderInfo : orderInfoList) {
			// 匹配医疗单
			SrvMatchEmsParamDTO srvMatchEmsParamDTO = srvMatchEmsParamFrom(ctx, orderInfo.getId_srv(),
					orderInfo.getSd_srvtp());

			// 调用接口进行当前医嘱的医疗单匹配
			FMap rstMap = emsManagementService.medSrvMatchEms(new SrvMatchEmsParamDTO[] { srvMatchEmsParamDTO });
			if (null != rstMap && rstMap.size() > 0) {

				// 解析医疗单结构
				SrvMatchEmsRstDTO rstMatchInfo = (SrvMatchEmsRstDTO) rstMap.get(orderInfo.getId_srv());

				// 有效性判断，是否存在医嘱id-load这样的映射关系（必须存在，不存在则错误）
				if (tmpIdOrderLoadInfoCache.containsKey(orderInfo.getId_or())) {
					EmsLoadDTO loadInfo = tmpIdOrderLoadInfoCache.get(orderInfo.getId_or());
					loadInfo.getDriverInfo().setJsonDriver(rstMatchInfo.getFuncclassstr());
					EmsRstDTO rstInfo = emsLoadFromDriver(ctx, loadInfo);
					rstInfo.getDriverInfo().setId_ems(rstMatchInfo.getId_ems());
					rstInfo.getDriverInfo().setFg_quickwflow(rstMatchInfo.getFg_quickwflow());
					rstInfoList.add(rstInfo);
				}

			}

		}
		return rstInfoList;
	}

	/**
	 * 
	 * @param ctx
	 * @param loadInfo
	 * @return
	 * @throws BizException
	 */
	private EmsRstDTO emsLoadFromDriver(CiEnContextDTO ctx, EmsLoadDTO loadInfo) throws BizException {

		// 解析驱动信息
		EmsDriverInfo driverInfo = this.parseJsonDriver(loadInfo.getDriverInfo().getJsonDriver());
		if (null != driverInfo && !CiOrdUtils.isEmpty(driverInfo.getEmsBackendDriver())) {

			driverInfo.setFg_quickwflow(loadInfo.getDriverInfo().getFg_quickwflow());
			// 设置后台驱动描述
			loadInfo.setDriverInfo(driverInfo);
			// 反射调用医疗单加载方法
			EmsRstDTO[] rstInfos = ReflClassUtils.ReflCallWith(driverInfo.getEmsBackendDriver(), "load", ctx,
					EmsLoadDTO[].class, new EmsLoadDTO[] { loadInfo });

			// 组装返回值结构中的驱动信息
			if (rstInfos != null && rstInfos.length == 1) {
				rstInfos[0].setDriverInfo(driverInfo);
				return rstInfos[0];
			}

		}
		return null;
	}

	/**
	 * 匹配创建医疗单
	 * 
	 * @param ctx
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	protected EmsRstDTO[] matchCreateEmsDriver(CiEnContextDTO ctx, EmsCrtDTO[] szCreateParams) throws BizException {
		// 有效性判断
		if (CiOrdUtils.isEmpty(ctx) || CiOrdUtils.isEmpty(szCreateParams)) {
			return null;
		}

		// 定义返回值集合对象
		return new EmsRstInfoList(createUnContainsEmsDriverInfo(ctx, Arrays.asList(szCreateParams))).asArray();
	}

	/**
	 * 处理创建医疗单模型时候，不包含医疗单驱动信息的业务逻辑（执行 医疗单服务匹配算法）
	 * 
	 * @param ctx
	 * @param lst
	 * @return
	 * @throws BizException
	 */
	private EmsRstInfoList createUnContainsEmsDriverInfo(CiEnContextDTO ctx, List<EmsCrtDTO> lst) throws BizException {
		// 定义返回值集合对象
		EmsRstInfoList rstInfoList = new EmsRstInfoList();
		if (CiOrdUtils.isEmpty(ctx) || null == lst || lst.size() == 0) {
			return rstInfoList;
		}

		EmsCrtDTO createInfo = lst.get(0);
		IEmsManagementService emsManagementService = ServiceFinder.find(IEmsManagementService.class);

		// 调用匹配医疗单算法服务
		FMap rstMap = emsManagementService.medSrvMatchEms(new SrvMatchEmsParamDTO[] {
				srvMatchEmsParamFrom(ctx, createInfo.getId_srv(), createInfo.getSd_srvtp()) });

		// 进行匹配结果有效性验证
		if (null != rstMap && rstMap.size() > 0) {

			// 根据服务id获取医疗单匹配信息
			SrvMatchEmsRstDTO rstMatchInfo = (SrvMatchEmsRstDTO) rstMap.get(createInfo.getId_srv());
			if(rstMatchInfo == null){
				throw new BizException("服务未匹配上医嘱单，请在医疗单维护中配置");
			}
			rstInfoList.addAll(emsCreateFromDriver(ctx, lst, rstMatchInfo));
		}
		return rstInfoList;
	}

	/**
	 * 执行反射调用处理创建医疗单模型对象
	 * 
	 * @param ctx
	 * @param lst
	 * @return
	 * @throws BizException
	 */
	private EmsRstInfoList emsCreateFromDriver(CiEnContextDTO ctx, List<EmsCrtDTO> lst, SrvMatchEmsRstDTO rstMatchInfo)
			throws BizException {

		// 定义返回值集合对象
		EmsRstInfoList rstInfoList = new EmsRstInfoList();

		// 获取前后台医疗单业务处理服务信息
		EmsDriverInfo driverInfo = new EmsDriverInfo(rstMatchInfo);
		if (driverInfo.isValid()) {

			// 设置后台驱动信息
			for (EmsCrtDTO createInfo : lst) {
				createInfo.setDriverInfo(driverInfo);
			}

			// 反射方式，调用医疗单创建逻辑
			EmsRstDTO[] rstInfos = ReflClassUtils.ReflCallWith(driverInfo.getEmsBackendDriver(), "create", ctx,
					EmsCrtDTO[].class, lst.toArray(new EmsCrtDTO[lst.size()]));

			// 设置医疗单返回值的驱动信息
			for (EmsRstDTO rstInfo : rstInfos) {
				rstInfo.setDriverInfo(driverInfo);
				rstInfoList.add(rstInfo);
			}

		}
		return rstInfoList;
	}

	private EmsRstInfoList emsCreateFromDriver(CiEnContextDTO ctx, List<EmsCrtDTO> lst, String id_ems,
			FBoolean fg_qucikwflow) throws BizException {

		// 定义返回值集合对象
		EmsRstInfoList rstInfoList = new EmsRstInfoList();

		// 获取前后台医疗单业务处理服务信息
		EmsDriverInfo driverInfo = parseJsonDriver(lst.get(0).getDriverInfo().getJsonDriver());
		if (null != driverInfo && !CiOrdUtils.isEmpty(driverInfo.getEmsBackendDriver())) {

			// 设置后台驱动信息
			for (EmsCrtDTO createInfo : lst) {
				createInfo.setDriverInfo(driverInfo);
				createInfo.getDriverInfo().setJsonDriver(lst.get(0).getDriverInfo().getJsonDriver());
			}

			// 反射方式，调用医疗单创建逻辑
			EmsRstDTO[] rstInfos = ReflClassUtils.ReflCallWith(driverInfo.getEmsBackendDriver(), "create", ctx,
					EmsCrtDTO[].class, lst.toArray(new EmsCrtDTO[lst.size()]));

			// 设置医疗单返回值的驱动信息
			for (EmsRstDTO rstInfo : rstInfos) {
				rstInfo.setDriverInfo(driverInfo);
				rstInfoList.add(rstInfo);
			}

		}
		return rstInfoList;
	}

	/**
	 * 匹配保存医疗单
	 * 
	 * @param ctx
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	protected EmsRstDTO matchSaveEmsDriver(CiEnContextDTO ctx, EmsSaveDTO ems) throws BizException {
		if (!ems.getDriverInfo().isValid() && !StringUtils.isEmpty(ems.getDriverInfo().getJsonDriver())) {
			ems.setDriverInfo(parseJsonDriver(ems.getDriverInfo().getJsonDriver()));
		}

		EmsRstDTO[] szRstInfo = ReflClassUtils.ReflCallWith(ems.getDriverInfo().getEmsBackendDriver(), "save", ctx,
				EmsSaveDTO[].class, new EmsSaveDTO[] { ems });
		return szRstInfo[0];
	}

	/**
	 * 断点调用保存（有待改善，根据业务需要，后台所有的逻辑都可以支持断点逻辑）
	 * 
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	protected EmsRstDTO doStackPoint(CiEnContextDTO ctx, EmsSaveDTO ems) throws BizException {
		for (Object objInfo : ems.getDocument()) {
			StackPointDTO spd = (StackPointDTO) objInfo;

			return ReflClassUtils.ReflCallWith(spd.getCallback(), "save", ctx, EmsSaveDTO[].class,
					new EmsSaveDTO[] { ems });
		}
		return null;
	}

	/**
	 * 组建医疗单匹配数据结构
	 * 
	 * @param ctx
	 * @param id_srv
	 * @param sd_srvtp
	 * @return
	 */
	private SrvMatchEmsParamDTO srvMatchEmsParamFrom(CiEnContextDTO ctx, String id_srv, String sd_srvtp) {
		SrvMatchEmsParamDTO srvMatchEmsParamDTO = new SrvMatchEmsParamDTO();
		srvMatchEmsParamDTO.setId_srv(id_srv);
		srvMatchEmsParamDTO.setCode_entp(ctx.getCode_entp());
		srvMatchEmsParamDTO.setId_emp(ctx.getId_emp_or());
		srvMatchEmsParamDTO.setId_dept(ctx.getId_dep_or());
		srvMatchEmsParamDTO.setId_org(ctx.getId_org());
		srvMatchEmsParamDTO.setId_grp(ctx.getId_grp());
		srvMatchEmsParamDTO.setSd_srvtp(sd_srvtp);
		srvMatchEmsParamDTO.setDt_or(CiOrdAppUtils.getServerDateTime());
		srvMatchEmsParamDTO.setEmsappmode(ctx.getEmsappmode());
		return srvMatchEmsParamDTO;
	}

}
