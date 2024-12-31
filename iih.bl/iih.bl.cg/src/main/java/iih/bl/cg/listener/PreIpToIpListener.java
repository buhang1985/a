package iih.bl.cg.listener;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bl.comm.log.BLThirdItfLogger;
import iih.bl.params.BlParams;
import iih.en.pv.out.d.EnEvtDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.businessevent.BusinessEvent.BusinessUserObj;
import xap.sys.appfw.businessevent.IBusinessEvent;
import xap.sys.appfw.businessevent.IBusinessListener;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.kernel.exception.DbException;

/**
 * 预住院转住院监听事件
 * @author hanjq 2020-05-06 10:14
 *
 */
public class PreIpToIpListener implements IBusinessListener{

	@Override
	public void doAction(IBusinessEvent arg0) throws BizException {
		BusinessUserObj bizUserObj = (BusinessUserObj) arg0.getUserObject();
		try {
			if (IEnEventConst.EVENT_EN_PRE_IP.equals(arg0.getEventType())
					&& IEnEventConst.EVENT_SOURCE_EN_IP_ENT.equalsIgnoreCase(arg0.getSourceID())) {
				EnEvtDTO transDepEvt = (EnEvtDTO) bizUserObj.getUserObj();
				if(transDepEvt != null && StringUtils.isNotBlank(transDepEvt.getId_ent()) && IEnDictCodeConst.SD_ENTEVT_TRANSHOS.equals(transDepEvt.getSd_entevt())){
					String idEnt = transDepEvt.getId_ent();
					this.updateCgEnttp(idEnt);
					this.updatePrePayPat(idEnt);
				}
					
			}
		} catch (Exception e) {
			BLThirdItfLogger.error(" 门诊记账短信监听事件新"+e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void updateCgEnttp(String idEnt) throws DbException, DAException{
		SqlParam param = new SqlParam();
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		param.addParam(IBdFcDictCodeConst.ID_CODE_ENTP_IP);
		String sql = " update bl_cg_ip set code_enttp = ?,id_enttp = ? where id_ent = ?  and code_enttp = ? and id_enttp = ?";
		Integer BLCG0039 = BlParams.BLCG0039();
		if(1 == BLCG0039){
			sql = " update bl_cg_ip set code_enttp = ?,id_enttp = ?,dt_cg = ? where id_ent = ?  and code_enttp = ? and id_enttp = ?";
			FDateTime now = new FDateTime();
			param.addParam(now);
		}else{
			sql = " update bl_cg_ip set code_enttp = ?,id_enttp = ? where id_ent = ?  and code_enttp = ? and id_enttp = ?";
		}		
		param.addParam(idEnt);
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE);
		param.addParam(IBdFcDictCodeConst.ID_CODE_ENTP_IP_PRE);
		
		DAFacade daf = new DAFacade();
		daf.execUpdate(sql, param);
	}
	
	private void updatePrePayPat(String idEnt) throws DAException{
		String sql = " update bl_prepay_pat set code_enttp = ?,id_enttp = ? where id_ent = ?  and code_enttp = ? and id_enttp = ?";
		this.execUpdate(sql, idEnt);
	}
	
	private void execUpdate(String sql,String idEnt) throws DAException{
		SqlParam param = new SqlParam();
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		param.addParam(IBdFcDictCodeConst.ID_CODE_ENTP_IP);
		param.addParam(idEnt);
		param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE);
		param.addParam(IBdFcDictCodeConst.ID_CODE_ENTP_IP_PRE);
		
		DAFacade daf = new DAFacade();
		daf.execUpdate(sql, param);
	}

}
