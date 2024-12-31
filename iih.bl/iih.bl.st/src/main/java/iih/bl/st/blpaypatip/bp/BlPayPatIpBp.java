package iih.bl.st.blpaypatip.bp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.base.utils.StringUtils;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.pripat.d.PripatAggDO;
import iih.bd.pp.pripat.i.IPripatRService;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.i.IBlcgqueryCudService;
import iih.bl.cg.blcgquery.i.IBlcgqueryRService;
import iih.bl.cg.blcgzyquerydto.d.BlCgZyQueryDTO;
import iih.bl.cg.service.IBlcgqueryService;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.comm.GetCodeByCustomization;
import iih.bl.comm.util.BlBaseInfoUtils;
import iih.bl.inc.blincip.d.BlIncIpDO;
import iih.bl.inc.blincip.d.BlIncItmIpDO;
import iih.bl.inc.blincip.d.BlStIncIpDO;
import iih.bl.inc.blincip.d.BlincipAggDO;
import iih.bl.inc.blincip.i.IBlincipCudService;
import iih.bl.inc.blincip.i.IBlincipMDORService;
import iih.bl.inc.blincip.i.IBlincipRService;
import iih.bl.inc.blincoep.d.BlFreeMdEnum;
import iih.bl.inc.blincquerydto.d.BlInvoicePmDTO;
import iih.bl.inc.i.IBlIncUtilService;
import iih.bl.inc.i.IBlIncValidateService;
import iih.bl.inc.service.i.IBLInvoiceService;
//import iih.bl.inc.blinciss.Service.i.IBLInvoiceService;
import iih.bl.inc.service.i.IBlincQryService;
import iih.bl.params.BlParams;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;
import iih.bl.pay.blpaypat.i.IBlpaypatRService;
import iih.bl.pay.dto.d.BlBannerDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySTDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.i.IBlPrepayCmdService;
import iih.bl.prop.blproparip.d.BlPropArIpDO;
import iih.bl.prop.blproparip.d.BlproparipAggDO;
import iih.bl.prop.blpropip.d.BlPropIpDO;
import iih.bl.prop.i.IBlPropCmdService;
import iih.bl.prop.i.IBlPropQryService;
import iih.bl.pub.dto.d.BlEventInfoDTO;
import iih.bl.st.blpaypatip.d.BlPayItmPatIpDO;
import iih.bl.st.blpaypatip.d.BlPayPatIpDO;
import iih.bl.st.blpaypatip.d.BlpaypatipAggDO;
import iih.bl.st.blpaypatip.i.IBlpaypatipCudService;
import iih.bl.st.blpaypatip.i.IBlpaypatipRService;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipCudService;
import iih.bl.st.blstip.i.IBlstipRService;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.bl.st.dto.d.BlIncIpEntHpInfoDTO;
import iih.bl.st.dto.d.BlStIpInccaInfoDTO;
import iih.bl.st.dto.d.BlStIpInccanoDTO;
import iih.bl.st.dto.d.BlStIpPayInvoceInfoDTO;
import iih.bl.st.dto.d.BlstipInvoiceHeadInfoDTO;
import iih.bl.st.ep.IpStEP;
import iih.bl.st.listrener.event.BlStIpEvent;
import iih.bl.st.s.bp.ip.BackPayReDoStBp;
import iih.en.pv.i.IEnOutCmdService;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.out.bl.d.EnMomBabyInfoDTO;
import iih.en.pv.out.i.IEn4BlQryService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.mi.biz.dto.d.HisPropertyRefHpDTO;
import iih.mi.biz.dto.d.MiFlowType;
import iih.mi.biz.insureprop.ruraltmp.d.HpPropDirectEnum;
import iih.mi.biz.insureprop.ruraltmp.d.MiHpPropRuralIpTmpDO;
import iih.mi.biz.insureprop.ruraltmp.i.IMihppropruraliptmpCudService;
import iih.mi.biz.insureprop.ruraltmp.i.IMihppropruraliptmpRService;
import iih.mi.itf.context.InsureContext;
import iih.mi.itf.facade.InsureFacade;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.appfw.xapformula.vo.pub.formulaset.MoneyFormat;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * *住院结算收款/退费
 * 
 * @author liwq
 */
public class BlPayPatIpBp {

	/**
	 * 获取就诊对应的未付款结算
	 * */
	public BlStIpDO getBlStIpByIdEnt(String id_ent) throws BizException {
		// 获取结算
		IBlstipRService stService = ServiceFinder.find(IBlstipRService.class);
		StringBuffer sqlQue = new StringBuffer();
		sqlQue.append(" a0.id_ent = '").append(id_ent).append("' and a0.fg_pay = 'N' ");
		BlStIpDO[] blStIpDOArr = stService.find(sqlQue.toString(), null, FBoolean.FALSE);
		if (blStIpDOArr == null || blStIpDOArr.length == 0) {
			return null;
		}
		return blStIpDOArr[0];
	}

	/**
	 * 根据就诊获取结算账单信息
	 * 
	 * @throws BizException
	 * */
	public BlStIpInccaInfoDTO[] getBdInccaInfoByIdEnt(String id_ent) throws BizException {
		// 获取结算
		IBlstipRService stService = ServiceFinder.find(IBlstipRService.class);
		StringBuffer sqlQue = new StringBuffer();
		sqlQue.append(" a0.id_ent = '").append(id_ent).append("' and a0.fg_pay = 'N' ");
		BlStIpDO[] blStIpDOArr = stService.find(sqlQue.toString(), null, FBoolean.FALSE);
		if (blStIpDOArr == null || blStIpDOArr.length == 0) {
			return null;
		}
		// 获取结算账单
		BlStIpInccaInfoDTO[] incArr = getBdInccaInfoByIdStIp(blStIpDOArr[0].getId_stip());
		return incArr;
	}

	/**
	 * 根据结算获取账单信息
	 * 
	 * @param id_stip
	 *            结算id
	 * @return BlStIpInccaInfoDTO[] 账单信息
	 * @throws BizException
	 * */
	@SuppressWarnings("unchecked")
	public BlStIpInccaInfoDTO[] getBdInccaInfoByIdStIp(String id_stip) throws BizException {
		StringBuffer sql = new StringBuffer();
		// 按新票据分类做的
		sql.append("  SELECT Z.ID_INCCAITM, ");
		sql.append("         Z.CODE_INCCAITM, ");
		sql.append("         NVL(Z.NAME_INCCAITM, '未知') as NAME_INCCAITM, ");
		sql.append("         SUM(X.EU_DIRECT * X.Quan) Quan, ");
		sql.append("         SUM(X.EU_DIRECT * X.AMT) AS AMT, ");
		sql.append("         SUM(X.EU_DIRECT * X.AMT_HP) AMT_HP, ");
		sql.append("         SUM(X.EU_DIRECT * X.AMT_STD) AMT_STD, ");
		sql.append("         SUM(X.EU_DIRECT * X.AMT_PAT) AMT_PAT, ");
		sql.append("         SUM(X.EU_DIRECT * X.AMT_RATIO) AMT_RATIO ");
		sql.append("    FROM BL_CG_IP X ");
		sql.append("    LEFT JOIN (SELECT distinct B.ID_INCCAITM, ");
		sql.append("                               B.NAME        AS NAME_INCCAITM, ");
		sql.append("                               B.CODE        AS CODE_INCCAITM, ");
		sql.append("                               C.ID_SRV ");
		sql.append("                 FROM BD_INCCA_ITM B ");
		sql.append("                 JOIN BD_INCCA_ITM_REL C ");
		sql.append("                   ON B.ID_INCCAITM = C.ID_INCCAITM ");
		sql.append("                WHERE c.ID_INCCA = ?) Z ");
		sql.append("      ON X.ID_SRV = Z.ID_SRV  ");
		sql.append("   WHERE X.ID_STIP = ? ");
		sql.append("   GROUP BY Z.ID_INCCAITM, Z.CODE_INCCAITM, Z.NAME_INCCAITM ");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(IBdInccaCodeConst.ID_INHOS_INVOICE);
		sqlp.addParam(id_stip);

		List<BlStIpInccaInfoDTO> list = (List<BlStIpInccaInfoDTO>) new DAFacade().execQuery(sql.toString(), sqlp, new BeanListHandler(BlStIpInccaInfoDTO.class));
		return list.toArray(new BlStIpInccaInfoDTO[] {});
	}

	/**
	 * 获取当前住院发票号和住院押金条号
	 * */
	public BlStIpInccanoDTO getBlStIpInccaNos(String id_psndoc) throws BizException {
		BlStIpInccanoDTO blStIpInccanoDTO = new BlStIpInccanoDTO();
		// 获取票据编码
		IBLInvoiceService incService = (IBLInvoiceService) ServiceFinder.find(IBLInvoiceService.class);
		blStIpInccanoDTO.setIncno(incService.GetInvoiceNo(id_psndoc, IBdInccaCodeConst.CODE_INHOS_INVOICE));
		blStIpInccanoDTO.setPayno(incService.GetInvoiceNo(id_psndoc, IBdInccaCodeConst.CODE_INHOS_DEPOSIT));
		return blStIpInccanoDTO;
	}

	/**
	 * 获取就诊对应的价格系数
	 * */
	public FDouble getPatRateByIdEnt(String id_ent) throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append("select b.rate ").append("from en_ent e ").append("left join bd_pri_pat b on e.id_pripat = b.id_pripat ").append("where e.id_ent = '").append(id_ent).append("' ");
		BigDecimal discount = (BigDecimal) new DAFacade().execQuery(sql.toString(), new ColumnHandler());
		if (discount == null) {
			throw new BizException("就诊对应的价格分类不存在！");
		}
		return new FDouble(discount);
	}

	/**
	 * 收付款
	 * 
	 * @param isArrears
	 *            是否欠费结算
	 * @param blPrePayPatDOArr
	 *            使用预交金
	 * @param blPayItmPatIpDOArr
	 *            付费明细
	 * @throws BizException
	 * */
	public BlStIpPayInvoceInfoDTO doStPayment(OperatorInfoDTO operatorInfoDTO, BlPayPatIpDO blPayPatIpDO, BlPrePayPatDO[] blPrePayPatDOArr, BlPayItmPatIpDO[] blPayItmPatIpDOArr,
			BlCgIpDO[] blCgIpDOArr, String incno, String payno, FBoolean isArrears, FBoolean isCarryover, String sd_pttp) throws BizException {
		// 验证住院发票号和住院押金条号是否可用
		IBLInvoiceService incService = (IBLInvoiceService) ServiceFinder.find(IBLInvoiceService.class);
		String code_incno = incService.GetInvoiceNo(operatorInfoDTO.getId_emp(), IBdInccaCodeConst.CODE_INHOS_INVOICE);
		if (code_incno == null || code_incno == "") {
			throw new BizException("当前住院发票号码已被他人修改，请刷新界面，重做业务！");
		}
		if (incno != null && !incno.endsWith(code_incno)) {
			throw new BizException("当前住院发票号码已被他人修改，请刷新界面，重做业务！");
		}
		String code_payno = incService.GetInvoiceNo(operatorInfoDTO.getId_emp(), IBdInccaCodeConst.CODE_INHOS_DEPOSIT);
		if (code_payno == null || code_payno == "") {
			throw new BizException("当前住院押金条号码已被他人修改，请刷新界面，重做业务！");
		}
		if (payno != null && !payno.endsWith(code_payno)) {
			throw new BizException("当前住院押金条号码已被他人修改，请刷新界面，重做业务！");
		}
		// 获取结算信息
		IBlstipRService stRService = ServiceFinder.find(IBlstipRService.class);
		BlStIpDO blStIpDO = stRService.findById(blPayPatIpDO.getId_stip());
		if (null == blStIpDO)
			throw new BizException("对应的结算已经被取消！");

		// 获取就诊信息
		IPativisitRService entService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO = entService.findById(blPayPatIpDO.getId_ent());

		// 患者价格分类(获取就诊价格系数)
		IPripatRService priRService = ServiceFinder.find(IPripatRService.class);
		PripatAggDO priPatAggDO = priRService.findById(patiVisitDO.getId_pripat());

		// 获取当前服务器时间
		TimeService timeService = new TimeServiceImpl();
		FDateTime dateTime = timeService.getUFDateTime();

		// 判断减免
		int eu_free = BlFreeMdEnum.AMT_FREE_MD;
		FDouble amt_free = new FDouble("0");
		// this.checkFree(blPayItmPatIpDOArr, eu_free, amt_free);
		for (BlPayItmPatIpDO blPayItmPatIpDO : blPayItmPatIpDOArr) {
			if (IBdPripmCodeConst.ID_PRI_PM_MONEYDEDUCTION.equals(blPayItmPatIpDO.getId_pm())) {// 金额减免
				eu_free = BlFreeMdEnum.AMT_FREE_MD;
				amt_free = blPayItmPatIpDO.getAmt();
			} else if (IBdPripmCodeConst.ID_PRI_PM_SRVDEDUCTION.equals(blPayItmPatIpDO.getId_pm())) {// 项目减免
				eu_free = BlFreeMdEnum.ITM_FREE_MD;
				amt_free = blPayItmPatIpDO.getAmt();
			}
		}

		// 住院发票记录
		BlincipAggDO blincipAggDO = this.setInccaInfo(operatorInfoDTO, blStIpDO, incno, dateTime, priPatAggDO.getParentDO().getRate(), blCgIpDOArr, eu_free, amt_free);

		// 结算收付款记录
		BlpaypatipAggDO blPayPatIpAggDO = this.setBlStIpPayInfo(operatorInfoDTO, blStIpDO, blPayPatIpDO, blPayItmPatIpDOArr, priPatAggDO.getParentDO().getRate(), dateTime);

		// 修改结算数据
		this.updateBlStIpInfo(blStIpDO, blPayPatIpDO, blPayPatIpAggDO.getParentDO().getId_paypatip(), priPatAggDO.getParentDO().getRate(), isArrears, isCarryover);

		// 修改预交金数据
		this.setBlPrePayInfo(operatorInfoDTO, blPayPatIpAggDO, blPrePayPatDOArr, blStIpDO, dateTime, sd_pttp);

		// 修改就诊账户数据
		this.updateEnAccountInfo(blPayPatIpDO.getId_ent(), blPrePayPatDOArr, isArrears, blStIpDO, priPatAggDO.getParentDO().getRate());

		// 修改记账数据
		this.updateBlCgIpInfo(blCgIpDOArr);

		// 组装发票数据
		BlStIpPayInvoceInfoDTO invoceDTO = this.setBlStIpPayInncaInfo(blStIpDO, blincipAggDO.getParentDO().getId_incip(), dateTime);

		// 发送事件
		this.invokePayEvent(patiVisitDO, blStIpDO, blPayPatIpAggDO, blincipAggDO);

		return invoceDTO;
	}

	/**
	 * 判断金额减免/项目减免
	 * 
	 * @param 减免标志
	 *            0:不减免;1:金额减免;2:项目减免
	 * @param 减免金额
	 * @author weijia
	 * */
	public void checkFree(BlPayItmPatIpDO[] blPayItmPatIpDOArr, int eu_free, FDouble amt_free) {
		for (BlPayItmPatIpDO blPayItmPatIpDO : blPayItmPatIpDOArr) {
			if (IBdPripmCodeConst.ID_PRI_PM_MONEYDEDUCTION.equals(blPayItmPatIpDO.getId_pm())) {// 金额减免
				eu_free = BlFreeMdEnum.AMT_FREE_MD;
				amt_free = blPayItmPatIpDO.getAmt();
			} else if (IBdPripmCodeConst.ID_PRI_PM_SRVDEDUCTION.equals(blPayItmPatIpDO.getId_pm())) {// 项目减免
				eu_free = BlFreeMdEnum.ITM_FREE_MD;
				amt_free = blPayItmPatIpDO.getAmt();
			}
		}
	}

	/**
	 * 住院结算收付款发送事件
	 * 
	 * @throws BizException
	 * */
	public void invokePayEvent(PatiVisitDO patiVisitDO, BlStIpDO blStIpDO, BlpaypatipAggDO blPayPatIpAggDO, BlincipAggDO blincipAggDO) throws BizException {
		// 发送事件
		BlEventInfoDTO blEventInfoDTO = new BlEventInfoDTO();
		blEventInfoDTO.setPatiVisitDO(patiVisitDO);
		blEventInfoDTO.setBlpaypatipAggDO(blPayPatIpAggDO);
		blEventInfoDTO.setBlStIpDO(blStIpDO);
		blEventInfoDTO.setBlincipAggDO(blincipAggDO);

		BlStIpEvent blStIpEvent = new BlStIpEvent();
		blStIpEvent.invokePay(blEventInfoDTO);
	}

	/**
	 * 结算收付款记录
	 * */
	public BlpaypatipAggDO setBlStIpPayInfo(OperatorInfoDTO operatorInfoDTO, BlStIpDO blStIpDO, BlPayPatIpDO blPayPatIpDO, BlPayItmPatIpDO[] blPayItmPatIpDOArr, FDouble rate, FDateTime dateTime)
			throws BizException {
		IBlpaypatipCudService payCService = ServiceFinder.find(IBlpaypatipCudService.class);
		BlpaypatipAggDO blPayPatIpAggDO = new BlpaypatipAggDO();
		// 主
		blPayPatIpDO.setId_org(operatorInfoDTO.getId_org());
		blPayPatIpDO.setId_grp(operatorInfoDTO.getId_grp());
		if (StTypeEnum.ST_INP.equals(blStIpDO.getEu_sttp())) {// 在院结算
			blPayPatIpDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_ST);
			blPayPatIpDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_ST);
		} else if (StTypeEnum.ST_INP_MIDWAY.equals(blStIpDO.getEu_sttp())) {// 中途结算
			blPayPatIpDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_MIDST);
			blPayPatIpDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_MIDST);
		}
		blPayPatIpDO.setId_enttp(blStIpDO.getId_enttp());
		blPayPatIpDO.setCode_enttp(blStIpDO.getCode_enttp());
		blPayPatIpDO.setEu_direct(BookRtnDirectEnum.CHARGE);
		blPayPatIpDO.setDt_pay(dateTime);
		blPayPatIpDO.setId_org_pay(operatorInfoDTO.getId_org());
		blPayPatIpDO.setId_dep_pay(operatorInfoDTO.getId_dep());
		blPayPatIpDO.setId_emp_pay(operatorInfoDTO.getId_emp());
		blPayPatIpDO.setId_cc(null);
		blPayPatIpDO.setFg_cc(FBoolean.FALSE);
		// blPayPatIpDO.setNote(blStIpDO.getAmt_std().sub(blStIpDO.getAmt_hp()).mod(rate).toString());
		blPayPatIpDO.setNote(blStIpDO.getAmt().sub(blPayPatIpDO.getAmt()).toString());
		blPayPatIpDO.setStatus(DOStatus.NEW);
		blPayPatIpAggDO.setParentDO(blPayPatIpDO);

		// 子
		for (BlPayItmPatIpDO blPayItmPatIpDO : blPayItmPatIpDOArr) {
			blPayItmPatIpDO.setId_org(operatorInfoDTO.getId_org());
			if (blPayItmPatIpDO.getId_pm() == null) {
				if (IBdPripmCodeConst.CODE_PRI_PM_CASH.equals(blPayItmPatIpDO.getPm_code())) {// 现金
					blPayItmPatIpDO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_CASH);
					blPayItmPatIpDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CASH);
				} else if (IBdPripmCodeConst.CODE_PRI_PM_CREDIT.equals(blPayItmPatIpDO.getPm_code())) {// 信用卡
					blPayItmPatIpDO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_CREDIT);
					blPayItmPatIpDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CREDIT);
				} else if (IBdPripmCodeConst.CODE_PRI_PM_CHECK.equals(blPayItmPatIpDO.getPm_code())) {// 支票
					blPayItmPatIpDO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_CHECK);
					blPayItmPatIpDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CHECK);
				} else if (IBdPripmCodeConst.CODE_PRI_PM_DEAFT.equals(blPayItmPatIpDO.getPm_code())) {// 汇票
					blPayItmPatIpDO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_DEAFT);
					blPayItmPatIpDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_DEAFT);
				} else if (IBdPripmCodeConst.CODE_PRI_PM_PAY.equals(blPayItmPatIpDO.getPm_code())) {// 预交金
					blPayItmPatIpDO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_PAY);
					blPayItmPatIpDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_PAY);
				}
			}
			blPayItmPatIpDO.setFg_realpay(FBoolean.TRUE);// 新加字段
			blPayItmPatIpDO.setStatus(DOStatus.NEW);
		}
		blPayPatIpAggDO.setBlPayItmPatIpDO(blPayItmPatIpDOArr);

		BlpaypatipAggDO[] blpaypatipAggDOArr = payCService.save(new BlpaypatipAggDO[] { blPayPatIpAggDO });
		if (blpaypatipAggDOArr == null || blpaypatipAggDOArr.length == 0) {
			throw new BizException("结算收付款记录保存失败！");
		}
		blPayPatIpAggDO = blpaypatipAggDOArr[0];
		return blPayPatIpAggDO;
	}

	/**
	 * 住院发票记录
	 * */
	public BlincipAggDO setInccaInfo(OperatorInfoDTO operatorInfoDTO, BlStIpDO blStIpDO, String incno, FDateTime dateTime, FDouble rate, BlCgIpDO[] blCgIpDOArr, int eu_free, FDouble amt_free)
			throws BizException {
		FDouble amt_pay = blStIpDO.getAmt().sub(amt_free);

		IBlincipCudService incCService = ServiceFinder.find(IBlincipCudService.class);
		IBlincQryService incQService = ServiceFinder.find(IBlincQryService.class);
		BlincipAggDO blIncIpAggDO = new BlincipAggDO();
		// 住院发票
		BlIncIpDO blIncIpDO = new BlIncIpDO();
		blIncIpDO.setId_org(operatorInfoDTO.getId_org());
		blIncIpDO.setId_grp(operatorInfoDTO.getId_grp());
		blIncIpDO.setId_pat(blStIpDO.getId_pat());
		blIncIpDO.setId_ent(blStIpDO.getId_ent());
		blIncIpDO.setId_enttp(blStIpDO.getId_enttp());
		blIncIpDO.setCode_enttp(blStIpDO.getCode_enttp());
		blIncIpDO.setEu_direct(BookRtnDirectEnum.CHARGE);
		blIncIpDO.setId_incca(IBdInccaCodeConst.ID_INHOS_INVOICE);
		blIncIpDO.setCode_incpkg(incQService.getCodeIncPkgByIdempiss(operatorInfoDTO.getId_org(), operatorInfoDTO.getId_emp(), IBdInccaCodeConst.ID_INHOS_INVOICE));// 票据包编号
		if (amt_pay.doubleValue() > 0) {
			blIncIpDO.setIncno(incno);// 发票号码
		}
		blIncIpDO.setDt_inc(dateTime);
		blIncIpDO.setEu_freemd(eu_free);
		blIncIpDO.setAmt_free(amt_free);

		//
		blIncIpDO.setAmt(blStIpDO.getAmt().sub(amt_free));// 总金额_患者需付
		// blIncIpDO.setAmt(blStIpDO.getAmt_pat().multiply(rate));//总金额_患者需付
		blIncIpDO.setAmt_pat(blStIpDO.getAmt_pat());// 总金额_患者自付
		blIncIpDO.setAmt_hp(new FDouble(0));// 总金额_医保
		blIncIpDO.setAmt_std(blStIpDO.getAmt_std());// 总金额
		blIncIpDO.setAmt_ratio(blStIpDO.getAmt_ratio());// 金额_价格比例
		blIncIpDO.setNote(MoneyFormat.getChineseValue(String.valueOf(blIncIpDO.getAmt().doubleValue()), "simpchn"));// 发票金额描述信息(总金额的大写)
		blIncIpDO.setId_emp_inc(operatorInfoDTO.getId_emp());
		blIncIpDO.setTimes_prn(1);
		blIncIpDO.setFg_canc(FBoolean.FALSE);
		blIncIpDO.setId_stip(blStIpDO.getId_stip());
		blIncIpDO.setStatus(DOStatus.NEW);
		blIncIpDO.setFg_print(FBoolean.TRUE);
		blIncIpDO.setFg_cc_out(FBoolean.FALSE);
		blIncIpDO.setFg_cc_in(FBoolean.FALSE);
		blIncIpAggDO.setParentDO(blIncIpDO);
		BlincipAggDO[] blIncIpAggDOArr = incCService.save(new BlincipAggDO[] { blIncIpAggDO });
		if (blIncIpAggDOArr == null || blIncIpAggDOArr.length == 0) {
			throw new BizException("保存发票信息失败！");
		}
		blIncIpAggDO = blIncIpAggDOArr[0];
		blIncIpAggDO.getParentDO().setStatus(DOStatus.UPDATED);

		// 住院发票明细
		BlStIpInccaInfoDTO[] blStIpInccaInfoDTOArr = this.getBdInccaInfoByIdStIp(blStIpDO.getId_stip());
		if (blStIpInccaInfoDTOArr == null || blStIpInccaInfoDTOArr.length == 0) {
			throw new BizException("票据项目分类为空！");
		}

		Map<String, FDouble> map = this.getBlCgIpAmtFree(blStIpDO, amt_free);
		List<BlIncItmIpDO> incItmList = new ArrayList<BlIncItmIpDO>();
		for (BlStIpInccaInfoDTO blStIpInccaInfoDTO : blStIpInccaInfoDTOArr) {
			BlIncItmIpDO blIncItmIpDO = new BlIncItmIpDO();
			blIncItmIpDO.setId_incip(blIncIpAggDO.getParentDO().getId_incip());
			blIncItmIpDO.setCode(blStIpInccaInfoDTO.getCode_inccaitm());// 项目编码(BD_INCCA_ITM.CODE)
			blIncItmIpDO.setName(blStIpInccaInfoDTO.getName_inccaitm());// 项目名称(BD_INCCA_ITM.NAME)
			if (BlFreeMdEnum.AMT_FREE_MD == eu_free) {// 金额减免
				FDouble amt_itm_free = new FDouble("0");
				if (map.get(blStIpInccaInfoDTO.getCode_inccaitm()) != null) {
					amt_itm_free = map.get(blStIpInccaInfoDTO.getCode_inccaitm());
				}
				blIncItmIpDO.setAmt_free(amt_itm_free);
				blIncItmIpDO.setAmt(blStIpInccaInfoDTO.getAmt().sub(amt_itm_free));// 金额(项目所关联的全部费用的金额合计SUM(AMT))
				blIncItmIpDO.setAmt_pat(blStIpInccaInfoDTO.getAmt().sub(amt_itm_free));// 金额_患者自付(项目所关联的全部费用的金额_患者自付合计SUM(AMT_PAT))
			} else if (BlFreeMdEnum.ITM_FREE_MD == eu_free) {// 项目减免
				FDouble amt_itm_free = new FDouble("0");
				for (BlCgIpDO blCgIpDO : blCgIpDOArr) {
					if (blCgIpDO.getCode_inccaitm().equals(blIncItmIpDO.getCode())) {
						amt_itm_free = amt_itm_free.add(blCgIpDO.getAmt());
					}
				}
				blIncItmIpDO.setAmt_free(amt_itm_free);
				blIncItmIpDO.setAmt(blStIpInccaInfoDTO.getAmt().sub(amt_itm_free));// 金额(项目所关联的全部费用的金额合计SUM(AMT))
				blIncItmIpDO.setAmt_pat(blStIpInccaInfoDTO.getAmt().sub(amt_itm_free));// 金额_患者自付(项目所关联的全部费用的金额_患者自付合计SUM(AMT_PAT))
			} else {
				blIncItmIpDO.setAmt_free(null);
				blIncItmIpDO.setAmt(blStIpInccaInfoDTO.getAmt());// 金额(项目所关联的全部费用的金额合计SUM(AMT))
				blIncItmIpDO.setAmt_pat(blStIpInccaInfoDTO.getAmt());// 金额_患者自付(项目所关联的全部费用的金额_患者自付合计SUM(AMT_PAT))
			}
			blIncItmIpDO.setStatus(DOStatus.NEW);
			incItmList.add(blIncItmIpDO);
		}
		blIncIpAggDO.setBlIncItmIpDO(incItmList.toArray(new BlIncItmIpDO[] {}));

		// 票据编码修改
		if (amt_pay.doubleValue() > 0) {
			/*IBLInvoiceService incService = (IBLInvoiceService) ServiceFinder.find(IBLInvoiceService.class);
			incService.NextInvoiceNoUpdateCurNo(operatorInfoDTO.getId_emp(), IBdInccaCodeConst.CODE_INHOS_INVOICE);*/
			
			IBlIncUtilService incService = ServiceFinder.find(IBlIncUtilService.class);
			incService.nextInvoiceNo(operatorInfoDTO.getId_emp(), Context.get().getClientHost(), IBdInccaCodeConst.ID_INHOS_INVOICE);
		}

		// 住院结算与发票关系
		BlStIncIpDO blStIncIpDO = new BlStIncIpDO();
		blStIncIpDO.setId_stip(blStIpDO.getId_stip());
		blStIncIpDO.setId_incip(blIncIpAggDO.getParentDO().getId_incip());
		blStIncIpDO.setFg_active(FBoolean.TRUE);
		blStIncIpDO.setStatus(DOStatus.NEW);
		blIncIpAggDO.setBlStIncIpDO(new BlStIncIpDO[] { blStIncIpDO });
		blIncIpAggDOArr = incCService.save(blIncIpAggDOArr);
		if (blIncIpAggDOArr == null || blIncIpAggDOArr.length == 0) {
			throw new BizException("住院结算发票数据保存失败！");
		}
		return blIncIpAggDOArr[0];
	}

	/**
	 * 金额减免算法
	 * 
	 * @throws BizException
	 * */
	public Map<String, FDouble> getBlCgIpAmtFree(BlStIpDO blStIpDO, FDouble amt_free) throws BizException {
		Map<String, FDouble> map = new HashMap<String, FDouble>();
		if (amt_free == null || amt_free.doubleValue() == 0) {
			return map;
		}
		// IBlcgqueryMDORService cgRService =
		// ServiceFinder.find(IBlcgqueryMDORService.class);
		// StringBuffer sqlQur = new StringBuffer();
		// sqlQur.append(" a0.ID_STIP = '").append(blStIpDO.getId_stip()).append("' ");
		// BlCgIpDO[] blCgIpDOArr = cgRService.find(sqlQur.toString(), null,
		// FBoolean.FALSE);
		BlCgIpDO[] blCgIpDOArr = this.getIncBlCgIpInfoBySt(blStIpDO.getId_stip());
		if (blCgIpDOArr != null && blCgIpDOArr.length > 0) {
			FDouble amt = new FDouble("0");
			for (BlCgIpDO blCgIpDO : blCgIpDOArr) {
				amt = amt.add(blCgIpDO.getAmt());
			}
			for (BlCgIpDO blCgIpDO : blCgIpDOArr) {
				FDouble amt_itm_free = map.get(blCgIpDO.getCode_inccaitm());
				if (amt_itm_free == null) {
					map.put(blCgIpDO.getCode_inccaitm(), amt_free.multiply(blCgIpDO.getAmt().div(amt)));
				} else {
					// amt_itm_free =
					// amt_itm_free.add(amt_free.multiply(blCgIpDO.getAmt().div(amt)));
					map.put(blCgIpDO.getCode_inccaitm(), amt_itm_free.add(amt_free.multiply(blCgIpDO.getAmt().div(amt))));
				}
				amt_free = amt_free.sub(amt_free.multiply(blCgIpDO.getAmt().div(amt)));
				amt = amt.sub(blCgIpDO.getAmt());
			}
		}
		return map;
	}

	@SuppressWarnings("unchecked")
	public BlCgIpDO[] getIncBlCgIpInfoBySt(String id_stip) throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append("select c.code_inccaitm,sum(c.amt) as amt,sum(c.amt_pat) as amt_pat,sum(c.amt_std) as amt_std from bl_cg_ip c ").append("where c.id_stip = '").append(id_stip).append("' ")
				.append("group by c.code_inccaitm ");
		List<BlCgIpDO> list = (List<BlCgIpDO>) new DAFacade().execQuery(sql.toString(), new BeanListHandler(BlCgIpDO.class));
		return list.toArray(new BlCgIpDO[] {});
	}

	/**
	 * 修改结算数据
	 * 
	 * @throws BizException
	 * */
	public void updateBlStIpInfo(BlStIpDO blStIpDO, BlPayPatIpDO blPayPatIpDO, String id_paypatip, FDouble rate, FBoolean isArrears, FBoolean isCarryover) throws BizException {
		IBlstipCudService stCService = ServiceFinder.find(IBlstipCudService.class);
		if (isArrears.booleanValue()) {// 欠费结算
			blStIpDO.setId_stresult(IBlDictCodeConst.ID_STRESULT_ARREARAGE);
			blStIpDO.setSd_stresult(IBlDictCodeConst.SD_STRESULT_ARREARAGE);
		} else if (isCarryover.booleanValue()) {// 存款结算
			blStIpDO.setId_stresult(IBlDictCodeConst.ID_STRESULT_DEPOSIT);
			blStIpDO.setSd_stresult(IBlDictCodeConst.SD_STRESULT_DEPOSIT);
		} else {
			blStIpDO.setId_stresult(IBlDictCodeConst.ID_STRESULT_NORMAL);
			blStIpDO.setSd_stresult(IBlDictCodeConst.SD_STRESULT_NORMAL);
		}
		// blStIpDO.setAmt_hp(new FDouble(0));//总金额_医保计划
		// blStIpDO.setAmt_pat(blStIpDO.getAmt_ratio().sub(blStIpDO.getAmt_hp()));//总金额_患者自付
		// blStIpDO.setAmt(blStIpDO.getAmt_pat().multiply(rate));//实际支付金额
		if (isArrears.booleanValue()) {// 欠费结清标志
			blStIpDO.setFg_arclear(FBoolean.FALSE);
		} else {
			blStIpDO.setFg_arclear(FBoolean.TRUE);
		}
		blStIpDO.setFg_pay(FBoolean.TRUE);// 患者收付款
		blStIpDO.setStatus(DOStatus.UPDATED);
		BlStIpDO[] blStIpDOArr = stCService.save(new BlStIpDO[] { blStIpDO });
		if (blStIpDOArr == null || blStIpDOArr.length == 0) {
			throw new BizException("结算数据修改失败！");
		}
		blStIpDO = blStIpDOArr[0];
	}

	/**
	 * 修改预交金数据&&如果有结转，添加新预交金数据
	 * */
	public void setBlPrePayInfo(OperatorInfoDTO operatorInfoDTO, BlpaypatipAggDO blPayPatIpAggDO, BlPrePayPatDO[] blPrePayPatDOArr, BlStIpDO blStIpDO, FDateTime dateTime, String sd_pttp)
			throws BizException {
		if (blPrePayPatDOArr == null || blPrePayPatDOArr.length == 0) {
			return;
		}
		List<BlPrePayPatDO> blPrePayPatDOList = new ArrayList<BlPrePayPatDO>();
		FDouble amt = new FDouble(0);
		for (BlPrePayPatDO blPrePayPatDO : blPrePayPatDOArr) {
			if (blPrePayPatDO.getId_paypat() != null) {
				blPrePayPatDO.setFg_rep_return(FBoolean.TRUE);
				blPrePayPatDO.setDt_return(dateTime);
				blPrePayPatDO.setId_emp_return(operatorInfoDTO.getId_emp());
				//blPrePayPatDO.setId_st_mid(blStIpDO.getId_stip());
				blPrePayPatDO.setStatus(DOStatus.UPDATED);
				blPrePayPatDOList.add(blPrePayPatDO);

				amt = amt.add(blPrePayPatDO.getAmt());
			} else {
				blPrePayPatDO.setId_grp(operatorInfoDTO.getId_grp());
				blPrePayPatDO.setId_org(operatorInfoDTO.getId_org());
				blPrePayPatDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_IPPREPAY);
				blPrePayPatDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_IPPREPAY);
				blPrePayPatDO.setId_pat(blStIpDO.getId_pat());
				blPrePayPatDO.setId_enttp(blStIpDO.getId_enttp());
				blPrePayPatDO.setCode_enttp(blStIpDO.getCode_enttp());
				blPrePayPatDO.setId_ent(blStIpDO.getId_ent());
				blPrePayPatDO.setEu_direct(BookRtnDirectEnum.CHARGE);
				blPrePayPatDO.setDt_pay(dateTime);
				blPrePayPatDO.setId_org_pay(operatorInfoDTO.getId_org());
				blPrePayPatDO.setId_dep_pay(operatorInfoDTO.getId_dep());
				blPrePayPatDO.setId_emp_pay(operatorInfoDTO.getId_emp());
				blPrePayPatDO.setFg_rep_return(FBoolean.FALSE);
				blPrePayPatDO.setFg_cc(FBoolean.FALSE);
				blPrePayPatDO.setId_incca(IBdInccaCodeConst.ID_INHOS_DEPOSIT);// 票据分类(住院预交金收据分类的ID)
				blPrePayPatDO.setCode_incca(IBdInccaCodeConst.CODE_INHOS_DEPOSIT);
				// blPrePayPatDO.setCode_rep("");//收据编号(当前票据号)
				blPrePayPatDO.setId_st_mid(blStIpDO.getId_stip());
				blPrePayPatDO.setSd_pttp(sd_pttp);
				blPrePayPatDO.setNote("找零结转");
				blPrePayPatDO.setStatus(DOStatus.NEW);
				blPrePayPatDOList.add((BlPrePayPatDO) blPrePayPatDO.clone());
			}
		}
		// 添加红冲数据
		if (amt.doubleValue() > 0) {
			BlPrePayPatDO blPrePay = new BlPrePayPatDO();
			blPrePay.setAmt(amt);
			blPrePay.setId_grp(operatorInfoDTO.getId_grp());
			blPrePay.setId_org(operatorInfoDTO.getId_org());
			blPrePay.setId_paytp(IBlDictCodeConst.ID_PAYTP_IPPREPAYCONSUME);
			blPrePay.setSd_paytp(IBlDictCodeConst.SD_PAYTP_IPPREPAYCONSUME);
			blPrePay.setId_pat(blStIpDO.getId_pat());
			blPrePay.setId_enttp(blStIpDO.getId_enttp());
			blPrePay.setCode_enttp(blStIpDO.getCode_enttp());
			blPrePay.setId_ent(blStIpDO.getId_ent());
			blPrePay.setEu_direct(BookRtnDirectEnum.RETURNS);
			blPrePay.setId_pm(IBdPripmCodeConst.ID_PRI_PM_PAY);
			blPrePay.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_PAY);
			blPrePay.setDt_pay(dateTime);
			blPrePay.setId_org_pay(operatorInfoDTO.getId_org());
			blPrePay.setId_dep_pay(operatorInfoDTO.getId_dep());
			blPrePay.setId_emp_pay(operatorInfoDTO.getId_emp());
			blPrePay.setFg_rep_return(FBoolean.FALSE);
			blPrePay.setFg_cc(FBoolean.FALSE);
			// blPrePay.setId_incca(IBdFcDictCodeConst.ID_CODE_ENTP_IP);//票据分类(住院预交金收据分类的ID)
			// blPrePay.setCode_incca(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
			blPrePay.setSd_pttp(sd_pttp);
			blPrePay.setStatus(DOStatus.NEW);
			blPrePayPatDOList.add(blPrePay);
		}

		IBlpaypatCudService preCService = ServiceFinder.find(IBlpaypatCudService.class);
		preCService.save(blPrePayPatDOList.toArray(new BlPrePayPatDO[] {}));

		// 票据编码修改
		/*IBLInvoiceService incService = (IBLInvoiceService) ServiceFinder.find(IBLInvoiceService.class);
		incService.NextInvoiceNoUpdateCurNo(operatorInfoDTO.getId_emp(), IBdInccaCodeConst.CODE_INHOS_DEPOSIT);*/
		
		IBlIncUtilService incService = ServiceFinder.find(IBlIncUtilService.class);
		incService.nextInvoiceNo(operatorInfoDTO.getId_emp(), Context.get().getClientHost(), IBdInccaCodeConst.ID_INHOS_DEPOSIT);
	}

	/**
	 * 修改就诊账户
	 * */
	public void updateEnAccountInfo(String id_ent, BlPrePayPatDO[] blPrePayPatDOArr, FBoolean isArrears, BlStIpDO blStIpDO, FDouble rate) throws BizException {
		// IEnaccountMDOCudService enCService =
		// ServiceFinder.find(IEnaccountMDOCudService.class);
		// IEnaccountMDORService enRService =
		// ServiceFinder.find(IEnaccountMDORService.class);
		// EnAccountDO[] enAccountDOArr = enRService.find(" a0.id_ent = '" +
		// id_ent + "' ", null, FBoolean.FALSE);
		// if(enAccountDOArr == null || enAccountDOArr.length == 0){
		// throw new BizException("就诊账户不存在！");
		// }
		// EnAccountDO enAccountDO = enAccountDOArr[0];
		// if(blPrePayPatDOArr != null && blPrePayPatDOArr.length > 0){
		// for(BlPrePayPatDO blPrePayPatDO : blPrePayPatDOArr){
		// if(blPrePayPatDO.getId_paypat() != null){
		// enAccountDO.setAmt_prepay(enAccountDO.getAmt_prepay().sub(blPrePayPatDO.getAmt()));//就诊预交金(原数值减去本次选择的预交金总金额)
		// }else{
		// enAccountDO.setAmt_prepay(enAccountDO.getAmt_prepay().add(blPrePayPatDO.getAmt()));//就诊预交金(原数值加上转结的预交金金额)
		// }
		// }
		// }
		// enAccountDO.setAmt_uncg(enAccountDO.getAmt_uncg().sub(blStIpDO.getAmt_std()));//就诊未结算费用(原数值减去结算的标准总金额)
		// enAccountDO.setStatus(DOStatus.UPDATED);
		// enCService.save(enAccountDOArr);

		FDouble amt = new FDouble();
		if (blPrePayPatDOArr != null && blPrePayPatDOArr.length > 0) {
			for (BlPrePayPatDO blPrePayPatDO : blPrePayPatDOArr) {
				if (blPrePayPatDO.getId_paypat() != null) {
					amt = amt.sub(blPrePayPatDO.getAmt());// 就诊预交金(原数值减去本次选择的预交金总金额)
				} else {
					amt = amt.add(blPrePayPatDO.getAmt());// 就诊预交金(原数值加上转结的预交金金额)
				}
			}
		}
		IEnOutCmdService inpPatAccImpls = ServiceFinder.find(IEnOutCmdService.class);
		inpPatAccImpls.recharge(id_ent, amt);
		inpPatAccImpls.consume(id_ent, new FDouble(0).sub(blStIpDO.getAmt_ratio()));
	}

	/**
	 * 修改记账数据
	 * */
	public void updateBlCgIpInfo(BlCgIpDO[] blCgIpDOArr) throws BizException {
		if (blCgIpDOArr == null || blCgIpDOArr.length == 0) {
			return;
		}
		IBlcgqueryCudService cgCService = ServiceFinder.find(IBlcgqueryCudService.class);

		for (BlCgIpDO blCgIpDO : blCgIpDOArr) {
			blCgIpDO.setFg_free(FBoolean.TRUE);
			blCgIpDO.setStatus(DOStatus.UPDATED);
		}
		cgCService.save(blCgIpDOArr);
	}

	/**
	 * 组装发票数据
	 * 
	 * @throws BizException
	 * */
	@SuppressWarnings("unchecked")
	public BlStIpPayInvoceInfoDTO setBlStIpPayInncaInfo(BlStIpDO blStIpDO, String id_incip, FDateTime dateTime) throws BizException {
		BlStIpPayInvoceInfoDTO blStIpPayInvoceInfoDTO = null;

		IPativisitRService entRService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO entDO = entRService.findById(blStIpDO.getId_ent());
		if (entDO == null) {
			throw new BizException("就诊信息不存在！");
		}
		IBlincipMDORService incRService = ServiceFinder.find(IBlincipMDORService.class);
		BlIncIpDO blIncIpDO = incRService.findById(id_incip);
		if (blIncIpDO == null) {
			throw new BizException("发票信息不存在！");
		}
		BlStIpInccaInfoDTO[] bodyDTOArr = this.getBlStIpPayIncInfoBySt(blIncIpDO.getId_incip());
		if (bodyDTOArr == null || bodyDTOArr.length == 0) {
			throw new BizException("结算项目明细数据为空！");
		}

		BlstipInvoiceHeadInfoDTO headDTO = new BlstipInvoiceHeadInfoDTO();
		headDTO.setId_stip(blStIpDO.getId_stip());// 住院结算标识
		headDTO.setCode_st(blStIpDO.getCode_st());// 住院号EN_ENT.CODE
		headDTO.setCode_ent(entDO.getCode());// 业务流水号BL_ST_IP.CODE_ST
		headDTO.setName_orgtp(null);// 医疗机构类型（暂空）
		headDTO.setName_pat(entDO.getName_pat());// 患者姓名EN_ENT.NAME_PAT
		// headDTO.setSd_sex(entDO.getSd_sex_pat());//患者性别EN_ENT.SD_SEX
		if (IPiDictCodeConst.SD_SEX_MALE.equals(entDO.getSd_sex_pat())) {
			headDTO.setSd_sex("男");
		} else if (IPiDictCodeConst.SD_SEX_FEMALE.equals(entDO.getSd_sex_pat())) {
			headDTO.setSd_sex("女");
		} else {
			headDTO.setSd_sex("");
		}

		String name_hp = "";// 医保类型
		String code_hp = "";// 社会保障号码
		List<BlIncIpEntHpInfoDTO> hpList = this.getBdHpInfoByIdEnt(blStIpDO.getId_ent());
		if (hpList != null && hpList.size() > 0) {
			StringBuffer nameStr = new StringBuffer();
			for (BlIncIpEntHpInfoDTO blIncIpEntHpInfoDTO : hpList) {
				if (nameStr.length() > 0) {
					nameStr.append(",");
				}
				nameStr.append(blIncIpEntHpInfoDTO.getName_hp());
				if (blIncIpEntHpInfoDTO.getFg_maj().booleanValue()) {
					code_hp = blIncIpEntHpInfoDTO.getCode_hp();
				}
			}
			name_hp = nameStr.toString();
		}
		headDTO.setName_hp(name_hp);// 医保类型（BL_INC_OIP EN_ENT_HP.ID_HP[@ID_ENT]
									// BD_HP.NAME 按序号排序，多条合并显示，半角逗号分隔）
		headDTO.setCode_hp(code_hp);// 社会保障号码（EN_ENT_HP.ID_HP[@ID_PAT = 患者ID AND
									// @FG_MAJ = TRUE] BD_HP.CODE）
		headDTO.setAmt_cap(MoneyFormat.getChineseValue(String.valueOf(blIncIpDO.getAmt().doubleValue()), "simpchn"));// 合计（大写）
		// headDTO.setAmt(blStIpDO.getAmt());//合计SUM(BL_CG_IP.AMT_STD)
		headDTO.setAmt(blIncIpDO.getAmt());// 合计
		headDTO.setAmt_hp(null);// 医保统筹支付（暂空）
		headDTO.setAmt_own_acc(null);// 个人账户支付（暂空）
		headDTO.setAmt_hp_otr(null);// 其它医保支付（暂空）
		headDTO.setAmt_own(null);// 个人支付（暂空）
		headDTO.setName_emp_inc(blIncIpDO.getName_emp_inc());// 收款人BL_INC_IP.ID_EMP_INC
		headDTO.setDt_inc(blIncIpDO.getDt_inc());// 收款日期BL_INC_IP.DT_INC
		headDTO.setIncno(blIncIpDO.getIncno());// 发票号码 BL_INC_IP.INCNO 只显示，不打印
		headDTO.setDt_acpt(entDO.getDt_acpt());// 入院时间EN_ENT.DT_ACPT
		headDTO.setDt_end(entDO.getDt_end());// 出院时间EN_ENT.DT_END
		headDTO.setNum_day_ent(blStIpDO.getDt_end().getDaysAfter(blStIpDO.getDt_start()));// 住院天数（BL_ST_IP.DT_END
																							// –
																							// BL_ST_IP.DT_START）
		// headDTO.setNum_day_ent(dateTime.getDaysAfter(entDO.getDt_acpt()));//住院天数（EN_ENT.DT_END
		// – EN_ENT.ACPT）
		headDTO.setMrno(null);// 病历号（暂空）
		headDTO.setAmt_pre(null);// 病历号（暂空）
		headDTO.setAmt_fill(null);// 预缴金额（暂空）
		headDTO.setAmt_ret(null);// 补缴金额（暂空）

		FArrayList invList = new FArrayList();
		for (BlStIpInccaInfoDTO info : bodyDTOArr) {
			invList.add(info);
		}

		// 结算明细
		IBlcgqueryService cgQueService = ServiceFinder.find(IBlcgqueryService.class);
		BlCgZyQueryDTO[] stHeadDTOArr = cgQueService.BlCgZyFindByQCond(" and d.id_ent = '" + blStIpDO.getId_ent() + "'", null, FBoolean.FALSE);
		if (stHeadDTOArr == null || stHeadDTOArr.length == 0) {
			throw new BizException("患者就诊信息不存在！");
		}
		/*IBlcgqueryRService cgMRService = ServiceFinder.find(IBlcgqueryRService.class);
		BlCgIpDO[] blCgIpDOArr = cgMRService.find(" a0.id_stip = '" + blStIpDO.getId_stip() + "'", null, FBoolean.FALSE);
		if (blCgIpDOArr == null || blCgIpDOArr.length == 0) {
			throw new BizException("结算明细信息为空！");
		}
		FArrayList blCgIpDOList = new FArrayList();
		for (BlCgIpDO blCgIpDO : blCgIpDOArr) {
			blCgIpDOList.add(blCgIpDO);
		}*/
		
		//查询收付款数据
		IBlpaypatipRService payService = ServiceFinder.find(IBlpaypatipRService.class);
		BlpaypatipAggDO[] payAggDos = payService.findByAttrValString(BlPayPatIpDO.ID_STIP, blStIpDO.getId_stip());
		
		FArrayList payList = new FArrayList();
		if(!ArrayUtil.isEmpty(payAggDos)){
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
		//blStIpPayInvoceInfoDTO.setStBodyInfoArr(blCgIpDOList);
		blStIpPayInvoceInfoDTO.setBlInvoicePmDTOList(payList);
		return blStIpPayInvoceInfoDTO;
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

	/**
	 * 获取就诊相关的医保计划信息
	 * */
	@SuppressWarnings("unchecked")
	public List<BlIncIpEntHpInfoDTO> getBdHpInfoByIdEnt(String id_ent) throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append("select e.id_ent,e.fg_maj,b.code as code_hp,b.name as name_hp ").append("from en_ent_hp e ").append("left join bd_hp b on e.id_hp = b.id_hp ").append("where e.id_ent = '")
				.append(id_ent).append("' ").append("order by b.code ");
		List<BlIncIpEntHpInfoDTO> list = (List<BlIncIpEntHpInfoDTO>) new DAFacade().execQuery(sql.toString(), new BeanListHandler(BlIncIpEntHpInfoDTO.class));
		return list;
	}

	/**
	 * 出院退费
	 * 
	 * @throws BizException
	 * */
	public BlPrePayPatDO doStipRefund(String idEnt, String id_stip, String sd_pttp, FBoolean isSaveRedProp) throws BizException {

		OperatorInfoDTO opreDto = new OperatorInfoDTO();
		opreDto.setId_grp(Context.get().getGroupId());
		opreDto.setId_org(Context.get().getOrgId());
		opreDto.setId_dep(Context.get().getDeptId());
		opreDto.setId_emp(Context.get().getStuffId());
		
		//根据就诊id查询PatiVisitDO
		IPativisitRService  patiRSer = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO[] patiVisitDos =  patiRSer.findByAttrValString("Id_ent", idEnt);
		if(ArrayUtil.isEmpty(patiVisitDos)){
			throw new BizException("做退款业务时，未查询到该患者的就诊信息！");
		}
				
		// 获取当前服务器时间
		TimeService timeService = new TimeServiceImpl();
		FDateTime dateTime = timeService.getUFDateTime();

		BlEventInfoDTO blEventInfoDTO = new BlEventInfoDTO();

		// 红冲结算信息
		BlStIpDO blStIpDO = this.setBlStIpByRefundReRun(opreDto, id_stip, dateTime, blEventInfoDTO);		
		//红冲住院分摊 
		if(isSaveRedProp.booleanValue()){				
			InsureContext insureContext = new InsureContext();
			insureContext.setIdHp(patiVisitDos[0].getId_hp());
			saveBackPropData(id_stip,blStIpDO.getId_stip(),insureContext);
		}
		// 记账信息
		this.setBlCgIpRefund(id_stip, blStIpDO, dateTime, blEventInfoDTO);

		// 发票信息
		this.setBlStIpIncRefund(opreDto, id_stip, blStIpDO, dateTime, blEventInfoDTO);

		//先生成预交金主键
		String id_paypat=this.getPrePayPk();
				
		// 收付款(实际交款金额)
		FDouble amt_pay = this.setBlStIpPayRefund(opreDto, id_stip, blStIpDO, dateTime, blEventInfoDTO,id_paypat);

		//处理预交金
		BlPrePayPatDO blPrePayPatDO = null;
		if(amt_pay != null && amt_pay.compareTo(FDouble.ZERO_DBL) > 0){
			blPrePayPatDO = this.dealPrepay(blStIpDO, amt_pay, sd_pttp,id_paypat);
		}
		
//		if(FBoolean.TRUE.equals(BlParams.BLSTIP0014())){
//		    // 预交金
//			blPrePayPatDO = this.setBlPrePayInfoByRefund(blStIpDO, amt_pay, sd_pttp, FBoolean.TRUE);
//		}
		
		// 修改就诊账户数据
		this.setEntEntAccoutInfoByRefund(blStIpDO, FDouble.ZERO_DBL);

		// 修改就诊信息
		this.setEnEntInfoByIdStip(id_stip, blEventInfoDTO);

		// 发送事件
		this.invokeRefundEvent(blEventInfoDTO);		
		
		//前置流程下结算+明细+分摊+前置分摊
		if(isSaveRedProp.booleanValue()){
			InsureContext insureContext = new InsureContext();
			insureContext.setIdHp(patiVisitDos[0].getId_hp());
			InsureFacade facade=new InsureFacade(insureContext);
			String flowType = facade.GetHpFlowType();
			if (flowType.equals(MiFlowType.PREFLOW)) {
				BackPayReDoStBp handlerBp=new BackPayReDoStBp();
				handlerBp.exec(id_stip,insureContext);
			}
		}
		//修改就诊付款标识
		IBlstipRService stRService = ServiceFinder.find(IBlstipRService.class);
		BlStIpDO blStIpOld = stRService.findById(id_stip);
		if(StTypeEnum.ST_INP.equals(blStIpOld.getEu_sttp())){
			this.upEntFgPay(patiVisitDos[0]);
		}
		return blPrePayPatDO;
	}
	
	/**
	 * 更新就诊付款标识
	 * @param entDo
	 * @throws DAException
	 */
	public void upEntFgPay(PatiVisitDO entDo) throws DAException{
		DAFacade daf = new DAFacade();
		entDo.setFg_pay(FBoolean.FALSE);
		entDo.setStatus(DOStatus.UPDATED);
		daf.updateDO(entDo, new String[]{PatiVisitDO.FG_PAY});
	}
	
	
	/**
	 * 预交金处理
	 * @throws BizException 
	 */
	private BlPrePayPatDO dealPrepay(BlStIpDO blstip, FDouble amt_pay,String sd_pttp,String id_paypat) throws BizException{
		BlPrepaySTDTO blPrepaySTDTO = new BlPrepaySTDTO();
		blPrepaySTDTO.setId_prepay_new(id_paypat);
		blPrepaySTDTO.setId_pat(blstip.getId_pat());
		blPrepaySTDTO.setId_ent(blstip.getId_ent());
		blPrepaySTDTO.setId_st(blstip.getId_stip());
		blPrepaySTDTO.setSd_pttp(sd_pttp);
		blPrepaySTDTO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_CASH);
		blPrepaySTDTO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CASH);
		blPrepaySTDTO.setAmt(amt_pay);
		blPrepaySTDTO.setId_emp_pay(Context.get().getStuffId());
		
		BlPrepaySetDTO setDto = new BlPrepaySetDTO();
		setDto.setFg_accupdate(FBoolean.TRUE);
		setDto.setFg_print(FBoolean.TRUE);
		
		IBlPrepayCmdService prepayService = ServiceFinder.find(IBlPrepayCmdService.class);
		BlPrePayPatDO blPrePayPatDO = prepayService.reverse(blPrepaySTDTO, setDto);
		
		return blPrePayPatDO;
	}
	
	/**
	 * 保存退费红冲分摊数据
	 * @param strStId 退费结算id
	 * @param insureContext
	 * @throws BizException
	 */
	private void saveBackPropData(String strStIdOriginal,String strStIdBack,InsureContext insureContext) throws BizException
	{
		IBlPropQryService propQryService=ServiceFinder.find(IBlPropQryService.class);
		FMap2 map=propQryService.getIpHpPropAggDo(strStIdOriginal);
		BlPropIpDO ipPropDo=(BlPropIpDO)map.get("PropIp");
		BlproparipAggDO propArDo=(BlproparipAggDO)map.get("PropArIpAgg");
		
		//医保分摊数据
		BlPropIpDO propIpDoBack=(BlPropIpDO)ipPropDo.clone();
		propIpDoBack.setId_propip(null);
		//记录方向
		propIpDoBack.setEu_direct(BookRtnDirectEnum.RETURNS);
		ipPropDo.setId_propip(null);
		ipPropDo.setEu_direct(-1);
		ipPropDo.setId_stip(strStIdBack);
		ipPropDo.setStatus(DOStatus.NEW);
		//保存应收数据
		BlproparipAggDO aggDoBack=new BlproparipAggDO();
		BlPropArIpDO propAripDoBack=(BlPropArIpDO)propArDo.getParentDO().clone();
		propAripDoBack.setId_proparip(null);
		propAripDoBack.setEu_direct(-1);
		propAripDoBack.setStatus(DOStatus.NEW);
		aggDoBack.setParentDO(propAripDoBack);
		IBlPropCmdService propCmdService = ServiceFinder.find(IBlPropCmdService.class);
		FMap2 mapBackData=propCmdService.saveIpPropData(ipPropDo, aggDoBack);
		
		BlproparipAggDO[] arIpAggDoArr=(BlproparipAggDO[])mapBackData.get("proparip");
		//医保扩展表存储
		InsureFacade facade=new InsureFacade(insureContext);
		HisPropertyRefHpDTO propertyRefHpDto=new HisPropertyRefHpDTO();
		propertyRefHpDto.setId_ref(arIpAggDoArr[0].getParentDO().getId_proparip());
		propertyRefHpDto.setId_refold(propArDo.getParentDO().getId_proparip());
		facade.saveBackPayPropData(null,propertyRefHpDto);
	}
	/**
	 * 住院结算退款发送事件
	 * 
	 * @throws BizException
	 * */
	public void invokeRefundEvent(BlEventInfoDTO blEventInfoDTO) throws BizException {
		BlStIpEvent blStIpEvent = new BlStIpEvent();
		blStIpEvent.invokeRefund(blEventInfoDTO);
	}
	/**
	 * 出院退费--记账信息
	 * */
	@SuppressWarnings("unchecked")
	public void setBlCgIpRefund(String id_stip, BlStIpDO blStIpDO, FDateTime dateTime, BlEventInfoDTO blEventInfoDTO) throws BizException {
		IBlcgqueryRService cgRService = ServiceFinder.find(IBlcgqueryRService.class);
		IBlcgqueryCudService cgCService = ServiceFinder.find(IBlcgqueryCudService.class);
		BlCgIpDO[] blCgIpDOArr = cgRService.find(" a0.id_stip = '" + id_stip + "'", null, FBoolean.FALSE);
		if (blCgIpDOArr == null || blCgIpDOArr.length == 0) {
			return;
		}
		//blStIpDO：红冲生成的结算记录
		invokeRechargeDetails(blCgIpDOArr, blStIpDO, dateTime,blEventInfoDTO);
	}

	/**
	 * 生成预交金主键
	 * @return
	 */
	private String getPrePayPk(){
		if(FBoolean.TRUE.equals(BlParams.BLSTIP0014())){
			return new DBUtil().getOIDs(1)[0];
		}
		return "";
	}
	
	/** 优化算法，解决住院退费后原记录id_par记录原主键的问题
	 * @param blCgIpDOArr
	 * @return
	 * @throws BizException
	 */
	private void invokeRechargeDetails(BlCgIpDO[] blCgIpDOArr,BlStIpDO blStIpDO,FDateTime dateTime,BlEventInfoDTO blEventInfoDTO) throws BizException
	{
		IBlcgqueryCudService cgCService = ServiceFinder.find(IBlcgqueryCudService.class);
		//原记账数据(最终成为待重收的记账数据)
		List<BlCgIpDO> orignalCgList = new ArrayList<BlCgIpDO>();
		//红冲记账数据
		List<BlCgIpDO> redCgList = new ArrayList<BlCgIpDO>();
		//新记账数据(原记账数据的备份)
		List<BlCgIpDO> newCgList = new ArrayList<BlCgIpDO>();

		//blCgIpDOArr 为原结算对应的记账明细
		for (BlCgIpDO cgDO : blCgIpDOArr) {
			//新生成红冲数据
			BlCgIpDO redCgDo = (BlCgIpDO) cgDO.clone();
			redCgDo.setId_cgip(null);
			redCgDo.setDt_st(dateTime);
//			redCgDo.setId_par(cgDO.getId_cgip()); //目的是找出新生成数据中收退费的关系
			redCgDo.setEu_direct(cgDO.getEu_direct()*-1);
			redCgDo.setId_stip(blStIpDO.getId_stip());
			//bl ly 2018/10/13 正向数据设置退费数量
			if(redCgDo.getEu_direct() == 1){
				redCgDo.setFg_refund(FBoolean.TRUE);
				redCgDo.setQuan_ret(redCgDo.getQuan());
			}

			redCgDo.setFg_real(FBoolean.FALSE);
			redCgDo.setStatus(DOStatus.NEW);
			redCgList.add(redCgDo);
			//新生成记录最终是对应的原记账记录的备份记录
			BlCgIpDO newCgDo = (BlCgIpDO) cgDO.clone();
			newCgDo.setId_cgip(null);
//			newCgDo.setId_par(cgDO.getId_cgip()); //目的是找出新生成数据中收退费的关系
			newCgDo.setId_stip(cgDO.getId_stip());
			if(newCgDo.getEu_direct() == 1){
				newCgDo.setFg_refund(FBoolean.TRUE);
				newCgDo.setQuan_ret(newCgDo.getQuan());
			}
			newCgDo.setFg_real(FBoolean.FALSE);
			newCgDo.setStatus(DOStatus.NEW);
			newCgList.add(newCgDo);
			
			//原记账记录
			cgDO.setDt_st(null);
			cgDO.setId_stip(null);
			cgDO.setFg_st(FBoolean.FALSE);
			cgDO.setFg_real(FBoolean.TRUE);
			cgDO.setStatus(DOStatus.UPDATED);
			orignalCgList.add(cgDO);			
		}
		//先保存记账数据 再进行对Id_par字段的处理
		//原记录先保存
//		cgCService.save(orignalCgList.toArray(new BlCgIpDO[orignalCgList.size()]));
		DAFacade daf = new DAFacade();
		daf.updateDOArray(orignalCgList.toArray(new BlCgIpDO[orignalCgList.size()]), new String[]{BlCgIpDO.DT_ST,BlCgIpDO.ID_STIP,BlCgIpDO.FG_ST,BlCgIpDO.FG_REAL});
		//保存红冲记录
		cgCService.save(redCgList.toArray(new BlCgIpDO[redCgList.size()]));
		//新记录先保存
		cgCService.save(newCgList.toArray(new BlCgIpDO[newCgList.size()]));	

//		//处理收退关系即id_cgip和id_par	
//		this.handleCgDataRelation(redCgDoArrs);
//		this.handleCgDataRelation(newCgDoArrs);		
	}
	/**
	 * 处理记账数据收退关系字段
	 * @param map
	 * @return
	 * @throws BizException 
	 */
	private void handleCgDataRelation(BlCgIpDO[] cgDoArrs) throws BizException {
		IBlcgqueryCudService cgCService = ServiceFinder.find(IBlcgqueryCudService.class);
		Map<String,BlCgIpDO> map = new HashMap<String,BlCgIpDO>();
		List<BlCgIpDO> list = new ArrayList<BlCgIpDO>();
		//处理收退关系即id_cgip和id_par	
		//找正向数据
		for(BlCgIpDO item : cgDoArrs)
		{
			if(item.getEu_direct() == 1){
				map.put(item.getId_par(),item);
				item.setId_par(null);
				item.setStatus(DOStatus.UPDATED);
				list.add(item);
			}			
		}
		//对于负向记录做处理
		for(BlCgIpDO item:cgDoArrs)
		{
			if(item.getEu_direct() == -1) {
				BlCgIpDO cgIpDo = map.get(item.getId_par());
				//把负向记录赋值为最新的记账主键
				item.setId_par(cgIpDo.getId_cgip());
				item.setStatus(DOStatus.UPDATED);
				list.add(item);
			}			
		}
		cgCService.save(list.toArray(new BlCgIpDO[list.size()]));
	}
	/**
	 * 出院退费--发票信息 红冲票据:取医保计划，如果医保要求打印红冲票据（BD_HP.FG_SABINC =
	 * TRUE）并且红冲票据需要由HIS打印(BD_HP.EU_SABINCPRN = 0)，则生成红冲发票，并且移动票号,
	 * 否则,也生成红冲票据信息，但是incno,code_incpkg,dt_inc,id_emp_inc设为空，fg_print=false
	 * 如果患者没有医保计划,则不生成红冲发票信息 2016-08-18 TCY 修改 2016-11-25 TCY
	 * 修改（如果不打印红冲票，也生成红冲票据信息
	 * ，但是incno,code_incpkg,dt_inc,id_emp_inc设为空，fg_print=false） 2017-4-5
	 * TCY修改，将是否需要打印红冲发票挪到函数IBLCancelSettlement.getFPrintRedInc(id_ent)中
	 * */
	public void setBlStIpIncRefund(OperatorInfoDTO operatorInfoDTO, String id_stip, BlStIpDO blStIpDO, FDateTime dateTime, BlEventInfoDTO blEventInfoDTO) throws BizException {

		// 获得ID_HP主医保计划
		IBlstipRService iBlstipRService = ServiceFinder.find(IBlstipRService.class);
		BlStIpDO[] blStIpDOs0 = iBlstipRService.find(" a0.id_stip='" + id_stip + "'", "", FBoolean.TRUE);
		if (null == blStIpDOs0 || blStIpDOs0.length == 0) {
			throw new BizException("查询原住院结算信息失败");
		}

		// 2017-4-5,查询患者的就诊对应医保计划下，是否需要打印红冲票 修改日期 2017年6月26日 yang.lu 方法迁入到 IBlIncOutQryService.isPrintRedInc中
		IBlIncValidateService service = ServiceFinder.find(IBlIncValidateService.class);
		FBoolean printRedInvoice = service.isPrintRedInc(blStIpDOs0[0].getId_ent());

		IBlincipRService incRService = ServiceFinder.find(IBlincipRService.class);
		IBlincipCudService incCService = ServiceFinder.find(IBlincipCudService.class);
		BlincipAggDO[] blIncIpAggDOArr = incRService.find(" a0.id_stip = '" + id_stip + "'", null, FBoolean.FALSE);
		if (blIncIpAggDOArr == null || blIncIpAggDOArr.length == 0) {
			return;
		}
		// 获取票据编码
		IBLInvoiceService incService = (IBLInvoiceService) ServiceFinder.find(IBLInvoiceService.class);
		String incno = "";
		IBlincQryService incQService = ServiceFinder.find(IBlincQryService.class);
		String code_incpkg = "";
		if(printRedInvoice.booleanValue()){
			code_incpkg = incQService.getCodeIncPkgByIdempiss(operatorInfoDTO.getId_org(), operatorInfoDTO.getId_emp(), IBdInccaCodeConst.ID_INHOS_INVOICE);// 票据包编号
		}

		List<BlincipAggDO> aggDOList = new ArrayList<BlincipAggDO>();
		for (BlincipAggDO aggDO : blIncIpAggDOArr) {
			// 红冲发票
			BlincipAggDO blIncIpAggDO = new BlincipAggDO();
			BlIncIpDO refundDO = (BlIncIpDO) aggDO.getParentDO().clone();
			refundDO.setId_incip(null);
			refundDO.setEu_direct(BookRtnDirectEnum.RETURNS);
			refundDO.setId_incca(IBdInccaCodeConst.ID_INHOS_INVOICE);// 当前票据包分类

			if (printRedInvoice.booleanValue()) { // 红冲发票，需要打印红冲发票信息，才出票据号，票据包号等
				incno = incService.GetInvoiceNo(operatorInfoDTO.getId_emp(), IBdInccaCodeConst.CODE_INHOS_INVOICE);
				refundDO.setCode_incpkg(code_incpkg);// 当前票据包编码
				refundDO.setIncno(incno);
				refundDO.setDt_inc(dateTime);
				refundDO.setId_emp_inc(operatorInfoDTO.getId_emp());
				refundDO.setTimes_prn(1);
				refundDO.setFg_print(FBoolean.TRUE);
				// 打印了红冲票，需要重设当前发票号
				String curno = String.valueOf(Long.parseLong(incno) + 1);
				incService.SetCurNoByParamNo(operatorInfoDTO.getId_emp(), IBdInccaCodeConst.ID_OUTPATIENT_INVOICE, curno);
			} else {
				refundDO.setCode_incpkg(null);
				refundDO.setIncno("");
				refundDO.setDt_inc(null);
				refundDO.setId_emp_inc("");
				refundDO.setTimes_prn(0);
				refundDO.setFg_print(FBoolean.FALSE);
			}
			refundDO.setId_stip(blStIpDO.getId_stip());

			refundDO.setFg_cc_out(FBoolean.FALSE);
			refundDO.setFg_cc_in(FBoolean.FALSE);
			refundDO.setStatus(DOStatus.NEW);
			blIncIpAggDO.setParentDO(refundDO);
			if (aggDO.getBlIncItmIpDO() != null) {
				List<BlIncItmIpDO> incItmIpList = new ArrayList<BlIncItmIpDO>();
				for (BlIncItmIpDO blIncItmIpDO : aggDO.getBlIncItmIpDO()) {
					BlIncItmIpDO incItmDO = (BlIncItmIpDO) blIncItmIpDO.clone();
					incItmDO.setId_incitmip(null);
					incItmDO.setId_incip(null);
					incItmDO.setStatus(DOStatus.NEW);
					incItmIpList.add(incItmDO);
				}
				blIncIpAggDO.setBlIncItmIpDO(incItmIpList.toArray(new BlIncItmIpDO[] {}));
			}
			if (aggDO.getBlStIncIpDO() != null) {
				List<BlStIncIpDO> stIncIpList = new ArrayList<BlStIncIpDO>();
				for (BlStIncIpDO blStIncIpDO : aggDO.getBlStIncIpDO()) {
					BlStIncIpDO stIncIpDO = (BlStIncIpDO) blStIncIpDO.clone();
					stIncIpDO.setId_stincip(null);
					stIncIpDO.setId_incip(null);
					stIncIpDO.setId_stip(blStIpDO.getId_stip());
					stIncIpDO.setStatus(DOStatus.NEW);
					stIncIpList.add(stIncIpDO);
				}
				blIncIpAggDO.setBlStIncIpDO(stIncIpList.toArray(new BlStIncIpDO[] {}));
			}
			aggDOList.add(blIncIpAggDO);
			blEventInfoDTO.setBlincipAggDO(blIncIpAggDO);

			// 原发票记录修改
			aggDO.getParentDO().setFg_canc(FBoolean.TRUE);
			aggDO.getParentDO().setSd_reason_canc("01");
			aggDO.getParentDO().setDes_reason_canc("退费");
			aggDO.getParentDO().setDt_canc(dateTime);
			aggDO.getParentDO().setId_emp_canc(operatorInfoDTO.getId_emp());
			//TODO yangyang 住院发票退费红冲后原发票打印标识变为了false，有争议，先注释掉
//			aggDO.getParentDO().setFg_print(FBoolean.FALSE);
			aggDO.getParentDO().setStatus(DOStatus.UPDATED);
			aggDOList.add(aggDO);
		}
		incCService.save(aggDOList.toArray(new BlincipAggDO[] {}));
	}

	/**
	 * 该方法供退费重算调用，和setBlStIpRefund方法唯一的不同就是eu_sttp的赋值不同。0191652
	 * @param operatorInfoDTO
	 * @param id_stip
	 * @param dateTime
	 * @param blEventInfoDTO
	 * @return
	 * @throws BizException
	 */
	private BlStIpDO setBlStIpByRefundReRun(OperatorInfoDTO operatorInfoDTO, String id_stip, FDateTime dateTime, BlEventInfoDTO blEventInfoDTO) throws BizException {
		IBlstipRService stRService = ServiceFinder.find(IBlstipRService.class);
		IBlstipCudService stCService = ServiceFinder.find(IBlstipCudService.class);
		BlStIpDO blStIpDO = stRService.findById(id_stip);

		BlStIpDO stIpDO = (BlStIpDO) blStIpDO.clone();
		// stIpDO.setId_org(operatorInfoDTO.getId_org());
		// stIpDO.setId_pat(blStIpDO.getId_pat());
		// stIpDO.setId_ent(blStIpDO.getId_ent());
		// stIpDO.setId_enttp(blStIpDO.getId_enttp());
		stIpDO.setId_stip(null);
		if (BookRtnDirectEnum.CHARGE == blStIpDO.getEu_direct()) {
			stIpDO.setEu_direct(BookRtnDirectEnum.RETURNS);
		} else {
			stIpDO.setEu_direct(BookRtnDirectEnum.CHARGE);
		}
		stIpDO.setEu_sttp(StTypeEnum.ST_INP_RED);
		// IBillcodeManage
		// billService=ServiceFinder.find(IBillcodeManage.class);
		// stIpDO.setCode_st(billService.getPreBillCode_RequiresNew(BlStIpDODesc.CLASS_FULLNAME));//结算号
		GetCodeByCustomization code_ins = new GetCodeByCustomization();
		stIpDO.setCode_st(code_ins.GetCodeStIp());// 结算号

		// stIpDO.setCode_st("-" + blStIpDO.getCode_st());
		stIpDO.setDt_st(dateTime);
		stIpDO.setId_dep_st(operatorInfoDTO.getId_dep());
		stIpDO.setId_emp_st(operatorInfoDTO.getId_emp());
		stIpDO.setFg_cc(FBoolean.FALSE);
		stIpDO.setId_cc(null);
		stIpDO.setFg_canc(FBoolean.FALSE);
		stIpDO.setId_emp_can(null);
		stIpDO.setDt_canc(null);
		stIpDO.setSd_reason_canc(null);
		stIpDO.setDes_reason_canc(null);
		stIpDO.setFg_arclear(FBoolean.TRUE);
		stIpDO.setId_propip(null);
		stIpDO.setId_par(id_stip);
		stIpDO.setFg_pay(FBoolean.TRUE);
		stIpDO.setId_stresult(IBlDictCodeConst.ID_STRESULT_NORMAL);
		stIpDO.setSd_stresult(IBlDictCodeConst.SD_STRESULT_NORMAL);
		stIpDO.setStatus(DOStatus.NEW);
		BlStIpDO[] stIpDOArr = stCService.save(new BlStIpDO[] { stIpDO });

		blEventInfoDTO.setBlStIpDO(stIpDOArr[0]);// 红冲结算信息

		blStIpDO.setFg_canc(FBoolean.TRUE);
		blStIpDO.setId_emp_can(operatorInfoDTO.getId_emp());
		blStIpDO.setDt_canc(dateTime);
		blStIpDO.setId_reason_canc(IBlDictCodeConst.BD_REFUND_SETTLE_CANCELLED_ID);
		blStIpDO.setSd_reason_canc(IBlDictCodeConst.BD_REFUND_SETTLE_CANCELLED);
		blStIpDO.setDes_reason_canc("退费");
		blStIpDO.setStatus(DOStatus.UPDATED);
		stCService.save(new BlStIpDO[] { blStIpDO });

		return stIpDOArr[0];
	}
	
	/**
	 * 出院退费--结算信息
	 * */
	public BlStIpDO setBlStIpRefund(OperatorInfoDTO operatorInfoDTO, String id_stip, FDateTime dateTime, BlEventInfoDTO blEventInfoDTO) throws BizException {
		IBlstipRService stRService = ServiceFinder.find(IBlstipRService.class);
		IBlstipCudService stCService = ServiceFinder.find(IBlstipCudService.class);
		BlStIpDO blStIpDO = stRService.findById(id_stip);

		BlStIpDO stIpDO = (BlStIpDO) blStIpDO.clone();
		// stIpDO.setId_org(operatorInfoDTO.getId_org());
		// stIpDO.setId_pat(blStIpDO.getId_pat());
		// stIpDO.setId_ent(blStIpDO.getId_ent());
		// stIpDO.setId_enttp(blStIpDO.getId_enttp());
		stIpDO.setId_stip(null);
		if (BookRtnDirectEnum.CHARGE == blStIpDO.getEu_direct()) {
			stIpDO.setEu_direct(BookRtnDirectEnum.RETURNS);
		} else {
			stIpDO.setEu_direct(BookRtnDirectEnum.CHARGE);
		}
		stIpDO.setEu_sttp(StTypeEnum.ST_INP_CANC);
		// IBillcodeManage
		// billService=ServiceFinder.find(IBillcodeManage.class);
		// stIpDO.setCode_st(billService.getPreBillCode_RequiresNew(BlStIpDODesc.CLASS_FULLNAME));//结算号
		GetCodeByCustomization code_ins = new GetCodeByCustomization();
		stIpDO.setCode_st(code_ins.GetCodeStIp());// 结算号

		// stIpDO.setCode_st("-" + blStIpDO.getCode_st());
		stIpDO.setDt_st(dateTime);
		stIpDO.setId_dep_st(operatorInfoDTO.getId_dep());
		stIpDO.setId_emp_st(operatorInfoDTO.getId_emp());
		stIpDO.setFg_cc(FBoolean.FALSE);
		stIpDO.setId_cc(null);
		stIpDO.setFg_canc(FBoolean.FALSE);
		stIpDO.setId_emp_can(null);
		stIpDO.setDt_canc(null);
		stIpDO.setSd_reason_canc(null);
		stIpDO.setDes_reason_canc(null);
		stIpDO.setFg_arclear(FBoolean.TRUE);
		stIpDO.setId_propip(null);
		stIpDO.setId_par(id_stip);
		stIpDO.setFg_pay(FBoolean.TRUE);
		stIpDO.setId_stresult(IBlDictCodeConst.ID_STRESULT_NORMAL);
		stIpDO.setSd_stresult(IBlDictCodeConst.SD_STRESULT_NORMAL);
		stIpDO.setStatus(DOStatus.NEW);
		BlStIpDO[] stIpDOArr = stCService.save(new BlStIpDO[] { stIpDO });

		blEventInfoDTO.setBlStIpDO(stIpDOArr[0]);// 红冲结算信息

		blStIpDO.setFg_canc(FBoolean.TRUE);
		blStIpDO.setId_emp_can(operatorInfoDTO.getId_emp());
		blStIpDO.setDt_canc(dateTime);
		blStIpDO.setId_reason_canc(IBlDictCodeConst.BD_REFUND_SETTLE_CANCELLED_ID);
		blStIpDO.setSd_reason_canc(IBlDictCodeConst.BD_REFUND_SETTLE_CANCELLED);
		blStIpDO.setDes_reason_canc("退费");
		blStIpDO.setStatus(DOStatus.UPDATED);
		stCService.save(new BlStIpDO[] { blStIpDO });

		return stIpDOArr[0];
	}
	/**
	 * 出院退费 红冲医保分摊信息
	 * @param id_stip
	 * @return
	 */
	public FBoolean RegressesMiHpPropRuralIpTmpDO(String id_stip)throws BizException{
		if (id_stip.isEmpty()) {
			throw new BizException("结算主键为空");
		}
		IMihppropruraliptmpCudService cudService=ServiceFinder.find(IMihppropruraliptmpCudService.class);
		IMihppropruraliptmpRService rService=ServiceFinder.find(IMihppropruraliptmpRService.class);
		MiHpPropRuralIpTmpDO[] hpPropRuralCoopDoArr=rService.findByAttrValString(MiHpPropRuralIpTmpDO.ID_REF,id_stip);
		if(ArrayUtils.isEmpty(hpPropRuralCoopDoArr)){
			throw new BizException("未找到原医保分摊信息！");
		}
		
		//分摊数据初始化
				MiHpPropRuralIpTmpDO propDataOld=hpPropRuralCoopDoArr[0];
				MiHpPropRuralIpTmpDO propBackData=new MiHpPropRuralIpTmpDO();
				propBackData.setAmt_all(propDataOld.getAmt_all());
				propBackData.setAmt_pat(propDataOld.getAmt_pat());
				propBackData.setHppolicy(propDataOld.getHppolicy());
				propBackData.setAmt_hpactual(propDataOld.getAmt_hpactual());
				propBackData.setAmt_hp(propDataOld.getAmt_hp());
				propBackData.setAmt_drgs(propDataOld.getAmt_drgs());
				propBackData.setAmt_sill(propDataOld.getAmt_sill());
				propBackData.setAmt_sill_actual(propDataOld.getAmt_sill_actual());
				propBackData.setAmt_civil(propDataOld.getAmt_civil());
				propBackData.setRatio_hp(propDataOld.getRatio_hp());
				propBackData.setAmt_accumyear(propDataOld.getAmt_accumyear());
				propBackData.setAmt_lower(propDataOld.getAmt_lower());
				propBackData.setAmt_top(propDataOld.getAmt_top());
				propBackData.setAmt_deduc(propDataOld.getAmt_deduc());
				propBackData.setAmt_advance(propDataOld.getAmt_advance());
				propBackData.setId_ref(id_stip);
				propBackData.setTimes_accumyear(propDataOld.getTimes_accumyear());
				//分摊方向
				propBackData.setEu_direct(HpPropDirectEnum.HPBACK);
				propBackData.setStatus(DOStatus.NEW);
				MiHpPropRuralIpTmpDO[] ruralCoopDos=cudService.save(new MiHpPropRuralIpTmpDO[]{propBackData});
		return FBoolean.TRUE;
	}
	/**
	 * 出院退费--结算收付款信息
	 * */
	public FDouble setBlStIpPayRefund(OperatorInfoDTO operatorInfoDTO, String id_stip, BlStIpDO blStIpDO, FDateTime dateTime, BlEventInfoDTO blEventInfoDTO,String id_paypat) throws BizException {
		IBlpaypatipRService payRService = ServiceFinder.find(IBlpaypatipRService.class);
		IBlpaypatipCudService payCService = ServiceFinder.find(IBlpaypatipCudService.class);
		BlpaypatipAggDO[] blPayPatIpAggDOArr = payRService.find(" a0.id_stip = '" + id_stip + "'", null, FBoolean.FALSE);
		if (blPayPatIpAggDOArr == null || blPayPatIpAggDOArr.length == 0) {
			return new FDouble("0.00");
		}
		// BlpaypatipAggDO aggDO = blPayPatIpAggDOArr[0];
		List<BlPayItmPatIpDO> payList = new ArrayList<BlPayItmPatIpDO>();
		FDouble amt_pay = new FDouble("0.00");
		FDouble amt_pre = new FDouble("0.00");
		FBoolean fg_free = FBoolean.FALSE;
//		//获取支付方式对应的付款方式类型 by lim 2018-08-31
//		Map<String,String> pmTpMap=BlBaseInfoUtils.getPmTpInfo();
//		String[] noPayArr= new String[]{IBdPripmCodeConst.SD_PRI_PM_TP_TRANSFE,IBdPripmCodeConst.SD_PRI_PM_TP_COMPANY,IBdPripmCodeConst.SD_PRI_PM_TP_OTHER};
		
		//查询所有支付方式字典
		Map<String,PriPmDO> pmMap=BlBaseInfoUtils.getPmDOInfo();
		
		for (BlpaypatipAggDO payPatAggDO : blPayPatIpAggDOArr) {
			amt_pay = amt_pay.add(payPatAggDO.getParentDO().getAmt());
			for (BlPayItmPatIpDO blPayItmPatIpDO : payPatAggDO.getBlPayItmPatIpDO()) {
				payList.add(blPayItmPatIpDO);
				if (IBdPripmCodeConst.CODE_PRI_PM_MONEYDEDUCTION.equals(blPayItmPatIpDO.getSd_pm()) || IBdPripmCodeConst.CODE_PRI_PM_SRVDEDUCTION.equals(blPayItmPatIpDO.getSd_pm())) {
					fg_free = FBoolean.TRUE;
				} else {
//					if(!MapUtils.isEmpty(pmTpMap) &&!Tools.getStrInArr(noPayArr, pmTpMap.get(blPayItmPatIpDO.getId_pm()))){
//						amt_pre = amt_pre.add(blPayItmPatIpDO.getAmt().multiply(blPayItmPatIpDO.getEu_direct()));
//					}
					PriPmDO pm=pmMap.get(blPayItmPatIpDO.getId_pm());
					if(FBoolean.FALSE.equals(pm.getFg_ori_rtn())){
						amt_pre = amt_pre.add(blPayItmPatIpDO.getAmt().multiply(blPayItmPatIpDO.getEu_direct()));
					
					}
				}
			}
		}

		// 红冲数据
		BlpaypatipAggDO payAggDO = new BlpaypatipAggDO();

		BlPayPatIpDO payIpDO = new BlPayPatIpDO();
		payIpDO.setId_paypatip(null);
		payIpDO.setId_grp(operatorInfoDTO.getId_grp());
		payIpDO.setId_org(operatorInfoDTO.getId_org());
		payIpDO.setId_stip(blStIpDO.getId_stip());
		payIpDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_CANCELST);
		payIpDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_CANCELST);
		payIpDO.setId_pat(blStIpDO.getId_pat());
		payIpDO.setId_ent(blStIpDO.getId_ent());
		payIpDO.setId_enttp(blStIpDO.getId_enttp());
		payIpDO.setCode_enttp(blStIpDO.getCode_enttp());
		// payIpDO.setEu_direct(aggDO.getParentDO().getEu_direct() * -1);
		payIpDO.setEu_direct(BookRtnDirectEnum.RETURNS);
		// payIpDO.setAmt(blStIpDO.getAmt());//收退款金额(个人负担金额)
		payIpDO.setAmt(amt_pay);// 收退款金额(个人负担金额)
		payIpDO.setDt_pay(dateTime);
		payIpDO.setId_org_pay(operatorInfoDTO.getId_org());
		payIpDO.setId_dep_pay(operatorInfoDTO.getId_dep());
		payIpDO.setId_emp_pay(operatorInfoDTO.getId_emp());
		payIpDO.setId_cc(null);
		payIpDO.setFg_cc(FBoolean.FALSE);
		payIpDO.setNote("取消结算");
		payIpDO.setStatus(DOStatus.NEW);
		payAggDO.setParentDO(payIpDO);

		// if(aggDO.getBlPayItmPatIpDO() != null &&
		// aggDO.getBlPayItmPatIpDO().length > 0){
		// List<BlPayItmPatIpDO> payItmIpList = new
		// ArrayList<BlPayItmPatIpDO>();
		// for(BlPayItmPatIpDO blPayItmPatIpDO : aggDO.getBlPayItmPatIpDO()){
		// BlPayItmPatIpDO payItmDO = new BlPayItmPatIpDO();
		// payItmDO.setId_payitmpatip(null);
		// payItmDO.setId_paypatip(null);
		// payItmDO.setId_org(operatorInfoDTO.getId_org());
		// payItmDO.setEu_direct(blPayItmPatIpDO.getEu_direct() * -1);
		// payItmDO.setId_pm(blPayItmPatIpDO.getId_pm());
		// payItmDO.setSd_pm(blPayItmPatIpDO.getSd_pm());
		// payItmDO.setAmt(blPayItmPatIpDO.getAmt());
		// payItmDO.setId_bank(null);
		// payItmDO.setBankno(null);
		// payItmDO.setPaymodenode(null);
		// payItmDO.setStatus(DOStatus.NEW);
		// payItmIpList.add(payItmDO);
		// }
		// payAggDO.setBlPayItmPatIpDO(payItmIpList.toArray(new
		// BlPayItmPatIpDO[]{}));
		// }
		// List<BlPayItmPatIpDO> payItmIpList = new
		// ArrayList<BlPayItmPatIpDO>();
		// BlPayItmPatIpDO payItmDO = new BlPayItmPatIpDO();
		// payItmDO.setId_payitmpatip(null);
		// payItmDO.setId_paypatip(null);
		// payItmDO.setId_org(operatorInfoDTO.getId_org());
		// payItmDO.setEu_direct(BookRtnDirectEnum.RETURNS);
		// payItmDO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_CASH);
		// payItmDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CASH);
		// //payItmDO.setAmt(blStIpDO.getAmt());
		// payItmDO.setAmt(amt_pay);
		// payItmDO.setId_bank(null);
		// payItmDO.setBankno(null);
		// payItmDO.setPaymodenode(null);
		// // if(blPayPatIpAggDOArr[0].getBlPayItmPatIpDO() != null &&
		// blPayPatIpAggDOArr[0].getBlPayItmPatIpDO().length > 0){
		// //
		// payItmDO.setPaymodenode(blPayPatIpAggDOArr[0].getBlPayItmPatIpDO()[0].getPaymodenode());
		// // }
		// payItmDO.setFg_realpay(FBoolean.TRUE);//新加字段
		// payItmDO.setStatus(DOStatus.NEW);
		// payItmIpList.add(payItmDO);

		List<BlPayItmPatIpDO> payItmIpList = new ArrayList<BlPayItmPatIpDO>();
//		if (fg_free.booleanValue()) {
//			FDouble amt_pre_free = new FDouble("0.00");
//			FDouble amt_pay_no_free = new FDouble("0.00");
//			for (BlPayItmPatIpDO blPayItmPatIpDO : payList) {
//				if (IBdPripmCodeConst.CODE_PRI_PM_MONEYDEDUCTION.equals(blPayItmPatIpDO.getSd_pm()) || IBdPripmCodeConst.CODE_PRI_PM_SRVDEDUCTION.equals(blPayItmPatIpDO.getSd_pm())) {
//					amt_pre_free = amt_pre_free.add(blPayItmPatIpDO.getAmt().multiply(blPayItmPatIpDO.getEu_direct()));
//				} else {
//					amt_pay_no_free = amt_pay_no_free.add(blPayItmPatIpDO.getAmt().multiply(blPayItmPatIpDO.getEu_direct()));
//				}
//			}
//			payItmIpList.add(this.getNewBlPayPatItmDO(operatorInfoDTO.getId_org(), amt_pre_free, payList.get(0).getId_pm(), payList.get(0).getSd_pm(),""));
//			if (amt_pay_no_free.doubleValue() > 0) {
//				payItmIpList.add(this.getNewBlPayPatItmDO(operatorInfoDTO.getId_org(), amt_pay_no_free, IBdPripmCodeConst.ID_PRI_PM_CASH, IBdPripmCodeConst.CODE_PRI_PM_CASH,""));
//			}
//		} else {
		FDouble amt = new FDouble("0.00");
		for (BlPayItmPatIpDO blPayItmPatIpDO : payList) {
			PriPmDO pmdo=pmMap.get(blPayItmPatIpDO.getId_pm());
			if(FBoolean.TRUE.equals(pmdo.getFg_ori_rtn())||IBdPripmCodeConst.CODE_PRI_PM_MONEYDEDUCTION.equals(blPayItmPatIpDO.getSd_pm()) || IBdPripmCodeConst.CODE_PRI_PM_SRVDEDUCTION.equals(blPayItmPatIpDO.getSd_pm())){
				payItmIpList.add(this.getNewBlPayPatItmDO(operatorInfoDTO.getId_org(), blPayItmPatIpDO.getAmt().multiply(blPayItmPatIpDO.getEu_direct()), pmdo.getId_pm(), pmdo.getCode(),null));
				
			}else{
				amt = amt.add(blPayItmPatIpDO.getAmt().multiply(blPayItmPatIpDO.getEu_direct()));
			}
		}
		if(amt.compareTo(FDouble.ZERO_DBL)>0){
			payItmIpList.add(this.getNewBlPayPatItmDO(operatorInfoDTO.getId_org(), amt, IBdPripmCodeConst.ID_PRI_PM_CASH, IBdPripmCodeConst.CODE_PRI_PM_CASH,id_paypat));

		}
		//		}
		payAggDO.setBlPayItmPatIpDO(payItmIpList.toArray(new BlPayItmPatIpDO[] {}));

		BlpaypatipAggDO[] payAggDOArr = payCService.save(new BlpaypatipAggDO[] { payAggDO });

		blEventInfoDTO.setBlpaypatipRedAggDO(payAggDOArr[0]);// 红冲结算收付款信息

		// 修改红冲结算信息
		if (payAggDOArr == null || payAggDOArr.length == 0) {
			throw new BizException("红冲结算收付款信息失败！");
		}
		IBlstipCudService stCService = ServiceFinder.find(IBlstipCudService.class);
		blStIpDO.setFg_pay(FBoolean.TRUE);
		blStIpDO.setStatus(DOStatus.UPDATED);
		stCService.save(new BlStIpDO[] { blStIpDO });

		blEventInfoDTO.setBlStIpRedDO(blStIpDO);// 红冲结算信息

		return amt_pre.abs();
	}

	/**
	 * 组装收付款明细数据
	 * */
	public BlPayItmPatIpDO getNewBlPayPatItmDO(String id_org, FDouble amt_pay, String id_pm, String sd_pm,String id_paypat) {
		BlPayItmPatIpDO payItmDO = new BlPayItmPatIpDO();
		payItmDO.setId_payitmpatip(null);
		payItmDO.setId_paypatip(null);
		payItmDO.setId_org(id_org);
		payItmDO.setEu_direct(BookRtnDirectEnum.RETURNS);
		payItmDO.setId_pm(id_pm);
		payItmDO.setSd_pm(sd_pm);
		payItmDO.setAmt(amt_pay);
		payItmDO.setId_bank(null);
		payItmDO.setBankno(null);
		payItmDO.setPaymodenode(null);
		payItmDO.setFg_realpay(FBoolean.TRUE);// 新加字段
		if(StringUtils.isNotEmpty(id_paypat)){
			payItmDO.setId_paypat(id_paypat);
		}
		payItmDO.setStatus(DOStatus.NEW);
		return payItmDO;
	}

	/**
	 * 出院退费--修改预交金信息
	 * */
	public BlPrePayPatDO setBlPrePayInfoByRefund(BlStIpDO blStIpDO, FDouble amt_pay, String sd_pttp,FBoolean isOriginalAmt) throws BizException {
		if (amt_pay.doubleValue() == 0) {
			return null;
		}
		if(!isOriginalAmt.booleanValue()) {
			BlPrePayPatDO blPayPatDO = new BlPrePayPatDO();
			blPayPatDO.setId_org(Context.get().getOrgId());
			blPayPatDO.setId_grp(Context.get().getGroupId());
			blPayPatDO.setId_dep_pay(Context.get().getDeptId());
			blPayPatDO.setId_org_pay(Context.get().getOrgId());
			blPayPatDO.setId_emp_pay(Context.get().getStuffId());
			blPayPatDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_IPPREPAY);
			blPayPatDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_IPPREPAY);
			blPayPatDO.setId_pat(blStIpDO.getId_pat());
			blPayPatDO.setId_ent(blStIpDO.getId_ent());
			blPayPatDO.setId_enttp(blStIpDO.getId_enttp());
			blPayPatDO.setCode_enttp(blStIpDO.getCode_enttp());
			blPayPatDO.setId_st_mid(blStIpDO.getId_stip());
			blPayPatDO.setEu_direct(BookRtnDirectEnum.CHARGE);
			blPayPatDO.setAmt(amt_pay);
			blPayPatDO.setId_pm(IBdPripmCodeConst.ID_PRI_PM_CASH);
			blPayPatDO.setSd_pm(IBdPripmCodeConst.CODE_PRI_PM_CASH);
			TimeService timeService = new TimeServiceImpl();// 获取当前服务器时间
			FDateTime dateTime = timeService.getUFDateTime();
			blPayPatDO.setDt_pay(dateTime);
			blPayPatDO.setSd_pttp(sd_pttp);
			blPayPatDO.setNote("取消结算退回");
			blPayPatDO.setStatus(DOStatus.NEW);

			// 获取票据编码
			IBlIncUtilService incService = ServiceFinder.find(IBlIncUtilService.class);
			//IBLInvoiceService incService = (IBLInvoiceService) ServiceFinder.find(IBLInvoiceService.class);
			blPayPatDO.setCode_rep(incService.getCurInvoiceNo(Context.get().getStuffId(), Context.get().getClientHost(), IBdInccaCodeConst.ID_INHOS_DEPOSIT));
			blPayPatDO.setId_incca(IBdInccaCodeConst.ID_INHOS_DEPOSIT);
			blPayPatDO.setCode_incca(IBdInccaCodeConst.CODE_INHOS_DEPOSIT);

			IBlpaypatCudService payService = (IBlpaypatCudService) ServiceFinder.find(IBlpaypatCudService.class);
			BlPrePayPatDO[] blPrePayPatDOArr = payService.save(new BlPrePayPatDO[] { blPayPatDO });
			if (blPrePayPatDOArr == null || blPrePayPatDOArr.length == 0) {
				throw new BizException("预交金保存失败！");
			}
			//incService.NextInvoiceNoUpdateCurNo(blPayPatDO.getId_emp_pay(),	IBdInccaCodeConst.CODE_INHOS_DEPOSIT);// 票据编码修改
			incService.nextInvoiceNo(blPayPatDO.getId_emp_pay(), Context.get().getClientHost(), IBdInccaCodeConst.ID_INHOS_DEPOSIT);
			
			IBlpaypatRService service = ServiceFinder.find(IBlpaypatRService.class);
			BlPrePayPatDO blPrePayPatDO = service.findById(blPrePayPatDOArr[0].getId_paypat());
			return blPrePayPatDO;
		} else {
			//1、根据就诊id查询bl_prepay_pat预交金信息
			List<BlPrePayPatDO> prePayList = (List<BlPrePayPatDO>) new DAFacade().findByAttrValString(BlPrePayPatDO.class, "Id_ent", blStIpDO.getId_ent(), null);
			
			//2、红冲消费类型22的数据，且更新12类型记录可用
			List<BlPrePayPatDO> newPrePayList =  new ArrayList<BlPrePayPatDO>();
			for(BlPrePayPatDO prePayDo : prePayList) {
				if(prePayDo.getEu_direct() > 0) {
					prePayDo.setFg_rep_return(FBoolean.FALSE);
					prePayDo.setDt_return(null);
					prePayDo.setId_emp_return("~");
					prePayDo.setId_st_mid("~");
					prePayDo.setNote(null);
					prePayDo.setStatus(DOStatus.UPDATED);
					newPrePayList.add(prePayDo);
				} else {
					BlPrePayPatDO redPrePayDo = (BlPrePayPatDO)prePayDo.clone();
					redPrePayDo.setId_paypat(null);
					redPrePayDo.setEu_direct(prePayDo.getEu_direct()*BookRtnDirectEnum.RETURNS);
					redPrePayDo.setId_st_mid(blStIpDO.getId_stip());
					redPrePayDo.setId_par(prePayDo.getId_paypat());
					redPrePayDo.setNote("红冲已回收的预交金票据");
					redPrePayDo.setStatus(DOStatus.NEW);
					newPrePayList.add(redPrePayDo);
				}
			}
			IBlpaypatCudService payService = (IBlpaypatCudService) ServiceFinder.find(IBlpaypatCudService.class);
			BlPrePayPatDO[] blPrePayPatDOArr = payService.save(newPrePayList.toArray(new BlPrePayPatDO[] { }));
			if (blPrePayPatDOArr == null || blPrePayPatDOArr.length == 0) {
				throw new BizException("预交金保存失败！");
			}
			return null;
		}
	}

	/**
	 * 出院退费--修改就诊账户信息
	 * */
	public void setEntEntAccoutInfoByRefund(BlStIpDO blStIpDO, FDouble amt_pay) throws BizException {
		IEnOutCmdService inpPatAccImpls = ServiceFinder.find(IEnOutCmdService.class);
//		// 消费金额
//		inpPatAccImpls.consume(blStIpDO.getId_ent(), blStIpDO.getAmt_ratio());
		
		// 处理婴儿单独结算
		IEn4BlQryService enService = ServiceFinder.find(IEn4BlQryService.class);
		EnMomBabyInfoDTO[] dtos = enService.getMomBabyInfos(new String[] { blStIpDO.getId_ent() });
		// 母亲entid
		String entId_Mom = null;
		FBoolean isBb = FBoolean.FALSE;

		if (!ArrayUtil.isEmpty(dtos)) {
			for (EnMomBabyInfoDTO dto : dtos) {
				if (blStIpDO.getId_ent().equals(dto.getId_ent_bb())) {
					isBb = FBoolean.TRUE;
					entId_Mom = dto.getId_ent_mom();
					break;
				}
			}
		}
		// 婴儿是否使用母亲账户
		FBoolean isUseMmAcc = BlParams.BLSTIP0026();

		if (FBoolean.TRUE.equals(isBb) && FBoolean.TRUE.equals(isUseMmAcc)) {
			// 更新母亲账户锁定
			if (!StringUtil.isEmpty(entId_Mom)) {
				inpPatAccImpls.consume(entId_Mom, blStIpDO.getAmt_ratio());
			} else {
				throw new BizException("婴儿：" + blStIpDO.getId_ent() + " 对应的母亲就诊信息为空");
			}
		} else {
			// 修改消费金额
			inpPatAccImpls.consume(blStIpDO.getId_ent(), blStIpDO.getAmt_ratio());
		}

		
		// inpPatAccImpls.recharge(blStIpDO.getId_ent(), blStIpDO.getAmt());
		if(FBoolean.TRUE.equals(BlParams.BLSTIP0014())){
			// 充值金额
			inpPatAccImpls.recharge(blStIpDO.getId_ent(), amt_pay);
		}
	}

	/**
	 * 出院退费--修改就诊信息
	 * 
	 * @throws BizException
	 * */
	public void setEnEntInfoByIdStip(String id_stip, BlEventInfoDTO blEventInfoDTO) throws BizException {
		IBlstipRService stRService = ServiceFinder.find(IBlstipRService.class);
		BlStIpDO blStIpDO = stRService.findById(id_stip);

		IPativisitRService entService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO = entService.findById(blStIpDO.getId_ent());

		if (StTypeEnum.ST_INP.equals(blStIpDO.getEu_sttp())) {
			//1. 判断是否母婴合并结算  且 获取就诊信息
			FBoolean isMerge =  BlParams.BLSTIP0005();
			IpStEP stEP = new IpStEP();
			//母婴合合并结算时，同时更新婴儿
			if(FBoolean.TRUE.equals(isMerge)){
				List<NewbornDO> list = (List<NewbornDO>)new DAFacade().findByAttrValString(NewbornDO.class, "Id_ent_mom", patiVisitDO.getId_ent(), null);
				if(list != null && !list.isEmpty()){
					for (NewbornDO newbornDO : list) {
						PatiVisitDO bbDo = stEP.getPatiEntInfo(newbornDO.getId_ent_bb());
						this.updateEntStFlag(bbDo);
					}
				} 
				this.updateEntStFlag(patiVisitDO);				
			}else {
				this.updateEntStFlag(patiVisitDO);
			}
		}

		blEventInfoDTO.setPatiVisitDO(patiVisitDO);
	}
	
	/**
	 * 更新就诊的结算状态为未结算
	 * @param patiVisitDO
	 * @throws BizException 
	 */
	private void updateEntStFlag(PatiVisitDO patiVisitDO) throws BizException
	{
		IPativisitCudService entCService = ServiceFinder.find(IPativisitCudService.class);
		patiVisitDO.setFg_st(FBoolean.FALSE);
		patiVisitDO.setStatus(DOStatus.UPDATED);
		entCService.save(new PatiVisitDO[] { patiVisitDO });
	}

	/**
	 * 获取住院收付款节点对应的就诊信息（已结算，未付款）
	 * */
	@SuppressWarnings({ "unchecked" })
	public PatiVisitDO[] getBlStIpPayBanner(String id_pat) throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append("select distinct t.id_ent,t.code,t.name_pat ").append("from en_ent t ")
		// .append("inner join bl_st_ip s on s.id_ent = t.id_ent ")
				.append("where t.id_pat = '").append(id_pat).append("' ").append("and t.code_entp = 10 ").append("and t.fg_canc = 'N' ");
		// .append("and t.fg_st = 'Y' ")
		// .append("and s.fg_pay = 'N' ");
		List<PatiVisitDO> list = (List<PatiVisitDO>) new DAFacade().execQuery(sql.toString(), new BeanListHandler(PatiVisitDO.class));
		return list.toArray(new PatiVisitDO[] {});
	}

	/**
	 * 获取住院结算退费节点对应的就诊信息（已结算，已付款）
	 * */
	@SuppressWarnings("unchecked")
	public PatiVisitDO[] getBlStIpPayRefundBanner(String id_pat) throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append("select distinct t.id_ent,t.code,t.name_pat ").append("from en_ent t ").append("inner join bl_st_ip s on s.id_ent = t.id_ent ").append("where t.id_pat = '").append(id_pat)
				.append("' ").append("and t.code_entp = 10 ").append("and t.fg_canc = 'N' ")
				// .append("and t.fg_st = 'Y' ")
				.append("and s.fg_pay = 'Y' ");
		List<PatiVisitDO> list = (List<PatiVisitDO>) new DAFacade().execQuery(sql.toString(), new BeanListHandler(PatiVisitDO.class));
		return list.toArray(new PatiVisitDO[] {});
	}

	/**
	 * 根据banner中输入值查询相关患者就诊信息(结算收付款)
	 * */
	@SuppressWarnings("unchecked")
	public BlBannerDTO[] getStPayBannerEnEntInfo(String inputValue, String[] selectCondition) throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append("select distinct(t.id_ent),p.id_pat,p.name as name_pat,t.code as code_ent,t.dt_entry as dt_in,e.times_ip,r.id_pripat,r.name as name_pripat,h.id_hp,h.name as name_hp,t.fg_ip,t.id_dep_nur ,dep.name name_dep_nur,e.name_bed ")
				.append(" ,hpca.name_hppatca ,medkind.name as name_hpmedkind 	") 
				.append("from en_ent t ")
				.append("left join pi_pat p on p.id_pat = t.id_pat ")
				.append("left join en_ent_ip e on e.id_ent = t.id_ent ")
				.append("left join bd_pri_pat r on r.id_pripat = t.id_pripat ")
				.append("left join en_ent_hp n on n.id_ent = t.id_ent and n.fg_maj = 'Y' ")
				.append("left join bd_hp h on h.id_hp = n.id_hp ")
				.append("left outer join bl_st_ip s on s.id_ent = t.id_ent ")
				.append("left outer join pi_pat_card c on c.id_pat = p.id_pat ")
				.append(" left join bd_dep dep on dep.id_dep =t.id_dep_nur ")
				.append("left join  bd_hp_patca hpca on hpca.code_hppatca = n.code_hppatca and hpca.id_hp =h.id_hp ")
				.append("left join  bd_hp_med_kind_ah medkind on medkind.code = t.code_hpmedkind ")
				.append("where t.code_entp = 10 ").append("and t.fg_canc = 'N' ").append("and (t.fg_st = 'N' or (t.fg_st = 'Y' and s.fg_pay = 'N')) ");
		if (selectCondition != null && selectCondition.length > 0) {
			sql.append("and (");
			StringBuffer wheresql = new StringBuffer();
			for (String cond : selectCondition) {
				if ("code_ent".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("t.code like '%").append(inputValue).append("%'");
				} else if ("id_pat".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("p.id_pat like '%").append(inputValue).append("%'");
				} else if ("code_pat".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("p.code like '%").append(inputValue).append("%'");
				} else if ("id_code".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("p.id_code like '%").append(inputValue).append("%'");
				} else if ("barcode_chis".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("p.barcode_chis like '%").append(inputValue).append("%'");
				} else if ("code_amr_ip".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("e.code_amr_ip like '%").append(inputValue).append("%'");
				} else if ("patcode".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("c.code like '%").append(inputValue).append("%'");
				} else if("no_hp".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("n.no_hp like '%").append(inputValue).append("%'");
				}
			}
			sql.append(wheresql.toString());
			sql.append(") ");
		}
		String sqlContext = " and " + EnvContextUtil.processEnvContext("", new PatiVisitDO(), "t");//增加组织隔离
		sql.append(sqlContext);
		sql.append(" order by p.id_pat,e.times_ip desc");
		List<BlBannerDTO> list = (List<BlBannerDTO>) new DAFacade().execQuery(sql.toString(), new BeanListHandler(BlBannerDTO.class));
		return list.toArray(new BlBannerDTO[] {});
	}

	/**
	 * 根据banner中输入值查询相关患者就诊信息(结算退费)
	 * */
	@SuppressWarnings("unchecked")
	public BlBannerDTO[] getStRefundBannerEnEntInfo(String inputValue, String[] selectCondition) throws BizException {
		StringBuffer sql = new StringBuffer();
		sql.append("select distinct(t.id_ent),p.id_pat,p.name as name_pat,t.code as code_ent,t.dt_entry as dt_in,e.times_ip,r.id_pripat,r.name as name_pripat,h.id_hp,h.name as name_hp,t.fg_ip,t.id_dep_nur ,dep.name name_dep_nur,e.name_bed ")
				.append("from en_ent t ").append("left join pi_pat p on p.id_pat = t.id_pat ").append("left join en_ent_ip e on e.id_ent = t.id_ent ")
				.append("left join bd_pri_pat r on r.id_pripat = t.id_pripat ").append("left join en_ent_hp n on n.id_ent = t.id_ent and n.fg_maj = 'Y' ")
				.append("left join bd_hp h on h.id_hp = n.id_hp ").append("left join bl_st_ip s on s.id_ent = t.id_ent and s.fg_pay = 'Y' ")
				.append("left outer join pi_pat_card c on c.id_pat = p.id_pat ").append("left  join bd_dep dep on dep.id_dep =t.id_dep_nur ").append("where t.code_entp = 10 ").append("and t.fg_canc = 'N' ");
		if (selectCondition != null && selectCondition.length > 0) {
			sql.append(" and ( ");
			StringBuffer wheresql = new StringBuffer();
			for (String cond : selectCondition) {
				if ("code_ent".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("t.code like '%").append(inputValue).append("%'");
				} else if ("id_pat".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("p.id_pat like '%").append(inputValue).append("%'");
				} else if ("code_pat".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("p.code like '%").append(inputValue).append("%'");
				} else if ("id_code".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("p.id_code like '%").append(inputValue).append("%'");
				} else if ("barcode_chis".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("p.barcode_chis like '%").append(inputValue).append("%'");
				} else if ("code_amr_ip".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("e.code_amr_ip like '%").append(inputValue).append("%'");
				} else if ("patcode".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("c.code like '%").append(inputValue).append("%'");
				} else if( "no_hp".equals(cond)) {
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("n.no_hp like '%").append(inputValue)
					.append("%'");
				}else if("name_pat".equals(cond))
				{
					if (wheresql != null && wheresql.length() > 0) {
						wheresql.append(" or ");
					}
					wheresql.append("p.name like '%").append(inputValue).append("%'");
				}
			}
			sql.append(wheresql.toString());
			sql.append(") ");
		}
		String sqlContext = " and " + EnvContextUtil.processEnvContext("", new PatiVisitDO(), "t");//增加组织隔离
		sql.append(sqlContext);
		sql.append(" order by p.id_pat,e.times_ip desc");
		List<BlBannerDTO> list = (List<BlBannerDTO>) new DAFacade().execQuery(sql.toString(), new BeanListHandler(BlBannerDTO.class));
		return list.toArray(new BlBannerDTO[] {});
	}

}
