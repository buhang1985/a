package iih.en.pv.out.bp.qry;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.en.comm.ep.ErPreEP;
import iih.en.comm.ep.UdiDocEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnFMapUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.pre.d.EnErPreDO;
import iih.pi.banner.d.PatientBannerDTO;

import java.util.Map;

import xap.mw.core.data.BizException;
import xap.sys.xbd.udi.d.UdidocDO;
/**
 * 患者banner处理预检信息
 * 
 * @author liubin
 *
 */
public class HandlePiBannerErPreInfoBP {
	/**
	 * 患者banner处理预检信息
	 * 
	 * @param banners
	 * @throws BizException
	 */
	public void exec(PatientBannerDTO[] banners) throws BizException {
		if(EnValidator.isEmpty(banners))
			return;
		String[] erPreIds = EnAppUtils.getKeyPropArrayFromDO("Id_erpre", banners);
		if(EnValidator.isEmpty(erPreIds))
			return;
		ErPreEP erPreEP = new ErPreEP();
		EnErPreDO[] erPres = erPreEP.findByIds(erPreIds);
		if(EnValidator.isEmpty(erPres))
			return;
		UdiDocEP udiDocEP = new UdiDocEP();
		Map<String,UdidocDO> scoMap = udiDocEP.getUdiDocsByCode(IEnDictCodeTypeConst.SD_ERPRE_SCOLE);
		Map<String,UdidocDO> triageToMap = udiDocEP.getUdiDocsByCode(IEnDictCodeTypeConst.SD_ERPRE_TRIAGETO);
		Map<String, EnErPreDO> erPreMap = EnFMapUtils.getMap(EnErPreDO.ID_ERPRE, erPres);
		for(PatientBannerDTO banner : banners){
			 if(EnValidator.isEmpty(banner.getId_erpre()) || !erPreMap.containsKey(banner.getId_erpre()))
				 continue;
			 EnErPreDO erPre = erPreMap.get(banner.getId_erpre());
			 banner.setCode_erpre(erPre.getCode());
			 banner.setDt_entry_erpre(erPre.getDt_entry());
			 banner.setSd_triage_sco(erPre.getSd_scale_hm());
			 if(!EnValidator.isEmpty(banner.getSd_triage_sco()) && scoMap!=null && scoMap.containsKey(banner.getSd_triage_sco())){
				 UdidocDO udi = scoMap.get(banner.getSd_triage_sco());
				 banner.setName_triage_sco(udi.getName());
			 }
			 banner.setId_triage_dep(erPre.getId_dep_to());
			 banner.setName_triage_dep(erPre.getName_dep_to());
			 banner.setIds_green_channel_sym(erPre.getIds_green_channel_sym());
			 banner.setNames_green_channel_sym(erPre.getNames_green_channel());
			 banner.setFg_nonperson(erPre.getFg_nonperson());
			 banner.setSd_status_erpre(erPre.getSd_status());
			 banner.setSd_triage_to(erPre.getSd_triage_to());
			 if(!EnValidator.isEmpty(banner.getSd_triage_to()) && triageToMap!=null && triageToMap.containsKey(banner.getSd_triage_to())){
				 UdidocDO udi = triageToMap.get(banner.getSd_triage_to());
				 banner.setName_triage_to(udi.getName());
				 banner.setId_triage_to(udi.getId_udidoc());
			 }
			 banner.setName_status_erpre(getErPreStatusName(banner.getSd_status_erpre()));
		 }
	}
	/**
	 * 获取预检状态
	 * 
	 * @param status
	 * @return
	 */
	private String getErPreStatusName(String status){
		switch (status) {
		case IEnDictCodeConst.SD_STATUS_ERPRE_NEW:
			return "预检";
		case IEnDictCodeConst.SD_STATUS_ERPRE_VISIT:
			return "就诊";
		case IEnDictCodeConst.SD_STATUS_ERPRE_END:
			return "结束";
		case IEnDictCodeConst.SD_STATUS_ERPRE_CANCEL:
			return "取消";
		default:
			break;
		}
		return null;
	}
}
