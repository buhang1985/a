package iih.bd.srv.diagcate.s.bp;

import org.apache.commons.lang3.StringUtils;

import iih.bd.srv.diagcate.d.DiCateItemDO;
import iih.bd.srv.diagcate.d.DiagCateDO;
import iih.bd.srv.diagcate.i.IDiCateItemDORService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 根据查询方案和疾病诊断分类查询疾病诊断分类下项目业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindPageingByQCondAndCateBp {

	public PagingRtnData<DiCateItemDO> exec(QryRootNodeDTO qryRootNodeDTO, DiagCateDO diagCateDO, PaginationInfo pg)
			throws BizException {
		CheckParams(qryRootNodeDTO, diagCateDO, pg);
		PagingRtnData<DiCateItemDO> result = FindPageingByQCondAndCate(qryRootNodeDTO, diagCateDO, pg);
		return result;
	}

	/**
	 * 检查参数
	 * 
	 * @param qryRootNodeDTO
	 * @param diagCateDO
	 * @param pg
	 * @throws BizException
	 */
	private void CheckParams(QryRootNodeDTO qryRootNodeDTO, DiagCateDO diagCateDO, PaginationInfo pg)
			throws BizException {
		if (diagCateDO == null) {
			throw new BizException("疾病诊断分类不允许为空。");
		}
	}

	/**
	 * 根据查询方案和疾病诊断分类查询疾病诊断分类下项目分页数据
	 * 
	 * @param qryRootNodeDTO
	 * @param diagCateDO
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<DiCateItemDO> FindPageingByQCondAndCate(QryRootNodeDTO qryRootNodeDTO, DiagCateDO diagCateDO,
			PaginationInfo pg) throws BizException {
		String wherePart = GetWherePart(qryRootNodeDTO, diagCateDO);
		PagingRtnData<DiCateItemDO> result = FindPagingData(wherePart, pg);
		return result;
	}

	/**
	 * 使用查询方案和疾病诊断分类生成条件语句
	 * 
	 * @param qryRootNodeDTO
	 * @param diagCateDO
	 * @return
	 * @throws BizException
	 */
	private String GetWherePart(QryRootNodeDTO qryRootNodeDTO, DiagCateDO diagCateDO) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder();

		String wherePart = String.format("id_dica = '%s'", diagCateDO.getId_dica());
		wherePartBuilder.append(wherePart);

		wherePart = GetWherePart(qryRootNodeDTO);
		if (!StringUtils.isEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}
		return wherePartBuilder.toString();
	}

	/**
	 * 根据查询方案生成条件语句
	 * 
	 * @param qryRootNodeDTO
	 * @return
	 * @throws BizException
	 */
	private String GetWherePart(QryRootNodeDTO qryRootNodeDTO) throws BizException {
		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String wherePart = qrySQLGeneratorService.getQueryStringWithDesc(qryRootNodeDTO,
				new DiCateItemDO().getDODesc());
		return wherePart;
	}

	/**
	 * 根据条件语句查询疾病诊断分类下项目分页数据
	 * 
	 * @param wherePart
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<DiCateItemDO> FindPagingData(String wherePart, PaginationInfo pg) throws BizException {
		IDiCateItemDORService diCateItemDORService = ServiceFinder.find(IDiCateItemDORService.class);
		PagingRtnData<DiCateItemDO> result = diCateItemDORService.findByPageInfo(pg, wherePart, "Id_didef");
		return result;
	}

}
