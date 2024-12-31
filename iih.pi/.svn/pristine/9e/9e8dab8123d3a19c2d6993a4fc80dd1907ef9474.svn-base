package iih.pi.reg.pat.s.rule;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.fc.tagtp.d.BdTagTpDO;
import iih.bd.fc.tagtp.i.ITagtpRService;
import iih.bl.hp.i.IBlHpQryService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pattag.d.PatTagDO;
import iih.pi.reg.pattag.i.IPattagCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;

/**
 * 患者标签插入后规则
 * @author ly 2019/08/21
 *
 */
public class PatTagInsertRule implements IRule<PatiAggDO> {

	@Override
	public void process(PatiAggDO... paramVarArgs) throws BizException {
		
		for (PatiAggDO aggDO : paramVarArgs) {
			
			PatDO patDO = aggDO.getParentDO();
			if(FBoolean.FALSE.equals(patDO.getFg_dealtag()))
				continue;
			
			// 贫困标签
			this.dealPoorPatTag(patDO);
		}
	}
	
	/**
	 * 贫困标签
	 * @param patDO
	 * @throws BizException
	 */
	private void dealPoorPatTag(PatDO patDO) throws BizException {
		
		if(!IPiDictCodeConst.SD_IDTP_IDENTITY.equals(patDO.getSd_idtp()) || StringUtil.isEmpty(patDO.getId_code()))
			return;
				
		ITagtpRService tagService = ServiceFinder.find(ITagtpRService.class);
		BdTagTpDO[] tagTpDos = tagService.findByAttrValString(BdTagTpDO.SD_TP, IBdFcDictCodeConst.SD_TAGTP_POOR);
		if(ArrayUtil.isEmpty(tagTpDos))
			return;
		BdTagTpDO poorTag = tagTpDos[0];
		
		IBlHpQryService hpService = ServiceFinder.find(IBlHpQryService.class);
		FBoolean fgPoorPat = hpService.checkPiPatPoor(patDO.getId_code());
		
		if(FBoolean.FALSE.equals(fgPoorPat))
			return;
		
		IPattagCudService tagCudService = ServiceFinder.find(IPattagCudService.class);
		
		PatTagDO patPoorTagDO = new PatTagDO();
		patPoorTagDO.setId_pat(patDO.getId_pat());
		patPoorTagDO.setId_org(Context.get().getOrgId());
		patPoorTagDO.setId_grp(Context.get().getGroupId());
		patPoorTagDO.setId_pattagtp(poorTag.getId_tagtp());
		patPoorTagDO.setSd_pattagtp(poorTag.getCode());
		patPoorTagDO.setId_emp_tag(Context.get().getStuffId());
		patPoorTagDO.setDt_tag(new FDateTime());

		tagCudService.insert(new PatTagDO[] { patPoorTagDO });
	}
}
