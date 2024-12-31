package iih.bd.pp.anhuisrvorca.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import iih.bd.pp.anhuisrvorca.s.bp.sql.FindDrugCompSql;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 安徽东软医保_查询药品对照业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindDrugCompBp {

	/**
	 * @param qryRootNodeDto
	 * @param hpId
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public PagingRtnData<DrugCompDTO> exec(QryRootNodeDTO qryRootNodeDto, String hpId, PaginationInfo pg)
			throws BizException {
		String wherePart = GetWherePart(qryRootNodeDto);
		String idRef = getIdRef(hpId);
		FindDrugCompSql sql = new FindDrugCompSql(idRef,hpId, wherePart);
		PagingServiceImpl<DrugCompDTO> pagingServiceImpl = new PagingServiceImpl<DrugCompDTO>();
		PagingRtnData<DrugCompDTO> pagingRtnData = pagingServiceImpl.findByPageInfo(new DrugCompDTO(), pg,
				sql.getQrySQLStr(), "SRV.NAME,UDIDOC_DOSAGE.NAME DESC", sql.getQryParameter(null));

		return pagingRtnData;
	}

	/**
	 * @param hpId
	 * @return
	 * @throws BizException 
	 */
	private String getIdRef(String hpId) throws BizException {
		IHpMDORService iHpMDORService = ServiceFinder.find(IHpMDORService.class);
		HPDO hpdo = iHpMDORService.findById(hpId);
		return hpdo.getId_refhp();
	}

	/**
	 * 查询方案生成条件语句
	 * 
	 * @param qryRootNodeDto
	 * @return
	 * @throws BizException
	 */
	private String GetWherePart(QryRootNodeDTO qryRootNodeDto) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		IQrySQLGeneratorService qrySQLGeneratorService = ServiceFinder.find(IQrySQLGeneratorService.class);
		String wherePart = qrySQLGeneratorService.getQueryStringWithoutDesc(qryRootNodeDto);
		if (!StringUtils.isEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		return wherePartBuilder.toString();
	}
}
