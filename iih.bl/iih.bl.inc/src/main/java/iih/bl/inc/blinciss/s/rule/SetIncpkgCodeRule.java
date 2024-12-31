package iih.bl.inc.blinciss.s.rule;

import iih.bl.comm.util.BlCodeUtils;
import iih.bl.inc.blinciss.d.BlIncIssDO;
import iih.bl.inc.blinciss.d.desc.BlIncIssDODesc;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.IRule;

/**
 * 创建票据包编号规则
 * @author hll 2019/04/12
 *
 */
public class SetIncpkgCodeRule implements IRule<BlIncIssDO> {

	@Override
	public void process(BlIncIssDO... arg0) throws BizException {
		
		if(ArrayUtil.isEmpty(arg0))
			return;
		
		FBoolean isauto = BlParams.BLINC0014();
		if(FBoolean.FALSE.equals(isauto))
		{
			return;
		}
		
		 for (BlIncIssDO blIncIssDOs : arg0) {
			  String  code=BlCodeUtils.getinccode(BlIncIssDODesc.CLASS_FULLNAME, new BlIncIssDO());
			  blIncIssDOs.setCode_incpkg(code);
		}
	}
}
