package iih.sc.sch.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch.qos.logback.core.Context;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.comm.ScValidator;
import iih.sc.sch.dto.d.MtSchMgrDTO;
import iih.sc.sch.s.bp.qry.GetAllMtSchMgr4SingleSql;
import iih.sc.sch.s.bp.qry.GetMtSchMgrSql;
import iih.sc.sch.s.bp.qry.GetSrvNamesSql;
import iih.sc.sch.sctick.d.ScSchTickDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 获取单个医技排班所有扼要信息
 * 
 * @author yzh
 */
public class GetAllSchMgrBrief4SingleBP {

	/**
	 * 获取单个医技排班所有扼要信息
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
	public MtSchMgrDTO[] exec(String depId, String scresId, String srvId,String sd_sctp) throws BizException {
		// 校验数据是否有值
		ScValidator.validateParam("id_dep", depId);
		FDate d_b = ScAppUtils.getServerDate();
		// 获取区间内排班
		MtSchMgrDTO[] retDtos = (MtSchMgrDTO[]) AppFwUtil.getDORstWithDao(new GetAllMtSchMgr4SingleSql(d_b,depId, scresId, srvId,sd_sctp), MtSchMgrDTO.class);
		return retDtos;
	}
}
