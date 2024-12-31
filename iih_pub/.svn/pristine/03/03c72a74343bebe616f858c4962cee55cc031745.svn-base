package iih.ci.mrfp.cimrfpdto.i;

import iih.ci.mrfp.cimrfpdto.d.CiMrFpDTO;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpSugDTO;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpXYDIDTO;
import iih.ci.mrfp.cimrfpdto.d.CiMrFpZYDiDTO;
import iih.ci.mrfp.cimrfpdto.d.CiMrfpIntenCareDTO;
import iih.ci.mrfp.cimrfpdto.d.CimrfpdtoAggDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAException;
import xap.sys.xbd.udi.d.UdidocDO;

public interface ICiMrFpDTOEntRService {
	/**
	 * 获取病案首页信息
	 * 
	 * @param id_ent
	 * @throws BizException
	 */
	public abstract CimrfpdtoAggDTO getCiMrfpAggEntDTOs(String id_ent) throws BizException;

	/**
	 * 保存病案首页正面
	 * 
	 * @param cimrfpdtoAggDTO
	 * @throws BizException
	 */
	public abstract void saveCiMrfpAggEntDTO_positive(CimrfpdtoAggDTO cimrfpdtoAggDTO) throws BizException;

	/**
	 * 保存病案首页正面
	 * 
	 * @param cimrfpdtoAggDTO
	 * @throws BizException
	 */
	public abstract void saveCiMrfpAggEntDTO_reverse(CimrfpdtoAggDTO cimrfpdtoAggDTO) throws BizException;

	/**
	 * 保存病案首页
	 * 
	 * @param cimrfpdtoAggDTO
	 * @throws BizException
	 */
	public abstract void saveCiMrfpAggEntDTO(CimrfpdtoAggDTO cimrfpdtoAggDTO) throws BizException;

	public abstract CiMrFpDTO getMrFpPatDto(String id_ent) throws BizException;

	public abstract CiMrFpZYDiDTO[] getCiMrFpZYDiDTO(String id_ent) throws DAException;

	public abstract CiMrFpXYDIDTO[] getCiMrFpXYDiDTO(String id_ent) throws DAException;

	public abstract CiMrFpSugDTO[] getCiMrFpSugDTO(String id_ent) throws DAException;
	
	public abstract CiMrfpIntenCareDTO[] getCiMrfpIntenCareDTO(String id_ent) throws DAException;
	 /**
     * 从编目表获取病案患者信息
     * @param id_ent
     * @return
     */
    CiMrFpDTO getMrmFpPatDTO4Cata(String id_ent)throws DAException;
    /**
     * 从编目表获取病案中医诊断信息
     * @param id_ent
     * @return
     */
    CiMrFpZYDiDTO[] getCiMrmFpZYDiDTO4Cata(String id_ent)throws DAException;
   /**
    * 从编目表获取病案西医诊断信息
    * @param id_ent
    * @return
    */
    CiMrFpXYDIDTO[] getCiMrmFpXYDiDTO4Cata(String id_ent)throws DAException;
   /**
    * 从编目表获取病案手术信息
    * @param id_ent
    * @return
    */
    CiMrFpSugDTO[] getCiMrmFpSugDTO4Cata(String id_ent)throws DAException;
    /**
     * 从编目表获取病案重症信息
     * @param id_ent
     * @return
     */
    CiMrfpIntenCareDTO[] getCiMrfpIntenCareDTOCata(String id_ent) throws DAException;
	/**
	 * 根据其他域的参照id，获取自定义档案 目的获取扩展字段值
	 * 
	 * @param mapRefId
	 * @return
	 * @throws BizException
	 */
	public abstract FMap2 getMrfpStandardEef(FMap2 mapRefId) throws BizException;

	/**
	 * 查询自定义档案：病案首页入院途径
	 * @return
	 * @throws BizException
	 */
	public abstract UdidocDO[] getUdidocDOOfReferalsrc() throws BizException;
    /**
	 * 获取住院就诊转科流程记录
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public String getTransDeptFlowString(String entId) throws BizException;
	
	/**
	 * 从编目表获取病案患者信息查询方案
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 */
    PagingRtnData<CiMrFpDTO> getCiMrFpPatData(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo,String orgparam)throws BizException;
    
    /**
   	 * 医保上报查询
   	 * @param qryRootNodeDTO
   	 * @param paginationInfo
   	 * @return
   	 */
    PagingRtnData<CiMrFpDTO> getCiMrFpPatDataUpload(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)throws BizException;
    
    /**
	 * 获取医保上传所有患者信息
	 * @return
	 */
	CiMrFpDTO[] getCiMrFpDtos() throws BizException;
	
	/**
	 * 获取所有已结算医保住院患者信息
	 */
	PagingRtnData<CiMrFpDTO> getSettleMeInsuHosPatInfo(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)throws BizException;
	
	/**
	 * 诊断上报无效参数开启时，获取的诊断
	 */
	public CiMrFpXYDIDTO[] getCiMrFpXYDiDTOUselessParam(String id_ent,String[] s) throws DAException;
	
	/**
	 * 诊断上报无效参数开启时，获取病案首页中医诊断
	 */
	public CiMrFpZYDiDTO[] getCiMrFpZYDiDTOUselessParam(String id_ent,String[]sp) throws DAException ;
	
	/**
	 * 诊断上报无效参数开启时，获取病案首页编目中医诊断
	 */
	public CiMrFpXYDIDTO[] getCiMrmFpXYDiDTO4CataUselessParam(String id_ent,String[]sp) throws DAException ;
	
	/**
	 * 诊断上报无效参数开启时，获取病案首页编目中医诊断
	 */
	public CiMrFpZYDiDTO[] getCiMrmFpZYDiDTO4CataUselessParam(String id_ent,String[]sp) throws DAException ;
}
