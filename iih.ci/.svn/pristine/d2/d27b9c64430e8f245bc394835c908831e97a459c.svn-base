package iih.ci.ord.s.external.blood.ruimei.s.bp;

import java.util.Map;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.external.blood.ruimei.d.IEOpUbOrEnParamDTO;
import iih.ci.ord.external.blood.wqxk.d.WQUbOrEnParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class WanQuanBloodUtils {
	/**
	 * 转换用血回写参数
	 * @param param
	 * @return
	 */
	public static IEOpUbOrEnParamDTO getUbParam(WQUbOrEnParamDTO param) {
		IEOpUbOrEnParamDTO ubparam=new IEOpUbOrEnParamDTO();
		ubparam.setApplyno(param.getApplyno());
		ubparam.setCode_amr_ip(param.getCode_amr_ip());
		ubparam.setCode_emp_or(param.getCode_emp_or());
		ubparam.setCode_dep(param.getCode_dep());
		ubparam.setCode_ent(param.getCode_ent());
		ubparam.setDt_effe(param.getDt_effe());
		ubparam.setMatch_id(param.getMatch_id());
		ubparam.setName_or(param.getName_or());
		ubparam.setName_pat(param.getName_pat());
		ubparam.setTimesip(param.getTimesip());
		return ubparam;
	}
	
	public static CiOrderDO validateUbwriteBk(IEOpUbOrEnParamDTO ubparam,String rst) throws BizException {
		if(ubparam.getApplyno()==null||ubparam.getApplyno().trim().length()<=0) {
			throw new BizException("传入的申请单号为空");
		}
		CiOrderDO[] ords=ServiceFinder.find(ICiorderMDORService.class).find(" applyno='"+ubparam.getApplyno()+"' and fg_canc='N' and eu_orsrcmdtp='"+OrSourceFromEnum.THIRDPARTYSYS+"'", "", FBoolean.FALSE);
		if(ords==null||ords.length==0)
			throw new BizException("回写失败!");
		if(ords.length>1)
			throw new BizException("该申请单号对应多条医嘱");
		if(rst==null)
			throw new BizException("返回结果为空，回写失败");
		Map<String,Object> rnt=new ConvertXml2DTOsUtils().exec(rst);
		if(rnt.containsKey("code")) {
			String val=(String) rnt.get("code");
			if(val==null||!val.equals("0")) {
				String msg=(String) rnt.get("msg");
				throw new BizException("用血医嘱回写失败！"+msg);
			}
		}else {
			throw new BizException("用血医嘱回写失败！");
		}
		return ords[0];
	}

}
