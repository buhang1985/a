package iih.bd.pp.medinsurtreatrec.i;

import iih.bd.pp.medinsurdown.d.MedInsurFileDownRecDO;
import iih.bd.pp.medinsurtreatrec.d.MedInsurTreatRecDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 安徽医保诊疗记录扩展查询服务接口
 * 
 * @author hao_wu
 *
 */
public interface IMedinsurtreatrecExtRService {
	/**
	 * 使用查询方案和文件下载记录查询安徽医保诊疗记录分页数据
	 * 
	 * @param qryRootNodeDto
	 *            查询方案
	 * @param fileDownRec
	 *            文件下载记录
	 * @param orderPart
	 *            排序语句
	 * @param pg
	 *            分页信息
	 * @return 安徽医保诊疗记录分页数据
	 * @throws BizException
	 */
	public abstract PagingRtnData<MedInsurTreatRecDO> FindPagingByQCondAndDownId(QryRootNodeDTO qryRootNodeDto,
			MedInsurFileDownRecDO fileDownRec, String orderPart, PaginationInfo pg) throws BizException;
}
