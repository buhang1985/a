package iih.en.comm.ep;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.ipspectp.d.BdEnIpSpecDO;
import iih.bd.fc.ipspectp.i.IIpspectpRService;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.pi.reg.patamrcode.d.PiPatAmrCodeDO;
import iih.pi.reg.patamrcode.i.IPatamrcodeCudService;
import iih.pi.reg.patamrcode.i.IPatamrcodeRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/***
 * 基础数据-患者编码编码表EP
 * @author zhangpp
 *
 */
public class PiPatAmrCodeEP {

	/**
	 * 根据id获取患者编码表信息
	 * @param amrCodeId
	 * @return
	 * @throws BizException
	 */
	public PiPatAmrCodeDO getpiPatAmrCodeById(String amrCodeId) throws BizException{
		if(EnValidator.isEmpty(amrCodeId)){
			return null;
		}
		IPatamrcodeRService iRService = ServiceFinder.find(IPatamrcodeRService.class);
		PiPatAmrCodeDO piPatAmrCodeDO = iRService.findById(amrCodeId);
		return piPatAmrCodeDO;
	}
	/**
	 * 根据where条件获取患者编码表信息
	 * @param whereStr
	 * @param orderStr
	 * @param isLazy
	 * @return
	 * @throws BizException
	 */
	public PiPatAmrCodeDO getpiPatAmrCodeByWherestr(String idPat, String sdPatarmtp) throws BizException{
		if(EnValidator.isEmpty(idPat) || EnValidator.isEmpty(sdPatarmtp)){
			return null;
		}
		String whereStr = "id_pat = '"+idPat+"' and sd_patamrtp = '"+sdPatarmtp+"'";
		IPatamrcodeRService iRService = ServiceFinder.find(IPatamrcodeRService.class);
		PiPatAmrCodeDO[] piPatAmrCodeDOs = iRService.find(whereStr, "", FBoolean.FALSE);
		if (EnValidator.isEmpty(piPatAmrCodeDOs)) {
			return null;
		}
		return piPatAmrCodeDOs[0];
	}
	
	/**
	 * 保存患者编码表（带更新状态）
	 * @param piPatAmrCodeDOs
	 * @return
	 * @throws BizException
	 */
	public PiPatAmrCodeDO[] savePiPatAmrCodeDO(PiPatAmrCodeDO[] piPatAmrCodeDOs) throws BizException{
		if(EnValidator.isEmpty(piPatAmrCodeDOs)){
			return null;
		}
		IPatamrcodeCudService iCudService = ServiceFinder.find(IPatamrcodeCudService.class);
		return iCudService.save(piPatAmrCodeDOs);
	}
	
	/**
	 * 入院登记注册保存时，更新患者病案编码表
	 * @param enhosPatDTO
	 * @param enHosRegDTO
	 * @throws BizException
	 */
	public void registSavePatAmrCodeDO(String patId, String codeAmrIp, String sdIpSpec, String sdStatus) throws BizException{
		//根据住院特定类型，查找对应的患者病案类型
		IIpspectpRService iIpspectpRService = ServiceFinder.find(IIpspectpRService.class);
		BdEnIpSpecDO[] bdEnIpSpecDOs = iIpspectpRService.findByAttrValString(BdEnIpSpecDO.SD_IP_SPEC, sdIpSpec);
		if (bdEnIpSpecDOs != null && bdEnIpSpecDOs.length >= 1 && 
				!EnValidator.isEmpty(sdIpSpec) && !IEnDictCodeConst.SD_IPTYPE_CUSTOM.equals(sdIpSpec)) {
			PiPatAmrCodeDO pCodeDO = null;
			PiPatAmrCodeDO piPatAmrCodeDO = getpiPatAmrCodeByWherestr(patId, bdEnIpSpecDOs[0].getSd_patarmtp());
			if (piPatAmrCodeDO != null) {
				pCodeDO = piPatAmrCodeDO;
				//如果患者为登记或者在院状态，不更新
				if(!IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN.equals(sdStatus) 
						&& !IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN.equals(sdStatus)){
					pCodeDO.setCnt_use(pCodeDO.getCnt_use() + 1);
					pCodeDO.setStatus(DOStatus.UPDATED);
					savePiPatAmrCodeDO(new PiPatAmrCodeDO[]{pCodeDO});
				}
			}else {
				pCodeDO = new PiPatAmrCodeDO();
				pCodeDO.setId_grp(EnContextUtils.getGrpId());
				pCodeDO.setId_org(EnContextUtils.getOrgId());
				pCodeDO.setId_pat(patId);
				pCodeDO.setId_patamrtp(bdEnIpSpecDOs[0].getId_patarmtp());
				pCodeDO.setSd_patamrtp(bdEnIpSpecDOs[0].getSd_patarmtp());
				pCodeDO.setCode(codeAmrIp);
				pCodeDO.setCnt_use(1);
				pCodeDO.setDt_create(EnAppUtils.getServerDateTime());
				pCodeDO.setId_depcreate(EnContextUtils.getDeptId());
				pCodeDO.setId_empcreate(EnContextUtils.getPsnId());
				pCodeDO.setStatus(DOStatus.NEW);
				savePiPatAmrCodeDO(new PiPatAmrCodeDO[]{pCodeDO});
			}
		}
	}
	/**
	 * 取消登记或者退院时，更新患者病案编码表
	 * @param idPat
	 * @param SdSpecType
	 * @return
	 * @throws BizException
	 */
	public boolean disOrCancSavePatAmrCodeDO(String idPat, String SdSpecType) throws BizException{
		boolean rollBackAmrCode = false;
		//根据住院特定类型，查找对应的患者病案类型
		IIpspectpRService iIpspectpRService = ServiceFinder.find(IIpspectpRService.class);
		BdEnIpSpecDO[] bdEnIpSpecDOs = iIpspectpRService.findByAttrValString(BdEnIpSpecDO.SD_IP_SPEC, SdSpecType);
		//如果住院特定类型表中无数据，默认走普通的住院号
		if (bdEnIpSpecDOs != null && bdEnIpSpecDOs.length >= 1 && 
				!EnValidator.isEmpty(SdSpecType) && !IEnDictCodeConst.SD_IPTYPE_CUSTOM.equals(SdSpecType)) {
			//获取患者病案编码表信息
			PiPatAmrCodeDO pCodeDO = getpiPatAmrCodeByWherestr(idPat, bdEnIpSpecDOs[0].getSd_patarmtp());
			if (pCodeDO != null) {
				if ("1".equals(pCodeDO.getCnt_use().toString())) {
					pCodeDO.setStatus(DOStatus.DELETED);
					//回滚病案号
					new EnCodeAmrIpEP().rollBackCodeAmrIpSpecType(bdEnIpSpecDOs[0].getCode_codemaker(), pCodeDO.getCode());
					EnLogUtil.getInstance().logInfo("回滾特定类型的住院号：患者id"+idPat+ " 回滾的特定类型住院号为:"+pCodeDO.getCode());
					rollBackAmrCode = true;
				}else{
					pCodeDO.setCnt_use(pCodeDO.getCnt_use() - 1);
					pCodeDO.setStatus(DOStatus.UPDATED);
				}
				savePiPatAmrCodeDO(new PiPatAmrCodeDO[]{pCodeDO});
			}else {
				throw new BizException("未获取到患者病案编码表信息！");
			}
		}
		return rollBackAmrCode;
	}
}
