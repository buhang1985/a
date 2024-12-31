package iih.bl.itf.std.bp.ipprepay;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.itf.std.bean.input.prepay.WsParamGetAccRecord;
import iih.bl.itf.std.bean.input.prepay.sub.WsParamAccPatInfo;
import iih.bl.itf.std.bean.output.WsResultMsg;
import iih.bl.itf.std.bean.output.prepay.WsResultGetIpAcc;
import iih.bl.itf.std.bean.output.prepay.WsResultInfoGetIpAcc;
import iih.bl.itf.std.bean.output.prepay.sub.WsResultIpAccount;
import iih.bl.itf.std.bean.output.prepay.sub.WsResultPayInfo;
import iih.bl.itf.std.bp.BlItfBaseBP;
import iih.bl.itf.std.util.BlAmtConverUtil;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipRService;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.InpatientDO;
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
 * 住院押金充值记录查询(含余额)
 * 
 * @author ly 2018/7/20
 *
 */
public class GetIpRechargeRecordBP extends BlItfBaseBP<WsParamGetAccRecord,WsResultGetIpAcc> {

	@Override
	protected String getBusiness() {

		return "住院押金充值记录查询(含余额)";
	}

	@Override
	protected void checkParam(WsParamGetAccRecord param) throws BizException {
		if (param == null || param.getPatInfo() == null) {
			throw new BizException("账户查询入参数据为空");
		}

		WsParamAccPatInfo paramInfo = param.getPatInfo();

//		if (StringUtil.isEmpty(paramInfo.getHospitalCode())) {
//			throw new BizException("账户查询入参医院编码为空");
//		}

		if (StringUtil.isEmpty(paramInfo.getEntpCode())) {
			throw new BizException("账户查询入参就诊类型为空");
		}
		if (StringUtil.isEmpty(paramInfo.getIPCode())) {
			throw new BizException("住院账号查询入参关键信息全为空:住院编号");
		}
	}

	@Override
	protected WsResultGetIpAcc doWork(WsParamGetAccRecord param) throws BizException {

		//获取就诊信息
		String entId=this.getentId(param.getPatInfo().getIPCode());
		
		// 获得账户信息(含余额)
		WsResultIpAccount patAccInfo = this.getAccInfo(entId);
		
		// 获得充值记录信息(含余额)
		List<WsResultPayInfo> patInfoList = this.getPrepayRecord(entId);

		//组装返回值
		WsResultGetIpAcc rlt = new WsResultGetIpAcc();
		WsResultInfoGetIpAcc rltInfo = new WsResultInfoGetIpAcc();
		WsResultMsg rltMsg = new WsResultMsg();
		rlt.setRltInfo(rltInfo);
		rlt.setRltMsg(rltMsg);
		rltMsg.setCode(IBlWsConst.RLT_SUCCESS);
		rltInfo.setAccInfo(patAccInfo);
		rltInfo.setPayInfoList(patInfoList);
		return rlt;

	}

	/**
	 * 通过入参获得就诊id
	 * 
	 * @param param
	 * @return id_ent
	 * @throws BizException
	 */
	private String getentId(String ipCode) throws BizException {
		StringBuilder sql = new StringBuilder();
		sql.append(" select id_ent");
		sql.append(" from  en_ent_ip ");
		sql.append(" where code_amr_ip = '" + ipCode + "'");
		sql.append(" order by times_ip desc ");

		@SuppressWarnings("unchecked")
		List<InpatientDO> list = (List<InpatientDO>) new DAFacade().execQuery(sql.toString(),
				new BeanListHandler(InpatientDO.class));
		if (ListUtil.isEmpty(list)) {
			throw new BizException("未查询到就诊信息！");
		}
		return list.get(0).getId_ent();
	}

	/**
	 * 通过id_ent获得住院账户余额
	 * 
	 * @param accPatInfo
	 * @return
	 * @throws BizException
	 */
	private FDouble getAmtcret(String entId) throws BizException {
		IEnOutQryService service = ServiceFinder.find(IEnOutQryService.class);
		BalanceDTO balanceDTO = service.getBalanceDTO(entId);
		return balanceDTO.getAmt_bal();
	}

	/**
	 * 查询住院账户信息（含余额）
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private WsResultIpAccount getAccInfo(String entId) throws BizException {
		
		if(StringUtil.isEmpty(entId)){
			throw new BizException("就诊id为空");
		}
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select");
		sql.append(" pat.code patCode,");
		sql.append(" enent.name_pat patName,");
		sql.append(" doc.name patSex,");
		sql.append(" pat.dt_birth patBorthday,");
		sql.append(" pat.id_code sdCode,");
		sql.append(" decode(enent.fg_ip,'Y','在院','N','出院') IPStatus,");
		sql.append(" phyadmdep.name depName,");
		sql.append(" entip.name_bed bedNO,");
		sql.append(" enent.dt_entry dtIP,");
		sql.append(" acc.amt_prepay prepayment,");
		sql.append(" acc.amt_uncg totalAmt ");
		// sql.append(" amt_prepay-amt_uncg balance");
		sql.append(" from en_ent_ip entip");
		sql.append(" left join en_ent enent on enent.id_ent = entip.id_ent");
		sql.append(" left join en_ent_acc acc on acc.id_ent=entip.id_ent");
		sql.append(" left join bl_prepay_pat paypat on paypat.id_ent=entip.id_ent");
		sql.append(" left join pi_pat pat on pat.id_pat=enent.id_pat");
		sql.append(" left join bd_udidoc doc on pat.id_sex=doc.id_udidoc");
		sql.append(" left join bd_dep phyadmdep on phyadmdep.id_dep=entip.id_dep_phyadm");
		sql.append(" where 1=1");
		sql.append(" and enent.id_ent=? ");
		
		SqlParam sp = new SqlParam();
		sp.addParam(entId);
		
		// 执行sql语句
		@SuppressWarnings("unchecked")
		List<WsResultIpAccount> list = (List<WsResultIpAccount>) new DAFacade().execQuery(sql.toString(), sp,
				new BeanListHandler(WsResultIpAccount.class));
		
		if(list==null || list.size()<=0){
			return null;
		}
		// 住院费用总金额（单位分）由元转为分
		list.get(0).setTotalAmt(BlAmtConverUtil.toXmlString(new FDouble(list.get(0).getTotalAmt())));
		// 预交金总额（单位分）由元转为分
		list.get(0).setPrepayment(BlAmtConverUtil.toXmlString(new FDouble(list.get(0).getPrepayment())));
		// 预交金可用总额（单位分）由元转为分
		list.get(0).setBalance(this.subUtil(list.get(0).getPrepayment(), list.get(0).getTotalAmt()));

		if ("在院".equals(list.get(0).getIPStatus())) {
			// 结算状态
			list.get(0).setSTStatus("N");
		} else {
			// 判断出院结算是否已经进行付款
			list.get(0).setSTStatus(this.getStStatus(entId));
		}

		return list.get(0);
	}

	/**
	 * 判断是否已经进行出院结算付款
	 * 
	 * @param ipCode
	 * @return
	 * @throws BizException
	 */
	private String getStStatus(String entId) throws BizException {

		IBlstipRService stService = ServiceFinder.find(IBlstipRService.class);

		BlStIpDO[] stArr = stService.find("id_ent='" + entId + "' and fg_pay='Y' and eu_sttp='10' ", "",
				FBoolean.FALSE);

		if (ArrayUtil.isEmpty(stArr)) {
			return "N";
		} else {
			return "Y";
		}

	}

	/**
	 * 
	 * 两个string类型的减法方法，入参为string,返回结果为String
	 * 
	 * @param num1
	 * @param num2
	 * @return
	 */
	private String subUtil(String num1, String num2) {
		double num11 = new BigDecimal(num1).doubleValue();
		double num22 = new BigDecimal(num2).doubleValue();
		double doubleValue = new BigDecimal(num11 - num22).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();

		DecimalFormat decimalFormat = new DecimalFormat("###################.###########");

		return decimalFormat.format(doubleValue);
		// return String.valueOf(doubleValue);//double转成string时，会在末尾加上一个0，如12
		// 会变为12.0
	}

	/**
	 * 查询住院充值记录（含余额）
	 * 
	 * @param param
	 * @return
	 */
	private List<WsResultPayInfo> getPrepayRecord(String entId) throws BizException {
		// 支付票据编码，支付方式，金额状态(取消标志)，交易时间，备注，账户余额
		StringBuilder sql = new StringBuilder();
		sql.append(" select prepay.code_rep incCode,");
		sql.append(" pm.name payMethod,");
		sql.append(" prepay.fg_canc status,");
		sql.append(" prepay.dt_pay tradeTime,");
		sql.append(" prepay.note,");
		//sql.append(" acc.prepay-acc.acc_lock,  ");
		sql.append(" prepay.amt ");
		sql.append(" from bl_prepay_pat prepay");
		sql.append(" left join en_ent_ip entip on prepay.id_ent=entip.id_ent");
		sql.append(" left join bd_pri_pm pm on prepay.id_pm = pm.id_pm");
		sql.append(" left join pi_pat pat on prepay.id_pat = pat.id_pat");
		//sql.append(" left join pi_pat_card card on card.id_pat = prepay.id_pat");
		//sql.append(" left join pi_pat_acc acc on prepay.id_pat = acc.id_pat");
		sql.append(" where 1=1 and prepay.sd_paytp = '12' and prepay.eu_direct = 1 ");
		sql.append(" and entip.id_ent=? ");
		
		// 对占位符的赋值
		SqlParam sp = new SqlParam();
		sp.addParam(entId);
		
		@SuppressWarnings("unchecked")
		List<WsResultPayInfo> list = (List<WsResultPayInfo>) new DAFacade().execQuery(sql.toString(), sp,
				new BeanListHandler(WsResultPayInfo.class));
		
		if(list!=null && list.size()>0){
			FDouble amt_bml = this.getAmtcret(entId);
			// 修改查询记录的amt值，原来为账户余额，现改为充值金额
			for (WsResultPayInfo info : list) {
				info.setAmt(BlAmtConverUtil.toXmlString(new FDouble(info.getAmt())));
			}
		}
		return list;
	}
}
