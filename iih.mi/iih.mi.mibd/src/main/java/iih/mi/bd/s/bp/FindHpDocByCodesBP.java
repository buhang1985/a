package iih.mi.bd.s.bp;

import iih.mi.bd.d.HpDocDTO;
import iih.mi.bd.s.bp.sql.FindHpDocByCodesQry;
import iih.mi.mibd.base.exception.ArgumentNullException;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 医保档案数据查询处理
 * @author ly 2018/09/08
 *
 */
public class FindHpDocByCodesBP {

	/**
	 * 根据编码查询医保档案数据
	 * (档案编码为空时，返回该档案类型下全部档案数据)
	 * 
	 * @param hpId 医保产品id
	 * @param docTypeCode 档案类型编码
	 * @param docCodes 档案编码
	 * @return 档案数据
	 * @throws BizException
	 */
	public HpDocDTO[] exec(String hpId, String docTypeCode, String[] docCodes) throws BizException {
	
		if(StringUtil.isEmpty(hpId)){
			throw new ArgumentNullException("医保档案查询", "医保产品id");
		}
		
		if(StringUtil.isEmpty(docTypeCode)){
			throw new ArgumentNullException("医保档案查询", "档案类型编码");
		}
		
		//复用医保产品待讨论 TODO
		FindHpDocByCodesQry qry = new FindHpDocByCodesQry(hpId, docTypeCode, docCodes);
		return (HpDocDTO[])AppFwUtil.getDORstWithDao(qry, HpDocDTO.class);
	}
}
