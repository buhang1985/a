package iih.bl.st.ip.s.bp;

import iih.bl.cg.bliptfin.d.BlCgIpTfInDO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.exception.DbException;

public class BliptfinUpdateFgHpBP {
	public BlCgIpTfInDO[] exec(BlCgIpTfInDO[] dos) throws BizException{
		
		PersistMgr persist = null;
		PersistSession session = null;
		try {				
			persist = (PersistMgr) PersistMgr.getInstance();
			session = persist.getPersistSession();
			for(BlCgIpTfInDO indo:dos){
				StringBuilder sqlb = new StringBuilder();
				sqlb.append(" update BL_CG_IP_TFIN set FG_HP_TF='").append(indo.getFg_hp_tf()).append("' where ID_CGIP_TFIN='").append(indo.getId_cgip_tfin()).append("' ");
				session.addBatch(sqlb.toString());
			}
			session.execBatch();
		}catch (DbException e) {
			throw new BizException("更新门诊转住院的医保上传状态失败，失败原因为："+e.getMessage());
		} finally {
			if (session != null)
				session.closeAll();

			if (persist != null)
				persist.release();
		}
		return dos;
	}
}
