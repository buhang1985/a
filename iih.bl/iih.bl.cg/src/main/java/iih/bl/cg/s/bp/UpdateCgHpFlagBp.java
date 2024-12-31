package iih.bl.cg.s.bp;

import iih.bl.hp.dto.d.OutUploadPresDTO;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipRService;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.exception.DbException;

public class UpdateCgHpFlagBp {

	/**
	 * 医保费用上传/撤销后，更新fg_hp='Y' 并更新amt_pat和amt_hp字段
	 * 
	 * @param idEnt
	 *            就诊id
	 * @param idStIp
	 *            结算id
	 * @param map
	 *            医保上传结果与对应的记账主键关系<idcgip,OutUploadPresDTO>
	 * @param isUploaded
	 *            fg_hp标志更改
	 * @param isBat
	 *            是否是批量上传
	 * @author liwq
	 */
	public FBoolean exec(String idEnt, String idStIp, FMap2 map, FBoolean isUploaded, FBoolean isBat) throws BizException {
		if (StringUtils.isEmpty(idEnt))
			return FBoolean.FALSE;
		int rtn = 0;
		if (isBat.booleanValue()) {
			if (isUploaded.booleanValue()) {
				this.doUpdateBatUploaded(isBat, map, idStIp);				
			} else {
				StringBuilder sqlb = new StringBuilder();
				sqlb.append(" update bl_cg_ip set fg_hp = 'N', amt_pat = amt_ratio,  amt_hp = 0.00  where id_ent = '").append(idEnt).append("'; ");
				rtn = new DAFacade().execUpdate(sqlb.toString());
			}

		} else {
			if (StringUtils.isEmpty(idStIp)) {
				IBlstipRService stRService = ServiceFinder
						.find(IBlstipRService.class);
				BlStIpDO[] stDOs = stRService.find(
						" id_ent = '" + idEnt + "' ", "", FBoolean.TRUE);
				if (ArrayUtils.isEmpty(stDOs)) {
					throw new BizException("未查询到该就诊患者对应的结算信息！");
				}
				idStIp = stDOs[0].getId_stip();
			}

			if (isUploaded.booleanValue()) {
				this.doUpdateBatUploaded(isBat, map, idStIp);
			} else {
				StringBuilder sqlb = new StringBuilder();
				sqlb.append(" update bl_cg_ip set fg_hp = 'N', amt_pat = amt_ratio,  amt_hp = 0.00  where id_stip = '").append(idStIp).append("'; ");
				rtn = new DAFacade().execUpdate(sqlb.toString());
			}
		}
		if (rtn > 0) {
			return FBoolean.TRUE;
		} else {
			return FBoolean.FALSE;
		}
	}
	
	private void doUpdateBatUploaded(  FBoolean isBat, FMap2 map, String idStIp) {
		if(isBat.booleanValue()) {
			PersistMgr persist = null;
			PersistSession session = null;
			try {
				persist = (PersistMgr) PersistMgr.getInstance();
				session = persist.getPersistSession();

				for (String str : map.keySet()) {
					StringBuilder sqlb = new StringBuilder();
					OutUploadPresDTO outDto = (OutUploadPresDTO) map.get(str);					
					FDouble amt_pat = new FDouble(outDto.getAllselfamt()).add(new FDouble(outDto.getOneselfamt())).abs();
					FDouble amt_hp = new FDouble(outDto.getAmt()).abs();
					
					sqlb.append(" update bl_cg_ip set fg_hp = 'Y', amt_pat = ").append(amt_pat).append(", amt_hp = ")
							.append(amt_hp).append(" where id_cgip = '").append(str).append("' and fg_st = 'N' ;");
					session.addBatch(sqlb.toString());
				}

				session.execBatch();

			} catch (DbException e) {
				e.printStackTrace();
			} finally {
				if (session != null)
					session.closeAll();

				if (persist != null)
					persist.release();
			}

		} else {
			PersistMgr persist = null;
			PersistSession session = null;
			try {
				persist = (PersistMgr) PersistMgr.getInstance();
				session = persist.getPersistSession();

				for (String str : map.keySet()) {
					StringBuilder sqlb = new StringBuilder();
					OutUploadPresDTO outDto = (OutUploadPresDTO) map
							.get(str);
					FDouble amt_hp = new FDouble(outDto.getAmt());
					FDouble amt_pat = new FDouble(outDto.getAllselfamt()).add(new FDouble(outDto.getOneselfamt()));
					sqlb.append(" update bl_cg_ip set fg_hp = 'Y', amt_pat = ").append(amt_pat).append(", amt_hp = ")
							.append(amt_hp).append(" where id_cgip = '").append(str).append("' and id_stip = '").append(idStIp).append("' ");
					
					session.addBatch(sqlb.toString());
				}

				session.execBatch();

			} catch (DbException e) {
				e.printStackTrace();
			} finally {
				if (session != null)
					session.closeAll();

				if (persist != null)
					persist.release();
			}

		}		
	}
}
