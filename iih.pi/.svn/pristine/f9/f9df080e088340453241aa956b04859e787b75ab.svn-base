package iih.pi.dic.patientcategory.s.bp;

import iih.pi.dic.patcatehp.d.PiPatCaHpDO;
import iih.pi.dic.patcatehp.i.IPatcatehpCudService;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 患者分类医保计划插入逻辑类
 * @author ly 2017/06/25
 *
 */
public class PatCateHpInsertBP {

	/**
	 * 插入患者分类医保计划
	 * @param patCa
	 * @throws BizException
	 */
	public void exec(PiPatCaDO patCaDo) throws BizException{
		
		if(StringUtil.isEmpty(patCaDo.getId_hp()))
			return;
		
		PiPatCaHpDO caHpDo = new PiPatCaHpDO();
		caHpDo.setStatus(DOStatus.NEW);
		
		caHpDo.setId_org(Context.get().getOrgId());
		caHpDo.setId_grp(Context.get().getGroupId());
		caHpDo.setId_patca(patCaDo.getId_patca());
		caHpDo.setId_hp(patCaDo.getId_hp());
		caHpDo.setFg_fundpay(patCaDo.getFg_fundpay());
		caHpDo.setId_hpkind(patCaDo.getId_hpkind());
		caHpDo.setFg_hp_card(patCaDo.getFg_hp_card());
		caHpDo.setFg_hp_spcl(FBoolean.FALSE);
		
		IPatcatehpCudService service = ServiceFinder.find(IPatcatehpCudService.class);
		service.insert(new PiPatCaHpDO[]{caHpDo});
	}
}
