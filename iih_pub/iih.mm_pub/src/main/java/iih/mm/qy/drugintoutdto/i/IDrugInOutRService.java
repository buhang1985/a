package iih.mm.qy.drugintoutdto.i;

import iih.mm.qy.drugintoutdto.d.DrugIntOutDTO;
import iih.mm.qy.drugintoutdto.d.DrugPatDetailDTO;
import iih.mm.qy.drugintoutdto.d.MmWhBatchNumDTO;
import iih.mm.qy.drugintoutdto.d.PatOrderInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**  
 * Function: 药品入出信息查询 <br/>  
 * Date:     2018年10月22日 下午7:11:11 <br/>  
 * @author   zmyang  
 * @version    
 * @since    JDK 1.7.0_80       
 */
public interface IDrugInOutRService {

	/**
	 * 
	 * findByPageInfo:住院分页查询药品使用基本信息 <br/>  
	 * @author zmyang  
	 * @param pg
	 * @param wherePart
	 * @param orderByPart
	 * @return
	 * @throws BizException  
	 * @since JDK 1.7.0_80
	 */
	public abstract PagingRtnData<DrugIntOutDTO> ipFindByPageInfo(PaginationInfo pg, String orderByPart,QryRootNodeDTO qryRootNodeDTO) throws BizException;
	/**
	 * 
	 * findByPageInfo:门诊分页查询药品使用基本信息 <br/>  
	 * @author zmyang  
	 * @param pg
	 * @param wherePart
	 * @param orderByPart
	 * @return
	 * @throws BizException  
	 * @since JDK 1.7.0_80
	 */
	public abstract PagingRtnData<DrugIntOutDTO> opFindByPageInfo(PaginationInfo pg, String orderByPart,QryRootNodeDTO qryRootNodeDTO) throws BizException;
	/**
	 * 
	 * findByPageDrugPatDetailDTO:住院分页患者使用药品汇总信息 <br/>  
	 * @author zmyang  
	 * @param pg
	 * @param wherePart
	 * @param orderByPart
	 * @return
	 * @throws BizException  
	 * @since JDK 1.7.0_80
	 */
	public abstract PagingRtnData<DrugPatDetailDTO> ipFindPagingPatUseDrugDetailByMmId(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO,String orderByPart) throws BizException;
	/**
	 * 
	 * findByPageDrugPatDetailDTO:门诊分页患者使用药品汇总信息 <br/>  
	 * @author zmyang  
	 * @param pg
	 * @param wherePart
	 * @param orderByPart
	 * @return
	 * @throws BizException  
	 * @since JDK 1.7.0_80
	 */
	public abstract PagingRtnData<DrugPatDetailDTO> opFindPagingPatUseDrugDetailByMmId(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO,String orderByPart) throws BizException;
	
	/**
	 * 
	 * getIpPatUseDrugDetail:住院获取患者用药详细信息 <br/>  
	 * @author zmyang  
	 * @param condition
	 * @param orderStr
	 * @param isLazy
	 * @return  
	 * @since JDK 1.7.0_80
	 */
	public abstract DrugPatDetailDTO[] getIpPatUseDrugDetail(String condition, String orderStr, FBoolean isLazy) throws BizException;
	
	/**
	 * 
	 * getOpPatUseDrugDetail:门诊获取患者用药详细信息<br/>  
	 * @author zmyang  
	 * @param condition
	 * @param orderStr
	 * @param isLazy
	 * @return  
	 * @since JDK 1.7.0_80
	 */
	public abstract PatOrderInfoDTO[] getOpPatUseDrugDetail(String condition, String orderStr, FBoolean isLazy) throws BizException;
	
	/**
	 * GetMmWhSummaryData:仓库库存汇总查询（分页） <br/>  
	 * @author zmyang  
	 * @param pg
	 * @param qryRootNodeDTO
	 * @param orderByPart
	 * @return
	 * @throws BizException  
	 * @since JDK 1.7.0_76
	 */
	public abstract PagingRtnData<DrugIntOutDTO> getMmWhSummaryData(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO,String orderByPart) throws BizException;

	/**
	 * GetMmWhBatchDetailData:仓库库存分批次明细查询. <br/>  
	 * @author zmyang  
	 * @param condition
	 * @param orderStr
	 * @param isLazy
	 * @return
	 * @throws BizException  
	 * @since JDK 1.7.0_76
	 */
	public abstract MmWhBatchNumDTO[] getMmWhBatchDetailData(String condition, String orderStr, FBoolean isLazy) throws BizException;
	
	/**
	 * 
	 * findByPageInfo:药库入出存分页查询药品使用基本信息 <br/>  
	 * @author zmyang  
	 * @param pg
	 * @param wherePart
	 * @param orderByPart
	 * @return
	 * @throws BizException  
	 * @since JDK 1.7.0_80
	 */
	public abstract PagingRtnData<DrugIntOutDTO> drugStorageIpFindByPageInfo(PaginationInfo pg, String orderByPart,QryRootNodeDTO qryRootNodeDTO) throws BizException;
	
	/**
	 * 
	 * findByPageDrugPatDetailDTO:药库入出存分页患者使用药品汇总信息 <br/>  
	 * @author zmyang  
	 * @param pg
	 * @param wherePart
	 * @param orderByPart
	 * @return
	 * @throws BizException  
	 * @since JDK 1.7.0_80
	 */
	public abstract PagingRtnData<DrugPatDetailDTO> drugStorageIpFindPagingPatUseDrugDetailByMmId(PaginationInfo pg, QryRootNodeDTO qryRootNodeDTO,String orderByPart) throws BizException;
	
	/**
	 * 
	 * getIpPatUseDrugDetail:药库入出存获取患者用药详细信息 <br/>  
	 * @author zmyang  
	 * @param condition
	 * @param orderStr
	 * @param isLazy
	 * @return  
	 * @since JDK 1.7.0_80
	 */
	public abstract DrugPatDetailDTO[] drugStorageGetIpPatUseDrugDetail(String condition, String orderStr, FBoolean isLazy) throws BizException;
}
  
