package iih.bd.fc.s.bp.orwfcfg.query;

import java.util.ArrayList;
import java.util.List;

import iih.bd.fc.dto.qryorwf.d.QryOrWfCondDTO;
import iih.bd.fc.dto.qryorwf.d.QryOrWfResDTO;
import iih.bd.fc.i.IBdFcQryService;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.s.bp.orwfcfg.qry.GetSrvBaseInfoSql;
import iih.bd.fc.wf.d.EnumFLowTp;
import iih.bd.fc.wf.d.EnumFlow;
import iih.bd.fc.wf.d.OrRecurTypeEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * @Description:医嘱流向查询
 * @author: xu_xing@founder.com.cn
 * @version：2019年5月5日 下午1:16:28 创建
 */
public class OrWfCfgQueryBp {

	/**
	 * 主入口
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public QryOrWfResDTO[] exec(QryOrWfCondDTO inParam) throws BizException {

		//1、初始化参数值
		OrWfExDeptParamDTO param = initParam(inParam);

		//2、流向匹配
		OrWfExDeptDTO[] cfgs = matchQry(param);

		//3、返回数据组装
		QryOrWfResDTO[] rtns = pakageRtn(cfgs);

		return rtns;
	}

	/**
	 * 获取流向计算参数
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private OrWfExDeptParamDTO initParam(QryOrWfCondDTO param) throws BizException {
		if (param == null)
			throw new BizException("医嘱流向查询，参数空异常！");
		if (StringUtil.isEmptyWithTrim(param.getId_srv()))
			throw new BizException("医嘱流向查询，必须指定医疗服务！");
		GetSrvBaseInfoSql sql = new GetSrvBaseInfoSql(param.getId_srv());
		OrWfExDeptParamDTO[] rtns = (OrWfExDeptParamDTO[]) AppFwUtil.getDORstWithDao(sql, OrWfExDeptParamDTO.class);
		if (rtns == null || rtns.length < 1)
			throw new BizException("医嘱流向查询，获取医疗服务【" + param.getId_srv() + "】基本信息失败！");
		if (rtns.length > 1 && StringUtil.isEmptyWithTrim(param.getId_mm()))
			throw new BizException("医嘱流向查询，当前医疗服务关联了多个物品，请指定具体的物品！");
		OrWfExDeptParamDTO rtn = rtns[0];
		rtn.setEu_wftp(EnumFlow.NULL);
		rtn.setCode_entp(param.getCode_entp());
		rtn.setId_srv(param.getId_srv());
		//UI上有指定具体物品，优先使用UI上指定的
		if (!StringUtil.isEmptyWithTrim(param.getId_mm()))
			rtn.setId_mm(param.getId_mm());
		rtn.setId_usage(param.getId_route());
		rtn.setId_dept_or(param.getId_dep_or());
		rtn.setId_dept_en(param.getId_dep_phy());
		rtn.setId_dept_ns(param.getId_dep_nur());
		rtn.setId_dept_ex(param.getId_dep_ex());
		rtn.setRecurstr(param.getFg_long() + "");
		rtn.setDt_birth(param.getDt_birth());
		//长临
		if (FBoolean.TRUE.equals(param.getFg_long())) {
			rtn.setRecurstr(OrRecurTypeEnum.LONG.toString());
		} else {
			rtn.setRecurstr(OrRecurTypeEnum.TEMP.toString());
		}
		rtn.setFg_pres_outp(param.getFg_pres_out());
		if (param.getDt_effe() != null) {
			rtn.setTimestr(new FTime(param.getDt_effe().getTime()));
			int week = param.getDt_effe().getWeek();
			rtn.setWeekno("0" + week);
			if (week == 0)
				rtn.setWeekno("07");
		}
		return rtn;
	}

	/**
	 * 流向匹配
	 * @param params
	 * @return
	 * @throws BizException
	 */
	public OrWfExDeptDTO[] matchQry(OrWfExDeptParamDTO param) throws BizException {
		return ServiceFinder.find(IBdFcQryService.class).getOrExDeptMainBP(param);
	}

	/**
	 * 返回数据组装
	 * 
	 * @param dtos
	 * @return
	 */
	private QryOrWfResDTO[] pakageRtn(OrWfExDeptDTO[] rtns) {
		if (rtns == null || rtns.length < 1)
			return null;
		List<QryOrWfResDTO> reList = new ArrayList<QryOrWfResDTO>();
		for (OrWfExDeptDTO rtn : rtns) {
			QryOrWfResDTO dto = new QryOrWfResDTO();
			dto.setId_wf(rtn.getId_wf());
			dto.setName_wf(rtn.getName_wf());
			dto.setEu_wftp(rtn.getEu_wftp());
			dto.setName_wftp(rtn.getEu_wftp() == EnumFLowTp.EXECUTEFLOW ? "执行流向" : "物资流向");
			dto.setId_dept(rtn.getId_dept());
			dto.setName_dept(rtn.getName_dept());
			dto.setId_orgmp(rtn.getId_org());
			dto.setName_orgmp(rtn.getName_org());
			dto.setSort_no(rtn.getSortno());
			reList.add(dto);
		}
		return reList.toArray(new QryOrWfResDTO[0]);
	}
}
