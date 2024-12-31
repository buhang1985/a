package iih.bd.pp.anhuisrvorca.s.bp;

import iih.bd.pp.anhuisrvorca.d.TreatCompDTO;
import iih.bd.pp.anhuisrvorca.s.bp.sql.FindTreatCompSql;
import iih.bd.pp.hp.d.HPDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;

/**
 * 获取超限价诊疗对照分页数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindExceedMaxPriZlCompBp {

	public PagingRtnData<TreatCompDTO> exec(String hpCode, PaginationInfo pg) throws BizException {
		String hpId = GetHpId(hpCode);
		String wherePart = GetWherePart();
		FindTreatCompSql sql = new FindTreatCompSql(hpId, wherePart);
		PagingServiceImpl<TreatCompDTO> pagingServiceImpl = new PagingServiceImpl<TreatCompDTO>();
		PagingRtnData<TreatCompDTO> pagingRtnData = pagingServiceImpl.findByPageInfo(new TreatCompDTO(), pg,
				sql.getQrySQLStr(), "SRV.CODE", sql.getQryParameter(null));
		return pagingRtnData;
	}

	/**
	 * 获取条件语句
	 * 
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
	private String GetWherePart() throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		wherePartBuilder.append(" AND SRV.PRI > ZL_ORGINAL.PRI_MAX ");
		return wherePartBuilder.toString();
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
}
