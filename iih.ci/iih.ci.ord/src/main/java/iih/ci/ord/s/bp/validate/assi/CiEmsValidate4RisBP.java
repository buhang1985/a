package iih.ci.ord.s.bp.validate.assi;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medsrv.i.IMedSrvRisDORService;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ems.d.CiTmplValidateRstDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.validate.assi.common.BaseEmsValidate4OtherBP;
import iih.ci.ord.s.ems.utils.OrderUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检查医疗单有效性检查
 * 
 * @author qzwang
 *
 */
public class CiEmsValidate4RisBP extends BaseEmsValidate4OtherBP {

	@Override
	public CiTmplValidateRstDTO exec(CiEmsDTO emsDTO, List<String> errorList) throws BizException {
		// TODO Auto-generated method stub
		super.exec(emsDTO, errorList);

		// 检查总次数
		checkTimesCurInfo(emsDTO, errorList);

		// 患者信息和就诊信息
		checkPatDiInfo(emsDTO, errorList);

		// 检查执行科室信息
		checkDepInfo(emsDTO, errorList);

		// 申请单错误检查
		checkApplySheetInfo(emsDTO, errorList);
		// 校验性别
		ValidateSex(emsDTO,errorList);
		//校验临床病症及体征不允许空校验
		checkClinicalzztz(emsDTO, errorList);

		return this.getValidateRst();
	}
	protected void checkClinicalzztz(CiEmsDTO emsDTO, List<String> errorList)  throws BizException{
	}
	/**
	 * 校验开单性别限制
	 * @param emsDTO
	 * @throws BizException
	 */
	private void ValidateSex(CiEmsDTO emsDTO, List<String> errorList) throws BizException {
		List<String> idsrvs = new ArrayList<String>();
		//套
		if(FBoolean.TRUE.equals(emsDTO.getFg_set())){
			FArrayList emssrvs = emsDTO.getEmssrvs();
			for(Object obj : emssrvs){
				CiEmsSrvDTO srv = (CiEmsSrvDTO)obj;
				if(!StringUtils.isEmpty(srv.getId_srv()) && !idsrvs.contains(srv.getId_srv())){
					idsrvs.add(srv.getId_srv());
				}
			}
		}else{//非套
			idsrvs.add(emsDTO.getId_srv());
		}
		if(idsrvs.size()>0){
			IMedSrvRisDORService risService = ServiceFinder.find(IMedSrvRisDORService.class);
			MedSrvRisDO[] rises = risService.findByAttrValStrings(MedSrvRisDO.ID_SRV, idsrvs.toArray(new String[0]));
			CiEnContextDTO envinfo = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
			if(envinfo!=null){
				for(MedSrvRisDO ris : rises){
//					OrderUtils.ValidateSex(envinfo.getSd_sex(), ris.getFit_sex(), ris.getSrv_name(), IBdSrvDictCodeConst.SD_SRVTP_RIS);
					String errorInfo = OrderUtils.ValidateSexMessageRst(envinfo.getSd_sex(), ris.getFit_sex(), ris.getSrv_name(), IBdSrvDictCodeConst.SD_SRVTP_RIS);
					if(!StringUtils.isEmpty(errorInfo)){
						errorList.add(errorInfo);
						this.getValidateRst().setLevel(CiTmplValidateRstDTO.ERROR);
					}
				}
			}
		}
		
	}

	private void checkPatDiInfo(CiEmsDTO ems, List<String> errorList) {
		if (StringUtil.isEmpty(ems.getId_en()) || StringUtil.isEmpty(ems.getId_entp())
				|| StringUtil.isEmpty(ems.getId_pat())) {
			errorList.add("医疗单就诊相关信息不完整，请重新检查");
			this.getValidateRst().setLevel(CiTmplValidateRstDTO.ERROR);
		}
	}

	private void checkDepInfo(CiEmsDTO ems, List<String> errorList) {
		if (StringUtil.isEmpty(ems.getId_dep_mp()) || StringUtil.isEmpty(ems.getName_dep_mp())) {
			errorList.add("执行科室信息不完整，请重新检查");
			this.getValidateRst().setLevel(CiTmplValidateRstDTO.WARN);
		}
	}

	private void checkTimesCurInfo(CiEmsDTO ems, List<String> errorList) {
		if (ems.getTimes_cur().intValue() == 0) {
			errorList.add("检查次数必须大于 0");
			this.getValidateRst().setLevel(CiTmplValidateRstDTO.WARN);
		}
	}

	private void checkApplySheetInfo(CiEmsDTO ems, List<String> errorList) throws BizException {
		FMap mapApplySheet = ems.getOrapplysheet();
		if (null != mapApplySheet && mapApplySheet.containsKey(EmsType.RIS.toString())) {
			OrdApObsDO objOrdApObs = (OrdApObsDO) mapApplySheet.get(EmsType.RIS.toString());
			if (!CiOrdUtils.isEmpty(ems.getCode_entp())//非住院的校验诊断必填
					&& !ems.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP)
					&& !ems.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS)
					&& !ems.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE)) {
				if (StringUtil.isEmpty(objOrdApObs.getId_di()) || StringUtil.isEmpty(objOrdApObs.getName_di())) {
					errorList.add("诊断信息不完整，请重新检查");
					this.getValidateRst().setLevel(CiTmplValidateRstDTO.ERROR);
				}
			}

			if (StringUtil.isEmpty(objOrdApObs.getNo_applyform())) {
				errorList.add("没有申请单号，请重新检查");
				this.getValidateRst().setLevel(CiTmplValidateRstDTO.ERROR);
			}

			if (StringUtil.isEmpty(objOrdApObs.getName_pps()) || StringUtil.isEmpty(objOrdApObs.getId_pps())
					|| StringUtil.isEmpty(objOrdApObs.getSd_pps()) || StringUtils.isEmpty(objOrdApObs.getDes_pps())) {
				errorList.add("检查目的信息不完整");
				this.getValidateRst().setLevel(CiTmplValidateRstDTO.WARN);
			}

		}

	}

}
