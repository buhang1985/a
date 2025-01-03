package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScSqlUtils;
import iih.sc.scbd.schedulesrv.d.ScheduleSrvDO;
import iih.sc.scbd.schedulesrv.i.ISchedulesrvMDORService;
import iih.sc.sch.dto.d.MtSchDetailDTO;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.s.ep.TickEP;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.ScSchEnDO;
import iih.sc.sch.scsch.d.ScSchOptsrvDO;
import iih.sc.sch.scsch.d.ScschAggDO;
import iih.sc.sch.sctick.d.EuAddTickMod;
import iih.sc.sch.sctick.d.EuUseState;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.i.ISctickRService;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.sch.scticks.i.IScticksRService;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.i.IScplanRService;
import java.util.ArrayList;
import java.util.List;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 医技排班管理详细信息
 *
 * @author yang.lu ,renying
 *
 */
public class GetSchMgrDetailBP {

	/**
	 * 医技排班管理详细信息
	 *
	 * @param mtSchMgrDTO
	 * @return
	 * @throws BizException
	 */
	public MtSchDetailDTO exec(MtSchDetailDTO mtSchMgrDTO) throws BizException {

		MtSchDetailDTO retDto = new MtSchDetailDTO();
		// 获取预约挂号数
		retDto = this.getAptUsed(mtSchMgrDTO.getId_sch());
		// 通过编号获取排班DO
		ScschAggDO scSchAggDO = new SchEP().getAggById(mtSchMgrDTO.getId_sch());
		if(scSchAggDO == null) throw new BizException("没有检索到对应的排班");
		ScSchDO scSchDO = (ScSchDO)scSchAggDO.getParentDO();
		ScSchOptsrvDO[] optsrvs = scSchAggDO.getScSchOptsrvDO();
		// 为DTO赋值
		if (scSchDO != null) {
			retDto.setFg_std_acpt(scSchDO.getFg_std_acpt());
			retDto.setId_sch(scSchDO.getId_sch());
			retDto.setQuan_total(scSchDO.getQuan_total());
			retDto.setQuan_total_appt(scSchDO.getQuan_total_appt());
			retDto.setQuan_total_chkin(scSchDO.getQuan_total()-scSchDO.getQuan_total_appt());
			retDto.setQuan_total_used(scSchDO.getQuan_total_used() + "");
			retDto.setScpolcn(scSchDO.getScpolcn());
			retDto.setSrvslot(scSchDO.getSrvslot());
			retDto.setSugest_exmint(scSchDO.getSugest_exmint());
			retDto.setSugest_num_mint(scSchDO.getSugest_num_mint());
			retDto.setSd_sctp(scSchDO.getSd_sctp());
			retDto.setSugest_num_tick(scSchDO.getSugest_num_tick());
			retDto.setSd_tickmd(scSchDO.getSd_tickmd());
			retDto.setNo_total(scSchDO.getAddquecn());
			retDto.setT_b_acpt(scSchDO.getT_b_acpt());
			retDto.setT_e_acpt(scSchDO.getT_e_acpt());
			retDto.setT_e_reg(scSchDO.getT_e_reg());
			retDto.setMax_num_add(scSchDO.getMax_num_add());
			retDto.setId_scca(scSchAggDO.getParentDO().getId_scca());
			//渠道
			retDto.setSch_chl_list(getChlDos(scSchAggDO.getScSchChlDO(), scSchDO));
			//就诊
			if(scSchDO.getFg_setentp() != null && scSchDO.getFg_setentp().booleanValue())
			{
				retDto.setSch_en_list(getEnDos(scSchAggDO.getScSchEnDO(), scSchDO));
			}
			retDto.setSch_tick_list(getTickDOs(mtSchMgrDTO.getId_sch()));
			retDto.setSch_ticks_list(getTicksDOs(mtSchMgrDTO.getId_sch()));
			retDto.setId_dayslot(scSchDO.getId_dayslot());
			retDto.setName_dayslot(scSchDO.getName_dayslot());
			retDto.setD_sch(scSchDO.getD_sch());
			// 自动释放号源 zhengcm 2017-10-23
			retDto.setFg_auto_release(scSchDO.getFg_auto_release());
			this.getScPlName(scSchDO, retDto);
			// 加号数量 add by zhengcm 2017-11-30
			retDto.setNo_add(this.getAddAmount(scSchDO.getId_sch()));
			// 就诊类型
			retDto.setFg_setentp(scSchDO.getFg_setentp());
			// 设置是否适用于自动预约
			retDto.setFg_auto_apt(scSchDO.getFg_auto_apt());
			this.setScSrvs(optsrvs, retDto);
			retDto.setFix_t_b_acpt(retDto.getT_b_acpt());
			retDto.setFix_t_e_acpt(retDto.getT_e_acpt());
			return retDto;
		}
		return null;
	}

    private void setScSrvs(ScSchOptsrvDO[] optsrvs,MtSchDetailDTO mtSchMgrDTO) throws BizException{
    	if(!ArrayUtil.isEmpty(optsrvs)){
    		List<String> scsrvList = new ArrayList<String>();
    		for (ScSchOptsrvDO optsrv : optsrvs) {
				scsrvList.add(optsrv.getId_scsrv());
			}
    		String cond = ScSqlUtils.getInSqlByIds(ScheduleSrvDO.ID_SCSRV, scsrvList);
    		ISchedulesrvMDORService ischedulesrvmdorservice = ServiceFinder.find(ISchedulesrvMDORService.class);
    		ScheduleSrvDO[] scsrvs = ischedulesrvmdorservice.find(cond, null, FBoolean.FALSE);
    		String id_scsrvs = "";
    		String name_scsrvs = "";
    		for (ScheduleSrvDO scheduleSrvDO : scsrvs) {
				id_scsrvs += scheduleSrvDO.getId_scsrv()+",";
				name_scsrvs += scheduleSrvDO.getName()+",";
			}
    		if (!ArrayUtil.isEmpty(scsrvs)) {
    			mtSchMgrDTO.setId_scsrvs(id_scsrvs.substring(0, id_scsrvs.length()-1));
    			mtSchMgrDTO.setName_scsrvs(name_scsrvs.substring(0, name_scsrvs.length()-1));
			}
    	}
    }
	/**
	 * 获取加号数量
	 *
	 * @author zhengcm
	 * @date 2017-11-30 19:04:02
	 *
	 * @param id_sch
	 * @return
	 * @throws BizException
	 */
	private int getAddAmount(String id_sch) throws BizException {
		int amount = 0;
		String cond = String.format("id_sch = '%s' and eu_add = %d", id_sch, EuAddTickMod.JH);
		ScSchTickDO[] tickDOs = new TickEP().getTickByCond(cond, null);
		if (!ArrayUtil.isEmpty(tickDOs)) {
			amount = tickDOs.length;
		}
		return amount;
	}

	private void getScPlName(ScSchDO scSchDO, MtSchDetailDTO mtSchMgrDTO) throws BizException {
		if (!StringUtil.isEmptyWithTrim(scSchDO.getId_scpl())) {
			IScplanRService rService = ServiceFinder.find(IScplanRService.class);
			ScPlanDO planDO = rService.findById(scSchDO.getId_scpl());
			if (planDO == null)
				return;
			mtSchMgrDTO.setName_scpl(planDO.getName());
			mtSchMgrDTO.setId_scpl(planDO.getId_scpl());
			mtSchMgrDTO.setId_dep(planDO.getId_dep());
		}
	}

	/**
	 * 获取渠道列表
	 *
	 * @param 排班管理编号
	 * @return
	 * @throws BizException
	 */
	private FArrayList getChlDos(ScSchChlDO[] chlDOs, ScSchDO scSchDO) throws BizException {
		FArrayList arrayList = new FArrayList();
		if (scSchDO == null || scSchDO.getScpolcn() == null) {
			return arrayList;
		}
		List<String> chlIdList = null;
		List<String> chlNameList = null;
		List<String> chlCodeList = null;
		List<String> chlIdEmpList = null;
		List<String> chlNameEmpList = null;
		List<String> chlIdDepList = null;
		List<String> chlNameDepList = null;
		List<String> chlIdEntpList = null;//就诊类型id
		List<String> chlCodeEntpList = null;//就诊类型编码
		List<String> chlNameEntpList = null;//就诊类型名称
		for (int i = 0; i < scSchDO.getScpolcn(); i++) {
			ScSchChlDO newChlDO = new ScSchChlDO();
			newChlDO.setId_sch(scSchDO.getId_sch());
			chlIdList = new ArrayList<String>();
			chlNameList = new ArrayList<String>();
			chlCodeList = new ArrayList<String>();
			chlIdEmpList = new ArrayList<String>();
			chlNameEmpList = new ArrayList<String>();
			chlIdDepList = new ArrayList<String>();
			chlNameDepList = new ArrayList<String>();
			chlIdEntpList = new ArrayList<String>();
			chlNameEntpList = new ArrayList<String>();
			chlCodeEntpList = new ArrayList<String>();
			// 给list设置值
			this.getScchlList(i, chlDOs, chlIdList, chlNameList, chlCodeList, chlIdEmpList, chlNameEmpList,
					chlIdDepList, chlNameDepList,chlIdEntpList,chlNameEntpList,chlCodeEntpList);
			if (!ListUtil.isEmpty(chlIdList)) {
				newChlDO.setId_scchl(BuildIdStr(chlIdList));
			}
			if (!ListUtil.isEmpty(chlNameList)) {
				newChlDO.setName_scchl(BuildIdStr(chlNameList));
			}
			if (!ListUtil.isEmpty(chlCodeList)) {
				newChlDO.setCode_scchl(BuildIdStr(chlCodeList));
			}
			if (!ListUtil.isEmpty(chlIdEmpList)) {
				newChlDO.setIds_emp_spec(BuildIdStr(chlIdEmpList));
			}
			if (!ListUtil.isEmpty(chlNameEmpList)) {
				newChlDO.setName_emp_spec(BuildIdStr(chlNameEmpList));
			}
			if (!ListUtil.isEmpty(chlIdDepList)) {
				newChlDO.setIds_dep_spec(BuildIdStr(chlIdDepList));
			}
			if (!ListUtil.isEmpty(chlNameDepList)) {
				newChlDO.setName_dep_spec(BuildIdStr(chlNameDepList));
			}
			if(!ListUtil.isEmpty(chlIdEntpList)) {
				newChlDO.setId_entp(BuildIdStr(chlIdEntpList));
			}
			if(!ListUtil.isEmpty(chlNameEntpList)) {
				newChlDO.setName_entp(BuildIdStr(chlNameEntpList));
			}
			if(!ListUtil.isEmpty(chlCodeEntpList)) {
				newChlDO.setCode_entp(BuildIdStr(chlCodeEntpList));
			}
			newChlDO.setScpolcn(i);
			Integer quanAppt = scSchDO.getAttrVal("Quan" + i + "_appt") == null ? 0 : ((Integer) scSchDO
					.getAttrVal("Quan" + i + "_appt")).intValue();
			Integer quanUsed = scSchDO.getAttrVal("Quan" + i + "_used") == null ? 0 : ((Integer) scSchDO
					.getAttrVal("Quan" + i + "_used")).intValue();
			if(IScDictCodeConst.SD_TICKMD_TIME.equals(scSchDO.getSd_tickmd())) {
				//时间片模式可用时长为号源池总时长减已用时长 20-08-05 yu.b
				newChlDO.setQuan_appt(quanAppt - quanUsed);
			} else {
				//号位、号段模式可用号数为号源池总号数
				newChlDO.setQuan_appt(quanAppt);
			}
			newChlDO.setQuan_used(quanUsed);
			arrayList.add(newChlDO);
		}

		return arrayList;
	}

	/**
	 * 获取渠道列表
	 *
	 * @param 排班管理编号
	 * @return
	 * @throws BizException
	 */
	private FArrayList getEnDos(ScSchEnDO[] enDOs, ScSchDO scSchDO) throws BizException {
		FArrayList arrayList = new FArrayList();
		if (scSchDO == null || scSchDO.getScpolcn() == null) {
			return arrayList;
		}
		for (int i = 0; i < enDOs.length; i++) {
			ScSchEnDO newEnDO = new ScSchEnDO();
			newEnDO.setId_sch(scSchDO.getId_sch());
			newEnDO.setId_entp(enDOs[i].getId_entp());
			newEnDO.setSd_entp(enDOs[i].getSd_entp());
			newEnDO.setScpolcn(enDOs[i].getScpolcn());
			arrayList.add(newEnDO);
		}
		return arrayList;
	}

	/**
	 * 设置值
	 *
	 * @param scpolcn
	 * @param chlDOs
	 * @param chlIdList
	 * @param chlNameList
	 * @param chlCodeList
	 * @param chlIdEmpList
	 * @param chlNameEmpList
	 * @param chlIdDepList
	 * @param chlNameDepList
	 */
	private void getScchlList(int scpolcn, ScSchChlDO[] chlDOs, List<String> chlIdList, List<String> chlNameList,
			List<String> chlCodeList, List<String> chlIdEmpList, List<String> chlNameEmpList,
			List<String> chlIdDepList, List<String> chlNameDepList,
			List<String> chlIdEntpList,List<String> chlNameEntpList,List<String> chlCodeEntpList) {
		if (ArrayUtil.isEmpty(chlDOs))
			return;
		for (ScSchChlDO chlDO : chlDOs) {
			if (chlDO.getScpolcn() == null || chlDO.getScpolcn() != scpolcn) {
				continue;
			}
			if (!StringUtil.isEmptyWithTrim(chlDO.getId_scchl()) && !chlIdList.contains(chlDO.getId_scchl())) {
				chlIdList.add(chlDO.getId_scchl());
			}
			if (!StringUtil.isEmptyWithTrim(chlDO.getName_scchl()) && !chlNameList.contains(chlDO.getName_scchl())) {
				chlNameList.add(chlDO.getName_scchl());
			}
			if (!StringUtil.isEmptyWithTrim(chlDO.getCode_scchl()) && !chlCodeList.contains(chlDO.getCode_scchl())) {
				chlCodeList.add(chlDO.getCode_scchl());
			}
			if (!StringUtil.isEmptyWithTrim(chlDO.getIds_emp_spec()) && !chlIdEmpList.contains(chlDO.getIds_emp_spec())) {
				chlIdEmpList.add(chlDO.getIds_emp_spec());
			}
			if (!StringUtil.isEmptyWithTrim(chlDO.getName_emp_spec())
					&& !chlNameEmpList.contains(chlDO.getName_emp_spec())) {
				chlNameEmpList.add(chlDO.getName_emp_spec());
			}
			if (!StringUtil.isEmptyWithTrim(chlDO.getIds_dep_spec()) && !chlIdDepList.contains(chlDO.getIds_dep_spec())) {
				chlIdDepList.add(chlDO.getIds_dep_spec());
			}
			if (!StringUtil.isEmptyWithTrim(chlDO.getName_dep_spec())
					&& !chlNameDepList.contains(chlDO.getName_dep_spec())) {
				chlNameDepList.add(chlDO.getName_dep_spec());
			}
			if (!StringUtil.isEmptyWithTrim(chlDO.getId_entp())
					&& !chlIdEntpList.contains(chlDO.getId_entp())) {
				chlIdEntpList.add(chlDO.getId_entp());
			}
			if (!StringUtil.isEmptyWithTrim(chlDO.getName_entp())
					&& !chlNameEntpList.contains(chlDO.getName_entp())) {
				chlNameEntpList.add(chlDO.getName_entp());
			}
			if (!StringUtil.isEmptyWithTrim(chlDO.getCode_entp())
					&& !chlCodeEntpList.contains(chlDO.getCode_entp())) {
				chlCodeEntpList.add(chlDO.getCode_entp());
			}
		}
		return;
	}

	/**
	 * 查找号位
	 *
	 * @param id_sch
	 * @return
	 * @throws BizException
	 */
	private FArrayList getTickDOs(String id_sch) throws BizException {
		FArrayList arrayList = new FArrayList();
		ScSchTickDO[] chlDOs = null;
		ISctickRService findService = ServiceFinder.find(ISctickRService.class);
		String whereStr = "a0.id_sch=?";
		SqlParamDTO param = new SqlParamDTO();
		param.addParam(id_sch);
		chlDOs = findService.find2(whereStr, param, "a0.queno,a0.T_b", FBoolean.FALSE);
		if (chlDOs != null && chlDOs.length != 0) {
			for (ScSchTickDO scSchChlDO : chlDOs) {
				arrayList.add(scSchChlDO);
			}
		}
		return arrayList;
	}

	/**
	 * 查找号段
	 *
	 * @param id_sch
	 * @return
	 * @throws BizException
	 */
	private FArrayList getTicksDOs(String id_sch) throws BizException {
		FArrayList arrayList = new FArrayList();
		ScSchTicksDO[] ticksDOs = null;
		IScticksRService findService = ServiceFinder.find(IScticksRService.class);
		ticksDOs = findService.find("id_sch ='" + id_sch + "'", "a0.T_b asc,queno_b asc ", FBoolean.FALSE);
		if (ticksDOs != null && ticksDOs.length != 0) {
			for (ScSchTicksDO ticks : ticksDOs) {
				arrayList.add(ticks);
			}
		}
		return arrayList;
	}

	/**
	 * 将idlist转换成字符串
	 *
	 * @param idList
	 * @return
	 */
	private String BuildIdStr(List<String> idList) {
		if (ListUtil.isEmpty(idList)) {
			return null;
		}
		StringBuilder builder = new StringBuilder();
		boolean first = true;
		for (String id : idList) {
			if (StringUtil.isEmpty(id)) {
				continue;
			}
			if (first) {
				first = false;
			} else {
				builder.append(",");
			}
			builder.append(String.format("%s", id));
		}

		return builder.toString();
	}

	/**
	 * 获取预约挂号数
	 * @param id_sch
	 * @param retDto
	 * @throws DAException
	 */
    private MtSchDetailDTO getAptUsed(String id_sch) throws DAException {
    	String sql = "select count(id_tick) as Quan_apt_used from sc_tick where id_sch = ? and fg_active = ? and eu_used=?";
    	SqlParam param = new SqlParam();
    	param.addParam(id_sch);
    	param.addParam(FBoolean.TRUE);
    	param.addParam(EuUseState.SY); // 已使用
		@SuppressWarnings("unchecked")
		List<MtSchDetailDTO> datas = (List<MtSchDetailDTO>) new DAFacade().execQuery(sql.toString(),
				param, new BeanListHandler(MtSchDetailDTO.class));
		return (MtSchDetailDTO) datas.toArray()[0];
	}
}
