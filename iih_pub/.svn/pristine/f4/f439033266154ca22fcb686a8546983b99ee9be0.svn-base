package iih.sfda.pub;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 集合相关帮助类
 * 
 * @author lijm
 *
 */
public class CollectUtils {

	/**
	 * 获取FArrayList集合中第一个元素
	 * 
	 * @param flist
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static <T extends BaseDO> T GetFirstEleFromFArrayList(FArrayList flist) throws BizException {
		if (flist == null || flist.size() == 0)
			return null;
		T baseDo = (T) flist.get(0);
		return baseDo;
	}

	/**
	 * 获取FArrayList集合中第index+1个元素
	 * 
	 * @param flist
	 * @param index
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static <T extends BaseDO> T GetIndexEleFromFArrayList(FArrayList flist, Integer index) throws BizException {
		if (flist == null || flist.size() == 0 || flist.size() < index)
			return null;
		T baseDo = (T) flist.get(index);
		return baseDo;
	}

	/**
	 * 根据给定BaseDO获取FArrayList集合
	 * 
	 * @param baseDo
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static <T extends BaseDO> FArrayList GetFArrayList(T baseDo) throws BizException {
		if (baseDo == null)
			return null;
		FArrayList list = new FArrayList();
		list.add(baseDo);
		return list;
	}

	/**
	 * 根据给定BaseDO数组获取FArrayList集合
	 * 
	 * @param baseDos
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static <T extends BaseDO> FArrayList GetFArrayList(T[] baseDos) throws BizException {
		if (baseDos == null || baseDos.length == 0)
			return null;
		FArrayList list = new FArrayList();
		for (T baseDo : baseDos)
			list.add(baseDo);
		return list;
	}
}
