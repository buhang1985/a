package iih.ci.ord.s.external.blood.ruimei.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.res.deptb.d.DeptBDO;
import iih.bd.res.deptb.i.IDeptbRService;
import iih.bd.srv.ems.d.SrvMatchEmsParamDTO;
import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.bd.srv.ems.i.IEmsManagementService;
import iih.bd.srv.medsrv.d.MedSrvBlModeEnum;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.external.blood.ruimei.d.IEOpBtOrEnParamDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.sdk.utils.StringUtils;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsndocAggDO;
import xap.sys.bdfw.bbd.i.IPsndocRService;
import xap.sys.custcfg.billcode.i.IBillcodeManage;

public class SavewritebackPBTDataBp {
	
	private String errorInfo = "HIS中未维护备血申请服务！请在参数模板LL_CIOR0424中维护服务编码";
	/**
	 * 保存备血申请主入口
	 * 
	 * @param param
	 * @throws BizException
	 */
	public void exec(IEOpBtOrEnParamDTO param) throws BizException {

		// 底层服务类保存方法
		ICiorderCudService aggservice = ServiceFinder.find(ICiorderCudService.class);

		// 患者就诊号取出来去查询患者信息
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO[] visitDOS = service.find("code = '" + param.getCode_ent() + "' and code_entp = '"
				+ IBdFcDictCodeConst.SD_CODE_ENTP_IP + "' and fg_ip = '" + FBoolean.TRUE + "'", null, FBoolean.FALSE);
		if (visitDOS == null || visitDOS.length < 1) {
			throw new BizException("患者的就诊信息不存在");
		}
		// 患者住院信息
		IInpatientRService inpatientservice = ServiceFinder.find(IInpatientRService.class);
		InpatientDO[] inpatDOs = inpatientservice.find("code_amr_ip = '" + param.getCode_amr_ip() + "'", null,
				FBoolean.FALSE);
		if (inpatDOs == null || inpatDOs.length < 1) {
			throw new BizException("未填写住院号，请填写!");
		}
		// 开立医生
		IPsndocRService psndocservice = ServiceFinder.find(IPsndocRService.class);
		PsndocAggDO[] docAggDO = psndocservice.find("code='" + param.getCode_emp_or() + "'", null, FBoolean.FALSE);
		if (docAggDO == null || docAggDO.length < 1) {
			throw new BizException("未填写开立医生，请填写!");
		}
		// 部门表
		IDeptbRService deptbRSer = ServiceFinder.find(IDeptbRService.class);
		DeptBDO[] deptBDO = deptbRSer.find("code='" + param.getCode_dep() + "'", null, FBoolean.FALSE);
		if (deptBDO == null || deptBDO.length < 1) {
			throw new BizException("未填写部门信息，请填写!");
		}
		// 医疗服务
		/**
		 * 备血申请、用血申请iih不进行申请单号规则生成,申请单号就是存的血库的单号 2018/10/9 需求确认
		 */
		/*
		 * IMedsrvMDORService medsrvMDOservice =
		 * ServiceFinder.find(IMedsrvMDORService.class); MedSrvDO[] medSrvDO =
		 * medsrvMDOservice .find(
		 * "id_srv=(select ci.id_srv from ci_ap_bt bt left join ci_order ci on bt.id_or=ci.id_or where bt.no_applyform='"
		 * + param.getApplyno() + "')", null, FBoolean.FALSE); if (medSrvDO ==
		 * null) { throw new BizException("未填写备血医疗服务信息，请填写!"); }
		 */

		// 医疗服务
		
		String code_srv =BloodManageUtils.LL_CIOR0424();
		IMedsrvMDORService medsrvMDOservice = ServiceFinder.find(IMedsrvMDORService.class);
		MedSrvDO[] medSrvDO = medsrvMDOservice.find("code='"+code_srv+"'", null, FBoolean.FALSE);
		if(medSrvDO==null||medSrvDO.length==0)
		{
			throw new BizException(errorInfo);
		}
		// 回写到CiOrderDO
		CiOrderDO ciOrderDO2 = SetValue2CiOrderDO(param, visitDOS[0], docAggDO[0], deptBDO[0], medSrvDO[0]);

		OrdSrvDO[] ordSrvDO2 = SetValue2OrdSrvDO(param, visitDOS, deptBDO, docAggDO, ciOrderDO2, medSrvDO[0]);

		CiorderAggDO aggDO = new CiorderAggDO();
		aggDO.setParentDO(ciOrderDO2);
		aggDO.setOrdSrvDO(ordSrvDO2);
		// 保存对象
		aggservice.save(new CiorderAggDO[] { aggDO });

	}

	private CiOrderDO SetValue2CiOrderDO(IEOpBtOrEnParamDTO param, PatiVisitDO visitDO, PsndocAggDO docAggDO,
			DeptBDO deptBDO, MedSrvDO medSrvDO) throws BizException {
		// 备血字段回写到ci_order,ci_or_srv表中
		CiOrderDO ciOrderDO = new CiOrderDO();
		ciOrderDO = new CiOrderDO();
		ciOrderDO.setId_grp(visitDO.getId_grp());// 所属集团 当前就诊所在集团
		ciOrderDO.setId_org(visitDO.getId_org());// 所属组织 当前就诊所在组织
		ciOrderDO.setId_pat(visitDO.getId_pat());// 患者 当前就诊患者id
		ciOrderDO.setId_en(visitDO.getId_ent());// 就诊 当前就诊id
		ciOrderDO.setId_entp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);// 就诊类型 住院
																	// 10住院
		ciOrderDO.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);// 就诊类型编码
																	// 10
		ciOrderDO.setFg_set(FBoolean.FALSE);// 服务套标识
		ciOrderDO.setFg_long(FBoolean.FALSE);// 长临标识

		IBillcodeManage codeManage = ServiceFinder.find(IBillcodeManage.class);
//		String code_or = codeManage.getPreBillCode_RequiresNew(CiOrderDODesc.CLASS_FULLNAME);
		if(StringUtils.isEmptty(param.getCode_or())){
			String code_or = CiOrdAppUtils.getCiOrdQryService().getCodeOr();
			ciOrderDO.setCode_or(code_or);// 医嘱编码 编码规则生成
		}else{
			ciOrderDO.setCode_or(param.getCode_or());
		}
		ciOrderDO.setContent_or("0801||"+param.getName_or()+"&0.00&&|&&");// 医嘱内容// 按照嘱托规则构建

		ciOrderDO.setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);// 医嘱频次  once
																			
		ciOrderDO.setFg_boil(FBoolean.FALSE);// 代煎标识
		ciOrderDO.setId_su_or(ICiDictCodeConst.SD_SU_ID_SIGN);// 医嘱状态 10已签署
		ciOrderDO.setSd_su_or(ICiDictCodeConst.SD_SU_SIGN);// 医嘱状态编码 10
		ciOrderDO.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);// 执行状态
																	// 0未执行
		ciOrderDO.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);// 执行状态编码
		ciOrderDO.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);// 记账状态
																	// 0未记账
		ciOrderDO.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);// 记账状态编码 0
		ciOrderDO.setId_org_or(visitDO.getId_org());// 开立机构 当前就诊所在组织
		ciOrderDO.setId_dep_or(visitDO.getId_dep_phy());// 开立部门 当前就诊所在部门
		if (docAggDO != null && docAggDO.getParentDO() != null) {
			ciOrderDO.setId_emp_or(docAggDO.getParentDO().getId_psndoc());// 开立医生
			ciOrderDO.setId_emp_sign(docAggDO.getParentDO().getId_psndoc());// 签署医生
		}

		ciOrderDO.setDt_entry(new FDateTime(param.getDt_effe()));// 开立日期
		ciOrderDO.setDt_effe(new FDateTime(param.getDt_effe()));// 医嘱生效日期
		ciOrderDO.setDt_end(new FDateTime(param.getDt_effe()));// 医嘱结束时间
		ciOrderDO.setDt_last_bl(new FDateTime(param.getDt_effe()));// 最近生成日期

		ciOrderDO.setFg_sign(FBoolean.TRUE);// 签署标识 Y

		ciOrderDO.setId_dep_sign(visitDO.getId_dep_phy());// 签署部门
															// 当前就诊所在部门
		ciOrderDO.setDt_sign(BloodManageUtils.getServerDateTime());// 签署日期
																	// 当前系统时间

		ciOrderDO.setFg_chk(FBoolean.FALSE);// 核对标识
		ciOrderDO.setFg_stop(FBoolean.FALSE);// 停止标识
		ciOrderDO.setFg_mp_in(FBoolean.TRUE); // 在院执行标识 Y
		ciOrderDO.setTimes_mp_in(1);// 在院执行次数 1
		ciOrderDO.setFg_pkg(FBoolean.FALSE);// 服务包标识
		ciOrderDO.setName_or(param.getName_or()); // 医嘱名称 入参 --备血内容
		ciOrderDO.setFg_or_form(FBoolean.TRUE);// 医嘱单标识 Y
		ciOrderDO.setFg_pres_outp(FBoolean.FALSE);// 出院带药标识

		// 嘱托类医嘱对应医疗单
		SrvMatchEmsParamDTO paramDto = new SrvMatchEmsParamDTO();
		SrvMatchEmsRstDTO emsmatch = new SrvMatchEmsRstDTO();
		paramDto.setId_org(visitDO.getId_org());
		paramDto.setId_grp(visitDO.getId_grp());
		paramDto.setId_dept(visitDO.getId_dep_phy());
		paramDto.setId_emp(docAggDO.getParentDO().getId_psndoc());
		paramDto.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		if (medSrvDO != null) {
			paramDto.setSd_srvtp(medSrvDO.getSd_srvtp());
			paramDto.setId_srv(medSrvDO.getId_srv());
			ciOrderDO.setId_srvtp(medSrvDO.getId_srvtp());// 医嘱类型
			// 0801嘱托
			ciOrderDO.setId_srv(medSrvDO.getId_srv());// 医嘱服务类型Id
			ciOrderDO.setSd_srvtp(medSrvDO.getSd_srvtp());// 医嘱类型编码
			ciOrderDO.setId_srvca(medSrvDO.getId_srvca()); // 服务基本分类
		}
		paramDto.setDt_or(BloodManageUtils.getServerDateTime());// 系统时间
		paramDto.setEmsappmode(0);// 智慧版

		FMap map = ServiceFinder.find(IEmsManagementService.class)
				.medSrvMatchEms(new SrvMatchEmsParamDTO[] { paramDto });
		emsmatch = (SrvMatchEmsRstDTO) map.get(medSrvDO.getId_srv());
		if(emsmatch==null) {
			throw new BizException("没有匹配到医疗单");
		}

		ciOrderDO.setFuncclassstr(emsmatch.getFuncclassstr());// 医疗单URL
		// 嘱托类医嘱对应医疗单
		ciOrderDO.setId_srvof(emsmatch.getId_ems());// 医疗单 嘱托类医嘱对应医疗单

		ciOrderDO.setApplyno(param.getApplyno()); // 申请单号 入参 --申请单号

		ciOrderDO.setFg_urgent(FBoolean.FALSE);// 加急标识

		if (deptBDO != null) {
			ciOrderDO.setId_dep_mp(deptBDO.getId_dep());// 执行科室 入参 -- 执行科室
		}
		ciOrderDO.setFg_uncancelable(FBoolean.FALSE);// 医嘱不可取消标识
		ciOrderDO.setFg_feertnable(FBoolean.TRUE);// 可退费标识 Y
		ciOrderDO.setFg_quickwflow(FBoolean.TRUE);// 简化的流程标识 Y
		ciOrderDO.setEu_orsrcmdtp(OrSourceFromEnum.THIRDPARTYSYS);// 医嘱来源方式类型
																	// 10第三方系统
		ciOrderDO.setId_orsrc_main(OrSourceFromEnum.THIRDPARTYSYS);// 医嘱来源主标识
																	// 10第三方系统
		ciOrderDO.setSd_orsrcfun(ICiDictCodeConst.SD_ORDSRCFUN_DOC);//医嘱来源功能sd
		ciOrderDO.setId_orsrcfun(ICiDictCodeConst.ID_ORDSRCFUN_DOC);//医嘱来源功能id
		ciOrderDO.setSd_totalopenmode("0");// 总量开单方式
		ICiorderMDORService ciorderMDORService = ServiceFinder.find(ICiorderMDORService.class);
		CiOrderDO[] ciOrderDOs = ciorderMDORService.find("sortno=(select max(sortno) from  ci_order)", null,
				FBoolean.FALSE);
		ciOrderDO.setSortno(ciOrderDOs[0].getSortno() + 1);// 医嘱排序 按照规则生成
															// 医嘱排序号是取当前医嘱最大序号在加1
		ciOrderDO.setStatus(DOStatus.NEW);

		return ciOrderDO;
	}

	private OrdSrvDO[] SetValue2OrdSrvDO(IEOpBtOrEnParamDTO param, PatiVisitDO[] visitDOS, DeptBDO[] deptBDO,
			PsndocAggDO[] docAggDO, CiOrderDO ciOrderDO2, MedSrvDO medSrvDO) {
		// 回写到ci_or_srv
		OrdSrvDO[] ordSrvDO = new OrdSrvDO[1];
		ordSrvDO[0] = new OrdSrvDO();

		ordSrvDO[0].setId_or(ciOrderDO2.getId_or());// 医嘱id
		ordSrvDO[0].setId_grp(visitDOS[0].getId_grp());// 所属集团 当前就诊所在集团
		ordSrvDO[0].setId_org(visitDOS[0].getId_org());// 所属组织 当前就诊所在组织
		ordSrvDO[0].setId_pat(visitDOS[0].getId_pat());// 患者 当前就诊患者id
		ordSrvDO[0].setId_entp(visitDOS[0].getId_entp());// 就诊类型 当前就诊类型
		ordSrvDO[0].setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);// 就诊类型编码
																		// 当前就诊类型
		ordSrvDO[0].setId_en(ciOrderDO2.getId_en());// 就诊 当前就诊
		ordSrvDO[0].setSortno(1);// 序号 1
		if(medSrvDO!=null){
			ordSrvDO[0].setId_srvtp(medSrvDO.getId_srvtp()); // 服务类型
			// 0801嘱托
			ordSrvDO[0].setSd_srvtp(medSrvDO.getSd_srvtp());// 服务类型编码
			ordSrvDO[0].setId_srv(medSrvDO.getId_srv());// 服务项目 备血申请对应服务id
			ordSrvDO[0].setCode_srv(medSrvDO.getCode());// 服务项目编码
			ordSrvDO[0].setId_srvca(medSrvDO.getId_srv());// 服务项目分类
			ordSrvDO[0].setQuan_medu(medSrvDO.getQuan_med());// 数值_医疗单位 备血申请对应服务默认单位
			ordSrvDO[0].setId_medu(medSrvDO.getId_unit_med());// 医疗单位 1
		}
																		// 801
		/*
		 * if (medSrvDO != null) {
		 * ordSrvDO[0].setId_srvca(medSrvDO[0].getId_srvca());// 服务项目分类 //
		 * 备血申请对应服务的服务分类 ordSrvDO[0].setCode_srv(medSrvDO[0].getCode());//
		 * 服务项目编码 }
		 */
		ordSrvDO[0].setName(param.getName_or());// 服务项目名称 备血申请对应服务名称
		ordSrvDO[0].setFg_dose_anoma(FBoolean.FALSE);// 不规则剂量标识 N
		ordSrvDO[0].setId_freq(IBdSrvDictCodeConst.ID_FREQNUNITCT_ITEM_ONCE);// 服务频次

		ordSrvDO[0].setId_org_srv(visitDOS[0].getId_org());// 服务项目开立机构 当前就诊所在组织
		ordSrvDO[0].setId_dep_srv(visitDOS[0].getId_dep_phy());// 服务项目开立科室
																// 当前就诊所在部门
		if (docAggDO != null && docAggDO.length > 0 && docAggDO[0].getParentDO() != null) {
			ordSrvDO[0].setId_emp_srv(docAggDO[0].getParentDO().getId_psndoc());// 服务项目开立医生 入参-对应医生
		}
		ordSrvDO[0].setId_org_mp(visitDOS[0].getId_org());// 执行机构 当前就诊所在组织

		if (deptBDO != null) {
			ordSrvDO[0].setId_dep_mp(deptBDO[0].getId_dep());// 执行科室 入参 -- 执行科室
		}

		ordSrvDO[0].setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);// 执行状态编码 0未执行
		ordSrvDO[0].setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);// 记账状态编码 0未记账
		ordSrvDO[0].setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);// 记账状态 0未记账
		ordSrvDO[0].setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);// 执行状态 0未执行
		ordSrvDO[0].setFg_or(FBoolean.TRUE);// 医嘱标识 Y
		ordSrvDO[0].setEu_blmd(MedSrvBlModeEnum.AUTOBL);// 记费模式 备血申请对应服务的划价方式
		ordSrvDO[0].setFg_mm(FBoolean.FALSE);// 物品标识 N
		ordSrvDO[0].setFg_set(FBoolean.FALSE);// 服务套标识 N
		ordSrvDO[0].setFg_indic(FBoolean.FALSE);// 医保适应症标识 N
		ordSrvDO[0].setFg_propc(FBoolean.FALSE);// 是否预防用药 N
		ordSrvDO[0].setFg_self(FBoolean.FALSE);// 是否自备药 N
		ordSrvDO[0].setDt_create(BloodManageUtils.getServerDateTime());// 服务项目立时间-当前系统时间
		// 备血申请对应服务的服务分类
		ordSrvDO[0].setFg_bl(FBoolean.FALSE);// 费用标识 N
		// 备血申请对应服务的编码
		ordSrvDO[0].setId_dep_nur_srv(visitDOS[0].getId_dep_nur());// 开立病区
																	// 当前就诊患者所在病区
		ordSrvDO[0].setDt_last_bl(new FDateTime(param.getDt_effe()));// 最近生成日期
		ordSrvDO[0].setEu_sourcemd(Integer.valueOf(IBdSrvDictCodeConst.SD_SRVTP_OTHER));// 医嘱项目来源方式
																						// 99其他

		ordSrvDO[0].setId_hp(visitDOS[0].getId_hp());// 主医保计划 当前就诊的主医保计划

		ordSrvDO[0].setId_hpsrvtp(IBdPpCodeTypeConst.ID_HP_BJ_THREE);// 医保目录类型
																		// 丙类
																		// HPSrvorcaDO
		ordSrvDO[0].setSd_hpsrvtp(IBdPpCodeTypeConst.SD_HP_BJ_THREE);// 医保目录类型编码
																		// 丙类对应编码
		ordSrvDO[0].setFg_skintest(FBoolean.FALSE);// 需皮试标识 N
		ordSrvDO[0].setFg_selfsrv(FBoolean.TRUE); // 自定义服务标识 Y
		ordSrvDO[0].setQuan_total_medu(new FDouble(1));// 服务总量 1

		// 调用底层 定价模式的
		ordSrvDO[0].setId_primd(IBdPrimdCodeConst.ID_PRI_RES);// 定价模式
																// 备血申请对应服务的定价模式
		ordSrvDO[0].setFg_selfpay(FBoolean.TRUE);// 自费标识 Y
		ordSrvDO[0].setFg_feertnable(FBoolean.TRUE);// 可退费标识 Y
		ordSrvDO[0].setId_pripat(visitDOS[0].getId_patca());// 患者价格分类 本次就诊患者价格分类
		ordSrvDO[0].setFg_nothingwithorders(FBoolean.FALSE);// 付数无关标志 N
		ordSrvDO[0].setStatus(DOStatus.NEW);
		return ordSrvDO;
	}

}
