package iih.en.comm.ep;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EntQryModDTO;
import iih.en.pv.enres.d.EnAuthDO;
import iih.en.pv.enres.i.IEnauthCudService;
import iih.en.pv.enres.i.IEnauthRService;
import iih.en.pv.entagtp.d.EnTagTpDO;
import iih.en.pv.entagtp.i.IEntagtpCudService;
import iih.en.pv.entagtp.i.IEntagtpRService;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 
 * 
 * @author liubin
 *
 */
public class EntAuthEP {
	public EnAuthDO authComfirm(EnAuthDO authDO) throws BizException {
		// 1.保存do
		if(authDO.getId_entauth() == null){
			List<String> idents = this.search(authDO.getId_dep_to(), authDO.getId_emp_to(), authDO.getId_ent());
			if(idents != null && idents.size()>0){
				throw new BizException("患者已被授权给该医生，请编辑已授权的记录或选择其他医生");
			}
			authDO.setStatus(DOStatus.NEW);
		}else{
			authDO.setStatus(DOStatus.UPDATED);
		}
		authDO = save(authDO);
		 //2.保存 授权标签
		EnPatTpEP ep = new EnPatTpEP();
		ep.setEnAuthTag(authDO.getId_ent(), FBoolean.TRUE,authDO.getDt_end());
		return authDO;
	}

	public void cancelAuth(EnAuthDO authDO) throws BizException {
		// 刪除标签
		EnPatTpEP ep = new EnPatTpEP();
		ep.setEnAuthTag(authDO.getId_ent(), FBoolean.FALSE,authDO.getDt_end());
		// 1.保存do
		authDO.setDt_end(EnAppUtils.getServerDateTime());
		authDO.setStatus(DOStatus.UPDATED);
		save(authDO);

	}

	public EnAuthDO save(EnAuthDO authDO) throws BizException {
		IEnauthCudService cudService = ServiceFinder.find(IEnauthCudService.class);
		return cudService.save(new EnAuthDO[] { authDO })[0];
	}
	
	public List<String>  getEntIdsList (EntQryModDTO entQryDto, FDateTime time) throws DAException{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT AUTH.ID_ENT FROM EN_ENT_AUTH AUTH ");
		sb.append(" INNER JOIN EN_ENT EN ON AUTH.ID_ENT = EN.ID_ENT ");
		sb.append(" WHERE AUTH.ID_DEP_TO = ? AND AUTH.ID_EMP_TO = ? AND AUTH.DT_BEGIN<= ? AND AUTH.DT_END > ? ");
		SqlParam param=new SqlParam();
		param.addParam(entQryDto.getId_dep());
		param.addParam(entQryDto.getId_emp());
		param.addParam(time);
		param.addParam(time);
		if(!EnValidator.isEmpty(entQryDto.getCode_entp())){
			sb.append(" AND EN.CODE_ENTP = ? ");
			param.addParam(entQryDto.getCode_entp());
		}
		String sql = sb.toString();
		return (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
	}
	
	public List<String> search(String depId, String empId, String idEnt) throws DAException{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ID_ENT FROM EN_ENT_AUTH ");
		sb.append(" WHERE ID_DEP_TO = ? AND ID_EMP_TO = ? AND ID_ENT = ? and dt_end > ?");
		String sql = sb.toString();
		SqlParam param=new SqlParam();
		param.addParam(depId);
		param.addParam(empId);
		param.addParam(idEnt);
		param.addParam(EnAppUtils.getServerDateTime());
		return (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
	}
	
	public List<String> search(String idEnt) throws DAException{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT dt_end FROM EN_ENT_AUTH ");
		sb.append(" WHERE ID_ENT = ? and dt_end > ? order by dt_end desc ");
		String sql = sb.toString();
		SqlParam param=new SqlParam();
		param.addParam(idEnt);
		param.addParam(EnAppUtils.getServerDateTime());
		return (List<String>) new DAFacade().execQuery(sql, param, new ColumnListHandler());
	}
	
	/**
	 * 根据id_ent数组查找未过期的EnAuthDO数组
	 * 
	 * @param idEnt
	 * @return
	 * @throws DAException
	 */
	public EnAuthDO[] searchEnAuthDO(List<String> idEnt) throws BizException {
		IEnauthRService rService = ServiceFinder.find(IEnauthRService.class);
		String ids = SqlUtils.getInSqlByIds("ID_ENT", idEnt);
		String whereStr = String.format(" %s and dt_end > '%s' ", ids, EnAppUtils.getServerDateTime().toString());
		return rService.find(whereStr, "", FBoolean.FALSE);
	}

	/**
	 * 转科时对授权做处理
	 * @param idEnts
	 * @throws BizException
	 */
	public void dealForTransdep(List<String> idEnts) throws BizException{
		//设置记录
		setDtEndNowByIdEnt(idEnts);
		//查找标签
		EnTagTpDO[] dos = this.qryenTagTp(idEnts);
		//删除标签
		delEnTagTpDO(dos);
	}
	
	/**
	 * 将所有的授权记录设为当前时间（立即过期）
	 * @param idEnt
	 * @throws BizException
	 */
	public void setDtEndNowByIdEnt(List<String> idEnts) throws BizException {
		EnAuthDO[] dos = searchEnAuthDO(idEnts);
		if (EnValidator.isEmpty(dos)) {
			return;
		}
		FDateTime now = EnAppUtils.getServerDateTime();
		for (EnAuthDO au : dos) {
			au.setStatus(DOStatus.UPDATED);
			au.setDt_end(now);
		}
		IEnauthCudService cudService = ServiceFinder.find(IEnauthCudService.class);
		cudService.save(dos);
	}
	
	/**
	 * 根据ident集合查出所有的授权标签
	 * @param idEnts
	 * @return
	 * @throws BizException
	 */
	private EnTagTpDO[] qryenTagTp(List<String> idEnts) throws BizException{
		IEntagtpRService iCudService = ServiceFinder.find(IEntagtpRService.class);
		String ids = SqlUtils.getInSqlByIds("ID_ENT", idEnts);
		String whereStr = ids + " and code_tagtp = '"+IBdFcDictCodeConst.SD_TAGTP_ENAUTH+"' ";
		EnTagTpDO[] enTagTpDOs = iCudService.find(whereStr, null, FBoolean.FALSE);
		return enTagTpDOs;
	} 
	/**
	 * 删除
	 * @throws BizException
	 */
	private void delEnTagTpDO(EnTagTpDO[] enTagTpDOs) throws BizException{
		
		if (EnValidator.isEmpty(enTagTpDOs)) {
			return;
		}
		IEntagtpCudService iRService = ServiceFinder.find(IEntagtpCudService.class);
		iRService.delete(enTagTpDOs);	
	} 
}
