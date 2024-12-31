package iih.ci.preop.order.bp;

import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.tsip.d.CiTsOrDO;
import iih.ci.tsip.i.ICitsorderMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sie.common.utils.StringUtils;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 预住院医嘱申请单签署撤回逻辑处理
 * @author wangqingzhu
 *
 */
public class OrderRevertBP {

	public OrderRstDTO exec(String id_en, String code_entp, String[] szCode_tsorder) throws BizException{
		OrderRstDTO rst = new OrderRstDTO();
		rst.setIsSuccess(FBoolean.TRUE);
		if(StringUtils.isEmpty(id_en) && (szCode_tsorder==null || szCode_tsorder.length == 0)){
			rst.setIsSuccess(FBoolean.FALSE);
			rst.setMessageInfo("撤回操作时，没有可执行的数据");
			return rst;
		}
		// TODO: 实现预住院申请单项目撤回逻辑
		ICitsorderMDORService orderService = ServiceFinder.find(ICitsorderMDORService.class);
		CiTsOrDO[] ciTsOrs = orderService.findByAttrValStrings(CiTsOrDO.CODE_OR, szCode_tsorder);
		if(ciTsOrs != null && ciTsOrs.length > 0){
			TimeService imeService =(TimeService)ServiceFinder.find(TimeService.class.getName());
			for (CiTsOrDO ciTsOrDO : ciTsOrs) {
				ciTsOrDO.setFg_sign(FBoolean.FALSE);
				ciTsOrDO.setId_emp_sign("~");
				ciTsOrDO.setId_dep_sign("~");
				ciTsOrDO.setDt_sign(null);
			}
			DAFacade fa = new DAFacade();
			fa.updateDOArray(ciTsOrs, new String[]{CiTsOrDO.FG_SIGN,CiTsOrDO.ID_EMP_SIGN,CiTsOrDO.ID_DEP_SIGN,CiTsOrDO.DT_SIGN});
		}
		return rst;
	}
}
