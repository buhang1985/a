package iih.mi.mibd.srvfac.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.mi.mibd.mis.d.MisDO;
import iih.mi.mibd.srvfac.d.SrvfacDO;
import iih.mi.mibd.srvfac.d.desc.SrvfacDODesc;
import iih.mi.mibd.srvfac.i.ISrvfacRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据所属医保系统和查询方案查询服务设施分页数据业务逻辑
 * 
 * @author dj.zhang
 *
 */
public class FindPagingByMisAndQCondBp {

	public PagingRtnData<SrvfacDO> exec(MisDO mis, QryRootNodeDTO qryRootNodeDTO, String orderStr, PaginationInfo pg)
			throws BizException {

		String wherePart = getWherePart(mis, qryRootNodeDTO);
		PagingRtnData<SrvfacDO> result = findPagingByWherePart(wherePart, orderStr, pg);
		return result;
	}

	/**
	 * 获取条件语句
	 * 
	 * @param mis
	 * @param qryRootNodeDTO
	 * @return
	 * @throws BizException
	 */
	private String getWherePart(MisDO mis, QryRootNodeDTO qryRootNodeDTO) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String wherePart;
		if (mis != null) {
			wherePart = String.format(" and Id_mis = '%s'", mis.getId_mis());
			wherePartBuilder.append(wherePart);
		}

		if (qryRootNodeDTO != null) {
			wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDTO, SrvfacDODesc.CLASS_FULLNAME);
			if (StringUtils.isNotEmpty(wherePart)) {
				wherePartBuilder.append(" and ");
				wherePartBuilder.append(wherePart);
			}
		}
		return wherePartBuilder.toString();
	}

	/**
	 * 根据条件语句查询分页数据
	 * 
	 * @param wherePart
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<SrvfacDO> findPagingByWherePart(String wherePart, String orderStr, PaginationInfo pg)
			throws BizException {
		ISrvfacRService srvfacRService = ServiceFinder.find(ISrvfacRService.class);
		PagingRtnData<SrvfacDO> result = srvfacRService.findByPageInfo(pg, wherePart, orderStr);
		return result;
	}
}
