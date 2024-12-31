package iih.ci.ord.specanti.i;

import iih.ci.ord.ap.d.CiApSpecAntiRecordDO;
import iih.ci.ord.specanti.d.SpecAntiParamDTO;
import iih.ci.ord.specanti.d.SpecOrderAntiDrugAppDTO;
import iih.ci.ord.specanti.d.SpecOrderAntiDrugDTO;
import iih.ci.ord.specanti.d.SpecantOrderDTO;
import iih.ci.ord.specanti.d.SpecantionApplyDTO;
import iih.ci.ord.speconsqrydto.d.SpeconsQryDTO;
import xap.mw.core.data.BizException;

/**
* 特殊使用级抗菌药物会诊申请数据维护服务
*  by gh 2018年8月10日
*/
public interface ISpecantOrderService {
	/**
	*  根据抗菌药名称查找特殊使用级抗菌药物会诊申请数据 树列表
	*  by gh
	*/	
	public abstract SpecantOrderDTO[] findByDrugName(String patId,String whereParm) throws BizException;
	
	/**
	*  根据抗菌药申请单ID查找申请单明细
	*  by gh
	*/	
	public abstract SpecantionApplyDTO findApplyById(String applyId) throws BizException;
	
	/**
	*  新增申请单数据 组建默认值 根据医嘱ID
	*  by gh
	*/	
	public abstract SpecantionApplyDTO newApply(String id_or) throws BizException;
	
	/**
	*  根据抗菌药名称查找特殊使用级抗菌药物会诊申请数据   左下侧患者列表
	*/	
	public abstract SpecantionApplyDTO[] findByTime(SpeconsQryDTO speconsQryDTO) throws BizException;
	/**
	*  根据抗菌药会诊申请ID   查DTO数据
	*/	
	public abstract SpecantionApplyDTO[] findById(String id_apspecanticons) throws BizException;
	/**
	 * 特殊级抗菌药审批
	 * @param specantionDTO
	 * @return
	 * @throws BizException
	 */
	public abstract Boolean approval(SpecantionApplyDTO specantionDTO) throws BizException;
	
	/**
     * 存在申请单
     * @param id_en
     * @param code_ent
     * @param szId_mm
     * @return -1：该就诊患者，在相应的业务线，没有该特抗药的申请；0：存在特抗药申请单，但流程没有走完；1：存在特抗药申请单，流程走完；
     * @throws BizException
     */
	public abstract Integer hasApprovaled(String id_en,String code_ent, String[] szId_mm) throws BizException;
	
	/**
	 * 获取给定医嘱ID下的所有抗菌药基本信息
	 * @param szId_or
	 * @return
	 * @throws BizException
	 */
	public SpecOrderAntiDrugDTO[] getOrderAntiDrugsInfo(String[] szId_or ) throws BizException;
	
	/**
	 * 获得就诊信息下的所有抗菌药申请信息
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	public SpecOrderAntiDrugAppDTO[] getOrderAntiDrugAppsInfo(String id_en) throws BizException ;
	/**
	 * 特殊级抗菌药判断，判断耀皮是否是特殊级抗菌药，如果是，判断审核走到哪一步了
	 * @return SpecAntiParamDTO[]
	 */
	public SpecAntiParamDTO[] specAntiJudge(SpecAntiParamDTO[] params) throws BizException;
	/**
	 * 碳青霉烯类及替加环素,应用记录表
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public CiApSpecAntiRecordDO[] carbapenemJudge(String[] id_ors) throws BizException;
}