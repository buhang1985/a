package iih.en.pv.common;
/**
 * 检查标识
 * 0-表示不检查   1-表示有内容警示 2-表示有内容强制不允许出院
 * @author yank
 * @since date 2015-10-17
 *
 */
public class CheckFlag {
	public static final Integer NoCheck=0;//不检查
	public static final Integer Warn=1;//有内容只是警告
	public static final Integer Forced=2;//有内容则强制停止
}
