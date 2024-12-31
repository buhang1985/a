package iih.hp.cp.sd.i;

import iih.hp.cp.sd.d.HpCpStandardDO;
import iih.hp.cp.sdele.d.HpcpsdeleAggDO;
import xap.mw.core.data.BizException;

/**
 * @author 作者 E-mail:
 * @version 创建时间：2016年8月30日 下午4:12:14
 * 类说明
 */
public interface IHpcpsdExtService {
	/**
	 * 诊疗计划标准以及元素统一保存
	 * @param standarDO
	 * @param aggDOS
	 * @return
	 * @throws BizException
	 */
	public abstract HpCpStandardDO save(HpCpStandardDO standarDO,HpcpsdeleAggDO[] aggDOs)throws BizException;
}
