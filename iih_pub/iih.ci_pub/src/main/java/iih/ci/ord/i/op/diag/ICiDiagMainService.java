
package iih.ci.ord.i.op.diag;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.meta.DiagCrtDTO;
import iih.ci.ord.i.meta.DiagLoadDTO;
import iih.ci.ord.i.meta.DiagRstDTO;
import iih.ci.ord.i.meta.DiagSaveDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 诊断主服务接口
 * 
 * @author wangqingzhu
 *
 */
public interface ICiDiagMainService {
	/**
	 * 新建诊断
	 * 
	 * @param diCreateInfo
	 * @return
	 */
	abstract DiagRstDTO create(DiagCrtDTO diCreateInfo) throws BizException;

	/**
	 * 加载诊断
	 * 
	 * @param diLoadInfo
	 * @return
	 */
	abstract DiagRstDTO load(DiagLoadDTO diLoadInfo) throws BizException;

	/**
	 * 保存诊断
	 * 
	 * @param diSaveInfo
	 * @return
	 */
	abstract DiagRstDTO save(DiagSaveDTO diSaveInfo) throws BizException;

	/**
	 * 签署诊断
	 * 
	 * @param diSaveInfo
	 * @return
	 */
	abstract DiagRstDTO sign(DiagSaveDTO diSaveInfo) throws BizException;

	/**
	 * 判断是否存在诊断信息
	 * 
	 * @param ctx
	 * @return
	 */
	abstract FBoolean isExistDiagInfo(CiEnContextDTO ctx) throws BizException;
}
