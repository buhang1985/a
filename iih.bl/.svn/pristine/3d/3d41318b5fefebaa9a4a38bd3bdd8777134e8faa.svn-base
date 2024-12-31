package iih.bl.st.blpaypatip.bp;

import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.comm.IBlConst;
import iih.bl.comm.util.BlBaseInfoUtils;
import iih.bl.st.blpaypatip.d.BlPayItmPatIpDO;
import iih.bl.st.blpaypatip.d.BlPayPatIpDO;
import iih.bl.st.blpaypatip.i.IBlpaypatipMDORService;
import iih.bl.st.blpaypatiplog.d.BlPayItmPatIpLogDO;
import iih.bl.st.blpaypatiplog.i.IBlpaypatiplogCudService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 保存住院收付款明细日志表
 * 
 * @author LIM
 * @since 2019-11-06
 *
 */
public class BlPaypatItmLogBP {
	List<String> idPrepayList = new ArrayList<String>();
	/**
	 * 保存住院收付款明细日志表
	 * 
	 * @param BlPayItmPatIpLogDO
	 *            住院收付款明细
	 * @return
	 * @throws BizException
	 */
	public BlPayItmPatIpLogDO[] exec(BlPayItmPatIpDO[] payItmDOArr) throws BizException {
		if (ArrayUtil.isEmpty(payItmDOArr))
			return null;
		List<String> unPreList = new ArrayList<String>();
		//1.循环获取非预交金数据
		for (BlPayItmPatIpDO blPayItmPatIpDO : payItmDOArr) {
			if (StringUtil.isEmpty(blPayItmPatIpDO.getId_paypat()) && !unPreList.contains(blPayItmPatIpDO.getSd_pm() + blPayItmPatIpDO.getAmt())) {
				unPreList.add(blPayItmPatIpDO.getSd_pm() + blPayItmPatIpDO.getAmt());
			}
		}
		//2.获取所有支付方式
		Map<String,PriPmDO> pmMap=BlBaseInfoUtils.getPmDOInfo();
		//3.判断交易是收还是退
		FBoolean bCharge = this.bCharge(payItmDOArr[0].getId_paypatip());
		//4.组织日志数据
		List<BlPayItmPatIpLogDO> payItmLogDOList = new ArrayList<BlPayItmPatIpLogDO>();
		for (BlPayItmPatIpDO blPayItmPatIpDO : payItmDOArr) {
			// 如果不是预交金则直接添加到list
			if (StringUtil.isEmpty(blPayItmPatIpDO.getId_paypat())) {
				payItmLogDOList.add(this.convertBlPayItmPatIpLogDO(blPayItmPatIpDO));
			} else {
				//判断是否存在对应的日志记录，如果不存在，则直接添加到list
				List<BlPayItmPatIpLogDO> logDOList = this.getPrePatRet(blPayItmPatIpDO,unPreList,bCharge);
				if (!ListUtil.isEmpty(logDOList)) {
					payItmLogDOList.addAll(logDOList);
				} else {
					payItmLogDOList.add(this.convertBlPayItmPatIpLogDO(blPayItmPatIpDO));
				}
			}
		}
		IBlpaypatiplogCudService ser = ServiceFinder.find(IBlpaypatiplogCudService.class);
		BlPayItmPatIpLogDO[] logArr = ser.insert(payItmLogDOList.toArray(new BlPayItmPatIpLogDO[] {}));
		return logArr;
	}

	/**
	 * 获取预交金退费记录
	 * 
	 * @param id_paypat
	 *            预交金表id
	 * @param id_paypatip
	 *            收付款主表id
	 * @param bCharge
	 * 			     收还是退           
	 * @return
	 * @throws BizException
	 */
	private List<BlPayItmPatIpLogDO> getPrePatRet(BlPayItmPatIpDO blPayItmPatIpDO, List<String> unPreList,FBoolean bCharge) throws BizException {
		List<BlPayItmPatIpLogDO> logList = new ArrayList<BlPayItmPatIpLogDO>();
		String id_paypatip=blPayItmPatIpDO.getId_paypatip();
		String id_paypat=blPayItmPatIpDO.getId_paypat();
		// 根据收退获取日志表数据
		if (FBoolean.TRUE.equals(bCharge)) {
			//获取上次退费的日志数据
			logList = this.getLogDoByCharge(id_paypat);
		} else {
			// 获取上次收的日志数据
			//获取上次收的日志数据
			List<BlPayItmPatIpLogDO> tmplogList = this.getLogDoByRefund(id_paypat);
			List<BlPayItmPatIpLogDO> tmplogList1 =new ArrayList<BlPayItmPatIpLogDO>();
			List<BlPayItmPatIpLogDO> tmplogList2 = new ArrayList<BlPayItmPatIpLogDO>();
			
			for (BlPayItmPatIpLogDO logDO : tmplogList) {
				logDO.setId_paypat_merge(id_paypat);
				if (StringUtil.isEmpty(logDO.getId_paypat())) {
					if (!unPreList.contains(logDO.getSd_pm() + logDO.getAmt())) {
//						logDO.setId_paypat_merge(id_paypat);
						logList.add(logDO);
					}
				}else{
					String sd_amt=blPayItmPatIpDO.getSd_pm()+blPayItmPatIpDO.getAmt();
					if(sd_amt.equals(logDO.getSd_pm() + logDO.getAmt()) 
							&& !idPrepayList.contains(logDO.getSd_pm() + logDO.getAmt())){
						tmplogList1.add(logDO);
						idPrepayList.add(sd_amt);
					}else{
						tmplogList2.add(logDO);
					}
//					if(id_paypat.equals(logDO.getId_paypat())){
////						logDO.setId_paypat_merge(id_paypat);
//						tmplogList1.add(logDO);
//					}else{
////						logDO.setId_paypat_merge(id_paypat);
//						tmplogList2.add(logDO);
//					}
				}
			}
			if(!ListUtil.isEmpty(tmplogList1)){
				logList.addAll(tmplogList1);
			}else if(!ListUtil.isEmpty(tmplogList2)){
				logList.addAll(tmplogList2);
			}
		}
		//循环日志数据赋相应值
		for (BlPayItmPatIpLogDO logDO : logList) {
			logDO.setId_paypatip(id_paypatip);
			logDO.setId_payitmpatip(blPayItmPatIpDO.getId_payitmpatip());
			logDO.setEu_direct(-1 * logDO.getEu_direct());
			logDO.setStatus(DOStatus.NEW);
		}
		return logList;
	}

	/**
	 * 此次是否收费操作
	 * 
	 * @param id_paypatip
	 * @return
	 * @throws BizException
	 */
	private FBoolean bCharge(String id_paypatip) throws BizException {
		IBlpaypatipMDORService ser = ServiceFinder.find(IBlpaypatipMDORService.class);
		BlPayPatIpDO blPayPatIpDO = ser.findById(id_paypatip);
		return blPayPatIpDO != null && blPayPatIpDO.getEu_direct() == IBlConst.BL_CHARGES ? FBoolean.TRUE : FBoolean.FALSE;
	}

	/**
	 * 收找退
	 * 
	 * @return
	 * @throws DAException
	 */
	private List<BlPayItmPatIpLogDO> getLogDoByCharge(String id_paypat) throws DAException {
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("itmlog.id_grp,");
		sb.append("itmlog.id_org,");
		sb.append("itmlog.id_paypat,");
		sb.append("itmlog.id_pm,");
		sb.append("itmlog.sd_pm,");
		sb.append("itmlog.eu_direct,");
		sb.append("itmlog.amt,");
		sb.append("itmlog.id_bank,");
		sb.append("itmlog.bankno,");
		sb.append("itmlog.paymodenode");
		sb.append(" from BL_PAY_ITM_IP_LOG itmlog ");
		sb.append(" where itmlog.id_paypat_merge=? ");
		SqlParam param = new SqlParam();
		param.addParam(id_paypat);

		@SuppressWarnings("unchecked")
		List<BlPayItmPatIpLogDO> list = (List<BlPayItmPatIpLogDO>) new DAFacade().execQuery(sb.toString(), param, new BeanListHandler(BlPayItmPatIpLogDO.class));
		return list;
	}

	/**
	 * 退找收
	 * 
	 * @return
	 * @throws DAException
	 */
	private List<BlPayItmPatIpLogDO> getLogDoByRefund(String id_paypat) throws DAException {
		StringBuilder sb = new StringBuilder();
		sb.append(" select  ");
		sb.append("itmlog.id_grp,");
		sb.append("itmlog.id_org,");
//		sb.append("itmlog.id_paypatip,");
//		sb.append("itmlog.id_payitmpatip,");
		sb.append("itmlog.id_paypat,");
		sb.append("itmlog.id_pm,");
		sb.append("itmlog.sd_pm,");
		sb.append("itmlog.eu_direct,");
		sb.append("itmlog.amt,");
		sb.append("itmlog.id_bank,");
		sb.append("itmlog.bankno,");
		sb.append("itmlog.paymodenode");
		sb.append(" from bl_pay_pat_ip pay ");
		sb.append(" inner join  bl_pay_itm_pat_ip itm on pay.id_paypatip=itm.id_paypatip ");
		sb.append(" inner join bl_st_ip st on pay.id_stip=st.id_stip ");
		sb.append(" inner join BL_PAY_ITM_IP_LOG itmlog on itm.id_payitmpatip=itmlog.id_payitmpatip ");
		sb.append(" inner join bd_pri_pm pm on itm.id_pm=pm.id_pm");
		sb.append(" where exists ( ");
		sb.append(" select pay.id_stip from bl_pay_pat_ip pay ");
		sb.append(" inner join  bl_pay_itm_pat_ip itm on pay.id_paypatip=itm.id_paypatip");
		sb.append(" inner join bl_st_ip stip on pay.id_stip=stip.id_stip ");
		sb.append(" where itm.id_paypat=? and st.id_stip= stip.id_par) ");
		sb.append(" and  pm.fg_ori_rtn='N' and itm.id_pm not in (?,?)");

		SqlParam param = new SqlParam();
		param.addParam(id_paypat);
		param.addParam(IBdPripmCodeConst.ID_PRI_PM_MONEYDEDUCTION);
		param.addParam(IBdPripmCodeConst.ID_PRI_PM_SRVDEDUCTION);
		@SuppressWarnings("unchecked")
		List<BlPayItmPatIpLogDO> list = (List<BlPayItmPatIpLogDO>) new DAFacade().execQuery(sb.toString(), param, new BeanListHandler(BlPayItmPatIpLogDO.class));
		return list;
	}

	/**
	 * 将收付款DO转换为收付款日志DO
	 * 
	 * @param blPayItmPatIpDO
	 * @return
	 */
	private BlPayItmPatIpLogDO convertBlPayItmPatIpLogDO(BlPayItmPatIpDO blPayItmPatIpDO) {
		BlPayItmPatIpLogDO logDO = new BlPayItmPatIpLogDO();
		logDO.setId_grp(Context.get().getGroupId());
		logDO.setId_org(blPayItmPatIpDO.getId_org());
		logDO.setId_paypatip(blPayItmPatIpDO.getId_paypatip());
		logDO.setId_payitmpatip(blPayItmPatIpDO.getId_payitmpatip());
		logDO.setId_paypat(blPayItmPatIpDO.getId_paypat());
		logDO.setId_pm(blPayItmPatIpDO.getId_pm());
		logDO.setSd_pm(blPayItmPatIpDO.getSd_pm());
		logDO.setEu_direct(blPayItmPatIpDO.getEu_direct());
		logDO.setAmt(blPayItmPatIpDO.getAmt());
		logDO.setId_bank(blPayItmPatIpDO.getId_bank());
		logDO.setBankno(blPayItmPatIpDO.getBankno());
		logDO.setPaymodenode(blPayItmPatIpDO.getPaymodenode());
		logDO.setStatus(DOStatus.NEW);
		return logDO;
	}
}
