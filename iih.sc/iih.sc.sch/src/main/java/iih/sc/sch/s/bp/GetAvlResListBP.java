package iih.sc.sch.s.bp;

import iih.sc.comm.ScCollectionUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDORService;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.reg.dto.d.ResQrySchemeDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取可挂号资源BP
 * @author yankan
 *
 */
public class GetAvlResListBP {
	/**
	 * 获取可挂号资源
	 * @param date 日期
	 * @param dayslotId 午别，为null，则是全部
	 * @param depIds 科室id数组，若 为null则为全部
	 * @return 返回可挂号资源DTO
	 * @throws BizException
	 */
	public RegResDTO[] exec(FDate date,String dayslotId,String[] depIds,String empId, String scchltp) throws BizException{
		String scchlId = getchlId(scchltp);
		ResQrySchemeDTO qryScheme = new ResQrySchemeDTO();
		qryScheme.setDate(date);
		if(!ScValidator.isEmptyIgnoreBlank(scchlId))
			qryScheme.setId_scchl(scchlId);
		qryScheme.setId_dayslot(dayslotId);
		qryScheme.setIds_dep(ScCollectionUtils.arrayToList(depIds));
		if(!StringUtil.isEmpty(empId)){
			FArrayList empList = new FArrayList();
			empList.add(empId);
			qryScheme.setIds_emp(empList);
		}
		qryScheme.setFg_quan(FBoolean.TRUE);//加载号源
		GetResBySchmBP getBySchmBP = new GetResBySchmBP();
		return getBySchmBP.exec(qryScheme);
	}
	/**
	 * 查找渠道ID
	 * 
	 * @return
	 * @throws BizException 
	 */
	private String getchlId(String scchltp) throws BizException{
		if(ScValidator.isEmptyIgnoreBlank(scchltp))
			return null;
		ISchedulechlMDORService serv = ServiceFinder.find(ISchedulechlMDORService.class);
		SchedulechlDO[] chls = serv.findByAttrValString(SchedulechlDO.SD_SCCHLTP, scchltp); 
		if(!ScValidator.isNullOrEmpty(chls))
			return chls[0].getId_scchl();
		return null;
	}
}
