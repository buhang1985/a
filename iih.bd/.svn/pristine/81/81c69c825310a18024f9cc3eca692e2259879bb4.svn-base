package iih.bd.pp.medinsurdrugrec.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.medinsurdown.d.MedInsurFileDownRecDO;
import iih.bd.pp.medinsurdrugrec.d.MedInsurDrugRecDO;
import iih.bd.pp.medinsurdrugrec.d.desc.MedInsurDrugRecDODesc;
import iih.bd.pp.medinsurdrugrec.i.IMedinsurdrugrecRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 使用查询方案和文件下载记录查询安徽医保药品记录分页数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindDrugPagingByQCondAndDownIdBp {
	public PagingRtnData<MedInsurDrugRecDO> exec(QryRootNodeDTO qryRootNodeDto, MedInsurFileDownRecDO fileDownRec,
			String orderPart, PaginationInfo pg) throws BizException {
		if (fileDownRec == null) {
			throw new BizException("下载记录不允许为空。");
		}

		PagingRtnData<MedInsurDrugRecDO> result = FindTreatPagingByQCondAndDownId(qryRootNodeDto, fileDownRec,
				orderPart, pg);
		return result;
	}

	/**
	 * 使用查询方案和文件下载记录查询安徽医保药品记录分页数据
	 * 
	 * @param qryRootNodeDto
	 * @param fileDownRec
	 * @param orderPart
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<MedInsurDrugRecDO> FindTreatPagingByQCondAndDownId(QryRootNodeDTO qryRootNodeDto,
			MedInsurFileDownRecDO fileDownRec, String orderPart, PaginationInfo pg) throws BizException {
		String wherePart = GetWherePart(qryRootNodeDto, fileDownRec);
		PagingRtnData<MedInsurDrugRecDO> result = FindPagingDataByWherePart(wherePart, orderPart, pg);
		return result;
	}

	/**
	 * 构建条件语句
	 * 
	 * @param qryRootNodeDto
	 * @param fileDownRec
	 * @return
	 * @throws BizException
	 */
	private String GetWherePart(QryRootNodeDTO qryRootNodeDto, MedInsurFileDownRecDO fileDownRec) throws BizException {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String wherePart;
		if (fileDownRec != null) {
			wherePart = String.format(" and id_down = '%s'", fileDownRec.getId_down());
			wherePartBuilder.append(wherePart);
		}

		if (qryRootNodeDto != null) {
			wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDto, MedInsurDrugRecDODesc.CLASS_FULLNAME);
			if (StringUtils.isNotEmpty(wherePart)) {
				wherePartBuilder.append(" and ");
				wherePartBuilder.append(wherePart);
			}
		}
		return wherePartBuilder.toString();
	}

	/**
	 * 使用条件语句查询安徽医保药品记录分页数据
	 * 
	 * @param wherePart
	 * @param orderPart
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<MedInsurDrugRecDO> FindPagingDataByWherePart(String wherePart, String orderPart,
			PaginationInfo pg) throws BizException {
		IMedinsurdrugrecRService medinsurdrugrecRService = ServiceFinder.find(IMedinsurdrugrecRService.class);
		PagingRtnData<MedInsurDrugRecDO> result = medinsurdrugrecRService.findByPageInfo(pg, wherePart, orderPart);
		return result;
	}
}
