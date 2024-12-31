package iih.ci.ord.change;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.change.bp.OrdChangePersonOrdInfoBP;
/**
 * 医嘱变更单查询
 * @author zhangwq
 *
 */
public class OrdChangeService {          //                                                                             //结束时间             签署、停止                长临                              频次                                    用法                                  医护嘱
	public List<OrdChangePersonDTO> exec(String model,String id_ent,String changeDate,String ordstatus,String print,String end,String sign,String fg_long,String name_freq ,String name_route,String yhz,String sd_srvtp){//YH医护嘱
		if(StringUtils.isEmpty(id_ent)){
			return null;
		}
		//病区信息
		//人员和医嘱信息
		return new OrdChangePersonOrdInfoBP().exec(model,id_ent,changeDate,ordstatus, print,end, sign, fg_long, name_freq, name_route, yhz,sd_srvtp);
	}
}
