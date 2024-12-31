package iih.ci.ord.s.bp.ems.save.validate;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.dto.validate.EmsValidateRstDTO;
import iih.ci.ord.ems.d.CiEmsDTO;
import xap.mw.core.data.FArrayList;

/**
 * 医嘱开立校验
 * @author zhangwq
 *
 */
public class BaseSaveValidateBP {
	public EmsValidateRstDTO exec(CiEmsDTO ems){
		EmsValidateRstDTO rst = new EmsValidateRstDTO();
		FArrayList errorList = new FArrayList();
		if(StringUtils.isEmpty(ems.getId_pat())){
			errorList.add(String.format("%s医嘱的患者主键Id_pat为空，不允许保存,可能原因是该患者被执行过患者合并\r\n", ems.getName()));
		}
		rst.setErrorList(errorList);
		return rst;
	}
	
}
