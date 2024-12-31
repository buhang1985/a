package iih.ci.ord.s.ems.op.ems.apbt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.srv.dto.d.EmsDynamicParamDTO;
import iih.bd.srv.ems.d.EmsDynamicIndexDTO;
import iih.bd.srv.ems.d.EmsregistryAggDO;
import iih.bd.srv.ems.i.IEmsregistryRService;
import iih.bd.srv.i.IBdSrvQryService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.d.OrdApBtViewItemDO;
import iih.ci.ord.cior.i.ICiorappbtRService;
import iih.ci.ord.ciordems.d.EmsBtItemDO;
import iih.ci.ord.ciordems.d.EmsBuItemDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import iih.ci.ord.s.ems.meta.DiagOutlineInfo;
import iih.ci.ord.s.ems.op.base.OpBaseEmsLoadBP;
import iih.ci.ord.s.ems.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.utils.DiagInfoUtils;
import iih.ci.ord.s.ems.utils.OrderEmsExtInfoUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 备血医疗单加载逻辑
 * 
 * @author wangqingzhu
 *
 */
public class EmsApBtLoadBP extends OpBaseEmsLoadBP {

	@Override
	public EmsRstDTO[] load(CiEnContextDTO ctx, EmsLoadDTO[] args) throws BizException {
		// TODO Auto-generated method stub
		EmsLoadDTO arg = args[0];
		List<EmsRstDTO> rsts = new ArrayList<EmsRstDTO>();
		EmsRstDTO rst = new EmsRstDTO();

		// 获取医疗单 DTO对象结构
		CiEmsDTO ciEmsInfo = ciEmsInfoFrom(arg.getId_or());
		if (null == ciEmsInfo) {
			throw new BizException("获取医疗单信息失败", CiOrdemsErrorCodeEnum.ERRORCODE_ORDER_ISNULL);
		}

		MedSrvDO med = ServiceFinder.find(IMedsrvRService.class).findById(ciEmsInfo.getId_srv()).getParentDO();

		EmsBtItemDO ems = emsBtItemDOFrom(ctx, ciEmsInfo);
		// 医疗单对象
		OrderEmsExtInfoUtils.SetCustomInfo(rst, ciEmsInfo);
		// 主服务对象
		OrderEmsExtInfoUtils.SetCustomInfo(rst, med);

		// 用血模型对象
		OrderEmsExtInfoUtils.SetCustomInfo(rst, this.ciOrdubInfoFrom(arg.getId_or(), med));
		// 获取执行科室
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ctx, med.getId_srv(), "", "","",med.getFg_long(),FBoolean.FALSE,ems.getDt_begin_ui());
		if (!CiOrdUtils.isEmpty(wf)) {
			// 保存执行科室过滤条件
			OrderEmsExtInfoUtils.SetMpDepFilter(rst,
					CiOrdUtils.isEmpty(wf.getId_mp_depts()) ? null : wf.getId_mp_depts());

			// 保存物资流向
			OrderEmsExtInfoUtils.SetWhDepFilter(rst,
					CiOrdUtils.isEmpty(wf.getId_dept_whs()) ? null : wf.getId_dept_whs());
			OrderEmsExtInfoUtils.SetWhDepId(rst, wf.getId_dept_wh());
			OrderEmsExtInfoUtils.SetWhDepName(rst, wf.getName_dept_wh());
		}
		// 医疗单模型文档
		rst.setDocument(this.handleReturnDocument(ems));
		// rst.setDocumentString(StringCodingUtils.Utf8_Base64_Encode(ems.serializeJson()));
		// 医疗单类型
		rst.getDriverInfo().setEmsBackendDriver(EmsType.BT.toString());
		rsts.add(rst);
		return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
	}

	/**
	 * 构建备血申请单模型
	 * 
	 * @param ctx
	 * @param ciEmsInfo
	 * @return
	 * @throws BizException
	 */
	private EmsBtItemDO emsBtItemDOFrom(CiEnContextDTO ctx, CiEmsDTO dto) throws BizException {

		EmsBtItemDO ems = new EmsBtItemDO();

		ems.setDt_create(dto.getDt_begin());
		// 获取申请单信息
		Object objInfo = dto.getOrapplysheet().get((EmsType.BT).toString());
		if (null == objInfo) {
			throw new BizException("该医嘱存在异常，申请单信息丢失", -1001);
		}
		CiorappbtAggDO agg = (CiorappbtAggDO) objInfo;

		OrdApBtDO bt = agg.getParentDO();

        ems.setDt_bt(new FDateTime(bt.getDt_bt_pl()));
		// 列表中服务名称
		ems.setComponents_name(dto.getName());
		ems.setId_emsbt(bt.getId_apbt());
		ems.setNo_applyform(bt.getNo_applyform());
		ems.setPregnat_num(bt.getPregnant_num());
		ems.setParturition_cnt(bt.getParturition_cnt());

		ems.setFg_db(bt.getFg_db());
		ems.setNo_db(bt.getNo_db());

		// 诊断信息
		ems.setId_di(bt.getId_di());
		ems.setName_diag(bt.getName_diag());
		ems.setId_diitm(bt.getId_diitm());// 主诊断id

		DiagOutlineInfo diagOutlineInfo = DiagInfoUtils.GetDiagOutLineInfo(ctx.getId_en());
		if (diagOutlineInfo != null) {
			ems.setStr_code_di(diagOutlineInfo.getStr_code_di());// 诊断编码拼接
			ems.setStr_name_di(diagOutlineInfo.getStr_name_di());// 诊断名称拼接
			ems.setStr_id_diitm(diagOutlineInfo.getStr_id_diitm());// 诊断子项目id拼接
		}
		ems.setId_his_bt(bt.getId_his_bt());
		ems.setName_his_bt(bt.getName_his_bt());
		ems.setSd_his_bt(bt.getSd_his_bt());

		ems.setId_pps(bt.getId_pps_bt());
		ems.setName_pps(bt.getName_pps_bt());
		ems.setSd_pps(bt.getSd_pps_bt());

		ems.setId_labitmexplain(bt.getId_labitmexplain());
		ems.setName_labitmexplain(bt.getName_labitmexplain());
		ems.setSd_labitmexplain(bt.getSd_labitmexplain());

		ems.setId_demandsu(bt.getId_demandsu_bt());
		ems.setName_demandsu(bt.getName_demandsu_bt());
		ems.setSd_demandsu(bt.getSd_demandsu_bt());

		ems.setId_mode(bt.getId_mode_bt());
		ems.setName_mode(bt.getName_mode_bt());
		ems.setSd_mode(bt.getSd_mode_bt());
		ems.setName_emp_create(dto.getName_emp_phy());

        ems.setId_bloodtype_ap(bt.getId_bloodtype_ap());
        ems.setSd_bloodtype_ap(bt.getSd_bloodtype_ap());
        ems.setName_bloodtype_ap(bt.getName_bloodtp());
        ems.setId_rhd_ap(bt.getId_rhd_ap());
        ems.setSd_rhd_ap(bt.getSd_rhd_ap());
        ems.setName_rhd_ap(bt.getName_rhd());
        ems.setFg_newborn(bt.getFg_newborn());
		ems.setId_blodquan(bt.getId_blodquan());
		
		ems.setStatus(DOStatus.UPDATED);
		ems.setFg_selfpay((dto.getEu_hpindicjudge() == HpIndicJudgeEnum.SELFPAY ? FBoolean.TRUE : FBoolean.FALSE));
		// 科研项目信息
//		ems.setFg_research(dto.getFg_research()); // 科研用药标识
//		ems.setId_researchproject(dto.getId_researchproject()); // 科研用药id
//		ems.setCode_researchproject(dto.getCode_researchproject()); // 科研用药编码
//		ems.setName_researchproject(dto.getName_researchproject()); // 科研用药名称
//		ems.setPassword(dto.getPassword());
        
		CiEmsSrvDTO mainSrvInfo = this.mainSrvInfoFrom(ctx, dto);
		
		if(CiOrdUtils.isTrue(dto.getFg_set())){
			for (Object item : dto.getEmssrvs()){
			CiEmsSrvDTO srv = (CiEmsSrvDTO) item;
				if(srv.getId_srv_src().equals(dto.getId_srv()) && CiOrdUtils.isTrue(srv.getFg_or())){
					mainSrvInfo = srv;
					break;
				}
			}
		}
		
		ems.setId_srv(mainSrvInfo.getId_srv());
		ems.setName_srv(mainSrvInfo.getName_srv());
		ems.setSd_srvtp(mainSrvInfo.getSd_srvtp());
		ems.setInnercode_srvca(mainSrvInfo.getInnercode_srvca());

		ems.setId_emp_create(mainSrvInfo.getId_emp_srv());
		ems.setDt_create(mainSrvInfo.getDt_create_srv());

		ems.setQuan_med(mainSrvInfo.getQuan_med());
		ems.setId_unit_med(mainSrvInfo.getId_unit_med());
		ems.setName_unit_med(mainSrvInfo.getName_unit_med());
				// 执行科室
		ems.setId_mp_dep(mainSrvInfo.getId_dep());
		ems.setName_mp_dep(mainSrvInfo.getName_dep());
		
//		for (Object item : dto.getEmssrvs()) {
//			CiEmsSrvDTO srv = (CiEmsSrvDTO) item;
//			if(FBoolean.TRUE.equals(srv.getFg_set())){
//				ems.setId_srv(srv.getId_srv());
//				ems.setName_srv(srv.getName_srv());
//			}
//			if (srv.getId_srv().equals(dto.getId_srv())) {
//				ems.setId_srv(srv.getId_srv());
//				ems.setName_srv(srv.getName_srv());
//				ems.setSd_srvtp(srv.getSd_srvtp());
//				ems.setInnercode_srvca(srv.getInnercode_srvca());
//
//				ems.setId_emp_create(srv.getId_emp_srv());
//				ems.setDt_create(srv.getDt_create_srv());
//
//				ems.setQuan_med(srv.getQuan_med());
//				ems.setId_unit_med(srv.getId_unit_med());
//				ems.setName_unit_med(srv.getName_unit_med());
//				// 执行科室
//				ems.setId_mp_dep(srv.getId_dep());
//				ems.setName_mp_dep(srv.getName_dep());
//				break;
//			}
//		}
		ems.setQuan_blood(ems.getQuan_med().toString());
		//动态指标
		FArrayList ordApBtViewItemList = new FArrayList();
		for (OrdApBtViewItemDO itemdto : agg.getOrdApBtViewItemDO()) {
        	ordApBtViewItemList.add(itemdto);
		}
		ems.setBtLabItemEx(ordApBtViewItemList);
        ems.setFg_selfpay((dto.getEu_hpindicjudge()==HpIndicJudgeEnum.SELFPAY?FBoolean.TRUE:FBoolean.FALSE));
		return ems;

	}

	

	/**
	 * 获取备血申请单中的动态指标数据
	 * 
	 * @param agg
	 * @return
	 */
	private Map<String,OrdApBtViewItemDO> EditIndicatorDateSource(  CiorappbtAggDO agg) {

		if (agg == null)
			return null;
        
        Map<String,OrdApBtViewItemDO> tmpRstMap = new HashMap<String,OrdApBtViewItemDO>();

		OrdApBtViewItemDO[] szOrdApBtViewItem = agg.getOrdApBtViewItemDO();
        for (OrdApBtViewItemDO item : szOrdApBtViewItem){
			tmpRstMap.put(item.getId_srv(), item);
		}

		return tmpRstMap;
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
			}
			;
			rstList.add(item);
		}

		return rstList.toArray(new OrdApBtViewItemDO[rstList.size()]);
	}
	
	/**
	 * 构建用血医嘱模型数据
	 * @param id_or
	 * @param med
	 * @return
	 * @throws BizException
	 */
	private EmsBuItemDO ciOrdubInfoFrom(String id_or, MedSrvDO med) throws BizException {
		EmsBuItemDO apbu = new EmsBuItemDO();
		CiorderAggDO ciagg = ServiceFinder.find(ICiorderRService.class).findById(id_or);
		CiOrderDO ciOrder = ciagg.getParentDO();
		CiorappbtAggDO[] szApbtAggInfo = ServiceFinder.find(ICiorappbtRService.class).find("id_or='" + id_or + "'",
				null, FBoolean.FALSE);
		OrdApBtDO btdo = szApbtAggInfo[0].getParentDO();

		apbu.setId_or(ciOrder.getId_or());
		apbu.setNo_applyform_bt(btdo.getNo_applyform());
		apbu.setId_srv(ciOrder.getId_srv());
		apbu.setName_srv(ciagg.getOrdSrvDO()[0].getName());

		apbu.setQuan_medu_bt(ciagg.getOrdSrvDO()[0].getQuan_medu());
		apbu.setId_unit(ciagg.getOrdSrvDO()[0].getId_medu());
		apbu.setDt_pl_bt(new FDateTime(btdo.getDt_bt_pl()));
		apbu.setQuan_avi_bt(btdo.getNum_margin_bu());
		apbu.setId_emp_bu(ciOrder.getId_emp_sign());
		apbu.setName_emp_bu(ciOrder.getEmp_sign_name());
		apbu.setId_route(med.getId_route());
		apbu.setName_route(med.getRoute_name());
		apbu.setQuan_medu_bu(apbu.getQuan_medu_bt());
		apbu.setId_unit(med.getId_unit_med());
		apbu.setName_unit(ciagg.getOrdSrvDO()[0].getMedu_name());

		return apbu;
	}

}
