package iih.ei.sc.s.bp.oper;

import java.util.List;


import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.ei.sc.s.bp.qry.IsSelfCancableBP;
import iih.ei.sc.ws.bean.IsSelfCancableBean;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.i.IScAptCmdService;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.i.IScaptMDORService;
import iih.sc.sch.i.IScSchOutCmdService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class CancAptBP {

	private static final String String = null;

	/**
	 * 取消预约
	 * @param idApt
	 * @param patCode
	 * @param chlType
	 * @param oprCode
	 * @throws BizException
	 */
	public void exec(String idApt,String patCode,String chlType,String oprCode,String isValidChl) throws BizException
	{
		//校验数据
		this.validData(idApt, patCode, chlType, oprCode);

		StringBuilder sqlQry = new StringBuilder();
		sqlQry.append("select id_aptappl as id_apt_appl,id_scca,id_dep_mp,id_or,sd_aptmd,sd_sys_from from sc_apt_appl where fg_canc = 'N' and id_scapt =? ");
		SqlParam param = new SqlParam();
		param.addParam(idApt);
		List<MtAppDTO> apps = (List<MtAppDTO>) new DAFacade().execQuery(sqlQry.toString(),param,new BeanListHandler(MtAppDTO.class));
		if (ListUtil.isEmpty(apps)) {
			throw new BizException("未查询到申请单信息!");
		}
		//校验取消预约规则
		this.validCancRule4Chl(chlType, apps.get(0).getId_apt_appl());
		//查询预约记录 并校验预约数据
		ScAptDO aptDO = this.getScApt(idApt, patCode, chlType, isValidChl);

		//取消预约
		IScAptCmdService cmdService = ServiceFinder.find(IScAptCmdService.class);
		MtAppDTO appdto = new MtAppDTO();
		appdto.setId_apt(aptDO.getId_apt());
		appdto.setId_scca(aptDO.getId_scca());
		appdto.setId_dep_mp(apps.get(0).getId_dep_mp());
		this.assemlData(apps.get(0), appdto);
		cmdService.cancelMtApt(appdto);
	}

	/**
	 * 组装数据
	 * @param src
	 * @param appdto
	 */
	private void assemlData(MtAppDTO src,MtAppDTO appdto){
		appdto.setId_apt_appl(src.getId_apt_appl());
		appdto.setId_or(src.getId_or());
		appdto.setSd_aptmd(src.getSd_aptmd());
		appdto.setSd_sys_from(src.getSd_sys_from());
	}
	/**
	 * 查询预约记录
	 * @param idApt
	 * @return
	 * @throws BizException
	 */
	private ScAptDO getScApt(String idApt,String patCode,String chlType,String isValidChl) throws BizException
	{
		IScaptMDORService aptRService = ServiceFinder.find(IScaptMDORService.class);
 		ScAptDO aptDO = aptRService.findById(idApt);
		if(aptDO == null)
		{
			throw new BizException("取消预约失败:没找到对应预约记录!idApt=" + idApt + ",patCode=" + patCode + ",chlType=" + chlType);
		}
		if(FBoolean.TRUE.equals(aptDO.getFg_canc()))
		{
			throw new BizException("取消预约失败:预约记录已经取消,不能多次取消!");
		}
		if(IScDictCodeConst.SD_APTSTATUS_FINISH.equals(aptDO.getSd_status()))
		{
			throw new BizException("取消预约失败:预约已经完成,不能取消预约!");
		}
		//校验 患者编码
		StringBuilder sql1 = new StringBuilder();
		sql1.append("select code from pi_pat where id_pat = ?");
		SqlParam param1 = new SqlParam();
		param1.addParam(aptDO.getId_pat());
		String code_pat = (String) new DAFacade().execQuery(sql1.toString(),param1,new ColumnHandler());
		if(StringUtil.isEmpty(code_pat))
		{
			throw new BizException("取消预约失败:未找到患者信息!");
		}
		if(!code_pat.equals(patCode))
		{
			throw new BizException("取消预约失败:患者同预约记录不一致!");
		}
		if(StringUtil.isEmpty(isValidChl) && FBoolean.TRUE.toString().equals(isValidChl)){
		//校验渠道
		StringBuilder sql2 = new StringBuilder();
		SqlParam param2 = new SqlParam();
		sql2.append("select chl.sd_scchltp from sc_chl chl where chl.id_scchl = ?");
		param2.addParam(aptDO.getId_scchl());
		String code_chl = (String) new DAFacade().execQuery(sql2.toString(),param2,new ColumnHandler());
		if(StringUtil.isEmpty(code_chl))
		{
			throw new BizException("取消预约失败:未找到渠道信息!");
		}
		if(!code_chl.equals(chlType))
		{
			throw new BizException("取消预约失败:只能取消预约本渠道预约的申请，原预约渠道："+code_chl);
		}
		}
		return aptDO;
	}

	/**
	 * 校验数据
	 * @param idApt
	 * @param patCode
	 * @param chlType
	 * @param oprCode
	 * @throws BizException
	 */
	private void validData(String idApt,String patCode,String chlType,String oprCode) throws BizException
	{
		if(StringUtil.isEmpty(idApt))
		{
			throw new BizException("取消预约失败:预约记录id为空!");
		}
		if(StringUtil.isEmpty(patCode))
		{
			throw new BizException("取消预约失败:患者编码为空!");
		}
		if(StringUtil.isEmpty(chlType))
		{
			throw new BizException("取消预约失败:渠道类型为空!");
		}
		if(StringUtil.isEmpty(oprCode))
		{
			throw new BizException("取消预约失败:操作员为空!");
		}
	}
	/**
	 * 根据渠道校验取消预约规则
	 * @param chlType
	 * @param id_apt
	 * @throws BizException
	 */
	private void validCancRule4Chl(String chlType,String id_apt) throws BizException{
		IsSelfCancableBean[] isCancable = new IsSelfCancableBP().exec(id_apt,IScDictCodeConst.RULE_SC_MT_CANC_APT,chlType);
		FBoolean isCancApt = FBoolean.TRUE;
		if(!ArrayUtil.isEmpty(isCancable)){
			IsSelfCancableBean bean = isCancable[0];
			isCancApt = new FBoolean(bean.getIsCancable());
		}
		if(!isCancApt.booleanValue()){
			throw new BizException("渠道:"+chlType+",不满足取消预约规则");
		}
	}
}
