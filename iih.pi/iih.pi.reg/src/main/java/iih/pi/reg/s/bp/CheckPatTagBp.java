package iih.pi.reg.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.pi.reg.s.bp.qry.FindPatTagCountQry;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;

/**
 * 检查患者标签业务逻辑
 * 
 * @author hao_wu
 *
 */
public class CheckPatTagBp {

	public Boolean exec(String patCode, String tagTpCode) throws BizException {
		if (StringUtils.isEmpty(patCode)) {
			throw new BizException("患者编码不允许为空。");
		}
		if (StringUtils.isEmpty(tagTpCode)) {
			throw new BizException("标签类型编码不允许为空。");
		}

		Boolean hasTag = checkPatTag(patCode, tagTpCode);
		return hasTag;
	}

	/**
	 * 检查患者标签
	 * 
	 * @author hao_wu
	 * @param patCode
	 *            患者编码
	 * @param tagTpCode
	 *            患者标签类型编码
	 * @return
	 * @throws DAException
	 */
	private Boolean checkPatTag(String patCode, String tagTpCode) throws DAException {
		Integer patTagCount = getPatTagCount(patCode, tagTpCode);
		return patTagCount > 0;
	}

	/**
	 * 获取患者标签个数
	 * 
	 * @author hao_wu
	 * @param patCode
	 * @param tagTpCode
	 * @return
	 * @throws DAException
	 */
	private Integer getPatTagCount(String patCode, String tagTpCode) throws DAException {
		FindPatTagCountQry qry = new FindPatTagCountQry(patCode, tagTpCode);

		DAFacade daFacade = new DAFacade();
		Integer patTagCount = (Integer) daFacade.execQuery(qry.getQrySQLStr(), qry.getQryParameter(null),
				new ColumnHandler("PATTAGCOUNT"));
		return patTagCount;
	}
}
