package iih.bl.cg.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgquery.d.BookRtnDirectEnum;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.pay.blprepaypatpmamtoep.d.BlPrepayPatPmamtOepDO;
import iih.bl.pay.blprepaypatpmamtoep.i.IBlprepaypatpmamtoepCudService;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.d.PayDirectEnum;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepCudService;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepRService;
import iih.bl.st.blprepaysrcpmoep.d.BlPrepaySrcpmOepDO;
import iih.bl.st.blprepaysrcpmoep.i.IBlprepaysrcpmoepCudService;
import iih.bl.st.blstoep.d.BlStOepDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class RedBackBP {
	// private BlpaypatoepAggDO[] all_blpaypatoepAgg=null;
	// private BlpaypatoepAggDO orgin_blpaypatoepAgg=null;

	/**
	 * 根据结算号，查询对应的支付记录
	 * 
	 * @param id_stoep
	 *            结算号
	 * @return 对应的支付记录
	 * @throws BizException
	 */
	public BlpaypatoepAggDO getBlpaypatoepAggDOById_stoep(String id_stoep) throws BizException {
		BlpaypatoepAggDO[] blpaypatoepAggDO_arr = null;
		// 1. 查找原结算信息
		String[] fields = { "id_stoep", "id_paypatoep" };
		DAFacade dafacade = new DAFacade();
		List<BlStOepDO> blStOepDOLst = (List<BlStOepDO>) dafacade.findByCond(BlStOepDO.class, "id_stoep='" + id_stoep + "'", fields);
		if (blStOepDOLst == null || blStOepDOLst.size() == 0) {
			throw new BizException("查询原门诊结算信息失败");
		}
		// 2.查找对应的支付
		BlStOepDO blStOepDO = blStOepDOLst.toArray(new BlStOepDO[0])[0];
		IBlpaypatoepRService iBlpaypatoepRService = ServiceFinder.find(IBlpaypatoepRService.class);
		blpaypatoepAggDO_arr = iBlpaypatoepRService.find(" a0.id_paypatoep='" + blStOepDO.getId_paypatoep() + "'", "", FBoolean.FALSE);
		if (null == blpaypatoepAggDO_arr || blpaypatoepAggDO_arr.length == 0) {
			throw new BizException("查询患者收付款信息失败");
		}
		return blpaypatoepAggDO_arr[0];
	}

	private BlpaypatoepAggDO blpaypatoepAggValueCopy(BlpaypatoepAggDO blpaypatoepAggDO_arr) {
		BlpaypatoepAggDO temp_agg = new BlpaypatoepAggDO();
		List<BlPayItmPatOepDO> temp_item_list = new ArrayList<BlPayItmPatOepDO>();

		BlPayPatOepDO blPayPatOepDO = new BlPayPatOepDO();
		BlPayPatOepDO orgin_blPayPatOepDO = blpaypatoepAggDO_arr.getParentDO();

		blPayPatOepDO.setId_paypatoep(orgin_blPayPatOepDO.getId_paypatoep());
		blPayPatOepDO.setId_grp(orgin_blPayPatOepDO.getId_grp());
		blPayPatOepDO.setId_org(orgin_blPayPatOepDO.getId_org());
		blPayPatOepDO.setId_enttp(orgin_blPayPatOepDO.getId_enttp());
		blPayPatOepDO.setCode_enttp(orgin_blPayPatOepDO.getCode_enttp());
		blPayPatOepDO.setId_paytp(orgin_blPayPatOepDO.getId_paytp());
		blPayPatOepDO.setSd_paytp(orgin_blPayPatOepDO.getSd_paytp());
		blPayPatOepDO.setId_pat(orgin_blPayPatOepDO.getId_pat());
		blPayPatOepDO.setEu_direct(orgin_blPayPatOepDO.getEu_direct());
		blPayPatOepDO.setAmt(orgin_blPayPatOepDO.getAmt());
		blPayPatOepDO.setDt_pay(orgin_blPayPatOepDO.getDt_pay());
		blPayPatOepDO.setId_org_pay(orgin_blPayPatOepDO.getId_org_pay());
		blPayPatOepDO.setId_dep_pay(orgin_blPayPatOepDO.getId_dep_pay());
		blPayPatOepDO.setId_emp_pay(orgin_blPayPatOepDO.getId_emp_pay());
		blPayPatOepDO.setFg_cc(orgin_blPayPatOepDO.getFg_cc());
		blPayPatOepDO.setId_cc(orgin_blPayPatOepDO.getId_cc());
		blPayPatOepDO.setNote(orgin_blPayPatOepDO.getNote());
		blPayPatOepDO.setSd_pttp(orgin_blPayPatOepDO.getSd_pttp());
		blPayPatOepDO.setStatus(DOStatus.NEW);
		BlPayItmPatOepDO[] BlPayItmPatOepDOs = blpaypatoepAggDO_arr.getBlPayItmPatOepDO();
		for (BlPayItmPatOepDO blPayItmPatOepDO : BlPayItmPatOepDOs) {
			BlPayItmPatOepDO temp_BlPayItmPatOepDO = new BlPayItmPatOepDO();
			temp_BlPayItmPatOepDO.setPaymodenode(blPayItmPatOepDO.getPaymodenode());
			temp_BlPayItmPatOepDO.setEu_direct(blPayItmPatOepDO.getEu_direct());
			temp_BlPayItmPatOepDO.setSd_pm(blPayItmPatOepDO.getSd_pm());
			temp_BlPayItmPatOepDO.setId_payitmpatoep(blPayItmPatOepDO.getId_payitmpatoep());
			temp_BlPayItmPatOepDO.setId_paypatoep(blPayItmPatOepDO.getId_paypatoep());
			temp_BlPayItmPatOepDO.setId_grp(blPayItmPatOepDO.getId_grp());
			temp_BlPayItmPatOepDO.setId_org(blPayItmPatOepDO.getId_org());
			temp_BlPayItmPatOepDO.setId_pm(blPayItmPatOepDO.getId_pm());
			temp_BlPayItmPatOepDO.setAmt(blPayItmPatOepDO.getAmt());
			temp_BlPayItmPatOepDO.setId_bank(blPayItmPatOepDO.getId_bank());
			temp_BlPayItmPatOepDO.setBankno(blPayItmPatOepDO.getBankno());
			temp_BlPayItmPatOepDO.setDs(blPayItmPatOepDO.getDs());
			temp_BlPayItmPatOepDO.setSv(blPayItmPatOepDO.getSv());
			temp_BlPayItmPatOepDO.setStatus(DOStatus.NEW);
			temp_item_list.add(temp_BlPayItmPatOepDO);

		}
		temp_agg.setParentDO(blPayPatOepDO);
		temp_agg.setBlPayItmPatOepDO(temp_item_list.toArray(new BlPayItmPatOepDO[] {}));

		return temp_agg;
	}

	/**
	 * 收付款红冲数据的后续处理：如果有预交金，且修改门诊预交金账户，更新预交金_患者_收支总金额表， 保存收付款_预交金_费用来源_门急体表
	 * 
	 * @param red_blpaypatoepAggDOs
	 *            红冲的收付款记录
	 * @param id_paypatoep
	 *            原始收付款的主键
	 * @throws BizException
	 */
	public void savePrepayAndBlPrepayPatPmamtOepDO(BlpaypatoepAggDO[] red_blpaypatoepAggDOs, String id_paypatoep) throws BizException {
		// 退费也要处理结存的预交金
		// 1.如果患者采用预交金支付，则统计预交金支付金额，且修改门诊预交金账户
		DoOepFgAccAmtAcc doOepFgAccAmtAccBp = new DoOepFgAccAmtAcc();
		doOepFgAccAmtAccBp.doPayByPrepay_rtn(red_blpaypatoepAggDOs);

		// 2.查 收付款_预交金_费用来源_门急体
		IBlprepaypatpmamtoepCudService iBlprepaypatpmamtoepCudService = ServiceFinder.find(IBlprepaypatpmamtoepCudService.class);
		IBlprepaysrcpmoepCudService iBlprepaysrcpmoepCudService = ServiceFinder.find(IBlprepaysrcpmoepCudService.class);
		// 查支付方式优先级
		DAFacade dafacade = new DAFacade();
		StringBuffer sqlb1 = new StringBuffer();
		sqlb1.append("select b.* from bd_pri_pm a,bl_prepay_pat_pmamt_oep b where a.id_pm=b.id_pm ");
		sqlb1.append(" and b.id_pat=? order by a.prepay_lv asc");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(red_blpaypatoepAggDOs[0].getParentDO().getId_pat());
		List<BlPrepayPatPmamtOepDO> blPrepayPatPmamtOepDOLst = (List<BlPrepayPatPmamtOepDO>) dafacade.execQuery(sqlb1.toString(), sqlp, new BeanListHandler(BlPrepayPatPmamtOepDO.class));
		if (blPrepayPatPmamtOepDOLst == null || blPrepayPatPmamtOepDOLst.size() == 0) {
			// 为了兼容老数据，因此注销
			// throw new BizException("查询预交金各种付款方式收支总金额失败！");
		} else {
			BlPrepayPatPmamtOepDO[] blPrepayPatPmamtOepDOArr = blPrepayPatPmamtOepDOLst.toArray(new BlPrepayPatPmamtOepDO[0]);
			BlPayItmPatOepDO[] new_blPayItmPatOepDO_arr = red_blpaypatoepAggDOs[0].getBlPayItmPatOepDO();
			StringBuffer sqlb = new StringBuffer();
			sqlb.append(" select c.* ");
			sqlb.append("   from bl_pay_pat_oep a ");
			sqlb.append("  inner join bl_pay_itm_pat_oep b ");
			sqlb.append("     on a.id_paypatoep = b.id_paypatoep ");
			sqlb.append("   inner join BL_PREPAY_SRCPM_OEP c ");
			sqlb.append("     on b.id_payitmpatoep = c.id_payitmpatoep ");
			sqlb.append("  where a.id_paypatoep = ? ");
			SqlParam sqlp1 = new SqlParam();
			sqlp1.addParam(id_paypatoep);
			DAFacade dafacade1 = new DAFacade();
			// 查原始：收付款_预交金_费用来源_门急体
			List<BlPrepaySrcpmOepDO> blPrepaySrcpmOepDOLst = (List<BlPrepaySrcpmOepDO>) dafacade1.execQuery(sqlb.toString(), sqlp1, new BeanListHandler(BlPrepaySrcpmOepDO.class));

			for (BlPayItmPatOepDO blPayItmPatOepDO : new_blPayItmPatOepDO_arr) {
				if (IBdPripmCodeConst.ID_PRI_PM_PAY.equals(blPayItmPatOepDO.getId_pm())) // 预交金
				{
					if (blPrepaySrcpmOepDOLst != null && blPrepaySrcpmOepDOLst.size() > 0) {
						BlPrepaySrcpmOepDO[] blPrepaySrcpmOepDOArr = blPrepaySrcpmOepDOLst.toArray(new BlPrepaySrcpmOepDO[0]);
						for (BlPrepaySrcpmOepDO blPrepaySrcpmOepDO : blPrepaySrcpmOepDOArr) {
							blPrepaySrcpmOepDO.setId_prepaysrcpmoep(null);
							blPrepaySrcpmOepDO.setId_payitmpatoep(blPayItmPatOepDO.getId_payitmpatoep());
							blPrepaySrcpmOepDO.setStatus(DOStatus.NEW);
							for (BlPrepayPatPmamtOepDO blPrepayPatPmamtOepDO : blPrepayPatPmamtOepDOArr) {
								if (blPrepaySrcpmOepDO.getId_pm_src().equals(blPrepayPatPmamtOepDO.getId_pm())) {
									if (red_blpaypatoepAggDOs[0].getParentDO().getEu_direct() == BookRtnDirectEnum.REFUND) // 退
									{
										if (blPayItmPatOepDO.getEu_direct() == PayDirectEnum.CHARGE) // 退
										{
											blPrepayPatPmamtOepDO.setAmt_out(blPrepayPatPmamtOepDO.getAmt_out().add(blPayItmPatOepDO.getAmt()));
										} else // 找零
										{
											blPrepayPatPmamtOepDO.setAmt_in(blPrepayPatPmamtOepDO.getAmt_in().add(blPayItmPatOepDO.getAmt()));
										}
									} else // 收
									{
										if (blPayItmPatOepDO.getEu_direct() == PayDirectEnum.CHARGE) // 收
										{
											blPrepayPatPmamtOepDO.setAmt_in(blPrepayPatPmamtOepDO.getAmt_in().add(blPayItmPatOepDO.getAmt()));
										} else // 找零
										{
											blPrepayPatPmamtOepDO.setAmt_out(blPrepayPatPmamtOepDO.getAmt_out().add(blPayItmPatOepDO.getAmt()));
										}
									}
									blPrepayPatPmamtOepDO.setStatus(DOStatus.UPDATED);
								}
							}
						}
					}

					// 3.更新预交金_患者_收支总金额表
					iBlprepaypatpmamtoepCudService.save(blPrepayPatPmamtOepDOArr);
					// 4.保存收付款_预交金_费用来源_门急体表
					iBlprepaysrcpmoepCudService.save(blPrepaySrcpmOepDOLst.toArray(new BlPrepaySrcpmOepDO[0]));
				}
			}
		}
	}

	/**
	 * 保存红冲门诊收付款
	 * 
	 * @param id_paypatoep
	 * @return 保存的红冲门诊收付款
	 * @throws BizException
	 */
	public BlpaypatoepAggDO[] redBack_BlpaypatoepAgg(String id_paypatoep, FDateTime strDateTime, OperatorInfoDTO operatorInfoDTO) throws BizException {
		BlpaypatoepAggDO orgin_blpaypatoepAgg = null;
		// 1. 原门诊收付款
		IBlpaypatoepRService iBlpaypatoepRService = ServiceFinder.find(IBlpaypatoepRService.class);
		BlpaypatoepAggDO[] blpaypatoepAggDO_arr = iBlpaypatoepRService.find(" a0.id_paypatoep='" + id_paypatoep + "'", "", FBoolean.FALSE);
		if (null == blpaypatoepAggDO_arr) {
			throw new BizException("查询患者收付款信息失败");
		}
		orgin_blpaypatoepAgg = blpaypatoepAggValueCopy(blpaypatoepAggDO_arr[0]);

		// 2. 生成红冲门诊收付款
		// 2.1 收付款主表
		List<BlPayItmPatOepDO> blPayItmPatOepDO_list = new ArrayList<BlPayItmPatOepDO>();
		BlPayPatOepDO blPayPatOepDO = blpaypatoepAggDO_arr[0].getParentDO();
		// blPayPatOepDO.setNote("退费："+blPayPatOepDO.getId_paypatoep());
		blPayPatOepDO.setId_paypatoep(null);
		blPayPatOepDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_STRED);
		blPayPatOepDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_STRED);
		if (blPayPatOepDO.getEu_direct() == 1)// （原-1变1，原1变-1）
		{
			blPayPatOepDO.setEu_direct(BookRtnDirectEnum.REFUND);
		} else {
			blPayPatOepDO.setEu_direct(BookRtnDirectEnum.CHARGES);
		}
		blPayPatOepDO.setId_dep_pay(operatorInfoDTO.getId_dep());
		blPayPatOepDO.setId_org_pay(operatorInfoDTO.getId_org_emp());
		blPayPatOepDO.setId_emp_pay(operatorInfoDTO.getId_emp());
		blPayPatOepDO.setFg_cc(FBoolean.FALSE);
		blPayPatOepDO.setId_cc(null);
		blPayPatOepDO.setNote(null);
		blPayPatOepDO.setDt_pay(strDateTime);
		blPayPatOepDO.setStatus(DOStatus.NEW);
		// 2.2 收付款子表
		BlPayItmPatOepDO[] blPayItmPatOepDO_arr = blpaypatoepAggDO_arr[0].getBlPayItmPatOepDO();
		for (int j = 0; j < blPayItmPatOepDO_arr.length; j++) {
			blPayItmPatOepDO_arr[j].setId_payitmpatoep(null);
			blPayItmPatOepDO_arr[j].setId_paypatoep(null);
			blPayItmPatOepDO_arr[j].setId_org(operatorInfoDTO.getId_org());
			// （原-1变1，原1变-1）
			if (blPayItmPatOepDO_arr[j].getEu_direct() == 1) {
				blPayItmPatOepDO_arr[j].setEu_direct(BookRtnDirectEnum.REFUND);
			} else {
				blPayItmPatOepDO_arr[j].setEu_direct(BookRtnDirectEnum.CHARGES);
			}
			blPayItmPatOepDO_arr[j].setFg_realpay(FBoolean.FALSE);
			blPayItmPatOepDO_arr[j].setStatus(DOStatus.NEW);
			blPayItmPatOepDO_list.add(blPayItmPatOepDO_arr[j]);
		}
		// 3.保存红冲收付款
		BlpaypatoepAggDO red_BlpaypatoepAggDO = new BlpaypatoepAggDO();
		red_BlpaypatoepAggDO.setParentDO(blPayPatOepDO);
		red_BlpaypatoepAggDO.setBlPayItmPatOepDO(blPayItmPatOepDO_list.toArray(new BlPayItmPatOepDO[] {}));
		// blpaypatoepAggDO_arr[0]=red_BlpaypatoepAggDO;
		IBlpaypatoepCudService iBlpaypatoepCudService = ServiceFinder.find(IBlpaypatoepCudService.class);
		BlpaypatoepAggDO[] new_blpaypatoepAggDO_arr = iBlpaypatoepCudService.save(new BlpaypatoepAggDO[] { red_BlpaypatoepAggDO });
		if (null == new_blpaypatoepAggDO_arr) {
			throw new BizException("保存红冲患者收付款信息失败");
		}
		// //退费不处理结存的预交金
		// DoOepFgAccAmtAcc doOepFgAccAmtAccBp=new DoOepFgAccAmtAcc();
		// doOepFgAccAmtAccBp.doOepPrepayConsumeAndTransferPrepay_refund(new
		// BlpaypatoepAggDO[]{red_BlpaypatoepAggDO});

		return new_blpaypatoepAggDO_arr;
	}

	/**
	 * 保存指定的退款方式门诊收付款
	 * 
	 * @param blpaypatoepAggDO
	 *            指定的退款方式门诊收付款
	 * @return 保存的红冲门诊收付款
	 * @throws BizException
	 */
	public BlpaypatoepAggDO[] redBack_oepRefund_BlpaypatoepAgg(BlpaypatoepAggDO blpaypatoepAggDO) throws BizException {
		// 1.门诊退费的退费调用， eu_direct设置为1，但是重划重收设置为1，因此需要强制设置方向
		Integer eu_direct = blpaypatoepAggDO.getParentDO().getEu_direct();
		BlpaypatoepAggDO blpaypatoepAggDO1 = (BlpaypatoepAggDO) blpaypatoepAggDO.clone();
		if (eu_direct == BookRtnDirectEnum.CHARGES) // 数据来源重划重收
		{
			blpaypatoepAggDO1.getParentDO().setEu_direct(-1);
			for (BlPayItmPatOepDO blPayItmPatOepDO : blpaypatoepAggDO1.getBlPayItmPatOepDO()) {
				if (blPayItmPatOepDO.getEu_direct() == 1) {
					blPayItmPatOepDO.setEu_direct(BookRtnDirectEnum.REFUND);
				} else {
					blPayItmPatOepDO.setEu_direct(BookRtnDirectEnum.CHARGES);
				}
			}
		}

		// 2.保存红冲收付款(退的门诊收付款)
		IBlpaypatoepCudService iBlpaypatoepCudService = ServiceFinder.find(IBlpaypatoepCudService.class);
		BlpaypatoepAggDO[] new_blpaypatoepAggDO_arr = iBlpaypatoepCudService.save(new BlpaypatoepAggDO[] { blpaypatoepAggDO1 });
		if (null == new_blpaypatoepAggDO_arr) {
			throw new BizException("保存红冲患者收付款信息失败");
		}
		// //退费不处理结存的预交金
		// DoOepFgAccAmtAcc doOepFgAccAmtAccBp=new DoOepFgAccAmtAcc();
		// doOepFgAccAmtAccBp.doOepPrepayConsumeAndTransferPrepay_refund(new
		// BlpaypatoepAggDO[]{red_BlpaypatoepAggDO});
		// 退费也要处理结存的预交金
		// 3.如果患者采用预交金支付，则统计预交金支付金额，且修改门诊预交金账户
		DoOepFgAccAmtAcc doOepFgAccAmtAccBp = new DoOepFgAccAmtAcc();
		doOepFgAccAmtAccBp.doPayByPrepay_rtn(new BlpaypatoepAggDO[] { blpaypatoepAggDO });

		return new_blpaypatoepAggDO_arr;
	}

	/**
	 * 重收BlpaypatoepAggDO
	 * 
	 * @param orgin_BlpaypatoepAggDO_arr
	 *            ：原收费BlpaypatoepAggDO信息
	 * @param BlpaypatoepAggDO_arr
	 *            ：退费的BlpaypatoepAggDO信息(如果AllRefundAndAllCharge=FBoolean.TRUE，
	 *            该参数表示收费的信息） 收付款信息（重收的收付款信息） 数据来源于挂号的重收：原收费信息（正向）
	 *            数据来源于门诊结算的退费：退费的信息（负向） 数据来源于门诊结算的重划重收：新收费信息（正向）
	 * @param operatorInfoDTO
	 *            ：操作员
	 * @param strDateTime
	 * @param AllRefundAndAllCharge
	 *            :是否全退重收。FBoolean.TRUE:全退重收;FBoolean.FALSE:退费
	 * @return
	 * @throws BizException
	 */
	public BlpaypatoepAggDO[] reCharge_BlpaypatoepAgg(BlpaypatoepAggDO orgin_BlpaypatoepAggDO_arr, BlpaypatoepAggDO BlpaypatoepAggDO_arr, OperatorInfoDTO operatorInfoDTO, FDateTime strDateTime, FBoolean AllRefundAndAllCharge) throws BizException {
		if (AllRefundAndAllCharge.booleanValue()) // 重退重收，则refund_BlpaypatoepAggDO_arr表示新的收付款信息
		{
			orgin_BlpaypatoepAggDO_arr.getParentDO().setId_paypatoep(null);
			orgin_BlpaypatoepAggDO_arr.getParentDO().setStatus(DOStatus.NEW);
			for (BlPayItmPatOepDO blPayItmPatOepDO : orgin_BlpaypatoepAggDO_arr.getBlPayItmPatOepDO()) {
				blPayItmPatOepDO.setId_paypatoep(null);
				blPayItmPatOepDO.setId_payitmpatoep(null);
				blPayItmPatOepDO.setId_paypat(null);
				// blPayItmPatOepDO.setFg_realpay(FBoolean.TRUE);//真实交易
				blPayItmPatOepDO.setFg_realpay(FBoolean.FALSE);// 非真实交易。若设置成真实交易，则结账会出问题。例如，收款员只做了重划重收操作，实际没有收费
				blPayItmPatOepDO.setStatus(DOStatus.NEW);
			}
			return new BlpaypatoepAggDO[] { orgin_BlpaypatoepAggDO_arr };
		}

		// 直接在原收付款记录上增加一条记录即可
		FDouble amt = new FDouble(0);
		String orgin_id_paypatoep = orgin_BlpaypatoepAggDO_arr.getParentDO().getId_paypatoep();
		List<BlPayItmPatOepDO> all_BlPayItmPatOepDO_list = new ArrayList<BlPayItmPatOepDO>();

		HashMap<String, String> pmPayModeMap = new HashMap<String, String>();

		// 之前的收付款明细
		BlPayItmPatOepDO[] orgin_blPayItmPatOepDOs = orgin_BlpaypatoepAggDO_arr.getBlPayItmPatOepDO();
		for (int j = 0; j < orgin_blPayItmPatOepDOs.length; j++) {
			orgin_blPayItmPatOepDOs[j].setId_payitmpatoep(null);
			orgin_blPayItmPatOepDOs[j].setId_paypatoep(null);
			orgin_blPayItmPatOepDOs[j].setId_paypat(null);
			orgin_blPayItmPatOepDOs[j].setFg_realpay(FBoolean.FALSE);// 非真实交易
			orgin_blPayItmPatOepDOs[j].setStatus(DOStatus.NEW);
			all_BlPayItmPatOepDO_list.add(orgin_blPayItmPatOepDOs[j]);
			//获取原退款费用真实金额的凭据数据
			if (!pmPayModeMap.containsKey(orgin_blPayItmPatOepDOs[j].getPm_code())&&FBoolean.TRUE.equals(orgin_blPayItmPatOepDOs[j].getFg_realpay())) {
				pmPayModeMap.put(orgin_blPayItmPatOepDOs[j].getPm_code(), orgin_blPayItmPatOepDOs[j].getPaymodenode());
			}
			amt = amt.add(orgin_blPayItmPatOepDOs[j].getAmt().multiply(orgin_blPayItmPatOepDOs[j].getEu_direct()));
		}

		// 新的收付款明细
		BlPayItmPatOepDO[] refund_blPayItmPatOepDOs = BlpaypatoepAggDO_arr.getBlPayItmPatOepDO();
		for (int i = 0; i < refund_blPayItmPatOepDOs.length; i++) {
			refund_blPayItmPatOepDOs[i].setId_payitmpatoep(null);
			refund_blPayItmPatOepDOs[i].setId_paypatoep(null);
			refund_blPayItmPatOepDOs[i].setId_paypat(null);
			if(refund_blPayItmPatOepDOs[i].getFg_realpay()==null)
				refund_blPayItmPatOepDOs[i].setFg_realpay(FBoolean.TRUE); // 真实交易
			refund_blPayItmPatOepDOs[i].setStatus(DOStatus.NEW);
			//赋值原退款费用真实金额的凭据数据
			if (pmPayModeMap.containsKey(refund_blPayItmPatOepDOs[i].getPm_code())) {
				refund_blPayItmPatOepDOs[i].setPaymodenode(pmPayModeMap.get(refund_blPayItmPatOepDOs[i].getPm_code()));
			}
			all_BlPayItmPatOepDO_list.add(refund_blPayItmPatOepDOs[i]);
			amt = amt.add(refund_blPayItmPatOepDOs[i].getAmt().multiply(refund_blPayItmPatOepDOs[i].getEu_direct()));
		}
		BlPayPatOepDO blPayPatOepDO = orgin_BlpaypatoepAggDO_arr.getParentDO();
		blPayPatOepDO.setNote("重收：" + orgin_id_paypatoep);
		blPayPatOepDO.setId_paypatoep(null);
		blPayPatOepDO.setId_paytp(IBlDictCodeConst.ID_PAYTP_STRED);
		blPayPatOepDO.setSd_paytp(IBlDictCodeConst.SD_PAYTP_STRED);
		blPayPatOepDO.setEu_direct(BookRtnDirectEnum.CHARGES);
		blPayPatOepDO.setId_dep_pay(operatorInfoDTO.getId_dep());
		blPayPatOepDO.setId_org_pay(operatorInfoDTO.getId_org_emp());
		blPayPatOepDO.setId_emp_pay(operatorInfoDTO.getId_emp());
		blPayPatOepDO.setFg_cc(FBoolean.FALSE);
		blPayPatOepDO.setAmt(amt); // 绝对值
		// if(amt.compareTo(new FDouble(0))<0)
		// {
		// //blPayPatOepDO.setAmt(amt.multiply(new FDouble(-1)));
		// blPayPatOepDO.setEu_direct(BookRtnDirectEnum.REFUND);
		// }
		// else
		// {
		// blPayPatOepDO.setAmt(amt);
		blPayPatOepDO.setEu_direct(BookRtnDirectEnum.CHARGES);
		// }
		blPayPatOepDO.setId_cc(null);
		blPayPatOepDO.setNote(null);
		blPayPatOepDO.setSd_pttp(IBlDictCodeConst.SD_PTTP_WINDOW);//暂时解决重收终端问题 ly 2018/12/20
		blPayPatOepDO.setDt_pay(strDateTime);
		blPayPatOepDO.setStatus(DOStatus.NEW);
		BlpaypatoepAggDO[] blpaypatoepAggDO = new BlpaypatoepAggDO[1];
		blpaypatoepAggDO[0] = new BlpaypatoepAggDO();
		blpaypatoepAggDO[0].setParentDO(blPayPatOepDO);
		blpaypatoepAggDO[0].setBlPayItmPatOepDO(all_BlPayItmPatOepDO_list.toArray(new BlPayItmPatOepDO[] {}));

		return blpaypatoepAggDO;
	}
	// /**
	// * 原始的收款信息
	// * @return
	// */
	// public BlpaypatoepAggDO getOrgin_blpaypatoepAgg() {
	//
	// return null;
	// }

}
