package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.LinkedList;
import java.util.List;

import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import xap.mw.core.data.BizException;

/**
 * 增量维护同步医保数据业务逻辑
 * @author guoyang
 *
 */
public class SyncInsurDataByEuHpsrvtp {

	public void exec(HPSrvorcaDO[] hpSrvorcaDOs) throws BizException {
		boolean drugflag = false;
		boolean zlflag = false;
		boolean fwssflag = false;
		List<String> drugpks = new LinkedList<String>();
		List<String> zlpks = new LinkedList<String>();
		List<String> fwsspks = new LinkedList<String>();
		for (HPSrvorcaDO hpSrvorcaDO : hpSrvorcaDOs) {
			if(HpSrvTpEnum.DRUG.equals(hpSrvorcaDO.getEu_hpsrvtp())){
				if (!drugflag) {
					drugflag = true;
				}
				drugpks.add(hpSrvorcaDO.getId_hpsrvorca());
				break;
			}
			if(HpSrvTpEnum.ZL.equals(hpSrvorcaDO.getEu_hpsrvtp())){
				if (!zlflag) {
					zlflag = true;
				}
				zlpks.add(hpSrvorcaDO.getId_hpsrvorca());
				break;
			}
			if(HpSrvTpEnum.FWSS.equals(hpSrvorcaDO.getEu_hpsrvtp())){
				if (!fwssflag) {
					fwssflag = true;
				}
				fwsspks.add(hpSrvorcaDO.getId_hpsrvorca());
				break;
			}
		}
		String hpId = hpSrvorcaDOs[0].getId_hp();
		if(drugflag){
			SyncInsurDrugData(hpId, drugpks.toArray(new String[drugpks.size()]));
		}
		if(zlflag){
			SyncInsurZlData(hpId, zlpks.toArray(new String[zlpks.size()]));
		}
		if(fwssflag){
			SyncInsurFwssData(hpId, fwsspks.toArray(new String[fwsspks.size()]));
		}
	}
	
	/**
	 * 同步医保服务设施数据
	 * @param pks 
	 * @param hpId 
	 * 
	 * @throws BizException
	 */
	private void SyncInsurFwssData(String hpId, String[] pks) throws BizException {
		SyncInsurFwssDataBp bp = new SyncInsurFwssDataBp();
		bp.exec(hpId, pks);
	}

	/**
	 * 同步医保诊疗信息
	 * @param strings 
	 * @param hpId 
	 * 
	 * @throws BizException
	 */
	private void SyncInsurZlData(String hpId, String[] pks) throws BizException {
		SyncInsurZlDataBp bp = new SyncInsurZlDataBp();
		bp.exec(hpId, pks);
	}

	/**
	 * 同步医保药品信息
	 * @param strings 
	 * @param hpId 
	 * 
	 * @throws BizException
	 */
	private void SyncInsurDrugData(String hpId, String[] pks) throws BizException {
		SyncInsurDrugDataBp bp = new SyncInsurDrugDataBp();
		bp.exec(hpId, pks);
	}
}
