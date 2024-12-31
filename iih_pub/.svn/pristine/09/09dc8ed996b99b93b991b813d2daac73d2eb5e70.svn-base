package iih.bd.pp.anhuisrvorca.i;

import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 医保药品对照信息查询服务
 * 
 * @author guoyang, hao_wu
 *
 */
public interface IDrugCompRService {
	/**
	 * 查询药品对照信息
	 * 
	 * @param qryRootNodeDto
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<DrugCompDTO> FindCompDataList(QryRootNodeDTO qryRootNodeDto, String hpId,
			PaginationInfo pg) throws BizException;

	/**
	 * 补全医保药品信息</br>
	 * 选择医保药品参照后进行补全
	 * 
	 * @param drugCompDTOs
	 * @return
	 * @throws BizException
	 */
	public abstract DrugCompDTO[] CompInsurDrugData(DrugCompDTO[] drugCompDTOs) throws BizException;
	
	/**
	 * 补全医保药品信息（药品对诊疗）</br>
	 * 选择医保药品参照后进行补全
	 * 
	 * @param drugCompDTOs
	 * @return
	 * @throws BizException
	 */
	public abstract DrugCompDTO[] CompInsurDrugTreatData(DrugCompDTO[] drugCompDTOs) throws BizException;

	/**
	 * 获取所有药品对照
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract DrugCompDTO[] FindAllDrugComp(String hpCode) throws BizException;

	/**
	 * 获取超限价对照信息
	 * 
	 * @param pg
	 * @return
	 */
	public abstract PagingRtnData<DrugCompDTO> FindExceedMaxPriComp(String hpCode, PaginationInfo pg)
			throws BizException;
}
