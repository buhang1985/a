package iih.bl.cg.bp;

import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 优惠券处理业务
 * @author yi
 *
 */
public class HandlerCpnOepBp {

    //优惠券分类码长度
   // private static final String COUPONCACODE_LEN_PARAM="BlCpnCaCodeLen";
    //优惠券单码长度
   // private static final String COUPONCODE_LEN_PARAM="BlCpnAddCodeLen";
    
    public void exec(String strIdPat,String strCpnCode) throws BizException
    {
        //优惠券码的校验
        int couponCaCodeLen=BlParams.BLCPN0001();
        int couponCodeLen=BlParams.BLCPN0002();
        
        //直接更新优惠券使用标识
        StringBuffer sb=new StringBuffer();
        sb.append(" UPDATE BL_CPN SET FG_USED='Y' WHERE CODE=?");
        DAFacade facade=new DAFacade();
        SqlParam param=new SqlParam();
        param.addParam(strCpnCode);
        
        facade.execUpdate(sb.toString(), param);
        
    }
}
