package iih.bd.pp.srvctrdi.s.bp;

import iih.bd.pp.srvctrdi.d.BdHpSrvCtrDiDO;
import iih.bd.pp.srvctrdi.s.bp.sql.FindSrvCtrDiSql;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 使用查询方案查询分页数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindPagingDataByQCondBp {

	public PagingRtnData<BdHpSrvCtrDiDO> exec(QryRootNodeDTO qryRootNodeDto, PaginationInfo pg) throws BizException {
		String wherePart = GetWherePartByQCond(qryRootNodeDto);
		PagingRtnData<BdHpSrvCtrDiDO> result = FindPagingDataByWherePart(wherePart, pg);
		return result;
	}

	/**
	 * 使用条件语句查询分页信息
	 * 
	 * @param wherePart
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<BdHpSrvCtrDiDO> FindPagingDataByWherePart(String wherePart, PaginationInfo pg)
			throws BizException {
		FindSrvCtrDiSql sql = new FindSrvCtrDiSql(wherePart);

		PagingServiceImpl<BdHpSrvCtrDiDO> pagingServiceImpl = new PagingServiceImpl<BdHpSrvCtrDiDO>();
		PagingRtnData<BdHpSrvCtrDiDO> result = pagingServiceImpl.findByPageInfo(new BdHpSrvCtrDiDO(), pg,
				sql.getQrySQLStr(), "DI_DEF_CODE", sql.getQryParameter(null));
		return result;
	}

	/**
	 * 查询方案生成条件语句
	 * 
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
	private String GetWherePartByQCond(QryRootNodeDTO qryRootNodeDto) throws BizException {
		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String wherePart = qrySQLGeneratorService.getQueryStringWithDesc(qryRootNodeDto,
				new BdHpSrvCtrDiDO().getDODesc());
		return wherePart;
	}

}
