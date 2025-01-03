package iih.ci.ord.s.ems.third;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.wf.d.EnumFlow;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.i.third.ThirdRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.DateUtils;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ci.ord.s.bp.CiOrEventsDeleteBP;
import iih.ci.ord.s.bp.validate.tl.OrSrvDoctorRtValidateBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.sie.common.utils.StringUtils;
import xap.sys.appfw.businessevent.IEventType;

public class MpOrderFeeAction {
	/**
	 * 医嘱作废
	 * 
	 * @return
	 * @throws BizException
	 */
	public ThirdRstDTO cancel(String[] szId_or) throws BizException {
		ThirdRstDTO rst = new ThirdRstDTO();
		FDateTime now = new FDateTime();
		try {
			List<String> cancelIds = new ArrayList<String>();
			List<CiOrderDO> cancelOrds = new ArrayList<CiOrderDO>();
			CiOrderDO[] ors = CiOrdAppUtils.getOrQryService().findByIds(szId_or, FBoolean.FALSE);
			for (CiOrderDO or : ors) {
				// if(or.getFg_uncancelable() == FBoolean.FALSE){
				cancelIds.add(or.getId_or());
				or.setId_su_or(ICiDictCodeConst.SD_SU_ID_CHECKCANCEL);
				or.setSd_su_or(ICiDictCodeConst.SD_SU_CHECKCANCEL);
				or.setFg_canc(new FBoolean(true));
				or.setDt_canc(now);
				or.setId_dep_canc(Context.get().getDeptId());
				or.setId_emp_canc(Context.get().getStuffId());
				or.setFg_chk_canc(new FBoolean(true));
				or.setDt_chk_canc(now);
				or.setId_dep_chk_canc(Context.get().getDeptId());
				or.setId_emp_chk_canc(Context.get().getStuffId());
				or.setStatus(DOStatus.UPDATED);
				cancelOrds.add(or);
				// }
			}
			if (cancelOrds.size() > 0) {
				CiOrdAppUtils.getOrService().update(cancelOrds.toArray(new CiOrderDO[0]));
				rst.setSuccessful(new FBoolean(true));
			} else {
				rst.setSuccessful(new FBoolean(false));
				rst.setErrorMessage("未执行的医嘱才可以作废！");
			}
		} catch (Exception ex) {
			rst.setErrorMessage(ex.getMessage());
			rst.setSuccessful(FBoolean.FALSE);
		}
		return rst;
	}

	/**
	 * 第三方医嘱保存接口实现
	 * 
	 * @param orderAggDO
	 * @return
	 * @throws BizException
	 */
	public ThirdRstDTO delete(String[] szId_or) throws BizException {
		ThirdRstDTO rst = new ThirdRstDTO();
		try {
			List<String> deleteIds = new ArrayList<String>();
			List<CiorderAggDO> deleteAggs = new ArrayList<CiorderAggDO>();
			CiorderAggDO[] aggs = CiOrdAppUtils.getOrAggQryService().findByIds(szId_or, FBoolean.FALSE);
			for (CiorderAggDO agg : aggs) {
				String sd_su_bl = agg.getParentDO().getSd_su_bl();
				if (!ICiDictCodeConst.SD_SU_BL_ACCOUNT.equals(sd_su_bl)) {
					deleteIds.add(agg.getParentDO().getId_or());
					deleteAggs.add(agg);
				}
			}
			if (deleteIds.size() > 0) {
				CiOrEventsDeleteBP delBP = new CiOrEventsDeleteBP();
				delBP.exec(deleteIds.toArray(new String[deleteIds.size()]));
				CiOrdAppUtils.getOrAggService().logicDelete(deleteAggs.toArray(new CiorderAggDO[deleteAggs.size()]));
				rst.setSuccessful(new FBoolean(true));
			} else {
				rst.setSuccessful(new FBoolean(false));
				rst.setErrorMessage("未交费的医嘱才可以删除！");
			}

		} catch (Exception ex) {
			rst.setErrorMessage(ex.getMessage());
			rst.setSuccessful(FBoolean.FALSE);
		}
		return rst;
	}

	/**
	 * 第三方医嘱保存接口实现
	 * 
	 * @param orderAggDO
	 * @return
	 * @throws BizException
	 */
	public ThirdRstDTO save(CiorderAggDO[] szOrderAggInfo) throws BizException {
		// 1. 创建返回值结果对象
		ThirdRstDTO rst = new ThirdRstDTO();
		// 2. 传入医嘱有效性验证
		if (!isValidate(rst, szOrderAggInfo)) {
			// 处理错误返回值
			rst.setSuccessful(FBoolean.FALSE);
			return rst;
		} else {
			// 3. 默认值处理
			handleDefaultInfo(szOrderAggInfo);
			//医嘱开立权限校验
			orSrvRtCtlChkHandle(szOrderAggInfo);
			// 4. 数据库保存
			save(rst, szOrderAggInfo);
		}
		return rst;
	}

	/**
	 * 医嘱有效性验证
	 * 
	 * @param orderAggDO
	 * @return
	 * @throws BizException
	 */
	private boolean isValidate(ThirdRstDTO rst, CiorderAggDO[] szOrderAggInfo) throws BizException {
		StringBuilder errorInfo = new StringBuilder();
		// 1. 服务类型必须为 05 类治疗医嘱
		for (CiorderAggDO agg : szOrderAggInfo) {
			CiOrderDO order = agg.getParentDO();
			String sd_srvtp = order.getSd_srvtp();
			if (CiOrdUtils.isEmpty(sd_srvtp)) {
				errorInfo.append(String.format("医嘱%s的服务类型为空！\r\n", order.getName_or()));
				continue;
			}
			// if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT)){
			// 2. 关键必填项信息检查
			OrdSrvDO[] ordSrvs = agg.getOrdSrvDO();
			for (OrdSrvDO srv : ordSrvs) {
				// 本服务定价或不计费
				if (!IBdPrimdCodeConst.ID_PRI_SRV.equals(srv.getId_primd())
						&& !IBdPrimdCodeConst.ID_PRI_FREE.equals(srv.getId_primd())) {
					errorInfo.append(String.format("服务【%s】的定价模式不允许补费！\r\n", srv.getName_srv()));
				}
				// 剂量不为空
				if (CiOrdUtils.isEmpty(srv.getQuan_medu())) {
					errorInfo.append(String.format("服务【%s】的剂量不可为空！\r\n", srv.getName_srv()));
				}
				// 剂量单位不为空
				if (CiOrdUtils.isEmpty(srv.getId_medu())) {
					errorInfo.append(String.format("服务【%s】的剂量单位不可为空！\r\n", srv.getName_srv()));
				}
				// 频次不为空
				if (CiOrdUtils.isEmpty(srv.getId_freq())) {
					errorInfo.append(String.format("服务【%s】的频次不可为空！\r\n", srv.getName_srv()));
				}
				// 频次为持续类型时，剂量单位必须为时间类型
				if (!CiOrdUtils.validateFreqAndQuanMedu(srv.getId_freq(), srv.getId_medu()).booleanValue()) {
					errorInfo.append(String.format("服务【%s】的频次为持续类型，剂量单位必须时时间量纲！\r\n", srv.getName_srv()));
				}
			}
			// }else{
			// errorInfo.append(String.format("医技补费补录的医嘱必须是治疗类！\r\n医嘱%s不是治疗类！",order.getName_or()));
			// }
		}
		if (errorInfo.toString().length() == 0) {
			return true;
		} else {
			rst.setErrorMessage(errorInfo.toString());
			return false;
		}

	}

	/**
	 * 处理默认值信息
	 * 
	 * @param orderAggDO
	 */
	private void handleDefaultInfo(CiorderAggDO[] szOrderAggInfo) throws BizException {
		List<CiorderAggDO> emptyDepMpAggs = new ArrayList<CiorderAggDO>();
		// 1. 执行科室 ？
		for (CiorderAggDO agg : szOrderAggInfo) {
			CiOrderDO order = agg.getParentDO();
			OrdSrvDO[] ordSrvs = agg.getOrdSrvDO();
			// 医嘱内容拼接
			order.setContent_or(getContentOr(agg));
			order.setCode_or(CiOrdAppUtils.getCiOrdQryService().getCodeOr());
			// 执行科室为空的记录下来
			if (CiOrdUtils.isEmpty(order.getName_dep_mp())) {
				emptyDepMpAggs.add(agg);
			}
			if (CiOrdUtils.isEmpty(order.getDays_or())) {
				order.setDays_or(1);
			}
			// 2. 总量 ？
			// 总次数
			if (order.getTimes_cur() == null || order.getTimes_cur() == 0) {
				order.setTimes_cur(1);
			}
			for (OrdSrvDO srv : ordSrvs) {
				srv.setEu_sourcemd(OrSrvSourceFromEnum.MTEXECADD);
				if (CiOrdUtils.isEmpty(srv.getQuan_total_medu())) {
					srv.setQuan_total_medu(new FDouble(order.getTimes_cur()).multiply(srv.getQuan_medu()));
				}
				if (CiOrdUtils.isEmpty(srv.getDt_last_bl())) {
					srv.setDt_last_bl(order.getDt_effe());
				}
			}
			// 3.医嘱来源Order eu_sourcemd = '医技补费'
			order.setEu_orsrcmdtp(OrSourceFromEnum.IIHMEDTECHORDERS);
			// 4.医嘱状态 = 60
			order.setSd_su_or(ICiDictCodeConst.SD_SU_FINISH);
			order.setId_su_or(ICiDictCodeConst.SD_SU_ID_FINISH);

			order.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_EXEOK);
			order.setId_su_mp(ICiDictCodeConst.SD_SU_MP_EXEOK_ID);
			// order.setSd_su
			// 设置dt-last_bl
			if (CiOrdUtils.isEmpty(order.getDt_last_bl())) {
				order.setDt_last_bl(order.getDt_effe());
			}
		}
		//
		if (emptyDepMpAggs.size() > 0) {
			// 填充执行科室
			handleNameDepMp(emptyDepMpAggs);
		}

	}

	/**
	 * 数据库保存
	 * 
	 * @param rst
	 * @param orderAggDO
	 * @return
	 */
	private void save(ThirdRstDTO rst, CiorderAggDO[] szOrderAggInfo) throws BizException {
		try {
			ICiorderCudService orservice = CiOrdAppUtils.getOrAggService();
			CiorderAggDO[] szRstOrdAggInfo = orservice.save(szOrderAggInfo);
			FArrayList orderList = new FArrayList();
			List<CiOrderDO> orderlist = new ArrayList<CiOrderDO>();
			for (CiorderAggDO ord : szRstOrdAggInfo) {
				orderList.add(ord);
				CiOrderDO order = ord.getParentDO();
				orderlist.add(order);
			}
			rst.setOrderAggInfoList(orderList);
			rst.setSuccessful(FBoolean.TRUE);

			// 保存成功后往集成平台同步数据，发送事件
			CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID, IEventType.TYPE_UPDATE_AFTER,
					orderlist.toArray(new CiOrderDO[0]));
		} catch (Exception e) {
			rst.setErrorMessage(e.getMessage());
			rst.setSuccessful(FBoolean.FALSE);
		}

	}

	/**
	 * 执行科室查询
	 * 
	 * @throws BizException
	 */
	private void handleNameDepMp(List<CiorderAggDO> aggs) throws BizException {
		List<OrWfExDeptParamDTO> deptParamDtos = new ArrayList<OrWfExDeptParamDTO>();
		HashMap<OrWfExDeptParamDTO, CiorderAggDO> maphash = new HashMap<OrWfExDeptParamDTO, CiorderAggDO>();
		int i = 0;
		String names = "";
		for (CiorderAggDO agg : aggs) {
			CiOrderDO order = agg.getParentDO();
			if (StringUtils.isEmpty(order.getId_dep_mp())) {
				OrWfExDeptParamDTO deptParm = new OrWfExDeptParamDTO();
				deptParm.setEu_wftp(EnumFlow.EXECUTEFLOW);// 查询执行流向
				deptParm.setCode_entp(order.getCode_entp());
				deptParm.setSd_srvtp(order.getSd_srvtp());
				deptParm.setId_srvca(order.getId_srvca());
				deptParm.setId_usage(order.getId_route());
				deptParm.setRecurstr(CiOrdUtils.getFg_longStr(order.getFg_long()));
				deptParm.setWeekno(DateUtils.getWeekNoStr4Dt(order.getDt_effe()));
				deptParm.setTimestr(DateUtils.getFTime8Dt(order.getDt_effe()));
				deptParm.setId_srv(order.getId_srv());
				deptParm.setId_dept_or(order.getId_dep_or());
				deptParamDtos.add(deptParm);
				maphash.put(deptParm, agg);
				names += "," + order.getName_or();
			}
		}
		if(deptParamDtos.size()==0){
			return;
		}
		OrWfExDeptParamDTO[] deptParamDtosArray = CiOrdAppUtils.getBdFcQryQryService().getOrExDeptBatchBP(deptParamDtos.toArray(new OrWfExDeptParamDTO[0]));
		if (CiOrdUtils.isEmpty(deptParamDtosArray)) {
			throw new BizException("服务【" + names.substring(1) + "】没有配置执行科室，请联系信息科！");
		}
		for (OrWfExDeptParamDTO param : deptParamDtosArray) {
			FArrayList deptArrays = param.getRes();
			if (CiOrdUtils.isEmpty(deptArrays)) {
				throw new BizException("服务【" + names.substring(1) + "】没有配置执行科室，请联系信息科！");
			}
			for (i = 0; i < deptArrays.size(); i++) {
				OrWfExDeptDTO wfex = (OrWfExDeptDTO) deptArrays.get(i);
				CiorderAggDO aggDo = maphash.get(param);
				aggDo.getParentDO().setId_dep_mp(wfex.getId_dept());
				for (OrdSrvDO srv : aggDo.getOrdSrvDO()) {
					if (CiOrdUtils.isEmpty(srv.getId_dep_mp())) {
						srv.setId_dep_mp(wfex.getId_dept());
					}
				}
			}
		}
	}

	/**
	 * 拼接医嘱内容
	 * 
	 * @param agg
	 * @return
	 */
	private String getContentOr(CiorderAggDO agg) {
		CiOrContentDO contentdo = new CiOrContentDO();
		CiOrderDO order = agg.getParentDO();
		contentdo.setTypeId(order.getSd_srvtp());
		contentdo.setTitle("");
		contentdo.setItemInfos(getItemInfos(agg));
		contentdo.setTailInfo(getTailInfos(agg));
		return contentdo.toString();
	}

	private ArrayList<ArrayList<String>> getItemInfos(CiorderAggDO agg) {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		ArrayList<String> arrList = new ArrayList<String>();

		if (agg.getParentDO().getSd_srvtp().equals("0506")) {
			arrList.add(agg.getOrdSrvDO()[0].getName());
			list.add(arrList);
			return list;
		}

		for (int i = 0; i < agg.getOrdSrvDO().length; i++) {
			arrList.add(agg.getOrdSrvDO()[i].getName());
		}
		list.add(arrList);
		return list;
	}

	/**
	 * 获得表尾数据
	 * 
	 * @param ems
	 * @return
	 */
	private ArrayList<String> getTailInfos(CiorderAggDO agg) {
		ArrayList<String> list = new ArrayList<String>();
		list.add(agg.getParentDO().getRoutedes_name());
		FBoolean fg_urgent = agg.getParentDO().getFg_urgent();
		if (fg_urgent != null && fg_urgent.booleanValue()) {
			list.add("加急！");
		}
		return list;
	}
	/**
	 * 医嘱开立权限检查处理
	 * 
	 * @param aggors
	 * @throws BizException
	 */
	private void orSrvRtCtlChkHandle(CiorderAggDO[] aggors) throws BizException {
		OrSrvDoctorRtValidateBP bp = new OrSrvDoctorRtValidateBP();
		FMap2 orsrvrtchk =  bp.exec(aggors, false);
		if (orsrvrtchk != null && orsrvrtchk.size() > 0 && orsrvrtchk.containsKey("ErrMsg")) {
			throw new BizException(orsrvrtchk.get("ErrMsg").toString());
		}
	}
}
