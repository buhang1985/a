package iih.ci.ord.s.bp.validate.assi;

import java.util.List;

import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiTmplValidateRstDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.validate.assi.common.BaseEmsValidate4OtherBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 草药医疗单检查
 * @author qzwang
 *
 */
public class CiEmsValidate4HerbsBP extends BaseEmsValidate4OtherBP {

	@Override
	public CiTmplValidateRstDTO exec(CiEmsDTO emsDTO,List<String> errorList) throws BizException {
		// TODO Auto-generated method stub
		super.exec(emsDTO, errorList);
		
		// 采用剂型信息检查
		checkBoilInfo(emsDTO,errorList);
		// 剂|总量必须大于0
		checkDrugQuanInfo(emsDTO.getEmssrvs(),errorList);
		// 频次
		//checkSrvFreqInfo(emsDTO,errorList);
		// 住院时停止时间为空
		if(CiOrdUtils.isIpWf(emsDTO.getCode_entp())){
			if(emsDTO.getDt_end() == null){
				emsDTO.setDt_end(emsDTO.getDt_begin().getDateTimeAfter(7));
				//errorList.add(String.format("%s([%s]) 结束日期不能为空", emsDTO.getName(),emsDTO.getId_srv()));
			}
		}
		//检查是否有空的物资执行科室(药房)
		checkWhDep(emsDTO,errorList);
		// 增加库存校验
		checkStock(emsDTO,errorList);
		return this.getValidateRst();
	}
}
