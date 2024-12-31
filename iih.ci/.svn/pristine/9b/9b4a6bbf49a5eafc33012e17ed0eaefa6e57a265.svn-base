package iih.ci.preop.di.bp;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.i.ICidiagMDOCudService;
import iih.ci.sdk.database.SqlParamBuilder;
import iih.ci.sdk.utils.ObjectUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 预住院转门诊诊断业务逻辑类
 * @author zhengqiang
 *
 */
public class CiPreOpEntpUpdateBP {

	public CiDiagDO[] exec(String id_en) throws BizException{
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
			//更新就诊类型
			diag.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
			diag.setId_entp(IBdFcDictCodeConst.ID_CODE_ENTP_OP);
			//更新诊断类型
			diag.setId_ditp(ICiDictCodeConst.ID_OPDI);
			diag.setCode_ditp(ICiDictCodeConst.SD_OPDI);
			diag.setStatus(DOStatus.UPDATED);
		}
		//更新后保存到ci_di表
		CiDiagDO[] diagDOs = ServiceFinder.find(ICidiagMDOCudService.class).save(diagDO.toArray(new CiDiagDO[0]));
		return diagDOs;
	}
}
