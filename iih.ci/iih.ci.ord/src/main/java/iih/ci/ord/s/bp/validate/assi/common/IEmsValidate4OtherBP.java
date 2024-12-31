package iih.ci.ord.s.bp.validate.assi.common;

import java.util.List;

import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiTmplValidateRstDTO;
import xap.mw.core.data.BizException;

public interface IEmsValidate4OtherBP {

	abstract public CiTmplValidateRstDTO exec(CiEmsDTO emsDTO,List<String> errorList) throws BizException;
	CiTmplValidateRstDTO getValidateRst();
}
