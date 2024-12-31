package iih.bl.cg.ip.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;

import iih.bd.pp.priboildes.d.BdPriBoilDesDO;
import iih.bd.pp.priboildes.i.IPriboildesRService;
import iih.bl.cg.dto.d.BoilDesReferBillDTO;
import iih.bl.cg.dto.d.SrvBoilDesInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 煎法要求关联费用
 * @author yangyang
 * @date 2018-07-11
 */
public class BoilDesWithBillBp {

	public BoilDesReferBillDTO[] exec(SrvBoilDesInfoDTO[] srvBoildesDtoArr) throws BizException
	{
		//1、医嘱域传来的服务，如果为空，代表没有需要处理的数据，返回空值
		if(ArrayUtils.isEmpty(srvBoildesDtoArr))
			return null;
		IPriboildesRService service=ServiceFinder.find(IPriboildesRService.class);
		BdPriBoilDesDO[] priBoilDoArr=service.find(" 1=1", "", FBoolean.FALSE);
		if(ArrayUtils.isEmpty(priBoilDoArr))
			return null;
		
		Map<String,BoilDesReferBillDTO> map=new HashMap<String,BoilDesReferBillDTO>();
		for(SrvBoilDesInfoDTO item:srvBoildesDtoArr)
		{
			if(item==null || StringUtil.isEmpty(item.getId_boildes()))
				continue;
			List<BdPriBoilDesDO> priBoilDesDoList=matchBoilDes(priBoilDoArr,item.getId_boildes());
			//如果重量收费标志
			//if(priBoilDesDo.getFg_weight().booleanValue())
			if(ListUtil.isEmpty(priBoilDesDoList))
				continue;
			for(BdPriBoilDesDO priBoilDesDo :priBoilDesDoList){
				String key=item.getId_srv() +priBoilDesDo.getId_priboildes();
				if(FBoolean.TRUE.equals(priBoilDesDo.getFg_weight()))
				{
					//因为煎法要求是作用到项目上的，有可能多个项目有此煎法要求
					FDouble fd=item.getQuan().div(priBoilDesDo.getQuan_per());
					BoilDesReferBillDTO referbillDto=new BoilDesReferBillDTO();
					
					if(map.containsKey(key))
					{
						BoilDesReferBillDTO tmp=map.get(priBoilDesDo.getId_priboildes());
						tmp.setQuan_medu(fd.add(tmp.getQuan_medu()));
						map.put(key, tmp);
					}
					else{
						referbillDto.setId_srv(priBoilDesDo.getId_srv());
						referbillDto.setName_srv(priBoilDesDo.getSrv_name());
						referbillDto.setQuan_medu(fd);
						referbillDto.setId_unit(priBoilDesDo.getId_unit());
						map.put(key,referbillDto);
					}
				}
				else{
					BoilDesReferBillDTO referbillDto=new BoilDesReferBillDTO();
					FDouble fd=priBoilDesDo.getQuan_medu();
					if(map.containsKey(key))
					{
						BoilDesReferBillDTO tmp=map.get(item.getId_srv());
						tmp.setQuan_medu(fd.add(tmp.getQuan_medu()));
						map.put(key, tmp);
					}
					else{
						referbillDto.setId_srv(priBoilDesDo.getId_srv());
						referbillDto.setName_srv(priBoilDesDo.getSrv_name());
						referbillDto.setQuan_medu(fd);
						referbillDto.setId_unit(priBoilDesDo.getId_unit());
						map.put(key,referbillDto);
					}
				}			
			}
		}
		return map.values().toArray(new BoilDesReferBillDTO[0]);
	}
	private List<BdPriBoilDesDO> matchBoilDes(BdPriBoilDesDO[] priBoilDoArr,String strIdBoilDes)
	{
		List<BdPriBoilDesDO> bdPriBoilDesDOList= new ArrayList<BdPriBoilDesDO>(); 
		for(BdPriBoilDesDO item:priBoilDoArr)
		{
			if(item.getId_boildes().equals(strIdBoilDes))
				bdPriBoilDesDOList.add(item);
		}
		return bdPriBoilDesDOList;
	}
}
