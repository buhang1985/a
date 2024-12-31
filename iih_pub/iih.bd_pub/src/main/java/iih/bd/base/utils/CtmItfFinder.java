package iih.bd.base.utils;

import java.lang.reflect.Constructor;
import java.util.HashMap;

import org.apache.commons.lang.ArrayUtils;

import com.founder.xap.runtime.msys.Module;
import com.founder.xap.runtime.msys.ModuleSystem;
import com.founder.xap.runtime.msys.impl.ModuleSystemImpl;

import iih.bd.bs.ctmitfrel.d.CtmItfRelDO;
import iih.bd.bs.ctmitfrel.i.ICtmitfrelRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 客户化接口查找器
 * 
 * @author hao_wu 2019-12-13
 * @version 2020/05/18 1.去掉本地缓存 2.增加模块字段
 *
 */
public class CtmItfFinder {

	/**
	 * 接口信息缓存
	 */
	//private static HashMap<String, CtmItfRelDO> ItfCache = new HashMap<String, CtmItfRelDO>();

	/**
	 * 获取实例类对象
	 * 
	 * @param itfType 客户化接口类型
	 * @return 实例类对象
	 * @throws BizException
	 */
	public static <T> T find(Class<T> itfType) throws BizException {
		return find(itfType, null);
	}

	/**
	 * 获取实例类对象
	 * 
	 * @param itfType   客户化接口类型
	 * @param paramObjs 参数对象集合
	 * @return 实例类对象
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T find(Class<T> itfType, Object[] paramObjs) throws BizException {
		Object implObj = createImplByItfType(itfType, paramObjs);
		return (T) implObj;
	}

	/**
	 * 获取实例类对象
	 * 
	 * @param itfClsName 客户化接口全类名
	 * @return 实例类对象
	 * @throws BizException
	 */
	public static Object find(String itfClsName) throws BizException {
		return find(itfClsName, null);
	}

	/**
	 * 获取实例类对象
	 * 
	 * @param itfClsName 客户化接口全类名
	 * @param paramObjs  参数对象集合
	 * @return 实例类对象
	 * @throws BizException
	 */
	public static Object find(String itfClsName, Object[] paramObjs) throws BizException {
		Class<?> itfType = getType(itfClsName);

		Object implObj = find(itfType, paramObjs);
		return implObj;
	}

	/**
	 * 根据客户化接口类型获取实例类类型
	 * 
	 * @param itfType 客户化接口类型
	 * @return 实例类类型
	 * @throws BizException
	 */
	public static Class<?> findImplType(Class<?> itfType) throws BizException {
		// 1.查询接口信息
		String itfClsName = itfType.getName();

		CtmItfRelDO itmRelDo = null;
		//if (ItfCache.containsKey(itfClsName)) {
		//	itmRelDo = ItfCache.get(itfClsName);
		//} else {
			ICtmitfrelRService ctmitfrelRService = ServiceFinder.find(ICtmitfrelRService.class);
			CtmItfRelDO[] itfRelDos = ctmitfrelRService.findByAttrValString(CtmItfRelDO.CLASSNAME_ITF, itfClsName);
			if (ArrayUtils.isEmpty(itfRelDos)) {
				return null;
			}

			if (itfRelDos.length > 1) {
				String msg = String.format("该接口配置有多个实现类，请检查配置，clsname:{1}。", itfClsName);
				throw new BizException(msg);
			}

			itmRelDo = itfRelDos[0];
			if (org.apache.commons.lang.StringUtils.isBlank(itmRelDo.getClassname_impl())) {
				return null;
			}

		//	ItfCache.put(itfClsName, itmRelDo);
		//}

		//String module = itmRelDo.getDllname_impl();
		String module = itmRelDo.getModulename_impl();
		String implClsName = itmRelDo.getClassname_impl();

		// 2.构建Type
		//Class<?> implType = getType(implClsName);
		Class<?> implType = getType(module, implClsName);
		if (implType == null) {
			String msg = String.format("找不到实例类类型，clsname:%s。", implClsName);
			throw new BizException(msg);
		}

		return implType;
	}

	/**
	 * 根据客户化接口类名获取实例类类型
	 * 
	 * @param itfClsName 客户化接口类名
	 * @return 实例类类型
	 * @throws BizException
	 */
	public static Class<?> findImplType(String itfClsName) throws BizException {
		Class<?> itfType = getType(itfClsName);
		Class<?> implType = findImplType(itfType);
		return implType;
	}

	/**
	 * 检查实例化对象类型
	 * 
	 * @param implObj 实例化对象
	 * @param itfType 接口类型
	 * @throws BizException
	 */
	private static void checkImplObjType(Object implObj, Class<?> itfType) throws BizException {
		if (implObj == null) {
			return;
		}
		if (!itfType.isAssignableFrom(implObj.getClass())) {
			String itfClsName = itfType.getName();

			Class<?> implType = implObj.getClass();
			String implClsName = implType.getName();

			String msg = String.format("实例类未实现接口，接口clsname:%s,实例类clsname:%s。", itfClsName, implClsName);
			throw new BizException(msg);
		}
	}

	/**
	 * 根据全类名获取类型
	 * 
	 * @param clsName 全类名
	 * @return 类型
	 * @throws BizException
	 */
	private static Class<?> getType(String clsName) throws BizException {
		Class<?> type = null;
		try {
			type = Class.forName(clsName);
		} catch (ClassNotFoundException e) {
			String msg = String.format("根据全类名\"%s\"获取类型失败.", clsName);
			throw new BizException(msg, e);
		}
		return type;
	}
	
	/**
	 * 根据全类名模块获取类型
	 * @param module
	 * @param clsName
	 * @return
	 * @throws BizException
	 */
	private static Class<?> getType(String moduleName,String clsName) throws BizException {
		Class<?> type = null;
		try {
			String[] names = moduleName.split("\\.");
			if(names.length > 2){
				moduleName = names[0] + "." + names[1];
			}
			ModuleSystem msys = (ModuleSystem)ModuleSystemImpl.getExtensionPoints().getExtensionPoint(ModuleSystem.class);
			Module module = msys.getModule(moduleName);
			type = module.loadClass(clsName);
		} catch (Exception e) {
			String msg = String.format("根据全类名\"%s\"获取类型失败.", clsName);
			throw new BizException(msg, e);
		}
		return type;
	}

	/**
	 * 根据接口类型和参数对象集合创建实例类对象
	 * 
	 * @param itfType   接口类型
	 * @param paramObjs 参数对象集合
	 * @return 实例类对象
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private static <T> T createImplByItfType(Class<T> itfType, Object[] paramObjs) throws BizException {
		Class<?> implType = findImplType(itfType);
		if (implType == null) {
			String msg = String.format("获取接口的实现类类型为空,itfClsName:%s。", itfType.getName());
			throw new BizException(msg);
		}

		Object implObj = createImpl(implType, paramObjs);

		checkImplObjType(implObj, itfType);

//        object implObj = Activator.CreateInstance(implType, true);//根据类型创建实例
//        if (implObj is ICtmItfFactory)
//        {
//            //如果实现类是工厂，则调用工厂的创建实现类方法
//            ICtmItfFactory itfFactory = implObj as ICtmItfFactory;
//            implObj = itfFactory.GetItfImpl(paramObj);
//        }
		return (T) implObj;
	}

	/**
	 * 根据实例类型和参数对象集合创建实例类对象
	 * 
	 * @param implType  实例类型
	 * @param paramObjs 参数对象集合
	 * @return 实例类对象
	 * @throws BizException
	 */
	private static Object createImpl(Class<?> implType, Object[] paramObjs) throws BizException {
		Object implObj = null;
		try {
			if (ArrayUtils.isEmpty(paramObjs)) {
				implObj = implType.newInstance();
			} else {
				Class<?>[] paramTypes = new Class<?>[paramObjs.length];
				for (int i = 0; i < paramObjs.length; i++) {
					paramTypes[i] = paramObjs[i].getClass();
				}

				Constructor<?> constructor = implType.getConstructor(paramTypes);
				if (constructor == null) {
					// 根据参数类型获取构造函数失败
					String msg = String.format("根据参数类型获取构造函数失败,ImplClsName:%s。", implType.getName());
					throw new BizException(msg);
				}

				implObj = constructor.newInstance(paramObjs);
			}
		} catch (Exception e) {
			String msg = String.format("创建接口的实现类实例失败,implClsName:%s。 ", implType.getName(), implType.getName());
			throw new BizException(msg, e);
		}
		return implObj;
	}
}
