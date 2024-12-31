package iih.en.pv.out.bp.qry;

import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 患者是否有对应标签
 * 
 * @author liubin
 *
 */
public class EntHasTagBP {
	/**
	 * 患者是否有对应标签
	 * 
	 * @param entId
	 * 			就诊id
	 * @param sd_tagtp
	 * 			标签类型（iih.bd.bc.udi.pub.IBdFcDictCodeConst.SD_TAGTP_XXX）
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String entId, String sd_tagtp)
			throws BizException {
		if(EnValidator.isEmpty(entId) || EnValidator.isEmpty(sd_tagtp))
			return FBoolean.FALSE;
		String sql = "SELECT COUNT(1) FROM EN_ENT_TAGTP WHERE ID_ENT = ? AND CODE_TAGTP = ?  AND NVL(DT_END, ?) >= ? ";
		SqlParam param = new SqlParam();
		param.addParam(entId);
		param.addParam(sd_tagtp);
		FDateTime now = EnAppUtils.getServerDateTime();
		param.addParam(now);
		param.addParam(now);
		Integer count = (Integer) new DAFacade().execQuery(sql, param, new ColumnHandler());
		return new FBoolean(count != null && count > 0);
	}
}
