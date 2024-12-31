package iih.ci.sdk.dept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.fc.i.IBdFcQryService;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.wf.d.EnumFlow;
import iih.ci.ems.b.BaseEmsViewDTO;
import iih.ci.ems.b.BaseOrderListViewDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.sdk.cache.BDDeptInfoCache;
import iih.ci.sdk.utils.CiOrdAppUtils;
import iih.ci.sdk.utils.ObjectUtils;
import iih.ci.sdk.utils.SysParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @author wangqingzhu
 *
 * @date 2019年12月6日下午2:42:58
 *
 * @classpath iih.ci.sdk.dept.GetWhOrExeDeptBP
 *
 *            写明类文件描述
 * 
 */
public class GetWhOrExeDeptBP {

	/**
	 * 调用逻辑，主要用来计算执行科室和物资流向科室信息，该方法为批量方法，性能依赖于执行域提供的流向接口
	 * 
	 * @param ctx
	 * @param szSrvInfo
	 * @param wftp
	 * @return
	 * @throws BizException
	 */
	public Map<String, WhOrExeDeptInfo> exec(CiEnContextDTO ctx, BaseOrderListViewDTO[] szSrvInfo, int wftp)
			throws BizException {

		return exec(ctx.getCode_entp(), ctx.getId_dep_or(), ctx.getId_dep_en(), ctx.getId_dep_ns(), szSrvInfo, wftp);
	}

	/**
	 * 调用逻辑，主要用来计算执行科室和物资流向科室信息，该方法为批量方法，性能依赖于执行域提供的流向接口
	 * 
	 * @param code_entp
	 * @param id_dep_or
	 * @param id_dep_en
	 * @param ide_dep_ns
	 * @param szSrvInfo
	 * @param tp
	 *            < 0 表示 计算执行科室；0 表示 执行科室和物资科室；>0 表示物资科室
	 * @return
	 * @throws BizException
	 */
	public Map<String, WhOrExeDeptInfo> exec(String code_entp, String id_dep_or, String id_dep_en, String id_dep_ns,
			BaseOrderListViewDTO[] szSrvInfo, int wftp) throws BizException {
		Map<String, WhOrExeDeptInfo> rstMap = new HashMap<>();
		List<BaseOrderListViewDTO> followList = new ArrayList<>();
		List<BaseOrderListViewDTO> fdList = new ArrayList<>();
		// 1、分拣出不需要计算执行科室的服务
		if (EnumFlow.EXECUTEFLOW.equals(wftp)) {
			for (BaseOrderListViewDTO srv : szSrvInfo) {
				// 流向就诊科室的
				if (srv.getDept_MpMd().equals(IBdSrvDictCodeConst.SD_ORTMPLTP_PVDEPT)) {
					WhOrExeDeptInfo info = new WhOrExeDeptInfo();
					info.setId_dep_mp(id_dep_en);
					info.setName_dep_mp(BDDeptInfoCache.GetNameOfBDeptInfo(id_dep_en));
					info.setFilter_dep_mp(id_dep_en);
					rstMap.put(srv.getId_srv(), info);
				} else if (srv.getDept_MpMd().equals(IBdSrvDictCodeConst.SD_ORTMPLTP_PVWARD)) {
					WhOrExeDeptInfo info = new WhOrExeDeptInfo();
					info.setId_dep_mp(id_dep_ns);
					info.setName_dep_mp(BDDeptInfoCache.GetNameOfBDeptInfo(id_dep_ns));
					info.setFilter_dep_mp(id_dep_ns);
					rstMap.put(srv.getId_srv(), info);
				} else if (srv.getDept_MpMd().equals(IBdSrvDictCodeConst.SD_ORTMPLTP_ORDEPT)) {
					WhOrExeDeptInfo info = new WhOrExeDeptInfo();
					info.setId_dep_mp(id_dep_or);
					info.setName_dep_mp(BDDeptInfoCache.GetNameOfBDeptInfo(id_dep_or));
					info.setFilter_dep_mp(id_dep_or);
					rstMap.put(srv.getId_srv(), info);
				} else if (srv.getDept_MpMd().equals(IBdSrvDictCodeConst.SD_ORTMPLTP_CONSTDEPT)) {
					// WhOrExeDeptInfo info = new WhOrExeDeptInfo();
					// info.setId_dep_mp(id_dep_or);
					// info.setName_dep_mp(BDDeptInfoCache.GetNameOfBDeptInfo(id_dep_or));
					// info.setFilter_dep_mp(id_dep_or);
					// rstMap.put(srv.getId_srv(), info);
				} else if (srv.getDept_MpMd().equals(IBdSrvDictCodeConst.SD_ORTMPLTP_WITHSRVSET)) {
					followList.add(srv);
				} else if (srv.getDept_MpMd().equals(IBdSrvDictCodeConst.SD_ORTMPLTP_ORWFMD)) {
					fdList.add(srv);
				}
			}
		} else {
			// 分拣符合计算物资流向服务数据
			for (BaseOrderListViewDTO srv : szSrvInfo) {
				if (ObjectUtils.isTrue(srv.getFg_mm())) {
					fdList.add(srv);
				}
			}
		}
		// 2、构建计算执行科室参数集合
		OrWfExDeptParamDTO[] szOrWfExDeptParamDTO = null;
		if (!ObjectUtils.isEmpty(fdList)) {
			szOrWfExDeptParamDTO = orWfExDeptParamWith(code_entp, id_dep_or, id_dep_en, id_dep_ns,
					fdList.toArray(new BaseOrderListViewDTO[1]), wftp);
		}
		// 3、调用执行接口
		OrWfExDeptParamDTO[] szRstInfo = null;
		if (!ObjectUtils.isEmpty(szOrWfExDeptParamDTO)) {
			szRstInfo = ServiceFinder.find(IBdFcQryService.class).getBatchOrExDeptMainBP(szOrWfExDeptParamDTO);
		}
		// 4、按照临床参数处理返回值结果集合
		if (!ObjectUtils.isEmpty(szRstInfo)) {
			for (OrWfExDeptParamDTO srv : szRstInfo) {
				// 没有匹配到执行科室或者物资流向科室时候，进行临床参数处理，并根据参数设置进行默认值处理
				if (ObjectUtils.isEmpty(srv.getRes())) {
					// 如果没有匹配到医嘱流向中的配置数据，则检查是否启用了临床执行科室参数
					if ((EnumFlow.NULL.equals(wftp) || EnumFlow.EXECUTEFLOW.equals(wftp)) && "1".equals(
							SysParamUtils.getSysParam().getSYS_PARAM_CiOrExFlowDeptHandleMode().getOrgParam())) {

						// 默认科室的取值参数
						String paramValue = SysParamUtils.getSysParam().getSYS_PARAM_CiOrExFlowDefaultDeptSet4Ip()
								.getOrgParam();
						// 默认就诊科室
						if ("0".equals(paramValue)) {

							WhOrExeDeptInfo info = new WhOrExeDeptInfo();
							info.setId_dep_mp(id_dep_en);
							info.setName_dep_mp(BDDeptInfoCache.GetNameOfBDeptInfo(id_dep_en));
							info.setFilter_dep_mp(id_dep_en);
							rstMap.put(srv.getId_srv(), info);
						}
						// 默认开单科室
						else if ("1".equals(paramValue)) {
							WhOrExeDeptInfo info = new WhOrExeDeptInfo();
							info.setId_dep_mp(id_dep_or);
							info.setName_dep_mp(BDDeptInfoCache.GetNameOfBDeptInfo(id_dep_or));
							info.setFilter_dep_mp(id_dep_or);
							rstMap.put(srv.getId_srv(), info);
						}
						// 默认病区
						else if ("2".equals(paramValue)) {
							WhOrExeDeptInfo info = new WhOrExeDeptInfo();
							info.setId_dep_mp(id_dep_ns);
							info.setName_dep_mp(BDDeptInfoCache.GetNameOfBDeptInfo(id_dep_ns));
							info.setFilter_dep_mp(id_dep_ns);
							rstMap.put(srv.getId_srv(), info);
						}

					}
				}
				else
				{
					// 返回了执行科室
					FArrayList exeWfDeptList = srv.getRes();
					for(Object objWfInfo : exeWfDeptList) {
						// 转换为流向科室对象类型
						OrWfExDeptDTO info = (OrWfExDeptDTO)objWfInfo;
						
					}
					 
				}
			}
		}
		// 5、组织map字典返回值对象

		return rstMap;
	}

	/**
	 * 组建参数集合
	 *  
	 * @param code_entp
	 * @param id_dep_or
	 * @param id_dep_en
	 * @param id_dep_ns
	 * @param szSrvInfo
	 * @param tp
	 * @return
	 */
	protected OrWfExDeptParamDTO[] orWfExDeptParamWith(String code_entp, String id_dep_or, String id_dep_en,
			String id_dep_ns, BaseOrderListViewDTO[] szSrvInfo, int wftp) {
		if (ObjectUtils.isEmpty(szSrvInfo)) {
			return null;
		}
		List<OrWfExDeptParamDTO> rstList = new ArrayList<>();
		for (BaseEmsViewDTO srv : szSrvInfo) {
			OrWfExDeptParamDTO rst = new OrWfExDeptParamDTO();
			rstList.add(rst);
			/**
			 * 就诊类型编码
			 * 
			 * @param Code_entp
			 */
			rst.setCode_entp(code_entp);
			/**
			 * 服务类型编码
			 * 
			 * @param Sd_srvtp
			 */
			rst.setSd_srvtp(srv.getSd_srvtp());

			/**
			 * 服务分类
			 * 
			 * @param Id_srvca
			 */
			rst.setId_srvca(srv.getId_srvca());

			/**
			 * 用法
			 * 
			 * @param Id_usage
			 */
			rst.setId_usage(srv.getId_route());

			/**
			 * 长期临时
			 * 
			 * @param Recurstr
			 */
			rst.setRecurstr(ObjectUtils.isTrue(srv.getFg_long()) ? "1" : "0");

			/**
			 * 星期数
			 * 
			 * @param Weekno
			 */
			rst.setWeekno(CiOrdAppUtils.getServerDateTime().getWeek() + "");

			/**
			 * 时间
			 * 
			 * @param Timestr
			 */
			rst.setTimestr(null == srv.getDt_effe() ? new FTime() : srv.getDt_effe().getUFTime());

			/**
			 * 服务
			 * 
			 * @param Id_srv
			 */
			rst.setId_srv(srv.getId_srv());

			/**
			 * 物品
			 * 
			 * @param Id_mm
			 */
			rst.setId_mm(srv.getId_mm());

			/**
			 * 就诊科室
			 * 
			 * @param Id_dept_en
			 */
			rst.setId_dept_en(id_dep_en);

			/**
			 * 护理单元
			 * 
			 * @param Id_dept_ns
			 */
			rst.setId_dept_ns(id_dep_ns);

			/**
			 * 开立科室
			 * 
			 * @param Id_dept_or
			 */
			rst.setId_dept_or(id_dep_or);

			/**
			 * 主执行科室
			 * 
			 * @param Id_dept_ex
			 */
			rst.setId_dept_ex(null);

			/**
			 * 服务分类内码
			 * 
			 * @param Innercode_srvca
			 */
			rst.setInnercode_srvca(null);

			/**
			 * 流向类型
			 * 
			 * @param Eu_wftp
			 */
			rst.setEu_wftp(wftp);

			/**
			 * 药品剂型
			 * 
			 * @param Id_dosage
			 */
			rst.setId_dosage(srv.getId_dosage());

			/**
			 * 出院带药标识
			 * 
			 * @param Fg_pres_outp
			 */
			rst.setFg_pres_outp(srv.getFg_pres_outp());

			/**
			 * 毒麻类型
			 * 
			 * @param Sd_pois
			 */
			rst.setSd_pois(srv.getSd_pois());

			/**
			 * 草药剂型
			 * 
			 * @param Sd_herbpreparationtp
			 */
			rst.setSd_herbpreparationtp(null);

			/**
			 * 是否校验医嘱内容
			 * 
			 * @param Code_entp
			 */
			rst.setFg_chk_or(null);
		}

		return rstList.toArray(new OrWfExDeptParamDTO[1]);
	}
}
