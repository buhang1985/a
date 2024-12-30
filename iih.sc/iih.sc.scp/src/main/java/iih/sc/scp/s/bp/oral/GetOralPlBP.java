package iih.sc.scp.s.bp.oral;

import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scp.dto.d.OralPlDTO;
import iih.sc.scp.s.ep.OralScplEP;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scploptsrv.d.ScPlOptSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 获取口腔排班
 * 
 * @author liubin
 *
 */
public class GetOralPlBP {
	
	private OralScplEP ep = null;
	
	public GetOralPlBP(){
		ep = new OralScplEP();
	}
	/**
	 * 获取口腔排班计划
	 * @param plId 排班计划ID
	 * @return
	 * @throws BizException
	 */
	public OralPlDTO exec(String plId) throws BizException {
		if(ScValidator.isEmptyIgnoreBlank(plId))
			return null;
		//查询计划
		ScPlanDO pl = this.getScPl(plId);
		if(pl == null)
			return null;
		//查询备选服务
		ScPlOptSrvDO[] optSrv = this.getScplOptSrvByPlId(plId);
		//组装备选服务给ScPlanDO
		this.processScPlanDO(pl, optSrv);
		OralPlDTO oralPl = new OralPlDTO();
		oralPl.setId_scpl(pl.getId_scpl());
		oralPl.setScpl_list(ScAppUtils.doArray2List(pl));
		oralPl.setOptsrv_list(ScAppUtils.doArray2List(optSrv));
		
		GetOralPlWeekBP oralPlWeekBP = new GetOralPlWeekBP();
		FArrayList weekList = oralPlWeekBP.getOralPlTickList(plId);
		oralPl.setWeek_list(weekList);
		return oralPl;
	}
	/**
	 * 查询计划
	 * 
	 * @param plId
	 * @return
	 * @throws BizException
	 */
	private ScPlanDO getScPl(String plId) throws BizException{
		return this.ep.getPlanById(plId);
	}
	/**
	 * 根据排班Id获取备选服务
	 * @param plId
	 * @return
	 * @throws BizException
	 */
	private ScPlOptSrvDO[] getScplOptSrvByPlId(String plId) throws BizException{
		return this.ep.getScplOptSrvByPlId(plId);
	}
	/**
	 * 
	 * 
	 * @param pl
	 * @param srvs
	 */
	private void processScPlanDO(ScPlanDO pl, ScPlOptSrvDO[] srvs){
		if(ScValidator.isNullOrEmpty(srvs))
			return;
		StringBuilder srvIds = new StringBuilder();
		StringBuilder srvNames = new StringBuilder();
		boolean isFirst = true;
		for(ScPlOptSrvDO srv : srvs){
			if(!isFirst){
				srvIds.append(",");
				srvNames.append(",");
			}
			srvIds.append(srv.getId_scsrv());
			srvNames.append(srv.getName_srv());
			isFirst = false;
		}
		pl.setId_optsrv(srvIds.toString());
		pl.setName_optsrv(srvNames.toString());
	}
	
}
