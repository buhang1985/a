package iih.ci.ord.s.ems.op.ems.pathgy;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.cior.d.CiorapppathgyAggDO;
import iih.ci.ord.cior.d.OrdApPathgySampDO;
import iih.ci.ord.ciordems.d.EmsItemInPathgy;
import iih.ci.ord.ciordems.d.EmsObsLap;
import iih.ci.ord.ciordems.d.EmsPathgyItemDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.i.meta.EmsLoadDTO;
import iih.ci.ord.i.meta.EmsRstDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import iih.ci.ord.s.ems.meta.DiagOutlineInfo;
import iih.ci.ord.s.ems.op.base.OpBaseEmsLoadBP;
import iih.ci.ord.s.ems.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.utils.DiagInfoUtils;
import iih.ci.ord.s.ems.utils.OrderEmsExtInfoUtils;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 病理医疗单加载逻辑
 * 
 * @author wangqingzhu
 *
 */
public class EmsPathgyLoadBP extends OpBaseEmsLoadBP {

	@Override
	public EmsRstDTO[] load(CiEnContextDTO ctx, EmsLoadDTO[] args) throws BizException {
		EmsRstDTO[] rsts = super.load(ctx,args);
		EmsRstDTO rst = rsts[0];
		EmsLoadDTO arg = args[0];
		// 获取医疗单 DTO对象结构
		CiEmsDTO ciEmsInfo = ciEmsInfoFrom(arg.getId_or());
		if (null == ciEmsInfo) {
			throw new BizException("获取医疗单信息失败", CiOrdemsErrorCodeEnum.ERRORCODE_ORDER_ISNULL);
		}

		EmsPathgyItemDO ems = modelFrom(ctx, ciEmsInfo);

		MedsrvAggDO medSrvAggInfo = ServiceFinder.find(IMedsrvRService.class).findById(ciEmsInfo.getId_srv());

		// 计算价格
		ems.setPrice(this.calculatePrice(medSrvAggInfo.getParentDO(), null));

		// 医疗单对象
		OrderEmsExtInfoUtils.SetCustomInfo(rst, ciEmsInfo);
		// 主服务对象
		OrderEmsExtInfoUtils.SetCustomInfo(rst, medSrvAggInfo.getParentDO());

		// 获取执行科室
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ctx, medSrvAggInfo.getParentDO().getId_srv(), "","","",medSrvAggInfo.getParentDO().getFg_long(),FBoolean.FALSE,ems.getDt_begin_ui());
		if (!CiOrdUtils.isEmpty(wf)) {
			// 封装错误信息
 			//FArrayList errorlist=new FArrayList();
			//errorlist.append("获取执行科室失败");
			//OrderEmsExtInfoUtils.SetErrMsg(rst, errorlist);
 			//return rsts;
		// 保存执行科室过滤条件
 			if("1".equals(wf.getMp_source())){
 				OrderEmsExtInfoUtils.SetMpDepFilter(rst, null);
 			}else{
 				OrderEmsExtInfoUtils.SetMpDepFilter(rst, CiOrdUtils.isEmpty(wf.getId_mp_depts())?null:wf.getId_mp_depts());
 			}
		// 保存物资流向
		OrderEmsExtInfoUtils.SetWhDepFilter(rst, wf.getId_dept_whs());
		OrderEmsExtInfoUtils.SetWhDepId(rst, wf.getId_dept_wh());
		OrderEmsExtInfoUtils.SetWhDepName(rst, wf.getName_dept_wh());
 		}
 		

		// 医疗单模型文档
		rst.setDocument(handleReturnDocument(ems));
		// rst.setDocumentString(StringCodingUtils.Utf8_Base64_Encode(ems.serializeJson()));
		// 医疗单类型
		rst.getDriverInfo().setEmsBackendDriver(EmsType.PATHGY.toString());
		return rsts;
	}

	public EmsPathgyItemDO modelFrom(CiEnContextDTO ctx, CiEmsDTO dto) throws BizException {
		EmsPathgyItemDO ems = new EmsPathgyItemDO();
		ems.setDt_begin_ui(dto.getDt_begin());
		ems.setDt_end_ui(dto.getDt_end());
		ems.setUse_days(dto.getDays_or());
		ems.setTimes_cur(dto.getTimes_cur());
		ems.setTimes_mp_in(dto.getTimes_mp_in());
		//ems.setFg_selfpay((dto.getEu_hpindicjudge() == HpIndicJudgeEnum.SELFPAY ? FBoolean.TRUE : FBoolean.FALSE));
		
		ems.setEu_hpjudge(dto.getEu_hpjudge());
		ems.setEu_orhp(dto.getEu_orhp());
		
		ems.setId_didef(dto.getId_didef());
		
		if (!dto.getOrapplysheet().containsKey(EmsType.PATHGY.toString())) {
			throw new BizException("", CiOrdemsErrorCodeEnum.ERRORCODE_EMS_APPSHEET_NULL);
		}

		CiorapppathgyAggDO agg = (CiorapppathgyAggDO) dto.getOrapplysheet().get(EmsType.PATHGY.toString());
		constructEmsPathgyItemInfo(ctx, ems, agg, dto);
		if (agg.getOrdApPathgySampDO() != null) {
			ems.setEmsItemInpathgyList(emsPathgyItemInfoFrom(agg, dto));
		}

		return ems;
	}

	private void constructEmsPathgyItemInfo(CiEnContextDTO ctx, EmsPathgyItemDO ems, CiorapppathgyAggDO agg,
			CiEmsDTO dto) throws BizException {

		CiEmsSrvDTO mainSrvInfo = this.mainSrvInfoFrom(ctx, dto);

		ems.setId_or(dto.getId_or());
		ems.setId_srv(mainSrvInfo.getId_srv());// 服务id REF 医疗服务 20 医疗服务
		ems.setName_srv(mainSrvInfo.getName_srv());// 病理项目 SINGLE String 50
		ems.setId_di(agg.getParentDO().getId_di());// 诊断id REF 医疗服务_疾病诊断定
		ems.setName_diag(agg.getParentDO().getName_diag());// 诊断 SINGLE String
															// 50
		ems.setId_diitm(agg.getParentDO().getId_diitm());
		DiagOutlineInfo diagOutlineInfo = DiagInfoUtils.GetDiagOutLineInfo(ctx.getId_en());
		if (diagOutlineInfo != null) {
			ems.setStr_code_di(diagOutlineInfo.getStr_code_di());// 诊断编码拼接
			ems.setStr_name_di(diagOutlineInfo.getStr_name_di());// 诊断名称拼接
			ems.setStr_id_diitm(diagOutlineInfo.getStr_id_diitm());// 诊断子项目id拼接
		}
		ems.setFg_urgent(agg.getParentDO().getFg_urgent());// 加急标识 SINGLE
															// FBoolean
		ems.setId_samptp(agg.getParentDO().getId_samptp());// 标本类型id REF
															// 标本类型_自定义档案
		ems.setSd_samptp(agg.getParentDO().getSd_samptp());// 标本类型编码 SINGLE
															// String 50
		ems.setName_samptp(agg.getParentDO().getName_samptp());// 标本类型 SINGLE
																// String 50
		ems.setId_dep_coll(agg.getParentDO().getId_dep());// 标本采集科室id REF 部门 20
		ems.setName_dep_coll(agg.getParentDO().getName_dep());// 标本采集科室 SINGLE
																// String
		ems.setId_emp_coll(agg.getParentDO().getId_emp());// 采集者id REF 人员基本信息 20
		ems.setName_emp_coll(agg.getParentDO().getName_coll_emp());// 采集者 SINGLE
																	// String 50
		ems.setDt_coll(agg.getParentDO().getDt_coll());// 采集时间 SINGLE FDateTime
		ems.setAnnouncements(agg.getParentDO().getAnnouncements());// 检查要求
																	// SINGLE
																	// String
																	// 150
		ems.setDes_sympsign(agg.getParentDO().getDes_sympsign());// 病情描述 SINGLE
																	// 备注 300
		ems.setFg_outer(agg.getParentDO().getFg_outer());// 外院标志 SINGLE FBoolean
		ems.setNo_pathgy_old(agg.getParentDO().getNo_pathgy_old());// 既往病理号
																	// SINGLE
																	// String
		ems.setId_di_pathgy_old(agg.getParentDO().getDi_pathgy_old());// 既往病理诊断id
																		// REF
																		// 医疗服务_疾病诊
		ems.setName_di_pathgy_old(agg.getParentDO().getDi_pathgy_old());// 既往病理诊断
																		// REF
																		// 医疗服务_疾病诊
		ems.setNo_pathgy(agg.getParentDO().getNo_pathgy());// 病理号
		// ems.setName_di_pathgy_old (
		// agg.getParentDO().getName_pathgy_old());//既往病理诊断 SINGLE String
		ems.setOrg_pathgy_old(agg.getParentDO().getOrg_pathgy_old());// 既往病理医院
																		// SINGLE
																		// String
		ems.setDt_pathgy_old(agg.getParentDO().getDt_pathgy_old());// 既往病理日期
																	// SINGLE
																	// FDateTim
		ems.setCollectdes(agg.getParentDO().getCollectdes());// 采集所见 SINGLE
																// String 50

		// ems.setId_ordpathgyitem ( path.Id_appathgy;// 主键 SINGLE String 50
		// ems.setId_or ( path.Id_or; // 医嘱id SINGLE String 20
		ems.setId_orsrv(mainSrvInfo.getId_orsrv()); // 医嘱服务id SINGLE String 50
		ems.setNo_applyform(agg.getParentDO().getNo_applyform());// 申请单号 SINGLE
																	// String 50
		ems.setDt_create(dto.getDt_begin());// 申请时间 SINGLE FDateTime
		ems.setId_emp_create(dto.getId_emp_phy());// 申请医生id REF 用户 20
		ems.setName_emp_create(dto.getName_emp_phy());// 申请医师 SINGLE String 50
		// ems.setNo_pathgy ( path.No_pathgy;//病理号 SINGLE String 50
		ems.setDt_rptpathgy(agg.getParentDO().getDt_rptpathgy());// 报告发布时间
																	// SINGLE
																	// FDateTim
		// ems.setStr_id_di ( agg.getParentDO().getStr_code_di());//诊断idi拼接字符串
		// SINGLE Stri
		// ems.setStr_name_di ( agg.getParentDO().getStr_name_di());//诊断名字拼接字符串
		// SINGLE Stri
		// ems.setSv ( path.Sv; // 版本号
		ems.setId_mp_dep(dto.getId_dep_mp());
		ems.setName_mp_dep(dto.getName_dep_mp());
		ems.setDt_begin_ui(dto.getDt_begin());
		ems.setDt_end_ui(dto.getDt_end());
		ems.setTimes_cur(dto.getTimes_cur());
		ems.setTimes_mp_in(dto.getTimes_mp_in());
		ems.setUse_days(dto.getDays_or());

		ems.setDef1(agg.getParentDO().getDef1());
		ems.setDef2(agg.getParentDO().getDef2());
		ems.setDef3(agg.getParentDO().getDef3());
		ems.setDef4(agg.getParentDO().getDef4());
		ems.setDef5(agg.getParentDO().getDef5());
		ems.setDef6(agg.getParentDO().getDef6());
		ems.setDef7(agg.getParentDO().getDef7());
		ems.setDef8(agg.getParentDO().getDef8());
		ems.setDef9(agg.getParentDO().getDef9());
		ems.setDef10(agg.getParentDO().getDef10());
		ems.setDef11(agg.getParentDO().getDef11());
		ems.setDef12(agg.getParentDO().getDef12());
		ems.setDef13(agg.getParentDO().getDef13());
		ems.setDef14(agg.getParentDO().getDef14());
		ems.setDef15(agg.getParentDO().getDef15());
		ems.setDef16(agg.getParentDO().getDef16());
		ems.setDef17(agg.getParentDO().getDef17());
		ems.setDef18(agg.getParentDO().getDef18());
		ems.setDef19(agg.getParentDO().getDef19());
		ems.setDef20(agg.getParentDO().getDef20());
		ems.setDef21(agg.getParentDO().getDef21());
		ems.setDef22(agg.getParentDO().getDef22());
		ems.setDef23(agg.getParentDO().getDef23());
		ems.setDef24(agg.getParentDO().getDef24());
		ems.setDef25(agg.getParentDO().getDef25());
		ems.setDef26(agg.getParentDO().getDef26());
		ems.setDef27(agg.getParentDO().getDef27());
		ems.setDef28(agg.getParentDO().getDef28());
		ems.setDef29(agg.getParentDO().getDef29());
		ems.setDef30(agg.getParentDO().getDef30());
		ems.setDef31(agg.getParentDO().getDef31());
		ems.setDef32(agg.getParentDO().getDef32());
		ems.setDef33(agg.getParentDO().getDef33());
		ems.setDef34(agg.getParentDO().getDef34());
		ems.setDef35(agg.getParentDO().getDef35());
		ems.setDef36(agg.getParentDO().getDef36());
		ems.setDef37(agg.getParentDO().getDef37());
		ems.setDef38(agg.getParentDO().getDef38());
		ems.setDef39(agg.getParentDO().getDef39());
		ems.setDef40(agg.getParentDO().getDef40());
		ems.setDef41(agg.getParentDO().getDef41());
		ems.setDef42(agg.getParentDO().getDef42());
		ems.setDef43(agg.getParentDO().getDef43());
		ems.setDef44(agg.getParentDO().getDef44());
		ems.setDef45(agg.getParentDO().getDef45());
		ems.setDef46(agg.getParentDO().getDef46());
		ems.setDef47(agg.getParentDO().getDef47());
		ems.setDef48(agg.getParentDO().getDef48());
		ems.setDef49(agg.getParentDO().getDef49());
		ems.setDef50(agg.getParentDO().getDef50());

		// 超量用药原因
		ems.setId_excessive_reason(dto.getId_excessive_reason());
		ems.setSd_excessive_reason(dto.getSd_excessive_reason());
		ems.setName_excessive_reason(dto.getName_excessive_reason());
		//临床症状及体征
		ems.setClinicalzztz(agg.getParentDO().getClinicalzztz());
		ems.setStatus(DOStatus.UPDATED);
	}

	/**
	 * 编辑 病理标本信息对照
	 * 
	 * @param agg
	 * @param dto
	 * @return
	 */
	private FArrayList emsPathgyItemInfoFrom(CiorapppathgyAggDO agg, CiEmsDTO dto) {
		FArrayList emsItemInPathgyInfoList = new FArrayList();
		for (OrdApPathgySampDO item : agg.getOrdApPathgySampDO()) {

			EmsItemInPathgy emsItemInPathgyInfo = new EmsItemInPathgy();
			emsItemInPathgyInfo.setId_oriteminpathgy(item.getId_appathgysamp());// 主键
																				// SINGLE
																				// Str
			emsItemInPathgyInfo.setId_or(dto.getId_or());// // 医嘱主键 SINGLE
			emsItemInPathgyInfo.setName_labsamp(item.getName_labsamp());// 标本名称
																		// SINGLE
			emsItemInPathgyInfo.setBody_coll(item.getBody_coll());// 采集部位 SINGLE
			emsItemInPathgyInfo.setId_body_coll(item.getId_body_coll());//采集部位Id
			emsItemInPathgyInfo.setSd_body_coll(item.getSd_body_coll());//采集部位Sd
			emsItemInPathgyInfo.setQuan_coll(item.getQuan_coll());// 标本数量 SINGLE
			emsItemInPathgyInfo.setFixative(item.getFixative()); // 固定液 SINGLE
			emsItemInPathgyInfo.setId_fixative(item.getId_fixative());//固定液Id
			emsItemInPathgyInfo.setSd_fixative(item.getSd_fixative());//固定液Sd
																	// Int
			// Collectdes =item.,// 采集所见 SINGLE
			// Dt_coll =item.Dt_coll,// 采集时间 SINGLE
			// Id_emp_coll =item.,// 采集者编码 REF 用户
			// Name_emp_coll =item.,// 采集者名称 SINGLE
			emsItemInPathgyInfo.setSortno(item.getSortno());// 序号 SINGLE Int
			emsItemInPathgyInfo.setId_su_labsamp(item.getId_su_labsamp());// 标本状态id
																			// SINGLE
			emsItemInPathgyInfo.setSd_su_labsamp(item.getSd_su_labsamp());// 标本状态编码
																			// SIN
			emsItemInPathgyInfo.setId_dep_sign(item.getId_dep_sign());// 标本签收科室
																		// REF
			emsItemInPathgyInfo.setId_emp_sign(item.getId_emp_sign());// 标本签收人
																		// REF
																		// 用户
			emsItemInPathgyInfoList.append(emsItemInPathgyInfo);
		}

		return emsItemInPathgyInfoList;
	}

	/**
	 * 医嘱服务计算价格（非物品计价）
	 * 
	 * @param medsrv
	 * @param emsOrObsList
	 * @return
	 * @throws BizException
	 */
	public FDouble calculatePrice(MedSrvDO medsrv, FArrayList emsOrObsList) throws BizException {
		BdSrvPriCalParamDTO priParam = new BdSrvPriCalParamDTO();
		int iNumber = 0;

		priParam.setId_srv(medsrv.getId_srv());
		priParam.setId_primd(medsrv.getId_primd());
		priParam.setNum(iNumber);
		if (emsOrObsList != null) {
			FArrayList setItemSrvList = new FArrayList();
			for (Object obLap : emsOrObsList) {
				EmsObsLap lap = (EmsObsLap) obLap;
				if (CiOrdUtils.isTrue(lap.getFg_chk())) {
					iNumber++;
					BdSrvPriCalParamDTO param = new BdSrvPriCalParamDTO();
					param.setId_srv(lap.getId_srv());
					param.setId_primd(lap.getId_primd());
					param.setNum(1);
					setItemSrvList.append(param);
				}
			}
			priParam.setNum(iNumber);
			priParam.setSrvsetitms(setItemSrvList);
		}

		FDouble price = ServiceFinder.find(ICiOrdQryService.class).ciOrBdSrvPriceCal(priParam);
		if (price != null) {
			return price;
		}

		return FDouble.ZERO_DBL;
	}
}
