package iih.bd.srv.mrfpbltype.s.bp;

import iih.bd.srv.mrfpbltype.d.MrfpbltypeAggDO;
import xap.mw.core.data.BizException;

/**
 * 病案首页费用分类插入或更新前规则业务逻辑
 * 
 * @author hao_wu
 *
 */
public class MrfpbltypeAggBeforeInsertOrUpdateRuleBp {

	public void exec(MrfpbltypeAggDO[] arg0) throws BizException {
		//唯一性规则变更  使用框架处理
		// MrfpbltypeAggProUniqueValidateBp bp = new
		// MrfpbltypeAggProUniqueValidateBp();
		// bp.exec(arg0);
	}
}
