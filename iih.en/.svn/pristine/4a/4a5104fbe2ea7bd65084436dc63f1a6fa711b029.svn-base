package iih.en.comm.util;


import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ci.mr.ciamr.d.desc.AMrDODesc;
import iih.en.comm.validator.EnValidator;
import iih.en.er.pre.d.desc.EnErPreDODesc;
import iih.en.pv.inpatient.d.desc.EnPeCmpyDODesc;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.d.desc.PatiVisitDODesc;
import iih.pi.reg.pat.d.desc.PatDODesc;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
/**
 * 编码生成帮助类
 * @author yank
 *
 */
public class EnCodeUtils {
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
	 * 生成患者编号
	 * @return
	 * @throws BizException
	 */
	public static String createPatCode() throws BizException{
		String entCode = createCode(PatDODesc.CLASS_FULLNAME);
		return entCode;
	}

	/**
     * 生成团检记录编号
     * @return
     * @throws BizException
     */
    public static String EnPeCmpyItmDOCode() throws BizException{
        String entCode = createCode(EnPeCmpyDODesc.CLASS_FULLNAME);
        return entCode;
    }
	
    /**
	 * 生成门诊病案编号
	 * @return
	 * @throws BizException 
	 */
	public static String createOpAmrCode() throws BizException{
		String amrCode = createCode(PatDODesc.CLASS_FULLNAME);
		return amrCode;
	}
	/**
	 * 生成住院病案编号
	 * @return
	 * @throws BizException 
	 */
	public static String createIpAmrCode() throws BizException{
		String entCode = createCode(AMrDODesc.CLASS_FULLNAME);
		return entCode;
	}
	
	/**
	 * 生成特定类型住院病案编号
	 * @param fullName
	 * @return
	 * @throws BizException
	 */
	public static String createIpSpecTypeAmrCode(String fullName) throws BizException{
		String entCode = createCode(fullName);
		return entCode;
	}
	
	/**
	 * 生成急诊预检编码
	 * 
	 * @return
	 * @throws BizException
	 */
	public static String createErPreCode() throws BizException{
		return createCode(EnErPreDODesc.CLASS_FULLNAME);
	}
	
	/**
	}/**
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
	 * 回滾生成的住院號
	 * @param doDescFullName
	 * @param codeAmrIp
	 * @throws BizException
	 */
	public static void rollBackCodeAmrIp(String codeAmrIp) throws BizException{
		IBillcodeManage  codeManage=ServiceFinder.find(IBillcodeManage.class);
		codeManage.returnBillCodeOnDelete(AMrDODesc.CLASS_FULLNAME, codeAmrIp, null);
	} 
	
	/**
	 * 回滚生成的住院号特定类型
	 * @param doDescFullName
	 * @param codeAmrIp
	 * @throws BizException
	 */
	public static void rollBackCodeAmrIpSpecType(String fullName, String codeAmrIp) throws BizException{
		IBillcodeManage  codeManage=ServiceFinder.find(IBillcodeManage.class);
		codeManage.returnBillCodeOnDelete(fullName, codeAmrIp, null);
	} 
	
	/**
	 * 创建表Id
	 * 
	 * @param Size
	 * @return
	 */
	public static String[] createPrimaryKeys(int size){
		DBUtil util = new DBUtil();
		return util.getOIDs(size);
	}
	/**
	 * 微信后台获取各渠道预约明细(患者预约明细)-入参编码转换
	 * @param chlType
	 * @return
	 */
	public static String chlStatusTOHisStatus(String chlType){
		if(IScDictCodeConst.SD_SCCHLTP_PATIENT_MOBILE.equals(chlType)){
			return "1X"; //手机APP
		}else if(IScDictCodeConst.SD_SCCHLTP_PATIENT_WEIXIN.equals(chlType)){
			return "00"; //微信
		}else if(IScDictCodeConst.SD_SCCHLTP_PATIENT_ZHIFUBAO.equals(chlType)){
			return "00"; //支付窗（支付宝）
		}else if(IScDictCodeConst.SD_SCCHLTP_PATIENT_WEB.equals(chlType)){
			return "1X"; //官网
		}else{
			return null;
		}
	}
	
	/**
	 * 服务编码转换
	 * @param srvType
	 * @return
	 */
	public static String[] srvTypeTOIIHSrvTp(String srvType){
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
	public static String srvTpTOHisSrvCode(String srvTp){
		if(EnValidator.isEmpty(srvTp))
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
	public static String srvTpTOHisSrvName(String srvTp){
		if(EnValidator.isEmpty(srvTp))
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
