package iih.bl.cg.s.bp;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import iih.bl.hp.dto.d.IpBillItmUploadHpDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.exception.DbException;

/**
 * @author F
 *
 */
public class UpdateCgIpHpFlagBp {

	/**
	 * @param strIdEnt
	 * @param map
	 * @param isUploaded
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(String strIdEnt,IpBillItmUploadHpDTO[] list,FBoolean isUploaded) throws BizException{
		if(strIdEnt==null){
			return FBoolean.FALSE;
		}
		int rtn=0;
		if(isUploaded.booleanValue()){
			PersistMgr persist = null;
			PersistSession session = null;
			try {
				persist = (PersistMgr) PersistMgr.getInstance();
				session = persist.getPersistSession();
				
				if(ArrayUtils.isEmpty(list)){
					throw new BizException("要更新的记账明细数量不能为0");
				}
				
				for (IpBillItmUploadHpDTO bill : list) {
					
					StringBuilder sqlb = new StringBuilder();
					FDouble amt_hp=bill.getAmt_hp();
					FDouble amt_pat=bill.getAmt_pat();
					sqlb.append("update bl_cg_ip set fg_hp = 'Y' ");
					if(amt_hp!=null&&amt_pat!=null){
						sqlb.append(" ,amt_hp = ").append(amt_hp).append(", ");
						sqlb.append(" amt_pat = ").append(amt_pat).append(" ");
					}
					sqlb.append("where id_cgip = ").append("'"+bill.getId_cgip()+"'");
					rtn = new DAFacade().execUpdate(sqlb.toString());
				}
				
				session.execBatch();
			}catch (DbException e) {
				throw new BizException("更新记账数据的医保状态失败，失败原因为："+e.getMessage());
			} finally {
				if (session != null)
					session.closeAll();

				if (persist != null)
					persist.release();
			}
		
		}else{
			
			
		}
		return FBoolean.TRUE;
	}
}
