package iih.pi.reg.pat.s.rule;

import java.util.ArrayList;

import iih.pi.overview.overview.d.PiPatMhDO;
import iih.pi.overview.overview.i.IPiPatMhDOCudService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;

/**
 * 创建患者月经史规则
 * 
 * @author hao_wu
 *
 */
public class CreatePatMhRule implements IRule<PatiAggDO> {

	@Override
	public void process(PatiAggDO... arg0) throws BizException {
		if (arg0 == null || arg0.length <= 0) {
			return;
		}
		// TODO:为啥？
		ArrayList<PiPatMhDO> patMhList = new ArrayList<PiPatMhDO>();
		for (PatiAggDO patiAggDo : arg0) {
			PatDO PatiDo = patiAggDo.getParentDO();
			PiPatMhDO piPatMhDO = new PiPatMhDO();
			piPatMhDO.setStatus(DOStatus.NEW);
			piPatMhDO.setId_pat(PatiDo.getId_pat());
			piPatMhDO.setSd_datasrc("0");
			patMhList.add(piPatMhDO);

		}

		IPiPatMhDOCudService piPatMhDOCudService = ServiceFinder.find(IPiPatMhDOCudService.class);
		piPatMhDOCudService.insert(patMhList.toArray(new PiPatMhDO[0]));
	}

}
