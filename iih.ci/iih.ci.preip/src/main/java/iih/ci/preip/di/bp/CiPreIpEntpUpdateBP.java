package iih.ci.preip.di.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.i.ICidiagMDOCudService;
import iih.ci.sdk.utils.ObjectUtils;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 预住院转住院业务逻辑
 * @author zhengqiang
 *
 */
public class CiPreIpEntpUpdateBP {
	@SuppressWarnings("unchecked")
	public CiDiagDO[] exec(String id_en, String code_entp) throws BizException{
		if(ObjectUtils.isEmpty(id_en)){
			throw new BizException(" parameter: id_en  is null");
		}
		//更新ci_di
		StringBuilder Sql = new StringBuilder();
		Sql.append("select * from ci_di where id_en = ? and code_entp = ?");
		SqlParam SqlParam = new SqlParam();
		SqlParam.addParam(id_en);
		SqlParam.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_IP_PRE);
		List<CiDiagDO> diagDO = (List<CiDiagDO>) new DAFacade().execQuery(Sql.toString(), SqlParam, new BeanListHandler(CiDiagDO.class));
		for(CiDiagDO diag : diagDO){
			diag.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
			diag.setId_entp(IBdFcDictCodeConst.ID_CODE_ENTP_IP);
			diag.setStatus(DOStatus.UPDATED);
		}
		//更新后保存到ci_di表
		CiDiagDO[] diagDOs = ServiceFinder.find(ICidiagMDOCudService.class).save(diagDO.toArray(new CiDiagDO[0]));
		return diagDOs;
	}

}
