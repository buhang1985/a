package iih.ei.std.s.v1.bp.bl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import iih.bl.itf.std.bean.constant.IBlWsConst;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipRService;
import iih.ei.std.d.v1.bl.iprechargerecorddto.d.IpRechargeRecordParamDTO;
import iih.ei.std.d.v1.bl.iprechargerecorddto.d.IpRechargeRecordResultDTO;
import iih.ei.std.d.v1.bl.iprechargerecorddto.d.PayInfo;
import iih.ei.std.s.v1.bp.IIHServiceBaseBP;
import iih.ei.std.s.v1.bp.bl.utils.BlAmtConverUtil;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.InpatientDO;
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
 * 住院充值记录查询(含余额)
 * 
 * @author shaokx
 * @date: 2019.09.29
 */
public class GetIpRechargeRecordBP extends IIHServiceBaseBP<IpRechargeRecordParamDTO, IpRechargeRecordResultDTO>{

	@Override
	protected void checkParam(IpRechargeRecordParamDTO param) throws BizException {
		if(param == null){
			throw new BizException("入参为空");
		}
		
		if (StringUtil.isEmpty(param.getCode_hospital())) {
			throw new BizException("充值记录查询入参医院编码为空");
		}

		if (StringUtil.isEmpty(param.getCode_enttp())) {
			throw new BizException("充值记录查询入参就诊类型为空");
		}
		
		if(!IBlWsConst.ENTP_IP.equals(param.getCode_enttp())){
			throw new BizException("就诊类型值不正确");
		}

		if (StringUtil.isEmpty(param.getCode_amr_ip())) {
			throw new BizException("充值记录查询入参关键信息为空:住院号");
		}
		
	}

	@Override
	protected IpRechargeRecordResultDTO process(IpRechargeRecordParamDTO param) throws BizException {
		//获取就诊信息
		String entId=this.getentId(param.getCode_amr_ip());
				
		// 获得账户信息(含余额)
		IpRechargeRecordResultDTO rlt1 = this.getAccInfo(entId);
		
		// 获得充值记录信息(含余额)
		List<PayInfo> patInfoList = this.getPrepayRecord(entId);
		FArrayList arr = new FArrayList();
		arr.addAll(patInfoList);
		rlt1.setPayinfo(arr);
		
		return rlt1;
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
	private IpRechargeRecordResultDTO getAccInfo(String entId) throws BizException {
		
		if(StringUtil.isEmpty(entId)){
			throw new BizException("就诊id为空");
		}
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select");
		sql.append(" pat.code code_pat,");
		sql.append(" enent.name_pat,");
		sql.append(" doc.name sex_pat,");
		sql.append(" pat.dt_birth,");
		sql.append(" pat.id_code code_idnum,");
		sql.append(" decode(enent.fg_ip,'Y','在院','N','出院') status_ip,");
		sql.append(" phyadmdep.name name_dep,");
		sql.append(" entip.name_bed,");
		sql.append(" enent.dt_entry,");
		sql.append(" acc.amt_prepay,");
		sql.append(" acc.amt_uncg amt_total ");
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
		List<IpRechargeRecordResultDTO> list = (List<IpRechargeRecordResultDTO>) new DAFacade().execQuery(sql.toString(), sp,
				new BeanListHandler(IpRechargeRecordResultDTO.class));
		
		if(ListUtil.isEmpty(list)){
			throw new BizException("未查询到患者账户信息");
		}
		// 住院费用总金额（单位分）由元转为分
		list.get(0).setAmt_total(BlAmtConverUtil.toXmlString(new FDouble(list.get(0).getAmt_total())));
		// 预交金总额（单位分）由元转为分
		list.get(0).setAmt_prepay(BlAmtConverUtil.toXmlString(new FDouble(list.get(0).getAmt_prepay())));
		// 预交金可用总额（单位分）由元转为分
		list.get(0).setAmt_balance(this.subUtil(list.get(0).getAmt_prepay(), list.get(0).getAmt_total()));

		if ("在院".equals(list.get(0).getStatus_ip())) {
			// 结算状态
			list.get(0).setFg_st("N");
		} else {
			// 判断出院结算是否已经进行付款
			list.get(0).setFg_st(this.getStStatus(entId));
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
	private List<PayInfo> getPrepayRecord(String entId) throws BizException {
		// 支付票据编码，支付方式，金额状态(取消标志)，交易时间，备注，账户余额
		StringBuilder sql = new StringBuilder();
		sql.append(" select prepay.code_rep code_inc,");
		sql.append(" pm.name name_pm,");
		sql.append(" prepay.fg_canc status_amt,");
		sql.append(" prepay.dt_pay dt_trade,");
		sql.append(" prepay.note,");
		//sql.append(" acc.prepay-acc.acc_lock,  ");
		sql.append(" prepay.amt ");
		sql.append(" from bl_prepay_pat prepay");
		sql.append(" left join en_ent_ip entip on prepay.id_ent=entip.id_ent");
		sql.append(" left join bd_pri_pm pm on prepay.id_pm = pm.id_pm");
		sql.append(" left join pi_pat pat on prepay.id_pat = pat.id_pat");
		//sql.append(" left join pi_pat_card card on card.id_pat = prepay.id_pat");
		//sql.append(" left join pi_pat_acc acc on prepay.id_pat = acc.id_pat");
		sql.append(" where 1=1 and prepay.eu_direct = 1 and prepay.sd_paytp = '12' ");
		sql.append(" and entip.id_ent=? ");
		
		// 对占位符的赋值
		SqlParam sp = new SqlParam();
		sp.addParam(entId);
		
		@SuppressWarnings("unchecked")
		List<PayInfo> list = (List<PayInfo>) new DAFacade().execQuery(sql.toString(), sp,
				new BeanListHandler(PayInfo.class));
		
		FDouble amt_bml = this.getAmtcret(entId);
		// 修改查询记录的amt值，原来为账户余额，现改为充值金额
		for (PayInfo info : list) {
			info.setAmt(BlAmtConverUtil.toXmlString(new FDouble(info.getAmt())));
		}

		return list;
	}

}
