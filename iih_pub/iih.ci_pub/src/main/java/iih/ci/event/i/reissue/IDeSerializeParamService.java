package iih.ci.event.i.reissue;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
/**
 * 将xml文件处理成DTO
 * @author zhangwq
 *
 */
public interface IDeSerializeParamService {
	BaseDTO deserialize(String xml) throws BizException;
}
