package iih.pe.papt.i;

import iih.bd.bc.condition.d.ConditionDO;
import iih.pe.papt.dto.pepsnaptqrydto.d.PePsnAptQryDTO;
import iih.pe.papt.dto.pepsnaptqrydto.d.PePsnAptRegQryDTO;
import iih.pe.papt.dto.pepsnaptsetdto.d.PePsnAptSetDTO;
import iih.pe.pitm.pesrvbcatlog.d.PeSrvCastApplyDO;
import iih.pe.por.pepsnbinfo.d.PePsnBInfoDO;
import iih.pe.pwf.dto.peovallistdto.d.PeOvalListDTO;
import iih.pe.pwf.dto.pereglistdto.d.PeRegListDTO;
import iih.pe.pwf.peregquery.d.PeRegQueryDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IPaptQueryService {

	

	/**
	 * 通过客户姓名，会员卡id，体检流程号查询体检预约名单表
	 * @param name_psn，id_pepsncard，card_pe
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<PePsnAptQryDTO> findPePsnAptQryDTO(PaginationInfo pg, PePsnBInfoDO qry, String orderStr, FBoolean isLazy) throws BizException;
	
	/***
	 * 在已选择套餐列表中列出套餐项目
	 * 
	 */
	public abstract PePsnAptSetDTO[] findPePsnAptSetDTO(String id_pepsnappt ,String id_pesrvsetdef) throws BizException;
	/***
	 * 个人预约（含注册）查询
	 * 
	 */
	public PePsnAptRegQryDTO[] findPePsnAptRegQryDTO(PeRegQueryDO qry) throws BizException;
	
	public PeSrvCastApplyDO[] findPePsnAptLisApply(String id_pepsnappt) throws BizException;
	
	public PagingRtnData<PePsnAptRegQryDTO> findCustomPageInfoList(PaginationInfo pg, String[] sqlParam, String funcode, String orderStr, FBoolean isLazy) throws BizException;
	
	public abstract PagingRtnData<PePsnAptQryDTO> findPePsn(PaginationInfo pg, String[] qry, String orderStr, FBoolean isLazy) throws BizException;
}
