package iih.sc.sch.s.bp;

import iih.bd.res.dayslot.d.DayslotAggDO;
import iih.bd.res.dayslot.i.IDayslotRService;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.d.desc.ScSchTickDODesc;
import iih.sc.sch.sctick.i.ISctickCudService;
import iih.sc.sch.sctick.i.ISctickRService;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

/**排班生成号位
 * @author ccj 
 *
 */
public class SaveTickBySchBp {
	
	
	/**排班生成号位
	 * @param schDO 排班do
	 * @throws BizException
	 */
	public void exec(ScSchDO schDO,Integer state) throws BizException{
		if(schDO == null || state == null) return;
		ISctickCudService iSctickCudService = ServiceFinder.find(ISctickCudService.class);
		if(state == DOStatus.UPDATED){
			ISctickRService rService = ServiceFinder.find(ISctickRService.class);
			String whereStr = String.format("%s.id_sch=? ", ScSchTickDODesc.TABLE_ALIAS_NAME);
			SqlParamDTO param = new SqlParamDTO();
			param.addParam(schDO.getId_sch());
			ScSchTickDO[] dos = rService.find2(whereStr, param, null, FBoolean.TRUE);
			if(ArrayUtils.isNotEmpty(dos)){
				iSctickCudService.delete(dos);
			}
		}
		IDayslotRService daysloatSrv = ServiceFinder.find(IDayslotRService.class);
		DayslotAggDO dlotAgg = daysloatSrv.findById(schDO.getId_dayslot());
		FTime beginTime = dlotAgg.getParentDO().getTime_begin();  // 分组开始时间
		FTime endTime = dlotAgg.getParentDO().getTime_end();   //分组结束时间
		GetSdSchruleByIdSchBp byIdSch = new GetSdSchruleByIdSchBp();
		String sd_schrule = byIdSch.exec(schDO.getId_sch()); // 预约规则编码
		SaveSchTickBp schTickBp = new SaveSchTickBp(); 
		List<ScSchTickDO> tickList = schTickBp.exec(beginTime,endTime,schDO.getId_sch(),schDO.getQuan_total(),schDO.getQuan_total_appt(),1,schDO.getQuan_total(),null,sd_schrule);
		iSctickCudService.save(tickList.toArray(new ScSchTickDO[tickList.size()]));
	}
}
