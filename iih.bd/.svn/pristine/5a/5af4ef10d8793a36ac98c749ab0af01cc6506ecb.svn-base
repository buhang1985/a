package iih.bd.srv.s.bp;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import iih.bd.srv.dto.d.EmsDynamicParamDTO;
import iih.bd.srv.ems.d.EmsDynamicIndexDTO;
import iih.bd.srv.pub.BdSrvUtils;
import iih.bd.srv.s.bp.qry.GetEmsDynamicIndexQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获得医疗单对应的动态指标数据信息集合操作BP
 */
public class GetEmsDynamicIndexInfosBP {
	/**
	 * 获得医疗单对应的动态指标数据信息集合
	 * @param id_ems
	 * @throws BizException
	 */
	public EmsDynamicIndexDTO[] exec(EmsDynamicParamDTO paramDto) throws BizException
	{
		String id_ems = paramDto.getId_ems();
		boolean fg_dyncitm_en = paramDto.getFg_dyncitm_en();
		Integer eu_dyncitmunit = paramDto.getEu_dyncitmunit();
		Integer dyncitmunitct = paramDto.getDyncitmunitct();
		String id_ent = paramDto.getId_ent();
		String id_pat = paramDto.getId_pat();
		if(BdSrvUtils.isEmpty(id_ems))return null;
		Calendar   rightNow   =   Calendar.getInstance();  
		if(dyncitmunitct==null)
			dyncitmunitct=1;
		if(eu_dyncitmunit==null||eu_dyncitmunit==0){
			rightNow.add(Calendar.HOUR_OF_DAY, -dyncitmunitct);
		}else if(eu_dyncitmunit==1){
			rightNow.add(Calendar.DAY_OF_MONTH, -dyncitmunitct);
		}else if(eu_dyncitmunit==2){
			rightNow.add(Calendar.MONTH, -dyncitmunitct);
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		String startDate = df.format(rightNow.getTime());
		GetEmsDynamicIndexQry qry = new GetEmsDynamicIndexQry(id_ems,startDate,fg_dyncitm_en,id_ent,id_pat);
		EmsDynamicIndexDTO[] rtn = (EmsDynamicIndexDTO[])AppFwUtil.getDORstWithDao(qry, EmsDynamicIndexDTO.class);

		return rtn;
	}
}
