package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.i.IScDaysLotService;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDORService;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.reg.dto.d.ResQrySchemeDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 诊间加号获取排班资源
 * 
 * @author liu bin
 *
 */
public class AddTickesSchBP {

	@SuppressWarnings("unchecked")
	public RegResDTO[] getSchListOfDoc(String deptId,String empId,FDate date, String scchltp)
			throws BizException {
		//查找医院诊间（本科）渠道ID
		String chlId = this.getchlId(scchltp);
		if(ScValidator.isEmptyIgnoreBlank(chlId))
			return null;
		//1.获取可用的时间分组ID集合
		String[] daysLotIds = getDaysLotIds();
		if(!ArrayUtil.isEmptyNoNull(daysLotIds)){
			//2、获取排班id集合
			GetEmpOrDepSchBP getEmpOrDepSchBP = new GetEmpOrDepSchBP();
			List<String> list = getEmpOrDepSchBP.getSchIds(deptId, empId, date, daysLotIds);
			if(!ListUtil.isEmpty(list)){
				//3.获取资源详细信息
				ResQrySchemeDTO qryScheme = new ResQrySchemeDTO();
				FArrayList schIdList = new FArrayList();
				schIdList.addAll(list);
				qryScheme.setIds_sch(schIdList);
				qryScheme.setId_scchl(chlId);
				qryScheme.setFg_quan(FBoolean.TRUE);//加载号源
				GetResBySchmBP getBP = new GetResBySchmBP();
				return getBP.exec(qryScheme);
			}
		}		
		return null;
	}
	/**
	 * 查找渠道ID
	 * 
	 * @return
	 * @throws BizException 
	 */
	private String getchlId(String scchltp) throws BizException{
		ISchedulechlMDORService serv = ServiceFinder.find(ISchedulechlMDORService.class);
		SchedulechlDO[] chls = serv.findByAttrValString(SchedulechlDO.SD_SCCHLTP, scchltp); 
		if(!ScValidator.isNullOrEmpty(chls))
			return chls[0].getId_scchl();
		return null;
	}
	/**
	 * 获取可用的时间分组ID集合
	 * 
	 * @return
	 * @throws BizException
	 */
	private String[] getDaysLotIds() throws BizException {
		IScDaysLotService dayslotQryService = ServiceFinder.find(IScDaysLotService.class);
		DaysLotDO[] daysLotDOs =  dayslotQryService.getAllowedDaysLots(IScDictCodeConst.SD_SCTP_OP, FBoolean.FALSE);
		if(!ArrayUtil.isEmptyNoNull(daysLotDOs)){
			int len = daysLotDOs.length;
			String[] daysLotIds = new String[len];
			for(int i=0;i<len;i++){
				daysLotIds[i] = daysLotDOs[i].getId_dayslot();
			}
			return daysLotIds;
		}
		return null;
	}
}
