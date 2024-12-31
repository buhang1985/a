package iih.bd.pp.hpsrvorca.s.bp;

import iih.bd.pp.bdhpsrvctr.d.BdHpSrvctrDO;
import iih.bd.pp.bdhpsrvctr.i.IBdhpsrvctrCudService;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.i.IHpsrvorcaCudService;
import iih.bd.pp.srvctrdi.d.BdHpSrvCtrDiDO;
import iih.bd.pp.srvctrdi.i.ISrvctrdiCudService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存目录对照增量维护HpSrvorcaDo，BdHpSrvctrDo，BdHpSrvCtrDiDo保存Bp
 * 
 * @author guoyang
 *
 */
public class SaveSrvorcaSrvctrSrvCtrDiBp {

	public void exec(BdHpSrvCtrDiDO[] bdHpSrvCtrDiArr) throws BizException {
		// saveHPSrvorcaDO(hpsrvorca);
		// saveBdHpSrvctrDO(hpSrvctrDo);
		saveBdHpSrvCtrDiDO(bdHpSrvCtrDiArr);
	}

	private void saveHPSrvorcaDO(HPSrvorcaDO hpsrvorca) throws BizException {
		if (hpsrvorca != null) {
			IHpsrvorcaCudService hpsrvorcaCudService = ServiceFinder.find(IHpsrvorcaCudService.class);
			hpsrvorcaCudService.save(new HPSrvorcaDO[] { hpsrvorca });
		}
	}

	private void saveBdHpSrvctrDO(BdHpSrvctrDO hpSrvctrDo) throws BizException {
		if (hpSrvctrDo != null) {
			IBdhpsrvctrCudService bdhpsrvctrCudService = ServiceFinder.find(IBdhpsrvctrCudService.class);
			// IBdhpsrvctrRService bdhpsrvctrRService =
			// ServiceFinder.find(IBdhpsrvctrRService.class);
			// String whereStr = String.format(" id_hp = '%s' and code = '%s' ",
			// hpSrvctrDo.getId_hp(), hpSrvctrDo.getCode());
			// BdHpSrvctrDO[] bdHpSrvctrDOs =bdhpsrvctrRService.find(whereStr,
			// "", FBoolean.FALSE);
			// if(bdHpSrvctrDOs != null && bdHpSrvctrDOs.length >0){
			// bdhpsrvctrCudService.delete(bdHpSrvctrDOs);
			// }
			bdhpsrvctrCudService.save(new BdHpSrvctrDO[] { hpSrvctrDo });
		}
	}

	private void saveBdHpSrvCtrDiDO(BdHpSrvCtrDiDO[] bdHpSrvCtrDiArr) throws BizException {
		if (bdHpSrvCtrDiArr != null && bdHpSrvCtrDiArr.length > 0) {
			ISrvctrdiCudService srvctrdiCudService = ServiceFinder.find(ISrvctrdiCudService.class);
			// ISrvctrdiRService srvctrdiRService =
			// ServiceFinder.find(ISrvctrdiRService.class);
			// String whereStr = String.format(" id_hp = '%s' and code_srv_hp =
			// '%s' and eu_hpsrvtp = '%s' ", bdHpSrvCtrDiArr[0].getId_hp(),
			// bdHpSrvCtrDiArr[0].getCode_srv_hp());
			// BdHpSrvCtrDiDO[] hpSrvCtrDiDOs = srvctrdiRService.find(whereStr,
			// "", FBoolean.FALSE);
			// if(hpSrvCtrDiDOs != null && hpSrvCtrDiDOs.length >0){
			// srvctrdiCudService.delete(hpSrvCtrDiDOs);
			// }
			srvctrdiCudService.save(bdHpSrvCtrDiArr);
		}
	}
}
