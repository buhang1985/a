package iih.bd.pp.anhuisrvorca.s.bp;

import iih.bd.pp.anhuiinsur.d.CenChargeCate;
import iih.bd.pp.anhuisrvorca.d.TreatCompDTO;
import iih.bd.pp.anhuisrvorca.s.bp.sql.FindTreatAndFwssCompSql;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;

/**
 * 获取超限价对照信息业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindExceedMaxPriCompBp {

	public PagingRtnData<TreatCompDTO> exec(String hpCode, PaginationInfo pg) throws BizException {
		String hpId = GetHpId(hpCode);
		String wherePart = GetWherePart();
		FindTreatAndFwssCompSql sql = new FindTreatAndFwssCompSql(hpId, wherePart);
		PagingServiceImpl<TreatCompDTO> pagingServiceImpl = new PagingServiceImpl<TreatCompDTO>();
		PagingRtnData<TreatCompDTO> pagingRtnData = pagingServiceImpl.findByPageInfo(new TreatCompDTO(), pg,
				sql.getQrySQLStr(), "SRV_CODE", sql.getQryParameter(null));
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
		wherePartBuilder.append(" AND PRI_MAX <> 0 AND PRI_MAX IS NOT NULL AND SRV_PRICE > PRI_MAX");
		wherePartBuilder.append(String.format(" AND EU_STATUS = '%s'", HpStatusEnum.REVIEW));
		
		String wherePart = String.format(" AND　CODE_CA　<> '%s'", CenChargeCate.MATERIALFEES);
		wherePartBuilder.append(wherePart);
		return wherePartBuilder.toString();
	}
}
