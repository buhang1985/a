package iih.bl.params;

import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;

/**
 * 费用参数分析器
 * @author ly 2019/12/05
 *
 */
public class BlParamsAnalysisUtil {

	/**
	 * 该票据类型是否使用电子发票
	 * @param inccaId
	 * @return
	 */
	public static FBoolean BLINC0029(String inccaId){
		
		String blinc0029 = BlParams.BLINC0029();
		if(StringUtil.isEmpty(blinc0029))
			return FBoolean.FALSE;
		
		return new FBoolean(blinc0029.contains(inccaId));
	}
	
}
