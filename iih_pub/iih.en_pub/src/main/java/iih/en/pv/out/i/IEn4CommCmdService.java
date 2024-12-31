package iih.en.pv.out.i;

import iih.en.pv.dto.d.EntStateDTO;
import xap.mw.core.data.BizException;

/**
 * 就诊对外公共操作接口
 * （对各个域对外接口继承此接口，此接口不进行注册，不对外开放）
 * 
 * @author liubin
 *
 */
public interface IEn4CommCmdService {
	/**
	 * 设置就诊状况
	 * 
	 * @param entStateDTO
	 *            就诊状况DTO
	 * @throws BizException
	 * @author yank
	 */
	public abstract void setEntState(EntStateDTO entStateDTO) throws BizException;
}
