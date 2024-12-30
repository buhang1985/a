package iih.sc.sch.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch.qos.logback.core.Context;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScValidator;
import iih.sc.sch.dto.d.MtSchMgrDTO;
import iih.sc.sch.s.bp.qry.GetMtSchMgrSql;
import iih.sc.sch.s.bp.qry.GetSrvNamesSql;
import iih.sc.sch.sctick.d.ScSchTickDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 医技排班管理扼要信息
 * 
 * @author lj
 */
public class GetSchMgrBriefBP {

	/**
	 * 医技排班管理扼要信息
	 * 
	 * @param dt_b
	 *            开始时间
	 * @param dt_e
	 *            结束时间
	 * @param depId
	 *            所属科室
	 * @param scresId
	 *            排班服务
	 * @param srvId
	 *            排班资源
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public MtSchMgrDTO[] exec(FDate dt_b, FDate dt_e, String depId, String scresId, String srvId,String sd_sctp,String loadType) throws BizException {
		// 校验数据是否有值
		ScValidator.validateParam("id_dep", depId);
		ScValidator.validateParam("dt_b", dt_b);
		ScValidator.validateParam("dt_e", dt_e);
		// 获取区间内排班
		MtSchMgrDTO[] retDtos = (MtSchMgrDTO[]) AppFwUtil.getDORstWithDao(new GetMtSchMgrSql(dt_b, dt_e, depId, scresId, srvId,sd_sctp,loadType), MtSchMgrDTO.class);
		// 判断是否有排班数据
		if (retDtos != null && retDtos.length != 0) {
			// 定义排班map
			Map<String, FArrayList> map = new HashMap<String, FArrayList>();
			// 查询服务所在的排班的编号定义
			List<String> schIdList = new ArrayList();;
			// 循环排班数据并添加到条件字段中并添加到map中
			for (MtSchMgrDTO mtSchMgrDTO : retDtos) {
				map.put(mtSchMgrDTO.getId_sch(), new FArrayList());
				schIdList.add(mtSchMgrDTO.getId_sch());
			}
			// 获取相关服务 sql 中进插入DO 的 id_sch 与 name 字段
			ScSchTickDO[] tickDOs = (ScSchTickDO[]) AppFwUtil.getDORstWithDao(new GetSrvNamesSql(schIdList), ScSchTickDO.class);

			// 根据服务编号获取对应服务并添加到服务的集合中
			for (ScSchTickDO scSchTickDO : tickDOs) {
				map.get(scSchTickDO.getId_sch()).add(scSchTickDO.getName());
			}
			// 将集合的服务添加到排班的号位字段中
			for (MtSchMgrDTO mtSchMgrDTO : retDtos) {
				mtSchMgrDTO.setSch_tick_list(map.get(mtSchMgrDTO.getId_sch()));
			}
		}
		return retDtos;
	}
}
