package iih.pi.reg.pat.s.rule;

import java.util.ArrayList;

import org.apache.commons.lang.ArrayUtils;

import iih.pi.overview.overview.d.PiPatPsnDO;
import iih.pi.overview.overview.i.IPiPatPsnDOCudService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAggDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.bizrule.IRule;

/**
 * 创建患者个人史规则
 * 
 * @author hao_wu
 *
 */
public class CreatePatPsnRule implements IRule<PatiAggDO> {

	@Override
	public void process(PatiAggDO... patAggs) throws BizException {
		if (ArrayUtils.isEmpty(patAggs)) {
			return;
		}

		ArrayList<PiPatPsnDO> patPsnList = new ArrayList<PiPatPsnDO>();
		for (PatiAggDO patiAggDo : patAggs) {
			PatDO PatiDo = patiAggDo.getParentDO();
			// String[] arrPsn = { "吸烟情况", "开始年龄", "频率", "戒烟年龄", "饮酒情况", "开始年龄",
			// "频率", "戒酒年龄" };
			PiPatPsnDO piPatPsnDo = new PiPatPsnDO();
			piPatPsnDo.setStatus(2);
			piPatPsnDo.setId_pat(PatiDo.getId_pat());
			piPatPsnDo.setSd_datasrc("0");
			patPsnList.add(piPatPsnDo);
		}

		IPiPatPsnDOCudService patPsnDOCudService = ServiceFinder.find(IPiPatPsnDOCudService.class);
		patPsnDOCudService.insert(patPsnList.toArray(new PiPatPsnDO[0]));
	}
}
