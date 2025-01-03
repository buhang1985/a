package iih.bl.itf.std.bp.opprepay;

import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.oep.i.IOpSettlementQryService;
import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.prepay.WsParamGetAccRecord;
import iih.bl.itf.std.bean.input.prepay.sub.WsParamAccPatInfo;
import iih.bl.itf.std.bean.output.WsResultMsg;
import iih.bl.itf.std.bean.output.prepay.WsResultGetOpAcc;
import iih.bl.itf.std.bean.output.prepay.WsResultInfoGetOpAcc;
import iih.bl.itf.std.bean.output.prepay.sub.WsResultOpAccount;
import iih.bl.itf.std.bean.output.prepay.sub.WsResultPayInfo;
import iih.bl.itf.std.bp.BlItfBaseBP;
import iih.bl.itf.std.util.BlAmtConverUtil;
import iih.pi.acc.account.i.IPatAccServiceExt;
import iih.pi.reg.dto.d.PiPatFuzyyQueryCondDTO;
import iih.pi.reg.i.IPiRegQryService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pat.i.IPiPatCardDORService;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊充值记录查询(含余额)
 * 
 * @author ly 2018/7/20
 *
 */
public class GetOpRechargeRecordBP extends BlItfBaseBP<WsParamGetAccRecord,WsResultGetOpAcc> {

	String patId = null;

	protected String getBusiness() {

		return "门诊充值记录查询（含余额）";
	}

	@Override
	protected void checkParam(WsParamGetAccRecord param) throws BizException {
		WsParamAccPatInfo accPatInfo = param.getPatInfo();
		if (StringUtil.isEmpty(accPatInfo.getPatCode()) && StringUtil.isEmpty(accPatInfo.getCardCode())
				&& StringUtil.isEmpty(accPatInfo.getSdCode())) {
			throw new BizException("请正确输入参数");
		}
	}

	@Override
	protected WsResultGetOpAcc doWork(WsParamGetAccRecord param) throws BizException {
		WsParamAccPatInfo paramInfo = param.getPatInfo();
		// 查询患者信息
		PatDO patInfo = this.findPat(paramInfo);
		
		WsResultGetOpAcc rlt = new WsResultGetOpAcc();
		WsResultInfoGetOpAcc rltInfo = new WsResultInfoGetOpAcc();
		WsResultMsg rltMsg = new WsResultMsg();
		rlt.setRltInfo(rltInfo);
		rlt.setRltMsg(rltMsg);
		rltMsg.setCode(IBlWsConst.RLT_SUCCESS);
		// 获得账户信息
		WsResultOpAccount patAccInfo = this.getSqlResult(param,patInfo.getId_pat());
		// 获得充值记录
		List<WsResultPayInfo> patInfoList = this.getRechargeRecord(param,patInfo.getId_pat());
		rltInfo.setAccInfo(patAccInfo);
		rltInfo.setPayInfoList(patInfoList);

		return rlt;
	}
	
	/**
	 * 查询患者
	 * 
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	private PatDO findPat(WsParamAccPatInfo paramInfo) throws BizException {

		IPiRegQryService regQryService = ServiceFinder.find(IPiRegQryService.class);
		PiPatFuzyyQueryCondDTO condDto = new PiPatFuzyyQueryCondDTO();
		condDto.setPat_code(paramInfo.getPatCode());
		condDto.setId_code(paramInfo.getSdCode());
		condDto.setCard_code(paramInfo.getCardCode());

		PatiAggDO[] patiAggs = regQryService.fuzzyQueryPati(condDto);
		if (ArrayUtil.isEmpty(patiAggs)) {
			throw new BizException("门诊充值记录查询:未查询到患者信息");
		}

		return patiAggs[0].getParentDO();
	}

	/**
	 * 查询门诊账户信息和余额
	 * 
	 * @param param
	 * @throws BizException
	 */
	private WsResultOpAccount getSqlResult(WsParamGetAccRecord param,String patId) throws BizException {
		IPatAccServiceExt ipatAccService = ServiceFinder.find(IPatAccServiceExt.class);
		WsParamAccPatInfo accPatInfo = param.getPatInfo();
		// 调用接口获得门诊账户余额
		FDouble accBalance = ipatAccService.GetOutpPrepaymentAmount(patId);

		// 获得门诊账户信息
		StringBuffer sb = new StringBuffer();
		sb.append(" select pat.code patCode, ");
		// sb.append(" pat.id_pat, ");
		sb.append(" pat.name patName, ");
		sb.append(" decode(pat.sd_sex, '1', '男', '2', '女', '未知') patSex, ");
		sb.append(" pat.dt_birth patBorthday, ");
		sb.append(" pat.id_code sdCode ");
		if (!StringUtil.isEmpty(accPatInfo.getCardCode())) {
			sb.append(" ,(case when card.eu_cardsu = '0' then '空白' ");
			sb.append(" when card.eu_cardsu = '1' and patcard.fg_act = 'N' then '不启用' ");
			sb.append(" when card.eu_cardsu = '1' then '在用' ");
			sb.append(" when card.eu_cardsu = '2' then '挂失' ");
			sb.append(" when card.eu_cardsu = '3' then '注销' ");
			sb.append(" end) cardStatus  ");
		}
		//sb.append(" decode(card.eu_cardsu,'0','空白','1','在用','2','挂失','3','注销') cardStatus ");
		sb.append(" from pi_pat pat ");
		if(!StringUtil.isEmpty(accPatInfo.getCardCode())){
			sb.append(" left join pi_pat_card patcard ");
			sb.append(" on pat.id_pat = patcard.id_pat");
			sb.append(" left join pi_card card ");
			sb.append(" on patcard.id_card = card.id_card ");
			sb.append(" left join pi_pat_acc patacc ");
			sb.append(" on pat.id_pat = patacc.id_pat ");
		}
		sb.append("  where  1=1  ");
		if (!StringUtil.isEmpty(accPatInfo.getPatCode())) {
			sb.append(" and pat.code = ? ");
		}
		if (!StringUtil.isEmpty(accPatInfo.getCardCode())) {
			sb.append(" and card.code = ? ");
		}
		if (!StringUtil.isEmpty(accPatInfo.getSdCode())) {
			sb.append(" and pat.id_code = ? ");
		}
		// 对占位符的赋值
		SqlParam sp = new SqlParam();
		if (!StringUtil.isEmpty(accPatInfo.getPatCode())) {
			sp.addParam(accPatInfo.getPatCode());
		}
		if (!StringUtil.isEmpty(accPatInfo.getCardCode())) {
			sp.addParam(accPatInfo.getCardCode());
		}
		if (!StringUtil.isEmpty(accPatInfo.getSdCode())) {
			sp.addParam(accPatInfo.getSdCode());
		}

		// 执行sql语句
		@SuppressWarnings("unchecked")
		List<WsResultOpAccount> list = (List<WsResultOpAccount>) new DAFacade().execQuery(sb.toString(), sp,
				new BeanListHandler(WsResultOpAccount.class));

		if (ListUtil.isEmpty(list)) {
			throw new BizException("未查询到患者信息");
		}

		list.get(0).setBalance(BlAmtConverUtil.toXmlString(accBalance));
		list.get(0).setNeedPaid(BlAmtConverUtil.toXmlString(this.getNeedPaid(patId, accBalance)));
		return list.get(0);
	}

	/**
	 * 获得患者需缴金额
	 * 
	 * @return
	 * @throws BizException 
	 */
	private FDouble getNeedPaid(String patId,FDouble accBalance) throws BizException {
		FDouble unPaid = FDouble.ZERO_DBL;// 未缴金额
		FDouble needPaid = FDouble.ZERO_DBL;//需缴金额
		IOpSettlementQryService iOpSettleSrv = ServiceFinder.find(IOpSettlementQryService.class);
		// 调用接口查询患者未记账医嘱信息
		BlOrderAppendBillParamDTO[] blNoCgDTO = iOpSettleSrv.getNoBookkeepingCiSrv(patId);
		if(!ArrayUtil.isEmpty(blNoCgDTO)){
			for (BlOrderAppendBillParamDTO itm : blNoCgDTO) {
				unPaid = unPaid.add(itm.getAmt_ratio());
			}
		}


		if(unPaid.sub(accBalance).compareTo(FDouble.ZERO_DBL) < 0){
			needPaid = FDouble.ZERO_DBL;
		}else{
			needPaid = unPaid.sub(accBalance);
		}
		return needPaid;
	}

	/**
	 * 通过入参获得患者id并且调接口查询账户余额
	 * 
	 * @param accPatInfo
	 * @return
	 * @throws BizException
	 */
	private FDouble getBalanceByPatId(WsParamAccPatInfo accPatInfo) throws BizException {
		IPatAccServiceExt ipatAccService = ServiceFinder.find(IPatAccServiceExt.class);
		IPatiMDORService iPatMDORService = ServiceFinder.find(IPatiMDORService.class);
		IPiPatCardDORService iPiPatCardService = ServiceFinder.find(IPiPatCardDORService.class);

		if (!StringUtil.isEmpty(accPatInfo.getPatCode())) {
			String contition = " code = '" + accPatInfo.getPatCode() + "'  ";
			PatDO[] patDO = iPatMDORService.find(contition, "", FBoolean.FALSE);
			if (ArrayUtil.isEmpty(patDO)) {
				throw new BizException("通过患者编号查询不到该患者");
			}
			patId = patDO[0].getId_pat();
		} else if (!StringUtil.isEmpty(accPatInfo.getSdCode())) {
			String contition = " id_code = '" + accPatInfo.getSdCode() + "'  ";
			PatDO[] patDO = iPatMDORService.find(contition, "", FBoolean.FALSE);
			if (ArrayUtil.isEmpty(patDO)) {
				throw new BizException("通过患者身份证号查询不到该患者");
			}
			patId = patDO[0].getId_pat();
		} else if (!StringUtil.isEmpty(accPatInfo.getCardCode())) {
			String contition = " code = '" + accPatInfo.getCardCode() + "'  ";
			PiPatCardDO[] piCardDO = iPiPatCardService.find(contition, "", FBoolean.FALSE);
			if (ArrayUtil.isEmpty(piCardDO)) {
				throw new BizException("通过患者就诊卡号查询不到该患者");
			}
			patId = piCardDO[0].getId_pat();
		}
		FDouble accBalance = ipatAccService.GetOutpPrepaymentAmount(patId);

		return accBalance;
	}

	/**
	 * 获得充值记录
	 * 
	 * @throws BizException
	 */
	private List<WsResultPayInfo> getRechargeRecord(WsParamGetAccRecord param,String patId) throws BizException {
		WsParamAccPatInfo accPatInfo = param.getPatInfo();
		StringBuffer sb = new StringBuffer();
		sb.append(" select prepay.code_rep incCode, ");
		sb.append(" pm.name payMethod, ");
		sb.append(" prepay.fg_canc status, ");
		sb.append(" prepay.dt_pay tradeTime, ");
		sb.append(" prepay.note, ");
		sb.append(" prepay.amt ");
		// sb.append(" acc.prepay-acc.acc_lock amt ");
		sb.append(" from bl_prepay_pat prepay ");
		sb.append(" left join bd_pri_pm pm ");
		sb.append(" on prepay.id_pm = pm.id_pm ");
		sb.append(" left join pi_pat pat ");
		sb.append(" on prepay.id_pat = pat.id_pat ");
		//sb.append(" left join pi_pat_card card  ");
		//sb.append(" on card.id_pat = prepay.id_pat ");
		sb.append(" left join pi_pat_acc acc ");
		sb.append(" on prepay.id_pat = acc.id_pat where 1=1 ");
		sb.append(" and prepay.eu_direct = 1 and prepay.sd_paytp = '11' ");
		sb.append(" and prepay.id_pat = ? ");

		if (!StringUtil.isEmpty(accPatInfo.getStartDate())) {
			sb.append(" and prepay.dt_pay >= ? ");
		}
		if (!StringUtil.isEmpty(accPatInfo.getEndDate())) {
			sb.append(" and prepay.dt_pay <= ? ");
		}

		// 对占位符的赋值
		SqlParam sp = new SqlParam();
		sp.addParam(patId);
		if (!StringUtil.isEmpty(accPatInfo.getStartDate())) {
			sp.addParam(accPatInfo.getStartDate());
		}
		if (!StringUtil.isEmpty(accPatInfo.getEndDate())) {
			sp.addParam(accPatInfo.getEndDate());
		}

		// 执行sql语句
		@SuppressWarnings("unchecked")
		List<WsResultPayInfo> list = (List<WsResultPayInfo>) new DAFacade().execQuery(sb.toString(), sp,
				new BeanListHandler(WsResultPayInfo.class));

		//FDouble accBalance = this.getBalanceByPatId(accPatInfo);
		// 因为充值记录的账户余额没有时间限制，所以这里调用接口循环赋值
		// 修改之前的账户余额为充值金额
		for (WsResultPayInfo ws : list) {
			ws.setAmt(BlAmtConverUtil.toXmlString(new FDouble(ws.getAmt())));
		}

		return list;
	}
}
