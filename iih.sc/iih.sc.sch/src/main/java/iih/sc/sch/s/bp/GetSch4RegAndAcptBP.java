package iih.sc.sch.s.bp;

import java.util.List;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScCollectionUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.scbd.schedulechl.i.ISchedulechlMDORService;
import iih.sc.sch.reg.dto.d.RegResDTO;
import iih.sc.sch.reg.dto.d.ResQrySchemeDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 接诊挂号获取医生排班
 * 
 * @author liubin
 *
 */
public class GetSch4RegAndAcptBP {
	/**
	 * 接诊挂号获取医生排班
	 * 
	 * @param depId 科室id
	 * @param empId 医生id
	 * @param date 日期
	 * @param dayslotId 当前时间分组
	 * @return
	 * @throws BizException
	 * @author liubin
	 */
	public RegResDTO[] exec(String depId,String empId,FDate date, String dayslotId) throws BizException{
		if(StringUtil.isEmptyWithTrim(depId)||StringUtil.isEmptyWithTrim(dayslotId)||date==null){
			return null;
		}
		//查找医院诊间（本科）渠道ID
		String chlId = this.getchlId();
		if(ScValidator.isEmptyIgnoreBlank(chlId))
			return null;
		//医生可接诊挂号排班
		GetEmpOrDepSchBP empOrDepSchBP = new GetEmpOrDepSchBP();
		List<String> schIdList = empOrDepSchBP.getSchIds(depId, empId, date, new String[]{dayslotId});
		if(!ListUtil.isEmpty(schIdList)){
			ResQrySchemeDTO qryScheme = new ResQrySchemeDTO();
			qryScheme.setIds_sch(ScCollectionUtils.arrayToList(schIdList.toArray(new String[0])));
			qryScheme.setFg_reg(FBoolean.FALSE);
			qryScheme.setId_scchl(chlId);
			qryScheme.setFg_quan(FBoolean.TRUE);//加载号源
			GetResBySchmBP getBySchmBP = new GetResBySchmBP();
			return getBySchmBP.exec(qryScheme);
		}
		return null;
	}
	/**
	 * 查找医院诊间（本科）渠道ID
	 * 
	 * @return
	 * @throws BizException 
	 */
	private String getchlId() throws BizException{
		ISchedulechlMDORService serv = ServiceFinder.find(ISchedulechlMDORService.class);
		SchedulechlDO[] chls = serv.findByAttrValString(SchedulechlDO.SD_SCCHLTP, IScDictCodeConst.SD_SCCHLTP_HOSPITAL_ROOM_DEPT); 
		if(!ScValidator.isNullOrEmpty(chls))
			return chls[0].getId_scchl();
		return null;
	}
}
