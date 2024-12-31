package iih.ci.ord.s.ems.op.ems.apbt;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.dto.d.EmsDynamicParamDTO;
import iih.bd.srv.ems.d.EmsDynamicIndexDTO;
import iih.bd.srv.ems.d.EmsregistryAggDO;
import iih.bd.srv.ems.i.IEmsregistryRService;
import iih.bd.srv.i.IBdSrvQryService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.bd.srv.medsrvbloodquancanap.d.MedsrvbloodquancanapDO;
import iih.bd.srv.medsrvbloodquancanap.i.IMedsrvbloodquancanapRService;
import iih.ci.ord.cior.d.OrdApBtViewItemDO;
import iih.ci.ord.cior.d.OrdApSugViewItemDO;
import iih.ci.ord.ciordems.d.EmsBtItemDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.i.ie.ICiIEMainService;
import iih.ci.ord.i.meta.EmsCrtDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.iemsg.d.IELisQryItemInDTO;
import iih.ci.ord.iemsg.d.IELisQryOutDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.ems.cache.BDEmsInfoCache;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.s.ems.meta.DiagOutlineInfo;
import iih.ci.ord.s.ems.op.base.OpBaseEmsCreateBP;
import iih.ci.ord.s.ems.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.utils.DiagInfoUtils;
import iih.ci.ord.s.ems.utils.OrderEmsExtInfoUtils;
import iih.ci.ord.s.ems.utils.OrderEmsPriceUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class EmsApBtCreateBP extends OpBaseEmsCreateBP {

	@Override
	public EmsRstDTO[] create(CiEnContextDTO ctx,EmsCrtDTO[] emsarray) throws BizException {
		EmsCrtDTO ems = emsarray[0];
		List<EmsRstDTO> rsts = new ArrayList<EmsRstDTO>();
		EmsRstDTO rst = new EmsRstDTO();
		// 获取主服务信息
		MedsrvAggDO aggDO = ServiceFinder.find(IMedsrvRService.class).findById(ems.getId_srv());
		if (aggDO == null) {
			throw new BizException("查询主服务信息失败！", CiOrdemsErrorCodeEnum.ERRORCODE_EMS_MAINSRV_NULL);
		}
		// 合成主UI模型对象
		EmsBtItemDO emsModel = BDEmsInfoCache.GetCache(ctx,ems.getDriverInfo().getId_ems(), ems.getId_srv());
		if (null == emsModel) {
			emsModel = emsModelFrom(aggDO.getParentDO());
			BDEmsInfoCache.PutCache(ctx,ems.getDriverInfo().getId_ems(), ems.getId_srv(), emsModel);
		}

		// 可变部分赋值
		{
			FDateTime tm = CiOrdAppUtils.getServerDateTime();
			emsModel.setUse_days(1);
			GetTotalTimesBP totalTimesBP = new GetTotalTimesBP();
			Integer totalTimes = totalTimesBP.getTotalTimes(tm,aggDO.getParentDO().getId_freq(), emsModel.getUse_days());
			emsModel.setTimes_cur(totalTimes);
			emsModel.setDt_begin_ui(tm); // SINGLE
			emsModel.setDt_end_ui(new FDateTime(tm.getBeginDate().getDateAfter(1), tm.getUFTime()));
			emsModel.setDt_bt(tm); // 输血日期 SINGLE
			emsModel.setDt_create(tm); // 开立时间 SINGLE
			emsModel.setNo_applyform(CiOrdUtils.getApplyNo(aggDO.getParentDO().getSd_srvtp()));

			emsModel.setId_emp_create(ctx.getId_emp_or()); // 申请医生id
			// REF
			emsModel.setName_emp_create(ctx.getName_emp_or()); // 申请医生
			// SINGLE
		}
		// 诊断信息
		DiagOutlineInfo diagOutlineInfo = DiagInfoUtils.GetDiagOutLineInfo(ctx.getId_en());
		if (diagOutlineInfo != null) {
			emsModel.setId_di(diagOutlineInfo.getId_di());// 主诊断的主项目id
			emsModel.setId_diitm(diagOutlineInfo.getId_diitm());// 主诊断id
			emsModel.setName_diag(diagOutlineInfo.getName_diag());// 主诊断名称
			emsModel.setStr_code_di(diagOutlineInfo.getStr_code_di());// 诊断编码拼接
			emsModel.setStr_name_di(diagOutlineInfo.getStr_name_di());// 诊断名称拼接
			emsModel.setStr_id_diitm(diagOutlineInfo.getStr_id_diitm());// 诊断子项目id拼接

			OrderEmsExtInfoUtils.SetDiInfo(rst, diagOutlineInfo.toFMap());
		}

		// 获取价格
		emsModel.setPrice(OrderEmsPriceUtils.calculatePrice(aggDO.getParentDO(),
				ctx.getId_pripat()));
		//获取申请血量
		MedsrvbloodquancanapDO[] bloodquans=getBooldQuan(aggDO.getParentDO().getId_srv());
		if(bloodquans.length>0){
			if(!CiOrdUtils.isEmpty(aggDO.getParentDO().getQuan_med())){
				for(MedsrvbloodquancanapDO bloodquan : bloodquans){
					if(bloodquan.getQuan_blood()==aggDO.getParentDO().getQuan_med()){
						emsModel.setQuan_blood(bloodquan.getQuan_blood().toString());
						emsModel.setId_blodquan(bloodquan.getId_srvblodquancanap());
					}
				}
			}else{
				emsModel.setQuan_blood(bloodquans[0].getQuan_blood().toString());
				emsModel.setId_blodquan(bloodquans[0].getId_srvblodquancanap());
			}
		}

		// 主服务对象
		OrderEmsExtInfoUtils.SetCustomInfo(rst, aggDO.getParentDO());

		// 获取执行科室
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ctx, aggDO.getParentDO().getId_srv(), "","", "",aggDO.getParentDO().getFg_long(),FBoolean.FALSE,emsModel.getDt_begin_ui());
		if (!CiOrdUtils.isEmpty(wf)) {
			// 封装错误信息
			//FArrayList errorlist=new FArrayList();
			//errorlist.add("获取执行科室失败");
			//OrderEmsExtInfoUtils.SetErrMsg(rst, errorlist);
			//rsts.add(rst);
			//return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
			emsModel.setId_mp_dep(wf.getFirstid_mp_dept());
			emsModel.setName_mp_dep(wf.getFirstname_mp_dept());
			// 保存执行科室过滤条件
			OrderEmsExtInfoUtils.SetMpDepFilter(rst, CiOrdUtils.isEmpty(wf.getId_mp_depts())?null:wf.getId_mp_depts());

			// 保存物资流向
			OrderEmsExtInfoUtils.SetWhDepFilter(rst, CiOrdUtils.isEmpty(wf.getId_dept_whs())?null:wf.getId_dept_whs());
			OrderEmsExtInfoUtils.SetWhDepId(rst, wf.getId_dept_wh());
			OrderEmsExtInfoUtils.SetWhDepName(rst, wf.getName_dept_wh());
		}

		// 动态指标
		if (null != ems.getDriverInfo()) {
			OrdApBtViewItemDO[] szOrdApSugViewItemDO = this.ordApSugViewItemListFrom(ctx,
					ems.getDriverInfo().getId_ems());
			if (null != szOrdApSugViewItemDO) {
				FArrayList indicatorList = new FArrayList();
				for (OrdApBtViewItemDO item : szOrdApSugViewItemDO){
					indicatorList.add(item);
				}
				if (indicatorList.size() > 0){
					emsModel.setBtLabItemEx(indicatorList);
				}
			}
		}


		// 返回值处理
		rst.setDocument(this.handleReturnDocument(emsModel));
		// rst.setDocumentString(StringCodingUtils.Utf8_Base64_Encode(emsModel.serializeJson()));
		rst.getDriverInfo().setEmsBackendDriver(EmsType.BT.toString());
		rst.getDriverInfo().setEmsFrontDriver(EmsType.BT.toString());
		rsts.add(rst);
		return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
	}

	public EmsBtItemDO emsModelFrom(MedSrvDO med) throws BizException {
		EmsBtItemDO ems = new EmsBtItemDO();
		FDateTime tm = CiOrdAppUtils.getServerDateTime();
		ems.setComponents_name(med.getName());
		ems.setFg_bl(med.getFg_bl());
		ems.setFg_or(med.getFg_or());
		ems.setFg_mm(med.getFg_mm());
		ems.setSd_srvtp(med.getSd_srvtp());
		// ems.setId_or //医嘱id
		// ems.setId_orsrv //医嘱服务id
		// 若打开该医疗单的服务是服务套时，输血成分参照是服务套中临床标志为true的明细
		if (CiOrdUtils.isTrue(med.getFg_set())) {

			MedSrvSetItemDO[] setItems = ServiceFinder.find(IMedSrvSetItemDORService.class)
					.find(String.format("a8.id_srv='%s'", med.getId_srv()), "", FBoolean.FALSE);
			if (setItems != null && setItems.length > 0) {
				ems.setId_srv(setItems[0].getId_srv_itm()); // 服务id
				ems.setName_srv(setItems[0].getSet_name()); // 输血成分(服务名称)
				ems.setQuan_med(setItems[0].getQuan_medu()); // 输血数量(医学单位数值)
				ems.setId_unit_med(setItems[0].getId_medu()); // 输血数量单位(医学单位)
				ems.setName_unit_med(setItems[0].getMedu_name()); // 医学单位名称
			}
		} else {
			ems.setId_srv(med.getId_srv()); // 服务id
			ems.setName_srv(med.getName()); // 输血成分(服务名称)
			ems.setQuan_med(med.getQuan_med()); // 输血数量(医学单位数值) SINGLE FDouble
			ems.setId_unit_med(med.getId_unit_med()); // 输血数量单位(医学单位) REF 计量单位
			ems.setName_unit_med(med.getMed_name()); // 医学单位名称 SINGLE String 50
		}
		// ems.setId_di //临床诊断id REF 医疗服务_疾病诊断定义 20 疾病诊断
		// ems.setName_di //临床诊断
		ems.setNo_applyform(CiOrdUtils.getApplyNo(med.getSd_srvtp())); // 输血单号
		// ems.setParturition_cnt //产数量 SINGLE Integer 10
		// ems.setFg_bt // 输血史标志 SINGLE FBoolean 1
		// ems.setSd_pps // 输血目的编码 SINGLE String 20
		// ems.setId_pps // 输血目的id REF 检验目的_自定义档案 20 检验目的_自定义档案
		// ems.setName_pps // 输血目的 SINGLE String 50
		// ems.setFg_db // 献血史标志 SINGLE FBoolean 1
		// ems.setNo_db // 献血证号 SINGLE String 50
		// ems.setId_mode // 预定输血方式id REF 20
		// ems.setName_mode // 预定输血方式 SINGLE String 50
		// ems.setSd_demandsu // 输血需求状态sd SINGLE String 50
		// ems.setSd_mode //预定输血方式sd SINGLE String 50
		// ems.setPregnat_num //孕几胎 SINGLE Integer 10
		// ems.setId_labitmexplain //输血前检查说明id SINGLE String 50
		// ems.setName_labitmexplain //输血前检查说明 SINGLE String 50
		// ems.setSd_labitmexplain //输血前检测项目说明 REF String 50
		ems.setDt_bt(tm); // 输血日期 SINGLE
		ems.setDt_create(tm); // 开立时间 SINGLE
		// FDateTime 19
		// ems.setId_bttp // 血液品种id REF 血液品种_自定义档案 20 血液品种_自定义档案
		// ems.setName_bttp // 血液品种 SINGLE String 50
		// ems.setSd_bttp // 血液品种sd SINGLE String 50
		// ems.setId_demandsu // 输血需求状态id REF 20
		// ems.setName_demandsu // 输血需求状态

		ems.setUse_days(1);
		GetTotalTimesBP totalTimesBP = new GetTotalTimesBP();
		Integer totalTimes = totalTimesBP.getTotalTimes(tm,med.getId_freq(), ems.getUse_days());
		ems.setTimes_cur(totalTimes);

		ems.setDt_begin_ui(tm); // SINGLE
		ems.setDt_end_ui(new FDateTime(tm.getBeginDate().getDateAfter(1), tm.getUFTime())); // String
		// //
		// 50
		ems.setStatus(DOStatus.NEW);

		return ems;
	}

	/**
	 * 动态指标
	 * 
	 * @param ctx
	 * @param id_srvof
	 * @return
	 * @throws BizException
	 */
	protected OrdApBtViewItemDO[] ordApSugViewItemListFrom(CiEnContextDTO ctx, String id_srvof) throws BizException {
		// 获取医疗单维护 -- 医疗单注册服务
		IEmsregistryRService emsMgrService = ServiceFinder.find(IEmsregistryRService.class);

		if (null == emsMgrService)
			return null;


		EmsregistryAggDO emsRegAggDo = emsMgrService.findById(id_srvof);

		if (null == emsRegAggDo) {
			return null;
		}

		if (emsRegAggDo.getParentDO() == null)
			return null;

		FBoolean fg_dyncitm_en = emsRegAggDo.getParentDO().getFg_dyncitm_crossentp();
		Integer eu_dyncitmunit = emsRegAggDo.getParentDO().getEu_dyncitmunit();// 指标周期类型
		Integer dyncitmunitct = emsRegAggDo.getParentDO().getCnt_dyncitmunit();

		EmsDynamicParamDTO paramDto = new EmsDynamicParamDTO();
		paramDto.setId_ems(id_srvof);
		paramDto.setFg_dyncitm_en(fg_dyncitm_en.booleanValue());
		paramDto.setEu_dyncitmunit(eu_dyncitmunit);
		paramDto.setId_ent(ctx.getId_en());
		paramDto.setId_pat(ctx.getId_pat());
		paramDto.setDyncitmunitct(dyncitmunitct);

		IBdSrvQryService qryService = ServiceFinder.find(IBdSrvQryService.class);
		if (null == qryService) {
			return null;
		}
		EmsDynamicIndexDTO[] dtos = qryService.getEmsDynamicIndexInfos(paramDto);
		// Datatype为编辑类型，0：输入框，其他为：下拉框
		List<OrdApBtViewItemDO> rstList = new ArrayList<OrdApBtViewItemDO>();
		for (EmsDynamicIndexDTO dto : dtos) {
			OrdApBtViewItemDO item = new OrdApBtViewItemDO();
			{
				item.setVal_rstrptla(dto.getIndexval() == null ? "" : dto.getIndexval());
				item.setVal_restrptlab(dto.getEnumvalues() == null ? "" : "|" + dto.getEnumvalues().replace(',', '|'));
				item.setSd_restrptlabtp(dto.getDatatype());
				item.setName_srv(dto.getShowname());
				item.setName_unit(dto.getUnitname());
				item.setId_unit(dto.getId_unit());
				item.setId_srv(dto.getId_srv());
				item.setFg_allowempty(dto.getFg_allowempty());
				item.setSortno(dto.getSortno());
				item.setCode_srv(formatCodeSrv(dto.getSrv_code()));
			}
			;
			rstList.add(item);
		}

		//setViewItemFromIE(rstList,ctx);//暂时注释
		return rstList.toArray(new OrdApBtViewItemDO[rstList.size()]);
	}

	private String formatCodeSrv(String code_srv) {
		if (CiOrdUtils.isEmpty(code_srv)) {
			return null;
		}
		return code_srv.substring(3);
	}

	/**
	 * 从IE平台取回检验结果值
	 * @param ordbtitemlist
	 * @param ctx
	 * @throws BizException
	 */
	private void setViewItemFromIE(List<OrdApBtViewItemDO> ordbtitemlist, CiEnContextDTO ctx) throws BizException {
		ICiIEMainService ieMgrService = ServiceFinder.find(ICiIEMainService.class);
		if (ieMgrService == null)
			return;
		FArrayList paramList = new FArrayList();
		for (OrdApBtViewItemDO btitem : ordbtitemlist) {
			IELisQryItemInDTO ieitemdto = new IELisQryItemInDTO();
			ieitemdto.setDomainid("01");
			ieitemdto.setPatientid(ctx.getCode_pat());
			ieitemdto.setTestdetailitemcode(btitem.getCode_srv());
			ieitemdto.setHospitalcode(ctx.getCode_org());
			ieitemdto.setHospitalname(ctx.getName_org());
			paramList.add(ieitemdto);
		}
		try{
			long tBeginTime = System.currentTimeMillis();
			IELisQryOutDTO rtndto=ieMgrService.ieLisQry(paramList);
			OrdBizLogger.info(ctx, String.format("备血医嘱获取动态指标值,耗时:%s(ms)", System.currentTimeMillis()-tBeginTime));
			if(rtndto==null && rtndto.getItems().size()<1)return;
			FArrayList2 rtnitemlist=rtndto.getItems();
			for(Object rtnitemdto:rtnitemlist){
				IELisQryItemInDTO rtnitem=(IELisQryItemInDTO)rtnitemdto;
				for(OrdApBtViewItemDO btitem:ordbtitemlist){
					if(btitem.getCode_srv().equals(rtnitem.getTestdetailitemcode())){
						btitem.setVal_rstrptla(rtnitem.getTestresult());
						break;
					}
				}
			}
		}catch(Exception e){
			e.getMessage();
		}
	}

	private MedsrvbloodquancanapDO[] getBooldQuan(String id_srv) throws BizException{
		IMedsrvbloodquancanapRService service = ServiceFinder.find(IMedsrvbloodquancanapRService.class);
		String wherestr=String.format("id_srv='%s'", id_srv);
		return service.find(wherestr, "quan_blood", FBoolean.FALSE);
	}
}
