package iih.bd.srv.medusage.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.srv.medusage.d.MedUsageDO;
import iih.bd.srv.medusage.d.desc.MedUsageDODesc;
import iih.bd.srv.medusage.i.IMedusageRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 使用服务类型和查询方案查询用法分页数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindPagingByQcondAndSrvTpBp {

	public PagingRtnData<MedUsageDO> exec(UdidocDO srvTp, QryRootNodeDTO qryRootNodeDto, PaginationInfo pg)
			throws BizException {
		String wherePart = GetWherePart(srvTp, qryRootNodeDto);
		PagingRtnData<MedUsageDO> result = FindPaingData(wherePart, pg);
		return result;
	}

	/**
	 * 获取条件语句
	 * 
	 * @param srvTp
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
	private String GetWherePart(UdidocDO srvTp, QryRootNodeDTO qryRootNodeDto) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		if (srvTp != null) {
			String wherePart = String.format(" and id_srvtp = '%s'", srvTp.getId_udidoc());
			wherePartBuilder.append(wherePart);
		}

		String wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDto, MedUsageDODesc.CLASS_FULLNAME);
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}

		return wherePartBuilder.toString();
	}

	/**
	 * 查找分页数据
	 * 
	 * @param wherePart
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<MedUsageDO> FindPaingData(String wherePart, PaginationInfo pg) throws BizException {
		String orderPart = "name";

		IMedusageRService medusageRService = ServiceFinder.find(IMedusageRService.class);
		PagingRtnData<MedUsageDO> result = medusageRService.findByPageInfo(pg, wherePart, orderPart);
		return result;
	}

}
