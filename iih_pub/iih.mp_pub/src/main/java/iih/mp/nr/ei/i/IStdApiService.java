package iih.mp.nr.ei.i;

/**
 * 
 * @Description:第三方医技相关标准接口 new
 * 给第三方提供的webservice统一走这一个入口 创建一个管理类 根据不同的方法名调用不同的接口
 * @author: huang_junhao@founder.com.cn
 * @version：2019年4月22日 下午1:50:31 创建
 */
public interface IStdApiService {


	/**
	 * 第三方接口主入口
	 * @param name_mothed 接口方法名
	 * @param inParam 入参xml
	 * @return
	 */
	public abstract String apiEntry(String name_method, String inParam);
}
