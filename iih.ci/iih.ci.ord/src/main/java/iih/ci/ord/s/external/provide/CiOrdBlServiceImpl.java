package iih.ci.ord.s.external.provide;

import java.util.List;

import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bl.params.BlParams;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.prescostdto.d.PrescriptionConstBaseDto;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.external.common.ICIOrdRService;
import iih.ci.ord.i.external.provide.ICiOrdBlService;
import iih.ci.ord.i.external.provide.meta.bl.EnDiInfo4BlDTO;
import iih.ci.ord.i.external.provide.meta.bl.OrdDrugInfo4BlDTO;
import iih.ci.ord.i.external.provide.meta.bl.OrdOperInfo4BlDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.ord.s.bp.getPrescriptionCostDtoBP;
import iih.ci.ord.s.bp.ordforbl.GetUnchargeOrdBP;
import iih.ci.ord.s.external.bp.GetCiOrderDOs4BlBP;
import iih.ci.ord.s.external.bp.GetDiagDefDOsBP;
import iih.ci.ord.s.external.bp.GetEnDiInfo4BlDTOsBP;
import iih.ci.ord.s.external.bp.GetOrdDrugInfo4BlDTOsBP;
import iih.ci.ord.s.external.bp.GetOrdOperInfo4BlDTOsBP;
import iih.ci.ord.s.external.bp.bl.account.KeepAccountOrdersBP;
import iih.ci.ord.s.external.bp.bl.outer.OuterHosKillAlwaysOrdersBP;
import iih.ci.ord.s.external.bp.bl.refund.RefundAccountOrdersBP;
import iih.ci.ord.s.external.provide.bp.bl.CheckSpecialOrderBP;
import iih.ci.ord.s.external.provide.bp.bl.GetEntDiProveDOsBP;
import iih.ci.ord.s.external.provide.bp.bl.GetIPOutReasonBP;
import iih.ci.ord.s.external.provide.bp.bl.GetOrdItelliVerifyBP;
import iih.en.pv.entdiprove.d.EntDiProveDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 临床对费用提供对外接口
 * 
 * @author HUMS
 *
 */
@Service(serviceInterfaces = { ICiOrdBlService.class }, binding = Binding.JSONRPC)
public class CiOrdBlServiceImpl implements ICiOrdBlService {

	/**
	 * 查询诊断
	 */
	@Override
	public DiagDefDO[] getDiagDefDOs(FDateTime dtStart, FDateTime dtEnd, String nameDi, String codeDi, String idcdsystp,
			String iddica, String idorg, String idgrp) throws BizException {
		GetDiagDefDOsBP bp=new GetDiagDefDOsBP();
		return bp.exec(dtStart, dtEnd, nameDi, codeDi, idcdsystp, iddica, idorg, idgrp);
	}
	
	/**
	 * 查询患者一次就诊医生开立的已签署未作废的诊断明细信息
	 * 
	 * @param id_ent 就诊ID
	 * @param params
	 * @return
	 * @throws BizException
	 */
	@Override
	public EnDiInfo4BlDTO[] getEnDiInfo4BlDTOs(String id_ent, String... params) throws BizException {
		GetEnDiInfo4BlDTOsBP bp = new GetEnDiInfo4BlDTOsBP();
		return bp.exec(id_ent, params);
	}

	/**
	 * 查询药品开单信息 
	 * 1、当入参只有【就诊主键 id_ent】时，查询患者本次就诊下所有有效药品信息 
	 * 2、当入参只有【医嘱主键id_ors】时，查询对应医嘱集合下所有药品信息 
	 * 3、当入参只有【医嘱服务项目主键id_orsrvs】时，查询服务项目集合下所有药品信息
	 * 4、当入参为多个时，根据入参个数组合以上条件。
	 * 
	 * @param id_ent 就诊ID
	 * @param id_ors 医嘱ID数组
	 * @param id_orsrvs 医嘱服务ID数组
	 * @param params
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrdDrugInfo4BlDTO[] getOrdDrugInfo4BlDTOs(String id_ent, String[] id_ors, String[] id_orsrvs,FBoolean fg_cancel, String... params)
			throws BizException {
		GetOrdDrugInfo4BlDTOsBP bp = new GetOrdDrugInfo4BlDTOsBP();
		return bp.exec(id_ent, id_ors, id_orsrvs, fg_cancel, params);
	}

	/**
	 * 查询手术开单信息
	 * 1、当入参只有【就诊主键 id_ent】时，查询患者本次就诊下所有有效手术信息。
	 * 2、当入参只有【医嘱主键 id_ors】时，查询对应医嘱集合对应所有手术信息。
	 * 3、当入参为多个时，根据入参个数组合以上条件。
	 * 
	 * @param id_ent 就诊ID
	 * @param id_ors 医嘱ID数组
	 * @param params
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrdOperInfo4BlDTO[] getOrdOperInfo4BlDTOs(String id_ent, String[] id_ors, String... params)
			throws BizException {
		GetOrdOperInfo4BlDTOsBP bp = new GetOrdOperInfo4BlDTOsBP();
		return bp.exec(id_ent, id_ors, params);
	}
	
	/**
	 * 查询有效医嘱
	 * @param id_ent 就诊ID
	 * @param en_code 就诊编码
	 * @param id_ors 医嘱ID数组
	 * @param or_codes 医嘱编码数组
	 * @param params
	 * @return
	 * @throws BizException
	 */
	@Override
	public CiOrderDO[] getCiOrderDOs4Bl(String id_ent, String en_code, String[] id_ors, String[] or_codes, String... params)
			throws BizException {
		GetCiOrderDOs4BlBP bp = new GetCiOrderDOs4BlBP();
		return bp.exec(id_ent, en_code, id_ors, or_codes, params);
	}

	/**
	 * 医嘱记账
	 */
	@Override	
	public OrderRstDTO keepAccountOrders(CiEnContextDTO ctx , List<CiOrderDO> orderList)  {
		
		KeepAccountOrdersBP bp = new KeepAccountOrdersBP();
		return bp.exec(ctx, orderList);
	}
	/**
	 * 医嘱销账
	 */
	@Override
	public OrderRstDTO refundAccountOrders(CiEnContextDTO ctx, List<CiOrderDO> orderList) {
		RefundAccountOrdersBP bp = new RefundAccountOrdersBP();
		return bp.exec(ctx, orderList);
	}

	/**
	 * 获取医嘱状态
	 * @param code_entp 就诊类型
	 * @param sd_su_or 医嘱状态
	 * @param fg_stop 停止标志
	 * @param sd_su_mp 执行状态
	 * @return 用于医嘱列表显示的状态
	 */
	@Override
	public String getOrderStatus(String code_entp, String sd_su_or, String sd_su_mp, FBoolean fg_stop) {
	
		ICIOrdRService ciOrdRService = (ICIOrdRService)ServiceFinder.find(ICIOrdRService.class);
		return ciOrdRService.getOrderStatus(code_entp, sd_su_or, sd_su_mp, fg_stop);
	}
	/**
	 * 出院或转科时，杀死或完成持续类医嘱
	 * @param id_ent
	 * @return
	 */
	@Override
	public OrderRstDTO outerHosKillAlwaysOrders(String[] id_ents) throws BizException{
		OuterHosKillAlwaysOrdersBP bp = new OuterHosKillAlwaysOrdersBP();
		return bp.exec(id_ents);
	}
	/**
	 * 患者按处方收费（ 未计费的医嘱）
	 * 
	 * @param patid
	 *            患者id
	 * @param dtSignB
	 *            开始时间
	 * @param dtSignE
	 *            结束时间
	 * @param code_entp
	 *            就诊类型
	 * @param Id_org
	 *            就诊机构
	 * @return
	 * @throws BizException
	 */
	@Override
	public PrescriptionConstBaseDto getPrescriptionConstBaseDto(String patid, FDateTime dtSignB, FDateTime dtSignE,
			String code_entp, String Id_org) throws BizException {
		if (patid == null || code_entp == null || Id_org == null)
			throw new BizException(" parameter patid or code_entp  or  Id_org is null  ");
		
		PrescriptionConstBaseDto rst = null;
		if(FBoolean.TRUE.equals(BlParams.BLSWICH0001())){
			GetUnchargeOrdBP bp = new GetUnchargeOrdBP();
			rst = bp.exec(patid, dtSignB, dtSignE, new String[]{code_entp});
		}else{
			getPrescriptionCostDtoBP bp = new getPrescriptionCostDtoBP();
			rst = bp.exe2(patid, dtSignB, dtSignE, new String[]{code_entp}, Id_org);
		}
		
		return rst;
	}
	
	/**
	 * 患者按处方收费（ 未计费的医嘱, 多就诊类型）
	 * 
	 * @param patid
	 *            患者id
	 * @param dtSignB
	 *            开始时间
	 * @param dtSignE
	 *            结束时间
	 * @param code_entps
	 *            就诊类型
	 * @param Id_org
	 *            就诊机构
	 * @return
	 * @throws BizException
	 */
	@Override
	public PrescriptionConstBaseDto getPrescriptionConstBaseDto8Entps(String patid, FDateTime dtSignB, FDateTime dtSignE,
			String[] code_entps, String Id_org) throws BizException {
		if (patid == null || code_entps == null || code_entps.length<=0 || Id_org == null)
			throw new BizException(" parameter patid or code_entp  or  Id_org is null  ");
		
		PrescriptionConstBaseDto rst = null;
		if(FBoolean.TRUE.equals(BlParams.BLSWICH0001())){
			GetUnchargeOrdBP bp = new GetUnchargeOrdBP();
			rst = bp.exec(patid, dtSignB, dtSignE, code_entps);
		}else{
			getPrescriptionCostDtoBP bp = new getPrescriptionCostDtoBP();
			rst = bp.exe2(patid, dtSignB, dtSignE, code_entps, Id_org);
		}
		
		return rst;
	}
	
	/**
	 * 医嘱只能审核，获取临床医嘱数据
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	@Override
	public FArrayList getOrdItelliVerify(String[] id_ors) throws BizException {
		GetOrdItelliVerifyBP bp = new GetOrdItelliVerifyBP();
		return bp.exec(id_ors);
	}
	@Override
	public FBoolean checkSpecialOrder(String iden) throws BizException {
		CheckSpecialOrderBP bp = new CheckSpecialOrderBP();
		return bp.exec(iden);
	}
	/**
	 * 新医保平台下，查询药品开单信息 
	 * 1、当入参只有【就诊主键 id_ent】时，查询患者本次就诊下所有有效药品信息 
	 * 2、当入参只有【医嘱主键id_ors】时，查询对应医嘱集合下所有药品信息 
	 * 3、当入参只有【医嘱服务项目主键id_orsrvs】时，查询服务项目集合下所有药品信息
	 * 4、当入参为多个时，根据入参个数组合以上条件。
	 * 
	 * @param id_ent 就诊ID
	 * @param id_ors 医嘱ID数组
	 * @param id_orsrvs 医嘱服务ID数组
	 * @param params
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrdDrugInfo4BlDTO[] getOrdDrugInfo4BlOnNewMedical(String id_ent, String[] id_ors, String[] id_orsrvs)
			throws BizException {
		iih.ci.ord.s.external.provide.bp.bl.GetOrdDrugInfo4BlDTOsBP bp = new iih.ci.ord.s.external.provide.bp.bl.GetOrdDrugInfo4BlDTOsBP();
		return bp.exec(id_ent, id_ors, id_orsrvs);
	}

	/**
	 * 根据患者就诊ID查询诊断证明
	 */
	@Override
	public EntDiProveDO[] getEntDiProveDOs(String id_ent) throws BizException {
		GetEntDiProveDOsBP bp=new GetEntDiProveDOsBP();
		return bp.exec(id_ent);
	}
	
	/**
	 * 获取出院转归编码
	 */
	@Override
	public String getIpOutReason(String id_ent) throws BizException {
		return new GetIPOutReasonBP().exe(id_ent);
	}
}
