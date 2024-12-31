package iih.bd.srv.diagdef.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.cdsys.d.MedCdSystemDO;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.d.desc.DiagDefDODesc;
import iih.bd.srv.diagdef.i.IDiagdefMDORService;
import iih.bd.srv.diagstaca.d.DiagStacaDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据查询方案和分类信息查询疾病诊断分页信息业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindPagingByQCondAndCateBp {

	public PagingRtnData<DiagDefDO> exec(MedCdSystemDO medCdSystemDo, DiagStacaDO diagStacaDo,
			QryRootNodeDTO qryRootNodeDto, PaginationInfo pg) throws BizException {

		String wherePart = GetWherePart(medCdSystemDo, diagStacaDo, qryRootNodeDto);
		PagingRtnData<DiagDefDO> result = FindPagingByWherePart(wherePart, pg);
		return result;
	}

	/**
	 * 获取条件语句
	 * 
	 * @param medCdSystemDo
	 *            诊断标准
	 * @param diagStacaDo
	 *            诊断分类
	 * @param qryRootNodeDto
	 *            查询方案
	 * @return 条件语句
	 * @throws BizException
	 */
	private String GetWherePart(MedCdSystemDO medCdSystemDo, DiagStacaDO diagStacaDo, QryRootNodeDTO qryRootNodeDto)
			throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		String wherePart;
		if (medCdSystemDo != null) {
			wherePart = String.format(" and id_cdsys = '%s'", medCdSystemDo.getId_cdsys());
			wherePartBuilder.append(wherePart);
		}

		if (diagStacaDo != null) {
			wherePart = String.format(" and id_distdca = '%s'", diagStacaDo.getId_distdca());
			wherePartBuilder.append(wherePart);
		}

		wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDto, DiagDefDODesc.CLASS_FULLNAME);
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}

		return wherePartBuilder.toString();
	}

	/**
	 * 根据条件语句查询分页数据
	 * 
	 * @param wherePart
	 *            条件语句
	 * @param pg
	 *            分页信息
	 * @return 分页数据
	 * @throws BizException
	 */
	private PagingRtnData<DiagDefDO> FindPagingByWherePart(String wherePart, PaginationInfo pg) throws BizException {
		String orderStr = "code";

		IDiagdefMDORService diagdefMdoRService = ServiceFinder.find(IDiagdefMDORService.class);
		PagingRtnData<DiagDefDO> result = diagdefMdoRService.findByPageInfo(pg, wherePart, orderStr);
		return result;
	}

}
