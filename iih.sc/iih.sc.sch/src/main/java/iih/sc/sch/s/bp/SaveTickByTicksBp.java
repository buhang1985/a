package iih.sc.sch.s.bp;

import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.d.desc.ScSchTickDODesc;
import iih.sc.sch.sctick.i.ISctickCudService;
import iih.sc.sch.sctick.i.ISctickRService;
import iih.sc.sch.scticks.d.ScSchTicksDO;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

/**号段生成号位
 * @author ccj
 *
 */
public class SaveTickByTicksBp {
	
	/**号段生成号位
	 * @param ticksDOs  号段数组
	 * @param sd_schrule  规则编码
	 * @throws BizException
	 */
	public void exec(ScSchTicksDO[] ticksDOs,String sd_schrule) throws BizException{
		if(ticksDOs == null || ticksDOs.length == 0 || StringUtils.isBlank(sd_schrule)) return;
		ISctickRService rService = ServiceFinder.find(ISctickRService.class);
		ISctickCudService tickCudSrv = ServiceFinder.find(ISctickCudService.class);
		// 删除号段下号位
		String whereStr = String.format("%s.id_sch=? ", ScSchTickDODesc.TABLE_ALIAS_NAME);
		SqlParamDTO param = new SqlParamDTO();
		param.addParam(ticksDOs[0].getId_sch());
		ScSchTickDO[] schTickDOs = rService.find2(whereStr, param, null, FBoolean.TRUE);
		if(ArrayUtils.isNotEmpty(schTickDOs)){
			tickCudSrv.delete(schTickDOs);
		}
		List<ScSchTickDO> tickList = new ArrayList<ScSchTickDO>();
		SaveSchTickBp schTickBp = new SaveSchTickBp(); 
		for (ScSchTicksDO scSchTicksDO : ticksDOs) {
			FTime beginTime =scSchTicksDO.getT_b();
			FTime endTime =scSchTicksDO.getT_e();
			Integer endTicket = scSchTicksDO.getQueno_b()+scSchTicksDO.getQuecn();  //结束票号 为开始票号+票号张数
			List<ScSchTickDO> list =  schTickBp.exec(beginTime,endTime,scSchTicksDO.getId_sch(),scSchTicksDO.getQuecn(),scSchTicksDO.getQuecn_appt(),scSchTicksDO.getQueno_b(),endTicket,scSchTicksDO.getId_ticks(),sd_schrule);
			tickList.addAll(list);
		}
		ScSchTickDO[] tickDOs = (ScSchTickDO[])tickList.toArray(new ScSchTickDO[tickList.size()]);
		tickCudSrv.save(tickDOs);
	}
}
