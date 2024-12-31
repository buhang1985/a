package iih.bd.pp.bdhpspec.s;

import iih.bd.pp.bdhpspec.d.BdHpSpecDO;
import iih.bd.pp.bdhpspec.d.BdhpspecAggDO;
import iih.bd.pp.bdhpspec.i.IBdHpSpecExtCudService;
import iih.bd.pp.bdhpspec.i.IBdHpSpecExtRService;
import iih.bd.pp.bdhpspec.s.bp.FindByHpBp;
import iih.bd.pp.bdhpspec.s.bp.FindByIdBp;
import iih.bd.pp.hp.d.HPDO;
import xap.mw.core.data.BizException;

/**
 * 医保特殊病扩展服务
 * 
 * @author hao_wu
 *
 */
public class BdHpSpecExtCrudServiceImpl implements IBdHpSpecExtRService, IBdHpSpecExtCudService {

	@Override
	public BdHpSpecDO[] FindByHp(HPDO hpdo) throws BizException {
		FindByHpBp bp = new FindByHpBp();
		BdHpSpecDO[] result = bp.exec(hpdo);
		return result;
	}

	@Override
	public BdhpspecAggDO FindById(String pk) throws BizException {
		FindByIdBp bp = new FindByIdBp();
		BdhpspecAggDO result = bp.exec(pk);
		return result;
	}

}
