package iih.bd.srv.diagdef.i;

import iih.bd.bc.cdsys.d.MedCdSystemDO;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.d.DiagdefAggDO;
import iih.bd.srv.diagstaca.d.DiagStacaDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IDiagdefExtService {

	/**
	 * 查询特殊诊断
	 * 
	 * @param id_org
	 * @return
	 * @throws BizException
	 */
	public abstract DiagDefDO[] findDiagdefSpec(String id_org, String sqlWhere) throws BizException;

	/**
	 * 根据主键查询诊断信息</br>
	 * 查询后会补全对照信息中的计算字段
	 * 
	 * @param id_Diagdef
	 * @return
	 * @throws BizException
	 */
	public abstract DiagdefAggDO findById(String id_Diagdef) throws BizException;

	/**
	 * 根据查询方案和分类信息查询疾病诊断分页信息
	 * 
	 * @param medCdSystemDo
	 *            诊断标准
	 * @param diagStacaDo
	 *            诊断分类
	 * @param qryRootNodeDto
	 *            查询方案
	 * @param pg
	 *            分页信息
	 * @return 分页数据
	 * @throws BizException
	 */
	public abstract PagingRtnData<DiagDefDO> FindPagingByQCondAndCate(MedCdSystemDO medCdSystemDo,
			DiagStacaDO diagStacaDo, QryRootNodeDTO qryRootNodeDto, PaginationInfo pg) throws BizException;
}
