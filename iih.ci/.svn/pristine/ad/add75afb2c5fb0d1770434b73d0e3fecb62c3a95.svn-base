package iih.ci.mr.s.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import iih.ci.mr.cimrpatsigns.d.CiMrHisDataDTO;
import iih.ci.mr.s.bp.qry.CiMrHisDataSql;
import iih.ci.mr.s.bp.qry.CustomItemSql;

public class CiMrHisDataBp {

	/**
	 * 获取患者历史生命体征数据 (xuxng_2016-05-03)
	 * @param id_ents
	 * @param id_mrtplvt
	 * @param dt_vt
	 * @return
	 * @throws BizException
	 */
	public CiMrHisDataDTO[] exec(String id_ents, String id_mrtplvt, String dt_vt) throws BizException {

		List<CiMrHisDataDTO> list = new ArrayList<CiMrHisDataDTO>();
		
		CiMrHisDataDTO[] tplData = getTplData(id_ents, id_mrtplvt, dt_vt);
		list.addAll(Arrays.asList(tplData));
		
		CiMrHisDataDTO[] customData = getCustomData(id_ents, dt_vt);
		list.addAll(Arrays.asList(customData));
		
		return list.toArray(new CiMrHisDataDTO[list.size()]);
	}

	/**
	 * 获取生命体征模板体征数据
	 * @param id_ents
	 * @param id_mrtplvt
	 * @param dt_vt
	 * @return
	 * @throws BizException
	 */
	public CiMrHisDataDTO[] getTplData(String id_ents, String id_mrtplvt, String dt_vt) throws BizException {

		CiMrHisDataSql Sql = new CiMrHisDataSql(id_ents, id_mrtplvt, dt_vt);
		
		CiMrHisDataDTO[] rtn = (CiMrHisDataDTO[]) AppFwUtil.getDORstWithDao(Sql, CiMrHisDataDTO.class);
		
		return rtn;
	}
	
	/**
	 * 获取自定义项目体征数据
	 * @param id_ents
	 * @param dt_vt
	 * @return
	 * @throws BizException
	 */
	public CiMrHisDataDTO[] getCustomData(String id_ents, String dt_vt) throws BizException {

		CustomItemSql Sql = new CustomItemSql(id_ents, dt_vt);
		
		CiMrHisDataDTO[] rtn = (CiMrHisDataDTO[]) AppFwUtil.getDORstWithDao(Sql, CiMrHisDataDTO.class);
		
		return rtn;
	}
	
}
