package iih.bd.pp.priceengine;

/**
 * 仓库
 * @author yankan
 * @since 2017-07-27
 *
 */
public interface IServiceRepository<T>{
	/**
	 * 添加
	 * @param key 键
	 * @param service 服务
	 */
	public abstract void store(String key,T service);
	/**
	 * 更新
	 * @param key 键
	 * @param service 服务
	 */
	public abstract void update(String key,T  service);
	/**
	 * 删除
	 * @param key
	 */
	public abstract void delete(String key);
	/**
	 * 获取
	 * @param key
	 */
	public abstract T find(String key);
}
