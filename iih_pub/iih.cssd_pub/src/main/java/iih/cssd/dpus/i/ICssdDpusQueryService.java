package iih.cssd.dpus.i;

import iih.cssd.dpbd.pkg.d.CssdPkgDO;
import iih.cssd.dpus.dfpapp.d.DfpAppDO;
import iih.cssd.dpus.dto.dfpappdto.d.AppCardSourceDTO;
import iih.cssd.dpus.dto.dfpappdto.d.AppRecordDTO;
import iih.cssd.dpus.dto.dfpappdto.d.DfpAppDetilDTO;
import iih.cssd.dpus.dto.dfpappsend.d.DfpSendSourceDTO;
import iih.cssd.dpus.dto.dfpappsend.d.DfpappSendDTO;
import iih.cssd.dpus.dto.dfpappsend.d.DfpappSendQryDTO;
import iih.cssd.dpus.dto.dfpappsend.d.SendAppDetailDTO;
import iih.cssd.dpus.dto.dfpappsend.d.SendCondDTO;
import iih.cssd.dpus.dto.dfprev.d.DfpRevDTO;
import iih.cssd.dpus.dto.dfprev.d.RevQryDTO;
import iih.cssd.dpus.dto.dfpuse.d.DepPatDTO;
import iih.cssd.dpus.dto.dfpuse.d.DfpUseDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;

public interface ICssdDpusQueryService {

	/**
	 * 获取科室常用请领包类型
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract CssdPkgDO[] getAppPkgFreq() throws BizException;

	/**
	 * 获取请领单数据源
	 * 
	 * @param id_dfp_app
	 * @return
	 */
	public abstract AppCardSourceDTO getDfpAppSource(String id_dfp_app) throws BizException;

	/**
	 * 获取请领单明细
	 * 
	 * @param id_dfp_app
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<DfpAppDetilDTO> getAppDetail(PaginationInfo pg, String[] id_dfp_apps, String[] id_pkgs) throws BizException;

	/**
	 * 获取发放页面请领单列表
	 * 
	 * @param pg
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<DfpAppDO> getDfpApp(PaginationInfo pg, SendCondDTO param) throws BizException;

	/**
	 * 获取发放页面请领单明细
	 * 
	 * @param id_dfp_apps
	 * @return
	 * @throws BizException
	 */
	public abstract SendAppDetailDTO[] getDfpAppItmInfo(String[] id_dfp_apps, FBoolean fg_send) throws BizException;

	/**
	 * 获取消毒包发放数据源
	 * 
	 * @param id_dfp_send
	 * @return
	 * @throws BizException
	 */
	public abstract DfpSendSourceDTO getSendDtlSource(String id_dfp_send) throws BizException;

	/**
	 * 消毒包发放列表查询
	 * 
	 * @param param
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<DfpappSendDTO> getDfpSendViewDTO(DfpappSendQryDTO param, PaginationInfo pg) throws BizException;

	//////////////////////////////////////// 以上代码逻辑审核完成//////////////////////////////////////////

	/**
	 * 消毒包接收明细
	 * 
	 * @param condDto
	 * @return
	 * @throws BizException
	 */
	public DfpRevDTO[] getDfpItmInfo(RevQryDTO condDto) throws BizException;

	/**
	 * 获取请领的消毒包的明细
	 * 
	 * @param dfpUseDTO
	 * @return
	 * @throws BizException
	 */
	public abstract DfpUseDTO[] getUseDfp(DfpUseDTO dfpUseDTO) throws BizException;

	/**
	 * 获取消毒包使用患者列表
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract DepPatDTO getPatInfo() throws BizException;

	/**
	 * 获取请领记录
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract DfpAppDO[] getAppRcdList(AppRecordDTO param) throws BizException;
}
