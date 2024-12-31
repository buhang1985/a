package iih.bd.bc.udi.pub;

/**
 * 医疗执行管理模块(IIH.MP)相关的基础数据常量定义。
 */
public interface IMpDictCodeTypeConst {
	/*
	 * 例：如下 public static final String SD_REACTCA = "0001ZZ2000000000001B";
	 * //0515 互斥类型
	 */
	public static final String SD_MPDGTP = "0001ZZ2000000000006G";// 0505

	//public static final String SD_MRTPLVT = "0001AA10000000054CLA";// 体温单测量模板
	public static final String SD_FREQ_AWAYS = "always";// Always频率
	public static final String SD_ENTP_OUTPATIENT = "00";// 门诊就诊类型code
	///public static final String ID_MRTPLVT_OUTPATIENT = "0001AA10000000073576";// 门诊预检体征模板ID
	public static final String SD_SRVTP_CODE = "BD.SRV.0505";// 医疗服务类型编码
	/**
	 * MP域接口常量
	 */
	public static final String SD_ORPLTPSTA_CHECK = "16";// 检查类服务，到检闭环类型状态 编码

	/**
	 * 回写医嘱执行状态
	 */
	//public static final String ID_SUMP_EXECUTED = "0001AA1000000004KRCB";// 已执行
	public static final String SD_SUMP_EXECUTED = "1";// 已执行

	/**
	 * 生命体征模板code
	 */
	public static final String SD_TEMPERATURE_SRVVT = "SMTZ0001";// 体温
	public static final String SD_PLUS_SRVVT = "SMTZ0002";// 脉搏
	public static final String SD_HEART_SRVVT = "SMTZ0003";// 心率
	public static final String SD_BREATH_SRVVT = "SMTZ0004";// 呼吸
	public static final String SD_PRESSURE_SRVVT = "SMTZ0005";// 血压
	public static final String SD_WEIGTH_SRVVT = "SMTZ0006";// 体重

	/**
     * 
     */
	//public static final String ID_SAMPTP_BLOOD = "0001AA1000000003W7UL";// 血液
	public static final String SD_SRVTP_PREBLOOD = "140101";//服务类型备血
	public static final String SD_PREBLOOD_PRINT = "34";//备血闭环打印环节
    public static final String SD_TEST_PRINT = "22";//检验闭环打印环节
    public static final String SD_PREBLOOD_COLLECT = "35";//备血闭环采集环节
    public static final String SD_TEST_COLLECT = "23";//检验闭环采集环节
    public static final String SD_PREBLOOD_INSPECION="36";//备血闭环送检环节
    public static final String SD_TEST_INSPECION = "24";//检验闭环送检环节
    
    /*
     * 记录医嘱执行闭环状态
     */
    public static final String SD_FETCHBLOOD_ORPLTPSTA="29";//取血   
    public static final String SD_TRANSFUSION_B_ORPLTPSTA="30" ;//开始输血
    public static final String SD_TRANSFUSION_E_ORPLTPSTA="31" ;//完成输血
	
    /**
     * 刷单校验类型
     */
    public static final String SD_BRUSHCHECKTYPE = "MP.DG.0525" ;
    /**
     * 药单使用场景
     */
    public static final String SD_DRUGUSESCENE = "MP.DG.0530" ;
    /**
     * 药单异常控制结果
     */
    public static final String SD_DRUGEXCCTRLRESU = "MP.DG.0535" ;
    /**
     * 首日摆药状态
     */
    public static final String SD_FIRSTDAYDRUGSTATE = "MP.DG.0540" ;

    
}
