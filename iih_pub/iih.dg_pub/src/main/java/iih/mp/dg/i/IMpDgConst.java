package iih.mp.dg.i;

/**
 * 执行域药品服务常量
 * @author ly
 *
 */
public interface IMpDgConst {

	/*
	 * 药品发送状态
	 */
	public static final String SEND_STATE_NOT_SEND = "0";//未发送
	public static final String SEND_STATE_HAS_SEND = "1";//已发送,未确认
	public static final String SEND_STATE_HAS_CONFIRM = "2";//已确认
	public static final String SEND_STATE_PART_CONFIRM = "3";//发药中 部分确认
	
	/*
	 * 摆药类型
	 */
	public static final String PUT_TYPE_PUT = "21";//发药
	public static final String PUT_TYPE_RETURN = "22";//退药
	public static final String PUT_TYPE_TAKE = "23";//出院带药
	
	
	/*
	 * 请领单号（空）
	 */
	public static final String APP_CODE_BLANK = "0000000000";
	
	/*
	 * 贵重处方默认名称
	 */
	public static final String NAME_NOT_OTC = "处";
	public static final String NAME_VAL_SPECIAL = "贵";
	
	/**
	 * 取整模式
	 */
	public static final String SPLITRS_GRPTP_OUTP="4";  //出院带药类型
	public static final String SPLITRS_GRPTP_HERB="5";  //草药
	public static final String SPLITRS_GRPTP_NBYT="0";  //按此取整
	public static final String SPLITRS_GRPTP_NBYB="1";      //按批取整
	public static final String SPLITRS_GRPTP_REMAINS="2";      //余量法
	public static final String SPLITRS_GRPTP_WDSUM="3";      //病区合用法
	public static final String SPLITRS_GRPTP_SRV="6";      //只按服务
	
	/**
	 * 分窗口调用点  
	 */
	public static final Integer ENTRY_NEVER=0;
	public static final Integer ENTRY_AFTER_CHARGE=1;
	public static final Integer ENTRY_AFTER_SIGN=2;
	
	
	/**
	 * 未发药  0
	 */ 
	public static final Integer DRUG_MP_UNDISPENSE=0;//未发药
	/**
	 * 已发药  1
	 */
	public static final Integer DRUG_MP_DISPENSED=1;//
	/**
	 * 发药完成  2
	 */
	public static final Integer DRUG_MP_COMPLETED=2;//
	/**
	 * 已退药  8  
	 */
	public static final Integer DRUG_MP_PHARMRTN=8;//
	/**
	 * 退药完成   9 
	 */
	public static final Integer DRUG_MP_PHARMRTNOK=9;//
	
	public static final String ERROR_MPAPPUT4IP_LISTENER_NOT_MATCH_EVENT = "住院发药监听器与事件源不匹配！";

	public static final String ERROR_MPOPPUT4IP_LISTENER_NOT_MATCH_EVENT = "门急诊处方发药监听器与事件源不匹配！";

	/**
	 * 综合窗口id占位符
	 */
	public static final String SYN="SYN";
	public static final String SYN_NAME = "综合窗口";
}
