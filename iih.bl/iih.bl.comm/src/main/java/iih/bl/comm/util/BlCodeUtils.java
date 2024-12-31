package iih.bl.comm.util;

import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.desc.BlCgOepDODesc;
import iih.bl.comm.IBlConst;
import iih.bl.hp.hpentcode.d.desc.HpEntCodeDODesc;
import iih.bl.params.BlParams;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.desc.BlPrePayPatDODesc;
import iih.bl.st.blpaypatoep.d.desc.BlPayItmPatOepDODesc;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.d.desc.BlStIpDODesc;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.d.desc.BlStOepDODesc;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 编码帮助类
 * 
 * @author yankan
 * @since 2017-06-30
 *
 */
public class BlCodeUtils {
	
	/**
	 * 生成编码
	 * 
	 * @param doDescFullName 实体元数据类全名
	 * @param 
	 * @return
	 * @throws BizException
	 */
	private static String generateCode(String doDescFullName,BaseDO baseDO) throws BizException {
		IBillcodeManage codeManage = ServiceFinder.find(IBillcodeManage.class);
		String code = codeManage.getBillCode_RequiresNew(doDescFullName,baseDO);
		return code;
	}
	
	/**
	 * 生成前编码
	 * 
	 * @param doDescFullName 实体元数据类全名
	 * @param 
	 * @return
	 * @throws BizException
	 */
	private static String generatePreCode(String doDescFullName) throws BizException {
		IBillcodeManage codeManage = ServiceFinder.find(IBillcodeManage.class);
		String code = codeManage.getPreBillCode_RequiresNew(doDescFullName);
		return code;
	}
	
	/**
	 * 生成门急诊记账编号 
	 * 
	 * @return 编码
	 * @throws BizException
	 */
	public static String generateOepCgCode() throws BizException {
		String stCode = generateCode(BlCgOepDODesc.CLASS_FULLNAME,new BlCgOepDO());
		return stCode;
	}
	/**
	 * 生成门急诊结算编号 
	 * 编码规则：窗口号+生成编码
	 * 
	 * @return 编码
	 * @throws BizException
	 */
	public static String generateOepStCode() throws BizException {
		String stCode = generateCode(BlStOepDODesc.CLASS_FULLNAME,new BlStOepDO());
		String windowNo = StringUtil.isEmpty(Context.get().getClientHost())?"":BlParams.BLSTOEP0005();
		if (StringUtil.isEmpty(windowNo)) {
			windowNo = IBlConst.DEFAULT_WINDOWNO;//如果没有取到窗口好，默认99，代表其他或者无窗口号
		}
		stCode = windowNo + stCode;
		return stCode;
	}
	/**
	 * 生成住院结算编号 
	 * 编码规则：窗口号+生成编码
	 * 
	 * @return 编码
	 * @throws BizException
	 */
	public static String generateIpStCode() throws BizException {
		String stCode = generateCode(BlStIpDODesc.CLASS_FULLNAME,new BlStIpDO());
		String windowNo = BlParams.BLSTIP0003();
		if (StringUtil.isEmpty(windowNo)) {
			windowNo = IBlConst.DEFAULT_WINDOWNO;//如果没有取到窗口好，默认99，代表其他或者无窗口号
		}
		stCode = windowNo + stCode;
		return stCode;
	}
	
	/**
	 * 生成医保住院入参交易流水号
	 * @author liwq
	 */
	public static String generateHpRegisterCode() throws BizException {		
		String code = generatePreCode(HpEntCodeDODesc.CLASS_FULLNAME);
		return code;
	}
	
	/**
	 * 生成票据包编码
	 * @return
	 * @author houll
	 * @throws BizException
	 */
	public static String  getinccode(String doDescFullName,BaseDO baseDO) throws BizException
	{
		IBillcodeManage codeManage = ServiceFinder.find(IBillcodeManage.class);
		String code = codeManage.getBillCode_RequiresNew(doDescFullName,baseDO);
		return code;
	}
	
	/**
	 * 生成在线支付订单号
	 * 
	 * @return 编码
	 * @throws BizException
	 */
	public static String generateThirdOrdNo() throws BizException {
		String stCode = generatePreCode(BlPayItmPatOepDODesc.CLASS_FULLNAME);
		return stCode;
	}
	
	
	
	/**
	 * 查询udidoc数据
	 * @param id
	 * @return
	 * @throws BizException
	 */
	public static UdidocDO getUdiDocById(String id) throws BizException {
		IUdidocRService rService = ServiceFinder.find(IUdidocRService.class);
		return rService.findById(id);
	}
	
	/**
	 * 生成门诊预交金编号
	 * @throws BizException
	 * @author ly 2019/09/11
	 */
	public static String generateOpPrepayCode() throws BizException {
		String format = BlParams.BLINC0021();
		String code = generateCode(BlPrePayPatDODesc.CLASS_FULLNAME, new BlPrePayPatDO());
		return generatePrepayCode(format, code);
	}
	
	/**
	 * 生成住院预交金编号
	 * @throws BizException
	 * @author ly 2019/09/11
	 */
	public static String generateIpPrepayCode() throws BizException {
		String format = BlParams.BLINC0022();
		String code = generateCode(BlPrePayPatDODesc.CLASS_FULLNAME,new BlPrePayPatDO());
		return generatePrepayCode(format, code);
	}
	
	/**
	 * 组装预交金编号
	 * @param format
	 * @param serailNum
	 * @author ly 2019/09/11
	 */
	private static String generatePrepayCode(String format, String serailNum) throws BizException {
	
		if(StringUtil.isEmpty(format))
			return serailNum;
		String code = "";
		String[] formats = format.replace("{", "").split("}");
		for (String value : formats) {
			
			if(StringUtil.isEmpty(value))
				continue;
			
			if (value.startsWith("固定值")) {
				code += value.replace("固定值", "");
			} else if (value.equals("员工编号") && !StringUtil.isEmpty(Context.get().getStuffId())) {
				PsnDocDO psnDO = (PsnDocDO) new DAFacade().findByPK(PsnDocDO.class, Context.get().getStuffId(),
						new String[] { PsnDocDO.ID_PSNDOC, PsnDocDO.CODE });
				if (psnDO != null) {
					code += psnDO.getCode();
				}
			} else if (value.equals("系统编码")) {
				code += serailNum;
			}
		}
		if(StringUtil.isEmpty(code)){
			code = serailNum;
		}
		
		return code;
	}
}
