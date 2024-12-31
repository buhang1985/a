package iih.mi.inst.bizbase.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.desc.HPSrvorcaDODesc;
import iih.bd.pp.hpsrvorca.i.IHpsrvorcaRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * @author dj.zhang
 *
 */
public class FindPagingByQCondBp {

	public PagingRtnData<HPSrvorcaDO> exec(String hpId, QryRootNodeDTO qryRootNodeDto, String orderStr,
			PaginationInfo pg) throws BizException {
		PagingRtnData<HPSrvorcaDO> result = findPagingByQCond(hpId, qryRootNodeDto, orderStr, pg);
		setMiInfo(result);
		return result;
	}

	/**
	 * 
	 * @param id_hp
	 * @param qryRootNodeDTO
	 * @param orderStr
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<HPSrvorcaDO> findPagingByQCond(String hpId, QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException {
		String idRef = getIdRef(hpId);
		String wherePart;
		if (StringUtils.isEmpty(idRef)) {
			wherePart = getWherePart(hpId, qryRootNodeDTO);
		} else {
			wherePart = getWherePart(idRef, qryRootNodeDTO);
		}
		IHpsrvorcaRService hpsrvorcaRService = ServiceFinder.find(IHpsrvorcaRService.class);
		PagingRtnData<HPSrvorcaDO> result = hpsrvorcaRService.findByPageInfo(pg, wherePart, orderStr);
		return result;
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
	 * @param hpId
	 * @param qryRootNodeDTO
	 * @return
	 * @throws BizException
	 */
	private String getWherePart(String hpId, QryRootNodeDTO qryRootNodeDTO) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder();

		String wherePart = String.format("id_hp = '%s'", hpId);
		wherePartBuilder.append(wherePart);

		wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDTO, HPSrvorcaDODesc.CLASS_FULLNAME);
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}
		return wherePartBuilder.toString();
	}

	/**
	 * 设置HIS信息
	 * 
	 * @param result
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void setMiInfo(PagingRtnData<HPSrvorcaDO> result) throws BizException {
		SetMiInfoBp bp = new SetMiInfoBp();
		bp.exec((HPSrvorcaDO[]) result.getPageData().toArray(new HPSrvorcaDO[0]));
	}

}
