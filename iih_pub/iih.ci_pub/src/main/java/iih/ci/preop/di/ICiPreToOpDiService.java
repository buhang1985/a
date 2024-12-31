package iih.ci.preop.di;

import iih.ci.diag.cidiag.d.CiDiagDO;
import xap.mw.core.data.BizException;

/**
 * 预住院诊断转门诊诊断 接口 
 * @author zhengqiang
 *
 */
public interface ICiPreToOpDiService {

	public abstract CiDiagDO[] OpUpdateCiPreEntp(String id_en) throws BizException;
}
