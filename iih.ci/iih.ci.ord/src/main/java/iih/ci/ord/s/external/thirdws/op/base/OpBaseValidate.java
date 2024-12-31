package iih.ci.ord.s.external.thirdws.op.base;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.i.external.thirdws.base.EmsValidateRstDTO;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.s.external.thirdws.base.IValidate;

public class OpBaseValidate implements IValidate {

	@Override
	public EmsValidateRstDTO validate(EntWsDTO dataSource) {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 * 校验 放异常信息
	 */
    public void checkEmpty(String attribute,String ErrMsg,EmsValidateRstDTO rstDTO) {
    	if(StringUtils.isEmpty(attribute)) {
			rstDTO.setLevel(EmsValidateRstDTO.ERROR);
			rstDTO.getMsgInfoList().add("'"+ErrMsg+"' 不能为空! \n");
		}
    }

}
