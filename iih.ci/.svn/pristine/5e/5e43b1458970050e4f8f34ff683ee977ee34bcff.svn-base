package iih.ci.ord.s.bp.validate.assi;

import java.util.List;

import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiTmplValidateRstDTO;
import iih.ci.ord.s.bp.validate.assi.common.BaseEmsValidate4OtherBP;
import xap.mw.core.data.BizException;

public class CiEmsValidate4OtherBP extends BaseEmsValidate4OtherBP {

	@Override
	public CiTmplValidateRstDTO exec(CiEmsDTO emsDTO, List<String> errorList) throws BizException {
		// TODO Auto-generated method stub
		super.exec(emsDTO, errorList);

		// 频次信息检查
		//checkSrvFreqInfo(emsDTO, errorList);

		return this.getValidateRst();

	}

}
