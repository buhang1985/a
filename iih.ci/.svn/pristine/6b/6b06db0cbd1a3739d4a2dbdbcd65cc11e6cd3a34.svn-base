package iih.ci.ord.s.bp.cfg.rulecfg.rule.pres;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;


import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.s.bp.cfg.rulecfg.AbstractRuleExecutor;
import xap.lui.core.xml.StringUtils;

/**
 * 处方合并规则：成组药先单独成方，如果两个方子的数量不大于5，则可以合并为一个处方
 * 
 * @author zhangwq
 *
 */
public class PresMergerRule extends AbstractPresRuleExecutor {

	

	@Override
	public List<CiOrPresSplitList> startExecuteRule(List<CiOrPresSplitList> presSplitList) {
		//先根据每个处方的数量进行排序
		presSplitList = sortByPresNumAsc(presSplitList);
		//已经分完方的集合
		List<CiOrPresSplitList> hasPresedList = new ArrayList<CiOrPresSplitList>();
		//新的分方规则下返回分方数据
		List<CiOrPresSplitList> rstPresList = new ArrayList<CiOrPresSplitList>();
		for(int i=0;i<presSplitList.size();i++){
			//已经被分方合并处理过的数据，不再判断
			if(hasPresedList.contains(presSplitList.get(i)))
			{
				continue;
			}
			CiOrPresSplitList pres1 = presSplitList.get(i);
			hasPresedList.add(pres1);
			//如果当前处方的数量已经>=5了，不再合并，可放入返回的处方集合中，并且将当前处方数据记录到已经分完方的集合中
			if(pres1.getOrderList().size()>=5)
			{
				rstPresList.add(pres1);
				continue;
			}
			//创建一个新的处方dto，用于存放合并后的集合
			CiOrPresSplitList newPresSplit = new CiOrPresSplitList();
			BeanUtils.copyProperties(pres1, newPresSplit, new String[] {"cfgProps"});
			
			List<String> prestpwordList = new ArrayList<String>();
			String id_prestpwords = pres1.getId_prestpword();
			if(StringUtils.isNotEmpty(id_prestpwords)){
				prestpwordList = Arrays.asList(id_prestpwords.split(","));	
			}
			
			
			for(int j=i+1;j<presSplitList.size();j++){
				// 1、两个方子的处方类型得一致；
				if((presSplitList.get(j).getId_prestp() !=null && !presSplitList.get(j).getId_prestp().equals(pres1.getId_prestp())) 
						|| hasPresedList.contains(presSplitList.get(j)))
				{
					continue;
				}
				//2、处方标识相同（如果不限制，会导致医保患者毒麻处方和医保的处方合并到一起）				
				List<String> prestpwordListTemp = new ArrayList<String>();
				String id_prestpwordsTemp = presSplitList.get(j).getId_prestpword();
				if(StringUtils.isNotEmpty(id_prestpwordsTemp)){
					prestpwordListTemp = Arrays.asList(id_prestpwordsTemp.split(","));	
				}
				
				if(prestpwordListTemp.size() != prestpwordList.size()){
					continue;
				}
				
				for(String prestpword : prestpwordListTemp){
					if(!prestpwordList.contains(prestpword)){
						continue;
					}
				}
								
				//3、两个方子的药房得是同一个
				if(presSplitList.get(j).getOrderList()!=null&&presSplitList.get(j).getOrderList().size()>0
						&&pres1.getOrderList()!=null&&pres1.getOrderList().size()>0){
					String id_dep_wh = presSplitList.get(j).getOrderList().get(0).getId_dep_wh();
					//药房不一致的，不合单
					if(!id_dep_wh.equals(pres1.getOrderList().get(0).getId_dep_wh())){
						continue;
					}
				}
				CiOrPresSplitList pres2 = presSplitList.get(j);
				if((newPresSplit.getOrderList().size()+pres2.getOrderList().size())<=5)
				{
					newPresSplit.getOrderList().addAll(pres2.getOrderList());
					hasPresedList.add(presSplitList.get(j));
				}
			}
			rstPresList.add(newPresSplit);
		}
		// 如果存在下一个规则，执行下一个规则
		if (nextExecutor != null) {

			nextExecutor.request = this.request;
			nextExecutor.response = this.response;

			rstPresList = ((AbstractRuleExecutor<List<CiOrPresSplitList>>)nextExecutor).startExecuteRule(rstPresList);
		}		
		return rstPresList;		
	}
	private List<CiOrPresSplitList> sortByPresNumAsc(List<CiOrPresSplitList> presSplitList){
		if(presSplitList==null||presSplitList.size()==0)
		{
			return presSplitList;
		}
		CiOrPresSplitList[] presArrays =  presSplitList.toArray(new CiOrPresSplitList[presSplitList.size()]);
		for(int i=0;i<presArrays.length;i++){
			CiOrPresSplitList pres1 = presArrays[i];
			for(int j=i+1;j<presArrays.length;j++){
				CiOrPresSplitList pres2 = presArrays[j];
				if(pres2.getOrderList().size()<pres1.getOrderList().size())
				{
					presArrays[i] = pres2;
					presArrays[j] = pres1;
					pres1=pres2;
				}
			}
		}
		return Arrays.asList(presArrays);
	}
	@Override
	protected boolean isConformToTheRules(OrderPresSplitDTO orderPresSplit) {

		return true;
	}

	@Override
	protected boolean isForcedSplit() {

		return true;
	}

	@Override
	protected String getPresIdentification(OrderPresSplitDTO orderPresSplit) {
		// TODO Auto-generated method stub
		return null;
	}
}
