package iih.bl.hp.s.bp;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import iih.bl.hp.hpentcode.d.HpEntCodeDO;
import iih.bl.hp.hpentcode.i.IHpentcodeCudService;
import iih.bl.hp.hpentcode.i.IHpentcodeRService;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpCudService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 医保登记撤销后，删除医保计划 且修改登记流水表有效标志
 * @author liwq
 */
public class DeleteEntHpInfoBp {

	public FBoolean exec(String idEnt) throws BizException {
		// 1.查询医保计划DO
		
		@SuppressWarnings("unchecked")
		List<EntHpDO> entHpDoList = (List<EntHpDO>)new DAFacade().findByAttrValString(EntHpDO.class,"Id_ent", idEnt,null);
		if(entHpDoList == null )
			return FBoolean.FALSE;
		EntHpDO[] entHpDOs = entHpDoList.toArray(new EntHpDO[]{});
		if (ArrayUtils.isEmpty(entHpDOs))
			return FBoolean.FALSE;
		// 2.删除医保计划
		IEnthpCudService entHpCudService = ServiceFinder.find(IEnthpCudService.class);
		entHpCudService.delete(entHpDOs);
		// 3.查询就诊DO 并更新(医保转自费)
		@SuppressWarnings("unchecked")
		List<PiPatCaDO> patCaList = (List<PiPatCaDO>)new DAFacade().findByAttrValString(PiPatCaDO.class, "Fg_def", "Y", null); 
		@SuppressWarnings("unchecked")
		PatiVisitDO patiDO = (PatiVisitDO)new DAFacade().findByPK(PatiVisitDO.class, idEnt);
		
		patiDO.setId_hp(null);
		patiDO.setId_patca(patCaList.get(0).getId_patca());
		patiDO.setCode_hpmedkind(null);
		patiDO.setStatus(DOStatus.UPDATED);
		IPativisitCudService entPatiCudService = ServiceFinder.find(IPativisitCudService.class);
		PatiVisitDO[] dos = entPatiCudService.save(new PatiVisitDO[] { patiDO });
		if (ArrayUtils.isEmpty(dos)) {
			return FBoolean.FALSE;
		}
		// 4.修改医保登记记录表中有效标志为N
		IHpentcodeRService entCodeRService = ServiceFinder.find(IHpentcodeRService.class);
		HpEntCodeDO[] entCodeDOs = entCodeRService.findByAttrValString("Id_ent", idEnt);
		entCodeDOs[0].setFg_active(FBoolean.FALSE);
		entCodeDOs[0].setStatus(DOStatus.UPDATED);
		IHpentcodeCudService codeCudService = ServiceFinder.find(IHpentcodeCudService.class);
		HpEntCodeDO[] enCodeDOs = codeCudService.save(entCodeDOs);
		if (ArrayUtils.isEmpty(enCodeDOs))
			return FBoolean.FALSE;
		return FBoolean.TRUE;
	}
}
