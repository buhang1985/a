package iih.bd.pp.hpsrvorca.s.bp;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import iih.bd.srv.medsrv.i.IMedSrvDrugDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 设置剂型明细
 * 
 * @author dj.zhang
 *
 */
public class SetDosageInfoBp {

	public PagingRtnData<HPSrvorcaDO> exec(PagingRtnData<HPSrvorcaDO> findByPageInfo) throws BizException {
		if (findByPageInfo.getPageData().size() <= 0) {
			return findByPageInfo;
		}
		FArrayList pageData = findByPageInfo.getPageData();
		setDosageInfo(pageData);
		return findByPageInfo;
	}

	/**
	 * 设置剂型明细
	 * 
	 * @param pageData
	 * @throws BizException
	 */
	private void setDosageInfo(FArrayList pageData) throws BizException {
		for (Object oj : pageData) {
			HPSrvorcaDO hPSrv = (HPSrvorcaDO) oj;
			setDosage(hPSrv);
		}

	}

	/**
	 * 设置明细
	 * 
	 * @param hPSrv
	 * @throws BizException
	 */
	private void setDosage(HPSrvorcaDO hPSrv) throws BizException {
		setHisDosageName(hPSrv);
	}

	/**
	 * 设置HIS剂型
	 * 
	 * @param hPSrv
	 * @throws BizException
	 */
	private void setHisDosageName(HPSrvorcaDO hPSrv) throws BizException {
		IMeterialMDORService iMeterialSrv = ServiceFinder.find(IMeterialMDORService.class);
		String whereStr = String.format("Id_mm = '%s'", hPSrv.getId_mm());
		MeterialDO[] meterialDOs = iMeterialSrv.find(whereStr, "", FBoolean.FALSE);
		if (meterialDOs != null && meterialDOs.length > 0) {
			IMedSrvDrugDORService iMedSrve = ServiceFinder.find(IMedSrvDrugDORService.class);
			whereStr = String.format("Id_srv = '%s'", meterialDOs[0].getId_srv());
			MedSrvDrugDO[] medSrvDrugDOs = iMedSrve.find(whereStr, "", FBoolean.FALSE);
			if (medSrvDrugDOs != null && medSrvDrugDOs.length > 0) {
				IUdidocRService iRService = ServiceFinder.find(IUdidocRService.class);
				whereStr = String.format("Code = '%s'", medSrvDrugDOs[0].getSd_dosage());
				UdidocDO[] udidocDOs = iRService.find(whereStr, "", FBoolean.FALSE);
				if (udidocDOs != null && udidocDOs.length > 0) {
					hPSrv.setHisdosage_name(udidocDOs[0].getName());
				}

			}
		}
	}

}
