package iih.bl.hp.s.bp;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.hp.insurecard.d.CardPersonInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;

/**
 * 判断医保是否属于基金支付
 * @author ly 2018/01/24
 *
 */
public class HpJudgeIfFundpayBP {

	/**
	 * 判断医保是否属于基金支付
	 * @param dto
	 * @param codeEntp
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(CardPersonInfoDTO dto,String codeEntp) throws BizException{
		
		if(dto == null || StringUtil.isEmpty(codeEntp)){
			throw new ArgumentNullException("判断医保是否属于基金支付","医保数据或就诊类型");
		}
		
		//判断患者是否在院，在院无法进行门诊结算
		if("1".equals(dto.getHospflag())){
			return FBoolean.FALSE;
		}
		
		if(IBdFcDictCodeConst.ID_CODE_ENTP_OP.equals(codeEntp)){
			
			//判断是否在红名单
			if("false".equalsIgnoreCase(dto.getIsinredlist())){
				return FBoolean.FALSE;
			}
			
			//判断是否定点医院
			if(!"1".equals(dto.getIsspecifiedhosp())){
				return FBoolean.FALSE;
			}
		}
		
		return FBoolean.TRUE;
	}
}
