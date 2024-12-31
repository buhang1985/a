package iih.en.pv.s.bp.ip;

import iih.en.comm.ep.EntDeptEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enres.d.EnDepDO;
import iih.en.pv.inpatient.d.InpatientDO;
import iih.en.pv.inpatient.dto.d.EntForMedRecDTO;
import iih.en.pv.inpatient.i.IInpatientRService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.i.IPiPatContDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 为病案首页查询就诊信息
 * @author yank
 *
 */
public class GetEntInfoForMrBP {
	/**
	 * 获取就诊信息
	 * @param entId 就诊id
	 * @return
	 * @throws BizException
	 */
	public EntForMedRecDTO exec(String entId) throws BizException{
		EntForMedRecDTO en4MrDTO = new EntForMedRecDTO();
		IPativisitRService pvService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO pvDO = pvService.findById(entId);
		if(pvDO==null){
			throw new BizException("就诊记录不存在！");
		}
		en4MrDTO.setId_ent(entId);
		en4MrDTO.setId_pat(pvDO.getId_pat());
		en4MrDTO.setName_pat(pvDO.getName_pat());
		en4MrDTO.setDt_birth(pvDO.getDt_birth_pat());//出生日期
		en4MrDTO.setSex_pat(pvDO.getSd_sex_pat());//性别
		en4MrDTO.setSd_mari_pat(pvDO.getSd_mari_pat());//婚姻状况
		en4MrDTO.setTel(pvDO.getTelno_pat());//联系方式
		
		//住院信息
		IInpatientRService ipService = ServiceFinder.find(IInpatientRService.class);
		String whereStr = String.format("id_ent='%s'",entId);
		InpatientDO[] ipDOs = ipService.find(whereStr, null, FBoolean.FALSE);
		if(!EnValidator.isEmpty(ipDOs)){
			InpatientDO ipDO = ipDOs[0];
			
			//联系人
			en4MrDTO.setCont_name(ipDO.getCont_name());//联系人姓名
			en4MrDTO.setCont_tel(ipDO.getCont_tel());//联系人电话
			IPiPatContDORService patContRService = ServiceFinder.find(IPiPatContDORService.class);
			PiPatContDO patContDO = patContRService.findById(ipDO.getId_patcont());
			if(patContDO!=null){
				//en4MrDTO.set
				en4MrDTO.setSd_referalsrc(patContDO.getConttp_name());//类型名称
				en4MrDTO.setCont_address(patContDO.getContaddr());//联系人地址
				en4MrDTO.setCont_tel(patContDO.getConttel());//联系方式
				en4MrDTO.setId_conttp(patContDO.getId_conttp());//联系人类型
				en4MrDTO.setSd_conttp(patContDO.getSd_conttp());
			}
			
			en4MrDTO.setSd_referalsrc(ipDO.getSd_referalsrc());//入院方式
			en4MrDTO.setDt_acpt(pvDO.getDt_acpt());//入院时间
			en4MrDTO.setId_dep_phyadm(ipDO.getId_dep_phyadm());//入院科室
			en4MrDTO.setId_dep_nuradm(ipDO.getId_dep_nuradm());//入院病区
			
			//转科科室
			EntDeptEP resBP = new EntDeptEP();			
			EnDepDO transDepDO = resBP.getTransDept(entId);
			if(transDepDO!=null){
				en4MrDTO.setId_dep_trans(transDepDO.getId_dep());
			}			
			
			en4MrDTO.setId_dep_phydisc(ipDO.getId_dep_phydisc());//出院科室
			en4MrDTO.setId_dep_nurdisc(ipDO.getId_dep_nurdisc());//出院病区
			en4MrDTO.setDt_end(pvDO.getDt_end());//出院时间
			int days = 0;
			if(pvDO.getDt_acpt()!=null && pvDO.getDt_end()!=null){
				days = FDateTime.getDaysBetween(pvDO.getDt_acpt(), pvDO.getDt_end());
				days=days+1;
			}
			en4MrDTO.setHosdays(days);//住院天数
		}		
		
		return en4MrDTO;
	}
}
