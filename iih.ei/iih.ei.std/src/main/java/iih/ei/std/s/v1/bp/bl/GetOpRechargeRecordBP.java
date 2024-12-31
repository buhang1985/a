package iih.ei.std.s.v1.bp.bl;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.bl.cg.oep.i.IOpSettlementQryService;
import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.prepay.sub.WsParamAccPatInfo;
import iih.ei.std.d.v1.bl.oprechargerecorddto.d.OpRechargeRecordParamDTO;
import iih.ei.std.d.v1.bl.oprechargerecorddto.d.OpRechargeRecordResultDTO;
import iih.ei.std.d.v1.bl.oprechargerecorddto.d.PayInfo;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.bl.utils.BlAmtConverUtil;
import iih.pi.acc.account.i.IPatAccServiceExt;
import iih.pi.reg.dto.d.PiPatFuzyyQueryCondDTO;
import iih.pi.reg.i.IPiRegQryService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import iih.pi.reg.pat.i.IPiPatCardDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/***
 * 门诊充值记录查询(含余额)
 * 
 * @author shaokx
 * @date: 2019.09.27
 */
public class GetOpRechargeRecordBP extends IIHServiceBaseBP<OpRechargeRecordParamDTO, OpRechargeRecordResultDTO>{

	String patId = null;
	
	@Override
	protected void checkParam(OpRechargeRecordParamDTO param) throws BizException {
		if(param == null){
			throw new BizException("入参为空");
		}
		
		if (StringUtil.isEmpty(param.getCode_hospital())) {
			throw new BizException("充值记录查询入参医院编码为空");
		}

		if (StringUtil.isEmpty(param.getCode_enttp())) {
			throw new BizException("充值记录查询入参就诊类型为空");
		}
		
		if(StringUtil.isEmpty(param.getDt_start())){
			throw new BizException("入参开始时间为空");
		}
		
		if(StringUtil.isEmpty(param.getDt_end())){
			throw new BizException("入参结束时间为空");
		}
		
		if(!IBlWsConst.ENTP_OP.equals(param.getCode_enttp())){
			throw new BizException("就诊类型值不正确");
		}

		if (StringUtil.isEmpty(param.getCode_pat()) && StringUtil.isEmpty(param.getCode_card())
				&& StringUtil.isEmpty(param.getCode_idnum())) {
			throw new BizException("充值记录查询入参关键信息全为空:患者编码,就诊卡号,身份证号");
		}
		
	}

	@Override
	protected OpRechargeRecordResultDTO process(OpRechargeRecordParamDTO param) throws BizException {
		
		// 查询患者信息
		PatDO patInfo = this.findPat(param);
		
		// 获得账户信息
		OpRechargeRecordResultDTO rlt1 = this.getSqlResult(param,patInfo.getId_pat());
		// 获得充值记录
		List<PayInfo> patInfoList = this.getRechargeRecord(param,patInfo.getId_pat());
        FArrayList arr = new FArrayList();
        arr.addAll(patInfoList);
        rlt1.setPayinfo(arr);
		
		return rlt1;
	}
	
	/**
	 * 查询患者
	 * 
	 * @param prepayInfo
	 * @return
	 * @throws BizException
	 */
	private PatDO findPat(OpRechargeRecordParamDTO paramInfo) throws BizException {

		IPiRegQryService regQryService = ServiceFinder.find(IPiRegQryService.class);
		PiPatFuzyyQueryCondDTO condDto = new PiPatFuzyyQueryCondDTO();
		condDto.setPat_code(paramInfo.getCode_pat());
		condDto.setId_code(paramInfo.getCode_idnum());
		condDto.setCard_code(paramInfo.getCode_card());

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
	private OpRechargeRecordResultDTO getSqlResult(OpRechargeRecordParamDTO param,String patId) throws BizException {
		IPatAccServiceExt ipatAccService = ServiceFinder.find(IPatAccServiceExt.class);
		
		// 调用接口获得门诊账户余额
		FDouble accBalance = ipatAccService.GetOutpPrepaymentAmount(patId);

		// 获得门诊账户信息
		StringBuffer sb = new StringBuffer();
		sb.append(" select pat.code code_pat, ");
		// sb.append(" pat.id_pat, ");
		sb.append(" pat.name name_pat, ");
		sb.append(" decode(pat.sd_sex, '1', '男', '2', '女', '未知') sex_pat, ");
		sb.append(" pat.dt_birth dt_birth, ");
		sb.append(" pat.id_code code_idnum ");
		if (!StringUtil.isEmpty(param.getCode_card())) {
			sb.append(" ,(case when card.eu_cardsu = '0' then '空白' ");
			sb.append(" when card.eu_cardsu = '1' and patcard.fg_act = 'N' then '不启用' ");
			sb.append(" when card.eu_cardsu = '1' then '在用' ");
			sb.append(" when card.eu_cardsu = '2' then '挂失' ");
			sb.append(" when card.eu_cardsu = '3' then '注销' ");
			sb.append(" end) status_card  ");
		}
		//sb.append(" decode(card.eu_cardsu,'0','空白','1','在用','2','挂失','3','注销') cardStatus ");
		sb.append(" from pi_pat pat ");
		if(!StringUtil.isEmpty(param.getCode_card())){
			sb.append(" left join pi_pat_card patcard ");
			sb.append(" on pat.id_pat = patcard.id_pat");
			sb.append(" left join pi_card card ");
			sb.append(" on patcard.id_card = card.id_card ");
			sb.append(" left join pi_pat_acc patacc ");
			sb.append(" on pat.id_pat = patacc.id_pat ");
		}
		sb.append("  where  1=1  ");
		if (!StringUtil.isEmpty(param.getCode_pat())) {
			sb.append(" and pat.code = ? ");
		}
		if (!StringUtil.isEmpty(param.getCode_card())) {
			sb.append(" and card.code = ? ");
		}
		if (!StringUtil.isEmpty(param.getCode_idnum())) {
			sb.append(" and pat.id_code = ? ");
		}
		// 对占位符的赋值
		SqlParam sp = new SqlParam();
		if (!StringUtil.isEmpty(param.getCode_pat())) {
			sp.addParam(param.getCode_pat());
		}
		if (!StringUtil.isEmpty(param.getCode_card())) {
			sp.addParam(param.getCode_card());
		}
		if (!StringUtil.isEmpty(param.getCode_idnum())) {
			sp.addParam(param.getCode_idnum());
		}

		// 执行sql语句
		@SuppressWarnings("unchecked")
		List<OpRechargeRecordResultDTO> list = (List<OpRechargeRecordResultDTO>) new DAFacade().execQuery(sb.toString(), sp,
				new BeanListHandler(OpRechargeRecordResultDTO.class));

		if (ListUtil.isEmpty(list)) {
			throw new BizException("未查询到患者信息");
		}

		list.get(0).setAmt_balance(BlAmtConverUtil.toXmlString(accBalance));
		list.get(0).setAmt_needpaid(BlAmtConverUtil.toXmlString(this.getNeedPaid(patId, accBalance)));

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
	private FDouble getBalanceByPatId(OpRechargeRecordParamDTO param) throws BizException {
		IPatAccServiceExt ipatAccService = ServiceFinder.find(IPatAccServiceExt.class);
		IPatiMDORService iPatMDORService = ServiceFinder.find(IPatiMDORService.class);
		IPiPatCardDORService iPiPatCardService = ServiceFinder.find(IPiPatCardDORService.class);

		if (!StringUtil.isEmpty(param.getCode_pat())) {
			String contition = " code = '" + param.getCode_pat() + "'  ";
			PatDO[] patDO = iPatMDORService.find(contition, "", FBoolean.FALSE);
			if (ArrayUtil.isEmpty(patDO)) {
				throw new BizException("通过患者编号查询不到该患者");
			}
			patId = patDO[0].getId_pat();
		} else if (!StringUtil.isEmpty(param.getCode_idnum())) {
			String contition = " id_code = '" + param.getCode_idnum() + "'  ";
			PatDO[] patDO = iPatMDORService.find(contition, "", FBoolean.FALSE);
			if (ArrayUtil.isEmpty(patDO)) {
				throw new BizException("通过患者身份证号查询不到该患者");
			}
			patId = patDO[0].getId_pat();
		} else if (!StringUtil.isEmpty(param.getCode_card())) {
			String contition = " code = '" + param.getCode_card() + "'  ";
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
	private List<PayInfo> getRechargeRecord(OpRechargeRecordParamDTO param,String patId) throws BizException {
		StringBuffer sb = new StringBuffer();
		sb.append(" select prepay.code_rep code_inc, ");
		sb.append(" pm.name name_pm, ");
		sb.append(" prepay.fg_canc status_amt, ");
		sb.append(" prepay.dt_pay dt_trade, ");
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

		if (!StringUtil.isEmpty(param.getDt_start())) {
			sb.append(" and prepay.dt_pay >= ? ");
		}
		if (!StringUtil.isEmpty(param.getDt_end())) {
			sb.append(" and prepay.dt_pay <= ? ");
		}

		// 对占位符的赋值
		SqlParam sp = new SqlParam();
		sp.addParam(patId);
		if (!StringUtil.isEmpty(param.getDt_start())) {
			sp.addParam(param.getDt_start());
		}
		if (!StringUtil.isEmpty(param.getDt_end())) {
			sp.addParam(param.getDt_end());
		}

		// 执行sql语句
		@SuppressWarnings("unchecked")
		List<PayInfo> list = (List<PayInfo>) new DAFacade().execQuery(sb.toString(), sp,
				new BeanListHandler(PayInfo.class));

		//FDouble accBalance = this.getBalanceByPatId(param);
		// 因为充值记录的账户余额没有时间限制，所以这里调用接口循环赋值
		// 修改之前的账户余额为充值金额
		for (PayInfo ws : list) {
			ws.setAmt(BlAmtConverUtil.toXmlString(new FDouble(ws.getAmt())));
		}

		return list;
	}

}
