package iih.bl.itf.std.bp.validator;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.itf.std.bean.constant.IBlWsConst;

/**
 * 入参校验器基类，提供通用数据校验
 * @author ly 2018/07/25
 *
 */
public class WsParamBaseValidator {

	private static String[] TMINAL_TYPE_RANGE;//终端类型值范围
	
	static{
		TMINAL_TYPE_RANGE = new String[] { IBlDictCodeConst.SD_PTTP_WINDOW, 
				IBlDictCodeConst.SD_PTTP_SELF_TERMINAL,
				IBlDictCodeConst.SD_PTTP_WEIXIN, 
				IBlDictCodeConst.SD_PTTP_PHONE_APP,IBlDictCodeConst.SD_PTTP_H5 };
	}
	
	/**
	 * 校验xml入参就诊类型
	 * @param value
	 * @return
	 */
	protected Boolean checkEntp(String value) {

		if(!IBlWsConst.ENTP_OP.equals(value) && !IBlWsConst.ENTP_IP.equals(value) && !IBlWsConst.ENTP_PE.equals(value)){
			return false;
		}
		return true;
	}

	/**
	 * 校验xml入参终端类型
	 * @param value
	 * @return
	 */
	protected Boolean checkTerminalType(String value) {
		
		for (String str : TMINAL_TYPE_RANGE) {
			if(str.equals(value)){
				return true;
			}
		}
		return false;
	}
}
