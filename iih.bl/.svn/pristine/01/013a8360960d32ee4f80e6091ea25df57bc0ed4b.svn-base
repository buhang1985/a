package iih.bl.cg.service.s.bp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

import org.mvel2.util.Make.Map;


import sun.management.counter.Variability;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.portal.pin.msg.Msg;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import iih.bd.bc.udi.pub.IBdSrvTpDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bl.cg.api.d.WeChatPayInfo;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.bp.DoOepFgAccAmtAcc;
import iih.bl.cg.service.d.OperatorInfoDTO;
//import iih.bl.inc.blinciss.Service.i.IBLInvoiceService;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.service.i.IBLInvoiceService;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepCudService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.mp.dg.dto.d.OpDgRtnAmountDTO;

/**
 * 门诊划价、结算业务逻辑
 * 
 * @author tcy
 *
 */
public class PriceSettleBP {
	TimeService timeService = new TimeServiceImpl();

	String strDateTime = timeService.getUFDateTime().toStdString();

	/**
	 * 创建门急诊结算单对象
	 * 
	 * @param patId
	 *            患者id
	 * @param entId
	 *            就诊id
	 * @param entpId
	 *            就诊类型id
	 * @param entpCode
	 *            就诊类型编码
	 * @return
	 */
	public BlStOepDO createStOep(String patId, String entId, String entpId, String entpCode, OperatorInfoDTO operatorInfoDTO) {
		BlStOepDO stOep = new BlStOepDO();
		stOep.setEu_direct(Integer.parseInt(IBlDictCodeConst.SD_DIRECT_CHARGE));
		stOep.setEu_sttp(StTypeEnum.ST_OEP_REG);
		stOep.setSd_stresult(IBlDictCodeConst.SD_STRESULT_NORMAL);
		stOep.setId_stresult(IBlDictCodeConst.ID_STRESULT_NORMAL);
		stOep.setId_grp(operatorInfoDTO.getId_grp());// 集团
		stOep.setId_org(operatorInfoDTO.getId_org());// 组织
		stOep.setId_dep_st(operatorInfoDTO.getId_dep());// 部门
		stOep.setId_emp_st(operatorInfoDTO.getId_emp());// 操作员
		stOep.setId_pat(patId);
		stOep.setId_ent(entId);
		stOep.setId_enttp(entpId);
		stOep.setCode_enttp(entpCode);
		stOep.setStatus(DOStatus.NEW);
		return stOep;
	}

	/**
	 * 门急诊发票--主实体
	 * 
	 * @param patId
	 *            患者id
	 * @param entId
	 *            就诊id
	 * @param entpId
	 *            就诊类型id
	 * @param entpCode
	 *            就诊类型编码
	 * @param invoiceNo
	 *            发票号
	 * @param oprId
	 *            操作员id
	 * @param fgPrint
	 *            是否打印发票
	 * @return
	 */
	public BlIncOepDO createIncOep(String patId, String entId, String entpId, String entpCode, String invoiceNo, String oprId, FBoolean fgPrint, OperatorInfoDTO operatorInfoDTO) {
		BlIncOepDO incOepDO = new BlIncOepDO();
		incOepDO.setId_grp(operatorInfoDTO.getId_grp());// 集团
		incOepDO.setId_org(operatorInfoDTO.getId_org());// 组织
		incOepDO.setId_pat(patId);
		// incOepDO.setId_ent(entId);
		incOepDO.setId_enttp(entpId);
		incOepDO.setCode_enttp(entpCode);
		incOepDO.setFg_print(fgPrint);
		incOepDO.setId_emp_inc(oprId);
		if (FBoolean.TRUE.equals(fgPrint)) {
			incOepDO.setCode_incpkg("");
			incOepDO.setIncno(invoiceNo);
			incOepDO.setDt_inc(timeService.getUFDateTime());
			incOepDO.setTimes_prn(1);
		} else {
			incOepDO.setTimes_prn(0);
		}
		incOepDO.setId_incca(IBdInccaCodeConst.ID_OUTPATIENT_INVOICE);
		incOepDO.setEu_direct(BookRtnDirectEnum.CHARGES);
		incOepDO.setStatus(DOStatus.NEW);
		return incOepDO;
	}

	/**
	 * 划价前的数据校验和部分数据完善
	 * 
	 * @param appendBillParamDTOs
	 *            待划价数据
	 * @param operatorInfoDTO
	 *            操作员信息
	 * @throws BizException
	 */
	public void validateAndPerfect_Pricing(BlOrderAppendBillParamDTO[] appendBillParamDTOs, OperatorInfoDTO operatorInfoDTO) throws BizException {
		if (operatorInfoDTO.getId_dep() == null || operatorInfoDTO.getId_dep().length() == 0) {
			throw new BizException("上下文：用户所在科室不存在");
		}
		if (operatorInfoDTO.getId_org() == null || operatorInfoDTO.getId_org().length() == 0) {
			throw new BizException("上下文：用户所在组织不存在");
		}
		if (operatorInfoDTO.getId_grp() == null || operatorInfoDTO.getId_grp().length() == 0) {
			throw new BizException("上下文：用户所在集团不存在");
		}
		if (operatorInfoDTO.getId_emp() == null || operatorInfoDTO.getId_emp().length() == 0) {
			throw new BizException("上下文：用户ID不存在");
		}
		if (operatorInfoDTO.getId_org_emp() == null || operatorInfoDTO.getId_org_emp().length() == 0) {
			throw new BizException("上下文：用户所在组织不存在");
		}

		// 2017-6-8 检查、检验类的ID_SRV,一天只能收费一次
		// // 1.检索当天已收费的数据中属于检查检验类的IDSRV
		// String id_srvs = "";
		// String id_ors = "";
		// // 获取当前需要划价的医嘱项与 服务项
		// for (BlOrderAppendBillParamDTO blOrderAppendBillParamDTO :
		// appendBillParamDTOs) {
		// if (blOrderAppendBillParamDTO.getSd_srvtp() != null) {
		// if
		// (blOrderAppendBillParamDTO.getSd_srvtp().indexOf(IBdSrvTpDictCodeConst.SD_SRVTP_RIS)
		// != -1
		// ||
		// blOrderAppendBillParamDTO.getSd_srvtp().indexOf(IBdSrvTpDictCodeConst.SD_SRVTP_LIS)
		// != -1) {
		// id_srvs = id_srvs + (id_srvs == "" ? "" : ",") + "'" +
		// blOrderAppendBillParamDTO.getId_srv() + "'";
		// if (!"".equals(blOrderAppendBillParamDTO.getId_or()))
		// id_ors = id_ors + (id_ors == "" ? "" : ",") + "'" +
		// blOrderAppendBillParamDTO.getId_or() + "'";
		// }
		// }
		// }
		// // 验证当前医嘱项目 有多个的进行提示
		// if (id_ors != "") {
		// OrderListById_or_validate(id_ors, new SqlParam(), 1);
		// }
		// // 验证已收费未退费的医嘱项如果有进行提示
		// if (id_srvs != "") {
		// String sqlWhere =
		// "SELECT ID_OR FROM BL_CG_ITM_OEP item INNER JOIN BL_CG_OEP cg on CG.ID_CGOEP=ITEM.ID_CGOEP WHERE item.ID_PAT=? AND cg.EU_DIRECT='1' AND item.FG_REFUND='N' AND item.id_srv IN ("
		// + id_srvs +
		// ") AND item.DT_ST>? AND item.DT_ST<=? GROUP BY ITEM.ID_OR";
		// SqlParam sp = new SqlParam();
		// sp.addParam(appendBillParamDTOs[0].getId_pat());
		// FDate ndate = new FDate().asLocalBegin();
		// sp.addParam(new FDateTime(ndate, new FTime("00:00:00")));
		// sp.addParam(new FDateTime(ndate, new FTime("23:59:59")));
		// OrderListById_or_validate(sqlWhere, sp, 0);
		// }

		for (BlOrderAppendBillParamDTO blOrderAppendBillParamDTO : appendBillParamDTOs) {
			blOrderAppendBillParamDTO.setId_org_cg(operatorInfoDTO.getId_org());
			blOrderAppendBillParamDTO.setId_dep_cg(operatorInfoDTO.getId_dep());
			blOrderAppendBillParamDTO.setId_emp_cg(operatorInfoDTO.getId_emp());
		}

	}

	public String validateCiOrderSrvById_or(String[] id_ors) throws BizException {
		/*String idors = "";
		for (String idor : id_ors) {
			if (!"".equals(idor)) {
				idors = idors + (idors == "" ? "" : ",") + "'" + idor + "'";
			}
		}
		if (idors != "") {
			String thrMsg = "";
			String strSql = "SELECT  count(NAME_OR) QUAN_MEDU,NAME_OR FROM CI_ORDER  where ID_OR in (" + idors + ") GROUP BY NAME_OR,ID_SRV";
			DAFacade da = new DAFacade();
			List<CiOrderDO> list = (List<CiOrderDO>) da.execQuery(strSql, new BeanListHandler(CiOrderDO.class));
			if (list != null) {
				for (CiOrderDO ciOrderDO : list) {
					if (ciOrderDO.getQuan_medu().compareTo(new FDouble(1)) > 0) {
						thrMsg += (thrMsg.equals("") ? "" : "，") + "[" + ciOrderDO.getName_or() + "]";
					}
				}
			}
			if (thrMsg != "") {
				return "医嘱项目：" + thrMsg + " 重复！";
			}
		}*/
		return "";
	}

	// 2017-6-8 检查、检验类的ID_SRV,一天只能收费一次
	// void CiOrderById_or_validate(String sqlWhere, SqlParam sp, int
	// compareNum) throws BizException {
	// List<CiOrderDO> list = null;
	// String thrMsg = "";
	// String strSql =
	// "SELECT  count(NAME_OR) QUAN_MEDU,NAME_OR FROM CI_ORDER  where ID_OR in ("
	// + sqlWhere + ") GROUP BY NAME_OR,ID_SRV";
	// DAFacade da = new DAFacade();
	// list = (List<CiOrderDO>) da.execQuery(strSql, sp, new
	// BeanListHandler(CiOrderDO.class));
	// if (list != null) {
	// for (CiOrderDO ciOrderDO : list) {
	// if (ciOrderDO.getQuan_medu().compareTo(new FDouble(compareNum)) > 0) {
	// thrMsg += (thrMsg.equals("") ? "" : "，") + "[" + ciOrderDO.getName_or() +
	// "]";
	// }
	// }
	// }
	// if (thrMsg != "") {
	// throw new BizException("医嘱项目：" + thrMsg + "一天只能收一次费");
	// }
	// }

	/**
	 * 门急诊退费结算（不含划价部分）：供红冲后再划价使用
	 * 
	 * @param blStOepDO
	 *            ：按就诊ID和就诊类型的产生的结算数组，一次就诊产生一次DO，多次就诊产生多次DO（就诊=id_pat+" "+id_ent
	 *            +" "+id_enttp）
	 * @param blincoepAggDO
	 *            ：发票AGG数组，一个blStOepDO，对应一个发票AGG；多个blStOepDO，对应多个发票AGG
	 * @param BlcgoepAggDO
	 *            ：记账AGG，红冲后返回的待解算AGG
	 * @param blpaypatoepAggDO
	 *            :收付款AGG
	 * @throws BizException
	 */
	public void validate_SettlementAfterRedBill(BlStOepDO[] blStOepDO, BlincoepAggDO[] blincoepAggDO, BlcgoepAggDO[] blcgoepAggDO, BlpaypatoepAggDO blpaypatoepAggDO) throws BizException {
		if (blcgoepAggDO == null) {
			throw new BizException("没有门诊记账信息");
		}
		if (blStOepDO == null) {
			throw new BizException("没有门诊结算信息");
		}
		if (blincoepAggDO == null) {
			throw new BizException("没有门诊票据信息");
		}
		if (blpaypatoepAggDO == null) {
			throw new BizException("没有门诊付款信息");
		}
		for (int i = 0; i < blpaypatoepAggDO.getBlPayItmPatOepDO().length; i++) {
			if (blpaypatoepAggDO.getBlPayItmPatOepDO()[i] == null || blpaypatoepAggDO.getBlPayItmPatOepDO()[i].getAmt() == null) {
				throw new BizException("没有门诊收款明细费用");
			}
			if (blpaypatoepAggDO.getBlPayItmPatOepDO()[i] == null || blpaypatoepAggDO.getBlPayItmPatOepDO()[i].getSd_pm() == null) {
				throw new BizException("没有设置门诊收款明细费用支付方式代码");
			}
			if (blpaypatoepAggDO.getBlPayItmPatOepDO()[i] == null || ("现金").equals(blpaypatoepAggDO.getBlPayItmPatOepDO()[i].getId_pm())) {
				throw new BizException("没有设置门诊收款明细费用支付方式ID");
			}
		}
	}

	/**
	 * 结算前校验
	 * 
	 * @param blStOepDO
	 * @param blincoepAggDO
	 * @param blcgoepAggDO
	 * @param PrintInvocie
	 * @throws BizException
	 */
	public void validate_settlementPayment(BlcgoepAggDO[] blcgoepAggDO, BlpaypatoepAggDO blpaypatoepAggDO) throws BizException {
		if (blcgoepAggDO == null) {
			throw new BizException("没有门诊记账信息");
		}
		if (blpaypatoepAggDO == null) {
			throw new BizException("没有门诊收款信息");
		}

		if (blpaypatoepAggDO.getParentDO().getAmt() == null || blpaypatoepAggDO.getParentDO().getAmt().toString().trim().length() == 0) {
			throw new BizException("收付款主表金额不能为空！");
		}
		if (blpaypatoepAggDO.getParentDO().getSd_pttp() == null || blpaypatoepAggDO.getParentDO().getSd_pttp().toString().trim().length() == 0) {
			throw new BizException("收付款终端类型不能为空！");
		}
		if (blpaypatoepAggDO.getBlPayItmPatOepDO() == null || blpaypatoepAggDO.getBlPayItmPatOepDO().length == 0) {
			throw new BizException("没有收付款明细，请检查支付方式！");
		}
		BlPayItmPatOepDO[] blPayItmPatOepDOArr = blpaypatoepAggDO.getBlPayItmPatOepDO();
		for (int i = 0; i < blPayItmPatOepDOArr.length; i++) {

			// if(blPayItmPatOepDOArr[i]==null ||
			// blPayItmPatOepDOArr[i].getAmt()==null ||
			// blPayItmPatOepDOArr[i].getAmt().compareTo(new FDouble(0))<=0)
			// {
			// throw new BizException("门诊收款明细费用应该大于0，请检查！");
			// }
			if (blPayItmPatOepDOArr[i] == null || blPayItmPatOepDOArr[i].getSd_pm() == null) {
				throw new BizException("没有设置门诊收款明细费用支付方式代码");
			}
			if (blPayItmPatOepDOArr[i] == null || blPayItmPatOepDOArr[i].getId_pm() == null) {
				throw new BizException("没有设置门诊收款明细费用支付方式ID");
			}

		}

	}

	/**
	 * 划价前校验
	 * 
	 * @param blStOepDO
	 * @param blincoepAggDO
	 * @param blcgoepAggDO
	 * @param PrintInvocie
	 * @throws BizException
	 */
	public void validate_pricing(BlStOepDO blStOepDO, BlincoepAggDO blincoepAggDO, BlcgoepAggDO[] blcgoepAggDO, FBoolean PrintInvocie) throws BizException {
		if (blcgoepAggDO == null) {
			throw new BizException("没有门诊记账信息");
		}
		if (blStOepDO == null) {
			throw new BizException("没有门诊结算信息");
		}
		if (blStOepDO.getId_emp_st() == null) {
			throw new BizException("没有门诊结算人员信息");
		}
		if (blincoepAggDO == null) {
			throw new BizException("没有门诊票据信息");
		}
		if (PrintInvocie.booleanValue()) // 需要打发票
		{
			if (blincoepAggDO.getParentDO() == null || blincoepAggDO.getParentDO().getIncno() == null) {
				throw new BizException("没有发票号");
			}

			// 若要打印发票，则需要验证发票号，否则不验证，只保存INC
			// 验证首张发票是否是当前票号
			IBLInvoiceService iBLInvoiceService = ServiceFinder.find(IBLInvoiceService.class);
			String curincno = iBLInvoiceService.GetInvoiceNo(blincoepAggDO.getParentDO().getId_emp_inc(), IBdInccaCodeConst.CODE_OUTPATIENT_INVOICE);
			if (blincoepAggDO.getParentDO().getIncno() != null) // 有发票号
			{
				if (!curincno.equals(blincoepAggDO.getParentDO().getIncno())) {
					throw new BizException("当前票号已作废，请重新加载");
				}
			}

			if (blincoepAggDO.getParentDO().getId_emp_inc() == null) {
				throw new BizException("没有门诊票据开票人员信息");
			}

		}
	}
}
