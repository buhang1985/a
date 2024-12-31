package iih.bd.bc.udi.pub;

public class SuMrConst {

//	1	1000AA100000000009A1 00	新建（草稿）			
//	2	1000AA100000000009A2 01	已提交					
//	3	1000AA100000000009A3 02	二级审签中				
//	4	1000AA100000000009A4 03	已二级审签				
//	5	1000AA100000000009A5 04	三级审签中				
//	6	1000AA100000000009A6 05	已三级审签				
	
	
	public static final String ID_SUMR_NEW = "@@@@AA100000000009A1"; //01	新建	
	public static final String ID_SUMR_SUBMIT = "@@@@AA100000000009A2"; //已提交
	public static final String ID_SUMR_INTWOLEVELAUDIT = "@@@@AA100000000009A3"; //03	二级审签中
	public static final String ID_SUMR_TWOLEVELSIGNBY = "@@@@AA100000000009A4"; //04	已二级审签
	public static final String ID_SUMR_IN_THREELEVELAUDIT = "@@@@AA100000000009A5"; //05	三级审签中
	public static final String ID_SUMR_THREELEVELSIGNBY = "@@@@AA100000000009A6"; //06	已三级审签

	/**
	 * 95 审签中
	 */
    public static final String ID_SUMR_SIGNING = "@@@@AA100000000009B1";
    /**
     * 98	取回
     */
    public static final String ID_SUMR_RETRIEVE = "@@@@AA100000000009A8";
    /**
     * 99	驳回
     */
    public static final String ID_SUMR_REJECT = "@@@@AA100000000009A7";
    /**
     * 96	审签完成
     */
    public static final String ID_SUMR_COMPLETE = "@@@@AA100000000009A9";
    
	public static final String SD_SUMR_NEW = "00"; 
	public static final String SD_SUMR_SUBMIT = "01"; 
	public static final String SD_SUMR_INTWOLEVELAUDIT = "02";
	public static final String SD_SUMR_TWOLEVELSIGNBY = "03";
	public static final String SD_SUMR_IN_THREELEVELAUDIT = "04";
	public static final String SD_SUMR_THREELEVELSIGNBY = "05"; 
	
	/**
	 * 95 审签中
	 */
    public static final String SD_SUMR_SIGNING = "95";
    /**
     * 98	取回
     */
    
    public static final String SD_SUMR_RETRIEVE = "98";
    /**
     * 99	驳回
     */
    public static final String SD_SUMR_REJECT = "99";
    /**
     * 96	审签完成
     */
    public static final String SD_SUMR_COMPLETE = "96";



}