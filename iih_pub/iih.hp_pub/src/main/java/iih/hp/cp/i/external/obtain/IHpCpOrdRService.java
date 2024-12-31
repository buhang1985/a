package iih.hp.cp.i.external.obtain;

import xap.mw.core.data.BizException;

/**
 * 临床路径获取【医嘱信息】相关接口
 * @author HUMS
 *
 */
public interface IHpCpOrdRService {

	/**
	 * 根据就诊id获取医嘱排序号
	 * @param id_en 
	 * @return
	 * @throws BizException
	 */
	public Integer getOrdMaxSortno(String id_en) throws BizException ;
}
