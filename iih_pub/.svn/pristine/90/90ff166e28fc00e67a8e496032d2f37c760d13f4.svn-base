package iih.bl.pay.service.i;

import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blprepayunstdetaildto.d.BlPrepayUnStDetailDTO;
import iih.bl.pay.dto.blprepaydto.d.BlPrepayDTO;
import iih.bl.pay.dto.d.BlBannerDTO;
import iih.bl.pay.dto.d.BlLowerlimitOfArrearsDTO;
import iih.bl.pay.dto.d.BlPayPatItemDTO;
import iih.bl.pay.dto.d.BlPayPmDTO;
import iih.bl.pay.dto.d.DebtinfoDTO;
import iih.bl.pay.dto.d.ETPatInfoDTO;
import iih.bl.pay.dto.d.PatInfoQryDTO;
import iih.bl.pay.dto.d.PipatSrvPkgDTO;
import iih.bl.pay.dto.d.PrepayAccTransDTO;
import iih.bl.st.blstdetaildto.d.BlStDetailDTO;
import iih.en.pv.enfee.d.EnAccountDO;
import iih.pi.acc.account.d.PiPatAccDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;



public interface IBLPayQueService {
	/**
	 * 获得门诊记账主键为ID_CGOEP下到付款信息:就诊领域使用
	 * TODO 已过时，请迁移至新方法：//iih.bl.pay.i.IBlPayOutQryService.getOpRegPayDetailBP()
	 * @param Id_cgoep门诊记账主键为ID_CGOEP
	 * @return 付款信息
	 * @throws BizException
	 */
	@Deprecated  
	public abstract BlPayPmDTO[] getBlPayPmDTOByIdCgOep(String Id_cgoep)  throws BizException;
	
	public abstract BlPayPatItemDTO getBlPayPatItemByQuery(String queryStr,String id_user,String payType) throws BizException;
	
	/**
	 *  获取账户余额等信息， 查询账户余额等信息。
	 * @param queryStr ，当门诊时 其为某个id_pat的值， 当住院时其值为某个id_ent的值
	 * @param payType   患者就诊类型ID
	 * @return
	 * @throws BizException
	 */
	public abstract BlPayPatItemDTO getBlPayPatItemByQur(String queryStr, String payType) throws BizException ;
	
	/**
	 * 通过患者表的主键id_pat得到此患者的预交金转移的dto
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public abstract PrepayAccTransDTO[]  getBalanceByIds(String id_pat)throws BizException;
	
	/**
	 * 通过患者表的主键id_pat和患者的收付款类型sd_paytp来获得此患者的门诊账户对应的预交金数据，即患者的预交金详情
	 * @param id_pat
	 * @param sd_paytp
	 * @return
	 * @throws BizException
	 */
	public abstract BlPrePayPatDO[]  getBlPrePayPatDOsByIds(String id_pat,String sd_paytp)throws BizException;
	
	/**
	 * 通过患者的主键id_pat获得患者的门诊账户do
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public abstract PiPatAccDO  getPiPatAccDOByIdpat(String id_pat)throws BizException;
	
	/**
	 * 通过患者的主键id_pat和患者banner的就诊主键id_ent 来获得患者的住院预交金详情
	 * @param id_pat
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract BlPrePayPatDO[]  getBlPrePayPatDOsByIdpatident(String id_pat,String id_ent)throws BizException;
	
	/**
	 * 通过患者banner传入的id_pat,id_ent 或者患者的本次就诊的住院账户
	 * @param id_ent
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	public abstract EnAccountDO  getEnAccountDOByIdentidpat(String id_ent,String id_pat)throws BizException;
	
	
	/**
	 * 通过前台传入的查询条件获得欠款催缴数据显示所需的dto
	 * @param whereSql
	 * @param orderStr
	 * @param isLazy
	 * @return
	 * @throws BizException
	 */
	public abstract DebtinfoDTO[] findDebtinfoDTOsByQCond(String whereSql, String orderStr, FBoolean isLazy)throws BizException;
	
	/**
	 * 通过患者的主键id_pat来得到患者服务包
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
    public abstract PipatSrvPkgDTO[]  findPiPatSrvPkgDTOByIdpat(String id_pat) throws BizException;
    
    /**
     * 查找所有的BdsrvpkgDTO，优惠包销售节点用
     * @return
     * @throws BizException
     */
    public abstract  PipatSrvPkgDTO[]   getAllPipatSrvPkgDTOs() throws BizException;
    
    /**
     * 获得收据号接口
     * @param Id_emp_inc
     * @param code_incca
     * @return
     */
    public abstract  String   getNextInvoiceNo(String Id_emp_inc, String code_incca) throws BizException;
    
   // public abstract  BdPriPkgItmDO[] findBdpripkgItmDOsById(String id_srv_pkg_itm_comp)throws BizException;
    
    /**
     * 根据Banner输入值查找对应就诊信息
     * */
    public abstract BlBannerDTO[] findBannerDtoInfo(String inputValue,String[] selectCondition) throws BizException;
    /**
     * 铜陵住院预交金节点的患者信息弹窗窗用  查询患者信息接口，参数为从前台界面传过来的查询条件
     * @param strcond
     * @return
     * @throws BizException
     */
    public abstract  PatInfoQryDTO[] findByQueryCondsforPatInfoqry(String strcond) throws BizException;
	/**
	 * 住院预交金节点的患者信息弹窗窗用  查询患者信息接口(分组)
	 * @param pg
	 * @param wherePart
	 * @param orderByPart
	 * @return
	 * @throws BizException
	 */
    public abstract  PagingRtnData<PatInfoQryDTO> findPatInfoByPageInfo(PaginationInfo pg, String wherePart,String orderByPart)throws BizException;
    /**
     * 
     * @Title: findPatsLowerLimitOfArrears   
     * @Description: 批量查询急诊留观患者欠费下限
     * @param: @param etPatInfoDTO
     * @param: @return
     * @param: @throws BizException      
     * @return: BlLowerlimitOfArrearsDTO[] 
     * @author: xy.zhou     
     * @throws
     */
    public abstract BlLowerlimitOfArrearsDTO[] findETPatsLowerLimitOfArrears(ETPatInfoDTO etPatInfoDTO)throws BizException;

    /**
     * 查询患者预交金明细
     * @param id_pat 患者主键
     * @param code_enttp 00门诊 10住院
     * @param Dt_start 开始时间
     * @param Dt_end 结束时间
     * @return 预交金明细
     * @author xuebei
     * @throws BizException
     */
    public abstract BlPrepayDTO[] findPrepayDetail(String id_pat,String code_enttp, String Dt_start, String Dt_end) throws BizException;
   
    /**
     * 查询患者预交金结算明细
     * @param id_paypat 收付款主键
     * @param code_enttp 00门诊 10住院
     * @author xuebei
     * @throws BizException
     */
    public abstract BlStDetailDTO[] findPrepayStDetail(String id_paypat,String code_enttp) throws BizException;
    
    /**
     * 查询患者预交金未结算记账明细
     * @param id_pat 患者ID/就诊ID
     * @param code_enttp 00门诊 10住院
     * @author xuebei
     * @throws BizException
     */
    public abstract BlPrepayUnStDetailDTO[] findPrepayUnStDetail(String id_pat, String code_enttp, String Dt_start, String Dt_end)throws BizException;
    
    /**
     * 查询患者预交金明细
     * @param id_pat 患者主键
     * @param code_enttp 00门诊 10住院
     * @param Dt_start 开始时间
     * @param Dt_end 结束时间
     * @return 预交金明细
     * @author xuebei
     * @throws BizException
     */
	public PagingRtnData<BlPrepayDTO> findPrepayDetailPageInfoDos(FMap map, PaginationInfo pageInfo) throws BizException;

	/**
	 * 查询患者预交金未结算记账明细
	 * 
	 * @param id_pat
	 *            患者ID/就诊ID
	 * @param code_enttp
	 *            00门诊 10住院
	 * @param Dt_start
	 * @param Dt_end
	 * @param Or
	 *            医嘱筛选条件
	 * @param Srv
	 *            服务筛选条件
	 * @param Dt_cg_start
	 *            记账起始时间
	 * @param Dt_cg_end
	 *            记账结束时间
	 * @author xuebei
	 * @throws BizException
	 */
	public PagingRtnData<BlPrepayUnStDetailDTO> findPrepayUnStDetailPageInfoDos(FMap map, PaginationInfo pageInfo) throws BizException;
	
	/**
     * 查询患者预交金结算明细
     * @param id_paypat 收付款主键
     * @param code_enttp 00门诊 10住院
     * @author xuebei
     * @throws BizException
     */
	public PagingRtnData<BlStDetailDTO> findPrepayStDetailPageInfoDos(FMap map, PaginationInfo pageInfo) throws BizException ;
}
