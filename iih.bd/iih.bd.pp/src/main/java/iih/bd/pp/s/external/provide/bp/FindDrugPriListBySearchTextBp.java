package iih.bd.pp.s.external.provide.bp;

import iih.bd.pp.i.external.provide.meta.bl.DrugPriceInfo;
import iih.bd.pp.s.external.provide.bp.qry.FindDrugPriListByPycodeQry;
import iih.bd.pp.s.external.provide.bp.qry.FindPageListQry;
import iih.bd.utils.CommDAFacade;
import xap.mw.core.data.BizException;

/**
 * 根据搜索文本查询药品价格列表业务逻辑
 * 
 * @author hao_wu 2018-6-12
 *
 */
public class FindDrugPriListBySearchTextBp {

	/**
	 * 根据搜索文本查询药品价格列表
	 * 
	 * @param searchText
	 *            搜索文本:拼音码、五笔码、助记码、名称
	 * @return
	 * @throws BizException
	 */
	public DrugPriceInfo[] exec(String searchText) throws BizException {

		FindDrugPriListByPycodeQry qry = new FindDrugPriListByPycodeQry(searchText);
		FindPageListQry paListQry = new FindPageListQry(qry, 500, 0);
		DrugPriceInfo[] result = CommDAFacade.execQuery(paListQry, DrugPriceInfo.class);
		return result;
	}
}
