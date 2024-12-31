package iih.bd.srv.mrtplseg.s.rule.bp;

import iih.bd.srv.mrtplsec.d.MrTplSegFsDO;
import iih.bd.srv.mrtplseg.d.MrTplSegmentDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据片段模板删除片段模板内容业务逻辑
 * 
 * @author hao_wu
 *
 */
public class DelStreamWithSegmentBp {

	public void exec(MrTplSegmentDO[] mrTplSegmentArray) throws BizException {
		if (mrTplSegmentArray == null || mrTplSegmentArray.length <= 0) {
			return;
		}

		DelStream(mrTplSegmentArray);
	}

	/**
	 * 删除片段模板内容
	 * 
	 * @param mrTplSegmentArray
	 * @throws BizException
	 */
	private void DelStream(MrTplSegmentDO[] mrTplSegmentArray) throws BizException {
		DAFacade daFacade = new DAFacade();
		String wherePart = BuildWherePart(mrTplSegmentArray);
		SqlParam sqlParam = BuildSqlParam(mrTplSegmentArray);
		daFacade.deleteByClause(MrTplSegFsDO.class, wherePart, sqlParam);
	}

	/**
	 * 构建条件语句
	 * 
	 * @param mrTplSegmentArray
	 * @return
	 */
	private String BuildWherePart(MrTplSegmentDO[] mrTplSegmentArray) {
		StringBuilder wherePartBuilder = new StringBuilder();
		wherePartBuilder.append("(");
		wherePartBuilder.append(" 1 <> 1 ");
		int lenght = mrTplSegmentArray.length;
		for (int i = 0; i < lenght; i++) {
			String str = String.format(" or %s = ? ", MrTplSegFsDO.ID_MRTPLSEC);
			wherePartBuilder.append(str);
		}
		wherePartBuilder.append(")");
		return wherePartBuilder.toString();
	}

	/**
	 * 构建条件参数
	 * 
	 * @param mrTplSegmentArray
	 * @return
	 */
	private SqlParam BuildSqlParam(MrTplSegmentDO[] mrTplSegmentArray) {
		SqlParam sqlParam = new SqlParam();
		for (MrTplSegmentDO mrTplSegmentDO : mrTplSegmentArray) {
			sqlParam.addParam(mrTplSegmentDO.getId_mrtplsec());
		}
		return sqlParam;
	}

}
