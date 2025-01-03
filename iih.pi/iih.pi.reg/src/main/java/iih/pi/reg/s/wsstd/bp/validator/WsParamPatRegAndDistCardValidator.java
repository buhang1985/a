package iih.pi.reg.s.wsstd.bp.validator;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.common.idcheck.IDChecker;
import iih.pi.reg.wsstd.bean.input.patreg.WsParamPatRegAndDistCard;
import iih.pi.reg.wsstd.bean.input.patreg.sub.WsParamPatRegAndDistCardInfo;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 患者注册发卡或患者注册入参校验
 * 
 * @author shaokx
 *
 */
public class WsParamPatRegAndDistCardValidator {

	private static String[] TMINAL_TYPE_RANGE;// 终端类型值范围
	private static String[] CODE_ID_TYPE;// 证件号类型范围

	static {
		TMINAL_TYPE_RANGE = new String[] { IBlDictCodeConst.SD_PTTP_WINDOW, IBlDictCodeConst.SD_PTTP_SELF_TERMINAL,
				IBlDictCodeConst.SD_PTTP_WEIXIN, IBlDictCodeConst.SD_PTTP_PHONE_APP };
		CODE_ID_TYPE = new String[] { IPiDictCodeConst.SD_IDTP_IDENTITY, IPiDictCodeConst.SD_IDTP_JMHKB,
				IPiDictCodeConst.SD_IDTP_HZ, IPiDictCodeConst.SD_IDTP_JGZ, IPiDictCodeConst.SD_IDTP_JSZ,
				IPiDictCodeConst.SD_IDTP_GAJMZ, IPiDictCodeConst.SD_IDTP_TWJMZ, IPiDictCodeConst.SD_IDTP_QTFDZ };
	}

	/**
	 * 校验
	 * 
	 * @param param
	 * @throws BizException
	 */
	public void validate(WsParamPatRegAndDistCard param) throws BizException {

		WsParamPatRegAndDistCardInfo paramInfo = param.get_patRegAndDistrInfo();
		//如果是绑卡
		if ("02".equals(paramInfo.getDoType())) {
			if ((StringUtils.isEmpty(paramInfo.getBankCode()) && StringUtils.isEmpty(paramInfo.getHpCode())
					&& StringUtils.isEmpty(paramInfo.getCardCode()))) {
				throw new BizException("患者银行卡或者医保卡或者就诊卡不能为空");
			}
			if (StringUtils.isEmpty(paramInfo.getPatCode())) {
				throw new BizException("患者编码不能为空");
			}
		} else {
			
			if (StringUtils.isEmpty(paramInfo.getDoType())) {
				throw new BizException("患者操作动作不允许为空");
			}

			if (!"01".equals(paramInfo.getDoType()) && !"04".equals(paramInfo.getDoType()) && !"05".equals(paramInfo.getDoType()) && !"06".equals(paramInfo.getDoType())) {
				throw new BizException("患者操作动作值不正确");
			}

			if("01".equals(paramInfo.getDoType())){
				
				if(StringUtil.isEmpty(paramInfo.getCardCode())){
					throw new BizException("建档发卡动作时卡号为空");
				}
			}

			if(!"05".equals(paramInfo.getDoType()) && !"06".equals(paramInfo.getDoType())){
				
                if(!StringUtil.isEmpty(paramInfo.getSdType())){
					
					// 校验证件类型是否正确
                    if(!this.checkIdType(paramInfo.getSdType())){
                    	throw new BizException("患者证件类型值不正确");
                    }
                    
                    if("01".equals(paramInfo.getSdType())){
                    	if (StringUtils.isEmpty(paramInfo.getSdCode())) {
        					throw new BizException("患者身份证号不允许为空。");
        				}

        				// 校验身份证号是否正确
        				if (!IDChecker.checkIDCard(paramInfo.getSdCode())) {
        					throw new BizException("身份证号值不正确");
        				}
                    }else{
                    	if (StringUtils.isEmpty(paramInfo.getSdCode())) {
        					throw new BizException("患者证件号不允许为空。");
        				}
                    }
                }else{
                	if (StringUtils.isEmpty(paramInfo.getSdCode())) {
    					throw new BizException("患者身份证号不允许为空。");
    				}

    				// 校验身份证号是否正确
    				if (!IDChecker.checkIDCard(paramInfo.getSdCode())) {
    					throw new BizException("身份证号值不正确");
    				}
                }
			}else{
				if(!StringUtil.isEmpty(paramInfo.getSdCode())){
					// 校验身份证号是否正确
					if (!IDChecker.checkIDCard(paramInfo.getSdCode())) {
						throw new BizException("身份证号值不正确");
					}
				}
			}
			
			if (StringUtils.isEmpty(paramInfo.getPatName())) {
				throw new BizException("患者姓名不允许为空。");
			}
		
			if (StringUtils.isEmpty(paramInfo.getPhoneCode())) {
				throw new BizException("患者手机号不允许为空。");
			}

			if (StringUtils.isEmpty(paramInfo.getPatSex())) {
				throw new BizException("患者性别不允许为空");
			}

			if (StringUtils.isEmpty(paramInfo.getPatBorthday())) {
				throw new BizException("患者出生日期不允许为空");
			}

			if (StringUtils.isEmpty(paramInfo.getOperaCode())) {
				throw new BizException("患者操作员编码不允许为空");
			}

		}
		// if("01".equals(paramInfo.getDoType())){
		// if (StringUtils.isEmpty(paramInfo.getCardCode())) {
		// throw new BizException("患者就诊卡号不允许为空");
		// }
		//
		// if (StringUtils.isEmpty(paramInfo.getDocumentNumber())) {
		// throw new BizException("患者交易流水号不允许为空");
		// }
		//
		// if (StringUtils.isEmpty(paramInfo.getPaymentMethod())) {
		// throw new BizException("患者支付方式不允许为空");
		// }
		//
		// if (StringUtils.isEmpty(paramInfo.getPayMoney())) {
		// throw new BizException("患者支付金额不允许为空");
		// }
		//
		// if (StringUtils.isEmpty(paramInfo.getOrderNumber())) {
		// throw new BizException("患者订单流水号不允许为空");
		// }
		//
		// if (StringUtils.isEmpty(paramInfo.getTerminalType())) {
		// throw new BizException("患者终端类型不允许为空");
		// }
		//
		// if(!this.checkTerminalType(paramInfo.getTerminalType())){
		// throw new BizException("患者入参终端类型值不正确");
		// }
		// }

	}

	/**
	 * 校验xml入参终端类型
	 * 
	 * @param value
	 * @return
	 */
	protected Boolean checkTerminalType(String value) {

		for (String str : TMINAL_TYPE_RANGE) {
			if (str.equals(value)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 校验xml入参证件类型
	 * 
	 * @param value
	 * @return
	 */
	public static Boolean checkIdType(String value) {

		for (String str : CODE_ID_TYPE) {
			if (str.equals(value)) {
				return true;
			}
		}
		return false;
	}
}
