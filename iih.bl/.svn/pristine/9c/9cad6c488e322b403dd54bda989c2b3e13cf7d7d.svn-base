package iih.bl.cg.s.bp;

import java.util.HashMap;

import com.founder.ws.back.WsRefundService;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bd.srv.srvselfcaitm.d.eudirect;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.cg.extritf.d.EuRefundType;
import iih.bl.cg.extritf.d.RefundInfoDO;
import iih.bl.comm.IBlConst;
import iih.bl.params.BlParams;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepRService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.d.StTypeEnum;
import iih.bl.st.blstoep.i.IBlstoepRService;
import iih.en.pv.dto.d.OpBasicDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.sc.apt.i.IScAptOutQryService;
import iih.sc.apt.scapt.d.AptExChlDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.message.notice.d.priorityenum;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 根据退费编号组装退费接口所需接口 调用 第三方接口BP
 * 
 * @author yang.lu 2017年6月27日22:09:29
 *
 */
public class SendRefundMsgByStIdBP {

	/**
	 * 根据退费编号组装退费接口所需接口 调用 第三方接口BP
	 *
	 * @param id_stoep
	 *            退费编号
	 * @author yang.lu 2017年6月27日22:09:29
	 *
	 */
	public void exec(String id_stoep, WsRefundService refundService) throws BizException {

		FBoolean isPublic = BlParams.BLSTOEP0001();
		// 判断参数模板中是否发送此消息
		if (isPublic != null && isPublic.booleanValue()) {

			// 被退款交易
			BlStOepDO nowstoepdo = GetStOepById_stoep(id_stoep);

			if (nowstoepdo == null) {
				return;
			}

			// 被退款结算数据
			BlpaypatoepAggDO oldAggDo = GetBlPayAggById_stoep(nowstoepdo.getId_stoep());
			if (oldAggDo == null)
				return;
			// 退款结算数据
			BlpaypatoepAggDO outAggDo = GetOutBlPayAggById_stoep(nowstoepdo.getId_stoep(), IBlConst.BL_REFUND);

			// 重收结算数据
			BlpaypatoepAggDO reEntAggDo = GetOutBlPayAggById_stoep(nowstoepdo.getId_stoep(), IBlConst.BL_CHARGES);

			// 2.判断blpaypatoepAggDO.getParentDO().getSd_pttp()!="01"的
			BlPayPatOepDO oepdo = oldAggDo.getParentDO();

			BlPayPatOepDO outoepdo = null;
			if (outAggDo != null) {
				outoepdo = outAggDo.getParentDO();
			}
			BlPayPatOepDO reEntoepdo = null;
			if (reEntAggDo != null) {
				reEntoepdo = reEntAggDo.getParentDO();
			}

			// 发送消息
			RefundInfoDO retfundInfo = new RefundInfoDO();
			if ((nowstoepdo != null && !oepdo.getSd_pttp().equals("01")) || (outoepdo != null && !outoepdo.getSd_pttp().equals("01")) || (reEntoepdo != null && !reEntoepdo.getSd_pttp().equals("01"))) {

				// 判断是门诊退费还是挂号退费
				if (StTypeEnum.ST_OEP_CHARGE.equals(nowstoepdo.getEu_sttp()) || StTypeEnum.ST_OEP_REG.equals(nowstoepdo.getEu_sttp())) {

					retfundInfo.setId_grp(nowstoepdo.getId_grp());
					retfundInfo.setId_org(nowstoepdo.getId_org());
					retfundInfo.setId_pat(nowstoepdo.getId_pat());
					// arg1 退费类型（门诊缴费退费01，挂号退费02）
					String RefundType = StTypeEnum.ST_OEP_CHARGE.equals(nowstoepdo.getEu_sttp()) ? "01" : StTypeEnum.ST_OEP_REG.equals(nowstoepdo.getEu_sttp()) ? "02" : "";
					// arg2 sc_apt_sxchl.code_apt
					String AppCode = GetAppCode(nowstoepdo.getId_ent());
					PatiVisitDO entdo = getEnEntById_ent(nowstoepdo.getId_ent());
					// arg3 患者编码
					String PatientID = entdo.getCode_pat();
					if (entdo != null) {
						// arg4 （门诊01，住院02）
						String DomainID = entdo.getCode_entp() == "10" ? "02" : "01";
						String TickedID = "";
						// arg5 交易明细流水号
						// 本次退费的处方号，多个处方号直接用“,”隔开。bl_cg_itm_oep.code_apply
						BlCgItmOepDO[] cgList = GetBlCgItmOepDOById_stoep(nowstoepdo.getId_stoep());
						if (cgList != null)
							for (BlCgItmOepDO itmOepDO : cgList) {
								if (itmOepDO.getCode_apply() != null)
									TickedID = TickedID + ("".equals(TickedID) ? "" : ",") + itmOepDO.getCode_apply();
							}
						// arg7 患者的挂号次数，来源于就诊
						int Times = getTimesById_ent(nowstoepdo.getId_ent());
						// arg8 结算流水号（当前第三方平台支持长度为5）
						String CheckOuts = StringUtil.subChineseString(nowstoepdo.getCode_st(), nowstoepdo.getCode_st().length() - 5, 5);
						// arg10 患者手机号
						String MobileNo = entdo.getTelno_pat();

						retfundInfo.setEu_refundtype(RefundType);
						retfundInfo.setCode_apt(AppCode);
						retfundInfo.setCode_pat(PatientID);
						retfundInfo.setCode_enttp(DomainID);
						retfundInfo.setCode_apply(TickedID);
						retfundInfo.setTimes_op(Times);
						retfundInfo.setCode_st(CheckOuts);
						retfundInfo.setTelno_pat(MobileNo);
						retfundInfo.setId_emp_operator(nowstoepdo.getId_emp_st());
						// 针对单独重收的业务发送退费消息(挂号业务中 重收时没有原支付数据)
						if (outAggDo == null) {
							BlPayItmPatOepDO[] oldItmpat = oldAggDo.getBlPayItmPatOepDO();
							if (oldItmpat != null && oldItmpat.length != 0) {
								for (BlPayItmPatOepDO blPayItmPatOepDO : oldItmpat) {
									if (isInSend(blPayItmPatOepDO.getPm_code()) && IBlConst.BL_REFUND == blPayItmPatOepDO.getEu_direct() && FBoolean.TRUE.equals(blPayItmPatOepDO.getFg_realpay())) {
										// arg0 第三方同支付宝（微信）的支付流水号，在结算时有传入
										String OrderNo = blPayItmPatOepDO.getPaymodenode();

										// arg9 不是支付方式，是支付终端 + 支付方式的组合
										String PayType = GetItemPmType(oepdo.getSd_pttp(), blPayItmPatOepDO.getPm_code(), entdo.getCode_entp());

										// arg6 退费金额
										// 正数，只传真实交易的退费部分。通过第三方支付时，不会有多条。
										FDouble TicketPay = getTicketPay(blPayItmPatOepDO, oldItmpat);

										retfundInfo.setPaymodenode(OrderNo);
										retfundInfo.setAmt(TicketPay);
										retfundInfo.setPaytype(PayType);
										SendMessage(retfundInfo, refundService);
									}
								}
							}
						}
						// 针对全退业务或重收业务
						else {
							// 针对全退业务
							// 发送退费的真实交易消息
							BlPayItmPatOepDO[] itmpat = outAggDo.getBlPayItmPatOepDO();
							if (itmpat != null && itmpat.length != 0) {
								HashMap<String, String> execMap = new HashMap<String, String>();
								// 循环收款明细发送到第三方接口
								for (BlPayItmPatOepDO blPayItmPatOepDO : itmpat) {
									// 判断是否有需要发消息的支付项目 并且是真实交易
									if (isInSend(blPayItmPatOepDO.getPm_code()) && !execMap.containsKey(blPayItmPatOepDO.getPm_code()) && FBoolean.TRUE.equals(blPayItmPatOepDO.getFg_realpay())) {
										String OrderNo = blPayItmPatOepDO.getPaymodenode();
										if(StringUtil.isEmpty(OrderNo)){
											for (BlPayItmPatOepDO oldpaydo : oldAggDo.getBlPayItmPatOepDO()) {
												if(oldpaydo.getId_pm().equals(blPayItmPatOepDO.getId_pm())&&!StringUtil.isEmpty(oldpaydo.getPaymodenode())){
													// arg0 第三方同支付宝（微信）的支付流水号，在结算时有传入
													OrderNo = oldpaydo.getPaymodenode();
												}
											}
										}
										// arg9 不是支付方式，是支付终端 + 支付方式的组合
										String PayType = GetItemPmType(oepdo.getSd_pttp(), blPayItmPatOepDO.getPm_code(), entdo.getCode_entp());

										// arg6 退费金额
										// 正数，只传真实交易的退费部分。通过第三方支付时，不会有多条。
										FDouble TicketPay = getTicketPay(blPayItmPatOepDO, itmpat);
										retfundInfo.setPaymodenode(OrderNo);
										retfundInfo.setAmt(TicketPay);
										retfundInfo.setPaytype(PayType);
										SendMessage(retfundInfo, refundService);
										execMap.put(blPayItmPatOepDO.getPm_code(), blPayItmPatOepDO.getPm_code());
									}
								}
								// 针对半退重收业务
								if (reEntAggDo != null) {
									// 发送退费的真实交易消息
									BlPayItmPatOepDO[] reItmpat = reEntAggDo.getBlPayItmPatOepDO();
									if (reItmpat != null && reItmpat.length != 0) {
										// 循环收款明细发送到第三方接口
										for (BlPayItmPatOepDO blPayItmPatOepDO : reItmpat) {
											// 判断是否有需要发消息的支付项目 并且是真实交易
											if (isInSend(blPayItmPatOepDO.getPm_code()) && FBoolean.TRUE.equals(blPayItmPatOepDO.getFg_realpay())) {
												// arg0
												// 第三方同支付宝（微信）的支付流水号，在结算时有传入
												String OrderNo = blPayItmPatOepDO.getPaymodenode();
												if(StringUtil.isEmpty(OrderNo)){
													for (BlPayItmPatOepDO oldpaydo : oldAggDo.getBlPayItmPatOepDO()) {
														if(oldpaydo.getId_pm().equals(blPayItmPatOepDO.getId_pm())){
															// arg0 第三方同支付宝（微信）的支付流水号，在结算时有传入
															OrderNo = oldpaydo.getPaymodenode();
														}
													}
												}
												// arg9 不是支付方式，是支付终端 + 支付方式的组合
												String PayType = GetItemPmType(oepdo.getSd_pttp(), blPayItmPatOepDO.getPm_code(), entdo.getCode_entp());

												// arg6 退费金额
												// 正数，只传真实交易的退费部分。通过第三方支付时，不会有多条。
												FDouble TicketPay = getTicketPay(blPayItmPatOepDO, reItmpat);

												retfundInfo.setPaymodenode(OrderNo);
												retfundInfo.setAmt(TicketPay);
												retfundInfo.setPaytype(PayType);
												SendMessage(retfundInfo, refundService);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * 获取对应金额
	 * 
	 * @param blPayItmPatOepDO
	 * @param itmpat
	 * @return
	 */
	private FDouble getTicketPay(BlPayItmPatOepDO blPayItmPatOepDO, BlPayItmPatOepDO[] itmpat) {
		FDouble TicketPay =new FDouble(0);
		TicketPay = TicketPay.add(blPayItmPatOepDO.getAmt().multiply(blPayItmPatOepDO.getEu_direct()));
		for (BlPayItmPatOepDO payItmDO : itmpat) {
			if (!payItmDO.getId_payitmpatoep().equals(blPayItmPatOepDO.getId_payitmpatoep())&& payItmDO.getId_pm().equals(blPayItmPatOepDO.getId_pm()) && FBoolean.TRUE.equals(payItmDO.getFg_realpay())) {
				TicketPay = TicketPay.add(payItmDO.getAmt().multiply(blPayItmPatOepDO.getEu_direct()));
			}
		}
		if (TicketPay.toDouble() < 0) {
			TicketPay = TicketPay.multiply(-1);
		}
		return TicketPay;
	}

	/**
	 * 发送消息
	 * 
	 * @param retfundInfo
	 * @param refundService
	 * @throws BizException
	 */
	private void SendMessage(RefundInfoDO retfundInfo, WsRefundService refundService) throws BizException {
		SendRefundMsgBP bp = new SendRefundMsgBP();
		bp.exec(retfundInfo, refundService);
	}

	/**
	 * 判断是否发消息
	 * 
	 * @param pmCode
	 * @return
	 */
	private boolean isInSend(String pmCode) {
		switch (pmCode) {
		case IBdPripmCodeConst.CODE_PRI_PM_WECHAT:
		case IBdPripmCodeConst.CODE_PRI_PM_ALIPAY:
		case IBdPripmCodeConst.CODE_PRI_PM_MISPOS:
			return true;

		default:
			return false;
		}
	}

	/**
	 * 获取支付方式
	 * 
	 * @param sd_paytp
	 *            支付窗口
	 * @param pm_code
	 *            支付编码
	 * @return
	 */
	private String GetItemPmType(String sd_paytp, String pm_code, String codeEnttp) {
		// 1 APP微信支付
		// 2 APP支付宝支付
		// 13 app住院支付宝支付
		// 10 自助机支付宝支付
		// 11 自助机微信支付
		// 12 自助机银行卡支付
		// 3 微信端微信支付
		// 4 支付窗支付宝支付
		// 7 桌健门诊交费
		// 8 卓健门诊支付
		String newpmCode = "";
		switch (sd_paytp) {
		// 自助机
		case IBlDictCodeConst.SD_PTTP_SELF_TERMINAL:
			// 微信
			if (IBdPripmCodeConst.CODE_PRI_PM_WECHAT.equals(pm_code)) {
				newpmCode = "11";
			}
			// 支付宝
			else if (IBdPripmCodeConst.CODE_PRI_PM_ALIPAY.equals(pm_code)) {
				newpmCode = "10";
			}
			// MISPOS
			else if (IBdPripmCodeConst.CODE_PRI_PM_MISPOS.equals(pm_code)) {
				newpmCode = "12";
			} else {
				newpmCode = pm_code;
			}
			break;
		// 微信平台
		case IBlDictCodeConst.SD_PTTP_WEIXIN:
			// 微信
			if (IBdPripmCodeConst.CODE_PRI_PM_WECHAT.equals(pm_code)) {
				newpmCode = "3";
			} else {
				newpmCode = pm_code;
			}
			break;
		// 手机APP
		case IBlDictCodeConst.SD_PTTP_PHONE_APP:
			// 微信
			if (IBdPripmCodeConst.CODE_PRI_PM_WECHAT.equals(pm_code)) {
				newpmCode = "1";
			}
			// 支付宝
			else if (IBdPripmCodeConst.CODE_PRI_PM_ALIPAY.equals(pm_code)) {
				if ("02".equals(codeEnttp))
					newpmCode = "13";
				else
					newpmCode = "2";
			} else {
				newpmCode = pm_code;
			}
			break;
		default:
			break;
		}
		return (newpmCode);
	}

	/**
	 * 通过结算编号 获取交费数据
	 * 
	 * @param id_stoep
	 *            结账编号
	 * @return
	 * @throws BizException
	 */
	private BlpaypatoepAggDO GetBlPayAggById_stoep(String id_stoep) throws BizException {
		IBlpaypatoepRService service = ServiceFinder.find(IBlpaypatoepRService.class);
		String sqlWhere = " ID_PAYPATOEP=(SELECT ID_PAYPATOEP FROM BL_ST_OEP WHERE id_stoep='" + id_stoep + "')";
		BlpaypatoepAggDO[] aggs = service.find(sqlWhere, "", FBoolean.FALSE);
		if (aggs != null && aggs.length == 1) {
			return aggs[0];
		}
		return null;
	}

	/**
	 * 通过结算编号 获取对应的数据
	 * 
	 * @param id_stoep
	 *            结账编号
	 * @return
	 * @throws BizException
	 */
	private BlpaypatoepAggDO GetOutBlPayAggById_stoep(String id_stoep, int euDirect) throws BizException {
		IBlpaypatoepRService service = ServiceFinder.find(IBlpaypatoepRService.class);
		String sqlWhere = " ID_PAYPATOEP=(SELECT ID_PAYPATOEP FROM BL_ST_OEP WHERE id_par='" + id_stoep + "' and EU_DIRECT="+euDirect+")";
		BlpaypatoepAggDO[] aggs = service.find(sqlWhere, "", FBoolean.FALSE);
		if (aggs != null && aggs.length == 1) {
			return aggs[0];
		}
		return null;
	}

	/**
	 * 
	 * 通过结算编号获取明细记账信息
	 * 
	 * @param id_stoep
	 *            结算编号
	 * @return
	 * @throws BizException
	 */
	private BlCgItmOepDO[] GetBlCgItmOepDOById_stoep(String id_stoep) throws BizException {
		IBlCgItmOepDORService service = ServiceFinder.find(IBlCgItmOepDORService.class);
		String sqlWhere = " id_stoep='" + id_stoep + "'";
		BlCgItmOepDO[] aggs = service.find(sqlWhere, "", FBoolean.FALSE);
		if (aggs != null && aggs.length == 1) {
			return aggs;
		}
		return null;
	}

	/**
	 * 获取就诊次数
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private int getTimesById_ent(String id_ent) throws BizException {
		IEnOutQryService service = ServiceFinder.find(IEnOutQryService.class);
		OpBasicDTO dto = service.getOpBasicInfo(id_ent);
		if (dto != null)
			return dto.getTimes_op();
		return 0;
	}

	/**
	 * 获得就诊数据
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO getEnEntById_ent(String id_ent) throws BizException {
		IPativisitRService service = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO dto = service.findById(id_ent);
		if (dto != null)
			return dto;
		return null;
	}

	/**
	 * 获取结算数据
	 * 
	 * @param id_stoep
	 * @return
	 * @throws BizException
	 */
	private BlStOepDO GetStOepById_stoep(String id_stoep) throws BizException {
		IBlstoepRService service = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO dto = service.findById(id_stoep);
		return dto;
	}

	/**
	 * 获取预约码
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private String GetAppCode(String id_ent) throws BizException {
		IScAptOutQryService service = ServiceFinder.find(IScAptOutQryService.class);
		AptExChlDO[] exChlDOs = service.getAptExChl(id_ent);
		if (!ArrayUtil.isEmpty(exChlDOs)) {
			return exChlDOs[0].getCode_apt();
		}
		return "";
	}
}
