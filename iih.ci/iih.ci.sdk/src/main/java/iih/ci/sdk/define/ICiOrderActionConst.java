package iih.ci.sdk.define;

public class ICiOrderActionConst {
	/**
	 * 医嘱操作提示信息，提示后终止操作
	 */
    public static final String ShowInfor_Message = "ShowInforMessage";
    /**
     * 医嘱操作提示信息，提示后继续操作
     */
    public static final String ShowWarning_Message = "ShowWarningMessage";
    /**
     * 医嘱操作提示确认信息
     */
    public static final String ShowConfirm_Message = "ShowConfirm_Message";
	
	/**
	 * 是否循环标识
	 */
	public static final String IsRecurs = "IsRecurs";
	
	/**
	 * 医嘱签署判断医保
	 */
	public static final String IDors4OrderHpInfo = "IDors4OrderHpInfo";
    public static final String OrderHpInfo_Checked = "OrderHpInfo_Checked";
	
    /**
     * 医嘱签署临床路径
     */
    public static final String IDors4HpOrClinpath = "IDors4HpOrClinpath";
    public static final String HpOrClinpath_Checked = "HpOrClinpath_Checked";
    /**
     * 医嘱签署特殊药判断
     */
    public static final String SpecilDrugs4Sign = "SpecilDrugs4Sign";
    public static final String SpecilDrugs_Checked = "SpecilDrugs_Checked";
    /**
     * 医嘱签署毒麻药
     */
    public static final String PoisInfoCheck4Sign = "PoisInfoCheck4Sign";
    public static final String PoisInfo_Checked = "PoisInfo_Checked";
    
    /**
     * 医嘱签署特殊使用级抗菌药参数
     */
    public static final String SpecilAntiDrugs4Sign = "SpecilAntiDrugs4Sign";
    
    /**
     * 医嘱删除作废微生物送检判断
     */
    public static final String BiologyTest4DelCanc = "BiologyTest4DelCanc";
    public static final String BiologyTest_Checked = "BiologyTest_Checked";
    
    /**
     * 医嘱停止时间
     */
    public static final String OrderStopTime = "OrderStopTime";

    /**
     * 皮试校验
     */
    public static final String SkinTest_Checked = "SkinTest_Checked";
    public static final String SkinTestNoRstTip4Sign = "SkinTestNoRstTip4Sign";
    public static final String SkinTestOrderRstNotReturn4Sign = "SkinTestOrderRstNotReturn4Sign";
    public static final String SkinTestNoRstTip4CreateDrugReason = "SkinTestNoRstTip4CreateDrugReason";
    public static final String SkinTestRst4Sign = "SkinTestRst4Sign";
    public static final String SkinTestOrder4Sign = "SkinTestOrder4Sign";
    public static final String SkinTestOrderCreate = "SkinTestOrderCreate";
    public static final String SkinTestAllergy4Sign = "SkinTestAllergy4Sign";
    public static final String SkinTestOrderPatallergy4Sign = "SkinTestOrderPatallergy4Sign";
    
    /**
     * 错误等级
     */
    public static final String ErrorLevel_A="A";// 正常
    public static final String ErrorLevel_B="B";// 提示
    public static final String ErrorLevel_C="C";
    public static final String ErrorLevel_D="D";
    public static final String ErrorLevel_E="E";// 严重错误
}
