package iih.bd.base.util;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;

/**
 * @Description:就诊类型工具类
 * @author: xu_xing@founder.com.cn
 * @version：2019年10月21日 下午5:19:38 创建
 */
public class EntpUtils {
	
	/**
	 * 获取门诊流程对应的就诊类型
	 * @return '00','0101','0102'
	 */
	public static String getOpEntpSqlStrs() {
		String rtn = "";
		for (String code_entp : getOpEntps()) {
			rtn += (rtn.length() == 0 ? "" : ",") + ("'" + code_entp + "'");
		}
		return rtn;
	}

	/**
	 * 获取门诊流程对应的就诊类型
	 * @return
	 */
	public static List<String> getOpEntps() {
		List<String> reList = new ArrayList<String>();
		reList.add(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		reList.add(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FLOW);
		reList.add(IBdFcDictCodeConst.SD_CODE_ENTP_ET_FSTAID);
		return reList;
	}

	/**
	 * 获取住院流程对应的就诊类型
	 * @return '10','0103'
	 */
	public static String getIpEntpSqlStrs() {
		String rtn = "";
		for (String code_entp : getIpEntps()) {
			rtn += (rtn.length() == 0 ? "" : ",") + ("'" + code_entp + "'");
		}
		return rtn;
	}

	/**
	 * 获取住院流程对应的就诊类型
	 * @return
	 */
	public static List<String> getIpEntps() {
		List<String> reList = new ArrayList<String>();
		reList.add(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		reList.add(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS);
		reList.add(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE);
		return reList;
	}
}
