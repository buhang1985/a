package iih.mi.mc.mimcspec.s.bp;

import iih.bd.utils.BdEnvContextUtil;
import iih.mi.mc.mimcspec.d.MiMcSpecDO;
import iih.mi.mc.mimcspec.d.MiMcSpecDrugDO;
import iih.mi.mc.mimcspec.s.bp.qry.FindMiMcSpecDrugQry;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public class FindSpecSrvBP {
	public PagingRtnData<MiMcSpecDrugDO> exec(MiMcSpecDO miMcSpecDO, QryRootNodeDTO qryRootNodeDto,PaginationInfo pg)throws BizException {
		if (miMcSpecDO == null) {
			throw new BizException("医保特殊病诊断不允许为空。");
		}
		PagingRtnData<MiMcSpecDrugDO> result = findSpecSrv(miMcSpecDO, qryRootNodeDto, pg);
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
	private PagingRtnData<MiMcSpecDrugDO> findSpecSrv(MiMcSpecDO miMcSpecDO, QryRootNodeDTO qryRootNodeDto,
			PaginationInfo pg) throws BizException {
		String wherePart = getWherePart(miMcSpecDO, qryRootNodeDto);
		FindMiMcSpecDrugQry sql = new FindMiMcSpecDrugQry(wherePart);
		PagingServiceImpl<MiMcSpecDrugDO> pagingServiceImpl = new PagingServiceImpl<MiMcSpecDrugDO>();
		PagingRtnData<MiMcSpecDrugDO> result = pagingServiceImpl.findByPageInfo(new MiMcSpecDrugDO(), pg,
				sql.getQrySQLStr(), "ID_SRV", sql.getQryParameter(null));
		return result;
	}
	
	/**
	 * 使用医保特殊病诊断和查询方案生成条件语句
	 * 
	 * @param miMcSpecDO
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
	private String getWherePart(MiMcSpecDO miMcSpecDO, QryRootNodeDTO qryRootNodeDto) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String bdModelWherePart = BdEnvContextUtil.processEnvContext(new MiMcSpecDrugDO(), "A1");
		String wherePart = String.format(" AND %s", bdModelWherePart);
		wherePartBuilder.append(wherePart);

		wherePart = String.format(" AND Id_hpspec = '%s'", miMcSpecDO.getId_hpspec());
		wherePartBuilder.append(wherePart);

		wherePart = getWherePart(qryRootNodeDto);
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
	private String getWherePart(QryRootNodeDTO qryRootNodeDto) throws BizException {
		if (qryRootNodeDto == null) {
			return "1 = 1";
		}
		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String wherePart = qrySQLGeneratorService.getQueryStringWithDesc(qryRootNodeDto,
				new MiMcSpecDrugDO().getDODesc());
		return wherePart;
	}

}
