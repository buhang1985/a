package iih.ci.ord.s.bp.validate.assi;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.StringUtil;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.cior.d.CiorapppathgyAggDO;
import iih.ci.ord.cior.d.OrdApPathgyDO;
import iih.ci.ord.cior.d.OrdApPathgySampDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiTmplValidateRstDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.validate.assi.common.BaseEmsValidate4OtherBP;

/**
 * 病理医疗单有效性检查
 * @author qzwang
 *
 */
public class CiEmsValidate4PythgyBP extends BaseEmsValidate4OtherBP {

	@Override
	public CiTmplValidateRstDTO exec(CiEmsDTO emsDTO,List<String> errorList) throws BizException{
		// TODO Auto-generated method stub
		
		super.exec(emsDTO,errorList);
		
		checkPatDiInfo(emsDTO,errorList);
		
		checkDepInfo(emsDTO,errorList);
		
		checkApplySheetInfo(emsDTO,errorList);
		
		return this.getValidateRst();
	}
	
	/**
	 * 就诊信息校验
	 * @param ems
	 * @param errorList
	 */
	private void checkPatDiInfo(CiEmsDTO ems, List<String> errorList){
		if (StringUtil.isEmpty(ems.getId_en())||
				StringUtil.isEmpty(ems.getId_entp())||
				StringUtil.isEmpty(ems.getId_pat()))
		{
			errorList.add("医疗单就诊相关信息不完整，请重新检查");
			this.getValidateRst().setLevel(CiTmplValidateRstDTO.ERROR);
		}
	}
	
	/**
	 * 执行科室信息校验
	 * @param ems
	 * @param errorList
	 */
	private void checkDepInfo(CiEmsDTO ems, List<String> errorList){
		if (StringUtil.isEmpty(ems.getId_dep_mp())||
				StringUtil.isEmpty(ems.getName_dep_mp()))
		{
			errorList.add("执行科室信息不完整，请重新检查");
			this.getValidateRst().setLevel(CiTmplValidateRstDTO.WARN);
		}
	}
	
	/**
	 * 对象信息校验
	 * @param ems
	 * @param errorList
	 */
	private void checkApplySheetInfo(CiEmsDTO ems, List<String> errorList){
		FMap mapApplySheet = ems.getOrapplysheet();
		if (null != mapApplySheet && mapApplySheet.containsKey(EmsType.PATHGY.toString())){
			CiorapppathgyAggDO objAggDO = (CiorapppathgyAggDO) mapApplySheet.get(EmsType.PATHGY.toString());
			
			checkOrdApPathgyInfo(ems,objAggDO.getParentDO(),errorList);
			
			checkOrdApPathgySampInfo(objAggDO.getOrdApPathgySampDO(),errorList);
		}

	}
	
	/**
	 * 病理对象信息校验
	 * @param objOrdApPathgy
	 * @param errorList
	 */
	private void checkOrdApPathgyInfo(CiEmsDTO ems,OrdApPathgyDO objOrdApPathgy,List<String> errorList){
		if (!CiOrdUtils.isEmpty(ems.getCode_entp())//非住院的校验诊断必填
				&& !ems.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP)
				&& !ems.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET_OBS)
				&& !ems.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE)) {
			if (StringUtil.isEmpty(objOrdApPathgy.getId_di())||
					StringUtil.isEmpty(objOrdApPathgy.getStr_code_di())||
					StringUtil.isEmpty(objOrdApPathgy.getStr_name_di())){
				errorList.add("诊断信息不完整，请重新检查");
				this.getValidateRst().setLevel(CiTmplValidateRstDTO.ERROR);
			}
		}
		/*if(StringUtil.isEmpty(objOrdApPathgy.getId_samptp())||
				StringUtil.isEmpty(objOrdApPathgy.getSd_samptp())||
				StringUtil.isEmpty(objOrdApPathgy.getName_samptp())){
			errorList.add("标本类型信息不完整，请重新检查");
			this.getValidateRst().setLevel(CiTmplValidateRstDTO.WARN);
		}*/
	}
	
	/**
	 * 标本对象信息校验
	 * @param arrSampDOs
	 * @param errorList
	 */
	private void checkOrdApPathgySampInfo(OrdApPathgySampDO[] arrSampDOs,List<String> errorList){
		
		if(arrSampDOs!=null&&arrSampDOs.length>0){
			for(OrdApPathgySampDO sampDO:arrSampDOs){
				if (sampDO.getSortno() == null || StringUtil.isEmpty(sampDO.getSortno().toString())) {
					errorList.add("标本序号不完整，请重新检查");
					this.getValidateRst().setLevel(CiTmplValidateRstDTO.WARN);
				}
				//0171423: 门急诊医生站：开立内镜病理签署报没有标本信息不可签署。全选开立医嘱后取消勾选内镜病理医嘱签署报内镜病理没有标本信息。在医嘱模板中开立内镜病理医嘱签署时报内镜病理没有标本信息、正常开立可直接签署。
				//可以保存空的标本数据
//				if(StringUtil.isEmpty(sampDO.getName_labsamp())){
//					errorList.add("标本名称不完整，请重新检查");
//					this.getValidateRst().setLevel(CiTmplValidateRstDTO.WARN);
//				}
//				
//				if(StringUtil.isEmpty(sampDO.getBody_coll())){
//					errorList.add("标本采集部位不完整，请重新检查");
//					this.getValidateRst().setLevel(CiTmplValidateRstDTO.WARN);
//				}
//				
//				if(StringUtil.isEmpty(sampDO.getFixative())){
//					errorList.add("标本固定液不完整，请重新检查");
//					this.getValidateRst().setLevel(CiTmplValidateRstDTO.WARN);
//				}
			}
			
		}
	}
	
	
}
