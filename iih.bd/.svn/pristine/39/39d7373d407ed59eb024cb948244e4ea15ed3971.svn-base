package iih.bd.mhi.hpfeeca.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.mhi.dto.d.HPFeeCaCompDTO;
import iih.bd.mhi.hpfeeca.s.bp.qry.FindFeecaPagingByHpIdSql;
import iih.bd.pp.hp.d.HPDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;

/**
 * 查询费别对照
 * 
 * @author dj.zhang
 *
 */
public class FindFeecaPagingByHpIdBp {

	public PagingRtnData<HPFeeCaCompDTO> exec(HPDO hpdo, String orderStr, PaginationInfo pg) throws BizException {
		String hpId = hpdo.getId_hp();
		if (StringUtils.isNotEmpty(hpdo.getId_refhp())) {
			hpId = hpdo.getId_refhp();
		}
		FindFeecaPagingByHpIdSql sql = new FindFeecaPagingByHpIdSql(hpId);
		PagingServiceImpl<HPFeeCaCompDTO> pagingServiceImpl = new PagingServiceImpl<HPFeeCaCompDTO>();
		PagingRtnData<HPFeeCaCompDTO> pagingRtnData = pagingServiceImpl.findByPageInfo(new HPFeeCaCompDTO(), pg,
				sql.getQrySQLStr(), orderStr, sql.getQryParameter(null));
		return pagingRtnData;
	}

}
