package iih.bl.cg.service.s;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.pp.incca.d.IncCaItmDO;
import iih.bd.pp.service.i.IBdInccaQueService;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.blcgquery.i.IBlcgqueryRService;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendOutpBillParamDTO;
import iih.bl.cg.bp.GetBlCgDO;
import iih.bl.cg.bp.ValidateParam;
import iih.bl.cg.dto.d.OpAcc4EsDTO;
import iih.bl.cg.event.OpAccEvent;
import iih.bl.cg.service.d.BlCgOepAggDTO;
import iih.bl.cg.service.d.BlOrderRefundBillParamDTO;
import iih.bl.cg.service.d.Bl_BatchAppendBillDTO;
import iih.bl.cg.service.d.CgTypeEnum;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.i.IBLOrderAppendBillService;
import iih.bl.cg.service.s.bp.BlAppendOrRefundBillBP;
import iih.bl.cg.service.s.bp.CancelReserveBP;
import iih.bl.cg.service.s.bp.IBLOrderAppendBillServiceImplBp;
import iih.bl.cg.service.udi.IBlCgCodeConst;
import iih.bl.st.service.i.IBLStQueService;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.ci.ord.dto.unchargeordinfo.d.UnchargeOrdSrvDTO;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mp.dg.dto.d.OpPresQueSiteDTO;
import iih.mp.dg.i.IMpDgConst;
import iih.mp.dg.i.IMpDgOutService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊、住院补退费接口
 * 
 * @author tcy
 *
 */
@Service(serviceInterfaces = { IBLOrderAppendBillService.class }, binding = Binding.JSONRPC)
public class IBLOrderAppendBillServiceImpl implements IBLOrderAppendBillService {

	/**
	 * 患者已经出院结算、患者的费用已经封账或患者的费用正在审核结算流程中，禁止执行与费用有关的操作 （适用于住院）
	 * 
	 * @param id_ent
	 *            就诊id_ent
	 * @throws BizException
	 */
	public void validateFreezeAccAndAuditStatus(String id_ent) throws BizException {
		ValidateParam validateParams = new ValidateParam();
		validateParams.validateFreezeAccAndAuditStatus(id_ent);
	}

	public BlOrderAppendBillParamDTO[] SetOrderAppendBill_ByIdorsrv(BlOrderAppendBillParamDTO[] appendBillParamDTO1, String code_enttp) throws BizException {
		IBLOrderAppendBillServiceImplBp bp = new IBLOrderAppendBillServiceImplBp();
		return bp.SetOrderAppendBill(appendBillParamDTO1, code_enttp, true);
	}

	public BlOrderAppendBillParamDTO[] SetOrderAppendBill_ByItms(BlOrderAppendBillParamDTO[] appendBillParamDTO1, String code_enttp) throws BizException {
		IBLOrderAppendBillServiceImplBp bp = new IBLOrderAppendBillServiceImplBp();
		// 由于执行组是执行的医嘱内容，所以理应按照医嘱计费 即参数为TRUE By liwq 2017年7月6日19:26:51
		return bp.SetOrderAppendBill(appendBillParamDTO1, code_enttp, false);
	}

	/**
	 * 医嘱取消记账（销账后，【记账状态】=已退费，冲账类型 =销账） 且取消物品预留，
	 * 必填：id_pat,id_org,id_or,id_orsrv,code_enttp,Id_emp_cg
	 * 
	 * @param refundBillParamDTO
	 *            必填：id_pat,id_org,id_or,id_orsrv,code_enttp,Id_emp_cg
	 * @param code_enttp
	 *            就诊类型代码
	 * @return 返回“销账成功，销账金额：……”
	 * @throws BizException
	 */
	public String SetOrderRefundBill_ByIdor_cancelReserve(BlOrderAppendBillParamDTO[] refundBillParamDTO, String code_enttp) throws BizException {
		CancelReserveBP bp = new CancelReserveBP();
		return bp.exec(refundBillParamDTO, code_enttp);
	}

	/**
	 * 供CI调用，进行销账
	 * 
	 * @param id_ent
	 * @param code_enttp
	 * @param id_emp
	 *            销账人员
	 * @return 返回“销账成功，销账金额：……”
	 * @author Liwq
	 * @throws BizException
	 */
	public String setRefundBillForCi_ByIdent(String id_ent, String code_enttp, String id_emp) throws BizException {
		StringBuilder sqlCi = new StringBuilder();
		// 1、查询Ci是否存在已记账医嘱,未执行
		sqlCi.append(" id_en = '").append(id_ent).append("' and sd_su_bl = '1'");
		IOrdSrvDORService ordSrvDorService = ServiceFinder.find(IOrdSrvDORService.class);
		OrdSrvDO[] ordSrvDOs = ordSrvDorService.find(sqlCi.toString(), "", FBoolean.FALSE);

		if (ordSrvDOs == null || ordSrvDOs.length <= 0) {
			throw new BizException("该次就诊未查询到已记账的医嘱！");
		}
		IBLOrderAppendBillServiceImplBp iBLOrderAppendBillServiceImplBp = new IBLOrderAppendBillServiceImplBp();
		List<BlOrderAppendBillParamDTO> feeDtoList = new ArrayList<BlOrderAppendBillParamDTO>();
		for (OrdSrvDO srvDO : ordSrvDOs) {
			// 2、根据已记账医嘱查询CG，判断是否已经收费
			StringBuilder sqlCg = new StringBuilder();
			sqlCg.append(" SELECT OEP.* ");
			sqlCg.append(" FROM BL_CG_ITM_OEP OEP ");
			sqlCg.append(" INNER JOIN CI_OR_SRV CISRV ON OEP.ID_ORSRV=CISRV.ID_ORSRV ");
			sqlCg.append(" INNER JOIN BL_CG_OEP CG on OEP.id_cgoep=CG.id_cgoep ");
			sqlCg.append(" where OEP.id_or = ? ");
			sqlCg.append(" and OEP.id_orsrv = ? ");
			sqlCg.append(" and OEP.id_ent = ? ");
			sqlCg.append(" and CG.id_emp_cg = ? AND CISRV.FG_FEERTNABLE='Y' and OEP.fg_refund='N' and CG.eu_direct=1 and OEP.fg_st='N' and OEP.fg_hpcg='N'"); // 需要排除高端商保
			SqlParam param = new SqlParam();
			param.addParam(srvDO.getId_or());
			param.addParam(srvDO.getId_orsrv());
			param.addParam(srvDO.getId_en());
			param.addParam(id_emp);
			List<BlCgItmOepDO> itmOepDOsList = (List<BlCgItmOepDO>) new DAFacade().execQuery(sqlCg.toString(), param, new BeanListHandler(BlCgItmOepDO.class));

			if (itmOepDOsList != null && itmOepDOsList.size() > 0)// 只存在于CG表中的数据，才可以取消记账
			{
				BlOrderAppendBillParamDTO tmpFeeDo = new BlOrderAppendBillParamDTO();
				tmpFeeDo.setCode_enttp(code_enttp);
				tmpFeeDo.setId_pat(srvDO.getId_pat());
				tmpFeeDo.setId_org(srvDO.getId_org_srv());
				tmpFeeDo.setId_or(srvDO.getId_or());
				tmpFeeDo.setId_orsrv(srvDO.getId_orsrv());
				tmpFeeDo.setId_emp_cg(id_emp);
				feeDtoList.add(tmpFeeDo);
			}
		}
		if(feeDtoList.size()<=0){
			throw new BizException("没有获取到可以销账的数据！");
		}
		// 3、调用销账函数进行销账
		String tip = this.SetOrderRefundBill_ByIdor_cancelReserve(feeDtoList.toArray(new BlOrderAppendBillParamDTO[] {}), code_enttp);
		return tip;
	}

	/**
	 * 指定就诊下未缴费的医嘱进行缴费
	 * 
	 * @param id_ent
	 *            就诊
	 * @param code_enttp
	 *            就诊类型
	 * @param cgType
	 *            记账类型
	 * @param id_emp
	 *            操作人员
	 * @return 成功返回缴费后的信息，失败抛出异常
	 * @throws BizException
	 */
	public BlOrderAppendBillParamDTO[] SetOrderAppendBill_ByItms_ci_kljz_new(String id_ent, String code_enttp, String cgType, String id_emp) throws BizException {

		// 1.根据id_ent提取未交费的医嘱
		IBLStQueService iBLStQueService = ServiceFinder.find(IBLStQueService.class);
		BlOrderAppendBillParamDTO[] appendBillParamDTO1 = iBLStQueService.getOrderSrvPrinceInfoByIdent(id_ent, new String[] { "0" });
		List<String> id_orSrvList = new ArrayList<String>();
		xap.mw.log.logging.Logger.info("获取记账数据：【就诊编号" + id_ent + "】【记账数据：" + appendBillParamDTO1.length + "】");
		if (cgType.equals(CgTypeEnum.CG_PREPAY))// 预交金记账
		{
			if (appendBillParamDTO1 == null || appendBillParamDTO1.length == 0) {
				throw new BizException("没有需要记账的医嘱！");
			}
			for (BlOrderAppendBillParamDTO dto : appendBillParamDTO1) {
				dto.setId_emp_cg(id_emp);
				dto.setSupportAppendBill(FBoolean.FALSE); // 不支持后付费，必须有足够的预交金
				dto.setFg_pricinginsertcg(FBoolean.FALSE); // 不是划价产生的数据
				if (dto.getFg_mm() != null && dto.getFg_mm().booleanValue()) // 物品调预留接口，重新计价
				{
					dto.setFg_reserveMaterials(FBoolean.TRUE);
					dto.setPrice(null);
					dto.setPri_ss(null);
					dto.setPrice_ratio(null);
				}
				id_orSrvList.add(dto.getId_orsrv());
			}

		} else if (cgType.equals(CgTypeEnum.CG_HPCG)) // 高端商保记账
		{
			if (appendBillParamDTO1 == null || appendBillParamDTO1.length == 0) {
				return null;
			}
			for (BlOrderAppendBillParamDTO dto : appendBillParamDTO1) {
				dto.setId_emp_cg(id_emp);
				dto.setFg_pricinginsertcg(FBoolean.FALSE); // 不是划价产生的数据
				if (dto.getOutpBillDTO() != null) {
					dto.getOutpBillDTO().setFg_hpcg(FBoolean.TRUE);
				} else {
					BlOrderAppendOutpBillParamDTO outpBillDTO = new BlOrderAppendOutpBillParamDTO();
					outpBillDTO.setFg_hpcg(FBoolean.TRUE);
					dto.setOutpBillDTO(outpBillDTO);
				}
				if (dto.getFg_mm() != null && dto.getFg_mm().booleanValue()) // 物品调预留接口，重新计价
				{
					dto.setFg_reserveMaterials(FBoolean.TRUE);
					dto.setPrice(null);
					dto.setPri_ss(null);
					dto.setPrice_ratio(null);
				}
				id_orSrvList.add(dto.getId_orsrv());
			}
		}
		// if (id_orSrvList != null && id_orSrvList.size() > 0) {
		// IBLCiOrderToBlCgServiceImpl bp = new IBLCiOrderToBlCgServiceImpl();
		// bp.invokeOepCiOrderEvent(id_orSrvList);
		// }

		 appendBillParamDTO1 = SetOrderAppendBill_ByItms_ci_kljz_bp(appendBillParamDTO1,  code_enttp);

		 //尝试使用划价来处理记账功能
//		OperatorInfoDTO operatorInfoDTO = new OperatorInfoDTO();
//		operatorInfoDTO.setId_dep(Context.get().getDeptId());
//		operatorInfoDTO.setId_emp(Context.get().getUserId());
//		operatorInfoDTO.setId_grp(Context.get().getGroupId());
//		operatorInfoDTO.setId_org(Context.get().getOrgId());
//		operatorInfoDTO.setId_org_emp(Context.get().getOrgId());
//		IBLCiOrderToBlCgServiceImpl serimpl = new IBLCiOrderToBlCgServiceImpl();
//		serimpl.SetCiOrderToPrice(appendBillParamDTO1, operatorInfoDTO, FBoolean.FALSE);
//
//		// 4 更新医嘱记账信息
//		if (id_orSrvList != null && id_orSrvList.size() > 0) {
//			ICiOrdMaintainService obj2X = ServiceFinder.find(ICiOrdMaintainService.class);
//			FBoolean updateCiOrder = obj2X.UpdateOrdChargeRelInfo2(id_orSrvList.toArray(new String[] {}), ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID, ICiDictCodeConst.SD_SU_BL_ACCOUNT, appendBillParamDTO1[0].getDt_last_bl(), FeeReverseType.NOBLCANCEL);
//		}
//
//		// 2.获取处方领药窗口号
//		IMpDgOutService mpDgoutService = ServiceFinder.find(IMpDgOutService.class);
//		Map<String, String> presVsWindowInfo = new HashMap<String, String>(); // 《处方号，窗口号》
//		for (BlOrderAppendBillParamDTO dto : appendBillParamDTO1) {
//			if (dto.getId_pres() != null && dto.getSd_srvtp() != null && dto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
//				if (!presVsWindowInfo.containsKey(dto.getId_pres())) {
//					OpPresQueSiteDTO opPresQueSiteDTO = mpDgoutService.insertPresWindowData(dto.getId_pres(), IMpDgConst.ENTRY_AFTER_CHARGE);
//					if (opPresQueSiteDTO != null) {
//						presVsWindowInfo.put(dto.getId_pres(), opPresQueSiteDTO.getName_quesite());
//					}
//				}
//			}
//		}
//		// 3.领域窗口号回写到处方中
//		ICiOrdMaintainService iCiOrdMaintainService = ServiceFinder.find(ICiOrdMaintainService.class);
//		iCiOrdMaintainService.setPresWindowNo(presVsWindowInfo);
//		// 4.发送收费信息到集成平台
//		// 尝试把CI的发事件代码复制过来
//		if (id_orSrvList != null || id_orSrvList.size() > 0) {
//			this.invokeOepCiOrderEvent(id_orSrvList);
//		}
//		invokeOpAccEvent(appendBillParamDTO1);

		return appendBillParamDTO1;
	}

	// /**
	// * CI的高端商保记账调用，包括：
	// * 将选择的费用记入门诊记账表（BL_CG_OEP）和门诊记账明细表（BL_CG_ITM_OEP）
	// * 冻结患者账户中相同金额的预交金
	// * 发送药品预留申请
	// * 发送收费消息到集成平台
	// * 更新医嘱状态
	// * 获取处方领药窗口号并回写到处方中（涉及药品和临床两个接口）
	// * @param appendBillParamDTO1 待记账明细
	// * @param code_enttp 就诊类型
	// * @return
	// * @throws BizException
	// */
	// public BlOrderAppendBillParamDTO[] SetOrderAppendBill_ByItms_ci_hpcg(
	// BlOrderAppendBillParamDTO[] appendBillParamDTO1,String code_enttp)
	// throws BizException
	// {
	//
	//
	//
	// //1.医嘱记账(含将选择的费用记入门诊记账表（BL_CG_OEP）和门诊记账明细表（BL_CG_ITM_OEP），冻结患者账户中相同金额的预交金，发送药品预留申请）
	// for(BlOrderAppendBillParamDTO dto: appendBillParamDTO1)
	// {
	// if(dto.getFg_mm()!=null && dto.getFg_mm().booleanValue()) //物品调预留接口，重新计价
	// {
	// dto.setFg_reserveMaterials(FBoolean.TRUE);
	// dto.setPrice(null);
	// dto.setPri_ss(null);
	// dto.setPrice_ratio(null);
	// }
	// dto.setFg_pricinginsertcg(FBoolean.FALSE); //不是划价产生的数据
	// if(dto.getOutpBillDTO()!=null)
	// {
	// dto.getOutpBillDTO().setFg_hpcg(FBoolean.TRUE);
	// }
	// else
	// {
	// BlOrderAppendOutpBillParamDTO outpBillDTO=new
	// BlOrderAppendOutpBillParamDTO();
	// outpBillDTO.setFg_hpcg(FBoolean.TRUE);
	// dto.setOutpBillDTO(outpBillDTO);
	// }
	// }
	// return
	// SetOrderAppendBill_ByItms_ci_kljz_bp(appendBillParamDTO1,code_enttp);
	// }

	/**
	 * CI的开立记账调用，包括： 将选择的费用记入门诊记账表（BL_CG_OEP）和门诊记账明细表（BL_CG_ITM_OEP）
	 * 冻结患者账户中相同金额的预交金 发送药品预留申请 发送收费消息到集成平台 更新医嘱状态 获取处方领药窗口号并回写到处方中（涉及药品和临床两个接口）
	 * 
	 * @param appendBillParamDTO1
	 *            待记账明细
	 * @param code_enttp
	 *            就诊类型
	 * @return
	 * @throws BizException
	 */
	public BlOrderAppendBillParamDTO[] SetOrderAppendBill_ByItms_ci_kljz(BlOrderAppendBillParamDTO[] appendBillParamDTO1, String code_enttp) throws BizException {
		// 1.医嘱记账(含将选择的费用记入门诊记账表（BL_CG_OEP）和门诊记账明细表（BL_CG_ITM_OEP），冻结患者账户中相同金额的预交金，发送药品预留申请）
		for (BlOrderAppendBillParamDTO dto : appendBillParamDTO1) {
			if (dto.getFg_mm() != null && dto.getFg_mm().booleanValue()) // 物品调预留接口，重新计价
			{
				dto.setFg_reserveMaterials(FBoolean.TRUE);
				dto.setPrice(null);
				dto.setPri_ss(null);
				dto.setPrice_ratio(null);
			}
		}
		return SetOrderAppendBill_ByItms_ci_kljz_bp(appendBillParamDTO1, code_enttp);
		// IBLOrderAppendBillServiceImplBp bp=new
		// IBLOrderAppendBillServiceImplBp();
		// BlOrderAppendBillParamDTO[]
		// dtos=bp.SetOrderAppendBill(appendBillParamDTO1,code_enttp, false);
		// //2.获取处方领药窗口号
		// IMpDgOutService mpDgoutService =
		// ServiceFinder.find(IMpDgOutService.class);
		// Map<String,String> presVsWindowInfo = new HashMap(); //《处方号，窗口号》
		// List<String> id_orsrvLst=new ArrayList<String>();
		// for (BlOrderAppendBillParamDTO dto : appendBillParamDTO1)
		// {
		// if (dto.getId_pres() != null && dto.getSd_srvtp()!=null &&
		// dto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG))
		// {
		// if (!presVsWindowInfo.containsKey(dto.getId_pres())) {
		// OpPresQueSiteDTO opPresQueSiteDTO = mpDgoutService
		// .insertPresWindowData(dto.getId_pres(),
		// IMpDgConst.ENTRY_AFTER_CHARGE);
		// if (opPresQueSiteDTO != null) {
		//
		// presVsWindowInfo.put(dto.getId_pres(),
		// opPresQueSiteDTO.getName_quesite());
		// }
		// }
		// }
		// if(!id_orsrvLst.contains(dto.getId_orsrv()))
		// {
		// id_orsrvLst.add(dto.getId_orsrv());
		// }
		// }
		// //3.领域窗口号回写到处方中
		// ICiOrdMaintainService iCiOrdMaintainService =
		// ServiceFinder.find(ICiOrdMaintainService.class);
		// iCiOrdMaintainService.setPresWindowNo(presVsWindowInfo);
		// //4.发送收费信息到集成平台
		// //尝试把CI的发事件代码复制过来
		// if(id_orsrvLst!=null || id_orsrvLst.size()>0)
		// {
		// this.invokeOepCiOrderEvent(id_orsrvLst);
		// }
		// return dtos;
	}

	/**
	 * CI的开立记账调用，包括： 将选择的费用记入门诊记账表（BL_CG_OEP）和门诊记账明细表（BL_CG_ITM_OEP）
	 * 冻结患者账户中相同金额的预交金 发送药品预留申请 发送收费消息到集成平台 更新医嘱状态 获取处方领药窗口号并回写到处方中（涉及药品和临床两个接口）
	 * 
	 * @param appendBillParamDTO1
	 *            待记账明细
	 * @param code_enttp
	 *            就诊类型
	 * @return
	 * @throws BizException
	 */
	private BlOrderAppendBillParamDTO[] SetOrderAppendBill_ByItms_ci_kljz_bp(BlOrderAppendBillParamDTO[] appendBillParamDTO1, String code_enttp) throws BizException {
		// 1.医嘱记账(含将选择的费用记入门诊记账表（BL_CG_OEP）和门诊记账明细表（BL_CG_ITM_OEP），冻结患者账户中相同金额的预交金，发送药品预留申请）
		IBLOrderAppendBillServiceImplBp bp = new IBLOrderAppendBillServiceImplBp();
		BlOrderAppendBillParamDTO[] dtos = bp.SetOrderAppendBill(appendBillParamDTO1, code_enttp, false);
		// 2.获取处方领药窗口号
		IMpDgOutService mpDgoutService = ServiceFinder.find(IMpDgOutService.class);
		Map<String, String> presVsWindowInfo = new HashMap(); // 《处方号，窗口号》
		List<String> id_orsrvLst = new ArrayList<String>();
		for (BlOrderAppendBillParamDTO dto : appendBillParamDTO1) {
			if (dto.getId_pres() != null && dto.getSd_srvtp() != null && dto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
				if (!presVsWindowInfo.containsKey(dto.getId_pres())) {
					OpPresQueSiteDTO opPresQueSiteDTO = mpDgoutService.insertPresWindowData(dto.getId_pres(), IMpDgConst.ENTRY_AFTER_CHARGE);
					if (opPresQueSiteDTO != null) {

						presVsWindowInfo.put(dto.getId_pres(), opPresQueSiteDTO.getName_quesite());
					}
				}
			}
			if (!id_orsrvLst.contains(dto.getId_orsrv())) {
				id_orsrvLst.add(dto.getId_orsrv());
			}
		}
		// 3.领域窗口号回写到处方中
		ICiOrdMaintainService iCiOrdMaintainService = ServiceFinder.find(ICiOrdMaintainService.class);
		iCiOrdMaintainService.setPresWindowNo(presVsWindowInfo);
//		// 尝试把CI的发事件代码复制过来
//		if (id_orsrvLst != null || id_orsrvLst.size() > 0) {
//			this.invokeOepCiOrderEvent(id_orsrvLst);
//		}
		// 4.发送收费信息到集成平台
		invokeOpAccEvent(dtos);
		return dtos;
	}

	/**
	 * 出发发送门诊高端商保，预交金记账数据
	 * 
	 * @throws BizException
	 */
	private void invokeOpAccEvent(BlOrderAppendBillParamDTO[] dtos) throws BizException {
		if (dtos == null || dtos.length == 0)
			return;
		List<OpAcc4EsDTO> opaccDtos = new ArrayList<OpAcc4EsDTO>();
		for (BlOrderAppendBillParamDTO orderDto : dtos) {
			OpAcc4EsDTO opaccDto = new OpAcc4EsDTO();
			opaccDto.setCode_apply(orderDto.getCode_apply());
			opaccDto.setCode_applytp(orderDto.getCode_applytp());
			opaccDto.setFg_acc(orderDto.getOutpBillDTO().getFg_acc());
			opaccDto.setFg_free(orderDto.getFg_free());
			opaccDto.setFg_hpcg(orderDto.getOutpBillDTO().getFg_hpcg());
			opaccDto.setId_cgitmoep(orderDto.getOutpBillDTO().getId_cgitmoep());
			opaccDto.setId_cgoep(orderDto.getOutpBillDTO().getId_cgitmoep());
			opaccDto.setId_or(orderDto.getId_or());
			opaccDto.setId_orsrv(orderDto.getId_orsrv());
			opaccDto.setId_pres(orderDto.getId_pres());
			opaccDto.setId_ent(orderDto.getId_ent());
			// TODO 当前数据中 Fg_additm 是在付款是补费才能为Y 所以当前判断不出来是否补费 ，此消息仅发送高端商保 与
			// 预交金记账数据，暂不支持补费发送数据
			// opaccDto.setFg_additm(orderDto.getFg_additm());
			opaccDtos.add(opaccDto);
		}

		OpAccEvent opAccEvent = new OpAccEvent();
		opAccEvent.invoke(opaccDtos.toArray(new OpAcc4EsDTO[opaccDtos.size()]));
	}

//	/**
//	 * 触发检查申请信息服务事件
//	 * 
//	 * @throws BizException
//	 * */
//	private void invokeOepCiOrderEvent(List<String> id_orsrvLst) throws BizException {
//		String[] objArr = id_orsrvLst.toArray(new String[] {});
//		BlOepSrvEventInfoDTO blOepSrvEventInfoDTO = new BlOepSrvEventInfoDTO();
//		blOepSrvEventInfoDTO.setOper_type(BookRtnDirectEnum.CHARGES);
//		blOepSrvEventInfoDTO.setIdSrvArr(objArr);
//		BusinessEvent oepSettlementEvent = new BusinessEvent(IBlEventConst.EVENT_IE_BL_OEP_CHARGE, IEventType.TYPE_UPDATE_AFTER, new BlOepSrvEventInfoDTO[] { blOepSrvEventInfoDTO });
//		EventDispatcher.fireEvent(oepSettlementEvent);
//	}

	/**
	 * 单患者补费：根据id_ent,id_or,id_orsrv补费。其中，id_ent保持一致
	 * 
	 * @param appendBillParamDTO1
	 *            补费信息（可只包含id_ent,id_or,id_orsrv）
	 * @param operatorInfoDTO
	 *            操作人员信息
	 * @return
	 * @throws BizException
	 */
	public BlOrderAppendBillParamDTO[] SetOrderAppendBill_ByIdEntIdOrIdOrsrv(BlOrderAppendBillParamDTO[] appendBillParamDTO1, OperatorInfoDTO operatorInfoDTO) throws BizException {
		if (appendBillParamDTO1 != null && appendBillParamDTO1.length > 0) {
			// VerificationBdHpCtr(appendBillParamDTO1);
			BlOrderAppendBillParamDTO[] appendBillParamDTO2 = this.getBlOrderAppendBillParamDTOArr_byIdentIdorIdorsrv(appendBillParamDTO1, operatorInfoDTO);
			String code_enttp = appendBillParamDTO2[0].getCode_enttp();
			IBLOrderAppendBillServiceImplBp bp = new IBLOrderAppendBillServiceImplBp();

			// 补费时发送事件到平台 2017年6月27日21:51:14 yang.lu
			List<String> id_orsrvLst = new ArrayList<String>();
			for (BlOrderAppendBillParamDTO dto : appendBillParamDTO2) {
				if (!id_orsrvLst.contains(dto.getId_orsrv())) {
					id_orsrvLst.add(dto.getId_orsrv());
				}
			}
			// 尝试把CI的发事件代码复制过来
			if (id_orsrvLst != null || id_orsrvLst.size() > 0) {
//				this.invokeOepCiOrderEvent(id_orsrvLst);
			}

			return bp.SetOrderAppendBill(appendBillParamDTO2, code_enttp, false);
		} else {
			return null;
		}
	}

	// /**
	// * 验证当前是否满足单条限额 补费项目 不需要验证 2017年6月12日
	// *
	// * @param appendBillParamDTOs
	// */
	// private void VerificationBdHpCtr(BlOrderAppendBillParamDTO[]
	// appendBillParamDTOs) throws BizException {
	// if (appendBillParamDTOs != null && appendBillParamDTOs.length > 0) {
	// IBdHpCtrDORService service = (IBdHpCtrDORService)
	// ServiceFinder.find(IBdHpCtrDORService.class);
	// BdHpCtrDO[] ctrdos =
	// service.find(" id_hp=(SELECT id_hp FROM EN_ENT WHERE id_ent='" +
	// appendBillParamDTOs[0].getId_ent() + "')", "", FBoolean.FALSE);
	// FDouble maxval = FDouble.ZERO_DBL;
	// if (ctrdos != null && ctrdos.length == 1) {
	// maxval = ctrdos[0].getOr_limit_amt();
	// } else
	// return;
	//
	// String msg = "";
	// for (BlOrderAppendBillParamDTO appdto : appendBillParamDTOs) {
	// if (appdto.getQuan().multiply(appdto.getPrice_ratio()).compareTo(maxval)
	// > 0) {
	// // 当前DTO中不包含服务名称
	// // msg = msg + ("".equals(msg) ? "" : "，") + "[" +
	// // appdto.getName_srv() + "]";
	// msg = msg + "," + appdto.getId_srv();
	// }
	// }
	// if (!"".equals(msg)) {
	// throw new BizException("补费服务：单条补费超出限额！单条补费限额为：" + maxval);
	// }
	// }
	// }

	/**
	 * 补费接口，返回BlCgOepAggDTO，供门诊挂号后付费和门诊诊间挂号
	 * 
	 * @param appendBillParamDTO1
	 * @param code_enttp
	 * @return
	 * @throws BizException
	 */
	public BlCgOepAggDTO SetOrderAppendBill_ByItms_agg(BlOrderAppendBillParamDTO[] appendBillParamDTO1, String code_enttp) throws BizException {
		BlCgOepAggDTO BlCgOepAggDTO = new BlCgOepAggDTO();
		return BlCgOepAggDTO;// SetOrderAppendBill(appendBillParamDTO1,code_enttp,
								// false);
	}

	/**
	 * 补费接口，供CI领域调用
	 * 
	 * @param appendBillParamDTOArr
	 *            CI领域补录的费用明细：
	 *            1.id_pat,id_enttp,code_enttp,id_srv,quan,eu_direct
	 *            (Ci填1),id_org_mp,id_dep_mp,id_or,id_orsrv必填,其他字段可省;
	 *            2.如果需要支持后付费
	 *            ，则需要设置BlOrderAppendBillParamDTO.setOutpBillDTO(OutpBillDTO
	 *            .fg_acc=FBoolean.true)
	 * @param operatorInfoDTO
	 *            操作员信息
	 * @param id_pripat
	 *            患者价格分类
	 * @return 计费成功后的费用明细
	 * @throws BizException
	 */
	public BlOrderAppendBillParamDTO[] SetOrderAppendBill_ByCi(BlOrderAppendBillParamDTO[] appendBillParamDTO1, OperatorInfoDTO operatorInfoDTO, String code_enttp, String id_pripat) throws BizException {
		IBLOrderAppendBillServiceImplBp bp = new IBLOrderAppendBillServiceImplBp();
		BlOrderAppendBillParamDTO[] blOrderAppendBillParamDTOArr = bp.getBlOrderAppendBillParamDTOArr(appendBillParamDTO1, operatorInfoDTO, id_pripat);
		return bp.SetOrderAppendBill(blOrderAppendBillParamDTOArr, code_enttp, false);
	}

	public BlOrderAppendBillParamDTO[] SetOrderAppendBill_ByItms_MultiPat(BlOrderAppendBillParamDTO[] appendBillParamDTO1, String code_enttp) throws BizException {
		List<BlOrderAppendBillParamDTO> blOrderAppendBillParamDTOLst = new ArrayList<BlOrderAppendBillParamDTO>();
		// List<BlOrderAppendBillParamDTO> blOrderAppendBillParamDTOResult=new
		// ArrayList<BlOrderAppendBillParamDTO>();
		Map<String, FDouble> identSumAmtRatioMap = new HashMap<String, FDouble>();// <id_ent,消费金额>
		Map<String, List<BlOrderAppendBillParamDTO>> identBlCgDTOMap = new HashMap<String, List<BlOrderAppendBillParamDTO>>();// <id_ent,记费明细>
		FDouble sumAmtRatio = new FDouble(0);
		List<String> orsrvids_list = new ArrayList<String>();// 需要修改记账信息的医嘱
		List<String> id_entLst = new ArrayList<String>(); // 待补费的患者集合
		for (BlOrderAppendBillParamDTO blOrderAppendBillParamDTO : appendBillParamDTO1) {
			if (!id_entLst.contains(blOrderAppendBillParamDTO.getId_ent())) {
				id_entLst.add(blOrderAppendBillParamDTO.getId_ent());
			}
			// 记录已记账的医嘱序号
			if (!orsrvids_list.contains(blOrderAppendBillParamDTO.getId_orsrv())) {
				orsrvids_list.add(blOrderAppendBillParamDTO.getId_orsrv());
			}
			blOrderAppendBillParamDTO.setFg_susp(FBoolean.FALSE);// 补费的数据未挂起
			blOrderAppendBillParamDTO.setFg_hp(FBoolean.FALSE);// 记账上传医保标志
			if (blOrderAppendBillParamDTO.getPrice_ratio() == null) {
				blOrderAppendBillParamDTO.setPrice_ratio(blOrderAppendBillParamDTO.getPrice());
			}
			blOrderAppendBillParamDTO.setAmt(blOrderAppendBillParamDTO.getAmt().setScale(-2, BigDecimal.ROUND_HALF_UP));
			blOrderAppendBillParamDTO.setAmt_std(blOrderAppendBillParamDTO.getAmt_std().setScale(-2, BigDecimal.ROUND_HALF_UP));
			blOrderAppendBillParamDTO.setAmt_hp(blOrderAppendBillParamDTO.getAmt_hp().setScale(-2, BigDecimal.ROUND_HALF_UP));
			blOrderAppendBillParamDTO.setAmt_pat(blOrderAppendBillParamDTO.getAmt_pat().setScale(-2, BigDecimal.ROUND_HALF_UP));
			if (blOrderAppendBillParamDTO.getAmt_ratio() == null) {
				blOrderAppendBillParamDTO.setAmt_ratio(blOrderAppendBillParamDTO.getAmt());
			} else {
				blOrderAppendBillParamDTO.setAmt_ratio(blOrderAppendBillParamDTO.getAmt_ratio().setScale(-2, BigDecimal.ROUND_HALF_UP));
			}

			if (blOrderAppendBillParamDTO.getName_inccaitm() == null || blOrderAppendBillParamDTO.getName_inccaitm().trim().length() == 0) {
				// 完善账单码
				IncCaItmDO incCaItmDO = getInccaitmCodeAndName(blOrderAppendBillParamDTO.getCode_enttp(), blOrderAppendBillParamDTO.getId_srv());
				if (incCaItmDO != null) {
					blOrderAppendBillParamDTO.setName_inccaitm(incCaItmDO.getName());
					blOrderAppendBillParamDTO.setCode_inccaitm(incCaItmDO.getCode());
				}
			}
		}
		for (String id_ent : id_entLst) {
			sumAmtRatio = new FDouble(0);
			blOrderAppendBillParamDTOLst.clear();
			for (BlOrderAppendBillParamDTO blOrderAppendBillParamDTO : appendBillParamDTO1) {
				if (id_ent.equals(blOrderAppendBillParamDTO.getId_ent())) {
					blOrderAppendBillParamDTOLst.add(blOrderAppendBillParamDTO);
					sumAmtRatio = sumAmtRatio.add(blOrderAppendBillParamDTO.getAmt_ratio().multiply(blOrderAppendBillParamDTO.getEu_direct()));
				}
			}
			identSumAmtRatioMap.put(id_ent, sumAmtRatio); // <就诊id,消费金额>
			identBlCgDTOMap.put(id_ent, blOrderAppendBillParamDTOLst);

			// BlOrderAppendBillParamDTO[]
			// tempDtoArr=SetOrderAppendBill(blOrderAppendBillParamDTOLst.toArray(new
			// BlOrderAppendBillParamDTO[0]),code_enttp, false);
			// for(BlOrderAppendBillParamDTO blOrderAppendBillParamDTO:
			// tempDtoArr)
			// {
			// blOrderAppendBillParamDTOResult.add(blOrderAppendBillParamDTO);
			// }
		}
		IBLOrderAppendBillServiceImplBp bp = new IBLOrderAppendBillServiceImplBp();
		return bp.SetOrderAppendBill_MultiPat_Bp(identBlCgDTOMap, identSumAmtRatioMap, id_entLst, orsrvids_list, code_enttp, false);
		// return blOrderAppendBillParamDTOResult.toArray(new
		// BlOrderAppendBillParamDTO[0]);
	}

	/**
	 * 针对多病人（id_pat）特定就诊的医嘱补费接口，返回值为计费完整的DTO,数据库中生成多条主记录，多条明细记录
	 * 
	 * @param appendBillParamDTO1
	 *            医嘱补费需要的参数数组，数组中每行id_pat,code_enttp,是否允许后计费,门诊必填数据或住院结账必填数据相同
	 * @param isCiOrder
	 *            是否是医嘱记账，如果是true，则由本接口负责将医嘱转换成费用，其中，id_or必填；
	 *            否则(isCiOrder=false)
	 *            ，由调用方直接先将费用条目组装好(如果需要本接口计算费用，请将price设置为null)再传入本接口。
	 * @param code_enttp
	 *            就诊类型代码
	 * @return Bl_BatchAppendBillDTO 成功计费的信息DTO；<id_ent, 记费失败原因>;成功计费的id_ent
	 * @throws BizException
	 */
	public Bl_BatchAppendBillDTO SetOrderAppendBill_ByItms_MultiPat_new(BlOrderAppendBillParamDTO[] appendBillParamDTO1, String code_enttp) throws BizException {
		List<BlOrderAppendBillParamDTO> blOrderAppendBillParamDTOLst = new ArrayList<BlOrderAppendBillParamDTO>();
		// List<BlOrderAppendBillParamDTO> blOrderAppendBillParamDTOResult=new
		// ArrayList<BlOrderAppendBillParamDTO>();
		Map<String, FDouble> identSumAmtRatioMap = new HashMap<String, FDouble>();// <id_ent,消费金额>
		Map<String, List<BlOrderAppendBillParamDTO>> identBlCgDTOMap = new HashMap<String, List<BlOrderAppendBillParamDTO>>();// <id_ent,记费明细>
		FDouble sumAmtRatio = new FDouble(0);
		List<String> orsrvids_list = new ArrayList<String>();// 需要修改记账信息的医嘱
		List<String> id_entLst = new ArrayList<String>(); // 待补费的患者集合
		for (BlOrderAppendBillParamDTO blOrderAppendBillParamDTO : appendBillParamDTO1) {
			if (!id_entLst.contains(blOrderAppendBillParamDTO.getId_ent())) {
				id_entLst.add(blOrderAppendBillParamDTO.getId_ent());
			}
			// 记录已记账的医嘱序号
			if (!orsrvids_list.contains(blOrderAppendBillParamDTO.getId_orsrv())) {
				orsrvids_list.add(blOrderAppendBillParamDTO.getId_orsrv());
			}
			blOrderAppendBillParamDTO.setFg_susp(FBoolean.FALSE);// 补费的数据未挂起
			blOrderAppendBillParamDTO.setFg_hp(FBoolean.FALSE);// 记账上传医保标志
			// 折扣金额
			if (blOrderAppendBillParamDTO.getPrice_ratio() == null) {
				blOrderAppendBillParamDTO.setPrice_ratio(blOrderAppendBillParamDTO.getPrice());
			}
			blOrderAppendBillParamDTO.setAmt(blOrderAppendBillParamDTO.getAmt().setScale(-2, BigDecimal.ROUND_HALF_UP));
			blOrderAppendBillParamDTO.setAmt_std(blOrderAppendBillParamDTO.getAmt_std().setScale(-2, BigDecimal.ROUND_HALF_UP));
			blOrderAppendBillParamDTO.setAmt_hp(blOrderAppendBillParamDTO.getAmt_hp().setScale(-2, BigDecimal.ROUND_HALF_UP));
			blOrderAppendBillParamDTO.setAmt_pat(blOrderAppendBillParamDTO.getAmt_pat().setScale(-2, BigDecimal.ROUND_HALF_UP));
			if (blOrderAppendBillParamDTO.getAmt_ratio() == null) {
				blOrderAppendBillParamDTO.setAmt_ratio(blOrderAppendBillParamDTO.getAmt());
			} else {
				blOrderAppendBillParamDTO.setAmt_ratio(blOrderAppendBillParamDTO.getAmt_ratio().setScale(-2, BigDecimal.ROUND_HALF_UP));
			}
			if (blOrderAppendBillParamDTO.getName_inccaitm() == null || blOrderAppendBillParamDTO.getName_inccaitm().trim().length() == 0) {
				// 完善账单码
				IncCaItmDO incCaItmDO = getInccaitmCodeAndName(blOrderAppendBillParamDTO.getCode_enttp(), blOrderAppendBillParamDTO.getId_srv());
				if (incCaItmDO != null) {
					blOrderAppendBillParamDTO.setName_inccaitm(incCaItmDO.getName());
					blOrderAppendBillParamDTO.setCode_inccaitm(incCaItmDO.getCode());
				}
			}
		}
		for (String id_ent : id_entLst) {
			sumAmtRatio = new FDouble(0);
			blOrderAppendBillParamDTOLst.clear();
			for (BlOrderAppendBillParamDTO blOrderAppendBillParamDTO : appendBillParamDTO1) {
				if (id_ent.equals(blOrderAppendBillParamDTO.getId_ent())) {
					blOrderAppendBillParamDTOLst.add(blOrderAppendBillParamDTO);
					sumAmtRatio = sumAmtRatio.add(blOrderAppendBillParamDTO.getAmt_ratio().multiply(blOrderAppendBillParamDTO.getEu_direct()));
				}
			}
			identSumAmtRatioMap.put(id_ent, sumAmtRatio); // <就诊id,消费金额>
			identBlCgDTOMap.put(id_ent, blOrderAppendBillParamDTOLst);

			// BlOrderAppendBillParamDTO[]
			// tempDtoArr=SetOrderAppendBill(blOrderAppendBillParamDTOLst.toArray(new
			// BlOrderAppendBillParamDTO[0]),code_enttp, false);
			// for(BlOrderAppendBillParamDTO blOrderAppendBillParamDTO:
			// tempDtoArr)
			// {
			// blOrderAppendBillParamDTOResult.add(blOrderAppendBillParamDTO);
			// }
		}
		IBLOrderAppendBillServiceImplBp bp = new IBLOrderAppendBillServiceImplBp();
		return bp.SetOrderAppendBill_MultiPat_Bp_new(identBlCgDTOMap, identSumAmtRatioMap, id_entLst, orsrvids_list, code_enttp, false);
		// return blOrderAppendBillParamDTOResult.toArray(new
		// BlOrderAppendBillParamDTO[0]);
	}

	public FBoolean SetOrderRefundBill_ByIdor(BlOrderAppendBillParamDTO[] refundBillParamDTO, String code_enttp) throws BizException {
		IBLOrderAppendBillServiceImplBp bp = new IBLOrderAppendBillServiceImplBp();
		return bp.SetOrderRefundBill(refundBillParamDTO, true, code_enttp);

	}

	public FBoolean SetOrderRefundBill_ByItms(BlOrderAppendBillParamDTO[] refundBillParamDTO, String code_enttp) throws BizException {
		IBLOrderAppendBillServiceImplBp bp = new IBLOrderAppendBillServiceImplBp();
		return bp.SetOrderRefundBill(refundBillParamDTO, false, code_enttp);
	}

	/**
	 * 护士站执行退费
	 * 
	 * @param blOrderRefundBillParamDTO
	 *            退费条件
	 * @param code_enttp就诊类型
	 * @return
	 * @throws BizException
	 */
	public FBoolean SetOrderRefundBill_ByPlan(BlOrderRefundBillParamDTO[] blOrderRefundBillParamDTO, String code_enttp) throws BizException {
		List<BlOrderAppendBillParamDTO> BlOrderAppendBillParamDTOLst = new ArrayList<BlOrderAppendBillParamDTO>();
		for (BlOrderRefundBillParamDTO blOrderRefundBillParamDTO1 : blOrderRefundBillParamDTO) {
			BlOrderAppendBillParamDTO blOrderAppendBillParamDTO = new BlOrderAppendBillParamDTO();
			blOrderAppendBillParamDTO.setId_ent(blOrderRefundBillParamDTO1.getId_ent());
			blOrderAppendBillParamDTO.setRefundBillParamDTO(blOrderRefundBillParamDTO1);
			BlOrderAppendBillParamDTOLst.add(blOrderAppendBillParamDTO);
		}
		IBLOrderAppendBillServiceImplBp bp = new IBLOrderAppendBillServiceImplBp();
		return bp.SetOrderRefundBill(BlOrderAppendBillParamDTOLst.toArray(new BlOrderAppendBillParamDTO[0]), false, code_enttp);
	}

	public FBoolean SetOrderRefundBill_ByItms_MultiPat(BlOrderAppendBillParamDTO[] refundBillParamDTO, String code_enttp) throws BizException {
		List<BlOrderAppendBillParamDTO> blOrderAppendBillParamDTOLst = new ArrayList<BlOrderAppendBillParamDTO>();
		IBLOrderAppendBillServiceImplBp bp = new IBLOrderAppendBillServiceImplBp();
		List<String> id_entLst = new ArrayList<String>(); // 待退费的患者集合
		for (BlOrderAppendBillParamDTO blOrderAppendBillParamDTO : refundBillParamDTO) {
			if (!id_entLst.contains(blOrderAppendBillParamDTO.getRefundBillParamDTO().getId_ent())) {
				id_entLst.add(blOrderAppendBillParamDTO.getRefundBillParamDTO().getId_ent());
			}
		}
		for (String id_ent : id_entLst) {
			blOrderAppendBillParamDTOLst.clear();
			for (BlOrderAppendBillParamDTO blOrderAppendBillParamDTO : refundBillParamDTO) {
				if (id_ent.equals(blOrderAppendBillParamDTO.getRefundBillParamDTO().getId_ent())) {
					blOrderAppendBillParamDTOLst.add(blOrderAppendBillParamDTO);
				}
			}

			bp.SetOrderRefundBill(blOrderAppendBillParamDTOLst.toArray(new BlOrderAppendBillParamDTO[0]), false, code_enttp);
		}
		return FBoolean.TRUE;
	}

	public BlCgOepAggDTO getBlCgOepAggDTOFromBlOrderAppendBillParamDTO(BlOrderAppendBillParamDTO[] blOrderAppendBillParamDTOArr) throws BizException {
		BlCgOepAggDTO blCgOepAggDTO = new BlCgOepAggDTO();
		FArrayList blcgoepAggDOFLst = new FArrayList();
		BlcgoepAggDO blcgoepAggDO = new BlcgoepAggDO();
		if (blOrderAppendBillParamDTOArr != null && blOrderAppendBillParamDTOArr.length > 0) {
			GetBlCgDO blCgIns = new GetBlCgDO();
			BlCgOepDO blCgOepDO = new BlCgOepDO();
			TimeService timeService = new TimeServiceImpl();
			String strDateTime = timeService.getUFDateTime().toStdString();
			blCgOepDO = blCgIns.GetBlCgOepDO(blOrderAppendBillParamDTOArr[0], strDateTime);

			blcgoepAggDOFLst.add(blcgoepAggDO);
			blCgOepAggDTO.setBlcgoepAggDO(blcgoepAggDOFLst);
		}
		return blCgOepAggDTO;
	}

	/**
	 * 针对同一病人（id_pat）特定就诊的医嘱补费接口，返回值为计费完整的DTO,数据库中生成一条主记录，多条明细记录
	 * 
	 * @param appendBillParamDTO
	 *            医嘱补费需要的参数数组，数组中每行id_pat,code_enttp,是否允许后计费,门诊必填数据或住院结账必填数据相同
	 * @param isCiOrder
	 *            是否是医嘱记账，如果是true，则由本接口负责将医嘱转换成费用，其中，id_or必填；
	 *            否则(isCiOrder=false)
	 *            ，由调用方直接先将费用条目组装好(如果需要本接口计算费用，请将price设置为null)再传入本接口。
	 *            返回值：补费成功后的DTO
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	@Override
	public BlOrderAppendBillParamDTO[] SetOrderAppendBill(BlOrderAppendBillParamDTO[] appendBillParamDTO1, String code_enttp, boolean isCiOrder) throws BizException {
		IBLOrderAppendBillServiceImplBp bp = new IBLOrderAppendBillServiceImplBp();
		return bp.SetOrderAppendBill(appendBillParamDTO1, code_enttp, isCiOrder);
	}

	/**
	 * 医嘱退记账接口:
	 * 门诊退记账信息，必须录入id_or,id_orsrv,code_ent,id_pat,id_org,id_org_cg,id_dep_cg
	 * ,id_emp_cg
	 * 住院退记账信息，在BlOrderAppendBillParamDTO中必须生成RefundBillParamDTO，必须录入id_org_cg
	 * ,id_dep_cg,id_emp_cg,id_ent,id_or,id_orsrv,id_pat,id_org,code_ent
	 * 当isCiOrder
	 * =FBoolean.true时，按医嘱下服务整张退（同时满足这四个条件：id_pat,id_org,id_or,id_orsrv）；
	 * 当isCiOrder=FBoolean.false时,由调用方拼好所有信息，包括价格，标准费用等信息 code_ent：就诊类型代码,门诊还是住院
	 */
	@Override
	public FBoolean SetOrderRefundBill(BlOrderAppendBillParamDTO[] refundBillParamDTOs, boolean isCiOrder, String code_ent) throws BizException {
		IBLOrderAppendBillServiceImplBp bp = new IBLOrderAppendBillServiceImplBp();
		return bp.SetOrderRefundBill(refundBillParamDTOs, isCiOrder, code_ent);
	}

	/**
	 * 按住院记账主键进行住院记账退费，不更改医嘱信息
	 * 
	 * @param id_cgip
	 *            住院记账主键
	 * @param id_cgip
	 *            操作人员信息
	 * @return
	 * @throws BizException
	 */
	@Override
	public FBoolean RefundInpBlcgById_cgip(String[] Id_cgiparr, OperatorInfoDTO operatorInfoDTO) throws BizException {
		// 根据id_cgip查询id_ent
		IBlcgqueryRService iBlcgqueryMDORService = ServiceFinder.find(IBlcgqueryRService.class);
		BlCgIpDO blCgIpDO = iBlcgqueryMDORService.findById(Id_cgiparr[0]);
		if (blCgIpDO == null) {
			throw new BizException("没有查询到患者原始记账记录");
		}
		String id_ent = blCgIpDO.getId_ent();
		List<BlOrderAppendBillParamDTO> OrginBlOrderAppendBillParamDTOList = new ArrayList<BlOrderAppendBillParamDTO>();
		for (String Id_cgip : Id_cgiparr) {
			BlOrderAppendBillParamDTO dto = new BlOrderAppendBillParamDTO();
			BlOrderRefundBillParamDTO refundBillDTO = new BlOrderRefundBillParamDTO();
			refundBillDTO.setId_cg_pk(Id_cgip);
			refundBillDTO.setId_org_cg(operatorInfoDTO.getId_org_emp());
			refundBillDTO.setId_dep_cg(operatorInfoDTO.getId_dep());
			refundBillDTO.setId_emp_cg(operatorInfoDTO.getId_emp());
			refundBillDTO.setId_ent(id_ent);
			dto.setSrcfunc_des(IBlCgCodeConst.RefundInpBlcgById_cgip); // 来源于医技退费
			dto.setRefundBillParamDTO(refundBillDTO);
			dto.setId_ent(id_ent);
			OrginBlOrderAppendBillParamDTOList.add(dto);
		}
		IBLOrderAppendBillServiceImplBp bp = new IBLOrderAppendBillServiceImplBp();
		bp.SetOrderRefundBill(OrginBlOrderAppendBillParamDTOList.toArray(new BlOrderAppendBillParamDTO[] {}), false, IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		return FBoolean.TRUE;
	}

	/**
	 * 根据id_ent,id_or,id_orsrv和操作员信息，返回完整的BlOrderAppendBillParamDTO数组
	 * 
	 * @param appendBillParamDTOArr
	 *            挂号显示价格调用时：
	 *            1.id_pat,id_enttp,code_enttp,id_srv,quan,eu_direct(挂号填1
	 *            ),id_org_mp,id_dep_mp必填,其他字段可省;
	 *            2.如果需要支持后付费，则需要设置BlOrderAppendBillParamDTO
	 *            .setOutpBillDTO(OutpBillDTO.fg_acc=FBoolean.true)
	 * @param operatorInfoDTO
	 *            操作员信息
	 * @param id_pripat
	 *            患者价格分类
	 * @return 完整的BlOrderAppendBillParamDTO数组
	 * @throws BizException
	 */
	private BlOrderAppendBillParamDTO[] getBlOrderAppendBillParamDTOArr_byIdentIdorIdorsrv(BlOrderAppendBillParamDTO[] appendBillParamDTOArr, OperatorInfoDTO operatorInfoDTO) throws BizException {
		String id_pripat = "";
		DAFacade dafacade = new DAFacade();
		List<PatiVisitDO> patiVisitDOLst = (List<PatiVisitDO>) dafacade.execQuery("select id_pripat from en_ent where id_ent='" + appendBillParamDTOArr[0].getId_ent() + "'", new BeanListHandler(PatiVisitDO.class));
		if (patiVisitDOLst != null && patiVisitDOLst.size() > 0) {
			id_pripat = patiVisitDOLst.toArray(new PatiVisitDO[0])[0].getId_pripat();
		}
		// 查医嘱
		String sql = "";
		for (BlOrderAppendBillParamDTO blOrderAppendBillParamDTO : appendBillParamDTOArr) {
			sql = "select  p.id_pres,p.id_pat,p.id_entp,p.code_entp,p.id_srv,p.quan_total_medu,p.id_medu ,p.id_org_mp,p.id_dep_mp,p.fg_mm from ci_or_srv p where p.id_or='" + blOrderAppendBillParamDTO.getId_or() + "' and p.id_orsrv='" + blOrderAppendBillParamDTO.getId_orsrv() + "'";
			List<OrdSrvDO> ordSrvDOLst = (List<OrdSrvDO>) dafacade.execQuery(sql, new BeanListHandler(OrdSrvDO.class));
			if (ordSrvDOLst != null && ordSrvDOLst.size() > 0) {
				OrdSrvDO ordSrvDO = ordSrvDOLst.toArray(new OrdSrvDO[0])[0];
				if (blOrderAppendBillParamDTO.getId_pres() == null) // 物品预付费时，有id_pres
				{
					blOrderAppendBillParamDTO.setId_pres(ordSrvDO.getId_pres());
				}
				blOrderAppendBillParamDTO.setId_pat(ordSrvDO.getId_pat());
				blOrderAppendBillParamDTO.setId_enttp(ordSrvDO.getId_entp());
				blOrderAppendBillParamDTO.setCode_enttp(ordSrvDO.getCode_entp());
				blOrderAppendBillParamDTO.setId_srv(ordSrvDO.getId_srv());
				blOrderAppendBillParamDTO.setId_org_mp(ordSrvDO.getId_org_mp());
				blOrderAppendBillParamDTO.setId_dep_mp(ordSrvDO.getId_dep_mp());
				blOrderAppendBillParamDTO.setFg_mm(ordSrvDO.getFg_mm());
				if (ordSrvDO.getFg_mm() == null || !ordSrvDO.getFg_mm().booleanValue())// 非物品
				{
					blOrderAppendBillParamDTO.setQuan(ordSrvDO.getQuan_total_medu());
					blOrderAppendBillParamDTO.setSrvu(ordSrvDO.getId_medu());
				} else// 物品
				{
					sql = "select  q.id_orsrvmm,q.id_mm,q.quan_cur,q.sd_Mmtp,q.code_mm,q.id_pgku_cur ,q.id_pgku_base,q.factor from ci_or_srv p inner join ci_or_srv_mm q  on p.id_orsrv=q.id_orsrv where p.id_or='" + blOrderAppendBillParamDTO.getId_or() + "' and p.id_orsrv='" + blOrderAppendBillParamDTO.getId_orsrv() + "'";

					List<OrdSrvMmDO> ordSrvMmDOLst = (List<OrdSrvMmDO>) dafacade.execQuery(sql, new BeanListHandler(OrdSrvMmDO.class));
					if (ordSrvMmDOLst != null && ordSrvMmDOLst.size() > 0) {
						OrdSrvMmDO ordSrvMmDO = ordSrvMmDOLst.toArray(new OrdSrvMmDO[0])[0];
						blOrderAppendBillParamDTO.setQuan(ordSrvMmDO.getQuan_cur());
						blOrderAppendBillParamDTO.setSrvu(ordSrvMmDO.getId_pgku_cur());
						blOrderAppendBillParamDTO.setSd_mmtp(ordSrvMmDO.getSd_mmtp());
						blOrderAppendBillParamDTO.setCode_mm(ordSrvMmDO.getCode_mm());
						blOrderAppendBillParamDTO.setId_mm(ordSrvMmDO.getId_mm());
						blOrderAppendBillParamDTO.setPgku_base(ordSrvMmDO.getId_pgku_base());
						blOrderAppendBillParamDTO.setPgku_cur(ordSrvMmDO.getId_pgku_cur());
						blOrderAppendBillParamDTO.setFactor(ordSrvMmDO.getFactor());
					}

				}
			}
		}

		BlAppendOrRefundBillBP bp = new BlAppendOrRefundBillBP();
		return bp.getBlOrderAppendBillParamDTOArr(appendBillParamDTOArr, operatorInfoDTO, id_pripat);
	}

	/**
	 * 根据服务ID（非物品），返回完整的BlOrderAppendBillParamDTO数组
	 * 
	 * @param appendBillParamDTOArr
	 *            挂号显示价格调用时：
	 *            1.id_pat,id_enttp,code_enttp,id_srv,quan,eu_direct(挂号填1
	 *            ),id_org_mp,id_dep_mp必填,其他字段可省;
	 *            2.如果需要支持后付费，则需要设置BlOrderAppendBillParamDTO
	 *            .setOutpBillDTO(OutpBillDTO.fg_acc=FBoolean.true)
	 * @param operatorInfoDTO
	 *            操作员信息
	 * @param id_pripat
	 *            患者价格分类
	 * @return 完整的BlOrderAppendBillParamDTO数组
	 * @throws BizException
	 */
	public BlOrderAppendBillParamDTO[] getBlOrderAppendBillParamDTOArr(BlOrderAppendBillParamDTO[] appendBillParamDTOArr, OperatorInfoDTO operatorInfoDTO, String id_pripat) throws BizException {
		BlAppendOrRefundBillBP bp = new BlAppendOrRefundBillBP();
		return bp.getBlOrderAppendBillParamDTOArr(appendBillParamDTOArr, operatorInfoDTO, id_pripat);
	}

	/**
	 * 单患者：按医嘱号（id_or)补费，由本接口负责将医嘱转换成对应的费用明细存入费用明细表
	 * 
	 * @param id_or
	 *            需要记费的医嘱号数组
	 * @param operatorInfoDTO
	 *            操作人员信息
	 * @param srcfunc_des
	 *            费用来源执行点
	 * @return
	 * @throws BizException
	 */
	public BlOrderAppendBillParamDTO[] SetOrderAppendBill_ByIdor(String id_or, OperatorInfoDTO operatorInfoDTO, String srcfunc_des) throws BizException {

		String id_pripat = "";
		String code_enttp = "";
		// 1.入参验证
		if (id_or == null) {
			throw new BizException("没有待记费的医嘱");
		}
		if (operatorInfoDTO == null) {
			throw new BizException("没有操作人员信息");
		}
		if (code_enttp == null) {
			throw new BizException("没有就诊类型");
		}
		if (srcfunc_des == null) {
			throw new BizException("没有明确执行调用点");
		}
		// 2.获得ci中的信息
		List<BlOrderAppendBillParamDTO> blOrderAppendBillParamDTOLst = new ArrayList<BlOrderAppendBillParamDTO>();
		ICiOrdQryService iCiOrdQryService = ServiceFinder.find(ICiOrdQryService.class);
		UnchargeOrdSrvDTO[] unchargeOrdSrvDTOArr = iCiOrdQryService.getUnchargeOrderSrv(id_or);
		for (UnchargeOrdSrvDTO unchargeOrdSrvDTO : unchargeOrdSrvDTOArr) {
			blOrderAppendBillParamDTOLst.add(setBlOrderAppendBillParamDTO(unchargeOrdSrvDTO, operatorInfoDTO, srcfunc_des));
		}
		if (blOrderAppendBillParamDTOLst == null || blOrderAppendBillParamDTOLst.size() == 0) {
			return null;
		}
		// 3.记费
		code_enttp = blOrderAppendBillParamDTOLst.toArray(new BlOrderAppendBillParamDTO[0])[0].getCode_enttp();
		IBLOrderAppendBillServiceImplBp bp = new IBLOrderAppendBillServiceImplBp();
		return bp.SetOrderAppendBill(blOrderAppendBillParamDTOLst.toArray(new BlOrderAppendBillParamDTO[0]), code_enttp, true);

	}

	// 将未记账医嘱信息转换为可展示DTO
	private BlOrderAppendBillParamDTO setBlOrderAppendBillParamDTO(UnchargeOrdSrvDTO srvDTO, OperatorInfoDTO operatorInfoDTO, String srcfunc_des) {
		BlOrderAppendBillParamDTO ordShow = new BlOrderAppendBillParamDTO();
		ordShow.setId_emp_cg(operatorInfoDTO.getId_emp());
		ordShow.setId_org(operatorInfoDTO.getId_org());
		ordShow.setId_org_mp(srvDTO.getId_org_mp());
		ordShow.setId_org_or(srvDTO.getId_org_srv());
		ordShow.setId_dep_mp(srvDTO.getId_dep_mp());
		ordShow.setId_dep_wh(srvDTO.getId_dep_wh());
		ordShow.setFg_reserveMaterials(FBoolean.TRUE);// 调用物品预留
		ordShow.setId_dep_or(srvDTO.getId_dep_srv());
		ordShow.setId_emp_or(srvDTO.getId_emp_srv());
		ordShow.setId_ent(srvDTO.getId_en());
		ordShow.setId_enttp(srvDTO.getId_entp());
		ordShow.setId_grp(operatorInfoDTO.getId_grp());
		ordShow.setId_mm(srvDTO.getId_mm());
		// ordShow.setId_pat(ordDTO.getId_pat());
		ordShow.setId_pat(srvDTO.getId_pat());
		ordShow.setId_srv(srvDTO.getId_srv());
		ordShow.setId_srvca(srvDTO.getId_srvtp());
		// 医保计划
		ordShow.setId_hp(srvDTO.getId_hp());
		// 服务项目医保类别
		ordShow.setId_hpsrvtp(srvDTO.getId_hpsrvtp());
		// 服务项目医保类别
		ordShow.setSd_hpsrvtp(srvDTO.getSd_hpsrvtp());
		ordShow.setSd_srvtp(srvDTO.getSd_srvtp());
		ordShow.setId_srvtp(srvDTO.getId_srvtp());
		ordShow.setCode_enttp(srvDTO.getCode_entp());
		// tcy:在医嘱领域：物品信息取数为ci_or_srv_mm.quan_cur;非物品为ci_or_srv.quan_medu
		if (!srvDTO.getFg_mm().booleanValue()) {
			ordShow.setQuan(new FDouble(srvDTO.getQuan_med()));
		} else {
			ordShow.setQuan(srvDTO.getQuan_cur());
		}

		ordShow.setQuan_base(srvDTO.getQuan_base());
		ordShow.setPgku_cur(srvDTO.getId_unit_cur());
		ordShow.setPgku_base(srvDTO.getId_unit_cur());
		ordShow.setFactor(srvDTO.getFactor_cb());
		ordShow.setFg_Cgoep(FBoolean.FALSE);

		ordShow.setId_or(srvDTO.getId_or());

		ordShow.setId_orsrv(srvDTO.getId_orsrv());
		ordShow.setName_srv(srvDTO.getName_srv());
		ordShow.setName_mm(srvDTO.getName_mm());
		// tcy:医嘱日期
		ordShow.setDt_or(srvDTO.getDt_sign());

		ordShow.setCode_enttp(srvDTO.getCode_entp());// new
		ordShow.setCode_srv(srvDTO.getCode_srv());// new

		if (srvDTO.getFg_mm().booleanValue()) {
			ordShow.setSrvu(srvDTO.getId_unit_cur());// 获取在医嘱服务数据中单位的ID值
		} else {
			ordShow.setSrvu(srvDTO.getId_unit_med());// new 服务项目单位
		}
		ordShow.setId_pres(srvDTO.getId_pres());// new 处方
		ordShow.setSrcfunc_des(IBlCgCodeConst.OpFeeCollect);// 来源门诊收费

		ordShow.setId_hp(srvDTO.getId_hp());// 医保
		ordShow.setId_hpsrvtp(srvDTO.getId_hpsrvtp());// 医保
		ordShow.setSd_hpsrvtp(srvDTO.getSd_hpsrvtp());// 医保
		ordShow.setSd_mmtp(srvDTO.getSd_mmtp());// new 物品类型编码

		ordShow.setCode_mm(srvDTO.getCode_mm());// new 物品编码
		ordShow.setId_mmtp(srvDTO.getId_mmtp());// new 物品类型
		ordShow.setSd_mmtp(srvDTO.getSd_mmtp());// new 物品类型编码
		ordShow.setFg_mm(srvDTO.getFg_mm());// new 物品标示
		ordShow.setSrcfunc_des(srcfunc_des);// 数据执行点来源
		ordShow.setEu_direct(BookRtnDirectEnum.CHARGES); // 记费
		ordShow.setEu_srctp(0);// 数据来源:医嘱产生
		ordShow.setId_pripat(srvDTO.getId_pripat());// new 患者价格类型

		return ordShow;
	}

	/**
	 * 根据就诊类型和ID_srv，查询对应的账单项
	 * 
	 * @param code_enttp
	 *            就诊类型代码
	 * @param id_srv
	 *            服务ID
	 * @return 对应的账单项
	 * @throws BizException
	 */
	private IncCaItmDO getInccaitmCodeAndName(String code_enttp, String id_srv) throws BizException {
		IBdInccaQueService iBdInccaQueService = ServiceFinder.find(IBdInccaQueService.class);
		return iBdInccaQueService.getInccaitmCodeAndName(code_enttp, id_srv);
	}

}
