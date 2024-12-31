package iih.ci.mrqc.s;

import iih.ci.mrqc.i.IMedicalDepMrQcMaintainService;
import iih.ci.mrqc.qcresult.d.QcPatResultListDTO;
import iih.ci.mrqc.s.bp.medicaldepqc.MedicalDepQryBP;
import xap.mw.core.data.BizException;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
/**
 * 医务质控报表
 * @author F
 *
 */
public class MedicalDepMrQcMaintainServiceImpl implements IMedicalDepMrQcMaintainService{

	/**
	 * 医务质控报表所有数据
	 * @param qryRootNodeDTO
	 * @return
	 * @throws BizException
	 */
	public QcPatResultListDTO[] getQcPatResultList(QryRootNodeDTO qryRootNodeDTO) throws BizException{
		
		MedicalDepQryBP bp=new MedicalDepQryBP();
		return bp.getQcPatResultList(qryRootNodeDTO);				
	}
}
