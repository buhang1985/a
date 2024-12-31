package iih.ci.ord.s.bp.validate.assi.op;

import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiTmplValidateRstDTO;
import iih.ci.ord.s.bp.validate.assi.CiEmsValidate4LisBP;
import xap.mw.core.data.FMap;
/**
 * 门诊检验医疗单检查
 * @author zhangwq
 *
 */
public class OpCiEmsValidate4LisBP extends CiEmsValidate4LisBP {

	@Override
	protected void checkSamptp(CiEmsDTO emsDTO, List<String> errorList) {
		FMap sheetMap = emsDTO.getOrapplysheet();
		if(sheetMap != null && sheetMap.containsKey(EmsType.LIS + "")){
			OrdApLabDO lab = (OrdApLabDO)sheetMap.get(EmsType.LIS + "");
			if(lab != null){
				if(StringUtils.isNullOrEmpty(lab.getSd_samptp())){
					errorList.add(emsDTO.getName()+"医疗单标本信息不完整");
					this.getValidateRst().setLevel(CiTmplValidateRstDTO.WARN);
				}
			}
		}
	}
	
}
