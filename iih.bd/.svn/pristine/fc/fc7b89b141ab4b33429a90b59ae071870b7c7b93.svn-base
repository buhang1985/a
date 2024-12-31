package iih.bd.pp.medinsurdown.s;

import iih.bd.pp.medinsurdown.d.MedInsurFileDownRecDO;
import iih.bd.pp.medinsurdown.i.IMedinsurfiledownrecExtCudService;
import iih.bd.pp.medinsurdown.i.IMedinsurfiledownrecExtRService;
import iih.bd.pp.medinsurdown.s.bp.SaveDownRecByFileIdAndhpSrvTpBp;
import xap.mw.core.data.BizException;

/**
 * 安徽医保目录下载记录扩展服务
 * 
 * @author hao_wu
 *
 */
public class MedinsurfiledownrecExtCrudServiceImpl
		implements IMedinsurfiledownrecExtCudService, IMedinsurfiledownrecExtRService {

	@Override
	public MedInsurFileDownRecDO SaveMedInsurFileDownRec(String fileId, Integer hpSrvTp) throws BizException {
		SaveDownRecByFileIdAndhpSrvTpBp bp = new SaveDownRecByFileIdAndhpSrvTpBp();
		MedInsurFileDownRecDO result = bp.exec(fileId, hpSrvTp);
		return result;
	}

}
