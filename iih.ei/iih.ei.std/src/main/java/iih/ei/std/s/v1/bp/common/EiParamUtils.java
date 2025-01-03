package iih.ei.std.s.v1.bp.common;


import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sie.common.utils.StringUtils;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class EiParamUtils {

	//退几天过期号权限
	public static final String RETURN_NUMBER_DAY_POWER = "ENAU00061";
	//退过期号权限标识
	private static final String KEY_EN_DRAWBACK_EXPRIRED = "ENAU0006";
    //在门诊预约中直接使用的患者分类
    private static final String KEY_SC_PATCA_APTSELFPAY = "SC0021";
	// 预约需要确认
	private static final String KEY_APT_NEEDCFM = "SC0020";
    //可提前接诊时间
    private static final String KEY_EN_OP_ADVANCEACPTTIME = "ENOP0240";
    // 住院天数的计算方式  0-记出不计入计算方式（11234） 1-临床计算方式（12345）
 	private static final String KEY_CALCULATE_HOSDAYS_TYPE = "ENIP0210"; 
    //顺序接诊就诊优先级限制
    private static final String KEY_EN_PVORDERACPT_LEVEL = "ENOP0023";
    //医院预交金收费流程模式
    private static final String KEY_BLCG_0002 = "BLCG0002";
    //检验第三方系统扣费闭环状态
    private static final String KEY_SDLL_MPNR_0001 = "SDLLMPNR0001";
    //检查第三方系统扣费闭环
    private static final String KEY_MPNR_0130 = "MPNR0130";
    //检验第三方系统扣费闭环状态
    private static final String KEY_MPNR_0131 = "MPNR0131";
    //输液标签 药品条数显示参数
    private static final String KEY_MPNR_0002 = "MPNR0002";
    //是否走第三方改状态接口退费
    private static final String KEY_MPNR_0146 = "MPNR0146";
    //预交金不足是否允许摆药
    private static final String KEY_MPDGIP_0005 = "MPDGIP0005";
    // GCP系统接诊挂号的排班服务id
 	private static final String SC_APR_NOSCH_SCSRV = "SC0112" ;//GCP系统接诊挂号的排班服务id
 	// 门诊挂号有效期标识
 	private static final String KEY_OP_VALID_PERIOD = "ENOP0001";
 	private static final Integer DEFAULT_OP_VALID_HOURS = 24;// 门诊默认有效期
 	
    /**
     * 如果为true，可退过期的号，默认只可退未过期的号
     * 
     * @param psnId
     * @return
     */
    public static boolean isDrawbackExprired(String psnId){
    	String hasAuth = getPcParamValue(psnId, KEY_EN_DRAWBACK_EXPRIRED);
		return Boolean.parseBoolean(hasAuth);
    }
  
    /***
     * @Description:退几天过期号权限
     * @param psnId
     * @return
     */
    public static int getRtuenNumberDay(String psnId) {
    	String hasAuth = getPcParamValue(psnId, RETURN_NUMBER_DAY_POWER);
		return Integer.parseInt(hasAuth);
    }
 	/**
     * 获取在门诊预约中直接使用的患者分类
     * 
     * @return
     */
    public static String getAptSelfPayPatCaIds(){
    	return getOrgParamValue(EiContextUtils.getOrgId(), KEY_SC_PATCA_APTSELFPAY);
    }
    
    /**
	 * 住院天数的计算方式
	 * 0-记出不计入计算方式（11234） 1-临床计算方式（12345）
	 * @return
	 */
	public static Integer GetCalculateHosDaysType(){
		String param = getOrgParamValue(EiContextUtils.getOrgId(), KEY_CALCULATE_HOSDAYS_TYPE);
		if(!StringUtils.isEmpty(param))
			return Integer.parseInt(param);
		return null;
	}
	/**
	 * 获取预约是否确认
	 * 
	 * @return
	 */
	public static Boolean getAptNeedCfm() {
		String paramValue = getOrgParamValue(EiContextUtils.getOrgId(),KEY_APT_NEEDCFM);
		return Boolean.parseBoolean(paramValue);
	}
    /**
     * 获取可提前接诊时间
     * 
     * @return
     */
    public static int getAdvanceAcptTime(){
    	String paramValue = getOrgParamValue(EiContextUtils.getOrgId(), KEY_EN_OP_ADVANCEACPTTIME);
		if (!StringUtil.isEmptyWithTrim(paramValue)) {
			return Integer.parseInt(paramValue);
		}
		return 0; 
    }
    
    /**
     * 医院预交金收费流程模式
     * @return
     */
    public static String BLCG0002() {
    	return getOrgParamValue(EiContextUtils.getOrgId(), KEY_BLCG_0002);

    }
    
    /**
     * 检验第三方系统扣费闭环状态
     * @return
     */
    public static String SDLLMPNR0001() {
		return getOrgParamValue(EiContextUtils.getOrgId(), KEY_SDLL_MPNR_0001);
	}
    
    /**
     * 检查第三方系统扣费闭环
     * @return
     */
    public static String MPNR0130() {
    	return getOrgParamValue(EiContextUtils.getOrgId(), KEY_MPNR_0130);
	}
    
    /**
     * 检验第三方系统扣费闭环状态
     * @return
     */
    public static String MPNR0131() {
    	return getOrgParamValue(EiContextUtils.getOrgId(), KEY_MPNR_0131);
    }
    
    /**
	 * 输液标签 药品条数显示参数
	 * 
	 * @return
	 */
	public static FBoolean MPNR0002() {
		String paramValue = getOrgParamValue(EiContextUtils.getOrgId(),KEY_MPNR_0002);
		return new FBoolean(paramValue);
	}
	
	/**
	 * 是否走第三方改状态接口退费
	 * 
	 * @return
	 */
	public static FBoolean MPNR0146() {
		String paramValue = getOrgParamValue(EiContextUtils.getOrgId(),KEY_MPNR_0146);
		return new FBoolean(paramValue);
	}
	
	/**
	 * 预交金不足是否允许摆药
	 * 
	 * @return
	 */
	public static FBoolean MPDGIP0005() {
		String paramValue = getOrgParamValue(EiContextUtils.getOrgId(),KEY_MPDGIP_0005);
		return new FBoolean(paramValue);
	}
	
    /**
	 * GCP系统接诊挂号的排班服务id
	 * 
	 * @return
	 */
	public static String geNoSchScSrv() {
		return getOrgParamValue(EiContextUtils.getOrgId(),SC_APR_NOSCH_SCSRV);
	}
	
	/**
	 * 获取门诊挂号有效期 默认为24小时
	 * 
	 * @return
	 * @throws BizException 
	 */
	public static int getOpValidHours(String id_dep) throws BizException {
		try{
			Integer param = ParamsetQryUtil.getParaIntByComplex(new String[]{id_dep,EiContextUtils.getOrgId()},null,KEY_OP_VALID_PERIOD);
			if(param == null){
				return DEFAULT_OP_VALID_HOURS;
			}
			return param;
		}catch(BizException e){
			return DEFAULT_OP_VALID_HOURS;
		}
	}
    // ///////////////////////////////////////////////////////////////////////////////
    /**
	 * 获取PC参数
	 * 
	 * @param pcId PC的KEY
	 * @param paramCode 参数编码
	 * @return
	 */
	private static String getPcParamValue(String pcId, String paramCode) {
		try {
			return ParamsetQryUtil.getParaStringByInstance(pcId, paramCode);
		} catch (BizException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
     * 顺序接诊就诊优先级限制(默认100)
     * 
     * @return
     */
    public static final int getPvOrderAcptLevel(){
    	String val = "";
		try {
			val = ParamsetQryUtil.getParaString(Context.get().getOrgId(), KEY_EN_PVORDERACPT_LEVEL);
		} catch (BizException e) {
			e.printStackTrace();
		}
		if (!StringUtil.isEmptyWithTrim(val)) {
			return Integer.parseInt(val);
		}
		return 100; 
    }
	/**
	 * 获取部门参数
	 * 
	 * @param depId 部门id
	 * @param paramCode 参数编码
	 * @return
	 */
	@SuppressWarnings("unused")
	private static String getDepParamValue(String depId, String paramCode) {
		return getParamValue(depId, paramCode);
	}

	/**
	 * 获取组织参数
	 * 
	 * @param orgId 组织id
	 * @param paramCode 参数编码
	 * @return
	 */
	private static String getOrgParamValue(String orgId, String paramCode) {
		return getParamValue(orgId, paramCode);
	}
	/**
	 * 获取参数
	 * 
	 * @param dataId
	 * @param paramCode
	 * @return
	 */
	private static String getParamValue(String dataId, String paramCode) {
		// 框架提供的方法
		String val = "";
		try {
			val = ParamsetQryUtil.getParaString(dataId, paramCode);
		} catch (BizException e) {
			e.printStackTrace();
		}
		return val;
	}
}
