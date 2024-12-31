package iih.bd.pp.anhuisrvorca.s.bp;

import iih.bd.pp.anhuiinsur.d.CenChargeCate;
import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import iih.bd.pp.anhuisrvorca.s.bp.sql.FindDrugCompSql;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;

/**
 * 获取超限价药品对照信息业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindExceedMaxPriDrugCompBp {

	public PagingRtnData<DrugCompDTO> exec(String hpCode, PaginationInfo pg) throws BizException {
		String hpId = GetHpId(hpCode);
		String wherePart = GetWherePart();
		FindDrugCompSql sql = new FindDrugCompSql(hpId, wherePart);
		PagingServiceImpl<DrugCompDTO> pagingServiceImpl = new PagingServiceImpl<DrugCompDTO>();
		PagingRtnData<DrugCompDTO> pagingRtnData = pagingServiceImpl.findByPageInfo(new DrugCompDTO(), pg,
				sql.getQrySQLStr(), "UDIDOC_DOSAGE.NAME DESC,MM.CODE", sql.getQryParameter(null));

		return pagingRtnData;
	}

	/**
	 * 获取医保计划主键
	 * 
	 * @param hpCode
	 * @return
	 * @throws BizException
	 */
	private String GetHpId(String hpCode) throws BizException {
		FindHpDoByCodeBp bp = new FindHpDoByCodeBp();
		HPDO hpdo = bp.exec(hpCode);
		return hpdo.getId_hp();
	}

	/**
	 * 查询方案生成条件语句
	 * 
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
	private String GetWherePart() throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		wherePartBuilder.append(
				" AND DRUG_ORGINAL.PRI_MAX <> 0 AND DRUG_ORGINAL.PRI_MAX IS NOT NULL AND MM.PRICE > DRUG_ORGINAL.PRI_MAX");
		wherePartBuilder.append(String.format(" AND SRVORCA.EU_STATUS = '%s'", HpStatusEnum.REVIEW));

		String wherePart = String.format(" AND　DRUG_ORGINAL.CODE_CA　<> '%s'", CenChargeCate.MATERIALFEES);
		wherePartBuilder.append(wherePart);
		return wherePartBuilder.toString();
	}
}
