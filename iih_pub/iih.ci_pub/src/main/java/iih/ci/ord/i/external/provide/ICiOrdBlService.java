package iih.ci.ord.i.external.provide;

import java.util.List;

import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.prescostdto.d.PrescriptionConstBaseDto;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.external.provide.meta.bl.EnDiInfo4BlDTO;
import iih.ci.ord.i.external.provide.meta.bl.OrdDrugInfo4BlDTO;
import iih.ci.ord.i.external.provide.meta.bl.OrdOperInfo4BlDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.en.pv.entdiprove.d.EntDiProveDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/**
 * 临床对费用提供的对外接口
 * 
 * @author HUMS
 *
 */
public interface ICiOrdBlService {

	/**
	 * 查询诊断集合
	 * 
	 * @param dtStart 开始时间
	 * @param dtEnd 结束时间
	 * @param nameDi 诊断名称
	 * @param codeDi 诊断编码
	 * @param idcdsystp 诊断体系ID
	 * @param iddica 诊断分类ID
	 * @param idorg 集团ID
	 * @param idgrp 组织ID
	 * @return
	 * @throws BizException
	 */
	public abstract DiagDefDO[] getDiagDefDOs(FDateTime dtStart, FDateTime dtEnd, String nameDi, String codeDi,
			String idcdsystp, String iddica, String idorg, String idgrp) throws BizException;

	/**
	 * 查询患者一次就诊医生开立的已签署未作废的诊断明细信息
	 * 
	 * @param id_ent 就诊ID
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public abstract EnDiInfo4BlDTO[] getEnDiInfo4BlDTOs(String id_ent, String... params) throws BizException;

	/**
	 * 查询药品开单信息 <br/>
	 * 1、当入参只有【就诊主键 id_ent】时，查询患者本次就诊下所有有效药品信息
	 * 2、当入参只有【医嘱主键id_ors】时，查询对应医嘱集合下所有药品信息
	 * 3、当入参只有【医嘱服务项目主键id_orsrvs】时，查询服务项目集合下所有药品信息
	 * 
	 * @param id_ent 就诊ID
	 * @param id_ors 医嘱ID数组
	 * @param id_orsrvs 医嘱服务ID数组
	 * @param fg_cancel 为空时查询全部
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public abstract OrdDrugInfo4BlDTO[] getOrdDrugInfo4BlDTOs(String id_ent, String[] id_ors, String[] id_orsrvs,FBoolean fg_cancel,
			String... params) throws BizException;

	/**
	 * 查询手术开单信息 1、当入参只有【就诊主键 id_ent】时，查询患者本次就诊下所有有效手术信息。 2、当入参只有【医嘱主键
	 * id_ors】时，查询对应医嘱集合对应所有手术信息。 3、当入参为多个时，根据入参个数组合以上条件。
	 * 
	 * @param id_ent 就诊ID
	 * @param id_ors 医嘱ID数组
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public abstract OrdOperInfo4BlDTO[] getOrdOperInfo4BlDTOs(String id_ent, String[] id_ors, String... params)
			throws BizException;

	/**
	 * 查询有效医嘱
	 * 
	 * @param id_ent 就诊ID
	 * @param en_code 就诊编码
	 * @param id_ors 医嘱ID数组
	 * @param or_codes 医嘱编码数组
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public abstract CiOrderDO[] getCiOrderDOs4Bl(String id_ent, String en_code, String[] id_ors, String[] or_codes,
			String... params) throws BizException;
	
	/**
	 * 医嘱进行记账
	 * @param ctx
	 * @param id_ors
	 */
	public abstract OrderRstDTO keepAccountOrders(CiEnContextDTO ctx , List<CiOrderDO> orderList);
	/**
	 * 医嘱进行销账
	 * @param ctx
	 * @param orderList
	 * @return
	 */
	public abstract OrderRstDTO refundAccountOrders(CiEnContextDTO ctx , List<CiOrderDO> orderList);
	

	/**
	 * 获取医嘱状态
	 * @param code_entp 就诊类型
	 * @param sd_su_or 医嘱状态
	 * @param sd_su_mp 执行状态
	 * @param fg_stop 停止标志
	 * @return 用于医嘱列表显示的状态
	 */
	public String getOrderStatus(String code_entp, String sd_su_or, String sd_su_mp, FBoolean fg_stop);
	/**
	 * 出院或转科时，杀死或完成持续类医嘱
	 * @param id_ents
	 * @return
	 */
	public OrderRstDTO outerHosKillAlwaysOrders(String[] id_ents) throws BizException;
	/**
	 * 患者按处方收费（ 未计费的医嘱）
	 * 
	 * @param patid 患者id
	 * @param dtSignB 开始时间
	 * @param dtSignE 结束时间
	 * @param code_entp 就诊类型
	 * @param Id_org 就诊机构
	 * @return
	 * @throws BizException
	 */
	public abstract PrescriptionConstBaseDto getPrescriptionConstBaseDto(String patid, FDateTime dtSignB,
			FDateTime dtSignE, String code_entp, String Id_org) throws BizException;
	
	/**
	 * 患者按处方收费（ 未计费的医嘱, 多就诊类型）
	 * 
	 * @param patid 患者id
	 * @param dtSignB 开始时间
	 * @param dtSignE 结束时间
	 * @param code_entps 就诊类型
	 * @param Id_org 就诊机构
	 * @return
	 * @throws BizException
	 */
	public abstract PrescriptionConstBaseDto getPrescriptionConstBaseDto8Entps(String patid, FDateTime dtSignB,
			FDateTime dtSignE, String[] code_entps, String Id_org) throws BizException;
	/**
	 * 医嘱只能审核，获取临床医嘱数据
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public abstract FArrayList getOrdItelliVerify(String[] id_ors) throws BizException;
	/**
	 * 新医保平台下，查询药品开单信息 
	 * 1、当入参只有【就诊主键 id_ent】时，查询患者本次就诊下所有有效药品信息
	 * 2、当入参只有【医嘱主键id_ors】时，查询对应医嘱集合下所有药品信息 
	 * 3、当入参只有【医嘱服务项目主键id_orsrvs】时，查询服务项目集合下所有药品信息
	 * 
	 * @param id_ent 就诊ID
	 * @param id_ors 医嘱ID数组
	 * @param id_orsrvs 医嘱服务ID数组
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public abstract OrdDrugInfo4BlDTO[] getOrdDrugInfo4BlOnNewMedical(String id_ent, String[] id_ors, String[] id_orsrvs)
			throws BizException;
	/**
	 * 根据就诊id查询当前就诊下 未作废 未退费 非药品 的ciorsrv的费用项 的特殊病标识是否有为true的
	 * 
	 * @author yzh
	 * @param iden
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean checkSpecialOrder(String iden) throws BizException;
	/**
	 * 根据就诊ID，查询诊断证明数组
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract EntDiProveDO[] getEntDiProveDOs(String id_ent)throws BizException;
	
	/**
	 * 获取出院转归编码
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public abstract String getIpOutReason(String id_ent) throws BizException;
}