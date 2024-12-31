package iih.bd.pp.s.external.provide.bp;

import iih.bd.pp.i.external.provide.meta.bl.TreatPriceInfo;
import iih.bd.pp.s.external.provide.bp.qry.FindPageListQry;
import iih.bd.pp.s.external.provide.bp.qry.FindTreatPriListByPycodeQry;
import iih.bd.utils.CommDAFacade;
import xap.mw.core.data.BizException;

/**
 * 根据搜索文本查询诊疗价格列表业务逻辑
 * 
 * @author hao_wu 2018-6-12
 *
 */
public class FindTreatPriListBySearchTextBp {

	/**
	 * 根据搜索文本查询诊疗价格列表
	 * 
	 * @param searchText
	 *            搜索文本:拼音码、五笔码、助记码、名称
	 * @return
	 * @throws BizException
	 */
	public TreatPriceInfo[] exec(String searchText) throws BizException {

		FindTreatPriListByPycodeQry qry = new FindTreatPriListByPycodeQry(searchText);
		FindPageListQry paListQry = new FindPageListQry(qry, 500, 0);
		TreatPriceInfo[] result = CommDAFacade.execQuery(paListQry, TreatPriceInfo.class);
		return result;
	}
}
