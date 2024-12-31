package iih.ci.sdk.ems.itf;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.FeeListLoadDTO;
import iih.ci.ord.i.meta.FeeListRstDTO;
import xap.mw.core.data.BizException;
/**
 * 费用清单数据加载业务处理接口
 * @author wangqingzhu
 *
 */
public interface IFeeListLoadBP {
	/**
	 * 加载费用清单数据
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public abstract FeeListRstDTO load(CiEnContextDTO ctx, FeeListLoadDTO ems) throws BizException;
}
