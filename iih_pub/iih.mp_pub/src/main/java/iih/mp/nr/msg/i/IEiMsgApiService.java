package iih.mp.nr.msg.i;

/**
 * 
 * @description：集成平台webservice统一接口 
 * @author：ma.meng@founder.com
 * @version：2020年3月23日 下午5:57:42 创建
 */
public interface IEiMsgApiService {

	/**
	 * 第三方接口主入口
	 * @param name_mothed 接口方法名
	 * @param inParam 入参xml
	 * @return
	 */
	public abstract String apiEntry(String name_method, String inParam);

}
