package iih.bd.srv.basemrtplfs.s.bp;

import iih.bd.srv.basemrtplfs.d.BaseMrTplStreamDO;
import iih.bd.srv.basemrtplfs.i.IBasemrtplfsCudService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存基础医疗模板流数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class SaveBaseMrTplStreamBp {

	public BaseMrTplStreamDO exec(BaseMrTplStreamDO baseMrTplStreamDO) throws BizException {
		if (baseMrTplStreamDO == null) {
			return null;
		}

		IBasemrtplfsCudService basemrtplfsCudService = ServiceFinder.find(IBasemrtplfsCudService.class);
		BaseMrTplStreamDO[] result = basemrtplfsCudService.save(new BaseMrTplStreamDO[] { baseMrTplStreamDO });

		if (result == null || result.length != 1) {
			throw new BizException("保存基础医疗模板流数据失败。");
		}

		return result[0];
	}

}
