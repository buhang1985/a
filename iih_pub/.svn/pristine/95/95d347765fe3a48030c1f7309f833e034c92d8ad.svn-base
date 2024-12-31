package iih.bl.cg.service;

import java.util.Map;

import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgquery.Service.d.CreateBlcgqueryDTO;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgzyquerydto.d.BlCgZyQueryDTO;
import iih.bl.cg.blrecgoepdto.d.BlRecgOepDTO;
import iih.bl.cg.dto.d.BlCgAmtDTO;
import iih.bl.cg.dto.d.BlCgItmVsBiPritpDTO;
import iih.bl.cg.dto.d.BlCgPriceAndAmtDTO;
import iih.bl.cg.dto.d.BlcgDto;
import iih.bl.cg.dto.d.EntPatInfoDTO;
import iih.bl.cg.dto.d.OepfeeitmqryDTO;
import iih.bl.cg.dto.d.SrvVsInvoiceTypeDTO;
import iih.bl.cg.service.d.BlCgIpAmtAndUncgRationDTO;
import iih.bl.inc.blincquerydto.d.BlIncItmVsTypeDTO;
import iih.bl.pay.dto.d.BlBannerDTO;
import iih.bl.st.dto.d.BlIpAuditFeeDTO;
import iih.bl.st.dto.d.BlPrinterSetDTO;
import iih.en.pv.enfee.dto.d.PatiFixedFeeLeftDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAException;

/**
 * 记帐额外服务（查询统计类）
 */
public interface IBlcgqueryService {
	
	/**
	 * 查询处方是否缴费（只要一个服务缴费即代表整个处方缴费）
	 * @param id_OrArr 医嘱列
	 * @return Map<String,FBoolean> <id_or,是否缴费(FBoolean.TRUE:缴费;FBoolean.FALSE:未缴费)>
	 * @throws BizException
	 * @author tcy
	 */
	public abstract Map<String,FBoolean> querySettlementByIdPres_Oep(String[] id_presArr) throws BizException ;

	/**
	 * 查询医嘱是否缴费（只要一个服务缴费即代表整个医嘱缴费）
	 * @param id_OrArr 医嘱ID_OR列
	 * @return Map<String,FBoolean> <id_or,是否缴费(FBoolean.TRUE:缴费;FBoolean.FALSE:未缴费)>
	 * @throws BizException
	 * @author tcy
	 */
	public abstract Map<String,FBoolean> querySettlementByIdOr_Oep(String[] id_OrArr) throws BizException;

	
	/**
	 * 根据就诊，返回该就诊下的费用明细及其对应的收费方式
	 * @param id_ent 就诊ID
	 * @param code_enttp 就诊类型CODE
	 * @return 该就诊下的费用明细及其对应的收费方式
	 * @throws BizException
	 * @author tcy
	 */
	public abstract BlCgItmVsBiPritpDTO[] getBlCgItmVsBiPritpDTO(String id_ent,String code_enttp) throws BizException ;

	/**
	 * 取得就诊的记帐金额和付款方式
	 */
	public abstract BlcgDto getAmountAndPayMode(String entId) throws BizException;
	//public BlCgDO[] blcgFindByQCond(QryRootNodeDTO qryRootNodeDTO,String orderStr,FBoolean isLazy) throws BizException;
	
	public abstract CreateBlcgqueryDTO blcgFindByQCond(QryRootNodeDTO qryRootNodeDTO,
			String orderStr, FBoolean isLazy) throws BizException;
	
	public abstract CreateBlcgqueryDTO[] BlcgFindByQCond(String wheresql,
			String orderStr, FBoolean isLazy) throws BizException;
	
	
    public  abstract    FBoolean     savePrinterSetInfo(BlPrinterSetDTO viewDto) throws BizException ;
    
    public  abstract   BlPrinterSetDTO  findBlPrinterSetDtoInfo(String printerType) throws BizException  ;
	
	/**
	 *住院费用清单节点的新表头绑定数据用接口
	 * @param wheresql
	 * @param orderStr
	 * @param isLazy
	 * @return
	 * @throws BizException
	 */
	public abstract BlCgZyQueryDTO[] BlCgZyFindByQCond(String wheresql,String orderStr, FBoolean isLazy) throws BizException;//新表头接口
	
	public abstract CreateBlcgqueryDTO[] find(String whereStr,String orderStr,FBoolean isLazy) throws BizException;
	
	
	/**
	 * 重写findByQCond()方法，从查询模版中获取到查询条件，传到后台来查询数据，用于门诊收费项目查询节点显示数据
	 * @param wheresql
	 * @param orderStr
	 * @param isLazy
	 * @return
	 */
	public abstract  OepfeeitmqryDTO[] findByQueryCondsforOepfeeitmqry(String[] conds)throws BizException;
	

	/**
	 * 根据就诊号获取住院记账信息
	 * */
	public abstract BlCgIpDO[] findBlCgIpInfoByIdEnt(String id_ent) throws BizException;
//	
//	/**
//	 * 根据医嘱号获取住院记账信息
//	 * */
//	public BlCgIpDO[] findBlCgIpInfoByIdor(String id_or) throws BizException;

	/**
	 * 根据医嘱号获取门诊记账信息(按明细显示，非汇总）
	 * */
	public abstract BlCgItmOepDO[] findBlCgOepInfoByIdor(String id_or) throws BizException;
	
	/**
	 * 根据医嘱号查询该医嘱下的门诊费用明细(按汇总显示）
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	public BlCgItmOepDO[] findBlCgOepInfoByIdor_aggregate(String id_or) throws BizException ;


	/**
	 * 根据就诊ID获取门诊记账信息
	 * */
	public abstract BlCgItmOepDO[] findBlCgOepInfoByIdent(String id_ent) throws BizException;
	/**
	 * 根据病人ID和就诊ID，获得可消费余额，账户余额，已消费总额，特定服务分类占比
	 * @param id_pat 病人ID
	 * @param id_ent 就诊ID
	 * @param Code_srvca 服务项目分类，如果查药占比，则传“01”
	 * @return DTO:可消费余额，账户余额，已消费总额，特定服务分类占比	 
	 * @throws BizException
	 * @author tcy 
	 */
	public abstract BlCgIpAmtAndUncgRationDTO GetBlcgIpAmtVsDrugRation(String id_pat,String id_ent,String code_srvca) throws BizException;	
	/**
	 * 根据就诊和就诊类型，查询该就诊下发生的费用
	 * @param id_ent 就诊ID
	 * @param code_entp 就诊类型
	 * @return
	 * @throws BizException
	 * @author tcy 
	 */	
	public abstract BlCgAmtDTO GetBlCgAmtByIdEnt(String id_ent,String code_entp)  throws BizException;

	/**
	 * 从门诊费用明细表中获得该处方的所有费用信息
	 * @param id_pat 病人ID
	 * @param id_presarr 处方数组
	 * @return
	 * @throws BizException
	 * @author tcy 
	 */
	public abstract BlCgPriceAndAmtDTO[] getBlCgPriceAndAmtDTOFromIdPres(String id_pat,String[] id_presarr)   throws BizException;
	
	/**
	 * 从费用角度判断，是否可以分诊：
	 * 医嘱已交费，可以分诊；医嘱未交费，预交金余额任免支付，可以分诊；医嘱未交费，预交金余额不足，信用额度足够，可以分诊
	 * @param id_orArr 医嘱id_or
	 * @return 
	 * @throws BizException
	 */
	public abstract FMap fSupportTriage_CiOrderFee(String[] id_orArr)   throws BizException;
	
//	/**
//	 * 返回指定结算号所有服务对应的发票分类SrvVsInvoiceTypeDTO
//	 * @param code_incca 票据类型代码
//	 * @param id_stoeps sql中in格式的，例如   '11','23'
//	 * @return
//	 * @throws BizException
//	 */
//	public abstract SrvVsInvoiceTypeDTO[] GetInvocieTypeByStOepId(String code_incca,String id_stoeps) throws BizException;

	/**
	 * 返回指定结算号所有服务对应的发票分类SrvVsInvoiceTypeDTO
	 * @param id_stoeps sql中in格式的，例如   '11','23'
	 * @return
	 * @throws BizException
	 */
	public abstract SrvVsInvoiceTypeDTO[] GetInvocieTypeByStOepId(String id_stoeps) throws BizException;

	
	/**
	 * 根据患者id_pat查询门诊未结算Fg_st='N'就诊信息
	 * */
	public abstract BlRecgOepDTO[] findBlCgOepInfoByIdpat(String id_pat,String pat_code,String id_grp,String id_org) throws BizException;

	/**
	 * 根据部门Id查询患者就诊信息
	 * */
	public abstract EntPatInfoDTO[] findEntPatInfoByDept(String id_dept) throws BizException;
	
	/**
	 * 根据条件查询患者就诊信息
	 * */
	public abstract EntPatInfoDTO[] findEntPatInfoByCondition(String id_dept, String keyCond, String condition) throws BizException;
	
	
	/**
	 * 根据条件查询会诊患者就诊信息
	 * */
	public abstract EntPatInfoDTO[] findEntConPatInfoByCondition(String id_dept, String keyCond, String condition) throws BizException;
	
	
	/**
	 * Banner中查询患者就诊信息（住院补/退费）
	 * */
	public abstract BlBannerDTO[] findStMendBannerDtoInfo(String inputValue, String[] selectCondition) throws BizException;
	
	/**
	 * 通过患者的住院病区主键id查询当前病区在院患者列表
	 * @param id_dep_nuradm
	 * @author li_pengying
	 * @return
	 * @throws BizException
	 */
	public   PatiFixedFeeLeftDTO[] getPatientListInfo(String id_dep_nuradm) throws BizException;
	
	/**
	 *  通过患者的住院病区主键id、患者姓名、患者床号等字段值查询当前病区在院患者列表
	 * @param id_dep
	 * @param key
	 * @param value
	 * @return
	 * @throws BizException
	 */
	public  PatiFixedFeeLeftDTO[]	getPatientListInfoByQueryCondition(String id_dep,String key,String value ) throws BizException;
	
	/**
	 * 查询获得某次住院就诊id_ent的住院记账明细
	 * @param id_ent
	 * @author li_pengying
	 * @return
	 * @throws BizException
	 */
	 public BlCgIpDO[]  findBlCgIpDOsByIdent(String id_ent) throws BizException;

	 /**
	  * 保存护士冲账数据
	  * @param blcgipDos
	  * @author li_pengying
	  * @param ident
	  * @return
	  * @throws BizException
	  */
	public BlCgIpDO[] saveNurseTuifee(BlCgIpDO[] blcgipDos,String ident) throws BizException;
	
	/**
	 * 根据门诊发票主键获取其对应结算的所有发票信息
	 * @param strIdInc
	 * @return
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] getStIncInfoDtoByIncId(String strIdInc) throws BizException;
	
	/**
	 * 根据门诊发票主键获取其对应结算的所有发票详细信息
	 * @param strIdInc
	 * @return
	 * @throws BizException
	 */
	public BlIncItmVsTypeDTO[] getIncOepInfoDtoByIncId(String strIdInc) throws BizException;
	
	/**
	 * 住院费用清单展示 根据查询模板条件查询
	 * @param strKey  查询参数条件    FMap2 参数值
	 * @return
	 * @throws BizException
	 * @author liwq
	 */
	public BlIpAuditFeeDTO[] getIpFeeInfo(FMap2 queryMap) throws BizException;
	
	/**
	 * 留观费用清单 费用明细查询
	 * @param querySchema  查询参数
	 * @return
	 * @throws BizException
	 * @author xuebei
	 */
	public BlIpAuditFeeDTO[] getEtFeeInfo(FMap2 queryMap) throws BizException ;
	
	/**
	 * 获取某服务项目对应的记账明细(分页)
	 * @param BlIpAuditFeeDTO  合计项dto
	 * @param PaginationInfo
	 * @author liwq
	 * @throws DAException
	 */
	public PagingRtnData<BlIpAuditFeeDTO> getIpCgFeeDetail(BlIpAuditFeeDTO feeDto, PaginationInfo pageInfo) throws BizException;
	
	/**
	 * 获取急诊留观某服务项目对应的记账明细(分页)
	 * @param BlIpAuditFeeDTO  合计项dto
	 * @param PaginationInfo
	 * @author xuebei
	 * @throws DAException
	 */
	public PagingRtnData<BlIpAuditFeeDTO> getEtCgFeeDetail(BlIpAuditFeeDTO feeDto,FMap2 map, PaginationInfo pageInfo) throws BizException;
}
