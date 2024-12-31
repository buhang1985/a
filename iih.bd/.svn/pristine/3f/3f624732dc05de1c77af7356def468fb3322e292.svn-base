package iih.bd.srv.mrfpbltype.s.bp;

import iih.bd.srv.mrfpbltype.d.MrFpBlTypeProDO;
import iih.bd.srv.mrfpbltype.d.MrfpbltypeAggDO;
import xap.mw.core.data.BizException;

/**
 * 首页费用分类Agg子DO唯一性检查逻辑
 * 
 * @author hao_wu
 *
 */
public class MrfpbltypeAggProUniqueValidateBp {

	public void exec(MrfpbltypeAggDO[] dataArr) throws BizException {
		if (dataArr == null || dataArr.length <= 0) {
			return;
		}

		MrFpBlTypeProUniqueValidateBp bp = new MrFpBlTypeProUniqueValidateBp();
		for (MrfpbltypeAggDO mrfpbltypeAggDO : dataArr) {
			MrFpBlTypeProDO[] mrFpBlTypeProDOArr = mrfpbltypeAggDO.getMrFpBlTypeProDO();
			bp.exec(mrFpBlTypeProDOArr);
		}
	}
}
