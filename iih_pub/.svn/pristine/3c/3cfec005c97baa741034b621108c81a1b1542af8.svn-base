package iih.bd.pp.anhuisrvorca.i;

import iih.bd.pp.anhuisrvorca.d.FwssCompDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 服务设施对照信息查询服务
 * 
 * @author guoyang, hao_wu
 *
 */
public interface IFwssCompRService {

	/**
	 * 查询服务设施对照信息
	 * 
	 * @param qryRootNodeDto
	 *            查询方案数据
	 * @param pg
	 *            分页信息
	 * @return 服务设施对照信息
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<FwssCompDTO> FindCompDataList(QryRootNodeDTO qryRootNodeDto, String hpCode,
			PaginationInfo pg) throws BizException;

	/**
	 * 补全医保服务设施信息</br>
	 * 选择医保服务设施参照后进行补全
	 * 
	 * @param fwssCompDTOs
	 * @return
	 * @throws BizException
	 */
	public abstract FwssCompDTO[] CompInsurFwssData(FwssCompDTO[] fwssCompDTOs) throws BizException;

	/**
	 * 获取所有服务设施对照
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract FwssCompDTO[] FindAllFwssComp(String hpCode) throws BizException;
}
