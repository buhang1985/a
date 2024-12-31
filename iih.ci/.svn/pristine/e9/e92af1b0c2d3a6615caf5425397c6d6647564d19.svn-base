package iih.ci.preop.order.bp;

import iih.ci.tsip.d.CiTsOrDO;
import iih.ci.tsip.i.ICitsorderMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sie.common.utils.StringUtils;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 门诊预住院申请签署逻辑
 * @author wangqingzhu
 *
 */
public class OrderSignBP {

	public String exec(String id_en, String code_entp, String[] szCode_tsOrder) throws BizException{
		if(StringUtils.isEmpty(id_en) && (szCode_tsOrder==null || szCode_tsOrder.length == 0)){
			return "";
		}
		// TODO: 实现预住院申请单项目撤回逻辑
		ICitsorderMDORService orderService = ServiceFinder.find(ICitsorderMDORService.class);
		CiTsOrDO[] ciTsOrs = orderService.findByAttrValStrings(CiTsOrDO.CODE_OR, szCode_tsOrder);
		if(ciTsOrs != null && ciTsOrs.length > 0){
			TimeService imeService =(TimeService)ServiceFinder.find(TimeService.class.getName());
			for (CiTsOrDO ciTsOrDO : ciTsOrs) {
				ciTsOrDO.setFg_sign(FBoolean.TRUE);
				ciTsOrDO.setId_emp_sign(Context.get().getStuffId());
				ciTsOrDO.setId_dep_sign(Context.get().getDeptId());
				ciTsOrDO.setDt_sign(imeService.getUFDateTime());
			}
			DAFacade fa = new DAFacade();
			fa.updateDOArray(ciTsOrs, new String[]{CiTsOrDO.FG_SIGN,CiTsOrDO.ID_EMP_SIGN,CiTsOrDO.ID_DEP_SIGN,CiTsOrDO.DT_SIGN});
		}
		return null;
	}
}
