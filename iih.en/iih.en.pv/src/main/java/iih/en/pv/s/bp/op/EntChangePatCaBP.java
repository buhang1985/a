package iih.en.pv.s.bp.op;

import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.EntHpEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

/**
 * 门诊换号
 * BL结算时自费换医保调用
 * @author liubin
 *
 */
public class EntChangePatCaBP {
	/**
	 * 门诊换号
	 * 
	 * @param entId 就诊id
	 * @param patCaIdOld 原患者分类
	 * @param priPatIdOld 原价格分类
	 * @param hpIdOld 原医保计划
	 * @param patCaIdNew 新患者分类
	 * @param priPatIdNew 新价格分类
	 * @param entHp 就诊医保计划
	 * @throws BizException
	 */
	public void exec(String entId, String patCaIdOld,
			String priPatIdOld, String hpIdOld, String patCaIdNew,
			String priPatIdNew, EntHpDO entHp) throws BizException {
		this.validate(entId, entHp);
		
		//更新en_ent
		this.updateEnt(entId, patCaIdNew, priPatIdNew, entHp);
		
		//更新en_ent_hp
		this.updateEntHp(entId, hpIdOld, entHp);
	}
	
	private void validate(String entId, EntHpDO entHp) throws BizException{
		if(EnValidator.isEmpty(entId))
			throw new BizException(IEnMsgConst.ERROR_ENTID_NOT_EXIST);
	}
	
	/**
	 * 更新en_ent
	 * 
	 * @param entId
	 * @param patCaIdOld
	 * @param priPatIdOld
	 * @param hpIdOld
	 * @param patCaIdNew
	 * @param priPatIdNew
	 * @param hpIdNew
	 * @throws BizException
	 */
	private void updateEnt(String entId, String patCaIdNew, String priPatIdNew, EntHpDO entHp)throws BizException{
		PvEP ep = new PvEP();
		PatiVisitDO pv = ep.getPvByPK(entId);
		pv.setId_patca(patCaIdNew);
		pv.setId_pripat(priPatIdNew);
		if(entHp != null){
			pv.setId_hp(entHp.getId_hp());
			pv.setCode_hpmedkind(entHp.getCode_hpmedkind());
		}else{
			pv.setId_hp(null);
			pv.setCode_hpmedkind(null);
		}
		pv.setStatus(DOStatus.UPDATED);
		ep.savePv(pv);
	}
	/**
	 * 更新en_ent_hp
	 * 
	 * @param entId
	 * @param hpIdOld
	 * @param entHp
	 * @throws BizException 
	 */
	private void updateEntHp(String entId, String hpIdOld, EntHpDO entHpNew) throws BizException{
		EntHpEP ep = new EntHpEP();
		if(entHpNew == null){
			ep.deleteByEntId(entId);
			return;
		}
		EntHpDO entHp =  ep.getMainEntHp(entId);
		if(entHp == null){
			entHp = entHpNew;
			entHp.setId_ent(entId);
			entHp.setStatus(DOStatus.NEW);
		}else{
			entHp.setStatus(DOStatus.UPDATED);
			entHp.setId_hp(entHpNew.getId_hp());
			entHp.setNo_hp(entHpNew.getNo_hp());
			entHp.setFg_fundpay(entHpNew.getFg_fundpay());
			entHp.setFg_hp_card(entHpNew.getFg_hp_card());
			entHp.setFg_hpspcl(entHpNew.getFg_hpspcl());
			entHp.setId_hpkind(entHpNew.getId_hpkind());
			entHp.setCode_hpkind(entHpNew.getCode_hpkind());
			entHp.setId_hppatca(entHpNew.getId_hppatca());
			entHp.setCode_hppatca(entHpNew.getCode_hppatca());
			entHp.setCode_hparea(entHpNew.getCode_hparea());
		}
		ep.save(new EntHpDO[] { entHp });
	}
}
