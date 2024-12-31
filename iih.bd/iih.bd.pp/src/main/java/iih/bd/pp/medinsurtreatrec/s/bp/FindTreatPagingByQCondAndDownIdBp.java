package iih.bd.pp.medinsurtreatrec.s.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.medinsurdown.d.MedInsurFileDownRecDO;
import iih.bd.pp.medinsurtreatrec.d.MedInsurTreatRecDO;
import iih.bd.pp.medinsurtreatrec.d.desc.MedInsurTreatRecDODesc;
import iih.bd.pp.medinsurtreatrec.i.IMedinsurtreatrecRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 使用查询方案和文件下载记录查询安徽医保诊疗记录分页数据业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindTreatPagingByQCondAndDownIdBp {

	public PagingRtnData<MedInsurTreatRecDO> exec(QryRootNodeDTO qryRootNodeDto, MedInsurFileDownRecDO fileDownRec,
			String orderPart, PaginationInfo pg) throws BizException {
		if (fileDownRec == null) {
			throw new BizException("下载记录不允许为空。");
		}

		PagingRtnData<MedInsurTreatRecDO> result = FindTreatPagingByQCondAndDownId(qryRootNodeDto, fileDownRec,
				orderPart, pg);
		return result;
	}

	/**
	 * 使用查询方案和文件下载记录查询安徽医保诊疗记录分页数据
	 * 
	 * @param qryRootNodeDto
	 * @param fileDownRec
	 * @param orderPart
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<MedInsurTreatRecDO> FindTreatPagingByQCondAndDownId(QryRootNodeDTO qryRootNodeDto,
			MedInsurFileDownRecDO fileDownRec, String orderPart, PaginationInfo pg) throws BizException {
		String wherePart = GetWherePart(qryRootNodeDto, fileDownRec);
		PagingRtnData<MedInsurTreatRecDO> result = FindPagingDataByWherePart(wherePart, orderPart, pg);
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
			wherePart = SqlUtils.getWherePartByQCond(qryRootNodeDto, MedInsurTreatRecDODesc.CLASS_FULLNAME);
			if (StringUtils.isNotEmpty(wherePart)) {
				wherePartBuilder.append(" and ");
				wherePartBuilder.append(wherePart);
			}
		}
		return wherePartBuilder.toString();
	}

	/**
	 * 使用条件语句查询安徽医保诊疗记录分页数据
	 * 
	 * @param wherePart
	 * @param orderPart
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	private PagingRtnData<MedInsurTreatRecDO> FindPagingDataByWherePart(String wherePart, String orderPart,
			PaginationInfo pg) throws BizException {
		IMedinsurtreatrecRService medinsurtreatrecRService = ServiceFinder.find(IMedinsurtreatrecRService.class);
		PagingRtnData<MedInsurTreatRecDO> result = medinsurtreatrecRService.findByPageInfo(pg, wherePart, orderPart);
		return result;
	}
}
