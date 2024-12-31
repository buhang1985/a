package iih.en.er.bp.stayregist;

import iih.bd.res.bed.d.Bdbed;
import iih.en.comm.ep.BedEP;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.UrgStayRegistryDTO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.apt.aptip.d.AptIpDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 急诊留观登记保存校验
 * 
 * @author liubin
 *
 */
public class ValidateSaveUrgStayRegistBP {
	/**
	 * 急诊留观登记保存校验
	 * 
	 * @param urgStayRegistry
	 * @throws BizException
	 */
	public void exec(UrgStayRegistryDTO urgStayRegistry) throws BizException {
		//1.校验入参
		validateParam(urgStayRegistry);
		//2.校验就诊状态
		validateIpStatus(urgStayRegistry);
		//3.校验患者是否被合并
		validatePatCombine(urgStayRegistry);
		//4.校验留观申请单状态
		validateScAptIpStatus(urgStayRegistry);
		//5.校验床位状态
		validateBedStatus(urgStayRegistry);
	}
	/**
	 * 校验入参
	 * 
	 * @param urgStayRegistry
	 * @throws BizException
	 */
	private void validateParam(UrgStayRegistryDTO urgStayRegistry) throws BizException {
		if(urgStayRegistry == null)
			throw new BizException("留观登记保存数据为空！");
		if(EnValidator.isEmpty(urgStayRegistry.getId_pat()))
			throw new BizException("留观登记保存患者不能为空！");
	}
	/**
	 * 校验患者是否被合并
	 * 
	 * @param urgStayRegistry
	 * @throws BizException
	 */
	private void validatePatCombine(UrgStayRegistryDTO urgStayRegistry) throws BizException {
		//已登记患者不用校验
		if(!EnValidator.isEmpty(urgStayRegistry.getId_ent()))
			return;
		PatDO pat = (PatDO) new DAFacade().findByPK(PatDO.class, urgStayRegistry.getId_pat(), new String[]{PatDO.ID_PAT, PatDO.FG_ACTIVE});
		if(FBoolean.FALSE.equals(pat.getFg_active()))
			throw new BizException("该患者已经被合并，不能进行留观登记！");
	}
	/**
	 * 校验就诊状态
	 * 
	 * @param urgStayRegistry
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void validateIpStatus(UrgStayRegistryDTO urgStayRegistry) throws BizException {
		//未登记患者不用校验
		if(EnValidator.isEmpty(urgStayRegistry.getId_ent()))
			return;
		List<InpatientDO> list = (List<InpatientDO>) new DAFacade()
				.findByAttrValString(InpatientDO.class, InpatientDO.ID_ENT,
						urgStayRegistry.getId_ent(), new String[] {
								InpatientDO.ID_ENT, InpatientDO.SD_STATUS });
		if(!list.get(0).getSd_status().equals(urgStayRegistry.getSd_status()))
			throw new BizException("该患者就诊状态发生改变，请刷新后重试！");
	}
	/**
	 * 校验留观申请单状态
	 * 
	 * @param urgStayRegistry
	 * @throws BizException
	 */
	private void validateScAptIpStatus(UrgStayRegistryDTO urgStayRegistry) throws BizException {
		//已登记患者不用校验
		if(!EnValidator.isEmpty(urgStayRegistry.getId_ent()))
			return;
		AptIpDO apt = (AptIpDO) new DAFacade().findByPK(AptIpDO.class, urgStayRegistry.getId_aptip(), new String[]{AptIpDO.ID_APTIP, AptIpDO.FG_CANC, AptIpDO.SD_STATUS});
		if(FBoolean.TRUE.equals(apt.getFg_canc()))
			throw new BizException("该患者留观申请单已经取消，不能进行留观登记！");
	}
	/**
	 * 校验床位状态
	 * 
	 * @param urgStayRegistry
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void validateBedStatus(UrgStayRegistryDTO urgStayRegistry) throws BizException {
		BedEP bedBP = new BedEP();
		if(EnValidator.isEmpty(urgStayRegistry.getId_bed())){
			Bdbed bed = bedBP.getRegistBedbyDep(urgStayRegistry.getId_dep_nuradm(), urgStayRegistry.getSd_sex());
			urgStayRegistry.setId_bed(bed.getId_bed());
			urgStayRegistry.setName_bed(bed.getName());
			return;
		}
		if(EnValidator.isEmpty(urgStayRegistry.getId_ent())){
			FBoolean hasUse = bedBP.hasUsed(urgStayRegistry.getId_bed());
			if(FBoolean.TRUE.equals(hasUse))
				throw new BizException("该床位已经被使用，不能进行留观登记！");
		}else{
			List<InpatientDO> list = (List<InpatientDO>) new DAFacade()
			.findByAttrValString(InpatientDO.class, InpatientDO.ID_ENT,
					urgStayRegistry.getId_ent(), new String[] {
							InpatientDO.ID_BED});
			if(!urgStayRegistry.getId_bed().equals(list.get(0).getId_bed())){
				FBoolean hasUse = bedBP.hasUsed(urgStayRegistry.getId_bed());
				if(FBoolean.TRUE.equals(hasUse))
					throw new BizException("该床位已经被使用，不能进行留观登记！");
			}
		}
		
	}
}
