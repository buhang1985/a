package iih.ci.sdk.define;

/**
 * 临床数据交互模式，主要区分由于不同的UI展现模式造成的数据读写差异
 * @author wangqingzhu
 *
 */
@Deprecated
public class ICIDataActionMode {

	/**
	 * 医嘱直接编辑医疗单模式
	 */
	public static String OrderEms_DataActionMode = "0";
	
	/**
	 * 底部固定医疗单编辑，医嘱列表禁止编辑模式
	 */
	public static String BottomFixEms_DataActionMode = "1";
}
