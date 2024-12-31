package iih.en.que.s.bp.pharm;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.quesite.d.QueSiteDO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取科室可选择站点列表
 * @author yank
 *
 */
public class GetDeptSiteBP {
	/**
	 * 获取科室可选择站点列表
	 * @param deptId 科室id
	 * @return
	 * @throws BizException
	 */
	public QueSiteDO[] exec(String deptId) throws BizException{
		StringBuilder sqlBuilder=new StringBuilder();
		sqlBuilder.append("SELECT SITE.* FROM BD_QUE_SITE SITE ");
		sqlBuilder.append(" LEFT JOIN BD_QUE QUE ON SITE.ID_QUE = QUE.ID_QUE");
		sqlBuilder.append(" WHERE QUE.ID_DEP=?");//科室
		sqlBuilder.append(" AND SITE.SD_QUESITETP = ? ");
		//sqlBuilder.append(" AND ISNULL(SITE.ID_EMP,'~')<>'~'");//有人的，TODO 暂停的是否处理
		sqlBuilder.append(" AND SITE.FG_ACTIVE = ? ");
		//sqlBuilder.append(" AND SITE.EU_PAUSE = ? ");
		SqlParam param = new SqlParam();
		param.addParam(deptId);
		param.addParam(IBdFcDictCodeConst.SD_QUESITETP_SENDM);
		param.addParam(FBoolean.TRUE);
		//param.addParam(PauseEnum.ONLINE);
		List<QueSiteDO> queSiteList = (List<QueSiteDO>) new DAFacade().execQuery(sqlBuilder.toString(), 
				param, new BeanListHandler(QueSiteDO.class));
		if(queSiteList!=null && queSiteList.size()>0){
			return queSiteList.toArray(new QueSiteDO[0]);
		}
		
		return null;
	}
}
