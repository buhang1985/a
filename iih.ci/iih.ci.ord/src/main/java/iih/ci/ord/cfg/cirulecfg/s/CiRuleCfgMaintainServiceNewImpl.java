package iih.ci.ord.cfg.cirulecfg.s;

import iih.ci.ord.cfg.cirulecfg.d.CiRuleCfg;
import iih.ci.ord.cfg.cirulecfg.i.ICiRuleCfgMaintainServiceNew;
import iih.ci.ord.cfg.cirulecfg.i.ICiRuleEntityMaintainService;
import iih.ci.ord.cfg.cirulecfg.i.ICirulecfgMDOCudService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;

@Service(serviceInterfaces={ICiRuleCfgMaintainServiceNew.class}, binding=Binding.JSONRPC)
public class CiRuleCfgMaintainServiceNewImpl implements ICiRuleCfgMaintainServiceNew {


	@Override
	public CiRuleCfg[] save(CiEnContextDTO ctx, CiRuleCfg[] dos) throws BizException {
		if (dos == null || dos.length == 0) {
			return null;
		}
		
		for (CiRuleCfg entity : dos) {
			if (entity.getStatus() == DOStatus.NEW) {
				String[] ids = new DBUtil().getOIDs(1);
				entity.setId_rulecfg(ids[0]);
				entity.setId_grp(ctx.getId_grp());
				entity.setId_org(ctx.getId_org());
			}
		}
		
		CiRuleCfg[] rst = ServiceFinder.find(ICirulecfgMDOCudService.class).save(dos);
		return rst;
	}

}
