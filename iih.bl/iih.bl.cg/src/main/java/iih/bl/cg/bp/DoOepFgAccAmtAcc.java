package iih.bl.cg.bp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.service.d.OperatorInfoDTO;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.BookRtnDirectEnum;
import iih.bl.pay.blprepaypatpmamtoep.d.BlPrepayPatPmamtOepDO;
import iih.bl.pay.blprepaypatpmamtoep.i.IBlprepaypatpmamtoepCudService;
import iih.bl.pay.service.i.IBLPayMaintainService;
import iih.bl.st.blpaypatip.d.BlPayPatIpDO;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepCudService;
import iih.bl.st.blprepaysrcpmoep.d.BlPrepaySrcpmOepDO;
import iih.bl.st.blprepaysrcpmoep.i.IBlprepaysrcpmoepCudService;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.i.IPatAccServiceExt;
import iih.pi.acc.dto.d.PatRelAmountInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊收费或门诊退费，收付款明细中，如果采用了预交金，需要调用本类方法
 * 
 * @author tcy
 *
 */
public class DoOepFgAccAmtAcc {

	/**
	 * 处理门诊收付款明细中支付方式中与预交金相关的业务 1.若采用预授权，则处理预授权 2.若支付采用预交金，则修改对应的门诊预交金账户和预交金明细表
	 * 3.若找零结存，则修改对应的门诊预交金账户和预交金明细表
	 * 
	 * @param blcgoepAggDO
	 *            门诊费用明细
	 * @param blpaypatoepAggDOs
	 *            门诊支付
	 * @param IsTransferPrepay
	 *            找零是否结存
	 * @param fDateTime
	 *            时间
	 * @throws BizException
	 */
	public void doOepPrepayConsumeAndTransferPrepay(BlcgoepAggDO[] blcgoepAggDO, BlpaypatoepAggDO[] blpaypatoepAggDOs, FBoolean IsTransferPrepay, FDateTime fDateTime) throws BizException {
		// 1.获得预授权金额
		FDouble sum_amt_acc = new FDouble(0);
		String strCodeEntp = "";
		String id_pat = "";
		for (BlcgoepAggDO blcgoepAggDO1 : blcgoepAggDO) {
			BlCgItmOepDO[] blCgItmOepDOs = blcgoepAggDO1.getBlCgItmOepDO();
			for (int j = 0; j < blCgItmOepDOs.length; j++) {
				if(strCodeEntp.isEmpty())
				{
					strCodeEntp = blCgItmOepDOs[j].getCode_enttp();
					id_pat = blCgItmOepDOs[j].getId_pat();
				}
				//TODO yangyang review 2017-07-06
				if(blCgItmOepDOs[j].getFg_refund()!=null && blCgItmOepDOs[j].getFg_refund().booleanValue())
					continue;
				if (blCgItmOepDOs[j].getFg_acc() != null && blCgItmOepDOs[j].getFg_acc().booleanValue()) // 计算预授权金额
				{
					// 由amt_acc改成了amt_ratio,2016-08-31
					sum_amt_acc = sum_amt_acc.add(blCgItmOepDOs[j].getAmt_ratio().multiply(blcgoepAggDO1.getParentDO().getEu_direct()));
				}
			}
		}

		// 2.如果患者采用预交金支付，则统计预交金支付金额，且存入收付款_预交金_费用来源_门急体表，修改门诊预交金账户,修改门诊预交金消费锁定金额
		DoOepFgAccAmtAcc doOepFgAccAmtAccBp = new DoOepFgAccAmtAcc();
		// if(sum_amt_acc.compareTo(new FDouble(0))>0)
		// {
		doOepFgAccAmtAccBp.prepayConsume(blpaypatoepAggDOs, sum_amt_acc);
		// }

		// 3.结存，找零费用转存到门诊预交金账户
		if (IsTransferPrepay.booleanValue()) {
			doOepFgAccAmtAccBp.TransferBalanceToPrepay(blpaypatoepAggDOs[0]);
		}
		return;
	}

	/**
	 * 供红冲使用：处理门诊收付款明细中支付方式中与预交金相关的业务 1.若支付采用预交金，则修改对应的门诊预交金账户和预交金明细表
	 * 2.若找零结存，则修改对应的门诊预交金账户和预交金明细表
	 * 
	 * @param blcgoepAggDO
	 *            门诊费用明细
	 * @param blpaypatoepAggDOs
	 *            门诊支付
	 * @param IsTransferPrepay
	 *            找零是否结存
	 * @param fDateTime
	 *            时间
	 * @throws BizException
	 */
	public void doOepPrepayConsumeAndTransferPrepay_refund(BlpaypatoepAggDO[] blpaypatoepAggDOs) throws BizException {
		// //1.获得预授权金额
		// FDouble sum_amt_acc=new FDouble(0);
		// for(BlcgoepAggDO blcgoepAggDO1:blcgoepAggDO)
		// {
		// BlCgItmOepDO[] blCgItmOepDOs=blcgoepAggDO1.getBlCgItmOepDO();
		// for(int j=0;j<blCgItmOepDOs.length;j++)
		// {
		// if(blCgItmOepDOs[j].getFg_acc()!=null &&
		// blCgItmOepDOs[j].getFg_acc().booleanValue()) //计算预授权金额
		// {
		// sum_amt_acc=sum_amt_acc.add(blCgItmOepDOs[j].getAmt_acc().multiply(blcgoepAggDO1.getParentDO().getEu_direct()));
		// }
		// }
		// }
		//
		// 1.如果患者采用预交金支付，则统计预交金支付金额，且修改门诊预交金账户,修改门诊预交金消费锁定金额
		DoOepFgAccAmtAcc doOepFgAccAmtAccBp = new DoOepFgAccAmtAcc();
		doOepFgAccAmtAccBp.prepayConsume(blpaypatoepAggDOs, new FDouble(0));

		// 2.结存，找零费用转存到门诊预交金账户
		doOepFgAccAmtAccBp.TransferBalanceToPrepay(blpaypatoepAggDOs[0]);

		return;
	}

	/**
	 * 门诊收费调用：门诊收费调用如果患者采用预交金支付，则统计预交金支付金额，且修改门诊预交金账户,修改门诊预交金消费锁定金额
	 * 
	 * @param blpaypatoepAggDOs
	 *            支付方式
	 * @param sum_amt_acc
	 *            结算明细中属于患者账户授权的金额总计
	 * 
	 * 
	 * @throws BizException
	 */
	public void prepayConsume(BlpaypatoepAggDO[] blpaypatoepAggDOs, FDouble sum_amt_acc) throws BizException {
		//1.更新支付方式中 预交金扣款
		doPayByPrepay(blpaypatoepAggDOs);
		Boolean IsET = blpaypatoepAggDOs[0].getParentDO().getCode_enttp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS);
		if (sum_amt_acc.compareTo(new FDouble(0)) > 0) {
			//2. 修改预交金锁定金额
			// 程序用的add，但业务逻辑是减少消费锁定额
			IPatAccServiceExt patAccImpls = (IPatAccServiceExt) ServiceFinder.find(IPatAccServiceExt.class);
			PiPatAccDO piPatAccDO1 = new PiPatAccDO();
			if(IsET)
				piPatAccDO1 = patAccImpls.updatePatEtAccLock(blpaypatoepAggDOs[0].getParentDO().getId_pat(), sum_amt_acc.multiply(new FDouble(-1)));
			else
			{
				piPatAccDO1 = patAccImpls.PatiAccPreAuthor(blpaypatoepAggDOs[0].getParentDO().getId_pat(), sum_amt_acc.multiply(new FDouble(-1)));
			}
			if (null == piPatAccDO1) {
				throw new BizException("修改患者预交金预授权失败");
			}
		}
	}

	/**
	 * 找零数据结存到预交金账户
	 * 
	 * @param payItmDo
	 *            收付款找零明细数据
	 * @param id_pat
	 *            患者账户主键ID
	 * */
	public void TransferBalanceToPrepay(BlpaypatoepAggDO blpaypatoepAggDO) throws BizException {
		OperatorInfoDTO operatorInfoDTO = new OperatorInfoDTO();
		operatorInfoDTO.setId_dep(blpaypatoepAggDO.getParentDO().getId_dep_pay());
		operatorInfoDTO.setId_emp(blpaypatoepAggDO.getParentDO().getId_emp_pay());
		operatorInfoDTO.setId_grp(blpaypatoepAggDO.getParentDO().getId_grp());
		operatorInfoDTO.setId_org(blpaypatoepAggDO.getParentDO().getId_org());
		operatorInfoDTO.setId_org_emp(blpaypatoepAggDO.getParentDO().getId_org_pay());

		// BlPayItmPatOepDO[]
		// ArrPayItemDo=blpaypatoepAggDO.getBlPayItmPatOepDO();
		IBLPayMaintainService iBLPayMaintainService = ServiceFinder.find(IBLPayMaintainService.class);

		for (BlPayItmPatOepDO item : blpaypatoepAggDO.getBlPayItmPatOepDO()) {
			if (item.getEu_direct()  == -1)// 判断是否找零
			{
				BlPrePayPatDO[] blPrePayPatDOArr = iBLPayMaintainService.TransferBalanceToPatacc(item, blpaypatoepAggDO.getParentDO().getId_pat(), operatorInfoDTO, blpaypatoepAggDO.getParentDO()
						.getId_enttp(), "门诊预交金结算找零数据结存");
				if (blPrePayPatDOArr != null) {
					item.setId_paypat(blPrePayPatDOArr[0].getId_paypat());
					item.setStatus(DOStatus.UPDATED);
					blpaypatoepAggDO.getParentDO().setStatus(DOStatus.UPDATED);
				}
			}

		}
		IBlpaypatoepCudService iBlpaypatoepCudService = ServiceFinder.find(IBlpaypatoepCudService.class);
		BlpaypatoepAggDO[] blpaypatoepAggDOs1 = iBlpaypatoepCudService.save(new BlpaypatoepAggDO[] { blpaypatoepAggDO });
		if (null == blpaypatoepAggDOs1) {
			throw new BizException("保存患者收付款信息失败");
		}
	}

	/**
	 * 门诊收费调用：如果患者采用预交金支付，则统计预交金支付金额，且修改门诊预交金账户,修改门诊预交金消费锁定金额
	 * 排除了找零，如果找零的数据转存到预交金，则单独处理。
	 * 
	 * @param blpaypatoepAggDOs
	 *            支付方式
	 * @throws BizException
	 */
	public void doPayByPrepay(BlpaypatoepAggDO[] blpaypatoepAggDOs) throws BizException {

		Boolean IsET = blpaypatoepAggDOs[0].getParentDO().getCode_enttp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS);
		
		OperatorInfoDTO operatorInfoDTO = new OperatorInfoDTO();
		operatorInfoDTO.setId_dep(blpaypatoepAggDOs[0].getParentDO().getId_dep_pay());
		operatorInfoDTO.setId_emp(blpaypatoepAggDOs[0].getParentDO().getId_emp_pay());
		operatorInfoDTO.setId_grp(blpaypatoepAggDOs[0].getParentDO().getId_grp());
		operatorInfoDTO.setId_org(blpaypatoepAggDOs[0].getParentDO().getId_org());
		operatorInfoDTO.setId_org_emp(blpaypatoepAggDOs[0].getParentDO().getId_org_pay());

		// 如果是预交金结算，则修改预交金账户
		FDouble consumeAmount = new FDouble(0);
		FDouble sum_consumeAmount = new FDouble(0);
		FDouble prepayAmount = new FDouble(0);
		Integer eu_direct = 0;
		boolean updatePay = false;

		// 调用门诊账户接口
		IPatAccServiceExt patAccImpls = (IPatAccServiceExt) ServiceFinder.find(IPatAccServiceExt.class);
		// 1.计算门诊账户余额：调用门诊账户接口
		// prepayAmount = patAccImpls
		// .GetOutpPrepaymentAmount(blpaypatoepAggDOs[0].getParentDO()
		// .getId_pat()); //取到是可用额度

		PatRelAmountInfoDTO patRelAmountInfoDTO = patAccImpls.GetPatRelAmountInfo(blpaypatoepAggDOs[0].getParentDO().getId_pat());
		prepayAmount = IsET ? patRelAmountInfoDTO.getPrepay_emgstay() : patRelAmountInfoDTO.getPrepay();// 预交金额

		// 2.预交金合计(门诊收费）
		for (int i = 0; i < blpaypatoepAggDOs.length; i++) {
			BlPayItmPatOepDO[] blPayItmPatOepDO_arr = blpaypatoepAggDOs[i].getBlPayItmPatOepDO();
	
			for (int j = 0; j < blPayItmPatOepDO_arr.length; j++) {
				if (IBdPripmCodeConst.ID_PRI_PM_PAY.equals(blPayItmPatOepDO_arr[j].getId_pm()) && FBoolean.TRUE.equals(blPayItmPatOepDO_arr[j].getFg_realpay())) // 预交金
				{
					sum_consumeAmount = sum_consumeAmount.add(blPayItmPatOepDO_arr[j].getAmt().multiply(blPayItmPatOepDO_arr[j].getEu_direct()));
							
				}
			}
		}

		// 3.门诊收费：判断预交金是否足够
		if (prepayAmount.compareTo(sum_consumeAmount) < 0) {
			throw new BizException("预交金余额不足，不能采用预交金支付。\r\n预交金余额：" + prepayAmount.setScale(-2, BigDecimal.ROUND_HALF_UP).toString() + "。\r\n需要预交金支付额："
					+ sum_consumeAmount.setScale(-2, BigDecimal.ROUND_HALF_UP).toString());
		}

		// 4.循环修改预交金表和账户表
		// 查支付方式优先级
		IBlprepaypatpmamtoepCudService iBlprepaypatpmamtoepCudService = ServiceFinder.find(IBlprepaypatpmamtoepCudService.class);
		IBlprepaysrcpmoepCudService iBlprepaysrcpmoepCudService = ServiceFinder.find(IBlprepaysrcpmoepCudService.class);
		BlPrepayPatPmamtOepDO[] blPrepayPatPmamtOepDOArr = null;
		DAFacade dafacade = new DAFacade();
		StringBuffer sqlb = new StringBuffer();
		sqlb.append("select b.* from bd_pri_pm a,bl_prepay_pat_pmamt_oep b where a.id_pm=b.id_pm ");
		sqlb.append(" and b.id_pat=? order by a.prepay_lv asc");
		SqlParam sqlp = new SqlParam();
		sqlp.addParam(blpaypatoepAggDOs[0].getParentDO().getId_pat());
		List<BlPrepayPatPmamtOepDO> blPrepayPatPmamtOepDOLst = (List<BlPrepayPatPmamtOepDO>) dafacade.execQuery(sqlb.toString(), sqlp, new BeanListHandler(BlPrepayPatPmamtOepDO.class));
		if (blPrepayPatPmamtOepDOLst == null || blPrepayPatPmamtOepDOLst.size() == 0) {
			// 为了兼容以前老数据，因此注销
			// throw new BizException("查询预交金各种付款方式收支总金额失败！");
		} else {
			blPrepayPatPmamtOepDOArr = blPrepayPatPmamtOepDOLst.toArray(new BlPrepayPatPmamtOepDO[0]);
		}
		for (int i = 0; i < blpaypatoepAggDOs.length; i++) {
			BlPayItmPatOepDO[] blPayItmPatOepDO_arr = blpaypatoepAggDOs[i].getBlPayItmPatOepDO();
			//进行排序--解决重收的时候金额不足的问题
			this.arraySort(blPayItmPatOepDO_arr);
			for (int j = 0; j < blPayItmPatOepDO_arr.length; j++) {
				if (IBdPripmCodeConst.ID_PRI_PM_PAY.equals(blPayItmPatOepDO_arr[j].getId_pm())) // 预交金
				{
					// 4.1.计算预交金支付金额
					consumeAmount = blPayItmPatOepDO_arr[j].getAmt().multiply(blPayItmPatOepDO_arr[j].getEu_direct());

					if (consumeAmount.compareTo(new FDouble(0)) == 0) // 支付没有采用预交金
					{
						continue;
					}
					
					if(FBoolean.FALSE.equals(blPayItmPatOepDO_arr[j].getFg_realpay())){
						continue;
					}

					// 4.2确定预交金表中的方向（收费调用）
					if (consumeAmount.compareTo(FDouble.ZERO_DBL) > 0) // 大于0，说明用了预交金
					{
						eu_direct = BookRtnDirectEnum.RETURNS;// 针对预交金表来说，应该退患者
					} else {
						eu_direct = BookRtnDirectEnum.CHARGE;
					}
					// 4.3.更新预交金余额 ：调用患者账户表，修改预交金账户金额，修改预交金表
					String strSdPayTp = "", strIdPayTP = "", strNote = "";
					if (IsET) {
						strSdPayTp = IBlDictCodeConst.SD_PAYTP_ETPREPAYCONSUME;
						strIdPayTP = IBlDictCodeConst.ID_PAYTP_ETPREPAYCONSUME;
						strNote = "留观预交金结算";
					} else {
						strSdPayTp = IBlDictCodeConst.SD_PAYTP_OPPREPAYCONSUME;
						strIdPayTP = IBlDictCodeConst.ID_PAYTP_OPPREPAYCONSUME;
						strNote = "门诊预交金结算";
					}
					
					String entpId = blpaypatoepAggDOs[i].getParentDO().getId_enttp();
					if(IBdFcDictCodeConst.ID_CODE_ENTP_IP_PRE.equals(entpId)){
						entpId = IBdFcDictCodeConst.ID_CODE_ENTP_OP;
					}
					
					BlPrePayPatDO[] blPrePayPatDOArr = saveBlPayPatInfoByPay(consumeAmount.abs(),
							blpaypatoepAggDOs[i].getParentDO().getId_pat(), operatorInfoDTO, eu_direct, entpId,
							strSdPayTp, strIdPayTP, strNote);
					// 4.4修改收付款明细表中对应的预交金主键
					blpaypatoepAggDOs[i].getParentDO().setStatus(DOStatus.UPDATED);
					blPayItmPatOepDO_arr[j].setId_paypat(blPrePayPatDOArr[0].getId_paypat());
					blPayItmPatOepDO_arr[j].setStatus(DOStatus.UPDATED);
					updatePay = true;

					// 4.5存入收付款_预交金_费用来源_门急体表
					if (blPrepayPatPmamtOepDOLst != null && blPrepayPatPmamtOepDOLst.size() > 0) {
						FDouble amt_temp = consumeAmount;
						List<BlPrepaySrcpmOepDO> blPrepaySrcpmOepDOLst = new ArrayList<BlPrepaySrcpmOepDO>();

						for (BlPrepayPatPmamtOepDO blPrepayPatPmamtOepDO : blPrepayPatPmamtOepDOArr) {
							if (amt_temp.compareTo(FDouble.ZERO_DBL) > 0) {
								if (blPrepayPatPmamtOepDO.getAmt_in().add(blPrepayPatPmamtOepDO.getAmt_out().multiply(new FDouble(-1))).compareTo(amt_temp) >= 0) {
									BlPrepaySrcpmOepDO blPrepaySrcpmOepDO = new BlPrepaySrcpmOepDO();
									blPrepaySrcpmOepDO.setId_prepaysrcpmoep(null);
									blPrepaySrcpmOepDO.setId_payitmpatoep(blPayItmPatOepDO_arr[j].getId_payitmpatoep());
									blPrepaySrcpmOepDO.setAmt(amt_temp);
									blPrepaySrcpmOepDO.setId_pm_src(blPrepayPatPmamtOepDO.getId_pm());
									blPrepaySrcpmOepDO.setStatus(DOStatus.NEW);
									blPrepaySrcpmOepDOLst.add(blPrepaySrcpmOepDO);
									blPrepayPatPmamtOepDO.setAmt_out(blPrepayPatPmamtOepDO.getAmt_out().add(amt_temp));
									blPrepayPatPmamtOepDO.setStatus(DOStatus.UPDATED);
									amt_temp = new FDouble(0);
									break;
								} else// 该种支付方式下预交金不足
								{
									BlPrepaySrcpmOepDO blPrepaySrcpmOepDO = new BlPrepaySrcpmOepDO();
									blPrepaySrcpmOepDO.setId_prepaysrcpmoep(null);
									blPrepaySrcpmOepDO.setId_payitmpatoep(blPayItmPatOepDO_arr[j].getId_payitmpatoep());
									blPrepaySrcpmOepDO.setAmt(blPrepayPatPmamtOepDO.getAmt_in().add(blPrepayPatPmamtOepDO.getAmt_out().multiply(new FDouble(-1))));
									blPrepaySrcpmOepDO.setId_pm_src(blPrepayPatPmamtOepDO.getId_pm());
									blPrepaySrcpmOepDO.setStatus(DOStatus.NEW);
									blPrepaySrcpmOepDOLst.add(blPrepaySrcpmOepDO);
									blPrepayPatPmamtOepDO.setAmt_out(blPrepayPatPmamtOepDO.getAmt_in());// 收支相等
									blPrepayPatPmamtOepDO.setStatus(DOStatus.UPDATED);
									amt_temp = amt_temp.add(blPrepaySrcpmOepDO.getAmt().multiply(new FDouble(-1)));
								}
							} else {
								break;
							}
						}
						// 更新预交金_患者_收支总金额表
						iBlprepaypatpmamtoepCudService.save(blPrepayPatPmamtOepDOArr);
						// 保存收付款_预交金_费用来源_门急体表
						iBlprepaysrcpmoepCudService.save(blPrepaySrcpmOepDOLst.toArray(new BlPrepaySrcpmOepDO[0]));
					}
				}
			}
		}

		// 5.保存支付明细中对应的预交金记录主键
		if (updatePay) {
			Object obj222 = ServiceFinder.find(IBlpaypatoepCudService.class);
			BlpaypatoepAggDO[] blpaypatoepAggDOs1 = ((IBlpaypatoepCudService) obj222).save(blpaypatoepAggDOs);
			if (null == blpaypatoepAggDOs1) {
				throw new BizException("保存患者收付款信息失败");
			}
		}
	}

	/**
	 * 对数组进行排序(按Eu_direct升序)
	 */
	private BlPayItmPatOepDO[] arraySort(BlPayItmPatOepDO[] blPayItmPatOepDO_arr)
	{
		if(ArrayUtil.isEmpty(blPayItmPatOepDO_arr)){
			
			return blPayItmPatOepDO_arr;
		}
		BlPayItmPatOepDO itmDo=new BlPayItmPatOepDO();
		for(int i=0;i<blPayItmPatOepDO_arr.length;i++){
			for(int j=i+1;j<blPayItmPatOepDO_arr.length;j++){
				
			   if(blPayItmPatOepDO_arr[i].getEu_direct()>blPayItmPatOepDO_arr[j].getEu_direct()) {
				   itmDo = blPayItmPatOepDO_arr[i];
                    blPayItmPatOepDO_arr[i] = blPayItmPatOepDO_arr[j];
                    blPayItmPatOepDO_arr[j] = itmDo;
                }
			}
		}
		
		return blPayItmPatOepDO_arr;
	}
	
	/**
	 * 门诊退费调用：如果患者采用预交金支付，则统计预交金支付金额，且修改门诊预交金账户,修改门诊预交金消费锁定金额
	 * 排除了找零，如果找零的数据转存到预交金，则单独处理。 退费不用和预交金账户余额进行比较
	 * 
	 * @param blpaypatoepAggDOs
	 *            支付方式
	 * @throws BizException
	 */
	public void doPayByPrepay_rtn(BlpaypatoepAggDO[] blpaypatoepAggDOs) throws BizException {

		OperatorInfoDTO operatorInfoDTO = new OperatorInfoDTO();
		operatorInfoDTO.setId_dep(blpaypatoepAggDOs[0].getParentDO().getId_dep_pay());
		operatorInfoDTO.setId_emp(blpaypatoepAggDOs[0].getParentDO().getId_emp_pay());
		operatorInfoDTO.setId_grp(blpaypatoepAggDOs[0].getParentDO().getId_grp());
		operatorInfoDTO.setId_org(blpaypatoepAggDOs[0].getParentDO().getId_org());
		operatorInfoDTO.setId_org_emp(blpaypatoepAggDOs[0].getParentDO().getId_org_pay());

		// FDouble prepayAmount = new FDouble(0);
		Integer eu_direct = 0;
		boolean updatePay = false;

		// 1.获得需要预交金支付的金额
		for (int i = 0; i < blpaypatoepAggDOs.length; i++) {
			BlPayItmPatOepDO[] blPayItmPatOepDO_arr = blpaypatoepAggDOs[i].getBlPayItmPatOepDO();
			for (int j = 0; j < blPayItmPatOepDO_arr.length; j++) {
				// 2.只处理预交金
				if (IBdPripmCodeConst.ID_PRI_PM_PAY.equals(blPayItmPatOepDO_arr[j].getId_pm())) // 预交金,（预交金不找零，结存也是增加找零的现金，再增加一笔预交金）
				{
					// 如果是预交金结算，则修改预交金账户
					FDouble consumeAmount = blPayItmPatOepDO_arr[j].getAmt().multiply(blPayItmPatOepDO_arr[j].getEu_direct());

					if (consumeAmount.compareTo(new FDouble(0)) == 0) // 支付没有采用预交金
					{
						continue;
					}
					
					if(FBoolean.FALSE.equals(blPayItmPatOepDO_arr[j].getFg_realpay())){
						continue;
					}

					// 3.确定预交金方向，红冲修改，即退预交金
					if (consumeAmount.compareTo(FDouble.ZERO_DBL) > 0 ) {
						eu_direct = BookRtnDirectEnum.RETURNS;
					} else {
						eu_direct = BookRtnDirectEnum.CHARGE;
					}
					// 4.增加对应的预交金记录，修改预交金账户金额
					// 退费，对于预交金来说是收
					BlPrePayPatDO[] blPrePayPatDOArr = saveBlPayPatInfoByPay(consumeAmount.abs(), blpaypatoepAggDOs[0].getParentDO().getId_pat(), operatorInfoDTO, eu_direct, blpaypatoepAggDOs[0]
							.getParentDO().getId_enttp(), IBlDictCodeConst.SD_PAYTP_OPPREPAYCONSUME, IBlDictCodeConst.ID_PAYTP_OPPREPAYCONSUME, "门诊预交金结算");
					if (blPrePayPatDOArr != null) {
						blPayItmPatOepDO_arr[j].setId_paypat(blPrePayPatDOArr[0].getId_paypat());
						blPayItmPatOepDO_arr[j].setStatus(DOStatus.UPDATED);
					}
					updatePay = true;
				}
			}
		}

		// 5.保存支付明细中对应的预交金记录主键
		if (updatePay) {
			IBlpaypatoepCudService payService = ServiceFinder.find(IBlpaypatoepCudService.class);
			BlpaypatoepAggDO[] blpaypatoepAggDOs1 = payService.save(blpaypatoepAggDOs);
			if (null == blpaypatoepAggDOs1) {
				throw new BizException("保存患者收付款信息失败");
			}
		}

	}

	/**
	 * 收、退费方式为预交金，即在预交金中增加相关一条预交金操作记录，并修改预交金账户金额
	 * 
	 * @param payment_prepay_amt
	 *            支付的预交金金额
	 * @param id_pat
	 *            患者ID
	 * @param operatorInfoDTO
	 *            操作员信息
	 * @param eu_direct
	 *            预交金收付款方向
	 * @param entType
	 *            就诊类型
	 * @param sd_paytp
	 *            收付款方式SD
	 * @param id_paytp
	 *            收付款方式iD
	 * @param note
	 *            备注
	 * @return
	 * @throws BizException
	 */
	public BlPrePayPatDO[] saveBlPayPatInfoByPay(FDouble payment_prepay_amt, String id_pat, OperatorInfoDTO operatorInfoDTO, Integer eu_direct, String entType, String sd_paytp, String id_paytp,
			String note) throws BizException {
		IBLPayMaintainService iBLPayMaintainService = ServiceFinder.find(IBLPayMaintainService.class);
		return iBLPayMaintainService.saveBlPayPatInfoByPay(payment_prepay_amt, id_pat, operatorInfoDTO, eu_direct, entType, sd_paytp, id_paytp, note);
	}

	/**
	 * 更新患者账户的acc_lock字段
	 * 
	 * @param id_pat
	 * @param sum_amt_acc_FromOepCgItms
	 * @throws BizException
	 */
	public void acc_lockUpdate(String id_pat, FDouble sum_amt_acc_FromOepCgItms) throws BizException {
		if (sum_amt_acc_FromOepCgItms.compareTo(0) > 0) {
			// 调用门诊账户接口
			IPatAccServiceExt patAccImpls = (IPatAccServiceExt) ServiceFinder.find(IPatAccServiceExt.class);
			// 程序用的add，但业务逻辑是减少消费锁定额
			PiPatAccDO piPatAccDO1 = patAccImpls.PatiAccPreAuthor(id_pat, sum_amt_acc_FromOepCgItms.multiply(new FDouble(-1)));
			if (null == piPatAccDO1) {
				throw new BizException("修改患者预交金预授权失败");
			}
		}
	}

}
