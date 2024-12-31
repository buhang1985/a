package iih.ci.ord.s.ems.itf.bp;

import iih.ci.ord.i.meta.DiagLoadDTO;
import iih.ci.ord.i.meta.DiagRstDTO;

/**
 * 诊断加载逻辑
 * 
 * @author wangqingzhu
 *
 */
public interface IDiagLoadBP {
	/**
	 * 加载诊断信息逻辑
	 * 
	 * @param diLoadInfo
	 * @return
	 */
	abstract DiagRstDTO load(DiagLoadDTO diLoadInfo);
}
