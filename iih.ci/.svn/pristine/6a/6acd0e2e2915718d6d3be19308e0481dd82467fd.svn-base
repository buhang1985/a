package iih.ci.ord.s.bp.validate.assi;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.base.utils.FMapUtils;
import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.cior.d.CiordInviteConsDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiTmplValidateRstDTO;
import iih.ci.ord.s.bp.validate.assi.common.BaseEmsValidate4OtherBP;

/**
 * 会诊医疗单有效性检查
 * @author lxy
 *
 */
public class CiEmsValidate4ConsBP extends BaseEmsValidate4OtherBP {

	@Override
	public CiTmplValidateRstDTO exec(CiEmsDTO emsDTO,List<String> errorList) {
		
		CiorappconsultAggDO agg=(CiorappconsultAggDO)emsDTO.getOrapplysheet().get(EmsType.CONS) ;
		if(agg == null) {
			errorList.add("\"医嘱模板\"和\"服务\"暂不支持会诊类服务！");
			this.getValidateRst().setLevel(CiTmplValidateRstDTO.ERROR);
			
		}
		if(agg!=null){
			CiordInviteConsDO[] invitelist=agg.getCiordInviteConsDO();
			if(invitelist.length!=0){
				boolean flag=false;
				for(CiordInviteConsDO invite:invitelist){
					if(("").equals(invite.getId_dep()) || invite.getId_dep().equals(null))flag=true;
				}
				if(flag){
					errorList.add("请填写受邀科室！！");
					this.getValidateRst().setLevel(CiTmplValidateRstDTO.WARN);
				}
			}else{
				errorList.add("缺少会诊受邀方信息！");
				this.getValidateRst().setLevel(CiTmplValidateRstDTO.WARN);
			}
		}

		return this.getValidateRst();
	}


}
