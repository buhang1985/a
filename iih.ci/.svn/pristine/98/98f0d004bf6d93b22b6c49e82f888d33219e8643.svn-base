package iih.ci.ord.s.ems.op.ems.opr;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.cior.d.OrdApSugViewItemDO;
import iih.ci.ord.cior.d.OrdOpEmpDO;
import iih.ci.ord.cior.d.OrdOpMmDO;
import iih.ci.ord.ciordems.d.EmsItemInOp;
import iih.ci.ord.ciordems.d.EmsOpitemDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
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
import xap.mw.coreitf.i.IBaseDO;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 手术医疗单的加载逻辑
 * 
 * @author wangqingzhu
 *
 */
public class EmsOprLoadBP extends OpBaseEmsLoadBP {

	@Override
	public EmsRstDTO[] load(CiEnContextDTO ctx, EmsLoadDTO[] args) throws BizException {
		EmsRstDTO[] rsts = super.load(ctx, args);
		EmsLoadDTO arg = args[0];
		EmsRstDTO rst = rsts[0];
		// 获取医疗单 DTO对象结构
		CiEmsDTO ciEmsInfo = ciEmsInfoFrom(arg.getId_or());		
		if (null == ciEmsInfo) {
			throw new BizException("获取医疗单信息失败", CiOrdemsErrorCodeEnum.ERRORCODE_ORDER_ISNULL);
		}
		MedsrvAggDO medSrvAggInfo = ServiceFinder.find(IMedsrvRService.class).findById(ciEmsInfo.getId_srv());

		EmsOpitemDO ems = emsOpitemInfoFrom(ctx, ciEmsInfo);
		ems.setEu_blmd(medSrvAggInfo.getParentDO().getEu_blmd());
		ems.setId_srvof(ciEmsInfo.getId_srvof());
		// 医疗单对象
		OrderEmsExtInfoUtils.SetCustomInfo(rst, ciEmsInfo);
		// 主服务对象
		OrderEmsExtInfoUtils.SetCustomInfo(rst, medSrvAggInfo.getParentDO());

		// 获取执行科室
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ctx, medSrvAggInfo.getParentDO().getId_srv(), "","","",medSrvAggInfo.getParentDO().getFg_long(),FBoolean.FALSE,ems.getDt_begin_ui());
		if (!CiOrdUtils.isEmpty(wf)) {
			// 封装错误信息
 			//FArrayList errorlist=new FArrayList();
			//errorlist.add("获取执行科室失败");
			//OrderEmsExtInfoUtils.SetErrMsg(rst, errorlist);
 			//return rsts;
		// 保存执行科室过滤条件
 			if("1".equals(wf.getMp_source())){
				OrderEmsExtInfoUtils.SetMpDepFilter(rst, null);
			}else{
				OrderEmsExtInfoUtils.SetMpDepFilter(rst, CiOrdUtils.isEmpty(wf.getId_mp_depts())?null:wf.getId_mp_depts());
			}
		// 保存物资流向
 	 		OrderEmsExtInfoUtils.SetWhDepFilter(rst, CiOrdUtils.isEmpty(wf.getId_dept_whs())?null:wf.getId_dept_whs());
		OrderEmsExtInfoUtils.SetWhDepId(rst, wf.getId_dept_wh());
		OrderEmsExtInfoUtils.SetWhDepName(rst, wf.getName_dept_wh());

 		}
 		
 		
		// 医疗单模型文档
		rst.setDocument(handleReturnDocument(ems));
		// rst.setDocumentString(StringCodingUtils.Utf8_Base64_Encode(ems.serializeJson()));
		// 医疗单类型
		rst.getDriverInfo().setEmsBackendDriver(EmsType.OPER.toString());
		return rsts;
	}

	/**
	 * 构建手术医疗单主模型信息
	 * 
	 * @param ctx
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public EmsOpitemDO emsOpitemInfoFrom(CiEnContextDTO ctx, CiEmsDTO dto) throws BizException {
		//
		EmsOpitemDO ems = new EmsOpitemDO();

		// 获取医疗单服务项目中的主服务
		CiEmsSrvDTO mainSrvInfo = this.mainSrvInfoFrom(ctx, dto);
		if (mainSrvInfo == null) {
			throw new BizException("解析手术医疗单时候，没有获取到主服务项目", CiOrdemsErrorCodeEnum.ERRORCODE_EMS_MAINSRV_NULL);
		}

		CiorappsurgeryAggDO orAppSurgeryAggInfo = (CiorappsurgeryAggDO) dto.getOrapplysheet()
				.get((EmsType.OPER).toString());
		if (orAppSurgeryAggInfo == null) {
			throw new BizException("解析手术医疗单时候，没有获取到申请单信息", CiOrdemsErrorCodeEnum.ERRORCODE_EMS_APPSHEET_NULL);
		}
		ems.setId_or(dto.getId_or());
		ems.setId_mp_dep(mainSrvInfo.getId_dep());
		ems.setName_mp_dep(mainSrvInfo.getName_dep());
		ems.setId_srv(dto.getId_srv());
		ems.setName_srv(dto.getName());
		ems.setId_orsrv(mainSrvInfo.getId_orsrv());

		ems.setSd_srvtp(mainSrvInfo.getSd_srvtp());
		ems.setId_didef(dto.getId_didef());
		ems.setName_diag(dto.getName_didef());
		//添加超量开单原因（慢病标识）
		ems.setId_excessive_reason(dto.getId_excessive_reason());
		ems.setSd_excessive_reason(dto.getSd_excessive_reason());
		ems.setName_excessive_reason(dto.getName_excessive_reason());
		//获取手术感染标识和编码 名称
		OrdApOpDO opDO=(OrdApOpDO) orAppSurgeryAggInfo.getParent();
		ems.setFg_infection_sug(opDO.getFg_infection_sug());
		ems.setName_infectionca_sug(opDO.getName_infectionca_sug());
		ems.setSd_infectionca_sug(opDO.getSd_infectionca_sug());
		constructMainModelInfo(ctx, ems, dto, mainSrvInfo, orAppSurgeryAggInfo);
		constructApopEmpInfo(ems, orAppSurgeryAggInfo);
		ConstructApopMmInfo(ems, orAppSurgeryAggInfo);
		constructApopAppendInfo(ems, dto);
		constructIndicatorInfo(ems, orAppSurgeryAggInfo);
		opAppendItem2OpexInfo(ems,ems.getOpAppendList());
		ems.setStatus(DOStatus.UPDATED);
		ems.setFg_selfpay((dto.getEu_hpindicjudge() == HpIndicJudgeEnum.SELFPAY ? FBoolean.TRUE : FBoolean.FALSE));
		
		ems.setEu_hpjudge(dto.getEu_hpjudge());
		ems.setEu_orhp(dto.getEu_orhp());
		ems.setId_asa(opDO.getId_asa());
		ems.setSd_asa(opDO.getSd_asa());
		ems.setName_asa(opDO.getName_asa());
		
		return ems;
	}

	/**
	 * 构建主手术医疗单模型信息
	 * 
	 * @param ctx
	 * @param ems
	 * @param dto
	 * @param srvCommon
	 * @param orAppSurgeryAggInfo
	 * @throws BizException
	 */
	private void constructMainModelInfo(CiEnContextDTO ctx, EmsOpitemDO ems, CiEmsDTO dto, CiEmsSrvDTO srvCommon,
			CiorappsurgeryAggDO orAppSurgeryAggInfo) throws BizException {

		OrdApOpDO op = orAppSurgeryAggInfo.getParentDO();

		ems.setId_apop(op.getId_apop());
		// 麻醉方法
		ems.setId_anestp(op.getId_anestp());
		ems.setSd_anestp(op.getSd_anestp());
		ems.setName_anestp(op.getName_anestp());
		ems.setId_di(op.getId_di());
		ems.setName_diag(op.getName_didef_dis());
		// 诊断信息
		ems.setId_di(op.getId_di());// 主诊断的主项目id
		ems.setId_diitm(op.getId_diitm());// 主诊断id
		ems.setName_diag(op.getName_diag());// 主诊断名称
		DiagOutlineInfo diagOutlineInfo = DiagInfoUtils.GetDiagOutLineInfo(ctx.getId_en());
		if (diagOutlineInfo != null) {
			ems.setStr_code_di(diagOutlineInfo.getStr_code_di());// 诊断编码拼接
			ems.setStr_name_di(diagOutlineInfo.getStr_name_di());// 诊断名称拼接
			ems.setStr_id_diitm(diagOutlineInfo.getStr_id_diitm());// 诊断子项目id拼接
		}
		// Id_diitm = null,
		ems.setId_emp_help1(op.getId_emp_helper());
		ems.setName_emp_help1(op.getName_helper());
		ems.setId_emp_operator(op.getId_emp_operate());
		ems.setName_emp_operator(op.getName_operate());
		// 切口愈合等级
		ems.setId_incitp(op.getId_incitp());
		ems.setSd_incitp(op.getSd_incitp());
		// 手术级别
		ems.setId_lvlsug(op.getId_lvlsug());
		ems.setSd_lvlsug(op.getSd_lvlsug());
		ems.setName_lvlsug(op.getName_lvlsug());
		// emsHeadDO.Id_or ( op.getId_or());

		ems.setCode_srv(op.getId_srv_code());
		// 体位
		ems.setId_sugbodycod(op.getId_sugbody());
		ems.setSd_sugbodycod(op.getSd_sugbody());
		ems.setName_sugbodycod(op.getName_sugbody());
		// 手术申请状态
		// Id_su_op ( null,
		// Sd_su_op ( null,
		ems.setFg_allergy(op.getFg_allergy());
		//药物过敏信息
		ems.setDes_allergy(op.getDes_allergy());
		ems.setFg_new_sug(op.getFg_new_sug());
		ems.setFg_patho(op.getFg_patho());
		ems.setFg_er_sug(op.getFg_er_sug());
		ems.setFg_xq_sug(op.getFg_xq_sug());
		ems.setFg_zq_sug(op.getFg_zq_sug());
		ems.setDt_plan(op.getDt_plan());
		ems.setDt_creat(dto.getDt_begin());
		ems.setNo_applyform(op.getNo_applyform());
		ems.setQuan_bt_plan(op.getQuan_bt_paln());
		ems.setTime_sup_plan(op.getSugplantime());
		ems.setSpecialdes(op.getSpecialdes());
		ems.setSpecialinstrument(op.getSpecialinstrument());
		ems.setSpecialreq(op.getSpecialreq());
		ems.setAnnouncements(op.getAnnouncements());
		ems.setStatus(DOStatus.UNCHANGED);
		ems.setPrice(srvCommon.getPrice());
		//ems.setDes(op.getAnnouncements());
		ems.setDes(dto.getDes_or());//	0122645: 门急诊医生站开手术描述问题    加载手术医疗单时 获取的字段不正确
		// 剂量和频次信息
		ems.setId_unit_med(srvCommon.getId_unit_med());
		ems.setName_unit_med(srvCommon.getName_unit_med());
		ems.setQuan_med(srvCommon.getQuan_med());
		ems.setId_freq(srvCommon.getId_freq());
		ems.setName_freq(srvCommon.getName_freq());
		ems.setFreqct(srvCommon.getFreqct());
		ems.setId_surgical_site(op.getId_surgical_site());
		ems.setSd_surgical_site(op.getSd_surgical_site());
		ems.setName_surgical_site(op.getName_surgical_site());
		ems.setFg_urgent(dto.getFg_urgent());
		ems.setFg_selfpay((FBoolean.TRUE.equals(dto.getFg_orhp()) ? FBoolean.FALSE : FBoolean.TRUE));
	}

	/**
	 * 构建手术人员信息
	 * 
	 * @param ems
	 * @param orAppSurgeryAggInfo
	 */
	private void constructApopEmpInfo(EmsOpitemDO ems, CiorappsurgeryAggDO orAppSurgeryAggInfo) {

		OrdOpEmpDO[] szOrdOpEmpInfo = orAppSurgeryAggInfo.getOrdOpEmpDO();
		if (szOrdOpEmpInfo == null)
			return;

		FArrayList listOpEmpItem = new FArrayList();
		for (OrdOpEmpDO emp : szOrdOpEmpInfo) {
			EmsItemInOp empItemInfo = new EmsItemInOp();

			empItemInfo.setId_oropitem(emp.getId_apopemp());
			empItemInfo.setId_emp_op(emp.getId_emp());
			empItemInfo.setName_emp_op(emp.getName_emp());
			empItemInfo.setId_role(emp.getId_role());
			empItemInfo.setSd_role(emp.getSd_role());
			empItemInfo.setName_role(emp.getName_role());
			empItemInfo.setStatus(DOStatus.UNCHANGED);
			empItemInfo.setSv(emp.getSv());

			listOpEmpItem.add(empItemInfo);

		}
		ems.setOpPersonList(listOpEmpItem);
	}

	/**
	 * 构建手术物品信息
	 * 
	 * @param ems
	 * @param orAppSurgeryAggInfo
	 */
	private void ConstructApopMmInfo(EmsOpitemDO ems, CiorappsurgeryAggDO orAppSurgeryAggInfo) {

		OrdOpMmDO[] szOrdOpMmInfo = orAppSurgeryAggInfo.getOrdOpMmDO();
		if (szOrdOpMmInfo == null)
			return;

		FArrayList listMmItem = new FArrayList();
		for (OrdOpMmDO mm : szOrdOpMmInfo) {
			EmsItemInOp mmItem = new EmsItemInOp();

			mmItem.setId_oropitem(mm.getId_apopmm());
			mmItem.setId_mm(mm.getId_mm());
			mmItem.setName_mm(mm.getName_mm());
			mmItem.setId_mmtp(mm.getId_mmtp());
			mmItem.setSd_mmtp(mm.getSd_mmtp());
			mmItem.setName_mmtp(mm.getName_mmtp());
			mmItem.setSpec(mm.getSpec());
			mmItem.setId_sup(mm.getId_sup());
			mmItem.setName_sup(mm.getName_sug());
			mmItem.setPrice(mm.getPrice());
			mmItem.setQuan_cur(mm.getQuan_cur());
			mmItem.setId_unit_pkgsp(mm.getId_unit_pkgsp());
			mmItem.setName_unit_pkgsp(mm.getName_unit_pkgsp());
			mmItem.setStatus(DOStatus.UNCHANGED);

			listMmItem.add(mmItem);
			ems.setOpDrugList(listMmItem);
		}
	}

	/**
	 * 构建附加手术信息
	 * 
	 * @param ems
	 * @param dto
	 */
	private void constructApopAppendInfo(EmsOpitemDO ems, CiEmsDTO dto) {

		// 分拣附加手术项目：项目列表中，排除主医嘱项目，排除非临床项目 -- wangqzh
		FArrayList listAppendItem = new FArrayList();
		for (Object objInfo : dto.getEmssrvs()) {
			CiEmsSrvDTO srvInfo = (CiEmsSrvDTO) objInfo;

			if (!srvInfo.getId_srv().equals(dto.getId_srv()) && CiOrdUtils.isTrue(srvInfo.getFg_or())) {
				EmsItemInOp itemInfo = new EmsItemInOp();
				itemInfo.setName_srv(srvInfo.getName_srv());
				itemInfo.setId_srv(srvInfo.getId_srv());
				itemInfo.setCode_srv(srvInfo.getCode_srv());
				itemInfo.setDes_op(srvInfo.getDes_srv());
				itemInfo.setId_orsrv(srvInfo.getId_orsrv());
				itemInfo.setStatus(DOStatus.UNCHANGED);
				listAppendItem.add(itemInfo);
			}
		}
		ems.setOpAppendList(listAppendItem);

	}

	/**
	 * 构建动态指标信息
	 * 
	 * @param ems
	 * @param agg
	 */
	private void constructIndicatorInfo(EmsOpitemDO ems, CiorappsurgeryAggDO agg) {

		OrdApSugViewItemDO[] szOrdApSugViewItemInfo = agg.getOrdApSugViewItemDO();

		FArrayList listOpLabItem = new FArrayList();
		for (OrdApSugViewItemDO apSugItemInfo : szOrdApSugViewItemInfo) {
			OrdApSugViewItemDO apViewItemInfo = new OrdApSugViewItemDO();
			apViewItemInfo
					.setVal_rstrptla(apSugItemInfo.getVal_rstrptla() == null ? "" : apSugItemInfo.getVal_rstrptla());
			apViewItemInfo.setVal_restrptlab(apSugItemInfo.getVal_restrptlab() == null ? ""
					: apSugItemInfo.getVal_restrptlab().replace(',', '|'));
			apViewItemInfo.setSd_restrptlabtp(apSugItemInfo.getSd_restrptlabtp());
			apViewItemInfo.setName_srv(apSugItemInfo.getName_srv() == null ? "" : apSugItemInfo.getName_srv());
			apViewItemInfo.setName_unit(apSugItemInfo.getName_unit() == null ? "" : apSugItemInfo.getName_unit());
			apViewItemInfo.setId_unit(apSugItemInfo.getId_unit());
			apViewItemInfo.setId_srv(apSugItemInfo.getId_srv());
			apViewItemInfo.setId_apopobsindex(apSugItemInfo.getId_apopobsindex());
			apViewItemInfo.setId_apop(apSugItemInfo.getId_apop());
			apViewItemInfo.setSv(apSugItemInfo.getSv());
			apViewItemInfo.setId_restrptlabtp(apSugItemInfo.getId_restrptlabtp());
			apViewItemInfo.setDs(apSugItemInfo.getDs());
			apViewItemInfo.setStatus(DOStatus.UNCHANGED);
			apViewItemInfo.setId_apopobsindex(apSugItemInfo.getId_apopobsindex());
			listOpLabItem.add(apViewItemInfo);

		}
		ems.setOpCheckIndicatorList(listOpLabItem);

	}
	/**
	 * 附加手术集合信息
	 * @param ems
	 * @param listAppendItem
	 */
	 private void opAppendItem2OpexInfo(EmsOpitemDO ems,FArrayList listAppendItem)
     {
         String Code_opex_srvs = "";
         String Id_opex_srvs = "";
         String Name_opex_srvs = "";
         List<String> tmpFilterSameItem = new ArrayList<String>();
         for (Object itemObj : listAppendItem)
         {
        	 EmsItemInOp item = (EmsItemInOp)itemObj;
             if (item.getId_srv() != null && item.getCode_srv() != null && item.getName_srv() != null)
             {
                 if (tmpFilterSameItem.contains(item.getId_srv()))
                     continue;
                 tmpFilterSameItem.add(item.getId_srv());
                 Code_opex_srvs += item.getCode_srv() + ",";
                 Id_opex_srvs += item.getId_srv() + ",";
                 Name_opex_srvs += item.getName_srv() + ",";
             }
         }
         if (Code_opex_srvs.length() > 0)
        	 Code_opex_srvs = Code_opex_srvs.substring(0, Code_opex_srvs.length()-1);
         if (Id_opex_srvs.length() > 0)
        	 Id_opex_srvs = Id_opex_srvs.substring(0, Id_opex_srvs.length()-1);
         if (Name_opex_srvs.length() > 0)
        	 Name_opex_srvs = Name_opex_srvs.substring(0, Name_opex_srvs.length()-1);
         ems.setCode_opex_srvs(Code_opex_srvs);
         ems.setId_opex_srvs(Id_opex_srvs);
         ems.setName_opex_srvs(Name_opex_srvs);
     }
}
