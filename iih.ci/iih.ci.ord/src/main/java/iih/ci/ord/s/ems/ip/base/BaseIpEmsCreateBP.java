package iih.ci.ord.s.ems.ip.base;

import iih.bd.base.database.DatabaseUtils;
import iih.bd.base.database.ListMapRecordSet;
import iih.bd.base.database.SqlConditionsParameter;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeTypeConst;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;
import iih.ci.ord.dws.ip.order.d.OrderPrescribeModuleEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.i.common.EmsDriverInfo;
import iih.ci.ord.i.external.obtain.ICiOrdBdRService;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.util.biz.CiEnContextUtil;
import iih.ci.ord.s.ems.base.BaseEmsCreateBP;
import iih.ci.ord.s.ems.cache.BDFreqInfoCache;
import iih.ci.ord.s.ems.cache.BDMeasInfoCache;
import iih.ci.ord.s.ems.define.ICiDoctorStationTypeConst;
import iih.ci.ord.s.ems.utils.DeptInfoUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 住院医生站，医疗单创建基类实现
 * 
 * @author wangqingzhu
 *
 */
public class BaseIpEmsCreateBP extends BaseEmsCreateBP {

	@Override
	public EmsRstDTO[] create(CiEnContextDTO ctx, EmsCrtDTO[] szEms) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 处理模型对象的返回值结果
	 * 
	 * @param objInfo
	 * @return
	 * @throws BizException
	 */
	protected FArrayList handleReturnDocument(Object objInfo) throws BizException {
		FArrayList objList = new FArrayList();
		objList.add(objInfo);

		return objList;
	}
	
	
	/**
	 * 医嘱列表信息赋值
	 * 
	 * @param ctx
	 * @param medSrv
	 * @param orderListViewDTO
	 * @throws BizException
	 */
	protected void orderListViewInfoFrom(CiEnContextDTO ctx, MedSrvDO medSrv, EmsDriverInfo driverInfo,
			OrderListViewDTO orderListViewDTO) throws BizException {
		if (orderListViewDTO == null)
			return;
		FDateTime dt = CiOrdAppUtils.getServerDateTime();
		orderListViewDTO.setIdsrvIdmm(medSrv.getId_srv());
		orderListViewDTO.setId_srvtp(medSrv.getId_srvtp());// 服务类型ID
		orderListViewDTO.setSd_srvtp(medSrv.getSd_srvtp());// 服务类型编码
		orderListViewDTO.setName_srvtp(this.getNameSrvtp(medSrv));// 服务类型
		orderListViewDTO.setId_srv(medSrv.getId_srv());// 服务ID
		orderListViewDTO.setCode_srv(medSrv.getCode());
		orderListViewDTO.setName_srv(medSrv.getName());// 服务编码
		// orderListViewDTO.setExtend(Extend);//辅助说明，医疗单赋值
		orderListViewDTO.setQuan_med((CiOrdUtils.isTrue(medSrv.getIsmuldose()) ? medSrv.getQuan_med() : new FDouble(1)));// 剂量
		orderListViewDTO.setId_unit_med(medSrv.getId_unit_med());// 剂量单位ID
		orderListViewDTO.setName_unit_med(medSrv.getMed_name());// 剂量单位
		//频次
		FreqDefDO freqDefDO = BDFreqInfoCache.GetFreqInfo(CiOrdUtils.isTrue(medSrv.getIsmulexec()) ? 
				medSrv.getId_freq() : IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
		if (freqDefDO == null) {
			orderListViewDTO.setId_freq(null);
			orderListViewDTO.setName_freq(null);
			orderListViewDTO.setSd_frequnitct(null);
			orderListViewDTO.setFreqct(null);
			orderListViewDTO.setFg_long(null);
			orderListViewDTO.setFg_long_edit(null);
		}else{
			orderListViewDTO.setId_freq(freqDefDO.getId_freq());// 频次ID
			orderListViewDTO.setName_freq(freqDefDO.getCode());// 频次
			orderListViewDTO.setSd_frequnitct(freqDefDO.getSd_frequnitct());// 频次数量
			orderListViewDTO.setFreqct(freqDefDO.getFreqct());// 频次周期类型编码
			orderListViewDTO.setFg_long(freqDefDO.getFg_long());// 长临标识
			orderListViewDTO.setFg_long_edit(freqDefDO.getFg_long_edit());// 长临标识可编辑标识
			orderListViewDTO.setCode_disp_freq(freqDefDO.getCode_disp());//频次显示名称
		}
		orderListViewDTO.setId_route(medSrv.getId_route());// 用法ID
		orderListViewDTO.setName_route(medSrv.getRoute_name());// 用法
		orderListViewDTO.setFilter_route(ServiceFinder.find(ICiOrdBdRService.class).getIdroutes8Dosage(medSrv.getSd_srvtp(), new String[]{medSrv.getId_srv()}, FBoolean.FALSE));//用法过滤条件，关联剂型，药品
		orderListViewDTO.setId_routedes(medSrv.getId_routedes());// 用法要求ID
		orderListViewDTO.setName_routedes(medSrv.getRoutedes_name());// 用法要求
		orderListViewDTO.setDt_effe(dt);// 开立时间
		orderListViewDTO.setId_emp_or(ctx.getId_emp_or());// 开立医生ID
		orderListViewDTO.setName_emp_or(ctx.getName_emp_or());// 开立医生
		orderListViewDTO.setId_dep_or(ctx.getId_dep_or());// 开单科室
		orderListViewDTO.setDt_end(null);// 停止时间
		orderListViewDTO.setDays_or(1);// 医嘱天数，医疗单实际赋值
		orderListViewDTO.setFg_research(FBoolean.FALSE);// 科研标识
		orderListViewDTO.setId_su_or(ICiDictCodeConst.SD_SU_ID_OPEN);// 医嘱状态：开立
		orderListViewDTO.setSd_su_or(ICiDictCodeConst.SD_SU_OPEN);// 医嘱状态：开立
		orderListViewDTO.setFg_sign(FBoolean.FALSE);//签署标识
		orderListViewDTO.setFg_chk(FBoolean.FALSE);//确认标识
		orderListViewDTO.setFg_refusecheck(FBoolean.FALSE);//拒绝确认标识
		orderListViewDTO.setFg_canc(FBoolean.FALSE);//作废标识
		orderListViewDTO.setFg_uncancelable(FBoolean.FALSE);//医嘱不可取消标识
		orderListViewDTO.setFg_chk_canc(FBoolean.FALSE);//作废确认标识
		orderListViewDTO.setFg_stop(FBoolean.FALSE);//停止标识
		orderListViewDTO.setFg_chk_stop(FBoolean.FALSE);//停止确认标识
		orderListViewDTO.setFg_set(medSrv.getFg_set());//服务套标识
		orderListViewDTO.setFg_setradio(medSrv.getFg_setradio());
		orderListViewDTO.setFg_urgent(FBoolean.FALSE);// 加急标识
		orderListViewDTO.setFg_urgent_edit(medSrv.getFg_urgent_ip());//加急可使用标识
		if(!CiEnContextUtil.IsHpPat(ctx)){
			orderListViewDTO.setFg_selfpay(FBoolean.TRUE);// 自费标识	
		}
		
		orderListViewDTO.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);//医嘱服务来源方式
		orderListViewDTO.setEu_orsrcmdtp(OrSourceFromEnum.IIHSRVREF);// 医嘱来源方式：服务参照
		orderListViewDTO.setIsmuldose(medSrv.getIsmuldose());// 多剂量标识
		orderListViewDTO.setIsmulexec(medSrv.getIsmulexec());// 多次执行标识
		orderListViewDTO.setSd_totalopenmode(medSrv.getSd_totalopenmode());// 总量开单模式
		orderListViewDTO.setEu_blmd(medSrv.getEu_blmd());// 划价方式
		orderListViewDTO.setFg_selfsrv(medSrv.getFg_ctm());// 自定义服务标识
		orderListViewDTO.setFg_use(medSrv.getFg_use_ip());// 住院可使用标识-当前就诊类型
		orderListViewDTO.setId_primd(medSrv.getId_primd());
		orderListViewDTO.setFg_or(medSrv.getFg_or());
		// 二次配液标志，默认false
		orderListViewDTO.setFg_secadmt(FBoolean.FALSE);
		
		// 不计费类型
		if(CiOrdUtils.isTrue(orderListViewDTO.getFg_selfsrv()) && !"2".equals(ctx.getSd_orsrcfun())){
			orderListViewDTO.setId_nodispense(ICiDictCodeConst.ID_NODISPENSE_SELF);
			orderListViewDTO.setSd_nodispense(ICiDictCodeConst.SD_NODISPENSE_SELF);
			orderListViewDTO.setName_nodispense(ICiDictCodeConst.NAME_NODISPENSE_SELF);
			orderListViewDTO.setFg_self(FBoolean.TRUE);//自备药标识，药品
		}
		//费用标识
		orderListViewDTO.setFg_bl(medSrv.getFg_bl());
		// 当前剂量单位和剂量赋值
		orderListViewDTO.setId_medu_cur(orderListViewDTO.getId_unit_med());
		orderListViewDTO.setName_medu_cur(orderListViewDTO.getName_unit_med());
		orderListViewDTO.setQuan_medu_cur(orderListViewDTO.getQuan_med());
		// 医疗单驱动
		orderListViewDTO.setDriverInfo(driverInfo);
		//医嘱开立方式：默认医嘱列表开立
		orderListViewDTO.setEu_OrderPrescribeModule(OrderPrescribeModuleEnum.ORDERLIST);
		orderListViewDTO.setFg_pres_outp(FBoolean.FALSE);
		orderListViewDTO.setStatus(DOStatus.NEW);

	}
	
	
	
	protected void handleMtOrderInfo(CiEnContextDTO ctx, OrderListViewDTO orderInfo) throws BizException{
		if(ICiDoctorStationTypeConst.Type_Ip_MtDoctor_Station.equals(ctx.getStationType())){
			orderInfo.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);
			orderInfo.setName_freq(BDFreqInfoCache.GetNameOfFreqInfo(orderInfo.getId_freq()));
			orderInfo.setFreqct(BDFreqInfoCache.GetFreqctOfFreqInfo(orderInfo.getId_freq()));
			orderInfo.setSd_frequnitct(BDFreqInfoCache.GetSDFrequnitctOfFreqInfo(orderInfo.getId_freq()));
			orderInfo.setFg_long(BDFreqInfoCache.GetFgLongOfFreqInfo(orderInfo.getId_freq()));
			orderInfo.setFg_long_edit(BDFreqInfoCache.GetFgLongEditOfFreqInfo(orderInfo.getId_freq()));
		}
	}

	/**
	 * 设置执行科室信息
	 * 
	 * @param ctx
	 * @param medSrv
	 * @param orderListViewDTO
	 * @throws BizException
	 */
	protected void calcOrderWfDeptInfo(CiEnContextDTO ctx, MedSrvDO medSrv, OrderListViewDTO orderListViewDTO)
			throws BizException {
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ctx, medSrv.getId_srv(), orderListViewDTO.getId_mm(), orderListViewDTO.getId_route(),null,
				orderListViewDTO.getFg_long(),ctx.getFg_pres_outp(),orderListViewDTO.getDt_effe());
		if (!CiOrdUtils.isEmpty(wf)) {
			
			// 非物品没有物质科室
			if(FBoolean.TRUE.equals(medSrv.getFg_mm())){
				orderListViewDTO.setId_dep_wh(wf.getId_dept_wh());// 物资仓库ID
				orderListViewDTO.setName_dep_wh(wf.getName_dept_wh());// 物资仓库
				orderListViewDTO.setFilter_dep_wh(wf.getId_dept_whs());// 物资仓库过滤条件	
			}
			
			orderListViewDTO.setId_dep_mp(wf.getFirstid_mp_dept());// 执行科室ID
			orderListViewDTO.setName_dep_mp(wf.getFirstname_mp_dept());// 执行科室
			orderListViewDTO.setFilter_dep_mp("1".equals(wf.getMp_source()) ? null : wf.getId_mp_depts());// 执行科室过滤条件
		}
	}

	protected void setEmsDriverInfo(EmsDriverInfo driverInfo, OrderListViewDTO emsViewDTO) {
		emsViewDTO.setDriverInfo(driverInfo);
		emsViewDTO.setId_ems(driverInfo.getId_ems());
		emsViewDTO.setJsonDriver(driverInfo.getJsonDriver());
		emsViewDTO.setFg_quickwflow(driverInfo.getFg_quickwflow());
	}

	/**
	 * 设置开立科室、开立人信息
	 * 
	 * @param ctx
	 * @param medSrv
	 * @param orderListViewDTO
	 * @throws BizException
	 */
	protected void setOrdDeptEmpInfo(CiEnContextDTO ctx,  OrderListViewDTO orderListViewDTO)throws BizException {
		FDateTime dt = CiOrdAppUtils.getServerDateTime();
		orderListViewDTO.setDt_effe(dt);// 开立时间
		orderListViewDTO.setId_emp_or(ctx.getId_emp_or());// 开立医生ID
		orderListViewDTO.setName_emp_or(ctx.getName_emp_or());// 开立医生
		orderListViewDTO.setId_dep_or(ctx.getId_dep_or());// 开单科室
		if(!CiEnContextUtil.IsHpPat(ctx)){
			orderListViewDTO.setFg_selfpay(FBoolean.TRUE);// 自费标识	
		}
		orderListViewDTO.setNo_applyform( CiOrdUtils.getApplyNo(orderListViewDTO.getSd_srvtp()) );
		
	}
	/**
	 * 服务类型名称
	 * @param medSrv
	 * @return
	 * @throws BizException
	 */
	private String getNameSrvtp(MedSrvDO medSrv) throws BizException{
		String sd_srvtp = medSrv.getSd_srvtp();
		String sql="select ctrl2 from bd_udidoc where Id_udidoclist = ? and code=decode(substr(?, 1, 2),'01',substr(?, 1, 4),'14',substr(?, 1, 4),substr(?, 1, 2))";
		//服务类型名称
		SqlConditionsParameter sqlCondParameter = new SqlConditionsParameter();
		sqlCondParameter.setSql(sql);
		sqlCondParameter.addParam(IBdSrvDictCodeTypeConst.ID_SRVTP);
		sqlCondParameter.addParam(sd_srvtp);
		sqlCondParameter.addParam(sd_srvtp);
		sqlCondParameter.addParam(sd_srvtp);
		sqlCondParameter.addParam(sd_srvtp);
		ListMapRecordSet recordSet = DatabaseUtils.Q(sqlCondParameter);
		if (recordSet != null && recordSet.size() > 0) {
			return recordSet.get(0).get("ctrl2").toString();
		}
		return medSrv.getName();
	}
	
	protected void handleDefaultInfo(EmsCrtDTO emsCrtDTO, OrderListViewDTO emsViewDTO) throws BizException {
		if(emsCrtDTO.getExtension() != null && emsCrtDTO.getExtension().containsKey("MainOrderSrv")){
			OrderListViewDTO mainSrvInfo = (OrderListViewDTO)emsCrtDTO.getExtension().get("MainOrderSrv");
			emsViewDTO.setId_or_rel(mainSrvInfo.getId_or_rel());
			emsViewDTO.setId_emp_or(mainSrvInfo.getId_emp_or());
			
			// 户嘱补录的医嘱可能不是多长执行的
			if(FBoolean.TRUE.equals(emsViewDTO.getIsmulexec())){
				emsViewDTO.setId_freq(mainSrvInfo.getId_freq());
				emsViewDTO.setName_freq(mainSrvInfo.getName_freq());
				emsViewDTO.setSd_frequnitct(mainSrvInfo.getSd_frequnitct());
				emsViewDTO.setFreqct(mainSrvInfo.getFreqct());
				emsViewDTO.setCode_disp_freq(mainSrvInfo.getCode_disp_freq());
				emsViewDTO.setFg_long(mainSrvInfo.getFg_long());
				emsViewDTO.setFg_long_edit(mainSrvInfo.getFg_long_edit());	
			}
			
			if(null != mainSrvInfo.getDt_effe()) { //针对护嘱- 如果护嘱跟随主医嘱的执行日期和首日执行次数的话  在前端会传回来 并且会赋值
				emsViewDTO.setDt_effe(mainSrvInfo.getDt_effe());
				emsViewDTO.setQuan_firday_mp(mainSrvInfo.getQuan_firday_mp());
			}
			emsViewDTO.setDt_end(mainSrvInfo.getDt_end());
			emsViewDTO.setSd_orsrcfun(mainSrvInfo.getSd_orsrcfun());
			emsViewDTO.setId_unit_cur(mainSrvInfo.getId_unit_cur());
			emsViewDTO.setId_unit_cur(emsViewDTO.getId_unit_cur());// 总量单位
			emsViewDTO.setName_unit_cur(BDMeasInfoCache.GetNameOfBdMeasInfo(emsViewDTO.getId_unit_cur()));// 总量单位名称
			emsViewDTO.setFactor_cb(BDMeasInfoCache.GetScaleFactorOfBdMeasInfo(emsViewDTO.getId_unit_cur()));// 基本包装单位和总量单位的换算系数

		}
		
				
		
	}
	
}
