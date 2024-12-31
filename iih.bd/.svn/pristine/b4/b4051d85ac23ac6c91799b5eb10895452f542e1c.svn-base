package iih.bd.pp.bdhpspec.s.bp;

import iih.bd.pp.bdhpspec.d.BdHpSpecDO;
import iih.bd.pp.bdhpspec.d.BdHpSpecDrugDO;
import iih.bd.pp.bdhpspec.s.bp.sql.FindBdHpSpecDrugSql;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 获取医保特殊病诊断可开医保项目分页数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindMedicalCareSrvBp {

	public PagingRtnData<BdHpSpecDrugDO> exec(BdHpSpecDO bdHpSpecDo, QryRootNodeDTO qryRootNodeDto, PaginationInfo pg)
			throws BizException {
		if (bdHpSpecDo == null) {
			throw new BizException("医保特殊病诊断不允许为空。");
		}
		PagingRtnData<BdHpSpecDrugDO> result = FindMedicalCareSrv(bdHpSpecDo, qryRootNodeDto, pg);
		return result;
	}

	/**
	 * 获取医保特殊病诊断可开医保项目分页数据
	 * 
	 * @param bdHpSpecDo
	 * @param qryRootNodeDto
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<BdHpSpecDrugDO> FindMedicalCareSrv(BdHpSpecDO bdHpSpecDo, QryRootNodeDTO qryRootNodeDto,
			PaginationInfo pg) throws BizException {
		String wherePart = GetWherePart(bdHpSpecDo, qryRootNodeDto);
		FindBdHpSpecDrugSql sql = new FindBdHpSpecDrugSql(wherePart);
		PagingServiceImpl<BdHpSpecDrugDO> pagingServiceImpl = new PagingServiceImpl<BdHpSpecDrugDO>();
		PagingRtnData<BdHpSpecDrugDO> result = pagingServiceImpl.findByPageInfo(new BdHpSpecDrugDO(), pg,
				sql.getQrySQLStr(), "CODE_HP", sql.getQryParameter(null));
		return result;
	}

	/**
	 * 使用医保特殊病诊断和查询方案生成条件语句
	 * 
	 * @param bdHpSpecDo
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
	private String GetWherePart(BdHpSpecDO bdHpSpecDo, QryRootNodeDTO qryRootNodeDto) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String bdModelWherePart = BdEnvContextUtil.processEnvContext(new BdHpSpecDrugDO(), "A1");
		String wherePart = String.format(" AND %s", bdModelWherePart);
		wherePartBuilder.append(wherePart);

		wherePart = String.format(" AND Id_hpspec = '%s'", bdHpSpecDo.getId_hpspec());
		wherePartBuilder.append(wherePart);

		wherePart = GetWherePart(qryRootNodeDto);
		wherePart = String.format(" AND %s", wherePart);
		wherePartBuilder.append(wherePart);

		return wherePartBuilder.toString();
	}

	/**
	 * 使用查询方案生成条件片段
	 * 
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
	private String GetWherePart(QryRootNodeDTO qryRootNodeDto) throws BizException {
		if (qryRootNodeDto == null) {
			return "1 = 1";
		}
		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String wherePart = qrySQLGeneratorService.getQueryStringWithDesc(qryRootNodeDto,
				new BdHpSpecDrugDO().getDODesc());
		return wherePart;
	}

}
