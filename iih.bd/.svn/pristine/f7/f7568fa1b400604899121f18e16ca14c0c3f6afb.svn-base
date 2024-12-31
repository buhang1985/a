package iih.bd.pp.hp.s.bp;

import iih.bd.mhi.dto.d.HpDosageCompDTO;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.s.bp.sql.FindPagingByHpIdSql;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;

/**
 * @author dj.zhang
 *
 */
public class FindPagingByHpIdBp {

	public PagingRtnData<HpDosageCompDTO> exec(HPDO hpdo, String orderStr, PaginationInfo pg) throws BizException {
		FindPagingByHpIdSql sql = new FindPagingByHpIdSql(hpdo.getId_hp());
		PagingServiceImpl<HpDosageCompDTO> pagingServiceImpl = new PagingServiceImpl<HpDosageCompDTO>();
		PagingRtnData<HpDosageCompDTO> pagingRtnData = pagingServiceImpl.findByPageInfo(new HpDosageCompDTO(), pg,
				sql.getQrySQLStr(), orderStr, sql.getQryParameter(null));
		return pagingRtnData;
	}

}
