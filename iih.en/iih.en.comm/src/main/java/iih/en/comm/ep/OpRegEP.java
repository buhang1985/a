package iih.en.comm.ep;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.opreg.d.EnOpRegDO;
import iih.en.pv.opreg.i.IOpregCudService;
import iih.en.pv.opreg.i.IOpregRService;
import iih.en.pv.outpatient.dto.d.RegInfoDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 就诊登记记录EP
 * 
 * @author liubin
 *
 */
public class OpRegEP {
	/**
	 * 获取就诊登记记录
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public EnOpRegDO getOpRegByEntId(String entId)throws BizException{
		if(EnValidator.isEmpty(entId))
			return null;
		@SuppressWarnings("unchecked")
		List<EnOpRegDO> regList = (List<EnOpRegDO>) new DAFacade().findByAttrValString(EnOpRegDO.class, 
				EnOpRegDO.ID_ENT, entId, null);
		if(!EnValidator.isEmpty(regList))
			return regList.get(0);
		return null;
	}
	/**
	 * 保存就诊登记记录
	 * 
	 * @param regInfo
	 * @throws BizException
	 */
	public void saveOpReg(RegInfoDTO regInfo) throws BizException {
		if (regInfo == null)
			return;
		EnOpRegDO reg = this.getOpRegByEntId(regInfo.getId_ent());
		if(reg != null){
			reg.setStatus(DOStatus.UPDATED);
		}else{
			reg = new EnOpRegDO();
			reg.setStatus(DOStatus.NEW);
		}
		reg.setId_ent(regInfo.getId_ent());
		reg.setId_patca(regInfo.getId_patca());
		reg.setId_pripat(regInfo.getId_pripat());
		reg.setId_patcret(regInfo.getId_patcredtp());
		reg.setId_hp(regInfo.getId_hp());
		reg.setNo_hp(regInfo.getNo_hp());
		reg.setFg_fundpay(regInfo.getFg_hpsettle());
		reg.setFg_hp_card(regInfo.getFg_hp_card());
		this.getCudServ().save(new EnOpRegDO[] { reg });
	}
	/**
	 * 修改就诊登记记录
	 * 
	 * @param pv
	 * @param enthp
	 * @throws BizException
	 */
	public void updateOpReg(PatiVisitDO pv, EntHpDO enthp) throws BizException{
		if(pv == null)
			return;
		EnOpRegDO reg = this.getOpRegByEntId(pv.getId_ent());
		if(reg != null){
			reg.setStatus(DOStatus.UPDATED);
		}else{
			reg = new EnOpRegDO();
			reg.setStatus(DOStatus.NEW);
		}
		reg.setId_ent(pv.getId_ent());
		reg.setId_patca(pv.getId_patca());
		reg.setId_pripat(pv.getId_pripat());
		reg.setId_patcret(pv.getId_patcret());
		reg.setId_hp(pv.getId_hp());
		if(enthp != null){
			reg.setNo_hp(enthp.getNo_hp());
			reg.setFg_fundpay(enthp.getFg_fundpay());
			reg.setFg_hp_card(enthp.getFg_hp_card());
		}else{
			reg.setNo_hp(null);
			reg.setFg_fundpay(FBoolean.FALSE);
			reg.setFg_hp_card(FBoolean.FALSE);
		}
		
		this.getCudServ().save(new EnOpRegDO[] { reg });
	}
	/**
	 * 获取就诊登记记录查询服务
	 * 
	 * @return
	 */
	public IOpregRService getRServ(){
		return ServiceFinder.find(IOpregRService.class);
	}
	/**
	 * 获取就诊登记记录命令服务
	 * 
	 * @return
	 */
	public IOpregCudService getCudServ(){
		return ServiceFinder.find(IOpregCudService.class);
	}
}
