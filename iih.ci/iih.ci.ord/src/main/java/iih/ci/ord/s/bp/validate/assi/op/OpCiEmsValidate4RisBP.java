package iih.ci.ord.s.bp.validate.assi.op;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiTmplValidateRstDTO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.s.bp.validate.assi.CiEmsValidate4RisBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;
/**
 * 门诊检查医疗单有效性检查
 * @author zhangwq
 *
 */
public class OpCiEmsValidate4RisBP extends CiEmsValidate4RisBP {

	@Override
	protected void checkClinicalzztz(CiEmsDTO emsDTO, List<String> errorList) throws BizException {
		FMap sheetMap = emsDTO.getOrapplysheet();
		//0173910: 参数CIOR0504为false，从模板开立检查医嘱仍然校验
		FBoolean flag = ParamsetQryUtil.getParaBoolean(Context.get().getOrgId(),ICiOrdNSysParamConst.SYS_PARAM_CLINICAL_VALIDATE);
		if(FBoolean.TRUE.equals(flag)){
		if(sheetMap != null && sheetMap.containsKey(EmsType.RIS + "")){
			OrdApObsDO obs = (OrdApObsDO)sheetMap.get(EmsType.RIS + "");
			if(obs != null){
				if(StringUtils.isNullOrEmpty(obs.getClinicalzztz())){
					errorList.add(emsDTO.getName()+"医疗单临床病症及体征信息不完整");
					this.getValidateRst().setLevel(CiTmplValidateRstDTO.WARN);
				}
			}
		}
		}
		
	}
	
}
