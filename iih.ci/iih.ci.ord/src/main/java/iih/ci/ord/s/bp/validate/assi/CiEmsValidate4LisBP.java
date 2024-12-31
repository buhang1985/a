package iih.ci.ord.s.bp.validate.assi;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvLisDO;
import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medsrv.i.IMedSrvLisDORService;
import iih.bd.srv.medsrv.i.IMedSrvRisDORService;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ems.d.CiTmplValidateRstDTO;
import iih.ci.ord.s.bp.validate.assi.common.BaseEmsValidate4OtherBP;
import iih.ci.ord.s.ems.utils.OrderUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 检验医疗单检查
 * @author qzwang
 *
 */
public class CiEmsValidate4LisBP extends BaseEmsValidate4OtherBP {

	@Override
	public CiTmplValidateRstDTO exec(CiEmsDTO emsDTO,List<String> errorList) throws BizException {
		// TODO Auto-generated method stub
		super.exec(emsDTO, errorList);
		
		// 患者信息和就诊信息
		checkPatDiInfo(emsDTO, errorList);
		
		// 申请单错误检查
		checkApplySheetInfo(emsDTO, errorList);
		
		ValidateSex(emsDTO,errorList);
		
		//校验标本不予许为空
		checkSamptp(emsDTO,errorList);
		return this.getValidateRst();
	}
	/**
	 * 校验标本不允许为空
	 * @param emsDTO
	 * @param errorList
	 */
	protected void checkSamptp(CiEmsDTO emsDTO, List<String> errorList) {
	}
	/**
	 * 校验开单性别限制
	 * @param emsDTO
	 * @throws BizException
	 */
	private void ValidateSex(CiEmsDTO emsDTO,List<String> errorList) throws BizException {
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
			IMedSrvLisDORService risService = ServiceFinder.find(IMedSrvLisDORService.class);
			MedSrvLisDO[] lises = risService.findByAttrValStrings(MedSrvLisDO.ID_SRV, idsrvs.toArray(new String[0]));
			CiEnContextDTO envinfo = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
			for(MedSrvLisDO lis : lises){
//				OrderUtils.ValidateSex(envinfo.getSd_sex(), lis.getFit_sex(), lis.getSrv_name(), IBdSrvDictCodeConst.SD_SRVTP_LIS);
				String errorInfo = OrderUtils.ValidateSexMessageRst(envinfo.getSd_sex(), lis.getFit_sex(), lis.getSrv_name(), IBdSrvDictCodeConst.SD_SRVTP_LIS);
				if(!StringUtils.isEmpty(errorInfo)){
					errorList.add(errorInfo);
					this.getValidateRst().setLevel(CiTmplValidateRstDTO.ERROR);
				}
			}
		}
		
	}
	private void checkPatDiInfo(CiEmsDTO ems, List<String> errorList){
		if (StringUtil.isEmpty(ems.getId_en())||
				StringUtil.isEmpty(ems.getId_entp())||
				StringUtil.isEmpty(ems.getId_pat()))
		{
			errorList.add("医疗单就诊相关信息不完整，请重新检查");
			this.getValidateRst().setLevel(CiTmplValidateRstDTO.WARN);
		}
	}
	
	private void checkApplySheetInfo(CiEmsDTO ems, List<String> errorList){
		
	}

}
