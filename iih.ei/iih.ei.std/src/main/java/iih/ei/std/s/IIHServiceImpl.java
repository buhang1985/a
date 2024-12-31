package iih.ei.std.s;

import iih.ei.std.i.IIHService;
import iih.ei.std.s.bp.IIHServiceBP;

/**
 * IIH对外标准接口
 * 
 * @author ly 2019/07/29
 *
 */
public class IIHServiceImpl implements IIHService {

	/**
	 * @author hao_wu
	 */
	@Override
	public String process(String code, String xml) {
		IIHServiceBP bp = new IIHServiceBP();
		return bp.exec(code, xml);
	}
}
