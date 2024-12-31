package iih.en.pv.s.bp.ip.qry;

import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.TransDepPatDTO;
import xap.mw.core.data.BizException;
/**
 *  获取转科转出病人总数
 *  TODO renying 严重问题，不能根据查询到集合，然后再获取数量，查询数量需要单写服务，直接查count即可。
 *  现有写法效率很差，查询了多余的表和多余的列，特别是包含了出科核查的校验
 *  其他获取总数的，也要同样调优
 *  待删除
 * @author Sarah
 *
 */
public class GetTransOutCountBP {
	/**
	 * 获取转科转出病人总数
	 * @param nurId 病区id
	 * @return
	 * @throws BizException
	 */
	public Integer exec(String nurId) throws BizException{		
		GetTransOutDepBP transDepBp = new GetTransOutDepBP();
		TransDepPatDTO[] appDTOArray = transDepBp.exec(nurId);;
		if(EnValidator.isEmpty(appDTOArray)){
			return 0;
		}
		return appDTOArray.length;
	}
}
