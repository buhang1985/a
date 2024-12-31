package iih.ci.preop.order.bp;

import iih.ci.ord.i.meta.OrderRstDTO;
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
 * y预住院医嘱申请单作废逻辑
 * @author wangqingzhu
 *
 */
public class OrderCancelBP {

	public OrderRstDTO exec(String id_en, String code_entp, String[] szCode_tsorder) throws BizException{
		OrderRstDTO rst = new OrderRstDTO();
		if(StringUtils.isEmpty(id_en) && (szCode_tsorder==null || szCode_tsorder.length == 0)){
			rst.setIsSuccess(FBoolean.FALSE);
			rst.setMessageInfo("作废操作时，没有可执行的数据");
			return rst;
		}
		// TODO: 实现预住院申请单项目撤回逻辑
		ICitsorderMDORService orderService = ServiceFinder.find(ICitsorderMDORService.class);
		CiTsOrDO[] ciTsOrs = orderService.findByAttrValStrings(CiTsOrDO.CODE_OR, szCode_tsorder);
		if(ciTsOrs != null && ciTsOrs.length > 0){
			TimeService imeService =(TimeService)ServiceFinder.find(TimeService.class.getName());
			for (CiTsOrDO ciTsOrDO : ciTsOrs) {
				ciTsOrDO.setFg_canc(FBoolean.TRUE);
				ciTsOrDO.setId_emp_canc(Context.get().getStuffId());
				ciTsOrDO.setId_dep_canc(Context.get().getDeptId());
				ciTsOrDO.setDt_canc(imeService.getUFDateTime());
			}
			DAFacade fa = new DAFacade();
			fa.updateDOArray(ciTsOrs, new String[]{CiTsOrDO.FG_CANC,CiTsOrDO.ID_EMP_CANC,CiTsOrDO.ID_DEP_CANC,CiTsOrDO.DT_CANC});
		}
		rst.setIsSuccess(FBoolean.TRUE);
		return rst;
	}
}
