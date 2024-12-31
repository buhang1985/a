package iih.ci.preop.ems.ris;

import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.preop.ems.base.BasePreOpEmsSaveBP;
import iih.ci.preop.ems.d.EmsRisViewDTO;
import iih.ci.preop.ems.d.b.BasePreOpEmsViewDTO;
import iih.ci.sdk.orctt.CiOrContentUtils;
import iih.ci.sdk.orctt.meta.RisOrContentParam;
import iih.ci.sdk.utils.ObjectUtils;
import iih.ci.tsip.d.CiTsApObsDO;
import iih.ci.tsip.d.CiTsOrSrvSetDO;
import iih.ci.tsip.d.CitsorderAggDO;
import iih.ci.tsip.i.ICitsapobsCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 门诊预住院申请检查保存逻辑
 * @author wangqingzhu
 *
 */
public class EmsRisSaveBP extends BasePreOpEmsSaveBP {

	@Override
	protected void afterSaveTsOrderAggInfo(CiEnContextDTO ctx,CitsorderAggDO aggD,BasePreOpEmsViewDTO emsViewDto) throws BizException {
		CiTsApObsDO ciTsApObsDo=new CiTsApObsDO();
		ciTsApObsDo.setStatus(DOStatus.NEW);
		ciTsApObsDo.setId_tsor(aggD.getParentDO().getId_tsor());
		this.mergeCiTsOrdAppInfo(ciTsApObsDo, emsViewDto);
		ServiceFinder.find(ICitsapobsCudService.class).save(new CiTsApObsDO[]{ciTsApObsDo});
	}
	@Override
	protected void mergeCiTsOrdAppInfo(Object ciTsApInfoDo,BasePreOpEmsViewDTO emsViewDto) throws BizException{
		CiTsApObsDO ciTsApObsDo=(CiTsApObsDO)ciTsApInfoDo;
		EmsRisViewDTO risViewDto=(EmsRisViewDTO)emsViewDto;
		//		ciTsApObsDo.setId_tsapobs();	            //治疗方案检查申请ID	
		//		ciTsApObsDo.setId_tsor();	                //治疗方案医嘱ID
		ciTsApObsDo.setId_pps(risViewDto.getId_pps());//检查目的ID
		ciTsApObsDo.setSd_pps(risViewDto.getSd_pps());//检查目的SD
		ciTsApObsDo.setName_pps(risViewDto.getName_pps());//检查目的
		ciTsApObsDo.setDes_pps(risViewDto.getDes_pps());//检查目的描述
		ciTsApObsDo.setAnnouncements(risViewDto.getAnnouncements());//注意事项
		ciTsApObsDo.setDes_sympsign(risViewDto.getDes_sympsign());//症状和体征
	}

	/**
	 * 医嘱内容拼接
	 * @param tsOrdAggDO
	 * @return
	 * @throws BizException 
	 */
	@Override
	protected CiOrContentDO setOrContentInfo(CitsorderAggDO tsOrdAggDO,BasePreOpEmsViewDTO emsViewDto) throws BizException{
		RisOrContentParam param = new RisOrContentParam();
		param.setName_srv(emsViewDto.getName_srv());
		param.setPri(emsViewDto.getPri());
		param.setIsmuldose(FBoolean.FALSE);
		param.setIsmulexec(FBoolean.FALSE);
		param.setSd_srvtp(emsViewDto.getSd_srvtp());
		param.setQuan_med(emsViewDto.getQuan_med());
		param.setName_unit_med(emsViewDto.getName_unit_med());
		param.setName_freq(emsViewDto.getName_freq());
		param.setDays_or(emsViewDto.getDays_or());
		param.setFg_urgent(FBoolean.FALSE);
		param.setSd_nodispense(emsViewDto.getSd_nodispense());
		if (!ObjectUtils.isEmpty(tsOrdAggDO.getCiTsOrSrvSetDO())) {
			StringBuilder bodyname = new StringBuilder();
			for (Object obj : tsOrdAggDO.getCiTsOrSrvSetDO()) {
				CiTsOrSrvSetDO itemDto = (CiTsOrSrvSetDO) obj;
				//				if (ObjectUtils.isTrue(itemDto.getFg_check())) {
				bodyname.append("、" + itemDto.getName_body());
				//				}
			}
			if (bodyname.length() > 0) {
				param.setStr_body(bodyname.substring(1));
			}
		}
		return CiOrContentUtils.create(param);
	}

}
