package iih.ci.preip.di;

import iih.ci.diag.cidiag.d.CiDiagDO;
import xap.mw.core.data.BizException;

/**
 * 预住院诊断转住院诊断 接口 
 * @author zhengqiang
 *
 */
public interface ICiPreToIpDiService {

	public abstract CiDiagDO[] IpUpdateCiPreEntp(String id_en, String code_entp) throws BizException;
}
