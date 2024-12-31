package iih.ci.mr.s;

import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mr.i.ICiMrStateUpdateService;

public class CiMrStateUpdateServiceImpl implements ICiMrStateUpdateService {

	
	@Override
	public void updateSubmitAndPigeonholeStateByIdEnt(String id_ent) throws DAException{
		// TODO Auto-generated method stub
		
		
		DAFacade daf = new DAFacade();
		StringBuilder  sqlStr = new StringBuilder();
		String sql = "";
		//更新ci_mr表
		sql = "update ci_mr set id_su_mr = '"+
		ICiMrDictCodeConst.ID_SU_MR_SUBMIT+
		"', sd_su_mr= '"+
		ICiMrDictCodeConst.SD_SU_MR_SUBMIT+
		"' where  id_ent = '"+id_ent+"'";
		daf.execUpdate(sql);
		//更新ci_amr表
		sql = "update ci_amr  set ci_amr.id_qa_doctor_part_sta = '"+
		ICiMrDictCodeConst.ID_MR_HASTOFILE+
		"' , ci_amr.sd_qa_doctor_part_sta = '"+
		ICiMrDictCodeConst.SD_MR_HASTOFILE+
		"' where id_ent = '"+id_ent+"'";
		daf.execUpdate(sql);
	}

}
