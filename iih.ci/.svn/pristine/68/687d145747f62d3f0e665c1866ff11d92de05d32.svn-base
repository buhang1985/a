package iih.ci.ord.s.bp.validate.assi.op;

import java.util.List;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiTmplValidateRstDTO;
import iih.ci.ord.s.bp.validate.assi.common.BaseEmsValidate4OtherBP;
import xap.mw.core.data.BizException;

/**
 * 西成药检查
 * @author daixb
 *
 */
public class OpCiEmsValidate4DrugBP extends BaseEmsValidate4OtherBP {

	@Override
	public CiTmplValidateRstDTO exec(CiEmsDTO emsDTO,List<String> errorList) throws BizException {
		// TODO Auto-generated method stub
		
		//检查是否是抗菌药，如果是则提示，并清空用药目的
		checkDrugAnti(emsDTO,errorList);
		
		//检查是否有空的物资执行科室(药房)
        checkWhDep(emsDTO,errorList);
        // 增加库存校验
        checkStock(emsDTO,errorList);
        
		return this.getValidateRst();
	}
}
