package iih.en.pv.s.bp.op;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.pp.primd.i.IPriCalService;
import iih.bd.srv.enregpkg.d.SrvEnRegPkgDO;
import iih.bd.srv.enregpkg.i.IEnregpkgRService;
import iih.en.comm.validator.EnValidator;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取病历本价格BP
 * @author yank
 *
 */
public class GetRecordPriceBP {
	public GetRecordPriceBP(){
		
	}
	/**
	 * 获取病历本价格
	 * @return
	 * @throws BizException
	 */
	public FDouble getRecordPrice() throws BizException{
		//1、查询病历本对应的基本服务
		IEnregpkgRService pkgRService = ServiceFinder.find(IEnregpkgRService.class);
		String whereStr = String.format("ID_ENTP='%s'",IBdFcDictCodeConst.ID_CODE_ENTP_OP);
		SrvEnRegPkgDO[] pkgArray = pkgRService.find(whereStr, null, FBoolean.TRUE);
		if(EnValidator.isEmpty(pkgArray)){
			throw new BizException("就诊登记包中未定义病历本");
		}
		
		//2、查询病历本服务价格		
		IPriCalService priCalService = ServiceFinder.find(IPriCalService.class);
		FDouble price = priCalService.CalSingleSrvStdPrice(pkgArray[0].getId_srv());
		return price;		
	}
}
