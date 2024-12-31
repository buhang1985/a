package iih.ci.mrm;

import java.util.List;

import iih.ci.mrm.CiMrmPerformanceDTO;
import iih.ci.mrm.bp.getmzlistbp;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

public class MrmMzPerformanceService{

	public List<CiMrmPerformanceDTO> getmzlist(String id_pat,String name_pat,String id_emp_phy,String id_dep_phy, String dt_acpt,String dt_end,String performance) throws Exception {
		getmzlistbp bp = new getmzlistbp();
		
		return bp.getmzlist(id_pat,name_pat,id_emp_phy,id_dep_phy,dt_acpt,dt_end,performance);
	}


}
