package iih.mp.ot.i;

import iih.mp.dg.dto.ipdrugmp.d.IpDgDtDTO;
import iih.mp.ot.dto.compensationqry.d.ComPensationQryDTO;
import iih.mp.ot.dto.confirm.d.MpOtCondDTO;
import iih.mp.ot.dto.confirm.d.MpOtFeeParamDTO;
import iih.mp.ot.dto.confirm.d.MpOtOrderInfoDTO;
import iih.mp.ot.dto.confirm.d.MpOtSrvFeePsndocDTO;
import iih.mp.ot.dto.confirm.d.MpOtSrvInfoDTO;
import iih.mp.ot.dto.confirmpatinfo.d.MpOtConfirmPatCondDTO;
import iih.mp.ot.dto.confirmpatinfo.d.MpOtConfirmPatInfoDTO;
import iih.mp.ot.dto.depitm.d.MpOtDeptDTO;
import iih.mp.ot.dto.exerefund.d.CondDTO;
import iih.mp.ot.dto.exerefund.d.RfnOrSrvDTO;
import iih.mp.ot.dto.exerefund.d.RfnOrderDTO;
import iih.mp.ot.dto.phmyqry.d.PhmyCardDTO;
import iih.mp.ot.dto.phmyqry.d.PhmyDgListDTO;
import iih.mp.ot.dto.phmyqry.d.PhmyListDTO;
import iih.mp.ot.dto.phmyqry.d.PhmyOrderDTO;
import iih.mp.ot.dto.phmyqry.d.PhmyPatOrDTO;
import iih.mp.ot.dto.srvprice.d.SrvPriceDTO;
import iih.mp.ot.dto.srvprice.d.SrvPriceResultDTO;
import iih.mp.ot.dto.techcharge.d.TechOrDTO;
import iih.mp.ot.dto.techcharge.d.TechSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 执行域通用医技服务
 * 
 * @author ly
 *
 */
public interface IMpOtQryService {

	/**
	 * 取得医技科室
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtDeptDTO[] getMpOtDepts() throws BizException;

	/**
	 * 取得门诊医技执行确认数据
	 * 
	 * @param cond
	 *            查询条件
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtOrderInfoDTO[] getOpConfirmOrd(MpOtCondDTO cond) throws BizException;

	/**
	 * 取得门诊补录项目数据
	 * 
	 * @param cond
	 *            查询条件
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtOrderInfoDTO[] getOpCompensation(MpOtCondDTO cond) throws BizException;

	/**
	 * 取得门诊补录项目医嘱数据
	 * 
	 * @param cond
	 *            查询条件
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtOrderInfoDTO[] getOpOrderCompensation(MpOtCondDTO cond) throws BizException;

	/**
	 * 取得门诊补录项目数据
	 * 
	 * @param cond
	 *            查询条件
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtSrvInfoDTO[] getOpSrvCompensation(MpOtOrderInfoDTO infoDto) throws BizException;

	/**
	 * 取得住院补录项目数据
	 * 
	 * @param cond
	 *            查询条件
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtSrvInfoDTO[] getIpSrvCompensation(MpOtOrderInfoDTO infoDto) throws BizException;

	/**
	 * 取得门诊补录项目预付费数据
	 * 
	 * @param cond
	 *            查询条件
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtOrderInfoDTO[] getOpRetCompensation(MpOtCondDTO cond) throws BizException;

	/**
	 * 取得住院医技执行确认数据
	 * 
	 * @param cond
	 *            查询条件
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtOrderInfoDTO[] getIpConfirmOrd(MpOtCondDTO cond) throws BizException;

	/**
	 * 取得住院医技可补费医嘱
	 * 
	 * @param cond
	 *            查询条件
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtOrderInfoDTO[] getIpCanCompensateOrd(MpOtCondDTO cond) throws BizException;

	/**
	 * 取得住院医技补费项目数据
	 * 
	 * @param cond
	 *            查询条件
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtOrderInfoDTO[] getIpCompensation(MpOtCondDTO cond) throws BizException;

	/**
	 * 取得住院医技补费项目数据
	 * 
	 * @param cond
	 *            查询条件
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtOrderInfoDTO[] getIpOrderCompensation(MpOtCondDTO cond) throws BizException;

	/**
	 * 取得门诊已确认医技执行数据
	 * 
	 * @param cond
	 *            查询条件
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtOrderInfoDTO[] getOpConfirmedOrd(MpOtCondDTO cond) throws BizException;

	/**
	 * 取得住院已确认医技执行数据
	 * 
	 * @param cond
	 *            查询条件
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtOrderInfoDTO[] getIpConfirmedOrd(MpOtCondDTO cond) throws BizException;

	/**
	 * 获取服务价格
	 * 
	 * @param dto
	 *            参数信息
	 * @return
	 * @throws BizException
	 */
	public abstract SrvPriceResultDTO[] getSrvPrice(SrvPriceDTO[] dtos) throws BizException;

	/**
	 * 医技执行查询
	 * 
	 * @param qryRootNodeDTO
	 * @param pg
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<MpOtOrderInfoDTO> getOtExecOrdPaging(QryRootNodeDTO qryRootNodeDTO, PaginationInfo pg) throws BizException;

	/**
	 * 通过医嘱id查询执行确认服务
	 * 
	 * @param orId
	 * @param codeEntp
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtSrvInfoDTO[] getOrExecSrvInfoByOrId(String orId, String codeEntp) throws BizException;

	/**
	 * 补费时查询服务关联信息 包括：服务价格信息，服务医保目录信息，服务其他信息
	 * 
	 * @param dtos
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtSrvInfoDTO[] getFeeRelatedData(MpOtFeeParamDTO[] dtos) throws BizException;

	/**
	 * 医技补费查询，分页版
	 * 
	 * @param
	 * @return 分页信息
	 * @throws BizException
	 */
	public abstract PagingRtnData<ComPensationQryDTO> getComOrderPaging(PaginationInfo pg, String orderStr, QryRootNodeDTO wherePart) throws BizException;

	/**
	 * 退费医嘱信息查询
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract RfnOrderDTO[] getRfndOrders(CondDTO condDto, String id_pat,FBoolean fg_filter_mp) throws BizException;

	/**
	 * 退费医嘱项目信息查询
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract RfnOrSrvDTO[] getRfndOrSrvs(String id_or) throws BizException;

	/**
	 * 医技统领单查询
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<IpDgDtDTO> queryMedtechIpDgApItms(PaginationInfo pg, QryRootNodeDTO nodeDTO) throws BizException;

	/**
	 * 查询执行确认患者列表信息
	 * 
	 * @param cond
	 *            条件
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtConfirmPatInfoDTO[] getConfirmPatList(MpOtConfirmPatCondDTO cond) throws BizException;

	/**
	 * 查询医技补录患者列表信息
	 * 
	 * @param cond
	 *            条件
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtConfirmPatInfoDTO[] getCompensationPatList(MpOtConfirmPatCondDTO cond) throws BizException;
	/**
	 * 查询医技补录患者列表信息（新）
	 * 
	 * @param cond
	 *            条件
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<MpOtConfirmPatInfoDTO> newGetCompensationPatList(PaginationInfo pg, MpOtConfirmPatCondDTO cond, String orderByPart) throws BizException;

	/**
	 * 取得医保类型
	 * 
	 * @param cond
	 *            条件
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtOrderInfoDTO[] getCompensationHp(MpOtOrderInfoDTO infoDto) throws BizException;

	/**
	 * 发药统计列表查询
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract PhmyListDTO[] getPmhyQryList(PhmyCardDTO param) throws BizException;

	/**
	 * 发药统计物品列表查询
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract PhmyDgListDTO[] getPmhyQryDgList(String id_itm, PhmyCardDTO param) throws BizException;

	/**
	 * 获取发药患者领用明细
	 * 
	 * @param id_mm
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public abstract PhmyPatOrDTO[] getPmhyPatQryDgList(String id_itm, String id_mm,String name_unit, PhmyCardDTO param) throws BizException;

	/**
	 * 获取发药患者领用明细对应的医嘱信息
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public abstract PhmyOrderDTO[] getPmhyOrders(String[] id_ors) throws BizException;

	/**
	 * 获取记账的医嘱信息
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract TechOrDTO[] getTechChargeOrs(String id_pat, String sd_su_bl) throws BizException;

	/**
	 * 获取记账的医嘱项目信息
	 * 
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	public abstract TechSrvDTO[] getTechChargeSrvs(String id_or) throws BizException;

	/**
	 * 取得患者就诊的科室和医生
	 * 
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
    public MpOtOrderInfoDTO[] getDeptAndEmpByIdent(String id_ent) throws BizException;
    
    /**
     *获取医技工作量
     * 
     * @param id_or
     * @return
     * @throws BizException
     */
    public PagingRtnData<MpOtSrvFeePsndocDTO> getMpOtSrvPsndoc(PaginationInfo pg,QryRootNodeDTO nodeDTO) throws BizException;
    
    /**
	 * 发药统计列表查询(新)
	 * 
	 * @param phmyCardDto
	 * @return
	 * @throws BizException
	 */
	public abstract PhmyListDTO[] getPmhyProjectQryList(PhmyCardDTO param) throws BizException;
	
	/**
	 * 发药统计物品列表查询(新)
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract PhmyDgListDTO[] getPhmyDrugQryList(PhmyListDTO[] PhmyListDto, PhmyCardDTO phmyCardDto, QryRootNodeDTO qryRoot) throws BizException;
	
	/**
	 * 发药统计物品明细查询(新)
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract PhmyPatOrDTO[] getPmhyDrugDtQry(PhmyDgListDTO phmyDgList, PhmyCardDTO phmyCardDto) throws BizException;
	
	/**
	 * 门诊毒麻发药汇总查询
	 * @param pg
	 * @param orderByPart
	 * @param qryRootNodeDTO
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<PhmyDgListDTO> getOpFindByPageInfo(PaginationInfo pg, String orderByPart,QryRootNodeDTO qryRootNodeDTO) throws BizException;
	
	/**
	 * 医技补录项目（新）相关费用查询
	 * @param pg
	 * @param ident
	 * @param entp,
	 * @param iddep
	 * @return
	 * @throws BizException
	 */
	public abstract PagingRtnData<MpOtSrvInfoDTO> getRelatFeeList(PaginationInfo pg, String ident, String entp, String iddep) throws BizException;
	
	/**
	 * 拒绝执行   医嘱信息查询
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 * @throws BizException 
	 */
	public abstract MpOtOrderInfoDTO[] GetExecRefuseOrInfo(String dt_begin, String dt_end, String id_pat) throws BizException;

	
	/**
	 * 门诊医嘱服务是否已结算(执行确认时校验使用)
	 * @param orsrvIds
	 * @return
	 * @throws BizException
	 */
	public abstract Integer orsrvHasSettled(String[] orsrvIds) throws BizException;
	
	/**
	 * 住院医技批量执行数据查询
	 * @param cond
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtOrderInfoDTO[] getIpOrderInfoBathNew(MpOtCondDTO cond) throws BizException;
	
	/**
	 * 住院医技批量执行服务信息查询
	 * @param mpord
	 * @return
	 * @throws BizException
	 */
	public abstract MpOtSrvInfoDTO[] getIpOrderSrvInfo(String[] id_or_prs) throws BizException;
}
