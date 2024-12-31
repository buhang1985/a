package iih.bd.pp.hpdivshisdto.s;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.hpdivshisdto.d.HpDiVsHisDTO;
import iih.bd.pp.hpdivshisdto.i.IHpdivshisdtoExtService;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.i.IDiagdefMDORService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class HpdivshisdtoExtServiceImpl implements IHpdivshisdtoExtService {
	
	@Override
	public HpDiVsHisDTO[] completionStatus(HpDiVsHisDTO[] hpDiVsHisDTOs) throws BizException {
		if(hpDiVsHisDTOs != null && hpDiVsHisDTOs.length > 0){
			String[] nameArr = new String[hpDiVsHisDTOs.length];
			for (int i = 0; i < nameArr.length; i++) {
				nameArr[i] = hpDiVsHisDTOs[i].getHpdidict_name();
			}
			String whereIn = SqlUtils.getInSqlByIds("name", nameArr);
			IDiagdefMDORService diagdefMDORService = ServiceFinder.find(IDiagdefMDORService.class);
			DiagDefDO[] diagDefDOs = diagdefMDORService.find(whereIn, "", FBoolean.FALSE);
			for (HpDiVsHisDTO hpDiVsHisDTO : hpDiVsHisDTOs) {
				for (DiagDefDO diagDefDO : diagDefDOs) {
					if(hpDiVsHisDTO.getHpdidict_name().equals(diagDefDO.getName())){
						hpDiVsHisDTO.setEu_status(HpStatusEnum.MATCHED);
						break;
					}
				}
				hpDiVsHisDTO.setEu_status(HpStatusEnum.NOT_MATCHED);
			}
		}
		return hpDiVsHisDTOs;
	}
}
