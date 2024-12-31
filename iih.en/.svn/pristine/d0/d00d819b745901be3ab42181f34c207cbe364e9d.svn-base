package iih.en.pv.out.bp.cmd;

import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.bd.fc.entp.d.EnTypeDO;
import iih.bd.fc.entp.i.IEntpRService;
import iih.en.comm.ep.OpEP;
import iih.en.comm.ep.OpRegEP;
import iih.en.comm.ep.PiPatEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.ep.UdiDocEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.out.d.EnOpRegistBean;
import iih.en.pv.outpatient.d.EuPreObs;
import iih.en.pv.outpatient.d.EuRegTp;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.AdminAreaDO;
import xap.sys.bdfw.bbd.i.IAdminareaRService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 上传挂号信息
 * 
 * @author liubin
 *
 */
public class UploadOpRegistBP {
	/**
	 * 上传挂号信息
	 * 
	 * @param opRegistInfo
	 * @throws BizException
	 */
	public void exec(EnOpRegistBean opRegistInfo) throws BizException {
		//1.入参校验
		this.validate(opRegistInfo);
		//2.校验是否已经上传数据,幂等
		if(hasUpload(opRegistInfo.getId_ent()))
			return;
		//3.插入en_ent表记录
		PatiVisitDO pv = this.insertPv(opRegistInfo);
		//4.插入en_ent_op表数据
		this.insertOp(opRegistInfo);
		//5.插入en_ent_op_reg表数据
		this.insertOpReg(pv);
	}
	/**
	 * 入参校验
	 * 
	 * @param opRegistInfo
	 * @throws BizException
	 */
	private void validate(EnOpRegistBean opRegistInfo) throws BizException {
		if(opRegistInfo == null || EnValidator.isEmpty(opRegistInfo.getId_ent())){
			throw new BizException("上传就诊数据为空！");
		}
	}
	/**
	 * 校验是否已经上传数据
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private boolean hasUpload(String entId)throws BizException{
		String sql = "select count(1) from en_ent where id_ent = ? ";
		SqlParam param = new SqlParam();
		param.addParam(entId);
		Integer count =  (Integer) new DAFacade().execQuery(sql, param, new ColumnHandler());
		return count != null && count > 0;
	}
	/**
	 * 插入en_ent表记录
	 * 
	 * @param opRegistInfo
	 * @throws BizException
	 */
	private PatiVisitDO insertPv(EnOpRegistBean opRegistInfo) throws BizException {
		PatiVisitDO pv = new PatiVisitDO();
		pv.setStatus(DOStatus.NEW);
		pv.setId_ent(opRegistInfo.getId_ent());
		pv.setId_grp(opRegistInfo.getId_grp());
		pv.setId_org(opRegistInfo.getId_org());
		EnTypeDO entp = getEnTypeDO(opRegistInfo.getCode_entp());
		pv.setId_entp(entp.getId_entp());
		pv.setCode_entp(entp.getCode());
		pv.setCode(opRegistInfo.getCode());
		pv.setName_pat(opRegistInfo.getName_pat());
		pv.setId_pat(opRegistInfo.getId_pat());
		UdidocDO sex = getUdidocDo(IPiDictCodeTypeConst.SD_SEX_CODE, opRegistInfo.getSd_sex_pat());
		if(sex != null){
			pv.setId_sex_pat(sex.getId_udidoc());
			pv.setSd_sex_pat(sex.getCode());
		}
		UdidocDO mari = getUdidocDo(IPiDictCodeTypeConst.SD_MARRY, opRegistInfo.getSd_mari_pat());
		if(mari != null){
			pv.setId_mari_pat(mari.getId_udidoc());
			pv.setSd_mari_pat(mari.getCode());
		}
		if(opRegistInfo.getDt_birth_pat() != null)
			pv.setDt_birth_pat(new FDate(opRegistInfo.getDt_birth_pat()));
		pv.setTelno_pat(opRegistInfo.getTelno_pat());
		AdminAreaDO area = getAdminAreaDO(opRegistInfo.getSd_admdiv_addr());
		if(area != null){
			pv.setId_admdiv_addr(area.getId_adminarea());
			pv.setSd_admdiv_addr(area.getCode());
		}
		pv.setAddr_pat(opRegistInfo.getAddr_pat());
		pv.setDt_entry(new FDateTime(opRegistInfo.getDt_entry()));
		pv.setFg_acptvalid(FBoolean.TRUE);
		pv.setDt_acpt(EnAppUtils.getServerDateTime());
		pv.setId_dep_phy(opRegistInfo.getId_dep_phy());
		pv.setId_emp_phy(opRegistInfo.getId_emp_phy());
		pv.setId_emp_entry(opRegistInfo.getId_emp_oper());
		pv.setId_patca(opRegistInfo.getId_patca());
		pv.setId_pripat(opRegistInfo.getId_pripat());
		PiPatCaDO patCaDO = new PiPatEP().getPatCaById(opRegistInfo.getId_patca());
		if(patCaDO != null)
			pv.setId_patcret(patCaDO.getId_patcrettp());
		pv.setFg_st(FBoolean.valueOf(opRegistInfo.getFg_st()));
		pv.setFg_ip(FBoolean.FALSE);
		pv.setFg_flup(FBoolean.FALSE);
		pv.setFg_canc(FBoolean.valueOf(opRegistInfo.getFg_canc()));
		pv.setId_emp_canc(opRegistInfo.getFg_canc());
		if(FBoolean.TRUE.equals(pv.getFg_canc()))
			pv.setDt_canc(new FDateTime(opRegistInfo.getFg_canc()));
		pv.setFg_data_transf(FBoolean.FALSE);
		pv.setDt_end(EnAppUtils.getServerDateTime());
		pv.setDt_insert(new FDateTime(opRegistInfo.getDt_insert()));
		PvEP ep = new PvEP();
		ep.savePv(pv);
		return pv;
	}
	/**
	 * 
	 * 
	 * @param opRegistInfo
	 * @throws BizException
	 */
	private void insertOp(EnOpRegistBean opRegistInfo) throws BizException {
		OpEP ep = new OpEP();
		OutpatientDO op = new OutpatientDO();
		op.setStatus(DOStatus.NEW);
		op.setId_ent(opRegistInfo.getId_ent());
		UdidocDO srvtp = getUdidocDo(IBdSrvDictCodeTypeConst.SD_SRVTP, opRegistInfo.getSd_srvtp());
		if(srvtp != null){
			op.setId_svrtp(srvtp.getId_udidoc());
			op.setSd_svrtp(srvtp.getCode());
		}
		op.setId_emp_operator(opRegistInfo.getId_emp_oper());
		op.setDt_valid_b(new FDateTime(opRegistInfo.getDt_valid_b()));
		op.setDt_valid_e(new FDateTime(opRegistInfo.getDt_valid_e()));
		op.setId_sch(opRegistInfo.getId_sch());
		op.setId_dateslot(opRegistInfo.getId_dayslot());
		op.setId_scres(opRegistInfo.getId_scres());
		op.setId_scsrv(opRegistInfo.getId_scsrv());
		op.setId_dep_reg(opRegistInfo.getId_dep_reg());
		op.setId_emp_reg(opRegistInfo.getId_emp_reg());
		op.setFg_first(FBoolean.TRUE);
		op.setFg_cg(FBoolean.valueOf(opRegistInfo.getFg_cg()));
		op.setId_cg(opRegistInfo.getId_cg());
		op.setSd_status(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH);
		op.setCode_amr_oep(opRegistInfo.getCode_amr_oep());
		op.setFg_needrtn(FBoolean.FALSE);
		op.setTicketno(0);
		op.setTimes_op(ep.getMaxTimesOp(opRegistInfo.getId_pat()));
		op.setFg_rescue(FBoolean.FALSE);
		op.setTimes_rescue(0);
		op.setSucc_rescue(0);
		op.setEu_preobs(EuPreObs.NONEEDPREOBS);
		op.setEu_regtp(EuRegTp.EMGSYSTEM);//应急系统
		ep.save(op);
	}
	/**
	 * 插入en_ent_op_reg表数据
	 * 
	 * @param pv
	 * @throws BizException
	 */
	private void insertOpReg(PatiVisitDO pv)throws BizException{
		new OpRegEP().updateOpReg(pv, null);
	}
	
	/**
	 * 获取就诊类型
	 * 
	 * @param codeEntp
	 * @return
	 * @throws BizException
	 */
	private EnTypeDO getEnTypeDO(String codeEntp) throws BizException {
		if(EnValidator.isEmpty(codeEntp))
			throw new BizException("就诊类型不能为空！");
		IEntpRService serv = ServiceFinder.find(IEntpRService.class);
		EnTypeDO[] entps = serv.findByAttrValString(EnTypeDO.CODE, codeEntp);
		if(EnValidator.isEmpty(entps))
			throw new BizException(String.format("获取就诊类型[%s]失败!", codeEntp));
		return entps[0];
	}
	/**
	 * 获取自定义档案
	 * 
	 * @param type
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private UdidocDO getUdidocDo(String type, String code) throws BizException{
		if(EnValidator.isEmpty(code))
			return null;
		UdiDocEP ep = new UdiDocEP();
		return ep.getUdidocByCodeAndValue(type, code);
	}
	/**
	 * 获取现住址区县
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private AdminAreaDO getAdminAreaDO(String code) throws BizException{
		if(EnValidator.isEmpty(code))
			return null;
		IAdminareaRService serv = ServiceFinder.find(IAdminareaRService.class);
		AdminAreaDO[] areaDOs = serv.findByAttrValString(AdminAreaDO.CODE, code);
		return EnValidator.isEmpty(areaDOs) ? null : areaDOs[0];
	}
}
