package iih.ci.mrqc.qapatlist.i;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import iih.ci.mrqc.qapatlist.d.QaPatListDTO;

public interface IQaProcessQryService{
	public abstract PagingRtnData<QaPatListDTO> getQaPatListDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo,String qaVer) throws BizException;
	public abstract PagingRtnData<QaPatListDTO> getDeptQcPatListDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo,String qaVer) throws BizException;
	public abstract PagingRtnData<QaPatListDTO> getDeptQcScorePatListDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	public abstract PagingRtnData<QaPatListDTO> getTerminalQcSignOffPatListDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	public abstract PagingRtnData<QaPatListDTO> getTerminalQcPatListDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo,String qaVer) throws BizException;
	public abstract PagingRtnData<QaPatListDTO> getTerminalRandomQcPatListDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo,String qaVer) throws BizException;
	public abstract PagingRtnData<QaPatListDTO> getTerminalQcScorePatListDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	/**
	 * 住院环节质控抽查
	 * @param qryDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<QaPatListDTO> getInterQaPatListRandomDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo,String qaVer) throws BizException;	
	/**
	 * 内涵质控患者列表
	 * @param qryRootNodeDTO
	 * @param paginationInfo
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<QaPatListDTO> getConnonationQcPatListDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	
	public abstract PagingRtnData<QaPatListDTO> getDeptRandomQcPatListDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo,String qaVer) throws BizException;
	
	public abstract PagingRtnData<QaPatListDTO> GetConnonationQcPatListDTOList(QryRootNodeDTO qryRootNodeDTO,PaginationInfo paginationInfo) throws BizException;
	
	
}