package iih.ci.mr.pub.mrutil.stringoper;

/**
 * 
 * @author zhang.jb
 * @des 字符串操作方法
 *
 */
public  class StringOperUtil {
	/**
	 * 将数组合并成字符串
	 * @param arrStr 字符串数组
	 * @param strSplit 分割字符串
	 *  @param strPreSurround 每个字符转前环绕字符串
	 *   @param strBehSurround 每个字符转后环绕字符串
	 * @return
	 */
	public static String arrayStringJoin(String[] arrStr,String strSplit,String strPreSurround,String strBehSurround )
	{
		String strJoinResult ="" ;
		if(arrStr!=null)
		{
			for(String str :arrStr)
			{
				strJoinResult+=strPreSurround+str+strBehSurround+strSplit;
			}
			int subCount = strSplit!=null?strSplit.length():0;
			strJoinResult = strJoinResult.substring(0,strJoinResult.length()-subCount);
		}
		return strJoinResult;
	}
	/**
	 * 将数组合并成字符串
	 * @param arrStr 字符串数组
	 * @param strSplit 分割字符串
	 *  @param strPreSurround 每个字符转前环绕字符串
	 * @return
	 */
	public static String arrayStringJoin(String[] arrStr,String strSplit,String strPreSurround )
	{
		return arrayStringJoin(arrStr, strSplit, strPreSurround,"");	
	}
	/**
	 * 将数组合并成字符串
	 * @param arrStr 字符串数组
	 * @param strSplit 分割字符串
	 * @return
	 */
	public static String arrayStringJoin(String[] arrStr,String strSplit )
	{
		return arrayStringJoin(arrStr, strSplit, "","");	
	}
}
