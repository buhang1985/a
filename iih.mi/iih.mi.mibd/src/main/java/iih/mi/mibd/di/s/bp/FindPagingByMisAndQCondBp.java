package iih.mi.mibd.di.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.mi.mibd.di.d.DiDO;
import iih.mi.mibd.di.d.desc.DiDODesc;
import iih.mi.mibd.di.i.IDiRService;
import iih.mi.mibd.mis.d.MisDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据所属医保系统和查询方案查询病种目录分页数据业务逻辑
 * 
 * @author dj.zhang
 *
 */
public class FindPagingByMisAndQCondBp {

	public PagingRtnData<DiDO> exec(MisDO mis, QryRootNodeDTO qryRootNodeDTO, String orderStr, PaginationInfo pg)
			throws BizException {

		String wherePart = getWherePart(mis, qryRootNodeDTO);
		PagingRtnData<DiDO> result = findPagingByWherePart(wherePart, orderStr, pg);
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
			wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDTO, DiDODesc.CLASS_FULLNAME);
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
	private PagingRtnData<DiDO> findPagingByWherePart(String wherePart, String orderStr, PaginationInfo pg)
			throws BizException {
		IDiRService diRService = ServiceFinder.find(IDiRService.class);
		PagingRtnData<DiDO> result = diRService.findByPageInfo(pg, wherePart, orderStr);
		return result;
	}
}
