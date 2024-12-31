package iih.ci.ord.cfg.cirulecfg.s;

import iih.ci.ord.cfg.cirulecfg.d.CiRuleEntity;
import iih.ci.ord.cfg.cirulecfg.i.ICiRuleEntityMaintainService;
import iih.ci.ord.cfg.cirulecfg.i.IRuleentityCudService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;

@Service(serviceInterfaces={ICiRuleEntityMaintainService.class}, binding=Binding.JSONRPC)
public class CiRuleEntityMaintainServiceImpl implements ICiRuleEntityMaintainService {

	@Override
	public CiRuleEntity[] save(CiEnContextDTO ctx, CiRuleEntity[] dos) throws BizException {
		if (dos == null || dos.length == 0) {
			return null;
		}
		
		for (CiRuleEntity entity : dos) {
			if (entity.getStatus() == DOStatus.NEW) {
				String[] ids = new DBUtil().getOIDs(1);
				entity.setId_rule(ids[0]);
				entity.setId_grp(ctx.getId_grp());
				entity.setId_org(ctx.getId_org());
			}
		}
		
		CiRuleEntity[] rst = ServiceFinder.find(IRuleentityCudService.class).save(dos);
		return rst;
	}

}
