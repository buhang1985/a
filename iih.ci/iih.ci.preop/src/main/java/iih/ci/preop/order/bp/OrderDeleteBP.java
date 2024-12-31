package iih.ci.preop.order.bp;

import iih.ci.ord.i.error.ErrorEmsDTO;
import iih.ci.ord.i.meta.OrderRstDTO;
import iih.ci.sdk.ems.meta.ErrorEmsList;
import iih.ci.sdk.utils.ObjectUtils;
import iih.ci.tsip.d.CiTsOrDO;
import iih.ci.tsip.i.ICitsorderMDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sie.common.utils.StringUtils;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 预住院申请信息删除逻辑
 * @author wangqingzhu
 *
 */
public class OrderDeleteBP {

	/**
	 * 删除实现逻辑
	 * @param id_en
	 * @param code_entp
	 * @param szCode_tsorder
	 * @return
	 * @throws BizException
	 */
	public OrderRstDTO exec( String id_en, String code_entp, String[] szCode_tsorder) throws BizException{
		OrderRstDTO rst = new OrderRstDTO();
		rst.setIsSuccess(FBoolean.TRUE);
		if(StringUtils.isEmpty(id_en) && (szCode_tsorder==null || szCode_tsorder.length == 0)){
			rst.setIsSuccess(FBoolean.FALSE);
			rst.setMessageInfo("删除操作时，没有可执行的数据");
			return rst;
		}
		// 校验，已导入医嘱不允许作废
        OrderDeleteValidateBP validateBP = new OrderDeleteValidateBP();
        ErrorEmsList errorEmsList = validateBP.validateImported(szCode_tsorder);
        if (!ObjectUtils.isEmpty(errorEmsList)) {
            rst.setIsSuccess(FBoolean.FALSE);
            String name_or = "";
            for (ErrorEmsDTO errorDTO : errorEmsList) {
                name_or += "【" + errorDTO.getName_or() + "】";
            }
            rst.setMessageInfo(name_or + "已被导入为预住院医嘱，不允许删除！");
            return rst;
        }
        
		// TODO: 实现预住院申请单项目撤回逻辑
		DAFacade fa = new DAFacade();
		fa.deleteByWhere(CiTsOrDO.class, getWherePart(CiTsOrDO.CODE_OR,szCode_tsorder));
		return rst;
	}
	private String getWherePart(String attrVal,String[] szCode_tsorder){
		StringBuilder sb = new StringBuilder();
		sb.append(attrVal+" in ");
		for (int i =0;i < szCode_tsorder.length;i++) {
			if(i ==0){
				sb.append("( ");
			}
			sb.append("'");
			sb.append(szCode_tsorder[i]);
			sb.append("'");
			if(i != szCode_tsorder.length-1){
				sb.append(",");
			}else{
				sb.append(")");
			}
		}
		return sb.toString();
	}
}
