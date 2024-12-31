package iih.bd.pp.priceengine;

import java.util.HashMap;
import java.util.Map;

/**
 * 服务仓库
 * 
 * @author yankan
 * @since 2017-07-25
 *
 */
public class ServiceRepository<T> implements IServiceRepository<T> {
	public Map<String, Object> serviceMap = new HashMap<String, Object>();

	/**
	 * 构造函数
	 */
	public ServiceRepository() {

	}

	/**
	 * 添加
	 * 
	 * @param key 键
	 * @param service 服务
	 */
	@Override
	public void store(String key, T service) {
		serviceMap.put(key, service);
	}

	/**
	 * 更新
	 * 
	 * @param key 键
	 * @param service 服务
	 */
	@Override
	public void update(String key, T service) {
		if (key != null) {
			serviceMap.put(key, service);
		}
	}

	/**
	 * 删除
	 * 
	 * @param key
	 */
	@Override
	public void delete(String key) {
		if (serviceMap.containsKey(key)) {
			serviceMap.remove(key);
		}
	}

	/**
	 * 获取
	 * 
	 * @param key
	 */
	@Override
	public T find(String key) {
		if (key == null) {
			return null;
		}

		return (T) serviceMap.get(key);
	}
}
