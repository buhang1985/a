package iih.pi.dic.patientcategory.s.bp;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import iih.pi.dic.patcatehp.d.PiPatCaHpDO;
import iih.pi.dic.patcatehp.i.IPatcatehpCudService;
import iih.pi.dic.patcatehp.i.IPatcatehpRService;
import iih.pi.dic.patientcategory.d.PiPatCaDO;

/**
 * 患者分类医保计划更新逻辑类
 * @author ly 2017/06/25
 *
 */
public class PatCateHpUpdateBP {

	/**
	 * 更新患者分类医保计划
	 * @param patCa
	 * @throws BizException
	 */
	public void exec(PiPatCaDO patCaDo) throws BizException{
		
		IPatcatehpCudService cudService = ServiceFinder.find(IPatcatehpCudService.class);
		IPatcatehpRService rService = ServiceFinder.find(IPatcatehpRService.class);
		
		PiPatCaHpDO caHpDo = rService.findById(patCaDo.getId_patcahp());
		if(caHpDo == null)
			return;
		
		if(StringUtil.isEmpty(patCaDo.getId_hp())){
			caHpDo.setStatus(DOStatus.DELETED);
			cudService.delete(new PiPatCaHpDO[]{caHpDo});
			return;
		}
		
		//对比是否变化
		if(this.isChanged(patCaDo, caHpDo)){
			caHpDo.setStatus(DOStatus.UPDATED);
			caHpDo.setId_hp(patCaDo.getId_hp());
			caHpDo.setFg_fundpay(patCaDo.getFg_fundpay());
			caHpDo.setId_hpkind(patCaDo.getId_hpkind());
			caHpDo.setFg_hp_card(patCaDo.getFg_hp_card());
			cudService.update(new PiPatCaHpDO[]{caHpDo});
		}
	}
	
	/**
	 * 对比关键字段是否发生变化
	 * @param patCaDo
	 * @param caHpDo
	 * @return
	 */
	private boolean isChanged(PiPatCaDO patCaDo,PiPatCaHpDO caHpDo){
		
		if(StringUtil.compare(patCaDo.getId_hp(),caHpDo.getId_hp()) != 0)
			return true;
		
		if(StringUtil.compare(patCaDo.getId_hpkind(),caHpDo.getId_hpkind()) != 0)
			return true;
		
		if(!this.equal(patCaDo.getFg_fundpay(),caHpDo.getFg_fundpay()))
			return true;
		
		if(!this.equal(patCaDo.getFg_hp_card(),caHpDo.getFg_hp_card()))
			return true;
		
		return false;
	}
	
	/**
	 * 对比FBoolean类型
	 * @param f1
	 * @param f2
	 * @return
	 */
	private boolean equal(FBoolean f1,FBoolean f2){
		
		if(f1 == null && f2 == null)
			return true;
		else if(f1 != null && f2 == null)
			return false;
		else if(f1 == null && f2 != null)
			return false;
		else
			return f1.equals(f2);
	}
}
