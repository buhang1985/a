package iih.ci.mi.diag.i;

import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;

/**
 * 
 * @author HUMS
 *
 */
public interface ICiMiDiagService {

	/**
	 * 获取医保特殊病流程下，医生站采用病种模式还是采用诊断模式
	 * 0：医生站采用病种模式；
	 * 1：医生站采用诊断模式；
	 * @return
	 */
	public int getSpecillDsdefModel();
	
	/**
	 * 判断是否为保外诊断
	 * @param idHp 医保id
	 * @param codeEntp 就诊code
	 * @param idDidefs 诊断定义id集合
	 * @return
	 * @throws BizException
	 */
	public abstract FMap checkDiScopeRule(CiEnContextDTO ctx, String[] idDidefs) throws BizException;
}
