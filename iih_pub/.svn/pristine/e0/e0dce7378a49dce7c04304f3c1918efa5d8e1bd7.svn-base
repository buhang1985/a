package iih.bl.params.check;

import iih.bl.params.BlParamConst;
import iih.bl.params.BlParamValueConst;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.devcfg.paramset.d.ParamSetDO;
import xap.sys.devcfg.paramset.i.ICheckPara;
import xap.sys.devcfg.paramset.util.CheckParaDO;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 
 * 参数BLPAY011校验器
 * @author ly 2020/01/13
 *
 */
public class BLPAY011Checker implements ICheckPara {

	@Override
	public CheckParaDO paraBeforeSavingCheck(ParamSetDO arg0) {
		
		CheckParaDO rlt = new CheckParaDO();
		rlt.setIsLegal(FBoolean.TRUE);
		
		if(!BlParamValueConst.BLPAY011_DISABLED.equals(arg0.getValue())){
			
			try {
				String BLPAY008 = ParamsetQryUtil.getParaString(arg0.getId_org(),BlParamConst.BLPAY008);
				if(!BlParamValueConst.BLPAY008_DISABLED.equals(BLPAY008)){
					rlt.setIsLegal(FBoolean.FALSE);
					rlt.setErrMsg("参数BLPAY008不为[0:不启用],无法设置该参数值");
				}
			} catch (BizException e) {
			}
		}
		
		return rlt;
	}
}
