package iih.sc.apt.s.bp.ip;

import iih.bd.res.bed.d.Bdbed;
import iih.bd.res.bed.d.BedDTO;
import iih.bd.res.bed.i.IBedMDOCudService;
import iih.bd.res.bed.i.IBedMDORService;
import iih.sc.apt.aptip.d.AptIpDO;
import iih.sc.apt.aptip.i.IAptipMDOCudService;
import iih.sc.apt.aptip.i.IAptipMDORService;
import iih.sc.apt.dto.d.AptIpDTO;
import iih.sc.apt.dto.d.EuStatus;
import iih.sc.apt.s.bp.GetDeplNurBp;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;

/**
 * 为住院预约分配床位
 * 
 * @author zhouliming
 *
 */
public class AptBedBP {
	/**
	 * 预约床位
	 * 
	 * @param aptDTO 住院预约DTO
	 * @param bedDTO 床位信息
	 * @throws BizException
	 */
	public void exec(AptIpDTO aptDTO, BedDTO bedDTO) throws BizException {
		// 校验预约信息的有效性
		if (!validate(aptDTO, bedDTO)) {
			return;
		}
		String psnId = ScContextUtils.getPsnId();// 获取用户id
		String id_bed = bedDTO.getId_bed();
		String id_scaptip = aptDTO.getId_scaptip();
		// 更新申请单状态
		IAptipMDORService rService = ServiceFinder.find(IAptipMDORService.class);
		IAptipMDOCudService cudService = ServiceFinder.find(IAptipMDOCudService.class);
		AptIpDO aptIpDO = rService.findById(id_scaptip);
		if (aptIpDO == null) {
			throw new BizException(IScMsgConst.SC_APT_IP_HAS_REVOKE);// 该申请单已经撤销，请刷新后重试！
		}
		aptIpDO.setSd_status(EuStatus.ARRANG);// 申请单状态设置为预约
		aptIpDO.setId_bed(id_bed);
		aptIpDO.setId_emp_appt(psnId);
		aptIpDO.setRsn_refuse(null);// 清空拒绝原因
		aptIpDO.setDt_appt(ScAppUtils.getServerDateTime());// 预约时间
		cudService.update(new AptIpDO[] { aptIpDO });

		// 修改床位状态
		IBedMDORService bedRService = ServiceFinder.find(IBedMDORService.class);
		IBedMDOCudService bedCudService = ServiceFinder.find(IBedMDOCudService.class);
		Bdbed bdbed = bedRService.findById(id_bed);
		if (aptIpDO == null) {
			throw new BizException(IScMsgConst.SC_APT_IP_HAS_REVOKE);// 该申请单已经撤销，请刷新后重试！
		}
		bdbed.setFg_appt(FBoolean.TRUE);
		bedCudService.update(new Bdbed[] { bdbed });
	}

	/**
	 * 校验预约信息的有效性
	 * 
	 * @param aptDTO
	 * @param bedDTO
	 * @throws BizException
	 */
	private boolean validate(AptIpDTO aptDTO, BedDTO bedDTO) throws BizException {
		if (aptDTO == null || bedDTO == null) {
			throw new BizException(IScMsgConst.SC_APT_IP_ISNULL);
		}

		// 1.判断申请病人的状态是否为申请状态、床位状态未预约。如果不是，不允许预约
		String sd_status = aptDTO.getSd_status();
		FBoolean fg_appt = bedDTO.getFg_appt();
		if (!(sd_status.equals(EuStatus.APPY) || sd_status.equals(EuStatus.REJECT)) || fg_appt.equals(FBoolean.TRUE)) {
			throw new BizException(IScMsgConst.SC_APT_IP_APPT);
		}

		// 2.校验存在业务线的申请科室是否与所选床位的病区相匹配
		String id_dep = aptDTO.getId_dep_phy_ip();// 申请科室
		String id_nur = bedDTO.getId_dep_belong();// 所属病区
		if (!matchDepANDNur(id_dep, id_nur)) {
			throw new BizException(IScMsgConst.SC_APT_IP_NURANDDEP);
		}
		return true;
	}

	/**
	 * 校验存在业务线的申请科室是否与所选床位的病区相匹配
	 * 
	 * @param id_dep
	 * @param id_nur
	 * @throws DAException
	 */
	public Boolean matchDepANDNur(String id_dep, String id_nur) throws DAException {
		// String sd_deptp = IBdResDictCodeConst.SD_DEPLTP_DEPNUR;//业务线类型
		// String depRole = IBdResDictCodeConst.SD_DEPROLE_DEP;//科室角色
		// String nurRole = IBdResDictCodeConst.SD_DEPROlE_NUR;//部门角色
		//
		// StringBuffer sb = new StringBuffer();
		// sb.append("select n.id_dep ");
		// sb.append("  from bd_depl_dep p ");
		// sb.append(" inner join bd_depl depl ");
		// sb.append("	on p.id_depl = depl.id_depl ");
		// sb.append(" and depl.sd_deptltp = ? ");
		// sb.append(" and depl.activestate = '2' ");
		// sb.append(" inner join bd_depl_dep n ");
		// sb.append("	on depl.id_depl = n.id_depl ");
		// sb.append(" and n.sd_deplrole like ? ");
		// sb.append(" where p.sd_deplrole like ? ");
		// sb.append(" and p.id_dep = ? ");
		//
		// SqlParam sqlParam = new SqlParam();
		// sqlParam.addParam(sd_deptp);
		// sqlParam.addParam(nurRole+"%");
		// sqlParam.addParam(depRole+"%");
		// sqlParam.addParam(id_dep);
		//
		// List<String> list = (List<String>) new
		// DAFacade().execQuery(sb.toString(),sqlParam,new ColumnListHandler());
		GetDeplNurBp bp = new GetDeplNurBp();
		String depNurList = bp.exec(id_dep);
		if (StringUtils.isBlank(depNurList) || depNurList.contains(id_nur)) {
			return true;
		}
		return false;
	}
}
