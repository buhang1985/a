package iih.en.pv.s.bp.op;

import iih.en.comm.bp.PatQryBP;
import iih.en.comm.ep.EntHpEP;
import iih.en.comm.ep.OpRegEP;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.en.pv.pativisit.i.IPativisitRService;
import iih.pi.reg.pat.d.PatDO;
import iih.sc.apt.dto.d.OpAptDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 修改就诊患者BP
 * @author yankan
 *
 */
public class ChgAptEnPatBP {
	/**
	 * 修改就诊的患者信息
	 * @param opAptDTO 预约信息
	 * @param patDO 患者信息
	 * @throws BizException
	 */
	public String changeAptEnPat(OpAptDTO opAptDTO,PatDO patDO) throws BizException{
		EnValidator.validateParam("门诊预约信息", opAptDTO);
		EnValidator.validateParam("患者信息", patDO);
		
		RegInfoDTO regInfo = AptParser.aptToRegDTO(opAptDTO);
		//1、修改就诊信息
		PatiVisitDO pvDO = this.updatePvInfo(regInfo, patDO);	
		
		//2、插入医保计划
		EntHpEP hpBP =new EntHpEP();
		hpBP.deleteByEntId(regInfo.getId_ent());
		hpBP.saveEntHp(regInfo);
		
		//3、插入就诊队列
		if(EnParamUtils.getAptNeedCfm()){			
			JoinOpQueBP joinQueBP = new JoinOpQueBP();
			joinQueBP.exec(pvDO, regInfo);
		}
		//4.保存en_ent_op_reg
		new OpRegEP().saveOpReg(regInfo);
		
		return pvDO.getId_ent();
	}
	/**
	 * 更新就诊信息
	 * @param entId 就诊ID
	 * @param hpId 主医保计划
	 * @param patDO 患者DO
	 * @throws BizException
	 */
	private PatiVisitDO updatePvInfo(RegInfoDTO regInfo,PatDO patDO) throws BizException{
		IPativisitRService pvRService = ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO pvDO = pvRService.findById(regInfo.getId_ent());
		if(pvDO==null){
			throw new BizException("就诊信息不存在");
		}
		//1、修改就诊信息
		pvDO.setId_pat(patDO.getId_pat());//患者id
		pvDO.setName_pat(patDO.getName());//姓名
		pvDO.setId_sex_pat(patDO.getId_sex());//性别
		pvDO.setSd_sex_pat(patDO.getSd_sex());
		pvDO.setId_mari_pat(patDO.getId_marry());
		pvDO.setSd_mari_pat(patDO.getSd_marry());//婚姻状况
		pvDO.setDt_birth_pat(patDO.getDt_birth());//出生日期
		pvDO.setTelno_pat(EnValidator.isEmpty(patDO.getMob()) ? patDO.getTel() :patDO.getMob()) ;//联系方式
		PatQryBP patQryBP = new PatQryBP();
		pvDO.setAddr_pat(patQryBP.getPresentAddress(patDO.getId_pat()));
		pvDO.setId_hp(regInfo.getId_hp());
		pvDO.setId_patca(regInfo.getId_patca());//患者分类
		pvDO.setId_pripat(regInfo.getId_pripat());//患者价格分类
		pvDO.setId_patcret(regInfo.getId_patcredtp());//信用分类
		pvDO.setFg_data_transf(FBoolean.FALSE);//不可转移
		pvDO.setStatus(DOStatus.UPDATED);
		
		IPativisitCudService pvCudService = ServiceFinder.find(IPativisitCudService.class);
		pvCudService.save(new PatiVisitDO[]{pvDO});	
		
		return pvDO;
	}
}
