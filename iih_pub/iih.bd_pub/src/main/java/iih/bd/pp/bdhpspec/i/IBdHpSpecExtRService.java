package iih.bd.pp.bdhpspec.i;

import iih.bd.pp.bdhpspec.d.BdHpSpecDO;
import iih.bd.pp.bdhpspec.d.BdhpspecAggDO;
import iih.bd.pp.hp.d.HPDO;
import xap.mw.core.data.BizException;

/**
 * 医保特殊病扩展查询服务
 * 
 * @author hao_wu
 *
 */
public interface IBdHpSpecExtRService {
	/**
	 * 使用医保计划查询医保特殊病列表
	 * 
	 * @param hpdo
	 *            医保计划
	 * @return
	 * @throws BizException
	 */
	public abstract BdHpSpecDO[] FindByHp(HPDO hpdo) throws BizException;

	/**
	 * 使用主键查询医保特殊病信息
	 * 
	 * @param pk
	 *            主键
	 * @return
	 * @throws BizException
	 */
	public abstract BdhpspecAggDO FindById(String pk) throws BizException;
}
