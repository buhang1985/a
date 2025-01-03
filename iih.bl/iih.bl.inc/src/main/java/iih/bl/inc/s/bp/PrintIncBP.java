package iih.bl.inc.s.bp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgzyquerydto.d.BlCgZyQueryDTO;
import iih.bl.cg.service.IBlcgqueryService;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blincip.d.BlincipAggDO;
import iih.bl.inc.blincip.i.IBlincipRService;
import iih.bl.inc.blincquerydto.d.BlInvoicePmDTO;
import iih.bl.params.BlParams;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.i.IBlpaypatRService;
import iih.bl.prop.blproparip.d.BlPropArIpDO;
import iih.bl.st.blpaypatip.d.BlPayItmPatIpDO;
import iih.bl.st.blpaypatip.d.BlPayPatIpDO;
import iih.bl.st.blpaypatip.d.BlpaypatipAggDO;
import iih.bl.st.blpaypatip.i.IBlpaypatipRService;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipRService;
import iih.bl.st.dto.d.BlIncIpEntHpInfoDTO;
import iih.bl.st.dto.d.BlStIpInccaInfoDTO;
import iih.bl.st.dto.d.BlStIpPayInvoceInfoDTO;
import iih.bl.st.dto.d.BlstipInvoiceHeadInfoDTO;
import iih.bl.st.utils.CapitalFiguresUtil;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.utils.StringUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.xapformula.vo.pub.formulaset.MoneyFormat;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获取发票票据信息
 * @author wq.li
 *
 */
public class PrintIncBP {

	/**
	 * 获取票据信息
	 * 
	 * @param incId
	 * @return
	 * @throws BizException
	 */
	public BlStIpPayInvoceInfoDTO exec(String stId) throws BizException {
		
		//查询发票数据
		IBlincipRService incService=ServiceFinder.find(IBlincipRService.class);
		BlincipAggDO[] incipAggDo = incService.findByAttrValString(BlIncIpDO.ID_STIP, stId);
		if (ArrayUtil.isEmpty(incipAggDo)) {
			throw new BizException("重打异常");
		}
		BlIncIpDO blIncIpDO = incipAggDo[0].getParentDO();

		// 2.查询相应的结算支付信息
		// 查询患者就诊信息
		IPativisitRService pativisitService = ServiceFinder.find(IPativisitRService.class);
		// PatiVisitDO entDO = pativisitService.findById(entId);
		PatiVisitDO entDO = pativisitService.findById(blIncIpDO.getId_ent());
		;

		// 结算项目明细数据
		BlStIpInccaInfoDTO[] bodyDTOArr = this.getBlStIpPayIncInfoBySt(blIncIpDO.getId_incip());
		if (ArrayUtil.isEmptyNoNull(bodyDTOArr)) {
			throw new BizException("结算项目明细数据为空！");
		}

		// 查询结算信息
		IBlstipRService blstipService = ServiceFinder.find(IBlstipRService.class);
		BlStIpDO blStIpDO = blstipService.findById(blIncIpDO.getId_stip());
		if (blStIpDO == null) {
			throw new BizException("该患者结算信息为空");
		}

		// 查询支付信息
		IBlpaypatipRService paypatipService = ServiceFinder.find(IBlpaypatipRService.class);
		BlpaypatipAggDO[] blPayPatIpAggDOs = paypatipService.find("id_stip='" + blIncIpDO.getId_stip() + "'", "",
				FBoolean.FALSE);
		if (blPayPatIpAggDOs == null || blPayPatIpAggDOs.length == 0) {
			throw new BizException("该患者结算支付信息为空");
		}
		BlpaypatipAggDO blPayPatIpAggDO = blPayPatIpAggDOs[0];
		// 支付明细
		BlPayItmPatIpDO[] blPayItmPatIpDO = blPayPatIpAggDO.getBlPayItmPatIpDO();
		// 查询患者用于支付的预交金信息
		List<String> paypatIdList = new ArrayList<>();
		for (BlPayItmPatIpDO itm : blPayItmPatIpDO) {
			if (IBdPripmCodeConst.ID_PRI_PM_PAY.equals(itm.getId_pm())) {
				paypatIdList.add(itm.getId_paypat());
			}
		}
		String strWhere = SqlUtils.arrayToStr(paypatIdList.toArray(new String[0]));
		IBlpaypatRService paypatService = ServiceFinder.find(IBlpaypatRService.class);
		BlPrePayPatDO[] blPrePayPatDOArr = paypatService.find("id_paypat in (" + strWhere + ")", "", FBoolean.FALSE);

		// 3.组装发票数据
		BlStIpPayInvoceInfoDTO blStIpPayInvoceInfoDTO = this.assemblePrintIpIncInfoBp(blStIpDO, entDO, blIncIpDO,
				blPayPatIpAggDO, blPrePayPatDOArr, bodyDTOArr);
		return blStIpPayInvoceInfoDTO;
	}

	/**
	 * 组装住院打印发票所需数据
	 * 
	 * @param blStIpDO
	 * @param entDO
	 * @param blIncIpDO
	 * @param blPayPatIpAggDO
	 * @param blPrePayPatDOArr
	 * @return
	 * @date 2018年6月23日
	 * @author wq.li
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private BlStIpPayInvoceInfoDTO assemblePrintIpIncInfoBp(BlStIpDO blStIpDO, PatiVisitDO entDO, BlIncIpDO blIncIpDO,
			BlpaypatipAggDO blPayPatIpAggDO, BlPrePayPatDO[] blPrePayPatDOArr, BlStIpInccaInfoDTO[] bodyDTOArr)
			throws BizException {

		BlStIpPayInvoceInfoDTO blStIpPayInvoceInfoDTO = null;

		IInpatientRService inpatientRService = ServiceFinder.find(IInpatientRService.class);
		InpatientDO[] inpatientDOArr = inpatientRService.find("id_ent='" + entDO.getId_ent() + "'", "", FBoolean.FALSE);
		if (ArrayUtil.isEmpty(inpatientDOArr)) {
			throw new BizException("就诊属性为空！");
		}
		BlstipInvoiceHeadInfoDTO headDTO = new BlstipInvoiceHeadInfoDTO();
		headDTO.setId_stip(blStIpDO.getId_stip());// 住院结算标识
		headDTO.setCode_st(blStIpDO.getCode_st());// 住院号EN_ENT.CODE
		headDTO.setCode_ent(entDO.getCode());// 业务流水号BL_ST_IP.CODE_ST
		String HospitalType = BlParams.BLHP000001();
		headDTO.setName_orgtp(HospitalType);// 医疗机构类型（暂空）
		headDTO.setName_pat(entDO.getName_pat());// 患者姓名EN_ENT.NAME_PAT
		headDTO.setSd_sex(entDO.getName_sex());// 患者性别EN_ENT.SD_SEX

		// 查询医保计划
		List<EntHpDO> entHpDO = (List<EntHpDO>) new DAFacade().findByAttrValString(EntHpDO.class, "Id_ent",
				entDO.getId_ent(), null);
		if (entHpDO != null && !StringUtil.isEmpty(entHpDO.get(0).getCode_hppatca())) {
			if ("21".equals(entHpDO.get(0).getCode_hppatca()) || "31".equals(entHpDO.get(0).getCode_hppatca())
					|| "11".equals(entHpDO.get(0).getCode_hppatca())) {
				headDTO.setName_hp("职工医疗"); // 医保类型 安徽医保：居民、职工
			} else {
				headDTO.setName_hp("居民医疗");
			}
			headDTO.setCode_hp(entHpDO.get(0).getNo_hp()); // 社会保障号码：个人编号
			headDTO.setCode_hppatca(entHpDO.get(0).getCode_hppatca());
		} else {
			headDTO.setName_hp("自费医疗");
			headDTO.setCode_hp(null);
		}
		headDTO.setAmt_cap(CapitalFiguresUtil.digitUppercase(blIncIpDO.getAmt().doubleValue()));// 合计（大写）
		headDTO.setAmt(blIncIpDO.getAmt());// 合计
		BlPayItmPatIpDO[] blPayItmPatIpDO = blPayPatIpAggDO.getBlPayItmPatIpDO();

		FDouble amt_hp = new FDouble(0);
		FDouble amt_psnacc = new FDouble(0);
		FDouble amt_self = new FDouble(0);
		FDouble amt_other = new FDouble(0);
		FDouble amt_pre = new FDouble(0); // 预交金金额
		// FDouble amt_fill = new FDouble(0); //补缴金额
		// FDouble amt_ret = new FDouble(0);

		// 应收
		if (!StringUtil.isEmpty(entDO.getId_hp())) {
			// 传患者分摊信息
			BlPropArIpDO propArDo = this.getPropArInfo(blStIpDO.getId_stip());
			if (propArDo != null) {
				amt_hp = propArDo.getAmt_hp() == null ? FDouble.ZERO_DBL : propArDo.getAmt_hp();
				amt_self = propArDo.getAmt_cash() == null ? FDouble.ZERO_DBL : propArDo.getAmt_cash();
				amt_psnacc = propArDo.getAmt_psnacc() == null ? FDouble.ZERO_DBL : propArDo.getAmt_psnacc();
				amt_other = propArDo.getAmt_all().sub(amt_hp).sub(amt_self).sub(amt_psnacc);
			}
		}

		FDouble amt_hp_pay = FDouble.ZERO_DBL;
		FDouble amt_other_pay = FDouble.ZERO_DBL;
		FDouble amt_psnacc_pay = FDouble.ZERO_DBL;

		// 收付款
		for (BlPayItmPatIpDO itm : blPayItmPatIpDO) {
			switch (itm.getSd_pm()) {
			case IBdPripmCodeConst.CODE_PRI_PM_INSUR: // 医保统筹支付
				amt_hp_pay = amt_hp_pay.add(itm.getAmt());
				break;
			case IBdPripmCodeConst.CODE_PRI_PM_INSURPERSONALACCOUNT: // 个人账户支付
				amt_psnacc_pay = amt_psnacc_pay.add(itm.getAmt());
				break;
			case IBdPripmCodeConst.CODE_PRI_PM_SERIOUSILL: // 大病支付
			case IBdPripmCodeConst.CODE_PRI_PM_BIGCIVILSERVICE: // 大额支付
			case IBdPripmCodeConst.CODE_PRI_PM_SALVAGE: // 救助金支付
			case IBdPripmCodeConst.CODE_PRI_PM_CIVILSERVICE: // 公务员补助支付
				amt_other_pay = amt_other_pay.add(itm.getAmt());
				break;
			case IBdPripmCodeConst.CODE_PRI_PM_PAY:
				amt_pre = amt_pre.add(itm.getAmt());
				break;
			case IBdPripmCodeConst.CODE_PRI_PM_HPPROFITLOSS:// 减免
				amt_hp_pay = amt_hp_pay.add(itm.getAmt());
				amt_hp = amt_hp.add(itm.getAmt());
			default:
				// 铜陵不使用这种算法
				// if (itm.getEu_direct() == 1)
				// amt_fill = amt_fill.add(itm.getAmt());
				// else
				// amt_ret = amt_ret.add(itm.getAmt());
				break;
			}
		}
		// 个人自付金额
		// amt_self =
		// blStIpDO.getAmt_ratio().sub(amt_psnacc).sub(amt_other).sub(amt_hp);//
		// .sub(amt_hp)
		headDTO.setAmt_cap(
				MoneyFormat.getChineseValue(String.valueOf(blIncIpDO.getAmt_ratio().doubleValue()), "simpchn"));// 合计（大写）
		headDTO.setAmt(blIncIpDO.getAmt_ratio());// 合计
		headDTO.setAmt_hp(amt_hp);// 医保统筹支付
		headDTO.setAmt_own_acc(amt_psnacc);// 个人账户支付
		headDTO.setAmt_hp_otr(amt_other);// 其它医保支付
		headDTO.setAmt_own(amt_self);// 个人支付
		// // 医保统筹支付金额
		// FDouble amt_hp = FDouble.ZERO_DBL;
		// if (!StringUtil.isEmpty(entDO.getId_hp())) {
		// // 传患者分摊信息
		// BlPropArIpDO propArDo=this.getPropArInfo(blStIpDO.getId_stip());
		// if(propArDo!=null){
		// amt_hp=propArDo.getAmt_hp();
		// }
		// }
		// headDTO.setAmt_hp(amt_hp);
		// // headDTO.setAmt_hp(null);// 医保统筹支付（暂空）
		// // headDTO.setAmt_own_acc(null);// 个人账户支付（暂空）
		// headDTO.setAmt_hp_otr(null);// 其它医保支付（暂空）
		// headDTO.setAmt_own(amt_self);// 个人支付（暂空）
		headDTO.setName_emp_inc(blIncIpDO.getName_emp_inc());// 收款人BL_INC_IP.ID_EMP_INC
		headDTO.setDt_inc(blIncIpDO.getDt_inc());// 收款日期BL_INC_IP.DT_INC
		headDTO.setIncno(blIncIpDO.getIncno());// 发票号码 BL_INC_IP.INCNO 只显示，不打印
		headDTO.setDt_acpt(entDO.getDt_acpt());// 入院时间EN_ENT.DT_ACPT
		headDTO.setDt_end(entDO.getDt_end() != null ? entDO.getDt_end() : blStIpDO.getDt_st());// 出院时间EN_ENT.DT_END
		// // 住院天数（BL_ST_IP.DT_END – BL_ST_IP.DT_START）
		// headDTO.setNum_day_ent(blStIpDO.getDt_end().getDaysAfter(blStIpDO.getDt_start()));
		if (entDO.getDt_end() == null) {
			int days = blStIpDO.getDt_end().getDaysAfter(blStIpDO.getDt_start());// 住院天数
			headDTO.setNum_day_ent(days == 0 ? 1 : days);
		} else if (entDO.getDt_end().compareTo(blStIpDO.getDt_end()) <= 0) {
			int days = entDO.getDt_end().getDaysAfter(blStIpDO.getDt_start());// 住院天数
			headDTO.setNum_day_ent(days == 0 ? 1 : days);
		} else {
			int days = blStIpDO.getDt_end().getDaysAfter(blStIpDO.getDt_start());// 住院天数
			headDTO.setNum_day_ent(days == 0 ? 1 : days);
		}
		headDTO.setMrno(inpatientDOArr[0].getCode_amr_ip());// 病历号（暂空）
		headDTO.setAmt_pre(amt_pre.setScale(-2, BigDecimal.ROUND_HALF_UP));// 预缴金额
		// 铜陵不使用
		// headDTO.setAmt_fill(amt_fill.setScale(-2,
		// BigDecimal.ROUND_HALF_UP));// 补缴金额
		// headDTO.setAmt_ret(amt_ret.setScale(-2, BigDecimal.ROUND_HALF_UP));//
		// 退费金额
		FDouble amt_result = blStIpDO.getAmt_ratio().sub(amt_pre).sub(amt_other_pay).sub(amt_psnacc_pay)
				.sub(amt_hp_pay);// .sub(amt_hp)
		if (amt_result.compareTo(new FDouble(0)) >= 0) {
			headDTO.setAmt_fill(amt_result.setScale(-2, BigDecimal.ROUND_HALF_UP)); // 补缴只补
																					// 差额，找零不计入补缴之内（铜陵）
			headDTO.setAmt_ret(new FDouble(0).setScale(-2, BigDecimal.ROUND_HALF_UP));
		} else {
			headDTO.setAmt_fill(new FDouble(0).setScale(-2, BigDecimal.ROUND_HALF_UP));
			headDTO.setAmt_ret(amt_result.setScale(-2, BigDecimal.ROUND_HALF_UP).multiply(new FDouble(-1)));
		}

		FArrayList invList = new FArrayList();
		for (BlStIpInccaInfoDTO info : bodyDTOArr) {
			invList.add(info);
		}

		// 结算明细
		IBlcgqueryService cgQueService = ServiceFinder.find(IBlcgqueryService.class);
		BlCgZyQueryDTO[] stHeadDTOArr = cgQueService.BlCgZyFindByQCond(" and d.id_ent = '" + blStIpDO.getId_ent() + "'",
				null, FBoolean.FALSE);
		if (ArrayUtil.isEmptyNoNull(stHeadDTOArr)) {
			throw new BizException("患者就诊信息不存在！");
		}
		// 获取本次结算对应的记账明细
		/*
		 * IBlcgqueryRService cgMRService =
		 * ServiceFinder.find(IBlcgqueryRService.class); BlCgIpDO[] blCgIpDOArr
		 * = cgMRService.find(" a0.id_stip = '" + blStIpDO.getId_stip() + "'",
		 * null, FBoolean.FALSE); if (ArrayUtil.isEmptyNoNull(blCgIpDOArr)) {
		 * throw new BizException("结算明细信息为空！"); } FArrayList blCgIpDOList = new
		 * FArrayList(); for (BlCgIpDO blCgIpDO : blCgIpDOArr) {
		 * blCgIpDOList.add(blCgIpDO); }
		 */

		// 查询收付款数据
		IBlpaypatipRService payService = ServiceFinder.find(IBlpaypatipRService.class);
		BlpaypatipAggDO[] payAggDos = payService.findByAttrValString(BlPayPatIpDO.ID_STIP, blStIpDO.getId_stip());

		FArrayList payList = new FArrayList();
		if (!ArrayUtil.isEmpty(payAggDos)) {
			for (BlPayItmPatIpDO payItmDO : payAggDos[0].getBlPayItmPatIpDO()) {
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

		blStIpPayInvoceInfoDTO = new BlStIpPayInvoceInfoDTO();
		blStIpPayInvoceInfoDTO.setHeadInfoDTO(headDTO);
		blStIpPayInvoceInfoDTO.setBodyInfoDTO(invList);
		blStIpPayInvoceInfoDTO.setStHeadInfoDTO(stHeadDTOArr[0]);
		// blStIpPayInvoceInfoDTO.setStBodyInfoArr(blCgIpDOList);
		blStIpPayInvoceInfoDTO.setBlInvoicePmDTOList(payList);
		return blStIpPayInvoceInfoDTO;
	}

	/**
	 * 查询患者的应付信息
	 * 
	 * @param stid
	 * @return
	 * @throws BizException
	 */
	private BlPropArIpDO getPropArInfo(String stid) throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append("select propar.* from bl_prop_ar_ip propar                        ");
		sql.append("inner join bl_prop_ip prop on prop.id_propip=propar.id_propip    ");
		sql.append("where prop.id_stip=?                                           ");
		SqlParam param = new SqlParam();
		param.addParam(stid);
		List<BlPropArIpDO> list = (List<BlPropArIpDO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(BlPropArIpDO.class));
		if (ListUtil.isEmpty(list)) {
			return null;
		}
		return list.get(0);

	}

	/**
	 * 获取就诊相关的医保计划信息
	 */
	@SuppressWarnings("unchecked")
	public List<BlIncIpEntHpInfoDTO> getBdHpInfoByIdEnt(String id_ent) throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append("select e.id_ent,e.fg_maj,b.code as code_hp,b.name as name_hp ");
		sql.append("from en_ent_hp e ");
		sql.append("left join bd_hp b on e.id_hp = b.id_hp ");
		sql.append("where e.id_ent = ? ");
		sql.append("order by b.code ");
		
		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(id_ent);
		List<BlIncIpEntHpInfoDTO> list = (List<BlIncIpEntHpInfoDTO>) new DAFacade().execQuery(sql.toString(),
				sqlparam,
				new BeanListHandler(BlIncIpEntHpInfoDTO.class));
		return list;
	}

	/**
	 * 获取预交金缴费金额
	 */
	public FDouble getPatPrePayAmt(BlPrePayPatDO[] blPrePayPatDOArr) throws BizException {

		FDouble amt = new FDouble();
		if (blPrePayPatDOArr != null && blPrePayPatDOArr.length > 0) {
			for (BlPrePayPatDO blPrePayPatDO : blPrePayPatDOArr) {
				if (blPrePayPatDO.getId_paypat() != null) {
					amt = amt.add(blPrePayPatDO.getAmt());
				}
			}
		}
		return amt;
	}

	/**
	 * 发票明细
	 */
	@SuppressWarnings("unchecked")
	public BlStIpInccaInfoDTO[] getBlStIpPayIncInfoBySt(String id_incip) throws BizException {
		StringBuffer sql = new StringBuffer();
		// 按新票据分类做的
		sql.append("select c.code as code_inccaitm,c.name as name_inccaitm, ");
		sql.append("  c.amt,c.amt_pat,c.amt_hp,c.amt_ratio,c.amt_std ");
		sql.append("from bl_inc_itm_ip c ");
		sql.append("where c.id_incip = ? ");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(id_incip);

		List<BlStIpInccaInfoDTO> list = (List<BlStIpInccaInfoDTO>) new DAFacade().execQuery(sql.toString(), sqlp,
				new BeanListHandler(BlStIpInccaInfoDTO.class));
		return list.toArray(new BlStIpInccaInfoDTO[] {});
	}

}
