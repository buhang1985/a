package iih.sc.apt.s.bp;

import java.util.ArrayList;
import java.util.List;

import iih.sc.apt.aptoptemp.d.ScAptOptEmpDO;
import iih.sc.apt.aptoptemp.i.IAptoptempCudService;
import iih.sc.apt.aptoptemp.i.IAptoptempRService;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.out.ci.d.ScAptOptEmpDTO;
import iih.sc.comm.ScCollectionUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScValidator;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

public class SaveEmplBP {
	public void exec(ScAptOptEmpDO[] dtos, MtAppDTO mtAppDTO)throws BizException {
		IAptoptempRService rservice = ServiceFinder.find(IAptoptempRService.class);
		List<ScAptOptEmpDO> empDOlist = new ArrayList<ScAptOptEmpDO>();
		for(ScAptOptEmpDO dto : dtos)
		{
			ScAptOptEmpDO empDO = new ScAptOptEmpDO();
			if(ScValidator.isEmpty(dto.getId_aptoptemp()))
			{
				empDO.setStatus(DOStatus.NEW);
			}
			else
			{
				empDO = rservice.findById(dto.getId_aptoptemp());
				empDO.setStatus(DOStatus.UPDATED);
			}
			empDO.setId_apt(mtAppDTO.getId_apt());
			empDO.setId_aptappl(mtAppDTO.getId_apt_appl());
			empDO.setId_role(dto.getId_role());
			empDO.setId_emp(dto.getId_emp());
			empDO.setSd_role(dto.getSd_role());
			empDOlist.add(empDO);
		}
		IAptoptempCudService cudservice = ServiceFinder.find(IAptoptempCudService.class);
		cudservice.save(empDOlist.toArray(new ScAptOptEmpDO[0]));
	}
}
