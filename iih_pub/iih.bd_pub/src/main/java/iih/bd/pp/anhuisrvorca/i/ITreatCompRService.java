package iih.bd.pp.anhuisrvorca.i;

import iih.bd.pp.anhuisrvorca.d.TreatCompDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 诊疗项目对照信息查询服务
 * 
 * @author guoyang, hao_wu
 *
 */
public interface ITreatCompRService {

	/**
	 * 诊疗项目对照信息查询服务
	 * 
	 * @return
	 */
	public abstract PagingRtnData<TreatCompDTO> FindCompDataList(QryRootNodeDTO qryRootNodeDto, String hpId,
			PaginationInfo pg) throws BizException;

	/**
	 * 补全医保诊疗项目信息</br>
	 * 选择医保诊疗项目参照后进行补全
	 * 
	 * @param treatCompDTOs
	 * @return
	 * @throws BizException
	 */
	public abstract TreatCompDTO[] CompInsurZlData(TreatCompDTO[] treatCompDTOs) throws BizException;

	/**
	 * 获取所有诊疗对照
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract TreatCompDTO[] FindAllTreatComp(String hpCode) throws BizException;

	/**
	 * 获取超限价诊疗对照分页数据
	 * 
	 * @param pg
	 *            分页信息
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<TreatCompDTO> FindExceedMaxPriZlComp(String hpCode, PaginationInfo pg)
			throws BizException;
}
