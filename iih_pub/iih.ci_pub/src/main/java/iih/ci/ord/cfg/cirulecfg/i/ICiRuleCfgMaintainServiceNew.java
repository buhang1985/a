package iih.ci.ord.cfg.cirulecfg.i;

import iih.ci.ord.cfg.cirulecfg.d.CiRuleCfg;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;

public interface ICiRuleCfgMaintainServiceNew {
	CiRuleCfg[] save(CiEnContextDTO ctx, CiRuleCfg[] dos) throws BizException;
}
