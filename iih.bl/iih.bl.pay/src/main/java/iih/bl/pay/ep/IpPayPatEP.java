package iih.bl.pay.ep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.FDoubleUtils;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.i.IBlcgqueryCudService;
import iih.bl.cg.blcgquery.i.IBlcgqueryRService;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blincip.d.BlIncItmIpDO;
import iih.bl.inc.blincip.d.BlStIncIpDO;
import iih.bl.inc.blincoep.d.BlFreeMdEnum;
import iih.bl.inc.service.i.IBlincQryService;
import iih.bl.params.BlParams;
import iih.bl.params.BlParamsAnalysisUtil;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipRService;
import iih.bl.st.dto.d.BlStIpInccaInfoDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.xapformula.vo.pub.formulaset.MoneyFormat;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class IpPayPatEP {

	/**
	 * 根据结算id查询对应的结算记录数据
	 * 
	 * @param id_stip
	 * @return
	 * @throws BizException
	 */
	public BlStIpDO getSettleInfo(String id_stip) throws BizException {
		IBlstipRService stRService = ServiceFinder.find(IBlstipRService.class);
		BlStIpDO blStIpDO = stRService.findById(id_stip);
		if (null == blStIpDO)
			throw new BizException("未查询到对应的结算信息！");
		return blStIpDO;
	}
	/**
	 * 根据结算id查询对应的记账明细
	 * @param id_stip
	 * @return
	 * @throws BizException
	 */
	public BlCgIpDO[] getCgIpDOs(String id_stip) throws BizException {
		IBlcgqueryRService cgRService = ServiceFinder.find(IBlcgqueryRService.class);
		BlCgIpDO[] blCgIpDOArr = cgRService.find(" a0.id_stip = '" + id_stip + "'", null, FBoolean.FALSE);
		if (ArrayUtil.isEmptyNoNull(blCgIpDOArr)) {
			throw new BizException("未查询到结算对应的记账明细！");
		}
		return blCgIpDOArr;
	}
	
	/**
	 * 保存记账明细
	 * @param arr
	 * @return
	 * @throws BizException
	 */
	public BlCgIpDO[] saveCgIpDOs(BlCgIpDO[] arr) throws BizException {
		IBlcgqueryCudService cgCService = ServiceFinder.find(IBlcgqueryCudService.class);
		BlCgIpDO[] savedCgIpDOs = cgCService.save(arr);
		if(ArrayUtil.isEmptyNoNull(savedCgIpDOs)) {
			throw new BizException("保存记账明细失败！");
		}
		return savedCgIpDOs;
	}
	/**
	 * 获取就诊信息
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public PatiVisitDO getEntInfoDo(String id_ent) throws BizException {
		IPativisitRService entService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO = entService.findById(id_ent);
		return patiVisitDO;
	}
	
	/**
	 * 更新为下一张票号
	 * 
	 * @param id_emp
	 * @param billType
	 * @throws BizException
	 */
	/*public void updateNextBillNo(String id_emp,String billType) throws BizException {
		IBLInvoiceService incService = (IBLInvoiceService) ServiceFinder.find(IBLInvoiceService.class);
		incService.NextInvoiceNoUpdateCurNo(id_emp, billType);
	}*/
	/**
	 * 组装发票明细信息
	 * @param reductionDoArr 项目减免数据
	 * @param id_incip	发票主表id
	 * @param eu_free	减免类型
	 * @param id_stip	对应结算id
	 * @param amt_free	金额减所对应减免金额
	 * @throws BizException
	 */
	public BlIncItmIpDO[] setIncItmInfo(BlCgIpDO[] reductionDoArr,  int eu_free,String id_stip, FDouble amt_free) throws BizException {
		List<BlIncItmIpDO> incItmList = new ArrayList<BlIncItmIpDO>();
		//1.根据结算获取费用账单分组合计信息
		BlCgIpDO[] cgFeeInccaDoArr = this.getCgFeeInccaInfo(id_stip);
		if (ArrayUtil.isEmptyNoNull(cgFeeInccaDoArr)) {
			throw new BizException("未查询本次结算对应的账单项信息！");
		}
		//2.根据减免的算法进行分摊到账单项上（金额减免平摊，项目减免指定分摊）
		Map<String, FDouble> map = new HashMap<String, FDouble>(); 
		if(BlFreeMdEnum.AMT_FREE_MD == eu_free) { //金额减免
			 map = this.getBlCgIpAmtFree(id_stip, amt_free);
		} else if (BlFreeMdEnum.ITM_FREE_MD == eu_free || BlFreeMdEnum.HP_SELF_FREE == eu_free || BlFreeMdEnum.ITM_AND_HP_SELF== eu_free) { //项目减免、医保自付减免，项目减免+医保自付减免
			 map = this.getItmAmtFree(reductionDoArr);
		}
		
		for (BlCgIpDO cgFeeInccaDo : cgFeeInccaDoArr) {
			BlIncItmIpDO incItmIpDO = new BlIncItmIpDO();
			incItmIpDO.setId_incitmip(null);
			incItmIpDO.setId_incip(null);
			incItmIpDO.setCode(cgFeeInccaDo.getCode_inccaitm());// 项目编码(BD_INCCA_ITM.CODE)
			incItmIpDO.setName(cgFeeInccaDo.getName_inccaitm());// 项目名称(BD_INCCA_ITM.NAME)
			FDouble amtFree = FDouble.ZERO_DBL;
			if (BlFreeMdEnum.AMT_FREE_MD == eu_free || BlFreeMdEnum.ITM_FREE_MD == eu_free || BlFreeMdEnum.HP_SELF_FREE == eu_free || BlFreeMdEnum.ITM_AND_HP_SELF== eu_free) {// 金额减免				
				if (map.get(cgFeeInccaDo.getCode_inccaitm()) != null) {
					amtFree = map.get(cgFeeInccaDo.getCode_inccaitm());
				}
				incItmIpDO.setAmt_free(amtFree);
				incItmIpDO.setAmt(cgFeeInccaDo.getAmt().sub(amtFree));// 金额(项目所关联的全部费用的金额合计SUM(AMT))
				incItmIpDO.setAmt_pat(cgFeeInccaDo.getAmt().sub(amtFree));// 金额_患者自付(项目所关联的全部费用的金额_患者自付合计SUM(AMT_PAT))				
			} else {
				incItmIpDO.setAmt_free(amtFree);
				incItmIpDO.setAmt(cgFeeInccaDo.getAmt());// 金额(项目所关联的全部费用的金额合计SUM(AMT))
				incItmIpDO.setAmt_pat(cgFeeInccaDo.getAmt_pat());// 金额_患者自付(项目所关联的全部费用的金额_患者自付合计SUM(AMT_PAT))
			}
			incItmIpDO.setAmt_hp(cgFeeInccaDo.getAmt_hp());
			incItmIpDO.setAmt_ratio(cgFeeInccaDo.getAmt_ratio());
			incItmIpDO.setAmt_std(cgFeeInccaDo.getAmt_std());
			incItmIpDO.setStatus(DOStatus.NEW);
			incItmList.add(incItmIpDO);
		}
		//3.返回发票明细		
		return incItmList.toArray(new BlIncItmIpDO[]{});
	}
	
	
	/**
	 * 组装住院结算与发票的关系信息
	 * @param id_stip	结算id
	 * @param id_incip	发票表id
	 * @throws BizException
	 */
	public BlStIncIpDO[] setStIncInfo(String id_stip) throws BizException {	
		BlStIncIpDO blStIncIpDO = new BlStIncIpDO();
		blStIncIpDO.setId_stip(id_stip);
		blStIncIpDO.setId_incip(null);
		blStIncIpDO.setFg_active(FBoolean.TRUE);
		blStIncIpDO.setStatus(DOStatus.NEW);	
		return new BlStIncIpDO[]{blStIncIpDO};
	}
	/**
	 * 组装住院发票主表数据
	 * @param operator
	 * @param stIpDO
	 * @param reductionDoArr
	 * @param amt_free
	 * @param incno
	 * @param eu_free
	 * @param isPrint
	 * @return
	 * @throws BizException
	 */
	public BlIncIpDO setIncIpDo(OperatorInfoDTO operator, BlStIpDO stIpDO, BlCgIpDO[] reductionDoArr, FDouble amt_free,
			String incno, int eu_free, FBoolean isPrint) throws BizException {
		BlIncIpDO incIpDo = setIncIpDo(operator, stIpDO, amt_free, incno, eu_free, isPrint);
		FDouble amtPat = FDouble.ZERO_DBL;
		FDouble amtHpSelf = FDouble.ZERO_DBL;
		if(reductionDoArr != null && reductionDoArr.length >0){
			for(BlCgIpDO itm:reductionDoArr){
				if(itm.getAmt_pat_free() != null ){
					amtPat = amtPat.add(itm.getAmt_pat_free());
				}
				if(itm.getAmt_hp_free() != null ){
					amtHpSelf = amtHpSelf.add(itm.getAmt_hp_free());
				}
			}
		}
		incIpDo.setAmt_hp_free(amtHpSelf);
		incIpDo.setAmt_pat_free(amtPat);
		return incIpDo;
	}
	/**
	 * 组装住院发票主表数据
	 * @param operator
	 * @param stIpDO
	 * @param amt_free
	 * @param incno
	 * @param eu_free
	 * @return
	 * @throws BizException
	 */
	public BlIncIpDO setIncIpDo(OperatorInfoDTO operator,BlStIpDO stIpDO,FDouble amt_free,String incno,int eu_free,FBoolean isPrint) throws BizException {

		IBlincQryService incQService = ServiceFinder.find(IBlincQryService.class);
		FDouble amt_pay = stIpDO.getAmt().sub(amt_free);
	
		String idPc = BlParams.getRealPcId(Context.get().getClientHost());
		String BLINC0038 = BlParams.BLINC0038();
		FBoolean isPrintByPatca = FBoolean.TRUE;
		PatiVisitDO entDo = this.getEntInfoDo(stIpDO.getId_ent());
		String idPatCa = entDo.getId_patca();
		if(StringUtils.isNotBlank(BLINC0038) && StringUtils.isNotBlank(idPatCa) && BLINC0038.contains(idPatCa)){
			isPrintByPatca = FBoolean.FALSE;
			isPrint = FBoolean.FALSE;
		}
		// 住院发票
		BlIncIpDO blIncIpDO = new BlIncIpDO();
		blIncIpDO.setId_incip(null);
		blIncIpDO.setId_org(operator.getId_org());
		blIncIpDO.setId_grp(operator.getId_grp());
		blIncIpDO.setId_pat(stIpDO.getId_pat());
		blIncIpDO.setId_ent(stIpDO.getId_ent());
		blIncIpDO.setId_enttp(stIpDO.getId_enttp());
		blIncIpDO.setCode_enttp(stIpDO.getCode_enttp());
		blIncIpDO.setEu_direct(BookRtnDirectEnum.CHARGE);
		blIncIpDO.setId_incca(IBdInccaCodeConst.ID_INHOS_INVOICE);
		
		// 判断是否开启电子发票
		FBoolean fgEcInc = BlParamsAnalysisUtil.BLINC0029(IBdInccaCodeConst.ID_INHOS_INVOICE);
		blIncIpDO.setFg_ec_inc(fgEcInc);
		if(FBoolean.TRUE.equals(isPrint) && FBoolean.FALSE.equals(fgEcInc))//添加不打印发票的模式
		{
			// 票据包编号
			String codeIncPkg = incQService.getCodeIncPkgByIdempiss(operator.getId_org(), operator.getId_emp(), IBdInccaCodeConst.ID_INHOS_INVOICE);
			blIncIpDO.setCode_incpkg(codeIncPkg);
			//费用全部减免时，不写发票号，也就是不打印发票
			if (amt_pay.doubleValue() > 0 || FBoolean.TRUE.equals(BlParams.BLSTIP0006())) {
				blIncIpDO.setIncno(incno);// 发票号码
			}
		}
		FDateTime dateTime = AppUtils.getServerDateTime();
		blIncIpDO.setDt_inc(dateTime);
		if(eu_free != 0 && !FDoubleUtils.isNullOrZero(amt_free)) {
			blIncIpDO.setEu_freemd(eu_free);
			blIncIpDO.setAmt_free(amt_free);
		}

		//inc表amt与收付款表amt与记账表中总金额保持一致，防止与分摊表中总金额不一致  by liwq 2017-10-12 19:03:48
		blIncIpDO.setAmt(stIpDO.getAmt());// 总金额_患者需付
		blIncIpDO.setAmt_pat(stIpDO.getAmt_pat());// 总金额_患者自付
		blIncIpDO.setAmt_hp(stIpDO.getAmt_hp());// 总金额_医保
		blIncIpDO.setAmt_std(stIpDO.getAmt_std());// 总金额
		blIncIpDO.setAmt_ratio(stIpDO.getAmt_ratio());// 金额_价格比例
		String amtCapital = MoneyFormat.getChineseValue(String.valueOf(stIpDO.getAmt_ratio().doubleValue()), "simpchn");
		blIncIpDO.setNote(amtCapital);// 发票金额描述信息(总金额的大写)
		blIncIpDO.setId_emp_inc(operator.getId_emp());
		blIncIpDO.setTimes_prn(1);
		blIncIpDO.setFg_canc(FBoolean.FALSE);
		blIncIpDO.setId_stip(stIpDO.getId_stip());
		blIncIpDO.setStatus(DOStatus.NEW);
		blIncIpDO.setFg_print(FBoolean.TRUE);
		blIncIpDO.setFg_cc_out(FBoolean.FALSE);
		blIncIpDO.setFg_cc_in(FBoolean.FALSE);
		blIncIpDO.setStatus(DOStatus.NEW);
		blIncIpDO.setId_pc(idPc);
		
		if(isPrintByPatca == FBoolean.FALSE || FBoolean.FALSE.equals(isPrint)){
			blIncIpDO.setDt_inc(null);
			blIncIpDO.setId_emp_inc(null);
			blIncIpDO.setId_dep_inc(null);
			blIncIpDO.setTimes_prn(0);
			blIncIpDO.setFg_print(FBoolean.FALSE);
		}
		
		return blIncIpDO;
	}
	/**
	 * 项目减免 （按照账单项分组合计金额）
	 * 
	 * @param reductionDoArr
	 * @return
	 */
	private Map<String, FDouble> getItmAmtFree(BlCgIpDO[] reductionDoArr) {		
		Map<String, FDouble> map = new HashMap<String, FDouble>();
		for (BlCgIpDO blCgIpDO : reductionDoArr) {
			FDouble itmFreeAmt = map.get(blCgIpDO.getCode_inccaitm());
			FDouble amtFree = getAmtFree(blCgIpDO);
			if ( itmFreeAmt == null) {
				map.put(blCgIpDO.getCode_inccaitm(), amtFree);
			} else {				
				map.put(blCgIpDO.getCode_inccaitm(), itmFreeAmt.add(amtFree));
			}
		}
		return map;
	}
	
	//获取减免金额
	private FDouble getAmtFree(BlCgIpDO blCgIpDO){
		FDouble amtFree = FDouble.ZERO_DBL;
		if(blCgIpDO.getAmt_pat_free() != null){
			amtFree = amtFree.add(blCgIpDO.getAmt_pat_free());
		}
		if(blCgIpDO.getAmt_hp_free() != null){
			amtFree = amtFree.add(blCgIpDO.getAmt_hp_free());
		}
		return amtFree;
	}
	
	/**
	 * 金额减免算法
	 * 
	 * @throws BizException
	 * */
	public Map<String, FDouble> getBlCgIpAmtFree(String id_stip, FDouble amt_free) throws BizException {
		Map<String, FDouble> map = new HashMap<String, FDouble>();
		if (FDoubleUtils.isNullOrZero(amt_free)) {
			return map;
		}
		//本次结算所有记账明细对应的账单项信息
		BlCgIpDO[] cgIpDOArr = this.getCgFeeInccaInfo(id_stip);
		if (ArrayUtil.isEmptyNoNull(cgIpDOArr)) {
			return map;
		}
		//合计金额
		FDouble amt = FDouble.ZERO_DBL;			
		for (BlCgIpDO blCgIpDO : cgIpDOArr) {
			amt = amt.add(blCgIpDO.getAmt());
		}
		//减免金额平摊
//		for (BlCgIpDO blCgIpDO : cgIpDOArr) {
//			FDouble amtFree = map.get(blCgIpDO.getCode_inccaitm());
//			if ( amtFree == null) {
//				map.put(blCgIpDO.getCode_inccaitm(), amt_free.multiply(blCgIpDO.getAmt().div(amt)));
//			} else {				
//				map.put(blCgIpDO.getCode_inccaitm(), amtFree.add(amt_free.multiply(blCgIpDO.getAmt().div(amt))));
//			}
//			amt_free = amt_free.sub(amt_free.multiply(blCgIpDO.getAmt().div(amt)));
//			amt = amt.sub(blCgIpDO.getAmt());
//		}

		//已经分摊的减免和
		FDouble sum_free=FDouble.ZERO_DBL;
		
		for(int i=0;i<cgIpDOArr.length;i++)
		{
			BlCgIpDO blCgIpDO=cgIpDOArr[i];
			//该明细的减免金额
			FDouble itm_free=FDouble.ZERO_DBL;
			
			if(i==cgIpDOArr.length-1)
			{
				itm_free=amt_free.sub(sum_free);
			}else
			{
				itm_free=amt_free.multiply(blCgIpDO.getAmt().div(amt));
			}
			sum_free=sum_free.add(itm_free);
			FDouble amtFree = map.get(blCgIpDO.getCode_inccaitm());
			if ( amtFree == null) {
				map.put(blCgIpDO.getCode_inccaitm(), itm_free);
			} else {				
				map.put(blCgIpDO.getCode_inccaitm(), amtFree.add(itm_free));
			}
		}
		
		return map;
	}
	/**
	 * 根据结算获取账单信息
	 * 
	 * @param id_stip
	 *            结算id
	 * @return BlCgIpDO[] 账单信息
	 * @throws BizException
	 * */
	@SuppressWarnings("unchecked")
	public BlCgIpDO[] getCgFeeInccaInfo(String id_stip) throws BizException {
		StringBuilder sql = new StringBuilder();
		// 按新票据分类做的	
		sql.append("   SELECT    X.CODE_INCCAITM, ");
		sql.append("         NVL(X.NAME_INCCAITM, '未知') as NAME_INCCAITM, ");
		sql.append("         SUM(X.EU_DIRECT * X.Quan) Quan, ");
		sql.append("         SUM(X.EU_DIRECT * X.AMT) AS AMT, ");
		sql.append("         SUM(X.EU_DIRECT * X.AMT_HP) AMT_HP, ");
		sql.append("         SUM(X.EU_DIRECT * X.AMT_STD) AMT_STD, ");
		sql.append("         SUM(X.EU_DIRECT * X.AMT_PAT) AMT_PAT, ");
		sql.append("         SUM(X.EU_DIRECT * X.AMT_RATIO) AMT_RATIO ");
		sql.append("    FROM BL_CG_IP X ");
		sql.append("   WHERE X.ID_STIP = ? ");
		sql.append("   GROUP BY X.CODE_INCCAITM, X.NAME_INCCAITM ");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(id_stip);

		List<BlCgIpDO> list = (List<BlCgIpDO>) new DAFacade().execQuery(sql.toString(), sqlp, new BeanListHandler(BlCgIpDO.class));
		return list.toArray(new BlCgIpDO[] {});
	}

	/**
	 * 发票明细
	 * */
	@SuppressWarnings("unchecked")
	public BlStIpInccaInfoDTO[] getBlStIpPayIncInfoBySt(String id_incip) throws BizException {
		StringBuffer sql = new StringBuffer();
		// 按新票据分类做的
		sql.append("select c.code as code_inccaitm,c.name as name_inccaitm, ").append("c.amt,c.amt_pat,c.amt_hp,c.amt_ratio,c.amt_std ").append("from bl_inc_itm_ip c ")
				.append("where c.id_incip = ? ");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(id_incip);

		List<BlStIpInccaInfoDTO> list = (List<BlStIpInccaInfoDTO>) new DAFacade().execQuery(sql.toString(), sqlp, new BeanListHandler(BlStIpInccaInfoDTO.class));
		return list.toArray(new BlStIpInccaInfoDTO[] {});
	}	
	
}
