package iih.ei.std.s.v1.bp.common;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.d.desc.PatiVisitDODesc;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;

public class EiCodeUtils {
	/**
	 * 生成就诊编号
	 * @return
	 * @throws BizException 
	 */
	public static String createEntCode() throws BizException{
		String entCode = createCode(PatiVisitDODesc.CLASS_FULLNAME);
		return entCode;
	}
	/**
	 * 生成编码
	 * @param doDescFullName 实体元数据类全名
	 * @return
	 * @throws BizException
	 */
	private static String createCode(String doDescFullName) throws BizException{
		IBillcodeManage  codeManage=ServiceFinder.find(IBillcodeManage.class);
		String code =codeManage.getBillCode_RequiresNew(doDescFullName,new PatiVisitDO());
		return code;
	}
	/**
	 * 服务编码转换
	 * @param srvType
	 * @return
	 */
	public static String srvTpTOHisSrvCode(String srvTp){
		if(StringUtils.isNullOrEmpty(srvTp))
			return null;
		switch (srvTp) {
		case IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_NORM:
			return "01";
		case IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_SPECIAL:
		case IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_EXP:
			return "02";
		}
		return null;
	}
	/**
	 * 服务编码转换
	 * @param srvType
	 * @return
	 */
	public static  String[] srvTypeTOIIHSrvTp(String srvType){
		if("01".equals(srvType)) //普通号
			return new String[]{IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_NORM};
		else if("02".equals(srvType)) //专家号
			return new String[]{IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_EXP, IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_SPECIAL};
		else return null;
	}
	/**
	 * 服务编码转换
	 * @param srvType
	 * @return
	 */
	public static String srvTpTOHisSrvName(String srvTp){
		if(StringUtils.isNullOrEmpty(srvTp))
			return null;
		switch (srvTp) {
		case IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_NORM:
			return "普通";
		case IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_SPECIAL:
		case IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_EXP:
			return "专家";
		}
		return null;
	}
	/**
	 * 午别编码转换
	 * @param srvType
	 * @return
	 */
	public static String dayslotTpTOHisCode(String dayslotTp){
		switch (dayslotTp) {
		case IBdResDictCodeConst.SD_DAYSLOT_MORNING:
			return "am";
		case IBdResDictCodeConst.SD_DAYSLOT_AFTERNOON:
			return "pm";
		}
		return null;
	}
	/**
	 * 午别编码转换
	 * @param srvType
	 * @return
	 */
	public static String hisCodeToDaysLotTp(String ampm){
		switch (ampm) {
		case "am":
			return IBdResDictCodeConst.SD_DAYSLOT_MORNING;
		case "pm":
			return IBdResDictCodeConst.SD_DAYSLOT_AFTERNOON;
		}
		return null;
	}
	
}
