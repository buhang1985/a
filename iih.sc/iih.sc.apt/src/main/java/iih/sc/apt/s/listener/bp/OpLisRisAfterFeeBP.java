package iih.sc.apt.s.listener.bp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import iih.sc.apt.scaptappl.d.ScAptApplItmDO;
import iih.sc.apt.scaptappl.i.IScAptApplItmDORService;
import iih.sc.comm.ScSqlUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 门诊收费时更新申请单费用标识
 * @author 
 *
 */
public class OpLisRisAfterFeeBP {
	
	/**
	 * 主流程
	 * @param idorlist
	 * @throws BizException
	 */
	public void exec(List<String> idorlist)throws BizException{
		String cond = ScSqlUtils.getInSqlByIds("id_or", idorlist);
		if(!StringUtil.isEmpty(cond)){
			// 更新预约申请单明细fg_bl标识
			this.updateScAptApplFgBl(cond);
			// 更新预约申请单fg_bl标识
			this.updScAptApplFgBl(cond);
		}
	}
	
	/**
	 * 更新预约申请单明细fg_bl标识
	 * @param cond
	 * @throws DAException 
	 */
	private void updateScAptApplFgBl(String cond) throws DAException {
		DAFacade dafacade = new DAFacade();
		StringBuffer sql = new StringBuffer();
		sql.append("update sc_apt_appl_itm set fg_bl ='Y' where ")
		.append(cond);
		dafacade.execUpdate(sql.toString());
	}

	/**
	 * 根据id_or 更新预约申请单fg_bl标识
	 * @param cond
	 * @throws DAException 
	 */
	private void updScAptApplFgBl(String cond) throws BizException{
		// 获取预约申请单id
		HashSet<String> idAppls = this.getIdAptAppl(cond);
		if(idAppls == null){
			return;
		}
		// 获取需重置收费标识的申请单id
		List<String> usedId = new ArrayList<String>();
		for (String idAppl : idAppls) {
			if(getScAptApplFgBl(idAppl)){
				usedId.add(idAppl);
			}
		}
		if(ListUtil.isEmpty(usedId)){
			return;
		}
		// 更改申请单fg_bl标识
		String inSql = ScSqlUtils.getInSqlByIds("appl.id_aptappl", usedId);
		DAFacade dafacade = new DAFacade();
		StringBuffer sql = new StringBuffer();
		sql.append("update sc_apt_appl appl set fg_bl ='Y' where  ")
		.append(inSql);
		dafacade.execUpdate(sql.toString());
	}
	
	/**
	 * 获取预约申请单id
	 * @param cond
	 * @return
	 * @throws DAException 
	 */
	private HashSet getIdAptAppl(String cond) throws DAException {
		DAFacade dafacade = new DAFacade();
		StringBuffer sql = new StringBuffer();
		sql.append("select id_aptappl from sc_apt_appl_itm where ")
		.append(cond);
		@SuppressWarnings("unchecked")
		List<String> appls = (List<String>) dafacade.execQuery(sql.toString(), new ColumnListHandler("id_aptappl"));
		if(ListUtil.isEmpty(appls)){
			return null;
		}
		return new HashSet<String>(appls);
	}

	/**
	 * 根据医嘱列表fg_bl判断申请单fg_bl标识（医嘱fg_bl全为true则申请单fg_bl为true）
	 *
	 * @param List<String>
	 * @throws BizException
	 * @author yu.b
	 */
	private Boolean getScAptApplFgBl(String idAppl) throws BizException{
		IScAptApplItmDORService service = ServiceFinder.find(IScAptApplItmDORService.class);
		ScAptApplItmDO[] dos = service.findByAttrValString("Id_aptappl", idAppl);
		Boolean fg_bl = true;
		if (dos != null) {
			for(ScAptApplItmDO scAptApplItmDO : dos){
				fg_bl = fg_bl && scAptApplItmDO.getFg_bl().booleanValue();
			}
			return fg_bl;
		} 
		return false;
	}
}
