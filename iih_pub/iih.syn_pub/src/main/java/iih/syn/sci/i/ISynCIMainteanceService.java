package iih.syn.sci.i;

import xap.mw.core.data.BizException;

/**
 * @Description:临床数据同步基础维护服务
 * @author: xu_xing@founder.com.cn
 * @version：2018年3月28日 下午2:50:49 创建
 */
public interface ISynCIMainteanceService {
	
	/**
	 * 从Pacs获取检查报告信息
	 * 
	 * @param code_pat
	 */
	public abstract void getObsRptInfo(String code_pat) throws BizException;
	
	/**
	 * 从Lis获取检验报告数据
	 * @param code_pat
	 * @throws BizException
	 */
	public abstract void getRptLabInfo(String code_pat) throws BizException;
}
