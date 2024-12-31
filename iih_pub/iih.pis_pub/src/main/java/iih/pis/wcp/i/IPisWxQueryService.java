package iih.pis.wcp.i;

import java.util.concurrent.ExecutionException;

import iih.pis.ivx.pisivxsrvact.d.PisIvxSrvactTagDO;
import xap.mw.core.data.BizException;

public interface IPisWxQueryService {
	
	/**
	 * 获取课程培训链接地址
	 * @param courseid
	 * @return
	 * @throws BizException
	 */
	public String[] getCourseUrl(String[] courseid) throws BizException;
	
	/**
	 * 获取服务号下已创建的标签
	 * @return
	 * @throws BizException
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public PisIvxSrvactTagDO[] getSrvactTag() throws BizException;
	
}
