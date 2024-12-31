package iih.en.pv.s.bp.op;

import iih.en.comm.bp.PatQryBP;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.d.EuRegTp;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.apt.dto.d.OpAptDTO;
import xap.mw.core.data.BizException;

/**
 * 预约转换器
 * @author yank
 *
 */
public class AptParser {
	/**
	 * 门诊预约DTO转为挂号DTO
	 * @param aptDTO
	 * @return
	 * @throws BizException 
	 */
	public static RegInfoDTO aptToRegDTO(OpAptDTO aptDTO) throws BizException{
		RegInfoDTO regInfo = new RegInfoDTO();
		regInfo.setId_pat(aptDTO.getId_pat());
		regInfo.setId_patca(aptDTO.getId_patca());
		regInfo.setId_pripat(aptDTO.getId_pripat());
		regInfo.setId_patcredtp(aptDTO.getId_patcret());
		PatQryBP patQryBP = new PatQryBP();
		PatDO patDO= patQryBP.getPat(aptDTO.getId_pat());
		if(patDO!=null){
			if(EnValidator.isEmpty(regInfo.getId_patca()))
				regInfo.setId_patca(patDO.getId_paticate());
			if(EnValidator.isEmpty(regInfo.getId_pripat()))
				regInfo.setId_pripat(patDO.getId_patpritp());
			if(EnValidator.isEmpty(regInfo.getId_patcredtp()))
				regInfo.setId_patcredtp(patDO.getId_patcrettp());
		}
		regInfo.setId_hpkind(aptDTO.getId_hpkind());
		regInfo.setCode_hpkind(aptDTO.getCode_hpkind());
		regInfo.setCode_hppatca(aptDTO.getCode_hppatca());
		regInfo.setId_dayslot(aptDTO.getId_dayslot());//日期分组
		regInfo.setId_apt(aptDTO.getId_apt());
		regInfo.setId_ent(aptDTO.getId_ent()); //就诊ID
		regInfo.setId_pat(aptDTO.getId_pat());//患者id
		regInfo.setRegisted_date(aptDTO.getDt_b().getDate());//预约日期
		regInfo.setId_dayslot(aptDTO.getId_dayslot());//日期分组
		regInfo.setId_hp(aptDTO.getId_hp());//主医保计划
		regInfo.setNo_hp(aptDTO.getNo_hp());//主医保计划卡号
		regInfo.setId_hp_as(aptDTO.getId_hp_as());//辅医保计划
		regInfo.setNo_hp_as(aptDTO.getNo_hp_as());//辅医保计划卡号
		regInfo.setFg_hp_card(aptDTO.getFg_hp_card());
		regInfo.setFg_hpsettle(aptDTO.getFg_hpsettle());
		regInfo.setFg_settlebycard(aptDTO.getFg_settlebycard());
		regInfo.setRegresarray(aptDTO.getRegresarray());//挂号资源
		regInfo.setId_sch(aptDTO.getId_sch());//排班
		regInfo.setId_ticks(aptDTO.getId_ticks());//号段
		regInfo.setId_tick(aptDTO.getId_tick());//号位
		regInfo.setTickno(aptDTO.getQueno());//票号
		regInfo.setId_emp_entry(EnContextUtils.getPsnId()); //当前操作员ID，对应之后取号时的“门诊票据人员信息”
		regInfo.setPricedinfo(aptDTO.getPricedinfo());//划价信息
		regInfo.setCode_hpmedkind(aptDTO.getCode_hpmedkind());//医保诊疗类型
		regInfo.setId_cg(aptDTO.getId_cg());//记账编号
		if(aptDTO.getEu_regtp() != null)
			regInfo.setEu_regtp(aptDTO.getEu_regtp());//来源于预约
		else
			regInfo.setEu_regtp(EuRegTp.APT);//来源于预约
		
		return regInfo;		
	}
}
