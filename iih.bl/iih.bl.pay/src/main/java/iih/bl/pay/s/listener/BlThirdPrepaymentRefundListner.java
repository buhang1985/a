package iih.bl.pay.s.listener;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.event.pub.IBlEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.comm.IBlMsgConst;
import iih.bl.comm.log.BLThirdItfLogger;
import iih.bl.comm.s.bp.BlThirdPayBP;
import iih.bl.comm.thirdpayapi.BlThirdPayValidateUtil;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.itf.custom.IBlThirdPaymentRefundService;
import iih.bl.itf.custom.thirdpay.d.BlThirdPayRefundDTO;
import iih.bl.itf.custom.thirdpay.d.BlThirdPayReturnDTO;
import iih.bl.itf.dto.thirdpayvalidate.d.BlThirdPayValidateRltDTO;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.i.IBlpaypatRService;
import iih.bl.pay.i.listener.IBlThirdPrepaymentRefundListner;
import iih.bl.st.blpaypatoep.d.BlPayItmPatOepDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.appfw.businessevent.IBusinessEvent;

/**
 * 
 * 第三方支付非窗口支付 预交金充值退费监听接口
 * 
 * 
 * @author ly 2019/04/12
 *
 */
public class BlThirdPrepaymentRefundListner implements IBlThirdPrepaymentRefundListner {

	@Override
	public void doAction(IBusinessEvent event) throws BizException {

		// 验证事件
		this.validate(event);
		// 退预交金
		this.RefundPrePat(event);

	}

	/**
	 * 退预交金
	 * 
	 * @param event
	 * @throws BizException
	 */
	private void RefundPrePat(IBusinessEvent event) throws BizException {
		BusinessUserObj bizUserObj = (BusinessUserObj) event.getUserObject();
		BlPrePayPatDO blPrePatPatDo = (BlPrePayPatDO) bizUserObj.getUserObj();
		// 根据id_par 查询原预交金记录
		BlPrePayPatDO oldPrePayDo = this.getOldPrePayDo(blPrePatPatDo.getId_par());
		if (oldPrePayDo == null) {
			return;
		}
		boolean thirdFefund = BlThirdPayBP.isThirdFefund(blPrePatPatDo.getId_pm());
		//添加手工转账的不处理
		if (!thirdFefund||FBoolean.TRUE.equals(blPrePatPatDo.getFg_refund_manual())) {
			// 校验不通过 不符合第三方注册节点维护 不处理
			return;
		}
		// 如果是在收费窗口 收费的预交金 返回处理
		if (IBlDictCodeConst.SD_PTTP_WINDOW.equals(oldPrePayDo.getSd_pttp()) || 
				IBlDictCodeConst.SD_PTTP_BEDSIDE.equals(oldPrePayDo.getSd_pttp())) {
			return;
		}
		
		if (!IBlDictCodeConst.SD_PTTP_WINDOW.equals(blPrePatPatDo.getSd_pttp()) &&
				!IBlDictCodeConst.SD_PTTP_BEDSIDE.equals(blPrePatPatDo.getSd_pttp())) {
			return;
		}
		
		String sd_bizscene = null;
		// 如果是门诊类型 为门诊预交金
		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(blPrePatPatDo.getCode_enttp())) {
			sd_bizscene = IBlDictCodeConst.SD_BIZSCENE_OEP_PRE;
			// 如果是住院类型为住院预交金
		} else if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(blPrePatPatDo.getCode_enttp())) {
			sd_bizscene = IBlDictCodeConst.SD_BIZSCENE_IP_REFUND;
		}
		List<String> listPm = new ArrayList<String>();
		listPm.add(blPrePatPatDo.getId_pm());
		BlThirdPayValidateRltDTO Validatedto = BlThirdPayValidateUtil.validate(listPm.toArray(new String[0]),
				sd_bizscene);
		if (FBoolean.TRUE.equals(Validatedto.getFg_success()) && !StringUtils.isEmpty(Validatedto.getId_pm())) {
			// 组装退费数据
			BlThirdPayRefundDTO dto = new BlThirdPayRefundDTO();
			    //患者编码
			    dto.setPatcode(blPrePatPatDo.getPatcode());
				// 就诊类型
				dto.setCode_enttp(blPrePatPatDo.getCode_enttp());
				// 商户订单号
				dto.setTradeno(oldPrePayDo.getPaymodenode() == null ? "" : oldPrePayDo.getPaymodenode());
				// 交易号
				dto.setBankno(oldPrePayDo.getBankno() == null ? "" : oldPrePayDo.getBankno());
				// 新退款流水号
				dto.setRefundtradeno(BlCodeUtils.generateThirdOrdNo());
				// 退款金额
				dto.setRefundfee(blPrePatPatDo.getAmt().toString());
				// 终端类型
				dto.setSdpttp(oldPrePayDo.getSd_pttp());
				// 订单总金额
				dto.setTotalfee(oldPrePayDo.getAmt().toString());
				// 支付场景类型
				dto.setSd_bizscene(sd_bizscene);
			    //付款方式
				dto.setSd_pm(blPrePatPatDo.getSd_pm());
				//退费人员
				dto.setId_emp(blPrePatPatDo.getId_emp_pay());
				//本机识别码
				dto.setPcid(Context.get().getClientHost());
				// 调用客开接口
				IBlThirdPaymentRefundService service = ServiceFinder.find(IBlThirdPaymentRefundService.class);
				if (service == null) {
					throw new BizException("第三方退费客开接口未注册");
				}
				try {
					BLThirdItfLogger.info("调用第三方退费客开接口入参" + dto.serializeJson());
					BlThirdPayReturnDTO blThirdPayReturnDTO = service.refund(dto);
					BLThirdItfLogger.info("调用第三方退费客开接口出参" + blThirdPayReturnDTO.serializeJson());
					//添加返回值更新 收付款明细 do
					UpdateRefundInfo(blThirdPayReturnDTO,blPrePatPatDo);
				} catch (BizException e) {
					// 写日志
					BLThirdItfLogger.error(e.getMessage());
					e.printStackTrace();
				}
			}

		

	}
	/**
	 * 回写收付款明细
	 * 
	 * @param blThirdPayReturnDTO
	 * @param payItmPatOepDO
	 * @throws BizException
	 */
	private void UpdateRefundInfo(BlThirdPayReturnDTO blThirdPayReturnDTO, BlPrePayPatDO blPrePatPatDo)
			throws BizException {
		// 添加返回值更新 收付款明细 do
		if (blThirdPayReturnDTO != null && StringUtils.isNotEmpty(blThirdPayReturnDTO.getBankno())
				&& StringUtils.isNotEmpty(blThirdPayReturnDTO.getPaymodenode())
				&& StringUtils.isNotEmpty(blPrePatPatDo.getId_paypat())) {
			StringBuilder sql = new StringBuilder();
			sql.append(" update bl_prepay_pat  ");
			sql.append(" set bankno ='" + blThirdPayReturnDTO.getBankno() + "' ,");
			sql.append("  paymodenode ='" + blThirdPayReturnDTO.getPaymodenode() + "'");
			sql.append("  where bl_prepay_pat.id_paypat='" + blPrePatPatDo.getId_paypat() + "'");
			new DAFacade().execUpdate(sql.toString());
		}
	}

	/**
	 * 查询原预交金数据
	 * 
	 * @param id_par
	 * @return
	 * @throws BizException
	 */
	private BlPrePayPatDO getOldPrePayDo(String id_par) throws BizException {

		IBlpaypatRService serivce = ServiceFinder.find(IBlpaypatRService.class);
		if (!StringUtil.isEmpty(id_par)) {
			return serivce.findById(id_par);
		}
		return null;
	}

	/**
	 * 验证事件
	 * 
	 * @param event
	 */
	private void validate(IBusinessEvent event) throws BizException {
		if (!IBlEventConst.EVENT_SOURCE_PREPAY.equalsIgnoreCase(event.getSourceID())
				|| !IBlEventConst.EVENT_TYPE_PREPAY_REFUND.equals(event.getEventType())) {
			throw new BizException(IBlMsgConst.ERROR_LISTENER_NOT_MATCH_EVENT);
		}
	}
}
