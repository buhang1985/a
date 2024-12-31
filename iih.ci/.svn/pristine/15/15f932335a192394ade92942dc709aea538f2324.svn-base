package iih.ci.preop.di;

import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.preop.di.bp.CiPreOpEntpUpdateBP;
import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.data.BizException;

/**
 * 预住院转门诊诊断 接口实现类
 * @author zhengqiang
 *
 */
public class CiPreToOpDiServiceImpl implements ICiPreToOpDiService {

	@Override
	public CiDiagDO[] OpUpdateCiPreEntp(String id_en) throws BizException {
		if(!ObjectUtils.isEmpty(id_en)){
			return new CiPreOpEntpUpdateBP().exec(id_en);
		}
		return null;
	}

}
