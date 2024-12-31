package iih.mm.qy.drugintoutdto.i;

import iih.mm.qy.drugintoutdto.d.DrugIntOutDTO;
import iih.mm.qy.drugintoutdto.d.DrugPatDetailDTO;
import iih.mm.qy.drugintoutdto.d.PatOrderInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 门诊、住院药品入出存信息查询
 * @author liuyilin
 *
 */
public interface IOpDrugInOutQueryExtService {

	/**
	 * 查询门诊药品出入存信息
	 * @param pg
	 * @param qryRootNodeDTO
	 * @param orderByPart
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<DrugIntOutDTO> opDrugInOutQuery(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO,String orderByPart) throws BizException;

	/**
	 * 查询门诊药品患者使用记录
	 * @param pg
	 * @param qryRootNodeDTO
	 * @param orderByPart
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<DrugPatDetailDTO> opPatDrugInOutQuery(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO,String orderByPart) throws BizException;

	/**
	 * 查询门诊药品患者明细信息
	 * @param condition
	 * @param orderStr
	 * @param isLazy
	 * @return
	 * @throws BizException
	 */
	public abstract DrugPatDetailDTO[] opOrDrugInOutQuery(String condition, String orderStr, FBoolean isLazy) throws BizException;

	/**
	 * 查询住院药品出入存信息
	 * @param pg
	 * @param qryRootNodeDTO
	 * @param orderByPart
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<DrugIntOutDTO> ipDrugInOutQuery(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO,String orderByPart) throws BizException;

	/**
	 * 查询住院药品患者使用记录
	 * @param pg
	 * @param qryRootNodeDTO
	 * @param orderByPart
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<DrugPatDetailDTO> ipPatDrugInOutQuery(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO,String orderByPart) throws BizException;

	/**
	 * 查询住院药品患者明细信息
	 * @param condition
	 * @param orderStr
	 * @param isLazy
	 * @return
	 * @throws BizException
	 */
	public abstract DrugPatDetailDTO[] ipOrDrugInOutQuery(String condition, String orderStr, FBoolean isLazy) throws BizException;

}
