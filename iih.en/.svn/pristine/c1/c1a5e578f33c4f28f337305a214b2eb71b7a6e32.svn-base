package iih.en.que.s.bp;

import java.util.List;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.MedTechAppDTO;
import iih.en.que.dto.d.TriageQueSiteDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 自动分诊
 * 
 * @author Administrator
 *
 */
public class SaveAutoDiagnosis 
{

	/**
	 * 自动分诊
	 * @throws DAException 
	 */
	public FMap exec(EnQueueDO newQue,String id_que_site) throws BizException 
	{
		FMap resultMap = new FMap();
		String msg = "";
		resultMap.put("id_entque", newQue.getId_ent_que());
		// 1.获取在线站点和候诊数
		List<TriageQueSiteDTO> list = this.getOnlineSite(newQue.getId_queben(),id_que_site);
		if(list == null || list.size() == 0)
		{
			if(EnValidator.isEmpty(id_que_site))
			{
				msg = "自动分诊失败:未找到可分诊站点,请重新选择站点!";
				resultMap.put("msg", msg);
				return resultMap;
			}
			msg = "自动分诊失败:未找到上线站点!";
			resultMap.put("msg", msg);
			return resultMap;
		}
		
		// 2.比较最大候诊数,得到站点信息
		TriageQueSiteDTO siteDTO = this.getSite(list);
		if(siteDTO == null)
		{
			msg = "自动分诊失败:已上线站点都已达到最大候诊数!";
			resultMap.put("msg", msg);
			return resultMap;
		}
		
		// 3.分诊
		EnQueueDO enqueuedo = this.triageToSite(siteDTO, newQue.getId_ent_que());
		resultMap.put("apps", enqueuedo.getId_ent_que());
		msg = "自动分诊成功!";
		resultMap.put("msg", msg);
		return resultMap;
	}
	
	/**
	 * 分诊
	 * @param siteDTO
	 * @param id_ent_que
	 * @throws BizException 
	 */
	private EnQueueDO triageToSite(TriageQueSiteDTO siteDTO,String id_ent_que) throws BizException
	{
		MedTechAppDTO appDTO = new MedTechAppDTO();
		appDTO.setId_ent_que(id_ent_que);
		AllTriageBP allTriageBP = new AllTriageBP();
		return allTriageBP.triageToSiteAll(appDTO, siteDTO);
	}
	
	/**
	 *  超过最大申请数后,不能自动分诊
	 * @param list
	 * @return
	 */
	private TriageQueSiteDTO getSite(List<TriageQueSiteDTO> list)
	{
		for (TriageQueSiteDTO triageQueSiteDTO : list) {
			if(triageQueSiteDTO.getWaitnum() < triageQueSiteDTO.getApply_max())
			{
				return triageQueSiteDTO;
			}
		}
		return null;
	}

	/**
	 * 获取在线站点和候诊数
	 * @param id_queben  分诊台id
	 * @return
	 * @throws DAException
	 */
	public List<TriageQueSiteDTO> getOnlineSite(String id_queben,String id_que_site) throws DAException 
	{
		StringBuilder sql = new StringBuilder();
		SqlParam param = new SqlParam();
		sql.append("select Name_que,");
		sql.append("  Name_quesite,");
		sql.append("  Sitestatus,");
		sql.append("  waitnum,");
		sql.append("  id_que,");
		sql.append("  id_quesite,");
		sql.append("  apply_max,");
		sql.append("  ticketno");
		sql.append("  from (select q.name as Name_que,");
		sql.append("  s.name as Name_quesite,");
		sql.append("  s.eu_pause as Sitestatus,");
		sql.append("  count(eq1.id_ent_que) as waitnum,");
		sql.append("  q.id_que as id_que,");
		sql.append("  s.id_quesite as id_quesite,");
		sql.append("  nvl(max(ticketno),0) as ticketno,");
		sql.append("  s.apply_max");
		sql.append("  from bd_que q");
		sql.append(" inner join bd_que_site s");
		sql.append("    on q.id_que = s.id_que");
		sql.append("  left join en_ent_que eq1");
		sql.append("    on s.id_quesite = eq1.id_que_site");
		sql.append("   and eq1.dt_regist = to_char(sysdate, 'yyyy-MM-dd')");
		sql.append("   and eq1.sd_entque_tp = 9");
		//EnParamUtils.getIncludeOverNumberPat(depId);
		sql.append("   and eq1.sd_status_acpt in ( ?, ? )");
		sql.append(" where q.id_queben = ? ");
		sql.append("   and q.sd_quetp = ? ");
		sql.append("   and s.eu_pause = ? ");
		if(!EnValidator.isEmpty(id_que_site))
		{
			sql.append("   and s.id_quesite = ?");
		}
		sql.append(" group by q.name,");
		sql.append("     s.name,");
		sql.append("     s.eu_pause,");
		sql.append("     q.id_queben,");
		sql.append("     q.sd_quetp,");
		sql.append("     q.id_que,");
		sql.append("     s.id_quesite,");
		sql.append("     s.apply_max)");
		sql.append(" order by waitnum");
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALL);
		param.addParam(id_queben);
		param.addParam(IEnDictCodeConst.SD_QUEUE_CURRENCY);
		param.addParam(PauseEnum.ONLINE);
		
		if(!EnValidator.isEmpty(id_que_site))
		{
			param.addParam(id_que_site);
		}
		List<TriageQueSiteDTO> list = (List<TriageQueSiteDTO>) new DAFacade().execQuery(sql.toString(), param,
				new BeanListHandler(TriageQueSiteDTO.class));
		return list;
	}
}
