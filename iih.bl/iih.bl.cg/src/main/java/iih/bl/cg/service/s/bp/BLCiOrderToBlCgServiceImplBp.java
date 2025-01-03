package iih.bl.cg.service.s.bp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.MapUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.inccasplit.d.BdInccaSplitDO;
import iih.bd.pp.inccasplit.i.IInccasplitRService;
import iih.bd.pp.pripat.d.PriPatDO;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.d.desc.BlCgOepDODesc;
import iih.bl.cg.blcgoep.i.IBlcgoepCudService;
import iih.bl.cg.blcgoep.i.IBlcgoepRService;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.bp.GetBlCgDO;
import iih.bl.cg.bp.GetBlCgItmOepMap;
import iih.bl.cg.bp.GetBlCgOepAggByItmsQuery;
import iih.bl.cg.bp.GetBlPsnDocName;
import iih.bl.cg.bp.SetBlOrderAppendBillParamDTOPricing;
import iih.bl.cg.dto.d.BlCgItmOepMapDTO;
import iih.bl.cg.dto.d.BlcgOepAggDTO;
import iih.bl.cg.s.bp.comparator.OpIncComparator;
import iih.bl.cg.service.d.BlCgOepAggDTO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.cg.service.s.bp.qry.BlPropArQry;
import iih.bl.cg.service.s.bp.qry.GetRegInvoiceStDOQry;
import iih.bl.comm.GetCodeByCustomization;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.inc.blinccanc.d.BlIncCancDO;
import iih.bl.inc.blincoep.d.BlIncCgItmOep;
import iih.bl.inc.blincoep.d.BlIncItmOepDO;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlStIncOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.d.desc.BlIncOepDODesc;
import iih.bl.inc.blincoep.i.IBlincoepCudService;
import iih.bl.inc.blincoep.i.IBlincoepRService;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.inc.blincquerydto.d.BlInvoiceDetailsDTO;
import iih.bl.inc.blincquerydto.d.BlInvoiceHeadTailDTO;
import iih.bl.inc.blincquerydto.d.BlInvoicePmDTO;
import iih.bl.inc.blincquerydto.d.BlinvoicecaitmDTO;
import iih.bl.inc.blincquerydto.d.PatHpInfoDTO;
import iih.bl.inc.dto.blincprint.d.BlIncPrintDTO;
import iih.bl.inc.dto.d.BlIncissOepDTO;
import iih.bl.inc.i.IBlIncCmdService;
import iih.bl.inc.i.IBlIncOutCmdService;
import iih.bl.inc.service.i.IBLInvoiceService;
import iih.bl.params.BlParams;
import iih.bl.params.BlParamsAnalysisUtil;
import iih.bl.prop.blproparoep.d.BlPropArOepDO;
import iih.bl.prop.blproparoep.d.BlproparoepAggDO;
import iih.bl.prop.blproparoep.d.desc.BlPropArOepDODesc;
import iih.bl.prop.blproparoep.i.IBlproparoepCudService;
import iih.bl.prop.blproparoep.i.IBlproparoepRService;
import iih.bl.prop.blpropoep.d.BlPropOepDO;
import iih.bl.prop.blpropoep.i.IBlpropoepCudService;
import iih.bl.prop.blpropoep.i.IBlpropoepRService;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.d.PayDirectEnum;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepCudService;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepRService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.bl.st.blstoep.d.desc.BlStOepDODesc;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import iih.bl.st.blstoep.i.IBlstoepRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.FeeReverseType;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.ci.ord.pres.d.CiPresDO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.mm.itf.material.d.ReserveReqDTO;
import iih.mm.itf.material.i.IMaterialStockService;
import iih.mp.dg.dto.d.OpPresQueSiteDTO;
import iih.mp.dg.i.IMpDgConst;
import iih.mp.dg.i.IMpDgOutService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.mapping.DORsReferMap;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 划价、收费业务逻辑
 * 
 * @author tcy
 * 
 */
public class BLCiOrderToBlCgServiceImplBp {

	/**
	 * 获得所有商保对应的付款单位
	 * 
	 * @return
	 * @throws BizException
	 */
	public Map<String, String> getAllIdCustByIdHp() throws BizException {
		// 查询商保对应的付款单位
		Map<String, String> hp_cust = new HashMap<String, String>();
		List<HPDO> priStdSrvDTOLst = new ArrayList<HPDO>();
		DAFacade dafacade = new DAFacade();
		StringBuffer sqlb = new StringBuffer();
		sqlb.append(" select b.id_hp,b.id_cust from en_ent a inner join bd_hp b on a.id_hp=b.id_hp where b.fg_hpcg='Y'  ");
		List<HPDO> hPDOLst = (List<HPDO>) dafacade.execQuery(sqlb.toString(), new BeanListHandler(HPDO.class));
		for (HPDO hPDO : hPDOLst) {
			//TODO:基础数据迭代，删除付款客户，需与PO确认如何处理
//			hp_cust.put(hPDO.getId_hp(), hPDO.getId_cust());
		}
		return hp_cust;
	}

	/**
	 * 查询门诊或急诊中离院未结算的患者id_ent。
	 *
	 * @param days
	 *            结算距今天的头几个自然日的费用信息
	 * @throws BizException
	 */
	public List<PatiVisitDO> getIdEntsFromCiWithoutSettlement_hpcg(int days) throws BizException {
		TimeService timeService = new TimeServiceImpl();
		String strDateTime = timeService.getUFDateTime().getDateTimeBefore(days).toLocalString();
		List<String> id_entLst = new ArrayList<String>();
		DAFacade dafacade = new DAFacade();
		StringBuffer sqlb1 = new StringBuffer();
		sqlb1.append(" select distinct ent.id_ent,ent.id_pat,ent.id_hp");
		sqlb1.append("   from ci_or_srv ci");
		sqlb1.append("  inner join en_ent ent");
		sqlb1.append("     on ci.id_en = ent.id_ent");
		sqlb1.append("  inner join bd_hp");
		sqlb1.append("     on ent.id_hp = bd_hp.id_hp");
		sqlb1.append("  where ent.code_entp in ('").append(IBdFcDictCodeConst.SD_CODE_ENTP_OP).append("', '").append(IBdFcDictCodeConst.SD_CODE_ENTP_ET).append("')");
		sqlb1.append("    and ci.sd_su_bl = '0'");
		sqlb1.append("   and bd_hp.fg_hpcg = 'Y'");
		// 还差个判断医嘱签署状态的条件,和签署日期
		SqlParam param = new SqlParam();
		// TODO:差传参
		List<PatiVisitDO> list = (List<PatiVisitDO>) new DAFacade().execQuery(sqlb1.toString(), param, new BeanListHandler(PatiVisitDO.class));

		return list;
	}

	/**
	 * 金额校验。费用明细金额是否与支付金额相等
	 * 
	 * @param blcgoepAggDO_recharge
	 *            重新收费的费用明细
	 * @param payAmt
	 *            支付金额
	 * @return 如果不相等，抛出错误
	 */
	public void validate_fee_recharge(BlcgoepAggDO[] blcgoepAggDO_recharge, FDouble payAmt) throws BizException {
		FDouble sum_amt = new FDouble(0);
		for (BlcgoepAggDO blcgoepAggDO1 : blcgoepAggDO_recharge) {
			BlCgItmOepDO[] blCgItmOepDOArr = blcgoepAggDO1.getBlCgItmOepDO();
			for (BlCgItmOepDO blCgItmOepDO : blCgItmOepDOArr) {
				sum_amt = sum_amt.add(blCgItmOepDO.getAmt_ratio().multiply(blcgoepAggDO1.getParentDO().getEu_direct()));
			}
		}
		if (!(sum_amt.compareTo(payAmt) == 0)) {
			throw new BizException("已经收费的项目，不允许修改价格分类后再次执行相关操作！");
		}

	}

	/**
	 * 拼收付款AGG,供商保后台自动结算使用
	 * 
	 * @param AmtPay
	 *            商保支付金额
	 * @param operatorInfoDTO
	 *            操作员信息
	 * @param id_pat
	 *            患者ID
	 * @param id_cust
	 *            支付单位
	 * @return
	 */
	public BlpaypatoepAggDO AssemblePayData(FDouble AmtPay, OperatorInfoDTO operatorInfoDTO, String id_pat, String id_cust) {
		BlpaypatoepAggDO blpaypatoepAggDO = new BlpaypatoepAggDO();
		// 1.组装主表
		BlPayPatOepDO blPayPatOepDO = new BlPayPatOepDO();
		blPayPatOepDO.setId_grp(operatorInfoDTO.getId_grp());
		blPayPatOepDO.setId_org(operatorInfoDTO.getId_org());
		blPayPatOepDO.setId_enttp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);// const
		blPayPatOepDO.setCode_enttp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);// const
		blPayPatOepDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_ST);// const
		blPayPatOepDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_ST);// const
		blPayPatOepDO.setId_pat(id_pat);
		blPayPatOepDO.setEu_direct(PayDirectEnum.CHARGE);
		// 费用来源
		blPayPatOepDO.setSd_pttp(IBlDictCodeConst.SD_PTTP_WINDOW);
		// 实际的收付款数肯定应该是要收入的金额
		blPayPatOepDO.setAmt(AmtPay);
		blPayPatOepDO.setId_org_pay(operatorInfoDTO.getId_org_emp());
		blPayPatOepDO.setId_dep_pay(operatorInfoDTO.getId_dep());
		blPayPatOepDO.setId_emp_pay(operatorInfoDTO.getId_emp());
		blPayPatOepDO.setFg_cc(FBoolean.FALSE);
		blpaypatoepAggDO.setParentDO(blPayPatOepDO);

		// 2. 组装子表
		BlPayItmPatOepDO[] arr = new BlPayItmPatOepDO[1];
		BlPayItmPatOepDO blPayItmPatOepDO_1 = new BlPayItmPatOepDO();
		blPayItmPatOepDO_1.setId_grp(operatorInfoDTO.getId_grp());
		blPayItmPatOepDO_1.setId_org(operatorInfoDTO.getId_org());
		blPayItmPatOepDO_1.setEu_direct(Integer.valueOf(IBlDictCodeConst.SD_DIRECT_CHARGE).intValue());
		blPayItmPatOepDO_1.setId_pm(IBdPripmCodeConst.ID_PRI_PM_COMPANY);
		blPayItmPatOepDO_1.setId_cust(id_cust);
		blPayItmPatOepDO_1.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_COMPANY);
		blPayItmPatOepDO_1.setStatus(DOStatus.NEW);
		blPayItmPatOepDO_1.setPaymodenode(null);
		blPayItmPatOepDO_1.setAmt(AmtPay);
		blPayItmPatOepDO_1.setFg_realpay(FBoolean.TRUE);// 真实数据
		arr[0] = blPayItmPatOepDO_1;
		// 子项添加到AggDO
		blpaypatoepAggDO.setBlPayItmPatOepDO(arr);

		return blpaypatoepAggDO;
	}

	/**
	 * 重打发票业务
	 * 
	 * @param strCodeSt
	 * @param operatorInfoDto
	 * @return
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] doReprintInc(String strCodeSt, OperatorInfoDTO operatorInfoDto) throws BizException {
		if (StringUtil.isEmpty(strCodeSt)) {
			throw new BizException("没有传入结算流水号！");
		}
		// 查找原结算信息
		IBlstoepRService iBlstoepRService = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO[] blStOepDOArr = iBlstoepRService.findByAttrValString("Code_st", strCodeSt);
		if (ArrayUtil.isEmpty(blStOepDOArr))
			throw new BizException("未找到结算信息，请核对结算流水号是否正确！");

		// 1.操作合法性校验，判断是否可以重打印发票
		// 校验原发票信息是否已经结账，如果已经结账，则不再可以重打，应该不会出现该问题，一般重打是因为打印机卡纸
		IBlincoepRService iBlincoepRService = ServiceFinder.find(IBlincoepRService.class);
		BlincoepAggDO[] blincoepAggDOArr = iBlincoepRService.findByAttrValString(BlIncOepDO.ID_STOEP, blStOepDOArr[0].getId_stoep());
		// 原发票信息
		BlIncOepDO blincOepDo = null;
		if (!ArrayUtil.isEmpty(blincoepAggDOArr)) {
			blincOepDo = blincoepAggDOArr[0].getParentDO();
		}
		// 校验发票信息，只能处理未记账以及本人开立的发票
		if (blincOepDo.getFg_cc_out().booleanValue())
			throw new BizException("该发票已经结账，不能再补打发票！");
		// 非本人开具不能补打
		if (!blincOepDo.getId_emp_inc().equals(operatorInfoDto.getId_emp()))
			throw new BizException("该发票非本人开具，请找相关开票人员补打！");

		// 2.作废原发票
		IBLInvoiceService incService = ServiceFinder.find(IBLInvoiceService.class);
		// 考虑到分票的情况，一次结算对应多张发票，则对于原发票单独处理
		for (BlincoepAggDO incAggdo : blincoepAggDOArr) {
			// 原发票
			BlIncOepDO blIncOepDO = incAggdo.getParentDO();
			// 作废空白票
			BlIncCancDO blIncCancDO = new BlIncCancDO();
			blIncCancDO.setCode_incpkg(blIncOepDO.getCode_incpkg());
			blIncCancDO.setIncno(blIncOepDO.getIncno());
			blIncCancDO.setId_emp_canc(operatorInfoDto.getId_emp());
			blIncCancDO.setSd_reason_canc(IBdPpCodeTypeConst.SD_OTHER);
			blIncCancDO.setId_reason_canc(IBdPpCodeTypeConst.SD_OTHER);
			blIncCancDO.setId_incca(IBdPpCodeTypeConst.ID_OUTPATIENT_INVOICE);
			blIncCancDO.setDes_reason_canc(IBdPpCodeTypeConst.DES_OTHER);
			blIncCancDO.setDt_canc(AppUtils.getServerDateTime());
			blIncCancDO.setFg_canc(FBoolean.TRUE);
			blIncCancDO.setId_grp(operatorInfoDto.getId_grp());
			blIncCancDO.setId_org(operatorInfoDto.getId_org());
			blIncCancDO.setStatus(DOStatus.NEW);
			
			//增加计算机模式-修改人韩净旗-2018-07-21
			BlIncissOepDTO incIssOepDto = null;
			blIncCancDO.setId_pc(blIncOepDO.getId_pc());
			
			incService.AddBlIncCanc(operatorInfoDto.getId_emp(), IBdPpCodeTypeConst.SD_OUTPATIENT_INVOICE, blIncCancDO);
			incIssOepDto = incService.useReceipt(operatorInfoDto.getId_emp(), IBdPpCodeTypeConst.SD_OUTPATIENT_INVOICE);
			// 更新原发票信息
			// 获取最新发票信息
//			BlIncissOepDTO incIssOepDto = incService.useReceipt(operatorInfoDto.getId_emp(), IBdPpCodeTypeConst.SD_OUTPATIENT_INVOICE);
			// 更新的门诊发票
			blIncOepDO.setIncno(incIssOepDto.getIncno_cur());
			blIncOepDO.setCode_incpkg(incIssOepDto.getCode_incpkg());
			blIncOepDO.setDt_inc(AppUtils.getServerDateTime());
			blIncOepDO.setStatus(DOStatus.UPDATED);

		}
		IBlincoepCudService iBlincoepCudService = ServiceFinder.find(IBlincoepCudService.class);
		BlincoepAggDO[] blincoepAggDOArrUpdated = iBlincoepCudService.save(blincoepAggDOArr);

		// 获取最新的发票信息
		// BlIncItmVsTypeDTO[]
		// incOepDtoArr=getIncvoiceInfoByIdStOep(blStOepDOArr[0].getId_stoep());
		// review by yangyang 这里不再走上述接口，直接组装数据，走上边接口重新查询一遍发票信息，这里没必要
		BlIncItmVsTypeDTO[] incOepDtoArr = assemblyIncInfoDtos(blStOepDOArr[0], blincoepAggDOArrUpdated);
		return incOepDtoArr;
	}

	/**
	 * 根据结算主键获取发票信息
	 * 
	 * @param strIdStOep
	 *            结算主键
	 * @return 发票信息
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] getIncvoiceInfoByIdStOep(String strIdStOep) throws BizException {
		// 1、查找原结算信息
		IBlstoepRService stOepService = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO stOepDo = stOepService.findById(strIdStOep);
		if (stOepDo == null)
			throw new BizException("结算信息查找失败!");
		// 2、查找对应的发票信息
		IBlincoepRService incOepRService = ServiceFinder.find(IBlincoepRService.class);
		String strWhere = String.format(BlIncOepDODesc.TABLE_ALIAS_NAME + ".id_stoep='%s'", strIdStOep);
		BlincoepAggDO[] incOepAggdoLst = incOepRService.find(strWhere, "", FBoolean.FALSE);
		if (ArrayUtil.isEmpty(incOepAggdoLst))
			throw new BizException("未查询到发票信息！");

		return assemblyIncInfoDtos(stOepDo, incOepAggdoLst);
	}

	/**
	 * 重新打印发票
	 * 
	 * @param strIdPat
	 *            患者主键ID
	 * @param operatorInfoDTO
	 *            操作人员信息
	 * @param strArr
	 *            结算ID
	 * @return 发票信息DTO
	 * @throws BizException
	 * @author Liwq 添加参数解决挂号发票选择性打印
	 */
	public BlIncItmVsTypeDTO[] printRegisterInvoice(String strIdPat, OperatorInfoDTO operatorInfoDTO, String[] strArr) throws BizException {
		String strCond = "";
		if (strArr != null) {
			strCond = "'";
			for (int j = 0; j < strArr.length; j++) {
				strCond += strArr[j];
				if (strArr.length - 1 != j)
					strCond += "','";
			}
			strCond += "'";
		}

		BLCancelSettlementImplBp bLCancelSettlementImplBp = new BLCancelSettlementImplBp();

		// 1、获取患者所有未打印发票的挂号结算
		BlStOepDO[] stDos = (BlStOepDO[]) AppFwUtil.getDORstWithDao(new GetRegInvoiceStDOQry(strIdPat, strCond), BlStOepDO.class);
		List<BlIncItmVsTypeDTO> retList = new ArrayList<BlIncItmVsTypeDTO>();
		if (ArrayUtil.isEmpty(stDos)) {
			return new BlIncItmVsTypeDTO[0];
		}
		/*// 创建接口操作类
		IBlincoepRService iBlincoepRService = ServiceFinder.find(IBlincoepRService.class);
		IBlincoepCudService iBlincoepCudService = ServiceFinder.find(IBlincoepCudService.class);
		IBLInvoiceService iBLInvoiceService = ServiceFinder.find(IBLInvoiceService.class);
		// 3.创建统一保存的集合
		List<BlincoepAggDO> saveDos = new ArrayList<BlincoepAggDO>();
		// 2.遍历患者为打印结算并组装发票数据
		for (BlStOepDO blStOepDO : stDos) {
			if (blStOepDO.getEu_direct() == -1) {
				if (!bLCancelSettlementImplBp.getFPrintRedInc(blStOepDO.getId_ent()).booleanValue()) {
					continue; // 不打印红冲票
				}
			}
			// 3.获取结算对应的发票数据集合
			BlincoepAggDO[] incOepAggdoLst = iBlincoepRService.findByAttrValString("Id_stoep", blStOepDO.getId_stoep());
			if (strArr != null) {
				// 4.循环发票数据
				for (BlincoepAggDO aggDO : incOepAggdoLst) {
					// 5.对应当前用户获取对应发票数据
					BlIncissOepDTO oepDTO = iBLInvoiceService.useReceipt(operatorInfoDTO.getId_emp(), IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE);
					// 6.将发票数据赋值给 发票DO中
					aggDO.getParentDO().setCode_incpkg(oepDTO.getCode_incpkg());
					aggDO.getParentDO().setIncno(oepDTO.getIncno_cur());
					aggDO.getParentDO().setDt_inc(new TimeServiceImpl().getUFDateTime());
					aggDO.getParentDO().setId_emp_canc(null);
					aggDO.getParentDO().setId_emp_inc(operatorInfoDTO.getId_emp());
					aggDO.getParentDO().setTimes_prn(1);
					aggDO.getParentDO().setFg_print(FBoolean.TRUE);
					aggDO.getParentDO().setFg_canc(FBoolean.FALSE);
					aggDO.getParentDO().setStatus(DOStatus.UPDATED);
					// 7.添加到需要保存的DO集合中
					saveDos.add(aggDO);
				}
			}
			// 8.组装赋值后的结算与发票数据 获取发票拼装DO
			BlIncItmVsTypeDTO[] retDos = assemblyIncInfoDtos(blStOepDO, incOepAggdoLst);
			// 9.将拼装DO 添加到返回的数据集合
			for (BlIncItmVsTypeDTO blIncItmVsTypeDTO : retDos) {
				if (blStOepDO.getEu_direct() == -1) {
					blIncItmVsTypeDTO.setFg_RedInvoice(FBoolean.TRUE);// 挂号红冲票
				}
				retList.add(blIncItmVsTypeDTO);
			}
		}
		if (strArr != null) {
			// 10.保存发票数据集合
			iBlincoepCudService.save(saveDos.toArray(new BlincoepAggDO[saveDos.size()]));
		}*/
		
		// 2.遍历患者为打印结算并组装发票数据
		List<BlStOepDO> stList = new ArrayList<BlStOepDO>();
		List<String> stIdList = new ArrayList<String>();
		for (BlStOepDO blStOepDO : stDos) {
			if (blStOepDO.getEu_direct() == -1) {
				if (!bLCancelSettlementImplBp.getFPrintRedInc(blStOepDO.getId_ent()).booleanValue()) {
					continue; // 不打印红冲票
				}
			}
			
			stList.add(blStOepDO);
			stIdList.add(blStOepDO.getId_stoep());
		}
		
		if(stList.size() == 0)
			return new BlIncItmVsTypeDTO[0];
		
		BlincoepAggDO[] aggDos = null;
		if(strArr != null){
			
			BlIncPrintDTO printSet = new BlIncPrintDTO();
			printSet.setFgpay(FBoolean.FALSE);
			printSet.setSd_pttp(IBlDictCodeConst.SD_PTTP_WINDOW);
			
			FBoolean fgEcInc = BlParamsAnalysisUtil.BLINC0029(IBdPpCodeTypeConst.ID_OUTPATIENT_INVOICE);
			if(FBoolean.TRUE.equals(fgEcInc)){
				IBlIncCmdService incServcie = ServiceFinder.find(IBlIncCmdService.class);
				aggDos = incServcie.changeNotPirntIncToEcIncOp(stIdList.toArray(new String[0]));
			}else{
				//调用打印逻辑
				IBlIncOutCmdService incService = ServiceFinder.find(IBlIncOutCmdService.class);
				aggDos = incService.printOpInvoice(stIdList.toArray(new String[0]),printSet);
			}
		}else{
			IBlincoepRService iBlincoepRService = ServiceFinder.find(IBlincoepRService.class);
			aggDos = iBlincoepRService.findByAttrValStrings(BlIncOepDO.ID_STOEP, stIdList.toArray(new String[0]));
		}
		
		// 3.组织返回值
		for (BlStOepDO stDO : stList) {
			
			List<BlincoepAggDO> incList = new ArrayList<BlincoepAggDO>();
			for (BlincoepAggDO incAgg : aggDos) {
				if(stDO.getId_stoep().equals(incAgg.getParentDO().getId_stoep())){
					incList.add(incAgg);
				}
			}
			
			retList.addAll(Arrays.asList(this.assemblyIncInfoDtos(stDO,
					incList.toArray(new BlincoepAggDO[0]))));
		}
		
		// 11.返回对应发票数据
		return retList.toArray(new BlIncItmVsTypeDTO[retList.size()]);
	}

	/**
	 * 保存收付款信息
	 * 
	 * @param blpaypatoepAggDO
	 *            收付款信息
	 * @param fDateTime
	 *            服务器时间
	 * @return 保存后的收付款信息
	 * @throws BizException
	 */
	public BlpaypatoepAggDO[] saveBlpaypatoepAggDO(BlpaypatoepAggDO blpaypatoepAggDO, FDateTime fDateTime) throws BizException {
		BlPayPatOepDO blPayPatOepDO = blpaypatoepAggDO.getParentDO();
		blPayPatOepDO.setDt_pay(fDateTime);
		blPayPatOepDO.setStatus(DOStatus.NEW);
		blpaypatoepAggDO.setParentDO(blPayPatOepDO);
		Object obj222 = ServiceFinder.find(IBlpaypatoepCudService.class);
		BlpaypatoepAggDO[] blpaypatoepAggDOs = ((IBlpaypatoepCudService) obj222).save(new BlpaypatoepAggDO[] { blpaypatoepAggDO });
		if (null == blpaypatoepAggDOs) {
			throw new BizException("保存患者收付款信息失败");
		}
		return blpaypatoepAggDOs;
	}

	/**
	 * 保存退费重收后的记账明细
	 * 
	 * @param blcgoepAggDOs
	 *            退费重收后的记账明细
	 * @param fDateTime
	 *            服务器时间
	 * @param id_stoep
	 *            对应的结算id_stoep
	 * @return 保存后的退费重收后的记账明细
	 * @throws BizException
	 */
	public BlcgoepAggDO[] save_rechargeBlcgoepAggDO(BlcgoepAggDO[] blcgoepAggDOs, FDateTime fDateTime, String id_stoep) throws BizException {
		for (int i = 0; i < blcgoepAggDOs.length; i++) {
			BlCgOepDO blcgoepdo = blcgoepAggDOs[i].getParentDO();
			blcgoepdo.setDt_cg(fDateTime);
			blcgoepdo.setStatus(DOStatus.NEW);
			BlCgItmOepDO[] blCgItmOepDOs = blcgoepAggDOs[i].getBlCgItmOepDO();
			for (int j = 0; j < blCgItmOepDOs.length; j++) {
				blCgItmOepDOs[j].setId_org(blcgoepdo.getId_org());
				blCgItmOepDOs[j].setFg_st(FBoolean.TRUE);
				blCgItmOepDOs[j].setId_stoep(id_stoep);
				blCgItmOepDOs[j].setDt_st(fDateTime);
				blCgItmOepDOs[j].setFg_st(FBoolean.TRUE);// 置结算标志为真
				blCgItmOepDOs[j].setFg_susp(FBoolean.FALSE);// 置挂起标志为假
				blCgItmOepDOs[j].setStatus(DOStatus.NEW);
			}
		}
		IBlcgoepCudService iBlcgoepCudService = ServiceFinder.find(IBlcgoepCudService.class);
		iBlcgoepCudService = ServiceFinder.find(IBlcgoepCudService.class);
		BlcgoepAggDO[] blcgoepAggDOs1 = iBlcgoepCudService.save(blcgoepAggDOs);
		if (null == blcgoepAggDOs1) {
			throw new BizException("更新门诊记账信息失败");
		}
		return blcgoepAggDOs1;
	}

	/**
	 * 根据BlOrderAppendBillParamDTO等信息，生成记账表并保存记账表，且修改对应的ci_or_srv.sd_su_bl
	 * 
	 * @param appendBillParamDTOs
	 *            已计价后的待记账明细
	 * @param PrintInvocie
	 *            是否打印发票
	 * @param code_incpkg
	 *            票据包号
	 * @param fDateTime
	 *            服务器时间
	 * @return 记账表
	 * @throws BizException
	 */
	public BlcgoepAggDO[] creatBlCgAggDOByDTO(BlOrderAppendBillParamDTO[] appendBillParamDTOs, FBoolean PrintInvocie,FDateTime fDateTime) throws BizException {
		List<BlcgoepAggDO> blcgoepAggDOlist = new ArrayList<BlcgoepAggDO>();
		GetBlCgDO blCgIns = new GetBlCgDO();
		BlcgoepAggDO srvrtctlaggdos = new BlcgoepAggDO();

		BlCgOepDO blCgOepDO = null;
		BlCgItmOepDO[] blCgItmOepDO = new BlCgItmOepDO[appendBillParamDTOs.length];
		String[] orsrvids = new String[appendBillParamDTOs.length];
		// 挂起的数据
		List<BlCgItmOepDO> BlCgItmOepDOlist = new ArrayList<BlCgItmOepDO>();
		List<String> orsrvidslist = new ArrayList<String>();
		int j = 0, jj = 0;
		boolean blcgFlag = false;// 是否需要写入门诊记账表
		// 所有的记账信息
		// 1.组装AggDO
		Object cgoepRservice = ServiceFinder.find(IBlcgoepRService.class);
		String id_cgoep = "";
		Map<String, String> cg_susp_Map = new HashMap<String, String>(); // 挂起的记账信息
		String orsrvidss = "";
		for (BlOrderAppendBillParamDTO appendBillParamDTO : appendBillParamDTOs) {
			// 数据是否已经计入记账表中
			if (null == appendBillParamDTO.getFg_Cgoep() || appendBillParamDTO.getFg_Cgoep().equals(FBoolean.FALSE)) {
				blcgFlag = true;// 需要写入门诊记账表
				orsrvids[j] = appendBillParamDTO.getId_orsrv();
				if (appendBillParamDTO.getId_orsrv() != null) {
					orsrvidslist.add(appendBillParamDTO.getId_orsrv());
					orsrvidss = orsrvidss + "," + appendBillParamDTO.getId_orsrv();
				}
				if (null == blCgOepDO)// 门急诊主表，只需生成一次主表
				{
					blCgOepDO = blCgIns.GetBlCgOepDO(appendBillParamDTO, fDateTime.toString());
					blCgOepDO.setCode_cg(GetCodeCg());
					blCgOepDO.setStatus(DOStatus.NEW);
				}
				// 获得子表
				blCgItmOepDO[j] = new BlCgItmOepDO();
				blCgItmOepDO[j] = blCgIns.GetBlCgItmOepDO(appendBillParamDTO, fDateTime.toString(), FBoolean.TRUE);
				blCgItmOepDO[j].setStatus(DOStatus.NEW);
				BlCgItmOepDOlist.add(blCgItmOepDO[j]); // 待划价
				j++;
			} else // 已计价
			{
				id_cgoep = appendBillParamDTO.getOutpBillDTO().getId_cgoep();
				if (!StringUtil.isEmpty(id_cgoep) && !cg_susp_Map.containsKey(id_cgoep)) {
					cg_susp_Map.put(appendBillParamDTO.getOutpBillDTO().getId_cgoep(), "");
					// 提取agg;
					BlcgoepAggDO srvrtctlaggdo_susp = ((IBlcgoepRService) cgoepRservice).findById(id_cgoep);
					blcgoepAggDOlist.add(srvrtctlaggdo_susp); // 已划价且挂起的数据
				}
			}
		}
		//如果已计价，则直接返回  by lim 2019-11-26
		if(!ListUtil.isEmpty(blcgoepAggDOlist)){
			return blcgoepAggDOlist.toArray(new BlcgoepAggDO[0]);
		}
		if (blcgFlag == false && null == blCgOepDO) {
			throw new BizException("服务端没有生成门诊记账信息");
		}
		// 未划价的数据，一次划价生成 一条主记录，多条明细记录
		if (blCgOepDO != null) {
			srvrtctlaggdos.setParentDO(blCgOepDO);
		}
		if (BlCgItmOepDOlist.size() > 0) {
			srvrtctlaggdos.setBlCgItmOepDO(BlCgItmOepDOlist.toArray(new BlCgItmOepDO[] {}));
		}
		if (srvrtctlaggdos.getParentDO() != null) {
			blcgoepAggDOlist.add(srvrtctlaggdos); // 所有未结算AGG
		}

		BlCgOepDO tempcgoep = blcgoepAggDOlist.get(0).getParentDO();

		if (orsrvidss.length() > 1) {
			orsrvidss = orsrvidss.substring(1);
		}
		tempcgoep.setOrsrvids(orsrvidss);

		// tempcgoep.setSt_first_incno(blCgItmOepMapIns.getSt_first_incno());

		BlCgItmOepDO[] tempBlCgItmOepDO = blcgoepAggDOlist.get(0).getBlCgItmOepDO();
		blcgoepAggDOlist.remove(0);
		BlcgoepAggDO newBlcgoepAggDO = new BlcgoepAggDO();
		newBlcgoepAggDO.setParentDO(tempcgoep);
		newBlcgoepAggDO.setBlCgItmOepDO(tempBlCgItmOepDO);
		// 设置就诊与发票号，格式：//设置就诊与发票号
		blcgoepAggDOlist.add(newBlcgoepAggDO);// 已挂起AGG+新划价的且包含就诊发票号的AGG

		// 2.保存cgAgg，修改ci_or_srv.sd_su_bl
		String[] id_orsrvs = null;
		if (orsrvidss.length() > 1) {
			id_orsrvs = orsrvidss.split(",");
		}
		BlcgoepAggDO[] blcgoepAggDOs = saveCgOepAggDOAndUpdateCiOrder(blcgoepAggDOlist.toArray(new BlcgoepAggDO[] {}), id_orsrvs);

		// TODO review by yangyang 当前不用考虑分票功能，能否暂时去掉分票相关功能？
		// 3.这几个计算列需要传到前台去匹配，医保也需要上传发票号
		/*if (PrintInvocie.booleanValue()) {
		  
		 	//BY LY 没啥用 2018/03/28
			// 考虑到医保分解时，需要上传发票号和收费单据号，为保证医保上传与数据库发票数据中一致，需在此设置发票信息，故程序“不支持划价后再分票”模式
			// 生成发票信息
			GetBlCgItmOepMap blCgItmOepMapIns = new GetBlCgItmOepMap();
			// 一次遍历获得:就诊，发票号1|就诊，发票号2|...|
			// 就诊=id_pat+" "+id_org+" "+id_ent+" "+id_enttp
			BlCgItmOepMapDTO blCgItmOepMapDTO = blCgItmOepMapIns.BlCgItmOepConvertToMapIncPripats(appendBillParamDTOs, appendBillParamDTOs[0].getIncBillDTO().getId_emp_inc(), appendBillParamDTOs[0]
					.getIncBillDTO().getCode_incca(), PrintInvocie, code_incpkg);
			String ent_invoiceno = blCgItmOepMapDTO.getEntAndno();

			// 如果打发票，则ent_invoiceno为"就诊，发票号1|就诊，发票号2|...|",否则为""
			blcgoepAggDOs[0].getParentDO().setEnt_invoiceno(ent_invoiceno);
			blcgoepAggDOs[0].getParentDO().setEnt_invoice_pkgcode(blCgItmOepMapDTO.getEntAndno_pkgcode());
			blcgoepAggDOs[0].getParentDO().setSt_first_incno(blCgItmOepMapDTO.getSt_first_incno());
		}*/
		return blcgoepAggDOs;
	}

	/**
	 * 保存BlcgoepAggDO
	 * 
	 * @param blcgoepAggDOs1
	 *            待保存的记账明细DO
	 * @param id_orsrvs
	 *            修改对应的ci_or_srv.sd_su_bl未已记账信息
	 * @return 保存成功的BlcgoepAggDO
	 * @throws BizException
	 */
	private BlcgoepAggDO[] saveCgOepAggDOAndUpdateCiOrder(BlcgoepAggDO[] blcgoepAggDOs1, String[] id_orsrvs) throws BizException {
		IBlcgoepCudService iBlcgoepCudService = ServiceFinder.find(IBlcgoepCudService.class);
		BlcgoepAggDO[] blcgoepAggDOs = iBlcgoepCudService.save(blcgoepAggDOs1);
		if (null == blcgoepAggDOs) {
			throw new BizException("保存门诊记账信息失败");
		}
		// 字段补全操作，把参照的字段导入进来
		// review by yangyang 这段本来要用，但是数据模型已经搞得没法扩展了，太多的无用字段
		// for(BlcgoepAggDO cgItmAggdo:blcgoepAggDOs)
		// {
		// BlCgItmOepDO[] cgItmOeoDoLst=new
		// DORsReferMap<>(BlCgItmOepDO.class).convert(cgItmAggdo.getBlCgItmOepDO());
		// cgItmAggdo.setBlCgItmOepDO(cgItmOeoDoLst);
		// }

		// BlcgoepAggDO srvrtctlaggdo1=new BlcgoepAggDO();
		// BlCgOepDO blCgOepDO=blcgoepAggDOs[0].getParentDO();
		// blCgOepDO.setEnt_invoiceno(ent_invoiceno);//再次回写就诊，发票号1|就诊，发票号2|...|
		// BlCgItmOepDO[] blCgItmOepDO=blcgoepAggDOs[0].getBlCgItmOepDO();
		// srvrtctlaggdo1.setParentDO(blCgOepDO);
		// srvrtctlaggdo1.setBlCgItmOepDO(blCgItmOepDO);
		// srvrtctlaggdo[0].getParentDO().setEnt_invoiceno(ent_invoiceno);//再次回写就诊，发票号1|就诊，发票号2|...|
		// srvrtctlaggdo[0]=srvrtctlaggdo1;

		// 更新医嘱记账信息：新划价的信息对应医嘱 2017-3-1 此段代码放在收付款节点,2017-3-10又改回去了 2017-4-11又改了
		// TimeService timeService = new TimeServiceImpl();
		// FDateTime fDateTime = timeService.getUFDateTime();
		// if (null != id_orsrvs && id_orsrvs.length > 0) {
		// ICiOrdMaintainService iCiOrdMaintainService =
		// ServiceFinder.find(ICiOrdMaintainService.class);
		// FBoolean updateCiOrder =
		// iCiOrdMaintainService.UpdateOrdChargeRelInfo(id_orsrvs,
		// ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID,
		// ICiDictCodeConst.SD_SU_BL_ACCOUNT, fDateTime);
		// }
		return blcgoepAggDOs;
	}

	/**
	 * 计算每条费用明细（物品需计价，（非物品且price为空则计算，否则不计价）），
	 * 且返回所有未结账的BlcgoepAggDO，第一个BlCgOepDO中包含“就诊，发票|就诊，发票|……”
	 * 
	 * @param appendBillParamDTOs
	 * @param PrintOnlyOneInvoice
	 *            :FBoolean.True:多次就诊打印一张发票；FBoolean.False:多次就诊打印多张发票
	 * @param PrintInvocie
	 *            :是否需要生成发票数据，如果不生成发票，则不会打印发票
	 * @param code_incpkg
	 *            :如果要打发票，指发票对应的票据包编号
	 * @return
	 * @throws BizException
	 */
	private List<BlcgoepAggDO> GetBlcgoepAggDO_invoice_Pricing(BlOrderAppendBillParamDTO[] appendBillParamDTOs, FBoolean PrintInvocie, String code_incpkg) throws BizException {
		List<BlcgoepAggDO> blcgoepAggDOlist = new ArrayList<BlcgoepAggDO>();

		GetBlCgDO blCgIns = new GetBlCgDO();
		TimeService timeService = new TimeServiceImpl();
		String strDateTime = timeService.getUFDateTime().toStdString();
		BlcgoepAggDO srvrtctlaggdos = new BlcgoepAggDO();

		BlCgOepDO blCgOepDO = null;
		BlCgItmOepDO[] blCgItmOepDO = new BlCgItmOepDO[appendBillParamDTOs.length];
		String[] orsrvids = new String[appendBillParamDTOs.length];
		// 挂起的数据
		List<BlCgItmOepDO> BlCgItmOepDOlist = new ArrayList<BlCgItmOepDO>();
		List<String> orsrvidslist = new ArrayList<String>();
		int j = 0, jj = 0;
		boolean blcgFlag = false;// 是否需要写入门诊记账表
		// 所有的记账信息

		Object objq = ServiceFinder.find(IBlcgoepRService.class);
		String id_cgoep = "";
		Map<String, String> cg_susp_Map = new HashMap<String, String>(); // 挂起的记账信息
		String orsrvidss = "";
		long aa = System.currentTimeMillis();
		// 先判断是否有物品信息，如果有物品信息，可将一条转出多条
		SetBlOrderAppendBillParamDTOPricing GetMmToBlOrderAppendBillParamDTOIns = new SetBlOrderAppendBillParamDTOPricing();
		appendBillParamDTOs = GetMmToBlOrderAppendBillParamDTOIns.SetBlOrderAppendBillParamDTOPricing(appendBillParamDTOs);
		System.out.println("计价时间：" + (System.currentTimeMillis() - aa));
		for (BlOrderAppendBillParamDTO appendBillParamDTO : appendBillParamDTOs) {
			// 数据是否已经计入记账表中
			if (null == appendBillParamDTO.getFg_Cgoep() || appendBillParamDTO.getFg_Cgoep() == FBoolean.FALSE) {
				blcgFlag = true;// 需要写入门诊记账表
				orsrvids[j] = appendBillParamDTO.getId_orsrv();
				if (appendBillParamDTO.getId_orsrv() != null) {
					orsrvidslist.add(appendBillParamDTO.getId_orsrv());
					orsrvidss = orsrvidss + "," + appendBillParamDTO.getId_orsrv();
				}
				if (null == blCgOepDO)// 门急诊主表，只需生成一次主表
				{
					blCgOepDO = blCgIns.GetBlCgOepDO(appendBillParamDTO, strDateTime);
					blCgOepDO.setCode_cg(GetCodeCg());
					blCgOepDO.setStatus(DOStatus.NEW);
				}
				// 获得子表
				blCgItmOepDO[j] = new BlCgItmOepDO();
				blCgItmOepDO[j] = blCgIns.GetBlCgItmOepDO(appendBillParamDTO, strDateTime, FBoolean.TRUE);
				blCgItmOepDO[j].setStatus(DOStatus.NEW);
				BlCgItmOepDOlist.add(blCgItmOepDO[j]); // 待划价
				j++;
			} else // 已计价
			{
				id_cgoep = appendBillParamDTO.getOutpBillDTO().getId_cgoep();
				if (!cg_susp_Map.containsKey(id_cgoep)) {
					cg_susp_Map.put(appendBillParamDTO.getOutpBillDTO().getId_cgoep(), "");
					// 提取agg;
					BlcgoepAggDO srvrtctlaggdo_susp = ((IBlcgoepRService) objq).findById(id_cgoep);
					blcgoepAggDOlist.add(srvrtctlaggdo_susp); // 已划价且挂起的数据
				}
			}

		}
		//如果已计价，则直接返回  by lim 2019-11-26
		if(!ListUtil.isEmpty(blcgoepAggDOlist)){
			return blcgoepAggDOlist;
		}
		if (blcgFlag == false && null == blCgOepDO) {
			throw new BizException("服务端没有生成门诊记账信息");
		}
		// 未划价的数据，一次划价生成 一条主记录，多条明细记录
		if (blCgOepDO != null) {
			srvrtctlaggdos.setParentDO(blCgOepDO);
		}
		if (BlCgItmOepDOlist.size() > 0) {
			srvrtctlaggdos.setBlCgItmOepDO(BlCgItmOepDOlist.toArray(new BlCgItmOepDO[] {}));
		}
		if (srvrtctlaggdos.getParentDO() != null) {
			blcgoepAggDOlist.add(srvrtctlaggdos); // 所有未结算AGG
		}
		BlCgOepDO tempcgoep = blcgoepAggDOlist.get(0).getParentDO();
		if (PrintInvocie.booleanValue()) {
			// 考虑到医保分解时，需要上传发票号和收费单据号，为保证医保上传与数据库发票数据中一致，需在此设置发票信息，故程序“不支持划价后再分票”模式
			// 生成发票信息
			GetBlCgItmOepMap blCgItmOepMapIns = new GetBlCgItmOepMap();
			// 一次遍历获得:就诊，发票号1|就诊，发票号2|...|
			// 就诊=id_pat+" "+id_org+" "+id_ent+" "+id_enttp
			BlCgItmOepMapDTO blCgItmOepMapDTO = blCgItmOepMapIns.BlCgItmOepConvertToMapIncPripats(appendBillParamDTOs, appendBillParamDTOs[0].getIncBillDTO().getId_emp_inc(), appendBillParamDTOs[0]
					.getIncBillDTO().getCode_incca(), PrintInvocie, code_incpkg);
			String ent_invoiceno = blCgItmOepMapDTO.getEntAndno();

			// 如果打发票，则ent_invoiceno为"就诊，发票号1|就诊，发票号2|...|",否则为""
			tempcgoep.setEnt_invoiceno(ent_invoiceno);
			tempcgoep.setEnt_invoice_pkgcode(blCgItmOepMapDTO.getEntAndno_pkgcode());
			tempcgoep.setSt_first_incno(blCgItmOepMapDTO.getSt_first_incno());
		}
		if (orsrvidss.length() > 1) {
			orsrvidss = orsrvidss.substring(1);
		}
		tempcgoep.setOrsrvids(orsrvidss);

		// tempcgoep.setSt_first_incno(blCgItmOepMapIns.getSt_first_incno());

		BlCgItmOepDO[] tempBlCgItmOepDO = blcgoepAggDOlist.get(0).getBlCgItmOepDO();
		blcgoepAggDOlist.remove(0);
		BlcgoepAggDO newBlcgoepAggDO = new BlcgoepAggDO();
		newBlcgoepAggDO.setParentDO(tempcgoep);
		newBlcgoepAggDO.setBlCgItmOepDO(tempBlCgItmOepDO);
		// 设置就诊与发票号，格式：//设置就诊与发票号
		blcgoepAggDOlist.add(newBlcgoepAggDO);// 已挂起AGG+新划价的且包含就诊发票号的AGG

		return blcgoepAggDOlist;
	}

	/**
	 * 保存门诊记账信息Agg,更新医嘱记账信息 支持挂起的数据和非挂起的数据一起保存
	 * 
	 * @param blcgoepAggDOlist
	 *            待保存的blcgoepAggDO
	 * @return
	 * @throws BizException
	 */
	public BlcgoepAggDO[] SaveBlcgoepAggDOUpdateCiOrder(List<BlcgoepAggDO> blcgoepAggDOlist) throws BizException {

		// 待保存的BlcgoepAggDO
		BlcgoepAggDO[] blcgoepAggDO_arr = blcgoepAggDOlist.toArray(new BlcgoepAggDO[] {});
		// 未保存的BlcgoepAggDO
		List<BlcgoepAggDO> blcgoepAggDO_list = new ArrayList<BlcgoepAggDO>();
		// 已保存的BlcgoepAggDO（挂起）
		List<BlcgoepAggDO> blcgoepAggDO_list_2 = new ArrayList<BlcgoepAggDO>();
		// 既包含未保存的又包含已保存的BlcgoepAggDO
		List<BlcgoepAggDO> blcgoepAggDO_list_3 = new ArrayList<BlcgoepAggDO>();

		// 保存
		for (int i = 0; i < blcgoepAggDO_arr.length; i++) {
			if (blcgoepAggDO_arr[i].getParentDO().getId_cgoep() == null || blcgoepAggDO_arr[i].getParentDO().getId_cgoep().trim().equals("")) {
				blcgoepAggDO_list.add(blcgoepAggDO_arr[i]);
			} else {
				blcgoepAggDO_list_2.add(blcgoepAggDO_arr[i]);
			}
		}
		Object obj3 = ServiceFinder.find(IBlcgoepCudService.class);
		BlcgoepAggDO[] srvrtctlaggdo = null;
		if (blcgoepAggDO_list.size() == blcgoepAggDOlist.size()) // 都是未保存的BlcgoepAggDO
		{

			srvrtctlaggdo = ((IBlcgoepCudService) obj3).save(blcgoepAggDO_list.toArray(new BlcgoepAggDO[] {}));
			if (null == srvrtctlaggdo) {
				throw new BizException("保存门诊记账信息失败");
			}
		} else if (blcgoepAggDO_list_2.size() == blcgoepAggDOlist.size()) // 已挂起的BlcgoepAggDO
		{
			srvrtctlaggdo = blcgoepAggDOlist.toArray(new BlcgoepAggDO[] {});
		} else// 既包含未保存的又包含已保存的BlcgoepAggDO
		{
			for (int i = 0; i < blcgoepAggDO_arr.length; i++) {

				if (blcgoepAggDO_arr[i].getParentDO().getId_cgoep() == null || blcgoepAggDO_arr[i].getParentDO().getId_cgoep().trim().equals("")) {
					// 单独处理未保存的BlcgoepAggDO:先保存再添加
					blcgoepAggDO_list_3.add(((IBlcgoepCudService) obj3).save(new BlcgoepAggDO[] { blcgoepAggDO_arr[i] })[0]);
				} else {
					// 直接添加
					blcgoepAggDO_list_3.add(blcgoepAggDO_arr[i]);
				}
			}
			srvrtctlaggdo = blcgoepAggDO_list_3.toArray(new BlcgoepAggDO[] {});
		}

		srvrtctlaggdo[0].getParentDO().setHas_saveindb(FBoolean.TRUE);

		// 更新医嘱记账信息：新划价的信息对应医嘱
		TimeService timeService = new TimeServiceImpl();
		FDateTime fDateTime = timeService.getUFDateTime();
		if (null != srvrtctlaggdo[0].getParentDO().getOrsrvids() && srvrtctlaggdo[0].getParentDO().getOrsrvids().length() > 0)// 在补费接口，就需要更新医嘱记账信息
		{
			Object obj2 = ServiceFinder.find(ICiOrdMaintainService.class);
			// FBoolean
			// updateCiOrder=((ICiOrdMaintainService)obj2).UpdateOrdChargeRelInfo(
			// orsrvidslist.toArray(new String[]{}),
			// ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID,ICiDictCodeConst.SD_SU_BL_ACCOUNT);
			if ((srvrtctlaggdo[0].getBlCgItmOepDO() != null && srvrtctlaggdo[0].getBlCgItmOepDO().length > 0 && (!srvrtctlaggdo[0].getBlCgItmOepDO()[0].getFg_acc().booleanValue() && !srvrtctlaggdo[0]
					.getBlCgItmOepDO()[0].getFg_hpcg().booleanValue()))) {
				FBoolean updateCiOrder = ((ICiOrdMaintainService) obj2).UpdateOrdChargeRelInfo2(srvrtctlaggdo[0].getParentDO().getOrsrvids().split(","), ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID,
						ICiDictCodeConst.SD_SU_BL_ACCOUNT, fDateTime, FeeReverseType.NOBLCANCEL);
				if (!updateCiOrder.booleanValue()) {
					throw new BizException("更新医嘱状态失败,本次操作不成功！");
				}
			}
		}
		return srvrtctlaggdo;
	}

	/**
	 * 计价：由补退费DTO转换成门诊记账AggDO
	 * 
	 * @param appendBillParamDTOs
	 *            待计价的DTO
	 * @param blincoepAggDO
	 *            发票主体DO
	 * @param PrintOnlyOneInvoice
	 *            多次就诊是否打印一张发票
	 * @param PrintInvocie
	 *            是否打印发票
	 * @return
	 * @throws BizException
	 */
	public BlcgoepAggDO[] getBlcgoepAggDOFromAppendBillParamDTOArr(BlOrderAppendBillParamDTO[] appendBillParamDTOs, BlincoepAggDO blincoepAggDO, FBoolean PrintInvocie) throws BizException {
		String code_incpkg = "";
		if (PrintInvocie.booleanValue()) // 需要打发票
		{
			if (blincoepAggDO == null) {
				throw new BizException("没有门诊票据信息");
			}
			code_incpkg = blincoepAggDO.getParentDO().getCode_incpkg();
		}

		List<BlcgoepAggDO> blcgoepAggDOlist = new ArrayList<BlcgoepAggDO>();
		blcgoepAggDOlist = GetBlcgoepAggDO_invoice_Pricing(appendBillParamDTOs, PrintInvocie, code_incpkg);

		// 保存AGG，更新医嘱记账信息
		BlcgoepAggDO[] blcgoepAggDOs = SaveBlcgoepAggDOUpdateCiOrder(blcgoepAggDOlist);
		return blcgoepAggDOs;
	}

	public BlCgOepAggDTO createBlCgOepAggDTO(BlcgoepAggDO[] blcgoepAggDOArr, EntHpDO[] EntHpDOArr) {
		BlCgOepAggDTO blCgOepAggDTO = new BlCgOepAggDTO();
		FArrayList blcgoepAggDOList = new FArrayList();
		FArrayList entHpDOList = new FArrayList();
		if (blcgoepAggDOArr != null) {
			for (BlcgoepAggDO blcgoepAggDO1 : blcgoepAggDOArr) {
				blcgoepAggDOList.add(blcgoepAggDO1);
			}
		}
		if (EntHpDOArr != null) {
			for (EntHpDO entHpDO : EntHpDOArr) {
				entHpDOList.add(entHpDO);
			}
		}

		blCgOepAggDTO.setBlcgoepAggDO(blcgoepAggDOList);
		blCgOepAggDTO.setEntHpDO(entHpDOList);
		return blCgOepAggDTO;
	}

	/**
	 * 根据 id_ent,返回该就诊对应项的就诊医保计划
	 * 
	 * @param id_entList
	 * @return
	 * @throws BizException
	 */
	private EntHpDO[] QueryEntHpById_ent(List<String> id_entList) throws BizException {
		// 查询就诊下的医保计划
		// IEnthpRService
		// iEnthpRService=ServiceFinder.find(IEnthpRService.class);
		// entHpDOArr = iEnthpRService.findByIds(id_entList.toArray(new
		// String[0]),FBoolean.FALSE);
		EntHpDO[] entHpDOArr = null;
		String cond = "";
		String strWhere = "";
		if (id_entList == null) {
			return null;
		}
		for (int i = 0; i < id_entList.size(); i++) {
			if (i != id_entList.size() - 1)
				strWhere = strWhere + "'" + id_entList.get(i) + "',";
			else
				strWhere = strWhere + "'" + id_entList.get(i) + "'";
		}

		cond = " id_ent in (" + strWhere + ")";
		// entHpDOArr = iEnthpRService.find(cond, "", FBoolean.TRUE);

		DAFacade dAFacade = new DAFacade();
		List<EntHpDO> entHpDOList = (List<EntHpDO>) dAFacade.findByCond(EntHpDO.class, cond, "1");

		// ????
		if (entHpDOList != null) {
			if (entHpDOList.size() > 0) {
				if (entHpDOList.size() < id_entList.toArray().length) {
					throw new BizException("请先结算自费费用");
				}
				entHpDOArr = entHpDOList.toArray(new EntHpDO[] {});
			}
		}
		return entHpDOArr;
	}

	private EntHpDO[] QueryEntHpDOArrToCgAgg(BlOrderAppendBillParamDTO[] blOrderAppendBillParamDTOArr) throws BizException {
		EntHpDO[] entHpDOArr = null;
		List<String> id_entList = new ArrayList<String>();
		// 获得就诊
		for (BlOrderAppendBillParamDTO blOrderAppendBillParamDTO : blOrderAppendBillParamDTOArr) {
			if (id_entList.size() == 0) {
				id_entList.add(blOrderAppendBillParamDTO.getId_ent());
			} else {
				if (!id_entList.contains(blOrderAppendBillParamDTO.getId_ent())) {
					id_entList.add(blOrderAppendBillParamDTO.getId_ent());
				}
			}
		}
		return QueryEntHpById_ent(id_entList);

	}

	/**
	 * 用结算信息（id_stoep,code_st) 回写记账信息
	 * 
	 * @param blcgoepAggDOs
	 *            记账信息
	 * @param blStOepDO
	 *            结算信息
	 * @param fDateTime
	 *            服务器时间
	 * @return 返回记账表
	 * @throws BizException
	 */
	public BlcgoepAggDO[] writebackCgBySt(BlcgoepAggDO[] blcgoepAggDOs, BlStOepDO blStOepDO, FDateTime fDateTime) throws BizException {
		BlCgItmOepDO[] blCgItmOepDOs;
		for (int t = 0; t < blcgoepAggDOs.length; t++) {
			BlCgOepDO blcgoepdo = blcgoepAggDOs[t].getParentDO();
			// 2017年6月9日在获取数据时不进行记账时间修改
			// blcgoepdo.setDt_cg(fDateTime);
			blcgoepdo.setStatus(DOStatus.UPDATED);
			blCgItmOepDOs = blcgoepAggDOs[t].getBlCgItmOepDO();
			for (int k = 0; k < blCgItmOepDOs.length; k++)// 门诊记账明细表
			{
				if (blCgItmOepDOs[k].getFg_refund() != null && blCgItmOepDOs[k].getFg_refund().booleanValue())
					continue;
				blCgItmOepDOs[k].setId_org(blcgoepdo.getId_org());
				blCgItmOepDOs[k].setFg_st(FBoolean.TRUE);
				blCgItmOepDOs[k].setId_stoep(blStOepDO.getId_stoep());
				blCgItmOepDOs[k].setCode_st(blStOepDO.getCode_st());
				blCgItmOepDOs[k].setDt_st(fDateTime);
				blCgItmOepDOs[k].setFg_susp(FBoolean.TRUE);// 置挂起标志为真
				blCgItmOepDOs[k].setStatus(DOStatus.UPDATED);
			}

		}
		IBlcgoepCudService iBlcgoepCudService = ServiceFinder.find(IBlcgoepCudService.class);
		BlcgoepAggDO[] blcgoepAggDO1 = iBlcgoepCudService.save(blcgoepAggDOs);
		if (null == blcgoepAggDO1) {
			throw new BizException("更新门诊记账信息失败");
		}
		return blcgoepAggDO1;
	}

	/**
	 * 用bl_cg_itm_oep,bl_st_oep的金额回写bl_inc_oep表，且生成bl_st_inc_oep,
	 * bl_inc_cg_itm_oep表
	 * 
	 * @param blcgoepAggDOs
	 *            费用明细
	 * @param blincoepAggDO
	 *            发票表初始数据（只有主DO)
	 * @param blStOepDO
	 *            结算信息
	 * @param allBlCgItmOepDOs
	 *            所有费用明细
	 * @param id_emp_inc
	 *            操作员ID
	 * @param code_incca
	 *            就诊类型代码
	 * @param PrintInvocie
	 *            收费打印发票
	 * @param fDateTime
	 *            服务器时间
	 * @return 完整的BlincoepAggDO
	 * @throws BizException
	 */
	private BlincoepAggDO[] writeBackIncBySTAndCgItms(BlcgoepAggDO[] blcgoepAggDOs, BlincoepAggDO blincoepAggDO, BlStOepDO blStOepDO, BlCgItmOepDO[] allBlCgItmOepDOs, FDateTime fDateTime,
			BlCgItmOepMapDTO blCgItmOepMapDTO) throws BizException {
		GetBlCgItmOepMap blCgItmOepMapIns = new GetBlCgItmOepMap();
		Map<String, String> blCgItmOepMapEnt = blCgItmOepMapDTO.getBlCgItmOepMapEnt();// Map<就诊,结账序号>
		Map<String, FDouble> blCgItmOepAmtStdMap = blCgItmOepMapDTO.getBlCgItmOepAmtStdMap();// Map<就诊,标准金额>
		Map<String, FDouble> blCgItmOepAmtMap = blCgItmOepMapDTO.getBlCgItmOepAmtMap();// Map<就诊,应交金额>
		Map<String, FDouble> blCgItmOepAmtPatMap = blCgItmOepMapDTO.getBlCgItmOepAmtPatMap();// Map<就诊,医保自付金额>
		Map<String, FDouble> blCgItmOepAmtRatioMap = blCgItmOepMapDTO.getBlCgItmOepAmtRatioMap();// Map<就诊,金额_价格比例>
		// 回写结算与发票关系，发票费用明细，组成BL_ST_INC_OEPDO,BL_INC_CG_ITM_OEP
		// 票据接口
		GetBlPsnDocName name_ins = new GetBlPsnDocName();
		String Incno = "", ent_emp_name = "";
		String tempKey = "", key = "";
		List<BlincoepAggDO> blincoepAggDOList = new ArrayList<BlincoepAggDO>();
		int index = 0;
		// for(BlincoepAggDO blincoepAggDO1:blincoepAggDOs) //产生了几张发票
		// {
		// 每个发票对应的结算与发票关系_门急体
		List<BlStIncOepDO> blStIncOepDOs = new ArrayList<BlStIncOepDO>();
		List<BlIncCgItmOep> blIncCgItmOeps = new ArrayList<BlIncCgItmOep>();
		// 1.回写发票金额
		BlincoepAggDO[] newBlincoepAggDO1 = new BlincoepAggDO[1];
		BlIncOepDO blIncOepDO = blincoepAggDO.getParentDO();
		// if(PrintOnlyOneInvoice.equals(FBoolean.TRUE))//2017-1-11需求更改：多次就诊一次结算，只生成一条bl_st_oep和bl_inc_oep记录
		// {
		tempKey = blIncOepDO.getId_pat();
		// }
		// else
		// {
		// tempKey=blIncOepDO.getId_pat()+" "+blIncOepDO.getId_ent()+" "+blIncOepDO.getId_enttp();
		// blIncOepDO.setId_ent("");//多次就诊，一次结算 就不用ID_ENT了
		// }
		// if(PrintInvocie.booleanValue())
		// {
		// //开票人姓名与发票关联
		// ent_emp_name=ent_emp_name+tempKey+","+name_ins.GetBlPsnDocName(blIncOepDO.getId_emp_inc())+"|";
		// }
		blIncOepDO.setId_stoep(blStOepDO.getId_stoep());
		blIncOepDO.setAmt_std(blCgItmOepAmtStdMap.get(tempKey));
		blIncOepDO.setAmt(blCgItmOepAmtMap.get(tempKey));
		blIncOepDO.setAmt_pat(blCgItmOepAmtPatMap.get(tempKey));
		blIncOepDO.setAmt_ratio(blCgItmOepAmtRatioMap.get(tempKey));// 金额——价格比例
		blIncOepDO.setDt_inc(fDateTime);
		blIncOepDO.setFg_print(FBoolean.FALSE);
		blIncOepDO.setStatus(DOStatus.UPDATED);
		newBlincoepAggDO1[0] = new BlincoepAggDO();
		newBlincoepAggDO1[0].setParentDO(blIncOepDO);
		// 5.2 Bl_St_Inc_Oep门急诊结算与发票关系
		// for(int ii=0;ii<blStOepDOs.length;ii++)
		// {
		// id_org,id_pat,id_ent,id_enttp
		// if(!PrintOnlyOneInvoice.booleanValue())//2017-1-11需求更改：多次就诊一次结算，只生成一条bl_st_oep和bl_inc_oep记录
		// {
		// key=blStOepDOs[ii].getId_pat()+" "+blStOepDOs[ii].getId_ent()+" "+blStOepDOs[ii].getId_enttp();
		// }
		// else
		// {
		// key=blStOepDO.getId_pat();
		// // }
		// if(tempKey.equals(key))
		// {
		// 2.根据bl_st_oep和bl_inc_oep生成BlStIncOepDO
		BlStIncOepDO blStIncOepDO = new BlStIncOepDO();
		blStIncOepDO.setId_stoep(blStOepDO.getId_stoep());
		blStIncOepDO.setId_incoep(blIncOepDO.getId_incoep());
		blStIncOepDO.setFg_active(FBoolean.TRUE);
		blStIncOepDO.setStatus(DOStatus.NEW);
		blStIncOepDOs.add(blStIncOepDO);
		// }
		// }
		// 3 根据bl_cg_itm_oep和bl_st_oep生成Bl_Inc_Cg_Itm门诊发票费用明细
		for (int j = 0; j < allBlCgItmOepDOs.length; j++) {
			// if(!PrintOnlyOneInvoice.booleanValue())
			// {
			// key=AllBlCgItmOepDOs[j].getId_pat()+" "+AllBlCgItmOepDOs[j].getId_ent()+" "+AllBlCgItmOepDOs[j].getId_enttp();
			// }
			// else
			// {
			// 2017-1-11需求更改：多次就诊一次结算，只生成一条bl_st_oep和bl_inc_oep记录
			// key=allBlCgItmOepDOs[j].getId_pat();
			// }
			// if(tempKey.equals(key))
			// {
			BlIncCgItmOep blIncCgItmOep = new BlIncCgItmOep();
			blIncCgItmOep.setId_cgitmoep(allBlCgItmOepDOs[j].getId_cgitmoep());
			blIncCgItmOep.setId_incoep(blIncOepDO.getId_incoep());
			blIncCgItmOep.setStatus(DOStatus.NEW);
			blIncCgItmOeps.add(blIncCgItmOep);
			// }
		}

		newBlincoepAggDO1[0].setBlStIncOepDO(blStIncOepDOs.toArray(new BlStIncOepDO[] {}));
		newBlincoepAggDO1[0].setBlIncCgItmOep(blIncCgItmOeps.toArray(new BlIncCgItmOep[] {}));
		blincoepAggDOList.add(newBlincoepAggDO1[0]);
		index++;
		// }
		// 4保存BlincoepAggDO（bl_inc_oep,BL_ST_INC_OEPDO,BL_INC_CG_ITM_OEP)
		IBlincoepCudService iBlincoepCudService3 = ServiceFinder.find(IBlincoepCudService.class);
		BlincoepAggDO[] blincoepAggDOs1 = iBlincoepCudService3.save(blincoepAggDOList.toArray(new BlincoepAggDO[0]));
		if (null == blincoepAggDOs1) {
			throw new BizException("保存门诊结算发票信息失败");
		}
		return blincoepAggDOs1;
	}

	/**
	 * 划价的业务逻辑
	 * 
	 * @param blStOepDO
	 *            结算表
	 * @param blincoepAggDO
	 *            发票表
	 * @param blcgoepAggDOs
	 *            记账表
	 * @param PrintOnlyOneInvoice
	 *            多次就诊是否打印一张发票
	 * @param PrintInvocie
	 *            是否打印发票，门诊后付费就不打印发票
	 * @return
	 * @throws BizException
	 */
	public BlcgoepAggDO[] pricing_bp(BlStOepDO blStOepDO, BlincoepAggDO blincoepAggDO, BlcgoepAggDO[] blcgoepAggDOs, FBoolean PrintInvocie) throws BizException {
		// 获取记账中具体项目和主键的MAP
		Map<String, FDouble> blCgItmOepAmtStdMap = new HashMap<String, FDouble>();
		Map<String, FDouble> blCgItmOepAmtMap = new HashMap<String, FDouble>();
		Map<String, FDouble> blCgItmOepAmtPatMap = new HashMap<String, FDouble>();
		Map<String, FDouble> blCgItmOepAmtRatioMap = new HashMap<String, FDouble>();
		GetBlCgItmOepMap blCgItmOepMapIns = new GetBlCgItmOepMap();
		BlCgItmOepMapDTO blCgItmOepMapDTO = blCgItmOepMapIns.BlCgItmOepConvertToMaps(blcgoepAggDOs, blincoepAggDO.getParentDO().getId_emp_inc(), IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE,
				PrintInvocie);
		Map<String, String> blStOepMapEnt = new HashMap<String, String>();
		Map<String, String> codestMapEnt = new HashMap<String, String>();// Map<key,code_st>

		Map<String, String> blCgItmOepMapCodeSt = new HashMap<String, String>();

		String tempKey = "", key = "";

		TimeService timeService = new TimeServiceImpl();
		FDateTime strDateTime = timeService.getUFDateTime();
		PriceSettleBP priceBp = new PriceSettleBP();

		// 1.入口验证
		priceBp.validate_pricing(blStOepDO, blincoepAggDO, blcgoepAggDOs, PrintInvocie);

		// 2.保存记账表
		if (!blcgoepAggDOs[0].getParentDO().getHas_saveindb().booleanValue()) {
			// 需要保存blcgoepAggDO，且修改对应的医嘱记账状态
			blcgoepAggDOs = SaveBlcgoepAggDOVSUpdateCiOrder(blcgoepAggDOs);
		}
		// 设置 "就诊,发票号|……"
		blcgoepAggDOs[0].getParentDO().setEnt_invoiceno(blCgItmOepMapDTO.getEntAndno());

		// 3.保存门诊结算信息：blStOepDO
		// 生成结算号
		if (blStOepDO.getCode_st() == null) {
			String stCode = BlCodeUtils.generateOepStCode();
			blStOepDO.setCode_st(stCode);
		}
		tempKey = blStOepDO.getId_pat();
		if (!blCgItmOepMapCodeSt.containsKey(tempKey)) {
			blCgItmOepMapCodeSt.put(tempKey, blStOepDO.getCode_st());
		}
		blStOepDO.setAmt_std(blCgItmOepAmtStdMap.get(tempKey));// 结算标准总金额
		blStOepDO.setAmt_pat(blCgItmOepAmtPatMap.get(tempKey));// 医保自付金额
		blStOepDO.setAmt_ratio(blCgItmOepAmtRatioMap.get(tempKey));// 金额_价格比例
		blStOepDO.setAmt(blCgItmOepAmtMap.get(tempKey));// 应交金额
		blStOepDO.setDt_st(strDateTime);
		blStOepDO.setFg_cc(FBoolean.FALSE);// 设置结账标志为FALSE
		blStOepDO.setId_paypatoep("");
		blStOepDO.setStatus(DOStatus.NEW);

		Object obj1 = ServiceFinder.find(IBlstoepCudService.class);
		BlStOepDO[] blStOepDOs = ((IBlstoepCudService) obj1).save(new BlStOepDO[] { blStOepDO });
		if (null == blStOepDOs) {
			throw new BizException("保存门诊结算信息失败");
		}

		blStOepMapEnt.put(blStOepDO.getId_pat(), blStOepDOs[0].getId_stoep());
		// 存储结算流水号Code_st
		codestMapEnt.put(blStOepDO.getId_pat(), blStOepDOs[0].getCode_st());

		// 4.结算回写记账表
		BlcgoepAggDO[] blcgoepAggDO1 = writebackCgBySt(blcgoepAggDOs, blStOepDOs[0], strDateTime);
		// 5.得到记账的所有明细
		List<BlCgItmOepDO> BlCgItmOepDOlist = new ArrayList<BlCgItmOepDO>();
		for (int i = 0; i < blcgoepAggDO1.length; i++) {
			BlCgItmOepDO[] BlCgItmOepDOs = blcgoepAggDO1[i].getBlCgItmOepDO();
			for (int j = 0; j < BlCgItmOepDOs.length; j++) {
				BlCgItmOepDOlist.add(BlCgItmOepDOs[j]);
			}
		}
		BlCgItmOepDO[] allBlCgItmOepDOs = BlCgItmOepDOlist.toArray(new BlCgItmOepDO[] {});

		// 6.保存发票信息：blincoepAggDO,只保存了AGG的主表
		GetBlCgItmOepMap blCgItmOepMapIns1 = new GetBlCgItmOepMap();
		BlCgItmOepMapDTO blCgItmOepMapDTO1 = blCgItmOepMapIns1.blStOepConvertToMaps(blStOepDOs[0]);
		blStOepMapEnt = blCgItmOepMapDTO1.getBlStOepMapEnt();
		Object obj2 = ServiceFinder.find(IBlincoepCudService.class);
		BlincoepAggDO[] blincoepAggDOs = ((IBlincoepCudService) obj2).save(new BlincoepAggDO[] { blincoepAggDO });
		if (null == blincoepAggDOs) {
			throw new BizException("保存门诊结算发票信息失败");
		}
		// 6.用bl_cg_itm_oep,bl_st_oep的金额回写bl_inc_oep表，且生成bl_st_inc_oep,bl_inc_cg_itm_oep表_
		BlincoepAggDO[] blincoepAggDOs1 = writeBackIncBySTAndCgItms(blcgoepAggDO1, blincoepAggDOs[0], blStOepDO, allBlCgItmOepDOs, strDateTime, blCgItmOepMapDTO);

		// 7.如果打印票据，则生成需要打印的票据DTO
		if (PrintInvocie.booleanValue()) // 如果打印票据，则需要这些内容
		{
			String steop_vs_invoiceno = "";
			String steop_vs_invoicename = "";
			GetBlPsnDocName name_ins = new GetBlPsnDocName();
			steop_vs_invoiceno = steop_vs_invoiceno + "|" + blincoepAggDOs1[0].getParentDO().getId_stoep() + "," + blincoepAggDOs1[0].getParentDO().getIncno();
			steop_vs_invoicename = steop_vs_invoicename + "|" + blincoepAggDOs1[0].getParentDO().getId_stoep() + "," + name_ins.GetBlPsnDocName(blincoepAggDOs1[0].getParentDO().getId_emp_inc());
			steop_vs_invoiceno = steop_vs_invoiceno.substring(1);
			steop_vs_invoicename = steop_vs_invoicename.substring(1);
			// 就诊，发票开立人1|就诊，发票开立人2|……|就诊，发票开立人n
			// 开票人姓名与发票关联
			String ent_emp_name = blincoepAggDOs1[0].getParentDO().getId_pat() + "," + name_ins.GetBlPsnDocName(blincoepAggDOs1[0].getParentDO().getId_emp_inc()) + "|";
			blcgoepAggDO1[0].getParentDO().setEnt_invoice_empname(ent_emp_name);
			// 结算号,发票号1|结算号，发票号2|……|结算号，发票号n
			blcgoepAggDO1[0].getParentDO().setStoep_invoiceno(steop_vs_invoiceno);
			// 结算号,发票号开立人1|结算号，发票号开立人2|……|结算号，发票号开立人n
			blcgoepAggDO1[0].getParentDO().setStoep_invoicename(steop_vs_invoicename);
		}

		// 8.返回划价后的记账表
		return blcgoepAggDO1;
	}

	/**
	 * 门诊新收款：从DTO中获得：就诊，发票号1|就诊，发票号2
	 * 
	 * @param appendBillParamDTOs
	 * @param Id_emp_inc
	 *            开票人ID
	 * @param code_incca
	 *            票据种类代码
	 * @param PrintOnlyOneInvoice
	 *            多次就诊打印一张发票还是多次就诊打印多张发票，若是多次就诊打印多张发票，则 一次遍历获得:
	 *            就诊，发票号1|就诊，发票号2|...| 否则： 病人ID，发票号|
	 * @return
	 * @throws BizException
	 */

	public String GetEntInvoicenoFromDTO(BlOrderAppendBillParamDTO[] appendBillParamDTOs, String Id_emp_inc, String code_incca, FBoolean PrintOnlyOneInvoice, String code_incpkg) throws BizException {
		GetBlCgItmOepMap ins = new GetBlCgItmOepMap();
		String ent_invoiceno = ins.GetEntInvoicenoFromDTO(appendBillParamDTOs, Id_emp_inc, code_incca, code_incpkg);
		return ent_invoiceno;
	}

	/**
	 * 仅保存门诊记账信息Agg,更新医嘱记账信息
	 * 
	 * @param blcgoepAggDOlist
	 * @return
	 * @throws BizException
	 */
	private BlcgoepAggDO[] SaveBlcgoepAggDOVSUpdateCiOrder(BlcgoepAggDO[] blcgoepAggDOs) throws BizException {
		IBlcgoepCudService iBlcgoepCudService = ServiceFinder.find(IBlcgoepCudService.class);
		BlcgoepAggDO[] srvrtctlaggdo = iBlcgoepCudService.save(blcgoepAggDOs);
		if (null == srvrtctlaggdo) {
			throw new BizException("保存门诊记账信息失败");
		}

		BlcgoepAggDO srvrtctlaggdo1 = new BlcgoepAggDO();
		BlCgOepDO blCgOepDO = srvrtctlaggdo[0].getParentDO();
		// blCgOepDO.setEnt_invoiceno(ent_invoiceno);//再次回写就诊，发票号1|就诊，发票号2|...|
		BlCgItmOepDO[] blCgItmOepDO = srvrtctlaggdo[0].getBlCgItmOepDO();
		srvrtctlaggdo1.setParentDO(blCgOepDO);
		srvrtctlaggdo1.setBlCgItmOepDO(blCgItmOepDO);
		// srvrtctlaggdo[0].getParentDO().setEnt_invoiceno(ent_invoiceno);//再次回写就诊，发票号1|就诊，发票号2|...|
		srvrtctlaggdo[0] = srvrtctlaggdo1;

		// 更新医嘱记账信息：新划价的信息对应医嘱
		TimeService timeService = new TimeServiceImpl();
		FDateTime fDateTime = timeService.getUFDateTime();
		if (null != blCgOepDO.getOrsrvids()) {
			if (blCgOepDO.getOrsrvids().length() > 0)// 在补费接口，就需要更新医嘱记账信息
			{
				Object obj2 = ServiceFinder.find(ICiOrdMaintainService.class);
				// FBoolean
				// updateCiOrder=((ICiOrdMaintainService)obj2).UpdateOrdChargeRelInfo(
				// orsrvidslist.toArray(new String[]{}),
				// ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID,ICiDictCodeConst.SD_SU_BL_ACCOUNT);
				FBoolean updateCiOrder = ((ICiOrdMaintainService) obj2).UpdateOrdChargeRelInfo2(blCgOepDO.getOrsrvids().split(","), ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID,
						ICiDictCodeConst.SD_SU_BL_ACCOUNT, fDateTime, FeeReverseType.NOBLCANCEL);
				if (!updateCiOrder.booleanValue()) {
					throw new BizException("更新医嘱状态失败,本次操作不成功！");
				}
			}
		}
		return srvrtctlaggdo;
	}

	/**
	 * 门诊新结算：取消划价 业务逻辑
	 * 
	 * @param blcgoepAggDOs
	 *            记账数据
	 * @param isHaveEn
	 *            删除数据汇总是否包含挂号数据
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public FBoolean DeletePricingInfo_bp(BlcgoepAggDO[] blcgoepAggDOs, boolean isHaveEn) throws BizException {
		// TODO Auto-generated method stub

		Map<String, ReserveReqDTO> matrialMap = new HashMap<String, ReserveReqDTO>();
		List<ReserveReqDTO> matrialList = new ArrayList<ReserveReqDTO>();
		// List<String> orsrvidslist = new ArrayList<String>();
		List<String> id_sts = new ArrayList<String>();
		List<String> id_inc = new ArrayList<String>();
		List<BlcgoepAggDO> del_BlcgoepAggDOs = new ArrayList<BlcgoepAggDO>(); // 非预付费
		List<BlcgoepAggDO> prepay_BlcgoepAggDOs = new ArrayList<BlcgoepAggDO>(); // 预付费
		// if(1==1)
		// {
		// throw new BizException("测试取消划价业务异常");
		// }
		if (blcgoepAggDOs == null) {
			throw new BizException("没有门诊记账信息");
		}
		
		Set<String> orsrvIdSet = new HashSet<String>();
		for (BlcgoepAggDO cgAggDO : blcgoepAggDOs) {
			for (BlCgItmOepDO cgItmDO : cgAggDO.getBlCgItmOepDO()) {
				if(!StringUtil.isEmpty(cgItmDO.getId_orsrv())){
					orsrvIdSet.add(cgItmDO.getId_orsrv());
				}
			}
		}
		
		Map<String, OrdSrvDO> orsrvMap = new HashMap<String, OrdSrvDO>();
		if(orsrvIdSet.size() > 0){
			
			DAFacade daf = new DAFacade();
			List<OrdSrvDO> orsrvList = (List<OrdSrvDO>)daf.findByPKs(OrdSrvDO.class, orsrvIdSet.toArray(new String[0]));
			if(!ListUtil.isEmpty(orsrvList)){
				orsrvMap = (Map<String, OrdSrvDO>)MapUtils.convertListToMap(orsrvList, OrdSrvDO.ID_ORSRV);
			}
		}
		
		
		// 1.获得id_stoep
		for (int j = 0; j < blcgoepAggDOs.length; j++) {
			BlCgItmOepDO[] blCgItmOepDOs = blcgoepAggDOs[j].getBlCgItmOepDO();
			del_BlcgoepAggDOs.add(blcgoepAggDOs[j]);// 默认都可以删除
			for (int i = 0; i < blCgItmOepDOs.length; i++) {
				// 预付费CG，诊间挂号CG和商保记账CG的不能删除（非划价是插入记账表的数据不能删除）
				// if ((blCgItmOepDOs[i].getFg_acc() != null &&
				// blCgItmOepDOs[i].getFg_acc().booleanValue() &&
				// blCgItmOepDOs[i].getEu_srctp() == 1) ||
				// (blCgItmOepDOs[i].getFg_hpcg()!=null &&
				// blCgItmOepDOs[i].getFg_hpcg().booleanValue()))
				if (blCgItmOepDOs[i].getId_stoep() != null && !id_sts.contains(blCgItmOepDOs[i].getId_stoep())) {
					id_sts.add(blCgItmOepDOs[i].getId_stoep());
				}
				// if (blCgItmOepDOs[i].getId_orsrv() != null) {
				// orsrvidslist.add(blCgItmOepDOs[i].getId_orsrv());
				// }

				// 非划价时插入记账表的数据，不能删除
				if (!blCgItmOepDOs[i].getFg_pricinginsertcg().booleanValue()) {
					prepay_BlcgoepAggDOs.add(blcgoepAggDOs[j]); // 挂号的，预付费或者商保记账的不能删除，需要修改部分字段
					del_BlcgoepAggDOs.remove(blcgoepAggDOs[j]);// 从可删除列表中删除属于预付费的
					break;
				}
				if (blCgItmOepDOs[i].getFg_mm() != null && blCgItmOepDOs[i].getFg_mm().booleanValue() && blCgItmOepDOs[i].getFg_susp() != null && blCgItmOepDOs[i].getFg_susp().booleanValue()
						&& blCgItmOepDOs[i].getEu_srctp() != 1) // 需要退物品
				{
					if (!matrialMap.containsKey(blCgItmOepDOs[i].getId_orsrv())) {
						ReserveReqDTO mlDTO = new ReserveReqDTO();
						mlDTO.setId_mm(blCgItmOepDOs[i].getId_mm());
						mlDTO.setId_dep(blCgItmOepDOs[i].getId_dep_wh());
						mlDTO.setReq_num(blCgItmOepDOs[i].getQuan());
						mlDTO.setReq_unit_id(blCgItmOepDOs[i].getPgku_cur());
						mlDTO.setId_orsrv(blCgItmOepDOs[i].getId_orsrv());
						
						OrdSrvDO orsrvDO = orsrvMap.get(blCgItmOepDOs[i].getId_orsrv());
						
						// 价格如果为0 说明物品未进行预留所以不需要取消预留
						if (!FDouble.ZERO_DBL.equals(blCgItmOepDOs[i].getPrice()) && 
								(orsrvDO == null || FBoolean.TRUE.equals(orsrvDO.getFg_or()))) {
							matrialList.add(mlDTO);
							matrialMap.put(blCgItmOepDOs[i].getId_orsrv(), mlDTO);
						}
					}
				}
			}
		}
		// 下方有对不删除 修改 状态的处理 2017年6月12日10:56:33 注释该返回操作
		// if (del_BlcgoepAggDOs == null || del_BlcgoepAggDOs.size() == 0) {
		// return FBoolean.TRUE; // 没有需要删除的划价信息，直接返回
		// }
		String condistr = "", condincstr = "";
		for (String id_st : id_sts) {
			// condistr=condistr+" or a0.id_stoep='"+id_st+"' ";
			condistr = condistr + "','" + id_st;
		}
		if (condistr.length() > 0) {
			condistr = " id_stoep in (" + condistr.substring(2) + "')";
			// 2.查结算信息
			IBlstoepRService iBlstoepRService = ServiceFinder.find(IBlstoepRService.class);
			BlStOepDO[] blStOepDOs = iBlstoepRService.find(BlStOepDODesc.TABLE_ALIAS_NAME + "." + condistr, "", FBoolean.FALSE);
			if (blStOepDOs == null) {
				throw new BizException("没有门诊结算信息");
			}
			for (BlStOepDO blStOepDO : blStOepDOs) {
				// bl_st_oep.id_paypatoep可能为“~”或者为null，如果收费了，bl_st_oep.id_paypatoep就是bl_pay_pat_oep的主键，长度肯定大于2
				// 唐
				if (blStOepDO.getId_paypatoep() != null && blStOepDO.getId_paypatoep().trim().length() > 2) {
					throw new BizException("已结算，不能取消划价！");
				}
			}

			// 3. 查询发票信息
			IBlincoepRService iBlincoepRService = ServiceFinder.find(IBlincoepRService.class);
			BlincoepAggDO[] blincoepAggDOs = iBlincoepRService.find(condistr, "", FBoolean.FALSE);
			if (blincoepAggDOs != null) {
				// 3.1 删除发票信息
				IBlincoepCudService iBlincoepCudService = ServiceFinder.find(IBlincoepCudService.class);
				iBlincoepCudService.delete(blincoepAggDOs);
			}
			// 4.查询分摊信息
			IBlpropoepRService iBlpropoepRService = ServiceFinder.find(IBlpropoepRService.class);
			BlPropOepDO[] blPropOepDOArr = iBlpropoepRService.find(condistr, "", FBoolean.FALSE);
			IBlproparoepRService iBlproparoepRService = ServiceFinder.find(IBlproparoepRService.class);

			if (blPropOepDOArr != null && blPropOepDOArr.length > 0) {
				for (BlPropOepDO blPropOepDO : blPropOepDOArr) {
					BlproparoepAggDO[] blproparoepAggDOArr = iBlproparoepRService.find(BlPropArOepDODesc.TABLE_ALIAS_NAME + ".id_propoep='" + blPropOepDO.getId_propoep() + "'", "", FBoolean.FALSE);
					// 4.1 删除分摊明细
					IBlproparoepCudService IBlproparoepCudService = ServiceFinder.find(IBlproparoepCudService.class);
					IBlproparoepCudService.delete(blproparoepAggDOArr);
				}
				// 4.2 删除分摊
				IBlpropoepCudService iBlpropoepCudService = ServiceFinder.find(IBlpropoepCudService.class);
				iBlpropoepCudService.delete(blPropOepDOArr);
			}

			// 5. 删除结算信息
			IBlstoepCudService iBlstoepCudService = ServiceFinder.find(IBlstoepCudService.class);
			iBlstoepCudService.delete(blStOepDOs);
		}
		// 6. 删除划价信息
		IBlcgoepCudService iBlcgoepCudService = ServiceFinder.find(IBlcgoepCudService.class);
		if (del_BlcgoepAggDOs != null && del_BlcgoepAggDOs.size() > 0) {
			(iBlcgoepCudService).delete(del_BlcgoepAggDOs.toArray(new BlcgoepAggDO[0]));
		}

		// 7.还原预付费的划价信息
		if (prepay_BlcgoepAggDOs != null && prepay_BlcgoepAggDOs.size() > 0) {
			for (BlcgoepAggDO blcgoepAggDO : prepay_BlcgoepAggDOs) {
				blcgoepAggDO.getParentDO().setStatus(DOStatus.UPDATED);
				BlCgItmOepDO[] blCgItmOepDOs = blcgoepAggDO.getBlCgItmOepDO();
				for (BlCgItmOepDO blCgItmOepDO : blCgItmOepDOs) {
					blCgItmOepDO.setFg_st(FBoolean.FALSE);
					blCgItmOepDO.setFg_susp(FBoolean.FALSE);
					blCgItmOepDO.setId_stoep(null);
					blCgItmOepDO.setStatus(DOStatus.UPDATED);
				}
			}
			BlcgoepAggDO[] BlcgoepAggDOs = iBlcgoepCudService.update(prepay_BlcgoepAggDOs.toArray(new BlcgoepAggDO[0]));
			if (BlcgoepAggDOs == null || BlcgoepAggDOs.length == 0) {
				throw new BizException("预付费记账数据取消划价失败");
			}
		}

		// // 7. 更新医嘱记账信息为未记账 2017-4-11更改，挪到收款时再更新医嘱记账信息为记账，因此，取消划价不用改
		// TimeService timeService = new TimeServiceImpl();
		// FDateTime fDateTime = timeService.getUFDateTime();
		// if (!(orsrvidslist == null || orsrvidslist.size() < 1)) {
		// ICiOrdMaintainService obj2 =
		// ServiceFinder.find(ICiOrdMaintainService.class);
		// FBoolean updateCiOrder =
		// obj2.UpdateOrdChargeRelInfo(orsrvidslist.toArray(new String[] {}),
		// ICiDictCodeConst.SD_SU_BL_NONE_ID, ICiDictCodeConst.SD_SU_BL_NONE,
		// fDateTime);
		// }
		// 8. 处理物品,退预留
		if (matrialList.size() > 0) {
			
			IMaterialStockService mlService = ServiceFinder.find(IMaterialStockService.class);
			
			//过滤已经退的预留
			List<ReserveReqDTO> needRefundList = new ArrayList<ReserveReqDTO>();
			Map<String, FBoolean> checkNeedRefundMap = mlService.getOrsrvReserveFlag(matrialMap.keySet().toArray(new String[0]));
			for (ReserveReqDTO reqDto : matrialList) {
				
				if(FBoolean.TRUE.equals(checkNeedRefundMap.get(reqDto.getId_orsrv()))){
					needRefundList.add(reqDto);
				}
			}
			
			if(needRefundList.size() > 0){
				mlService.reserveMaterials(IMaterialStockService.TYPE_RETURN, needRefundList.toArray(new ReserveReqDTO[] {}));
			}
			
			// TimeService timeService = new TimeServiceImpl();

			// StringBuffer info=new StringBuffer();
			// info.append("取消划价：处理物品,退库存reserveMaterials。");
			// info.append("入参{ ");
			// info.append(" 预留类型 type:"+mlService.TYPE_RETURN+";");
			// info.append(" 预留请求列表 reserveInputs："+matrialList.toString()+";");
			// info.append("}  返回结果");
			// info.append(mlResult[0].toString());
			// BlCgLogsRecordUtil.setIBlCgLogsRecordService(ServiceFinder.find(IBlCgLogsRecordService.class));
			// BlCgLogsRecordUtil.getIBlCgLogsRecordService().recordBlCgVsMMLogs(timeService.getUFDateTime(),info.toString());
		}

		return FBoolean.TRUE;
	}

	/**
	 * 通过子表条件，查询出未结账BlcgoepAggDO数组 a1.id_pat = '" + id_pat +
	 * "' and a1.id_org = '" + id_org + "' and a1.eu_direct = '" + eu_direct +
	 * "'
	 */

	public BlcgoepAggDO[] FindByItmsCondition(String id_pat, String id_org, String eu_direct) throws BizException {

		// TODO Auto-generated method stub
		GetBlCgOepAggByItmsQuery ins = new GetBlCgOepAggByItmsQuery();
		String sql = ins.GetBlCgOepAggByItmsQueryStr();

		SqlParam sqlp = new SqlParam();
		sqlp.addParam(id_pat);
		// sqlp.addParam(id_org);
		sqlp.addParam(Integer.parseInt(eu_direct));
		List<BlcgOepAggDTO> blcgAgg = (List<BlcgOepAggDTO>) new DAFacade().execQuery(sql, sqlp, new BeanListHandler(BlcgOepAggDTO.class));
		if (blcgAgg == null || blcgAgg.size() == 0) {
			throw new BizException("查询门诊记账信息失败");
		}

		// 获得Agg
		String id_cgoep = (blcgAgg.toArray(new BlcgOepAggDTO[0]))[0].getId_cgoep();
		String cond = BlCgOepDODesc.TABLE_ALIAS_NAME + ".id_cgoep='" + id_cgoep + "'";
		IBlcgoepRService iBlcgoepRService = ServiceFinder.find(IBlcgoepRService.class);
		return iBlcgoepRService.find(cond, "", FBoolean.TRUE);

	}

	/**
	 * 计算下张票号
	 * 
	 * @param curNo
	 *            当前票号
	 * @return 下张票号
	 * @throws BizException
	 */
	public String computeNextInvoiceNo(String curNo) throws BizException {
		GetCodeByCustomization code_ins = new GetCodeByCustomization();
		return code_ins.computeNextInvoiceNo(curNo);
	}

	/**
	 * 获得记账码
	 * 
	 * @return
	 * @throws BizException
	 */
	private String GetCodeCg() throws BizException {
		GetCodeByCustomization code_ins = new GetCodeByCustomization();
		return code_ins.GetCodeBlCgOep();
	}

	/**
	 * 根据id_ent获得EntHpDO[]
	 * 
	 * @param id_ent
	 * @return
	 */
	public EntHpDO[] getEntHpDOArr(String id_ent) throws BizException {
		DAFacade dAFacade = new DAFacade();
		EntHpDO[] entHpDOArr = null;
		List<EntHpDO> entHpDOList = (List<EntHpDO>) dAFacade.findByCond(EntHpDO.class, " id_ent='" + id_ent + "'", "1");
		if (entHpDOList != null) {
			if (entHpDOList.size() > 0) {
				entHpDOArr = entHpDOList.toArray(new EntHpDO[] {});
				entHpDOArr = new DORsReferMap<>(EntHpDO.class).convert(entHpDOArr);
			}
		}
		return entHpDOArr;
	}

	/**
	 * 根据医保对照类型SD，返回对应名称
	 * 
	 * @param sd_hpsrvtp
	 *            医保对照类型SD
	 * @return 医保对照类型名称
	 */
	private String gethp_name(String sd_hpsrvtp) {
		String hp_name = "";
		switch (sd_hpsrvtp) {
		case IBdPpCodeTypeConst.SD_HP_BJ_ONE:
			hp_name = "甲类";
			break;
		case IBdPpCodeTypeConst.SD_HP_BJ_TOW:
			hp_name = "乙类";
			break;
		case IBdPpCodeTypeConst.SD_HP_BJ_THREE:
			hp_name = "丙类";
			break;
		default:
			break;
		}
		return hp_name;
	}

	/**
	 * 获取计量单位列表
	 * 
	 * @throws BizException
	 * */
	private Map<String, String> getMeasDocDOMap() throws BizException {

		Map<String, String> measMap = new HashMap<String, String>();// 计量单位字典

		// 查询：调用轻量级的服务
		String[] fields = { "Id_measdoc", "Name" }; // 需要查询的列
		DAFacade dAFacade = new DAFacade();
		List<MeasDocDO> measDocDOList = (List<MeasDocDO>) dAFacade.findByCond(MeasDocDO.class, "1=1", "1", fields);
		if (measDocDOList != null && measDocDOList.size() > 0) {
			for (MeasDocDO measDocDO : measDocDOList) {
				if (measMap.get(measDocDO.getId_measdoc()) == null) {
					measMap.put(measDocDO.getId_measdoc(), measDocDO.getName());
				}
			}
		}
		return measMap;
	}

	/**
	 * 组装发票数据
	 * 
	 * @param stOepDo
	 *            结算信息DO
	 * @param incOepAggdoLst
	 *            本结算对应的发票Aggdo
	 * @return 组装的发票DTO组合
	 * @throws DAException
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] assemblyIncInfoDtos(BlStOepDO stOepDo, BlincoepAggDO[] incOepAggdoLst) throws BizException {

		IBlpaypatoepRService paypatOepService = ServiceFinder.find(IBlpaypatoepRService.class);
		BlpaypatoepAggDO paypatOepAggdo = paypatOepService.findById(stOepDo.getId_paypatoep());
		FBoolean Fg_redInvoice = FBoolean.FALSE;
		if (stOepDo.getEu_direct() == -1) {
			Fg_redInvoice = FBoolean.TRUE;
		}
		return handlerIncInfoDtos(FBoolean.TRUE, Fg_redInvoice, stOepDo, incOepAggdoLst, paypatOepAggdo);
	}

	/**
	 * 组装发票数据（不分窗口）
	 * 
	 * @param stOepDo
	 *            结算信息DO
	 * @param incOepAggdoLst
	 *            本结算对应的发票Aggdo
	 * @return 组装的发票DTO组合
	 * @throws DAException
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] assemblyIncInfoDtosWithoutWindow(BlStOepDO stOepDo, BlincoepAggDO[] incOepAggdoLst) throws BizException {

		IBlpaypatoepRService paypatOepService = ServiceFinder.find(IBlpaypatoepRService.class);
		BlpaypatoepAggDO paypatOepAggdo = paypatOepService.findById(stOepDo.getId_paypatoep());
		FBoolean Fg_redInvoice = FBoolean.FALSE;
		if (stOepDo.getEu_direct() == -1) {
			Fg_redInvoice = FBoolean.TRUE;
		}
		return handlerIncInfoDtos(FBoolean.FALSE, Fg_redInvoice, stOepDo, incOepAggdoLst, paypatOepAggdo);
	}

	/**
	 * 返回打印发票需要的DTO信息
	 * 
	 * @param Fg_window
	 *            物品是否分窗口
	 * @param Fg_RedInvoice
	 *            是否是红冲票
	 * @param stOepDo
	 *            结算信息DO
	 * @param incOepAggdoLst
	 *            发票AGG
	 * @param payPatOepAggdo
	 *            收付款支付方式AGG
	 * @return 返回打印发票需要的DTO信息
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlIncItmVsTypeDTO[] handlerIncInfoDtos(FBoolean Fg_window, FBoolean Fg_RedInvoice, BlStOepDO stOepDo, BlincoepAggDO[] incOepAggdoLst, BlpaypatoepAggDO payPatOepAggdo) throws BizException {
		if(ArrayUtil.isEmpty(incOepAggdoLst)){
			return new BlIncItmVsTypeDTO[]{};
		}
		// 1.组装数据
		// 该服务获取药品处方对应的发药窗口信息
		IMpDgOutService mpDgoutService = ServiceFinder.find(IMpDgOutService.class);
		List<BlIncItmVsTypeDTO> incInfoDtoLst = new ArrayList<BlIncItmVsTypeDTO>();
		// 获得价格分类
		String pripat_name = "";
		String sql = "select distinct b.name from bl_cg_itm_oep a inner join bd_pri_pat b on a.id_pripat=b.id_pripat where a.id_stoep='" + stOepDo.getId_stoep() + "'";
		DAFacade facade = new DAFacade();
		List<PriPatDO> priPatDOLst = (List<PriPatDO>) facade.execQuery(sql, new BeanListHandler(PriPatDO.class));
		if (priPatDOLst != null && priPatDOLst.size() > 0) {
			pripat_name = priPatDOLst.toArray(new PriPatDO[0])[0].getName();
		}
		// 获得开票人编号
		GetBlPsnDocName name_ins = new GetBlPsnDocName();
		String emp_code = "";
		if (incOepAggdoLst[0].getParentDO().getId_emp_inc() != null) {
			emp_code = name_ins.GetBlPsnDocCode(incOepAggdoLst[0].getParentDO().getId_emp_inc());
		}

		// 获取一下医疗机构类型
		String hospitalType = BlParams.BLHP000001();
		for (BlincoepAggDO incOepAggdo : incOepAggdoLst) {
			BlIncOepDO incOepDo = incOepAggdo.getParentDO();
			// 储存处方和其对应的发药窗口
			FMap presVsWindowInfo = new FMap();
			// 创建发票DTO模型
			BlIncItmVsTypeDTO incInfoDto = new BlIncItmVsTypeDTO();
			PatHpInfoDTO patHpInfoDto = new PatHpInfoDTO();
			EntHpDO enthp = null;
			FArrayList incItmOepDoLst = new FArrayList();
			BlIncItmOepDO[] incItmDoLst = incOepAggdo.getBlIncItmOepDO();
			// 发票账单项
			for (BlIncItmOepDO incCaItmDo : incItmDoLst) {
				BlinvoicecaitmDTO incCaItmDto = new BlinvoicecaitmDTO();
				incCaItmDto.setAmt(incCaItmDo.getAmt().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
//				incCaItmDto.setAmt_pat(incCaItmDo.getAmt_pat().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				incCaItmDto.setAmt_hp(incCaItmDo.getAmt_hp().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				incCaItmDto.setAmt_ratio(incCaItmDo.getAmt_ratio().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				incCaItmDto.setAmt_free(incCaItmDo.getAmt_free().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				incCaItmDto.setAmt_std(incCaItmDo.getAmt_std().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				incCaItmDto.setCode_inccam(incCaItmDo.getCode());
				incCaItmDto.setId_incitmoep(incCaItmDo.getId_incitmoep());
				incCaItmDto.setId_incoep(incCaItmDo.getId_incoep());
				incCaItmDto.setName_inccam(incCaItmDo.getName());
				incItmOepDoLst.add(incCaItmDto);
			}
			incInfoDto.setBlInvoicecaitmDTOLst(incItmOepDoLst);

			// 设置是否是医保结算
			FBoolean hasHpSettle = FBoolean.FALSE;

			// 根据获取当前结算的分摊信息 判断是否有分摊数据决定当前是否是医保结算 下方循环费用明细时判断如果是医保结算 并且是特病结算的话
			// 将医保结算给费false
			if (!StringUtil.isEmpty(stOepDo.getId_stoep())) {
				IBlproparoepRService propoepService = ServiceFinder.find(IBlproparoepRService.class);
				BlproparoepAggDO[] propOepDO = propoepService.find("ID_PROPOEP=(SELECT ID_PROPOEP FROM BL_PROP_OEP WHERE ROWNUM=1 AND ID_STOEP='" + stOepDo.getId_stoep() + "')", "", FBoolean.FALSE);
				if (propOepDO != null && propOepDO.length == 1 && !StringUtil.isEmpty(propOepDO[0].getParentDO().getId_hp())) {
					hasHpSettle = FBoolean.TRUE;
				}
			}

			// 发票收费明细项目的数据组装
			// 查找该发票对应的费用明细,这里需考虑分票的情况
			// 下面的sql是查询BL_CG_ITM_OEP的所有字段,并把NAME_MM换成bd_mm中的peint_name
			StringBuffer sb = new StringBuffer();
			sb.append(" SELECT A.ID_CGITMOEP,A.ID_GRP,A.ID_ORG,A.ID_PAT,A.ID_CGOEP,A.ID_ENT,A.ID_ENTTP,A.CODE_ENTTP,A.ID_PRES,A.ID_OR,A.ID_ORSRV,A.ID_SRVTP,A.SD_SRVTP,A.ID_SRVCA,A.ID_SRV,A.CODE_SRV,A.NAME_SRV,A.SRVU,A.PRICE,A.QUAN,A.AMT,A.RATIO_PRIPAT,A.AMT_STD,A.ID_PRIPAT,A.AMT_PAT,A.ID_HPSRVTP,A.SD_HPSRVTP,A.ID_HP,A.RATIO_HP,A.AMT_HP,A.FG_ACC,A.AMT_ACC,A.AMT_RATIO,A.DT_OR,A.ID_ORG_OR,A.ID_DEP_OR,A.ID_EMP_OR,A.ID_ORG_MP,A.ID_DEP_MP,A.ID_DEP_WH,A.FG_MM,A.ID_MM,A.ID_MMTP,A.SD_MMTP,A.CODE_MM,A.ONLYCODE,A.SPEC,A.CD_BATCH,A.PGKU_BASE,A.PGKU_CUR,A.FACTOR,A.QUAN_BASE,A.PRI_SS,A.FG_ST,A.ID_STOEP,A.DT_ST,A.FG_HP,A.FG_SUSP,A.ID_PAR,A.EU_SRCTP,A.NOTE,A.FG_REFUND,A.FG_ADDITM,A.APPRNO,A.ID_RECG_OEP,A.FG_RECG,A.DT_SRV,A.SRCFUNC_DES,A.DS,A.SV,A.CODE_INCCAITM,A.NAME_INCCAITM,A.FG_FREE,A.CODE_APPLY,A.PRICE_RATIO,A.SD_ABRD,A.FG_HPCG,A.FG_PRICINGINSERTCG,A.CODE_APPLYTP,A.ID_HPSRVMPAYRATIO,A.FG_ZEROREG,A.ROWID");
			sb.append(",mm.printname name_mm, ");
			sb.append("depor.name as Depor_name, ");
			sb.append("psn.name   as Empor_name,");
			sb.append("depmp.name as Depmp_name, ");
			sb.append("srvmeasdoc.name srvu_name, ");
			sb.append("mmmeasdoc.name pgku_cur_name ");
			sb.append("FROM BL_CG_ITM_OEP A");
			sb.append(" INNER JOIN BL_INC_CG_ITM_OEP B");
			sb.append(" ON A.ID_CGITMOEP=B.ID_CGITMOEP");
			sb.append(" left join bd_mm mm on mm.id_mm=A.id_mm ");
			sb.append(" left join bd_dep depor on a.id_dep_or=depor.id_dep ");
			sb.append(" left join bd_dep depmp on a.id_dep_mp=depmp.id_dep ");
			sb.append(" left join bd_psndoc psn on a.id_emp_or=psn.id_psndoc  ");
			sb.append(" left join bd_measdoc srvmeasdoc on A.srvu=srvmeasdoc.id_measdoc  ");
			sb.append(" left join bd_measdoc mmmeasdoc on A.pgku_cur=mmmeasdoc.id_measdoc  ");
			sb.append(" WHERE A.ID_STOEP=? AND B.ID_INCOEP=?");
			SqlParam param = new SqlParam();
			param.addParam(incOepAggdo.getParentDO().getId_stoep());
			param.addParam(incOepAggdo.getParentDO().getId_incoep());

			@SuppressWarnings("unchecked")
			List<BlCgItmOepDO> cgItmOepDoLst = (List<BlCgItmOepDO>) facade.execQuery(sb.toString(), param, new BeanListHandler(BlCgItmOepDO.class));
			
			//票据明细
			FArrayList invoiceDetailDtoLst = new FArrayList();

			//不需要合并的费用明细
			List<BlCgItmOepDO> noHandleCgItmList=new ArrayList<BlCgItmOepDO>();
			//需合并的费用明细
			Map<String,List<BlCgItmOepDO>> cgItmMap=new HashMap<String,List<BlCgItmOepDO>>();
			//需要合并的医嘱
			Map<String, CiOrderDO> asoneOrMap =new HashMap<String, CiOrderDO>();
			//需要单独显示的账单项
			Set<String> incCodeSet = new HashSet<String>();
			
			//1.查询分票逻辑
			BdInccaSplitDO splitDo=this.getSplitSet();
			
			//2.判断对费用明细是否需要特殊处理
			if(isOrderAsOneWhenDetailShow(splitDo)){
				//明细模式医嘱按照一条显示，需要特殊处理
				List<String> orList = new ArrayList<String>();
				for (BlCgItmOepDO cgItm : cgItmOepDoLst) {
					if(!StringUtil.isEmpty(cgItm.getId_or()) && !orList.contains(cgItm.getId_or())){
						orList.add(cgItm.getId_or());
					}
				}
			
				asoneOrMap = judgeAsOneOrder(orList, splitDo.getSd_disp_ci_srvtp());
			
			
				for (BlCgItmOepDO cgItmOepDo : cgItmOepDoLst) {
					if(asoneOrMap.containsKey(cgItmOepDo.getId_or())){//需要合并
						if(cgItmMap.containsKey(cgItmOepDo.getId_or())){
							List<BlCgItmOepDO> cgItmList=cgItmMap.get(cgItmOepDo.getId_or());
							cgItmList.add(cgItmOepDo);
						}else{
							List<BlCgItmOepDO> cgItmList=new ArrayList<BlCgItmOepDO>();
							cgItmList.add(cgItmOepDo);
							cgItmMap.put(cgItmOepDo.getId_or(), cgItmList);
						}
					}else{//不需要合并
						noHandleCgItmList.add(cgItmOepDo);
					}
				}
			
			}else if (this.isIncitmWhenDetailShow(splitDo)){
			
				List<String> inccaItmList = new ArrayList<String>();
				inccaItmList.addAll(Arrays.asList(splitDo.getSd_disp_incitm().split(",")));
				
				for (BlCgItmOepDO cgItmOepDo : cgItmOepDoLst) {
				
					if(inccaItmList.contains(cgItmOepDo.getCode_inccaitm())){
						incCodeSet.add(cgItmOepDo.getCode_inccaitm());
					}else{
						noHandleCgItmList.add(cgItmOepDo);
					}
				}
				
			}else if(this.isIncitmAndOrdWhenDetailShow(splitDo)){
				
				List<String> orList = new ArrayList<String>();
				for (BlCgItmOepDO cgItm : cgItmOepDoLst) {
					if(!StringUtil.isEmpty(cgItm.getId_or()) && !orList.contains(cgItm.getId_or())){
						orList.add(cgItm.getId_or());
					}
				}
			
				asoneOrMap = judgeAsOneOrder(orList, splitDo.getSd_disp_ci_srvtp());
				
				List<String> inccaItmList = new ArrayList<String>();
				if(!StringUtil.isEmpty(splitDo.getSd_disp_incitm())){
					inccaItmList.addAll(Arrays.asList(splitDo.getSd_disp_incitm().split(",")));
				}
			
				for (BlCgItmOepDO cgItmOepDo : cgItmOepDoLst) {
					if(asoneOrMap.containsKey(cgItmOepDo.getId_or())){//需要合并
						if(cgItmMap.containsKey(cgItmOepDo.getId_or())){
							List<BlCgItmOepDO> cgItmList=cgItmMap.get(cgItmOepDo.getId_or());
							cgItmList.add(cgItmOepDo);
						}else{
							List<BlCgItmOepDO> cgItmList=new ArrayList<BlCgItmOepDO>();
							cgItmList.add(cgItmOepDo);
							cgItmMap.put(cgItmOepDo.getId_or(), cgItmList);
						}
					}else if(inccaItmList.contains(cgItmOepDo.getCode_inccaitm())){
						incCodeSet.add(cgItmOepDo.getCode_inccaitm());
					}else{//不需要合并
						noHandleCgItmList.add(cgItmOepDo);
					}
				}
			}else{
				noHandleCgItmList.addAll(cgItmOepDoLst);
			}
			//把不需要特殊处理记账明细组装成票据明细
			/*********************************组装开始**********************/
			List<String> noHps = new ArrayList<String>();
			for (BlCgItmOepDO cgItmOepDo : cgItmOepDoLst) {
				if (FBoolean.TRUE.equals(hasHpSettle) && FBoolean.TRUE.equals(cgItmOepDo.getFg_specill())) {
					hasHpSettle = FBoolean.FALSE;
				}
				BlInvoiceDetailsDTO invoiceSrvDetail = new BlInvoiceDetailsDTO();
				invoiceSrvDetail.setAmt(cgItmOepDo.getAmt().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				invoiceSrvDetail.setAmt_pat(cgItmOepDo.getAmt_pat().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				invoiceSrvDetail.setAmt_ratio(cgItmOepDo.getAmt_ratio().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				invoiceSrvDetail.setAmt_std(cgItmOepDo.getAmt_std().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
				invoiceSrvDetail.setCode_inccaitm(cgItmOepDo.getCode_inccaitm());
				invoiceSrvDetail.setFg_free(cgItmOepDo.getFg_free());
				invoiceSrvDetail.setFg_mm(cgItmOepDo.getFg_mm());
				invoiceSrvDetail.setId_hp(cgItmOepDo.getId_hp());
				invoiceSrvDetail.setHpsrvtp(cgItmOepDo.getSd_hpsrvtp());
				invoiceSrvDetail.setId_cgoep(cgItmOepDo.getId_cgoep());
				invoiceSrvDetail.setId_mm(cgItmOepDo.getId_mm());
				invoiceSrvDetail.setId_srv(cgItmOepDo.getId_srv());
				invoiceSrvDetail.setCode_srv(cgItmOepDo.getCode_srv());
				invoiceSrvDetail.setEu_srctp(cgItmOepDo.getEu_srctp());
				invoiceSrvDetail.setName_inccaitm(cgItmOepDo.getName_inccaitm());
				invoiceSrvDetail.setFg_window(FBoolean.FALSE);// 是否需要设置领药窗口
				//增加开单科室  执行科室  开立医生  打发票用  by lim 2018-04-24
				invoiceSrvDetail.setName_dep_or(cgItmOepDo.getDepor_name());
				invoiceSrvDetail.setName_dep_mp(cgItmOepDo.getDepmp_name());
				invoiceSrvDetail.setName_emp_or(cgItmOepDo.getEmpor_name());
				invoiceSrvDetail.setId_dep_or(cgItmOepDo.getId_dep_or());
				invoiceSrvDetail.setId_emp_or(cgItmOepDo.getId_emp_or());
				invoiceSrvDetail.setId_dep_mp(cgItmOepDo.getId_dep_mp());
				//单位
				if(FBoolean.TRUE.equals(cgItmOepDo.getFg_mm())){
					invoiceSrvDetail.setSrvu(cgItmOepDo.getPgku_cur_name());
				}
				else{
					// 单位名称
					invoiceSrvDetail.setSrvu(cgItmOepDo.getSrvu_name());
				}
					
				// 得到社保号
				//String no_hp = this.getPatHpDOByIds(cgItmOepDo.getId_pat(), cgItmOepDo.getId_hp());
				enthp = this.getEntHpDo(cgItmOepDo.getId_ent(), cgItmOepDo.getId_hp());
				String no_hp = enthp != null ?enthp.getNo_hp() : "";
				noHps.add(no_hp);
				patHpInfoDto.setHp_code(no_hp);
				
				String patCa = null;
				if(!ListUtil.isEmpty(cgItmOepDoLst)){
					String id_ent = null;
					for (BlCgItmOepDO itm : cgItmOepDoLst) {
						if(!StringUtil.isEmpty(itm.getId_ent())){
							id_ent = itm.getId_ent();
							break;
						}
					}
					if(!StringUtil.isEmpty(id_ent)){
						StringBuffer hpSql = new StringBuffer();
						hpSql.append(" select  c.name  as  Id_paticate_name ");
						hpSql.append("     from  en_ent  b ");
						hpSql.append("   left  join  pi_pat_ca  c ");
						hpSql.append("         on  c.id_patca  =  b.id_patca ");
						hpSql.append("   where  b.id_ent=? ");
						SqlParam hpParam = new SqlParam();
						hpParam.addParam(id_ent);
						
						patCa = (String) facade.execQuery(hpSql.toString(), hpParam,new ColumnHandler());
					}
				}
				patHpInfoDto.setId_paticate_name(patCa);
				
				// 为医保类型字段赋值
				// 获得医保类型
				String name_hptp = "";
				String strsql = "select udi.name as name_hptp,hp.id_hptp ,hp.id_hp  from  bd_hp  hp join  bd_udidoc  udi on  hp.id_hptp = udi.id_udidoc where  udi.id_udidoclist='@@@@ZZ200000000000A2' and hp.id_hp ='"
						+ cgItmOepDo.getId_hp() + "'";
				DAFacade dafacade = new DAFacade();
				@SuppressWarnings("unchecked")
				List<HPDO> hpDOLst = (List<HPDO>) dafacade.execQuery(strsql, new BeanListHandler(HPDO.class));
				if (hpDOLst != null && hpDOLst.size() > 0) {
					name_hptp = hpDOLst.toArray(new HPDO[0])[0].getName_hptp();
					
				}
				invoiceSrvDetail.setHp_name(name_hptp);
				patHpInfoDto.setHp_psntype(name_hptp);
				if (cgItmOepDo.getFg_mm().booleanValue()) {
					invoiceSrvDetail.setName_srv(cgItmOepDo.getName_mm());
					if (Fg_window.booleanValue() && !StringUtil.isEmpty(cgItmOepDo.getId_dep_wh())) {
						invoiceSrvDetail.setFg_window(Fg_window);
						// 获取医保上传药品名称类型
						//String drugName = BlParamUtils.getHpUploadDrugNameType();
						// 根据参数 药品显示商品名还是通用名
						// if(drugName.equals(EuHpDrugNameType.MMNAME)){//商品名
						// invoiceSrvDetail.setName_srv(cgItmOepDo.getName_mm());
						// }else
						// if(drugName.equals(EuHpDrugNameType.SRVNAME)){//通用名
						// invoiceSrvDetail.setName_srv(cgItmOepDo.getName_srv());
						// }
						//invoiceSrvDetail.setName_srv(cgItmOepDo.getName_mm());
						// 获取窗口信息
						// 获取窗口信息（如果是留观，则不需要获取窗口信息）by xuebei 20190509
						if (!IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS.equals(cgItmOepDo.getCode_enttp())) {
						if (presVsWindowInfo.containsKey(cgItmOepDo.getId_pres())) {
							if (presVsWindowInfo.get(cgItmOepDo.getId_pres()) != null) {
								invoiceSrvDetail.setWindowinfo(presVsWindowInfo.get(cgItmOepDo.getId_pres()).toString());
							}
						} else {
							String name_wh = "";// 药房名称
							String ssql = " select dep.name as def10  from  ci_pres  pres join  bd_dep  dep on  pres.id_dep_mp = id_dep   where pres.id_pres = '" + cgItmOepDo.getId_pres() + "'";
							DAFacade cade = new DAFacade();
							@SuppressWarnings("unchecked")
							List<CiPresDO> presDOLst = (List<CiPresDO>) cade.execQuery(ssql, new BeanListHandler(CiPresDO.class));
							if (presDOLst != null && presDOLst.size() > 0) {
								name_wh = presDOLst.toArray(new CiPresDO[0])[0].getDef10();
							}
							// 如果是商保记账 或预交金记账 则在医嘱记账时已经分发了窗口号，这里需调用取窗口号接口
							if (cgItmOepDo.getFg_hpcg().booleanValue() || cgItmOepDo.getFg_acc().booleanValue()) {
								FMap mapWindow = mpDgoutService.getQueSiteNameOfPres(new String[] { cgItmOepDo.getId_pres() }); // 其返回结果为map，
																																// key:处方id
																																// value:窗口名称（多个时用逗号分隔）
								String strWinInfo = (String) mapWindow.get(cgItmOepDo.getId_pres());
								strWinInfo = name_wh + strWinInfo;// 将取药窗口信息拼成
																	// 执行科室名称+窗口号的形式
								if (!presVsWindowInfo.containsKey(cgItmOepDo.getId_pres()))
									presVsWindowInfo.put(cgItmOepDo.getId_pres(), strWinInfo);
								// 获取并设置窗口名称
								invoiceSrvDetail.setWindowinfo(presVsWindowInfo.get(cgItmOepDo.getId_pres()).toString());
							} else {
								// 调用分窗口号接口
								OpPresQueSiteDTO opPresQueSiteDTO = mpDgoutService.insertPresWindowData(cgItmOepDo.getId_pres(), IMpDgConst.ENTRY_AFTER_CHARGE);
								if (opPresQueSiteDTO != null) {
									if (!presVsWindowInfo.containsKey(cgItmOepDo.getId_pres()))
										// 有些药是不需要发药窗口的，例如在院执行的
										presVsWindowInfo.put(cgItmOepDo.getId_pres(), name_wh + opPresQueSiteDTO.getName_quesite());
									// 获取并设置窗口名称
									invoiceSrvDetail.setWindowinfo(presVsWindowInfo.get(cgItmOepDo.getId_pres()).toString());
									}
								}
							}
						}	
					} 
				}else {
					invoiceSrvDetail.setName_srv(cgItmOepDo.getName_srv());
				}

				invoiceSrvDetail.setPrice(cgItmOepDo.getPrice());
				invoiceSrvDetail.setPrice_ratio(cgItmOepDo.getPrice_ratio());
				invoiceSrvDetail.setQuan(cgItmOepDo.getQuan());
				// 规格
				invoiceSrvDetail.setSpec_srv(cgItmOepDo.getSpec());
				
				if(asoneOrMap.containsKey(cgItmOepDo.getId_or()) || incCodeSet.contains(cgItmOepDo.getCode_inccaitm()))
					continue;
				
				invoiceDetailDtoLst.add(invoiceSrvDetail);
			}// 明细项组装完成
			/****************************组装结束*********************************/
			

			//把医嘱相应的记账明细进行合并,组装成一条票据明细
			if(cgItmMap != null && cgItmMap.size() > 0){
				for (Entry entry : cgItmMap.entrySet()) {
					List<BlCgItmOepDO> itmList=(List<BlCgItmOepDO>)entry.getValue();
					FDouble amt_ratio=FDouble.ZERO_DBL;
					FDouble amt=FDouble.ZERO_DBL;
					FDouble amt_std=FDouble.ZERO_DBL;
					FDouble amt_pat=FDouble.ZERO_DBL;
					for (BlCgItmOepDO blCgItmOepDO : itmList) {
						amt_ratio=amt_ratio.add(blCgItmOepDO.getAmt_ratio().multiply(incOepDo.getEu_direct()));
						amt=amt.add(blCgItmOepDO.getAmt().multiply(incOepDo.getEu_direct()));
						amt_std=amt_std.add(blCgItmOepDO.getAmt_std().multiply(incOepDo.getEu_direct()));
						amt_pat=amt_pat.add(blCgItmOepDO.getAmt_std().multiply(incOepDo.getEu_direct()));
					}
					BlInvoiceDetailsDTO invoiceSrvDetail = new BlInvoiceDetailsDTO();
					invoiceSrvDetail.setAmt(amt.setScale(-2, BigDecimal.ROUND_HALF_UP));
					invoiceSrvDetail.setAmt_pat(amt_pat.setScale(-2, BigDecimal.ROUND_HALF_UP));
					invoiceSrvDetail.setAmt_ratio(amt_ratio.setScale(-2, BigDecimal.ROUND_HALF_UP));
					invoiceSrvDetail.setAmt_std(amt_std.setScale(-2, BigDecimal.ROUND_HALF_UP));
					invoiceSrvDetail.setEu_srctp(0);
					CiOrderDO orDo=asoneOrMap.get(entry.getKey());
					if(orDo!=null){
						invoiceSrvDetail.setName_srv(orDo.getName_or());
						if(itmList.size() > 1){
							invoiceSrvDetail.setQuan(FDouble.ONE_DBL);
							invoiceSrvDetail.setPrice_ratio(invoiceSrvDetail.getAmt_ratio());
						}else{
							invoiceSrvDetail.setQuan(itmList.get(0).getQuan());
							invoiceSrvDetail.setPrice_ratio(itmList.get(0).getPrice_ratio());
						}
					}
					invoiceDetailDtoLst.add(invoiceSrvDetail);
				}
			}
			
			if(incCodeSet.size() > 0){
				
				for (String code : incCodeSet) {
					
					BlinvoicecaitmDTO incCaItmDto = null;
					for (int i = 0; i < incInfoDto.getBlInvoicecaitmDTOLst().size(); i++) {
						
						BlinvoicecaitmDTO incCaItmDto2 = (BlinvoicecaitmDTO)incInfoDto.getBlInvoicecaitmDTOLst().get(i);
						if(code.equals(incCaItmDto2.getCode_inccam())){
							incCaItmDto = incCaItmDto2;
							break;
						}
					}
					
					if(incCaItmDto != null){
						
						BlInvoiceDetailsDTO invoiceSrvDetail = new BlInvoiceDetailsDTO();
						invoiceSrvDetail.setAmt(incCaItmDto.getAmt());
						invoiceSrvDetail.setAmt_pat(incCaItmDto.getAmt_pat());
						invoiceSrvDetail.setAmt_ratio(incCaItmDto.getAmt_ratio());
						invoiceSrvDetail.setAmt_std(incCaItmDto.getAmt_std());
						invoiceSrvDetail.setEu_srctp(0);
						invoiceSrvDetail.setName_srv(incCaItmDto.getName_inccam());
						invoiceSrvDetail.setQuan(FDouble.ONE_DBL);
						invoiceSrvDetail.setPrice_ratio(invoiceSrvDetail.getAmt_ratio());
						
						invoiceDetailDtoLst.add(invoiceSrvDetail);
					}
				}
			}
			
			incInfoDto.setBlInvoiceDetailsDTO(invoiceDetailDtoLst);

			String strPayWay = "";
			// 获取对应的参照字段
			if (payPatOepAggdo != null) {
				BlPayItmPatOepDO[] payItmPatOpeDoLst = payPatOepAggdo.getBlPayItmPatOepDO();
				BlPayItmPatOepDO[] itmPatoepDoArr = new DORsReferMap<>(BlPayItmPatOepDO.class).convert(payItmPatOpeDoLst);
				payPatOepAggdo.setBlPayItmPatOepDO(itmPatoepDoArr);
				strPayWay = this.getPayWayStr(payPatOepAggdo);
			}
			// 发票头尾数据源组装
			// 获取医保结算信息
			BlPropArOepDO[] propArOepDoArr = null;

			if (hasHpSettle.booleanValue()) {
				// 如果是医保结算，获取医保交易流水号
				propArOepDoArr = (BlPropArOepDO[]) AppFwUtil.getDORstWithDao(new BlPropArQry(stOepDo.getId_stoep()), BlPropArOepDO.class);
			}
			BlInvoiceHeadTailDTO invoiceHeadTaildto = new BlInvoiceHeadTailDTO();
			String depName = "";
			if (invoiceDetailDtoLst != null && invoiceDetailDtoLst.size() != 0 && ((BlInvoiceDetailsDTO) invoiceDetailDtoLst.get(0)).getEu_srctp() == 1) {
				sql = "SELECT name FROM bd_dep WHERE ID_DEP=(select ID_DEP_PHY from en_ent WHERE ID_ENT='" + stOepDo.getId_ent() + "')";
				priPatDOLst = (List<PriPatDO>) facade.execQuery(sql, new BeanListHandler(PriPatDO.class));
				if (priPatDOLst != null && priPatDOLst.size() == 1) {
					depName = ((PriPatDO) priPatDOLst.get(0)).getName();
				}
			}
			if (noHps != null && noHps.size() != 0) {
				// 得到社会保障号
				invoiceHeadTaildto.setEnthpdo(noHps.get(0));
			}
			invoiceHeadTaildto.setAmt_st(stOepDo.getAmt_std().multiply(stOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
			invoiceHeadTaildto.setId_incoep(incOepDo.getId_incoep());
			invoiceHeadTaildto.setAmt(incOepDo.getAmt().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
			if (incOepDo.getAmt_free() != null) {
				invoiceHeadTaildto.setAmt_free(incOepDo.getAmt_free().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
			}
			if (incOepDo.getAmt_hp() != null)
				invoiceHeadTaildto.setAmt_hp(incOepDo.getAmt_hp().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
			
			
			// modified by czl  20180524
			//查应收表
			if (propArOepDoArr != null && propArOepDoArr.length > 0) {
				invoiceHeadTaildto.setAmt_hp(propArOepDoArr[0].getAmt_hp());
				invoiceHeadTaildto.setAmt_otherhp(propArOepDoArr[0].getAmt_other());
				
				/*if(propArOepDoArr[0].getAmt_other() != null){//ly 目前存放了医保盈亏金额
					invoiceHeadTaildto.setAmt_hp(invoiceHeadTaildto.getAmt_hp().add(propArOepDoArr[0].getAmt_other()));
				}*/
				
				invoiceHeadTaildto.setAmt_pat(propArOepDoArr[0].getAmt_cash());
				
			}else
   			   invoiceHeadTaildto.setAmt_pat(incOepDo.getAmt_pat().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
			
			invoiceHeadTaildto.setAmt_std(incOepDo.getAmt_std().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP));
			// 判断是否包含高端商保支付项目 如果包含减去患者自付金额合并高端商保字符类型为 CODE=17 的 并赋给字段amt_hpcg
			// 高保支付：***.**
			if (payPatOepAggdo != null) {
				BlPayItmPatOepDO[] itemDos = payPatOepAggdo.getBlPayItmPatOepDO();
				FDouble amt_hpcg = FDouble.ZERO_DBL;
				FDouble amt_jjzf = FDouble.ZERO_DBL;// 医保基金支付金额
				FDouble amt_grzhzf = FDouble.ZERO_DBL;// 个人账户支付金额
				FDouble amt_free = FDouble.ZERO_DBL;// 费用减免
				FDouble amt_diff = FDouble.ZERO_DBL;// 医保差额
				FDouble amt_profitloss = FDouble.ZERO_DBL;// 医保盈亏
				for (BlPayItmPatOepDO blPayItmPatOepDO : itemDos) {
					// 判断是否包含商保支付项目
					if (IBdPripmCodeConst.ID_PRI_PM_BUSINESS.equals(blPayItmPatOepDO.getId_pm())) {
						amt_hpcg = amt_hpcg.add(blPayItmPatOepDO.getAmt().multiply(blPayItmPatOepDO.getEu_direct()));
					}
					// 判断是否包含医保基金支付项目
					if (IBdPripmCodeConst.ID_PRI_PM_INSUR.equals(blPayItmPatOepDO.getId_pm())) {
						amt_jjzf = amt_jjzf.add(blPayItmPatOepDO.getAmt().multiply(blPayItmPatOepDO.getEu_direct()));
					}
					// 判断是否包含个人账户支付项目
					if (IBdPripmCodeConst.ID_PRI_PM_INSURPERSONALACCOUNT.equals(blPayItmPatOepDO.getId_pm())) {
						amt_grzhzf = amt_grzhzf.add(blPayItmPatOepDO.getAmt().multiply(blPayItmPatOepDO.getEu_direct()));
					}

					// 判断是否包金额减免与项目减免
					if (IBdPripmCodeConst.ID_PRI_PM_MONEYDEDUCTION.equals(blPayItmPatOepDO.getId_pm()) || IBdPripmCodeConst.ID_PRI_PM_SRVDEDUCTION.equals(blPayItmPatOepDO.getId_pm())) {
						amt_free = amt_free.add(blPayItmPatOepDO.getAmt().multiply(blPayItmPatOepDO.getEu_direct()));
					}

					// 判断是否包含医保差额
					if (IBdPripmCodeConst.ID_PRI_PM_INSUR_DIFF.equals(blPayItmPatOepDO.getId_pm())) {
						amt_diff = amt_diff.add(blPayItmPatOepDO.getAmt().multiply(blPayItmPatOepDO.getEu_direct()));
					}
					
					//医保盈亏
					if(IBdPripmCodeConst.ID_PRI_PM_HPPROFITLOSS.equals(blPayItmPatOepDO.getId_pm())) {
						amt_profitloss = amt_profitloss.add(blPayItmPatOepDO.getAmt().multiply(blPayItmPatOepDO.getEu_direct()));
					}
				}
				// 设置商保支付金额
				if (!FDouble.ZERO_DBL.equals(amt_hpcg)) {
					invoiceHeadTaildto.setAmt_hpcg(("商保金额：" + amt_hpcg.setScale(2, BigDecimal.ROUND_HALF_UP)));
				}

				if (!FDouble.ZERO_DBL.equals(amt_jjzf)) {
					invoiceHeadTaildto.setAmt_hp((amt_jjzf.setScale(2, BigDecimal.ROUND_HALF_UP)));
				}
				if (!FDouble.ZERO_DBL.equals(amt_free)) {
					invoiceHeadTaildto.setAmt_free(amt_free.setScale(2, BigDecimal.ROUND_HALF_UP));
				}
				// 设置个人账户支付金额
				invoiceHeadTaildto.setAmt_grzhzf((amt_grzhzf.setScale(2, BigDecimal.ROUND_HALF_UP)));

				// 判断是否包含个人支付项目 ，暂且将除了医保基金支付、个人账户支付、商保支付的其他支付方式均算在个人支付中，金额减免、
				// 项目减免、 内部转账的也暂且归到个人支付中，
				invoiceHeadTaildto.setAmt_pat(stOepDo.getAmt_ratio().sub(amt_hpcg.setScale(-2, BigDecimal.ROUND_HALF_UP)).sub(amt_jjzf.setScale(-2, BigDecimal.ROUND_HALF_UP))
						.sub(amt_grzhzf.setScale(-2, BigDecimal.ROUND_HALF_UP)).sub(amt_free.setScale(-2, BigDecimal.ROUND_HALF_UP)).sub(amt_diff.setScale(-2, BigDecimal.ROUND_HALF_UP))
						.sub(amt_profitloss.setScale(-2, BigDecimal.ROUND_HALF_UP)));

				invoiceHeadTaildto.setAmt_ratio(incOepDo.getAmt_ratio().multiply(incOepDo.getEu_direct()).setScale(-2, BigDecimal.ROUND_HALF_UP).sub(amt_diff.setScale(-2, BigDecimal.ROUND_HALF_UP)));

			}

			// 医保交易流水号
			if (propArOepDoArr != null && propArOepDoArr.length > 0) {
				invoiceHeadTaildto.setCode_hp(propArOepDoArr[0].getCode_hp());
				// 如果当前是医保结算 当前结算总金额为医保金额 为了避免差额问题2017年12月11日 yang.lu
				invoiceHeadTaildto.setAmt(propArOepDoArr[0].getAmt_all());
			}
			invoiceHeadTaildto.setPay_tp(strPayWay);
			invoiceHeadTaildto.setFg_hp(hasHpSettle);
			invoiceHeadTaildto.setCode_st(stOepDo.getCode_st());
			invoiceHeadTaildto.setDatetime_print(incOepDo.getDt_inc());
			invoiceHeadTaildto.setDatetime_st(stOepDo.getDt_st());
			invoiceHeadTaildto.setEu_direct(incOepDo.getEu_direct());
			invoiceHeadTaildto.setEu_freemd(incOepDo.getEu_freemd());
			invoiceHeadTaildto.setHospital_type(hospitalType);
			invoiceHeadTaildto.setId_pat(incOepDo.getId_pat());
			invoiceHeadTaildto.setPatcode(incOepDo.getPatcode());
			invoiceHeadTaildto.setId_stoep(incOepDo.getId_stoep());
			invoiceHeadTaildto.setFg_reg(new FBoolean(StTypeEnum.ST_OEP_REG.equals(stOepDo.getEu_sttp()))); 
			invoiceHeadTaildto.setIncno(incOepDo.getIncno());
			invoiceHeadTaildto.setPripat_name(pripat_name);
			invoiceHeadTaildto.setDep_name(depName);
			invoiceHeadTaildto.setPatname(incOepDo.getPatname());
			//获取患者信息 
			PatDO patDo=getPatDO(incOepDo.getId_pat());
			invoiceHeadTaildto.setSex(patDo.getSd_sex());
			
			String eu_sttp = stOepDo.getEu_sttp();
			if (eu_sttp.equals(StTypeEnum.ST_OEP_CHARGE)) {
				invoiceHeadTaildto.setEu_sttp("门诊收费结算");
			} else if (eu_sttp.equals(StTypeEnum.ST_OEP_MIDWAY)) {
				invoiceHeadTaildto.setEu_sttp("门诊收费冲账");
			} else if (eu_sttp.equals(StTypeEnum.ST_REGISTER_MIDWAY)) {
				invoiceHeadTaildto.setEu_sttp("门诊挂号冲账");
			} else if (eu_sttp.equals(StTypeEnum.ST_OEP_REG)) {
				invoiceHeadTaildto.setEu_sttp("门诊挂号结算");
			} else if (eu_sttp.equals(StTypeEnum.ST_OEP_RED)) {
				invoiceHeadTaildto.setEu_sttp("收费取消结算");
			} else if (eu_sttp.equals(StTypeEnum.ST_REGISTER_RED)) {
				invoiceHeadTaildto.setEu_sttp("挂号取消结算");
			}
			
			//收付款信息
			FArrayList payList = new FArrayList();
			if(payPatOepAggdo != null){
				for (BlPayItmPatOepDO payItmDO : payPatOepAggdo.getBlPayItmPatOepDO()) {
					BlInvoicePmDTO pmDto = new BlInvoicePmDTO();
					pmDto.setId_pm(payItmDO.getId_pm());
					pmDto.setSd_pm(payItmDO.getSd_pm());
					pmDto.setName_pm(payItmDO.getPm_name());
					pmDto.setEu_direct(payItmDO.getEu_direct());
					pmDto.setAmt(payItmDO.getAmt());
					pmDto.setFg_realpay(payItmDO.getFg_realpay());
					payList.add(pmDto);
				}
			}
			
			// 发票开立人姓名,改成发票开立人code
			invoiceHeadTaildto.setInc_emp_name(emp_code);
			invoiceHeadTaildto.setPayee_emp_name(stOepDo.getId_emp_st_code());
			incInfoDto.setBlInvoiceHeadTailDTO(invoiceHeadTaildto);
			incInfoDto.setFg_RedInvoice(Fg_RedInvoice);// 是否红冲票
			incInfoDto.setBlInvoicePmDTOList(payList);
			incInfoDto.setPatHpInfoDTO(patHpInfoDto);
			if(enthp != null){
				FArrayList entHpDos = new FArrayList();
				entHpDos.add(enthp);
				incInfoDto.setEntHpDO(entHpDos);
			}			
			incInfoDtoLst.add(incInfoDto);
		}// 组装数据完成
		
		//按照发票号排序
		Collections.sort(incInfoDtoLst, new OpIncComparator());
		
		return incInfoDtoLst.toArray(new BlIncItmVsTypeDTO[0]);
	}
		

		/**
		 * 过滤明细模式下需要单独医嘱的医嘱
		 * @param orList
		 * @param ciSrvTp
		 * @return
		 * @throws BizException
		 */
		@SuppressWarnings("unchecked")
		private static Map<String,CiOrderDO> judgeAsOneOrder(List<String> orList,String ciSrvTp) throws BizException{
			
			Map<String,CiOrderDO> result=new HashMap<String,CiOrderDO>();
			if(ListUtil.isEmpty(orList) || StringUtil.isEmpty(ciSrvTp)){
				return result;
			}
			
			String[] srtTps = ciSrvTp.split(",");
			
			StringBuilder sqlSb = new StringBuilder();
			sqlSb.append("select id_or,name_or,quan_medu ");
			sqlSb.append("from ci_order ");
			sqlSb.append("where " + SqlUtils.getInSqlByIds("id_or", orList.toArray(new String[0])) + " ");
			sqlSb.append("and "+ SqlUtils.getInSqlByIds("sd_srvtp", srtTps));
			
			DAFacade daf = new DAFacade();
			List<CiOrderDO> filterOrList =  (List<CiOrderDO>)daf.execQuery(sqlSb.toString(), new BeanListHandler(CiOrderDO.class));
			
			
			if(ListUtil.isEmpty(filterOrList))
				return result;
			
			for (CiOrderDO orDo : filterOrList) {
			
				if(!result.containsKey(orDo.getId_or())){
					result.put(orDo.getId_or(), orDo);
				}
			}
			return result;
		}
		
		
		/**
		 * 明细模式下医嘱是否按照一条显示明细模式下医嘱是否按照一条显示
		 * @param splitSet
		 * @return
		 * @throws BizException
		 */
		private static boolean isOrderAsOneWhenDetailShow(BdInccaSplitDO splitSet) throws BizException{
			
			if(splitSet == null || StringUtil.isEmpty(splitSet.getSd_disp_ci_srvtp())){
				return false;
			}
			
			if(FBoolean.TRUE.equals(splitSet.getFg_splitbyaccount())){
				return IBdPpCodeTypeConst.SD_DISPTP_DETAILORDER.equals(splitSet.getSd_ac_disptp());
			}else{
				return IBdPpCodeTypeConst.SD_DISPTP_DETAILORDER.equals(splitSet.getSd_disptp());
			}
		}

		/**
		 * 明细模式下账单项是否单独显示
		 * @param splitSet
		 * @return
		 * @throws BizException
		 */
		private boolean isIncitmWhenDetailShow(BdInccaSplitDO splitSet) throws BizException{
			
			if(splitSet == null || StringUtil.isEmpty(splitSet.getSd_disp_incitm())){
				return false;
			}
			
			if(FBoolean.TRUE.equals(splitSet.getFg_splitbyaccount())){
				return IBdPpCodeTypeConst.SD_DISPTP_DETAILINCITM.equals(splitSet.getSd_ac_disptp());
			}else{
				return IBdPpCodeTypeConst.SD_DISPTP_DETAILINCITM.equals(splitSet.getSd_disptp());
			}
		}
		
		/**
		 * 明细模式下账单项和医嘱是否单独显示
		 * @param splitSet
		 * @return
		 * @throws BizException
		 */
		private boolean isIncitmAndOrdWhenDetailShow(BdInccaSplitDO splitSet) throws BizException{
			
			if(splitSet == null)
				return false;
			
			if(StringUtil.isEmpty(splitSet.getSd_disp_incitm()) && StringUtil.isEmpty(splitSet.getSd_disp_ci_srvtp())){
				return false;
			}
			
			if(FBoolean.TRUE.equals(splitSet.getFg_splitbyaccount())){
				return IBdPpCodeTypeConst.SD_DISPTP_DETAILINCITMORDER.equals(splitSet.getSd_ac_disptp());
			}else{
				return IBdPpCodeTypeConst.SD_DISPTP_DETAILINCITMORDER.equals(splitSet.getSd_disptp());
			}
		}
	
	/**
	 * 获取门诊分票配置
	 * 
	 * @return
	 * @throws BizException
	 */
	private BdInccaSplitDO getSplitSet() throws BizException {

		IInccasplitRService rService = ServiceFinder.find(IInccasplitRService.class);
		String whereSql = String.format("id_incca = '%s' and fg_active = 'Y'",IBdPpCodeTypeConst.ID_OUTPATIENT_INVOICE);

		BdInccaSplitDO[] splitDos = rService.find(whereSql, "", FBoolean.FALSE);
		if (ArrayUtil.isEmpty(splitDos))
			return null;

		return splitDos[0];
	}

	/**
	 * 通过id_pat,id_hp得到患者医保计划表
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private String getPatHpDOByIds(String id_pat, String id_hp) throws BizException {
		String sql = "select no_hp from pi_pat_hp where id_pat ='" + id_pat + "' and id_hp='" + id_hp + "'";
		DAFacade facade = new DAFacade();
		@SuppressWarnings("unchecked")
		List<PiPatHpDO> entHpDODOLst = (List<PiPatHpDO>) facade.execQuery(sql, new BeanListHandler(PiPatHpDO.class));
		if (entHpDODOLst != null && entHpDODOLst.size() == 1) {
			String noHp = ((PiPatHpDO) entHpDODOLst.get(0)).getNo_hp();
			return noHp;
		}
		return null;
	}
	/**
	 * 获取医保信息
	 * @param id_ent
	 * @param id_hp
	 * @return
	 * @throws BizException
	 * @author hanJQ 2019年2月27日
	 */
	private EntHpDO getEntHpDo(String id_ent, String id_hp) throws BizException {
//		String sql = "select no_hp from en_ent_hp where id_ent ='" + id_ent + "' and id_hp='" + id_hp + "'";
//		DAFacade facade = new DAFacade();
//		@SuppressWarnings("unchecked")
//		List<EntHpDO> entHpDODOLst = (List<EntHpDO>) facade.execQuery(sql, new BeanListHandler(EntHpDO.class));
//		if (entHpDODOLst != null && entHpDODOLst.size() == 1) {
//			String noHp = ((EntHpDO) entHpDODOLst.get(0)).getNo_hp();
//			return noHp;
//		}
		IEnthpRService EnthpRService = ServiceFinder.find(IEnthpRService.class);
		String whereStr = "id_ent ='" + id_ent + "' and id_hp='" + id_hp + "'";
		EntHpDO[] entHpDos = EnthpRService.find(whereStr, "", FBoolean.FALSE);
		if(entHpDos != null && entHpDos.length > 0){
			return entHpDos[0];
		}
		return null;
	}

	/**
	 * 获取支付方式拼接的字符串
	 * 
	 * @param payPatOepAggdo
	 *            结算支付方式
	 * @return
	 * @throws BizException
	 */
	private String getPayWayStr(BlpaypatoepAggDO payPatOepAggdo) throws BizException {
		BlPayItmPatOepDO[] payItmPatOpeDoLst = payPatOepAggdo.getBlPayItmPatOepDO();
		String strPayWay = "";
		for (BlPayItmPatOepDO itmPatOepDo : payItmPatOpeDoLst) {
			// 如果当前支付项目为医保差额则屏蔽此名称 2017年12月11日 yang.lu 医保差额不显示在打印当中
			if (IBdPripmCodeConst.ID_PRI_PM_INSUR_DIFF.equals(itmPatOepDo.getId_pm()))
				continue;
			if (itmPatOepDo.getPm_name() == null) {
				throw new BizException("当前付款方式名称异常，请及时联系管理员！");
			}
			// 找零方式暂时不考虑
			if (itmPatOepDo.getEu_direct() == 1 && strPayWay.indexOf(itmPatOepDo.getPm_name()) == -1)
				strPayWay = strPayWay + "," + itmPatOepDo.getPm_name();
		}
		if (StringUtil.isEmpty(strPayWay))
			return strPayWay;
		return strPayWay.substring(1);
	}
	
	/**
	 * 查询患者信息
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	private PatDO getPatDO(String id_pat) throws BizException{
		IPatiMDORService patService= ServiceFinder.find(IPatiMDORService.class);
		PatDO patDo= patService.findById(id_pat);
		return patDo== null? new PatDO(): patDo;
	}
}
