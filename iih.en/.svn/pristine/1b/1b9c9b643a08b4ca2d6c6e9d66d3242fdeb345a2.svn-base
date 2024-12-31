package iih.en.que.s.bp;

import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.MedTechAppDTO;
import iih.en.que.dto.d.TriageQueSiteDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;

/**
 * 批量分诊
 * @author Administrator
 *
 */
public class BatchTriageToSite {
	
	/**
	 * 批量分诊
	 * @return
	 * @throws BizException 
	 */
	public FMap exec(String id_ben ,String id_que_site) throws BizException
	{
		FMap resultMap = new FMap();
		String msg = "";
		//1.获取分诊台下的所有到诊未分诊患者
		MedTechAppDTO[] appDTOs = new GetAllChappPatinfoBP().exec(id_ben, "到诊", "ALL", "", FBoolean.FALSE);
		if(appDTOs==null || appDTOs.length == 0)
		{
			msg = "未找到需要自动分诊的患者!";
			resultMap.put("msg", msg);
			return resultMap;
		}
		
		//2.获取分诊台下的所有站点信息
		List<TriageQueSiteDTO> siteList = new SaveAutoDiagnosis().getOnlineSite(id_ben ,id_que_site);
		if(siteList == null || siteList.size() == 0)
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
		
		//3.循环分诊
		return this.autoTriage(appDTOs, siteList,resultMap);
	}
	
	
	/**
	 * 批量分诊,患者匹配站点
	 * @param appDTOs
	 * @param siteList
	 * @return
	 * @throws BizException 
	 */
	private FMap autoTriage(MedTechAppDTO[] appDTOs,List<TriageQueSiteDTO> siteList,FMap resultMap) throws BizException
	{
		AllTriageBP allTriageBP = new AllTriageBP();
		StringBuffer ids = new StringBuffer();
		for (MedTechAppDTO appDTO : appDTOs) 
		{
			TriageQueSiteDTO siteDTO = null;
			if(siteList.size() == 0)
			{
				resultMap.put("msg", "自动分诊失败:所有站点都已达到最大接诊数");
				return resultMap;
			}
			for (TriageQueSiteDTO triageQueSiteDTO : siteList) 
			{
				//判断等待数和最大接诊数
				if(triageQueSiteDTO.getWaitnum() < triageQueSiteDTO.getApply_max())
				{
					siteDTO = (TriageQueSiteDTO)triageQueSiteDTO.clone();
					//更新接诊数
					triageQueSiteDTO.setWaitnum( triageQueSiteDTO.getWaitnum() + 1);
					//更新最大顺序号
					triageQueSiteDTO.setTicketno(triageQueSiteDTO.getTicketno() + 1);
					siteDTO.setTicketno(triageQueSiteDTO.getTicketno());
					//如果接诊数等于最大接诊数,从集合中移除
					if(triageQueSiteDTO.getWaitnum() == triageQueSiteDTO.getApply_max())
					{
						siteList.remove(triageQueSiteDTO);
					}
					break;
				}
			}
			if (siteDTO == null) {
				if (ids.length() > 0) {
					resultMap.put("apps", ids.toString().substring(0,ids.length()-1));
			}
				resultMap.put("msg", "自动分诊失败:所有站点都已达到最大接诊数");
				return resultMap;
		}
			allTriageBP.updateQue(siteDTO, siteDTO.getTicketno(), appDTO);
			ids.append(appDTO.getId_ent_que()).append(",");
		}
		if(ids.length() > 0){
			resultMap.put("apps", ids.toString().substring(0,ids.length()-1));
		}
		resultMap.put("msg", "自动分诊成功!");
		return resultMap;
	}
}





















