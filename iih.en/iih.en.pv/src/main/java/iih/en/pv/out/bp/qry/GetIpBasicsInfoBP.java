package iih.en.pv.out.bp.qry;

import iih.en.comm.ep.IpEP;
import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.IpBasicDTO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 批量查询患者基本信息
 * 
 * @author jizb
 *
 */
public class GetIpBasicsInfoBP {

	/**
	 * 批量查询患者基本信息
	 * 
	 * @param idEnts
	 * @return
	 * @throws BizException
	 */
	public IpBasicDTO[] exec(String[] idEnts) throws BizException {
		if (EnValidator.isEmpty(idEnts)) {
			return null;
		}
		List<IpBasicDTO> ipBasics = this.getEntInfos(idEnts);
		if (EnValidator.isEmpty(ipBasics)) {
			return null;
		}
		this.getIpPatients(idEnts, ipBasics);
		return ipBasics.toArray(new IpBasicDTO[]{});
		
		
	}
	
	/**
	 * 查找就诊表中的信息
	 * 
	 * @param idEnts
	 * @param ipBasics
	 * @return
	 * @throws BizException
	 */
	private List<IpBasicDTO> getEntInfos(String[] idEnts) throws BizException {
		IPativisitRService patvisitService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO[] pativisitDOs = patvisitService.findByIds(idEnts, FBoolean.FALSE);
		if (EnValidator.isEmpty(pativisitDOs)) {
			return null;
		}
		List<IpBasicDTO> ipBasics = new ArrayList<>();
		for (PatiVisitDO patiVisit : pativisitDOs) {
			if (patiVisit == null) {
				continue;
			}
			IpBasicDTO ipBasic = new IpBasicDTO();
			ipBasic.setId_ent(patiVisit.getId_ent());
			ipBasic.setId_pat(patiVisit.getId_pat());
			ipBasic.setName_pat(patiVisit.getName_pat());
			ipBasic.setDt_entry(patiVisit.getDt_entry());//入院登记时间
			ipBasic.setDt_acpt(patiVisit.getDt_acpt());
			ipBasic.setId_dep_phy(patiVisit.getId_dep_phy());
			ipBasic.setId_dep_nur(patiVisit.getId_dep_nur());
			ipBasic.setName_dep_phy(patiVisit.getName_dep_phy());
			ipBasic.setName_dep_nur(patiVisit.getName_dep_nur());
			ipBasic.setName_sex(patiVisit.getName_sex());
			//if (!EnValidator.isEmpty(patiVisit.getDt_birth_pat().toString())) 
			//	ipBasic.setAge_pat(AgeCalcUtil.getAge(patiVisit.getDt_birth_pat()));
			ipBasic.setId_pat(patiVisit.getId_pat());
			ipBasic.setDt_end(patiVisit.getDt_end());
			ipBasic.setFg_ip(patiVisit.getFg_ip());
			ipBasic.setId_hp(patiVisit.getId_hp());//医保计划
			ipBasic.setId_patca(patiVisit.getId_patca());
			ipBasic.setCode_patca(patiVisit.getSd_patca());
			ipBasic.setName_patca(patiVisit.getName_patca());
	        ipBasics.add(ipBasic);
		}
		EnAgeCalcUtil.setDoAges(ipBasics.toArray(new IpBasicDTO[]{}), "Id_ent", "Age_pat");
		return ipBasics;
	}
	
	/**
	 * 查询住院表信息
	 * 
	 * @param idEnts
	 * @param ipBasics
	 * @throws BizException 
	 */
	private void getIpPatients(String[] idEnts, List<IpBasicDTO> ipBasics) throws BizException {
		IpEP ep = new IpEP();
		InpatientDO[] inpatientDOs = ep.getInpatientDOs(Arrays.asList(idEnts));
		if (EnValidator.isEmpty(inpatientDOs)) {
			return;
		}
		for (InpatientDO inpatientDO : inpatientDOs) {
			for (IpBasicDTO ipBasic : ipBasics) {
				if (inpatientDO.getId_ent().equals(ipBasic.getId_ent())) {
					ipBasic.setId_bed(inpatientDO.getId_bed());
					ipBasic.setName_bed(inpatientDO.getName_bed());
					ipBasic.setCode_amr_ip(inpatientDO.getCode_amr_ip());
					ipBasic.setSd_status(inpatientDO.getSd_status());
					ipBasic.setTimes_ip(inpatientDO.getTimes_ip());//住院次数
				}
			}
		}
	}
}
