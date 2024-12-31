/*
 * 基础数据编码常量定义
 */
package iih.pe.comm.constant;

public interface IPEBdConst {
	public static final String BD_SEX = "@@@@ZZ20000000000035";	 			//性别
	public static final String BD_MARRIAGE = "@@@@ZZ2000000000003J";	 	//婚姻
	public static final String BD_CERTIFICATE = "@@@@ZZ20000000000020";  	//身份标志类型，证件类型
	public static final String BD_BLOODTYPE = "@@@@ZZ2000000000001K";  		//血型
	
	public static final String BD_IDTP = "@@@@AA1000000000MNLZ";			//身份证类型ID
	public static final String BD_SDIDTP = "01";							//身份证类型编码
	
	public static final String BD_IDTP_OTHER = "@@@@AA1000000000MNFJ";		//其他法定有效证件ID
	public static final String BD_SDIDTP_OTHER = "99";						//其他法定有效证件编码

	public static final String PE_REGTPID = "0001Z8100000000UIUX2";         //体检预约，默认体检登记类型 
    public static final String PE_REGTPSD = "01";                           //体检预约，默认体检登记类型
    public static final String PE_REGTPNAME = "健康体检"; 
}
