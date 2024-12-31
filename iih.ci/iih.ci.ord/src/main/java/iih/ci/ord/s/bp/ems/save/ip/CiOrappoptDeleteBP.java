package iih.ci.ord.s.bp.ems.save.ip;

import java.util.List;

import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.cior.d.OrdApOpAgainDO;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.cior.i.IOrdApOpAgainDOCudService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/*
 * 手术申请删除操作BP
 */
public class CiOrappoptDeleteBP {
	/**
	 * 手术申请删除
	 * @param orappmap
	 * @param id_or
	 * @throws BizException
	 */
	public CiorappsurgeryAggDO[] exec(String id_or) throws BizException{
		if(CiOrdUtils.isEmpty(id_or))return null;
		CiOrappoptGetBP bp=new CiOrappoptGetBP();
		CiorappsurgeryAggDO[] dos=bp.exec(id_or);
		CiOrdAppUtils.getOrappsurgerytService().delete(dos);;
		//将本次就诊下相同手术部位且未签署的二次手术申请单删除
		//因为：开立两个手术A和B，是相同部位时。先签署B，再签署A，此时A会提示二次手术申请。将B撤回后删除，再签署A，还会提示二次手术申请。所以将B删除时要将本次就诊下相同手术部位且未签署的二次手术申请单删除
		if(dos!=null&&dos.length>0){
			OrdApOpDO ordApOpDO = dos[0].getParentDO();
			String sd_surgical_site = ordApOpDO.getSd_surgical_site();
			OrdApOpAgainDO[] agains = getSameSiteSug(id_or,sd_surgical_site);
			if(agains!=null&&agains.length>0){
				IOrdApOpAgainDOCudService againService = ServiceFinder.find(IOrdApOpAgainDOCudService.class);
				againService.delete(agains);
			}
		}
		return dos;
	}
	/**
	 * 查询是否已经存在同部位的二次手术申请单
	 * @param id_ent
	 * @param id_apop
	 * @param sd_surgical_site
	 * @return
	 * @throws DAException
	 */
	private OrdApOpAgainDO[] getSameSiteSug(String id_or,String sd_surgical_site) throws DAException{
		DAFacade dao = new DAFacade();
		SqlParam param = new SqlParam();
		param.addParam(id_or);
		param.addParam(sd_surgical_site);
		List<OrdApOpAgainDO> ordApOps= (List<OrdApOpAgainDO>)dao.execQuery(getSameSiteSugSql(), param, new BeanListHandler(OrdApOpAgainDO.class));
		if(ordApOps!=null&&ordApOps.size()>0){
			return ordApOps.toArray(new OrdApOpAgainDO[0]);
		}
		return null;
	}
	private String getSameSiteSugSql(){
		StringBuilder sb = new StringBuilder();
		sb.append("select ");
		sb.append("again.* ");
		sb.append("from ci_ap_sug sug "); 
        sb.append("left join ci_order ci on sug.id_or = ci.id_or ");
        sb.append("left join ci_ap_sug_again again on sug.id_apop=again.id_apop ");
		sb.append("where ci.fg_canc='N' and ci.id_en=(select id_en from ci_order where id_or=?) and ci.fg_sign='N' and sug.sd_surgical_site=? ");
		return sb.toString();
	}
}
