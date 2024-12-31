package iih.pi.reg.pat.s.rule;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.fc.tagtp.d.BdTagTpDO;
import iih.bd.fc.tagtp.i.ITagtpRService;
import iih.bl.hp.i.IBlHpQryService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pattag.d.PatTagDO;
import iih.pi.reg.pattag.d.desc.PatTagDODesc;
import iih.pi.reg.pattag.i.IPattagCudService;
import iih.pi.reg.pattag.i.IPattagRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.ICompareRule;

/**
 * 患者标签更新后规则
 * @author ly 2019/08/21
 *
 */
public class PatTagUpdateRule implements ICompareRule<PatiAggDO>{

	@Override
	public void process(PatiAggDO[] newAggDos, PatiAggDO[] oldAggDos) throws BizException {
		
		for (int i = 0; i < newAggDos.length; i++) {
			
			PatDO newPatDO = newAggDos[i].getParentDO();
			PatDO oldPatDO = oldAggDos[i].getParentDO();
			if(FBoolean.FALSE.equals(newPatDO.getFg_dealtag()))
				continue;
		
			// 贫困标签
			this.dealPoorPatTag(newPatDO, oldPatDO);
		}
	}
	
	/**
	 * 贫困标签
	 * @param newPatDO
	 * @param oldPatDO
	 * @throws BizException
	 */
	private void dealPoorPatTag(PatDO newPatDO,PatDO oldPatDO) throws BizException {
		
		if(!IPiDictCodeConst.SD_IDTP_IDENTITY.equals(newPatDO.getSd_idtp()) || StringUtil.isEmpty(newPatDO.getId_code()))
			return;
		
		if(newPatDO.getId_code().equals(oldPatDO.getId_code()))
			return;
		
		ITagtpRService tagService = ServiceFinder.find(ITagtpRService.class);
		BdTagTpDO[] tagTpDos = tagService.findByAttrValString(BdTagTpDO.SD_TP, IBdFcDictCodeConst.SD_TAGTP_POOR);
		if(ArrayUtil.isEmpty(tagTpDos))
			return;
		BdTagTpDO poorTag = tagTpDos[0];
		
		IBlHpQryService hpService = ServiceFinder.find(IBlHpQryService.class);
		FBoolean fgPoorPat = hpService.checkPiPatPoor(newPatDO.getId_code());
		
		IPattagRService tagRService = ServiceFinder.find(IPattagRService.class);
		IPattagCudService tagCudService = ServiceFinder.find(IPattagCudService.class);
		
		String a0 = PatTagDODesc.TABLE_ALIAS_NAME;
		String whereSql = a0 + ".id_pat = '" + newPatDO.getId_pat() + "' and " + a0 + ".id_pattagtp = '"
				+ poorTag.getId_tagtp() + "' ";
		PatTagDO[] patPoorTagDos = tagRService.find(whereSql, null, FBoolean.FALSE);
		
		if(FBoolean.TRUE.equals(fgPoorPat)){
			if(ArrayUtil.isEmpty(patPoorTagDos)){
				
				PatTagDO patPoorTagDO = new PatTagDO();
				patPoorTagDO.setId_pat(newPatDO.getId_pat());
				patPoorTagDO.setId_org(Context.get().getOrgId());
				patPoorTagDO.setId_grp(Context.get().getGroupId());
				patPoorTagDO.setId_pattagtp(poorTag.getId_tagtp());
				patPoorTagDO.setSd_pattagtp(poorTag.getCode());
				patPoorTagDO.setId_emp_tag(Context.get().getStuffId());
				patPoorTagDO.setDt_tag(new FDateTime());
				
				tagCudService.insert(new PatTagDO[] { patPoorTagDO });
			}
		}else{
			if(!ArrayUtil.isEmpty(patPoorTagDos)){
				tagCudService.delete(patPoorTagDos);
			}
		}
	}
}
