package iih.pe.papt.i;


import iih.pe.papt.dto.pepsnaptqrydto.d.PePsnAptQryDTO;
import iih.pe.papt.dto.pepsnaptsetdto.d.PePsnAptSetDTO;
import iih.pe.papt.pepsncatsel.d.PePsnapptCatDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.xapformula.vo.pub.formulaset.core.ParseException;

public interface IPaptMaintainService {

	/***
	 * 个人预约 用户信息查询
	 * @param pe
	 * @return
	 * @throws BizException
	 */
	
	public abstract void savePePsnApt(String id,String sd_sex, String fg_psn, String id_psn) throws BizException;
	
	/**
	 * 
	 * @param pe
	 * @param gender
	 * @param id_pepsnappt
	 * @param id_pecorpapptgrp
	 * @param fg_psn
	 * @param id_psn
	 * @return
	 * @throws BizException
	 */
	public abstract boolean savePsnAptSet(PePsnAptSetDTO[] pe, String gender, String id_pepsnappt, String id_pecorpapptgrp, String fg_psn, String id_psn) throws BizException;
	
	public abstract boolean updatePsnAptBinfo(String id_pepsnbinfo, String sex, String dt_birth) throws BizException, ParseException, java.text.ParseException;

	//记录体检预约项目变更日志
	public void saveCatlogApptModLog(PePsnapptCatDO[] oldDos) throws BizException;
	
	public void saveCatlogApptModLogOld(PePsnapptCatDO[] oldDos) throws BizException;

	/**
	 * 健康管理预约
	 */
	public void hmAppt(String id_psn, String id_peappt, String dt_appt, String id_doctor) throws BizException;
	/**
	 * 健康管理取消预约
	 */
	public void hmApptAbout(String idPehmapptStr,String idPepsnapptStr,String idPepsnbinfoStr) throws BizException;
}
