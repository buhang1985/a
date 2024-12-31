package iih.ci.mrm.pub.MrMConst;

public class IMrMSysParamDefaultConst {


	/**
	 * 完成病历是否生成电子文档
	 */
	public static final Boolean SYS_PARAM_MRM_COMPLETE_GENERATE_ELE_DEFAULT= false ;
	
	/**
	 * 首次打印是否收费
	 */
	public static final Boolean SYS_PARAM_MRM_PRINT_FIRST_FREE_DEFAULT= true;
	
	/**
	 * 收费服务
	 */
	public static final String SYS_PARAM_MRM_PRINT_CHARGE_DEFAULT="";
	
	/**
	 * 入库是否录入信息
	 */
	public static final Boolean SYS_PARAM_MRM_STORAGE_ADD_INFO_DEFAULT= false;
	
	/**
	 * 自动生成病案电子文档格式
	 */
	public static final String SYS_PARAM_MRM_SAVE_FORMAT_DEFAULT = "1";
	
	/**
	 * 获取文件改名前缀
	 */
	public static final String SYS_PARAM_MRM_FILE_PREFIX_DEFAULT = "NONE";
	
	/**
	 * 获取文件改名序号长度
	 */
	public static final String SYS_PARAM_MRM_NUM_LENGTH_DEFAULT = "3";
	
	/**
	 * 获取病案输出水印设置
	 */
	public static final String SYS_PARAM_MRM_WATER_MARK_DEFAULT = "<?xml version=\"1.0\" encoding=\"utf-8\"?><root><!--是否启用  Y启用  N停用--><active>Y</active><!--水印内容--><area>北大国际医院</area><!--水印内容字体名称--><fontname>宋体</fontname><!--水印内容字体大小--><fontsize>80</fontsize><!--水印内容是否加粗--><blod>Y</blod><!--透明度0-100--><transparency>50</transparency><!--倾斜度--><inclination>-30</inclination><!--起始横坐标--><pointx>-300</pointx><!--起始纵坐标--><pointy>600</pointy></root>";
	
	/**
	 * 是否弹出应收预收金录入
	 */
	public static final Boolean SYS_PARAM_MRM_CHECK_ADVANCE_PAY_DEFAULT = true;
	
	/**
	 * 未打印病案是否可邮寄确认
	 */
	public static final Boolean SYS_PARAM_MRM_CHECK_UNPRINTED_DEFAULT = true;
	
	/**
	 * 未打印病案是否可邮寄确认
	 */
	public static final int SYS_PARAM_MRM_FP_TYPE_DEFAULT = 0;//默认西医
	
	/**
	 * 病案可召回状态默认
	 */
	public static final String SYS_PARAM_MRM_RECALL_STATUS_DEFAULT="@@@@AA1000000000099Z";
}
