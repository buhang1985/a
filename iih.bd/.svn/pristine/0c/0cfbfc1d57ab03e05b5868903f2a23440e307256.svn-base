package iih.bd.srv.basemrtplfs.s;

import iih.bd.srv.basemrtplfs.d.BaseMrTplStreamDO;
import iih.bd.srv.basemrtplfs.i.IBaseMrTplfsExtService;
import iih.bd.srv.basemrtplfs.s.bp.SaveBaseMrTplStreamBp;
import iih.bd.srv.basemrtplfs.s.bp.UpdatePaperTypeBp;
import xap.mw.core.data.BizException;

/**
 * 基础医疗模板流数据扩展服务
 * 
 * @author hao_wu
 *
 */
public class BaseMrTplfsExtServiceImpl implements IBaseMrTplfsExtService {

	@Override
	public BaseMrTplStreamDO save(BaseMrTplStreamDO baseMrTplStreamDO, String paperTp) throws BizException {
		SaveBaseMrTplStreamBp bp = new SaveBaseMrTplStreamBp();
		BaseMrTplStreamDO result = bp.exec(baseMrTplStreamDO);

		UpdatePaperTypeBp updatePaperTypeBp = new UpdatePaperTypeBp();
		updatePaperTypeBp.exec(baseMrTplStreamDO.getId_basemrtpl(), paperTp);
		return result;
	}
}
